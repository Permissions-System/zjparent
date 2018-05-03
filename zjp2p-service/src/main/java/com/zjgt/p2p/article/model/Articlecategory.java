package com.zjgt.p2p.article.model;

import java.util.Date;

public class Articlecategory
{
  private Long id;
  private Date createDate;
  private Date modifyDate;
  private Integer orders;
  private Integer grade;
  private String name;
  private String seoDescription;
  private String seoKeywords;
  private String seoTitle;
  private String treePath;
  private Long parent;

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

  public Integer getGrade()
  {
    return this.grade;
  }

  public void setGrade(Integer grade)
  {
    this.grade = grade;
  }

  public String getName()
  {
    return this.name;
  }

  public void setName(String name)
  {
    this.name = ((name == null) ? null : name.trim());
  }

  public String getSeoDescription()
  {
    return this.seoDescription;
  }

  public void setSeoDescription(String seoDescription)
  {
    this.seoDescription = ((seoDescription == null) ? null : seoDescription.trim());
  }

  public String getSeoKeywords()
  {
    return this.seoKeywords;
  }

  public void setSeoKeywords(String seoKeywords)
  {
    this.seoKeywords = ((seoKeywords == null) ? null : seoKeywords.trim());
  }

  public String getSeoTitle()
  {
    return this.seoTitle;
  }

  public void setSeoTitle(String seoTitle)
  {
    this.seoTitle = ((seoTitle == null) ? null : seoTitle.trim());
  }

  public String getTreePath()
  {
    return this.treePath;
  }

  public void setTreePath(String treePath)
  {
    this.treePath = ((treePath == null) ? null : treePath.trim());
  }

  public Long getParent()
  {
    return this.parent;
  }

  public void setParent(Long parent)
  {
    this.parent = parent;
  }
}