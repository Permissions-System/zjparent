package com.zjgt.p2p.report.model;

import java.math.BigDecimal;

public class OptranslogTemp {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column optranslogtemp.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column optranslogtemp.username
     *
     * @mbggenerated
     */
    private String username;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column optranslogtemp.busi_tp
     *
     * @mbggenerated
     */
    private String busiTp;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column optranslogtemp.txn_amt
     *
     * @mbggenerated
     */
    private BigDecimal txnAmt;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column optranslogtemp.id
     *
     * @return the value of optranslogtemp.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column optranslogtemp.id
     *
     * @param id the value for optranslogtemp.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column optranslogtemp.username
     *
     * @return the value of optranslogtemp.username
     *
     * @mbggenerated
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column optranslogtemp.username
     *
     * @param username the value for optranslogtemp.username
     *
     * @mbggenerated
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column optranslogtemp.busi_tp
     *
     * @return the value of optranslogtemp.busi_tp
     *
     * @mbggenerated
     */
    public String getBusiTp() {
        return busiTp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column optranslogtemp.busi_tp
     *
     * @param busiTp the value for optranslogtemp.busi_tp
     *
     * @mbggenerated
     */
    public void setBusiTp(String busiTp) {
        this.busiTp = busiTp == null ? null : busiTp.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column optranslogtemp.txn_amt
     *
     * @return the value of optranslogtemp.txn_amt
     *
     * @mbggenerated
     */
    public BigDecimal getTxnAmt() {
        return txnAmt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column optranslogtemp.txn_amt
     *
     * @param txnAmt the value for optranslogtemp.txn_amt
     *
     * @mbggenerated
     */
    public void setTxnAmt(BigDecimal txnAmt) {
        this.txnAmt = txnAmt;
    }
    
    
    
    private String checkFlag;//核对标记
    private String beginDate;//开始日期
    private String endDate;//结束日期
    
    
	public String getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getCheckFlag() {
		return checkFlag;
	}

	public void setCheckFlag(String checkFlag) {
		this.checkFlag = checkFlag;
	}
    
}