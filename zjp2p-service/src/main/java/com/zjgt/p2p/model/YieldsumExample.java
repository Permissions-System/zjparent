package com.zjgt.p2p.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springfk.pancloud.daoframework.page.PageExample;

public class YieldsumExample extends PageExample
{
  protected String orderByClause;
  protected boolean distinct;
  protected List<Criteria> oredCriteria;

  public YieldsumExample()
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

  public static class Criteria extends YieldsumExample.GeneratedCriteria
  {
  }

  protected static abstract class GeneratedCriteria
  {
    protected List<YieldsumExample.Criterion> criteria;

    protected GeneratedCriteria()
    {
      this.criteria = new ArrayList();
    }

    public boolean isValid() {
      return (this.criteria.size() > 0);
    }

    public List<YieldsumExample.Criterion> getAllCriteria() {
      return this.criteria;
    }

    public List<YieldsumExample.Criterion> getCriteria() {
      return this.criteria;
    }

    protected void addCriterion(String condition) {
      if (condition == null) {
        throw new RuntimeException("Value for condition cannot be null");
      }
      this.criteria.add(new YieldsumExample.Criterion(condition));
    }

    protected void addCriterion(String condition, Object value, String property) {
      if (value == null) {
        throw new RuntimeException("Value for " + property + " cannot be null");
      }
      this.criteria.add(new YieldsumExample.Criterion(condition, value));
    }

