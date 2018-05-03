package com.zjgt.p2p.model;

import java.util.Date;

public class VouchOrg
{
  private Integer id;
  private String instcode;
  private String instfullname;
  private String instname;
  private String instdesc;
  private String instlogo;
  private String uporg;
  private Integer instlevel;
  private String address;
  private String contactperson;
  private String mobile;
  private String phone;
  private String fax;
  private String email;
  private String agreement1;
  private String agreementimg;
  private Date validdate;
  private Integer orgstate;
  private Integer adminuserid;

  public Integer getId()
  {
    return this.id;
  }

  public void setId(Integer id)
  {
    this.id = id;
  }

  public String getInstcode()
  {
    return this.instcode;
  }

  public void setInstcode(String instcode)
  {
    this.instcode = ((instcode == null) ? null : instcode.trim());
  }

  public String getInstfullname()
  {
    return this.instfullname;
  }

  public void setInstfullname(String instfullname)
  {
    this.instfullname = ((instfullname == null) ? null : instfullname.trim());
  }

  public String getInstname()
  {
    return this.instname;
  }

  public void setInstname(String instname)
  {
    this.instname = ((instname == null) ? null : instname.trim());
  }

  public String getInstdesc()
  {
    return this.instdesc;
  }

  public void setInstdesc(String instdesc)
  {
    this.instdesc = ((instdesc == null) ? null : instdesc.trim());
  }

  public String getInstlogo()
  {
    return this.instlogo;
  }

  public void setInstlogo(String instlogo)
  {
    this.instlogo = ((instlogo == null) ? null : instlogo.trim());
  }

  public String getUporg()
  {
    return this.uporg;
  }

  public void setUporg(String uporg)
  {
    this.uporg = ((uporg == null) ? null : uporg.trim());
  }

  public Integer getInstlevel()
  {
    return this.instlevel;
  }

  public void setInstlevel(Integer instlevel)
  {
    this.instlevel = instlevel;
  }

  public String getAddress()
  {
    return this.address;
  }

  public void setAddress(String address)
  {
    this.address = ((address == null) ? null : address.trim());
  }

  public String getContactperson()
  {
    return this.contactperson;
  }

  public void setContactperson(String contactperson)
  {
    this.contactperson = ((contactperson == null) ? null : contactperson.trim());
  }

  public String getMobile()
  {
    return this.mobile;
  }

  public void setMobile(String mobile)
  {
    this.mobile = ((mobile == null) ? null : mobile.trim());
  }

  public String getPhone()
  {
    return this.phone;
  }

  public void setPhone(String phone)
  {
    this.phone = ((phone == null) ? null : phone.trim());
  }

  public String getFax()
  {
    return this.fax;
  }

  public void setFax(String fax)
  {
    this.fax = ((fax == null) ? null : fax.trim());
  }

  public String getEmail()
  {
    return this.email;
  }

  public void setEmail(String email)
  {
    this.email = ((email == null) ? null : email.trim());
  }

  public String getAgreement1()
  {
    return this.agreement1;
  }

  public void setAgreement1(String agreement1)
  {
    this.agreement1 = ((agreement1 == null) ? null : agreement1.trim());
  }

  public String getAgreementimg()
  {
    return this.agreementimg;
  }

  public void setAgreementimg(String agreementimg)
  {
    this.agreementimg = ((agreementimg == null) ? null : agreementimg.trim());
  }

  public Date getValiddate()
  {
    return this.validdate;
  }

  public void setValiddate(Date validdate)
  {
    this.validdate = validdate;
  }

  public Integer getOrgstate()
  {
    return this.orgstate;
  }

  public void setOrgstate(Integer orgstate)
  {
    this.orgstate = orgstate;
  }

  public Integer getAdminuserid()
  {
    return this.adminuserid;
  }

  public void setAdminuserid(Integer adminuserid)
  {
    this.adminuserid = adminuserid;
  }
}