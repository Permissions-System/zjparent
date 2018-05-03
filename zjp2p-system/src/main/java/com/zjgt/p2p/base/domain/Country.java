package com.zjgt.p2p.base.domain;

import java.io.Serializable;

public class Country
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private String countryCode;
  private String twoCode;
  private String threeCode;
  private String cnShortName;
  private String enShortName;
  private String cnName;
  private String enName;
  private String itelFix;

  public String getCountryCode()
  {
    return this.countryCode;
  }

  public void setCountryCode(String countryCode) {
    this.countryCode = countryCode;
  }

  public String getTwoCode() {
    return this.twoCode;
  }

  public void setTwoCode(String twoCode) {
    this.twoCode = twoCode;
  }

  public String getThreeCode() {
    return this.threeCode;
  }

  public void setThreeCode(String threeCode) {
    this.threeCode = threeCode;
  }

  public String getCnShortName() {
    return this.cnShortName;
  }

  public void setCnShortName(String cnShortName) {
    this.cnShortName = cnShortName;
  }

  public String getEnShortName() {
    return this.enShortName;
  }

  public void setEnShortName(String enShortName) {
    this.enShortName = enShortName;
  }

  public String getCnName() {
    return this.cnName;
  }

  public void setCnName(String cnName) {
    this.cnName = cnName;
  }

  public String getEnName() {
    return this.enName;
  }

  public void setEnName(String enName) {
    this.enName = enName;
  }

  public String getItelFix() {
    return this.itelFix;
  }

  public void setItelFix(String itelFix) {
    this.itelFix = itelFix;
  }
}