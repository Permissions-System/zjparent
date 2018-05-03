package com.zjgt.p2p.article.model;

import java.util.Date;

public class Article {
    /**
     * 字段名称:  .
     * 字段定义: article.id
     *
     * @ET
     */
    private Long id;

    /**
     * 字段名称:  .
     * 字段定义: article.create_date
     *
     * @ET
     */
    private Date createDate;

    /**
     * 字段名称:  .
     * 字段定义: article.modify_date
     *
     * @ET
     */
    private Date modifyDate;

    /**
     * 字段名称:  .
     * 字段定义: article.author
     *
     * @ET
     */
    private String author;

    /**
     * 字段名称:  .
     * 字段定义: article.hits
     *
     * @ET
     */
    private Long hits;

    /**
     * 字段名称:  .
     * 字段定义: article.is_publication
     *
     * @ET
     */
    private Boolean isPublication;

    /**
     * 字段名称:  .
     * 字段定义: article.is_top
     *
     * @ET
     */
    private Boolean isTop;

    /**
     * 字段名称:  .
     * 字段定义: article.seo_description
     *
     * @ET
     */
    private String seoDescription;

    /**
     * 字段名称:  .
     * 字段定义: article.seo_keywords
     *
     * @ET
     */
    private String seoKeywords;

    /**
     * 字段名称:  .
     * 字段定义: article.seo_title
     *
     * @ET
     */
    private String seoTitle;
    
    /**
     * 字段名称:  .
     * 字段定义: article.thumbnail
     *
     * @ET
     */
    private String thumbnail;

    /**
     * 字段名称:  .
     * 字段定义: article.title
     *
     * @ET
     */
    private String title;

    /**
     * 字段名称:  .
     * 字段定义: article.categoryid
     *
     * @ET
     */
    private Long categoryid;

    /**
     * 字段名称:  .
     * 字段定义: article.content
     *
     * @ET
     */
    private String content;

    /**
     * This method:getId
     * article.id
     *
     * @return the value of article.id
     *
     * @ET
     */
    public Long getId() {
        return id;
    }

    /**
     * This method:setId
     *  article.id
     *
     * @param id the value for article.id
     *
     * @ET
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method:getCreateDate
     * article.create_date
     *
     * @return the value of article.create_date
     *
     * @ET
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * This method:setCreateDate
     *  article.create_date
     *
     * @param createDate the value for article.create_date
     *
     * @ET
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * This method:getModifyDate
     * article.modify_date
     *
     * @return the value of article.modify_date
     *
     * @ET
     */
    public Date getModifyDate() {
        return modifyDate;
    }

    /**
     * This method:setModifyDate
     *  article.modify_date
     *
     * @param modifyDate the value for article.modify_date
     *
     * @ET
     */
    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    /**
     * This method:getAuthor
     * article.author
     *
     * @return the value of article.author
     *
     * @ET
     */
    public String getAuthor() {
        return author;
    }

    /**
     * This method:setAuthor
     *  article.author
     *
     * @param author the value for article.author
     *
     * @ET
     */
    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    /**
     * This method:getHits
     * article.hits
     *
     * @return the value of article.hits
     *
     * @ET
     */
    public Long getHits() {
        return hits;
    }

    /**
     * This method:setHits
     *  article.hits
     *
     * @param hits the value for article.hits
     *
     * @ET
     */
    public void setHits(Long hits) {
        this.hits = hits;
    }

    /**
     * This method:getIsPublication
     * article.is_publication
     *
     * @return the value of article.is_publication
     *
     * @ET
     */
    public Boolean getIsPublication() {
        return isPublication;
    }

    /**
     * This method:setIsPublication
     *  article.is_publication
     *
     * @param isPublication the value for article.is_publication
     *
     * @ET
     */
    public void setIsPublication(Boolean isPublication) {
        this.isPublication = isPublication;
    }

    /**
     * This method:getIsTop
     * article.is_top
     *
     * @return the value of article.is_top
     *
     * @ET
     */
    public Boolean getIsTop() {
        return isTop;
    }

    /**
     * This method:setIsTop
     *  article.is_top
     *
     * @param isTop the value for article.is_top
     *
     * @ET
     */
    public void setIsTop(Boolean isTop) {
        this.isTop = isTop;
    }

    /**
     * This method:getSeoDescription
     * article.seo_description
     *
     * @return the value of article.seo_description
     *
     * @ET
     */
    public String getSeoDescription() {
        return seoDescription;
    }

    /**
     * This method:setSeoDescription
     *  article.seo_description
     *
     * @param seoDescription the value for article.seo_description
     *
     * @ET
     */
    public void setSeoDescription(String seoDescription) {
        this.seoDescription = seoDescription == null ? null : seoDescription.trim();
    }

    /**
     * This method:getSeoKeywords
     * article.seo_keywords
     *
     * @return the value of article.seo_keywords
     *
     * @ET
     */
    public String getSeoKeywords() {
        return seoKeywords;
    }

    /**
     * This method:setSeoKeywords
     *  article.seo_keywords
     *
     * @param seoKeywords the value for article.seo_keywords
     *
     * @ET
     */
    public void setSeoKeywords(String seoKeywords) {
        this.seoKeywords = seoKeywords == null ? null : seoKeywords.trim();
    }

    /**
     * This method:getSeoTitle
     * article.seo_title
     *
     * @return the value of article.seo_title
     *
     * @ET
     */
    public String getSeoTitle() {
        return seoTitle;
    }

    /**
     * This method:setSeoTitle
     *  article.seo_title
     *
     * @param seoTitle the value for article.seo_title
     *
     * @ET
     */
    public void setSeoTitle(String seoTitle) {
        this.seoTitle = seoTitle == null ? null : seoTitle.trim();
    }

    
    
    public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	/**
     * This method:getTitle
     * article.title
     *
     * @return the value of article.title
     *
     * @ET
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method:setTitle
     *  article.title
     *
     * @param title the value for article.title
     *
     * @ET
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * This method:getCategoryid
     * article.categoryid
     *
     * @return the value of article.categoryid
     *
     * @ET
     */
    public Long getCategoryid() {
        return categoryid;
    }

    /**
     * This method:setCategoryid
     *  article.categoryid
     *
     * @param categoryid the value for article.categoryid
     *
     * @ET
     */
    public void setCategoryid(Long categoryid) {
        this.categoryid = categoryid;
    }

    /**
     * This method:getContent
     * article.content
     *
     * @return the value of article.content
     *
     * @ET
     */
    public String getContent() {
        return content;
    }

    /**
     * This method:setContent
     *  article.content
     *
     * @param content the value for article.content
     *
     * @ET
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}