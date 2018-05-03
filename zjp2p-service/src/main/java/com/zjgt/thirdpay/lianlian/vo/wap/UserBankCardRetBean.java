package com.zjgt.thirdpay.lianlian.vo.wap;

import java.io.Serializable;
import java.util.List;
import org.apache.commons.lang.builder.ToStringBuilder;

public class UserBankCardRetBean
  implements Serializable
{
  private static final long serialVersionUID = 5434987635360972547L;
  private String ret_code;
  private String ret_msg;
  private String user_id;
  private String count;
  private String agreement_list;
  private List<Agreement> agreementList;
  private String sign_type;
  private String sign;

  public String toString()
  {
    return new ToStringBuilder(this).append("ret_code", this.ret_code).append("ret_msg", this.ret_msg).append("user_id", this.user_id).append("count", this.count).append("agreement_list", this.agreement_list).append("agreementList", this.agreementList).append("sign_type", this.sign_type).append("sign", this.sign).toString();
  }

  public String getRet_code()
  {
    return this.ret_code;
  }

  public void setRet_code(String ret_code) {
    this.ret_code = ret_code;
  }

  public String getRet_msg() {
    return this.ret_msg;
  }

  public void setRet_msg(String ret_msg) {
    this.ret_msg = ret_msg;
  }

  public String getUser_id() {
    return this.user_id;
  }

  public void setUser_id(String user_id) {
    this.user_id = user_id;
  }

  public String getCount() {
    return this.count;
  }

  public void setCount(String count) {
    this.count = count;
  }

  public String getAgreement_list() {
    return this.agreement_list;
  }

  public void setAgreement_list(String agreement_list) {
    this.agreement_list = agreement_list;
  }

  public String getSign_type() {
    return this.sign_type;
  }

  public void setSign_type(String sign_type) {
    this.sign_type = sign_type;
  }

  public String getSign() {
    return this.sign;
  }

  public void setSign(String sign) {
    this.sign = sign;
  }

  public List<Agreement> getAgreementList() {
    return this.agreementList;
  }

  public void setAgreementList(List<Agreement> agreementList) {
    this.agreementList = agreementList;
  }

  public static class Agreement
  {
    private String no_agree;
    private String card_no;
    private String bank_code;
    private String bank_name;
    private String card_type;
    private String bind_mobile;

    public String getNo_agree()
    {
      return this.no_agree;
    }

    public void setNo_agree(String no_agree) {
      this.no_agree = no_agree;
    }

    public String getCard_no() {
      return this.card_no;
    }

    public void setCard_no(String card_no) {
      this.card_no = card_no;
    }

    public String getBank_code() {
      return this.bank_code;
    }

    public void setBank_code(String bank_code) {
      this.bank_code = bank_code;
    }

    public String getBank_name() {
      return this.bank_name;
    }

    public void setBank_name(String bank_name) {
      this.bank_name = bank_name;
    }

    public String getCard_type() {
      return this.card_type;
    }

    public void setCard_type(String card_type) {
      this.card_type = card_type;
    }

    public String getBind_mobile() {
      return this.bind_mobile;
    }

    public void setBind_mobile(String bind_mobile) {
      this.bind_mobile = bind_mobile;
    }
  }
}