package com.zjgt.p2p.model;

import java.util.Date;

public class Memberbankinfo
{
  private Long id;
  private Long memberid;
  private String bankname;
  private String bankprince;
  private String bankcity;
  private String bankinfo;
  private String bankcardno;
  private Date bankverifydate;
  private Boolean ifdefault;

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

  public Date getBankverifydate()
  {
    return this.bankverifydate;
  }

  public void setBankverifydate(Date bankverifydate)
  {
    this.bankverifydate = bankverifydate;
  }

  public Boolean getIfdefault()
  {
    return this.ifdefault;
  }

  public void setIfdefault(Boolean ifdefault)
  {
    this.ifdefault = ifdefault;
  }
}