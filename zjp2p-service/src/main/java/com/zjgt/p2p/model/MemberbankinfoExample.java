package com.zjgt.p2p.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MemberbankinfoExample
{
  protected String orderByClause;
  protected boolean distinct;
  protected List<Criteria> oredCriteria;

  public MemberbankinfoExample()
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

  public static class Criteria extends MemberbankinfoExample.GeneratedCriteria
  {
  }

  protected static abstract class GeneratedCriteria
  {
    protected List<MemberbankinfoExample.Criterion> criteria;

    protected GeneratedCriteria()
    {
      this.criteria = new ArrayList();
    }

    public boolean isValid() {
      return (this.criteria.size() > 0);
    }

    public List<MemberbankinfoExample.Criterion> getAllCriteria() {
      return this.criteria;
    }

    public List<MemberbankinfoExample.Criterion> getCriteria() {
      return this.criteria;
    }

    protected void addCriterion(String condition) {
      if (condition == null) {
        throw new RuntimeException("Value for condition cannot be null");
      }
      this.criteria.add(new MemberbankinfoExample.Criterion(condition));
    }

    protected void addCriterion(String condition, Object value, String property) {
      if (value == null) {
        throw new RuntimeException("Value for " + property + " cannot be null");
      }
      this.criteria.add(new MemberbankinfoExample.Criterion(condition, value));
    }

    protected void addCriterion(String condition, Object value1, Object value2, String property) {
      if ((value1 == null) || (value2 == null)) {
        throw new RuntimeException("Between values for " + property + " cannot be null");
      }
      this.criteria.add(new MemberbankinfoExample.Criterion(condition, value1, value2));
    }

    public MemberbankinfoExample.Criteria andIdIsNull() {
      addCriterion("id is null");
      return ((MemberbankinfoExample.Criteria)this);
    }

    public MemberbankinfoExample.Criteria andIdIsNotNull() {
      addCriterion("id is not null");
      return ((MemberbankinfoExample.Criteria)this);
    }

    public MemberbankinfoExample.Criteria andIdEqualTo(Long value) {
      addCriterion("id =", value, "id");
      return ((MemberbankinfoExample.Criteria)this);
    }

    public MemberbankinfoExample.Criteria andIdNotEqualTo(Long value) {
      addCriterion("id <>", value, "id");
      return ((MemberbankinfoExample.Criteria)this);
    }

    public MemberbankinfoExample.Criteria andIdGreaterThan(Long value) {
      addCriterion("id >", value, "id");
      return ((MemberbankinfoExample.Criteria)this);
    }

    public MemberbankinfoExample.Criteria andIdGreaterThanOrEqualTo(Long value) {
      addCriterion("id >=", value, "id");
      return ((MemberbankinfoExample.Criteria)this);
    }

    public MemberbankinfoExample.Criteria andIdLessThan(Long value) {
      addCriterion("id <", value, "id");
      return ((MemberbankinfoExample.Criteria)this);
    }

    public MemberbankinfoExample.Criteria andIdLessThanOrEqualTo(Long value) {
      addCriterion("id <=", value, "id");
      return ((MemberbankinfoExample.Criteria)this);
    }

    public MemberbankinfoExample.Criteria andIdIn(List<Long> values) {
      addCriterion("id in", values, "id");
      return ((MemberbankinfoExample.Criteria)this);
    }

    public MemberbankinfoExample.Criteria andIdNotIn(List<Long> values) {
      addCriterion("id not in", values, "id");
      return ((MemberbankinfoExample.Criteria)this);
    }

    public MemberbankinfoExample.Criteria andIdBetween(Long value1, Long value2) {
      addCriterion("id between", value1, value2, "id");
      return ((MemberbankinfoExample.Criteria)this);
    }

    public MemberbankinfoExample.Criteria andIdNotBetween(Long value1, Long value2) {
      addCriterion("id not between", value1, value2, "id");
      return ((MemberbankinfoExample.Criteria)this);
    }

    public MemberbankinfoExample.Criteria andMemberidIsNull() {
      addCriterion("memberid is null");
      return ((MemberbankinfoExample.Criteria)this);
    }

    public MemberbankinfoExample.Criteria andMemberidIsNotNull() {
      addCriterion("memberid is not null");
      return ((MemberbankinfoExample.Criteria)this);
    }

    public MemberbankinfoExample.Criteria andMemberidEqualTo(Long value) {
      addCriterion("memberid =", value, "memberid");
      return ((MemberbankinfoExample.Criteria)this);
    }

    public MemberbankinfoExample.Criteria andMemberidNotEqualTo(Long value) {
      addCriterion("memberid <>", value, "memberid");
      return ((MemberbankinfoExample.Criteria)this);
    }

    public MemberbankinfoExample.Criteria andMemberidGreaterThan(Long value) {
      addCriterion("memberid >", value, "memberid");
      return ((MemberbankinfoExample.Criteria)this);
    }

    public MemberbankinfoExample.Criteria andMemberidGreaterThanOrEqualTo(Long value) {
      addCriterion("memberid >=", value, "memberid");
      return ((MemberbankinfoExample.Criteria)this);
    }

    public MemberbankinfoExample.Criteria andMemberidLessThan(Long value) {
      addCriterion("memberid <", value, "memberid");
      return ((MemberbankinfoExample.Criteria)this);
    }

    public MemberbankinfoExample.Criteria andMemberidLessThanOrEqualTo(Long value) {
      addCriterion("memberid <=", value, "memberid");
      return ((MemberbankinfoExample.Criteria)this);
    }

    public MemberbankinfoExample.Criteria andMemberidIn(List<Long> values) {
      addCriterion("memberid in", values, "memberid");
      return ((MemberbankinfoExample.Criteria)this);
    }

    public MemberbankinfoExample.Criteria andMemberidNotIn(List<Long> values) {
      addCriterion("memberid not in", values, "memberid");
      return ((MemberbankinfoExample.Criteria)this);
    }

    public MemberbankinfoExample.Criteria andMemberidBetween(Long value1, Long value2) {
      addCriterion("memberid between", value1, value2, "memberid");
      return ((MemberbankinfoExample.Criteria)this);
    }

    public MemberbankinfoExample.Criteria andMemberidNotBetween(Long value1, Long value2) {
      addCriterion("memberid not between", value1, value2, "memberid");
      return ((MemberbankinfoExample.Criteria)this);
    }

    public MemberbankinfoExample.Criteria andBanknameIsNull() {
      addCriterion("bankname is null");
      return ((MemberbankinfoExample.Criteria)this);
    }

    public MemberbankinfoExample.Criteria andBanknameIsNotNull() {
      addCriterion("bankname is not null");
      return ((MemberbankinfoExample.Criteria)this);
    }

    public MemberbankinfoExample.Criteria andBanknameEqualTo(String value) {
      addCriterion("bankname =", value, "bankname");
      return ((MemberbankinfoExample.Criteria)this);
    }

    public MemberbankinfoExample.Criteria andBanknameNotEqualTo(String value) {
      addCriterion("bankname <>", value, "bankname");
      return ((MemberbankinfoExample.Criteria)this);
    }

    public MemberbankinfoExample.Criteria andBanknameGreaterThan(String value) {
      addCriterion("bankname >", value, "bankname");
      return ((MemberbankinfoExample.Criteria)this);
    }

    public MemberbankinfoExample.Criteria andBanknameGreaterThanOrEqualTo(String value) {
      addCriterion("bankname >=", value, "bankname");
      return ((MemberbankinfoExample.Criteria)this);
    }

    public MemberbankinfoExample.Criteria andBanknameLessThan(String value) {
      addCriterion("bankname <", value, "bankname");
      return ((MemberbankinfoExample.Criteria)this);
    }

    public MemberbankinfoExample.Criteria andBanknameLessThanOrEqualTo(String value) {
      addCriterion("bankname <=", value, "bankname");
      return ((MemberbankinfoExample.Criteria)this);
    }

    public MemberbankinfoExample.Criteria andBanknameLike(String value) {
      addCriterion("bankname like", value, "bankname");
      return ((MemberbankinfoExample.Criteria)this);
    }

    public MemberbankinfoExample.Criteria andBanknameNotLike(String value) {
      addCriterion("bankname not like", value, "bankname");
      return ((MemberbankinfoExample.Criteria)this);
    }

    public MemberbankinfoExample.Criteria andBanknameIn(List<String> values) {
      addCriterion("bankname in", values, "bankname");
      return ((MemberbankinfoExample.Criteria)this);
    }

    public MemberbankinfoExample.Criteria andBanknameNotIn(List<String> values) {
      addCriterion("bankname not in", values, "bankname");
      return ((MemberbankinfoExample.Criteria)this);
    }

    public MemberbankinfoExample.Criteria andBanknameBetween(String value1, String value2) {
      addCriterion("bankname between", value1, value2, "bankname");
      return ((MemberbankinfoExample.Criteria)this);
    }

    public MemberbankinfoExample.Criteria andBanknameNotBetween(String value1, String value2) {
      addCriterion("bankname not between", value1, value2, "bankname");
      return ((MemberbankinfoExample.Criteria)this);
    }

    public MemberbankinfoExample.Criteria andBankprinceIsNull() {
      addCriterion("bankprince is null");
      return ((MemberbankinfoExample.Criteria)this);
    }

    public MemberbankinfoExample.Criteria andBankprinceIsNotNull() {
      addCriterion("bankprince is not null");
      return ((MemberbankinfoExample.Criteria)this);
    }

    public MemberbankinfoExample.Criteria andBankprinceEqualTo(String value) {
      addCriterion("bankprince =", value, "bankprince");
      return ((MemberbankinfoExample.Criteria)this);
    }

    public MemberbankinfoExample.Criteria andBankprinceNotEqualTo(String value) {
      addCriterion("bankprince <>", value, "bankprince");
      return ((MemberbankinfoExample.Criteria)this);
    }

    public MemberbankinfoExample.Criteria andBankprinceGreaterThan(String value) {
      addCriterion("bankprince >", value, "bankprince");
      return ((MemberbankinfoExample.Criteria)this);
    }

    public MemberbankinfoExample.Criteria andBankprinceGreaterThanOrEqualTo(String value) {
      addCriterion("bankprince >=", value, "bankprince");
      return ((MemberbankinfoExample.Criteria)this);
    }

    public MemberbankinfoExample.Criteria andBankprinceLessThan(String value) {
      addCriterion("bankprince <", value, "bankprince");
      return ((MemberbankinfoExample.Criteria)this);
    }

    public MemberbankinfoExample.Criteria andBankprinceLessThanOrEqualTo(String value) {
      addCriterion("bankprince <=", value, "bankprince");
      return ((MemberbankinfoExample.Criteria)this);
    }

    public MemberbankinfoExample.Criteria andBankprinceLike(String value) {
      addCriterion("bankprince like", value, "bankprince");
      return ((MemberbankinfoExample.Criteria)this);
    }

    public MemberbankinfoExample.Criteria andBankprinceNotLike(String value) {
      addCriterion("bankprince not like", value, "bankprince");
      return ((MemberbankinfoExample.Criteria)this);
    }

    public MemberbankinfoExample.Criteria andBankprinceIn(List<String> values) {
      addCriterion("bankprince in", values, "bankprince");
      return ((MemberbankinfoExample.Criteria)this);
    }

    public MemberbankinfoExample.Criteria andBankprinceNotIn(List<String> values) {
      addCriterion("bankprince not in", values, "bankprince");
      return ((MemberbankinfoExample.Criteria)this);
    }

    public MemberbankinfoExample.Criteria andBankprinceBetween(String value1, String value2) {
      addCriterion("bankprince between", value1, value2, "bankprince");
      return ((MemberbankinfoExample.Criteria)this);
    }

    public MemberbankinfoExample.Criteria andBankprinceNotBetween(String value1, String value2) {
      addCriterion("bankprince not between", value1, value2, "bankprince");
      return ((MemberbankinfoExample.Criteria)this);
    }

    public MemberbankinfoExample.Criteria andBankcityIsNull() {
      addCriterion("bankcity is null");
      return ((MemberbankinfoExample.Criteria)this);
    }

    public MemberbankinfoExample.Criteria andBankcityIsNotNull() {
      addCriterion("bankcity is not null");
      return ((MemberbankinfoExample.Criteria)this);
    }

    public MemberbankinfoExample.Criteria andBankcityEqualTo(String value) {
      addCriterion("bankcity =", value, "bankcity");
      return ((MemberbankinfoExample.Criteria)this);
    }

    public MemberbankinfoExample.Criteria andBankcityNotEqualTo(String value) {
      addCriterion("bankcity <>", value, "bankcity");
      return ((MemberbankinfoExample.Criteria)this);
    }

    public MemberbankinfoExample.Criteria andBankcityGreaterThan(String value) {
      addCriterion("bankcity >", value, "bankcity");
      return ((MemberbankinfoExample.Criteria)this);
    }

    public MemberbankinfoExample.Criteria andBankcityGreaterThanOrEqualTo(String value) {
      addCriterion("bankcity >=", value, "bankcity");
      return ((MemberbankinfoExample.Criteria)this);
    }

    public MemberbankinfoExample.Criteria andBankcityLessThan(String value) {
      addCriterion("bankcity <", value, "bankcity");
      return ((MemberbankinfoExample.Criteria)this);
    }

    public MemberbankinfoExample.Criteria andBankcityLessThanOrEqualTo(String value) {
      addCriterion("bankcity <=", value, "bankcity");
      return ((MemberbankinfoExample.Criteria)this);
    }

    public MemberbankinfoExample.Criteria andBankcityLike(String value) {
      addCriterion("bankcity like", value, "bankcity");
      return ((MemberbankinfoExample.Criteria)this);
    }

    public MemberbankinfoExample.Criteria andBankcityNotLike(String value) {
      addCriterion("bankcity not like", value, "bankcity");
      return ((MemberbankinfoExample.Criteria)this);
    }

    public MemberbankinfoExample.Criteria andBankcityIn(List<String> values) {
      addCriterion("bankcity in", values, "bankcity");
      return ((MemberbankinfoExample.Criteria)this);
    }

    public MemberbankinfoExample.Criteria andBankcityNotIn(List<String> values) {
      addCriterion("bankcity not in", values, "bankcity");
      return ((MemberbankinfoExample.Criteria)this);
    }

    public MemberbankinfoExample.Criteria andBankcityBetween(String value1, String value2) {
      addCriterion("bankcity between", value1, value2, "bankcity");
      return ((MemberbankinfoExample.Criteria)this);
    }

    public MemberbankinfoExample.Criteria andBankcityNotBetween(String value1, String value2) {
      addCriterion("bankcity not between", value1, value2, "bankcity");
      return ((MemberbankinfoExample.Criteria)this);
    }

    public MemberbankinfoExample.Criteria andBankinfoIsNull() {
      addCriterion("bankinfo is null");
      return ((MemberbankinfoExample.Criteria)this);
    }

    public MemberbankinfoExample.Criteria andBankinfoIsNotNull() {
      addCriterion("bankinfo is not null");
      return ((MemberbankinfoExample.Criteria)this);
    }

    public MemberbankinfoExample.Criteria andBankinfoEqualTo(String value) {
      addCriterion("bankinfo =", value, "bankinfo");
      return ((MemberbankinfoExample.Criteria)this);
    }

    public MemberbankinfoExample.Criteria andBankinfoNotEqualTo(String value) {
      addCriterion("bankinfo <>", value, "bankinfo");
      return ((MemberbankinfoExample.Criteria)this);
    }

    public MemberbankinfoExample.Criteria andBankinfoGreaterThan(String value) {
      addCriterion("bankinfo >", value, "bankinfo");
      return ((MemberbankinfoExample.Criteria)this);
    }

    public MemberbankinfoExample.Criteria andBankinfoGreaterThanOrEqualTo(String value) {
      addCriterion("bankinfo >=", value, "bankinfo");
      return ((MemberbankinfoExample.Criteria)this);
    }

    public MemberbankinfoExample.Criteria andBankinfoLessThan(String value) {
      addCriterion("bankinfo <", value, "bankinfo");
      return ((MemberbankinfoExample.Criteria)this);
    }

    public MemberbankinfoExample.Criteria andBankinfoLessThanOrEqualTo(String value) {
      addCriterion("bankinfo <=", value, "bankinfo");
      return ((MemberbankinfoExample.Criteria)this);
    }

    public MemberbankinfoExample.Criteria andBankinfoLike(String value) {
      addCriterion("bankinfo like", value, "bankinfo");
      return ((MemberbankinfoExample.Criteria)this);
    }

    public MemberbankinfoExample.Criteria andBankinfoNotLike(String value) {
      addCriterion("bankinfo not like", value, "bankinfo");
      return ((MemberbankinfoExample.Criteria)this);
    }

    public MemberbankinfoExample.Criteria andBankinfoIn(List<String> values) {
      addCriterion("bankinfo in", values, "bankinfo");
      return ((MemberbankinfoExample.Criteria)this);
    }

    public MemberbankinfoExample.Criteria andBankinfoNotIn(List<String> values) {
      addCriterion("bankinfo not in", values, "bankinfo");
      return ((MemberbankinfoExample.Criteria)this);
    }

    public MemberbankinfoExample.Criteria andBankinfoBetween(String value1, String value2) {
      addCriterion("bankinfo between", value1, value2, "bankinfo");
      return ((MemberbankinfoExample.Criteria)this);
    }

    public MemberbankinfoExample.Criteria andBankinfoNotBetween(String value1, String value2) {
      addCriterion("bankinfo not between", value1, value2, "bankinfo");
      return ((MemberbankinfoExample.Criteria)this);
    }

    public MemberbankinfoExample.Criteria andBankcardnoIsNull() {
      addCriterion("bankcardno is null");
      return ((MemberbankinfoExample.Criteria)this);
    }

    public MemberbankinfoExample.Criteria andBankcardnoIsNotNull() {
      addCriterion("bankcardno is not null");
      return ((MemberbankinfoExample.Criteria)this);
    }

    public MemberbankinfoExample.Criteria andBankcardnoEqualTo(String value) {
      addCriterion("bankcardno =", value, "bankcardno");
      return ((MemberbankinfoExample.Criteria)this);
    }

    public MemberbankinfoExample.Criteria andBankcardnoNotEqualTo(String value) {
      addCriterion("bankcardno <>", value, "bankcardno");
      return ((MemberbankinfoExample.Criteria)this);
    }

    public MemberbankinfoExample.Criteria andBankcardnoGreaterThan(String value) {
      addCriterion("bankcardno >", value, "bankcardno");
      return ((MemberbankinfoExample.Criteria)this);
    }

    public MemberbankinfoExample.Criteria andBankcardnoGreaterThanOrEqualTo(String value) {
      addCriterion("bankcardno >=", value, "bankcardno");
      return ((MemberbankinfoExample.Criteria)this);
    }

    public MemberbankinfoExample.Criteria andBankcardnoLessThan(String value) {
      addCriterion("bankcardno <", value, "bankcardno");
      return ((MemberbankinfoExample.Criteria)this);
    }

    public MemberbankinfoExample.Criteria andBankcardnoLessThanOrEqualTo(String value) {
      addCriterion("bankcardno <=", value, "bankcardno");
      return ((MemberbankinfoExample.Criteria)this);
    }

    public MemberbankinfoExample.Criteria andBankcardnoLike(String value) {
      addCriterion("bankcardno like", value, "bankcardno");
      return ((MemberbankinfoExample.Criteria)this);
    }

    public MemberbankinfoExample.Criteria andBankcardnoNotLike(String value) {
      addCriterion("bankcardno not like", value, "bankcardno");
      return ((MemberbankinfoExample.Criteria)this);
    }

    public MemberbankinfoExample.Criteria andBankcardnoIn(List<String> values) {
      addCriterion("bankcardno in", values, "bankcardno");
      return ((MemberbankinfoExample.Criteria)this);
    }

    public MemberbankinfoExample.Criteria andBankcardnoNotIn(List<String> values) {
      addCriterion("bankcardno not in", values, "bankcardno");
      return ((MemberbankinfoExample.Criteria)this);
    }

    public MemberbankinfoExample.Criteria andBankcardnoBetween(String value1, String value2) {
      addCriterion("bankcardno between", value1, value2, "bankcardno");
      return ((MemberbankinfoExample.Criteria)this);
    }

    public MemberbankinfoExample.Criteria andBankcardnoNotBetween(String value1, String value2) {
      addCriterion("bankcardno not between", value1, value2, "bankcardno");
      return ((MemberbankinfoExample.Criteria)this);
    }

    public MemberbankinfoExample.Criteria andBankverifydateIsNull() {
      addCriterion("bankverifydate is null");
      return ((MemberbankinfoExample.Criteria)this);
    }

    public MemberbankinfoExample.Criteria andBankverifydateIsNotNull() {
      addCriterion("bankverifydate is not null");
      return ((MemberbankinfoExample.Criteria)this);
    }

    public MemberbankinfoExample.Criteria andBankverifydateEqualTo(Date value) {
      addCriterion("bankverifydate =", value, "bankverifydate");
      return ((MemberbankinfoExample.Criteria)this);
    }

    public MemberbankinfoExample.Criteria andBankverifydateNotEqualTo(Date value) {
      addCriterion("bankverifydate <>", value, "bankverifydate");
      return ((MemberbankinfoExample.Criteria)this);
    }

    public MemberbankinfoExample.Criteria andBankverifydateGreaterThan(Date value) {
      addCriterion("bankverifydate >", value, "bankverifydate");
      return ((MemberbankinfoExample.Criteria)this);
    }

    public MemberbankinfoExample.Criteria andBankverifydateGreaterThanOrEqualTo(Date value) {
      addCriterion("bankverifydate >=", value, "bankverifydate");
      return ((MemberbankinfoExample.Criteria)this);
    }

    public MemberbankinfoExample.Criteria andBankverifydateLessThan(Date value) {
      addCriterion("bankverifydate <", value, "bankverifydate");
      return ((MemberbankinfoExample.Criteria)this);
    }

    public MemberbankinfoExample.Criteria andBankverifydateLessThanOrEqualTo(Date value) {
      addCriterion("bankverifydate <=", value, "bankverifydate");
      return ((MemberbankinfoExample.Criteria)this);
    }

    public MemberbankinfoExample.Criteria andBankverifydateIn(List<Date> values) {
      addCriterion("bankverifydate in", values, "bankverifydate");
      return ((MemberbankinfoExample.Criteria)this);
    }

    public MemberbankinfoExample.Criteria andBankverifydateNotIn(List<Date> values) {
      addCriterion("bankverifydate not in", values, "bankverifydate");
      return ((MemberbankinfoExample.Criteria)this);
    }

    public MemberbankinfoExample.Criteria andBankverifydateBetween(Date value1, Date value2) {
      addCriterion("bankverifydate between", value1, value2, "bankverifydate");
      return ((MemberbankinfoExample.Criteria)this);
    }

    public MemberbankinfoExample.Criteria andBankverifydateNotBetween(Date value1, Date value2) {
      addCriterion("bankverifydate not between", value1, value2, "bankverifydate");
      return ((MemberbankinfoExample.Criteria)this);
    }

    public MemberbankinfoExample.Criteria andIfdefaultIsNull() {
      addCriterion("ifdefault is null");
      return ((MemberbankinfoExample.Criteria)this);
    }

    public MemberbankinfoExample.Criteria andIfdefaultIsNotNull() {
      addCriterion("ifdefault is not null");
      return ((MemberbankinfoExample.Criteria)this);
    }

    public MemberbankinfoExample.Criteria andIfdefaultEqualTo(Boolean value) {
      addCriterion("ifdefault =", value, "ifdefault");
      return ((MemberbankinfoExample.Criteria)this);
    }

    public MemberbankinfoExample.Criteria andIfdefaultNotEqualTo(Boolean value) {
      addCriterion("ifdefault <>", value, "ifdefault");
      return ((MemberbankinfoExample.Criteria)this);
    }

    public MemberbankinfoExample.Criteria andIfdefaultGreaterThan(Boolean value) {
      addCriterion("ifdefault >", value, "ifdefault");
      return ((MemberbankinfoExample.Criteria)this);
    }

    public MemberbankinfoExample.Criteria andIfdefaultGreaterThanOrEqualTo(Boolean value) {
      addCriterion("ifdefault >=", value, "ifdefault");
      return ((MemberbankinfoExample.Criteria)this);
    }

    public MemberbankinfoExample.Criteria andIfdefaultLessThan(Boolean value) {
      addCriterion("ifdefault <", value, "ifdefault");
      return ((MemberbankinfoExample.Criteria)this);
    }

    public MemberbankinfoExample.Criteria andIfdefaultLessThanOrEqualTo(Boolean value) {
      addCriterion("ifdefault <=", value, "ifdefault");
      return ((MemberbankinfoExample.Criteria)this);
    }

    public MemberbankinfoExample.Criteria andIfdefaultIn(List<Boolean> values) {
      addCriterion("ifdefault in", values, "ifdefault");
      return ((MemberbankinfoExample.Criteria)this);
    }

    public MemberbankinfoExample.Criteria andIfdefaultNotIn(List<Boolean> values) {
      addCriterion("ifdefault not in", values, "ifdefault");
      return ((MemberbankinfoExample.Criteria)this);
    }

    public MemberbankinfoExample.Criteria andIfdefaultBetween(Boolean value1, Boolean value2) {
      addCriterion("ifdefault between", value1, value2, "ifdefault");
      return ((MemberbankinfoExample.Criteria)this);
    }

    public MemberbankinfoExample.Criteria andIfdefaultNotBetween(Boolean value1, Boolean value2) {
      addCriterion("ifdefault not between", value1, value2, "ifdefault");
      return ((MemberbankinfoExample.Criteria)this);
    }
  }
}