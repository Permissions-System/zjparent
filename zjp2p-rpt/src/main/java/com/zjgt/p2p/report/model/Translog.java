package com.zjgt.p2p.report.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class Translog {
    /**
     * 字段名称: id，自增长 .
     * 字段定义: translog.id
     *
     * @ET
     */
    private Integer id;

    /**
     * 字段名称: 用户名 .
     * 字段定义: translog.username
     *
     * @ET
     */
    private String username;

    /**
     * 字段名称: 业务类型 recharge-充值 withdraw-提现 invest-投资 .
     * 字段定义: translog.serv_type
     *
     * @ET
     */
    private String servType;

    /**
     * 字段名称: 数据类型描述 .
     * 字段定义: translog.serv_desp
     *
     * @ET
     */
    private String servDesp;

    /**
     * 字段名称: 扩展类型 .
     * 字段定义: translog.ext_tp
     *
     * @ET
     */
    private String extTp;

    /**
     * 字段名称: 交易日期 .
     * 字段定义: translog.txn_date
     *
     * @ET
     */
    private Date txnDate;

    /**
     * 字段名称: 交易时分 .
     * 字段定义: translog.txn_time
     *
     * @ET
     */
    private Date txnTime;

    /**
     * 字段名称: 交易流水-对应第三方的流水号 .
     * 字段定义: translog.mchnt_ssn
     *
     * @ET
     */
    private String mchntSsn;

    /**
     * 字段名称: 交易金额 .
     * 字段定义: translog.txn_amt
     *
     * @ET
     */
    private BigDecimal txnAmt;

    /**
     * 字段名称: 成功交易金额 .
     * 字段定义: translog.txn_amt_suc
     *
     * @ET
     */
    private BigDecimal txnAmtSuc;

    /**
     * 字段名称: 合同号 .
     * 字段定义: translog.contract_no
     *
     * @ET
     */
    private String contractNo;

    /**
     * 字段名称: 出账用户虚拟账户 .
     * 字段定义: translog.out_fuiou_acct_no
     *
     * @ET
     */
    private String outFuiouAcctNo;

    /**
     * 字段名称: 出账用户名 .
     * 字段定义: translog.out_cust_no
     *
     * @ET
     */
    private String outCustNo;

    /**
     * 字段名称: 出账用户名称 .
     * 字段定义: translog.out_artif_nm
     *
     * @ET
     */
    private String outArtifNm;

    /**
     * 字段名称: 入账用户虚拟账户 .
     * 字段定义: translog.in_fuiou_acct_no
     *
     * @ET
     */
    private String inFuiouAcctNo;

    /**
     * 字段名称: 入账用户名 .
     * 字段定义: translog.in_cust_no
     *
     * @ET
     */
    private String inCustNo;

    /**
     * 字段名称: 入账用户名称 .
     * 字段定义: translog.in_artif_nm
     *
     * @ET
     */
    private String inArtifNm;

    /**
     * 字段名称: 备注 .
     * 字段定义: translog.remark
     *
     * @ET
     */
    private String remark;

    /**
     * 字段名称: 交易返回码 .
     * 字段定义: translog.txn_rsp_cd
     *
     * @ET
     */
    private String txnRspCd;

    /**
     * 字段名称: 交易返回码描述 .
     * 字段定义: translog.rsp_cd_desc
     *
     * @ET
     */
    private String rspCdDesc;

    /**
     * 字段名称: 数据来源编号 投资表-tb_lend或充值提现表 .
     * 字段定义: translog.sour_code
     *
     * @ET
     */
    private String sourCode;

    /**
     * 字段名称: 交易类型 .
     * 字段定义: translog.busi_tp
     *
     * @ET
     */
    private String busiTp;

    /**
     * 字段名称: 对应tb_lendinfo的RecordStatus .
     * 字段定义: translog.status
     *
     * @ET
     */
    private Integer status;

    /**
     * 字段名称: 核对是否成功 .
     * 字段定义: translog.checkflag
     *
     * @ET
     */
    private String checkflag;

    /**
     * 字段名称: 核对结果描述 .
     * 字段定义: translog.checkdesp
     *
     * @ET
     */
    private String checkdesp;

    /**
     * 字段名称: 创建日期 .
     * 字段定义: translog.createDate
     *
     * @ET
     */
    private String createdate;

    /**
     * 字段名称: 资金流向 .
     * 字段定义: translog.fundFlow
     *
     * @ET
     */
    private String fundflow;

    /**
     * 字段名称: 记录投资记录ID .
     * 字段定义: translog.investId
     *
     * @ET
     */
    private String investid;

    /**
     * 字段名称: 描述 .
     * 字段定义: translog.describes
     *
     * @ET
     */
    private String describes;

    /**
     * 字段名称: 扩展字段1 .
     * 字段定义: translog.temp1
     *
     * @ET
     */
    private String temp1;

    /**
     * 字段名称: 扩展字段2 .
     * 字段定义: translog.temp2
     *
     * @ET
     */
    private String temp2;

    /**
     * 字段名称: 扩展字段3 .
     * 字段定义: translog.temp3
     *
     * @ET
     */
    private String temp3;

    /**
     * 字段名称: 扩展字段4 .
     * 字段定义: translog.temp4
     *
     * @ET
     */
    private String temp4;

    /**
     * 字段名称: 扩展字段5 .
     * 字段定义: translog.temp5
     *
     * @ET
     */
    private String temp5;

    /**
     * This method:getId
     * translog.id
     *
     * @return the value of translog.id
     *
     * @ET
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method:setId
     *  translog.id
     *
     * @param id the value for translog.id
     *
     * @ET
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method:getUsername
     * translog.username
     *
     * @return the value of translog.username
     *
     * @ET
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method:setUsername
     *  translog.username
     *
     * @param username the value for translog.username
     *
     * @ET
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * This method:getServType
     * translog.serv_type
     *
     * @return the value of translog.serv_type
     *
     * @ET
     */
    public String getServType() {
        return servType;
    }

    /**
     * This method:setServType
     *  translog.serv_type
     *
     * @param servType the value for translog.serv_type
     *
     * @ET
     */
    public void setServType(String servType) {
        this.servType = servType == null ? null : servType.trim();
    }

    /**
     * This method:getServDesp
     * translog.serv_desp
     *
     * @return the value of translog.serv_desp
     *
     * @ET
     */
    public String getServDesp() {
        return servDesp;
    }

    /**
     * This method:setServDesp
     *  translog.serv_desp
     *
     * @param servDesp the value for translog.serv_desp
     *
     * @ET
     */
    public void setServDesp(String servDesp) {
        this.servDesp = servDesp == null ? null : servDesp.trim();
    }

    /**
     * This method:getExtTp
     * translog.ext_tp
     *
     * @return the value of translog.ext_tp
     *
     * @ET
     */
    public String getExtTp() {
        return extTp;
    }

    /**
     * This method:setExtTp
     *  translog.ext_tp
     *
     * @param extTp the value for translog.ext_tp
     *
     * @ET
     */
    public void setExtTp(String extTp) {
        this.extTp = extTp == null ? null : extTp.trim();
    }

    /**
     * This method:getTxnDate
     * translog.txn_date
     *
     * @return the value of translog.txn_date
     *
     * @ET
     */
    public Date getTxnDate() {
        return txnDate;
    }

    /**
     * This method:setTxnDate
     *  translog.txn_date
     *
     * @param txnDate the value for translog.txn_date
     *
     * @ET
     */
    public void setTxnDate(Date txnDate) {
        this.txnDate = txnDate;
    }

    /**
     * This method:getTxnTime
     * translog.txn_time
     *
     * @return the value of translog.txn_time
     *
     * @ET
     */
    public Date getTxnTime() {
        return txnTime;
    }

    /**
     * This method:setTxnTime
     *  translog.txn_time
     *
     * @param txnTime the value for translog.txn_time
     *
     * @ET
     */
    public void setTxnTime(Date txnTime) {
        this.txnTime = txnTime;
    }

    /**
     * This method:getMchntSsn
     * translog.mchnt_ssn
     *
     * @return the value of translog.mchnt_ssn
     *
     * @ET
     */
    public String getMchntSsn() {
        return mchntSsn;
    }

    /**
     * This method:setMchntSsn
     *  translog.mchnt_ssn
     *
     * @param mchntSsn the value for translog.mchnt_ssn
     *
     * @ET
     */
    public void setMchntSsn(String mchntSsn) {
        this.mchntSsn = mchntSsn == null ? null : mchntSsn.trim();
    }

    /**
     * This method:getTxnAmt
     * translog.txn_amt
     *
     * @return the value of translog.txn_amt
     *
     * @ET
     */
    public BigDecimal getTxnAmt() {
        return txnAmt;
    }

    /**
     * This method:setTxnAmt
     *  translog.txn_amt
     *
     * @param txnAmt the value for translog.txn_amt
     *
     * @ET
     */
    public void setTxnAmt(BigDecimal txnAmt) {
        this.txnAmt = txnAmt;
    }

    /**
     * This method:getTxnAmtSuc
     * translog.txn_amt_suc
     *
     * @return the value of translog.txn_amt_suc
     *
     * @ET
     */
    public BigDecimal getTxnAmtSuc() {
        return txnAmtSuc;
    }

    /**
     * This method:setTxnAmtSuc
     *  translog.txn_amt_suc
     *
     * @param txnAmtSuc the value for translog.txn_amt_suc
     *
     * @ET
     */
    public void setTxnAmtSuc(BigDecimal txnAmtSuc) {
        this.txnAmtSuc = txnAmtSuc;
    }

    /**
     * This method:getContractNo
     * translog.contract_no
     *
     * @return the value of translog.contract_no
     *
     * @ET
     */
    public String getContractNo() {
        return contractNo;
    }

    /**
     * This method:setContractNo
     *  translog.contract_no
     *
     * @param contractNo the value for translog.contract_no
     *
     * @ET
     */
    public void setContractNo(String contractNo) {
        this.contractNo = contractNo == null ? null : contractNo.trim();
    }

    /**
     * This method:getOutFuiouAcctNo
     * translog.out_fuiou_acct_no
     *
     * @return the value of translog.out_fuiou_acct_no
     *
     * @ET
     */
    public String getOutFuiouAcctNo() {
        return outFuiouAcctNo;
    }

    /**
     * This method:setOutFuiouAcctNo
     *  translog.out_fuiou_acct_no
     *
     * @param outFuiouAcctNo the value for translog.out_fuiou_acct_no
     *
     * @ET
     */
    public void setOutFuiouAcctNo(String outFuiouAcctNo) {
        this.outFuiouAcctNo = outFuiouAcctNo == null ? null : outFuiouAcctNo.trim();
    }

    /**
     * This method:getOutCustNo
     * translog.out_cust_no
     *
     * @return the value of translog.out_cust_no
     *
     * @ET
     */
    public String getOutCustNo() {
        return outCustNo;
    }

    /**
     * This method:setOutCustNo
     *  translog.out_cust_no
     *
     * @param outCustNo the value for translog.out_cust_no
     *
     * @ET
     */
    public void setOutCustNo(String outCustNo) {
        this.outCustNo = outCustNo == null ? null : outCustNo.trim();
    }

    /**
     * This method:getOutArtifNm
     * translog.out_artif_nm
     *
     * @return the value of translog.out_artif_nm
     *
     * @ET
     */
    public String getOutArtifNm() {
        return outArtifNm;
    }

    /**
     * This method:setOutArtifNm
     *  translog.out_artif_nm
     *
     * @param outArtifNm the value for translog.out_artif_nm
     *
     * @ET
     */
    public void setOutArtifNm(String outArtifNm) {
        this.outArtifNm = outArtifNm == null ? null : outArtifNm.trim();
    }

    /**
     * This method:getInFuiouAcctNo
     * translog.in_fuiou_acct_no
     *
     * @return the value of translog.in_fuiou_acct_no
     *
     * @ET
     */
    public String getInFuiouAcctNo() {
        return inFuiouAcctNo;
    }

    /**
     * This method:setInFuiouAcctNo
     *  translog.in_fuiou_acct_no
     *
     * @param inFuiouAcctNo the value for translog.in_fuiou_acct_no
     *
     * @ET
     */
    public void setInFuiouAcctNo(String inFuiouAcctNo) {
        this.inFuiouAcctNo = inFuiouAcctNo == null ? null : inFuiouAcctNo.trim();
    }

    /**
     * This method:getInCustNo
     * translog.in_cust_no
     *
     * @return the value of translog.in_cust_no
     *
     * @ET
     */
    public String getInCustNo() {
        return inCustNo;
    }

    /**
     * This method:setInCustNo
     *  translog.in_cust_no
     *
     * @param inCustNo the value for translog.in_cust_no
     *
     * @ET
     */
    public void setInCustNo(String inCustNo) {
        this.inCustNo = inCustNo == null ? null : inCustNo.trim();
    }

    /**
     * This method:getInArtifNm
     * translog.in_artif_nm
     *
     * @return the value of translog.in_artif_nm
     *
     * @ET
     */
    public String getInArtifNm() {
        return inArtifNm;
    }

    /**
     * This method:setInArtifNm
     *  translog.in_artif_nm
     *
     * @param inArtifNm the value for translog.in_artif_nm
     *
     * @ET
     */
    public void setInArtifNm(String inArtifNm) {
        this.inArtifNm = inArtifNm == null ? null : inArtifNm.trim();
    }

    /**
     * This method:getRemark
     * translog.remark
     *
     * @return the value of translog.remark
     *
     * @ET
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method:setRemark
     *  translog.remark
     *
     * @param remark the value for translog.remark
     *
     * @ET
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * This method:getTxnRspCd
     * translog.txn_rsp_cd
     *
     * @return the value of translog.txn_rsp_cd
     *
     * @ET
     */
    public String getTxnRspCd() {
        return txnRspCd;
    }

    /**
     * This method:setTxnRspCd
     *  translog.txn_rsp_cd
     *
     * @param txnRspCd the value for translog.txn_rsp_cd
     *
     * @ET
     */
    public void setTxnRspCd(String txnRspCd) {
        this.txnRspCd = txnRspCd == null ? null : txnRspCd.trim();
    }

    /**
     * This method:getRspCdDesc
     * translog.rsp_cd_desc
     *
     * @return the value of translog.rsp_cd_desc
     *
     * @ET
     */
    public String getRspCdDesc() {
        return rspCdDesc;
    }

    /**
     * This method:setRspCdDesc
     *  translog.rsp_cd_desc
     *
     * @param rspCdDesc the value for translog.rsp_cd_desc
     *
     * @ET
     */
    public void setRspCdDesc(String rspCdDesc) {
        this.rspCdDesc = rspCdDesc == null ? null : rspCdDesc.trim();
    }

    /**
     * This method:getSourCode
     * translog.sour_code
     *
     * @return the value of translog.sour_code
     *
     * @ET
     */
    public String getSourCode() {
        return sourCode;
    }

    /**
     * This method:setSourCode
     *  translog.sour_code
     *
     * @param sourCode the value for translog.sour_code
     *
     * @ET
     */
    public void setSourCode(String sourCode) {
        this.sourCode = sourCode == null ? null : sourCode.trim();
    }

    /**
     * This method:getBusiTp
     * translog.busi_tp
     *
     * @return the value of translog.busi_tp
     *
     * @ET
     */
    public String getBusiTp() {
        return busiTp;
    }

    /**
     * This method:setBusiTp
     *  translog.busi_tp
     *
     * @param busiTp the value for translog.busi_tp
     *
     * @ET
     */
    public void setBusiTp(String busiTp) {
        this.busiTp = busiTp == null ? null : busiTp.trim();
    }

    /**
     * This method:getStatus
     * translog.status
     *
     * @return the value of translog.status
     *
     * @ET
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method:setStatus
     *  translog.status
     *
     * @param status the value for translog.status
     *
     * @ET
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method:getCheckflag
     * translog.checkflag
     *
     * @return the value of translog.checkflag
     *
     * @ET
     */
    public String getCheckflag() {
        return checkflag;
    }

    /**
     * This method:setCheckflag
     *  translog.checkflag
     *
     * @param checkflag the value for translog.checkflag
     *
     * @ET
     */
    public void setCheckflag(String checkflag) {
        this.checkflag = checkflag == null ? null : checkflag.trim();
    }

    /**
     * This method:getCheckdesp
     * translog.checkdesp
     *
     * @return the value of translog.checkdesp
     *
     * @ET
     */
    public String getCheckdesp() {
        return checkdesp;
    }

    /**
     * This method:setCheckdesp
     *  translog.checkdesp
     *
     * @param checkdesp the value for translog.checkdesp
     *
     * @ET
     */
    public void setCheckdesp(String checkdesp) {
        this.checkdesp = checkdesp == null ? null : checkdesp.trim();
    }

    /**
     * This method:getCreatedate
     * translog.createDate
     *
     * @return the value of translog.createDate
     *
     * @ET
     */
    public String getCreatedate() {
        return createdate;
    }

    /**
     * This method:setCreatedate
     *  translog.createDate
     *
     * @param createdate the value for translog.createDate
     *
     * @ET
     */
    public void setCreatedate(String createdate) {
        this.createdate = createdate == null ? null : createdate.trim();
    }

    /**
     * This method:getFundflow
     * translog.fundFlow
     *
     * @return the value of translog.fundFlow
     *
     * @ET
     */
    public String getFundflow() {
        return fundflow;
    }

    /**
     * This method:setFundflow
     *  translog.fundFlow
     *
     * @param fundflow the value for translog.fundFlow
     *
     * @ET
     */
    public void setFundflow(String fundflow) {
        this.fundflow = fundflow == null ? null : fundflow.trim();
    }

    /**
     * This method:getInvestid
     * translog.investId
     *
     * @return the value of translog.investId
     *
     * @ET
     */
    public String getInvestid() {
        return investid;
    }

    /**
     * This method:setInvestid
     *  translog.investId
     *
     * @param investid the value for translog.investId
     *
     * @ET
     */
    public void setInvestid(String investid) {
        this.investid = investid == null ? null : investid.trim();
    }

    /**
     * This method:getDescribes
     * translog.describes
     *
     * @return the value of translog.describes
     *
     * @ET
     */
    public String getDescribes() {
        return describes;
    }

    /**
     * This method:setDescribes
     *  translog.describes
     *
     * @param describes the value for translog.describes
     *
     * @ET
     */
    public void setDescribes(String describes) {
        this.describes = describes == null ? null : describes.trim();
    }

    /**
     * This method:getTemp1
     * translog.temp1
     *
     * @return the value of translog.temp1
     *
     * @ET
     */
    public String getTemp1() {
        return temp1;
    }

    /**
     * This method:setTemp1
     *  translog.temp1
     *
     * @param temp1 the value for translog.temp1
     *
     * @ET
     */
    public void setTemp1(String temp1) {
        this.temp1 = temp1 == null ? null : temp1.trim();
    }

    /**
     * This method:getTemp2
     * translog.temp2
     *
     * @return the value of translog.temp2
     *
     * @ET
     */
    public String getTemp2() {
        return temp2;
    }

    /**
     * This method:setTemp2
     *  translog.temp2
     *
     * @param temp2 the value for translog.temp2
     *
     * @ET
     */
    public void setTemp2(String temp2) {
        this.temp2 = temp2 == null ? null : temp2.trim();
    }

    /**
     * This method:getTemp3
     * translog.temp3
     *
     * @return the value of translog.temp3
     *
     * @ET
     */
    public String getTemp3() {
        return temp3;
    }

    /**
     * This method:setTemp3
     *  translog.temp3
     *
     * @param temp3 the value for translog.temp3
     *
     * @ET
     */
    public void setTemp3(String temp3) {
        this.temp3 = temp3 == null ? null : temp3.trim();
    }

    /**
     * This method:getTemp4
     * translog.temp4
     *
     * @return the value of translog.temp4
     *
     * @ET
     */
    public String getTemp4() {
        return temp4;
    }

    /**
     * This method:setTemp4
     *  translog.temp4
     *
     * @param temp4 the value for translog.temp4
     *
     * @ET
     */
    public void setTemp4(String temp4) {
        this.temp4 = temp4 == null ? null : temp4.trim();
    }

    /**
     * This method:getTemp5
     * translog.temp5
     *
     * @return the value of translog.temp5
     *
     * @ET
     */
    public String getTemp5() {
        return temp5;
    }

    /**
     * This method:setTemp5
     *  translog.temp5
     *
     * @param temp5 the value for translog.temp5
     *
     * @ET
     */
    public void setTemp5(String temp5) {
        this.temp5 = temp5 == null ? null : temp5.trim();
    }
    
    
    private String beginTime;
    private String endTime;
    private String activityId;//活动编号
	private String businessType;//核算类型
	    
    private String checkFy;
    private String checkYw;
    private String isCheck;
    private String isExport;
    private String currentFuBalance;
    private String transQueryType;
    
    private String fySun;
    private String ywSum;
    
    private String isCheck11;
    private String[] userNameList;

	public String[] getUserNameList() {
		return userNameList;
	}

	public void setUserNameList(String[] userNameList) {
		this.userNameList = userNameList;
	}

	
    public String getisCheck11() {
		return isCheck11;
	}

	public void setisCheck11(String isCheck11) {
		this.isCheck11 = isCheck11;
	}
    
    public String getTransQueryType() {
		return transQueryType;
	}

	public void setTransQueryType(String transQueryType) {
		this.transQueryType = transQueryType;
	}

	public String getCurrentFuBalance() {
		return currentFuBalance;
	}

	public void setCurrentFuBalance(String currentFuBalance) {
		this.currentFuBalance = currentFuBalance;
	}

	public String getfySun() {
  		return fySun;
  	}

  	public void setfySun(String fySun) {
  		this.fySun = fySun;
  	}
  	
 	public void setywSum(String ywSum) {
   		this.ywSum = ywSum;
   	}
   	
    public String getywSum() {
  		return ywSum;
  	}
    
    

    public String getisExport() {
  		return isExport;
  	}

  	public void setisExport(String isExport) {
  		this.isExport = isExport;
  	}
  	

    public String getisCheck() {
  		return isCheck;
  	}

  	public void setisCheck(String isCheck) {
  		this.isCheck = isCheck;
  	}
  	
    public String getcheckFy() {
		return checkFy;
	}

	public void setcheckFy(String checkFy) {
		this.checkFy = checkFy;
	}
    
    public String getcheckYw() {
		return checkYw;
	}

	public void setcheckYw(String checkYw) {
		this.checkYw = checkYw;
	}
		
    public String getbusinessType() {
		return businessType;
	}

	public void setbusinessType(String businessType) {
		this.businessType = businessType;
	}
    
    public String getActivityId() {
		return activityId;
	}

	public void setActivityId(String activityId) {
		this.activityId = activityId;
	}

	public String getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
}