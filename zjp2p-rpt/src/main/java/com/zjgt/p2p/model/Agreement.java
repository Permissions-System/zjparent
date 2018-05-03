package com.zjgt.p2p.model;

public class Agreement {
    /**
     * 字段名称:  .
     * 字段定义: agreement.id
     *
     * @ET
     */
    private Integer id;

    /**
     * 字段名称:  .
     * 字段定义: agreement.agreementno
     *
     * @ET
     */
    private String agreementno;

    /**
     * 字段名称:  .
     * 字段定义: agreement.agreementname
     *
     * @ET
     */
    private String agreementname;

    /**
     * 字段名称:  .
     * 字段定义: agreement.subject
     *
     * @ET
     */
    private String subject;

    /**
     * 字段名称:  .
     * 字段定义: agreement.fileurl
     *
     * @ET
     */
    private String fileurl;

    /**
     * 字段名称:  .
     * 字段定义: agreement.remark
     *
     * @ET
     */
    private String remark;

    /**
     * This method:getId
     * agreement.id
     *
     * @return the value of agreement.id
     *
     * @ET
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method:setId
     *  agreement.id
     *
     * @param id the value for agreement.id
     *
     * @ET
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method:getAgreementno
     * agreement.agreementno
     *
     * @return the value of agreement.agreementno
     *
     * @ET
     */
    public String getAgreementno() {
        return agreementno;
    }

    /**
     * This method:setAgreementno
     *  agreement.agreementno
     *
     * @param agreementno the value for agreement.agreementno
     *
     * @ET
     */
    public void setAgreementno(String agreementno) {
        this.agreementno = agreementno == null ? null : agreementno.trim();
    }

    /**
     * This method:getAgreementname
     * agreement.agreementname
     *
     * @return the value of agreement.agreementname
     *
     * @ET
     */
    public String getAgreementname() {
        return agreementname;
    }

    /**
     * This method:setAgreementname
     *  agreement.agreementname
     *
     * @param agreementname the value for agreement.agreementname
     *
     * @ET
     */
    public void setAgreementname(String agreementname) {
        this.agreementname = agreementname == null ? null : agreementname.trim();
    }

    /**
     * This method:getSubject
     * agreement.subject
     *
     * @return the value of agreement.subject
     *
     * @ET
     */
    public String getSubject() {
        return subject;
    }

    /**
     * This method:setSubject
     *  agreement.subject
     *
     * @param subject the value for agreement.subject
     *
     * @ET
     */
    public void setSubject(String subject) {
        this.subject = subject == null ? null : subject.trim();
    }

    /**
     * This method:getFileurl
     * agreement.fileurl
     *
     * @return the value of agreement.fileurl
     *
     * @ET
     */
    public String getFileurl() {
        return fileurl;
    }

    /**
     * This method:setFileurl
     *  agreement.fileurl
     *
     * @param fileurl the value for agreement.fileurl
     *
     * @ET
     */
    public void setFileurl(String fileurl) {
        this.fileurl = fileurl == null ? null : fileurl.trim();
    }

    /**
     * This method:getRemark
     * agreement.remark
     *
     * @return the value of agreement.remark
     *
     * @ET
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method:setRemark
     *  agreement.remark
     *
     * @param remark the value for agreement.remark
     *
     * @ET
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}