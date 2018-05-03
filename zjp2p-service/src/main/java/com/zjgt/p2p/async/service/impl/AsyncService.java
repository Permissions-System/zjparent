package com.zjgt.p2p.async.service.impl;

import com.zjgt.p2p.async.domain.AsyncTask;
import com.zjgt.p2p.async.service.IAsyncService;
import com.zjgt.p2p.async.util.AsyncReflectUtil;
import com.zjgt.p2p.base.service.IErrorLogsService;
import java.io.Serializable;
import java.lang.reflect.Method;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springfk.pancloud.exception.BusinessException;
import org.springfk.pancloud.messageframework.IMessageHandler;
import org.springfk.pancloud.messageframework.IMessageSender;
import org.springfk.pancloud.messageframework.MessageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AsyncService
  implements IAsyncService, IMessageHandler
{
  private static Logger logger = LoggerFactory.getLogger(AsyncService.class);

  @Autowired(required=false)
  private IMessageSender asyncMessageSender;

  @Autowired
  private IErrorLogsService errLogService;

  public void addAsyncTask(Object serviceObject, String method, Class<?>[] paramTypes, Object[] params)
    throws BusinessException
  {
    addAsyncTask(serviceObject, method, paramTypes, params, null, null, 4);
  }

  public void addAsyncTask(Object serviceObject, String method, Class<?>[] paramTypes, Object[] params, int priorityLevel)
    throws BusinessException
  {
    addAsyncTask(serviceObject, method, paramTypes, params, null, null, priorityLevel);
  }

  public void addAsyncTask(Object serviceObject, String method, Class<?>[] paramTypes, Object[] params, Object callbackObject, String callbackMethod)
  {
    addAsyncTask(serviceObject, method, paramTypes, params, callbackObject, callbackMethod, 4);
  }

  public void addAsyncTask(Object serviceObject, String method, Class<?>[] paramTypes, Object[] params, Object callbackObject, String callbackMethod, int priorityLevel)
  {
    long startTime = System.currentTimeMillis();
    try {
      logger.info("add async task start");

      if (!(AsyncReflectUtil.checkTargetMethod(serviceObject, method, paramTypes))) {
        throw new BusinessException("无法识别的异常任务处理方法");
      }

      AsyncTask asyncTask = new AsyncTask();
      asyncTask.setServiceObject(AsyncReflectUtil.covertToMsgInfo(serviceObject));
      asyncTask.setMethod(method);
      asyncTask.setParamTypes(paramTypes);
      asyncTask.setParams(params);
      asyncTask.setCallbackObject((callbackObject == null) ? null : AsyncReflectUtil.covertToMsgInfo(callbackObject));

      asyncTask.setCallbackMethod(callbackMethod);

      MessageVO message = new MessageVO();
      message.setPriority(priorityLevel);
      message.setMessage(asyncTask);
      this.asyncMessageSender.sendMessage(message);
    }
    catch (BusinessException be) {
    }
    catch (Exception e) {
    }
    finally {
      long endTime;
      long killTime;
      endTime = System.currentTimeMillis();
      killTime = endTime - startTime;
      logger.info("add async task end \ttotal deal time: " + killTime + " ms.");
    }
  }

  public void addAsyncTask(Object serviceObject, String method, Object[] params)
    throws BusinessException
  {
    addAsyncTask(serviceObject, method, params, 4);
  }

  public void addAsyncTask(Object serviceObject, String method, Object[] params, int priorityLevel)
    throws BusinessException
  {
    addAsyncTask(serviceObject, method, params, null, null, 4);
  }

  public void addAsyncTask(Object serviceObject, String method, Object[] params, Object callbackObject, String callbackMethod)
  {
    addAsyncTask(serviceObject, method, params, callbackObject, callbackMethod, 4);
  }

  public void addAsyncTask(Object serviceObject, String method, Object[] params, Object callbackObject, String callbackMethod, int priorityLevel)
  {
    addAsyncTask(serviceObject, method, AsyncReflectUtil.getParamClassType(serviceObject, method, params), params, callbackObject, callbackMethod, priorityLevel); }

  public void handleMessage(Serializable arg0) {
    long startTime = System.currentTimeMillis();
    long endTime;
    long killTime;
    try {
      logger.info("deal async task start");

      AsyncTask task = (AsyncTask)arg0;

      Object serviceObject = AsyncReflectUtil.getTargetObject(task.getServiceObject());
      Method method = AsyncReflectUtil.getTargetMethod(serviceObject.getClass(), task.getMethod(), task.getParamTypes());

      Object result = null;
      try {
        result = method.invoke(serviceObject, task.getParams());
      } catch (NullPointerException ne) {
        logger.error("method:" + method);
        logger.error("serviceObject:" + serviceObject);
        logger.error("task:" + task);
        if (task != null) {
          logger.error("task.getAttachments():" + task.getAttachments());
          logger.error("task.getCallbackMethod():" + task.getCallbackMethod());
          logger.error("task.getMethod():" + task.getMethod());
          logger.error("task.getCallbackObject():" + task.getCallbackObject());
          logger.error("task.getClass():" + task.getClass());
          Object[] params = task.getParams();
          if (params != null) {
            for (Object param : params) {
              logger.error("param:" + param);
            }
          }

          Class[] paramTypes = task.getParamTypes();
          if (paramTypes != null) {
            for (Class paramType : paramTypes) {
              logger.error("paramType:" + paramType);
            }
          }
          logger.error("task.getServiceObject():" + task.getServiceObject());
        }
        throw ne;
      }

      logger.info("异步任务处理成功");
      if (task.hasCallback()) {
        logger.info("开始回调处理");

        Object callbackObject = AsyncReflectUtil.getTargetObject(task.getCallbackObject());
        Method callbackMethod = AsyncReflectUtil.getTargetMethod(callbackObject.getClass(), task.getCallbackMethod(), new Class[] { (result == null) ? null : result.getClass() });

        callbackMethod.invoke(callbackObject, new Object[] { (result == null) ? null : result });

        logger.info("回调处理成功");
      }
    } catch (Exception e) {
      try {
        this.errLogService.writeErrorLog(super.getClass(), "CPASYNC2", null, e);
      }
      catch (Exception e1)
      {
        e1.printStackTrace();
      }
    } finally {
      endTime = System.currentTimeMillis();
      killTime = endTime - startTime;
      logger.info("deal async task end \ttotal deal time: " + killTime + " ms.");
    }
  }
}