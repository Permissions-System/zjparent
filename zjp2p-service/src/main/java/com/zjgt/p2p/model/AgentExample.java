package com.zjgt.p2p.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class AgentExample
{
  protected String orderByClause;
  protected boolean distinct;
  protected List<Criteria> oredCriteria;

  public AgentExample()
  {
    this.oredCriteria = new ArrayList();
  }

  public void setOrderByClause(String orderByClause) {
    this.orderByClause = orderByClause;
  }

  public String getOrderByClause() {
    return this.orderByClause;
  }

  public void setDistinct(boolean distinct) {
    this.distinct = distinct;
  }

  public boolean isDistinct() {
    return this.distinct;
  }

  public List<Criteria> getOredCriteria() {
    return this.oredCriteria;
  }

  public void or(Criteria criteria) {
    this.oredCriteria.add(criteria);
  }

  public Criteria or() {
    Criteria criteria = createCriteriaInternal();
    this.oredCriteria.add(criteria);
    return criteria;
  }

  public Criteria createCriteria() {
    Criteria criteria = createCriteriaInternal();
    if (this.oredCriteria.size() == 0) {
      this.oredCriteria.add(criteria);
    }
    return criteria;
  }

  protected Criteria createCriteriaInternal() {
    Criteria criteria = new Criteria();
    return criteria;
  }

  public void clear() {
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

  public static class Criteria extends AgentExample.GeneratedCriteria
  {
  }

  protected static abstract class GeneratedCriteria
  {
    protected List<AgentExample.Criterion> criteria;

    protected GeneratedCriteria()
    {
      this.criteria = new ArrayList();
    }

    public boolean isValid() {
      return (this.criteria.size() > 0);
    }

    public List<AgentExample.Criterion> getAllCriteria() {
      return this.criteria;
    }

    public List<AgentExample.Criterion> getCriteria() {
      return this.criteria;
    }

    protected void addCriterion(String condition) {
      if (condition == null) {
        throw new RuntimeException("Value for condition cannot be null");
      }
      this.criteria.add(new AgentExample.Criterion(condition));
    }

    protected void addCriterion(String condition, Object value, String property) {
      if (value == null) {
        throw new RuntimeException("Value for " + property + " cannot be null");
      }
      this.criteria.add(new AgentExample.Criterion(condition, value));
    }

    protected void addCriterion(String condition, Object value1, Object value2, String property) {
      if ((value1 == null) || (value2 == null)) {
        throw new RuntimeException("Between values for " + property + " cannot be null");
      }
      this.criteria.add(new AgentExample.Criterion(condition, value1, value2));
    }

    public AgentExample.Criteria andIdIsNull() {
      addCriterion("id is null");
      return ((AgentExample.Criteria)this);
    }

    public AgentExample.Criteria andIdIsNotNull() {
      addCriterion("id is not null");
      return ((AgentExample.Criteria)this);
    }

    public AgentExample.Criteria andIdEqualTo(Long value) {
      addCriterion("id =", value, "id");
      return ((AgentExample.Criteria)this);
    }

    public AgentExample.Criteria andIdNotEqualTo(Long value) {
      addCriterion("id <>", value, "id");
      return ((AgentExample.Criteria)this);
    }

    public AgentExample.Criteria andIdGreaterThan(Long value) {
      addCriterion("id >", value, "id");
      return ((AgentExample.Criteria)this);
    }

    public AgentExample.Criteria andIdGreaterThanOrEqualTo(Long value) {
      addCriterion("id >=", value, "id");
      return ((AgentExample.Criteria)this);
    }

    public AgentExample.Criteria andIdLessThan(Long value) {
      addCriterion("id <", value, "id");
      return ((AgentExample.Criteria)this);
    }

    public AgentExample.Criteria andIdLessThanOrEqualTo(Long value) {
      addCriterion("id <=", value, "id");
      return ((AgentExample.Criteria)this);
    }

    public AgentExample.Criteria andIdIn(List<Long> values) {
      addCriterion("id in", values, "id");
      return ((AgentExample.Criteria)this);
    }

    public AgentExample.Criteria andIdNotIn(List<Long> values) {
      addCriterion("id not in", values, "id");
      return ((AgentExample.Criteria)this);
    }

    public AgentExample.Criteria andIdBetween(Long value1, Long value2) {
      addCriterion("id between", value1, value2, "id");
      return ((AgentExample.Criteria)this);
    }

    public AgentExample.Criteria andIdNotBetween(Long value1, Long value2) {
      addCriterion("id not between", value1, value2, "id");
      return ((AgentExample.Criteria)this);
    }

    public AgentExample.Criteria andMemberidIsNull() {
      addCriterion("memberid is null");
      return ((AgentExample.Criteria)this);
    }

    public AgentExample.Criteria andMemberidIsNotNull() {
      addCriterion("memberid is not null");
      return ((AgentExample.Criteria)this);
    }

    public AgentExample.Criteria andMemberidEqualTo(Long value) {
      addCriterion("memberid =", value, "memberid");
      return ((AgentExample.Criteria)this);
    }

    public AgentExample.Criteria andMemberidNotEqualTo(Long value) {
      addCriterion("memberid <>", value, "memberid");
      return ((AgentExample.Criteria)this);
    }

    public AgentExample.Criteria andMemberidGreaterThan(Long value) {
      addCriterion("memberid >", value, "memberid");
      return ((AgentExample.Criteria)this);
    }

    public AgentExample.Criteria andMemberidGreaterThanOrEqualTo(Long value) {
      addCriterion("memberid >=", value, "memberid");
      return ((AgentExample.Criteria)this);
    }

    public AgentExample.Criteria andMemberidLessThan(Long value) {
      addCriterion("memberid <", value, "memberid");
      return ((AgentExample.Criteria)this);
    }

    public AgentExample.Criteria andMemberidLessThanOrEqualTo(Long value) {
      addCriterion("memberid <=", value, "memberid");
      return ((AgentExample.Criteria)this);
    }

    public AgentExample.Criteria andMemberidIn(List<Long> values) {
      addCriterion("memberid in", values, "memberid");
      return ((AgentExample.Criteria)this);
    }

    public AgentExample.Criteria andMemberidNotIn(List<Long> values) {
      addCriterion("memberid not in", values, "memberid");
      return ((AgentExample.Criteria)this);
    }

    public AgentExample.Criteria andMemberidBetween(Long value1, Long value2) {
      addCriterion("memberid between", value1, value2, "memberid");
      return ((AgentExample.Criteria)this);
    }

    public AgentExample.Criteria andMemberidNotBetween(Long value1, Long value2) {
      addCriterion("memberid not between", value1, value2, "memberid");
      return ((AgentExample.Criteria)this);
    }

    public AgentExample.Criteria andLevelIsNull() {
      addCriterion("level is null");
      return ((AgentExample.Criteria)this);
    }

    public AgentExample.Criteria andLevelIsNotNull() {
      addCriterion("level is not null");
      return ((AgentExample.Criteria)this);
    }

    public AgentExample.Criteria andLevelEqualTo(Integer value) {
      addCriterion("level =", value, "level");
      return ((AgentExample.Criteria)this);
    }

    public AgentExample.Criteria andLevelNotEqualTo(Integer value) {
      addCriterion("level <>", value, "level");
      return ((AgentExample.Criteria)this);
    }

    public AgentExample.Criteria andLevelGreaterThan(Integer value) {
      addCriterion("level >", value, "level");
      return ((AgentExample.Criteria)this);
    }

    public AgentExample.Criteria andLevelGreaterThanOrEqualTo(Integer value) {
      addCriterion("level >=", value, "level");
      return ((AgentExample.Criteria)this);
    }

    public AgentExample.Criteria andLevelLessThan(Integer value) {
      addCriterion("level <", value, "level");
      return ((AgentExample.Criteria)this);
    }

    public AgentExample.Criteria andLevelLessThanOrEqualTo(Integer value) {
      addCriterion("level <=", value, "level");
      return ((AgentExample.Criteria)this);
    }

    public AgentExample.Criteria andLevelIn(List<Integer> values) {
      addCriterion("level in", values, "level");
      return ((AgentExample.Criteria)this);
    }

    public AgentExample.Criteria andLevelNotIn(List<Integer> values) {
      addCriterion("level not in", values, "level");
      return ((AgentExample.Criteria)this);
    }

    public AgentExample.Criteria andLevelBetween(Integer value1, Integer value2) {
      addCriterion("level between", value1, value2, "level");
      return ((AgentExample.Criteria)this);
    }

    public AgentExample.Criteria andLevelNotBetween(Integer value1, Integer value2) {
      addCriterion("level not between", value1, value2, "level");
      return ((AgentExample.Criteria)this);
    }

    public AgentExample.Criteria andIscompanyIsNull() {
      addCriterion("iscompany is null");
      return ((AgentExample.Criteria)this);
    }

    public AgentExample.Criteria andIscompanyIsNotNull() {
      addCriterion("iscompany is not null");
      return ((AgentExample.Criteria)this);
    }

    public AgentExample.Criteria andIscompanyEqualTo(Integer value) {
      addCriterion("iscompany =", value, "iscompany");
      return ((AgentExample.Criteria)this);
    }

    public AgentExample.Criteria andIscompanyNotEqualTo(Integer value) {
      addCriterion("iscompany <>", value, "iscompany");
      return ((AgentExample.Criteria)this);
    }

    public AgentExample.Criteria andIscompanyGreaterThan(Integer value) {
      addCriterion("iscompany >", value, "iscompany");
      return ((AgentExample.Criteria)this);
    }

    public AgentExample.Criteria andIscompanyGreaterThanOrEqualTo(Integer value) {
      addCriterion("iscompany >=", value, "iscompany");
      return ((AgentExample.Criteria)this);
    }

    public AgentExample.Criteria andIscompanyLessThan(Integer value) {
      addCriterion("iscompany <", value, "iscompany");
      return ((AgentExample.Criteria)this);
    }

    public AgentExample.Criteria andIscompanyLessThanOrEqualTo(Integer value) {
      addCriterion("iscompany <=", value, "iscompany");
      return ((AgentExample.Criteria)this);
    }

    public AgentExample.Criteria andIscompanyIn(List<Integer> values) {
      addCriterion("iscompany in", values, "iscompany");
      return ((AgentExample.Criteria)this);
    }

    public AgentExample.Criteria andIscompanyNotIn(List<Integer> values) {
      addCriterion("iscompany not in", values, "iscompany");
      return ((AgentExample.Criteria)this);
    }

    public AgentExample.Criteria andIscompanyBetween(Integer value1, Integer value2) {
      addCriterion("iscompany between", value1, value2, "iscompany");
      return ((AgentExample.Criteria)this);
    }

    public AgentExample.Criteria andIscompanyNotBetween(Integer value1, Integer value2) {
      addCriterion("iscompany not between", value1, value2, "iscompany");
      return ((AgentExample.Criteria)this);
    }

    public AgentExample.Criteria andIsMerchantIsNull() {
      addCriterion("isMerchant is null");
      return ((AgentExample.Criteria)this);
    }

    public AgentExample.Criteria andIsMerchantIsNotNull() {
      addCriterion("isMerchant is not null");
      return ((AgentExample.Criteria)this);
    }

    public AgentExample.Criteria andIsMerchantEqualTo(Integer value) {
      addCriterion("isMerchant =", value, "isMerchant");
      return ((AgentExample.Criteria)this);
    }

    public AgentExample.Criteria andIsMerchantNotEqualTo(Integer value) {
      addCriterion("isMerchant <>", value, "isisMerchantmerchant");
      return ((AgentExample.Criteria)this);
    }

    public AgentExample.Criteria andIsMerchantGreaterThan(Integer value) {
      addCriterion("isMerchant >", value, "isMerchant");
      return ((AgentExample.Criteria)this);
    }

    public AgentExample.Criteria andIsMerchantGreaterThanOrEqualTo(Integer value) {
      addCriterion("isMerchant >=", value, "isMerchant");
      return ((AgentExample.Criteria)this);
    }

    public AgentExample.Criteria andIsMerchantLessThan(Integer value) {
      addCriterion("isMerchant <", value, "isMerchant");
      return ((AgentExample.Criteria)this);
    }

    public AgentExample.Criteria andIsMerchantLessThanOrEqualTo(Integer value) {
      addCriterion("isMerchant <=", value, "isMerchant");
      return ((AgentExample.Criteria)this);
    }

    public AgentExample.Criteria andIsMerchantIn(List<Integer> values) {
      addCriterion("isMerchant in", values, "isMerchant");
      return ((AgentExample.Criteria)this);
    }

    public AgentExample.Criteria andIsMerchantNotIn(List<Integer> values) {
      addCriterion("isMerchant not in", values, "isMerchant");
      return ((AgentExample.Criteria)this);
    }

    public AgentExample.Criteria andIsMerchantBetween(Integer value1, Integer value2) {
      addCriterion("isMerchant between", value1, value2, "isMerchant");
      return ((AgentExample.Criteria)this);
    }

    public AgentExample.Criteria andIsMerchantNotBetween(Integer value1, Integer value2) {
      addCriterion("isMerchant not between", value1, value2, "isMerchant");
      return ((AgentExample.Criteria)this);
    }

    public AgentExample.Criteria andCommissionrateIsNull() {
      addCriterion("commissionrate is null");
      return ((AgentExample.Criteria)this);
    }

    public AgentExample.Criteria andCommissionrateIsNotNull() {
      addCriterion("commissionrate is not null");
      return ((AgentExample.Criteria)this);
    }

    public AgentExample.Criteria andCommissionrateEqualTo(BigDecimal value) {
      addCriterion("commissionrate =", value, "commissionrate");
      return ((AgentExample.Criteria)this);
    }

    public AgentExample.Criteria andCommissionrateNotEqualTo(BigDecimal value) {
      addCriterion("commissionrate <>", value, "commissionrate");
      return ((AgentExample.Criteria)this);
    }

    public AgentExample.Criteria andCommissionrateGreaterThan(BigDecimal value) {
      addCriterion("commissionrate >", value, "commissionrate");
      return ((AgentExample.Criteria)this);
    }

    public AgentExample.Criteria andCommissionrateGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("commissionrate >=", value, "commissionrate");
      return ((AgentExample.Criteria)this);
    }

    public AgentExample.Criteria andCommissionrateLessThan(BigDecimal value) {
      addCriterion("commissionrate <", value, "commissionrate");
      return ((AgentExample.Criteria)this);
    }

    public AgentExample.Criteria andCommissionrateLessThanOrEqualTo(BigDecimal value) {
      addCriterion("commissionrate <=", value, "commissionrate");
      return ((AgentExample.Criteria)this);
    }

    public AgentExample.Criteria andCommissionrateIn(List<BigDecimal> values) {
      addCriterion("commissionrate in", values, "commissionrate");
      return ((AgentExample.Criteria)this);
    }

    public AgentExample.Criteria andCommissionrateNotIn(List<BigDecimal> values) {
      addCriterion("commissionrate not in", values, "commissionrate");
      return ((AgentExample.Criteria)this);
    }

    public AgentExample.Criteria andCommissionrateBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("commissionrate between", value1, value2, "commissionrate");
      return ((AgentExample.Criteria)this);
    }

    public AgentExample.Criteria andCommissionrateNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("commissionrate not between", value1, value2, "commissionrate");
      return ((AgentExample.Criteria)this);
    }

    public AgentExample.Criteria andRemarkIsNull() {
      addCriterion("remark is null");
      return ((AgentExample.Criteria)this);
    }

    public AgentExample.Criteria andRemarkIsNotNull() {
      addCriterion("remark is not null");
      return ((AgentExample.Criteria)this);
    }

    public AgentExample.Criteria andRemarkEqualTo(String value) {
      addCriterion("remark =", value, "remark");
      return ((AgentExample.Criteria)this);
    }

    public AgentExample.Criteria andRemarkNotEqualTo(String value) {
      addCriterion("remark <>", value, "remark");
      return ((AgentExample.Criteria)this);
    }

    public AgentExample.Criteria andRemarkGreaterThan(String value) {
      addCriterion("remark >", value, "remark");
      return ((AgentExample.Criteria)this);
    }

    public AgentExample.Criteria andRemarkGreaterThanOrEqualTo(String value) {
      addCriterion("remark >=", value, "remark");
      return ((AgentExample.Criteria)this);
    }

    public AgentExample.Criteria andRemarkLessThan(String value) {
      addCriterion("remark <", value, "remark");
      return ((AgentExample.Criteria)this);
    }

    public AgentExample.Criteria andRemarkLessThanOrEqualTo(String value) {
      addCriterion("remark <=", value, "remark");
      return ((AgentExample.Criteria)this);
    }

    public AgentExample.Criteria andRemarkLike(String value) {
      addCriterion("remark like", value, "remark");
      return ((AgentExample.Criteria)this);
    }

    public AgentExample.Criteria andRemarkNotLike(String value) {
      addCriterion("remark not like", value, "remark");
      return ((AgentExample.Criteria)this);
    }

    public AgentExample.Criteria andRemarkIn(List<String> values) {
      addCriterion("remark in", values, "remark");
      return ((AgentExample.Criteria)this);
    }

    public AgentExample.Criteria andRemarkNotIn(List<String> values) {
      addCriterion("remark not in", values, "remark");
      return ((AgentExample.Criteria)this);
    }

    public AgentExample.Criteria andRemarkBetween(String value1, String value2) {
      addCriterion("remark between", value1, value2, "remark");
      return ((AgentExample.Criteria)this);
    }

    public AgentExample.Criteria andRemarkNotBetween(String value1, String value2) {
      addCriterion("remark not between", value1, value2, "remark");
      return ((AgentExample.Criteria)this);
    }
  }
}