package com.zjgt.p2p.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CpsCommissionrateExample
{
  protected String orderByClause;
  protected boolean distinct;
  protected List<Criteria> oredCriteria;

  public CpsCommissionrateExample()
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

  public static class Criteria extends CpsCommissionrateExample.GeneratedCriteria
  {
  }

  protected static abstract class GeneratedCriteria
  {
    protected List<CpsCommissionrateExample.Criterion> criteria;

    protected GeneratedCriteria()
    {
      this.criteria = new ArrayList();
    }

    public boolean isValid() {
      return (this.criteria.size() > 0);
    }

    public List<CpsCommissionrateExample.Criterion> getAllCriteria() {
      return this.criteria;
    }

    public List<CpsCommissionrateExample.Criterion> getCriteria() {
      return this.criteria;
    }

    protected void addCriterion(String condition) {
      if (condition == null) {
        throw new RuntimeException("Value for condition cannot be null");
      }
      this.criteria.add(new CpsCommissionrateExample.Criterion(condition));
    }

    protected void addCriterion(String condition, Object value, String property) {
      if (value == null) {
        throw new RuntimeException("Value for " + property + " cannot be null");
      }
      this.criteria.add(new CpsCommissionrateExample.Criterion(condition, value));
    }

    protected void addCriterion(String condition, Object value1, Object value2, String property) {
      if ((value1 == null) || (value2 == null)) {
        throw new RuntimeException("Between values for " + property + " cannot be null");
      }
      this.criteria.add(new CpsCommissionrateExample.Criterion(condition, value1, value2));
    }

    public CpsCommissionrateExample.Criteria andIdIsNull() {
      addCriterion("id is null");
      return ((CpsCommissionrateExample.Criteria)this);
    }

    public CpsCommissionrateExample.Criteria andIdIsNotNull() {
      addCriterion("id is not null");
      return ((CpsCommissionrateExample.Criteria)this);
    }

    public CpsCommissionrateExample.Criteria andIdEqualTo(Long value) {
      addCriterion("id =", value, "id");
      return ((CpsCommissionrateExample.Criteria)this);
    }

    public CpsCommissionrateExample.Criteria andIdNotEqualTo(Long value) {
      addCriterion("id <>", value, "id");
      return ((CpsCommissionrateExample.Criteria)this);
    }

    public CpsCommissionrateExample.Criteria andIdGreaterThan(Long value) {
      addCriterion("id >", value, "id");
      return ((CpsCommissionrateExample.Criteria)this);
    }

    public CpsCommissionrateExample.Criteria andIdGreaterThanOrEqualTo(Long value) {
      addCriterion("id >=", value, "id");
      return ((CpsCommissionrateExample.Criteria)this);
    }

    public CpsCommissionrateExample.Criteria andIdLessThan(Long value) {
      addCriterion("id <", value, "id");
      return ((CpsCommissionrateExample.Criteria)this);
    }

    public CpsCommissionrateExample.Criteria andIdLessThanOrEqualTo(Long value) {
      addCriterion("id <=", value, "id");
      return ((CpsCommissionrateExample.Criteria)this);
    }

    public CpsCommissionrateExample.Criteria andIdIn(List<Long> values) {
      addCriterion("id in", values, "id");
      return ((CpsCommissionrateExample.Criteria)this);
    }

    public CpsCommissionrateExample.Criteria andIdNotIn(List<Long> values) {
      addCriterion("id not in", values, "id");
      return ((CpsCommissionrateExample.Criteria)this);
    }

    public CpsCommissionrateExample.Criteria andIdBetween(Long value1, Long value2) {
      addCriterion("id between", value1, value2, "id");
      return ((CpsCommissionrateExample.Criteria)this);
    }

    public CpsCommissionrateExample.Criteria andIdNotBetween(Long value1, Long value2) {
      addCriterion("id not between", value1, value2, "id");
      return ((CpsCommissionrateExample.Criteria)this);
    }

    public CpsCommissionrateExample.Criteria andBidtypeIsNull() {
      addCriterion("bidtype is null");
      return ((CpsCommissionrateExample.Criteria)this);
    }

    public CpsCommissionrateExample.Criteria andBidtypeIsNotNull() {
      addCriterion("bidtype is not null");
      return ((CpsCommissionrateExample.Criteria)this);
    }

    public CpsCommissionrateExample.Criteria andBidtypeEqualTo(Integer value) {
      addCriterion("bidtype =", value, "bidtype");
      return ((CpsCommissionrateExample.Criteria)this);
    }

    public CpsCommissionrateExample.Criteria andBidtypeNotEqualTo(Integer value) {
      addCriterion("bidtype <>", value, "bidtype");
      return ((CpsCommissionrateExample.Criteria)this);
    }

    public CpsCommissionrateExample.Criteria andBidtypeGreaterThan(Integer value) {
      addCriterion("bidtype >", value, "bidtype");
      return ((CpsCommissionrateExample.Criteria)this);
    }

    public CpsCommissionrateExample.Criteria andBidtypeGreaterThanOrEqualTo(Integer value) {
      addCriterion("bidtype >=", value, "bidtype");
      return ((CpsCommissionrateExample.Criteria)this);
    }

    public CpsCommissionrateExample.Criteria andBidtypeLessThan(Integer value) {
      addCriterion("bidtype <", value, "bidtype");
      return ((CpsCommissionrateExample.Criteria)this);
    }

    public CpsCommissionrateExample.Criteria andBidtypeLessThanOrEqualTo(Integer value) {
      addCriterion("bidtype <=", value, "bidtype");
      return ((CpsCommissionrateExample.Criteria)this);
    }

    public CpsCommissionrateExample.Criteria andBidtypeIn(List<Integer> values) {
      addCriterion("bidtype in", values, "bidtype");
      return ((CpsCommissionrateExample.Criteria)this);
    }

    public CpsCommissionrateExample.Criteria andBidtypeNotIn(List<Integer> values) {
      addCriterion("bidtype not in", values, "bidtype");
      return ((CpsCommissionrateExample.Criteria)this);
    }

    public CpsCommissionrateExample.Criteria andBidtypeBetween(Integer value1, Integer value2) {
      addCriterion("bidtype between", value1, value2, "bidtype");
      return ((CpsCommissionrateExample.Criteria)this);
    }

    public CpsCommissionrateExample.Criteria andBidtypeNotBetween(Integer value1, Integer value2) {
      addCriterion("bidtype not between", value1, value2, "bidtype");
      return ((CpsCommissionrateExample.Criteria)this);
    }

    public CpsCommissionrateExample.Criteria andInvestamtfIsNull() {
      addCriterion("investamtf is null");
      return ((CpsCommissionrateExample.Criteria)this);
    }

    public CpsCommissionrateExample.Criteria andInvestamtfIsNotNull() {
      addCriterion("investamtf is not null");
      return ((CpsCommissionrateExample.Criteria)this);
    }

    public CpsCommissionrateExample.Criteria andInvestamtfEqualTo(BigDecimal value) {
      addCriterion("investamtf =", value, "investamtf");
      return ((CpsCommissionrateExample.Criteria)this);
    }

    public CpsCommissionrateExample.Criteria andInvestamtfNotEqualTo(BigDecimal value) {
      addCriterion("investamtf <>", value, "investamtf");
      return ((CpsCommissionrateExample.Criteria)this);
    }

    public CpsCommissionrateExample.Criteria andInvestamtfGreaterThan(BigDecimal value) {
      addCriterion("investamtf >", value, "investamtf");
      return ((CpsCommissionrateExample.Criteria)this);
    }

    public CpsCommissionrateExample.Criteria andInvestamtfGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("investamtf >=", value, "investamtf");
      return ((CpsCommissionrateExample.Criteria)this);
    }

    public CpsCommissionrateExample.Criteria andInvestamtfLessThan(BigDecimal value) {
      addCriterion("investamtf <", value, "investamtf");
      return ((CpsCommissionrateExample.Criteria)this);
    }

    public CpsCommissionrateExample.Criteria andInvestamtfLessThanOrEqualTo(BigDecimal value) {
      addCriterion("investamtf <=", value, "investamtf");
      return ((CpsCommissionrateExample.Criteria)this);
    }

    public CpsCommissionrateExample.Criteria andInvestamtfIn(List<BigDecimal> values) {
      addCriterion("investamtf in", values, "investamtf");
      return ((CpsCommissionrateExample.Criteria)this);
    }

    public CpsCommissionrateExample.Criteria andInvestamtfNotIn(List<BigDecimal> values) {
      addCriterion("investamtf not in", values, "investamtf");
      return ((CpsCommissionrateExample.Criteria)this);
    }

    public CpsCommissionrateExample.Criteria andInvestamtfBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("investamtf between", value1, value2, "investamtf");
      return ((CpsCommissionrateExample.Criteria)this);
    }

    public CpsCommissionrateExample.Criteria andInvestamtfNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("investamtf not between", value1, value2, "investamtf");
      return ((CpsCommissionrateExample.Criteria)this);
    }

    public CpsCommissionrateExample.Criteria andInvestamttIsNull() {
      addCriterion("investamtt is null");
      return ((CpsCommissionrateExample.Criteria)this);
    }

    public CpsCommissionrateExample.Criteria andInvestamttIsNotNull() {
      addCriterion("investamtt is not null");
      return ((CpsCommissionrateExample.Criteria)this);
    }

    public CpsCommissionrateExample.Criteria andInvestamttEqualTo(BigDecimal value) {
      addCriterion("investamtt =", value, "investamtt");
      return ((CpsCommissionrateExample.Criteria)this);
    }

    public CpsCommissionrateExample.Criteria andInvestamttNotEqualTo(BigDecimal value) {
      addCriterion("investamtt <>", value, "investamtt");
      return ((CpsCommissionrateExample.Criteria)this);
    }

    public CpsCommissionrateExample.Criteria andInvestamttGreaterThan(BigDecimal value) {
      addCriterion("investamtt >", value, "investamtt");
      return ((CpsCommissionrateExample.Criteria)this);
    }

    public CpsCommissionrateExample.Criteria andInvestamttGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("investamtt >=", value, "investamtt");
      return ((CpsCommissionrateExample.Criteria)this);
    }

    public CpsCommissionrateExample.Criteria andInvestamttLessThan(BigDecimal value) {
      addCriterion("investamtt <", value, "investamtt");
      return ((CpsCommissionrateExample.Criteria)this);
    }

    public CpsCommissionrateExample.Criteria andInvestamttLessThanOrEqualTo(BigDecimal value) {
      addCriterion("investamtt <=", value, "investamtt");
      return ((CpsCommissionrateExample.Criteria)this);
    }

    public CpsCommissionrateExample.Criteria andInvestamttIn(List<BigDecimal> values) {
      addCriterion("investamtt in", values, "investamtt");
      return ((CpsCommissionrateExample.Criteria)this);
    }

    public CpsCommissionrateExample.Criteria andInvestamttNotIn(List<BigDecimal> values) {
      addCriterion("investamtt not in", values, "investamtt");
      return ((CpsCommissionrateExample.Criteria)this);
    }

    public CpsCommissionrateExample.Criteria andInvestamttBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("investamtt between", value1, value2, "investamtt");
      return ((CpsCommissionrateExample.Criteria)this);
    }

    public CpsCommissionrateExample.Criteria andInvestamttNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("investamtt not between", value1, value2, "investamtt");
      return ((CpsCommissionrateExample.Criteria)this);
    }

    public CpsCommissionrateExample.Criteria andCommissionrateIsNull() {
      addCriterion("commissionrate is null");
      return ((CpsCommissionrateExample.Criteria)this);
    }

    public CpsCommissionrateExample.Criteria andCommissionrateIsNotNull() {
      addCriterion("commissionrate is not null");
      return ((CpsCommissionrateExample.Criteria)this);
    }

    public CpsCommissionrateExample.Criteria andCommissionrateEqualTo(BigDecimal value) {
      addCriterion("commissionrate =", value, "commissionrate");
      return ((CpsCommissionrateExample.Criteria)this);
    }

    public CpsCommissionrateExample.Criteria andCommissionrateNotEqualTo(BigDecimal value) {
      addCriterion("commissionrate <>", value, "commissionrate");
      return ((CpsCommissionrateExample.Criteria)this);
    }

    public CpsCommissionrateExample.Criteria andCommissionrateGreaterThan(BigDecimal value) {
      addCriterion("commissionrate >", value, "commissionrate");
      return ((CpsCommissionrateExample.Criteria)this);
    }

    public CpsCommissionrateExample.Criteria andCommissionrateGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("commissionrate >=", value, "commissionrate");
      return ((CpsCommissionrateExample.Criteria)this);
    }

    public CpsCommissionrateExample.Criteria andCommissionrateLessThan(BigDecimal value) {
      addCriterion("commissionrate <", value, "commissionrate");
      return ((CpsCommissionrateExample.Criteria)this);
    }

    public CpsCommissionrateExample.Criteria andCommissionrateLessThanOrEqualTo(BigDecimal value) {
      addCriterion("commissionrate <=", value, "commissionrate");
      return ((CpsCommissionrateExample.Criteria)this);
    }

    public CpsCommissionrateExample.Criteria andCommissionrateIn(List<BigDecimal> values) {
      addCriterion("commissionrate in", values, "commissionrate");
      return ((CpsCommissionrateExample.Criteria)this);
    }

    public CpsCommissionrateExample.Criteria andCommissionrateNotIn(List<BigDecimal> values) {
      addCriterion("commissionrate not in", values, "commissionrate");
      return ((CpsCommissionrateExample.Criteria)this);
    }

    public CpsCommissionrateExample.Criteria andCommissionrateBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("commissionrate between", value1, value2, "commissionrate");
      return ((CpsCommissionrateExample.Criteria)this);
    }

    public CpsCommissionrateExample.Criteria andCommissionrateNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("commissionrate not between", value1, value2, "commissionrate");
      return ((CpsCommissionrateExample.Criteria)this);
    }

    public CpsCommissionrateExample.Criteria andChannelIsNull() {
      addCriterion("channel is null");
      return ((CpsCommissionrateExample.Criteria)this);
    }

    public CpsCommissionrateExample.Criteria andChannelIsNotNull() {
      addCriterion("channel is not null");
      return ((CpsCommissionrateExample.Criteria)this);
    }

    public CpsCommissionrateExample.Criteria andChannelEqualTo(String value) {
      addCriterion("channel =", value, "channel");
      return ((CpsCommissionrateExample.Criteria)this);
    }

    public CpsCommissionrateExample.Criteria andChannelNotEqualTo(String value) {
      addCriterion("channel <>", value, "channel");
      return ((CpsCommissionrateExample.Criteria)this);
    }

    public CpsCommissionrateExample.Criteria andChannelGreaterThan(String value) {
      addCriterion("channel >", value, "channel");
      return ((CpsCommissionrateExample.Criteria)this);
    }

    public CpsCommissionrateExample.Criteria andChannelGreaterThanOrEqualTo(String value) {
      addCriterion("channel >=", value, "channel");
      return ((CpsCommissionrateExample.Criteria)this);
    }

    public CpsCommissionrateExample.Criteria andChannelLessThan(String value) {
      addCriterion("channel <", value, "channel");
      return ((CpsCommissionrateExample.Criteria)this);
    }

    public CpsCommissionrateExample.Criteria andChannelLessThanOrEqualTo(String value) {
      addCriterion("channel <=", value, "channel");
      return ((CpsCommissionrateExample.Criteria)this);
    }

    public CpsCommissionrateExample.Criteria andChannelLike(String value) {
      addCriterion("channel like", value, "channel");
      return ((CpsCommissionrateExample.Criteria)this);
    }

    public CpsCommissionrateExample.Criteria andChannelNotLike(String value) {
      addCriterion("channel not like", value, "channel");
      return ((CpsCommissionrateExample.Criteria)this);
    }

    public CpsCommissionrateExample.Criteria andChannelIn(List<String> values) {
      addCriterion("channel in", values, "channel");
      return ((CpsCommissionrateExample.Criteria)this);
    }

    public CpsCommissionrateExample.Criteria andChannelNotIn(List<String> values) {
      addCriterion("channel not in", values, "channel");
      return ((CpsCommissionrateExample.Criteria)this);
    }

    public CpsCommissionrateExample.Criteria andChannelBetween(String value1, String value2) {
      addCriterion("channel between", value1, value2, "channel");
      return ((CpsCommissionrateExample.Criteria)this);
    }

    public CpsCommissionrateExample.Criteria andChannelNotBetween(String value1, String value2) {
      addCriterion("channel not between", value1, value2, "channel");
      return ((CpsCommissionrateExample.Criteria)this);
    }

    public CpsCommissionrateExample.Criteria andChannel2IsNull() {
      addCriterion("channel2 is null");
      return ((CpsCommissionrateExample.Criteria)this);
    }

    public CpsCommissionrateExample.Criteria andChannel2IsNotNull() {
      addCriterion("channel2 is not null");
      return ((CpsCommissionrateExample.Criteria)this);
    }

    public CpsCommissionrateExample.Criteria andChannel2EqualTo(String value) {
      addCriterion("channel2 =", value, "channel2");
      return ((CpsCommissionrateExample.Criteria)this);
    }

    public CpsCommissionrateExample.Criteria andChannel2NotEqualTo(String value) {
      addCriterion("channel2 <>", value, "channel2");
      return ((CpsCommissionrateExample.Criteria)this);
    }

    public CpsCommissionrateExample.Criteria andChannel2GreaterThan(String value) {
      addCriterion("channel2 >", value, "channel2");
      return ((CpsCommissionrateExample.Criteria)this);
    }

    public CpsCommissionrateExample.Criteria andChannel2GreaterThanOrEqualTo(String value) {
      addCriterion("channel2 >=", value, "channel2");
      return ((CpsCommissionrateExample.Criteria)this);
    }

    public CpsCommissionrateExample.Criteria andChannel2LessThan(String value) {
      addCriterion("channel2 <", value, "channel2");
      return ((CpsCommissionrateExample.Criteria)this);
    }

    public CpsCommissionrateExample.Criteria andChannel2LessThanOrEqualTo(String value) {
      addCriterion("channel2 <=", value, "channel2");
      return ((CpsCommissionrateExample.Criteria)this);
    }

    public CpsCommissionrateExample.Criteria andChannel2Like(String value) {
      addCriterion("channel2 like", value, "channel2");
      return ((CpsCommissionrateExample.Criteria)this);
    }

    public CpsCommissionrateExample.Criteria andChannel2NotLike(String value) {
      addCriterion("channel2 not like", value, "channel2");
      return ((CpsCommissionrateExample.Criteria)this);
    }

    public CpsCommissionrateExample.Criteria andChannel2In(List<String> values) {
      addCriterion("channel2 in", values, "channel2");
      return ((CpsCommissionrateExample.Criteria)this);
    }

    public CpsCommissionrateExample.Criteria andChannel2NotIn(List<String> values) {
      addCriterion("channel2 not in", values, "channel2");
      return ((CpsCommissionrateExample.Criteria)this);
    }

    public CpsCommissionrateExample.Criteria andChannel2Between(String value1, String value2) {
      addCriterion("channel2 between", value1, value2, "channel2");
      return ((CpsCommissionrateExample.Criteria)this);
    }

    public CpsCommissionrateExample.Criteria andChannel2NotBetween(String value1, String value2) {
      addCriterion("channel2 not between", value1, value2, "channel2");
      return ((CpsCommissionrateExample.Criteria)this);
    }

    public CpsCommissionrateExample.Criteria andRemarkIsNull() {
      addCriterion("remark is null");
      return ((CpsCommissionrateExample.Criteria)this);
    }

    public CpsCommissionrateExample.Criteria andRemarkIsNotNull() {
      addCriterion("remark is not null");
      return ((CpsCommissionrateExample.Criteria)this);
    }

    public CpsCommissionrateExample.Criteria andRemarkEqualTo(String value) {
      addCriterion("remark =", value, "remark");
      return ((CpsCommissionrateExample.Criteria)this);
    }

    public CpsCommissionrateExample.Criteria andRemarkNotEqualTo(String value) {
      addCriterion("remark <>", value, "remark");
      return ((CpsCommissionrateExample.Criteria)this);
    }

    public CpsCommissionrateExample.Criteria andRemarkGreaterThan(String value) {
      addCriterion("remark >", value, "remark");
      return ((CpsCommissionrateExample.Criteria)this);
    }

    public CpsCommissionrateExample.Criteria andRemarkGreaterThanOrEqualTo(String value) {
      addCriterion("remark >=", value, "remark");
      return ((CpsCommissionrateExample.Criteria)this);
    }

    public CpsCommissionrateExample.Criteria andRemarkLessThan(String value) {
      addCriterion("remark <", value, "remark");
      return ((CpsCommissionrateExample.Criteria)this);
    }

    public CpsCommissionrateExample.Criteria andRemarkLessThanOrEqualTo(String value) {
      addCriterion("remark <=", value, "remark");
      return ((CpsCommissionrateExample.Criteria)this);
    }

    public CpsCommissionrateExample.Criteria andRemarkLike(String value) {
      addCriterion("remark like", value, "remark");
      return ((CpsCommissionrateExample.Criteria)this);
    }

    public CpsCommissionrateExample.Criteria andRemarkNotLike(String value) {
      addCriterion("remark not like", value, "remark");
      return ((CpsCommissionrateExample.Criteria)this);
    }

    public CpsCommissionrateExample.Criteria andRemarkIn(List<String> values) {
      addCriterion("remark in", values, "remark");
      return ((CpsCommissionrateExample.Criteria)this);
    }

    public CpsCommissionrateExample.Criteria andRemarkNotIn(List<String> values) {
      addCriterion("remark not in", values, "remark");
      return ((CpsCommissionrateExample.Criteria)this);
    }

    public CpsCommissionrateExample.Criteria andRemarkBetween(String value1, String value2) {
      addCriterion("remark between", value1, value2, "remark");
      return ((CpsCommissionrateExample.Criteria)this);
    }

    public CpsCommissionrateExample.Criteria andRemarkNotBetween(String value1, String value2) {
      addCriterion("remark not between", value1, value2, "remark");
      return ((CpsCommissionrateExample.Criteria)this);
    }
  }
}