package com.zjgt.p2p.report.model;

import java.math.BigDecimal;
import java.util.Date;

public class UserInvestInfo {
    /**
     * 字段名称: 会员名称 .
     * 字段定义: userinvestinfo.id
     *
     * @ET
     */
    private Integer id;

    /**
     * 字段名称: 会员名称 .
     * 字段定义: userinvestinfo.memberName
     *
     * @ET
     */
    private String membername;

    /**
     * 字段名称: 真实姓名 .
     * 字段定义: userinvestinfo.realName
     *
     * @ET
     */
    private String realname;

    /**
     * 字段名称: 手机号码 .
     * 字段定义: userinvestinfo.mobile
     *
     * @ET
     */
    private String mobile;

    /**
     * 字段名称: 富有是否开户（0：未开户1：开户） .
     * 字段定义: userinvestinfo.HasFuiou
     *
     * @ET
     */
    private Integer hasfuiou;

    /**
     * 字段名称: 注册时间 .
     * 字段定义: userinvestinfo.regTime
     *
     * @ET
     */
    private Date regtime;

    /**
     * 字段名称: 近投金额 .
     * 字段定义: userinvestinfo.nearlyInvestMoney
     *
     * @ET
     */
    private BigDecimal nearlyinvestmoney;

    /**
     * 字段名称: 近投时间 .
     * 字段定义: userinvestinfo.nearlyInvestTime
     *
     * @ET
     */
    private Date nearlyinvesttime;

    /**
     * 字段名称: 首次投资金额 .
     * 字段定义: userinvestinfo.firstInvestMoney
     *
     * @ET
     */
    private BigDecimal firstinvestmoney;

    /**
     * 字段名称: 首次投资时间 .
     * 字段定义: userinvestinfo.firstInvestTime
     *
     * @ET
     */
    private Date firstinvesttime;

    /**
     * 字段名称: 推荐人 .
     * 字段定义: userinvestinfo.recommendPerson
     *
     * @ET
     */
    private String recommendperson;

    /**
     * 字段名称: 推荐码 .
     * 字段定义: userinvestinfo.recommendCode
     *
     * @ET
     */
    private String recommendcode;

    /**
     * 字段名称: 推广渠道码 .
     * 字段定义: userinvestinfo.promoteCode
     *
     * @ET
     */
    private String promotecode;

    /**
     * 字段名称: 身份 .
     * 字段定义: userinvestinfo.identity
     *
     * @ET
     */
    private String identity;

    /**
     * 字段名称: “地域”根据IP地址查询 .
     * 字段定义: userinvestinfo.area
     *
     * @ET
     */
    private String area;

    /**
     * 字段名称: 省 .
     * 字段定义: userinvestinfo.province
     *
     * @ET
     */
    private String province;

    /**
     * 字段名称: 市 .
     * 字段定义: userinvestinfo.city
     *
     * @ET
     */
    private String city;

    /**
     * 字段名称: 区 .
     * 字段定义: userinvestinfo.region
     *
     * @ET
     */
    private String region;

    /**
     * 字段名称: 性别 .
     * 字段定义: userinvestinfo.gender
     *
     * @ET
     */
    private String gender;

    /**
     * 字段名称: 年龄 .
     * 字段定义: userinvestinfo.age
     *
     * @ET
     */
    private Integer age;

    /**
     * 字段名称: 账户余额 .
     * 字段定义: userinvestinfo.accountBalance
     *
     * @ET
     */
    private BigDecimal accountbalance;

    /**
     * 字段名称: 累计充值金额 .
     * 字段定义: userinvestinfo.addRechargeMoney
     *
     * @ET
     */
    private BigDecimal addrechargemoney;

    /**
     * 字段名称: 累计提现金额 .
     * 字段定义: userinvestinfo.addWithdrawalMoney
     *
     * @ET
     */
    private BigDecimal addwithdrawalmoney;

    /**
     * 字段名称: 累计投资金额 .
     * 字段定义: userinvestinfo.addInvestMoney
     *
     * @ET
     */
    private BigDecimal addinvestmoney;

