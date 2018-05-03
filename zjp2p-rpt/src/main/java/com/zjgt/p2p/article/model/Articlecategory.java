package com.zjgt.p2p.article.model;

import java.util.Date;
public class Articlecategory {
    /**
     * 字段名称: 分类编号 .
     * 字段定义: articlecategory.id
     *
     * @ET
     */
    private Long id;

    /**
     * 字段名称: 创建日期 .
     * 字段定义: articlecategory.create_date
     *
     * @ET
     */
    private Date createDate;

    /**
     * 字段名称: 修改日期 .
     * 字段定义: articlecategory.modify_date
     *
     * @ET
     */
    private Date modifyDate;

    /**
     * 字段名称: 序号 .
     * 字段定义: articlecategory.orders
     *
     * @ET
     */
    private Integer orders;

    /**
     * 字段名称: 级别分 .
     * 字段定义: articlecategory.grade
     *
     * @ET
     */
    private Integer grade;

    /**
     * 字段名称: 分类名称 .
     * 字段定义: articlecategory.name
     *
     * @ET
     */
    private String name;

    /**
     * 字段名称: seo描述 .
     * 字段定义: articlecategory.seo_description
     *
     * @ET
     */
    private String seoDescription;

    /**
     * 字段名称: seo关键词 .
     * 字段定义: articlecategory.seo_keywords
     *
     * @ET
     */
    private String seoKeywords;

    /**
     * 字段名称: seo标题 .
     * 字段定义: articlecategory.seo_title
     *
     * @ET
     */
    private String seoTitle;

    /**
     * 字段名称:  .
     * 字段定义: articlecategory.tree_path
     *
     * @ET
     */
    private String treePath;

    /**
     * 字段名称: 父类 .
     * 字段定义: articlecategory.parent
     *
     * @ET
     */
    private Long parent;

    /**
     * This method:getId
     * articlecategory.id
     *
     * @return the value of articlecategory.id
     *
     * @ET
     */
    public Long getId() {
        return id;
    }

    /**
     * This method:setId
     *  articlecategory.id
     *
     * @param id the value for articlecategory.id
     *
     * @ET
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method:getCreateDate
     * articlecategory.create_date
     *
     * @return the value of articlecategory.create_date
     *
     * @ET
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * This method:setCreateDate
     *  articlecategory.create_date
     *
     * @param createDate the value for articlecategory.create_date
     *
     * @ET
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * This method:getModifyDate
     * articlecategory.modify_date
     *
     * @return the value of articlecategory.modify_date
     *
     * @ET
     */
    public Date getModifyDate() {
        return modifyDate;
    }

    /**
     * This method:setModifyDate
     *  articlecategory.modify_date
     *
     * @param modifyDate the value for articlecategory.modify_date
     *
     * @ET
     */
    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    /**
     * This method:getOrders
     * articlecategory.orders
     *
     * @return the value of articlecategory.orders
     *
     * @ET
     */
    public Integer getOrders() {
        return orders;
    }

    /**
     * This method:setOrders
     *  articlecategory.orders
     *
     * @param orders the value for articlecategory.orders
     *
     * @ET
     */
    public void setOrders(Integer orders) {
        this.orders = orders;
    }

    /**
     * This method:getGrade
     * articlecategory.grade
     *
     * @return the value of articlecategory.grade
     *
     * @ET
     */
    public Integer getGrade() {
        return grade;
    }

    /**
     * This method:setGrade
     *  articlecategory.grade
     *
     * @param grade the value for articlecategory.grade
     *
     * @ET
     */
    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    /**
     * This method:getName
     * articlecategory.name
     *
     * @return the value of articlecategory.name
     *
     * @ET
     */
    public String getName() {
        return name;
    }

    /**
     * This method:setName
     *  articlecategory.name
     *
     * @param name the value for articlecategory.name
     *
     * @ET
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method:getSeoDescription
     * articlecategory.seo_description
     *
     * @return the value of articlecategory.seo_description
     *
     * @ET
     */
    public String getSeoDescription() {
        return seoDescription;
    }

    /**
     * This method:setSeoDescription
     *  articlecategory.seo_description
     *
     * @param seoDescription the value for articlecategory.seo_description
     *
     * @ET
     */
    public void setSeoDescription(String seoDescription) {
        this.seoDescription = seoDescription == null ? null : seoDescription.trim();
    }

    /**
     * This method:getSeoKeywords
     * articlecategory.seo_keywords
     *
     * @return the value of articlecategory.seo_keywords
     *
     * @ET
     */
    public String getSeoKeywords() {
        return seoKeywords;
    }

    /**
     * This method:setSeoKeywords
     *  articlecategory.seo_keywords
     *
     * @param seoKeywords the value for articlecategory.seo_keywords
     *
     * @ET
     */
    public void setSeoKeywords(String seoKeywords) {
        this.seoKeywords = seoKeywords == null ? null : seoKeywords.trim();
    }

    /**
     * This method:getSeoTitle
     * articlecategory.seo_title
     *
     * @return the value of articlecategory.seo_title
     *
     * @ET
     */
    public String getSeoTitle() {
        return seoTitle;
    }

    /**
     * This method:setSeoTitle
     *  articlecategory.seo_title
     *
     * @param seoTitle the value for articlecategory.seo_title
     *
     * @ET
     */
    public void setSeoTitle(String seoTitle) {
        this.seoTitle = seoTitle == null ? null : seoTitle.trim();
    }

    /**
     * This method:getTreePath
     * articlecategory.tree_path
     *
     * @return the value of articlecategory.tree_path
     *
     * @ET
     */
    public String getTreePath() {
        return treePath;
    }

    /**
     * This method:setTreePath
     *  articlecategory.tree_path
     *
     * @param treePath the value for articlecategory.tree_path
     *
     * @ET
     */
    public void setTreePath(String treePath) {
        this.treePath = treePath == null ? null : treePath.trim();
    }

    /**
     * This method:getParent
     * articlecategory.parent
     *
     * @return the value of articlecategory.parent
     *
     * @ET
     */
    public Long getParent() {
        return parent;
    }

    /**
     * This method:setParent
     *  articlecategory.parent
     *
     * @param parent the value for articlecategory.parent
     *
     * @ET
     */
    public void setParent(Long parent) {
        this.parent = parent;
    }
}