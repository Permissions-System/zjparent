package com.zjgt.p2p.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MemberProdIncomeExample
{
  protected String orderByClause;
  protected boolean distinct;
  protected List<Criteria> oredCriteria;

  public MemberProdIncomeExample()
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

  public static class Criteria extends MemberProdIncomeExample.GeneratedCriteria
  {
  }

  protected static abstract class GeneratedCriteria
  {
    protected List<MemberProdIncomeExample.Criterion> criteria;

    protected GeneratedCriteria()
    {
      this.criteria = new ArrayList();
    }

    public boolean isValid() {
      return (this.criteria.size() > 0);
    }

    public List<MemberProdIncomeExample.Criterion> getAllCriteria() {
      return this.criteria;
    }

    public List<MemberProdIncomeExample.Criterion> getCriteria() {
      return this.criteria;
    }

    protected void addCriterion(String condition) {
      if (condition == null) {
        throw new RuntimeException("Value for condition cannot be null");
      }
      this.criteria.add(new MemberProdIncomeExample.Criterion(condition));
    }

    protected void addCriterion(String condition, Object value, String property) {
      if (value == null) {
        throw new RuntimeException("Value for " + property + " cannot be null");
      }
      this.criteria.add(new MemberProdIncomeExample.Criterion(condition, value));
    }

    protected void addCriterion(String condition, Object value1, Object value2, String property) {
      if ((value1 == null) || (value2 == null)) {
        throw new RuntimeException("Between values for " + property + " cannot be null");
      }
      this.criteria.add(new MemberProdIncomeExample.Criterion(condition, value1, value2));
    }

    public MemberProdIncomeExample.Criteria andIdIsNull() {
      addCriterion("id is null");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andIdIsNotNull() {
      addCriterion("id is not null");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andIdEqualTo(Long value) {
      addCriterion("id =", value, "id");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andIdNotEqualTo(Long value) {
      addCriterion("id <>", value, "id");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andIdGreaterThan(Long value) {
      addCriterion("id >", value, "id");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andIdGreaterThanOrEqualTo(Long value) {
      addCriterion("id >=", value, "id");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andIdLessThan(Long value) {
      addCriterion("id <", value, "id");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andIdLessThanOrEqualTo(Long value) {
      addCriterion("id <=", value, "id");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andIdIn(List<Long> values) {
      addCriterion("id in", values, "id");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andIdNotIn(List<Long> values) {
      addCriterion("id not in", values, "id");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andIdBetween(Long value1, Long value2) {
      addCriterion("id between", value1, value2, "id");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andIdNotBetween(Long value1, Long value2) {
      addCriterion("id not between", value1, value2, "id");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andMemberidIsNull() {
      addCriterion("memberid is null");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andMemberidIsNotNull() {
      addCriterion("memberid is not null");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andMemberidEqualTo(Long value) {
      addCriterion("memberid =", value, "memberid");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andMemberidNotEqualTo(Long value) {
      addCriterion("memberid <>", value, "memberid");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andMemberidGreaterThan(Long value) {
      addCriterion("memberid >", value, "memberid");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andMemberidGreaterThanOrEqualTo(Long value) {
      addCriterion("memberid >=", value, "memberid");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andMemberidLessThan(Long value) {
      addCriterion("memberid <", value, "memberid");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andMemberidLessThanOrEqualTo(Long value) {
      addCriterion("memberid <=", value, "memberid");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andMemberidIn(List<Long> values) {
      addCriterion("memberid in", values, "memberid");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andMemberidNotIn(List<Long> values) {
      addCriterion("memberid not in", values, "memberid");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andMemberidBetween(Long value1, Long value2) {
      addCriterion("memberid between", value1, value2, "memberid");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andMemberidNotBetween(Long value1, Long value2) {
      addCriterion("memberid not between", value1, value2, "memberid");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andBidtypeidIsNull() {
      addCriterion("bidtypeid is null");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andBidtypeidIsNotNull() {
      addCriterion("bidtypeid is not null");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andBidtypeidEqualTo(Integer value) {
      addCriterion("bidtypeid =", value, "bidtypeid");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andBidtypeidNotEqualTo(Integer value) {
      addCriterion("bidtypeid <>", value, "bidtypeid");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andBidtypeidGreaterThan(Integer value) {
      addCriterion("bidtypeid >", value, "bidtypeid");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andBidtypeidGreaterThanOrEqualTo(Integer value) {
      addCriterion("bidtypeid >=", value, "bidtypeid");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andBidtypeidLessThan(Integer value) {
      addCriterion("bidtypeid <", value, "bidtypeid");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andBidtypeidLessThanOrEqualTo(Integer value) {
      addCriterion("bidtypeid <=", value, "bidtypeid");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andBidtypeidIn(List<Integer> values) {
      addCriterion("bidtypeid in", values, "bidtypeid");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andBidtypeidNotIn(List<Integer> values) {
      addCriterion("bidtypeid not in", values, "bidtypeid");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andBidtypeidBetween(Integer value1, Integer value2) {
      addCriterion("bidtypeid between", value1, value2, "bidtypeid");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andBidtypeidNotBetween(Integer value1, Integer value2) {
      addCriterion("bidtypeid not between", value1, value2, "bidtypeid");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andBidclassnameIsNull() {
      addCriterion("bidclassname is null");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andBidclassnameIsNotNull() {
      addCriterion("bidclassname is not null");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andBidclassnameEqualTo(String value) {
      addCriterion("bidclassname =", value, "bidclassname");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andBidclassnameNotEqualTo(String value) {
      addCriterion("bidclassname <>", value, "bidclassname");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andBidclassnameGreaterThan(String value) {
      addCriterion("bidclassname >", value, "bidclassname");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andBidclassnameGreaterThanOrEqualTo(String value) {
      addCriterion("bidclassname >=", value, "bidclassname");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andBidclassnameLessThan(String value) {
      addCriterion("bidclassname <", value, "bidclassname");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andBidclassnameLessThanOrEqualTo(String value) {
      addCriterion("bidclassname <=", value, "bidclassname");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andBidclassnameLike(String value) {
      addCriterion("bidclassname like", value, "bidclassname");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andBidclassnameNotLike(String value) {
      addCriterion("bidclassname not like", value, "bidclassname");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andBidclassnameIn(List<String> values) {
      addCriterion("bidclassname in", values, "bidclassname");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andBidclassnameNotIn(List<String> values) {
      addCriterion("bidclassname not in", values, "bidclassname");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andBidclassnameBetween(String value1, String value2) {
      addCriterion("bidclassname between", value1, value2, "bidclassname");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andBidclassnameNotBetween(String value1, String value2) {
      addCriterion("bidclassname not between", value1, value2, "bidclassname");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andTotalincomeIsNull() {
      addCriterion("totalIncome is null");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andTotalincomeIsNotNull() {
      addCriterion("totalIncome is not null");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andTotalincomeEqualTo(BigDecimal value) {
      addCriterion("totalIncome =", value, "totalincome");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andTotalincomeNotEqualTo(BigDecimal value) {
      addCriterion("totalIncome <>", value, "totalincome");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andTotalincomeGreaterThan(BigDecimal value) {
      addCriterion("totalIncome >", value, "totalincome");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andTotalincomeGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("totalIncome >=", value, "totalincome");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andTotalincomeLessThan(BigDecimal value) {
      addCriterion("totalIncome <", value, "totalincome");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andTotalincomeLessThanOrEqualTo(BigDecimal value) {
      addCriterion("totalIncome <=", value, "totalincome");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andTotalincomeIn(List<BigDecimal> values) {
      addCriterion("totalIncome in", values, "totalincome");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andTotalincomeNotIn(List<BigDecimal> values) {
      addCriterion("totalIncome not in", values, "totalincome");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andTotalincomeBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("totalIncome between", value1, value2, "totalincome");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andTotalincomeNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("totalIncome not between", value1, value2, "totalincome");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andIncomeIsNull() {
      addCriterion("income is null");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andIncomeIsNotNull() {
      addCriterion("income is not null");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andIncomeEqualTo(BigDecimal value) {
      addCriterion("income =", value, "income");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andIncomeNotEqualTo(BigDecimal value) {
      addCriterion("income <>", value, "income");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andIncomeGreaterThan(BigDecimal value) {
      addCriterion("income >", value, "income");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andIncomeGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("income >=", value, "income");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andIncomeLessThan(BigDecimal value) {
      addCriterion("income <", value, "income");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andIncomeLessThanOrEqualTo(BigDecimal value) {
      addCriterion("income <=", value, "income");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andIncomeIn(List<BigDecimal> values) {
      addCriterion("income in", values, "income");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andIncomeNotIn(List<BigDecimal> values) {
      addCriterion("income not in", values, "income");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andIncomeBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("income between", value1, value2, "income");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andIncomeNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("income not between", value1, value2, "income");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andRecvincomeIsNull() {
      addCriterion("recvincome is null");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andRecvincomeIsNotNull() {
      addCriterion("recvincome is not null");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andRecvincomeEqualTo(BigDecimal value) {
      addCriterion("recvincome =", value, "recvincome");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andRecvincomeNotEqualTo(BigDecimal value) {
      addCriterion("recvincome <>", value, "recvincome");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andRecvincomeGreaterThan(BigDecimal value) {
      addCriterion("recvincome >", value, "recvincome");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andRecvincomeGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("recvincome >=", value, "recvincome");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andRecvincomeLessThan(BigDecimal value) {
      addCriterion("recvincome <", value, "recvincome");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andRecvincomeLessThanOrEqualTo(BigDecimal value) {
      addCriterion("recvincome <=", value, "recvincome");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andRecvincomeIn(List<BigDecimal> values) {
      addCriterion("recvincome in", values, "recvincome");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andRecvincomeNotIn(List<BigDecimal> values) {
      addCriterion("recvincome not in", values, "recvincome");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andRecvincomeBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("recvincome between", value1, value2, "recvincome");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andRecvincomeNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("recvincome not between", value1, value2, "recvincome");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andMembertypeIsNull() {
      addCriterion("memberType is null");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andMembertypeIsNotNull() {
      addCriterion("memberType is not null");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andMembertypeEqualTo(Integer value) {
      addCriterion("memberType =", value, "membertype");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andMembertypeNotEqualTo(Integer value) {
      addCriterion("memberType <>", value, "membertype");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andMembertypeGreaterThan(Integer value) {
      addCriterion("memberType >", value, "membertype");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andMembertypeGreaterThanOrEqualTo(Integer value) {
      addCriterion("memberType >=", value, "membertype");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andMembertypeLessThan(Integer value) {
      addCriterion("memberType <", value, "membertype");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andMembertypeLessThanOrEqualTo(Integer value) {
      addCriterion("memberType <=", value, "membertype");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andMembertypeIn(List<Integer> values) {
      addCriterion("memberType in", values, "membertype");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andMembertypeNotIn(List<Integer> values) {
      addCriterion("memberType not in", values, "membertype");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andMembertypeBetween(Integer value1, Integer value2) {
      addCriterion("memberType between", value1, value2, "membertype");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andMembertypeNotBetween(Integer value1, Integer value2) {
      addCriterion("memberType not between", value1, value2, "membertype");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andModifyDateIsNull() {
      addCriterion("modify_date is null");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andModifyDateIsNotNull() {
      addCriterion("modify_date is not null");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andModifyDateEqualTo(Date value) {
      addCriterion("modify_date =", value, "modifyDate");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andModifyDateNotEqualTo(Date value) {
      addCriterion("modify_date <>", value, "modifyDate");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andModifyDateGreaterThan(Date value) {
      addCriterion("modify_date >", value, "modifyDate");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andModifyDateGreaterThanOrEqualTo(Date value) {
      addCriterion("modify_date >=", value, "modifyDate");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andModifyDateLessThan(Date value) {
      addCriterion("modify_date <", value, "modifyDate");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andModifyDateLessThanOrEqualTo(Date value) {
      addCriterion("modify_date <=", value, "modifyDate");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andModifyDateIn(List<Date> values) {
      addCriterion("modify_date in", values, "modifyDate");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andModifyDateNotIn(List<Date> values) {
      addCriterion("modify_date not in", values, "modifyDate");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andModifyDateBetween(Date value1, Date value2) {
      addCriterion("modify_date between", value1, value2, "modifyDate");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andModifyDateNotBetween(Date value1, Date value2) {
      addCriterion("modify_date not between", value1, value2, "modifyDate");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andCreateDateIsNull() {
      addCriterion("create_date is null");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andCreateDateIsNotNull() {
      addCriterion("create_date is not null");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andCreateDateEqualTo(Date value) {
      addCriterion("create_date =", value, "createDate");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andCreateDateNotEqualTo(Date value) {
      addCriterion("create_date <>", value, "createDate");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andCreateDateGreaterThan(Date value) {
      addCriterion("create_date >", value, "createDate");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
      addCriterion("create_date >=", value, "createDate");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andCreateDateLessThan(Date value) {
      addCriterion("create_date <", value, "createDate");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andCreateDateLessThanOrEqualTo(Date value) {
      addCriterion("create_date <=", value, "createDate");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andCreateDateIn(List<Date> values) {
      addCriterion("create_date in", values, "createDate");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andCreateDateNotIn(List<Date> values) {
      addCriterion("create_date not in", values, "createDate");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andCreateDateBetween(Date value1, Date value2) {
      addCriterion("create_date between", value1, value2, "createDate");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andCreateDateNotBetween(Date value1, Date value2) {
      addCriterion("create_date not between", value1, value2, "createDate");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andFreezeDateIsNull() {
      addCriterion("freeze_date is null");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andFreezeDateIsNotNull() {
      addCriterion("freeze_date is not null");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andFreezeDateEqualTo(Date value) {
      addCriterion("freeze_date =", value, "freezeDate");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andFreezeDateNotEqualTo(Date value) {
      addCriterion("freeze_date <>", value, "freezeDate");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andFreezeDateGreaterThan(Date value) {
      addCriterion("freeze_date >", value, "freezeDate");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andFreezeDateGreaterThanOrEqualTo(Date value) {
      addCriterion("freeze_date >=", value, "freezeDate");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andFreezeDateLessThan(Date value) {
      addCriterion("freeze_date <", value, "freezeDate");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andFreezeDateLessThanOrEqualTo(Date value) {
      addCriterion("freeze_date <=", value, "freezeDate");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andFreezeDateIn(List<Date> values) {
      addCriterion("freeze_date in", values, "freezeDate");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andFreezeDateNotIn(List<Date> values) {
      addCriterion("freeze_date not in", values, "freezeDate");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andFreezeDateBetween(Date value1, Date value2) {
      addCriterion("freeze_date between", value1, value2, "freezeDate");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andFreezeDateNotBetween(Date value1, Date value2) {
      addCriterion("freeze_date not between", value1, value2, "freezeDate");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andUpdateDateIsNull() {
      addCriterion("update_date is null");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andUpdateDateIsNotNull() {
      addCriterion("update_date is not null");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andUpdateDateEqualTo(Date value) {
      addCriterion("update_date =", value, "updateDate");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andUpdateDateNotEqualTo(Date value) {
      addCriterion("update_date <>", value, "updateDate");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andUpdateDateGreaterThan(Date value) {
      addCriterion("update_date >", value, "updateDate");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andUpdateDateGreaterThanOrEqualTo(Date value) {
      addCriterion("update_date >=", value, "updateDate");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andUpdateDateLessThan(Date value) {
      addCriterion("update_date <", value, "updateDate");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andUpdateDateLessThanOrEqualTo(Date value) {
      addCriterion("update_date <=", value, "updateDate");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andUpdateDateIn(List<Date> values) {
      addCriterion("update_date in", values, "updateDate");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andUpdateDateNotIn(List<Date> values) {
      addCriterion("update_date not in", values, "updateDate");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andUpdateDateBetween(Date value1, Date value2) {
      addCriterion("update_date between", value1, value2, "updateDate");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andUpdateDateNotBetween(Date value1, Date value2) {
      addCriterion("update_date not between", value1, value2, "updateDate");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andRemarkIsNull() {
      addCriterion("remark is null");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andRemarkIsNotNull() {
      addCriterion("remark is not null");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andRemarkEqualTo(String value) {
      addCriterion("remark =", value, "remark");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andRemarkNotEqualTo(String value) {
      addCriterion("remark <>", value, "remark");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andRemarkGreaterThan(String value) {
      addCriterion("remark >", value, "remark");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andRemarkGreaterThanOrEqualTo(String value) {
      addCriterion("remark >=", value, "remark");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andRemarkLessThan(String value) {
      addCriterion("remark <", value, "remark");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andRemarkLessThanOrEqualTo(String value) {
      addCriterion("remark <=", value, "remark");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andRemarkLike(String value) {
      addCriterion("remark like", value, "remark");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andRemarkNotLike(String value) {
      addCriterion("remark not like", value, "remark");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andRemarkIn(List<String> values) {
      addCriterion("remark in", values, "remark");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andRemarkNotIn(List<String> values) {
      addCriterion("remark not in", values, "remark");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andRemarkBetween(String value1, String value2) {
      addCriterion("remark between", value1, value2, "remark");
      return ((MemberProdIncomeExample.Criteria)this);
    }

    public MemberProdIncomeExample.Criteria andRemarkNotBetween(String value1, String value2) {
      addCriterion("remark not between", value1, value2, "remark");
      return ((MemberProdIncomeExample.Criteria)this);
    }
  }
}