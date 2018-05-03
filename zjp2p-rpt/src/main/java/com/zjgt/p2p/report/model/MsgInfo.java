package com.zjgt.p2p.report.model;

import java.util.Date;

public class MsgInfo {
    /**
     * 字段名称:  .
     * 字段定义: msginfo.id
     *
     * @ET
     */
    private Long id;

    /**
     * 字段名称: 消息的状态（1.未发 2.已发 3.失败） .
     * 字段定义: msginfo.status
     *
     * @ET
     */
    private Integer status;

    /**
     * 字段名称: 消息类型（1.系统消息 2...） .
     * 字段定义: msginfo.type
     *
     * @ET
     */
    private Integer type;

    /**
     * 字段名称: 消息分类（1.站内信 2.短信） .
     * 字段定义: msginfo.msgtype
     *
     * @ET
     */
    private Integer msgtype;

    /**
     * 字段名称: 计划发送时间 .
     * 字段定义: msginfo.senddate
     *
     * @ET
     */
    private Date senddate;

    /**
     * 字段名称: 业务类型（1.注册通知 2.投资成功 3.收益） .
     * 字段定义: msginfo.servtype
     *
     * @ET
     */
    private Integer servtype;

    /**
     * 字段名称: 业务编号 .
     * 字段定义: msginfo.servno
     *
     * @ET
     */
    private String servno;

    /**
     * 字段名称: 业务类型描述（register.注册通知 invest.投资成功 income.收益） .
     * 字段定义: msginfo.servdesc
     *
     * @ET
     */
    private String servdesc;

    /**
     * 字段名称: 消息的标题 .
     * 字段定义: msginfo.title
     *
     * @ET
     */
    private String title;

    /**
     * 字段名称: 手机号 .
     * 字段定义: msginfo.mobile
     *
     * @ET
     */
    private String mobile;

    /**
     * 字段名称:  .
     * 字段定义: msginfo.username
     *
     * @ET
     */
    private String username;

    /**
     * 字段名称: 会员的id .
     * 字段定义: msginfo.userid
     *
     * @ET
     */
    private Long userid;

    /**
     * 字段名称: 创建时间 .
     * 字段定义: msginfo.createdate
     *
     * @ET
     */
    private Date createdate;

    /**
     * 字段名称: 消息的内容 .
     * 字段定义: msginfo.content
     *
     * @ET
     */
    private String content;

    /**
     * This method:getId
     * msginfo.id
     *
     * @return the value of msginfo.id
     *
     * @ET
     */
    public Long getId() {
        return id;
    }

    /**
     * This method:setId
     *  msginfo.id
     *
     * @param id the value for msginfo.id
     *
     * @ET
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method:getStatus
     * msginfo.status
     *
     * @return the value of msginfo.status
     *
     * @ET
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method:setStatus
     *  msginfo.status
     *
     * @param status the value for msginfo.status
     *
     * @ET
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method:getType
     * msginfo.type
     *
     * @return the value of msginfo.type
     *
     * @ET
     */
    public Integer getType() {
        return type;
    }

    /**
     * This method:setType
     *  msginfo.type
     *
     * @param type the value for msginfo.type
     *
     * @ET
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * This method:getMsgtype
     * msginfo.msgtype
     *
     * @return the value of msginfo.msgtype
     *
     * @ET
     */
    public Integer getMsgtype() {
        return msgtype;
    }

    /**
     * This method:setMsgtype
     *  msginfo.msgtype
     *
     * @param msgtype the value for msginfo.msgtype
     *
     * @ET
     */
    public void setMsgtype(Integer msgtype) {
        this.msgtype = msgtype;
    }

    /**
     * This method:getSenddate
     * msginfo.senddate
     *
     * @return the value of msginfo.senddate
     *
     * @ET
     */
    public Date getSenddate() {
        return senddate;
    }

    /**
     * This method:setSenddate
     *  msginfo.senddate
     *
     * @param senddate the value for msginfo.senddate
     *
     * @ET
     */
    public void setSenddate(Date senddate) {
        this.senddate = senddate;
    }

    /**
     * This method:getServtype
     * msginfo.servtype
     *
     * @return the value of msginfo.servtype
     *
     * @ET
     */
    public Integer getServtype() {
        return servtype;
    }

    /**
     * This method:setServtype
     *  msginfo.servtype
     *
     * @param servtype the value for msginfo.servtype
     *
     * @ET
     */
    public void setServtype(Integer servtype) {
        this.servtype = servtype;
    }

    /**
     * This method:getServno
     * msginfo.servno
     *
     * @return the value of msginfo.servno
     *
     * @ET
     */
    public String getServno() {
        return servno;
    }

    /**
     * This method:setServno
     *  msginfo.servno
     *
     * @param servno the value for msginfo.servno
     *
     * @ET
     */
    public void setServno(String servno) {
        this.servno = servno == null ? null : servno.trim();
    }

    /**
     * This method:getServdesc
     * msginfo.servdesc
     *
     * @return the value of msginfo.servdesc
     *
     * @ET
     */
    public String getServdesc() {
        return servdesc;
    }

    /**
     * This method:setServdesc
     *  msginfo.servdesc
     *
     * @param servdesc the value for msginfo.servdesc
     *
     * @ET
     */
    public void setServdesc(String servdesc) {
        this.servdesc = servdesc == null ? null : servdesc.trim();
    }

    /**
     * This method:getTitle
     * msginfo.title
     *
     * @return the value of msginfo.title
     *
     * @ET
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method:setTitle
     *  msginfo.title
     *
     * @param title the value for msginfo.title
     *
     * @ET
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * This method:getMobile
     * msginfo.mobile
     *
     * @return the value of msginfo.mobile
     *
     * @ET
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * This method:setMobile
     *  msginfo.mobile
     *
     * @param mobile the value for msginfo.mobile
     *
     * @ET
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     * This method:getUsername
     * msginfo.username
     *
     * @return the value of msginfo.username
     *
     * @ET
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method:setUsername
     *  msginfo.username
     *
     * @param username the value for msginfo.username
     *
     * @ET
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * This method:getUserid
     * msginfo.userid
     *
     * @return the value of msginfo.userid
     *
     * @ET
     */
    public Long getUserid() {
        return userid;
    }

    /**
     * This method:setUserid
     *  msginfo.userid
     *
     * @param userid the value for msginfo.userid
     *
     * @ET
     */
    public void setUserid(Long userid) {
        this.userid = userid;
    }

    /**
     * This method:getCreatedate
     * msginfo.createdate
     *
     * @return the value of msginfo.createdate
     *
     * @ET
     */
    public Date getCreatedate() {
        return createdate;
    }

    /**
     * This method:setCreatedate
     *  msginfo.createdate
     *
     * @param createdate the value for msginfo.createdate
     *
     * @ET
     */
    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    /**
     * This method:getContent
     * msginfo.content
     *
     * @return the value of msginfo.content
     *
     * @ET
     */
    public String getContent() {
        return content;
    }

    /**
     * This method:setContent
     *  msginfo.content
     *
     * @param content the value for msginfo.content
     *
     * @ET
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}