    protected void addCriterion(String condition, Object value1, Object value2, String property) {
      if ((value1 == null) || (value2 == null)) {
        throw new RuntimeException("Between values for " + property + " cannot be null");
      }
      this.criteria.add(new YieldsumExample.Criterion(condition, value1, value2));
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

    public YieldsumExample.Criteria andIdIsNull() {
      addCriterion("Id is null");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andIdIsNotNull() {
      addCriterion("Id is not null");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andIdEqualTo(Long value) {
      addCriterion("Id =", value, "id");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andIdNotEqualTo(Long value) {
      addCriterion("Id <>", value, "id");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andIdGreaterThan(Long value) {
      addCriterion("Id >", value, "id");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andIdGreaterThanOrEqualTo(Long value) {
      addCriterion("Id >=", value, "id");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andIdLessThan(Long value) {
      addCriterion("Id <", value, "id");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andIdLessThanOrEqualTo(Long value) {
      addCriterion("Id <=", value, "id");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andIdIn(List<Long> values) {
      addCriterion("Id in", values, "id");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andIdNotIn(List<Long> values) {
      addCriterion("Id not in", values, "id");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andIdBetween(Long value1, Long value2) {
      addCriterion("Id between", value1, value2, "id");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andIdNotBetween(Long value1, Long value2) {
      addCriterion("Id not between", value1, value2, "id");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andParentidIsNull() {
      addCriterion("parentId is null");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andParentidIsNotNull() {
      addCriterion("parentId is not null");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andParentidEqualTo(Long value) {
      addCriterion("parentId =", value, "parentid");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andParentidNotEqualTo(Long value) {
      addCriterion("parentId <>", value, "parentid");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andParentidGreaterThan(Long value) {
      addCriterion("parentId >", value, "parentid");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andParentidGreaterThanOrEqualTo(Long value) {
      addCriterion("parentId >=", value, "parentid");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andParentidLessThan(Long value) {
      addCriterion("parentId <", value, "parentid");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andParentidLessThanOrEqualTo(Long value) {
      addCriterion("parentId <=", value, "parentid");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andParentidIn(List<Long> values) {
      addCriterion("parentId in", values, "parentid");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andParentidNotIn(List<Long> values) {
      addCriterion("parentId not in", values, "parentid");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andParentidBetween(Long value1, Long value2) {
      addCriterion("parentId between", value1, value2, "parentid");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andParentidNotBetween(Long value1, Long value2) {
      addCriterion("parentId not between", value1, value2, "parentid");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andInvestordercodeIsNull() {
      addCriterion("InvestOrderCode is null");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andInvestordercodeIsNotNull() {
      addCriterion("InvestOrderCode is not null");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andInvestordercodeEqualTo(String value) {
      addCriterion("InvestOrderCode =", value, "investordercode");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andInvestordercodeNotEqualTo(String value) {
      addCriterion("InvestOrderCode <>", value, "investordercode");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andInvestordercodeGreaterThan(String value) {
      addCriterion("InvestOrderCode >", value, "investordercode");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andInvestordercodeGreaterThanOrEqualTo(String value) {
      addCriterion("InvestOrderCode >=", value, "investordercode");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andInvestordercodeLessThan(String value) {
      addCriterion("InvestOrderCode <", value, "investordercode");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andInvestordercodeLessThanOrEqualTo(String value) {
      addCriterion("InvestOrderCode <=", value, "investordercode");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andInvestordercodeLike(String value) {
      addCriterion("InvestOrderCode like", value, "investordercode");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andInvestordercodeNotLike(String value) {
      addCriterion("InvestOrderCode not like", value, "investordercode");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andInvestordercodeIn(List<String> values) {
      addCriterion("InvestOrderCode in", values, "investordercode");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andInvestordercodeNotIn(List<String> values) {
      addCriterion("InvestOrderCode not in", values, "investordercode");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andInvestordercodeBetween(String value1, String value2) {
      addCriterion("InvestOrderCode between", value1, value2, "investordercode");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andInvestordercodeNotBetween(String value1, String value2) {
      addCriterion("InvestOrderCode not between", value1, value2, "investordercode");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andTermnumIsNull() {
      addCriterion("TermNum is null");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andTermnumIsNotNull() {
      addCriterion("TermNum is not null");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andTermnumEqualTo(Integer value) {
      addCriterion("TermNum =", value, "termnum");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andTermnumNotEqualTo(Integer value) {
      addCriterion("TermNum <>", value, "termnum");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andTermnumGreaterThan(Integer value) {
      addCriterion("TermNum >", value, "termnum");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andTermnumGreaterThanOrEqualTo(Integer value) {
      addCriterion("TermNum >=", value, "termnum");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andTermnumLessThan(Integer value) {
      addCriterion("TermNum <", value, "termnum");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andTermnumLessThanOrEqualTo(Integer value) {
      addCriterion("TermNum <=", value, "termnum");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andTermnumIn(List<Integer> values) {
      addCriterion("TermNum in", values, "termnum");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andTermnumNotIn(List<Integer> values) {
      addCriterion("TermNum not in", values, "termnum");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andTermnumBetween(Integer value1, Integer value2) {
      addCriterion("TermNum between", value1, value2, "termnum");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andTermnumNotBetween(Integer value1, Integer value2) {
      addCriterion("TermNum not between", value1, value2, "termnum");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andTermdateIsNull() {
      addCriterion("TermDate is null");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andTermdateIsNotNull() {
      addCriterion("TermDate is not null");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andTermdateEqualTo(java.util.Date value) {
      addCriterionForJDBCDate("TermDate =", value, "termdate");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andTermdateNotEqualTo(java.util.Date value) {
      addCriterionForJDBCDate("TermDate <>", value, "termdate");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andTermdateGreaterThan(java.util.Date value) {
      addCriterionForJDBCDate("TermDate >", value, "termdate");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andTermdateGreaterThanOrEqualTo(java.util.Date value) {
      addCriterionForJDBCDate("TermDate >=", value, "termdate");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andTermdateLessThan(java.util.Date value) {
      addCriterionForJDBCDate("TermDate <", value, "termdate");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andTermdateLessThanOrEqualTo(java.util.Date value) {
      addCriterionForJDBCDate("TermDate <=", value, "termdate");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andTermdateIn(List<java.util.Date> values) {
      addCriterionForJDBCDate("TermDate in", values, "termdate");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andTermdateNotIn(List<java.util.Date> values) {
      addCriterionForJDBCDate("TermDate not in", values, "termdate");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andTermdateBetween(java.util.Date value1, java.util.Date value2) {
      addCriterionForJDBCDate("TermDate between", value1, value2, "termdate");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andTermdateNotBetween(java.util.Date value1, java.util.Date value2) {
      addCriterionForJDBCDate("TermDate not between", value1, value2, "termdate");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andRepaydateIsNull() {
      addCriterion("RepayDate is null");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andRepaydateIsNotNull() {
      addCriterion("RepayDate is not null");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andRepaydateEqualTo(java.util.Date value) {
      addCriterionForJDBCDate("RepayDate =", value, "repaydate");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andRepaydateNotEqualTo(java.util.Date value) {
      addCriterionForJDBCDate("RepayDate <>", value, "repaydate");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andRepaydateGreaterThan(java.util.Date value) {
      addCriterionForJDBCDate("RepayDate >", value, "repaydate");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andRepaydateGreaterThanOrEqualTo(java.util.Date value) {
      addCriterionForJDBCDate("RepayDate >=", value, "repaydate");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andRepaydateLessThan(java.util.Date value) {
      addCriterionForJDBCDate("RepayDate <", value, "repaydate");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andRepaydateLessThanOrEqualTo(java.util.Date value) {
      addCriterionForJDBCDate("RepayDate <=", value, "repaydate");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andRepaydateIn(List<java.util.Date> values) {
      addCriterionForJDBCDate("RepayDate in", values, "repaydate");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andRepaydateNotIn(List<java.util.Date> values) {
      addCriterionForJDBCDate("RepayDate not in", values, "repaydate");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andRepaydateBetween(java.util.Date value1, java.util.Date value2) {
      addCriterionForJDBCDate("RepayDate between", value1, value2, "repaydate");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andRepaydateNotBetween(java.util.Date value1, java.util.Date value2) {
      addCriterionForJDBCDate("RepayDate not between", value1, value2, "repaydate");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andTermamountIsNull() {
      addCriterion("TermAmount is null");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andTermamountIsNotNull() {
      addCriterion("TermAmount is not null");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andTermamountEqualTo(BigDecimal value) {
      addCriterion("TermAmount =", value, "termamount");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andTermamountNotEqualTo(BigDecimal value) {
      addCriterion("TermAmount <>", value, "termamount");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andTermamountGreaterThan(BigDecimal value) {
      addCriterion("TermAmount >", value, "termamount");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andTermamountGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("TermAmount >=", value, "termamount");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andTermamountLessThan(BigDecimal value) {
      addCriterion("TermAmount <", value, "termamount");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andTermamountLessThanOrEqualTo(BigDecimal value) {
      addCriterion("TermAmount <=", value, "termamount");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andTermamountIn(List<BigDecimal> values) {
      addCriterion("TermAmount in", values, "termamount");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andTermamountNotIn(List<BigDecimal> values) {
      addCriterion("TermAmount not in", values, "termamount");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andTermamountBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("TermAmount between", value1, value2, "termamount");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andTermamountNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("TermAmount not between", value1, value2, "termamount");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andPrincipalamountsumIsNull() {
      addCriterion("PrincipalAmountSum is null");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andPrincipalamountsumIsNotNull() {
      addCriterion("PrincipalAmountSum is not null");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andPrincipalamountsumEqualTo(BigDecimal value) {
      addCriterion("PrincipalAmountSum =", value, "principalamountsum");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andPrincipalamountsumNotEqualTo(BigDecimal value) {
      addCriterion("PrincipalAmountSum <>", value, "principalamountsum");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andPrincipalamountsumGreaterThan(BigDecimal value) {
      addCriterion("PrincipalAmountSum >", value, "principalamountsum");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andPrincipalamountsumGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("PrincipalAmountSum >=", value, "principalamountsum");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andPrincipalamountsumLessThan(BigDecimal value) {
      addCriterion("PrincipalAmountSum <", value, "principalamountsum");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andPrincipalamountsumLessThanOrEqualTo(BigDecimal value) {
      addCriterion("PrincipalAmountSum <=", value, "principalamountsum");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andPrincipalamountsumIn(List<BigDecimal> values) {
      addCriterion("PrincipalAmountSum in", values, "principalamountsum");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andPrincipalamountsumNotIn(List<BigDecimal> values) {
      addCriterion("PrincipalAmountSum not in", values, "principalamountsum");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andPrincipalamountsumBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("PrincipalAmountSum between", value1, value2, "principalamountsum");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andPrincipalamountsumNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("PrincipalAmountSum not between", value1, value2, "principalamountsum");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andAccruedinterestsumIsNull() {
      addCriterion("AccruedInterestSum is null");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andAccruedinterestsumIsNotNull() {
      addCriterion("AccruedInterestSum is not null");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andAccruedinterestsumEqualTo(BigDecimal value) {
      addCriterion("AccruedInterestSum =", value, "accruedinterestsum");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andAccruedinterestsumNotEqualTo(BigDecimal value) {
      addCriterion("AccruedInterestSum <>", value, "accruedinterestsum");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andAccruedinterestsumGreaterThan(BigDecimal value) {
      addCriterion("AccruedInterestSum >", value, "accruedinterestsum");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andAccruedinterestsumGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("AccruedInterestSum >=", value, "accruedinterestsum");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andAccruedinterestsumLessThan(BigDecimal value) {
      addCriterion("AccruedInterestSum <", value, "accruedinterestsum");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andAccruedinterestsumLessThanOrEqualTo(BigDecimal value) {
      addCriterion("AccruedInterestSum <=", value, "accruedinterestsum");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andAccruedinterestsumIn(List<BigDecimal> values) {
      addCriterion("AccruedInterestSum in", values, "accruedinterestsum");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andAccruedinterestsumNotIn(List<BigDecimal> values) {
      addCriterion("AccruedInterestSum not in", values, "accruedinterestsum");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andAccruedinterestsumBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("AccruedInterestSum between", value1, value2, "accruedinterestsum");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andAccruedinterestsumNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("AccruedInterestSum not between", value1, value2, "accruedinterestsum");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andRemaininterestsumIsNull() {
      addCriterion("RemainInterestSum is null");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andRemaininterestsumIsNotNull() {
      addCriterion("RemainInterestSum is not null");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andRemaininterestsumEqualTo(BigDecimal value) {
      addCriterion("RemainInterestSum =", value, "remaininterestsum");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andRemaininterestsumNotEqualTo(BigDecimal value) {
      addCriterion("RemainInterestSum <>", value, "remaininterestsum");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andRemaininterestsumGreaterThan(BigDecimal value) {
      addCriterion("RemainInterestSum >", value, "remaininterestsum");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andRemaininterestsumGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("RemainInterestSum >=", value, "remaininterestsum");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andRemaininterestsumLessThan(BigDecimal value) {
      addCriterion("RemainInterestSum <", value, "remaininterestsum");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andRemaininterestsumLessThanOrEqualTo(BigDecimal value) {
      addCriterion("RemainInterestSum <=", value, "remaininterestsum");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andRemaininterestsumIn(List<BigDecimal> values) {
      addCriterion("RemainInterestSum in", values, "remaininterestsum");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andRemaininterestsumNotIn(List<BigDecimal> values) {
      addCriterion("RemainInterestSum not in", values, "remaininterestsum");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andRemaininterestsumBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("RemainInterestSum between", value1, value2, "remaininterestsum");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andRemaininterestsumNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("RemainInterestSum not between", value1, value2, "remaininterestsum");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andRemainpriamountIsNull() {
      addCriterion("RemainPriAmount is null");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andRemainpriamountIsNotNull() {
      addCriterion("RemainPriAmount is not null");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andRemainpriamountEqualTo(BigDecimal value) {
      addCriterion("RemainPriAmount =", value, "remainpriamount");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andRemainpriamountNotEqualTo(BigDecimal value) {
      addCriterion("RemainPriAmount <>", value, "remainpriamount");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andRemainpriamountGreaterThan(BigDecimal value) {
      addCriterion("RemainPriAmount >", value, "remainpriamount");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andRemainpriamountGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("RemainPriAmount >=", value, "remainpriamount");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andRemainpriamountLessThan(BigDecimal value) {
      addCriterion("RemainPriAmount <", value, "remainpriamount");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andRemainpriamountLessThanOrEqualTo(BigDecimal value) {
      addCriterion("RemainPriAmount <=", value, "remainpriamount");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andRemainpriamountIn(List<BigDecimal> values) {
      addCriterion("RemainPriAmount in", values, "remainpriamount");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andRemainpriamountNotIn(List<BigDecimal> values) {
      addCriterion("RemainPriAmount not in", values, "remainpriamount");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andRemainpriamountBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("RemainPriAmount between", value1, value2, "remainpriamount");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andRemainpriamountNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("RemainPriAmount not between", value1, value2, "remainpriamount");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andRepaidinterestsumIsNull() {
      addCriterion("RepaidInterestSum is null");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andRepaidinterestsumIsNotNull() {
      addCriterion("RepaidInterestSum is not null");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andRepaidinterestsumEqualTo(BigDecimal value) {
      addCriterion("RepaidInterestSum =", value, "repaidinterestsum");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andRepaidinterestsumNotEqualTo(BigDecimal value) {
      addCriterion("RepaidInterestSum <>", value, "repaidinterestsum");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andRepaidinterestsumGreaterThan(BigDecimal value) {
      addCriterion("RepaidInterestSum >", value, "repaidinterestsum");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andRepaidinterestsumGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("RepaidInterestSum >=", value, "repaidinterestsum");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andRepaidinterestsumLessThan(BigDecimal value) {
      addCriterion("RepaidInterestSum <", value, "repaidinterestsum");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andRepaidinterestsumLessThanOrEqualTo(BigDecimal value) {
      addCriterion("RepaidInterestSum <=", value, "repaidinterestsum");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andRepaidinterestsumIn(List<BigDecimal> values) {
      addCriterion("RepaidInterestSum in", values, "repaidinterestsum");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andRepaidinterestsumNotIn(List<BigDecimal> values) {
      addCriterion("RepaidInterestSum not in", values, "repaidinterestsum");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andRepaidinterestsumBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("RepaidInterestSum between", value1, value2, "repaidinterestsum");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andRepaidinterestsumNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("RepaidInterestSum not between", value1, value2, "repaidinterestsum");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andRepaidamountsumIsNull() {
      addCriterion("RepaidAmountSum is null");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andRepaidamountsumIsNotNull() {
      addCriterion("RepaidAmountSum is not null");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andRepaidamountsumEqualTo(BigDecimal value) {
      addCriterion("RepaidAmountSum =", value, "repaidamountsum");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andRepaidamountsumNotEqualTo(BigDecimal value) {
      addCriterion("RepaidAmountSum <>", value, "repaidamountsum");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andRepaidamountsumGreaterThan(BigDecimal value) {
      addCriterion("RepaidAmountSum >", value, "repaidamountsum");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andRepaidamountsumGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("RepaidAmountSum >=", value, "repaidamountsum");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andRepaidamountsumLessThan(BigDecimal value) {
      addCriterion("RepaidAmountSum <", value, "repaidamountsum");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andRepaidamountsumLessThanOrEqualTo(BigDecimal value) {
      addCriterion("RepaidAmountSum <=", value, "repaidamountsum");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andRepaidamountsumIn(List<BigDecimal> values) {
      addCriterion("RepaidAmountSum in", values, "repaidamountsum");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andRepaidamountsumNotIn(List<BigDecimal> values) {
      addCriterion("RepaidAmountSum not in", values, "repaidamountsum");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andRepaidamountsumBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("RepaidAmountSum between", value1, value2, "repaidamountsum");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andRepaidamountsumNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("RepaidAmountSum not between", value1, value2, "repaidamountsum");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andTermstatusIsNull() {
      addCriterion("TermStatus is null");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andTermstatusIsNotNull() {
      addCriterion("TermStatus is not null");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andTermstatusEqualTo(String value) {
      addCriterion("TermStatus =", value, "termstatus");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andTermstatusNotEqualTo(String value) {
      addCriterion("TermStatus <>", value, "termstatus");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andTermstatusGreaterThan(String value) {
      addCriterion("TermStatus >", value, "termstatus");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andTermstatusGreaterThanOrEqualTo(String value) {
      addCriterion("TermStatus >=", value, "termstatus");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andTermstatusLessThan(String value) {
      addCriterion("TermStatus <", value, "termstatus");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andTermstatusLessThanOrEqualTo(String value) {
      addCriterion("TermStatus <=", value, "termstatus");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andTermstatusLike(String value) {
      addCriterion("TermStatus like", value, "termstatus");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andTermstatusNotLike(String value) {
      addCriterion("TermStatus not like", value, "termstatus");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andTermstatusIn(List<String> values) {
      addCriterion("TermStatus in", values, "termstatus");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andTermstatusNotIn(List<String> values) {
      addCriterion("TermStatus not in", values, "termstatus");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andTermstatusBetween(String value1, String value2) {
      addCriterion("TermStatus between", value1, value2, "termstatus");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andTermstatusNotBetween(String value1, String value2) {
      addCriterion("TermStatus not between", value1, value2, "termstatus");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andTranscodeIsNull() {
      addCriterion("TransCode is null");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andTranscodeIsNotNull() {
      addCriterion("TransCode is not null");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andTranscodeEqualTo(String value) {
      addCriterion("TransCode =", value, "transcode");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andTranscodeNotEqualTo(String value) {
      addCriterion("TransCode <>", value, "transcode");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andTranscodeGreaterThan(String value) {
      addCriterion("TransCode >", value, "transcode");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andTranscodeGreaterThanOrEqualTo(String value) {
      addCriterion("TransCode >=", value, "transcode");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andTranscodeLessThan(String value) {
      addCriterion("TransCode <", value, "transcode");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andTranscodeLessThanOrEqualTo(String value) {
      addCriterion("TransCode <=", value, "transcode");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andTranscodeLike(String value) {
      addCriterion("TransCode like", value, "transcode");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andTranscodeNotLike(String value) {
      addCriterion("TransCode not like", value, "transcode");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andTranscodeIn(List<String> values) {
      addCriterion("TransCode in", values, "transcode");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andTranscodeNotIn(List<String> values) {
      addCriterion("TransCode not in", values, "transcode");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andTranscodeBetween(String value1, String value2) {
      addCriterion("TransCode between", value1, value2, "transcode");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andTranscodeNotBetween(String value1, String value2) {
      addCriterion("TransCode not between", value1, value2, "transcode");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andPaystatusIsNull() {
      addCriterion("PayStatus is null");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andPaystatusIsNotNull() {
      addCriterion("PayStatus is not null");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andPaystatusEqualTo(Integer value) {
      addCriterion("PayStatus =", value, "paystatus");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andPaystatusNotEqualTo(Integer value) {
      addCriterion("PayStatus <>", value, "paystatus");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andPaystatusGreaterThan(Integer value) {
      addCriterion("PayStatus >", value, "paystatus");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andPaystatusGreaterThanOrEqualTo(Integer value) {
      addCriterion("PayStatus >=", value, "paystatus");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andPaystatusLessThan(Integer value) {
      addCriterion("PayStatus <", value, "paystatus");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andPaystatusLessThanOrEqualTo(Integer value) {
      addCriterion("PayStatus <=", value, "paystatus");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andPaystatusIn(List<Integer> values) {
      addCriterion("PayStatus in", values, "paystatus");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andPaystatusNotIn(List<Integer> values) {
      addCriterion("PayStatus not in", values, "paystatus");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andPaystatusBetween(Integer value1, Integer value2) {
      addCriterion("PayStatus between", value1, value2, "paystatus");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andPaystatusNotBetween(Integer value1, Integer value2) {
      addCriterion("PayStatus not between", value1, value2, "paystatus");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andCreditcodeIsNull() {
      addCriterion("CreditCode is null");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andCreditcodeIsNotNull() {
      addCriterion("CreditCode is not null");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andCreditcodeEqualTo(String value) {
      addCriterion("CreditCode =", value, "creditcode");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andCreditcodeNotEqualTo(String value) {
      addCriterion("CreditCode <>", value, "creditcode");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andCreditcodeGreaterThan(String value) {
      addCriterion("CreditCode >", value, "creditcode");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andCreditcodeGreaterThanOrEqualTo(String value) {
      addCriterion("CreditCode >=", value, "creditcode");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andCreditcodeLessThan(String value) {
      addCriterion("CreditCode <", value, "creditcode");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andCreditcodeLessThanOrEqualTo(String value) {
      addCriterion("CreditCode <=", value, "creditcode");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andCreditcodeLike(String value) {
      addCriterion("CreditCode like", value, "creditcode");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andCreditcodeNotLike(String value) {
      addCriterion("CreditCode not like", value, "creditcode");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andCreditcodeIn(List<String> values) {
      addCriterion("CreditCode in", values, "creditcode");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andCreditcodeNotIn(List<String> values) {
      addCriterion("CreditCode not in", values, "creditcode");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andCreditcodeBetween(String value1, String value2) {
      addCriterion("CreditCode between", value1, value2, "creditcode");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andCreditcodeNotBetween(String value1, String value2) {
      addCriterion("CreditCode not between", value1, value2, "creditcode");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andRemarkIsNull() {
      addCriterion("Remark is null");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andRemarkIsNotNull() {
      addCriterion("Remark is not null");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andRemarkEqualTo(String value) {
      addCriterion("Remark =", value, "remark");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andRemarkNotEqualTo(String value) {
      addCriterion("Remark <>", value, "remark");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andRemarkGreaterThan(String value) {
      addCriterion("Remark >", value, "remark");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andRemarkGreaterThanOrEqualTo(String value) {
      addCriterion("Remark >=", value, "remark");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andRemarkLessThan(String value) {
      addCriterion("Remark <", value, "remark");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andRemarkLessThanOrEqualTo(String value) {
      addCriterion("Remark <=", value, "remark");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andRemarkLike(String value) {
      addCriterion("Remark like", value, "remark");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andRemarkNotLike(String value) {
      addCriterion("Remark not like", value, "remark");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andRemarkIn(List<String> values) {
      addCriterion("Remark in", values, "remark");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andRemarkNotIn(List<String> values) {
      addCriterion("Remark not in", values, "remark");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andRemarkBetween(String value1, String value2) {
      addCriterion("Remark between", value1, value2, "remark");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andRemarkNotBetween(String value1, String value2) {
      addCriterion("Remark not between", value1, value2, "remark");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andMemberidIsNull() {
      addCriterion("memberid is null");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andMemberidIsNotNull() {
      addCriterion("memberid is not null");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andMemberidEqualTo(Integer value) {
      addCriterion("memberid =", value, "memberid");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andMemberidNotEqualTo(Integer value) {
      addCriterion("memberid <>", value, "memberid");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andMemberidGreaterThan(Integer value) {
      addCriterion("memberid >", value, "memberid");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andMemberidGreaterThanOrEqualTo(Integer value) {
      addCriterion("memberid >=", value, "memberid");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andMemberidLessThan(Integer value) {
      addCriterion("memberid <", value, "memberid");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andMemberidLessThanOrEqualTo(Integer value) {
      addCriterion("memberid <=", value, "memberid");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andMemberidIn(List<Integer> values) {
      addCriterion("memberid in", values, "memberid");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andMemberidNotIn(List<Integer> values) {
      addCriterion("memberid not in", values, "memberid");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andMemberidBetween(Integer value1, Integer value2) {
      addCriterion("memberid between", value1, value2, "memberid");
      return ((YieldsumExample.Criteria)this);
    }

    public YieldsumExample.Criteria andMemberidNotBetween(Integer value1, Integer value2) {
      addCriterion("memberid not between", value1, value2, "memberid");
      return ((YieldsumExample.Criteria)this);
    }
  }
}