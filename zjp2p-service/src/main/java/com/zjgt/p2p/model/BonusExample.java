package com.zjgt.p2p.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springfk.pancloud.daoframework.page.PageExample;

public class BonusExample extends PageExample
{
  protected String orderByClause;
  protected boolean distinct;
  protected List<Criteria> oredCriteria;

  public BonusExample()
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

  public static class Criteria extends BonusExample.GeneratedCriteria
  {
  }

  protected static abstract class GeneratedCriteria
  {
    protected List<BonusExample.Criterion> criteria;

    protected GeneratedCriteria()
    {
      this.criteria = new ArrayList();
    }

    public boolean isValid() {
      return (this.criteria.size() > 0);
    }

    public List<BonusExample.Criterion> getAllCriteria() {
      return this.criteria;
    }

    public List<BonusExample.Criterion> getCriteria() {
      return this.criteria;
    }

    protected void addCriterion(String condition) {
      if (condition == null) {
        throw new RuntimeException("Value for condition cannot be null");
      }
      this.criteria.add(new BonusExample.Criterion(condition));
    }

    protected void addCriterion(String condition, Object value, String property) {
      if (value == null) {
        throw new RuntimeException("Value for " + property + " cannot be null");
      }
      this.criteria.add(new BonusExample.Criterion(condition, value));
    }

