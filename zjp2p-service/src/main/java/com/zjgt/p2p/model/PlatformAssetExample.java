package com.zjgt.p2p.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PlatformAssetExample
{
  protected String orderByClause;
  protected boolean distinct;
  protected List<Criteria> oredCriteria;

  public PlatformAssetExample()
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

  public static class Criteria extends PlatformAssetExample.GeneratedCriteria
  {
  }

  protected static abstract class GeneratedCriteria
  {
    protected List<PlatformAssetExample.Criterion> criteria;

    protected GeneratedCriteria()
    {
      this.criteria = new ArrayList();
    }

    public boolean isValid() {
      return (this.criteria.size() > 0);
    }

    public List<PlatformAssetExample.Criterion> getAllCriteria() {
      return this.criteria;
    }

    public List<PlatformAssetExample.Criterion> getCriteria() {
      return this.criteria;
    }

    protected void addCriterion(String condition) {
      if (condition == null) {
        throw new RuntimeException("Value for condition cannot be null");
      }
      this.criteria.add(new PlatformAssetExample.Criterion(condition));
    }

    protected void addCriterion(String condition, Object value, String property) {
      if (value == null) {
        throw new RuntimeException("Value for " + property + " cannot be null");
      }
      this.criteria.add(new PlatformAssetExample.Criterion(condition, value));
    }

    protected void addCriterion(String condition, Object value1, Object value2, String property) {
      if ((value1 == null) || (value2 == null)) {
        throw new RuntimeException("Between values for " + property + " cannot be null");
      }
      this.criteria.add(new PlatformAssetExample.Criterion(condition, value1, value2));
    }

    public PlatformAssetExample.Criteria andIdIsNull() {
      addCriterion("id is null");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andIdIsNotNull() {
      addCriterion("id is not null");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andIdEqualTo(Long value) {
      addCriterion("id =", value, "id");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andIdNotEqualTo(Long value) {
      addCriterion("id <>", value, "id");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andIdGreaterThan(Long value) {
      addCriterion("id >", value, "id");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andIdGreaterThanOrEqualTo(Long value) {
      addCriterion("id >=", value, "id");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andIdLessThan(Long value) {
      addCriterion("id <", value, "id");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andIdLessThanOrEqualTo(Long value) {
      addCriterion("id <=", value, "id");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andIdIn(List<Long> values) {
      addCriterion("id in", values, "id");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andIdNotIn(List<Long> values) {
      addCriterion("id not in", values, "id");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andIdBetween(Long value1, Long value2) {
      addCriterion("id between", value1, value2, "id");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andIdNotBetween(Long value1, Long value2) {
      addCriterion("id not between", value1, value2, "id");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andAcctidIsNull() {
      addCriterion("acctid is null");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andAcctidIsNotNull() {
      addCriterion("acctid is not null");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andAcctidEqualTo(Long value) {
      addCriterion("acctid =", value, "acctid");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andAcctidNotEqualTo(Long value) {
      addCriterion("acctid <>", value, "acctid");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andAcctidGreaterThan(Long value) {
      addCriterion("acctid >", value, "acctid");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andAcctidGreaterThanOrEqualTo(Long value) {
      addCriterion("acctid >=", value, "acctid");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andAcctidLessThan(Long value) {
      addCriterion("acctid <", value, "acctid");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andAcctidLessThanOrEqualTo(Long value) {
      addCriterion("acctid <=", value, "acctid");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andAcctidIn(List<Long> values) {
      addCriterion("acctid in", values, "acctid");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andAcctidNotIn(List<Long> values) {
      addCriterion("acctid not in", values, "acctid");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andAcctidBetween(Long value1, Long value2) {
      addCriterion("acctid between", value1, value2, "acctid");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andAcctidNotBetween(Long value1, Long value2) {
      addCriterion("acctid not between", value1, value2, "acctid");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andMemberidIsNull() {
      addCriterion("memberid is null");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andMemberidIsNotNull() {
      addCriterion("memberid is not null");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andMemberidEqualTo(Long value) {
      addCriterion("memberid =", value, "memberid");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andMemberidNotEqualTo(Long value) {
      addCriterion("memberid <>", value, "memberid");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andMemberidGreaterThan(Long value) {
      addCriterion("memberid >", value, "memberid");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andMemberidGreaterThanOrEqualTo(Long value) {
      addCriterion("memberid >=", value, "memberid");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andMemberidLessThan(Long value) {
      addCriterion("memberid <", value, "memberid");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andMemberidLessThanOrEqualTo(Long value) {
      addCriterion("memberid <=", value, "memberid");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andMemberidIn(List<Long> values) {
      addCriterion("memberid in", values, "memberid");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andMemberidNotIn(List<Long> values) {
      addCriterion("memberid not in", values, "memberid");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andMemberidBetween(Long value1, Long value2) {
      addCriterion("memberid between", value1, value2, "memberid");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andMemberidNotBetween(Long value1, Long value2) {
      addCriterion("memberid not between", value1, value2, "memberid");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andCreateDateIsNull() {
      addCriterion("create_date is null");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andCreateDateIsNotNull() {
      addCriterion("create_date is not null");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andCreateDateEqualTo(Date value) {
      addCriterion("create_date =", value, "createDate");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andCreateDateNotEqualTo(Date value) {
      addCriterion("create_date <>", value, "createDate");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andCreateDateGreaterThan(Date value) {
      addCriterion("create_date >", value, "createDate");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
      addCriterion("create_date >=", value, "createDate");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andCreateDateLessThan(Date value) {
      addCriterion("create_date <", value, "createDate");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andCreateDateLessThanOrEqualTo(Date value) {
      addCriterion("create_date <=", value, "createDate");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andCreateDateIn(List<Date> values) {
      addCriterion("create_date in", values, "createDate");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andCreateDateNotIn(List<Date> values) {
      addCriterion("create_date not in", values, "createDate");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andCreateDateBetween(Date value1, Date value2) {
      addCriterion("create_date between", value1, value2, "createDate");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andCreateDateNotBetween(Date value1, Date value2) {
      addCriterion("create_date not between", value1, value2, "createDate");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andAccountIsNull() {
      addCriterion("account is null");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andAccountIsNotNull() {
      addCriterion("account is not null");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andAccountEqualTo(BigDecimal value) {
      addCriterion("account =", value, "account");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andAccountNotEqualTo(BigDecimal value) {
      addCriterion("account <>", value, "account");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andAccountGreaterThan(BigDecimal value) {
      addCriterion("account >", value, "account");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andAccountGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("account >=", value, "account");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andAccountLessThan(BigDecimal value) {
      addCriterion("account <", value, "account");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andAccountLessThanOrEqualTo(BigDecimal value) {
      addCriterion("account <=", value, "account");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andAccountIn(List<BigDecimal> values) {
      addCriterion("account in", values, "account");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andAccountNotIn(List<BigDecimal> values) {
      addCriterion("account not in", values, "account");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andAccountBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("account between", value1, value2, "account");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andAccountNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("account not between", value1, value2, "account");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andBlanceIsNull() {
      addCriterion("blance is null");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andBlanceIsNotNull() {
      addCriterion("blance is not null");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andBlanceEqualTo(BigDecimal value) {
      addCriterion("blance =", value, "blance");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andBlanceNotEqualTo(BigDecimal value) {
      addCriterion("blance <>", value, "blance");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andBlanceGreaterThan(BigDecimal value) {
      addCriterion("blance >", value, "blance");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andBlanceGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("blance >=", value, "blance");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andBlanceLessThan(BigDecimal value) {
      addCriterion("blance <", value, "blance");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andBlanceLessThanOrEqualTo(BigDecimal value) {
      addCriterion("blance <=", value, "blance");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andBlanceIn(List<BigDecimal> values) {
      addCriterion("blance in", values, "blance");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andBlanceNotIn(List<BigDecimal> values) {
      addCriterion("blance not in", values, "blance");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andBlanceBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("blance between", value1, value2, "blance");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andBlanceNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("blance not between", value1, value2, "blance");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andFreezeBlanceIsNull() {
      addCriterion("freeze_blance is null");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andFreezeBlanceIsNotNull() {
      addCriterion("freeze_blance is not null");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andFreezeBlanceEqualTo(BigDecimal value) {
      addCriterion("freeze_blance =", value, "freezeBlance");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andFreezeBlanceNotEqualTo(BigDecimal value) {
      addCriterion("freeze_blance <>", value, "freezeBlance");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andFreezeBlanceGreaterThan(BigDecimal value) {
      addCriterion("freeze_blance >", value, "freezeBlance");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andFreezeBlanceGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("freeze_blance >=", value, "freezeBlance");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andFreezeBlanceLessThan(BigDecimal value) {
      addCriterion("freeze_blance <", value, "freezeBlance");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andFreezeBlanceLessThanOrEqualTo(BigDecimal value) {
      addCriterion("freeze_blance <=", value, "freezeBlance");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andFreezeBlanceIn(List<BigDecimal> values) {
      addCriterion("freeze_blance in", values, "freezeBlance");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andFreezeBlanceNotIn(List<BigDecimal> values) {
      addCriterion("freeze_blance not in", values, "freezeBlance");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andFreezeBlanceBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("freeze_blance between", value1, value2, "freezeBlance");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andFreezeBlanceNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("freeze_blance not between", value1, value2, "freezeBlance");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andIncomeIsNull() {
      addCriterion("income is null");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andIncomeIsNotNull() {
      addCriterion("income is not null");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andIncomeEqualTo(BigDecimal value) {
      addCriterion("income =", value, "income");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andIncomeNotEqualTo(BigDecimal value) {
      addCriterion("income <>", value, "income");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andIncomeGreaterThan(BigDecimal value) {
      addCriterion("income >", value, "income");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andIncomeGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("income >=", value, "income");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andIncomeLessThan(BigDecimal value) {
      addCriterion("income <", value, "income");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andIncomeLessThanOrEqualTo(BigDecimal value) {
      addCriterion("income <=", value, "income");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andIncomeIn(List<BigDecimal> values) {
      addCriterion("income in", values, "income");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andIncomeNotIn(List<BigDecimal> values) {
      addCriterion("income not in", values, "income");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andIncomeBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("income between", value1, value2, "income");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andIncomeNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("income not between", value1, value2, "income");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andExpenseIsNull() {
      addCriterion("expense is null");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andExpenseIsNotNull() {
      addCriterion("expense is not null");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andExpenseEqualTo(BigDecimal value) {
      addCriterion("expense =", value, "expense");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andExpenseNotEqualTo(BigDecimal value) {
      addCriterion("expense <>", value, "expense");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andExpenseGreaterThan(BigDecimal value) {
      addCriterion("expense >", value, "expense");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andExpenseGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("expense >=", value, "expense");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andExpenseLessThan(BigDecimal value) {
      addCriterion("expense <", value, "expense");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andExpenseLessThanOrEqualTo(BigDecimal value) {
      addCriterion("expense <=", value, "expense");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andExpenseIn(List<BigDecimal> values) {
      addCriterion("expense in", values, "expense");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andExpenseNotIn(List<BigDecimal> values) {
      addCriterion("expense not in", values, "expense");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andExpenseBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("expense between", value1, value2, "expense");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andExpenseNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("expense not between", value1, value2, "expense");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andModifyDateIsNull() {
      addCriterion("modify_date is null");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andModifyDateIsNotNull() {
      addCriterion("modify_date is not null");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andModifyDateEqualTo(Date value) {
      addCriterion("modify_date =", value, "modifyDate");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andModifyDateNotEqualTo(Date value) {
      addCriterion("modify_date <>", value, "modifyDate");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andModifyDateGreaterThan(Date value) {
      addCriterion("modify_date >", value, "modifyDate");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andModifyDateGreaterThanOrEqualTo(Date value) {
      addCriterion("modify_date >=", value, "modifyDate");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andModifyDateLessThan(Date value) {
      addCriterion("modify_date <", value, "modifyDate");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andModifyDateLessThanOrEqualTo(Date value) {
      addCriterion("modify_date <=", value, "modifyDate");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andModifyDateIn(List<Date> values) {
      addCriterion("modify_date in", values, "modifyDate");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andModifyDateNotIn(List<Date> values) {
      addCriterion("modify_date not in", values, "modifyDate");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andModifyDateBetween(Date value1, Date value2) {
      addCriterion("modify_date between", value1, value2, "modifyDate");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andModifyDateNotBetween(Date value1, Date value2) {
      addCriterion("modify_date not between", value1, value2, "modifyDate");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andFreezeDateIsNull() {
      addCriterion("freeze_date is null");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andFreezeDateIsNotNull() {
      addCriterion("freeze_date is not null");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andFreezeDateEqualTo(Date value) {
      addCriterion("freeze_date =", value, "freezeDate");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andFreezeDateNotEqualTo(Date value) {
      addCriterion("freeze_date <>", value, "freezeDate");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andFreezeDateGreaterThan(Date value) {
      addCriterion("freeze_date >", value, "freezeDate");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andFreezeDateGreaterThanOrEqualTo(Date value) {
      addCriterion("freeze_date >=", value, "freezeDate");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andFreezeDateLessThan(Date value) {
      addCriterion("freeze_date <", value, "freezeDate");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andFreezeDateLessThanOrEqualTo(Date value) {
      addCriterion("freeze_date <=", value, "freezeDate");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andFreezeDateIn(List<Date> values) {
      addCriterion("freeze_date in", values, "freezeDate");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andFreezeDateNotIn(List<Date> values) {
      addCriterion("freeze_date not in", values, "freezeDate");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andFreezeDateBetween(Date value1, Date value2) {
      addCriterion("freeze_date between", value1, value2, "freezeDate");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andFreezeDateNotBetween(Date value1, Date value2) {
      addCriterion("freeze_date not between", value1, value2, "freezeDate");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andUpdateDateIsNull() {
      addCriterion("update_date is null");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andUpdateDateIsNotNull() {
      addCriterion("update_date is not null");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andUpdateDateEqualTo(Date value) {
      addCriterion("update_date =", value, "updateDate");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andUpdateDateNotEqualTo(Date value) {
      addCriterion("update_date <>", value, "updateDate");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andUpdateDateGreaterThan(Date value) {
      addCriterion("update_date >", value, "updateDate");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andUpdateDateGreaterThanOrEqualTo(Date value) {
      addCriterion("update_date >=", value, "updateDate");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andUpdateDateLessThan(Date value) {
      addCriterion("update_date <", value, "updateDate");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andUpdateDateLessThanOrEqualTo(Date value) {
      addCriterion("update_date <=", value, "updateDate");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andUpdateDateIn(List<Date> values) {
      addCriterion("update_date in", values, "updateDate");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andUpdateDateNotIn(List<Date> values) {
      addCriterion("update_date not in", values, "updateDate");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andUpdateDateBetween(Date value1, Date value2) {
      addCriterion("update_date between", value1, value2, "updateDate");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andUpdateDateNotBetween(Date value1, Date value2) {
      addCriterion("update_date not between", value1, value2, "updateDate");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andMembertypeIsNull() {
      addCriterion("memberType is null");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andMembertypeIsNotNull() {
      addCriterion("memberType is not null");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andMembertypeEqualTo(Integer value) {
      addCriterion("memberType =", value, "membertype");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andMembertypeNotEqualTo(Integer value) {
      addCriterion("memberType <>", value, "membertype");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andMembertypeGreaterThan(Integer value) {
      addCriterion("memberType >", value, "membertype");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andMembertypeGreaterThanOrEqualTo(Integer value) {
      addCriterion("memberType >=", value, "membertype");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andMembertypeLessThan(Integer value) {
      addCriterion("memberType <", value, "membertype");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andMembertypeLessThanOrEqualTo(Integer value) {
      addCriterion("memberType <=", value, "membertype");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andMembertypeIn(List<Integer> values) {
      addCriterion("memberType in", values, "membertype");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andMembertypeNotIn(List<Integer> values) {
      addCriterion("memberType not in", values, "membertype");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andMembertypeBetween(Integer value1, Integer value2) {
      addCriterion("memberType between", value1, value2, "membertype");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andMembertypeNotBetween(Integer value1, Integer value2) {
      addCriterion("memberType not between", value1, value2, "membertype");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andRemarkIsNull() {
      addCriterion("remark is null");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andRemarkIsNotNull() {
      addCriterion("remark is not null");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andRemarkEqualTo(String value) {
      addCriterion("remark =", value, "remark");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andRemarkNotEqualTo(String value) {
      addCriterion("remark <>", value, "remark");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andRemarkGreaterThan(String value) {
      addCriterion("remark >", value, "remark");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andRemarkGreaterThanOrEqualTo(String value) {
      addCriterion("remark >=", value, "remark");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andRemarkLessThan(String value) {
      addCriterion("remark <", value, "remark");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andRemarkLessThanOrEqualTo(String value) {
      addCriterion("remark <=", value, "remark");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andRemarkLike(String value) {
      addCriterion("remark like", value, "remark");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andRemarkNotLike(String value) {
      addCriterion("remark not like", value, "remark");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andRemarkIn(List<String> values) {
      addCriterion("remark in", values, "remark");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andRemarkNotIn(List<String> values) {
      addCriterion("remark not in", values, "remark");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andRemarkBetween(String value1, String value2) {
      addCriterion("remark between", value1, value2, "remark");
      return ((PlatformAssetExample.Criteria)this);
    }

    public PlatformAssetExample.Criteria andRemarkNotBetween(String value1, String value2) {
      addCriterion("remark not between", value1, value2, "remark");
      return ((PlatformAssetExample.Criteria)this);
    }
  }
}