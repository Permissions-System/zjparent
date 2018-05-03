package com.zjgt.p2p.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BidclassExample
{
  protected String orderByClause;
  protected boolean distinct;
  protected List<Criteria> oredCriteria;

  public BidclassExample()
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

  public static class Criteria extends BidclassExample.GeneratedCriteria
  {
  }

  protected static abstract class GeneratedCriteria
  {
    protected List<BidclassExample.Criterion> criteria;

    protected GeneratedCriteria()
    {
      this.criteria = new ArrayList();
    }

    public boolean isValid() {
      return (this.criteria.size() > 0);
    }

    public List<BidclassExample.Criterion> getAllCriteria() {
      return this.criteria;
    }

    public List<BidclassExample.Criterion> getCriteria() {
      return this.criteria;
    }

    protected void addCriterion(String condition) {
      if (condition == null) {
        throw new RuntimeException("Value for condition cannot be null");
      }
      this.criteria.add(new BidclassExample.Criterion(condition));
    }

    protected void addCriterion(String condition, Object value, String property) {
      if (value == null) {
        throw new RuntimeException("Value for " + property + " cannot be null");
      }
      this.criteria.add(new BidclassExample.Criterion(condition, value));
    }

    protected void addCriterion(String condition, Object value1, Object value2, String property) {
      if ((value1 == null) || (value2 == null)) {
        throw new RuntimeException("Between values for " + property + " cannot be null");
      }
      this.criteria.add(new BidclassExample.Criterion(condition, value1, value2));
    }

    protected void addCriterionForJDBCDate(String condition, java.util.Date value, String property) {
      if (value == null) {
        throw new RuntimeException("Value for " + property + " cannot be null");
      }
      addCriterion(condition, new java.sql.Date(value.getTime()), property);
    }

    protected void addCriterionForJDBCDate(String condition, List<java.util.Date> values, String property) {
      if ((values == null) || (values.size() == 0)) {
        throw new RuntimeException("Value list for " + property + " cannot be null or empty");
      }
      List dateList = new ArrayList();
      Iterator iter = values.iterator();
      while (iter.hasNext()) {
        dateList.add(new java.sql.Date(((java.util.Date)iter.next()).getTime()));
      }
      addCriterion(condition, dateList, property);
    }

    protected void addCriterionForJDBCDate(String condition, java.util.Date value1, java.util.Date value2, String property) {
      if ((value1 == null) || (value2 == null)) {
        throw new RuntimeException("Between values for " + property + " cannot be null");
      }
      addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
    }

    public BidclassExample.Criteria andIdIsNull() {
      addCriterion("id is null");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andIdIsNotNull() {
      addCriterion("id is not null");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andIdEqualTo(Long value) {
      addCriterion("id =", value, "id");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andIdNotEqualTo(Long value) {
      addCriterion("id <>", value, "id");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andIdGreaterThan(Long value) {
      addCriterion("id >", value, "id");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andIdGreaterThanOrEqualTo(Long value) {
      addCriterion("id >=", value, "id");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andIdLessThan(Long value) {
      addCriterion("id <", value, "id");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andIdLessThanOrEqualTo(Long value) {
      addCriterion("id <=", value, "id");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andIdIn(List<Long> values) {
      addCriterion("id in", values, "id");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andIdNotIn(List<Long> values) {
      addCriterion("id not in", values, "id");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andIdBetween(Long value1, Long value2) {
      addCriterion("id between", value1, value2, "id");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andIdNotBetween(Long value1, Long value2) {
      addCriterion("id not between", value1, value2, "id");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andBidclassnoIsNull() {
      addCriterion("bidclassno is null");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andBidclassnoIsNotNull() {
      addCriterion("bidclassno is not null");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andBidclassnoEqualTo(String value) {
      addCriterion("bidclassno =", value, "bidclassno");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andBidclassnoNotEqualTo(String value) {
      addCriterion("bidclassno <>", value, "bidclassno");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andBidclassnoGreaterThan(String value) {
      addCriterion("bidclassno >", value, "bidclassno");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andBidclassnoGreaterThanOrEqualTo(String value) {
      addCriterion("bidclassno >=", value, "bidclassno");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andBidclassnoLessThan(String value) {
      addCriterion("bidclassno <", value, "bidclassno");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andBidclassnoLessThanOrEqualTo(String value) {
      addCriterion("bidclassno <=", value, "bidclassno");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andBidclassnoLike(String value) {
      addCriterion("bidclassno like", value, "bidclassno");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andBidclassnoNotLike(String value) {
      addCriterion("bidclassno not like", value, "bidclassno");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andBidclassnoIn(List<String> values) {
      addCriterion("bidclassno in", values, "bidclassno");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andBidclassnoNotIn(List<String> values) {
      addCriterion("bidclassno not in", values, "bidclassno");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andBidclassnoBetween(String value1, String value2) {
      addCriterion("bidclassno between", value1, value2, "bidclassno");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andBidclassnoNotBetween(String value1, String value2) {
      addCriterion("bidclassno not between", value1, value2, "bidclassno");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andBidclassnameIsNull() {
      addCriterion("bidclassname is null");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andBidclassnameIsNotNull() {
      addCriterion("bidclassname is not null");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andBidclassnameEqualTo(String value) {
      addCriterion("bidclassname =", value, "bidclassname");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andBidclassnameNotEqualTo(String value) {
      addCriterion("bidclassname <>", value, "bidclassname");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andBidclassnameGreaterThan(String value) {
      addCriterion("bidclassname >", value, "bidclassname");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andBidclassnameGreaterThanOrEqualTo(String value) {
      addCriterion("bidclassname >=", value, "bidclassname");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andBidclassnameLessThan(String value) {
      addCriterion("bidclassname <", value, "bidclassname");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andBidclassnameLessThanOrEqualTo(String value) {
      addCriterion("bidclassname <=", value, "bidclassname");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andBidclassnameLike(String value) {
      addCriterion("bidclassname like", value, "bidclassname");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andBidclassnameNotLike(String value) {
      addCriterion("bidclassname not like", value, "bidclassname");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andBidclassnameIn(List<String> values) {
      addCriterion("bidclassname in", values, "bidclassname");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andBidclassnameNotIn(List<String> values) {
      addCriterion("bidclassname not in", values, "bidclassname");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andBidclassnameBetween(String value1, String value2) {
      addCriterion("bidclassname between", value1, value2, "bidclassname");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andBidclassnameNotBetween(String value1, String value2) {
      addCriterion("bidclassname not between", value1, value2, "bidclassname");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andBidclasssubjectIsNull() {
      addCriterion("bidclasssubject is null");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andBidclasssubjectIsNotNull() {
      addCriterion("bidclasssubject is not null");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andBidclasssubjectEqualTo(String value) {
      addCriterion("bidclasssubject =", value, "bidclasssubject");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andBidclasssubjectNotEqualTo(String value) {
      addCriterion("bidclasssubject <>", value, "bidclasssubject");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andBidclasssubjectGreaterThan(String value) {
      addCriterion("bidclasssubject >", value, "bidclasssubject");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andBidclasssubjectGreaterThanOrEqualTo(String value) {
      addCriterion("bidclasssubject >=", value, "bidclasssubject");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andBidclasssubjectLessThan(String value) {
      addCriterion("bidclasssubject <", value, "bidclasssubject");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andBidclasssubjectLessThanOrEqualTo(String value) {
      addCriterion("bidclasssubject <=", value, "bidclasssubject");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andBidclasssubjectLike(String value) {
      addCriterion("bidclasssubject like", value, "bidclasssubject");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andBidclasssubjectNotLike(String value) {
      addCriterion("bidclasssubject not like", value, "bidclasssubject");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andBidclasssubjectIn(List<String> values) {
      addCriterion("bidclasssubject in", values, "bidclasssubject");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andBidclasssubjectNotIn(List<String> values) {
      addCriterion("bidclasssubject not in", values, "bidclasssubject");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andBidclasssubjectBetween(String value1, String value2) {
      addCriterion("bidclasssubject between", value1, value2, "bidclasssubject");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andBidclasssubjectNotBetween(String value1, String value2) {
      addCriterion("bidclasssubject not between", value1, value2, "bidclasssubject");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andThumpicIsNull() {
      addCriterion("thumpic is null");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andThumpicIsNotNull() {
      addCriterion("thumpic is not null");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andThumpicEqualTo(String value) {
      addCriterion("thumpic =", value, "thumpic");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andThumpicNotEqualTo(String value) {
      addCriterion("thumpic <>", value, "thumpic");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andThumpicGreaterThan(String value) {
      addCriterion("thumpic >", value, "thumpic");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andThumpicGreaterThanOrEqualTo(String value) {
      addCriterion("thumpic >=", value, "thumpic");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andThumpicLessThan(String value) {
      addCriterion("thumpic <", value, "thumpic");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andThumpicLessThanOrEqualTo(String value) {
      addCriterion("thumpic <=", value, "thumpic");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andThumpicLike(String value) {
      addCriterion("thumpic like", value, "thumpic");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andThumpicNotLike(String value) {
      addCriterion("thumpic not like", value, "thumpic");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andThumpicIn(List<String> values) {
      addCriterion("thumpic in", values, "thumpic");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andThumpicNotIn(List<String> values) {
      addCriterion("thumpic not in", values, "thumpic");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andThumpicBetween(String value1, String value2) {
      addCriterion("thumpic between", value1, value2, "thumpic");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andThumpicNotBetween(String value1, String value2) {
      addCriterion("thumpic not between", value1, value2, "thumpic");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andBidclasspicIsNull() {
      addCriterion("bidclasspic is null");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andBidclasspicIsNotNull() {
      addCriterion("bidclasspic is not null");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andBidclasspicEqualTo(String value) {
      addCriterion("bidclasspic =", value, "bidclasspic");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andBidclasspicNotEqualTo(String value) {
      addCriterion("bidclasspic <>", value, "bidclasspic");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andBidclasspicGreaterThan(String value) {
      addCriterion("bidclasspic >", value, "bidclasspic");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andBidclasspicGreaterThanOrEqualTo(String value) {
      addCriterion("bidclasspic >=", value, "bidclasspic");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andBidclasspicLessThan(String value) {
      addCriterion("bidclasspic <", value, "bidclasspic");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andBidclasspicLessThanOrEqualTo(String value) {
      addCriterion("bidclasspic <=", value, "bidclasspic");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andBidclasspicLike(String value) {
      addCriterion("bidclasspic like", value, "bidclasspic");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andBidclasspicNotLike(String value) {
      addCriterion("bidclasspic not like", value, "bidclasspic");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andBidclasspicIn(List<String> values) {
      addCriterion("bidclasspic in", values, "bidclasspic");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andBidclasspicNotIn(List<String> values) {
      addCriterion("bidclasspic not in", values, "bidclasspic");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andBidclasspicBetween(String value1, String value2) {
      addCriterion("bidclasspic between", value1, value2, "bidclasspic");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andBidclasspicNotBetween(String value1, String value2) {
      addCriterion("bidclasspic not between", value1, value2, "bidclasspic");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andAmountIsNull() {
      addCriterion("amount is null");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andAmountIsNotNull() {
      addCriterion("amount is not null");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andAmountEqualTo(BigDecimal value) {
      addCriterion("amount =", value, "amount");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andAmountNotEqualTo(BigDecimal value) {
      addCriterion("amount <>", value, "amount");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andAmountGreaterThan(BigDecimal value) {
      addCriterion("amount >", value, "amount");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andAmountGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("amount >=", value, "amount");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andAmountLessThan(BigDecimal value) {
      addCriterion("amount <", value, "amount");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andAmountLessThanOrEqualTo(BigDecimal value) {
      addCriterion("amount <=", value, "amount");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andAmountIn(List<BigDecimal> values) {
      addCriterion("amount in", values, "amount");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andAmountNotIn(List<BigDecimal> values) {
      addCriterion("amount not in", values, "amount");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andAmountBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("amount between", value1, value2, "amount");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andAmountNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("amount not between", value1, value2, "amount");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andInvestperiodIsNull() {
      addCriterion("investperiod is null");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andInvestperiodIsNotNull() {
      addCriterion("investperiod is not null");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andInvestperiodEqualTo(String value) {
      addCriterion("investperiod =", value, "investperiod");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andInvestperiodNotEqualTo(String value) {
      addCriterion("investperiod <>", value, "investperiod");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andInvestperiodGreaterThan(String value) {
      addCriterion("investperiod >", value, "investperiod");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andInvestperiodGreaterThanOrEqualTo(String value) {
      addCriterion("investperiod >=", value, "investperiod");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andInvestperiodLessThan(String value) {
      addCriterion("investperiod <", value, "investperiod");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andInvestperiodLessThanOrEqualTo(String value) {
      addCriterion("investperiod <=", value, "investperiod");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andInvestperiodLike(String value) {
      addCriterion("investperiod like", value, "investperiod");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andInvestperiodNotLike(String value) {
      addCriterion("investperiod not like", value, "investperiod");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andInvestperiodIn(List<String> values) {
      addCriterion("investperiod in", values, "investperiod");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andInvestperiodNotIn(List<String> values) {
      addCriterion("investperiod not in", values, "investperiod");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andInvestperiodBetween(String value1, String value2) {
      addCriterion("investperiod between", value1, value2, "investperiod");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andInvestperiodNotBetween(String value1, String value2) {
      addCriterion("investperiod not between", value1, value2, "investperiod");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andRaiseperiodIsNull() {
      addCriterion("raiseperiod is null");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andRaiseperiodIsNotNull() {
      addCriterion("raiseperiod is not null");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andRaiseperiodEqualTo(String value) {
      addCriterion("raiseperiod =", value, "raiseperiod");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andRaiseperiodNotEqualTo(String value) {
      addCriterion("raiseperiod <>", value, "raiseperiod");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andRaiseperiodGreaterThan(String value) {
      addCriterion("raiseperiod >", value, "raiseperiod");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andRaiseperiodGreaterThanOrEqualTo(String value) {
      addCriterion("raiseperiod >=", value, "raiseperiod");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andRaiseperiodLessThan(String value) {
      addCriterion("raiseperiod <", value, "raiseperiod");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andRaiseperiodLessThanOrEqualTo(String value) {
      addCriterion("raiseperiod <=", value, "raiseperiod");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andRaiseperiodLike(String value) {
      addCriterion("raiseperiod like", value, "raiseperiod");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andRaiseperiodNotLike(String value) {
      addCriterion("raiseperiod not like", value, "raiseperiod");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andRaiseperiodIn(List<String> values) {
      addCriterion("raiseperiod in", values, "raiseperiod");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andRaiseperiodNotIn(List<String> values) {
      addCriterion("raiseperiod not in", values, "raiseperiod");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andRaiseperiodBetween(String value1, String value2) {
      addCriterion("raiseperiod between", value1, value2, "raiseperiod");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andRaiseperiodNotBetween(String value1, String value2) {
      addCriterion("raiseperiod not between", value1, value2, "raiseperiod");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andExptinterestdateIsNull() {
      addCriterion("exptinterestdate is null");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andExptinterestdateIsNotNull() {
      addCriterion("exptinterestdate is not null");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andExptinterestdateEqualTo(java.util.Date value) {
      addCriterionForJDBCDate("exptinterestdate =", value, "exptinterestdate");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andExptinterestdateNotEqualTo(java.util.Date value) {
      addCriterionForJDBCDate("exptinterestdate <>", value, "exptinterestdate");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andExptinterestdateGreaterThan(java.util.Date value) {
      addCriterionForJDBCDate("exptinterestdate >", value, "exptinterestdate");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andExptinterestdateGreaterThanOrEqualTo(java.util.Date value) {
      addCriterionForJDBCDate("exptinterestdate >=", value, "exptinterestdate");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andExptinterestdateLessThan(java.util.Date value) {
      addCriterionForJDBCDate("exptinterestdate <", value, "exptinterestdate");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andExptinterestdateLessThanOrEqualTo(java.util.Date value) {
      addCriterionForJDBCDate("exptinterestdate <=", value, "exptinterestdate");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andExptinterestdateIn(List<java.util.Date> values) {
      addCriterionForJDBCDate("exptinterestdate in", values, "exptinterestdate");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andExptinterestdateNotIn(List<java.util.Date> values) {
      addCriterionForJDBCDate("exptinterestdate not in", values, "exptinterestdate");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andExptinterestdateBetween(java.util.Date value1, java.util.Date value2) {
      addCriterionForJDBCDate("exptinterestdate between", value1, value2, "exptinterestdate");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andExptinterestdateNotBetween(java.util.Date value1, java.util.Date value2) {
      addCriterionForJDBCDate("exptinterestdate not between", value1, value2, "exptinterestdate");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andExptexpiredateIsNull() {
      addCriterion("exptexpiredate is null");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andExptexpiredateIsNotNull() {
      addCriterion("exptexpiredate is not null");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andExptexpiredateEqualTo(java.util.Date value) {
      addCriterionForJDBCDate("exptexpiredate =", value, "exptexpiredate");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andExptexpiredateNotEqualTo(java.util.Date value) {
      addCriterionForJDBCDate("exptexpiredate <>", value, "exptexpiredate");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andExptexpiredateGreaterThan(java.util.Date value) {
      addCriterionForJDBCDate("exptexpiredate >", value, "exptexpiredate");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andExptexpiredateGreaterThanOrEqualTo(java.util.Date value) {
      addCriterionForJDBCDate("exptexpiredate >=", value, "exptexpiredate");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andExptexpiredateLessThan(java.util.Date value) {
      addCriterionForJDBCDate("exptexpiredate <", value, "exptexpiredate");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andExptexpiredateLessThanOrEqualTo(java.util.Date value) {
      addCriterionForJDBCDate("exptexpiredate <=", value, "exptexpiredate");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andExptexpiredateIn(List<java.util.Date> values) {
      addCriterionForJDBCDate("exptexpiredate in", values, "exptexpiredate");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andExptexpiredateNotIn(List<java.util.Date> values) {
      addCriterionForJDBCDate("exptexpiredate not in", values, "exptexpiredate");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andExptexpiredateBetween(java.util.Date value1, java.util.Date value2) {
      addCriterionForJDBCDate("exptexpiredate between", value1, value2, "exptexpiredate");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andExptexpiredateNotBetween(java.util.Date value1, java.util.Date value2) {
      addCriterionForJDBCDate("exptexpiredate not between", value1, value2, "exptexpiredate");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andIntestcalctypeidIsNull() {
      addCriterion("intestcalctypeid is null");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andIntestcalctypeidIsNotNull() {
      addCriterion("intestcalctypeid is not null");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andIntestcalctypeidEqualTo(Integer value) {
      addCriterion("intestcalctypeid =", value, "intestcalctypeid");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andIntestcalctypeidNotEqualTo(Integer value) {
      addCriterion("intestcalctypeid <>", value, "intestcalctypeid");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andIntestcalctypeidGreaterThan(Integer value) {
      addCriterion("intestcalctypeid >", value, "intestcalctypeid");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andIntestcalctypeidGreaterThanOrEqualTo(Integer value) {
      addCriterion("intestcalctypeid >=", value, "intestcalctypeid");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andIntestcalctypeidLessThan(Integer value) {
      addCriterion("intestcalctypeid <", value, "intestcalctypeid");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andIntestcalctypeidLessThanOrEqualTo(Integer value) {
      addCriterion("intestcalctypeid <=", value, "intestcalctypeid");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andIntestcalctypeidIn(List<Integer> values) {
      addCriterion("intestcalctypeid in", values, "intestcalctypeid");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andIntestcalctypeidNotIn(List<Integer> values) {
      addCriterion("intestcalctypeid not in", values, "intestcalctypeid");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andIntestcalctypeidBetween(Integer value1, Integer value2) {
      addCriterion("intestcalctypeid between", value1, value2, "intestcalctypeid");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andIntestcalctypeidNotBetween(Integer value1, Integer value2) {
      addCriterion("intestcalctypeid not between", value1, value2, "intestcalctypeid");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andIntestcalctypeIsNull() {
      addCriterion("intestcalctype is null");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andIntestcalctypeIsNotNull() {
      addCriterion("intestcalctype is not null");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andIntestcalctypeEqualTo(String value) {
      addCriterion("intestcalctype =", value, "intestcalctype");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andIntestcalctypeNotEqualTo(String value) {
      addCriterion("intestcalctype <>", value, "intestcalctype");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andIntestcalctypeGreaterThan(String value) {
      addCriterion("intestcalctype >", value, "intestcalctype");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andIntestcalctypeGreaterThanOrEqualTo(String value) {
      addCriterion("intestcalctype >=", value, "intestcalctype");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andIntestcalctypeLessThan(String value) {
      addCriterion("intestcalctype <", value, "intestcalctype");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andIntestcalctypeLessThanOrEqualTo(String value) {
      addCriterion("intestcalctype <=", value, "intestcalctype");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andIntestcalctypeLike(String value) {
      addCriterion("intestcalctype like", value, "intestcalctype");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andIntestcalctypeNotLike(String value) {
      addCriterion("intestcalctype not like", value, "intestcalctype");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andIntestcalctypeIn(List<String> values) {
      addCriterion("intestcalctype in", values, "intestcalctype");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andIntestcalctypeNotIn(List<String> values) {
      addCriterion("intestcalctype not in", values, "intestcalctype");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andIntestcalctypeBetween(String value1, String value2) {
      addCriterion("intestcalctype between", value1, value2, "intestcalctype");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andIntestcalctypeNotBetween(String value1, String value2) {
      addCriterion("intestcalctype not between", value1, value2, "intestcalctype");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andExptlastacctdateIsNull() {
      addCriterion("exptlastacctdate is null");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andExptlastacctdateIsNotNull() {
      addCriterion("exptlastacctdate is not null");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andExptlastacctdateEqualTo(java.util.Date value) {
      addCriterionForJDBCDate("exptlastacctdate =", value, "exptlastacctdate");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andExptlastacctdateNotEqualTo(java.util.Date value) {
      addCriterionForJDBCDate("exptlastacctdate <>", value, "exptlastacctdate");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andExptlastacctdateGreaterThan(java.util.Date value) {
      addCriterionForJDBCDate("exptlastacctdate >", value, "exptlastacctdate");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andExptlastacctdateGreaterThanOrEqualTo(java.util.Date value) {
      addCriterionForJDBCDate("exptlastacctdate >=", value, "exptlastacctdate");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andExptlastacctdateLessThan(java.util.Date value) {
      addCriterionForJDBCDate("exptlastacctdate <", value, "exptlastacctdate");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andExptlastacctdateLessThanOrEqualTo(java.util.Date value) {
      addCriterionForJDBCDate("exptlastacctdate <=", value, "exptlastacctdate");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andExptlastacctdateIn(List<java.util.Date> values) {
      addCriterionForJDBCDate("exptlastacctdate in", values, "exptlastacctdate");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andExptlastacctdateNotIn(List<java.util.Date> values) {
      addCriterionForJDBCDate("exptlastacctdate not in", values, "exptlastacctdate");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andExptlastacctdateBetween(java.util.Date value1, java.util.Date value2) {
      addCriterionForJDBCDate("exptlastacctdate between", value1, value2, "exptlastacctdate");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andExptlastacctdateNotBetween(java.util.Date value1, java.util.Date value2) {
      addCriterionForJDBCDate("exptlastacctdate not between", value1, value2, "exptlastacctdate");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andMininvestamountIsNull() {
      addCriterion("mininvestamount is null");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andMininvestamountIsNotNull() {
      addCriterion("mininvestamount is not null");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andMininvestamountEqualTo(BigDecimal value) {
      addCriterion("mininvestamount =", value, "mininvestamount");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andMininvestamountNotEqualTo(BigDecimal value) {
      addCriterion("mininvestamount <>", value, "mininvestamount");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andMininvestamountGreaterThan(BigDecimal value) {
      addCriterion("mininvestamount >", value, "mininvestamount");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andMininvestamountGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("mininvestamount >=", value, "mininvestamount");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andMininvestamountLessThan(BigDecimal value) {
      addCriterion("mininvestamount <", value, "mininvestamount");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andMininvestamountLessThanOrEqualTo(BigDecimal value) {
      addCriterion("mininvestamount <=", value, "mininvestamount");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andMininvestamountIn(List<BigDecimal> values) {
      addCriterion("mininvestamount in", values, "mininvestamount");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andMininvestamountNotIn(List<BigDecimal> values) {
      addCriterion("mininvestamount not in", values, "mininvestamount");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andMininvestamountBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("mininvestamount between", value1, value2, "mininvestamount");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andMininvestamountNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("mininvestamount not between", value1, value2, "mininvestamount");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andMaxinvestamountIsNull() {
      addCriterion("maxinvestamount is null");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andMaxinvestamountIsNotNull() {
      addCriterion("maxinvestamount is not null");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andMaxinvestamountEqualTo(BigDecimal value) {
      addCriterion("maxinvestamount =", value, "maxinvestamount");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andMaxinvestamountNotEqualTo(BigDecimal value) {
      addCriterion("maxinvestamount <>", value, "maxinvestamount");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andMaxinvestamountGreaterThan(BigDecimal value) {
      addCriterion("maxinvestamount >", value, "maxinvestamount");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andMaxinvestamountGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("maxinvestamount >=", value, "maxinvestamount");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andMaxinvestamountLessThan(BigDecimal value) {
      addCriterion("maxinvestamount <", value, "maxinvestamount");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andMaxinvestamountLessThanOrEqualTo(BigDecimal value) {
      addCriterion("maxinvestamount <=", value, "maxinvestamount");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andMaxinvestamountIn(List<BigDecimal> values) {
      addCriterion("maxinvestamount in", values, "maxinvestamount");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andMaxinvestamountNotIn(List<BigDecimal> values) {
      addCriterion("maxinvestamount not in", values, "maxinvestamount");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andMaxinvestamountBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("maxinvestamount between", value1, value2, "maxinvestamount");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andMaxinvestamountNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("maxinvestamount not between", value1, value2, "maxinvestamount");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andIfredeemIsNull() {
      addCriterion("ifredeem is null");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andIfredeemIsNotNull() {
      addCriterion("ifredeem is not null");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andIfredeemEqualTo(Integer value) {
      addCriterion("ifredeem =", value, "ifredeem");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andIfredeemNotEqualTo(Integer value) {
      addCriterion("ifredeem <>", value, "ifredeem");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andIfredeemGreaterThan(Integer value) {
      addCriterion("ifredeem >", value, "ifredeem");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andIfredeemGreaterThanOrEqualTo(Integer value) {
      addCriterion("ifredeem >=", value, "ifredeem");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andIfredeemLessThan(Integer value) {
      addCriterion("ifredeem <", value, "ifredeem");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andIfredeemLessThanOrEqualTo(Integer value) {
      addCriterion("ifredeem <=", value, "ifredeem");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andIfredeemIn(List<Integer> values) {
      addCriterion("ifredeem in", values, "ifredeem");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andIfredeemNotIn(List<Integer> values) {
      addCriterion("ifredeem not in", values, "ifredeem");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andIfredeemBetween(Integer value1, Integer value2) {
      addCriterion("ifredeem between", value1, value2, "ifredeem");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andIfredeemNotBetween(Integer value1, Integer value2) {
      addCriterion("ifredeem not between", value1, value2, "ifredeem");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andRedeemfeetypeIsNull() {
      addCriterion("redeemfeetype is null");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andRedeemfeetypeIsNotNull() {
      addCriterion("redeemfeetype is not null");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andRedeemfeetypeEqualTo(Integer value) {
      addCriterion("redeemfeetype =", value, "redeemfeetype");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andRedeemfeetypeNotEqualTo(Integer value) {
      addCriterion("redeemfeetype <>", value, "redeemfeetype");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andRedeemfeetypeGreaterThan(Integer value) {
      addCriterion("redeemfeetype >", value, "redeemfeetype");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andRedeemfeetypeGreaterThanOrEqualTo(Integer value) {
      addCriterion("redeemfeetype >=", value, "redeemfeetype");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andRedeemfeetypeLessThan(Integer value) {
      addCriterion("redeemfeetype <", value, "redeemfeetype");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andRedeemfeetypeLessThanOrEqualTo(Integer value) {
      addCriterion("redeemfeetype <=", value, "redeemfeetype");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andRedeemfeetypeIn(List<Integer> values) {
      addCriterion("redeemfeetype in", values, "redeemfeetype");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andRedeemfeetypeNotIn(List<Integer> values) {
      addCriterion("redeemfeetype not in", values, "redeemfeetype");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andRedeemfeetypeBetween(Integer value1, Integer value2) {
      addCriterion("redeemfeetype between", value1, value2, "redeemfeetype");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andRedeemfeetypeNotBetween(Integer value1, Integer value2) {
      addCriterion("redeemfeetype not between", value1, value2, "redeemfeetype");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andRedeemfeeIsNull() {
      addCriterion("redeemfee is null");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andRedeemfeeIsNotNull() {
      addCriterion("redeemfee is not null");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andRedeemfeeEqualTo(BigDecimal value) {
      addCriterion("redeemfee =", value, "redeemfee");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andRedeemfeeNotEqualTo(BigDecimal value) {
      addCriterion("redeemfee <>", value, "redeemfee");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andRedeemfeeGreaterThan(BigDecimal value) {
      addCriterion("redeemfee >", value, "redeemfee");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andRedeemfeeGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("redeemfee >=", value, "redeemfee");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andRedeemfeeLessThan(BigDecimal value) {
      addCriterion("redeemfee <", value, "redeemfee");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andRedeemfeeLessThanOrEqualTo(BigDecimal value) {
      addCriterion("redeemfee <=", value, "redeemfee");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andRedeemfeeIn(List<BigDecimal> values) {
      addCriterion("redeemfee in", values, "redeemfee");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andRedeemfeeNotIn(List<BigDecimal> values) {
      addCriterion("redeemfee not in", values, "redeemfee");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andRedeemfeeBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("redeemfee between", value1, value2, "redeemfee");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andRedeemfeeNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("redeemfee not between", value1, value2, "redeemfee");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andIftransferIsNull() {
      addCriterion("iftransfer is null");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andIftransferIsNotNull() {
      addCriterion("iftransfer is not null");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andIftransferEqualTo(Integer value) {
      addCriterion("iftransfer =", value, "iftransfer");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andIftransferNotEqualTo(Integer value) {
      addCriterion("iftransfer <>", value, "iftransfer");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andIftransferGreaterThan(Integer value) {
      addCriterion("iftransfer >", value, "iftransfer");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andIftransferGreaterThanOrEqualTo(Integer value) {
      addCriterion("iftransfer >=", value, "iftransfer");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andIftransferLessThan(Integer value) {
      addCriterion("iftransfer <", value, "iftransfer");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andIftransferLessThanOrEqualTo(Integer value) {
      addCriterion("iftransfer <=", value, "iftransfer");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andIftransferIn(List<Integer> values) {
      addCriterion("iftransfer in", values, "iftransfer");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andIftransferNotIn(List<Integer> values) {
      addCriterion("iftransfer not in", values, "iftransfer");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andIftransferBetween(Integer value1, Integer value2) {
      addCriterion("iftransfer between", value1, value2, "iftransfer");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andIftransferNotBetween(Integer value1, Integer value2) {
      addCriterion("iftransfer not between", value1, value2, "iftransfer");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andTransfertypeIsNull() {
      addCriterion("transfertype is null");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andTransfertypeIsNotNull() {
      addCriterion("transfertype is not null");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andTransfertypeEqualTo(Integer value) {
      addCriterion("transfertype =", value, "transfertype");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andTransfertypeNotEqualTo(Integer value) {
      addCriterion("transfertype <>", value, "transfertype");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andTransfertypeGreaterThan(Integer value) {
      addCriterion("transfertype >", value, "transfertype");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andTransfertypeGreaterThanOrEqualTo(Integer value) {
      addCriterion("transfertype >=", value, "transfertype");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andTransfertypeLessThan(Integer value) {
      addCriterion("transfertype <", value, "transfertype");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andTransfertypeLessThanOrEqualTo(Integer value) {
      addCriterion("transfertype <=", value, "transfertype");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andTransfertypeIn(List<Integer> values) {
      addCriterion("transfertype in", values, "transfertype");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andTransfertypeNotIn(List<Integer> values) {
      addCriterion("transfertype not in", values, "transfertype");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andTransfertypeBetween(Integer value1, Integer value2) {
      addCriterion("transfertype between", value1, value2, "transfertype");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andTransfertypeNotBetween(Integer value1, Integer value2) {
      addCriterion("transfertype not between", value1, value2, "transfertype");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andTransfeeIsNull() {
      addCriterion("transfee is null");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andTransfeeIsNotNull() {
      addCriterion("transfee is not null");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andTransfeeEqualTo(BigDecimal value) {
      addCriterion("transfee =", value, "transfee");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andTransfeeNotEqualTo(BigDecimal value) {
      addCriterion("transfee <>", value, "transfee");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andTransfeeGreaterThan(BigDecimal value) {
      addCriterion("transfee >", value, "transfee");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andTransfeeGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("transfee >=", value, "transfee");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andTransfeeLessThan(BigDecimal value) {
      addCriterion("transfee <", value, "transfee");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andTransfeeLessThanOrEqualTo(BigDecimal value) {
      addCriterion("transfee <=", value, "transfee");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andTransfeeIn(List<BigDecimal> values) {
      addCriterion("transfee in", values, "transfee");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andTransfeeNotIn(List<BigDecimal> values) {
      addCriterion("transfee not in", values, "transfee");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andTransfeeBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("transfee between", value1, value2, "transfee");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andTransfeeNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("transfee not between", value1, value2, "transfee");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andAssureinstidIsNull() {
      addCriterion("assureinstid is null");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andAssureinstidIsNotNull() {
      addCriterion("assureinstid is not null");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andAssureinstidEqualTo(Integer value) {
      addCriterion("assureinstid =", value, "assureinstid");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andAssureinstidNotEqualTo(Integer value) {
      addCriterion("assureinstid <>", value, "assureinstid");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andAssureinstidGreaterThan(Integer value) {
      addCriterion("assureinstid >", value, "assureinstid");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andAssureinstidGreaterThanOrEqualTo(Integer value) {
      addCriterion("assureinstid >=", value, "assureinstid");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andAssureinstidLessThan(Integer value) {
      addCriterion("assureinstid <", value, "assureinstid");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andAssureinstidLessThanOrEqualTo(Integer value) {
      addCriterion("assureinstid <=", value, "assureinstid");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andAssureinstidIn(List<Integer> values) {
      addCriterion("assureinstid in", values, "assureinstid");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andAssureinstidNotIn(List<Integer> values) {
      addCriterion("assureinstid not in", values, "assureinstid");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andAssureinstidBetween(Integer value1, Integer value2) {
      addCriterion("assureinstid between", value1, value2, "assureinstid");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andAssureinstidNotBetween(Integer value1, Integer value2) {
      addCriterion("assureinstid not between", value1, value2, "assureinstid");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andEnsuretypeIsNull() {
      addCriterion("ensuretype is null");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andEnsuretypeIsNotNull() {
      addCriterion("ensuretype is not null");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andEnsuretypeEqualTo(Integer value) {
      addCriterion("ensuretype =", value, "ensuretype");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andEnsuretypeNotEqualTo(Integer value) {
      addCriterion("ensuretype <>", value, "ensuretype");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andEnsuretypeGreaterThan(Integer value) {
      addCriterion("ensuretype >", value, "ensuretype");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andEnsuretypeGreaterThanOrEqualTo(Integer value) {
      addCriterion("ensuretype >=", value, "ensuretype");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andEnsuretypeLessThan(Integer value) {
      addCriterion("ensuretype <", value, "ensuretype");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andEnsuretypeLessThanOrEqualTo(Integer value) {
      addCriterion("ensuretype <=", value, "ensuretype");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andEnsuretypeIn(List<Integer> values) {
      addCriterion("ensuretype in", values, "ensuretype");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andEnsuretypeNotIn(List<Integer> values) {
      addCriterion("ensuretype not in", values, "ensuretype");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andEnsuretypeBetween(Integer value1, Integer value2) {
      addCriterion("ensuretype between", value1, value2, "ensuretype");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andEnsuretypeNotBetween(Integer value1, Integer value2) {
      addCriterion("ensuretype not between", value1, value2, "ensuretype");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andAgreement1IsNull() {
      addCriterion("agreement1 is null");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andAgreement1IsNotNull() {
      addCriterion("agreement1 is not null");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andAgreement1EqualTo(Integer value) {
      addCriterion("agreement1 =", value, "agreement1");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andAgreement1NotEqualTo(Integer value) {
      addCriterion("agreement1 <>", value, "agreement1");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andAgreement1GreaterThan(Integer value) {
      addCriterion("agreement1 >", value, "agreement1");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andAgreement1GreaterThanOrEqualTo(Integer value) {
      addCriterion("agreement1 >=", value, "agreement1");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andAgreement1LessThan(Integer value) {
      addCriterion("agreement1 <", value, "agreement1");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andAgreement1LessThanOrEqualTo(Integer value) {
      addCriterion("agreement1 <=", value, "agreement1");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andAgreement1In(List<Integer> values) {
      addCriterion("agreement1 in", values, "agreement1");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andAgreement1NotIn(List<Integer> values) {
      addCriterion("agreement1 not in", values, "agreement1");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andAgreement1Between(Integer value1, Integer value2) {
      addCriterion("agreement1 between", value1, value2, "agreement1");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andAgreement1NotBetween(Integer value1, Integer value2) {
      addCriterion("agreement1 not between", value1, value2, "agreement1");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andAgreement2IsNull() {
      addCriterion("agreement2 is null");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andAgreement2IsNotNull() {
      addCriterion("agreement2 is not null");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andAgreement2EqualTo(Integer value) {
      addCriterion("agreement2 =", value, "agreement2");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andAgreement2NotEqualTo(Integer value) {
      addCriterion("agreement2 <>", value, "agreement2");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andAgreement2GreaterThan(Integer value) {
      addCriterion("agreement2 >", value, "agreement2");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andAgreement2GreaterThanOrEqualTo(Integer value) {
      addCriterion("agreement2 >=", value, "agreement2");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andAgreement2LessThan(Integer value) {
      addCriterion("agreement2 <", value, "agreement2");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andAgreement2LessThanOrEqualTo(Integer value) {
      addCriterion("agreement2 <=", value, "agreement2");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andAgreement2In(List<Integer> values) {
      addCriterion("agreement2 in", values, "agreement2");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andAgreement2NotIn(List<Integer> values) {
      addCriterion("agreement2 not in", values, "agreement2");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andAgreement2Between(Integer value1, Integer value2) {
      addCriterion("agreement2 between", value1, value2, "agreement2");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andAgreement2NotBetween(Integer value1, Integer value2) {
      addCriterion("agreement2 not between", value1, value2, "agreement2");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andAgreement3IsNull() {
      addCriterion("agreement3 is null");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andAgreement3IsNotNull() {
      addCriterion("agreement3 is not null");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andAgreement3EqualTo(Integer value) {
      addCriterion("agreement3 =", value, "agreement3");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andAgreement3NotEqualTo(Integer value) {
      addCriterion("agreement3 <>", value, "agreement3");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andAgreement3GreaterThan(Integer value) {
      addCriterion("agreement3 >", value, "agreement3");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andAgreement3GreaterThanOrEqualTo(Integer value) {
      addCriterion("agreement3 >=", value, "agreement3");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andAgreement3LessThan(Integer value) {
      addCriterion("agreement3 <", value, "agreement3");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andAgreement3LessThanOrEqualTo(Integer value) {
      addCriterion("agreement3 <=", value, "agreement3");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andAgreement3In(List<Integer> values) {
      addCriterion("agreement3 in", values, "agreement3");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andAgreement3NotIn(List<Integer> values) {
      addCriterion("agreement3 not in", values, "agreement3");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andAgreement3Between(Integer value1, Integer value2) {
      addCriterion("agreement3 between", value1, value2, "agreement3");
      return ((BidclassExample.Criteria)this);
    }

    public BidclassExample.Criteria andAgreement3NotBetween(Integer value1, Integer value2) {
      addCriterion("agreement3 not between", value1, value2, "agreement3");
      return ((BidclassExample.Criteria)this);
    }
  }
}