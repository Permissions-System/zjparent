package com.zjgt.p2p.model;

import java.math.BigDecimal;

public class Agent {
    /**
     * 字段名称:  .
     * 字段定义: agent.id
     *
     * @ET
     */
    private Long id;

    /**
     * 字段名称:  .
     * 字段定义: agent.memberid
     *
     * @ET
     */
    private Long memberid;

    /**
     * 字段名称: 经济人等级 1 2 3级 .
     * 字段定义: agent.level
     *
     * @ET
     */
    private Integer level;

    /**
     * 字段名称: 是否公司用户 0-个人用户 1-公司用户 .
     * 字段定义: agent.iscompany
     *
     * @ET
     */
    private Integer iscompany;
    
    /**
     * 字段名称: 是否商户 0-否 1-商户代理人 .
     * 字段定义: agent.ismerchant
     *
     * @ET
     */
    private Integer isMerchant;

    /**
     * 字段名称: 金佣比例 .
     * 字段定义: agent.commissionrate
     *
     * @ET
     */
    private BigDecimal commissionrate;

    /**
     * 字段名称: 备注 .
     * 字段定义: agent.remark
     *
     * @ET
     */
    private String remark;

    /**
     * This method:getId
     * agent.id
     *
     * @return the value of agent.id
     *
     * @ET
     */
    public Long getId() {
        return id;
    }

    /**
     * This method:setId
     *  agent.id
     *
     * @param id the value for agent.id
     *
     * @ET
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method:getMemberid
     * agent.memberid
     *
     * @return the value of agent.memberid
     *
     * @ET
     */
    public Long getMemberid() {
        return memberid;
    }

    /**
     * This method:setMemberid
     *  agent.memberid
     *
     * @param memberid the value for agent.memberid
     *
     * @ET
     */
    public void setMemberid(Long memberid) {
        this.memberid = memberid;
    }

    /**
     * This method:getLevel
     * agent.level
     *
     * @return the value of agent.level
     *
     * @ET
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * This method:setLevel
     *  agent.level
     *
     * @param level the value for agent.level
     *
     * @ET
     */
    public void setLevel(Integer level) {
        this.level = level;
    }

    /**
     * This method:getIscompany
     * agent.iscompany
     *
     * @return the value of agent.iscompany
     *
     * @ET
     */
    public Integer getIscompany() {
        return iscompany;
    }

    /**
     * This method:setIscompany
     *  agent.iscompany
     *
     * @param iscompany the value for agent.iscompany
     *
     * @ET
     */
    public void setIscompany(Integer iscompany) {
        this.iscompany = iscompany;
    }

    
    public Integer getIsMerchant() {
		return isMerchant;
	}

	public void setIsMerchant(Integer isMerchant) {
		this.isMerchant = isMerchant;
	}

	/**
     * This method:getCommissionrate
     * agent.commissionrate
     *
     * @return the value of agent.commissionrate
     *
     * @ET
     */
    public BigDecimal getCommissionrate() {
        return commissionrate;
    }

    /**
     * This method:setCommissionrate
     *  agent.commissionrate
     *
     * @param commissionrate the value for agent.commissionrate
     *
     * @ET
     */
    public void setCommissionrate(BigDecimal commissionrate) {
        this.commissionrate = commissionrate;
    }

    /**
     * This method:getRemark
     * agent.remark
     *
     * @return the value of agent.remark
     *
     * @ET
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method:setRemark
     *  agent.remark
     *
     * @param remark the value for agent.remark
     *
     * @ET
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}