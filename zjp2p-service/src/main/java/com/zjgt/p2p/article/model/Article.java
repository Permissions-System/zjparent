package com.zjgt.p2p.article.model;

import java.util.Date;

public class Article
{
  private Long id;
  private Date createDate;
  private Date modifyDate;
  private String author;
  private Long hits;
  private Boolean isPublication;
  private Boolean isTop;
  private String seoDescription;
  private String seoKeywords;
  private String seoTitle;
  private String thumbnail;
  private String title;
  private Long categoryid;
  private String content;

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

  public String getAuthor()
  {
    return this.author;
  }

  public void setAuthor(String author)
  {
    this.author = ((author == null) ? null : author.trim());
  }

  public Long getHits()
  {
    return this.hits;
  }

  public void setHits(Long hits)
  {
    this.hits = hits;
  }

  public Boolean getIsPublication()
  {
    return this.isPublication;
  }

  public void setIsPublication(Boolean isPublication)
  {
    this.isPublication = isPublication;
  }

  public Boolean getIsTop()
  {
    return this.isTop;
  }

  public void setIsTop(Boolean isTop)
  {
    this.isTop = isTop;
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

  public String getThumbnail()
  {
    return this.thumbnail;
  }

  public void setThumbnail(String thumbnail) {
    this.thumbnail = thumbnail;
  }

  public String getTitle()
  {
    return this.title;
  }

  public void setTitle(String title)
  {
    this.title = ((title == null) ? null : title.trim());
  }

  public Long getCategoryid()
  {
    return this.categoryid;
  }

  public void setCategoryid(Long categoryid)
  {
    this.categoryid = categoryid;
  }

  public String getContent()
  {
    return this.content;
  }

  public void setContent(String content)
  {
    this.content = ((content == null) ? null : content.trim());
  }
}