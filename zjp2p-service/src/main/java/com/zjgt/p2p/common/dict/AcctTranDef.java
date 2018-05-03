package com.zjgt.p2p.common.dict;

public enum AcctTranDef
{
  FILL, WITHDRAW, FROZEN, DEDUCT, LOAN, REPAY, YIELD, UNFROZEN, TRANS, ADJUST_ADD, ADJUST_SUBTRACT, PREPAY, COMPENSATE, INCOME, PRINCIPAL, INTEREST, REDEM, FAILEDBID, ALLOT, PLATFILL, PLATWITHDRAW, SELFPRINCIPAL, SELFINTEREST, TRANSPRINCIPAL, TRANSINTEREST, DISBURSEMENTS, BONUS, EVERYINTEREST, LOSEREFUND, PAY_TO_BORROWER, FILL_FEE, WITHDRAW_FEE, REDEM_FEE, PUB_FEE, INFO_FEE, OVERDUE_FEE, UNPAID_FEE, MANAGER_FEE, RISKMGR_FEE, BONUS_FROZEN, BONUS_BIDLOSE_UNFROZEN, BONUS_RANSOM_UNFROZEN, BONUS_DEDUCT, COMMISS_APPROP, COMMISS_RETURN, COMPENSATION, MERCHANT_PROMOTION;

  private String tranCode;
  private String tranName;
  private String showName;
  private String amountFlag;
  private String iOrOut;

  public static AcctTranDef tranName(String tranName)
  {
    if (FILL.tranName.equals(tranName))
      return FILL;
    if (WITHDRAW.tranName.equals(tranName))
      return WITHDRAW;
    if (FROZEN.tranName.equals(tranName))
      return FROZEN;
    if (UNFROZEN.tranName.equals(tranName))
      return UNFROZEN;
    if (DEDUCT.tranName.equals(tranName))
      return DEDUCT;
    if (LOAN.tranName.equals(tranName))
      return LOAN;
    if (REPAY.tranName.equals(tranName))
      return REPAY;
    if (YIELD.tranName.equals(tranName))
      return YIELD;
    if (ADJUST_ADD.tranName.equals(tranName))
      return ADJUST_ADD;
    if (ADJUST_SUBTRACT.tranName.equals(tranName))
      return ADJUST_SUBTRACT;
    if (PREPAY.tranName.equals(tranName))
      return PREPAY;
    if (COMPENSATE.tranName.equals(tranName))
      return COMPENSATE;
    if (INCOME.tranName.equals(tranName))
      return INCOME;
    if (PRINCIPAL.tranName.equals(tranName))
      return PRINCIPAL;
    if (INTEREST.tranName.equals(tranName))
      return INTEREST;
    if (ALLOT.tranName.equals(tranName))
      return ALLOT;
    if (PLATFILL.tranName.equals(tranName))
      return PLATFILL;
    if (PLATWITHDRAW.tranName.equals(tranName))
      return PLATWITHDRAW;
    if (SELFPRINCIPAL.tranName.equals(tranName))
      return SELFPRINCIPAL;
    if (SELFINTEREST.tranName.equals(tranName))
      return SELFINTEREST;
    if (TRANSPRINCIPAL.tranName.equals(tranName))
      return TRANSPRINCIPAL;
    if (TRANSINTEREST.tranName.equals(tranName))
      return TRANSINTEREST;
    if (DISBURSEMENTS.tranName.equals(tranName))
      return DISBURSEMENTS;
    if (BONUS.tranName.equals(tranName))
      return BONUS;
    if (EVERYINTEREST.tranName.equals(tranName))
      return EVERYINTEREST;
    if (LOSEREFUND.tranName.equals(tranName))
      return LOSEREFUND;
    if (FILL_FEE.tranName.equals(tranName))
      return FILL_FEE;
    if (WITHDRAW_FEE.tranName.equals(tranName))
      return WITHDRAW_FEE;
    if (REDEM_FEE.tranName.equals(tranName))
      return REDEM_FEE;
    if (PUB_FEE.tranName.equals(tranName))
      return PUB_FEE;
    if (INFO_FEE.tranName.equals(tranName))
      return INFO_FEE;
    if (OVERDUE_FEE.tranName.equals(tranName))
      return OVERDUE_FEE;
    if (UNPAID_FEE.tranName.equals(tranName))
      return UNPAID_FEE;
    if (MANAGER_FEE.tranName.equals(tranName))
      return MANAGER_FEE;
    if (RISKMGR_FEE.tranName.equals(tranName)) {
      return RISKMGR_FEE;
    }
    return null;
  }

