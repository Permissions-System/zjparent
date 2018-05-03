package com.zjgt.p2p.report.model;

import java.util.Date;

public class Msglog {
    /**
     * 字段名称:  .
     * 字段定义: msglog.id
     *
     * @ET
     */
    private Long id;

    /**
     * 字段名称: 消息的状态（1.未读 2.以读 3.删除） .
     * 字段定义: msglog.status
     *
     * @ET
     */
    private Integer status;

    /**
     * 字段名称: 消息类型（1.系统消息 2...） .
     * 字段定义: msglog.type
     *
     * @ET
     */
    private Integer type;

    /**
     * 字段名称: 消息分类（1.站内信 2.短信） .
     * 字段定义: msglog.msgtype
     *
     * @ET
     */
    private Integer msgtype;

    /**
     * 字段名称: 发送时间 .
     * 字段定义: msglog.senddate
     *
     * @ET
     */
    private Date senddate;

    /**
     * 字段名称: 业务类型（1.注册通知 2.投资成功 3.收益） .
     * 字段定义: msglog.servtype
     *
     * @ET
     */
    private Integer servtype;

    /**
     * 字段名称: 业务编号 .
     * 字段定义: msglog.servno
     *
     * @ET
     */
    private String servno;

    /**
     * 字段名称: 业务类型描述（register.注册通知 invest.投资成功 income.收益） .
     * 字段定义: msglog.servdesc
     *
     * @ET
     */
    private String servdesc;

    /**
     * 字段名称: 消息的标题 .
     * 字段定义: msglog.title
     *
     * @ET
     */
    private String title;

    /**
     * 字段名称: 手机号 .
     * 字段定义: msglog.mobile
     *
     * @ET
     */
    private String mobile;

    /**
     * 字段名称:  .
     * 字段定义: msglog.username
     *
     * @ET
     */
    private String username;

    /**
     * 字段名称: 会员的id .
     * 字段定义: msglog.userid
     *
     * @ET
     */
    private Long userid;

    /**
     * 字段名称: 消息的发送时间 .
     * 字段定义: msglog.createdate
     *
     * @ET
     */
    private Date createdate;

    /**
     * 字段名称: 消息的内容 .
     * 字段定义: msglog.content
     *
     * @ET
     */
    private String content;

    /**
     * This method:getId
     * msglog.id
     *
     * @return the value of msglog.id
     *
     * @ET
     */
    public Long getId() {
        return id;
    }

    /**
     * This method:setId
     *  msglog.id
     *
     * @param id the value for msglog.id
     *
     * @ET
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method:getStatus
     * msglog.status
     *
     * @return the value of msglog.status
     *
     * @ET
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method:setStatus
     *  msglog.status
     *
     * @param status the value for msglog.status
     *
     * @ET
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method:getType
     * msglog.type
     *
     * @return the value of msglog.type
     *
     * @ET
     */
    public Integer getType() {
        return type;
    }

    /**
     * This method:setType
     *  msglog.type
     *
     * @param type the value for msglog.type
     *
     * @ET
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * This method:getMsgtype
     * msglog.msgtype
     *
     * @return the value of msglog.msgtype
     *
     * @ET
     */
    public Integer getMsgtype() {
        return msgtype;
    }

    /**
     * This method:setMsgtype
     *  msglog.msgtype
     *
     * @param msgtype the value for msglog.msgtype
     *
     * @ET
     */
    public void setMsgtype(Integer msgtype) {
        this.msgtype = msgtype;
    }

    /**
     * This method:getSenddate
     * msglog.senddate
     *
     * @return the value of msglog.senddate
     *
     * @ET
     */
    public Date getSenddate() {
        return senddate;
    }

    /**
     * This method:setSenddate
     *  msglog.senddate
     *
     * @param senddate the value for msglog.senddate
     *
     * @ET
     */
    public void setSenddate(Date senddate) {
        this.senddate = senddate;
    }

    /**
     * This method:getServtype
     * msglog.servtype
     *
     * @return the value of msglog.servtype
     *
     * @ET
     */
    public Integer getServtype() {
        return servtype;
    }

    /**
     * This method:setServtype
     *  msglog.servtype
     *
     * @param servtype the value for msglog.servtype
     *
     * @ET
     */
    public void setServtype(Integer servtype) {
        this.servtype = servtype;
    }

    /**
     * This method:getServno
     * msglog.servno
     *
     * @return the value of msglog.servno
     *
     * @ET
     */
    public String getServno() {
        return servno;
    }

    /**
     * This method:setServno
     *  msglog.servno
     *
     * @param servno the value for msglog.servno
     *
     * @ET
     */
    public void setServno(String servno) {
        this.servno = servno == null ? null : servno.trim();
    }

    /**
     * This method:getServdesc
     * msglog.servdesc
     *
     * @return the value of msglog.servdesc
     *
     * @ET
     */
    public String getServdesc() {
        return servdesc;
    }

    /**
     * This method:setServdesc
     *  msglog.servdesc
     *
     * @param servdesc the value for msglog.servdesc
     *
     * @ET
     */
    public void setServdesc(String servdesc) {
        this.servdesc = servdesc == null ? null : servdesc.trim();
    }

    /**
     * This method:getTitle
     * msglog.title
     *
     * @return the value of msglog.title
     *
     * @ET
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method:setTitle
     *  msglog.title
     *
     * @param title the value for msglog.title
     *
     * @ET
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * This method:getMobile
     * msglog.mobile
     *
     * @return the value of msglog.mobile
     *
     * @ET
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * This method:setMobile
     *  msglog.mobile
     *
     * @param mobile the value for msglog.mobile
     *
     * @ET
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     * This method:getUsername
     * msglog.username
     *
     * @return the value of msglog.username
     *
     * @ET
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method:setUsername
     *  msglog.username
     *
     * @param username the value for msglog.username
     *
     * @ET
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * This method:getUserid
     * msglog.userid
     *
     * @return the value of msglog.userid
     *
     * @ET
     */
    public Long getUserid() {
        return userid;
    }

    /**
     * This method:setUserid
     *  msglog.userid
     *
     * @param userid the value for msglog.userid
     *
     * @ET
     */
    public void setUserid(Long userid) {
        this.userid = userid;
    }

    /**
     * This method:getCreatedate
     * msglog.createdate
     *
     * @return the value of msglog.createdate
     *
     * @ET
     */
    public Date getCreatedate() {
        return createdate;
    }

    /**
     * This method:setCreatedate
     *  msglog.createdate
     *
     * @param createdate the value for msglog.createdate
     *
     * @ET
     */
    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    /**
     * This method:getContent
     * msglog.content
     *
     * @return the value of msglog.content
     *
     * @ET
     */
    public String getContent() {
        return content;
    }

    /**
     * This method:setContent
     *  msglog.content
     *
     * @param content the value for msglog.content
     *
     * @ET
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}