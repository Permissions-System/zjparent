package com.zjgt.p2p.util.email;

public class EmailBean
{
  private String hostName;
  private String authName;
  private String authPwd;
  private Integer smtpPort;
  private String smtpSSLProt;
  private Boolean isSSL;
  private String sendFrom;
  private String addTo;
  private String content;
  private String title;

  public EmailBean()
  {
    this.isSSL = Boolean.FALSE;
  }

  public String getAuthName()
  {
    return this.authName;
  }

  public void setAuthName(String authName) {
    this.authName = authName;
  }

  public String getAuthPwd() {
    return this.authPwd;
  }

  public void setAuthPwd(String authPwd) {
    this.authPwd = authPwd;
  }

  public Integer getSmtpPort() {
    return this.smtpPort;
  }

  public void setSmtpPort(Integer smtpPort) {
    this.smtpPort = smtpPort;
  }

  public String getSmtpSSLProt() {
    return this.smtpSSLProt;
  }

  public void setSmtpSSLProt(String smtpSSLProt) {
    this.smtpSSLProt = smtpSSLProt;
  }

  public Boolean getIsSSL() {
    return this.isSSL;
  }

  public void setIsSSL(Boolean isSSL) {
    this.isSSL = isSSL;
  }

  public String getSendFrom() {
    return this.sendFrom;
  }

  public void setSendFrom(String sendFrom) {
    this.sendFrom = sendFrom;
  }

  public String getAddTo() {
    return this.addTo;
  }

  public void setAddTo(String addTo) {
    this.addTo = addTo;
  }

  public String getContent() {
    return this.content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getTitle() {
    return this.title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getHostName() {
    return this.hostName;
  }

  public void setHostName(String hostName) {
    this.hostName = hostName;
  }

  public static EmailBean getbean(String email, String context) {
    return getbean("来自百富网的邮件", email, context);
  }

  public static EmailBean getbean(String subject, String email, String context) {
    EmailBean bean = new EmailBean();
    bean.setHostName("smtp.exmail.qq.com");
    bean.setSmtpPort(Integer.valueOf(25));
    bean.setSmtpSSLProt("465");
    bean.setAuthName("service@baifu360.com");
    bean.setAuthPwd("biifoo12345");
    bean.setIsSSL(Boolean.valueOf(false));
    bean.setTitle(subject);
    bean.setContent(context);
    bean.setSendFrom("service@baifu360.com");
    bean.setAddTo(email);
    return bean;
  }
}