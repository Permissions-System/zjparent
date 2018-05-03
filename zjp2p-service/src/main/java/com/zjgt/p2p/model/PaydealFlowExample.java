package com.zjgt.p2p.model;

import java.util.ArrayList;
import java.util.List;

public class PaydealFlowExample
{
  protected String orderByClause;
  protected boolean distinct;
  protected List<Criteria> oredCriteria;

  public PaydealFlowExample()
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

  public static class Criteria extends PaydealFlowExample.GeneratedCriteria
  {
  }

  protected static abstract class GeneratedCriteria
  {
    protected List<PaydealFlowExample.Criterion> criteria;

    protected GeneratedCriteria()
    {
      this.criteria = new ArrayList();
    }

    public boolean isValid() {
      return (this.criteria.size() > 0);
    }

    public List<PaydealFlowExample.Criterion> getAllCriteria() {
      return this.criteria;
    }

    public List<PaydealFlowExample.Criterion> getCriteria() {
      return this.criteria;
    }

    protected void addCriterion(String condition) {
      if (condition == null) {
        throw new RuntimeException("Value for condition cannot be null");
      }
      this.criteria.add(new PaydealFlowExample.Criterion(condition));
    }

    protected void addCriterion(String condition, Object value, String property) {
      if (value == null) {
        throw new RuntimeException("Value for " + property + " cannot be null");
      }
      this.criteria.add(new PaydealFlowExample.Criterion(condition, value));
    }

    protected void addCriterion(String condition, Object value1, Object value2, String property) {
      if ((value1 == null) || (value2 == null)) {
        throw new RuntimeException("Between values for " + property + " cannot be null");
      }
      this.criteria.add(new PaydealFlowExample.Criterion(condition, value1, value2));
    }