  public static AcctTranDef tranCode(String tranCode) {
    if (FILL.tranCode.equals(tranCode))
      return FILL;
    if (WITHDRAW.tranCode.equals(tranCode))
      return WITHDRAW;
    if (FROZEN.tranCode.equals(tranCode))
      return FROZEN;
    if (UNFROZEN.tranCode.equals(tranCode))
      return UNFROZEN;
    if (DEDUCT.tranCode.equals(tranCode))
      return DEDUCT;
    if (LOAN.tranCode.equals(tranCode))
      return LOAN;
    if (REPAY.tranCode.equals(tranCode))
      return REPAY;
    if (YIELD.tranCode.equals(tranCode))
      return YIELD;
    if (ADJUST_ADD.tranCode.equals(tranCode))
      return ADJUST_ADD;
    if (ADJUST_SUBTRACT.tranCode.equals(tranCode))
      return ADJUST_SUBTRACT;
    if (PREPAY.tranCode.equals(tranCode))
      return PREPAY;
    if (COMPENSATE.tranCode.equals(tranCode))
      return COMPENSATE;
    if (INCOME.tranCode.equals(tranCode))
      return INCOME;
    if (PRINCIPAL.tranCode.equals(tranCode))
      return PRINCIPAL;
    if (INTEREST.tranCode.equals(tranCode))
      return INTEREST;
    if (ALLOT.tranCode.equals(tranCode))
      return ALLOT;
    if (PLATFILL.tranCode.equals(tranCode))
      return PLATFILL;
    if (PLATWITHDRAW.tranCode.equals(tranCode))
      return PLATWITHDRAW;
    if (SELFPRINCIPAL.tranCode.equals(tranCode))
      return SELFPRINCIPAL;
    if (SELFINTEREST.tranCode.equals(tranCode))
      return SELFINTEREST;
    if (TRANSPRINCIPAL.tranCode.equals(tranCode))
      return TRANSPRINCIPAL;
    if (TRANSINTEREST.tranCode.equals(tranCode))
      return TRANSINTEREST;
    if (DISBURSEMENTS.tranCode.equals(tranCode))
      return DISBURSEMENTS;
    if (BONUS.tranCode.equals(tranCode))
      return BONUS;
    if (EVERYINTEREST.tranCode.equals(tranCode))
      return EVERYINTEREST;
    if (LOSEREFUND.tranCode.equals(tranCode))
      return LOSEREFUND;
    if (FILL_FEE.tranCode.equals(tranCode))
      return FILL_FEE;
    if (WITHDRAW_FEE.tranCode.equals(tranCode))
      return WITHDRAW_FEE;
    if (REDEM_FEE.tranCode.equals(tranCode))
      return REDEM_FEE;
    if (PUB_FEE.tranCode.equals(tranCode))
      return PUB_FEE;
    if (INFO_FEE.tranCode.equals(tranCode))
      return INFO_FEE;
    if (OVERDUE_FEE.tranCode.equals(tranCode))
      return OVERDUE_FEE;
    if (UNPAID_FEE.tranCode.equals(tranCode))
      return UNPAID_FEE;
    if (MANAGER_FEE.tranCode.equals(tranCode))
      return MANAGER_FEE;
    if (RISKMGR_FEE.tranCode.equals(tranCode)) {
      return RISKMGR_FEE;
    }
    return null;
  }

  public String getTranCode() {
    return this.tranCode;
  }

  public void setTranCode(String tranCode) {
    this.tranCode = tranCode;
  }

  public String getTranName() {
    return this.tranName;
  }

  public void setTranName(String tranName) {
    this.tranName = tranName;
  }

  public String getAmountFlag() {
    return this.amountFlag;
  }

  public void setAmountFlag(String amountFlag) {
    this.amountFlag = amountFlag;
  }

  public String getiOrOut()
  {
    return this.iOrOut;
  }

  public void setiOrOut(String iOrOut)
  {
    this.iOrOut = iOrOut;
  }

  public String getShowName() {
    return this.showName;
  }

  public void setShowName(String showName) {
    this.showName = showName;
  }
}