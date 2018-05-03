package com.zjgt.p2p.model;

import java.math.BigDecimal;
import java.util.Date;

public class Bonus
{
  private Integer id;
  private String bonusno;
  private Integer bonustype;
  private Integer source;
  private BigDecimal account;
  private BigDecimal blance;
  private Date begindate;
  private Date enddate;
  private Integer status;
  private Integer bonusrange;
  private String subject;
  private String bonusdetailtype;
  private String relativeno;
  private Long memberid;

  public Integer getId()
  {
    return this.id;
  }

  public void setId(Integer id)
  {
    this.id = id;
  }

  public String getBonusno()
  {
    return this.bonusno;
  }

  public void setBonusno(String bonusno)
  {
    this.bonusno = ((bonusno == null) ? null : bonusno.trim());
  }

  public Integer getBonustype()
  {
    return this.bonustype;
  }

  public void setBonustype(Integer bonustype)
  {
    this.bonustype = bonustype;
  }

  public Integer getSource()
  {
    return this.source;
  }

  public void setSource(Integer source)
  {
    this.source = source;
  }

  public BigDecimal getAccount()
  {
    return this.account;
  }

  public void setAccount(BigDecimal account)
  {
    this.account = account;
  }

  public BigDecimal getBlance()
  {
    return this.blance;
  }

  public void setBlance(BigDecimal blance)
  {
    this.blance = blance;
  }

  public Date getBegindate()
  {
    return this.begindate;
  }

  public void setBegindate(Date begindate)
  {
    this.begindate = begindate;
  }

  public Date getEnddate()
  {
    return this.enddate;
  }

  public void setEnddate(Date enddate)
  {
    this.enddate = enddate;
  }

  public Integer getStatus()
  {
    return this.status;
  }

  public void setStatus(Integer status)
  {
    this.status = status;
  }

  public Integer getBonusrange()
  {
    return this.bonusrange;
  }

  public void setBonusrange(Integer bonusrange)
  {
    this.bonusrange = bonusrange;
  }

  public String getSubject()
  {
    return this.subject;
  }

  public void setSubject(String subject)
  {
    this.subject = ((subject == null) ? null : subject.trim());
  }

  public String getBonusdetailtype()
  {
    return this.bonusdetailtype;
  }

  public void setBonusdetailtype(String bonusdetailtype)
  {
    this.bonusdetailtype = ((bonusdetailtype == null) ? null : bonusdetailtype.trim());
  }

  public String getRelativeno()
  {
    return this.relativeno;
  }

  public void setRelativeno(String relativeno)
  {
    this.relativeno = ((relativeno == null) ? null : relativeno.trim());
  }

  public Long getMemberid()
  {
    return this.memberid;
  }

  public void setMemberid(Long memberid)
  {
    this.memberid = memberid;
  }
}