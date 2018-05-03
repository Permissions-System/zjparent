package com.zjgt.p2p.model;

import java.util.Date;

public class ChannelsettleInfo
{
  private Long id;
  private Integer bidtypeid;
  private Integer channelid;
  private Integer settleperiod;
  private Date settledate;
  private String remark;

  public Long getId()
  {
    return this.id;
  }

  public void setId(Long id)
  {
    this.id = id;
  }

  public Integer getBidtypeid()
  {
    return this.bidtypeid;
  }

  public void setBidtypeid(Integer bidtypeid)
  {
    this.bidtypeid = bidtypeid;
  }

  public Integer getChannelid()
  {
    return this.channelid;
  }

  public void setChannelid(Integer channelid)
  {
    this.channelid = channelid;
  }

  public Integer getSettleperiod()
  {
    return this.settleperiod;
  }

  public void setSettleperiod(Integer settleperiod)
  {
    this.settleperiod = settleperiod;
  }

  public Date getSettledate()
  {
    return this.settledate;
  }

  public void setSettledate(Date settledate)
  {
    this.settledate = settledate;
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