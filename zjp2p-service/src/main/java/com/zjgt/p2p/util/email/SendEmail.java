package com.zjgt.p2p.util.email;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.MultiPartEmail;

public class SendEmail
{
  public static boolean sendHtmlEmail(EmailBean bean)
    throws Exception
  {
    System.setProperty("mail.smtp.ssl.enable", "");
    System.setProperty("mail.smtp.ssl.socketFactory.class", "");
    System.setProperty("mail.smtp.ssl.socketFactory.fallback", "");
    HtmlEmail email = new HtmlEmail();

    email.setCharset("UTF-8");
    email.setHostName(bean.getHostName());
    email.setSmtpPort(bean.getSmtpPort().intValue());
    email.setAuthenticator(new DefaultAuthenticator(bean.getAuthName(), bean.getAuthPwd()));
    if (bean.getIsSSL().booleanValue())
    {
      email.setSslSmtpPort(bean.getSmtpSSLProt());
      System.setProperty("mail.smtp.ssl.enable", "true");
      System.setProperty("mail.smtp.ssl.socketFactory.class", "com.lume.DummySSLSocketFactory");
      System.setProperty("mail.smtp.ssl.socketFactory.fallback", "false");
    }
    email.setFrom(bean.getSendFrom());
    email.addTo(bean.getAddTo());
    email.setSubject(bean.getTitle());
    email.setHtmlMsg(bean.getContent());
    email.send();
    return true;
  }

  public static boolean sendEmail(EmailBean bean)
    throws Exception
  {
    System.setProperty("mail.smtp.ssl.enable", "");
    System.setProperty("mail.smtp.ssl.socketFactory.class", "");
    System.setProperty("mail.smtp.ssl.socketFactory.fallback", "");
    Email email = new MultiPartEmail();
    email.setHostName(bean.getHostName());
    email.setSmtpPort(bean.getSmtpPort().intValue());
    email.setAuthenticator(new DefaultAuthenticator(bean.getAuthName(), bean.getAuthPwd()));
    if (bean.getIsSSL().booleanValue())
    {
      email.setSslSmtpPort(bean.getSmtpSSLProt());
      System.setProperty("mail.smtp.ssl.enable", "true");
      System.setProperty("mail.smtp.ssl.socketFactory.class", "com.lume.DummySSLSocketFactory");
      System.setProperty("mail.smtp.ssl.socketFactory.fallback", "false");
    }
    email.setFrom(bean.getSendFrom());
    email.setSubject(bean.getTitle());
    email.setMsg(bean.getContent());
    email.addTo(bean.getAddTo());

    email.setDebug(true);

    email.send();

    return true;
  }
}