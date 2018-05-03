package com.zjgt.p2p.article.model;

import java.util.Date;

public class Tag
{
  private Long id;
  private Date createDate;
  private Date modifyDate;
  private Integer orders;
  private String icon;
  private String memo;
  private String name;
  private Integer type;

  public Long getId()
  {
    return this.id;
  }

  public void setId(Long id)
  {
    this.id = id;
  }

  public Date getCreateDate()
  {
    return this.createDate;
  }

  public void setCreateDate(Date createDate)
  {
    this.createDate = createDate;
  }

  public Date getModifyDate()
  {
    return this.modifyDate;
  }

  public void setModifyDate(Date modifyDate)
  {
    this.modifyDate = modifyDate;
  }

  public Integer getOrders()
  {
    return this.orders;
  }

  public void setOrders(Integer orders)
  {
    this.orders = orders;
  }

  public String getIcon()
  {
    return this.icon;
  }

  public void setIcon(String icon)
  {
    this.icon = ((icon == null) ? null : icon.trim());
  }

  public String getMemo()
  {
    return this.memo;
  }

  public void setMemo(String memo)
  {
    this.memo = ((memo == null) ? null : memo.trim());
  }

  public String getName()
  {
    return this.name;
  }

  public void setName(String name)
  {
    this.name = ((name == null) ? null : name.trim());
  }

  public Integer getType()
  {
    return this.type;
  }

  public void setType(Integer type)
  {
    this.type = type;
  }
}