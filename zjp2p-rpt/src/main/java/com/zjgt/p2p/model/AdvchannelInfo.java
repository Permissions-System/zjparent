package com.zjgt.p2p.model;

import java.util.Date;

public class AdvchannelInfo {
    /**
     * 字段名称:  .
     * 字段定义: advchannelinfo.id
     *
     * @ET
     */
    private Integer id;

    /**
     * 字段名称: 用户编号 .
     * 字段定义: advchannelinfo.memberid
     *
     * @ET
     */
    private Long memberid;

    /**
     * 字段名称:  .
     * 字段定义: advchannelinfo.channelname
     *
     * @ET
     */
    private String channelname;

    /**
     * 字段名称:  .
     * 字段定义: advchannelinfo.channelcode
     *
     * @ET
     */
    private String channelcode;

    /**
     * 字段名称: 费用类型 .
     * 字段定义: advchannelinfo.feetype
     *
     * @ET
     */
    private Integer feetype;

    /**
     * 字段名称: 0-注册数  1-分佣 2-分成 3-其他 .
     * 字段定义: advchannelinfo.profittype
     *
     * @ET
     */
    private Integer profittype;

    /**
     * 字段名称: 合作截止日期 .
     * 字段定义: advchannelinfo.cooperiod
     *
     * @ET
     */
    private Date cooperiod;

    /**
     * 字段名称:  .
     * 字段定义: advchannelinfo.remark
     *
     * @ET
     */
    private String remark;

    /**
     * This method:getId
     * advchannelinfo.id
     *
     * @return the value of advchannelinfo.id
     *
     * @ET
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method:setId
     *  advchannelinfo.id
     *
     * @param id the value for advchannelinfo.id
     *
     * @ET
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method:getMemberid
     * advchannelinfo.memberid
     *
     * @return the value of advchannelinfo.memberid
     *
     * @ET
     */
    public Long getMemberid() {
        return memberid;
    }

    /**
     * This method:setMemberid
     *  advchannelinfo.memberid
     *
     * @param memberid the value for advchannelinfo.memberid
     *
     * @ET
     */
    public void setMemberid(Long memberid) {
        this.memberid = memberid;
    }

    /**
     * This method:getChannelname
     * advchannelinfo.channelname
     *
     * @return the value of advchannelinfo.channelname
     *
     * @ET
     */
    public String getChannelname() {
        return channelname;
    }

    /**
     * This method:setChannelname
     *  advchannelinfo.channelname
     *
     * @param channelname the value for advchannelinfo.channelname
     *
     * @ET
     */
    public void setChannelname(String channelname) {
        this.channelname = channelname == null ? null : channelname.trim();
    }

    /**
     * This method:getChannelcode
     * advchannelinfo.channelcode
     *
     * @return the value of advchannelinfo.channelcode
     *
     * @ET
     */
    public String getChannelcode() {
        return channelcode;
    }

    /**
     * This method:setChannelcode
     *  advchannelinfo.channelcode
     *
     * @param channelcode the value for advchannelinfo.channelcode
     *
     * @ET
     */
    public void setChannelcode(String channelcode) {
        this.channelcode = channelcode == null ? null : channelcode.trim();
    }

    /**
     * This method:getFeetype
     * advchannelinfo.feetype
     *
     * @return the value of advchannelinfo.feetype
     *
     * @ET
     */
    public Integer getFeetype() {
        return feetype;
    }

    /**
     * This method:setFeetype
     *  advchannelinfo.feetype
     *
     * @param feetype the value for advchannelinfo.feetype
     *
     * @ET
     */
    public void setFeetype(Integer feetype) {
        this.feetype = feetype;
    }

    /**
     * This method:getProfittype
     * advchannelinfo.profittype
     *
     * @return the value of advchannelinfo.profittype
     *
     * @ET
     */
    public Integer getProfittype() {
        return profittype;
    }

    /**
     * This method:setProfittype
     *  advchannelinfo.profittype
     *
     * @param profittype the value for advchannelinfo.profittype
     *
     * @ET
     */
    public void setProfittype(Integer profittype) {
        this.profittype = profittype;
    }

    /**
     * This method:getCooperiod
     * advchannelinfo.cooperiod
     *
     * @return the value of advchannelinfo.cooperiod
     *
     * @ET
     */
    public Date getCooperiod() {
        return cooperiod;
    }

    /**
     * This method:setCooperiod
     *  advchannelinfo.cooperiod
     *
     * @param cooperiod the value for advchannelinfo.cooperiod
     *
     * @ET
     */
    public void setCooperiod(Date cooperiod) {
        this.cooperiod = cooperiod;
    }

    /**
     * This method:getRemark
     * advchannelinfo.remark
     *
     * @return the value of advchannelinfo.remark
     *
     * @ET
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method:setRemark
     *  advchannelinfo.remark
     *
     * @param remark the value for advchannelinfo.remark
     *
     * @ET
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}