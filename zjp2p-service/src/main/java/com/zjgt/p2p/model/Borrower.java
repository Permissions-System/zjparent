package com.zjgt.p2p.model;

import java.util.Date;

public class Borrower
{
  private Integer id;
  private String borrowercode;
  private String fullname;
  private String borrowername;
  private String corpdesc;
  private String corplogo;
  private String uporg;
  private Integer level;
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
  private String identno;
  private Integer borrowtype;
  private String adminuserid;

  public Integer getId()
  {
    return this.id;
  }

  public void setId(Integer id)
  {
    this.id = id;
  }

  public String getBorrowercode()
  {
    return this.borrowercode;
  }

  public void setBorrowercode(String borrowercode)
  {
    this.borrowercode = ((borrowercode == null) ? null : borrowercode.trim());
  }

  public String getFullname()
  {
    return this.fullname;
  }

  public void setFullname(String fullname)
  {
    this.fullname = ((fullname == null) ? null : fullname.trim());
  }

  public String getBorrowername()
  {
    return this.borrowername;
  }

  public void setBorrowername(String borrowername)
  {
    this.borrowername = ((borrowername == null) ? null : borrowername.trim());
  }

  public String getCorpdesc()
  {
    return this.corpdesc;
  }

  public void setCorpdesc(String corpdesc)
  {
    this.corpdesc = ((corpdesc == null) ? null : corpdesc.trim());
  }

  public String getCorplogo()
  {
    return this.corplogo;
  }

  public void setCorplogo(String corplogo)
  {
    this.corplogo = ((corplogo == null) ? null : corplogo.trim());
  }

  public String getUporg()
  {
    return this.uporg;
  }

  public void setUporg(String uporg)
  {
    this.uporg = ((uporg == null) ? null : uporg.trim());
  }

  public Integer getLevel()
  {
    return this.level;
  }

  public void setLevel(Integer level)
  {
    this.level = level;
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

  public String getIdentno()
  {
    return this.identno;
  }

  public void setIdentno(String identno)
  {
    this.identno = ((identno == null) ? null : identno.trim());
  }

  public Integer getBorrowtype()
  {
    return this.borrowtype;
  }

  public void setBorrowtype(Integer borrowtype)
  {
    this.borrowtype = borrowtype;
  }

  public String getAdminuserid()
  {
    return this.adminuserid;
  }

  public void setAdminuserid(String adminuserid)
  {
    this.adminuserid = ((adminuserid == null) ? null : adminuserid.trim());
  }
}