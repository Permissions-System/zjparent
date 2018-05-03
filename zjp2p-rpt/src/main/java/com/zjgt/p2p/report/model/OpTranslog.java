package com.zjgt.p2p.report.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class OpTranslog {
    /**
     * 字段名称: id，自增长 .
     * 字段定义: optranslog.id
     *
     * @ET
     */
    private Integer id;

    /**
     * 字段名称: 用户名 .
     * 字段定义: optranslog.username
     *
     * @ET
     */
    private String username;

    /**
     * 字段名称: 业务类型 recharge-充值 withdraw-提现 invest-投资 .
     * 字段定义: optranslog.serv_type
     *
     * @ET
     */
    private String servType;

    /**
     * 字段名称: 数据类型(PW11 充值 PWTX 提现 PWPC 转账
	//PW13 预授权
	//PWCF 预授权撤销
	//PW03 划拨
	//PW14 转账冻结
	//PW15 划拨冻结
	//PWDJ 冻结
	//PWJD 解冻
	//PW19 冻结付款到冻结
	//) .
     * 字段定义: optranslog.busi_tp
     *
     * @ET
     */
    private String busiTp;

    /**
     * 字段名称: 扩展类型 .
     * 字段定义: optranslog.ext_tp
     *
     * @ET
     */
    private String extTp;

    /**
     * 字段名称: 交易日期 .
     * 字段定义: optranslog.txn_date
     *
     * @ET
     */
    private Date txnDate;

    /**
     * 字段名称: 交易时分 .
     * 字段定义: optranslog.txn_time
     *
     * @ET
     */
    private Date txnTime;

    /**
     * 字段名称: 交易流水 .
     * 字段定义: optranslog.mchnt_ssn
     *
     * @ET
     */
    private String mchntSsn;

    /**
     * 字段名称: 交易金额 .
     * 字段定义: optranslog.txn_amt
     *
     * @ET
     */
    private BigDecimal txnAmt;

    /**
     * 字段名称: 成功交易金额 .
     * 字段定义: optranslog.txn_amt_suc
     *
     * @ET
     */
    private BigDecimal txnAmtSuc;

    /**
     * 字段名称: 合同号 .
     * 字段定义: optranslog.contract_no
     *
     * @ET
     */
    private String contractNo;

    /**
     * 字段名称: 出账用户虚拟账户 .
     * 字段定义: optranslog.out_fuiou_acct_no
     *
     * @ET
     */
    private String outFuiouAcctNo;

    /**
     * 字段名称: 出账用户名 .
     * 字段定义: optranslog.out_cust_no
     *
     * @ET
     */
    private String outCustNo;

    /**
     * 字段名称: 出账用户名称 .
     * 字段定义: optranslog.out_artif_nm
     *
     * @ET
     */
    private String outArtifNm;

    /**
     * 字段名称: 入账用户虚拟账户 .
     * 字段定义: optranslog.in_fuiou_acct_no
     *
     * @ET
     */
    private String inFuiouAcctNo;

    /**
     * 字段名称: 入账用户名 .
     * 字段定义: optranslog.in_cust_no
     *
     * @ET
     */
    private String inCustNo;

    /**
     * 字段名称: 入账用户名称 .
     * 字段定义: optranslog.in_artif_nm
     *
     * @ET
     */
    private String inArtifNm;

    /**
     * 字段名称: 备注 .
     * 字段定义: optranslog.remark
     *
     * @ET
     */
    private String remark;

    /**
     * 字段名称: 交易返回码 .
     * 字段定义: optranslog.txn_rsp_cd
     *
     * @ET
     */
    private String txnRspCd;

    /**
     * 字段名称: 交易返回码描述 .
     * 字段定义: optranslog.rsp_cd_desc
     *
     * @ET
     */
    private String rspCdDesc;

    /**
     * 字段名称: 数据来源编号 .
     * 字段定义: optranslog.sour_code
     *
     * @ET
     */
    private String sourCode;

    /**
     * 字段名称: 核对数据是否正确 1-正确 0错误 2-未核对 .
     * 字段定义: optranslog.checkflag
     *
     * @ET
     */
    private String checkflag;

    /**
     * 字段名称: 核对结果描述 .
     * 字段定义: optranslog.checkdesp
     *
     * @ET
     */
    private String checkdesp;

    /**
     * 字段名称: 扩展字段1 .
     * 字段定义: optranslog.temp1
     *
     * @ET
     */
    private String temp1;

    /**
     * 字段名称: 扩展字段2 .
     * 字段定义: optranslog.temp2
     *
     * @ET
     */
    private String temp2;

    /**
     * 字段名称: 扩展字段3 .
     * 字段定义: optranslog.temp3
     *
     * @ET
     */
    private String temp3;

    /**
     * 字段名称: 扩展字段4 .
     * 字段定义: optranslog.temp4
     *
     * @ET
     */
    private String temp4;

    /**
     * 字段名称: 扩展字段5 .
     * 字段定义: optranslog.temp5
     *
     * @ET
     */
    private String temp5;

    /**
     * This method:getId
     * optranslog.id
     *
     * @return the value of optranslog.id
     *
     * @ET
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method:setId
     *  optranslog.id
     *
     * @param id the value for optranslog.id
     *
     * @ET
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method:getUsername
     * optranslog.username
     *
     * @return the value of optranslog.username
     *
     * @ET
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method:setUsername
     *  optranslog.username
     *
     * @param username the value for optranslog.username
     *
     * @ET
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * This method:getServType
     * optranslog.serv_type
     *
     * @return the value of optranslog.serv_type
     *
     * @ET
     */
    public String getServType() {
        return servType;
    }

    /**
     * This method:setServType
     *  optranslog.serv_type
     *
     * @param servType the value for optranslog.serv_type
     *
     * @ET
     */
    public void setServType(String servType) {
        this.servType = servType == null ? null : servType.trim();
    }

    /**
     * This method:getBusiTp
     * optranslog.busi_tp
     *
     * @return the value of optranslog.busi_tp
     *
     * @ET
     */
    public String getBusiTp() {
        return busiTp;
    }

    /**
     * This method:setBusiTp
     *  optranslog.busi_tp
     *
     * @param busiTp the value for optranslog.busi_tp
     *
     * @ET
     */
    public void setBusiTp(String busiTp) {
        this.busiTp = busiTp == null ? null : busiTp.trim();
    }

    /**
     * This method:getExtTp
     * optranslog.ext_tp
     *
     * @return the value of optranslog.ext_tp
     *
     * @ET
     */
    public String getExtTp() {
        return extTp;
    }

    /**
     * This method:setExtTp
     *  optranslog.ext_tp
     *
     * @param extTp the value for optranslog.ext_tp
     *
     * @ET
     */
    public void setExtTp(String extTp) {
        this.extTp = extTp == null ? null : extTp.trim();
    }

    /**
     * This method:getTxnDate
     * optranslog.txn_date
     *
     * @return the value of optranslog.txn_date
     *
     * @ET
     */
    public Date getTxnDate() {
        return txnDate;
    }

    /**
     * This method:setTxnDate
     *  optranslog.txn_date
     *
     * @param txnDate the value for optranslog.txn_date
     *
     * @ET
     */
    public void setTxnDate(Date txnDate) {
        this.txnDate = txnDate;
    }

    /**
     * This method:getTxnTime
     * optranslog.txn_time
     *
     * @return the value of optranslog.txn_time
     *
     * @ET
     */
    public Date getTxnTime() {
        return txnTime;
    }

    /**
     * This method:setTxnTime
     *  optranslog.txn_time
     *
     * @param txnTime the value for optranslog.txn_time
     *
     * @ET
     */
    public void setTxnTime(Date txnTime) {
        this.txnTime = txnTime;
    }

    /**
     * This method:getMchntSsn
     * optranslog.mchnt_ssn
     *
     * @return the value of optranslog.mchnt_ssn
     *
     * @ET
     */
    public String getMchntSsn() {
        return mchntSsn;
    }

    /**
     * This method:setMchntSsn
     *  optranslog.mchnt_ssn
     *
     * @param mchntSsn the value for optranslog.mchnt_ssn
     *
     * @ET
     */
    public void setMchntSsn(String mchntSsn) {
        this.mchntSsn = mchntSsn == null ? null : mchntSsn.trim();
    }

    /**
     * This method:getTxnAmt
     * optranslog.txn_amt
     *
     * @return the value of optranslog.txn_amt
     *
     * @ET
     */
    public BigDecimal getTxnAmt() {
        return txnAmt;
    }

    /**
     * This method:setTxnAmt
     *  optranslog.txn_amt
     *
     * @param txnAmt the value for optranslog.txn_amt
     *
     * @ET
     */
    public void setTxnAmt(BigDecimal txnAmt) {
        this.txnAmt = txnAmt;
    }

    /**
     * This method:getTxnAmtSuc
     * optranslog.txn_amt_suc
     *
     * @return the value of optranslog.txn_amt_suc
     *
     * @ET
     */
    public BigDecimal getTxnAmtSuc() {
        return txnAmtSuc;
    }

    /**
     * This method:setTxnAmtSuc
     *  optranslog.txn_amt_suc
     *
     * @param txnAmtSuc the value for optranslog.txn_amt_suc
     *
     * @ET
     */
    public void setTxnAmtSuc(BigDecimal txnAmtSuc) {
        this.txnAmtSuc = txnAmtSuc;
    }

    /**
     * This method:getContractNo
     * optranslog.contract_no
     *
     * @return the value of optranslog.contract_no
     *
     * @ET
     */
    public String getContractNo() {
        return contractNo;
    }

    /**
     * This method:setContractNo
     *  optranslog.contract_no
     *
     * @param contractNo the value for optranslog.contract_no
     *
     * @ET
     */
    public void setContractNo(String contractNo) {
        this.contractNo = contractNo == null ? null : contractNo.trim();
    }

    /**
     * This method:getOutFuiouAcctNo
     * optranslog.out_fuiou_acct_no
     *
     * @return the value of optranslog.out_fuiou_acct_no
     *
     * @ET
     */
    public String getOutFuiouAcctNo() {
        return outFuiouAcctNo;
    }

    /**
     * This method:setOutFuiouAcctNo
     *  optranslog.out_fuiou_acct_no
     *
     * @param outFuiouAcctNo the value for optranslog.out_fuiou_acct_no
     *
     * @ET
     */
    public void setOutFuiouAcctNo(String outFuiouAcctNo) {
        this.outFuiouAcctNo = outFuiouAcctNo == null ? null : outFuiouAcctNo.trim();
    }

    /**
     * This method:getOutCustNo
     * optranslog.out_cust_no
     *
     * @return the value of optranslog.out_cust_no
     *
     * @ET
     */
    public String getOutCustNo() {
        return outCustNo;
    }

    /**
     * This method:setOutCustNo
     *  optranslog.out_cust_no
     *
     * @param outCustNo the value for optranslog.out_cust_no
     *
     * @ET
     */
    public void setOutCustNo(String outCustNo) {
        this.outCustNo = outCustNo == null ? null : outCustNo.trim();
    }

    /**
     * This method:getOutArtifNm
     * optranslog.out_artif_nm
     *
     * @return the value of optranslog.out_artif_nm
     *
     * @ET
     */
    public String getOutArtifNm() {
        return outArtifNm;
    }

    /**
     * This method:setOutArtifNm
     *  optranslog.out_artif_nm
     *
     * @param outArtifNm the value for optranslog.out_artif_nm
     *
     * @ET
     */
    public void setOutArtifNm(String outArtifNm) {
        this.outArtifNm = outArtifNm == null ? null : outArtifNm.trim();
    }

    /**
     * This method:getInFuiouAcctNo
     * optranslog.in_fuiou_acct_no
     *
     * @return the value of optranslog.in_fuiou_acct_no
     *
     * @ET
     */
    public String getInFuiouAcctNo() {
        return inFuiouAcctNo;
    }

    /**
     * This method:setInFuiouAcctNo
     *  optranslog.in_fuiou_acct_no
     *
     * @param inFuiouAcctNo the value for optranslog.in_fuiou_acct_no
     *
     * @ET
     */
    public void setInFuiouAcctNo(String inFuiouAcctNo) {
        this.inFuiouAcctNo = inFuiouAcctNo == null ? null : inFuiouAcctNo.trim();
    }

    /**
     * This method:getInCustNo
     * optranslog.in_cust_no
     *
     * @return the value of optranslog.in_cust_no
     *
     * @ET
     */
    public String getInCustNo() {
        return inCustNo;
    }

    /**
     * This method:setInCustNo
     *  optranslog.in_cust_no
     *
     * @param inCustNo the value for optranslog.in_cust_no
     *
     * @ET
     */
    public void setInCustNo(String inCustNo) {
        this.inCustNo = inCustNo == null ? null : inCustNo.trim();
    }

    /**
     * This method:getInArtifNm
     * optranslog.in_artif_nm
     *
     * @return the value of optranslog.in_artif_nm
     *
     * @ET
     */
    public String getInArtifNm() {
        return inArtifNm;
    }

    /**
     * This method:setInArtifNm
     *  optranslog.in_artif_nm
     *
     * @param inArtifNm the value for optranslog.in_artif_nm
     *
     * @ET
     */
    public void setInArtifNm(String inArtifNm) {
        this.inArtifNm = inArtifNm == null ? null : inArtifNm.trim();
    }

    /**
     * This method:getRemark
     * optranslog.remark
     *
     * @return the value of optranslog.remark
     *
     * @ET
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method:setRemark
     *  optranslog.remark
     *
     * @param remark the value for optranslog.remark
     *
     * @ET
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * This method:getTxnRspCd
     * optranslog.txn_rsp_cd
     *
     * @return the value of optranslog.txn_rsp_cd
     *
     * @ET
     */
    public String getTxnRspCd() {
        return txnRspCd;
    }

    /**
     * This method:setTxnRspCd
     *  optranslog.txn_rsp_cd
     *
     * @param txnRspCd the value for optranslog.txn_rsp_cd
     *
     * @ET
     */
    public void setTxnRspCd(String txnRspCd) {
        this.txnRspCd = txnRspCd == null ? null : txnRspCd.trim();
    }

    /**
     * This method:getRspCdDesc
     * optranslog.rsp_cd_desc
     *
     * @return the value of optranslog.rsp_cd_desc
     *
     * @ET
     */
    public String getRspCdDesc() {
        return rspCdDesc;
    }

    /**
     * This method:setRspCdDesc
     *  optranslog.rsp_cd_desc
     *
     * @param rspCdDesc the value for optranslog.rsp_cd_desc
     *
     * @ET
     */
    public void setRspCdDesc(String rspCdDesc) {
        this.rspCdDesc = rspCdDesc == null ? null : rspCdDesc.trim();
    }

    /**
     * This method:getSourCode
     * optranslog.sour_code
     *
     * @return the value of optranslog.sour_code
     *
     * @ET
     */
    public String getSourCode() {
        return sourCode;
    }

    /**
     * This method:setSourCode
     *  optranslog.sour_code
     *
     * @param sourCode the value for optranslog.sour_code
     *
     * @ET
     */
    public void setSourCode(String sourCode) {
        this.sourCode = sourCode == null ? null : sourCode.trim();
    }

    /**
     * This method:getCheckflag
     * optranslog.checkflag
     *
     * @return the value of optranslog.checkflag
     *
     * @ET
     */
    public String getCheckflag() {
        return checkflag;
    }

    /**
     * This method:setCheckflag
     *  optranslog.checkflag
     *
     * @param checkflag the value for optranslog.checkflag
     *
     * @ET
     */
    public void setCheckflag(String checkflag) {
        this.checkflag = checkflag;
    }

    /**
     * This method:getCheckdesp
     * optranslog.checkdesp
     *
     * @return the value of optranslog.checkdesp
     *
     * @ET
     */
    public String getCheckdesp() {
        return checkdesp;
    }

    /**
     * This method:setCheckdesp
     *  optranslog.checkdesp
     *
     * @param checkdesp the value for optranslog.checkdesp
     *
     * @ET
     */
    public void setCheckdesp(String checkdesp) {
        this.checkdesp = checkdesp == null ? null : checkdesp.trim();
    }

    /**
     * This method:getTemp1
     * optranslog.temp1
     *
     * @return the value of optranslog.temp1
     *
     * @ET
     */
    public String getTemp1() {
        return temp1;
    }

    /**
     * This method:setTemp1
     *  optranslog.temp1
     *
     * @param temp1 the value for optranslog.temp1
     *
     * @ET
     */
    public void setTemp1(String temp1) {
        this.temp1 = temp1 == null ? null : temp1.trim();
    }

    /**
     * This method:getTemp2
     * optranslog.temp2
     *
     * @return the value of optranslog.temp2
     *
     * @ET
     */
    public String getTemp2() {
        return temp2;
    }

    /**
     * This method:setTemp2
     *  optranslog.temp2
     *
     * @param temp2 the value for optranslog.temp2
     *
     * @ET
     */
    public void setTemp2(String temp2) {
        this.temp2 = temp2 == null ? null : temp2.trim();
    }

    /**
     * This method:getTemp3
     * optranslog.temp3
     *
     * @return the value of optranslog.temp3
     *
     * @ET
     */
    public String getTemp3() {
        return temp3;
    }

    /**
     * This method:setTemp3
     *  optranslog.temp3
     *
     * @param temp3 the value for optranslog.temp3
     *
     * @ET
     */
    public void setTemp3(String temp3) {
        this.temp3 = temp3 == null ? null : temp3.trim();
    }

    /**
     * This method:getTemp4
     * optranslog.temp4
     *
     * @return the value of optranslog.temp4
     *
     * @ET
     */
    public String getTemp4() {
        return temp4;
    }

    /**
     * This method:setTemp4
     *  optranslog.temp4
     *
     * @param temp4 the value for optranslog.temp4
     *
     * @ET
     */
    public void setTemp4(String temp4) {
        this.temp4 = temp4 == null ? null : temp4.trim();
    }

    /**
     * This method:getTemp5
     * optranslog.temp5
     *
     * @return the value of optranslog.temp5
     *
     * @ET
     */
    public String getTemp5() {
        return temp5;
    }

    /**
     * This method:setTemp5
     *  optranslog.temp5
     *
     * @param temp5 the value for optranslog.temp5
     *
     * @ET
     */
    public void setTemp5(String temp5) {
        this.temp5 = temp5 == null ? null : temp5.trim();
    }
    
    
    private String beginTime;
    private String endTime;
    private String checkFy;
    private String checkYw;
    
    private String isCheck;
    private String isExport;
    private String fySun;
    private String ywSum;
    private String isErrorData;
    private String userid;
    private String[] userNameList;

    private String isShowErrorDate;
    
    public String getisShowErrorDate() {
  		return isShowErrorDate;
  	}

  	public void setisShowErrorDate(String isShowErrorDate) {
  		this.isShowErrorDate = isShowErrorDate;
  	}
  	
	public String[] getUserNameList() {
		return userNameList;
	}

	public void setUserNameList(String[] userNameList) {
		this.userNameList = userNameList;
	}

	public String getuserid() {
  		return userid;
  	}

  	public void setuserid(String userid) {
  		this.userid = userid;
  	}
  	
    public String getisErrorData() {
  		return isErrorData;
  	}

  	public void setisErrorData(String isErrorData) {
  		this.isErrorData = isErrorData;
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