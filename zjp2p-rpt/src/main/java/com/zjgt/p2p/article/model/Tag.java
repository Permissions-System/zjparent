package com.zjgt.p2p.article.model;

import java.util.Date;

public class Tag {
    /**
     * 字段名称: 编号 .
     * 字段定义: tag.id
     *
     * @ET
     */
    private Long id;

    /**
     * 字段名称: 创建日期 .
     * 字段定义: tag.create_date
     *
     * @ET
     */
    private Date createDate;

    /**
     * 字段名称: 修改日期 .
     * 字段定义: tag.modify_date
     *
     * @ET
     */
    private Date modifyDate;

    /**
     * 字段名称: 序号 .
     * 字段定义: tag.orders
     *
     * @ET
     */
    private Integer orders;

    /**
     * 字段名称: icon地址 .
     * 字段定义: tag.icon
     *
     * @ET
     */
    private String icon;

    /**
     * 字段名称: 备注 .
     * 字段定义: tag.memo
     *
     * @ET
     */
    private String memo;

    /**
     * 字段名称: tag名称 .
     * 字段定义: tag.name
     *
     * @ET
     */
    private String name;

    /**
     * 字段名称: tag类型 .
     * 字段定义: tag.type
     *
     * @ET
     */
    private Integer type;

    /**
     * This method:getId
     * tag.id
     *
     * @return the value of tag.id
     *
     * @ET
     */
    public Long getId() {
        return id;
    }

    /**
     * This method:setId
     *  tag.id
     *
     * @param id the value for tag.id
     *
     * @ET
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method:getCreateDate
     * tag.create_date
     *
     * @return the value of tag.create_date
     *
     * @ET
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * This method:setCreateDate
     *  tag.create_date
     *
     * @param createDate the value for tag.create_date
     *
     * @ET
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * This method:getModifyDate
     * tag.modify_date
     *
     * @return the value of tag.modify_date
     *
     * @ET
     */
    public Date getModifyDate() {
        return modifyDate;
    }

    /**
     * This method:setModifyDate
     *  tag.modify_date
     *
     * @param modifyDate the value for tag.modify_date
     *
     * @ET
     */
    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    /**
     * This method:getOrders
     * tag.orders
     *
     * @return the value of tag.orders
     *
     * @ET
     */
    public Integer getOrders() {
        return orders;
    }

    /**
     * This method:setOrders
     *  tag.orders
     *
     * @param orders the value for tag.orders
     *
     * @ET
     */
    public void setOrders(Integer orders) {
        this.orders = orders;
    }

    /**
     * This method:getIcon
     * tag.icon
     *
     * @return the value of tag.icon
     *
     * @ET
     */
    public String getIcon() {
        return icon;
    }

    /**
     * This method:setIcon
     *  tag.icon
     *
     * @param icon the value for tag.icon
     *
     * @ET
     */
    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    /**
     * This method:getMemo
     * tag.memo
     *
     * @return the value of tag.memo
     *
     * @ET
     */
    public String getMemo() {
        return memo;
    }

    /**
     * This method:setMemo
     *  tag.memo
     *
     * @param memo the value for tag.memo
     *
     * @ET
     */
    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    /**
     * This method:getName
     * tag.name
     *
     * @return the value of tag.name
     *
     * @ET
     */
    public String getName() {
        return name;
    }

    /**
     * This method:setName
     *  tag.name
     *
     * @param name the value for tag.name
     *
     * @ET
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method:getType
     * tag.type
     *
     * @return the value of tag.type
     *
     * @ET
     */
    public Integer getType() {
        return type;
    }

    /**
     * This method:setType
     *  tag.type
     *
     * @param type the value for tag.type
     *
     * @ET
     */
    public void setType(Integer type) {
        this.type = type;
    }
}