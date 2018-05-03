package com.zjgt.thirdpay.lianlian.vo;

import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;

public class OrderQueryRequest
  implements Serializable
{
  private static final long serialVersionUID = -7443855109747082391L;
  String oid_partner;
  String sign_type;
  String sign;
  String no_order;
  String dt_order;
  String oid_paybill;
  String query_version;
  String type_dc;

  public String toString()
  {
    return new ToStringBuilder(this).append("oid_partner", this.oid_partner).append("sign_type", this.sign_type).append("sign", this.sign).append("no_order", this.no_order).append("dt_order", this.dt_order).append("oid_paybill", this.oid_paybill).append("query_version", this.query_version).append("type_dc", this.type_dc).toString();
  }

  public String getOid_partner()
  {
    return this.oid_partner;
  }

  public void setOid_partner(String oid_partner) {
    this.oid_partner = oid_partner;
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

  public String getNo_order() {
    return this.no_order;
  }

  public void setNo_order(String no_order) {
    this.no_order = no_order;
  }

  public String getDt_order() {
    return this.dt_order;
  }

  public void setDt_order(String dt_order) {
    this.dt_order = dt_order;
  }

  public String getOid_paybill() {
    return this.oid_paybill;
  }

  public void setOid_paybill(String oid_paybill) {
    this.oid_paybill = oid_paybill;
  }

  public String getQuery_version() {
    return this.query_version;
  }

  public void setQuery_version(String query_version) {
    this.query_version = query_version;
  }

  public String getType_dc() {
    return this.type_dc;
  }

  public void setType_dc(String type_dc) {
    this.type_dc = type_dc;
  }
}