    /**
     * 字段名称: 累计提现次数 .
     * 字段定义: userinvestinfo.addInvestCnt
     *
     * @ET
     */
    private Integer addinvestcnt;

    /**
     * 字段名称: 领取中金币数量 .
     * 字段定义: userinvestinfo.ZJBNum
     *
     * @ET
     */
    private Integer zjbnum;

    /**
     * 字段名称: “推荐注册数”指的是这个用户推荐了多少人在网站注册，如果没有就是0 .
     * 字段定义: userinvestinfo.recommendRegCnt
     *
     * @ET
     */
    private Integer recommendregcnt;

    /**
     * 字段名称: 累计登入次数 .
     * 字段定义: userinvestinfo.addLoginCnt
     *
     * @ET
     */
    private Integer addlogincnt;

    /**
     * 字段名称: 最后一次登入时间(精确到秒) .
     * 字段定义: userinvestinfo.lastLoginTime
     *
     * @ET
     */
    private Date lastlogintime;

    /**
     * 字段名称: 记录值 .
     * 字段定义: userinvestinfo.record
     *
     * @ET
     */
    private String record;

    /**
     * 字段名称: 创建时间 .
     * 字段定义: userinvestinfo.createDate
     *
     * @ET
     */
    private Date createdate;

    /**
     * 字段名称:  .
     * 字段定义: userinvestinfo.temp1
     *
     * @ET
     */
    private String temp1;

    /**
     * 字段名称:  .
     * 字段定义: userinvestinfo.temp2
     *
     * @ET
     */
    private String temp2;

    /**
     * 字段名称:  .
     * 字段定义: userinvestinfo.temp3
     *
     * @ET
     */
    private String temp3;

    /**
     * 字段名称:  .
     * 字段定义: userinvestinfo.temp4
     *
     * @ET
     */
    private String temp4;
    
    
    private String regBeginTime;
    private String regEndTime;
    private String firstInvBeginTime;
    private String firstInvEndTime;

    /**
     * This method:getId
     * userinvestinfo.id
     *
     * @return the value of userinvestinfo.id
     *
     * @ET
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method:setId
     *  userinvestinfo.id
     *
     * @param id the value for userinvestinfo.id
     *
     * @ET
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method:getMembername
     * userinvestinfo.memberName
     *
     * @return the value of userinvestinfo.memberName
     *
     * @ET
     */
    public String getMembername() {
        return membername;
    }

    /**
     * This method:setMembername
     *  userinvestinfo.memberName
     *
     * @param membername the value for userinvestinfo.memberName
     *
     * @ET
     */
    public void setMembername(String membername) {
        this.membername = membername == null ? null : membername.trim();
    }

    /**
     * This method:getRealname
     * userinvestinfo.realName
     *
     * @return the value of userinvestinfo.realName
     *
     * @ET
     */
    public String getRealname() {
        return realname;
    }

    /**
     * This method:setRealname
     *  userinvestinfo.realName
     *
     * @param realname the value for userinvestinfo.realName
     *
     * @ET
     */
    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    /**
     * This method:getMobile
     * userinvestinfo.mobile
     *
     * @return the value of userinvestinfo.mobile
     *
     * @ET
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * This method:setMobile
     *  userinvestinfo.mobile
     *
     * @param mobile the value for userinvestinfo.mobile
     *
     * @ET
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     * This method:getHasfuiou
     * userinvestinfo.HasFuiou
     *
     * @return the value of userinvestinfo.HasFuiou
     *
     * @ET
     */
    public Integer getHasfuiou() {
        return hasfuiou;
    }

    /**
     * This method:setHasfuiou
     *  userinvestinfo.HasFuiou
     *
     * @param hasfuiou the value for userinvestinfo.HasFuiou
     *
     * @ET
     */
    public void setHasfuiou(Integer hasfuiou) {
        this.hasfuiou = hasfuiou;
    }

    /**
     * This method:getRegtime
     * userinvestinfo.regTime
     *
     * @return the value of userinvestinfo.regTime
     *
     * @ET
     */
    public Date getRegtime() {
        return regtime;
    }

