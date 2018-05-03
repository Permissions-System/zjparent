package com.zjgt.p2p.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springfk.pancloud.daoframework.page.PageExample;

public class YieldplanExample extends PageExample
{
  protected String orderByClause;
  protected boolean distinct;
  protected List<Criteria> oredCriteria;

  public YieldplanExample()
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

  public static class Criteria extends YieldplanExample.GeneratedCriteria
  {
  }

  protected static abstract class GeneratedCriteria
  {
    protected List<YieldplanExample.Criterion> criteria;

    protected GeneratedCriteria()
    {
      this.criteria = new ArrayList();
    }

    public boolean isValid() {
      return (this.criteria.size() > 0);
    }

    public List<YieldplanExample.Criterion> getAllCriteria() {
      return this.criteria;
    }

    public List<YieldplanExample.Criterion> getCriteria() {
      return this.criteria;
    }

    protected void addCriterion(String condition) {
      if (condition == null) {
        throw new RuntimeException("Value for condition cannot be null");
      }
      this.criteria.add(new YieldplanExample.Criterion(condition));
    }

    protected void addCriterion(String condition, Object value, String property) {
      if (value == null) {
        throw new RuntimeException("Value for " + property + " cannot be null");
      }
      this.criteria.add(new YieldplanExample.Criterion(condition, value));
    }