    protected void addCriterion(String condition, Object value1, Object value2, String property) {
      if ((value1 == null) || (value2 == null)) {
        throw new RuntimeException("Between values for " + property + " cannot be null");
      }
      this.criteria.add(new BonusExample.Criterion(condition, value1, value2));
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

    public BonusExample.Criteria andIdIsNull() {
      addCriterion("id is null");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andIdIsNotNull() {
      addCriterion("id is not null");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andIdEqualTo(Integer value) {
      addCriterion("id =", value, "id");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andIdNotEqualTo(Integer value) {
      addCriterion("id <>", value, "id");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andIdGreaterThan(Integer value) {
      addCriterion("id >", value, "id");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andIdGreaterThanOrEqualTo(Integer value) {
      addCriterion("id >=", value, "id");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andIdLessThan(Integer value) {
      addCriterion("id <", value, "id");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andIdLessThanOrEqualTo(Integer value) {
      addCriterion("id <=", value, "id");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andIdIn(List<Integer> values) {
      addCriterion("id in", values, "id");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andIdNotIn(List<Integer> values) {
      addCriterion("id not in", values, "id");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andIdBetween(Integer value1, Integer value2) {
      addCriterion("id between", value1, value2, "id");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andIdNotBetween(Integer value1, Integer value2) {
      addCriterion("id not between", value1, value2, "id");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andBonusnoIsNull() {
      addCriterion("bonusno is null");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andBonusnoIsNotNull() {
      addCriterion("bonusno is not null");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andBonusnoEqualTo(String value) {
      addCriterion("bonusno =", value, "bonusno");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andBonusnoNotEqualTo(String value) {
      addCriterion("bonusno <>", value, "bonusno");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andBonusnoGreaterThan(String value) {
      addCriterion("bonusno >", value, "bonusno");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andBonusnoGreaterThanOrEqualTo(String value) {
      addCriterion("bonusno >=", value, "bonusno");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andBonusnoLessThan(String value) {
      addCriterion("bonusno <", value, "bonusno");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andBonusnoLessThanOrEqualTo(String value) {
      addCriterion("bonusno <=", value, "bonusno");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andBonusnoLike(String value) {
      addCriterion("bonusno like", value, "bonusno");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andBonusnoNotLike(String value) {
      addCriterion("bonusno not like", value, "bonusno");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andBonusnoIn(List<String> values) {
      addCriterion("bonusno in", values, "bonusno");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andBonusnoNotIn(List<String> values) {
      addCriterion("bonusno not in", values, "bonusno");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andBonusnoBetween(String value1, String value2) {
      addCriterion("bonusno between", value1, value2, "bonusno");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andBonusnoNotBetween(String value1, String value2) {
      addCriterion("bonusno not between", value1, value2, "bonusno");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andBonustypeIsNull() {
      addCriterion("bonustype is null");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andBonustypeIsNotNull() {
      addCriterion("bonustype is not null");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andBonustypeEqualTo(Integer value) {
      addCriterion("bonustype =", value, "bonustype");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andBonustypeNotEqualTo(Integer value) {
      addCriterion("bonustype <>", value, "bonustype");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andBonustypeGreaterThan(Integer value) {
      addCriterion("bonustype >", value, "bonustype");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andBonustypeGreaterThanOrEqualTo(Integer value) {
      addCriterion("bonustype >=", value, "bonustype");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andBonustypeLessThan(Integer value) {
      addCriterion("bonustype <", value, "bonustype");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andBonustypeLessThanOrEqualTo(Integer value) {
      addCriterion("bonustype <=", value, "bonustype");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andBonustypeIn(List<Integer> values) {
      addCriterion("bonustype in", values, "bonustype");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andBonustypeNotIn(List<Integer> values) {
      addCriterion("bonustype not in", values, "bonustype");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andBonustypeBetween(Integer value1, Integer value2) {
      addCriterion("bonustype between", value1, value2, "bonustype");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andBonustypeNotBetween(Integer value1, Integer value2) {
      addCriterion("bonustype not between", value1, value2, "bonustype");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andSourceIsNull() {
      addCriterion("source is null");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andSourceIsNotNull() {
      addCriterion("source is not null");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andSourceEqualTo(Integer value) {
      addCriterion("source =", value, "source");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andSourceNotEqualTo(Integer value) {
      addCriterion("source <>", value, "source");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andSourceGreaterThan(Integer value) {
      addCriterion("source >", value, "source");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andSourceGreaterThanOrEqualTo(Integer value) {
      addCriterion("source >=", value, "source");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andSourceLessThan(Integer value) {
      addCriterion("source <", value, "source");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andSourceLessThanOrEqualTo(Integer value) {
      addCriterion("source <=", value, "source");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andSourceIn(List<Integer> values) {
      addCriterion("source in", values, "source");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andSourceNotIn(List<Integer> values) {
      addCriterion("source not in", values, "source");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andSourceBetween(Integer value1, Integer value2) {
      addCriterion("source between", value1, value2, "source");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andSourceNotBetween(Integer value1, Integer value2) {
      addCriterion("source not between", value1, value2, "source");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andAccountIsNull() {
      addCriterion("account is null");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andAccountIsNotNull() {
      addCriterion("account is not null");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andAccountEqualTo(BigDecimal value) {
      addCriterion("account =", value, "account");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andAccountNotEqualTo(BigDecimal value) {
      addCriterion("account <>", value, "account");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andAccountGreaterThan(BigDecimal value) {
      addCriterion("account >", value, "account");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andAccountGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("account >=", value, "account");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andAccountLessThan(BigDecimal value) {
      addCriterion("account <", value, "account");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andAccountLessThanOrEqualTo(BigDecimal value) {
      addCriterion("account <=", value, "account");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andAccountIn(List<BigDecimal> values) {
      addCriterion("account in", values, "account");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andAccountNotIn(List<BigDecimal> values) {
      addCriterion("account not in", values, "account");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andAccountBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("account between", value1, value2, "account");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andAccountNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("account not between", value1, value2, "account");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andBlanceIsNull() {
      addCriterion("blance is null");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andBlanceIsNotNull() {
      addCriterion("blance is not null");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andBlanceEqualTo(BigDecimal value) {
      addCriterion("blance =", value, "blance");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andBlanceNotEqualTo(BigDecimal value) {
      addCriterion("blance <>", value, "blance");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andBlanceGreaterThan(BigDecimal value) {
      addCriterion("blance >", value, "blance");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andBlanceGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("blance >=", value, "blance");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andBlanceLessThan(BigDecimal value) {
      addCriterion("blance <", value, "blance");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andBlanceLessThanOrEqualTo(BigDecimal value) {
      addCriterion("blance <=", value, "blance");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andBlanceIn(List<BigDecimal> values) {
      addCriterion("blance in", values, "blance");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andBlanceNotIn(List<BigDecimal> values) {
      addCriterion("blance not in", values, "blance");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andBlanceBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("blance between", value1, value2, "blance");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andBlanceNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("blance not between", value1, value2, "blance");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andBegindateIsNull() {
      addCriterion("begindate is null");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andBegindateIsNotNull() {
      addCriterion("begindate is not null");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andBegindateEqualTo(java.util.Date value) {
      addCriterionForJDBCDate("begindate =", value, "begindate");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andBegindateNotEqualTo(java.util.Date value) {
      addCriterionForJDBCDate("begindate <>", value, "begindate");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andBegindateGreaterThan(java.util.Date value) {
      addCriterionForJDBCDate("begindate >", value, "begindate");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andBegindateGreaterThanOrEqualTo(java.util.Date value) {
      addCriterionForJDBCDate("begindate >=", value, "begindate");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andBegindateLessThan(java.util.Date value) {
      addCriterionForJDBCDate("begindate <", value, "begindate");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andBegindateLessThanOrEqualTo(java.util.Date value) {
      addCriterionForJDBCDate("begindate <=", value, "begindate");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andBegindateIn(List<java.util.Date> values) {
      addCriterionForJDBCDate("begindate in", values, "begindate");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andBegindateNotIn(List<java.util.Date> values) {
      addCriterionForJDBCDate("begindate not in", values, "begindate");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andBegindateBetween(java.util.Date value1, java.util.Date value2) {
      addCriterionForJDBCDate("begindate between", value1, value2, "begindate");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andBegindateNotBetween(java.util.Date value1, java.util.Date value2) {
      addCriterionForJDBCDate("begindate not between", value1, value2, "begindate");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andEnddateIsNull() {
      addCriterion("enddate is null");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andEnddateIsNotNull() {
      addCriterion("enddate is not null");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andEnddateEqualTo(java.util.Date value) {
      addCriterionForJDBCDate("enddate =", value, "enddate");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andEnddateNotEqualTo(java.util.Date value) {
      addCriterionForJDBCDate("enddate <>", value, "enddate");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andEnddateGreaterThan(java.util.Date value) {
      addCriterionForJDBCDate("enddate >", value, "enddate");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andEnddateGreaterThanOrEqualTo(java.util.Date value) {
      addCriterionForJDBCDate("enddate >=", value, "enddate");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andEnddateLessThan(java.util.Date value) {
      addCriterionForJDBCDate("enddate <", value, "enddate");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andEnddateLessThanOrEqualTo(java.util.Date value) {
      addCriterionForJDBCDate("enddate <=", value, "enddate");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andEnddateIn(List<java.util.Date> values) {
      addCriterionForJDBCDate("enddate in", values, "enddate");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andEnddateNotIn(List<java.util.Date> values) {
      addCriterionForJDBCDate("enddate not in", values, "enddate");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andEnddateBetween(java.util.Date value1, java.util.Date value2) {
      addCriterionForJDBCDate("enddate between", value1, value2, "enddate");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andEnddateNotBetween(java.util.Date value1, java.util.Date value2) {
      addCriterionForJDBCDate("enddate not between", value1, value2, "enddate");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andStatusIsNull() {
      addCriterion("status is null");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andStatusIsNotNull() {
      addCriterion("status is not null");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andStatusEqualTo(Integer value) {
      addCriterion("status =", value, "status");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andStatusNotEqualTo(Integer value) {
      addCriterion("status <>", value, "status");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andStatusGreaterThan(Integer value) {
      addCriterion("status >", value, "status");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andStatusGreaterThanOrEqualTo(Integer value) {
      addCriterion("status >=", value, "status");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andStatusLessThan(Integer value) {
      addCriterion("status <", value, "status");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andStatusLessThanOrEqualTo(Integer value) {
      addCriterion("status <=", value, "status");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andStatusIn(List<Integer> values) {
      addCriterion("status in", values, "status");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andStatusNotIn(List<Integer> values) {
      addCriterion("status not in", values, "status");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andStatusBetween(Integer value1, Integer value2) {
      addCriterion("status between", value1, value2, "status");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andStatusNotBetween(Integer value1, Integer value2) {
      addCriterion("status not between", value1, value2, "status");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andBonusrangeIsNull() {
      addCriterion("bonusrange is null");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andBonusrangeIsNotNull() {
      addCriterion("bonusrange is not null");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andBonusrangeEqualTo(Integer value) {
      addCriterion("bonusrange =", value, "bonusrange");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andBonusrangeNotEqualTo(Integer value) {
      addCriterion("bonusrange <>", value, "bonusrange");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andBonusrangeGreaterThan(Integer value) {
      addCriterion("bonusrange >", value, "bonusrange");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andBonusrangeGreaterThanOrEqualTo(Integer value) {
      addCriterion("bonusrange >=", value, "bonusrange");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andBonusrangeLessThan(Integer value) {
      addCriterion("bonusrange <", value, "bonusrange");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andBonusrangeLessThanOrEqualTo(Integer value) {
      addCriterion("bonusrange <=", value, "bonusrange");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andBonusrangeIn(List<Integer> values) {
      addCriterion("bonusrange in", values, "bonusrange");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andBonusrangeNotIn(List<Integer> values) {
      addCriterion("bonusrange not in", values, "bonusrange");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andBonusrangeBetween(Integer value1, Integer value2) {
      addCriterion("bonusrange between", value1, value2, "bonusrange");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andBonusrangeNotBetween(Integer value1, Integer value2) {
      addCriterion("bonusrange not between", value1, value2, "bonusrange");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andSubjectIsNull() {
      addCriterion("subject is null");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andSubjectIsNotNull() {
      addCriterion("subject is not null");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andSubjectEqualTo(String value) {
      addCriterion("subject =", value, "subject");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andSubjectNotEqualTo(String value) {
      addCriterion("subject <>", value, "subject");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andSubjectGreaterThan(String value) {
      addCriterion("subject >", value, "subject");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andSubjectGreaterThanOrEqualTo(String value) {
      addCriterion("subject >=", value, "subject");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andSubjectLessThan(String value) {
      addCriterion("subject <", value, "subject");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andSubjectLessThanOrEqualTo(String value) {
      addCriterion("subject <=", value, "subject");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andSubjectLike(String value) {
      addCriterion("subject like", value, "subject");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andSubjectNotLike(String value) {
      addCriterion("subject not like", value, "subject");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andSubjectIn(List<String> values) {
      addCriterion("subject in", values, "subject");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andSubjectNotIn(List<String> values) {
      addCriterion("subject not in", values, "subject");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andSubjectBetween(String value1, String value2) {
      addCriterion("subject between", value1, value2, "subject");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andSubjectNotBetween(String value1, String value2) {
      addCriterion("subject not between", value1, value2, "subject");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andBonusdetailtypeIsNull() {
      addCriterion("bonusdetailtype is null");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andBonusdetailtypeIsNotNull() {
      addCriterion("bonusdetailtype is not null");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andBonusdetailtypeEqualTo(String value) {
      addCriterion("bonusdetailtype =", value, "bonusdetailtype");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andBonusdetailtypeNotEqualTo(String value) {
      addCriterion("bonusdetailtype <>", value, "bonusdetailtype");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andBonusdetailtypeGreaterThan(String value) {
      addCriterion("bonusdetailtype >", value, "bonusdetailtype");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andBonusdetailtypeGreaterThanOrEqualTo(String value) {
      addCriterion("bonusdetailtype >=", value, "bonusdetailtype");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andBonusdetailtypeLessThan(String value) {
      addCriterion("bonusdetailtype <", value, "bonusdetailtype");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andBonusdetailtypeLessThanOrEqualTo(String value) {
      addCriterion("bonusdetailtype <=", value, "bonusdetailtype");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andBonusdetailtypeLike(String value) {
      addCriterion("bonusdetailtype like", value, "bonusdetailtype");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andBonusdetailtypeNotLike(String value) {
      addCriterion("bonusdetailtype not like", value, "bonusdetailtype");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andBonusdetailtypeIn(List<String> values) {
      addCriterion("bonusdetailtype in", values, "bonusdetailtype");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andBonusdetailtypeNotIn(List<String> values) {
      addCriterion("bonusdetailtype not in", values, "bonusdetailtype");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andBonusdetailtypeBetween(String value1, String value2) {
      addCriterion("bonusdetailtype between", value1, value2, "bonusdetailtype");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andBonusdetailtypeNotBetween(String value1, String value2) {
      addCriterion("bonusdetailtype not between", value1, value2, "bonusdetailtype");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andRelativenoIsNull() {
      addCriterion("relativeno is null");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andRelativenoIsNotNull() {
      addCriterion("relativeno is not null");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andRelativenoEqualTo(String value) {
      addCriterion("relativeno =", value, "relativeno");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andRelativenoNotEqualTo(String value) {
      addCriterion("relativeno <>", value, "relativeno");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andRelativenoGreaterThan(String value) {
      addCriterion("relativeno >", value, "relativeno");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andRelativenoGreaterThanOrEqualTo(String value) {
      addCriterion("relativeno >=", value, "relativeno");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andRelativenoLessThan(String value) {
      addCriterion("relativeno <", value, "relativeno");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andRelativenoLessThanOrEqualTo(String value) {
      addCriterion("relativeno <=", value, "relativeno");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andRelativenoLike(String value) {
      addCriterion("relativeno like", value, "relativeno");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andRelativenoNotLike(String value) {
      addCriterion("relativeno not like", value, "relativeno");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andRelativenoIn(List<String> values) {
      addCriterion("relativeno in", values, "relativeno");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andRelativenoNotIn(List<String> values) {
      addCriterion("relativeno not in", values, "relativeno");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andRelativenoBetween(String value1, String value2) {
      addCriterion("relativeno between", value1, value2, "relativeno");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andRelativenoNotBetween(String value1, String value2) {
      addCriterion("relativeno not between", value1, value2, "relativeno");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andMemberidIsNull() {
      addCriterion("memberid is null");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andMemberidIsNotNull() {
      addCriterion("memberid is not null");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andMemberidEqualTo(Long value) {
      addCriterion("memberid =", value, "memberid");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andMemberidNotEqualTo(Long value) {
      addCriterion("memberid <>", value, "memberid");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andMemberidGreaterThan(Long value) {
      addCriterion("memberid >", value, "memberid");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andMemberidGreaterThanOrEqualTo(Long value) {
      addCriterion("memberid >=", value, "memberid");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andMemberidLessThan(Long value) {
      addCriterion("memberid <", value, "memberid");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andMemberidLessThanOrEqualTo(Long value) {
      addCriterion("memberid <=", value, "memberid");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andMemberidIn(List<Long> values) {
      addCriterion("memberid in", values, "memberid");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andMemberidNotIn(List<Long> values) {
      addCriterion("memberid not in", values, "memberid");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andMemberidBetween(Long value1, Long value2) {
      addCriterion("memberid between", value1, value2, "memberid");
      return ((BonusExample.Criteria)this);
    }

    public BonusExample.Criteria andMemberidNotBetween(Long value1, Long value2) {
      addCriterion("memberid not between", value1, value2, "memberid");
      return ((BonusExample.Criteria)this);
    }
  }
}