    /**
     * This method:setRegtime
     *  userinvestinfo.regTime
     *
     * @param regtime the value for userinvestinfo.regTime
     *
     * @ET
     */
    public void setRegtime(Date regtime) {
        this.regtime = regtime;
    }

    /**
     * This method:getNearlyinvestmoney
     * userinvestinfo.nearlyInvestMoney
     *
     * @return the value of userinvestinfo.nearlyInvestMoney
     *
     * @ET
     */
    public BigDecimal getNearlyinvestmoney() {
        return nearlyinvestmoney;
    }

    /**
     * This method:setNearlyinvestmoney
     *  userinvestinfo.nearlyInvestMoney
     *
     * @param nearlyinvestmoney the value for userinvestinfo.nearlyInvestMoney
     *
     * @ET
     */
    public void setNearlyinvestmoney(BigDecimal nearlyinvestmoney) {
        this.nearlyinvestmoney = nearlyinvestmoney;
    }

    /**
     * This method:getNearlyinvesttime
     * userinvestinfo.nearlyInvestTime
     *
     * @return the value of userinvestinfo.nearlyInvestTime
     *
     * @ET
     */
    public Date getNearlyinvesttime() {
        return nearlyinvesttime;
    }

    /**
     * This method:setNearlyinvesttime
     *  userinvestinfo.nearlyInvestTime
     *
     * @param nearlyinvesttime the value for userinvestinfo.nearlyInvestTime
     *
     * @ET
     */
    public void setNearlyinvesttime(Date nearlyinvesttime) {
        this.nearlyinvesttime = nearlyinvesttime;
    }

    /**
     * This method:getFirstinvestmoney
     * userinvestinfo.firstInvestMoney
     *
     * @return the value of userinvestinfo.firstInvestMoney
     *
     * @ET
     */
    public BigDecimal getFirstinvestmoney() {
        return firstinvestmoney;
    }

    /**
     * This method:setFirstinvestmoney
     *  userinvestinfo.firstInvestMoney
     *
     * @param firstinvestmoney the value for userinvestinfo.firstInvestMoney
     *
     * @ET
     */
    public void setFirstinvestmoney(BigDecimal firstinvestmoney) {
        this.firstinvestmoney = firstinvestmoney;
    }

    /**
     * This method:getFirstinvesttime
     * userinvestinfo.firstInvestTime
     *
     * @return the value of userinvestinfo.firstInvestTime
     *
     * @ET
     */
    public Date getFirstinvesttime() {
        return firstinvesttime;
    }

    /**
     * This method:setFirstinvesttime
     *  userinvestinfo.firstInvestTime
     *
     * @param firstinvesttime the value for userinvestinfo.firstInvestTime
     *
     * @ET
     */
    public void setFirstinvesttime(Date firstinvesttime) {
        this.firstinvesttime = firstinvesttime;
    }

    /**
     * This method:getRecommendperson
     * userinvestinfo.recommendPerson
     *
     * @return the value of userinvestinfo.recommendPerson
     *
     * @ET
     */
    public String getRecommendperson() {
        return recommendperson;
    }

    /**
     * This method:setRecommendperson
     *  userinvestinfo.recommendPerson
     *
     * @param recommendperson the value for userinvestinfo.recommendPerson
     *
     * @ET
     */
    public void setRecommendperson(String recommendperson) {
        this.recommendperson = recommendperson == null ? null : recommendperson.trim();
    }

    /**
     * This method:getRecommendcode
     * userinvestinfo.recommendCode
     *
     * @return the value of userinvestinfo.recommendCode
     *
     * @ET
     */
    public String getRecommendcode() {
        return recommendcode;
    }

    /**
     * This method:setRecommendcode
     *  userinvestinfo.recommendCode
     *
     * @param recommendcode the value for userinvestinfo.recommendCode
     *
     * @ET
     */
    public void setRecommendcode(String recommendcode) {
        this.recommendcode = recommendcode == null ? null : recommendcode.trim();
    }

