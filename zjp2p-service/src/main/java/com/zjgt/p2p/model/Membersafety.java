package com.zjgt.p2p.model;

import java.util.Date;

public class Membersafety
{
  private Long id;
  private Long memberid;
  private String realname;
  private String mobile;
  private Integer mobileifverified;
  private Date mobileifverifydate;
  private String idcard;
  private Integer idcardifverified;
  private Date idcardverifydate;
  private String email;
  private Integer emailifverified;
  private String emailverifyuuid;
  private Date emailverifydate;
  private Integer bankcardifverified;
  private String bankname;
  private String bankprince;
  private String bankcity;
  private String bankinfo;
  private String bankcardno;
  private String bankcode;
  private Date bankverifydate;
  private String transpasswd;
  private Integer transpasswdverified;
  private String remark;

  public Long getId()
  {
    return this.id;
  }

  public void setId(Long id)
  {
    this.id = id;
  }

  public Long getMemberid()
  {
    return this.memberid;
  }

  public void setMemberid(Long memberid)
  {
    this.memberid = memberid;
  }

  public String getRealname()
  {
    return this.realname;
  }

  public void setRealname(String realname)
  {
    this.realname = ((realname == null) ? null : realname.trim());
  }

  public String getMobile()
  {
    return this.mobile;
  }

  public void setMobile(String mobile)
  {
    this.mobile = ((mobile == null) ? null : mobile.trim());
  }

  public Integer getMobileifverified()
  {
    return this.mobileifverified;
  }

  public void setMobileifverified(Integer mobileifverified)
  {
    this.mobileifverified = mobileifverified;
  }

  public Date getMobileifverifydate()
  {
    return this.mobileifverifydate;
  }

  public void setMobileifverifydate(Date mobileifverifydate)
  {
    this.mobileifverifydate = mobileifverifydate;
  }

  public String getIdcard()
  {
    return this.idcard;
  }

  public void setIdcard(String idcard)
  {
    this.idcard = ((idcard == null) ? null : idcard.trim());
  }

  public Integer getIdcardifverified()
  {
    return this.idcardifverified;
  }

  public void setIdcardifverified(Integer idcardifverified)
  {
    this.idcardifverified = idcardifverified;
  }

  public Date getIdcardverifydate()
  {
    return this.idcardverifydate;
  }

  public void setIdcardverifydate(Date idcardverifydate)
  {
    this.idcardverifydate = idcardverifydate;
  }

  public String getEmail()
  {
    return this.email;
  }

  public void setEmail(String email)
  {
    this.email = ((email == null) ? null : email.trim());
  }

  public Integer getEmailifverified()
  {
    return this.emailifverified;
  }

  public void setEmailifverified(Integer emailifverified)
  {
    this.emailifverified = emailifverified;
  }

  public String getEmailverifyuuid()
  {
    return this.emailverifyuuid;
  }

  public void setEmailverifyuuid(String emailverifyuuid)
  {
    this.emailverifyuuid = ((emailverifyuuid == null) ? null : emailverifyuuid.trim());
  }

  public Date getEmailverifydate()
  {
    return this.emailverifydate;
  }

  public void setEmailverifydate(Date emailverifydate)
  {
    this.emailverifydate = emailverifydate;
  }

  public Integer getBankcardifverified()
  {
    return this.bankcardifverified;
  }

  public void setBankcardifverified(Integer bankcardifverified)
  {
    this.bankcardifverified = bankcardifverified;
  }

  public String getBankname()
  {
    return this.bankname;
  }

  public void setBankname(String bankname)
  {
    this.bankname = ((bankname == null) ? null : bankname.trim());
  }

  public String getBankprince()
  {
    return this.bankprince;
  }

  public void setBankprince(String bankprince)
  {
    this.bankprince = ((bankprince == null) ? null : bankprince.trim());
  }

  public String getBankcity()
  {
    return this.bankcity;
  }

  public void setBankcity(String bankcity)
  {
    this.bankcity = ((bankcity == null) ? null : bankcity.trim());
  }

  public String getBankinfo()
  {
    return this.bankinfo;
  }

  public void setBankinfo(String bankinfo)
  {
    this.bankinfo = ((bankinfo == null) ? null : bankinfo.trim());
  }

  public String getBankcardno()
  {
    return this.bankcardno;
  }

  public void setBankcardno(String bankcardno)
  {
    this.bankcardno = ((bankcardno == null) ? null : bankcardno.trim());
  }

  public String getBankcode()
  {
    return this.bankcode;
  }

  public void setBankcode(String bankcode)
  {
    this.bankcode = ((bankcode == null) ? null : bankcode.trim());
  }

  public Date getBankverifydate()
  {
    return this.bankverifydate;
  }

  public void setBankverifydate(Date bankverifydate)
  {
    this.bankverifydate = bankverifydate;
  }

  public String getTranspasswd()
  {
    return this.transpasswd;
  }

  public void setTranspasswd(String transpasswd)
  {
    this.transpasswd = ((transpasswd == null) ? null : transpasswd.trim());
  }

  public Integer getTranspasswdverified()
  {
    return this.transpasswdverified;
  }

  public void setTranspasswdverified(Integer transpasswdverified)
  {
    this.transpasswdverified = transpasswdverified;
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