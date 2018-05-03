package com.zjgt.p2p.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springfk.pancloud.daoframework.page.PageExample;

public class TranslogExample extends PageExample
{
  protected String orderByClause;
  protected boolean distinct;
  protected Integer startPos;
  protected Integer pageSize;
  protected List<Criteria> oredCriteria;

  public TranslogExample()
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

  public static class Criteria extends TranslogExample.GeneratedCriteria
  {
  }

  protected static abstract class GeneratedCriteria
  {
    protected List<TranslogExample.Criterion> criteria;

    protected GeneratedCriteria()
    {
      this.criteria = new ArrayList();
    }

    public boolean isValid() {
      return (this.criteria.size() > 0);
    }

    public List<TranslogExample.Criterion> getAllCriteria() {
      return this.criteria;
    }

    public List<TranslogExample.Criterion> getCriteria() {
      return this.criteria;
    }

    protected void addCriterion(String condition) {
      if (condition == null) {
        throw new RuntimeException("Value for condition cannot be null");
      }
      this.criteria.add(new TranslogExample.Criterion(condition));
    }

    public void addCriterion(String condition, Object value, String property) {
      if (value == null) {
        throw new RuntimeException("Value for " + property + " cannot be null");
      }
      this.criteria.add(new TranslogExample.Criterion(condition, value));
    }

    public void addCriterion(String condition, Object value1, Object value2, String property) {
      if ((value1 == null) || (value2 == null)) {
        throw new RuntimeException("Between values for " + property + " cannot be null");
      }
      this.criteria.add(new TranslogExample.Criterion(condition, value1, value2));
    }