    /**
     * This method:getPromotecode
     * userinvestinfo.promoteCode
     *
     * @return the value of userinvestinfo.promoteCode
     *
     * @ET
     */
    public String getPromotecode() {
        return promotecode;
    }

    /**
     * This method:setPromotecode
     *  userinvestinfo.promoteCode
     *
     * @param promotecode the value for userinvestinfo.promoteCode
     *
     * @ET
     */
    public void setPromotecode(String promotecode) {
        this.promotecode = promotecode == null ? null : promotecode.trim();
    }

    /**
     * This method:getIdentity
     * userinvestinfo.identity
     *
     * @return the value of userinvestinfo.identity
     *
     * @ET
     */
    public String getIdentity() {
        return identity;
    }

    /**
     * This method:setIdentity
     *  userinvestinfo.identity
     *
     * @param identity the value for userinvestinfo.identity
     *
     * @ET
     */
    public void setIdentity(String identity) {
        this.identity = identity == null ? null : identity.trim();
    }

    /**
     * This method:getArea
     * userinvestinfo.area
     *
     * @return the value of userinvestinfo.area
     *
     * @ET
     */
    public String getArea() {
        return area;
    }

    /**
     * This method:setArea
     *  userinvestinfo.area
     *
     * @param area the value for userinvestinfo.area
     *
     * @ET
     */
    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    /**
     * This method:getProvince
     * userinvestinfo.province
     *
     * @return the value of userinvestinfo.province
     *
     * @ET
     */
    public String getProvince() {
        return province;
    }

    /**
     * This method:setProvince
     *  userinvestinfo.province
     *
     * @param province the value for userinvestinfo.province
     *
     * @ET
     */
    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    /**
     * This method:getCity
     * userinvestinfo.city
     *
     * @return the value of userinvestinfo.city
     *
     * @ET
     */
    public String getCity() {
        return city;
    }

    /**
     * This method:setCity
     *  userinvestinfo.city
     *
     * @param city the value for userinvestinfo.city
     *
     * @ET
     */
    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    /**
     * This method:getRegion
     * userinvestinfo.region
     *
     * @return the value of userinvestinfo.region
     *
     * @ET
     */
    public String getRegion() {
        return region;
    }

    /**
     * This method:setRegion
     *  userinvestinfo.region
     *
     * @param region the value for userinvestinfo.region
     *
     * @ET
     */
    public void setRegion(String region) {
        this.region = region == null ? null : region.trim();
    }

    /**
     * This method:getGender
     * userinvestinfo.gender
     *
     * @return the value of userinvestinfo.gender
     *
     * @ET
     */
    public String getGender() {
        return gender;
    }

    /**
     * This method:setGender
     *  userinvestinfo.gender
     *
     * @param gender the value for userinvestinfo.gender
     *
     * @ET
     */
    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    /**
     * This method:getAge
     * userinvestinfo.age
     *
     * @return the value of userinvestinfo.age
     *
     * @ET
     */
    public Integer getAge() {
        return age;
    }

    /**
     * This method:setAge
     *  userinvestinfo.age
     *
     * @param age the value for userinvestinfo.age
     *
     * @ET
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * This method:getAccountbalance
     * userinvestinfo.accountBalance
     *
     * @return the value of userinvestinfo.accountBalance
     *
     * @ET
     */
    public BigDecimal getAccountbalance() {
        return accountbalance;
    }

    /**
     * This method:setAccountbalance
     *  userinvestinfo.accountBalance
     *
     * @param accountbalance the value for userinvestinfo.accountBalance
     *
     * @ET
     */
    public void setAccountbalance(BigDecimal accountbalance) {
        this.accountbalance = accountbalance;
    }

    /**
     * This method:getAddrechargemoney
     * userinvestinfo.addRechargeMoney
     *
     * @return the value of userinvestinfo.addRechargeMoney
     *
     * @ET
     */
    public BigDecimal getAddrechargemoney() {
        return addrechargemoney;
    }

