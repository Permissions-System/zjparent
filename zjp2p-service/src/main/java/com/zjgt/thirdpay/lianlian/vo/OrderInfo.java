package com.zjgt.thirdpay.lianlian.vo;

import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;

public class OrderInfo
  implements Serializable
{
  private static final long serialVersionUID = -639142270308567624L;
  private String no_order;
  private String dt_order;
  private String name_goods;
  private String info_order;
  private String money_order;

  public String toString()
  {
    return new ToStringBuilder(this).append("no_order", this.no_order).append("dt_order", this.dt_order).append("name_goods", this.name_goods).append("info_order", this.info_order).append("money_order", this.money_order).toString();
  }

  public String getNo_order()
  {
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

  public String getName_goods() {
    return this.name_goods;
  }

  public void setName_goods(String name_goods) {
    this.name_goods = name_goods;
  }

  public String getInfo_order() {
    return this.info_order;
  }

  public void setInfo_order(String info_order) {
    this.info_order = info_order;
  }

  public String getMoney_order() {
    return this.money_order;
  }

  public void setMoney_order(String money_order) {
    this.money_order = money_order;
  }
}