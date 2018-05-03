package com.zjgt.p2p.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Member
  implements Serializable
{
  private static final long serialVersionUID = 3828005930382324581L;
  private Long id;
  private String username;
  private String email;
  private String password;
  private String nickname;
  private String headimg;
  private String realname;
  private String name;
  private String verifyemail;
  private String idcard;
  private String bankcardno;
  private Integer bankcardnum;
  private String transpasswd;
  private Integer transpasswdifset;
  private String address;
  private String mobile;
  private BigDecimal amount;
  private Date birth;
  private Integer gender;
  private Boolean ifselfmember;
  private Boolean ifjoinexpence;
  private Boolean isEnabled;
  private Boolean isLocked;
  private Date lockedDate;
  private Date loginDate;
  private Integer loginFailureCount;
  private String loginIp;
  private String phone;
  private Long point;
  private String openid;
  private String weixinopenid;
  private Integer usertype;
  private Integer userrole;
  private String registerIp;
  private Date safeKeyExpire;
  private String safeKeyValue;
  private String zipCode;
  private Long area;
  private Long memberRank;
  private Long agentid;
  private Short regsource;
  private Date createDate;
  private Date modifyDate;
  private Short userstatus;

  public Long getId()
  {
    return this.id;
  }

  public void setId(Long id)
  {
    this.id = id;
  }

  public String getUsername()
  {
    return this.username;
  }

  public void setUsername(String username)
  {
    this.username = ((username == null) ? null : username.trim());
  }

  public String getEmail()
  {
    return this.email;
  }

  public void setEmail(String email)
  {
    this.email = ((email == null) ? null : email.trim());
  }

  public String getPassword()
  {
    return this.password;
  }

  public void setPassword(String password)
  {
    this.password = ((password == null) ? null : password.trim());
  }

  public String getNickname()
  {
    return this.nickname;
  }

  public void setNickname(String nickname)
  {
    this.nickname = ((nickname == null) ? null : nickname.trim());
  }

  public String getHeadimg()
  {
    return this.headimg;
  }

  public void setHeadimg(String headimg)
  {
    this.headimg = ((headimg == null) ? null : headimg.trim());
  }

  public String getRealname()
  {
    return this.realname;
  }

  public void setRealname(String realname)
  {
    this.realname = ((realname == null) ? null : realname.trim());
  }

  public String getName()
  {
    return this.name;
  }

  public void setName(String name)
  {
    this.name = ((name == null) ? null : name.trim());
  }

  public String getVerifyemail()
  {
    return this.verifyemail;
  }

  public void setVerifyemail(String verifyemail)
  {
    this.verifyemail = ((verifyemail == null) ? null : verifyemail.trim());
  }

  public String getIdcard()
  {
    return this.idcard;
  }

  public void setIdcard(String idcard)
  {
    this.idcard = ((idcard == null) ? null : idcard.trim());
  }

  public String getBankcardno()
  {
    return this.bankcardno;
  }

  public void setBankcardno(String bankcardno)
  {
    this.bankcardno = ((bankcardno == null) ? null : bankcardno.trim());
  }

  public Integer getBankcardnum()
  {
    return this.bankcardnum;
  }

  public void setBankcardnum(Integer bankcardnum)
  {
    this.bankcardnum = bankcardnum;
  }

  public String getTranspasswd()
  {
    return this.transpasswd;
  }

  public void setTranspasswd(String transpasswd)
  {
    this.transpasswd = ((transpasswd == null) ? null : transpasswd.trim());
  }

  public Integer getTranspasswdifset()
  {
    return this.transpasswdifset;
  }

  public void setTranspasswdifset(Integer transpasswdifset)
  {
    this.transpasswdifset = transpasswdifset;
  }

  public String getAddress()
  {
    return this.address;
  }

  public void setAddress(String address)
  {
    this.address = ((address == null) ? null : address.trim());
  }

  public String getMobile()
  {
    return this.mobile;
  }

  public void setMobile(String mobile)
  {
    this.mobile = ((mobile == null) ? null : mobile.trim());
  }

  public BigDecimal getAmount()
  {
    return this.amount;
  }

  public void setAmount(BigDecimal amount)
  {
    this.amount = amount;
  }

  public Date getBirth()
  {
    return this.birth;
  }

  public void setBirth(Date birth)
  {
    this.birth = birth;
  }

  public Integer getGender()
  {
    return this.gender;
  }

  public void setGender(Integer gender)
  {
    this.gender = gender;
  }

  public Boolean getIfselfmember()
  {
    return this.ifselfmember;
  }

  public void setIfselfmember(Boolean ifselfmember)
  {
    this.ifselfmember = ifselfmember;
  }

  public Boolean getIfjoinexpence()
  {
    return this.ifjoinexpence;
  }

  public void setIfjoinexpence(Boolean ifjoinexpence)
  {
    this.ifjoinexpence = ifjoinexpence;
  }

  public Boolean getIsEnabled()
  {
    return this.isEnabled;
  }

  public void setIsEnabled(Boolean isEnabled)
  {
    this.isEnabled = isEnabled;
  }

  public Boolean getIsLocked()
  {
    return this.isLocked;
  }

  public void setIsLocked(Boolean isLocked)
  {
    this.isLocked = isLocked;
  }

  public Date getLockedDate()
  {
    return this.lockedDate;
  }

  public void setLockedDate(Date lockedDate)
  {
    this.lockedDate = lockedDate;
  }

  public Date getLoginDate()
  {
    return this.loginDate;
  }

  public void setLoginDate(Date loginDate)
  {
    this.loginDate = loginDate;
  }

  public Integer getLoginFailureCount()
  {
    return this.loginFailureCount;
  }

  public void setLoginFailureCount(Integer loginFailureCount)
  {
    this.loginFailureCount = loginFailureCount;
  }

  public String getLoginIp()
  {
    return this.loginIp;
  }

  public void setLoginIp(String loginIp)
  {
    this.loginIp = ((loginIp == null) ? null : loginIp.trim());
  }

  public String getPhone()
  {
    return this.phone;
  }

  public void setPhone(String phone)
  {
    this.phone = ((phone == null) ? null : phone.trim());
  }

  public Long getPoint()
  {
    return this.point;
  }

  public void setPoint(Long point)
  {
    this.point = point;
  }

  public String getOpenid()
  {
    return this.openid;
  }

  public void setOpenid(String openid)
  {
    this.openid = ((openid == null) ? null : openid.trim());
  }

  public String getWeixinopenid()
  {
    return this.weixinopenid;
  }

  public void setWeixinopenid(String weixinopenid)
  {
    this.weixinopenid = ((weixinopenid == null) ? null : weixinopenid.trim());
  }

  public Integer getUsertype()
  {
    return this.usertype;
  }

  public void setUsertype(Integer usertype)
  {
    this.usertype = usertype;
  }

  public Integer getUserrole()
  {
    return this.userrole;
  }

  public void setUserrole(Integer userrole)
  {
    this.userrole = userrole;
  }

  public String getRegisterIp()
  {
    return this.registerIp;
  }

  public void setRegisterIp(String registerIp)
  {
    this.registerIp = ((registerIp == null) ? null : registerIp.trim());
  }

  public Date getSafeKeyExpire()
  {
    return this.safeKeyExpire;
  }

  public void setSafeKeyExpire(Date safeKeyExpire)
  {
    this.safeKeyExpire = safeKeyExpire;
  }

  public String getSafeKeyValue()
  {
    return this.safeKeyValue;
  }

  public void setSafeKeyValue(String safeKeyValue)
  {
    this.safeKeyValue = ((safeKeyValue == null) ? null : safeKeyValue.trim());
  }

  public String getZipCode()
  {
    return this.zipCode;
  }

  public void setZipCode(String zipCode)
  {
    this.zipCode = ((zipCode == null) ? null : zipCode.trim());
  }

  public Long getArea()
  {
    return this.area;
  }

  public void setArea(Long area)
  {
    this.area = area;
  }

  public Long getMemberRank()
  {
    return this.memberRank;
  }

  public void setMemberRank(Long memberRank)
  {
    this.memberRank = memberRank;
  }

  public Long getAgentid()
  {
    return this.agentid;
  }

  public void setAgentid(Long agentid)
  {
    this.agentid = agentid;
  }

  public Short getRegsource()
  {
    return this.regsource;
  }

  public void setRegsource(Short regsource)
  {
    this.regsource = regsource;
  }

  public Date getCreateDate()
  {
    return this.createDate;
  }

  public void setCreateDate(Date createDate)
  {
    this.createDate = createDate;
  }

  public Date getModifyDate()
  {
    return this.modifyDate;
  }

  public void setModifyDate(Date modifyDate)
  {
    this.modifyDate = modifyDate;
  }

  public Short getUserstatus()
  {
    return this.userstatus;
  }

  public void setUserstatus(Short userstatus)
  {
    this.userstatus = userstatus;
  }
}