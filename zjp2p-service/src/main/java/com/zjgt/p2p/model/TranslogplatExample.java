package com.zjgt.p2p.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TranslogplatExample
{
  protected String orderByClause;
  protected boolean distinct;
  protected Integer startPos;
  protected Integer pageSize;
  protected List<Criteria> oredCriteria;

  public TranslogplatExample()
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

  public Integer getStartPos()
  {
    return this.startPos;
  }

  public void setStartPos(Integer startPos) {
    this.startPos = startPos;
  }

  public Integer getPageSize() {
    return this.pageSize;
  }

  public void setPageSize(Integer pageSize) {
    this.pageSize = pageSize;
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

  public static class Criteria extends TranslogplatExample.GeneratedCriteria
  {
  }

  protected static abstract class GeneratedCriteria
  {
    protected List<TranslogplatExample.Criterion> criteria;

    protected GeneratedCriteria()
    {
      this.criteria = new ArrayList();
    }

    public boolean isValid() {
      return (this.criteria.size() > 0);
    }

    public List<TranslogplatExample.Criterion> getAllCriteria() {
      return this.criteria;
    }

    public List<TranslogplatExample.Criterion> getCriteria() {
      return this.criteria;
    }

    protected void addCriterion(String condition) {
      if (condition == null) {
        throw new RuntimeException("Value for condition cannot be null");
      }
      this.criteria.add(new TranslogplatExample.Criterion(condition));
    }

    protected void addCriterion(String condition, Object value, String property) {
      if (value == null) {
        throw new RuntimeException("Value for " + property + " cannot be null");
      }
      this.criteria.add(new TranslogplatExample.Criterion(condition, value));
    }

    protected void addCriterion(String condition, Object value1, Object value2, String property) {
      if ((value1 == null) || (value2 == null)) {
        throw new RuntimeException("Between values for " + property + " cannot be null");
      }
      this.criteria.add(new TranslogplatExample.Criterion(condition, value1, value2));
    }

    public TranslogplatExample.Criteria andIdIsNull() {
      addCriterion("Id is null");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andIdIsNotNull() {
      addCriterion("Id is not null");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andIdEqualTo(Long value) {
      addCriterion("Id =", value, "id");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andIdNotEqualTo(Long value) {
      addCriterion("Id <>", value, "id");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andIdGreaterThan(Long value) {
      addCriterion("Id >", value, "id");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andIdGreaterThanOrEqualTo(Long value) {
      addCriterion("Id >=", value, "id");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andIdLessThan(Long value) {
      addCriterion("Id <", value, "id");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andIdLessThanOrEqualTo(Long value) {
      addCriterion("Id <=", value, "id");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andIdIn(List<Long> values) {
      addCriterion("Id in", values, "id");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andIdNotIn(List<Long> values) {
      addCriterion("Id not in", values, "id");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andIdBetween(Long value1, Long value2) {
      addCriterion("Id between", value1, value2, "id");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andIdNotBetween(Long value1, Long value2) {
      addCriterion("Id not between", value1, value2, "id");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andTransnoIsNull() {
      addCriterion("TransNo is null");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andTransnoIsNotNull() {
      addCriterion("TransNo is not null");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andTransnoEqualTo(String value) {
      addCriterion("TransNo =", value, "transno");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andTransnoNotEqualTo(String value) {
      addCriterion("TransNo <>", value, "transno");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andTransnoGreaterThan(String value) {
      addCriterion("TransNo >", value, "transno");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andTransnoGreaterThanOrEqualTo(String value) {
      addCriterion("TransNo >=", value, "transno");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andTransnoLessThan(String value) {
      addCriterion("TransNo <", value, "transno");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andTransnoLessThanOrEqualTo(String value) {
      addCriterion("TransNo <=", value, "transno");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andTransnoLike(String value) {
      addCriterion("TransNo like", value, "transno");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andTransnoNotLike(String value) {
      addCriterion("TransNo not like", value, "transno");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andTransnoIn(List<String> values) {
      addCriterion("TransNo in", values, "transno");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andTransnoNotIn(List<String> values) {
      addCriterion("TransNo not in", values, "transno");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andTransnoBetween(String value1, String value2) {
      addCriterion("TransNo between", value1, value2, "transno");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andTransnoNotBetween(String value1, String value2) {
      addCriterion("TransNo not between", value1, value2, "transno");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andTranstimeIsNull() {
      addCriterion("TransTime is null");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andTranstimeIsNotNull() {
      addCriterion("TransTime is not null");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andTranstimeEqualTo(Date value) {
      addCriterion("TransTime =", value, "transtime");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andTranstimeNotEqualTo(Date value) {
      addCriterion("TransTime <>", value, "transtime");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andTranstimeGreaterThan(Date value) {
      addCriterion("TransTime >", value, "transtime");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andTranstimeGreaterThanOrEqualTo(Date value) {
      addCriterion("TransTime >=", value, "transtime");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andTranstimeLessThan(Date value) {
      addCriterion("TransTime <", value, "transtime");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andTranstimeLessThanOrEqualTo(Date value) {
      addCriterion("TransTime <=", value, "transtime");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andTranstimeIn(List<Date> values) {
      addCriterion("TransTime in", values, "transtime");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andTranstimeNotIn(List<Date> values) {
      addCriterion("TransTime not in", values, "transtime");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andTranstimeBetween(Date value1, Date value2) {
      addCriterion("TransTime between", value1, value2, "transtime");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andTranstimeNotBetween(Date value1, Date value2) {
      addCriterion("TransTime not between", value1, value2, "transtime");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andTranscodeIsNull() {
      addCriterion("TransCode is null");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andTranscodeIsNotNull() {
      addCriterion("TransCode is not null");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andTranscodeEqualTo(String value) {
      addCriterion("TransCode =", value, "transcode");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andTranscodeNotEqualTo(String value) {
      addCriterion("TransCode <>", value, "transcode");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andTranscodeGreaterThan(String value) {
      addCriterion("TransCode >", value, "transcode");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andTranscodeGreaterThanOrEqualTo(String value) {
      addCriterion("TransCode >=", value, "transcode");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andTranscodeLessThan(String value) {
      addCriterion("TransCode <", value, "transcode");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andTranscodeLessThanOrEqualTo(String value) {
      addCriterion("TransCode <=", value, "transcode");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andTranscodeLike(String value) {
      addCriterion("TransCode like", value, "transcode");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andTranscodeNotLike(String value) {
      addCriterion("TransCode not like", value, "transcode");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andTranscodeIn(List<String> values) {
      addCriterion("TransCode in", values, "transcode");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andTranscodeNotIn(List<String> values) {
      addCriterion("TransCode not in", values, "transcode");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andTranscodeBetween(String value1, String value2) {
      addCriterion("TransCode between", value1, value2, "transcode");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andTranscodeNotBetween(String value1, String value2) {
      addCriterion("TransCode not between", value1, value2, "transcode");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andTransdescIsNull() {
      addCriterion("TransDesc is null");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andTransdescIsNotNull() {
      addCriterion("TransDesc is not null");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andTransdescEqualTo(String value) {
      addCriterion("TransDesc =", value, "transdesc");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andTransdescNotEqualTo(String value) {
      addCriterion("TransDesc <>", value, "transdesc");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andTransdescGreaterThan(String value) {
      addCriterion("TransDesc >", value, "transdesc");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andTransdescGreaterThanOrEqualTo(String value) {
      addCriterion("TransDesc >=", value, "transdesc");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andTransdescLessThan(String value) {
      addCriterion("TransDesc <", value, "transdesc");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andTransdescLessThanOrEqualTo(String value) {
      addCriterion("TransDesc <=", value, "transdesc");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andTransdescLike(String value) {
      addCriterion("TransDesc like", value, "transdesc");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andTransdescNotLike(String value) {
      addCriterion("TransDesc not like", value, "transdesc");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andTransdescIn(List<String> values) {
      addCriterion("TransDesc in", values, "transdesc");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andTransdescNotIn(List<String> values) {
      addCriterion("TransDesc not in", values, "transdesc");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andTransdescBetween(String value1, String value2) {
      addCriterion("TransDesc between", value1, value2, "transdesc");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andTransdescNotBetween(String value1, String value2) {
      addCriterion("TransDesc not between", value1, value2, "transdesc");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andAmountIsNull() {
      addCriterion("Amount is null");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andAmountIsNotNull() {
      addCriterion("Amount is not null");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andAmountEqualTo(BigDecimal value) {
      addCriterion("Amount =", value, "amount");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andAmountNotEqualTo(BigDecimal value) {
      addCriterion("Amount <>", value, "amount");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andAmountGreaterThan(BigDecimal value) {
      addCriterion("Amount >", value, "amount");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andAmountGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("Amount >=", value, "amount");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andAmountLessThan(BigDecimal value) {
      addCriterion("Amount <", value, "amount");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andAmountLessThanOrEqualTo(BigDecimal value) {
      addCriterion("Amount <=", value, "amount");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andAmountIn(List<BigDecimal> values) {
      addCriterion("Amount in", values, "amount");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andAmountNotIn(List<BigDecimal> values) {
      addCriterion("Amount not in", values, "amount");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andAmountBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("Amount between", value1, value2, "amount");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andAmountNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("Amount not between", value1, value2, "amount");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andAvailamountIsNull() {
      addCriterion("availAmount is null");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andAvailamountIsNotNull() {
      addCriterion("availAmount is not null");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andAvailamountEqualTo(BigDecimal value) {
      addCriterion("availAmount =", value, "availamount");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andAvailamountNotEqualTo(BigDecimal value) {
      addCriterion("availAmount <>", value, "availamount");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andAvailamountGreaterThan(BigDecimal value) {
      addCriterion("availAmount >", value, "availamount");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andAvailamountGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("availAmount >=", value, "availamount");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andAvailamountLessThan(BigDecimal value) {
      addCriterion("availAmount <", value, "availamount");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andAvailamountLessThanOrEqualTo(BigDecimal value) {
      addCriterion("availAmount <=", value, "availamount");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andAvailamountIn(List<BigDecimal> values) {
      addCriterion("availAmount in", values, "availamount");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andAvailamountNotIn(List<BigDecimal> values) {
      addCriterion("availAmount not in", values, "availamount");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andAvailamountBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("availAmount between", value1, value2, "availamount");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andAvailamountNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("availAmount not between", value1, value2, "availamount");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andCurrencyIsNull() {
      addCriterion("Currency is null");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andCurrencyIsNotNull() {
      addCriterion("Currency is not null");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andCurrencyEqualTo(String value) {
      addCriterion("Currency =", value, "currency");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andCurrencyNotEqualTo(String value) {
      addCriterion("Currency <>", value, "currency");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andCurrencyGreaterThan(String value) {
      addCriterion("Currency >", value, "currency");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andCurrencyGreaterThanOrEqualTo(String value) {
      addCriterion("Currency >=", value, "currency");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andCurrencyLessThan(String value) {
      addCriterion("Currency <", value, "currency");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andCurrencyLessThanOrEqualTo(String value) {
      addCriterion("Currency <=", value, "currency");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andCurrencyLike(String value) {
      addCriterion("Currency like", value, "currency");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andCurrencyNotLike(String value) {
      addCriterion("Currency not like", value, "currency");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andCurrencyIn(List<String> values) {
      addCriterion("Currency in", values, "currency");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andCurrencyNotIn(List<String> values) {
      addCriterion("Currency not in", values, "currency");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andCurrencyBetween(String value1, String value2) {
      addCriterion("Currency between", value1, value2, "currency");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andCurrencyNotBetween(String value1, String value2) {
      addCriterion("Currency not between", value1, value2, "currency");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPaymemberidIsNull() {
      addCriterion("paymemberid is null");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPaymemberidIsNotNull() {
      addCriterion("paymemberid is not null");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPaymemberidEqualTo(Integer value) {
      addCriterion("paymemberid =", value, "paymemberid");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPaymemberidNotEqualTo(Integer value) {
      addCriterion("paymemberid <>", value, "paymemberid");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPaymemberidGreaterThan(Integer value) {
      addCriterion("paymemberid >", value, "paymemberid");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPaymemberidGreaterThanOrEqualTo(Integer value) {
      addCriterion("paymemberid >=", value, "paymemberid");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPaymemberidLessThan(Integer value) {
      addCriterion("paymemberid <", value, "paymemberid");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPaymemberidLessThanOrEqualTo(Integer value) {
      addCriterion("paymemberid <=", value, "paymemberid");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPaymemberidIn(List<Integer> values) {
      addCriterion("paymemberid in", values, "paymemberid");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPaymemberidNotIn(List<Integer> values) {
      addCriterion("paymemberid not in", values, "paymemberid");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPaymemberidBetween(Integer value1, Integer value2) {
      addCriterion("paymemberid between", value1, value2, "paymemberid");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPaymemberidNotBetween(Integer value1, Integer value2) {
      addCriterion("paymemberid not between", value1, value2, "paymemberid");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPayaccountidIsNull() {
      addCriterion("PayAccountId is null");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPayaccountidIsNotNull() {
      addCriterion("PayAccountId is not null");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPayaccountidEqualTo(Long value) {
      addCriterion("PayAccountId =", value, "payaccountid");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPayaccountidNotEqualTo(Long value) {
      addCriterion("PayAccountId <>", value, "payaccountid");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPayaccountidGreaterThan(Long value) {
      addCriterion("PayAccountId >", value, "payaccountid");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPayaccountidGreaterThanOrEqualTo(Long value) {
      addCriterion("PayAccountId >=", value, "payaccountid");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPayaccountidLessThan(Long value) {
      addCriterion("PayAccountId <", value, "payaccountid");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPayaccountidLessThanOrEqualTo(Long value) {
      addCriterion("PayAccountId <=", value, "payaccountid");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPayaccountidIn(List<Long> values) {
      addCriterion("PayAccountId in", values, "payaccountid");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPayaccountidNotIn(List<Long> values) {
      addCriterion("PayAccountId not in", values, "payaccountid");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPayaccountidBetween(Long value1, Long value2) {
      addCriterion("PayAccountId between", value1, value2, "payaccountid");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPayaccountidNotBetween(Long value1, Long value2) {
      addCriterion("PayAccountId not between", value1, value2, "payaccountid");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPayaccountnoIsNull() {
      addCriterion("PayAccountNo is null");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPayaccountnoIsNotNull() {
      addCriterion("PayAccountNo is not null");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPayaccountnoEqualTo(String value) {
      addCriterion("PayAccountNo =", value, "payaccountno");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPayaccountnoNotEqualTo(String value) {
      addCriterion("PayAccountNo <>", value, "payaccountno");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPayaccountnoGreaterThan(String value) {
      addCriterion("PayAccountNo >", value, "payaccountno");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPayaccountnoGreaterThanOrEqualTo(String value) {
      addCriterion("PayAccountNo >=", value, "payaccountno");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPayaccountnoLessThan(String value) {
      addCriterion("PayAccountNo <", value, "payaccountno");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPayaccountnoLessThanOrEqualTo(String value) {
      addCriterion("PayAccountNo <=", value, "payaccountno");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPayaccountnoLike(String value) {
      addCriterion("PayAccountNo like", value, "payaccountno");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPayaccountnoNotLike(String value) {
      addCriterion("PayAccountNo not like", value, "payaccountno");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPayaccountnoIn(List<String> values) {
      addCriterion("PayAccountNo in", values, "payaccountno");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPayaccountnoNotIn(List<String> values) {
      addCriterion("PayAccountNo not in", values, "payaccountno");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPayaccountnoBetween(String value1, String value2) {
      addCriterion("PayAccountNo between", value1, value2, "payaccountno");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPayaccountnoNotBetween(String value1, String value2) {
      addCriterion("PayAccountNo not between", value1, value2, "payaccountno");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPayernameIsNull() {
      addCriterion("PayerName is null");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPayernameIsNotNull() {
      addCriterion("PayerName is not null");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPayernameEqualTo(String value) {
      addCriterion("PayerName =", value, "payername");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPayernameNotEqualTo(String value) {
      addCriterion("PayerName <>", value, "payername");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPayernameGreaterThan(String value) {
      addCriterion("PayerName >", value, "payername");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPayernameGreaterThanOrEqualTo(String value) {
      addCriterion("PayerName >=", value, "payername");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPayernameLessThan(String value) {
      addCriterion("PayerName <", value, "payername");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPayernameLessThanOrEqualTo(String value) {
      addCriterion("PayerName <=", value, "payername");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPayernameLike(String value) {
      addCriterion("PayerName like", value, "payername");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPayernameNotLike(String value) {
      addCriterion("PayerName not like", value, "payername");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPayernameIn(List<String> values) {
      addCriterion("PayerName in", values, "payername");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPayernameNotIn(List<String> values) {
      addCriterion("PayerName not in", values, "payername");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPayernameBetween(String value1, String value2) {
      addCriterion("PayerName between", value1, value2, "payername");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPayernameNotBetween(String value1, String value2) {
      addCriterion("PayerName not between", value1, value2, "payername");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPaycardnumIsNull() {
      addCriterion("PayCardNum is null");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPaycardnumIsNotNull() {
      addCriterion("PayCardNum is not null");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPaycardnumEqualTo(String value) {
      addCriterion("PayCardNum =", value, "paycardnum");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPaycardnumNotEqualTo(String value) {
      addCriterion("PayCardNum <>", value, "paycardnum");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPaycardnumGreaterThan(String value) {
      addCriterion("PayCardNum >", value, "paycardnum");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPaycardnumGreaterThanOrEqualTo(String value) {
      addCriterion("PayCardNum >=", value, "paycardnum");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPaycardnumLessThan(String value) {
      addCriterion("PayCardNum <", value, "paycardnum");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPaycardnumLessThanOrEqualTo(String value) {
      addCriterion("PayCardNum <=", value, "paycardnum");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPaycardnumLike(String value) {
      addCriterion("PayCardNum like", value, "paycardnum");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPaycardnumNotLike(String value) {
      addCriterion("PayCardNum not like", value, "paycardnum");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPaycardnumIn(List<String> values) {
      addCriterion("PayCardNum in", values, "paycardnum");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPaycardnumNotIn(List<String> values) {
      addCriterion("PayCardNum not in", values, "paycardnum");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPaycardnumBetween(String value1, String value2) {
      addCriterion("PayCardNum between", value1, value2, "paycardnum");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPaycardnumNotBetween(String value1, String value2) {
      addCriterion("PayCardNum not between", value1, value2, "paycardnum");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPayaccounttypeIsNull() {
      addCriterion("PayAccountType is null");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPayaccounttypeIsNotNull() {
      addCriterion("PayAccountType is not null");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPayaccounttypeEqualTo(Integer value) {
      addCriterion("PayAccountType =", value, "payaccounttype");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPayaccounttypeNotEqualTo(Integer value) {
      addCriterion("PayAccountType <>", value, "payaccounttype");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPayaccounttypeGreaterThan(Integer value) {
      addCriterion("PayAccountType >", value, "payaccounttype");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPayaccounttypeGreaterThanOrEqualTo(Integer value) {
      addCriterion("PayAccountType >=", value, "payaccounttype");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPayaccounttypeLessThan(Integer value) {
      addCriterion("PayAccountType <", value, "payaccounttype");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPayaccounttypeLessThanOrEqualTo(Integer value) {
      addCriterion("PayAccountType <=", value, "payaccounttype");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPayaccounttypeIn(List<Integer> values) {
      addCriterion("PayAccountType in", values, "payaccounttype");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPayaccounttypeNotIn(List<Integer> values) {
      addCriterion("PayAccountType not in", values, "payaccounttype");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPayaccounttypeBetween(Integer value1, Integer value2) {
      addCriterion("PayAccountType between", value1, value2, "payaccounttype");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPayaccounttypeNotBetween(Integer value1, Integer value2) {
      addCriterion("PayAccountType not between", value1, value2, "payaccounttype");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPayeememberidIsNull() {
      addCriterion("payeememberid is null");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPayeememberidIsNotNull() {
      addCriterion("payeememberid is not null");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPayeememberidEqualTo(Integer value) {
      addCriterion("payeememberid =", value, "payeememberid");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPayeememberidNotEqualTo(Integer value) {
      addCriterion("payeememberid <>", value, "payeememberid");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPayeememberidGreaterThan(Integer value) {
      addCriterion("payeememberid >", value, "payeememberid");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPayeememberidGreaterThanOrEqualTo(Integer value) {
      addCriterion("payeememberid >=", value, "payeememberid");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPayeememberidLessThan(Integer value) {
      addCriterion("payeememberid <", value, "payeememberid");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPayeememberidLessThanOrEqualTo(Integer value) {
      addCriterion("payeememberid <=", value, "payeememberid");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPayeememberidIn(List<Integer> values) {
      addCriterion("payeememberid in", values, "payeememberid");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPayeememberidNotIn(List<Integer> values) {
      addCriterion("payeememberid not in", values, "payeememberid");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPayeememberidBetween(Integer value1, Integer value2) {
      addCriterion("payeememberid between", value1, value2, "payeememberid");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPayeememberidNotBetween(Integer value1, Integer value2) {
      addCriterion("payeememberid not between", value1, value2, "payeememberid");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPayeeaccountidIsNull() {
      addCriterion("PayeeAccountId is null");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPayeeaccountidIsNotNull() {
      addCriterion("PayeeAccountId is not null");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPayeeaccountidEqualTo(Long value) {
      addCriterion("PayeeAccountId =", value, "payeeaccountid");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPayeeaccountidNotEqualTo(Long value) {
      addCriterion("PayeeAccountId <>", value, "payeeaccountid");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPayeeaccountidGreaterThan(Long value) {
      addCriterion("PayeeAccountId >", value, "payeeaccountid");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPayeeaccountidGreaterThanOrEqualTo(Long value) {
      addCriterion("PayeeAccountId >=", value, "payeeaccountid");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPayeeaccountidLessThan(Long value) {
      addCriterion("PayeeAccountId <", value, "payeeaccountid");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPayeeaccountidLessThanOrEqualTo(Long value) {
      addCriterion("PayeeAccountId <=", value, "payeeaccountid");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPayeeaccountidIn(List<Long> values) {
      addCriterion("PayeeAccountId in", values, "payeeaccountid");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPayeeaccountidNotIn(List<Long> values) {
      addCriterion("PayeeAccountId not in", values, "payeeaccountid");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPayeeaccountidBetween(Long value1, Long value2) {
      addCriterion("PayeeAccountId between", value1, value2, "payeeaccountid");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPayeeaccountidNotBetween(Long value1, Long value2) {
      addCriterion("PayeeAccountId not between", value1, value2, "payeeaccountid");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPayeeaccountnoIsNull() {
      addCriterion("PayeeAccountNo is null");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPayeeaccountnoIsNotNull() {
      addCriterion("PayeeAccountNo is not null");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPayeeaccountnoEqualTo(String value) {
      addCriterion("PayeeAccountNo =", value, "payeeaccountno");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPayeeaccountnoNotEqualTo(String value) {
      addCriterion("PayeeAccountNo <>", value, "payeeaccountno");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPayeeaccountnoGreaterThan(String value) {
      addCriterion("PayeeAccountNo >", value, "payeeaccountno");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPayeeaccountnoGreaterThanOrEqualTo(String value) {
      addCriterion("PayeeAccountNo >=", value, "payeeaccountno");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPayeeaccountnoLessThan(String value) {
      addCriterion("PayeeAccountNo <", value, "payeeaccountno");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPayeeaccountnoLessThanOrEqualTo(String value) {
      addCriterion("PayeeAccountNo <=", value, "payeeaccountno");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPayeeaccountnoLike(String value) {
      addCriterion("PayeeAccountNo like", value, "payeeaccountno");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPayeeaccountnoNotLike(String value) {
      addCriterion("PayeeAccountNo not like", value, "payeeaccountno");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPayeeaccountnoIn(List<String> values) {
      addCriterion("PayeeAccountNo in", values, "payeeaccountno");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPayeeaccountnoNotIn(List<String> values) {
      addCriterion("PayeeAccountNo not in", values, "payeeaccountno");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPayeeaccountnoBetween(String value1, String value2) {
      addCriterion("PayeeAccountNo between", value1, value2, "payeeaccountno");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPayeeaccountnoNotBetween(String value1, String value2) {
      addCriterion("PayeeAccountNo not between", value1, value2, "payeeaccountno");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPayeenameIsNull() {
      addCriterion("PayeeName is null");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPayeenameIsNotNull() {
      addCriterion("PayeeName is not null");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPayeenameEqualTo(String value) {
      addCriterion("PayeeName =", value, "payeename");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPayeenameNotEqualTo(String value) {
      addCriterion("PayeeName <>", value, "payeename");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPayeenameGreaterThan(String value) {
      addCriterion("PayeeName >", value, "payeename");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPayeenameGreaterThanOrEqualTo(String value) {
      addCriterion("PayeeName >=", value, "payeename");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPayeenameLessThan(String value) {
      addCriterion("PayeeName <", value, "payeename");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPayeenameLessThanOrEqualTo(String value) {
      addCriterion("PayeeName <=", value, "payeename");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPayeenameLike(String value) {
      addCriterion("PayeeName like", value, "payeename");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPayeenameNotLike(String value) {
      addCriterion("PayeeName not like", value, "payeename");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPayeenameIn(List<String> values) {
      addCriterion("PayeeName in", values, "payeename");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPayeenameNotIn(List<String> values) {
      addCriterion("PayeeName not in", values, "payeename");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPayeenameBetween(String value1, String value2) {
      addCriterion("PayeeName between", value1, value2, "payeename");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPayeenameNotBetween(String value1, String value2) {
      addCriterion("PayeeName not between", value1, value2, "payeename");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPayeecardnumIsNull() {
      addCriterion("PayeeCardNum is null");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPayeecardnumIsNotNull() {
      addCriterion("PayeeCardNum is not null");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPayeecardnumEqualTo(String value) {
      addCriterion("PayeeCardNum =", value, "payeecardnum");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPayeecardnumNotEqualTo(String value) {
      addCriterion("PayeeCardNum <>", value, "payeecardnum");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPayeecardnumGreaterThan(String value) {
      addCriterion("PayeeCardNum >", value, "payeecardnum");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPayeecardnumGreaterThanOrEqualTo(String value) {
      addCriterion("PayeeCardNum >=", value, "payeecardnum");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPayeecardnumLessThan(String value) {
      addCriterion("PayeeCardNum <", value, "payeecardnum");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPayeecardnumLessThanOrEqualTo(String value) {
      addCriterion("PayeeCardNum <=", value, "payeecardnum");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPayeecardnumLike(String value) {
      addCriterion("PayeeCardNum like", value, "payeecardnum");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPayeecardnumNotLike(String value) {
      addCriterion("PayeeCardNum not like", value, "payeecardnum");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPayeecardnumIn(List<String> values) {
      addCriterion("PayeeCardNum in", values, "payeecardnum");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPayeecardnumNotIn(List<String> values) {
      addCriterion("PayeeCardNum not in", values, "payeecardnum");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPayeecardnumBetween(String value1, String value2) {
      addCriterion("PayeeCardNum between", value1, value2, "payeecardnum");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPayeecardnumNotBetween(String value1, String value2) {
      addCriterion("PayeeCardNum not between", value1, value2, "payeecardnum");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPayeeaccounttypeIsNull() {
      addCriterion("PayeeAccountType is null");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPayeeaccounttypeIsNotNull() {
      addCriterion("PayeeAccountType is not null");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPayeeaccounttypeEqualTo(Integer value) {
      addCriterion("PayeeAccountType =", value, "payeeaccounttype");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPayeeaccounttypeNotEqualTo(Integer value) {
      addCriterion("PayeeAccountType <>", value, "payeeaccounttype");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPayeeaccounttypeGreaterThan(Integer value) {
      addCriterion("PayeeAccountType >", value, "payeeaccounttype");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPayeeaccounttypeGreaterThanOrEqualTo(Integer value) {
      addCriterion("PayeeAccountType >=", value, "payeeaccounttype");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPayeeaccounttypeLessThan(Integer value) {
      addCriterion("PayeeAccountType <", value, "payeeaccounttype");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPayeeaccounttypeLessThanOrEqualTo(Integer value) {
      addCriterion("PayeeAccountType <=", value, "payeeaccounttype");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPayeeaccounttypeIn(List<Integer> values) {
      addCriterion("PayeeAccountType in", values, "payeeaccounttype");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPayeeaccounttypeNotIn(List<Integer> values) {
      addCriterion("PayeeAccountType not in", values, "payeeaccounttype");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPayeeaccounttypeBetween(Integer value1, Integer value2) {
      addCriterion("PayeeAccountType between", value1, value2, "payeeaccounttype");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andPayeeaccounttypeNotBetween(Integer value1, Integer value2) {
      addCriterion("PayeeAccountType not between", value1, value2, "payeeaccounttype");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andTransstatusIsNull() {
      addCriterion("TransStatus is null");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andTransstatusIsNotNull() {
      addCriterion("TransStatus is not null");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andTransstatusEqualTo(Integer value) {
      addCriterion("TransStatus =", value, "transstatus");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andTransstatusNotEqualTo(Integer value) {
      addCriterion("TransStatus <>", value, "transstatus");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andTransstatusGreaterThan(Integer value) {
      addCriterion("TransStatus >", value, "transstatus");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andTransstatusGreaterThanOrEqualTo(Integer value) {
      addCriterion("TransStatus >=", value, "transstatus");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andTransstatusLessThan(Integer value) {
      addCriterion("TransStatus <", value, "transstatus");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andTransstatusLessThanOrEqualTo(Integer value) {
      addCriterion("TransStatus <=", value, "transstatus");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andTransstatusIn(List<Integer> values) {
      addCriterion("TransStatus in", values, "transstatus");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andTransstatusNotIn(List<Integer> values) {
      addCriterion("TransStatus not in", values, "transstatus");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andTransstatusBetween(Integer value1, Integer value2) {
      addCriterion("TransStatus between", value1, value2, "transstatus");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andTransstatusNotBetween(Integer value1, Integer value2) {
      addCriterion("TransStatus not between", value1, value2, "transstatus");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andStaffNoIsNull() {
      addCriterion("STAFF_NO is null");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andStaffNoIsNotNull() {
      addCriterion("STAFF_NO is not null");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andStaffNoEqualTo(String value) {
      addCriterion("STAFF_NO =", value, "staffNo");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andStaffNoNotEqualTo(String value) {
      addCriterion("STAFF_NO <>", value, "staffNo");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andStaffNoGreaterThan(String value) {
      addCriterion("STAFF_NO >", value, "staffNo");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andStaffNoGreaterThanOrEqualTo(String value) {
      addCriterion("STAFF_NO >=", value, "staffNo");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andStaffNoLessThan(String value) {
      addCriterion("STAFF_NO <", value, "staffNo");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andStaffNoLessThanOrEqualTo(String value) {
      addCriterion("STAFF_NO <=", value, "staffNo");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andStaffNoLike(String value) {
      addCriterion("STAFF_NO like", value, "staffNo");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andStaffNoNotLike(String value) {
      addCriterion("STAFF_NO not like", value, "staffNo");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andStaffNoIn(List<String> values) {
      addCriterion("STAFF_NO in", values, "staffNo");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andStaffNoNotIn(List<String> values) {
      addCriterion("STAFF_NO not in", values, "staffNo");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andStaffNoBetween(String value1, String value2) {
      addCriterion("STAFF_NO between", value1, value2, "staffNo");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andStaffNoNotBetween(String value1, String value2) {
      addCriterion("STAFF_NO not between", value1, value2, "staffNo");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andRemarkIsNull() {
      addCriterion("remark is null");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andRemarkIsNotNull() {
      addCriterion("remark is not null");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andRemarkEqualTo(String value) {
      addCriterion("remark =", value, "remark");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andRemarkNotEqualTo(String value) {
      addCriterion("remark <>", value, "remark");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andRemarkGreaterThan(String value) {
      addCriterion("remark >", value, "remark");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andRemarkGreaterThanOrEqualTo(String value) {
      addCriterion("remark >=", value, "remark");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andRemarkLessThan(String value) {
      addCriterion("remark <", value, "remark");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andRemarkLessThanOrEqualTo(String value) {
      addCriterion("remark <=", value, "remark");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andRemarkLike(String value) {
      addCriterion("remark like", value, "remark");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andRemarkNotLike(String value) {
      addCriterion("remark not like", value, "remark");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andRemarkIn(List<String> values) {
      addCriterion("remark in", values, "remark");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andRemarkNotIn(List<String> values) {
      addCriterion("remark not in", values, "remark");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andRemarkBetween(String value1, String value2) {
      addCriterion("remark between", value1, value2, "remark");
      return ((TranslogplatExample.Criteria)this);
    }

    public TranslogplatExample.Criteria andRemarkNotBetween(String value1, String value2) {
      addCriterion("remark not between", value1, value2, "remark");
      return ((TranslogplatExample.Criteria)this);
    }
  }
}