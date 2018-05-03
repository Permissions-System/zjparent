package com.zjgt.p2p.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InvestorderhistoryExample
{
  protected String orderByClause;
  protected boolean distinct;
  protected List<Criteria> oredCriteria;

  public InvestorderhistoryExample()
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

  public static class Criteria extends InvestorderhistoryExample.GeneratedCriteria
  {
  }

  protected static abstract class GeneratedCriteria
  {
    protected List<InvestorderhistoryExample.Criterion> criteria;

    protected GeneratedCriteria()
    {
      this.criteria = new ArrayList();
    }

    public boolean isValid() {
      return (this.criteria.size() > 0);
    }

    public List<InvestorderhistoryExample.Criterion> getAllCriteria() {
      return this.criteria;
    }

    public List<InvestorderhistoryExample.Criterion> getCriteria() {
      return this.criteria;
    }

    protected void addCriterion(String condition) {
      if (condition == null) {
        throw new RuntimeException("Value for condition cannot be null");
      }
      this.criteria.add(new InvestorderhistoryExample.Criterion(condition));
    }

    protected void addCriterion(String condition, Object value, String property) {
      if (value == null) {
        throw new RuntimeException("Value for " + property + " cannot be null");
      }
      this.criteria.add(new InvestorderhistoryExample.Criterion(condition, value));
    }

    protected void addCriterion(String condition, Object value1, Object value2, String property) {
      if ((value1 == null) || (value2 == null)) {
        throw new RuntimeException("Between values for " + property + " cannot be null");
      }
      this.criteria.add(new InvestorderhistoryExample.Criterion(condition, value1, value2));
    }

    public InvestorderhistoryExample.Criteria andIdIsNull() {
      addCriterion("ID is null");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andIdIsNotNull() {
      addCriterion("ID is not null");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andIdEqualTo(Integer value) {
      addCriterion("ID =", value, "id");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andIdNotEqualTo(Integer value) {
      addCriterion("ID <>", value, "id");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andIdGreaterThan(Integer value) {
      addCriterion("ID >", value, "id");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andIdGreaterThanOrEqualTo(Integer value) {
      addCriterion("ID >=", value, "id");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andIdLessThan(Integer value) {
      addCriterion("ID <", value, "id");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andIdLessThanOrEqualTo(Integer value) {
      addCriterion("ID <=", value, "id");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andIdIn(List<Integer> values) {
      addCriterion("ID in", values, "id");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andIdNotIn(List<Integer> values) {
      addCriterion("ID not in", values, "id");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andIdBetween(Integer value1, Integer value2) {
      addCriterion("ID between", value1, value2, "id");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andIdNotBetween(Integer value1, Integer value2) {
      addCriterion("ID not between", value1, value2, "id");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andSerialidIsNull() {
      addCriterion("SerialId is null");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andSerialidIsNotNull() {
      addCriterion("SerialId is not null");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andSerialidEqualTo(Integer value) {
      addCriterion("SerialId =", value, "serialid");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andSerialidNotEqualTo(Integer value) {
      addCriterion("SerialId <>", value, "serialid");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andSerialidGreaterThan(Integer value) {
      addCriterion("SerialId >", value, "serialid");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andSerialidGreaterThanOrEqualTo(Integer value) {
      addCriterion("SerialId >=", value, "serialid");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andSerialidLessThan(Integer value) {
      addCriterion("SerialId <", value, "serialid");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andSerialidLessThanOrEqualTo(Integer value) {
      addCriterion("SerialId <=", value, "serialid");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andSerialidIn(List<Integer> values) {
      addCriterion("SerialId in", values, "serialid");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andSerialidNotIn(List<Integer> values) {
      addCriterion("SerialId not in", values, "serialid");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andSerialidBetween(Integer value1, Integer value2) {
      addCriterion("SerialId between", value1, value2, "serialid");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andSerialidNotBetween(Integer value1, Integer value2) {
      addCriterion("SerialId not between", value1, value2, "serialid");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andInvestordercodeIsNull() {
      addCriterion("InvestOrderCode is null");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andInvestordercodeIsNotNull() {
      addCriterion("InvestOrderCode is not null");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andInvestordercodeEqualTo(String value) {
      addCriterion("InvestOrderCode =", value, "investordercode");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andInvestordercodeNotEqualTo(String value) {
      addCriterion("InvestOrderCode <>", value, "investordercode");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andInvestordercodeGreaterThan(String value) {
      addCriterion("InvestOrderCode >", value, "investordercode");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andInvestordercodeGreaterThanOrEqualTo(String value) {
      addCriterion("InvestOrderCode >=", value, "investordercode");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andInvestordercodeLessThan(String value) {
      addCriterion("InvestOrderCode <", value, "investordercode");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andInvestordercodeLessThanOrEqualTo(String value) {
      addCriterion("InvestOrderCode <=", value, "investordercode");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andInvestordercodeLike(String value) {
      addCriterion("InvestOrderCode like", value, "investordercode");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andInvestordercodeNotLike(String value) {
      addCriterion("InvestOrderCode not like", value, "investordercode");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andInvestordercodeIn(List<String> values) {
      addCriterion("InvestOrderCode in", values, "investordercode");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andInvestordercodeNotIn(List<String> values) {
      addCriterion("InvestOrderCode not in", values, "investordercode");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andInvestordercodeBetween(String value1, String value2) {
      addCriterion("InvestOrderCode between", value1, value2, "investordercode");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andInvestordercodeNotBetween(String value1, String value2) {
      addCriterion("InvestOrderCode not between", value1, value2, "investordercode");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andPreordercodeIsNull() {
      addCriterion("preOrderCode is null");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andPreordercodeIsNotNull() {
      addCriterion("preOrderCode is not null");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andPreordercodeEqualTo(String value) {
      addCriterion("preOrderCode =", value, "preordercode");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andPreordercodeNotEqualTo(String value) {
      addCriterion("preOrderCode <>", value, "preordercode");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andPreordercodeGreaterThan(String value) {
      addCriterion("preOrderCode >", value, "preordercode");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andPreordercodeGreaterThanOrEqualTo(String value) {
      addCriterion("preOrderCode >=", value, "preordercode");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andPreordercodeLessThan(String value) {
      addCriterion("preOrderCode <", value, "preordercode");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andPreordercodeLessThanOrEqualTo(String value) {
      addCriterion("preOrderCode <=", value, "preordercode");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andPreordercodeLike(String value) {
      addCriterion("preOrderCode like", value, "preordercode");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andPreordercodeNotLike(String value) {
      addCriterion("preOrderCode not like", value, "preordercode");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andPreordercodeIn(List<String> values) {
      addCriterion("preOrderCode in", values, "preordercode");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andPreordercodeNotIn(List<String> values) {
      addCriterion("preOrderCode not in", values, "preordercode");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andPreordercodeBetween(String value1, String value2) {
      addCriterion("preOrderCode between", value1, value2, "preordercode");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andPreordercodeNotBetween(String value1, String value2) {
      addCriterion("preOrderCode not between", value1, value2, "preordercode");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andBidcodeIsNull() {
      addCriterion("BidCode is null");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andBidcodeIsNotNull() {
      addCriterion("BidCode is not null");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andBidcodeEqualTo(String value) {
      addCriterion("BidCode =", value, "bidcode");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andBidcodeNotEqualTo(String value) {
      addCriterion("BidCode <>", value, "bidcode");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andBidcodeGreaterThan(String value) {
      addCriterion("BidCode >", value, "bidcode");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andBidcodeGreaterThanOrEqualTo(String value) {
      addCriterion("BidCode >=", value, "bidcode");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andBidcodeLessThan(String value) {
      addCriterion("BidCode <", value, "bidcode");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andBidcodeLessThanOrEqualTo(String value) {
      addCriterion("BidCode <=", value, "bidcode");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andBidcodeLike(String value) {
      addCriterion("BidCode like", value, "bidcode");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andBidcodeNotLike(String value) {
      addCriterion("BidCode not like", value, "bidcode");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andBidcodeIn(List<String> values) {
      addCriterion("BidCode in", values, "bidcode");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andBidcodeNotIn(List<String> values) {
      addCriterion("BidCode not in", values, "bidcode");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andBidcodeBetween(String value1, String value2) {
      addCriterion("BidCode between", value1, value2, "bidcode");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andBidcodeNotBetween(String value1, String value2) {
      addCriterion("BidCode not between", value1, value2, "bidcode");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andCreditmatchruleidIsNull() {
      addCriterion("CreditMatchRuleId is null");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andCreditmatchruleidIsNotNull() {
      addCriterion("CreditMatchRuleId is not null");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andCreditmatchruleidEqualTo(Integer value) {
      addCriterion("CreditMatchRuleId =", value, "creditmatchruleid");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andCreditmatchruleidNotEqualTo(Integer value) {
      addCriterion("CreditMatchRuleId <>", value, "creditmatchruleid");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andCreditmatchruleidGreaterThan(Integer value) {
      addCriterion("CreditMatchRuleId >", value, "creditmatchruleid");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andCreditmatchruleidGreaterThanOrEqualTo(Integer value) {
      addCriterion("CreditMatchRuleId >=", value, "creditmatchruleid");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andCreditmatchruleidLessThan(Integer value) {
      addCriterion("CreditMatchRuleId <", value, "creditmatchruleid");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andCreditmatchruleidLessThanOrEqualTo(Integer value) {
      addCriterion("CreditMatchRuleId <=", value, "creditmatchruleid");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andCreditmatchruleidIn(List<Integer> values) {
      addCriterion("CreditMatchRuleId in", values, "creditmatchruleid");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andCreditmatchruleidNotIn(List<Integer> values) {
      addCriterion("CreditMatchRuleId not in", values, "creditmatchruleid");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andCreditmatchruleidBetween(Integer value1, Integer value2) {
      addCriterion("CreditMatchRuleId between", value1, value2, "creditmatchruleid");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andCreditmatchruleidNotBetween(Integer value1, Integer value2) {
      addCriterion("CreditMatchRuleId not between", value1, value2, "creditmatchruleid");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andCustomeridIsNull() {
      addCriterion("CustomerID is null");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andCustomeridIsNotNull() {
      addCriterion("CustomerID is not null");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andCustomeridEqualTo(Long value) {
      addCriterion("CustomerID =", value, "customerid");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andCustomeridNotEqualTo(Long value) {
      addCriterion("CustomerID <>", value, "customerid");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andCustomeridGreaterThan(Long value) {
      addCriterion("CustomerID >", value, "customerid");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andCustomeridGreaterThanOrEqualTo(Long value) {
      addCriterion("CustomerID >=", value, "customerid");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andCustomeridLessThan(Long value) {
      addCriterion("CustomerID <", value, "customerid");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andCustomeridLessThanOrEqualTo(Long value) {
      addCriterion("CustomerID <=", value, "customerid");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andCustomeridIn(List<Long> values) {
      addCriterion("CustomerID in", values, "customerid");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andCustomeridNotIn(List<Long> values) {
      addCriterion("CustomerID not in", values, "customerid");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andCustomeridBetween(Long value1, Long value2) {
      addCriterion("CustomerID between", value1, value2, "customerid");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andCustomeridNotBetween(Long value1, Long value2) {
      addCriterion("CustomerID not between", value1, value2, "customerid");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andCustomernicknameIsNull() {
      addCriterion("CustomerNickName is null");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andCustomernicknameIsNotNull() {
      addCriterion("CustomerNickName is not null");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andCustomernicknameEqualTo(String value) {
      addCriterion("CustomerNickName =", value, "customernickname");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andCustomernicknameNotEqualTo(String value) {
      addCriterion("CustomerNickName <>", value, "customernickname");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andCustomernicknameGreaterThan(String value) {
      addCriterion("CustomerNickName >", value, "customernickname");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andCustomernicknameGreaterThanOrEqualTo(String value) {
      addCriterion("CustomerNickName >=", value, "customernickname");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andCustomernicknameLessThan(String value) {
      addCriterion("CustomerNickName <", value, "customernickname");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andCustomernicknameLessThanOrEqualTo(String value) {
      addCriterion("CustomerNickName <=", value, "customernickname");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andCustomernicknameLike(String value) {
      addCriterion("CustomerNickName like", value, "customernickname");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andCustomernicknameNotLike(String value) {
      addCriterion("CustomerNickName not like", value, "customernickname");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andCustomernicknameIn(List<String> values) {
      addCriterion("CustomerNickName in", values, "customernickname");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andCustomernicknameNotIn(List<String> values) {
      addCriterion("CustomerNickName not in", values, "customernickname");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andCustomernicknameBetween(String value1, String value2) {
      addCriterion("CustomerNickName between", value1, value2, "customernickname");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andCustomernicknameNotBetween(String value1, String value2) {
      addCriterion("CustomerNickName not between", value1, value2, "customernickname");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andCustomernameIsNull() {
      addCriterion("CustomerName is null");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andCustomernameIsNotNull() {
      addCriterion("CustomerName is not null");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andCustomernameEqualTo(String value) {
      addCriterion("CustomerName =", value, "customername");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andCustomernameNotEqualTo(String value) {
      addCriterion("CustomerName <>", value, "customername");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andCustomernameGreaterThan(String value) {
      addCriterion("CustomerName >", value, "customername");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andCustomernameGreaterThanOrEqualTo(String value) {
      addCriterion("CustomerName >=", value, "customername");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andCustomernameLessThan(String value) {
      addCriterion("CustomerName <", value, "customername");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andCustomernameLessThanOrEqualTo(String value) {
      addCriterion("CustomerName <=", value, "customername");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andCustomernameLike(String value) {
      addCriterion("CustomerName like", value, "customername");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andCustomernameNotLike(String value) {
      addCriterion("CustomerName not like", value, "customername");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andCustomernameIn(List<String> values) {
      addCriterion("CustomerName in", values, "customername");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andCustomernameNotIn(List<String> values) {
      addCriterion("CustomerName not in", values, "customername");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andCustomernameBetween(String value1, String value2) {
      addCriterion("CustomerName between", value1, value2, "customername");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andCustomernameNotBetween(String value1, String value2) {
      addCriterion("CustomerName not between", value1, value2, "customername");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andSaleridIsNull() {
      addCriterion("SalerID is null");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andSaleridIsNotNull() {
      addCriterion("SalerID is not null");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andSaleridEqualTo(Long value) {
      addCriterion("SalerID =", value, "salerid");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andSaleridNotEqualTo(Long value) {
      addCriterion("SalerID <>", value, "salerid");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andSaleridGreaterThan(Long value) {
      addCriterion("SalerID >", value, "salerid");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andSaleridGreaterThanOrEqualTo(Long value) {
      addCriterion("SalerID >=", value, "salerid");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andSaleridLessThan(Long value) {
      addCriterion("SalerID <", value, "salerid");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andSaleridLessThanOrEqualTo(Long value) {
      addCriterion("SalerID <=", value, "salerid");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andSaleridIn(List<Long> values) {
      addCriterion("SalerID in", values, "salerid");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andSaleridNotIn(List<Long> values) {
      addCriterion("SalerID not in", values, "salerid");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andSaleridBetween(Long value1, Long value2) {
      addCriterion("SalerID between", value1, value2, "salerid");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andSaleridNotBetween(Long value1, Long value2) {
      addCriterion("SalerID not between", value1, value2, "salerid");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andBusinesstypeIsNull() {
      addCriterion("BusinessType is null");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andBusinesstypeIsNotNull() {
      addCriterion("BusinessType is not null");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andBusinesstypeEqualTo(String value) {
      addCriterion("BusinessType =", value, "businesstype");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andBusinesstypeNotEqualTo(String value) {
      addCriterion("BusinessType <>", value, "businesstype");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andBusinesstypeGreaterThan(String value) {
      addCriterion("BusinessType >", value, "businesstype");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andBusinesstypeGreaterThanOrEqualTo(String value) {
      addCriterion("BusinessType >=", value, "businesstype");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andBusinesstypeLessThan(String value) {
      addCriterion("BusinessType <", value, "businesstype");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andBusinesstypeLessThanOrEqualTo(String value) {
      addCriterion("BusinessType <=", value, "businesstype");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andBusinesstypeLike(String value) {
      addCriterion("BusinessType like", value, "businesstype");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andBusinesstypeNotLike(String value) {
      addCriterion("BusinessType not like", value, "businesstype");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andBusinesstypeIn(List<String> values) {
      addCriterion("BusinessType in", values, "businesstype");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andBusinesstypeNotIn(List<String> values) {
      addCriterion("BusinessType not in", values, "businesstype");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andBusinesstypeBetween(String value1, String value2) {
      addCriterion("BusinessType between", value1, value2, "businesstype");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andBusinesstypeNotBetween(String value1, String value2) {
      addCriterion("BusinessType not between", value1, value2, "businesstype");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andAmountIsNull() {
      addCriterion("Amount is null");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andAmountIsNotNull() {
      addCriterion("Amount is not null");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andAmountEqualTo(BigDecimal value) {
      addCriterion("Amount =", value, "amount");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andAmountNotEqualTo(BigDecimal value) {
      addCriterion("Amount <>", value, "amount");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andAmountGreaterThan(BigDecimal value) {
      addCriterion("Amount >", value, "amount");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andAmountGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("Amount >=", value, "amount");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andAmountLessThan(BigDecimal value) {
      addCriterion("Amount <", value, "amount");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andAmountLessThanOrEqualTo(BigDecimal value) {
      addCriterion("Amount <=", value, "amount");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andAmountIn(List<BigDecimal> values) {
      addCriterion("Amount in", values, "amount");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andAmountNotIn(List<BigDecimal> values) {
      addCriterion("Amount not in", values, "amount");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andAmountBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("Amount between", value1, value2, "amount");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andAmountNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("Amount not between", value1, value2, "amount");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andFeeIsNull() {
      addCriterion("Fee is null");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andFeeIsNotNull() {
      addCriterion("Fee is not null");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andFeeEqualTo(BigDecimal value) {
      addCriterion("Fee =", value, "fee");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andFeeNotEqualTo(BigDecimal value) {
      addCriterion("Fee <>", value, "fee");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andFeeGreaterThan(BigDecimal value) {
      addCriterion("Fee >", value, "fee");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andFeeGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("Fee >=", value, "fee");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andFeeLessThan(BigDecimal value) {
      addCriterion("Fee <", value, "fee");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andFeeLessThanOrEqualTo(BigDecimal value) {
      addCriterion("Fee <=", value, "fee");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andFeeIn(List<BigDecimal> values) {
      addCriterion("Fee in", values, "fee");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andFeeNotIn(List<BigDecimal> values) {
      addCriterion("Fee not in", values, "fee");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andFeeBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("Fee between", value1, value2, "fee");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andFeeNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("Fee not between", value1, value2, "fee");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andBonusamountIsNull() {
      addCriterion("bonusamount is null");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andBonusamountIsNotNull() {
      addCriterion("bonusamount is not null");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andBonusamountEqualTo(BigDecimal value) {
      addCriterion("bonusamount =", value, "bonusamount");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andBonusamountNotEqualTo(BigDecimal value) {
      addCriterion("bonusamount <>", value, "bonusamount");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andBonusamountGreaterThan(BigDecimal value) {
      addCriterion("bonusamount >", value, "bonusamount");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andBonusamountGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("bonusamount >=", value, "bonusamount");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andBonusamountLessThan(BigDecimal value) {
      addCriterion("bonusamount <", value, "bonusamount");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andBonusamountLessThanOrEqualTo(BigDecimal value) {
      addCriterion("bonusamount <=", value, "bonusamount");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andBonusamountIn(List<BigDecimal> values) {
      addCriterion("bonusamount in", values, "bonusamount");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andBonusamountNotIn(List<BigDecimal> values) {
      addCriterion("bonusamount not in", values, "bonusamount");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andBonusamountBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("bonusamount between", value1, value2, "bonusamount");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andBonusamountNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("bonusamount not between", value1, value2, "bonusamount");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andBonustypeIsNull() {
      addCriterion("bonustype is null");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andBonustypeIsNotNull() {
      addCriterion("bonustype is not null");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andBonustypeEqualTo(Integer value) {
      addCriterion("bonustype =", value, "bonustype");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andBonustypeNotEqualTo(Integer value) {
      addCriterion("bonustype <>", value, "bonustype");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andBonustypeGreaterThan(Integer value) {
      addCriterion("bonustype >", value, "bonustype");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andBonustypeGreaterThanOrEqualTo(Integer value) {
      addCriterion("bonustype >=", value, "bonustype");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andBonustypeLessThan(Integer value) {
      addCriterion("bonustype <", value, "bonustype");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andBonustypeLessThanOrEqualTo(Integer value) {
      addCriterion("bonustype <=", value, "bonustype");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andBonustypeIn(List<Integer> values) {
      addCriterion("bonustype in", values, "bonustype");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andBonustypeNotIn(List<Integer> values) {
      addCriterion("bonustype not in", values, "bonustype");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andBonustypeBetween(Integer value1, Integer value2) {
      addCriterion("bonustype between", value1, value2, "bonustype");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andBonustypeNotBetween(Integer value1, Integer value2) {
      addCriterion("bonustype not between", value1, value2, "bonustype");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andInvesttermIsNull() {
      addCriterion("InvestTerm is null");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andInvesttermIsNotNull() {
      addCriterion("InvestTerm is not null");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andInvesttermEqualTo(Integer value) {
      addCriterion("InvestTerm =", value, "investterm");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andInvesttermNotEqualTo(Integer value) {
      addCriterion("InvestTerm <>", value, "investterm");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andInvesttermGreaterThan(Integer value) {
      addCriterion("InvestTerm >", value, "investterm");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andInvesttermGreaterThanOrEqualTo(Integer value) {
      addCriterion("InvestTerm >=", value, "investterm");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andInvesttermLessThan(Integer value) {
      addCriterion("InvestTerm <", value, "investterm");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andInvesttermLessThanOrEqualTo(Integer value) {
      addCriterion("InvestTerm <=", value, "investterm");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andInvesttermIn(List<Integer> values) {
      addCriterion("InvestTerm in", values, "investterm");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andInvesttermNotIn(List<Integer> values) {
      addCriterion("InvestTerm not in", values, "investterm");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andInvesttermBetween(Integer value1, Integer value2) {
      addCriterion("InvestTerm between", value1, value2, "investterm");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andInvesttermNotBetween(Integer value1, Integer value2) {
      addCriterion("InvestTerm not between", value1, value2, "investterm");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andTermtypeIsNull() {
      addCriterion("TermType is null");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andTermtypeIsNotNull() {
      addCriterion("TermType is not null");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andTermtypeEqualTo(String value) {
      addCriterion("TermType =", value, "termtype");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andTermtypeNotEqualTo(String value) {
      addCriterion("TermType <>", value, "termtype");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andTermtypeGreaterThan(String value) {
      addCriterion("TermType >", value, "termtype");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andTermtypeGreaterThanOrEqualTo(String value) {
      addCriterion("TermType >=", value, "termtype");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andTermtypeLessThan(String value) {
      addCriterion("TermType <", value, "termtype");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andTermtypeLessThanOrEqualTo(String value) {
      addCriterion("TermType <=", value, "termtype");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andTermtypeLike(String value) {
      addCriterion("TermType like", value, "termtype");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andTermtypeNotLike(String value) {
      addCriterion("TermType not like", value, "termtype");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andTermtypeIn(List<String> values) {
      addCriterion("TermType in", values, "termtype");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andTermtypeNotIn(List<String> values) {
      addCriterion("TermType not in", values, "termtype");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andTermtypeBetween(String value1, String value2) {
      addCriterion("TermType between", value1, value2, "termtype");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andTermtypeNotBetween(String value1, String value2) {
      addCriterion("TermType not between", value1, value2, "termtype");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andChannelcodeIsNull() {
      addCriterion("ChannelCode is null");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andChannelcodeIsNotNull() {
      addCriterion("ChannelCode is not null");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andChannelcodeEqualTo(String value) {
      addCriterion("ChannelCode =", value, "channelcode");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andChannelcodeNotEqualTo(String value) {
      addCriterion("ChannelCode <>", value, "channelcode");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andChannelcodeGreaterThan(String value) {
      addCriterion("ChannelCode >", value, "channelcode");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andChannelcodeGreaterThanOrEqualTo(String value) {
      addCriterion("ChannelCode >=", value, "channelcode");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andChannelcodeLessThan(String value) {
      addCriterion("ChannelCode <", value, "channelcode");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andChannelcodeLessThanOrEqualTo(String value) {
      addCriterion("ChannelCode <=", value, "channelcode");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andChannelcodeLike(String value) {
      addCriterion("ChannelCode like", value, "channelcode");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andChannelcodeNotLike(String value) {
      addCriterion("ChannelCode not like", value, "channelcode");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andChannelcodeIn(List<String> values) {
      addCriterion("ChannelCode in", values, "channelcode");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andChannelcodeNotIn(List<String> values) {
      addCriterion("ChannelCode not in", values, "channelcode");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andChannelcodeBetween(String value1, String value2) {
      addCriterion("ChannelCode between", value1, value2, "channelcode");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andChannelcodeNotBetween(String value1, String value2) {
      addCriterion("ChannelCode not between", value1, value2, "channelcode");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andExptincomeIsNull() {
      addCriterion("exptIncome is null");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andExptincomeIsNotNull() {
      addCriterion("exptIncome is not null");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andExptincomeEqualTo(BigDecimal value) {
      addCriterion("exptIncome =", value, "exptincome");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andExptincomeNotEqualTo(BigDecimal value) {
      addCriterion("exptIncome <>", value, "exptincome");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andExptincomeGreaterThan(BigDecimal value) {
      addCriterion("exptIncome >", value, "exptincome");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andExptincomeGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("exptIncome >=", value, "exptincome");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andExptincomeLessThan(BigDecimal value) {
      addCriterion("exptIncome <", value, "exptincome");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andExptincomeLessThanOrEqualTo(BigDecimal value) {
      addCriterion("exptIncome <=", value, "exptincome");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andExptincomeIn(List<BigDecimal> values) {
      addCriterion("exptIncome in", values, "exptincome");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andExptincomeNotIn(List<BigDecimal> values) {
      addCriterion("exptIncome not in", values, "exptincome");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andExptincomeBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("exptIncome between", value1, value2, "exptincome");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andExptincomeNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("exptIncome not between", value1, value2, "exptincome");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andTransnameIsNull() {
      addCriterion("transname is null");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andTransnameIsNotNull() {
      addCriterion("transname is not null");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andTransnameEqualTo(String value) {
      addCriterion("transname =", value, "transname");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andTransnameNotEqualTo(String value) {
      addCriterion("transname <>", value, "transname");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andTransnameGreaterThan(String value) {
      addCriterion("transname >", value, "transname");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andTransnameGreaterThanOrEqualTo(String value) {
      addCriterion("transname >=", value, "transname");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andTransnameLessThan(String value) {
      addCriterion("transname <", value, "transname");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andTransnameLessThanOrEqualTo(String value) {
      addCriterion("transname <=", value, "transname");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andTransnameLike(String value) {
      addCriterion("transname like", value, "transname");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andTransnameNotLike(String value) {
      addCriterion("transname not like", value, "transname");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andTransnameIn(List<String> values) {
      addCriterion("transname in", values, "transname");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andTransnameNotIn(List<String> values) {
      addCriterion("transname not in", values, "transname");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andTransnameBetween(String value1, String value2) {
      addCriterion("transname between", value1, value2, "transname");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andTransnameNotBetween(String value1, String value2) {
      addCriterion("transname not between", value1, value2, "transname");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andTransstatusIsNull() {
      addCriterion("TransStatus is null");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andTransstatusIsNotNull() {
      addCriterion("TransStatus is not null");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andTransstatusEqualTo(Integer value) {
      addCriterion("TransStatus =", value, "transstatus");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andTransstatusNotEqualTo(Integer value) {
      addCriterion("TransStatus <>", value, "transstatus");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andTransstatusGreaterThan(Integer value) {
      addCriterion("TransStatus >", value, "transstatus");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andTransstatusGreaterThanOrEqualTo(Integer value) {
      addCriterion("TransStatus >=", value, "transstatus");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andTransstatusLessThan(Integer value) {
      addCriterion("TransStatus <", value, "transstatus");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andTransstatusLessThanOrEqualTo(Integer value) {
      addCriterion("TransStatus <=", value, "transstatus");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andTransstatusIn(List<Integer> values) {
      addCriterion("TransStatus in", values, "transstatus");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andTransstatusNotIn(List<Integer> values) {
      addCriterion("TransStatus not in", values, "transstatus");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andTransstatusBetween(Integer value1, Integer value2) {
      addCriterion("TransStatus between", value1, value2, "transstatus");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andTransstatusNotBetween(Integer value1, Integer value2) {
      addCriterion("TransStatus not between", value1, value2, "transstatus");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andApprostatusIsNull() {
      addCriterion("ApproStatus is null");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andApprostatusIsNotNull() {
      addCriterion("ApproStatus is not null");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andApprostatusEqualTo(Integer value) {
      addCriterion("ApproStatus =", value, "approstatus");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andApprostatusNotEqualTo(Integer value) {
      addCriterion("ApproStatus <>", value, "approstatus");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andApprostatusGreaterThan(Integer value) {
      addCriterion("ApproStatus >", value, "approstatus");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andApprostatusGreaterThanOrEqualTo(Integer value) {
      addCriterion("ApproStatus >=", value, "approstatus");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andApprostatusLessThan(Integer value) {
      addCriterion("ApproStatus <", value, "approstatus");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andApprostatusLessThanOrEqualTo(Integer value) {
      addCriterion("ApproStatus <=", value, "approstatus");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andApprostatusIn(List<Integer> values) {
      addCriterion("ApproStatus in", values, "approstatus");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andApprostatusNotIn(List<Integer> values) {
      addCriterion("ApproStatus not in", values, "approstatus");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andApprostatusBetween(Integer value1, Integer value2) {
      addCriterion("ApproStatus between", value1, value2, "approstatus");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andApprostatusNotBetween(Integer value1, Integer value2) {
      addCriterion("ApproStatus not between", value1, value2, "approstatus");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andOrderstatusIsNull() {
      addCriterion("OrderStatus is null");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andOrderstatusIsNotNull() {
      addCriterion("OrderStatus is not null");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andOrderstatusEqualTo(Integer value) {
      addCriterion("OrderStatus =", value, "orderstatus");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andOrderstatusNotEqualTo(Integer value) {
      addCriterion("OrderStatus <>", value, "orderstatus");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andOrderstatusGreaterThan(Integer value) {
      addCriterion("OrderStatus >", value, "orderstatus");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andOrderstatusGreaterThanOrEqualTo(Integer value) {
      addCriterion("OrderStatus >=", value, "orderstatus");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andOrderstatusLessThan(Integer value) {
      addCriterion("OrderStatus <", value, "orderstatus");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andOrderstatusLessThanOrEqualTo(Integer value) {
      addCriterion("OrderStatus <=", value, "orderstatus");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andOrderstatusIn(List<Integer> values) {
      addCriterion("OrderStatus in", values, "orderstatus");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andOrderstatusNotIn(List<Integer> values) {
      addCriterion("OrderStatus not in", values, "orderstatus");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andOrderstatusBetween(Integer value1, Integer value2) {
      addCriterion("OrderStatus between", value1, value2, "orderstatus");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andOrderstatusNotBetween(Integer value1, Integer value2) {
      addCriterion("OrderStatus not between", value1, value2, "orderstatus");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andOrderstatusdescIsNull() {
      addCriterion("OrderStatusDesc is null");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andOrderstatusdescIsNotNull() {
      addCriterion("OrderStatusDesc is not null");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andOrderstatusdescEqualTo(String value) {
      addCriterion("OrderStatusDesc =", value, "orderstatusdesc");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andOrderstatusdescNotEqualTo(String value) {
      addCriterion("OrderStatusDesc <>", value, "orderstatusdesc");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andOrderstatusdescGreaterThan(String value) {
      addCriterion("OrderStatusDesc >", value, "orderstatusdesc");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andOrderstatusdescGreaterThanOrEqualTo(String value) {
      addCriterion("OrderStatusDesc >=", value, "orderstatusdesc");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andOrderstatusdescLessThan(String value) {
      addCriterion("OrderStatusDesc <", value, "orderstatusdesc");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andOrderstatusdescLessThanOrEqualTo(String value) {
      addCriterion("OrderStatusDesc <=", value, "orderstatusdesc");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andOrderstatusdescLike(String value) {
      addCriterion("OrderStatusDesc like", value, "orderstatusdesc");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andOrderstatusdescNotLike(String value) {
      addCriterion("OrderStatusDesc not like", value, "orderstatusdesc");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andOrderstatusdescIn(List<String> values) {
      addCriterion("OrderStatusDesc in", values, "orderstatusdesc");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andOrderstatusdescNotIn(List<String> values) {
      addCriterion("OrderStatusDesc not in", values, "orderstatusdesc");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andOrderstatusdescBetween(String value1, String value2) {
      addCriterion("OrderStatusDesc between", value1, value2, "orderstatusdesc");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andOrderstatusdescNotBetween(String value1, String value2) {
      addCriterion("OrderStatusDesc not between", value1, value2, "orderstatusdesc");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andOrderdateIsNull() {
      addCriterion("OrderDate is null");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andOrderdateIsNotNull() {
      addCriterion("OrderDate is not null");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andOrderdateEqualTo(Date value) {
      addCriterion("OrderDate =", value, "orderdate");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andOrderdateNotEqualTo(Date value) {
      addCriterion("OrderDate <>", value, "orderdate");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andOrderdateGreaterThan(Date value) {
      addCriterion("OrderDate >", value, "orderdate");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andOrderdateGreaterThanOrEqualTo(Date value) {
      addCriterion("OrderDate >=", value, "orderdate");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andOrderdateLessThan(Date value) {
      addCriterion("OrderDate <", value, "orderdate");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andOrderdateLessThanOrEqualTo(Date value) {
      addCriterion("OrderDate <=", value, "orderdate");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andOrderdateIn(List<Date> values) {
      addCriterion("OrderDate in", values, "orderdate");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andOrderdateNotIn(List<Date> values) {
      addCriterion("OrderDate not in", values, "orderdate");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andOrderdateBetween(Date value1, Date value2) {
      addCriterion("OrderDate between", value1, value2, "orderdate");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andOrderdateNotBetween(Date value1, Date value2) {
      addCriterion("OrderDate not between", value1, value2, "orderdate");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andOpdateIsNull() {
      addCriterion("Opdate is null");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andOpdateIsNotNull() {
      addCriterion("Opdate is not null");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andOpdateEqualTo(Date value) {
      addCriterion("Opdate =", value, "opdate");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andOpdateNotEqualTo(Date value) {
      addCriterion("Opdate <>", value, "opdate");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andOpdateGreaterThan(Date value) {
      addCriterion("Opdate >", value, "opdate");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andOpdateGreaterThanOrEqualTo(Date value) {
      addCriterion("Opdate >=", value, "opdate");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andOpdateLessThan(Date value) {
      addCriterion("Opdate <", value, "opdate");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andOpdateLessThanOrEqualTo(Date value) {
      addCriterion("Opdate <=", value, "opdate");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andOpdateIn(List<Date> values) {
      addCriterion("Opdate in", values, "opdate");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andOpdateNotIn(List<Date> values) {
      addCriterion("Opdate not in", values, "opdate");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andOpdateBetween(Date value1, Date value2) {
      addCriterion("Opdate between", value1, value2, "opdate");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andOpdateNotBetween(Date value1, Date value2) {
      addCriterion("Opdate not between", value1, value2, "opdate");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andRemarkIsNull() {
      addCriterion("Remark is null");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andRemarkIsNotNull() {
      addCriterion("Remark is not null");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andRemarkEqualTo(String value) {
      addCriterion("Remark =", value, "remark");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andRemarkNotEqualTo(String value) {
      addCriterion("Remark <>", value, "remark");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andRemarkGreaterThan(String value) {
      addCriterion("Remark >", value, "remark");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andRemarkGreaterThanOrEqualTo(String value) {
      addCriterion("Remark >=", value, "remark");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andRemarkLessThan(String value) {
      addCriterion("Remark <", value, "remark");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andRemarkLessThanOrEqualTo(String value) {
      addCriterion("Remark <=", value, "remark");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andRemarkLike(String value) {
      addCriterion("Remark like", value, "remark");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andRemarkNotLike(String value) {
      addCriterion("Remark not like", value, "remark");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andRemarkIn(List<String> values) {
      addCriterion("Remark in", values, "remark");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andRemarkNotIn(List<String> values) {
      addCriterion("Remark not in", values, "remark");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andRemarkBetween(String value1, String value2) {
      addCriterion("Remark between", value1, value2, "remark");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andRemarkNotBetween(String value1, String value2) {
      addCriterion("Remark not between", value1, value2, "remark");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andExpiredateIsNull() {
      addCriterion("expiredate is null");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andExpiredateIsNotNull() {
      addCriterion("expiredate is not null");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andExpiredateEqualTo(Date value) {
      addCriterion("expiredate =", value, "expiredate");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andExpiredateNotEqualTo(Date value) {
      addCriterion("expiredate <>", value, "expiredate");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andExpiredateGreaterThan(Date value) {
      addCriterion("expiredate >", value, "expiredate");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andExpiredateGreaterThanOrEqualTo(Date value) {
      addCriterion("expiredate >=", value, "expiredate");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andExpiredateLessThan(Date value) {
      addCriterion("expiredate <", value, "expiredate");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andExpiredateLessThanOrEqualTo(Date value) {
      addCriterion("expiredate <=", value, "expiredate");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andExpiredateIn(List<Date> values) {
      addCriterion("expiredate in", values, "expiredate");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andExpiredateNotIn(List<Date> values) {
      addCriterion("expiredate not in", values, "expiredate");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andExpiredateBetween(Date value1, Date value2) {
      addCriterion("expiredate between", value1, value2, "expiredate");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andExpiredateNotBetween(Date value1, Date value2) {
      addCriterion("expiredate not between", value1, value2, "expiredate");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andIfsumIsNull() {
      addCriterion("ifsum is null");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andIfsumIsNotNull() {
      addCriterion("ifsum is not null");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andIfsumEqualTo(Integer value) {
      addCriterion("ifsum =", value, "ifsum");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andIfsumNotEqualTo(Integer value) {
      addCriterion("ifsum <>", value, "ifsum");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andIfsumGreaterThan(Integer value) {
      addCriterion("ifsum >", value, "ifsum");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andIfsumGreaterThanOrEqualTo(Integer value) {
      addCriterion("ifsum >=", value, "ifsum");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andIfsumLessThan(Integer value) {
      addCriterion("ifsum <", value, "ifsum");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andIfsumLessThanOrEqualTo(Integer value) {
      addCriterion("ifsum <=", value, "ifsum");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andIfsumIn(List<Integer> values) {
      addCriterion("ifsum in", values, "ifsum");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andIfsumNotIn(List<Integer> values) {
      addCriterion("ifsum not in", values, "ifsum");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andIfsumBetween(Integer value1, Integer value2) {
      addCriterion("ifsum between", value1, value2, "ifsum");
      return ((InvestorderhistoryExample.Criteria)this);
    }

    public InvestorderhistoryExample.Criteria andIfsumNotBetween(Integer value1, Integer value2) {
      addCriterion("ifsum not between", value1, value2, "ifsum");
      return ((InvestorderhistoryExample.Criteria)this);
    }
  }
}