    /**
     * This method:setAddrechargemoney
     *  userinvestinfo.addRechargeMoney
     *
     * @param addrechargemoney the value for userinvestinfo.addRechargeMoney
     *
     * @ET
     */
    public void setAddrechargemoney(BigDecimal addrechargemoney) {
        this.addrechargemoney = addrechargemoney;
    }

    /**
     * This method:getAddwithdrawalmoney
     * userinvestinfo.addWithdrawalMoney
     *
     * @return the value of userinvestinfo.addWithdrawalMoney
     *
     * @ET
     */
    public BigDecimal getAddwithdrawalmoney() {
        return addwithdrawalmoney;
    }

    /**
     * This method:setAddwithdrawalmoney
     *  userinvestinfo.addWithdrawalMoney
     *
     * @param addwithdrawalmoney the value for userinvestinfo.addWithdrawalMoney
     *
     * @ET
     */
    public void setAddwithdrawalmoney(BigDecimal addwithdrawalmoney) {
        this.addwithdrawalmoney = addwithdrawalmoney;
    }

    /**
     * This method:getAddinvestmoney
     * userinvestinfo.addInvestMoney
     *
     * @return the value of userinvestinfo.addInvestMoney
     *
     * @ET
     */
    public BigDecimal getAddinvestmoney() {
        return addinvestmoney;
    }

    /**
     * This method:setAddinvestmoney
     *  userinvestinfo.addInvestMoney
     *
     * @param addinvestmoney the value for userinvestinfo.addInvestMoney
     *
     * @ET
     */
    public void setAddinvestmoney(BigDecimal addinvestmoney) {
        this.addinvestmoney = addinvestmoney;
    }

    /**
     * This method:getAddinvestcnt
     * userinvestinfo.addInvestCnt
     *
     * @return the value of userinvestinfo.addInvestCnt
     *
     * @ET
     */
    public Integer getAddinvestcnt() {
        return addinvestcnt;
    }

    /**
     * This method:setAddinvestcnt
     *  userinvestinfo.addInvestCnt
     *
     * @param addinvestcnt the value for userinvestinfo.addInvestCnt
     *
     * @ET
     */
    public void setAddinvestcnt(Integer addinvestcnt) {
        this.addinvestcnt = addinvestcnt;
    }

    /**
     * This method:getZjbnum
     * userinvestinfo.ZJBNum
     *
     * @return the value of userinvestinfo.ZJBNum
     *
     * @ET
     */
    public Integer getZjbnum() {
        return zjbnum;
    }

    /**
     * This method:setZjbnum
     *  userinvestinfo.ZJBNum
     *
     * @param zjbnum the value for userinvestinfo.ZJBNum
     *
     * @ET
     */
    public void setZjbnum(Integer zjbnum) {
        this.zjbnum = zjbnum;
    }

    /**
     * This method:getRecommendregcnt
     * userinvestinfo.recommendRegCnt
     *
     * @return the value of userinvestinfo.recommendRegCnt
     *
     * @ET
     */
    public Integer getRecommendregcnt() {
        return recommendregcnt;
    }

    /**
     * This method:setRecommendregcnt
     *  userinvestinfo.recommendRegCnt
     *
     * @param recommendregcnt the value for userinvestinfo.recommendRegCnt
     *
     * @ET
     */
    public void setRecommendregcnt(Integer recommendregcnt) {
        this.recommendregcnt = recommendregcnt;
    }

    /**
     * This method:getAddlogincnt
     * userinvestinfo.addLoginCnt
     *
     * @return the value of userinvestinfo.addLoginCnt
     *
     * @ET
     */
    public Integer getAddlogincnt() {
        return addlogincnt;
    }

    /**
     * This method:setAddlogincnt
     *  userinvestinfo.addLoginCnt
     *
     * @param addlogincnt the value for userinvestinfo.addLoginCnt
     *
     * @ET
     */
    public void setAddlogincnt(Integer addlogincnt) {
        this.addlogincnt = addlogincnt;
    }

    /**
     * This method:getLastlogintime
     * userinvestinfo.lastLoginTime
     *
     * @return the value of userinvestinfo.lastLoginTime
     *
     * @ET
     */
    public Date getLastlogintime() {
        return lastlogintime;
    }

