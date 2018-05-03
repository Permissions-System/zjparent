package com.zjgt.p2p.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springfk.pancloud.daoframework.page.PageExample;

public class CapitaltransExample extends PageExample
{
  protected String orderByClause;
  protected boolean distinct;
  protected Integer startPos;
  protected Integer pageSize;
  protected List<Criteria> oredCriteria;

  public CapitaltransExample()
  {
    this.oredCriteria = new ArrayList();
  }

  public Integer getStartPos()
  {
    return this.startPos;
  }

  public void setStartPos(Integer startPos)
  {
    this.startPos = startPos;
  }

  public Integer getPageSize()
  {
    return this.pageSize;
  }

  public void setPageSize(Integer pageSize)
  {
    this.pageSize = pageSize;
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

  public static class Criteria extends CapitaltransExample.GeneratedCriteria
  {
  }

  protected static abstract class GeneratedCriteria
  {
    protected List<CapitaltransExample.Criterion> criteria;

    protected GeneratedCriteria()
    {
      this.criteria = new ArrayList();
    }

    public boolean isValid() {
      return (this.criteria.size() > 0);
    }

    public List<CapitaltransExample.Criterion> getAllCriteria() {
      return this.criteria;
    }

    public List<CapitaltransExample.Criterion> getCriteria() {
      return this.criteria;
    }

    protected void addCriterion(String condition) {
      if (condition == null) {
        throw new RuntimeException("Value for condition cannot be null");
      }
      this.criteria.add(new CapitaltransExample.Criterion(condition));
    }

    protected void addCriterion(String condition, Object value, String property) {
      if (value == null) {
        throw new RuntimeException("Value for " + property + " cannot be null");
      }
      this.criteria.add(new CapitaltransExample.Criterion(condition, value));
    }

    protected void addCriterion(String condition, Object value1, Object value2, String property) {
      if ((value1 == null) || (value2 == null)) {
        throw new RuntimeException("Between values for " + property + " cannot be null");
      }
      this.criteria.add(new CapitaltransExample.Criterion(condition, value1, value2));
    }

    public CapitaltransExample.Criteria andIdIsNull() {
      addCriterion("Id is null");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andIdIsNotNull() {
      addCriterion("Id is not null");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andIdEqualTo(Long value) {
      addCriterion("Id =", value, "id");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andIdNotEqualTo(Long value) {
      addCriterion("Id <>", value, "id");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andIdGreaterThan(Long value) {
      addCriterion("Id >", value, "id");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andIdGreaterThanOrEqualTo(Long value) {
      addCriterion("Id >=", value, "id");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andIdLessThan(Long value) {
      addCriterion("Id <", value, "id");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andIdLessThanOrEqualTo(Long value) {
      addCriterion("Id <=", value, "id");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andIdIn(List<Long> values) {
      addCriterion("Id in", values, "id");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andIdNotIn(List<Long> values) {
      addCriterion("Id not in", values, "id");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andIdBetween(Long value1, Long value2) {
      addCriterion("Id between", value1, value2, "id");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andIdNotBetween(Long value1, Long value2) {
      addCriterion("Id not between", value1, value2, "id");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andTransnoIsNull() {
      addCriterion("TransNo is null");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andTransnoIsNotNull() {
      addCriterion("TransNo is not null");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andTransnoEqualTo(String value) {
      addCriterion("TransNo =", value, "transno");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andTransnoNotEqualTo(String value) {
      addCriterion("TransNo <>", value, "transno");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andTransnoGreaterThan(String value) {
      addCriterion("TransNo >", value, "transno");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andTransnoGreaterThanOrEqualTo(String value) {
      addCriterion("TransNo >=", value, "transno");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andTransnoLessThan(String value) {
      addCriterion("TransNo <", value, "transno");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andTransnoLessThanOrEqualTo(String value) {
      addCriterion("TransNo <=", value, "transno");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andTransnoLike(String value) {
      addCriterion("TransNo like", value, "transno");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andTransnoNotLike(String value) {
      addCriterion("TransNo not like", value, "transno");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andTransnoIn(List<String> values) {
      addCriterion("TransNo in", values, "transno");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andTransnoNotIn(List<String> values) {
      addCriterion("TransNo not in", values, "transno");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andTransnoBetween(String value1, String value2) {
      addCriterion("TransNo between", value1, value2, "transno");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andTransnoNotBetween(String value1, String value2) {
      addCriterion("TransNo not between", value1, value2, "transno");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andTranstimeIsNull() {
      addCriterion("TransTime is null");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andTranstimeIsNotNull() {
      addCriterion("TransTime is not null");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andTranstimeEqualTo(Date value) {
      addCriterion("TransTime =", value, "transtime");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andTranstimeNotEqualTo(Date value) {
      addCriterion("TransTime <>", value, "transtime");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andTranstimeGreaterThan(Date value) {
      addCriterion("TransTime >", value, "transtime");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andTranstimeGreaterThanOrEqualTo(Date value) {
      addCriterion("TransTime >=", value, "transtime");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andTranstimeLessThan(Date value) {
      addCriterion("TransTime <", value, "transtime");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andTranstimeLessThanOrEqualTo(Date value) {
      addCriterion("TransTime <=", value, "transtime");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andTranstimeIn(List<Date> values) {
      addCriterion("TransTime in", values, "transtime");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andTranstimeNotIn(List<Date> values) {
      addCriterion("TransTime not in", values, "transtime");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andTranstimeBetween(Date value1, Date value2) {
      addCriterion("TransTime between", value1, value2, "transtime");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andTranstimeNotBetween(Date value1, Date value2) {
      addCriterion("TransTime not between", value1, value2, "transtime");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andTranstypeIsNull() {
      addCriterion("TransType is null");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andTranstypeIsNotNull() {
      addCriterion("TransType is not null");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andTranstypeEqualTo(Integer value) {
      addCriterion("TransType =", value, "transtype");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andTranstypeNotEqualTo(Integer value) {
      addCriterion("TransType <>", value, "transtype");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andTranstypeGreaterThan(Integer value) {
      addCriterion("TransType >", value, "transtype");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andTranstypeGreaterThanOrEqualTo(Integer value) {
      addCriterion("TransType >=", value, "transtype");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andTranstypeLessThan(Integer value) {
      addCriterion("TransType <", value, "transtype");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andTranstypeLessThanOrEqualTo(Integer value) {
      addCriterion("TransType <=", value, "transtype");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andTranstypeIn(List<Integer> values) {
      addCriterion("TransType in", values, "transtype");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andTranstypeNotIn(List<Integer> values) {
      addCriterion("TransType not in", values, "transtype");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andTranstypeBetween(Integer value1, Integer value2) {
      addCriterion("TransType between", value1, value2, "transtype");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andTranstypeNotBetween(Integer value1, Integer value2) {
      addCriterion("TransType not between", value1, value2, "transtype");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andMemberAcctidIsNull() {
      addCriterion("member_acctid is null");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andMemberAcctidIsNotNull() {
      addCriterion("member_acctid is not null");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andMemberAcctidEqualTo(Integer value) {
      addCriterion("member_acctid =", value, "memberAcctid");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andMemberAcctidNotEqualTo(Integer value) {
      addCriterion("member_acctid <>", value, "memberAcctid");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andMemberAcctidGreaterThan(Integer value) {
      addCriterion("member_acctid >", value, "memberAcctid");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andMemberAcctidGreaterThanOrEqualTo(Integer value) {
      addCriterion("member_acctid >=", value, "memberAcctid");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andMemberAcctidLessThan(Integer value) {
      addCriterion("member_acctid <", value, "memberAcctid");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andMemberAcctidLessThanOrEqualTo(Integer value) {
      addCriterion("member_acctid <=", value, "memberAcctid");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andMemberAcctidIn(List<Integer> values) {
      addCriterion("member_acctid in", values, "memberAcctid");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andMemberAcctidNotIn(List<Integer> values) {
      addCriterion("member_acctid not in", values, "memberAcctid");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andMemberAcctidBetween(Integer value1, Integer value2) {
      addCriterion("member_acctid between", value1, value2, "memberAcctid");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andMemberAcctidNotBetween(Integer value1, Integer value2) {
      addCriterion("member_acctid not between", value1, value2, "memberAcctid");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andMemberidIsNull() {
      addCriterion("memberid is null");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andMemberidIsNotNull() {
      addCriterion("memberid is not null");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andMemberidEqualTo(Integer value) {
      addCriterion("memberid =", value, "memberid");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andMemberidNotEqualTo(Integer value) {
      addCriterion("memberid <>", value, "memberid");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andMemberidGreaterThan(Integer value) {
      addCriterion("memberid >", value, "memberid");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andMemberidGreaterThanOrEqualTo(Integer value) {
      addCriterion("memberid >=", value, "memberid");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andMemberidLessThan(Integer value) {
      addCriterion("memberid <", value, "memberid");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andMemberidLessThanOrEqualTo(Integer value) {
      addCriterion("memberid <=", value, "memberid");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andMemberidIn(List<Integer> values) {
      addCriterion("memberid in", values, "memberid");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andMemberidNotIn(List<Integer> values) {
      addCriterion("memberid not in", values, "memberid");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andMemberidBetween(Integer value1, Integer value2) {
      addCriterion("memberid between", value1, value2, "memberid");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andMemberidNotBetween(Integer value1, Integer value2) {
      addCriterion("memberid not between", value1, value2, "memberid");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andRealnameIsNull() {
      addCriterion("realname is null");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andRealnameIsNotNull() {
      addCriterion("realname is not null");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andRealnameEqualTo(String value) {
      addCriterion("realname =", value, "realname");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andRealnameNotEqualTo(String value) {
      addCriterion("realname <>", value, "realname");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andRealnameGreaterThan(String value) {
      addCriterion("realname >", value, "realname");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andRealnameGreaterThanOrEqualTo(String value) {
      addCriterion("realname >=", value, "realname");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andRealnameLessThan(String value) {
      addCriterion("realname <", value, "realname");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andRealnameLessThanOrEqualTo(String value) {
      addCriterion("realname <=", value, "realname");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andRealnameLike(String value) {
      addCriterion("realname like", value, "realname");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andRealnameNotLike(String value) {
      addCriterion("realname not like", value, "realname");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andRealnameIn(List<String> values) {
      addCriterion("realname in", values, "realname");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andRealnameNotIn(List<String> values) {
      addCriterion("realname not in", values, "realname");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andRealnameBetween(String value1, String value2) {
      addCriterion("realname between", value1, value2, "realname");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andRealnameNotBetween(String value1, String value2) {
      addCriterion("realname not between", value1, value2, "realname");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andAmountIsNull() {
      addCriterion("amount is null");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andAmountIsNotNull() {
      addCriterion("amount is not null");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andAmountEqualTo(BigDecimal value) {
      addCriterion("amount =", value, "amount");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andAmountNotEqualTo(BigDecimal value) {
      addCriterion("amount <>", value, "amount");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andAmountGreaterThan(BigDecimal value) {
      addCriterion("amount >", value, "amount");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andAmountGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("amount >=", value, "amount");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andAmountLessThan(BigDecimal value) {
      addCriterion("amount <", value, "amount");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andAmountLessThanOrEqualTo(BigDecimal value) {
      addCriterion("amount <=", value, "amount");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andAmountIn(List<BigDecimal> values) {
      addCriterion("amount in", values, "amount");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andAmountNotIn(List<BigDecimal> values) {
      addCriterion("amount not in", values, "amount");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andAmountBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("amount between", value1, value2, "amount");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andAmountNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("amount not between", value1, value2, "amount");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andAvailamountIsNull() {
      addCriterion("availAmount is null");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andAvailamountIsNotNull() {
      addCriterion("availAmount is not null");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andAvailamountEqualTo(BigDecimal value) {
      addCriterion("availAmount =", value, "availamount");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andAvailamountNotEqualTo(BigDecimal value) {
      addCriterion("availAmount <>", value, "availamount");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andAvailamountGreaterThan(BigDecimal value) {
      addCriterion("availAmount >", value, "availamount");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andAvailamountGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("availAmount >=", value, "availamount");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andAvailamountLessThan(BigDecimal value) {
      addCriterion("availAmount <", value, "availamount");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andAvailamountLessThanOrEqualTo(BigDecimal value) {
      addCriterion("availAmount <=", value, "availamount");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andAvailamountIn(List<BigDecimal> values) {
      addCriterion("availAmount in", values, "availamount");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andAvailamountNotIn(List<BigDecimal> values) {
      addCriterion("availAmount not in", values, "availamount");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andAvailamountBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("availAmount between", value1, value2, "availamount");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andAvailamountNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("availAmount not between", value1, value2, "availamount");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andFeesIsNull() {
      addCriterion("fees is null");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andFeesIsNotNull() {
      addCriterion("fees is not null");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andFeesEqualTo(BigDecimal value) {
      addCriterion("fees =", value, "fees");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andFeesNotEqualTo(BigDecimal value) {
      addCriterion("fees <>", value, "fees");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andFeesGreaterThan(BigDecimal value) {
      addCriterion("fees >", value, "fees");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andFeesGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("fees >=", value, "fees");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andFeesLessThan(BigDecimal value) {
      addCriterion("fees <", value, "fees");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andFeesLessThanOrEqualTo(BigDecimal value) {
      addCriterion("fees <=", value, "fees");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andFeesIn(List<BigDecimal> values) {
      addCriterion("fees in", values, "fees");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andFeesNotIn(List<BigDecimal> values) {
      addCriterion("fees not in", values, "fees");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andFeesBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("fees between", value1, value2, "fees");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andFeesNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("fees not between", value1, value2, "fees");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andFeerateIsNull() {
      addCriterion("feerate is null");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andFeerateIsNotNull() {
      addCriterion("feerate is not null");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andFeerateEqualTo(BigDecimal value) {
      addCriterion("feerate =", value, "feerate");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andFeerateNotEqualTo(BigDecimal value) {
      addCriterion("feerate <>", value, "feerate");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andFeerateGreaterThan(BigDecimal value) {
      addCriterion("feerate >", value, "feerate");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andFeerateGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("feerate >=", value, "feerate");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andFeerateLessThan(BigDecimal value) {
      addCriterion("feerate <", value, "feerate");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andFeerateLessThanOrEqualTo(BigDecimal value) {
      addCriterion("feerate <=", value, "feerate");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andFeerateIn(List<BigDecimal> values) {
      addCriterion("feerate in", values, "feerate");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andFeerateNotIn(List<BigDecimal> values) {
      addCriterion("feerate not in", values, "feerate");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andFeerateBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("feerate between", value1, value2, "feerate");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andFeerateNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("feerate not between", value1, value2, "feerate");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andCurrencyIsNull() {
      addCriterion("Currency is null");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andCurrencyIsNotNull() {
      addCriterion("Currency is not null");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andCurrencyEqualTo(String value) {
      addCriterion("Currency =", value, "currency");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andCurrencyNotEqualTo(String value) {
      addCriterion("Currency <>", value, "currency");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andCurrencyGreaterThan(String value) {
      addCriterion("Currency >", value, "currency");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andCurrencyGreaterThanOrEqualTo(String value) {
      addCriterion("Currency >=", value, "currency");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andCurrencyLessThan(String value) {
      addCriterion("Currency <", value, "currency");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andCurrencyLessThanOrEqualTo(String value) {
      addCriterion("Currency <=", value, "currency");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andCurrencyLike(String value) {
      addCriterion("Currency like", value, "currency");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andCurrencyNotLike(String value) {
      addCriterion("Currency not like", value, "currency");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andCurrencyIn(List<String> values) {
      addCriterion("Currency in", values, "currency");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andCurrencyNotIn(List<String> values) {
      addCriterion("Currency not in", values, "currency");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andCurrencyBetween(String value1, String value2) {
      addCriterion("Currency between", value1, value2, "currency");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andCurrencyNotBetween(String value1, String value2) {
      addCriterion("Currency not between", value1, value2, "currency");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPayaccountidIsNull() {
      addCriterion("PayAccountId is null");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPayaccountidIsNotNull() {
      addCriterion("PayAccountId is not null");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPayaccountidEqualTo(Long value) {
      addCriterion("PayAccountId =", value, "payaccountid");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPayaccountidNotEqualTo(Long value) {
      addCriterion("PayAccountId <>", value, "payaccountid");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPayaccountidGreaterThan(Long value) {
      addCriterion("PayAccountId >", value, "payaccountid");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPayaccountidGreaterThanOrEqualTo(Long value) {
      addCriterion("PayAccountId >=", value, "payaccountid");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPayaccountidLessThan(Long value) {
      addCriterion("PayAccountId <", value, "payaccountid");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPayaccountidLessThanOrEqualTo(Long value) {
      addCriterion("PayAccountId <=", value, "payaccountid");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPayaccountidIn(List<Long> values) {
      addCriterion("PayAccountId in", values, "payaccountid");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPayaccountidNotIn(List<Long> values) {
      addCriterion("PayAccountId not in", values, "payaccountid");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPayaccountidBetween(Long value1, Long value2) {
      addCriterion("PayAccountId between", value1, value2, "payaccountid");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPayaccountidNotBetween(Long value1, Long value2) {
      addCriterion("PayAccountId not between", value1, value2, "payaccountid");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPayaccountnoIsNull() {
      addCriterion("PayAccountNo is null");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPayaccountnoIsNotNull() {
      addCriterion("PayAccountNo is not null");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPayaccountnoEqualTo(String value) {
      addCriterion("PayAccountNo =", value, "payaccountno");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPayaccountnoNotEqualTo(String value) {
      addCriterion("PayAccountNo <>", value, "payaccountno");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPayaccountnoGreaterThan(String value) {
      addCriterion("PayAccountNo >", value, "payaccountno");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPayaccountnoGreaterThanOrEqualTo(String value) {
      addCriterion("PayAccountNo >=", value, "payaccountno");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPayaccountnoLessThan(String value) {
      addCriterion("PayAccountNo <", value, "payaccountno");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPayaccountnoLessThanOrEqualTo(String value) {
      addCriterion("PayAccountNo <=", value, "payaccountno");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPayaccountnoLike(String value) {
      addCriterion("PayAccountNo like", value, "payaccountno");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPayaccountnoNotLike(String value) {
      addCriterion("PayAccountNo not like", value, "payaccountno");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPayaccountnoIn(List<String> values) {
      addCriterion("PayAccountNo in", values, "payaccountno");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPayaccountnoNotIn(List<String> values) {
      addCriterion("PayAccountNo not in", values, "payaccountno");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPayaccountnoBetween(String value1, String value2) {
      addCriterion("PayAccountNo between", value1, value2, "payaccountno");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPayaccountnoNotBetween(String value1, String value2) {
      addCriterion("PayAccountNo not between", value1, value2, "payaccountno");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPayernameIsNull() {
      addCriterion("PayerName is null");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPayernameIsNotNull() {
      addCriterion("PayerName is not null");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPayernameEqualTo(String value) {
      addCriterion("PayerName =", value, "payername");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPayernameNotEqualTo(String value) {
      addCriterion("PayerName <>", value, "payername");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPayernameGreaterThan(String value) {
      addCriterion("PayerName >", value, "payername");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPayernameGreaterThanOrEqualTo(String value) {
      addCriterion("PayerName >=", value, "payername");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPayernameLessThan(String value) {
      addCriterion("PayerName <", value, "payername");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPayernameLessThanOrEqualTo(String value) {
      addCriterion("PayerName <=", value, "payername");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPayernameLike(String value) {
      addCriterion("PayerName like", value, "payername");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPayernameNotLike(String value) {
      addCriterion("PayerName not like", value, "payername");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPayernameIn(List<String> values) {
      addCriterion("PayerName in", values, "payername");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPayernameNotIn(List<String> values) {
      addCriterion("PayerName not in", values, "payername");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPayernameBetween(String value1, String value2) {
      addCriterion("PayerName between", value1, value2, "payername");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPayernameNotBetween(String value1, String value2) {
      addCriterion("PayerName not between", value1, value2, "payername");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPaycardnumIsNull() {
      addCriterion("PayCardNum is null");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPaycardnumIsNotNull() {
      addCriterion("PayCardNum is not null");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPaycardnumEqualTo(String value) {
      addCriterion("PayCardNum =", value, "paycardnum");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPaycardnumNotEqualTo(String value) {
      addCriterion("PayCardNum <>", value, "paycardnum");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPaycardnumGreaterThan(String value) {
      addCriterion("PayCardNum >", value, "paycardnum");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPaycardnumGreaterThanOrEqualTo(String value) {
      addCriterion("PayCardNum >=", value, "paycardnum");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPaycardnumLessThan(String value) {
      addCriterion("PayCardNum <", value, "paycardnum");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPaycardnumLessThanOrEqualTo(String value) {
      addCriterion("PayCardNum <=", value, "paycardnum");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPaycardnumLike(String value) {
      addCriterion("PayCardNum like", value, "paycardnum");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPaycardnumNotLike(String value) {
      addCriterion("PayCardNum not like", value, "paycardnum");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPaycardnumIn(List<String> values) {
      addCriterion("PayCardNum in", values, "paycardnum");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPaycardnumNotIn(List<String> values) {
      addCriterion("PayCardNum not in", values, "paycardnum");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPaycardnumBetween(String value1, String value2) {
      addCriterion("PayCardNum between", value1, value2, "paycardnum");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPaycardnumNotBetween(String value1, String value2) {
      addCriterion("PayCardNum not between", value1, value2, "paycardnum");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPayaccounttypeIsNull() {
      addCriterion("PayAccountType is null");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPayaccounttypeIsNotNull() {
      addCriterion("PayAccountType is not null");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPayaccounttypeEqualTo(Integer value) {
      addCriterion("PayAccountType =", value, "payaccounttype");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPayaccounttypeNotEqualTo(Integer value) {
      addCriterion("PayAccountType <>", value, "payaccounttype");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPayaccounttypeGreaterThan(Integer value) {
      addCriterion("PayAccountType >", value, "payaccounttype");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPayaccounttypeGreaterThanOrEqualTo(Integer value) {
      addCriterion("PayAccountType >=", value, "payaccounttype");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPayaccounttypeLessThan(Integer value) {
      addCriterion("PayAccountType <", value, "payaccounttype");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPayaccounttypeLessThanOrEqualTo(Integer value) {
      addCriterion("PayAccountType <=", value, "payaccounttype");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPayaccounttypeIn(List<Integer> values) {
      addCriterion("PayAccountType in", values, "payaccounttype");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPayaccounttypeNotIn(List<Integer> values) {
      addCriterion("PayAccountType not in", values, "payaccounttype");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPayaccounttypeBetween(Integer value1, Integer value2) {
      addCriterion("PayAccountType between", value1, value2, "payaccounttype");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPayaccounttypeNotBetween(Integer value1, Integer value2) {
      addCriterion("PayAccountType not between", value1, value2, "payaccounttype");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPayeeaccountidIsNull() {
      addCriterion("PayeeAccountId is null");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPayeeaccountidIsNotNull() {
      addCriterion("PayeeAccountId is not null");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPayeeaccountidEqualTo(Long value) {
      addCriterion("PayeeAccountId =", value, "payeeaccountid");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPayeeaccountidNotEqualTo(Long value) {
      addCriterion("PayeeAccountId <>", value, "payeeaccountid");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPayeeaccountidGreaterThan(Long value) {
      addCriterion("PayeeAccountId >", value, "payeeaccountid");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPayeeaccountidGreaterThanOrEqualTo(Long value) {
      addCriterion("PayeeAccountId >=", value, "payeeaccountid");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPayeeaccountidLessThan(Long value) {
      addCriterion("PayeeAccountId <", value, "payeeaccountid");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPayeeaccountidLessThanOrEqualTo(Long value) {
      addCriterion("PayeeAccountId <=", value, "payeeaccountid");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPayeeaccountidIn(List<Long> values) {
      addCriterion("PayeeAccountId in", values, "payeeaccountid");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPayeeaccountidNotIn(List<Long> values) {
      addCriterion("PayeeAccountId not in", values, "payeeaccountid");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPayeeaccountidBetween(Long value1, Long value2) {
      addCriterion("PayeeAccountId between", value1, value2, "payeeaccountid");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPayeeaccountidNotBetween(Long value1, Long value2) {
      addCriterion("PayeeAccountId not between", value1, value2, "payeeaccountid");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPayeeaccountnoIsNull() {
      addCriterion("PayeeAccountNo is null");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPayeeaccountnoIsNotNull() {
      addCriterion("PayeeAccountNo is not null");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPayeeaccountnoEqualTo(String value) {
      addCriterion("PayeeAccountNo =", value, "payeeaccountno");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPayeeaccountnoNotEqualTo(String value) {
      addCriterion("PayeeAccountNo <>", value, "payeeaccountno");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPayeeaccountnoGreaterThan(String value) {
      addCriterion("PayeeAccountNo >", value, "payeeaccountno");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPayeeaccountnoGreaterThanOrEqualTo(String value) {
      addCriterion("PayeeAccountNo >=", value, "payeeaccountno");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPayeeaccountnoLessThan(String value) {
      addCriterion("PayeeAccountNo <", value, "payeeaccountno");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPayeeaccountnoLessThanOrEqualTo(String value) {
      addCriterion("PayeeAccountNo <=", value, "payeeaccountno");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPayeeaccountnoLike(String value) {
      addCriterion("PayeeAccountNo like", value, "payeeaccountno");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPayeeaccountnoNotLike(String value) {
      addCriterion("PayeeAccountNo not like", value, "payeeaccountno");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPayeeaccountnoIn(List<String> values) {
      addCriterion("PayeeAccountNo in", values, "payeeaccountno");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPayeeaccountnoNotIn(List<String> values) {
      addCriterion("PayeeAccountNo not in", values, "payeeaccountno");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPayeeaccountnoBetween(String value1, String value2) {
      addCriterion("PayeeAccountNo between", value1, value2, "payeeaccountno");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPayeeaccountnoNotBetween(String value1, String value2) {
      addCriterion("PayeeAccountNo not between", value1, value2, "payeeaccountno");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPayeenameIsNull() {
      addCriterion("PayeeName is null");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPayeenameIsNotNull() {
      addCriterion("PayeeName is not null");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPayeenameEqualTo(String value) {
      addCriterion("PayeeName =", value, "payeename");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPayeenameNotEqualTo(String value) {
      addCriterion("PayeeName <>", value, "payeename");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPayeenameGreaterThan(String value) {
      addCriterion("PayeeName >", value, "payeename");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPayeenameGreaterThanOrEqualTo(String value) {
      addCriterion("PayeeName >=", value, "payeename");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPayeenameLessThan(String value) {
      addCriterion("PayeeName <", value, "payeename");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPayeenameLessThanOrEqualTo(String value) {
      addCriterion("PayeeName <=", value, "payeename");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPayeenameLike(String value) {
      addCriterion("PayeeName like", value, "payeename");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPayeenameNotLike(String value) {
      addCriterion("PayeeName not like", value, "payeename");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPayeenameIn(List<String> values) {
      addCriterion("PayeeName in", values, "payeename");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPayeenameNotIn(List<String> values) {
      addCriterion("PayeeName not in", values, "payeename");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPayeenameBetween(String value1, String value2) {
      addCriterion("PayeeName between", value1, value2, "payeename");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPayeenameNotBetween(String value1, String value2) {
      addCriterion("PayeeName not between", value1, value2, "payeename");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPayeecardnumIsNull() {
      addCriterion("PayeeCardNum is null");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPayeecardnumIsNotNull() {
      addCriterion("PayeeCardNum is not null");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPayeecardnumEqualTo(String value) {
      addCriterion("PayeeCardNum =", value, "payeecardnum");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPayeecardnumNotEqualTo(String value) {
      addCriterion("PayeeCardNum <>", value, "payeecardnum");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPayeecardnumGreaterThan(String value) {
      addCriterion("PayeeCardNum >", value, "payeecardnum");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPayeecardnumGreaterThanOrEqualTo(String value) {
      addCriterion("PayeeCardNum >=", value, "payeecardnum");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPayeecardnumLessThan(String value) {
      addCriterion("PayeeCardNum <", value, "payeecardnum");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPayeecardnumLessThanOrEqualTo(String value) {
      addCriterion("PayeeCardNum <=", value, "payeecardnum");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPayeecardnumLike(String value) {
      addCriterion("PayeeCardNum like", value, "payeecardnum");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPayeecardnumNotLike(String value) {
      addCriterion("PayeeCardNum not like", value, "payeecardnum");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPayeecardnumIn(List<String> values) {
      addCriterion("PayeeCardNum in", values, "payeecardnum");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPayeecardnumNotIn(List<String> values) {
      addCriterion("PayeeCardNum not in", values, "payeecardnum");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPayeecardnumBetween(String value1, String value2) {
      addCriterion("PayeeCardNum between", value1, value2, "payeecardnum");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPayeecardnumNotBetween(String value1, String value2) {
      addCriterion("PayeeCardNum not between", value1, value2, "payeecardnum");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPayeeaccounttypeIsNull() {
      addCriterion("PayeeAccountType is null");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPayeeaccounttypeIsNotNull() {
      addCriterion("PayeeAccountType is not null");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPayeeaccounttypeEqualTo(Integer value) {
      addCriterion("PayeeAccountType =", value, "payeeaccounttype");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPayeeaccounttypeNotEqualTo(Integer value) {
      addCriterion("PayeeAccountType <>", value, "payeeaccounttype");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPayeeaccounttypeGreaterThan(Integer value) {
      addCriterion("PayeeAccountType >", value, "payeeaccounttype");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPayeeaccounttypeGreaterThanOrEqualTo(Integer value) {
      addCriterion("PayeeAccountType >=", value, "payeeaccounttype");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPayeeaccounttypeLessThan(Integer value) {
      addCriterion("PayeeAccountType <", value, "payeeaccounttype");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPayeeaccounttypeLessThanOrEqualTo(Integer value) {
      addCriterion("PayeeAccountType <=", value, "payeeaccounttype");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPayeeaccounttypeIn(List<Integer> values) {
      addCriterion("PayeeAccountType in", values, "payeeaccounttype");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPayeeaccounttypeNotIn(List<Integer> values) {
      addCriterion("PayeeAccountType not in", values, "payeeaccounttype");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPayeeaccounttypeBetween(Integer value1, Integer value2) {
      addCriterion("PayeeAccountType between", value1, value2, "payeeaccounttype");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andPayeeaccounttypeNotBetween(Integer value1, Integer value2) {
      addCriterion("PayeeAccountType not between", value1, value2, "payeeaccounttype");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andTransstatusIsNull() {
      addCriterion("TransStatus is null");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andTransstatusIsNotNull() {
      addCriterion("TransStatus is not null");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andTransstatusEqualTo(Integer value) {
      addCriterion("TransStatus =", value, "transstatus");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andTransstatusNotEqualTo(Integer value) {
      addCriterion("TransStatus <>", value, "transstatus");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andTransstatusGreaterThan(Integer value) {
      addCriterion("TransStatus >", value, "transstatus");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andTransstatusGreaterThanOrEqualTo(Integer value) {
      addCriterion("TransStatus >=", value, "transstatus");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andTransstatusLessThan(Integer value) {
      addCriterion("TransStatus <", value, "transstatus");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andTransstatusLessThanOrEqualTo(Integer value) {
      addCriterion("TransStatus <=", value, "transstatus");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andTransstatusIn(List<Integer> values) {
      addCriterion("TransStatus in", values, "transstatus");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andTransstatusNotIn(List<Integer> values) {
      addCriterion("TransStatus not in", values, "transstatus");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andTransstatusBetween(Integer value1, Integer value2) {
      addCriterion("TransStatus between", value1, value2, "transstatus");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andTransstatusNotBetween(Integer value1, Integer value2) {
      addCriterion("TransStatus not between", value1, value2, "transstatus");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andRemarkIsNull() {
      addCriterion("remark is null");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andRemarkIsNotNull() {
      addCriterion("remark is not null");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andRemarkEqualTo(String value) {
      addCriterion("remark =", value, "remark");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andRemarkNotEqualTo(String value) {
      addCriterion("remark <>", value, "remark");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andRemarkGreaterThan(String value) {
      addCriterion("remark >", value, "remark");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andRemarkGreaterThanOrEqualTo(String value) {
      addCriterion("remark >=", value, "remark");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andRemarkLessThan(String value) {
      addCriterion("remark <", value, "remark");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andRemarkLessThanOrEqualTo(String value) {
      addCriterion("remark <=", value, "remark");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andRemarkLike(String value) {
      addCriterion("remark like", value, "remark");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andRemarkNotLike(String value) {
      addCriterion("remark not like", value, "remark");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andRemarkIn(List<String> values) {
      addCriterion("remark in", values, "remark");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andRemarkNotIn(List<String> values) {
      addCriterion("remark not in", values, "remark");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andRemarkBetween(String value1, String value2) {
      addCriterion("remark between", value1, value2, "remark");
      return ((CapitaltransExample.Criteria)this);
    }

    public CapitaltransExample.Criteria andRemarkNotBetween(String value1, String value2) {
      addCriterion("remark not between", value1, value2, "remark");
      return ((CapitaltransExample.Criteria)this);
    }
  }
}