    public PaydealFlowExample.Criteria andDealflownumIsNull() {
      addCriterion("DealFlowNum is null");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealflownumIsNotNull() {
      addCriterion("DealFlowNum is not null");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealflownumEqualTo(String value) {
      addCriterion("DealFlowNum =", value, "dealflownum");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealflownumNotEqualTo(String value) {
      addCriterion("DealFlowNum <>", value, "dealflownum");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealflownumGreaterThan(String value) {
      addCriterion("DealFlowNum >", value, "dealflownum");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealflownumGreaterThanOrEqualTo(String value) {
      addCriterion("DealFlowNum >=", value, "dealflownum");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealflownumLessThan(String value) {
      addCriterion("DealFlowNum <", value, "dealflownum");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealflownumLessThanOrEqualTo(String value) {
      addCriterion("DealFlowNum <=", value, "dealflownum");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealflownumLike(String value) {
      addCriterion("DealFlowNum like", value, "dealflownum");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealflownumNotLike(String value) {
      addCriterion("DealFlowNum not like", value, "dealflownum");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealflownumIn(List<String> values) {
      addCriterion("DealFlowNum in", values, "dealflownum");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealflownumNotIn(List<String> values) {
      addCriterion("DealFlowNum not in", values, "dealflownum");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealflownumBetween(String value1, String value2) {
      addCriterion("DealFlowNum between", value1, value2, "dealflownum");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealflownumNotBetween(String value1, String value2) {
      addCriterion("DealFlowNum not between", value1, value2, "dealflownum");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealidIsNull() {
      addCriterion("DealID is null");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealidIsNotNull() {
      addCriterion("DealID is not null");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealidEqualTo(String value) {
      addCriterion("DealID =", value, "dealid");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealidNotEqualTo(String value) {
      addCriterion("DealID <>", value, "dealid");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealidGreaterThan(String value) {
      addCriterion("DealID >", value, "dealid");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealidGreaterThanOrEqualTo(String value) {
      addCriterion("DealID >=", value, "dealid");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealidLessThan(String value) {
      addCriterion("DealID <", value, "dealid");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealidLessThanOrEqualTo(String value) {
      addCriterion("DealID <=", value, "dealid");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealidLike(String value) {
      addCriterion("DealID like", value, "dealid");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealidNotLike(String value) {
      addCriterion("DealID not like", value, "dealid");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealidIn(List<String> values) {
      addCriterion("DealID in", values, "dealid");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealidNotIn(List<String> values) {
      addCriterion("DealID not in", values, "dealid");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealidBetween(String value1, String value2) {
      addCriterion("DealID between", value1, value2, "dealid");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealidNotBetween(String value1, String value2) {
      addCriterion("DealID not between", value1, value2, "dealid");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealtypeIsNull() {
      addCriterion("DealType is null");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealtypeIsNotNull() {
      addCriterion("DealType is not null");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealtypeEqualTo(String value) {
      addCriterion("DealType =", value, "dealtype");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealtypeNotEqualTo(String value) {
      addCriterion("DealType <>", value, "dealtype");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealtypeGreaterThan(String value) {
      addCriterion("DealType >", value, "dealtype");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealtypeGreaterThanOrEqualTo(String value) {
      addCriterion("DealType >=", value, "dealtype");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealtypeLessThan(String value) {
      addCriterion("DealType <", value, "dealtype");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealtypeLessThanOrEqualTo(String value) {
      addCriterion("DealType <=", value, "dealtype");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealtypeLike(String value) {
      addCriterion("DealType like", value, "dealtype");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealtypeNotLike(String value) {
      addCriterion("DealType not like", value, "dealtype");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealtypeIn(List<String> values) {
      addCriterion("DealType in", values, "dealtype");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealtypeNotIn(List<String> values) {
      addCriterion("DealType not in", values, "dealtype");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealtypeBetween(String value1, String value2) {
      addCriterion("DealType between", value1, value2, "dealtype");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealtypeNotBetween(String value1, String value2) {
      addCriterion("DealType not between", value1, value2, "dealtype");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealuseridIsNull() {
      addCriterion("DealUserID is null");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealuseridIsNotNull() {
      addCriterion("DealUserID is not null");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealuseridEqualTo(Long value) {
      addCriterion("DealUserID =", value, "dealuserid");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealuseridNotEqualTo(Long value) {
      addCriterion("DealUserID <>", value, "dealuserid");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealuseridGreaterThan(Long value) {
      addCriterion("DealUserID >", value, "dealuserid");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealuseridGreaterThanOrEqualTo(Long value) {
      addCriterion("DealUserID >=", value, "dealuserid");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealuseridLessThan(Long value) {
      addCriterion("DealUserID <", value, "dealuserid");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealuseridLessThanOrEqualTo(Long value) {
      addCriterion("DealUserID <=", value, "dealuserid");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealuseridIn(List<Long> values) {
      addCriterion("DealUserID in", values, "dealuserid");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealuseridNotIn(List<Long> values) {
      addCriterion("DealUserID not in", values, "dealuserid");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealuseridBetween(Long value1, Long value2) {
      addCriterion("DealUserID between", value1, value2, "dealuserid");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealuseridNotBetween(Long value1, Long value2) {
      addCriterion("DealUserID not between", value1, value2, "dealuserid");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealrequesttimeIsNull() {
      addCriterion("DealRequestTime is null");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealrequesttimeIsNotNull() {
      addCriterion("DealRequestTime is not null");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealrequesttimeEqualTo(String value) {
      addCriterion("DealRequestTime =", value, "dealrequesttime");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealrequesttimeNotEqualTo(String value) {
      addCriterion("DealRequestTime <>", value, "dealrequesttime");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealrequesttimeGreaterThan(String value) {
      addCriterion("DealRequestTime >", value, "dealrequesttime");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealrequesttimeGreaterThanOrEqualTo(String value) {
      addCriterion("DealRequestTime >=", value, "dealrequesttime");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealrequesttimeLessThan(String value) {
      addCriterion("DealRequestTime <", value, "dealrequesttime");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealrequesttimeLessThanOrEqualTo(String value) {
      addCriterion("DealRequestTime <=", value, "dealrequesttime");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealrequesttimeLike(String value) {
      addCriterion("DealRequestTime like", value, "dealrequesttime");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealrequesttimeNotLike(String value) {
      addCriterion("DealRequestTime not like", value, "dealrequesttime");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealrequesttimeIn(List<String> values) {
      addCriterion("DealRequestTime in", values, "dealrequesttime");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealrequesttimeNotIn(List<String> values) {
      addCriterion("DealRequestTime not in", values, "dealrequesttime");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealrequesttimeBetween(String value1, String value2) {
      addCriterion("DealRequestTime between", value1, value2, "dealrequesttime");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealrequesttimeNotBetween(String value1, String value2) {
      addCriterion("DealRequestTime not between", value1, value2, "dealrequesttime");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealobjectIsNull() {
      addCriterion("DealObject is null");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealobjectIsNotNull() {
      addCriterion("DealObject is not null");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealobjectEqualTo(String value) {
      addCriterion("DealObject =", value, "dealobject");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealobjectNotEqualTo(String value) {
      addCriterion("DealObject <>", value, "dealobject");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealobjectGreaterThan(String value) {
      addCriterion("DealObject >", value, "dealobject");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealobjectGreaterThanOrEqualTo(String value) {
      addCriterion("DealObject >=", value, "dealobject");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealobjectLessThan(String value) {
      addCriterion("DealObject <", value, "dealobject");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealobjectLessThanOrEqualTo(String value) {
      addCriterion("DealObject <=", value, "dealobject");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealobjectLike(String value) {
      addCriterion("DealObject like", value, "dealobject");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealobjectNotLike(String value) {
      addCriterion("DealObject not like", value, "dealobject");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealobjectIn(List<String> values) {
      addCriterion("DealObject in", values, "dealobject");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealobjectNotIn(List<String> values) {
      addCriterion("DealObject not in", values, "dealobject");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealobjectBetween(String value1, String value2) {
      addCriterion("DealObject between", value1, value2, "dealobject");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealobjectNotBetween(String value1, String value2) {
      addCriterion("DealObject not between", value1, value2, "dealobject");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealamountIsNull() {
      addCriterion("DealAmount is null");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealamountIsNotNull() {
      addCriterion("DealAmount is not null");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealamountEqualTo(Float value) {
      addCriterion("DealAmount =", value, "dealamount");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealamountNotEqualTo(Float value) {
      addCriterion("DealAmount <>", value, "dealamount");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealamountGreaterThan(Float value) {
      addCriterion("DealAmount >", value, "dealamount");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealamountGreaterThanOrEqualTo(Float value) {
      addCriterion("DealAmount >=", value, "dealamount");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealamountLessThan(Float value) {
      addCriterion("DealAmount <", value, "dealamount");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealamountLessThanOrEqualTo(Float value) {
      addCriterion("DealAmount <=", value, "dealamount");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealamountIn(List<Float> values) {
      addCriterion("DealAmount in", values, "dealamount");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealamountNotIn(List<Float> values) {
      addCriterion("DealAmount not in", values, "dealamount");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealamountBetween(Float value1, Float value2) {
      addCriterion("DealAmount between", value1, value2, "dealamount");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealamountNotBetween(Float value1, Float value2) {
      addCriterion("DealAmount not between", value1, value2, "dealamount");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealresponsemsgIsNull() {
      addCriterion("DealResponseMsg is null");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealresponsemsgIsNotNull() {
      addCriterion("DealResponseMsg is not null");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealresponsemsgEqualTo(String value) {
      addCriterion("DealResponseMsg =", value, "dealresponsemsg");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealresponsemsgNotEqualTo(String value) {
      addCriterion("DealResponseMsg <>", value, "dealresponsemsg");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealresponsemsgGreaterThan(String value) {
      addCriterion("DealResponseMsg >", value, "dealresponsemsg");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealresponsemsgGreaterThanOrEqualTo(String value) {
      addCriterion("DealResponseMsg >=", value, "dealresponsemsg");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealresponsemsgLessThan(String value) {
      addCriterion("DealResponseMsg <", value, "dealresponsemsg");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealresponsemsgLessThanOrEqualTo(String value) {
      addCriterion("DealResponseMsg <=", value, "dealresponsemsg");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealresponsemsgLike(String value) {
      addCriterion("DealResponseMsg like", value, "dealresponsemsg");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealresponsemsgNotLike(String value) {
      addCriterion("DealResponseMsg not like", value, "dealresponsemsg");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealresponsemsgIn(List<String> values) {
      addCriterion("DealResponseMsg in", values, "dealresponsemsg");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealresponsemsgNotIn(List<String> values) {
      addCriterion("DealResponseMsg not in", values, "dealresponsemsg");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealresponsemsgBetween(String value1, String value2) {
      addCriterion("DealResponseMsg between", value1, value2, "dealresponsemsg");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealresponsemsgNotBetween(String value1, String value2) {
      addCriterion("DealResponseMsg not between", value1, value2, "dealresponsemsg");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealrequestmsgIsNull() {
      addCriterion("DealRequestMsg is null");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealrequestmsgIsNotNull() {
      addCriterion("DealRequestMsg is not null");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealrequestmsgEqualTo(String value) {
      addCriterion("DealRequestMsg =", value, "dealrequestmsg");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealrequestmsgNotEqualTo(String value) {
      addCriterion("DealRequestMsg <>", value, "dealrequestmsg");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealrequestmsgGreaterThan(String value) {
      addCriterion("DealRequestMsg >", value, "dealrequestmsg");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealrequestmsgGreaterThanOrEqualTo(String value) {
      addCriterion("DealRequestMsg >=", value, "dealrequestmsg");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealrequestmsgLessThan(String value) {
      addCriterion("DealRequestMsg <", value, "dealrequestmsg");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealrequestmsgLessThanOrEqualTo(String value) {
      addCriterion("DealRequestMsg <=", value, "dealrequestmsg");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealrequestmsgLike(String value) {
      addCriterion("DealRequestMsg like", value, "dealrequestmsg");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealrequestmsgNotLike(String value) {
      addCriterion("DealRequestMsg not like", value, "dealrequestmsg");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealrequestmsgIn(List<String> values) {
      addCriterion("DealRequestMsg in", values, "dealrequestmsg");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealrequestmsgNotIn(List<String> values) {
      addCriterion("DealRequestMsg not in", values, "dealrequestmsg");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealrequestmsgBetween(String value1, String value2) {
      addCriterion("DealRequestMsg between", value1, value2, "dealrequestmsg");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealrequestmsgNotBetween(String value1, String value2) {
      addCriterion("DealRequestMsg not between", value1, value2, "dealrequestmsg");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealstatusIsNull() {
      addCriterion("DealStatus is null");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealstatusIsNotNull() {
      addCriterion("DealStatus is not null");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealstatusEqualTo(Byte value) {
      addCriterion("DealStatus =", value, "dealstatus");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealstatusNotEqualTo(Byte value) {
      addCriterion("DealStatus <>", value, "dealstatus");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealstatusGreaterThan(Byte value) {
      addCriterion("DealStatus >", value, "dealstatus");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealstatusGreaterThanOrEqualTo(Byte value) {
      addCriterion("DealStatus >=", value, "dealstatus");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealstatusLessThan(Byte value) {
      addCriterion("DealStatus <", value, "dealstatus");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealstatusLessThanOrEqualTo(Byte value) {
      addCriterion("DealStatus <=", value, "dealstatus");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealstatusIn(List<Byte> values) {
      addCriterion("DealStatus in", values, "dealstatus");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealstatusNotIn(List<Byte> values) {
      addCriterion("DealStatus not in", values, "dealstatus");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealstatusBetween(Byte value1, Byte value2) {
      addCriterion("DealStatus between", value1, value2, "dealstatus");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealstatusNotBetween(Byte value1, Byte value2) {
      addCriterion("DealStatus not between", value1, value2, "dealstatus");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealresponsetimeIsNull() {
      addCriterion("DealResponseTime is null");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealresponsetimeIsNotNull() {
      addCriterion("DealResponseTime is not null");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealresponsetimeEqualTo(String value) {
      addCriterion("DealResponseTime =", value, "dealresponsetime");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealresponsetimeNotEqualTo(String value) {
      addCriterion("DealResponseTime <>", value, "dealresponsetime");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealresponsetimeGreaterThan(String value) {
      addCriterion("DealResponseTime >", value, "dealresponsetime");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealresponsetimeGreaterThanOrEqualTo(String value) {
      addCriterion("DealResponseTime >=", value, "dealresponsetime");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealresponsetimeLessThan(String value) {
      addCriterion("DealResponseTime <", value, "dealresponsetime");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealresponsetimeLessThanOrEqualTo(String value) {
      addCriterion("DealResponseTime <=", value, "dealresponsetime");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealresponsetimeLike(String value) {
      addCriterion("DealResponseTime like", value, "dealresponsetime");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealresponsetimeNotLike(String value) {
      addCriterion("DealResponseTime not like", value, "dealresponsetime");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealresponsetimeIn(List<String> values) {
      addCriterion("DealResponseTime in", values, "dealresponsetime");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealresponsetimeNotIn(List<String> values) {
      addCriterion("DealResponseTime not in", values, "dealresponsetime");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealresponsetimeBetween(String value1, String value2) {
      addCriterion("DealResponseTime between", value1, value2, "dealresponsetime");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealresponsetimeNotBetween(String value1, String value2) {
      addCriterion("DealResponseTime not between", value1, value2, "dealresponsetime");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealfaileddescIsNull() {
      addCriterion("DealFailedDesc is null");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealfaileddescIsNotNull() {
      addCriterion("DealFailedDesc is not null");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealfaileddescEqualTo(String value) {
      addCriterion("DealFailedDesc =", value, "dealfaileddesc");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealfaileddescNotEqualTo(String value) {
      addCriterion("DealFailedDesc <>", value, "dealfaileddesc");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealfaileddescGreaterThan(String value) {
      addCriterion("DealFailedDesc >", value, "dealfaileddesc");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealfaileddescGreaterThanOrEqualTo(String value) {
      addCriterion("DealFailedDesc >=", value, "dealfaileddesc");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealfaileddescLessThan(String value) {
      addCriterion("DealFailedDesc <", value, "dealfaileddesc");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealfaileddescLessThanOrEqualTo(String value) {
      addCriterion("DealFailedDesc <=", value, "dealfaileddesc");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealfaileddescLike(String value) {
      addCriterion("DealFailedDesc like", value, "dealfaileddesc");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealfaileddescNotLike(String value) {
      addCriterion("DealFailedDesc not like", value, "dealfaileddesc");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealfaileddescIn(List<String> values) {
      addCriterion("DealFailedDesc in", values, "dealfaileddesc");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealfaileddescNotIn(List<String> values) {
      addCriterion("DealFailedDesc not in", values, "dealfaileddesc");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealfaileddescBetween(String value1, String value2) {
      addCriterion("DealFailedDesc between", value1, value2, "dealfaileddesc");
      return ((PaydealFlowExample.Criteria)this);
    }

    public PaydealFlowExample.Criteria andDealfaileddescNotBetween(String value1, String value2) {
      addCriterion("DealFailedDesc not between", value1, value2, "dealfaileddesc");
      return ((PaydealFlowExample.Criteria)this);
    }
  }
}