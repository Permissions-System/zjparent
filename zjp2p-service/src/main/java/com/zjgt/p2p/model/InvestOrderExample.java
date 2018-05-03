package com.zjgt.p2p.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springfk.pancloud.daoframework.page.PageExample;

public class InvestOrderExample extends PageExample
{
  protected String orderByClause;
  protected boolean distinct;
  protected Integer startPos;
  protected Integer pageSize;
  protected Integer bidtypeid;
  protected List<Criteria> oredCriteria;

  public InvestOrderExample()
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

  public Integer getStartPos() {
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

  public Integer getBidtypeid() {
    return this.bidtypeid;
  }

  public void setBidtypeid(Integer bidtypeid) {
    this.bidtypeid = bidtypeid;
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

  public static class Criteria extends InvestOrderExample.GeneratedCriteria
  {
  }

  protected static abstract class GeneratedCriteria
  {
    protected List<InvestOrderExample.Criterion> criteria;

    protected GeneratedCriteria()
    {
      this.criteria = new ArrayList();
    }

    public boolean isValid() {
      return (this.criteria.size() > 0);
    }

    public List<InvestOrderExample.Criterion> getAllCriteria() {
      return this.criteria;
    }

    public List<InvestOrderExample.Criterion> getCriteria() {
      return this.criteria;
    }

    protected void addCriterion(String condition) {
      if (condition == null) {
        throw new RuntimeException("Value for condition cannot be null");
      }
      this.criteria.add(new InvestOrderExample.Criterion(condition));
    }

    protected void addCriterion(String condition, Object value, String property) {
      if (value == null) {
        throw new RuntimeException("Value for " + property + " cannot be null");
      }
      this.criteria.add(new InvestOrderExample.Criterion(condition, value));
    }

    protected void addCriterion(String condition, Object value1, Object value2, String property) {
      if ((value1 == null) || (value2 == null)) {
        throw new RuntimeException("Between values for " + property + " cannot be null");
      }
      this.criteria.add(new InvestOrderExample.Criterion(condition, value1, value2));
    }

    public InvestOrderExample.Criteria andIdIsNull() {
      addCriterion("ID is null");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andIdIsNotNull() {
      addCriterion("ID is not null");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andIdEqualTo(Integer value) {
      addCriterion("ID =", value, "id");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andIdNotEqualTo(Integer value) {
      addCriterion("ID <>", value, "id");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andIdGreaterThan(Integer value) {
      addCriterion("ID >", value, "id");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andIdGreaterThanOrEqualTo(Integer value) {
      addCriterion("ID >=", value, "id");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andIdLessThan(Integer value) {
      addCriterion("ID <", value, "id");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andIdLessThanOrEqualTo(Integer value) {
      addCriterion("ID <=", value, "id");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andIdIn(List<Integer> values) {
      addCriterion("ID in", values, "id");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andIdNotIn(List<Integer> values) {
      addCriterion("ID not in", values, "id");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andIdBetween(Integer value1, Integer value2) {
      addCriterion("ID between", value1, value2, "id");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andIdNotBetween(Integer value1, Integer value2) {
      addCriterion("ID not between", value1, value2, "id");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andInvestordercodeIsNull() {
      addCriterion("InvestOrderCode is null");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andInvestordercodeIsNotNull() {
      addCriterion("InvestOrderCode is not null");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andInvestordercodeEqualTo(String value) {
      addCriterion("InvestOrderCode =", value, "investordercode");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andInvestordercodeNotEqualTo(String value) {
      addCriterion("InvestOrderCode <>", value, "investordercode");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andInvestordercodeGreaterThan(String value) {
      addCriterion("InvestOrderCode >", value, "investordercode");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andInvestordercodeGreaterThanOrEqualTo(String value) {
      addCriterion("InvestOrderCode >=", value, "investordercode");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andInvestordercodeLessThan(String value) {
      addCriterion("InvestOrderCode <", value, "investordercode");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andInvestordercodeLessThanOrEqualTo(String value) {
      addCriterion("InvestOrderCode <=", value, "investordercode");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andInvestordercodeLike(String value) {
      addCriterion("InvestOrderCode like", value, "investordercode");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andInvestordercodeNotLike(String value) {
      addCriterion("InvestOrderCode not like", value, "investordercode");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andInvestordercodeIn(List<String> values) {
      addCriterion("InvestOrderCode in", values, "investordercode");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andInvestordercodeNotIn(List<String> values) {
      addCriterion("InvestOrderCode not in", values, "investordercode");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andInvestordercodeBetween(String value1, String value2) {
      addCriterion("InvestOrderCode between", value1, value2, "investordercode");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andInvestordercodeNotBetween(String value1, String value2) {
      addCriterion("InvestOrderCode not between", value1, value2, "investordercode");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andPreordercodeIsNull() {
      addCriterion("preOrderCode is null");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andPreordercodeIsNotNull() {
      addCriterion("preOrderCode is not null");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andPreordercodeEqualTo(String value) {
      addCriterion("preOrderCode =", value, "preordercode");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andPreordercodeNotEqualTo(String value) {
      addCriterion("preOrderCode <>", value, "preordercode");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andPreordercodeGreaterThan(String value) {
      addCriterion("preOrderCode >", value, "preordercode");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andPreordercodeGreaterThanOrEqualTo(String value) {
      addCriterion("preOrderCode >=", value, "preordercode");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andPreordercodeLessThan(String value) {
      addCriterion("preOrderCode <", value, "preordercode");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andPreordercodeLessThanOrEqualTo(String value) {
      addCriterion("preOrderCode <=", value, "preordercode");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andPreordercodeLike(String value) {
      addCriterion("preOrderCode like", value, "preordercode");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andPreordercodeNotLike(String value) {
      addCriterion("preOrderCode not like", value, "preordercode");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andPreordercodeIn(List<String> values) {
      addCriterion("preOrderCode in", values, "preordercode");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andPreordercodeNotIn(List<String> values) {
      addCriterion("preOrderCode not in", values, "preordercode");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andPreordercodeBetween(String value1, String value2) {
      addCriterion("preOrderCode between", value1, value2, "preordercode");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andPreordercodeNotBetween(String value1, String value2) {
      addCriterion("preOrderCode not between", value1, value2, "preordercode");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andBidcodeIsNull() {
      addCriterion("BidCode is null");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andBidcodeIsNotNull() {
      addCriterion("BidCode is not null");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andBidcodeEqualTo(String value) {
      addCriterion("BidCode =", value, "bidcode");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andBidcodeNotEqualTo(String value) {
      addCriterion("BidCode <>", value, "bidcode");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andBidcodeGreaterThan(String value) {
      addCriterion("BidCode >", value, "bidcode");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andBidcodeGreaterThanOrEqualTo(String value) {
      addCriterion("BidCode >=", value, "bidcode");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andBidcodeLessThan(String value) {
      addCriterion("BidCode <", value, "bidcode");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andBidcodeLessThanOrEqualTo(String value) {
      addCriterion("BidCode <=", value, "bidcode");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andBidcodeLike(String value) {
      addCriterion("BidCode like", value, "bidcode");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andBidcodeNotLike(String value) {
      addCriterion("BidCode not like", value, "bidcode");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andBidcodeIn(List<String> values) {
      addCriterion("BidCode in", values, "bidcode");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andBidcodeNotIn(List<String> values) {
      addCriterion("BidCode not in", values, "bidcode");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andBidcodeBetween(String value1, String value2) {
      addCriterion("BidCode between", value1, value2, "bidcode");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andBidcodeNotBetween(String value1, String value2) {
      addCriterion("BidCode not between", value1, value2, "bidcode");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andCreditmatchruleidIsNull() {
      addCriterion("CreditMatchRuleId is null");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andCreditmatchruleidIsNotNull() {
      addCriterion("CreditMatchRuleId is not null");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andCreditmatchruleidEqualTo(Integer value) {
      addCriterion("CreditMatchRuleId =", value, "creditmatchruleid");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andCreditmatchruleidNotEqualTo(Integer value) {
      addCriterion("CreditMatchRuleId <>", value, "creditmatchruleid");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andCreditmatchruleidGreaterThan(Integer value) {
      addCriterion("CreditMatchRuleId >", value, "creditmatchruleid");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andCreditmatchruleidGreaterThanOrEqualTo(Integer value) {
      addCriterion("CreditMatchRuleId >=", value, "creditmatchruleid");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andCreditmatchruleidLessThan(Integer value) {
      addCriterion("CreditMatchRuleId <", value, "creditmatchruleid");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andCreditmatchruleidLessThanOrEqualTo(Integer value) {
      addCriterion("CreditMatchRuleId <=", value, "creditmatchruleid");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andCreditmatchruleidIn(List<Integer> values) {
      addCriterion("CreditMatchRuleId in", values, "creditmatchruleid");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andCreditmatchruleidNotIn(List<Integer> values) {
      addCriterion("CreditMatchRuleId not in", values, "creditmatchruleid");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andCreditmatchruleidBetween(Integer value1, Integer value2) {
      addCriterion("CreditMatchRuleId between", value1, value2, "creditmatchruleid");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andCreditmatchruleidNotBetween(Integer value1, Integer value2) {
      addCriterion("CreditMatchRuleId not between", value1, value2, "creditmatchruleid");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andCustomeridIsNull() {
      addCriterion("CustomerID is null");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andCustomeridIsNotNull() {
      addCriterion("CustomerID is not null");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andCustomeridEqualTo(Long value) {
      addCriterion("CustomerID =", value, "customerid");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andCustomeridNotEqualTo(Long value) {
      addCriterion("CustomerID <>", value, "customerid");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andCustomeridGreaterThan(Long value) {
      addCriterion("CustomerID >", value, "customerid");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andCustomeridGreaterThanOrEqualTo(Long value) {
      addCriterion("CustomerID >=", value, "customerid");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andCustomeridLessThan(Long value) {
      addCriterion("CustomerID <", value, "customerid");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andCustomeridLessThanOrEqualTo(Long value) {
      addCriterion("CustomerID <=", value, "customerid");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andCustomeridIn(List<Long> values) {
      addCriterion("CustomerID in", values, "customerid");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andCustomeridNotIn(List<Long> values) {
      addCriterion("CustomerID not in", values, "customerid");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andCustomeridBetween(Long value1, Long value2) {
      addCriterion("CustomerID between", value1, value2, "customerid");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andCustomeridNotBetween(Long value1, Long value2) {
      addCriterion("CustomerID not between", value1, value2, "customerid");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andCustomernicknameIsNull() {
      addCriterion("CustomerNickName is null");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andCustomernicknameIsNotNull() {
      addCriterion("CustomerNickName is not null");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andCustomernicknameEqualTo(String value) {
      addCriterion("CustomerNickName =", value, "customernickname");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andCustomernicknameNotEqualTo(String value) {
      addCriterion("CustomerNickName <>", value, "customernickname");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andCustomernicknameGreaterThan(String value) {
      addCriterion("CustomerNickName >", value, "customernickname");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andCustomernicknameGreaterThanOrEqualTo(String value) {
      addCriterion("CustomerNickName >=", value, "customernickname");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andCustomernicknameLessThan(String value) {
      addCriterion("CustomerNickName <", value, "customernickname");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andCustomernicknameLessThanOrEqualTo(String value) {
      addCriterion("CustomerNickName <=", value, "customernickname");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andCustomernicknameLike(String value) {
      addCriterion("CustomerNickName like", value, "customernickname");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andCustomernicknameNotLike(String value) {
      addCriterion("CustomerNickName not like", value, "customernickname");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andCustomernicknameIn(List<String> values) {
      addCriterion("CustomerNickName in", values, "customernickname");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andCustomernicknameNotIn(List<String> values) {
      addCriterion("CustomerNickName not in", values, "customernickname");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andCustomernicknameBetween(String value1, String value2) {
      addCriterion("CustomerNickName between", value1, value2, "customernickname");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andCustomernicknameNotBetween(String value1, String value2) {
      addCriterion("CustomerNickName not between", value1, value2, "customernickname");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andCustomernameIsNull() {
      addCriterion("CustomerName is null");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andCustomernameIsNotNull() {
      addCriterion("CustomerName is not null");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andCustomernameEqualTo(String value) {
      addCriterion("CustomerName =", value, "customername");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andCustomernameNotEqualTo(String value) {
      addCriterion("CustomerName <>", value, "customername");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andCustomernameGreaterThan(String value) {
      addCriterion("CustomerName >", value, "customername");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andCustomernameGreaterThanOrEqualTo(String value) {
      addCriterion("CustomerName >=", value, "customername");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andCustomernameLessThan(String value) {
      addCriterion("CustomerName <", value, "customername");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andCustomernameLessThanOrEqualTo(String value) {
      addCriterion("CustomerName <=", value, "customername");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andCustomernameLike(String value) {
      addCriterion("CustomerName like", value, "customername");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andCustomernameNotLike(String value) {
      addCriterion("CustomerName not like", value, "customername");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andCustomernameIn(List<String> values) {
      addCriterion("CustomerName in", values, "customername");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andCustomernameNotIn(List<String> values) {
      addCriterion("CustomerName not in", values, "customername");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andCustomernameBetween(String value1, String value2) {
      addCriterion("CustomerName between", value1, value2, "customername");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andCustomernameNotBetween(String value1, String value2) {
      addCriterion("CustomerName not between", value1, value2, "customername");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andSaleridIsNull() {
      addCriterion("SalerID is null");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andSaleridIsNotNull() {
      addCriterion("SalerID is not null");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andSaleridEqualTo(Long value) {
      addCriterion("SalerID =", value, "salerid");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andSaleridNotEqualTo(Long value) {
      addCriterion("SalerID <>", value, "salerid");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andSaleridGreaterThan(Long value) {
      addCriterion("SalerID >", value, "salerid");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andSaleridGreaterThanOrEqualTo(Long value) {
      addCriterion("SalerID >=", value, "salerid");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andSaleridLessThan(Long value) {
      addCriterion("SalerID <", value, "salerid");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andSaleridLessThanOrEqualTo(Long value) {
      addCriterion("SalerID <=", value, "salerid");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andSaleridIn(List<Long> values) {
      addCriterion("SalerID in", values, "salerid");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andSaleridNotIn(List<Long> values) {
      addCriterion("SalerID not in", values, "salerid");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andSaleridBetween(Long value1, Long value2) {
      addCriterion("SalerID between", value1, value2, "salerid");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andSaleridNotBetween(Long value1, Long value2) {
      addCriterion("SalerID not between", value1, value2, "salerid");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andBusinesstypeIsNull() {
      addCriterion("BusinessType is null");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andBusinesstypeIsNotNull() {
      addCriterion("BusinessType is not null");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andBusinesstypeEqualTo(String value) {
      addCriterion("BusinessType =", value, "businesstype");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andBusinesstypeNotEqualTo(String value) {
      addCriterion("BusinessType <>", value, "businesstype");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andBusinesstypeGreaterThan(String value) {
      addCriterion("BusinessType >", value, "businesstype");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andBusinesstypeGreaterThanOrEqualTo(String value) {
      addCriterion("BusinessType >=", value, "businesstype");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andBusinesstypeLessThan(String value) {
      addCriterion("BusinessType <", value, "businesstype");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andBusinesstypeLessThanOrEqualTo(String value) {
      addCriterion("BusinessType <=", value, "businesstype");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andBusinesstypeLike(String value) {
      addCriterion("BusinessType like", value, "businesstype");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andBusinesstypeNotLike(String value) {
      addCriterion("BusinessType not like", value, "businesstype");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andBusinesstypeIn(List<String> values) {
      addCriterion("BusinessType in", values, "businesstype");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andBusinesstypeNotIn(List<String> values) {
      addCriterion("BusinessType not in", values, "businesstype");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andBusinesstypeBetween(String value1, String value2) {
      addCriterion("BusinessType between", value1, value2, "businesstype");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andBusinesstypeNotBetween(String value1, String value2) {
      addCriterion("BusinessType not between", value1, value2, "businesstype");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andAmountIsNull() {
      addCriterion("Amount is null");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andAmountIsNotNull() {
      addCriterion("Amount is not null");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andAmountEqualTo(BigDecimal value) {
      addCriterion("Amount =", value, "amount");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andAmountNotEqualTo(BigDecimal value) {
      addCriterion("Amount <>", value, "amount");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andAmountGreaterThan(BigDecimal value) {
      addCriterion("Amount >", value, "amount");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andAmountGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("Amount >=", value, "amount");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andAmountLessThan(BigDecimal value) {
      addCriterion("Amount <", value, "amount");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andAmountLessThanOrEqualTo(BigDecimal value) {
      addCriterion("Amount <=", value, "amount");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andAmountIn(List<BigDecimal> values) {
      addCriterion("Amount in", values, "amount");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andAmountNotIn(List<BigDecimal> values) {
      addCriterion("Amount not in", values, "amount");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andAmountBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("Amount between", value1, value2, "amount");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andAmountNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("Amount not between", value1, value2, "amount");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andFeeIsNull() {
      addCriterion("Fee is null");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andFeeIsNotNull() {
      addCriterion("Fee is not null");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andFeeEqualTo(BigDecimal value) {
      addCriterion("Fee =", value, "fee");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andFeeNotEqualTo(BigDecimal value) {
      addCriterion("Fee <>", value, "fee");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andFeeGreaterThan(BigDecimal value) {
      addCriterion("Fee >", value, "fee");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andFeeGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("Fee >=", value, "fee");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andFeeLessThan(BigDecimal value) {
      addCriterion("Fee <", value, "fee");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andFeeLessThanOrEqualTo(BigDecimal value) {
      addCriterion("Fee <=", value, "fee");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andFeeIn(List<BigDecimal> values) {
      addCriterion("Fee in", values, "fee");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andFeeNotIn(List<BigDecimal> values) {
      addCriterion("Fee not in", values, "fee");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andFeeBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("Fee between", value1, value2, "fee");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andFeeNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("Fee not between", value1, value2, "fee");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andBonusamountIsNull() {
      addCriterion("bonusamount is null");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andBonusamountIsNotNull() {
      addCriterion("bonusamount is not null");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andBonusamountEqualTo(BigDecimal value) {
      addCriterion("bonusamount =", value, "bonusamount");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andBonusamountNotEqualTo(BigDecimal value) {
      addCriterion("bonusamount <>", value, "bonusamount");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andBonusamountGreaterThan(BigDecimal value) {
      addCriterion("bonusamount >", value, "bonusamount");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andBonusamountGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("bonusamount >=", value, "bonusamount");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andBonusamountLessThan(BigDecimal value) {
      addCriterion("bonusamount <", value, "bonusamount");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andBonusamountLessThanOrEqualTo(BigDecimal value) {
      addCriterion("bonusamount <=", value, "bonusamount");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andBonusamountIn(List<BigDecimal> values) {
      addCriterion("bonusamount in", values, "bonusamount");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andBonusamountNotIn(List<BigDecimal> values) {
      addCriterion("bonusamount not in", values, "bonusamount");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andBonusamountBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("bonusamount between", value1, value2, "bonusamount");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andBonusamountNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("bonusamount not between", value1, value2, "bonusamount");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andBonustypeIsNull() {
      addCriterion("bonustype is null");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andBonustypeIsNotNull() {
      addCriterion("bonustype is not null");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andBonustypeEqualTo(Integer value) {
      addCriterion("bonustype =", value, "bonustype");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andBonustypeNotEqualTo(Integer value) {
      addCriterion("bonustype <>", value, "bonustype");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andBonustypeGreaterThan(Integer value) {
      addCriterion("bonustype >", value, "bonustype");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andBonustypeGreaterThanOrEqualTo(Integer value) {
      addCriterion("bonustype >=", value, "bonustype");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andBonustypeLessThan(Integer value) {
      addCriterion("bonustype <", value, "bonustype");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andBonustypeLessThanOrEqualTo(Integer value) {
      addCriterion("bonustype <=", value, "bonustype");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andBonustypeIn(List<Integer> values) {
      addCriterion("bonustype in", values, "bonustype");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andBonustypeNotIn(List<Integer> values) {
      addCriterion("bonustype not in", values, "bonustype");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andBonustypeBetween(Integer value1, Integer value2) {
      addCriterion("bonustype between", value1, value2, "bonustype");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andBonustypeNotBetween(Integer value1, Integer value2) {
      addCriterion("bonustype not between", value1, value2, "bonustype");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andInvesttermIsNull() {
      addCriterion("InvestTerm is null");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andInvesttermIsNotNull() {
      addCriterion("InvestTerm is not null");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andInvesttermEqualTo(Integer value) {
      addCriterion("InvestTerm =", value, "investterm");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andInvesttermNotEqualTo(Integer value) {
      addCriterion("InvestTerm <>", value, "investterm");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andInvesttermGreaterThan(Integer value) {
      addCriterion("InvestTerm >", value, "investterm");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andInvesttermGreaterThanOrEqualTo(Integer value) {
      addCriterion("InvestTerm >=", value, "investterm");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andInvesttermLessThan(Integer value) {
      addCriterion("InvestTerm <", value, "investterm");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andInvesttermLessThanOrEqualTo(Integer value) {
      addCriterion("InvestTerm <=", value, "investterm");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andInvesttermIn(List<Integer> values) {
      addCriterion("InvestTerm in", values, "investterm");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andInvesttermNotIn(List<Integer> values) {
      addCriterion("InvestTerm not in", values, "investterm");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andInvesttermBetween(Integer value1, Integer value2) {
      addCriterion("InvestTerm between", value1, value2, "investterm");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andInvesttermNotBetween(Integer value1, Integer value2) {
      addCriterion("InvestTerm not between", value1, value2, "investterm");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andTermtypeIsNull() {
      addCriterion("TermType is null");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andTermtypeIsNotNull() {
      addCriterion("TermType is not null");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andTermtypeEqualTo(String value) {
      addCriterion("TermType =", value, "termtype");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andTermtypeNotEqualTo(String value) {
      addCriterion("TermType <>", value, "termtype");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andTermtypeGreaterThan(String value) {
      addCriterion("TermType >", value, "termtype");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andTermtypeGreaterThanOrEqualTo(String value) {
      addCriterion("TermType >=", value, "termtype");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andTermtypeLessThan(String value) {
      addCriterion("TermType <", value, "termtype");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andTermtypeLessThanOrEqualTo(String value) {
      addCriterion("TermType <=", value, "termtype");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andTermtypeLike(String value) {
      addCriterion("TermType like", value, "termtype");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andTermtypeNotLike(String value) {
      addCriterion("TermType not like", value, "termtype");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andTermtypeIn(List<String> values) {
      addCriterion("TermType in", values, "termtype");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andTermtypeNotIn(List<String> values) {
      addCriterion("TermType not in", values, "termtype");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andTermtypeBetween(String value1, String value2) {
      addCriterion("TermType between", value1, value2, "termtype");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andTermtypeNotBetween(String value1, String value2) {
      addCriterion("TermType not between", value1, value2, "termtype");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andChannelcodeIsNull() {
      addCriterion("ChannelCode is null");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andChannelcodeIsNotNull() {
      addCriterion("ChannelCode is not null");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andChannelcodeEqualTo(String value) {
      addCriterion("ChannelCode =", value, "channelcode");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andChannelcodeNotEqualTo(String value) {
      addCriterion("ChannelCode <>", value, "channelcode");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andChannelcodeGreaterThan(String value) {
      addCriterion("ChannelCode >", value, "channelcode");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andChannelcodeGreaterThanOrEqualTo(String value) {
      addCriterion("ChannelCode >=", value, "channelcode");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andChannelcodeLessThan(String value) {
      addCriterion("ChannelCode <", value, "channelcode");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andChannelcodeLessThanOrEqualTo(String value) {
      addCriterion("ChannelCode <=", value, "channelcode");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andChannelcodeLike(String value) {
      addCriterion("ChannelCode like", value, "channelcode");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andChannelcodeNotLike(String value) {
      addCriterion("ChannelCode not like", value, "channelcode");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andChannelcodeIn(List<String> values) {
      addCriterion("ChannelCode in", values, "channelcode");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andChannelcodeNotIn(List<String> values) {
      addCriterion("ChannelCode not in", values, "channelcode");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andChannelcodeBetween(String value1, String value2) {
      addCriterion("ChannelCode between", value1, value2, "channelcode");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andChannelcodeNotBetween(String value1, String value2) {
      addCriterion("ChannelCode not between", value1, value2, "channelcode");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andExptincomeIsNull() {
      addCriterion("exptIncome is null");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andExptincomeIsNotNull() {
      addCriterion("exptIncome is not null");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andExptincomeEqualTo(BigDecimal value) {
      addCriterion("exptIncome =", value, "exptincome");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andExptincomeNotEqualTo(BigDecimal value) {
      addCriterion("exptIncome <>", value, "exptincome");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andExptincomeGreaterThan(BigDecimal value) {
      addCriterion("exptIncome >", value, "exptincome");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andExptincomeGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("exptIncome >=", value, "exptincome");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andExptincomeLessThan(BigDecimal value) {
      addCriterion("exptIncome <", value, "exptincome");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andExptincomeLessThanOrEqualTo(BigDecimal value) {
      addCriterion("exptIncome <=", value, "exptincome");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andExptincomeIn(List<BigDecimal> values) {
      addCriterion("exptIncome in", values, "exptincome");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andExptincomeNotIn(List<BigDecimal> values) {
      addCriterion("exptIncome not in", values, "exptincome");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andExptincomeBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("exptIncome between", value1, value2, "exptincome");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andExptincomeNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("exptIncome not between", value1, value2, "exptincome");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andTransnameIsNull() {
      addCriterion("transname is null");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andTransnameIsNotNull() {
      addCriterion("transname is not null");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andTransnameEqualTo(String value) {
      addCriterion("transname =", value, "transname");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andTransnameNotEqualTo(String value) {
      addCriterion("transname <>", value, "transname");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andTransnameGreaterThan(String value) {
      addCriterion("transname >", value, "transname");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andTransnameGreaterThanOrEqualTo(String value) {
      addCriterion("transname >=", value, "transname");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andTransnameLessThan(String value) {
      addCriterion("transname <", value, "transname");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andTransnameLessThanOrEqualTo(String value) {
      addCriterion("transname <=", value, "transname");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andTransnameLike(String value) {
      addCriterion("transname like", value, "transname");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andTransnameNotLike(String value) {
      addCriterion("transname not like", value, "transname");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andTransnameIn(List<String> values) {
      addCriterion("transname in", values, "transname");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andTransnameNotIn(List<String> values) {
      addCriterion("transname not in", values, "transname");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andTransnameBetween(String value1, String value2) {
      addCriterion("transname between", value1, value2, "transname");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andTransnameNotBetween(String value1, String value2) {
      addCriterion("transname not between", value1, value2, "transname");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andTransstatusIsNull() {
      addCriterion("TransStatus is null");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andTransstatusIsNotNull() {
      addCriterion("TransStatus is not null");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andTransstatusEqualTo(Integer value) {
      addCriterion("TransStatus =", value, "transstatus");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andTransstatusNotEqualTo(Integer value) {
      addCriterion("TransStatus <>", value, "transstatus");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andTransstatusGreaterThan(Integer value) {
      addCriterion("TransStatus >", value, "transstatus");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andTransstatusGreaterThanOrEqualTo(Integer value) {
      addCriterion("TransStatus >=", value, "transstatus");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andTransstatusLessThan(Integer value) {
      addCriterion("TransStatus <", value, "transstatus");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andTransstatusLessThanOrEqualTo(Integer value) {
      addCriterion("TransStatus <=", value, "transstatus");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andTransstatusIn(List<Integer> values) {
      addCriterion("TransStatus in", values, "transstatus");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andTransstatusNotIn(List<Integer> values) {
      addCriterion("TransStatus not in", values, "transstatus");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andTransstatusBetween(Integer value1, Integer value2) {
      addCriterion("TransStatus between", value1, value2, "transstatus");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andTransstatusNotBetween(Integer value1, Integer value2) {
      addCriterion("TransStatus not between", value1, value2, "transstatus");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andApprostatusIsNull() {
      addCriterion("ApproStatus is null");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andApprostatusIsNotNull() {
      addCriterion("ApproStatus is not null");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andApprostatusEqualTo(Integer value) {
      addCriterion("ApproStatus =", value, "approstatus");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andApprostatusNotEqualTo(Integer value) {
      addCriterion("ApproStatus <>", value, "approstatus");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andApprostatusGreaterThan(Integer value) {
      addCriterion("ApproStatus >", value, "approstatus");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andApprostatusGreaterThanOrEqualTo(Integer value) {
      addCriterion("ApproStatus >=", value, "approstatus");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andApprostatusLessThan(Integer value) {
      addCriterion("ApproStatus <", value, "approstatus");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andApprostatusLessThanOrEqualTo(Integer value) {
      addCriterion("ApproStatus <=", value, "approstatus");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andApprostatusIn(List<Integer> values) {
      addCriterion("ApproStatus in", values, "approstatus");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andApprostatusNotIn(List<Integer> values) {
      addCriterion("ApproStatus not in", values, "approstatus");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andApprostatusBetween(Integer value1, Integer value2) {
      addCriterion("ApproStatus between", value1, value2, "approstatus");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andApprostatusNotBetween(Integer value1, Integer value2) {
      addCriterion("ApproStatus not between", value1, value2, "approstatus");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andOrderstatusIsNull() {
      addCriterion("OrderStatus is null");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andOrderstatusIsNotNull() {
      addCriterion("OrderStatus is not null");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andOrderstatusEqualTo(Integer value) {
      addCriterion("OrderStatus =", value, "orderstatus");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andOrderstatusNotEqualTo(Integer value) {
      addCriterion("OrderStatus <>", value, "orderstatus");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andOrderstatusGreaterThan(Integer value) {
      addCriterion("OrderStatus >", value, "orderstatus");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andOrderstatusGreaterThanOrEqualTo(Integer value) {
      addCriterion("OrderStatus >=", value, "orderstatus");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andOrderstatusLessThan(Integer value) {
      addCriterion("OrderStatus <", value, "orderstatus");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andOrderstatusLessThanOrEqualTo(Integer value) {
      addCriterion("OrderStatus <=", value, "orderstatus");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andOrderstatusIn(List<Integer> values) {
      addCriterion("OrderStatus in", values, "orderstatus");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andOrderstatusNotIn(List<Integer> values) {
      addCriterion("OrderStatus not in", values, "orderstatus");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andOrderstatusBetween(Integer value1, Integer value2) {
      addCriterion("OrderStatus between", value1, value2, "orderstatus");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andOrderstatusNotBetween(Integer value1, Integer value2) {
      addCriterion("OrderStatus not between", value1, value2, "orderstatus");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andOrderstatusdescIsNull() {
      addCriterion("OrderStatusDesc is null");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andOrderstatusdescIsNotNull() {
      addCriterion("OrderStatusDesc is not null");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andOrderstatusdescEqualTo(String value) {
      addCriterion("OrderStatusDesc =", value, "orderstatusdesc");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andOrderstatusdescNotEqualTo(String value) {
      addCriterion("OrderStatusDesc <>", value, "orderstatusdesc");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andOrderstatusdescGreaterThan(String value) {
      addCriterion("OrderStatusDesc >", value, "orderstatusdesc");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andOrderstatusdescGreaterThanOrEqualTo(String value) {
      addCriterion("OrderStatusDesc >=", value, "orderstatusdesc");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andOrderstatusdescLessThan(String value) {
      addCriterion("OrderStatusDesc <", value, "orderstatusdesc");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andOrderstatusdescLessThanOrEqualTo(String value) {
      addCriterion("OrderStatusDesc <=", value, "orderstatusdesc");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andOrderstatusdescLike(String value) {
      addCriterion("OrderStatusDesc like", value, "orderstatusdesc");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andOrderstatusdescNotLike(String value) {
      addCriterion("OrderStatusDesc not like", value, "orderstatusdesc");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andOrderstatusdescIn(List<String> values) {
      addCriterion("OrderStatusDesc in", values, "orderstatusdesc");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andOrderstatusdescNotIn(List<String> values) {
      addCriterion("OrderStatusDesc not in", values, "orderstatusdesc");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andOrderstatusdescBetween(String value1, String value2) {
      addCriterion("OrderStatusDesc between", value1, value2, "orderstatusdesc");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andOrderstatusdescNotBetween(String value1, String value2) {
      addCriterion("OrderStatusDesc not between", value1, value2, "orderstatusdesc");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andOrderdateIsNull() {
      addCriterion("OrderDate is null");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andOrderdateIsNotNull() {
      addCriterion("OrderDate is not null");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andOrderdateEqualTo(Date value) {
      addCriterion("OrderDate =", value, "orderdate");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andOrderdateNotEqualTo(Date value) {
      addCriterion("OrderDate <>", value, "orderdate");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andOrderdateGreaterThan(Date value) {
      addCriterion("OrderDate >", value, "orderdate");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andOrderdateGreaterThanOrEqualTo(Date value) {
      addCriterion("OrderDate >=", value, "orderdate");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andOrderdateLessThan(Date value) {
      addCriterion("OrderDate <", value, "orderdate");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andOrderdateLessThanOrEqualTo(Date value) {
      addCriterion("OrderDate <=", value, "orderdate");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andOrderdateIn(List<Date> values) {
      addCriterion("OrderDate in", values, "orderdate");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andOrderdateNotIn(List<Date> values) {
      addCriterion("OrderDate not in", values, "orderdate");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andOrderdateBetween(Date value1, Date value2) {
      addCriterion("OrderDate between", value1, value2, "orderdate");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andOrderdateNotBetween(Date value1, Date value2) {
      addCriterion("OrderDate not between", value1, value2, "orderdate");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andOpdateIsNull() {
      addCriterion("Opdate is null");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andOpdateIsNotNull() {
      addCriterion("Opdate is not null");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andOpdateEqualTo(Date value) {
      addCriterion("Opdate =", value, "opdate");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andOpdateNotEqualTo(Date value) {
      addCriterion("Opdate <>", value, "opdate");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andOpdateGreaterThan(Date value) {
      addCriterion("Opdate >", value, "opdate");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andOpdateGreaterThanOrEqualTo(Date value) {
      addCriterion("Opdate >=", value, "opdate");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andOpdateLessThan(Date value) {
      addCriterion("Opdate <", value, "opdate");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andOpdateLessThanOrEqualTo(Date value) {
      addCriterion("Opdate <=", value, "opdate");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andOpdateIn(List<Date> values) {
      addCriterion("Opdate in", values, "opdate");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andOpdateNotIn(List<Date> values) {
      addCriterion("Opdate not in", values, "opdate");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andOpdateBetween(Date value1, Date value2) {
      addCriterion("Opdate between", value1, value2, "opdate");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andOpdateNotBetween(Date value1, Date value2) {
      addCriterion("Opdate not between", value1, value2, "opdate");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andExpiredateIsNull() {
      addCriterion("expiredate is null");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andExpiredateIsNotNull() {
      addCriterion("expiredate is not null");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andExpiredateEqualTo(Date value) {
      addCriterion("expiredate =", value, "expiredate");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andExpiredateNotEqualTo(Date value) {
      addCriterion("expiredate <>", value, "expiredate");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andExpiredateGreaterThan(Date value) {
      addCriterion("expiredate >", value, "expiredate");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andExpiredateGreaterThanOrEqualTo(Date value) {
      addCriterion("expiredate >=", value, "expiredate");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andExpiredateLessThan(Date value) {
      addCriterion("expiredate <", value, "expiredate");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andExpiredateLessThanOrEqualTo(Date value) {
      addCriterion("expiredate <=", value, "expiredate");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andExpiredateIn(List<Date> values) {
      addCriterion("expiredate in", values, "expiredate");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andExpiredateNotIn(List<Date> values) {
      addCriterion("expiredate not in", values, "expiredate");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andExpiredateBetween(Date value1, Date value2) {
      addCriterion("expiredate between", value1, value2, "expiredate");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andExpiredateNotBetween(Date value1, Date value2) {
      addCriterion("expiredate not between", value1, value2, "expiredate");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andIfsumIsNull() {
      addCriterion("ifsum is null");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andIfsumIsNotNull() {
      addCriterion("ifsum is not null");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andIfsumEqualTo(Integer value) {
      addCriterion("ifsum =", value, "ifsum");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andIfsumNotEqualTo(Integer value) {
      addCriterion("ifsum <>", value, "ifsum");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andIfsumGreaterThan(Integer value) {
      addCriterion("ifsum >", value, "ifsum");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andIfsumGreaterThanOrEqualTo(Integer value) {
      addCriterion("ifsum >=", value, "ifsum");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andIfsumLessThan(Integer value) {
      addCriterion("ifsum <", value, "ifsum");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andIfsumLessThanOrEqualTo(Integer value) {
      addCriterion("ifsum <=", value, "ifsum");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andIfsumIn(List<Integer> values) {
      addCriterion("ifsum in", values, "ifsum");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andIfsumNotIn(List<Integer> values) {
      addCriterion("ifsum not in", values, "ifsum");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andIfsumBetween(Integer value1, Integer value2) {
      addCriterion("ifsum between", value1, value2, "ifsum");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andIfsumNotBetween(Integer value1, Integer value2) {
      addCriterion("ifsum not between", value1, value2, "ifsum");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andRemarkIsNull() {
      addCriterion("Remark is null");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andRemarkIsNotNull() {
      addCriterion("Remark is not null");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andRemarkEqualTo(String value) {
      addCriterion("Remark =", value, "remark");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andRemarkNotEqualTo(String value) {
      addCriterion("Remark <>", value, "remark");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andRemarkGreaterThan(String value) {
      addCriterion("Remark >", value, "remark");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andRemarkGreaterThanOrEqualTo(String value) {
      addCriterion("Remark >=", value, "remark");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andRemarkLessThan(String value) {
      addCriterion("Remark <", value, "remark");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andRemarkLessThanOrEqualTo(String value) {
      addCriterion("Remark <=", value, "remark");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andRemarkLike(String value) {
      addCriterion("Remark like", value, "remark");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andRemarkNotLike(String value) {
      addCriterion("Remark not like", value, "remark");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andRemarkIn(List<String> values) {
      addCriterion("Remark in", values, "remark");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andRemarkNotIn(List<String> values) {
      addCriterion("Remark not in", values, "remark");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andRemarkBetween(String value1, String value2) {
      addCriterion("Remark between", value1, value2, "remark");
      return ((InvestOrderExample.Criteria)this);
    }

    public InvestOrderExample.Criteria andRemarkNotBetween(String value1, String value2) {
      addCriterion("Remark not between", value1, value2, "remark");
      return ((InvestOrderExample.Criteria)this);
    }
  }
}