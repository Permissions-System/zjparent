package com.zjgt.p2p.service.impl;

import com.zjgt.p2p.service.ISmsService;
import com.zjgt.util.PropertiesUtils;
import com.zjgt.util.SmsUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

@Service
public class SmsServiceImpl
  implements ISmsService, InitializingBean
{
  Logger logger;

  public SmsServiceImpl()
  {
    this.logger = LoggerFactory.getLogger(SmsServiceImpl.class);
  }

  public void afterPropertiesSet()
    throws Exception
  {
  }

  public void send(String phone, String content)
    throws Exception
  {
    SmsUtil smsutil = new SmsUtil();
    String mobilepass = PropertiesUtils.getProperties("mobilepass");
    if ("1".equals(mobilepass)) {
      smsutil.sendbyweixin(phone, content);
    }
    if ("2".equals(mobilepass))
      smsutil.sendbymandao(phone, content);
  }

  public void sendMessageByTemplet(String phone, String content)
    throws Exception
  {
    SmsUtil smsutil = new SmsUtil();
    String mobilepass = PropertiesUtils.getProperties("mobilepass");
    if ("1".equals(mobilepass)) {
      smsutil.sendbyweixin2(phone, content);
    }
    if (mobilepass.equals("2"))
      smsutil.sendbymandao2(phone, content);
  }
}