    /**
     * This method:setLastlogintime
     *  userinvestinfo.lastLoginTime
     *
     * @param lastlogintime the value for userinvestinfo.lastLoginTime
     *
     * @ET
     */
    public void setLastlogintime(Date lastlogintime) {
        this.lastlogintime = lastlogintime;
    }

    /**
     * This method:getRecord
     * userinvestinfo.record
     *
     * @return the value of userinvestinfo.record
     *
     * @ET
     */
    public String getRecord() {
        return record;
    }

    /**
     * This method:setRecord
     *  userinvestinfo.record
     *
     * @param record the value for userinvestinfo.record
     *
     * @ET
     */
    public void setRecord(String record) {
        this.record = record == null ? null : record.trim();
    }

    /**
     * This method:getCreatedate
     * userinvestinfo.createDate
     *
     * @return the value of userinvestinfo.createDate
     *
     * @ET
     */
    public Date getCreatedate() {
        return createdate;
    }

    /**
     * This method:setCreatedate
     *  userinvestinfo.createDate
     *
     * @param createdate the value for userinvestinfo.createDate
     *
     * @ET
     */
    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    /**
     * This method:getTemp1
     * userinvestinfo.temp1
     *
     * @return the value of userinvestinfo.temp1
     *
     * @ET
     */
    public String getTemp1() {
        return temp1;
    }

    /**
     * This method:setTemp1
     *  userinvestinfo.temp1
     *
     * @param temp1 the value for userinvestinfo.temp1
     *
     * @ET
     */
    public void setTemp1(String temp1) {
        this.temp1 = temp1 == null ? null : temp1.trim();
    }

    /**
     * This method:getTemp2
     * userinvestinfo.temp2
     *
     * @return the value of userinvestinfo.temp2
     *
     * @ET
     */
    public String getTemp2() {
        return temp2;
    }

    /**
     * This method:setTemp2
     *  userinvestinfo.temp2
     *
     * @param temp2 the value for userinvestinfo.temp2
     *
     * @ET
     */
    public void setTemp2(String temp2) {
        this.temp2 = temp2 == null ? null : temp2.trim();
    }

    /**
     * This method:getTemp3
     * userinvestinfo.temp3
     *
     * @return the value of userinvestinfo.temp3
     *
     * @ET
     */
    public String getTemp3() {
        return temp3;
    }

    /**
     * This method:setTemp3
     *  userinvestinfo.temp3
     *
     * @param temp3 the value for userinvestinfo.temp3
     *
     * @ET
     */
    public void setTemp3(String temp3) {
        this.temp3 = temp3 == null ? null : temp3.trim();
    }

    /**
     * This method:getTemp4
     * userinvestinfo.temp4
     *
     * @return the value of userinvestinfo.temp4
     *
     * @ET
     */
    public String getTemp4() {
        return temp4;
    }

    /**
     * This method:setTemp4
     *  userinvestinfo.temp4
     *
     * @param temp4 the value for userinvestinfo.temp4
     *
     * @ET
     */
    public void setTemp4(String temp4) {
        this.temp4 = temp4 == null ? null : temp4.trim();
    }

	public String getRegBeginTime()
	{
		return regBeginTime;
	}

	public void setRegBeginTime(String regBeginTime)
	{
		this.regBeginTime = regBeginTime;
	}

	public String getRegEndTime()
	{
		return regEndTime;
	}

	public void setRegEndTime(String regEndTime)
	{
		this.regEndTime = regEndTime;
	}

	public String getFirstInvBeginTime()
	{
		return firstInvBeginTime;
	}

	public void setFirstInvBeginTime(String firstInvBeginTime)
	{
		this.firstInvBeginTime = firstInvBeginTime;
	}

	public String getFirstInvEndTime()
	{
		return firstInvEndTime;
	}

	public void setFirstInvEndTime(String firstInvEndTime)
	{
		this.firstInvEndTime = firstInvEndTime;
	}
}