    protected void addCriterion(String condition, Object value1, Object value2, String property) {
      if ((value1 == null) || (value2 == null)) {
        throw new RuntimeException("Between values for " + property + " cannot be null");
      }
      this.criteria.add(new YieldplanExample.Criterion(condition, value1, value2));
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

    public YieldplanExample.Criteria andIdIsNull() {
      addCriterion("Id is null");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andIdIsNotNull() {
      addCriterion("Id is not null");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andIdEqualTo(Long value) {
      addCriterion("Id =", value, "id");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andIdNotEqualTo(Long value) {
      addCriterion("Id <>", value, "id");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andIdGreaterThan(Long value) {
      addCriterion("Id >", value, "id");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andIdGreaterThanOrEqualTo(Long value) {
      addCriterion("Id >=", value, "id");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andIdLessThan(Long value) {
      addCriterion("Id <", value, "id");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andIdLessThanOrEqualTo(Long value) {
      addCriterion("Id <=", value, "id");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andIdIn(List<Long> values) {
      addCriterion("Id in", values, "id");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andIdNotIn(List<Long> values) {
      addCriterion("Id not in", values, "id");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andIdBetween(Long value1, Long value2) {
      addCriterion("Id between", value1, value2, "id");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andIdNotBetween(Long value1, Long value2) {
      addCriterion("Id not between", value1, value2, "id");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andParentidIsNull() {
      addCriterion("parentId is null");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andParentidIsNotNull() {
      addCriterion("parentId is not null");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andParentidEqualTo(Long value) {
      addCriterion("parentId =", value, "parentid");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andParentidNotEqualTo(Long value) {
      addCriterion("parentId <>", value, "parentid");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andParentidGreaterThan(Long value) {
      addCriterion("parentId >", value, "parentid");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andParentidGreaterThanOrEqualTo(Long value) {
      addCriterion("parentId >=", value, "parentid");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andParentidLessThan(Long value) {
      addCriterion("parentId <", value, "parentid");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andParentidLessThanOrEqualTo(Long value) {
      addCriterion("parentId <=", value, "parentid");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andParentidIn(List<Long> values) {
      addCriterion("parentId in", values, "parentid");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andParentidNotIn(List<Long> values) {
      addCriterion("parentId not in", values, "parentid");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andParentidBetween(Long value1, Long value2) {
      addCriterion("parentId between", value1, value2, "parentid");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andParentidNotBetween(Long value1, Long value2) {
      addCriterion("parentId not between", value1, value2, "parentid");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andInvestordercodeIsNull() {
      addCriterion("InvestOrderCode is null");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andInvestordercodeIsNotNull() {
      addCriterion("InvestOrderCode is not null");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andInvestordercodeEqualTo(String value) {
      addCriterion("InvestOrderCode =", value, "investordercode");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andInvestordercodeNotEqualTo(String value) {
      addCriterion("InvestOrderCode <>", value, "investordercode");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andInvestordercodeGreaterThan(String value) {
      addCriterion("InvestOrderCode >", value, "investordercode");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andInvestordercodeGreaterThanOrEqualTo(String value) {
      addCriterion("InvestOrderCode >=", value, "investordercode");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andInvestordercodeLessThan(String value) {
      addCriterion("InvestOrderCode <", value, "investordercode");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andInvestordercodeLessThanOrEqualTo(String value) {
      addCriterion("InvestOrderCode <=", value, "investordercode");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andInvestordercodeLike(String value) {
      addCriterion("InvestOrderCode like", value, "investordercode");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andInvestordercodeNotLike(String value) {
      addCriterion("InvestOrderCode not like", value, "investordercode");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andInvestordercodeIn(List<String> values) {
      addCriterion("InvestOrderCode in", values, "investordercode");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andInvestordercodeNotIn(List<String> values) {
      addCriterion("InvestOrderCode not in", values, "investordercode");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andInvestordercodeBetween(String value1, String value2) {
      addCriterion("InvestOrderCode between", value1, value2, "investordercode");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andInvestordercodeNotBetween(String value1, String value2) {
      addCriterion("InvestOrderCode not between", value1, value2, "investordercode");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andTermnumIsNull() {
      addCriterion("TermNum is null");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andTermnumIsNotNull() {
      addCriterion("TermNum is not null");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andTermnumEqualTo(Integer value) {
      addCriterion("TermNum =", value, "termnum");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andTermnumNotEqualTo(Integer value) {
      addCriterion("TermNum <>", value, "termnum");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andTermnumGreaterThan(Integer value) {
      addCriterion("TermNum >", value, "termnum");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andTermnumGreaterThanOrEqualTo(Integer value) {
      addCriterion("TermNum >=", value, "termnum");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andTermnumLessThan(Integer value) {
      addCriterion("TermNum <", value, "termnum");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andTermnumLessThanOrEqualTo(Integer value) {
      addCriterion("TermNum <=", value, "termnum");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andTermnumIn(List<Integer> values) {
      addCriterion("TermNum in", values, "termnum");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andTermnumNotIn(List<Integer> values) {
      addCriterion("TermNum not in", values, "termnum");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andTermnumBetween(Integer value1, Integer value2) {
      addCriterion("TermNum between", value1, value2, "termnum");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andTermnumNotBetween(Integer value1, Integer value2) {
      addCriterion("TermNum not between", value1, value2, "termnum");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andTermdateIsNull() {
      addCriterion("TermDate is null");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andTermdateIsNotNull() {
      addCriterion("TermDate is not null");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andTermdateEqualTo(java.util.Date value) {
      addCriterionForJDBCDate("TermDate =", value, "termdate");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andTermdateNotEqualTo(java.util.Date value) {
      addCriterionForJDBCDate("TermDate <>", value, "termdate");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andTermdateGreaterThan(java.util.Date value) {
      addCriterionForJDBCDate("TermDate >", value, "termdate");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andTermdateGreaterThanOrEqualTo(java.util.Date value) {
      addCriterionForJDBCDate("TermDate >=", value, "termdate");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andTermdateLessThan(java.util.Date value) {
      addCriterionForJDBCDate("TermDate <", value, "termdate");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andTermdateLessThanOrEqualTo(java.util.Date value) {
      addCriterionForJDBCDate("TermDate <=", value, "termdate");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andTermdateIn(List<java.util.Date> values) {
      addCriterionForJDBCDate("TermDate in", values, "termdate");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andTermdateNotIn(List<java.util.Date> values) {
      addCriterionForJDBCDate("TermDate not in", values, "termdate");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andTermdateBetween(java.util.Date value1, java.util.Date value2) {
      addCriterionForJDBCDate("TermDate between", value1, value2, "termdate");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andTermdateNotBetween(java.util.Date value1, java.util.Date value2) {
      addCriterionForJDBCDate("TermDate not between", value1, value2, "termdate");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andTermamountIsNull() {
      addCriterion("TermAmount is null");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andTermamountIsNotNull() {
      addCriterion("TermAmount is not null");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andTermamountEqualTo(BigDecimal value) {
      addCriterion("TermAmount =", value, "termamount");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andTermamountNotEqualTo(BigDecimal value) {
      addCriterion("TermAmount <>", value, "termamount");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andTermamountGreaterThan(BigDecimal value) {
      addCriterion("TermAmount >", value, "termamount");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andTermamountGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("TermAmount >=", value, "termamount");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andTermamountLessThan(BigDecimal value) {
      addCriterion("TermAmount <", value, "termamount");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andTermamountLessThanOrEqualTo(BigDecimal value) {
      addCriterion("TermAmount <=", value, "termamount");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andTermamountIn(List<BigDecimal> values) {
      addCriterion("TermAmount in", values, "termamount");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andTermamountNotIn(List<BigDecimal> values) {
      addCriterion("TermAmount not in", values, "termamount");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andTermamountBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("TermAmount between", value1, value2, "termamount");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andTermamountNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("TermAmount not between", value1, value2, "termamount");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andPrincipalamountIsNull() {
      addCriterion("PrincipalAmount is null");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andPrincipalamountIsNotNull() {
      addCriterion("PrincipalAmount is not null");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andPrincipalamountEqualTo(BigDecimal value) {
      addCriterion("PrincipalAmount =", value, "principalamount");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andPrincipalamountNotEqualTo(BigDecimal value) {
      addCriterion("PrincipalAmount <>", value, "principalamount");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andPrincipalamountGreaterThan(BigDecimal value) {
      addCriterion("PrincipalAmount >", value, "principalamount");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andPrincipalamountGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("PrincipalAmount >=", value, "principalamount");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andPrincipalamountLessThan(BigDecimal value) {
      addCriterion("PrincipalAmount <", value, "principalamount");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andPrincipalamountLessThanOrEqualTo(BigDecimal value) {
      addCriterion("PrincipalAmount <=", value, "principalamount");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andPrincipalamountIn(List<BigDecimal> values) {
      addCriterion("PrincipalAmount in", values, "principalamount");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andPrincipalamountNotIn(List<BigDecimal> values) {
      addCriterion("PrincipalAmount not in", values, "principalamount");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andPrincipalamountBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("PrincipalAmount between", value1, value2, "principalamount");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andPrincipalamountNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("PrincipalAmount not between", value1, value2, "principalamount");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andAccruedinterestIsNull() {
      addCriterion("AccruedInterest is null");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andAccruedinterestIsNotNull() {
      addCriterion("AccruedInterest is not null");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andAccruedinterestEqualTo(BigDecimal value) {
      addCriterion("AccruedInterest =", value, "accruedinterest");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andAccruedinterestNotEqualTo(BigDecimal value) {
      addCriterion("AccruedInterest <>", value, "accruedinterest");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andAccruedinterestGreaterThan(BigDecimal value) {
      addCriterion("AccruedInterest >", value, "accruedinterest");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andAccruedinterestGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("AccruedInterest >=", value, "accruedinterest");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andAccruedinterestLessThan(BigDecimal value) {
      addCriterion("AccruedInterest <", value, "accruedinterest");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andAccruedinterestLessThanOrEqualTo(BigDecimal value) {
      addCriterion("AccruedInterest <=", value, "accruedinterest");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andAccruedinterestIn(List<BigDecimal> values) {
      addCriterion("AccruedInterest in", values, "accruedinterest");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andAccruedinterestNotIn(List<BigDecimal> values) {
      addCriterion("AccruedInterest not in", values, "accruedinterest");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andAccruedinterestBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("AccruedInterest between", value1, value2, "accruedinterest");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andAccruedinterestNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("AccruedInterest not between", value1, value2, "accruedinterest");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andRemainpriamountIsNull() {
      addCriterion("RemainPriAmount is null");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andRemainpriamountIsNotNull() {
      addCriterion("RemainPriAmount is not null");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andRemainpriamountEqualTo(BigDecimal value) {
      addCriterion("RemainPriAmount =", value, "remainpriamount");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andRemainpriamountNotEqualTo(BigDecimal value) {
      addCriterion("RemainPriAmount <>", value, "remainpriamount");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andRemainpriamountGreaterThan(BigDecimal value) {
      addCriterion("RemainPriAmount >", value, "remainpriamount");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andRemainpriamountGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("RemainPriAmount >=", value, "remainpriamount");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andRemainpriamountLessThan(BigDecimal value) {
      addCriterion("RemainPriAmount <", value, "remainpriamount");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andRemainpriamountLessThanOrEqualTo(BigDecimal value) {
      addCriterion("RemainPriAmount <=", value, "remainpriamount");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andRemainpriamountIn(List<BigDecimal> values) {
      addCriterion("RemainPriAmount in", values, "remainpriamount");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andRemainpriamountNotIn(List<BigDecimal> values) {
      addCriterion("RemainPriAmount not in", values, "remainpriamount");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andRemainpriamountBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("RemainPriAmount between", value1, value2, "remainpriamount");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andRemainpriamountNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("RemainPriAmount not between", value1, value2, "remainpriamount");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andRemaininterestIsNull() {
      addCriterion("RemainInterest is null");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andRemaininterestIsNotNull() {
      addCriterion("RemainInterest is not null");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andRemaininterestEqualTo(BigDecimal value) {
      addCriterion("RemainInterest =", value, "remaininterest");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andRemaininterestNotEqualTo(BigDecimal value) {
      addCriterion("RemainInterest <>", value, "remaininterest");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andRemaininterestGreaterThan(BigDecimal value) {
      addCriterion("RemainInterest >", value, "remaininterest");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andRemaininterestGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("RemainInterest >=", value, "remaininterest");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andRemaininterestLessThan(BigDecimal value) {
      addCriterion("RemainInterest <", value, "remaininterest");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andRemaininterestLessThanOrEqualTo(BigDecimal value) {
      addCriterion("RemainInterest <=", value, "remaininterest");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andRemaininterestIn(List<BigDecimal> values) {
      addCriterion("RemainInterest in", values, "remaininterest");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andRemaininterestNotIn(List<BigDecimal> values) {
      addCriterion("RemainInterest not in", values, "remaininterest");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andRemaininterestBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("RemainInterest between", value1, value2, "remaininterest");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andRemaininterestNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("RemainInterest not between", value1, value2, "remaininterest");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andRepaydateIsNull() {
      addCriterion("RepayDate is null");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andRepaydateIsNotNull() {
      addCriterion("RepayDate is not null");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andRepaydateEqualTo(java.util.Date value) {
      addCriterionForJDBCDate("RepayDate =", value, "repaydate");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andRepaydateNotEqualTo(java.util.Date value) {
      addCriterionForJDBCDate("RepayDate <>", value, "repaydate");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andRepaydateGreaterThan(java.util.Date value) {
      addCriterionForJDBCDate("RepayDate >", value, "repaydate");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andRepaydateGreaterThanOrEqualTo(java.util.Date value) {
      addCriterionForJDBCDate("RepayDate >=", value, "repaydate");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andRepaydateLessThan(java.util.Date value) {
      addCriterionForJDBCDate("RepayDate <", value, "repaydate");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andRepaydateLessThanOrEqualTo(java.util.Date value) {
      addCriterionForJDBCDate("RepayDate <=", value, "repaydate");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andRepaydateIn(List<java.util.Date> values) {
      addCriterionForJDBCDate("RepayDate in", values, "repaydate");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andRepaydateNotIn(List<java.util.Date> values) {
      addCriterionForJDBCDate("RepayDate not in", values, "repaydate");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andRepaydateBetween(java.util.Date value1, java.util.Date value2) {
      addCriterionForJDBCDate("RepayDate between", value1, value2, "repaydate");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andRepaydateNotBetween(java.util.Date value1, java.util.Date value2) {
      addCriterionForJDBCDate("RepayDate not between", value1, value2, "repaydate");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andRepaidamountIsNull() {
      addCriterion("RepaidAmount is null");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andRepaidamountIsNotNull() {
      addCriterion("RepaidAmount is not null");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andRepaidamountEqualTo(BigDecimal value) {
      addCriterion("RepaidAmount =", value, "repaidamount");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andRepaidamountNotEqualTo(BigDecimal value) {
      addCriterion("RepaidAmount <>", value, "repaidamount");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andRepaidamountGreaterThan(BigDecimal value) {
      addCriterion("RepaidAmount >", value, "repaidamount");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andRepaidamountGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("RepaidAmount >=", value, "repaidamount");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andRepaidamountLessThan(BigDecimal value) {
      addCriterion("RepaidAmount <", value, "repaidamount");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andRepaidamountLessThanOrEqualTo(BigDecimal value) {
      addCriterion("RepaidAmount <=", value, "repaidamount");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andRepaidamountIn(List<BigDecimal> values) {
      addCriterion("RepaidAmount in", values, "repaidamount");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andRepaidamountNotIn(List<BigDecimal> values) {
      addCriterion("RepaidAmount not in", values, "repaidamount");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andRepaidamountBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("RepaidAmount between", value1, value2, "repaidamount");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andRepaidamountNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("RepaidAmount not between", value1, value2, "repaidamount");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andTermstatusIsNull() {
      addCriterion("TermStatus is null");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andTermstatusIsNotNull() {
      addCriterion("TermStatus is not null");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andTermstatusEqualTo(String value) {
      addCriterion("TermStatus =", value, "termstatus");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andTermstatusNotEqualTo(String value) {
      addCriterion("TermStatus <>", value, "termstatus");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andTermstatusGreaterThan(String value) {
      addCriterion("TermStatus >", value, "termstatus");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andTermstatusGreaterThanOrEqualTo(String value) {
      addCriterion("TermStatus >=", value, "termstatus");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andTermstatusLessThan(String value) {
      addCriterion("TermStatus <", value, "termstatus");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andTermstatusLessThanOrEqualTo(String value) {
      addCriterion("TermStatus <=", value, "termstatus");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andTermstatusLike(String value) {
      addCriterion("TermStatus like", value, "termstatus");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andTermstatusNotLike(String value) {
      addCriterion("TermStatus not like", value, "termstatus");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andTermstatusIn(List<String> values) {
      addCriterion("TermStatus in", values, "termstatus");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andTermstatusNotIn(List<String> values) {
      addCriterion("TermStatus not in", values, "termstatus");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andTermstatusBetween(String value1, String value2) {
      addCriterion("TermStatus between", value1, value2, "termstatus");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andTermstatusNotBetween(String value1, String value2) {
      addCriterion("TermStatus not between", value1, value2, "termstatus");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andTranscodeIsNull() {
      addCriterion("TransCode is null");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andTranscodeIsNotNull() {
      addCriterion("TransCode is not null");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andTranscodeEqualTo(String value) {
      addCriterion("TransCode =", value, "transcode");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andTranscodeNotEqualTo(String value) {
      addCriterion("TransCode <>", value, "transcode");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andTranscodeGreaterThan(String value) {
      addCriterion("TransCode >", value, "transcode");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andTranscodeGreaterThanOrEqualTo(String value) {
      addCriterion("TransCode >=", value, "transcode");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andTranscodeLessThan(String value) {
      addCriterion("TransCode <", value, "transcode");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andTranscodeLessThanOrEqualTo(String value) {
      addCriterion("TransCode <=", value, "transcode");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andTranscodeLike(String value) {
      addCriterion("TransCode like", value, "transcode");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andTranscodeNotLike(String value) {
      addCriterion("TransCode not like", value, "transcode");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andTranscodeIn(List<String> values) {
      addCriterion("TransCode in", values, "transcode");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andTranscodeNotIn(List<String> values) {
      addCriterion("TransCode not in", values, "transcode");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andTranscodeBetween(String value1, String value2) {
      addCriterion("TransCode between", value1, value2, "transcode");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andTranscodeNotBetween(String value1, String value2) {
      addCriterion("TransCode not between", value1, value2, "transcode");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andCreditcodeIsNull() {
      addCriterion("CreditCode is null");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andCreditcodeIsNotNull() {
      addCriterion("CreditCode is not null");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andCreditcodeEqualTo(String value) {
      addCriterion("CreditCode =", value, "creditcode");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andCreditcodeNotEqualTo(String value) {
      addCriterion("CreditCode <>", value, "creditcode");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andCreditcodeGreaterThan(String value) {
      addCriterion("CreditCode >", value, "creditcode");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andCreditcodeGreaterThanOrEqualTo(String value) {
      addCriterion("CreditCode >=", value, "creditcode");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andCreditcodeLessThan(String value) {
      addCriterion("CreditCode <", value, "creditcode");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andCreditcodeLessThanOrEqualTo(String value) {
      addCriterion("CreditCode <=", value, "creditcode");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andCreditcodeLike(String value) {
      addCriterion("CreditCode like", value, "creditcode");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andCreditcodeNotLike(String value) {
      addCriterion("CreditCode not like", value, "creditcode");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andCreditcodeIn(List<String> values) {
      addCriterion("CreditCode in", values, "creditcode");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andCreditcodeNotIn(List<String> values) {
      addCriterion("CreditCode not in", values, "creditcode");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andCreditcodeBetween(String value1, String value2) {
      addCriterion("CreditCode between", value1, value2, "creditcode");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andCreditcodeNotBetween(String value1, String value2) {
      addCriterion("CreditCode not between", value1, value2, "creditcode");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andRemarkIsNull() {
      addCriterion("Remark is null");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andRemarkIsNotNull() {
      addCriterion("Remark is not null");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andRemarkEqualTo(String value) {
      addCriterion("Remark =", value, "remark");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andRemarkNotEqualTo(String value) {
      addCriterion("Remark <>", value, "remark");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andRemarkGreaterThan(String value) {
      addCriterion("Remark >", value, "remark");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andRemarkGreaterThanOrEqualTo(String value) {
      addCriterion("Remark >=", value, "remark");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andRemarkLessThan(String value) {
      addCriterion("Remark <", value, "remark");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andRemarkLessThanOrEqualTo(String value) {
      addCriterion("Remark <=", value, "remark");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andRemarkLike(String value) {
      addCriterion("Remark like", value, "remark");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andRemarkNotLike(String value) {
      addCriterion("Remark not like", value, "remark");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andRemarkIn(List<String> values) {
      addCriterion("Remark in", values, "remark");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andRemarkNotIn(List<String> values) {
      addCriterion("Remark not in", values, "remark");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andRemarkBetween(String value1, String value2) {
      addCriterion("Remark between", value1, value2, "remark");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andRemarkNotBetween(String value1, String value2) {
      addCriterion("Remark not between", value1, value2, "remark");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andMemberidIsNull() {
      addCriterion("memberid is null");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andMemberidIsNotNull() {
      addCriterion("memberid is not null");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andMemberidEqualTo(Integer value) {
      addCriterion("memberid =", value, "memberid");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andMemberidNotEqualTo(Integer value) {
      addCriterion("memberid <>", value, "memberid");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andMemberidGreaterThan(Integer value) {
      addCriterion("memberid >", value, "memberid");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andMemberidGreaterThanOrEqualTo(Integer value) {
      addCriterion("memberid >=", value, "memberid");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andMemberidLessThan(Integer value) {
      addCriterion("memberid <", value, "memberid");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andMemberidLessThanOrEqualTo(Integer value) {
      addCriterion("memberid <=", value, "memberid");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andMemberidIn(List<Integer> values) {
      addCriterion("memberid in", values, "memberid");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andMemberidNotIn(List<Integer> values) {
      addCriterion("memberid not in", values, "memberid");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andMemberidBetween(Integer value1, Integer value2) {
      addCriterion("memberid between", value1, value2, "memberid");
      return ((YieldplanExample.Criteria)this);
    }

    public YieldplanExample.Criteria andMemberidNotBetween(Integer value1, Integer value2) {
      addCriterion("memberid not between", value1, value2, "memberid");
      return ((YieldplanExample.Criteria)this);
    }
  }
}