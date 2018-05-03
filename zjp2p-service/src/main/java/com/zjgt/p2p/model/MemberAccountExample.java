package com.zjgt.p2p.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MemberAccountExample
{
  protected String orderByClause;
  protected boolean distinct;
  protected List<Criteria> oredCriteria;

  public MemberAccountExample()
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

  public static class Criteria extends MemberAccountExample.GeneratedCriteria
  {
  }

  protected static abstract class GeneratedCriteria
  {
    protected List<MemberAccountExample.Criterion> criteria;

    protected GeneratedCriteria()
    {
      this.criteria = new ArrayList();
    }

    public boolean isValid() {
      return (this.criteria.size() > 0);
    }

    public List<MemberAccountExample.Criterion> getAllCriteria() {
      return this.criteria;
    }

    public List<MemberAccountExample.Criterion> getCriteria() {
      return this.criteria;
    }

    protected void addCriterion(String condition) {
      if (condition == null) {
        throw new RuntimeException("Value for condition cannot be null");
      }
      this.criteria.add(new MemberAccountExample.Criterion(condition));
    }

    protected void addCriterion(String condition, Object value, String property) {
      if (value == null) {
        throw new RuntimeException("Value for " + property + " cannot be null");
      }
      this.criteria.add(new MemberAccountExample.Criterion(condition, value));
    }

    protected void addCriterion(String condition, Object value1, Object value2, String property) {
      if ((value1 == null) || (value2 == null)) {
        throw new RuntimeException("Between values for " + property + " cannot be null");
      }
      this.criteria.add(new MemberAccountExample.Criterion(condition, value1, value2));
    }

    public MemberAccountExample.Criteria andIdIsNull() {
      addCriterion("id is null");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andIdIsNotNull() {
      addCriterion("id is not null");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andIdEqualTo(Long value) {
      addCriterion("id =", value, "id");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andIdNotEqualTo(Long value) {
      addCriterion("id <>", value, "id");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andIdGreaterThan(Long value) {
      addCriterion("id >", value, "id");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andIdGreaterThanOrEqualTo(Long value) {
      addCriterion("id >=", value, "id");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andIdLessThan(Long value) {
      addCriterion("id <", value, "id");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andIdLessThanOrEqualTo(Long value) {
      addCriterion("id <=", value, "id");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andIdIn(List<Long> values) {
      addCriterion("id in", values, "id");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andIdNotIn(List<Long> values) {
      addCriterion("id not in", values, "id");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andIdBetween(Long value1, Long value2) {
      addCriterion("id between", value1, value2, "id");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andIdNotBetween(Long value1, Long value2) {
      addCriterion("id not between", value1, value2, "id");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andMemberidIsNull() {
      addCriterion("memberid is null");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andMemberidIsNotNull() {
      addCriterion("memberid is not null");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andMemberidEqualTo(Long value) {
      addCriterion("memberid =", value, "memberid");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andMemberidNotEqualTo(Long value) {
      addCriterion("memberid <>", value, "memberid");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andMemberidGreaterThan(Long value) {
      addCriterion("memberid >", value, "memberid");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andMemberidGreaterThanOrEqualTo(Long value) {
      addCriterion("memberid >=", value, "memberid");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andMemberidLessThan(Long value) {
      addCriterion("memberid <", value, "memberid");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andMemberidLessThanOrEqualTo(Long value) {
      addCriterion("memberid <=", value, "memberid");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andMemberidIn(List<Long> values) {
      addCriterion("memberid in", values, "memberid");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andMemberidNotIn(List<Long> values) {
      addCriterion("memberid not in", values, "memberid");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andMemberidBetween(Long value1, Long value2) {
      addCriterion("memberid between", value1, value2, "memberid");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andMemberidNotBetween(Long value1, Long value2) {
      addCriterion("memberid not between", value1, value2, "memberid");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andAccountIsNull() {
      addCriterion("account is null");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andAccountIsNotNull() {
      addCriterion("account is not null");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andAccountEqualTo(BigDecimal value) {
      addCriterion("account =", value, "account");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andAccountNotEqualTo(BigDecimal value) {
      addCriterion("account <>", value, "account");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andAccountGreaterThan(BigDecimal value) {
      addCriterion("account >", value, "account");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andAccountGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("account >=", value, "account");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andAccountLessThan(BigDecimal value) {
      addCriterion("account <", value, "account");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andAccountLessThanOrEqualTo(BigDecimal value) {
      addCriterion("account <=", value, "account");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andAccountIn(List<BigDecimal> values) {
      addCriterion("account in", values, "account");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andAccountNotIn(List<BigDecimal> values) {
      addCriterion("account not in", values, "account");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andAccountBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("account between", value1, value2, "account");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andAccountNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("account not between", value1, value2, "account");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andBlanceIsNull() {
      addCriterion("blance is null");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andBlanceIsNotNull() {
      addCriterion("blance is not null");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andBlanceEqualTo(BigDecimal value) {
      addCriterion("blance =", value, "blance");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andBlanceNotEqualTo(BigDecimal value) {
      addCriterion("blance <>", value, "blance");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andBlanceGreaterThan(BigDecimal value) {
      addCriterion("blance >", value, "blance");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andBlanceGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("blance >=", value, "blance");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andBlanceLessThan(BigDecimal value) {
      addCriterion("blance <", value, "blance");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andBlanceLessThanOrEqualTo(BigDecimal value) {
      addCriterion("blance <=", value, "blance");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andBlanceIn(List<BigDecimal> values) {
      addCriterion("blance in", values, "blance");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andBlanceNotIn(List<BigDecimal> values) {
      addCriterion("blance not in", values, "blance");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andBlanceBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("blance between", value1, value2, "blance");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andBlanceNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("blance not between", value1, value2, "blance");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andUsedaccountIsNull() {
      addCriterion("usedaccount is null");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andUsedaccountIsNotNull() {
      addCriterion("usedaccount is not null");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andUsedaccountEqualTo(BigDecimal value) {
      addCriterion("usedaccount =", value, "usedaccount");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andUsedaccountNotEqualTo(BigDecimal value) {
      addCriterion("usedaccount <>", value, "usedaccount");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andUsedaccountGreaterThan(BigDecimal value) {
      addCriterion("usedaccount >", value, "usedaccount");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andUsedaccountGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("usedaccount >=", value, "usedaccount");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andUsedaccountLessThan(BigDecimal value) {
      addCriterion("usedaccount <", value, "usedaccount");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andUsedaccountLessThanOrEqualTo(BigDecimal value) {
      addCriterion("usedaccount <=", value, "usedaccount");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andUsedaccountIn(List<BigDecimal> values) {
      addCriterion("usedaccount in", values, "usedaccount");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andUsedaccountNotIn(List<BigDecimal> values) {
      addCriterion("usedaccount not in", values, "usedaccount");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andUsedaccountBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("usedaccount between", value1, value2, "usedaccount");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andUsedaccountNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("usedaccount not between", value1, value2, "usedaccount");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andFreezeBlanceIsNull() {
      addCriterion("freeze_blance is null");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andFreezeBlanceIsNotNull() {
      addCriterion("freeze_blance is not null");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andFreezeBlanceEqualTo(BigDecimal value) {
      addCriterion("freeze_blance =", value, "freezeBlance");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andFreezeBlanceNotEqualTo(BigDecimal value) {
      addCriterion("freeze_blance <>", value, "freezeBlance");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andFreezeBlanceGreaterThan(BigDecimal value) {
      addCriterion("freeze_blance >", value, "freezeBlance");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andFreezeBlanceGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("freeze_blance >=", value, "freezeBlance");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andFreezeBlanceLessThan(BigDecimal value) {
      addCriterion("freeze_blance <", value, "freezeBlance");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andFreezeBlanceLessThanOrEqualTo(BigDecimal value) {
      addCriterion("freeze_blance <=", value, "freezeBlance");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andFreezeBlanceIn(List<BigDecimal> values) {
      addCriterion("freeze_blance in", values, "freezeBlance");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andFreezeBlanceNotIn(List<BigDecimal> values) {
      addCriterion("freeze_blance not in", values, "freezeBlance");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andFreezeBlanceBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("freeze_blance between", value1, value2, "freezeBlance");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andFreezeBlanceNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("freeze_blance not between", value1, value2, "freezeBlance");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andTotalincomeIsNull() {
      addCriterion("totalIncome is null");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andTotalincomeIsNotNull() {
      addCriterion("totalIncome is not null");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andTotalincomeEqualTo(BigDecimal value) {
      addCriterion("totalIncome =", value, "totalincome");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andTotalincomeNotEqualTo(BigDecimal value) {
      addCriterion("totalIncome <>", value, "totalincome");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andTotalincomeGreaterThan(BigDecimal value) {
      addCriterion("totalIncome >", value, "totalincome");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andTotalincomeGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("totalIncome >=", value, "totalincome");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andTotalincomeLessThan(BigDecimal value) {
      addCriterion("totalIncome <", value, "totalincome");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andTotalincomeLessThanOrEqualTo(BigDecimal value) {
      addCriterion("totalIncome <=", value, "totalincome");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andTotalincomeIn(List<BigDecimal> values) {
      addCriterion("totalIncome in", values, "totalincome");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andTotalincomeNotIn(List<BigDecimal> values) {
      addCriterion("totalIncome not in", values, "totalincome");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andTotalincomeBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("totalIncome between", value1, value2, "totalincome");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andTotalincomeNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("totalIncome not between", value1, value2, "totalincome");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andIncomeIsNull() {
      addCriterion("income is null");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andIncomeIsNotNull() {
      addCriterion("income is not null");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andIncomeEqualTo(BigDecimal value) {
      addCriterion("income =", value, "income");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andIncomeNotEqualTo(BigDecimal value) {
      addCriterion("income <>", value, "income");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andIncomeGreaterThan(BigDecimal value) {
      addCriterion("income >", value, "income");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andIncomeGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("income >=", value, "income");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andIncomeLessThan(BigDecimal value) {
      addCriterion("income <", value, "income");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andIncomeLessThanOrEqualTo(BigDecimal value) {
      addCriterion("income <=", value, "income");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andIncomeIn(List<BigDecimal> values) {
      addCriterion("income in", values, "income");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andIncomeNotIn(List<BigDecimal> values) {
      addCriterion("income not in", values, "income");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andIncomeBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("income between", value1, value2, "income");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andIncomeNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("income not between", value1, value2, "income");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andRecvincomeIsNull() {
      addCriterion("recvincome is null");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andRecvincomeIsNotNull() {
      addCriterion("recvincome is not null");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andRecvincomeEqualTo(BigDecimal value) {
      addCriterion("recvincome =", value, "recvincome");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andRecvincomeNotEqualTo(BigDecimal value) {
      addCriterion("recvincome <>", value, "recvincome");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andRecvincomeGreaterThan(BigDecimal value) {
      addCriterion("recvincome >", value, "recvincome");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andRecvincomeGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("recvincome >=", value, "recvincome");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andRecvincomeLessThan(BigDecimal value) {
      addCriterion("recvincome <", value, "recvincome");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andRecvincomeLessThanOrEqualTo(BigDecimal value) {
      addCriterion("recvincome <=", value, "recvincome");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andRecvincomeIn(List<BigDecimal> values) {
      addCriterion("recvincome in", values, "recvincome");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andRecvincomeNotIn(List<BigDecimal> values) {
      addCriterion("recvincome not in", values, "recvincome");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andRecvincomeBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("recvincome between", value1, value2, "recvincome");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andRecvincomeNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("recvincome not between", value1, value2, "recvincome");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andGoldaccountIsNull() {
      addCriterion("goldAccount is null");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andGoldaccountIsNotNull() {
      addCriterion("goldAccount is not null");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andGoldaccountEqualTo(BigDecimal value) {
      addCriterion("goldAccount =", value, "goldaccount");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andGoldaccountNotEqualTo(BigDecimal value) {
      addCriterion("goldAccount <>", value, "goldaccount");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andGoldaccountGreaterThan(BigDecimal value) {
      addCriterion("goldAccount >", value, "goldaccount");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andGoldaccountGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("goldAccount >=", value, "goldaccount");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andGoldaccountLessThan(BigDecimal value) {
      addCriterion("goldAccount <", value, "goldaccount");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andGoldaccountLessThanOrEqualTo(BigDecimal value) {
      addCriterion("goldAccount <=", value, "goldaccount");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andGoldaccountIn(List<BigDecimal> values) {
      addCriterion("goldAccount in", values, "goldaccount");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andGoldaccountNotIn(List<BigDecimal> values) {
      addCriterion("goldAccount not in", values, "goldaccount");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andGoldaccountBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("goldAccount between", value1, value2, "goldaccount");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andGoldaccountNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("goldAccount not between", value1, value2, "goldaccount");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andGoldblanceIsNull() {
      addCriterion("goldblance is null");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andGoldblanceIsNotNull() {
      addCriterion("goldblance is not null");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andGoldblanceEqualTo(BigDecimal value) {
      addCriterion("goldblance =", value, "goldblance");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andGoldblanceNotEqualTo(BigDecimal value) {
      addCriterion("goldblance <>", value, "goldblance");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andGoldblanceGreaterThan(BigDecimal value) {
      addCriterion("goldblance >", value, "goldblance");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andGoldblanceGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("goldblance >=", value, "goldblance");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andGoldblanceLessThan(BigDecimal value) {
      addCriterion("goldblance <", value, "goldblance");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andGoldblanceLessThanOrEqualTo(BigDecimal value) {
      addCriterion("goldblance <=", value, "goldblance");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andGoldblanceIn(List<BigDecimal> values) {
      addCriterion("goldblance in", values, "goldblance");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andGoldblanceNotIn(List<BigDecimal> values) {
      addCriterion("goldblance not in", values, "goldblance");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andGoldblanceBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("goldblance between", value1, value2, "goldblance");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andGoldblanceNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("goldblance not between", value1, value2, "goldblance");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andFreezegoldblanceIsNull() {
      addCriterion("freezegoldblance is null");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andFreezegoldblanceIsNotNull() {
      addCriterion("freezegoldblance is not null");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andFreezegoldblanceEqualTo(BigDecimal value) {
      addCriterion("freezegoldblance =", value, "freezegoldblance");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andFreezegoldblanceNotEqualTo(BigDecimal value) {
      addCriterion("freezegoldblance <>", value, "freezegoldblance");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andFreezegoldblanceGreaterThan(BigDecimal value) {
      addCriterion("freezegoldblance >", value, "freezegoldblance");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andFreezegoldblanceGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("freezegoldblance >=", value, "freezegoldblance");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andFreezegoldblanceLessThan(BigDecimal value) {
      addCriterion("freezegoldblance <", value, "freezegoldblance");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andFreezegoldblanceLessThanOrEqualTo(BigDecimal value) {
      addCriterion("freezegoldblance <=", value, "freezegoldblance");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andFreezegoldblanceIn(List<BigDecimal> values) {
      addCriterion("freezegoldblance in", values, "freezegoldblance");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andFreezegoldblanceNotIn(List<BigDecimal> values) {
      addCriterion("freezegoldblance not in", values, "freezegoldblance");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andFreezegoldblanceBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("freezegoldblance between", value1, value2, "freezegoldblance");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andFreezegoldblanceNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("freezegoldblance not between", value1, value2, "freezegoldblance");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andUsedgoldaccountIsNull() {
      addCriterion("usedgoldaccount is null");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andUsedgoldaccountIsNotNull() {
      addCriterion("usedgoldaccount is not null");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andUsedgoldaccountEqualTo(BigDecimal value) {
      addCriterion("usedgoldaccount =", value, "usedgoldaccount");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andUsedgoldaccountNotEqualTo(BigDecimal value) {
      addCriterion("usedgoldaccount <>", value, "usedgoldaccount");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andUsedgoldaccountGreaterThan(BigDecimal value) {
      addCriterion("usedgoldaccount >", value, "usedgoldaccount");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andUsedgoldaccountGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("usedgoldaccount >=", value, "usedgoldaccount");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andUsedgoldaccountLessThan(BigDecimal value) {
      addCriterion("usedgoldaccount <", value, "usedgoldaccount");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andUsedgoldaccountLessThanOrEqualTo(BigDecimal value) {
      addCriterion("usedgoldaccount <=", value, "usedgoldaccount");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andUsedgoldaccountIn(List<BigDecimal> values) {
      addCriterion("usedgoldaccount in", values, "usedgoldaccount");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andUsedgoldaccountNotIn(List<BigDecimal> values) {
      addCriterion("usedgoldaccount not in", values, "usedgoldaccount");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andUsedgoldaccountBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("usedgoldaccount between", value1, value2, "usedgoldaccount");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andUsedgoldaccountNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("usedgoldaccount not between", value1, value2, "usedgoldaccount");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andCommisiontotalaccountIsNull() {
      addCriterion("commisiontotalaccount is null");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andCommisiontotalaccountIsNotNull() {
      addCriterion("commisiontotalaccount is not null");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andCommisiontotalaccountEqualTo(BigDecimal value) {
      addCriterion("commisiontotalaccount =", value, "commisiontotalaccount");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andCommisiontotalaccountNotEqualTo(BigDecimal value) {
      addCriterion("commisiontotalaccount <>", value, "commisiontotalaccount");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andCommisiontotalaccountGreaterThan(BigDecimal value) {
      addCriterion("commisiontotalaccount >", value, "commisiontotalaccount");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andCommisiontotalaccountGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("commisiontotalaccount >=", value, "commisiontotalaccount");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andCommisiontotalaccountLessThan(BigDecimal value) {
      addCriterion("commisiontotalaccount <", value, "commisiontotalaccount");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andCommisiontotalaccountLessThanOrEqualTo(BigDecimal value) {
      addCriterion("commisiontotalaccount <=", value, "commisiontotalaccount");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andCommisiontotalaccountIn(List<BigDecimal> values) {
      addCriterion("commisiontotalaccount in", values, "commisiontotalaccount");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andCommisiontotalaccountNotIn(List<BigDecimal> values) {
      addCriterion("commisiontotalaccount not in", values, "commisiontotalaccount");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andCommisiontotalaccountBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("commisiontotalaccount between", value1, value2, "commisiontotalaccount");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andCommisiontotalaccountNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("commisiontotalaccount not between", value1, value2, "commisiontotalaccount");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andCommisionaccountIsNull() {
      addCriterion("commisionaccount is null");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andCommisionaccountIsNotNull() {
      addCriterion("commisionaccount is not null");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andCommisionaccountEqualTo(BigDecimal value) {
      addCriterion("commisionaccount =", value, "commisionaccount");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andCommisionaccountNotEqualTo(BigDecimal value) {
      addCriterion("commisionaccount <>", value, "commisionaccount");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andCommisionaccountGreaterThan(BigDecimal value) {
      addCriterion("commisionaccount >", value, "commisionaccount");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andCommisionaccountGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("commisionaccount >=", value, "commisionaccount");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andCommisionaccountLessThan(BigDecimal value) {
      addCriterion("commisionaccount <", value, "commisionaccount");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andCommisionaccountLessThanOrEqualTo(BigDecimal value) {
      addCriterion("commisionaccount <=", value, "commisionaccount");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andCommisionaccountIn(List<BigDecimal> values) {
      addCriterion("commisionaccount in", values, "commisionaccount");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andCommisionaccountNotIn(List<BigDecimal> values) {
      addCriterion("commisionaccount not in", values, "commisionaccount");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andCommisionaccountBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("commisionaccount between", value1, value2, "commisionaccount");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andCommisionaccountNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("commisionaccount not between", value1, value2, "commisionaccount");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andMembertypeIsNull() {
      addCriterion("memberType is null");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andMembertypeIsNotNull() {
      addCriterion("memberType is not null");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andMembertypeEqualTo(Integer value) {
      addCriterion("memberType =", value, "membertype");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andMembertypeNotEqualTo(Integer value) {
      addCriterion("memberType <>", value, "membertype");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andMembertypeGreaterThan(Integer value) {
      addCriterion("memberType >", value, "membertype");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andMembertypeGreaterThanOrEqualTo(Integer value) {
      addCriterion("memberType >=", value, "membertype");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andMembertypeLessThan(Integer value) {
      addCriterion("memberType <", value, "membertype");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andMembertypeLessThanOrEqualTo(Integer value) {
      addCriterion("memberType <=", value, "membertype");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andMembertypeIn(List<Integer> values) {
      addCriterion("memberType in", values, "membertype");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andMembertypeNotIn(List<Integer> values) {
      addCriterion("memberType not in", values, "membertype");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andMembertypeBetween(Integer value1, Integer value2) {
      addCriterion("memberType between", value1, value2, "membertype");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andMembertypeNotBetween(Integer value1, Integer value2) {
      addCriterion("memberType not between", value1, value2, "membertype");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andModifyDateIsNull() {
      addCriterion("modify_date is null");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andModifyDateIsNotNull() {
      addCriterion("modify_date is not null");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andModifyDateEqualTo(Date value) {
      addCriterion("modify_date =", value, "modifyDate");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andModifyDateNotEqualTo(Date value) {
      addCriterion("modify_date <>", value, "modifyDate");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andModifyDateGreaterThan(Date value) {
      addCriterion("modify_date >", value, "modifyDate");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andModifyDateGreaterThanOrEqualTo(Date value) {
      addCriterion("modify_date >=", value, "modifyDate");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andModifyDateLessThan(Date value) {
      addCriterion("modify_date <", value, "modifyDate");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andModifyDateLessThanOrEqualTo(Date value) {
      addCriterion("modify_date <=", value, "modifyDate");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andModifyDateIn(List<Date> values) {
      addCriterion("modify_date in", values, "modifyDate");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andModifyDateNotIn(List<Date> values) {
      addCriterion("modify_date not in", values, "modifyDate");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andModifyDateBetween(Date value1, Date value2) {
      addCriterion("modify_date between", value1, value2, "modifyDate");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andModifyDateNotBetween(Date value1, Date value2) {
      addCriterion("modify_date not between", value1, value2, "modifyDate");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andCreateDateIsNull() {
      addCriterion("create_date is null");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andCreateDateIsNotNull() {
      addCriterion("create_date is not null");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andCreateDateEqualTo(Date value) {
      addCriterion("create_date =", value, "createDate");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andCreateDateNotEqualTo(Date value) {
      addCriterion("create_date <>", value, "createDate");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andCreateDateGreaterThan(Date value) {
      addCriterion("create_date >", value, "createDate");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
      addCriterion("create_date >=", value, "createDate");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andCreateDateLessThan(Date value) {
      addCriterion("create_date <", value, "createDate");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andCreateDateLessThanOrEqualTo(Date value) {
      addCriterion("create_date <=", value, "createDate");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andCreateDateIn(List<Date> values) {
      addCriterion("create_date in", values, "createDate");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andCreateDateNotIn(List<Date> values) {
      addCriterion("create_date not in", values, "createDate");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andCreateDateBetween(Date value1, Date value2) {
      addCriterion("create_date between", value1, value2, "createDate");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andCreateDateNotBetween(Date value1, Date value2) {
      addCriterion("create_date not between", value1, value2, "createDate");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andFreezeDateIsNull() {
      addCriterion("freeze_date is null");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andFreezeDateIsNotNull() {
      addCriterion("freeze_date is not null");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andFreezeDateEqualTo(Date value) {
      addCriterion("freeze_date =", value, "freezeDate");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andFreezeDateNotEqualTo(Date value) {
      addCriterion("freeze_date <>", value, "freezeDate");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andFreezeDateGreaterThan(Date value) {
      addCriterion("freeze_date >", value, "freezeDate");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andFreezeDateGreaterThanOrEqualTo(Date value) {
      addCriterion("freeze_date >=", value, "freezeDate");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andFreezeDateLessThan(Date value) {
      addCriterion("freeze_date <", value, "freezeDate");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andFreezeDateLessThanOrEqualTo(Date value) {
      addCriterion("freeze_date <=", value, "freezeDate");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andFreezeDateIn(List<Date> values) {
      addCriterion("freeze_date in", values, "freezeDate");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andFreezeDateNotIn(List<Date> values) {
      addCriterion("freeze_date not in", values, "freezeDate");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andFreezeDateBetween(Date value1, Date value2) {
      addCriterion("freeze_date between", value1, value2, "freezeDate");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andFreezeDateNotBetween(Date value1, Date value2) {
      addCriterion("freeze_date not between", value1, value2, "freezeDate");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andUpdateDateIsNull() {
      addCriterion("update_date is null");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andUpdateDateIsNotNull() {
      addCriterion("update_date is not null");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andUpdateDateEqualTo(Date value) {
      addCriterion("update_date =", value, "updateDate");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andUpdateDateNotEqualTo(Date value) {
      addCriterion("update_date <>", value, "updateDate");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andUpdateDateGreaterThan(Date value) {
      addCriterion("update_date >", value, "updateDate");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andUpdateDateGreaterThanOrEqualTo(Date value) {
      addCriterion("update_date >=", value, "updateDate");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andUpdateDateLessThan(Date value) {
      addCriterion("update_date <", value, "updateDate");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andUpdateDateLessThanOrEqualTo(Date value) {
      addCriterion("update_date <=", value, "updateDate");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andUpdateDateIn(List<Date> values) {
      addCriterion("update_date in", values, "updateDate");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andUpdateDateNotIn(List<Date> values) {
      addCriterion("update_date not in", values, "updateDate");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andUpdateDateBetween(Date value1, Date value2) {
      addCriterion("update_date between", value1, value2, "updateDate");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andUpdateDateNotBetween(Date value1, Date value2) {
      addCriterion("update_date not between", value1, value2, "updateDate");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andRemarkIsNull() {
      addCriterion("remark is null");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andRemarkIsNotNull() {
      addCriterion("remark is not null");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andRemarkEqualTo(String value) {
      addCriterion("remark =", value, "remark");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andRemarkNotEqualTo(String value) {
      addCriterion("remark <>", value, "remark");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andRemarkGreaterThan(String value) {
      addCriterion("remark >", value, "remark");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andRemarkGreaterThanOrEqualTo(String value) {
      addCriterion("remark >=", value, "remark");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andRemarkLessThan(String value) {
      addCriterion("remark <", value, "remark");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andRemarkLessThanOrEqualTo(String value) {
      addCriterion("remark <=", value, "remark");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andRemarkLike(String value) {
      addCriterion("remark like", value, "remark");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andRemarkNotLike(String value) {
      addCriterion("remark not like", value, "remark");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andRemarkIn(List<String> values) {
      addCriterion("remark in", values, "remark");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andRemarkNotIn(List<String> values) {
      addCriterion("remark not in", values, "remark");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andRemarkBetween(String value1, String value2) {
      addCriterion("remark between", value1, value2, "remark");
      return ((MemberAccountExample.Criteria)this);
    }

    public MemberAccountExample.Criteria andRemarkNotBetween(String value1, String value2) {
      addCriterion("remark not between", value1, value2, "remark");
      return ((MemberAccountExample.Criteria)this);
    }
  }
}