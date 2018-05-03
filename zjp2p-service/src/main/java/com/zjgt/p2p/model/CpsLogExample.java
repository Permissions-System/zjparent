package com.zjgt.p2p.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CpsLogExample
{
  protected String orderByClause;
  protected boolean distinct;
  protected List<Criteria> oredCriteria;

  public CpsLogExample()
  {
    this.oredCriteria = new ArrayList();
  }

  public void setOrderByClause(String orderByClause)
  {
    this.orderByClause = orderByClause;
  }

  public String getOrderByClause()
  {
    return this.orderByClause;
  }

  public void setDistinct(boolean distinct)
  {
    this.distinct = distinct;
  }

  public boolean isDistinct()
  {
    return this.distinct;
  }

  public List<Criteria> getOredCriteria()
  {
    return this.oredCriteria;
  }

  public void or(Criteria criteria)
  {
    this.oredCriteria.add(criteria);
  }

  public Criteria or()
  {
    Criteria criteria = createCriteriaInternal();
    this.oredCriteria.add(criteria);
    return criteria;
  }

  public Criteria createCriteria()
  {
    Criteria criteria = createCriteriaInternal();
    if (this.oredCriteria.size() == 0) {
      this.oredCriteria.add(criteria);
    }
    return criteria;
  }

  protected Criteria createCriteriaInternal()
  {
    Criteria criteria = new Criteria();
    return criteria;
  }

  public void clear()
  {
    this.oredCriteria.clear();
    this.orderByClause = null;
    this.distinct = false;
  }

  public static class Criterion
  {
    private String condition;
    private Object value;
    private Object secondValue;
    private boolean noValue;
    private boolean singleValue;
    private boolean betweenValue;
    private boolean listValue;
    private String typeHandler;

    public String getCondition()
    {
      return this.condition;
    }

    public Object getValue() {
      return this.value;
    }

    public Object getSecondValue() {
      return this.secondValue;
    }

    public boolean isNoValue() {
      return this.noValue;
    }

    public boolean isSingleValue() {
      return this.singleValue;
    }

    public boolean isBetweenValue() {
      return this.betweenValue;
    }

    public boolean isListValue() {
      return this.listValue;
    }

    public String getTypeHandler() {
      return this.typeHandler;
    }

    protected Criterion(String condition)
    {
      this.condition = condition;
      this.typeHandler = null;
      this.noValue = true;
    }

    protected Criterion(String condition, Object value, String typeHandler)
    {
      this.condition = condition;
      this.value = value;
      this.typeHandler = typeHandler;
      if (value instanceof List)
        this.listValue = true;
      else
        this.singleValue = true;
    }

    protected Criterion(String condition, Object value)
    {
      this(condition, value, null);
    }

    protected Criterion(String condition, Object value, Object secondValue, String typeHandler)
    {
      this.condition = condition;
      this.value = value;
      this.secondValue = secondValue;
      this.typeHandler = typeHandler;
      this.betweenValue = true;
    }

    protected Criterion(String condition, Object value, Object secondValue) {
      this(condition, value, secondValue, null);
    }
  }

  public static class Criteria extends CpsLogExample.GeneratedCriteria
  {
  }

  protected static abstract class GeneratedCriteria
  {
    protected List<CpsLogExample.Criterion> criteria;

    protected GeneratedCriteria()
    {
      this.criteria = new ArrayList();
    }

    public boolean isValid() {
      return (this.criteria.size() > 0);
    }

    public List<CpsLogExample.Criterion> getAllCriteria() {
      return this.criteria;
    }

    public List<CpsLogExample.Criterion> getCriteria() {
      return this.criteria;
    }

    protected void addCriterion(String condition) {
      if (condition == null) {
        throw new RuntimeException("Value for condition cannot be null");
      }
      this.criteria.add(new CpsLogExample.Criterion(condition));
    }

    protected void addCriterion(String condition, Object value, String property) {
      if (value == null) {
        throw new RuntimeException("Value for " + property + " cannot be null");
      }
      this.criteria.add(new CpsLogExample.Criterion(condition, value));
    }

    protected void addCriterion(String condition, Object value1, Object value2, String property) {
      if ((value1 == null) || (value2 == null)) {
        throw new RuntimeException("Between values for " + property + " cannot be null");
      }
      this.criteria.add(new CpsLogExample.Criterion(condition, value1, value2));
    }

    public CpsLogExample.Criteria andIdIsNull() {
      addCriterion("id is null");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andIdIsNotNull() {
      addCriterion("id is not null");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andIdEqualTo(Long value) {
      addCriterion("id =", value, "id");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andIdNotEqualTo(Long value) {
      addCriterion("id <>", value, "id");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andIdGreaterThan(Long value) {
      addCriterion("id >", value, "id");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andIdGreaterThanOrEqualTo(Long value) {
      addCriterion("id >=", value, "id");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andIdLessThan(Long value) {
      addCriterion("id <", value, "id");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andIdLessThanOrEqualTo(Long value) {
      addCriterion("id <=", value, "id");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andIdIn(List<Long> values) {
      addCriterion("id in", values, "id");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andIdNotIn(List<Long> values) {
      addCriterion("id not in", values, "id");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andIdBetween(Long value1, Long value2) {
      addCriterion("id between", value1, value2, "id");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andIdNotBetween(Long value1, Long value2) {
      addCriterion("id not between", value1, value2, "id");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andMemberidIsNull() {
      addCriterion("memberid is null");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andMemberidIsNotNull() {
      addCriterion("memberid is not null");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andMemberidEqualTo(Long value) {
      addCriterion("memberid =", value, "memberid");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andMemberidNotEqualTo(Long value) {
      addCriterion("memberid <>", value, "memberid");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andMemberidGreaterThan(Long value) {
      addCriterion("memberid >", value, "memberid");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andMemberidGreaterThanOrEqualTo(Long value) {
      addCriterion("memberid >=", value, "memberid");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andMemberidLessThan(Long value) {
      addCriterion("memberid <", value, "memberid");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andMemberidLessThanOrEqualTo(Long value) {
      addCriterion("memberid <=", value, "memberid");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andMemberidIn(List<Long> values) {
      addCriterion("memberid in", values, "memberid");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andMemberidNotIn(List<Long> values) {
      addCriterion("memberid not in", values, "memberid");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andMemberidBetween(Long value1, Long value2) {
      addCriterion("memberid between", value1, value2, "memberid");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andMemberidNotBetween(Long value1, Long value2) {
      addCriterion("memberid not between", value1, value2, "memberid");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andRealnameIsNull() {
      addCriterion("realname is null");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andRealnameIsNotNull() {
      addCriterion("realname is not null");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andRealnameEqualTo(String value) {
      addCriterion("realname =", value, "realname");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andRealnameNotEqualTo(String value) {
      addCriterion("realname <>", value, "realname");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andRealnameGreaterThan(String value) {
      addCriterion("realname >", value, "realname");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andRealnameGreaterThanOrEqualTo(String value) {
      addCriterion("realname >=", value, "realname");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andRealnameLessThan(String value) {
      addCriterion("realname <", value, "realname");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andRealnameLessThanOrEqualTo(String value) {
      addCriterion("realname <=", value, "realname");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andRealnameLike(String value) {
      addCriterion("realname like", value, "realname");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andRealnameNotLike(String value) {
      addCriterion("realname not like", value, "realname");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andRealnameIn(List<String> values) {
      addCriterion("realname in", values, "realname");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andRealnameNotIn(List<String> values) {
      addCriterion("realname not in", values, "realname");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andRealnameBetween(String value1, String value2) {
      addCriterion("realname between", value1, value2, "realname");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andRealnameNotBetween(String value1, String value2) {
      addCriterion("realname not between", value1, value2, "realname");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andMobileIsNull() {
      addCriterion("mobile is null");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andMobileIsNotNull() {
      addCriterion("mobile is not null");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andMobileEqualTo(String value) {
      addCriterion("mobile =", value, "mobile");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andMobileNotEqualTo(String value) {
      addCriterion("mobile <>", value, "mobile");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andMobileGreaterThan(String value) {
      addCriterion("mobile >", value, "mobile");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andMobileGreaterThanOrEqualTo(String value) {
      addCriterion("mobile >=", value, "mobile");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andMobileLessThan(String value) {
      addCriterion("mobile <", value, "mobile");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andMobileLessThanOrEqualTo(String value) {
      addCriterion("mobile <=", value, "mobile");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andMobileLike(String value) {
      addCriterion("mobile like", value, "mobile");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andMobileNotLike(String value) {
      addCriterion("mobile not like", value, "mobile");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andMobileIn(List<String> values) {
      addCriterion("mobile in", values, "mobile");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andMobileNotIn(List<String> values) {
      addCriterion("mobile not in", values, "mobile");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andMobileBetween(String value1, String value2) {
      addCriterion("mobile between", value1, value2, "mobile");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andMobileNotBetween(String value1, String value2) {
      addCriterion("mobile not between", value1, value2, "mobile");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andUserdistrictIsNull() {
      addCriterion("userdistrict is null");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andUserdistrictIsNotNull() {
      addCriterion("userdistrict is not null");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andUserdistrictEqualTo(String value) {
      addCriterion("userdistrict =", value, "userdistrict");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andUserdistrictNotEqualTo(String value) {
      addCriterion("userdistrict <>", value, "userdistrict");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andUserdistrictGreaterThan(String value) {
      addCriterion("userdistrict >", value, "userdistrict");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andUserdistrictGreaterThanOrEqualTo(String value) {
      addCriterion("userdistrict >=", value, "userdistrict");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andUserdistrictLessThan(String value) {
      addCriterion("userdistrict <", value, "userdistrict");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andUserdistrictLessThanOrEqualTo(String value) {
      addCriterion("userdistrict <=", value, "userdistrict");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andUserdistrictLike(String value) {
      addCriterion("userdistrict like", value, "userdistrict");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andUserdistrictNotLike(String value) {
      addCriterion("userdistrict not like", value, "userdistrict");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andUserdistrictIn(List<String> values) {
      addCriterion("userdistrict in", values, "userdistrict");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andUserdistrictNotIn(List<String> values) {
      addCriterion("userdistrict not in", values, "userdistrict");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andUserdistrictBetween(String value1, String value2) {
      addCriterion("userdistrict between", value1, value2, "userdistrict");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andUserdistrictNotBetween(String value1, String value2) {
      addCriterion("userdistrict not between", value1, value2, "userdistrict");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andAmountIsNull() {
      addCriterion("amount is null");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andAmountIsNotNull() {
      addCriterion("amount is not null");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andAmountEqualTo(BigDecimal value) {
      addCriterion("amount =", value, "amount");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andAmountNotEqualTo(BigDecimal value) {
      addCriterion("amount <>", value, "amount");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andAmountGreaterThan(BigDecimal value) {
      addCriterion("amount >", value, "amount");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andAmountGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("amount >=", value, "amount");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andAmountLessThan(BigDecimal value) {
      addCriterion("amount <", value, "amount");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andAmountLessThanOrEqualTo(BigDecimal value) {
      addCriterion("amount <=", value, "amount");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andAmountIn(List<BigDecimal> values) {
      addCriterion("amount in", values, "amount");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andAmountNotIn(List<BigDecimal> values) {
      addCriterion("amount not in", values, "amount");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andAmountBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("amount between", value1, value2, "amount");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andAmountNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("amount not between", value1, value2, "amount");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andOrderdateIsNull() {
      addCriterion("orderdate is null");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andOrderdateIsNotNull() {
      addCriterion("orderdate is not null");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andOrderdateEqualTo(Date value) {
      addCriterion("orderdate =", value, "orderdate");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andOrderdateNotEqualTo(Date value) {
      addCriterion("orderdate <>", value, "orderdate");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andOrderdateGreaterThan(Date value) {
      addCriterion("orderdate >", value, "orderdate");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andOrderdateGreaterThanOrEqualTo(Date value) {
      addCriterion("orderdate >=", value, "orderdate");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andOrderdateLessThan(Date value) {
      addCriterion("orderdate <", value, "orderdate");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andOrderdateLessThanOrEqualTo(Date value) {
      addCriterion("orderdate <=", value, "orderdate");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andOrderdateIn(List<Date> values) {
      addCriterion("orderdate in", values, "orderdate");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andOrderdateNotIn(List<Date> values) {
      addCriterion("orderdate not in", values, "orderdate");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andOrderdateBetween(Date value1, Date value2) {
      addCriterion("orderdate between", value1, value2, "orderdate");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andOrderdateNotBetween(Date value1, Date value2) {
      addCriterion("orderdate not between", value1, value2, "orderdate");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andCpsfeeIsNull() {
      addCriterion("cpsfee is null");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andCpsfeeIsNotNull() {
      addCriterion("cpsfee is not null");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andCpsfeeEqualTo(BigDecimal value) {
      addCriterion("cpsfee =", value, "cpsfee");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andCpsfeeNotEqualTo(BigDecimal value) {
      addCriterion("cpsfee <>", value, "cpsfee");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andCpsfeeGreaterThan(BigDecimal value) {
      addCriterion("cpsfee >", value, "cpsfee");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andCpsfeeGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("cpsfee >=", value, "cpsfee");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andCpsfeeLessThan(BigDecimal value) {
      addCriterion("cpsfee <", value, "cpsfee");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andCpsfeeLessThanOrEqualTo(BigDecimal value) {
      addCriterion("cpsfee <=", value, "cpsfee");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andCpsfeeIn(List<BigDecimal> values) {
      addCriterion("cpsfee in", values, "cpsfee");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andCpsfeeNotIn(List<BigDecimal> values) {
      addCriterion("cpsfee not in", values, "cpsfee");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andCpsfeeBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("cpsfee between", value1, value2, "cpsfee");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andCpsfeeNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("cpsfee not between", value1, value2, "cpsfee");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andRegdateIsNull() {
      addCriterion("regdate is null");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andRegdateIsNotNull() {
      addCriterion("regdate is not null");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andRegdateEqualTo(Date value) {
      addCriterion("regdate =", value, "regdate");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andRegdateNotEqualTo(Date value) {
      addCriterion("regdate <>", value, "regdate");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andRegdateGreaterThan(Date value) {
      addCriterion("regdate >", value, "regdate");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andRegdateGreaterThanOrEqualTo(Date value) {
      addCriterion("regdate >=", value, "regdate");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andRegdateLessThan(Date value) {
      addCriterion("regdate <", value, "regdate");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andRegdateLessThanOrEqualTo(Date value) {
      addCriterion("regdate <=", value, "regdate");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andRegdateIn(List<Date> values) {
      addCriterion("regdate in", values, "regdate");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andRegdateNotIn(List<Date> values) {
      addCriterion("regdate not in", values, "regdate");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andRegdateBetween(Date value1, Date value2) {
      addCriterion("regdate between", value1, value2, "regdate");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andRegdateNotBetween(Date value1, Date value2) {
      addCriterion("regdate not between", value1, value2, "regdate");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andLastlogindateIsNull() {
      addCriterion("lastlogindate is null");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andLastlogindateIsNotNull() {
      addCriterion("lastlogindate is not null");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andLastlogindateEqualTo(Date value) {
      addCriterion("lastlogindate =", value, "lastlogindate");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andLastlogindateNotEqualTo(Date value) {
      addCriterion("lastlogindate <>", value, "lastlogindate");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andLastlogindateGreaterThan(Date value) {
      addCriterion("lastlogindate >", value, "lastlogindate");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andLastlogindateGreaterThanOrEqualTo(Date value) {
      addCriterion("lastlogindate >=", value, "lastlogindate");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andLastlogindateLessThan(Date value) {
      addCriterion("lastlogindate <", value, "lastlogindate");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andLastlogindateLessThanOrEqualTo(Date value) {
      addCriterion("lastlogindate <=", value, "lastlogindate");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andLastlogindateIn(List<Date> values) {
      addCriterion("lastlogindate in", values, "lastlogindate");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andLastlogindateNotIn(List<Date> values) {
      addCriterion("lastlogindate not in", values, "lastlogindate");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andLastlogindateBetween(Date value1, Date value2) {
      addCriterion("lastlogindate between", value1, value2, "lastlogindate");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andLastlogindateNotBetween(Date value1, Date value2) {
      addCriterion("lastlogindate not between", value1, value2, "lastlogindate");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andRegsourceIsNull() {
      addCriterion("regsource is null");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andRegsourceIsNotNull() {
      addCriterion("regsource is not null");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andRegsourceEqualTo(Integer value) {
      addCriterion("regsource =", value, "regsource");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andRegsourceNotEqualTo(Integer value) {
      addCriterion("regsource <>", value, "regsource");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andRegsourceGreaterThan(Integer value) {
      addCriterion("regsource >", value, "regsource");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andRegsourceGreaterThanOrEqualTo(Integer value) {
      addCriterion("regsource >=", value, "regsource");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andRegsourceLessThan(Integer value) {
      addCriterion("regsource <", value, "regsource");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andRegsourceLessThanOrEqualTo(Integer value) {
      addCriterion("regsource <=", value, "regsource");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andRegsourceIn(List<Integer> values) {
      addCriterion("regsource in", values, "regsource");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andRegsourceNotIn(List<Integer> values) {
      addCriterion("regsource not in", values, "regsource");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andRegsourceBetween(Integer value1, Integer value2) {
      addCriterion("regsource between", value1, value2, "regsource");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andRegsourceNotBetween(Integer value1, Integer value2) {
      addCriterion("regsource not between", value1, value2, "regsource");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andIfexperienceIsNull() {
      addCriterion("ifexperience is null");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andIfexperienceIsNotNull() {
      addCriterion("ifexperience is not null");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andIfexperienceEqualTo(Integer value) {
      addCriterion("ifexperience =", value, "ifexperience");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andIfexperienceNotEqualTo(Integer value) {
      addCriterion("ifexperience <>", value, "ifexperience");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andIfexperienceGreaterThan(Integer value) {
      addCriterion("ifexperience >", value, "ifexperience");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andIfexperienceGreaterThanOrEqualTo(Integer value) {
      addCriterion("ifexperience >=", value, "ifexperience");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andIfexperienceLessThan(Integer value) {
      addCriterion("ifexperience <", value, "ifexperience");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andIfexperienceLessThanOrEqualTo(Integer value) {
      addCriterion("ifexperience <=", value, "ifexperience");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andIfexperienceIn(List<Integer> values) {
      addCriterion("ifexperience in", values, "ifexperience");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andIfexperienceNotIn(List<Integer> values) {
      addCriterion("ifexperience not in", values, "ifexperience");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andIfexperienceBetween(Integer value1, Integer value2) {
      addCriterion("ifexperience between", value1, value2, "ifexperience");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andIfexperienceNotBetween(Integer value1, Integer value2) {
      addCriterion("ifexperience not between", value1, value2, "ifexperience");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andChannelIsNull() {
      addCriterion("channel is null");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andChannelIsNotNull() {
      addCriterion("channel is not null");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andChannelEqualTo(String value) {
      addCriterion("channel =", value, "channel");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andChannelNotEqualTo(String value) {
      addCriterion("channel <>", value, "channel");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andChannelGreaterThan(String value) {
      addCriterion("channel >", value, "channel");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andChannelGreaterThanOrEqualTo(String value) {
      addCriterion("channel >=", value, "channel");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andChannelLessThan(String value) {
      addCriterion("channel <", value, "channel");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andChannelLessThanOrEqualTo(String value) {
      addCriterion("channel <=", value, "channel");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andChannelLike(String value) {
      addCriterion("channel like", value, "channel");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andChannelNotLike(String value) {
      addCriterion("channel not like", value, "channel");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andChannelIn(List<String> values) {
      addCriterion("channel in", values, "channel");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andChannelNotIn(List<String> values) {
      addCriterion("channel not in", values, "channel");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andChannelBetween(String value1, String value2) {
      addCriterion("channel between", value1, value2, "channel");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andChannelNotBetween(String value1, String value2) {
      addCriterion("channel not between", value1, value2, "channel");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andChannel2IsNull() {
      addCriterion("channel2 is null");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andChannel2IsNotNull() {
      addCriterion("channel2 is not null");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andChannel2EqualTo(String value) {
      addCriterion("channel2 =", value, "channel2");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andChannel2NotEqualTo(String value) {
      addCriterion("channel2 <>", value, "channel2");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andChannel2GreaterThan(String value) {
      addCriterion("channel2 >", value, "channel2");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andChannel2GreaterThanOrEqualTo(String value) {
      addCriterion("channel2 >=", value, "channel2");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andChannel2LessThan(String value) {
      addCriterion("channel2 <", value, "channel2");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andChannel2LessThanOrEqualTo(String value) {
      addCriterion("channel2 <=", value, "channel2");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andChannel2Like(String value) {
      addCriterion("channel2 like", value, "channel2");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andChannel2NotLike(String value) {
      addCriterion("channel2 not like", value, "channel2");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andChannel2In(List<String> values) {
      addCriterion("channel2 in", values, "channel2");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andChannel2NotIn(List<String> values) {
      addCriterion("channel2 not in", values, "channel2");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andChannel2Between(String value1, String value2) {
      addCriterion("channel2 between", value1, value2, "channel2");
      return ((CpsLogExample.Criteria)this);
    }

    public CpsLogExample.Criteria andChannel2NotBetween(String value1, String value2) {
      addCriterion("channel2 not between", value1, value2, "channel2");
      return ((CpsLogExample.Criteria)this);
    }
  }
}