    public TranslogExample.Criteria andIdIsNull() {
      addCriterion("Id is null");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andIdIsNotNull() {
      addCriterion("Id is not null");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andIdEqualTo(Long value) {
      addCriterion("Id =", value, "id");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andIdNotEqualTo(Long value) {
      addCriterion("Id <>", value, "id");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andIdGreaterThan(Long value) {
      addCriterion("Id >", value, "id");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andIdGreaterThanOrEqualTo(Long value) {
      addCriterion("Id >=", value, "id");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andIdLessThan(Long value) {
      addCriterion("Id <", value, "id");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andIdLessThanOrEqualTo(Long value) {
      addCriterion("Id <=", value, "id");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andIdIn(List<Long> values) {
      addCriterion("Id in", values, "id");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andIdNotIn(List<Long> values) {
      addCriterion("Id not in", values, "id");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andIdBetween(Long value1, Long value2) {
      addCriterion("Id between", value1, value2, "id");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andIdNotBetween(Long value1, Long value2) {
      addCriterion("Id not between", value1, value2, "id");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andTransnoIsNull() {
      addCriterion("TransNo is null");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andTransnoIsNotNull() {
      addCriterion("TransNo is not null");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andTransnoEqualTo(String value) {
      addCriterion("TransNo =", value, "transno");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andTransnoNotEqualTo(String value) {
      addCriterion("TransNo <>", value, "transno");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andTransnoGreaterThan(String value) {
      addCriterion("TransNo >", value, "transno");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andTransnoGreaterThanOrEqualTo(String value) {
      addCriterion("TransNo >=", value, "transno");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andTransnoLessThan(String value) {
      addCriterion("TransNo <", value, "transno");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andTransnoLessThanOrEqualTo(String value) {
      addCriterion("TransNo <=", value, "transno");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andTransnoLike(String value) {
      addCriterion("TransNo like", value, "transno");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andTransnoNotLike(String value) {
      addCriterion("TransNo not like", value, "transno");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andTransnoIn(List<String> values) {
      addCriterion("TransNo in", values, "transno");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andTransnoNotIn(List<String> values) {
      addCriterion("TransNo not in", values, "transno");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andTransnoBetween(String value1, String value2) {
      addCriterion("TransNo between", value1, value2, "transno");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andTransnoNotBetween(String value1, String value2) {
      addCriterion("TransNo not between", value1, value2, "transno");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andTranstimeIsNull() {
      addCriterion("TransTime is null");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andTranstimeIsNotNull() {
      addCriterion("TransTime is not null");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andTranstimeEqualTo(Date value) {
      addCriterion("TransTime =", value, "transtime");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andTranstimeNotEqualTo(Date value) {
      addCriterion("TransTime <>", value, "transtime");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andTranstimeGreaterThan(Date value) {
      addCriterion("TransTime >", value, "transtime");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andTranstimeGreaterThanOrEqualTo(Date value) {
      addCriterion("TransTime >=", value, "transtime");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andTranstimeLessThan(Date value) {
      addCriterion("TransTime <", value, "transtime");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andTranstimeLessThanOrEqualTo(Date value) {
      addCriterion("TransTime <=", value, "transtime");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andTranstimeIn(List<Date> values) {
      addCriterion("TransTime in", values, "transtime");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andTranstimeNotIn(List<Date> values) {
      addCriterion("TransTime not in", values, "transtime");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andTranstimeBetween(Date value1, Date value2) {
      addCriterion("TransTime between", value1, value2, "transtime");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andTranstimeNotBetween(Date value1, Date value2) {
      addCriterion("TransTime not between", value1, value2, "transtime");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andTranscodeIsNull() {
      addCriterion("TransCode is null");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andTranscodeIsNotNull() {
      addCriterion("TransCode is not null");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andTranscodeEqualTo(String value) {
      addCriterion("TransCode =", value, "transcode");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andTranscodeNotEqualTo(String value) {
      addCriterion("TransCode <>", value, "transcode");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andTranscodeGreaterThan(String value) {
      addCriterion("TransCode >", value, "transcode");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andTranscodeGreaterThanOrEqualTo(String value) {
      addCriterion("TransCode >=", value, "transcode");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andTranscodeLessThan(String value) {
      addCriterion("TransCode <", value, "transcode");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andTranscodeLessThanOrEqualTo(String value) {
      addCriterion("TransCode <=", value, "transcode");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andTranscodeLike(String value) {
      addCriterion("TransCode like", value, "transcode");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andTranscodeNotLike(String value) {
      addCriterion("TransCode not like", value, "transcode");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andTranscodeIn(List<String> values) {
      addCriterion("TransCode in", values, "transcode");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andTranscodeNotIn(List<String> values) {
      addCriterion("TransCode not in", values, "transcode");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andTranscodeBetween(String value1, String value2) {
      addCriterion("TransCode between", value1, value2, "transcode");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andTranscodeNotBetween(String value1, String value2) {
      addCriterion("TransCode not between", value1, value2, "transcode");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andTransdescIsNull() {
      addCriterion("TransDesc is null");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andTransdescIsNotNull() {
      addCriterion("TransDesc is not null");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andTransdescEqualTo(String value) {
      addCriterion("TransDesc =", value, "transdesc");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andTransdescNotEqualTo(String value) {
      addCriterion("TransDesc <>", value, "transdesc");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andTransdescGreaterThan(String value) {
      addCriterion("TransDesc >", value, "transdesc");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andTransdescGreaterThanOrEqualTo(String value) {
      addCriterion("TransDesc >=", value, "transdesc");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andTransdescLessThan(String value) {
      addCriterion("TransDesc <", value, "transdesc");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andTransdescLessThanOrEqualTo(String value) {
      addCriterion("TransDesc <=", value, "transdesc");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andTransdescLike(String value) {
      addCriterion("TransDesc like", value, "transdesc");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andTransdescNotLike(String value) {
      addCriterion("TransDesc not like", value, "transdesc");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andTransdescIn(List<String> values) {
      addCriterion("TransDesc in", values, "transdesc");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andTransdescNotIn(List<String> values) {
      addCriterion("TransDesc not in", values, "transdesc");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andTransdescBetween(String value1, String value2) {
      addCriterion("TransDesc between", value1, value2, "transdesc");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andTransdescNotBetween(String value1, String value2) {
      addCriterion("TransDesc not between", value1, value2, "transdesc");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andAmountIsNull() {
      addCriterion("Amount is null");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andAmountIsNotNull() {
      addCriterion("Amount is not null");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andAmountEqualTo(BigDecimal value) {
      addCriterion("Amount =", value, "amount");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andAmountNotEqualTo(BigDecimal value) {
      addCriterion("Amount <>", value, "amount");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andAmountGreaterThan(BigDecimal value) {
      addCriterion("Amount >", value, "amount");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andAmountGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("Amount >=", value, "amount");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andAmountLessThan(BigDecimal value) {
      addCriterion("Amount <", value, "amount");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andAmountLessThanOrEqualTo(BigDecimal value) {
      addCriterion("Amount <=", value, "amount");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andAmountIn(List<BigDecimal> values) {
      addCriterion("Amount in", values, "amount");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andAmountNotIn(List<BigDecimal> values) {
      addCriterion("Amount not in", values, "amount");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andAmountBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("Amount between", value1, value2, "amount");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andAmountNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("Amount not between", value1, value2, "amount");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andAvailamountIsNull() {
      addCriterion("availAmount is null");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andAvailamountIsNotNull() {
      addCriterion("availAmount is not null");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andAvailamountEqualTo(BigDecimal value) {
      addCriterion("availAmount =", value, "availamount");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andAvailamountNotEqualTo(BigDecimal value) {
      addCriterion("availAmount <>", value, "availamount");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andAvailamountGreaterThan(BigDecimal value) {
      addCriterion("availAmount >", value, "availamount");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andAvailamountGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("availAmount >=", value, "availamount");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andAvailamountLessThan(BigDecimal value) {
      addCriterion("availAmount <", value, "availamount");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andAvailamountLessThanOrEqualTo(BigDecimal value) {
      addCriterion("availAmount <=", value, "availamount");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andAvailamountIn(List<BigDecimal> values) {
      addCriterion("availAmount in", values, "availamount");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andAvailamountNotIn(List<BigDecimal> values) {
      addCriterion("availAmount not in", values, "availamount");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andAvailamountBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("availAmount between", value1, value2, "availamount");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andAvailamountNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("availAmount not between", value1, value2, "availamount");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPlatavailamountIsNull() {
      addCriterion("platAvailAmount is null");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPlatavailamountIsNotNull() {
      addCriterion("platAvailAmount is not null");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPlatavailamountEqualTo(BigDecimal value) {
      addCriterion("platAvailAmount =", value, "platavailamount");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPlatavailamountNotEqualTo(BigDecimal value) {
      addCriterion("platAvailAmount <>", value, "platavailamount");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPlatavailamountGreaterThan(BigDecimal value) {
      addCriterion("platAvailAmount >", value, "platavailamount");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPlatavailamountGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("platAvailAmount >=", value, "platavailamount");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPlatavailamountLessThan(BigDecimal value) {
      addCriterion("platAvailAmount <", value, "platavailamount");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPlatavailamountLessThanOrEqualTo(BigDecimal value) {
      addCriterion("platAvailAmount <=", value, "platavailamount");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPlatavailamountIn(List<BigDecimal> values) {
      addCriterion("platAvailAmount in", values, "platavailamount");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPlatavailamountNotIn(List<BigDecimal> values) {
      addCriterion("platAvailAmount not in", values, "platavailamount");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPlatavailamountBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("platAvailAmount between", value1, value2, "platavailamount");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPlatavailamountNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("platAvailAmount not between", value1, value2, "platavailamount");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPaysubamountIsNull() {
      addCriterion("paySubAmount is null");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPaysubamountIsNotNull() {
      addCriterion("paySubAmount is not null");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPaysubamountEqualTo(BigDecimal value) {
      addCriterion("paySubAmount =", value, "paysubamount");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPaysubamountNotEqualTo(BigDecimal value) {
      addCriterion("paySubAmount <>", value, "paysubamount");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPaysubamountGreaterThan(BigDecimal value) {
      addCriterion("paySubAmount >", value, "paysubamount");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPaysubamountGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("paySubAmount >=", value, "paysubamount");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPaysubamountLessThan(BigDecimal value) {
      addCriterion("paySubAmount <", value, "paysubamount");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPaysubamountLessThanOrEqualTo(BigDecimal value) {
      addCriterion("paySubAmount <=", value, "paysubamount");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPaysubamountIn(List<BigDecimal> values) {
      addCriterion("paySubAmount in", values, "paysubamount");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPaysubamountNotIn(List<BigDecimal> values) {
      addCriterion("paySubAmount not in", values, "paysubamount");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPaysubamountBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("paySubAmount between", value1, value2, "paysubamount");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPaysubamountNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("paySubAmount not between", value1, value2, "paysubamount");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayeesubamountIsNull() {
      addCriterion("payeeSubAmount is null");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayeesubamountIsNotNull() {
      addCriterion("payeeSubAmount is not null");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayeesubamountEqualTo(BigDecimal value) {
      addCriterion("payeeSubAmount =", value, "payeesubamount");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayeesubamountNotEqualTo(BigDecimal value) {
      addCriterion("payeeSubAmount <>", value, "payeesubamount");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayeesubamountGreaterThan(BigDecimal value) {
      addCriterion("payeeSubAmount >", value, "payeesubamount");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayeesubamountGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("payeeSubAmount >=", value, "payeesubamount");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayeesubamountLessThan(BigDecimal value) {
      addCriterion("payeeSubAmount <", value, "payeesubamount");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayeesubamountLessThanOrEqualTo(BigDecimal value) {
      addCriterion("payeeSubAmount <=", value, "payeesubamount");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayeesubamountIn(List<BigDecimal> values) {
      addCriterion("payeeSubAmount in", values, "payeesubamount");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayeesubamountNotIn(List<BigDecimal> values) {
      addCriterion("payeeSubAmount not in", values, "payeesubamount");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayeesubamountBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("payeeSubAmount between", value1, value2, "payeesubamount");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayeesubamountNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("payeeSubAmount not between", value1, value2, "payeesubamount");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andCurrencyIsNull() {
      addCriterion("Currency is null");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andCurrencyIsNotNull() {
      addCriterion("Currency is not null");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andCurrencyEqualTo(String value) {
      addCriterion("Currency =", value, "currency");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andCurrencyNotEqualTo(String value) {
      addCriterion("Currency <>", value, "currency");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andCurrencyGreaterThan(String value) {
      addCriterion("Currency >", value, "currency");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andCurrencyGreaterThanOrEqualTo(String value) {
      addCriterion("Currency >=", value, "currency");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andCurrencyLessThan(String value) {
      addCriterion("Currency <", value, "currency");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andCurrencyLessThanOrEqualTo(String value) {
      addCriterion("Currency <=", value, "currency");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andCurrencyLike(String value) {
      addCriterion("Currency like", value, "currency");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andCurrencyNotLike(String value) {
      addCriterion("Currency not like", value, "currency");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andCurrencyIn(List<String> values) {
      addCriterion("Currency in", values, "currency");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andCurrencyNotIn(List<String> values) {
      addCriterion("Currency not in", values, "currency");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andCurrencyBetween(String value1, String value2) {
      addCriterion("Currency between", value1, value2, "currency");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andCurrencyNotBetween(String value1, String value2) {
      addCriterion("Currency not between", value1, value2, "currency");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPaymemberidIsNull() {
      addCriterion("paymemberid is null");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPaymemberidIsNotNull() {
      addCriterion("paymemberid is not null");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPaymemberidEqualTo(Integer value) {
      addCriterion("paymemberid =", value, "paymemberid");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPaymemberidNotEqualTo(Integer value) {
      addCriterion("paymemberid <>", value, "paymemberid");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPaymemberidGreaterThan(Integer value) {
      addCriterion("paymemberid >", value, "paymemberid");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPaymemberidGreaterThanOrEqualTo(Integer value) {
      addCriterion("paymemberid >=", value, "paymemberid");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPaymemberidLessThan(Integer value) {
      addCriterion("paymemberid <", value, "paymemberid");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPaymemberidLessThanOrEqualTo(Integer value) {
      addCriterion("paymemberid <=", value, "paymemberid");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPaymemberidIn(List<Integer> values) {
      addCriterion("paymemberid in", values, "paymemberid");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPaymemberidNotIn(List<Integer> values) {
      addCriterion("paymemberid not in", values, "paymemberid");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPaymemberidBetween(Integer value1, Integer value2) {
      addCriterion("paymemberid between", value1, value2, "paymemberid");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPaymemberidNotBetween(Integer value1, Integer value2) {
      addCriterion("paymemberid not between", value1, value2, "paymemberid");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayaccountidIsNull() {
      addCriterion("PayAccountId is null");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayaccountidIsNotNull() {
      addCriterion("PayAccountId is not null");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayaccountidEqualTo(Long value) {
      addCriterion("PayAccountId =", value, "payaccountid");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayaccountidNotEqualTo(Long value) {
      addCriterion("PayAccountId <>", value, "payaccountid");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayaccountidGreaterThan(Long value) {
      addCriterion("PayAccountId >", value, "payaccountid");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayaccountidGreaterThanOrEqualTo(Long value) {
      addCriterion("PayAccountId >=", value, "payaccountid");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayaccountidLessThan(Long value) {
      addCriterion("PayAccountId <", value, "payaccountid");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayaccountidLessThanOrEqualTo(Long value) {
      addCriterion("PayAccountId <=", value, "payaccountid");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayaccountidIn(List<Long> values) {
      addCriterion("PayAccountId in", values, "payaccountid");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayaccountidNotIn(List<Long> values) {
      addCriterion("PayAccountId not in", values, "payaccountid");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayaccountidBetween(Long value1, Long value2) {
      addCriterion("PayAccountId between", value1, value2, "payaccountid");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayaccountidNotBetween(Long value1, Long value2) {
      addCriterion("PayAccountId not between", value1, value2, "payaccountid");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayaccountnoIsNull() {
      addCriterion("PayAccountNo is null");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayaccountnoIsNotNull() {
      addCriterion("PayAccountNo is not null");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayaccountnoEqualTo(String value) {
      addCriterion("PayAccountNo =", value, "payaccountno");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayaccountnoNotEqualTo(String value) {
      addCriterion("PayAccountNo <>", value, "payaccountno");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayaccountnoGreaterThan(String value) {
      addCriterion("PayAccountNo >", value, "payaccountno");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayaccountnoGreaterThanOrEqualTo(String value) {
      addCriterion("PayAccountNo >=", value, "payaccountno");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayaccountnoLessThan(String value) {
      addCriterion("PayAccountNo <", value, "payaccountno");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayaccountnoLessThanOrEqualTo(String value) {
      addCriterion("PayAccountNo <=", value, "payaccountno");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayaccountnoLike(String value) {
      addCriterion("PayAccountNo like", value, "payaccountno");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayaccountnoNotLike(String value) {
      addCriterion("PayAccountNo not like", value, "payaccountno");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayaccountnoIn(List<String> values) {
      addCriterion("PayAccountNo in", values, "payaccountno");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayaccountnoNotIn(List<String> values) {
      addCriterion("PayAccountNo not in", values, "payaccountno");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayaccountnoBetween(String value1, String value2) {
      addCriterion("PayAccountNo between", value1, value2, "payaccountno");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayaccountnoNotBetween(String value1, String value2) {
      addCriterion("PayAccountNo not between", value1, value2, "payaccountno");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayernameIsNull() {
      addCriterion("PayerName is null");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayernameIsNotNull() {
      addCriterion("PayerName is not null");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayernameEqualTo(String value) {
      addCriterion("PayerName =", value, "payername");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayernameNotEqualTo(String value) {
      addCriterion("PayerName <>", value, "payername");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayernameGreaterThan(String value) {
      addCriterion("PayerName >", value, "payername");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayernameGreaterThanOrEqualTo(String value) {
      addCriterion("PayerName >=", value, "payername");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayernameLessThan(String value) {
      addCriterion("PayerName <", value, "payername");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayernameLessThanOrEqualTo(String value) {
      addCriterion("PayerName <=", value, "payername");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayernameLike(String value) {
      addCriterion("PayerName like", value, "payername");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayernameNotLike(String value) {
      addCriterion("PayerName not like", value, "payername");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayernameIn(List<String> values) {
      addCriterion("PayerName in", values, "payername");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayernameNotIn(List<String> values) {
      addCriterion("PayerName not in", values, "payername");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayernameBetween(String value1, String value2) {
      addCriterion("PayerName between", value1, value2, "payername");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayernameNotBetween(String value1, String value2) {
      addCriterion("PayerName not between", value1, value2, "payername");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPaycardnumIsNull() {
      addCriterion("PayCardNum is null");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPaycardnumIsNotNull() {
      addCriterion("PayCardNum is not null");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPaycardnumEqualTo(String value) {
      addCriterion("PayCardNum =", value, "paycardnum");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPaycardnumNotEqualTo(String value) {
      addCriterion("PayCardNum <>", value, "paycardnum");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPaycardnumGreaterThan(String value) {
      addCriterion("PayCardNum >", value, "paycardnum");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPaycardnumGreaterThanOrEqualTo(String value) {
      addCriterion("PayCardNum >=", value, "paycardnum");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPaycardnumLessThan(String value) {
      addCriterion("PayCardNum <", value, "paycardnum");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPaycardnumLessThanOrEqualTo(String value) {
      addCriterion("PayCardNum <=", value, "paycardnum");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPaycardnumLike(String value) {
      addCriterion("PayCardNum like", value, "paycardnum");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPaycardnumNotLike(String value) {
      addCriterion("PayCardNum not like", value, "paycardnum");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPaycardnumIn(List<String> values) {
      addCriterion("PayCardNum in", values, "paycardnum");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPaycardnumNotIn(List<String> values) {
      addCriterion("PayCardNum not in", values, "paycardnum");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPaycardnumBetween(String value1, String value2) {
      addCriterion("PayCardNum between", value1, value2, "paycardnum");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPaycardnumNotBetween(String value1, String value2) {
      addCriterion("PayCardNum not between", value1, value2, "paycardnum");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayaccounttypeIsNull() {
      addCriterion("PayAccountType is null");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayaccounttypeIsNotNull() {
      addCriterion("PayAccountType is not null");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayaccounttypeEqualTo(Integer value) {
      addCriterion("PayAccountType =", value, "payaccounttype");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayaccounttypeNotEqualTo(Integer value) {
      addCriterion("PayAccountType <>", value, "payaccounttype");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayaccounttypeGreaterThan(Integer value) {
      addCriterion("PayAccountType >", value, "payaccounttype");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayaccounttypeGreaterThanOrEqualTo(Integer value) {
      addCriterion("PayAccountType >=", value, "payaccounttype");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayaccounttypeLessThan(Integer value) {
      addCriterion("PayAccountType <", value, "payaccounttype");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayaccounttypeLessThanOrEqualTo(Integer value) {
      addCriterion("PayAccountType <=", value, "payaccounttype");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayaccounttypeIn(List<Integer> values) {
      addCriterion("PayAccountType in", values, "payaccounttype");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayaccounttypeNotIn(List<Integer> values) {
      addCriterion("PayAccountType not in", values, "payaccounttype");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayaccounttypeBetween(Integer value1, Integer value2) {
      addCriterion("PayAccountType between", value1, value2, "payaccounttype");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayaccounttypeNotBetween(Integer value1, Integer value2) {
      addCriterion("PayAccountType not between", value1, value2, "payaccounttype");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayeememberidIsNull() {
      addCriterion("payeememberid is null");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayeememberidIsNotNull() {
      addCriterion("payeememberid is not null");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayeememberidEqualTo(Integer value) {
      addCriterion("payeememberid =", value, "payeememberid");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayeememberidNotEqualTo(Integer value) {
      addCriterion("payeememberid <>", value, "payeememberid");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayeememberidGreaterThan(Integer value) {
      addCriterion("payeememberid >", value, "payeememberid");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayeememberidGreaterThanOrEqualTo(Integer value) {
      addCriterion("payeememberid >=", value, "payeememberid");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayeememberidLessThan(Integer value) {
      addCriterion("payeememberid <", value, "payeememberid");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayeememberidLessThanOrEqualTo(Integer value) {
      addCriterion("payeememberid <=", value, "payeememberid");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayeememberidIn(List<Integer> values) {
      addCriterion("payeememberid in", values, "payeememberid");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayeememberidNotIn(List<Integer> values) {
      addCriterion("payeememberid not in", values, "payeememberid");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayeememberidBetween(Integer value1, Integer value2) {
      addCriterion("payeememberid between", value1, value2, "payeememberid");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayeememberidNotBetween(Integer value1, Integer value2) {
      addCriterion("payeememberid not between", value1, value2, "payeememberid");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayeeaccountidIsNull() {
      addCriterion("PayeeAccountId is null");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayeeaccountidIsNotNull() {
      addCriterion("PayeeAccountId is not null");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayeeaccountidEqualTo(Long value) {
      addCriterion("PayeeAccountId =", value, "payeeaccountid");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayeeaccountidNotEqualTo(Long value) {
      addCriterion("PayeeAccountId <>", value, "payeeaccountid");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayeeaccountidGreaterThan(Long value) {
      addCriterion("PayeeAccountId >", value, "payeeaccountid");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayeeaccountidGreaterThanOrEqualTo(Long value) {
      addCriterion("PayeeAccountId >=", value, "payeeaccountid");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayeeaccountidLessThan(Long value) {
      addCriterion("PayeeAccountId <", value, "payeeaccountid");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayeeaccountidLessThanOrEqualTo(Long value) {
      addCriterion("PayeeAccountId <=", value, "payeeaccountid");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayeeaccountidIn(List<Long> values) {
      addCriterion("PayeeAccountId in", values, "payeeaccountid");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayeeaccountidNotIn(List<Long> values) {
      addCriterion("PayeeAccountId not in", values, "payeeaccountid");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayeeaccountidBetween(Long value1, Long value2) {
      addCriterion("PayeeAccountId between", value1, value2, "payeeaccountid");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayeeaccountidNotBetween(Long value1, Long value2) {
      addCriterion("PayeeAccountId not between", value1, value2, "payeeaccountid");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayeeaccountnoIsNull() {
      addCriterion("PayeeAccountNo is null");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayeeaccountnoIsNotNull() {
      addCriterion("PayeeAccountNo is not null");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayeeaccountnoEqualTo(String value) {
      addCriterion("PayeeAccountNo =", value, "payeeaccountno");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayeeaccountnoNotEqualTo(String value) {
      addCriterion("PayeeAccountNo <>", value, "payeeaccountno");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayeeaccountnoGreaterThan(String value) {
      addCriterion("PayeeAccountNo >", value, "payeeaccountno");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayeeaccountnoGreaterThanOrEqualTo(String value) {
      addCriterion("PayeeAccountNo >=", value, "payeeaccountno");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayeeaccountnoLessThan(String value) {
      addCriterion("PayeeAccountNo <", value, "payeeaccountno");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayeeaccountnoLessThanOrEqualTo(String value) {
      addCriterion("PayeeAccountNo <=", value, "payeeaccountno");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayeeaccountnoLike(String value) {
      addCriterion("PayeeAccountNo like", value, "payeeaccountno");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayeeaccountnoNotLike(String value) {
      addCriterion("PayeeAccountNo not like", value, "payeeaccountno");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayeeaccountnoIn(List<String> values) {
      addCriterion("PayeeAccountNo in", values, "payeeaccountno");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayeeaccountnoNotIn(List<String> values) {
      addCriterion("PayeeAccountNo not in", values, "payeeaccountno");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayeeaccountnoBetween(String value1, String value2) {
      addCriterion("PayeeAccountNo between", value1, value2, "payeeaccountno");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayeeaccountnoNotBetween(String value1, String value2) {
      addCriterion("PayeeAccountNo not between", value1, value2, "payeeaccountno");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayeenameIsNull() {
      addCriterion("PayeeName is null");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayeenameIsNotNull() {
      addCriterion("PayeeName is not null");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayeenameEqualTo(String value) {
      addCriterion("PayeeName =", value, "payeename");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayeenameNotEqualTo(String value) {
      addCriterion("PayeeName <>", value, "payeename");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayeenameGreaterThan(String value) {
      addCriterion("PayeeName >", value, "payeename");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayeenameGreaterThanOrEqualTo(String value) {
      addCriterion("PayeeName >=", value, "payeename");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayeenameLessThan(String value) {
      addCriterion("PayeeName <", value, "payeename");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayeenameLessThanOrEqualTo(String value) {
      addCriterion("PayeeName <=", value, "payeename");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayeenameLike(String value) {
      addCriterion("PayeeName like", value, "payeename");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayeenameNotLike(String value) {
      addCriterion("PayeeName not like", value, "payeename");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayeenameIn(List<String> values) {
      addCriterion("PayeeName in", values, "payeename");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayeenameNotIn(List<String> values) {
      addCriterion("PayeeName not in", values, "payeename");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayeenameBetween(String value1, String value2) {
      addCriterion("PayeeName between", value1, value2, "payeename");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayeenameNotBetween(String value1, String value2) {
      addCriterion("PayeeName not between", value1, value2, "payeename");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayeecardnumIsNull() {
      addCriterion("PayeeCardNum is null");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayeecardnumIsNotNull() {
      addCriterion("PayeeCardNum is not null");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayeecardnumEqualTo(String value) {
      addCriterion("PayeeCardNum =", value, "payeecardnum");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayeecardnumNotEqualTo(String value) {
      addCriterion("PayeeCardNum <>", value, "payeecardnum");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayeecardnumGreaterThan(String value) {
      addCriterion("PayeeCardNum >", value, "payeecardnum");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayeecardnumGreaterThanOrEqualTo(String value) {
      addCriterion("PayeeCardNum >=", value, "payeecardnum");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayeecardnumLessThan(String value) {
      addCriterion("PayeeCardNum <", value, "payeecardnum");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayeecardnumLessThanOrEqualTo(String value) {
      addCriterion("PayeeCardNum <=", value, "payeecardnum");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayeecardnumLike(String value) {
      addCriterion("PayeeCardNum like", value, "payeecardnum");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayeecardnumNotLike(String value) {
      addCriterion("PayeeCardNum not like", value, "payeecardnum");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayeecardnumIn(List<String> values) {
      addCriterion("PayeeCardNum in", values, "payeecardnum");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayeecardnumNotIn(List<String> values) {
      addCriterion("PayeeCardNum not in", values, "payeecardnum");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayeecardnumBetween(String value1, String value2) {
      addCriterion("PayeeCardNum between", value1, value2, "payeecardnum");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayeecardnumNotBetween(String value1, String value2) {
      addCriterion("PayeeCardNum not between", value1, value2, "payeecardnum");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayeeaccounttypeIsNull() {
      addCriterion("PayeeAccountType is null");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayeeaccounttypeIsNotNull() {
      addCriterion("PayeeAccountType is not null");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayeeaccounttypeEqualTo(Integer value) {
      addCriterion("PayeeAccountType =", value, "payeeaccounttype");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayeeaccounttypeNotEqualTo(Integer value) {
      addCriterion("PayeeAccountType <>", value, "payeeaccounttype");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayeeaccounttypeGreaterThan(Integer value) {
      addCriterion("PayeeAccountType >", value, "payeeaccounttype");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayeeaccounttypeGreaterThanOrEqualTo(Integer value) {
      addCriterion("PayeeAccountType >=", value, "payeeaccounttype");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayeeaccounttypeLessThan(Integer value) {
      addCriterion("PayeeAccountType <", value, "payeeaccounttype");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayeeaccounttypeLessThanOrEqualTo(Integer value) {
      addCriterion("PayeeAccountType <=", value, "payeeaccounttype");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayeeaccounttypeIn(List<Integer> values) {
      addCriterion("PayeeAccountType in", values, "payeeaccounttype");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayeeaccounttypeNotIn(List<Integer> values) {
      addCriterion("PayeeAccountType not in", values, "payeeaccounttype");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayeeaccounttypeBetween(Integer value1, Integer value2) {
      addCriterion("PayeeAccountType between", value1, value2, "payeeaccounttype");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andPayeeaccounttypeNotBetween(Integer value1, Integer value2) {
      addCriterion("PayeeAccountType not between", value1, value2, "payeeaccounttype");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andTransstatusIsNull() {
      addCriterion("TransStatus is null");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andTransstatusIsNotNull() {
      addCriterion("TransStatus is not null");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andTransstatusEqualTo(Integer value) {
      addCriterion("TransStatus =", value, "transstatus");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andTransstatusNotEqualTo(Integer value) {
      addCriterion("TransStatus <>", value, "transstatus");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andTransstatusGreaterThan(Integer value) {
      addCriterion("TransStatus >", value, "transstatus");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andTransstatusGreaterThanOrEqualTo(Integer value) {
      addCriterion("TransStatus >=", value, "transstatus");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andTransstatusLessThan(Integer value) {
      addCriterion("TransStatus <", value, "transstatus");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andTransstatusLessThanOrEqualTo(Integer value) {
      addCriterion("TransStatus <=", value, "transstatus");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andTransstatusIn(List<Integer> values) {
      addCriterion("TransStatus in", values, "transstatus");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andTransstatusNotIn(List<Integer> values) {
      addCriterion("TransStatus not in", values, "transstatus");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andTransstatusBetween(Integer value1, Integer value2) {
      addCriterion("TransStatus between", value1, value2, "transstatus");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andTransstatusNotBetween(Integer value1, Integer value2) {
      addCriterion("TransStatus not between", value1, value2, "transstatus");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andMemberidIsNull() {
      addCriterion("memberid is null");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andMemberidIsNotNull() {
      addCriterion("memberid is not null");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andMemberidEqualTo(Integer value) {
      addCriterion("memberid =", value, "memberid");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andMemberidNotEqualTo(Integer value) {
      addCriterion("memberid <>", value, "memberid");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andMemberidGreaterThan(Integer value) {
      addCriterion("memberid >", value, "memberid");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andMemberidGreaterThanOrEqualTo(Integer value) {
      addCriterion("memberid >=", value, "memberid");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andMemberidLessThan(Integer value) {
      addCriterion("memberid <", value, "memberid");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andMemberidLessThanOrEqualTo(Integer value) {
      addCriterion("memberid <=", value, "memberid");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andMemberidIn(List<Integer> values) {
      addCriterion("memberid in", values, "memberid");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andMemberidNotIn(List<Integer> values) {
      addCriterion("memberid not in", values, "memberid");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andMemberidBetween(Integer value1, Integer value2) {
      addCriterion("memberid between", value1, value2, "memberid");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andMemberidNotBetween(Integer value1, Integer value2) {
      addCriterion("memberid not between", value1, value2, "memberid");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andRemarkIsNull() {
      addCriterion("remark is null");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andRemarkIsNotNull() {
      addCriterion("remark is not null");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andRemarkEqualTo(String value) {
      addCriterion("remark =", value, "remark");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andRemarkNotEqualTo(String value) {
      addCriterion("remark <>", value, "remark");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andRemarkGreaterThan(String value) {
      addCriterion("remark >", value, "remark");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andRemarkGreaterThanOrEqualTo(String value) {
      addCriterion("remark >=", value, "remark");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andRemarkLessThan(String value) {
      addCriterion("remark <", value, "remark");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andRemarkLessThanOrEqualTo(String value) {
      addCriterion("remark <=", value, "remark");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andRemarkLike(String value) {
      addCriterion("remark like", value, "remark");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andRemarkNotLike(String value) {
      addCriterion("remark not like", value, "remark");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andRemarkIn(List<String> values) {
      addCriterion("remark in", values, "remark");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andRemarkNotIn(List<String> values) {
      addCriterion("remark not in", values, "remark");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andRemarkBetween(String value1, String value2) {
      addCriterion("remark between", value1, value2, "remark");
      return ((TranslogExample.Criteria)this);
    }

    public TranslogExample.Criteria andRemarkNotBetween(String value1, String value2) {
      addCriterion("remark not between", value1, value2, "remark");
      return ((TranslogExample.Criteria)this);
    }
  }
}