package com.zjgt.p2p.model;

import java.util.Date;

public class AdvchannelInfo
{
  private Integer id;
  private Long memberid;
  private String channelname;
  private String channelcode;
  private Integer feetype;
  private Integer profittype;
  private Date cooperiod;
  private String remark;

  public Integer getId()
  {
    return this.id;
  }

  public void setId(Integer id)
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

  public String getChannelname()
  {
    return this.channelname;
  }

  public void setChannelname(String channelname)
  {
    this.channelname = ((channelname == null) ? null : channelname.trim());
  }

  public String getChannelcode()
  {
    return this.channelcode;
  }

  public void setChannelcode(String channelcode)
  {
    this.channelcode = ((channelcode == null) ? null : channelcode.trim());
  }

  public Integer getFeetype()
  {
    return this.feetype;
  }

  public void setFeetype(Integer feetype)
  {
    this.feetype = feetype;
  }

  public Integer getProfittype()
  {
    return this.profittype;
  }

  public void setProfittype(Integer profittype)
  {
    this.profittype = profittype;
  }

  public Date getCooperiod()
  {
    return this.cooperiod;
  }

  public void setCooperiod(Date cooperiod)
  {
    this.cooperiod = cooperiod;
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