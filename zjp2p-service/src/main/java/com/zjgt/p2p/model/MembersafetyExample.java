package com.zjgt.p2p.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MembersafetyExample
{
  protected String orderByClause;
  protected boolean distinct;
  protected List<Criteria> oredCriteria;

  public MembersafetyExample()
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

  public static class Criteria extends MembersafetyExample.GeneratedCriteria
  {
  }

  protected static abstract class GeneratedCriteria
  {
    protected List<MembersafetyExample.Criterion> criteria;

    protected GeneratedCriteria()
    {
      this.criteria = new ArrayList();
    }

    public boolean isValid() {
      return (this.criteria.size() > 0);
    }

    public List<MembersafetyExample.Criterion> getAllCriteria() {
      return this.criteria;
    }

    public List<MembersafetyExample.Criterion> getCriteria() {
      return this.criteria;
    }

    protected void addCriterion(String condition) {
      if (condition == null) {
        throw new RuntimeException("Value for condition cannot be null");
      }
      this.criteria.add(new MembersafetyExample.Criterion(condition));
    }

    protected void addCriterion(String condition, Object value, String property) {
      if (value == null) {
        throw new RuntimeException("Value for " + property + " cannot be null");
      }
      this.criteria.add(new MembersafetyExample.Criterion(condition, value));
    }

    protected void addCriterion(String condition, Object value1, Object value2, String property) {
      if ((value1 == null) || (value2 == null)) {
        throw new RuntimeException("Between values for " + property + " cannot be null");
      }
      this.criteria.add(new MembersafetyExample.Criterion(condition, value1, value2));
    }

    public MembersafetyExample.Criteria andIdIsNull() {
      addCriterion("id is null");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andIdIsNotNull() {
      addCriterion("id is not null");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andIdEqualTo(Long value) {
      addCriterion("id =", value, "id");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andIdNotEqualTo(Long value) {
      addCriterion("id <>", value, "id");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andIdGreaterThan(Long value) {
      addCriterion("id >", value, "id");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andIdGreaterThanOrEqualTo(Long value) {
      addCriterion("id >=", value, "id");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andIdLessThan(Long value) {
      addCriterion("id <", value, "id");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andIdLessThanOrEqualTo(Long value) {
      addCriterion("id <=", value, "id");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andIdIn(List<Long> values) {
      addCriterion("id in", values, "id");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andIdNotIn(List<Long> values) {
      addCriterion("id not in", values, "id");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andIdBetween(Long value1, Long value2) {
      addCriterion("id between", value1, value2, "id");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andIdNotBetween(Long value1, Long value2) {
      addCriterion("id not between", value1, value2, "id");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andMemberidIsNull() {
      addCriterion("memberid is null");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andMemberidIsNotNull() {
      addCriterion("memberid is not null");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andMemberidEqualTo(Long value) {
      addCriterion("memberid =", value, "memberid");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andMemberidNotEqualTo(Long value) {
      addCriterion("memberid <>", value, "memberid");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andMemberidGreaterThan(Long value) {
      addCriterion("memberid >", value, "memberid");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andMemberidGreaterThanOrEqualTo(Long value) {
      addCriterion("memberid >=", value, "memberid");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andMemberidLessThan(Long value) {
      addCriterion("memberid <", value, "memberid");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andMemberidLessThanOrEqualTo(Long value) {
      addCriterion("memberid <=", value, "memberid");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andMemberidIn(List<Long> values) {
      addCriterion("memberid in", values, "memberid");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andMemberidNotIn(List<Long> values) {
      addCriterion("memberid not in", values, "memberid");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andMemberidBetween(Long value1, Long value2) {
      addCriterion("memberid between", value1, value2, "memberid");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andMemberidNotBetween(Long value1, Long value2) {
      addCriterion("memberid not between", value1, value2, "memberid");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andRealnameIsNull() {
      addCriterion("realname is null");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andRealnameIsNotNull() {
      addCriterion("realname is not null");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andRealnameEqualTo(String value) {
      addCriterion("realname =", value, "realname");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andRealnameNotEqualTo(String value) {
      addCriterion("realname <>", value, "realname");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andRealnameGreaterThan(String value) {
      addCriterion("realname >", value, "realname");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andRealnameGreaterThanOrEqualTo(String value) {
      addCriterion("realname >=", value, "realname");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andRealnameLessThan(String value) {
      addCriterion("realname <", value, "realname");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andRealnameLessThanOrEqualTo(String value) {
      addCriterion("realname <=", value, "realname");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andRealnameLike(String value) {
      addCriterion("realname like", value, "realname");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andRealnameNotLike(String value) {
      addCriterion("realname not like", value, "realname");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andRealnameIn(List<String> values) {
      addCriterion("realname in", values, "realname");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andRealnameNotIn(List<String> values) {
      addCriterion("realname not in", values, "realname");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andRealnameBetween(String value1, String value2) {
      addCriterion("realname between", value1, value2, "realname");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andRealnameNotBetween(String value1, String value2) {
      addCriterion("realname not between", value1, value2, "realname");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andMobileIsNull() {
      addCriterion("mobile is null");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andMobileIsNotNull() {
      addCriterion("mobile is not null");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andMobileEqualTo(String value) {
      addCriterion("mobile =", value, "mobile");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andMobileNotEqualTo(String value) {
      addCriterion("mobile <>", value, "mobile");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andMobileGreaterThan(String value) {
      addCriterion("mobile >", value, "mobile");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andMobileGreaterThanOrEqualTo(String value) {
      addCriterion("mobile >=", value, "mobile");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andMobileLessThan(String value) {
      addCriterion("mobile <", value, "mobile");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andMobileLessThanOrEqualTo(String value) {
      addCriterion("mobile <=", value, "mobile");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andMobileLike(String value) {
      addCriterion("mobile like", value, "mobile");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andMobileNotLike(String value) {
      addCriterion("mobile not like", value, "mobile");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andMobileIn(List<String> values) {
      addCriterion("mobile in", values, "mobile");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andMobileNotIn(List<String> values) {
      addCriterion("mobile not in", values, "mobile");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andMobileBetween(String value1, String value2) {
      addCriterion("mobile between", value1, value2, "mobile");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andMobileNotBetween(String value1, String value2) {
      addCriterion("mobile not between", value1, value2, "mobile");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andMobileifverifiedIsNull() {
      addCriterion("mobileifverified is null");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andMobileifverifiedIsNotNull() {
      addCriterion("mobileifverified is not null");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andMobileifverifiedEqualTo(Integer value) {
      addCriterion("mobileifverified =", value, "mobileifverified");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andMobileifverifiedNotEqualTo(Integer value) {
      addCriterion("mobileifverified <>", value, "mobileifverified");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andMobileifverifiedGreaterThan(Integer value) {
      addCriterion("mobileifverified >", value, "mobileifverified");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andMobileifverifiedGreaterThanOrEqualTo(Integer value) {
      addCriterion("mobileifverified >=", value, "mobileifverified");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andMobileifverifiedLessThan(Integer value) {
      addCriterion("mobileifverified <", value, "mobileifverified");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andMobileifverifiedLessThanOrEqualTo(Integer value) {
      addCriterion("mobileifverified <=", value, "mobileifverified");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andMobileifverifiedIn(List<Integer> values) {
      addCriterion("mobileifverified in", values, "mobileifverified");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andMobileifverifiedNotIn(List<Integer> values) {
      addCriterion("mobileifverified not in", values, "mobileifverified");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andMobileifverifiedBetween(Integer value1, Integer value2) {
      addCriterion("mobileifverified between", value1, value2, "mobileifverified");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andMobileifverifiedNotBetween(Integer value1, Integer value2) {
      addCriterion("mobileifverified not between", value1, value2, "mobileifverified");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andMobileifverifydateIsNull() {
      addCriterion("mobileifverifydate is null");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andMobileifverifydateIsNotNull() {
      addCriterion("mobileifverifydate is not null");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andMobileifverifydateEqualTo(Date value) {
      addCriterion("mobileifverifydate =", value, "mobileifverifydate");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andMobileifverifydateNotEqualTo(Date value) {
      addCriterion("mobileifverifydate <>", value, "mobileifverifydate");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andMobileifverifydateGreaterThan(Date value) {
      addCriterion("mobileifverifydate >", value, "mobileifverifydate");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andMobileifverifydateGreaterThanOrEqualTo(Date value) {
      addCriterion("mobileifverifydate >=", value, "mobileifverifydate");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andMobileifverifydateLessThan(Date value) {
      addCriterion("mobileifverifydate <", value, "mobileifverifydate");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andMobileifverifydateLessThanOrEqualTo(Date value) {
      addCriterion("mobileifverifydate <=", value, "mobileifverifydate");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andMobileifverifydateIn(List<Date> values) {
      addCriterion("mobileifverifydate in", values, "mobileifverifydate");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andMobileifverifydateNotIn(List<Date> values) {
      addCriterion("mobileifverifydate not in", values, "mobileifverifydate");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andMobileifverifydateBetween(Date value1, Date value2) {
      addCriterion("mobileifverifydate between", value1, value2, "mobileifverifydate");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andMobileifverifydateNotBetween(Date value1, Date value2) {
      addCriterion("mobileifverifydate not between", value1, value2, "mobileifverifydate");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andIdcardIsNull() {
      addCriterion("idcard is null");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andIdcardIsNotNull() {
      addCriterion("idcard is not null");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andIdcardEqualTo(String value) {
      addCriterion("idcard =", value, "idcard");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andIdcardNotEqualTo(String value) {
      addCriterion("idcard <>", value, "idcard");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andIdcardGreaterThan(String value) {
      addCriterion("idcard >", value, "idcard");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andIdcardGreaterThanOrEqualTo(String value) {
      addCriterion("idcard >=", value, "idcard");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andIdcardLessThan(String value) {
      addCriterion("idcard <", value, "idcard");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andIdcardLessThanOrEqualTo(String value) {
      addCriterion("idcard <=", value, "idcard");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andIdcardLike(String value) {
      addCriterion("idcard like", value, "idcard");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andIdcardNotLike(String value) {
      addCriterion("idcard not like", value, "idcard");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andIdcardIn(List<String> values) {
      addCriterion("idcard in", values, "idcard");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andIdcardNotIn(List<String> values) {
      addCriterion("idcard not in", values, "idcard");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andIdcardBetween(String value1, String value2) {
      addCriterion("idcard between", value1, value2, "idcard");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andIdcardNotBetween(String value1, String value2) {
      addCriterion("idcard not between", value1, value2, "idcard");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andIdcardifverifiedIsNull() {
      addCriterion("idcardifverified is null");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andIdcardifverifiedIsNotNull() {
      addCriterion("idcardifverified is not null");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andIdcardifverifiedEqualTo(Integer value) {
      addCriterion("idcardifverified =", value, "idcardifverified");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andIdcardifverifiedNotEqualTo(Integer value) {
      addCriterion("idcardifverified <>", value, "idcardifverified");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andIdcardifverifiedGreaterThan(Integer value) {
      addCriterion("idcardifverified >", value, "idcardifverified");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andIdcardifverifiedGreaterThanOrEqualTo(Integer value) {
      addCriterion("idcardifverified >=", value, "idcardifverified");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andIdcardifverifiedLessThan(Integer value) {
      addCriterion("idcardifverified <", value, "idcardifverified");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andIdcardifverifiedLessThanOrEqualTo(Integer value) {
      addCriterion("idcardifverified <=", value, "idcardifverified");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andIdcardifverifiedIn(List<Integer> values) {
      addCriterion("idcardifverified in", values, "idcardifverified");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andIdcardifverifiedNotIn(List<Integer> values) {
      addCriterion("idcardifverified not in", values, "idcardifverified");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andIdcardifverifiedBetween(Integer value1, Integer value2) {
      addCriterion("idcardifverified between", value1, value2, "idcardifverified");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andIdcardifverifiedNotBetween(Integer value1, Integer value2) {
      addCriterion("idcardifverified not between", value1, value2, "idcardifverified");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andIdcardverifydateIsNull() {
      addCriterion("idcardverifydate is null");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andIdcardverifydateIsNotNull() {
      addCriterion("idcardverifydate is not null");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andIdcardverifydateEqualTo(Date value) {
      addCriterion("idcardverifydate =", value, "idcardverifydate");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andIdcardverifydateNotEqualTo(Date value) {
      addCriterion("idcardverifydate <>", value, "idcardverifydate");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andIdcardverifydateGreaterThan(Date value) {
      addCriterion("idcardverifydate >", value, "idcardverifydate");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andIdcardverifydateGreaterThanOrEqualTo(Date value) {
      addCriterion("idcardverifydate >=", value, "idcardverifydate");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andIdcardverifydateLessThan(Date value) {
      addCriterion("idcardverifydate <", value, "idcardverifydate");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andIdcardverifydateLessThanOrEqualTo(Date value) {
      addCriterion("idcardverifydate <=", value, "idcardverifydate");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andIdcardverifydateIn(List<Date> values) {
      addCriterion("idcardverifydate in", values, "idcardverifydate");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andIdcardverifydateNotIn(List<Date> values) {
      addCriterion("idcardverifydate not in", values, "idcardverifydate");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andIdcardverifydateBetween(Date value1, Date value2) {
      addCriterion("idcardverifydate between", value1, value2, "idcardverifydate");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andIdcardverifydateNotBetween(Date value1, Date value2) {
      addCriterion("idcardverifydate not between", value1, value2, "idcardverifydate");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andEmailIsNull() {
      addCriterion("email is null");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andEmailIsNotNull() {
      addCriterion("email is not null");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andEmailEqualTo(String value) {
      addCriterion("email =", value, "email");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andEmailNotEqualTo(String value) {
      addCriterion("email <>", value, "email");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andEmailGreaterThan(String value) {
      addCriterion("email >", value, "email");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andEmailGreaterThanOrEqualTo(String value) {
      addCriterion("email >=", value, "email");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andEmailLessThan(String value) {
      addCriterion("email <", value, "email");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andEmailLessThanOrEqualTo(String value) {
      addCriterion("email <=", value, "email");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andEmailLike(String value) {
      addCriterion("email like", value, "email");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andEmailNotLike(String value) {
      addCriterion("email not like", value, "email");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andEmailIn(List<String> values) {
      addCriterion("email in", values, "email");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andEmailNotIn(List<String> values) {
      addCriterion("email not in", values, "email");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andEmailBetween(String value1, String value2) {
      addCriterion("email between", value1, value2, "email");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andEmailNotBetween(String value1, String value2) {
      addCriterion("email not between", value1, value2, "email");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andEmailifverifiedIsNull() {
      addCriterion("emailifverified is null");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andEmailifverifiedIsNotNull() {
      addCriterion("emailifverified is not null");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andEmailifverifiedEqualTo(Integer value) {
      addCriterion("emailifverified =", value, "emailifverified");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andEmailifverifiedNotEqualTo(Integer value) {
      addCriterion("emailifverified <>", value, "emailifverified");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andEmailifverifiedGreaterThan(Integer value) {
      addCriterion("emailifverified >", value, "emailifverified");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andEmailifverifiedGreaterThanOrEqualTo(Integer value) {
      addCriterion("emailifverified >=", value, "emailifverified");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andEmailifverifiedLessThan(Integer value) {
      addCriterion("emailifverified <", value, "emailifverified");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andEmailifverifiedLessThanOrEqualTo(Integer value) {
      addCriterion("emailifverified <=", value, "emailifverified");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andEmailifverifiedIn(List<Integer> values) {
      addCriterion("emailifverified in", values, "emailifverified");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andEmailifverifiedNotIn(List<Integer> values) {
      addCriterion("emailifverified not in", values, "emailifverified");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andEmailifverifiedBetween(Integer value1, Integer value2) {
      addCriterion("emailifverified between", value1, value2, "emailifverified");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andEmailifverifiedNotBetween(Integer value1, Integer value2) {
      addCriterion("emailifverified not between", value1, value2, "emailifverified");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andEmailverifyuuidIsNull() {
      addCriterion("emailverifyuuid is null");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andEmailverifyuuidIsNotNull() {
      addCriterion("emailverifyuuid is not null");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andEmailverifyuuidEqualTo(String value) {
      addCriterion("emailverifyuuid =", value, "emailverifyuuid");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andEmailverifyuuidNotEqualTo(String value) {
      addCriterion("emailverifyuuid <>", value, "emailverifyuuid");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andEmailverifyuuidGreaterThan(String value) {
      addCriterion("emailverifyuuid >", value, "emailverifyuuid");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andEmailverifyuuidGreaterThanOrEqualTo(String value) {
      addCriterion("emailverifyuuid >=", value, "emailverifyuuid");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andEmailverifyuuidLessThan(String value) {
      addCriterion("emailverifyuuid <", value, "emailverifyuuid");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andEmailverifyuuidLessThanOrEqualTo(String value) {
      addCriterion("emailverifyuuid <=", value, "emailverifyuuid");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andEmailverifyuuidLike(String value) {
      addCriterion("emailverifyuuid like", value, "emailverifyuuid");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andEmailverifyuuidNotLike(String value) {
      addCriterion("emailverifyuuid not like", value, "emailverifyuuid");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andEmailverifyuuidIn(List<String> values) {
      addCriterion("emailverifyuuid in", values, "emailverifyuuid");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andEmailverifyuuidNotIn(List<String> values) {
      addCriterion("emailverifyuuid not in", values, "emailverifyuuid");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andEmailverifyuuidBetween(String value1, String value2) {
      addCriterion("emailverifyuuid between", value1, value2, "emailverifyuuid");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andEmailverifyuuidNotBetween(String value1, String value2) {
      addCriterion("emailverifyuuid not between", value1, value2, "emailverifyuuid");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andEmailverifydateIsNull() {
      addCriterion("emailverifydate is null");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andEmailverifydateIsNotNull() {
      addCriterion("emailverifydate is not null");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andEmailverifydateEqualTo(Date value) {
      addCriterion("emailverifydate =", value, "emailverifydate");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andEmailverifydateNotEqualTo(Date value) {
      addCriterion("emailverifydate <>", value, "emailverifydate");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andEmailverifydateGreaterThan(Date value) {
      addCriterion("emailverifydate >", value, "emailverifydate");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andEmailverifydateGreaterThanOrEqualTo(Date value) {
      addCriterion("emailverifydate >=", value, "emailverifydate");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andEmailverifydateLessThan(Date value) {
      addCriterion("emailverifydate <", value, "emailverifydate");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andEmailverifydateLessThanOrEqualTo(Date value) {
      addCriterion("emailverifydate <=", value, "emailverifydate");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andEmailverifydateIn(List<Date> values) {
      addCriterion("emailverifydate in", values, "emailverifydate");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andEmailverifydateNotIn(List<Date> values) {
      addCriterion("emailverifydate not in", values, "emailverifydate");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andEmailverifydateBetween(Date value1, Date value2) {
      addCriterion("emailverifydate between", value1, value2, "emailverifydate");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andEmailverifydateNotBetween(Date value1, Date value2) {
      addCriterion("emailverifydate not between", value1, value2, "emailverifydate");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andBankcardifverifiedIsNull() {
      addCriterion("bankcardifverified is null");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andBankcardifverifiedIsNotNull() {
      addCriterion("bankcardifverified is not null");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andBankcardifverifiedEqualTo(Integer value) {
      addCriterion("bankcardifverified =", value, "bankcardifverified");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andBankcardifverifiedNotEqualTo(Integer value) {
      addCriterion("bankcardifverified <>", value, "bankcardifverified");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andBankcardifverifiedGreaterThan(Integer value) {
      addCriterion("bankcardifverified >", value, "bankcardifverified");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andBankcardifverifiedGreaterThanOrEqualTo(Integer value) {
      addCriterion("bankcardifverified >=", value, "bankcardifverified");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andBankcardifverifiedLessThan(Integer value) {
      addCriterion("bankcardifverified <", value, "bankcardifverified");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andBankcardifverifiedLessThanOrEqualTo(Integer value) {
      addCriterion("bankcardifverified <=", value, "bankcardifverified");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andBankcardifverifiedIn(List<Integer> values) {
      addCriterion("bankcardifverified in", values, "bankcardifverified");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andBankcardifverifiedNotIn(List<Integer> values) {
      addCriterion("bankcardifverified not in", values, "bankcardifverified");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andBankcardifverifiedBetween(Integer value1, Integer value2) {
      addCriterion("bankcardifverified between", value1, value2, "bankcardifverified");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andBankcardifverifiedNotBetween(Integer value1, Integer value2) {
      addCriterion("bankcardifverified not between", value1, value2, "bankcardifverified");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andBanknameIsNull() {
      addCriterion("bankname is null");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andBanknameIsNotNull() {
      addCriterion("bankname is not null");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andBanknameEqualTo(String value) {
      addCriterion("bankname =", value, "bankname");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andBanknameNotEqualTo(String value) {
      addCriterion("bankname <>", value, "bankname");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andBanknameGreaterThan(String value) {
      addCriterion("bankname >", value, "bankname");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andBanknameGreaterThanOrEqualTo(String value) {
      addCriterion("bankname >=", value, "bankname");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andBanknameLessThan(String value) {
      addCriterion("bankname <", value, "bankname");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andBanknameLessThanOrEqualTo(String value) {
      addCriterion("bankname <=", value, "bankname");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andBanknameLike(String value) {
      addCriterion("bankname like", value, "bankname");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andBanknameNotLike(String value) {
      addCriterion("bankname not like", value, "bankname");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andBanknameIn(List<String> values) {
      addCriterion("bankname in", values, "bankname");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andBanknameNotIn(List<String> values) {
      addCriterion("bankname not in", values, "bankname");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andBanknameBetween(String value1, String value2) {
      addCriterion("bankname between", value1, value2, "bankname");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andBanknameNotBetween(String value1, String value2) {
      addCriterion("bankname not between", value1, value2, "bankname");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andBankprinceIsNull() {
      addCriterion("bankprince is null");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andBankprinceIsNotNull() {
      addCriterion("bankprince is not null");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andBankprinceEqualTo(String value) {
      addCriterion("bankprince =", value, "bankprince");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andBankprinceNotEqualTo(String value) {
      addCriterion("bankprince <>", value, "bankprince");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andBankprinceGreaterThan(String value) {
      addCriterion("bankprince >", value, "bankprince");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andBankprinceGreaterThanOrEqualTo(String value) {
      addCriterion("bankprince >=", value, "bankprince");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andBankprinceLessThan(String value) {
      addCriterion("bankprince <", value, "bankprince");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andBankprinceLessThanOrEqualTo(String value) {
      addCriterion("bankprince <=", value, "bankprince");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andBankprinceLike(String value) {
      addCriterion("bankprince like", value, "bankprince");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andBankprinceNotLike(String value) {
      addCriterion("bankprince not like", value, "bankprince");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andBankprinceIn(List<String> values) {
      addCriterion("bankprince in", values, "bankprince");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andBankprinceNotIn(List<String> values) {
      addCriterion("bankprince not in", values, "bankprince");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andBankprinceBetween(String value1, String value2) {
      addCriterion("bankprince between", value1, value2, "bankprince");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andBankprinceNotBetween(String value1, String value2) {
      addCriterion("bankprince not between", value1, value2, "bankprince");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andBankcityIsNull() {
      addCriterion("bankcity is null");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andBankcityIsNotNull() {
      addCriterion("bankcity is not null");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andBankcityEqualTo(String value) {
      addCriterion("bankcity =", value, "bankcity");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andBankcityNotEqualTo(String value) {
      addCriterion("bankcity <>", value, "bankcity");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andBankcityGreaterThan(String value) {
      addCriterion("bankcity >", value, "bankcity");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andBankcityGreaterThanOrEqualTo(String value) {
      addCriterion("bankcity >=", value, "bankcity");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andBankcityLessThan(String value) {
      addCriterion("bankcity <", value, "bankcity");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andBankcityLessThanOrEqualTo(String value) {
      addCriterion("bankcity <=", value, "bankcity");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andBankcityLike(String value) {
      addCriterion("bankcity like", value, "bankcity");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andBankcityNotLike(String value) {
      addCriterion("bankcity not like", value, "bankcity");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andBankcityIn(List<String> values) {
      addCriterion("bankcity in", values, "bankcity");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andBankcityNotIn(List<String> values) {
      addCriterion("bankcity not in", values, "bankcity");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andBankcityBetween(String value1, String value2) {
      addCriterion("bankcity between", value1, value2, "bankcity");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andBankcityNotBetween(String value1, String value2) {
      addCriterion("bankcity not between", value1, value2, "bankcity");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andBankinfoIsNull() {
      addCriterion("bankinfo is null");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andBankinfoIsNotNull() {
      addCriterion("bankinfo is not null");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andBankinfoEqualTo(String value) {
      addCriterion("bankinfo =", value, "bankinfo");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andBankinfoNotEqualTo(String value) {
      addCriterion("bankinfo <>", value, "bankinfo");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andBankinfoGreaterThan(String value) {
      addCriterion("bankinfo >", value, "bankinfo");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andBankinfoGreaterThanOrEqualTo(String value) {
      addCriterion("bankinfo >=", value, "bankinfo");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andBankinfoLessThan(String value) {
      addCriterion("bankinfo <", value, "bankinfo");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andBankinfoLessThanOrEqualTo(String value) {
      addCriterion("bankinfo <=", value, "bankinfo");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andBankinfoLike(String value) {
      addCriterion("bankinfo like", value, "bankinfo");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andBankinfoNotLike(String value) {
      addCriterion("bankinfo not like", value, "bankinfo");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andBankinfoIn(List<String> values) {
      addCriterion("bankinfo in", values, "bankinfo");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andBankinfoNotIn(List<String> values) {
      addCriterion("bankinfo not in", values, "bankinfo");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andBankinfoBetween(String value1, String value2) {
      addCriterion("bankinfo between", value1, value2, "bankinfo");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andBankinfoNotBetween(String value1, String value2) {
      addCriterion("bankinfo not between", value1, value2, "bankinfo");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andBankcardnoIsNull() {
      addCriterion("bankcardno is null");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andBankcardnoIsNotNull() {
      addCriterion("bankcardno is not null");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andBankcardnoEqualTo(String value) {
      addCriterion("bankcardno =", value, "bankcardno");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andBankcardnoNotEqualTo(String value) {
      addCriterion("bankcardno <>", value, "bankcardno");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andBankcardnoGreaterThan(String value) {
      addCriterion("bankcardno >", value, "bankcardno");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andBankcardnoGreaterThanOrEqualTo(String value) {
      addCriterion("bankcardno >=", value, "bankcardno");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andBankcardnoLessThan(String value) {
      addCriterion("bankcardno <", value, "bankcardno");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andBankcardnoLessThanOrEqualTo(String value) {
      addCriterion("bankcardno <=", value, "bankcardno");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andBankcardnoLike(String value) {
      addCriterion("bankcardno like", value, "bankcardno");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andBankcardnoNotLike(String value) {
      addCriterion("bankcardno not like", value, "bankcardno");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andBankcardnoIn(List<String> values) {
      addCriterion("bankcardno in", values, "bankcardno");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andBankcardnoNotIn(List<String> values) {
      addCriterion("bankcardno not in", values, "bankcardno");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andBankcardnoBetween(String value1, String value2) {
      addCriterion("bankcardno between", value1, value2, "bankcardno");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andBankcardnoNotBetween(String value1, String value2) {
      addCriterion("bankcardno not between", value1, value2, "bankcardno");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andBankcodeIsNull() {
      addCriterion("bankcode is null");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andBankcodeIsNotNull() {
      addCriterion("bankcode is not null");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andBankcodeEqualTo(String value) {
      addCriterion("bankcode =", value, "bankcode");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andBankcodeNotEqualTo(String value) {
      addCriterion("bankcode <>", value, "bankcode");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andBankcodeGreaterThan(String value) {
      addCriterion("bankcode >", value, "bankcode");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andBankcodeGreaterThanOrEqualTo(String value) {
      addCriterion("bankcode >=", value, "bankcode");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andBankcodeLessThan(String value) {
      addCriterion("bankcode <", value, "bankcode");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andBankcodeLessThanOrEqualTo(String value) {
      addCriterion("bankcode <=", value, "bankcode");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andBankcodeLike(String value) {
      addCriterion("bankcode like", value, "bankcode");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andBankcodeNotLike(String value) {
      addCriterion("bankcode not like", value, "bankcode");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andBankcodeIn(List<String> values) {
      addCriterion("bankcode in", values, "bankcode");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andBankcodeNotIn(List<String> values) {
      addCriterion("bankcode not in", values, "bankcode");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andBankcodeBetween(String value1, String value2) {
      addCriterion("bankcode between", value1, value2, "bankcode");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andBankcodeNotBetween(String value1, String value2) {
      addCriterion("bankcode not between", value1, value2, "bankcode");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andBankverifydateIsNull() {
      addCriterion("bankverifydate is null");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andBankverifydateIsNotNull() {
      addCriterion("bankverifydate is not null");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andBankverifydateEqualTo(Date value) {
      addCriterion("bankverifydate =", value, "bankverifydate");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andBankverifydateNotEqualTo(Date value) {
      addCriterion("bankverifydate <>", value, "bankverifydate");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andBankverifydateGreaterThan(Date value) {
      addCriterion("bankverifydate >", value, "bankverifydate");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andBankverifydateGreaterThanOrEqualTo(Date value) {
      addCriterion("bankverifydate >=", value, "bankverifydate");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andBankverifydateLessThan(Date value) {
      addCriterion("bankverifydate <", value, "bankverifydate");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andBankverifydateLessThanOrEqualTo(Date value) {
      addCriterion("bankverifydate <=", value, "bankverifydate");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andBankverifydateIn(List<Date> values) {
      addCriterion("bankverifydate in", values, "bankverifydate");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andBankverifydateNotIn(List<Date> values) {
      addCriterion("bankverifydate not in", values, "bankverifydate");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andBankverifydateBetween(Date value1, Date value2) {
      addCriterion("bankverifydate between", value1, value2, "bankverifydate");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andBankverifydateNotBetween(Date value1, Date value2) {
      addCriterion("bankverifydate not between", value1, value2, "bankverifydate");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andTranspasswdIsNull() {
      addCriterion("transpasswd is null");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andTranspasswdIsNotNull() {
      addCriterion("transpasswd is not null");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andTranspasswdEqualTo(String value) {
      addCriterion("transpasswd =", value, "transpasswd");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andTranspasswdNotEqualTo(String value) {
      addCriterion("transpasswd <>", value, "transpasswd");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andTranspasswdGreaterThan(String value) {
      addCriterion("transpasswd >", value, "transpasswd");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andTranspasswdGreaterThanOrEqualTo(String value) {
      addCriterion("transpasswd >=", value, "transpasswd");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andTranspasswdLessThan(String value) {
      addCriterion("transpasswd <", value, "transpasswd");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andTranspasswdLessThanOrEqualTo(String value) {
      addCriterion("transpasswd <=", value, "transpasswd");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andTranspasswdLike(String value) {
      addCriterion("transpasswd like", value, "transpasswd");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andTranspasswdNotLike(String value) {
      addCriterion("transpasswd not like", value, "transpasswd");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andTranspasswdIn(List<String> values) {
      addCriterion("transpasswd in", values, "transpasswd");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andTranspasswdNotIn(List<String> values) {
      addCriterion("transpasswd not in", values, "transpasswd");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andTranspasswdBetween(String value1, String value2) {
      addCriterion("transpasswd between", value1, value2, "transpasswd");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andTranspasswdNotBetween(String value1, String value2) {
      addCriterion("transpasswd not between", value1, value2, "transpasswd");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andTranspasswdverifiedIsNull() {
      addCriterion("transpasswdverified is null");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andTranspasswdverifiedIsNotNull() {
      addCriterion("transpasswdverified is not null");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andTranspasswdverifiedEqualTo(Integer value) {
      addCriterion("transpasswdverified =", value, "transpasswdverified");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andTranspasswdverifiedNotEqualTo(Integer value) {
      addCriterion("transpasswdverified <>", value, "transpasswdverified");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andTranspasswdverifiedGreaterThan(Integer value) {
      addCriterion("transpasswdverified >", value, "transpasswdverified");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andTranspasswdverifiedGreaterThanOrEqualTo(Integer value) {
      addCriterion("transpasswdverified >=", value, "transpasswdverified");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andTranspasswdverifiedLessThan(Integer value) {
      addCriterion("transpasswdverified <", value, "transpasswdverified");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andTranspasswdverifiedLessThanOrEqualTo(Integer value) {
      addCriterion("transpasswdverified <=", value, "transpasswdverified");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andTranspasswdverifiedIn(List<Integer> values) {
      addCriterion("transpasswdverified in", values, "transpasswdverified");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andTranspasswdverifiedNotIn(List<Integer> values) {
      addCriterion("transpasswdverified not in", values, "transpasswdverified");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andTranspasswdverifiedBetween(Integer value1, Integer value2) {
      addCriterion("transpasswdverified between", value1, value2, "transpasswdverified");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andTranspasswdverifiedNotBetween(Integer value1, Integer value2) {
      addCriterion("transpasswdverified not between", value1, value2, "transpasswdverified");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andRemarkIsNull() {
      addCriterion("remark is null");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andRemarkIsNotNull() {
      addCriterion("remark is not null");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andRemarkEqualTo(String value) {
      addCriterion("remark =", value, "remark");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andRemarkNotEqualTo(String value) {
      addCriterion("remark <>", value, "remark");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andRemarkGreaterThan(String value) {
      addCriterion("remark >", value, "remark");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andRemarkGreaterThanOrEqualTo(String value) {
      addCriterion("remark >=", value, "remark");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andRemarkLessThan(String value) {
      addCriterion("remark <", value, "remark");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andRemarkLessThanOrEqualTo(String value) {
      addCriterion("remark <=", value, "remark");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andRemarkLike(String value) {
      addCriterion("remark like", value, "remark");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andRemarkNotLike(String value) {
      addCriterion("remark not like", value, "remark");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andRemarkIn(List<String> values) {
      addCriterion("remark in", values, "remark");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andRemarkNotIn(List<String> values) {
      addCriterion("remark not in", values, "remark");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andRemarkBetween(String value1, String value2) {
      addCriterion("remark between", value1, value2, "remark");
      return ((MembersafetyExample.Criteria)this);
    }

    public MembersafetyExample.Criteria andRemarkNotBetween(String value1, String value2) {
      addCriterion("remark not between", value1, value2, "remark");
      return ((MembersafetyExample.Criteria)this);
    }
  }
}