package com.zjgt.p2p.model;

import java.util.Date;

public class Approve {
    /**
     * 字段名称: 编号 .
     * 字段定义: approve.Id
     *
     * @ET
     */
    private Long id;

    /**
     * 字段名称: 模块编号 .
     * 字段定义: approve.modulecode
     *
     * @ET
     */
    private String modulecode;

    /**
     * 字段名称: 业务编号 .
     * 字段定义: approve.serviceno
     *
     * @ET
     */
    private String serviceno;

    /**
     * 字段名称: 操作事务 .
     * 字段定义: approve.transname
     *
     * @ET
     */
    private String transname;

    /**
     * 字段名称: 流程步骤 1-申请 2-审核 .
     * 字段定义: approve.flowstep
     *
     * @ET
     */
    private Integer flowstep;

    /**
     * 字段名称: 审批意见 .
     * 字段定义: approve.subject
     *
     * @ET
     */
    private String subject;

    /**
     * 字段名称: 审核建议原因 .
     * 字段定义: approve.appreason
     *
     * @ET
     */
    private String appreason;

    /**
     * 字段名称: 审核状态 1-通过 0-不通过  .
     * 字段定义: approve.appstatus
     *
     * @ET
     */
    private Boolean appstatus;

    /**
     * 字段名称: 操作人编号 .
     * 字段定义: approve.staff_no
     *
     * @ET
     */
    private String staffNo;

    /**
     * 字段名称: 操作人姓名 .
     * 字段定义: approve.staff_name
     *
     * @ET
     */
    private String staffName;

    /**
     * 字段名称: 操作日期 .
     * 字段定义: approve.opdate
     *
     * @ET
     */
    private Date opdate;

    /**
     * 字段名称: 备注 .
     * 字段定义: approve.remark
     *
     * @ET
     */
    private String remark;

    /**
     * This method:getId
     * approve.Id
     *
     * @return the value of approve.Id
     *
     * @ET
     */
    public Long getId() {
        return id;
    }

    /**
     * This method:setId
     *  approve.Id
     *
     * @param id the value for approve.Id
     *
     * @ET
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method:getModulecode
     * approve.modulecode
     *
     * @return the value of approve.modulecode
     *
     * @ET
     */
    public String getModulecode() {
        return modulecode;
    }

    /**
     * This method:setModulecode
     *  approve.modulecode
     *
     * @param modulecode the value for approve.modulecode
     *
     * @ET
     */
    public void setModulecode(String modulecode) {
        this.modulecode = modulecode == null ? null : modulecode.trim();
    }

    /**
     * This method:getServiceno
     * approve.serviceno
     *
     * @return the value of approve.serviceno
     *
     * @ET
     */
    public String getServiceno() {
        return serviceno;
    }

    /**
     * This method:setServiceno
     *  approve.serviceno
     *
     * @param serviceno the value for approve.serviceno
     *
     * @ET
     */
    public void setServiceno(String serviceno) {
        this.serviceno = serviceno == null ? null : serviceno.trim();
    }

    /**
     * This method:getTransname
     * approve.transname
     *
     * @return the value of approve.transname
     *
     * @ET
     */
    public String getTransname() {
        return transname;
    }

    /**
     * This method:setTransname
     *  approve.transname
     *
     * @param transname the value for approve.transname
     *
     * @ET
     */
    public void setTransname(String transname) {
        this.transname = transname == null ? null : transname.trim();
    }

    /**
     * This method:getFlowstep
     * approve.flowstep
     *
     * @return the value of approve.flowstep
     *
     * @ET
     */
    public Integer getFlowstep() {
        return flowstep;
    }

    /**
     * This method:setFlowstep
     *  approve.flowstep
     *
     * @param flowstep the value for approve.flowstep
     *
     * @ET
     */
    public void setFlowstep(Integer flowstep) {
        this.flowstep = flowstep;
    }

    /**
     * This method:getSubject
     * approve.subject
     *
     * @return the value of approve.subject
     *
     * @ET
     */
    public String getSubject() {
        return subject;
    }

    /**
     * This method:setSubject
     *  approve.subject
     *
     * @param subject the value for approve.subject
     *
     * @ET
     */
    public void setSubject(String subject) {
        this.subject = subject == null ? null : subject.trim();
    }

    /**
     * This method:getAppreason
     * approve.appreason
     *
     * @return the value of approve.appreason
     *
     * @ET
     */
    public String getAppreason() {
        return appreason;
    }

    /**
     * This method:setAppreason
     *  approve.appreason
     *
     * @param appreason the value for approve.appreason
     *
     * @ET
     */
    public void setAppreason(String appreason) {
        this.appreason = appreason == null ? null : appreason.trim();
    }

    /**
     * This method:getAppstatus
     * approve.appstatus
     *
     * @return the value of approve.appstatus
     *
     * @ET
     */
    public Boolean getAppstatus() {
        return appstatus;
    }

    /**
     * This method:setAppstatus
     *  approve.appstatus
     *
     * @param appstatus the value for approve.appstatus
     *
     * @ET
     */
    public void setAppstatus(Boolean appstatus) {
        this.appstatus = appstatus;
    }

    /**
     * This method:getStaffNo
     * approve.staff_no
     *
     * @return the value of approve.staff_no
     *
     * @ET
     */
    public String getStaffNo() {
        return staffNo;
    }

    /**
     * This method:setStaffNo
     *  approve.staff_no
     *
     * @param staffNo the value for approve.staff_no
     *
     * @ET
     */
    public void setStaffNo(String staffNo) {
        this.staffNo = staffNo == null ? null : staffNo.trim();
    }

    /**
     * This method:getStaffName
     * approve.staff_name
     *
     * @return the value of approve.staff_name
     *
     * @ET
     */
    public String getStaffName() {
        return staffName;
    }

    /**
     * This method:setStaffName
     *  approve.staff_name
     *
     * @param staffName the value for approve.staff_name
     *
     * @ET
     */
    public void setStaffName(String staffName) {
        this.staffName = staffName == null ? null : staffName.trim();
    }

    /**
     * This method:getOpdate
     * approve.opdate
     *
     * @return the value of approve.opdate
     *
     * @ET
     */
    public Date getOpdate() {
        return opdate;
    }

    /**
     * This method:setOpdate
     *  approve.opdate
     *
     * @param opdate the value for approve.opdate
     *
     * @ET
     */
    public void setOpdate(Date opdate) {
        this.opdate = opdate;
    }

    /**
     * This method:getRemark
     * approve.remark
     *
     * @return the value of approve.remark
     *
     * @ET
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method:setRemark
     *  approve.remark
     *
     * @param remark the value for approve.remark
     *
     * @ET
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}