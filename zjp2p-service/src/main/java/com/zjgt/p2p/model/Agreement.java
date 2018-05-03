package com.zjgt.p2p.model;

public class Agreement
{
  private Integer id;
  private String agreementno;
  private String agreementname;
  private String subject;
  private String fileurl;
  private String remark;

  public Integer getId()
  {
    return this.id;
  }

  public void setId(Integer id)
  {
    this.id = id;
  }

  public String getAgreementno()
  {
    return this.agreementno;
  }

  public void setAgreementno(String agreementno)
  {
    this.agreementno = ((agreementno == null) ? null : agreementno.trim());
  }

  public String getAgreementname()
  {
    return this.agreementname;
  }

  public void setAgreementname(String agreementname)
  {
    this.agreementname = ((agreementname == null) ? null : agreementname.trim());
  }

  public String getSubject()
  {
    return this.subject;
  }

  public void setSubject(String subject)
  {
    this.subject = ((subject == null) ? null : subject.trim());
  }

  public String getFileurl()
  {
    return this.fileurl;
  }

  public void setFileurl(String fileurl)
  {
    this.fileurl = ((fileurl == null) ? null : fileurl.trim());
  }

  public String getRemark()
  {
    return this.remark;
  }

  public void setRemark(String remark)
  {
    this.remark = ((remark == null) ? null : remark.trim());
  }
}