package com.zjgt.p2p.base.service.impl;

import com.zjgt.p2p.base.dao.SerialDao;
import com.zjgt.p2p.base.domain.SerialTemplate;
import com.zjgt.p2p.base.service.ISerialService;
import com.zjgt.p2p.base.service.impl.serial.CachedSerialCounter;
import com.zjgt.p2p.base.service.impl.serial.DefaultSerialFormater;
import com.zjgt.p2p.base.service.impl.serial.ItemFormat;
import com.zjgt.p2p.base.service.impl.serial.SerialFormater;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springfk.pancloud.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

@Component
public class SerialService
  implements ISerialService
{
  protected String defaultSerialTemplate;
  private final Logger logger = LoggerFactory.getLogger(super.getClass());

  @Autowired
  private SerialDao serialDao;

  @Autowired
  private PlatformTransactionManager transactionManager;
  private SerialFormater serialFormater = new DefaultSerialFormater();

  private Map<String, CachedSerialCounter> serialCounterMap = new HashMap();

  private Map<String, SerialTemplate> templateMap = new HashMap();

  public String getDefaultSerialTemplate()
  {
    return this.defaultSerialTemplate;
  }

  public void setDefaultSerialTemplate(String defaultSerialTemplate) {
    this.defaultSerialTemplate = defaultSerialTemplate;
  }

  public Map<String, Object> getFormatedParams(Map<String, Object> params, Map<String, ItemFormat> formats)
  {
    Map formatedParams = new HashMap();
    for (Map.Entry entry : params.entrySet()) {
      String key = (String)entry.getKey();
      Object value = entry.getValue();
      ItemFormat format = (ItemFormat)formats.get(key);
      if (format != null)
        formatedParams.put(format.getKey(), this.serialFormater.format(value, format));
      else {
        formatedParams.put(key, value);
      }
    }
    return formatedParams;
  }

  public void setSerialFormater(SerialFormater serialFormater) {
    this.serialFormater = serialFormater;
  }

  public String getSerial(String templateCode, Map<String, Object> params)
    throws BusinessException
  {
    if (params == null) {
      params = new HashMap();
    }

    SerialTemplate template = null;

    synchronized (this.templateMap) {
      template = getSerialTemplate(templateCode);
    }
    if (template == null)
      throw new BusinessException("模板 " + templateCode + " 未定义");
    String sn;
    synchronized (template)
    {
      try {
        Map formats = this.serialFormater.getTemplateFormats(template.getTemplate());

        Map formatedParams = getFormatedParams(params, formats);
        sn = getSerialInfo(template, formatedParams);
      } catch (Exception e) {
        throw new BusinessException(e);
      }
    }

    return sn;
  }

  private String getSerialInfo(SerialTemplate template, Map<String, Object> formatedParams)
    throws Exception
  {
    Integer next = getNextCounter(template);
    formatedParams.put(SerialTemplate.SERIAL, String.valueOf(next));
    return this.serialFormater.format(formatedParams, template.getTemplate());
  }

  private Integer getNextCounter(SerialTemplate template)
    throws Exception
  {
    String templateCode = template.getTemplateCode();

    CachedSerialCounter counters = (CachedSerialCounter)this.serialCounterMap.get(templateCode);
    if (counters == null) {
      counters = new CachedSerialCounter(templateCode);
      this.serialCounterMap.put(templateCode, counters);
    }
    Integer counter = counters.popFirst();
    if (counter != null) {
      return counter;
    }

    DefaultTransactionDefinition def = new DefaultTransactionDefinition();
    def.setPropagationBehavior(3);
    def.setIsolationLevel(2);
    TransactionStatus ts = this.transactionManager.getTransaction(def);
    int currentCounter;
    int cachedCount;
    try
    {
      SerialTemplate serialCounter = getSerialTemplateForUpdate(templateCode);
      currentCounter = serialCounter.getCounter();
      cachedCount = serialCounter.getCachedCount();
      int newCounter = currentCounter + cachedCount;
      int counterSize = template.getCounterSize();
      int newCounterSize = String.valueOf(newCounter).length();
      if (counterSize < newCounterSize) {
        newCounter = Integer.parseInt(String.valueOf(newCounter).substring(1));
      }
      serialCounter.setCounter(newCounter);
      this.serialDao.updateSerialTemplate(serialCounter);
      this.transactionManager.commit(ts);
    } catch (Exception e) {
      this.logger.error(e.getMessage());
      this.transactionManager.rollback(ts);
      throw e;
    }

    for (int i = 0; i < cachedCount; ++i) {
      int next = currentCounter + 1;
      counters.add(next);
      currentCounter = next;
    }
    counter = counters.popFirst();
    return counter;
  }

  public SerialTemplate getSerialTemplate(String templateCode)
  {
    SerialTemplate template = (SerialTemplate)this.templateMap.get(templateCode);
    if (template == null) {
      template = getSerialTemplateFromDb(templateCode);
      if (template != null) {
        this.templateMap.put(templateCode, template);
      }
    }
    return template;
  }

  private SerialTemplate getSerialTemplateForUpdate(String templateCode)
  {
    SerialTemplate serialTemplate = this.serialDao.getSerialTemplateForUpdate(templateCode);
    return serialTemplate;
  }

  public SerialTemplate getSerialTemplateFromDb(String templateCode)
  {
    SerialTemplate serialTemplate = this.serialDao.getSerialTemplate(templateCode);
    return serialTemplate;
  }

  public void insertSerialTemplate(SerialTemplate template)
  {
    this.serialDao.insertSerialTemplate(template);
  }

  public List<SerialTemplate> getSerialTemplateList()
    throws BusinessException
  {
    return this.serialDao.getSerialTemplateList();
  }

  public void deleteSerialTemplate(String templateCode)
  {
    this.serialDao.deleteSerialTemplate(templateCode);
  }

  public void clearCache()
  {
    this.templateMap = new HashMap();
    this.serialCounterMap = new HashMap();
  }
}