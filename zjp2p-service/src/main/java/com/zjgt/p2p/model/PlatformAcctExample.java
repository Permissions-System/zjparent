package com.zjgt.p2p.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PlatformAcctExample
{
  protected String orderByClause;
  protected boolean distinct;
  protected List<Criteria> oredCriteria;

  public PlatformAcctExample()
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

  public static class Criteria extends PlatformAcctExample.GeneratedCriteria
  {
  }

  protected static abstract class GeneratedCriteria
  {
    protected List<PlatformAcctExample.Criterion> criteria;

    protected GeneratedCriteria()
    {
      this.criteria = new ArrayList();
    }

    public boolean isValid() {
      return (this.criteria.size() > 0);
    }

    public List<PlatformAcctExample.Criterion> getAllCriteria() {
      return this.criteria;
    }

    public List<PlatformAcctExample.Criterion> getCriteria() {
      return this.criteria;
    }

    protected void addCriterion(String condition) {
      if (condition == null) {
        throw new RuntimeException("Value for condition cannot be null");
      }
      this.criteria.add(new PlatformAcctExample.Criterion(condition));
    }

    protected void addCriterion(String condition, Object value, String property) {
      if (value == null) {
        throw new RuntimeException("Value for " + property + " cannot be null");
      }
      this.criteria.add(new PlatformAcctExample.Criterion(condition, value));
    }

    protected void addCriterion(String condition, Object value1, Object value2, String property) {
      if ((value1 == null) || (value2 == null)) {
        throw new RuntimeException("Between values for " + property + " cannot be null");
      }
      this.criteria.add(new PlatformAcctExample.Criterion(condition, value1, value2));
    }

    public PlatformAcctExample.Criteria andIdIsNull() {
      addCriterion("id is null");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andIdIsNotNull() {
      addCriterion("id is not null");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andIdEqualTo(Long value) {
      addCriterion("id =", value, "id");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andIdNotEqualTo(Long value) {
      addCriterion("id <>", value, "id");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andIdGreaterThan(Long value) {
      addCriterion("id >", value, "id");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andIdGreaterThanOrEqualTo(Long value) {
      addCriterion("id >=", value, "id");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andIdLessThan(Long value) {
      addCriterion("id <", value, "id");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andIdLessThanOrEqualTo(Long value) {
      addCriterion("id <=", value, "id");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andIdIn(List<Long> values) {
      addCriterion("id in", values, "id");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andIdNotIn(List<Long> values) {
      addCriterion("id not in", values, "id");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andIdBetween(Long value1, Long value2) {
      addCriterion("id between", value1, value2, "id");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andIdNotBetween(Long value1, Long value2) {
      addCriterion("id not between", value1, value2, "id");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andAcctidIsNull() {
      addCriterion("acctid is null");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andAcctidIsNotNull() {
      addCriterion("acctid is not null");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andAcctidEqualTo(Long value) {
      addCriterion("acctid =", value, "acctid");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andAcctidNotEqualTo(Long value) {
      addCriterion("acctid <>", value, "acctid");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andAcctidGreaterThan(Long value) {
      addCriterion("acctid >", value, "acctid");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andAcctidGreaterThanOrEqualTo(Long value) {
      addCriterion("acctid >=", value, "acctid");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andAcctidLessThan(Long value) {
      addCriterion("acctid <", value, "acctid");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andAcctidLessThanOrEqualTo(Long value) {
      addCriterion("acctid <=", value, "acctid");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andAcctidIn(List<Long> values) {
      addCriterion("acctid in", values, "acctid");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andAcctidNotIn(List<Long> values) {
      addCriterion("acctid not in", values, "acctid");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andAcctidBetween(Long value1, Long value2) {
      addCriterion("acctid between", value1, value2, "acctid");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andAcctidNotBetween(Long value1, Long value2) {
      addCriterion("acctid not between", value1, value2, "acctid");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andMemberidIsNull() {
      addCriterion("memberid is null");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andMemberidIsNotNull() {
      addCriterion("memberid is not null");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andMemberidEqualTo(Long value) {
      addCriterion("memberid =", value, "memberid");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andMemberidNotEqualTo(Long value) {
      addCriterion("memberid <>", value, "memberid");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andMemberidGreaterThan(Long value) {
      addCriterion("memberid >", value, "memberid");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andMemberidGreaterThanOrEqualTo(Long value) {
      addCriterion("memberid >=", value, "memberid");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andMemberidLessThan(Long value) {
      addCriterion("memberid <", value, "memberid");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andMemberidLessThanOrEqualTo(Long value) {
      addCriterion("memberid <=", value, "memberid");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andMemberidIn(List<Long> values) {
      addCriterion("memberid in", values, "memberid");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andMemberidNotIn(List<Long> values) {
      addCriterion("memberid not in", values, "memberid");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andMemberidBetween(Long value1, Long value2) {
      addCriterion("memberid between", value1, value2, "memberid");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andMemberidNotBetween(Long value1, Long value2) {
      addCriterion("memberid not between", value1, value2, "memberid");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andCreateDateIsNull() {
      addCriterion("create_date is null");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andCreateDateIsNotNull() {
      addCriterion("create_date is not null");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andCreateDateEqualTo(Date value) {
      addCriterion("create_date =", value, "createDate");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andCreateDateNotEqualTo(Date value) {
      addCriterion("create_date <>", value, "createDate");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andCreateDateGreaterThan(Date value) {
      addCriterion("create_date >", value, "createDate");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
      addCriterion("create_date >=", value, "createDate");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andCreateDateLessThan(Date value) {
      addCriterion("create_date <", value, "createDate");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andCreateDateLessThanOrEqualTo(Date value) {
      addCriterion("create_date <=", value, "createDate");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andCreateDateIn(List<Date> values) {
      addCriterion("create_date in", values, "createDate");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andCreateDateNotIn(List<Date> values) {
      addCriterion("create_date not in", values, "createDate");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andCreateDateBetween(Date value1, Date value2) {
      addCriterion("create_date between", value1, value2, "createDate");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andCreateDateNotBetween(Date value1, Date value2) {
      addCriterion("create_date not between", value1, value2, "createDate");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andAcctTypeIsNull() {
      addCriterion("acct_type is null");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andAcctTypeIsNotNull() {
      addCriterion("acct_type is not null");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andAcctTypeEqualTo(Integer value) {
      addCriterion("acct_type =", value, "acctType");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andAcctTypeNotEqualTo(Integer value) {
      addCriterion("acct_type <>", value, "acctType");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andAcctTypeGreaterThan(Integer value) {
      addCriterion("acct_type >", value, "acctType");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andAcctTypeGreaterThanOrEqualTo(Integer value) {
      addCriterion("acct_type >=", value, "acctType");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andAcctTypeLessThan(Integer value) {
      addCriterion("acct_type <", value, "acctType");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andAcctTypeLessThanOrEqualTo(Integer value) {
      addCriterion("acct_type <=", value, "acctType");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andAcctTypeIn(List<Integer> values) {
      addCriterion("acct_type in", values, "acctType");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andAcctTypeNotIn(List<Integer> values) {
      addCriterion("acct_type not in", values, "acctType");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andAcctTypeBetween(Integer value1, Integer value2) {
      addCriterion("acct_type between", value1, value2, "acctType");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andAcctTypeNotBetween(Integer value1, Integer value2) {
      addCriterion("acct_type not between", value1, value2, "acctType");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andAcctNameIsNull() {
      addCriterion("acct_name is null");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andAcctNameIsNotNull() {
      addCriterion("acct_name is not null");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andAcctNameEqualTo(String value) {
      addCriterion("acct_name =", value, "acctName");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andAcctNameNotEqualTo(String value) {
      addCriterion("acct_name <>", value, "acctName");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andAcctNameGreaterThan(String value) {
      addCriterion("acct_name >", value, "acctName");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andAcctNameGreaterThanOrEqualTo(String value) {
      addCriterion("acct_name >=", value, "acctName");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andAcctNameLessThan(String value) {
      addCriterion("acct_name <", value, "acctName");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andAcctNameLessThanOrEqualTo(String value) {
      addCriterion("acct_name <=", value, "acctName");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andAcctNameLike(String value) {
      addCriterion("acct_name like", value, "acctName");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andAcctNameNotLike(String value) {
      addCriterion("acct_name not like", value, "acctName");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andAcctNameIn(List<String> values) {
      addCriterion("acct_name in", values, "acctName");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andAcctNameNotIn(List<String> values) {
      addCriterion("acct_name not in", values, "acctName");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andAcctNameBetween(String value1, String value2) {
      addCriterion("acct_name between", value1, value2, "acctName");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andAcctNameNotBetween(String value1, String value2) {
      addCriterion("acct_name not between", value1, value2, "acctName");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andAccountIsNull() {
      addCriterion("account is null");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andAccountIsNotNull() {
      addCriterion("account is not null");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andAccountEqualTo(BigDecimal value) {
      addCriterion("account =", value, "account");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andAccountNotEqualTo(BigDecimal value) {
      addCriterion("account <>", value, "account");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andAccountGreaterThan(BigDecimal value) {
      addCriterion("account >", value, "account");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andAccountGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("account >=", value, "account");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andAccountLessThan(BigDecimal value) {
      addCriterion("account <", value, "account");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andAccountLessThanOrEqualTo(BigDecimal value) {
      addCriterion("account <=", value, "account");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andAccountIn(List<BigDecimal> values) {
      addCriterion("account in", values, "account");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andAccountNotIn(List<BigDecimal> values) {
      addCriterion("account not in", values, "account");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andAccountBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("account between", value1, value2, "account");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andAccountNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("account not between", value1, value2, "account");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andBlanceIsNull() {
      addCriterion("blance is null");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andBlanceIsNotNull() {
      addCriterion("blance is not null");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andBlanceEqualTo(BigDecimal value) {
      addCriterion("blance =", value, "blance");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andBlanceNotEqualTo(BigDecimal value) {
      addCriterion("blance <>", value, "blance");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andBlanceGreaterThan(BigDecimal value) {
      addCriterion("blance >", value, "blance");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andBlanceGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("blance >=", value, "blance");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andBlanceLessThan(BigDecimal value) {
      addCriterion("blance <", value, "blance");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andBlanceLessThanOrEqualTo(BigDecimal value) {
      addCriterion("blance <=", value, "blance");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andBlanceIn(List<BigDecimal> values) {
      addCriterion("blance in", values, "blance");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andBlanceNotIn(List<BigDecimal> values) {
      addCriterion("blance not in", values, "blance");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andBlanceBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("blance between", value1, value2, "blance");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andBlanceNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("blance not between", value1, value2, "blance");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andFreezeBlanceIsNull() {
      addCriterion("freeze_blance is null");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andFreezeBlanceIsNotNull() {
      addCriterion("freeze_blance is not null");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andFreezeBlanceEqualTo(BigDecimal value) {
      addCriterion("freeze_blance =", value, "freezeBlance");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andFreezeBlanceNotEqualTo(BigDecimal value) {
      addCriterion("freeze_blance <>", value, "freezeBlance");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andFreezeBlanceGreaterThan(BigDecimal value) {
      addCriterion("freeze_blance >", value, "freezeBlance");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andFreezeBlanceGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("freeze_blance >=", value, "freezeBlance");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andFreezeBlanceLessThan(BigDecimal value) {
      addCriterion("freeze_blance <", value, "freezeBlance");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andFreezeBlanceLessThanOrEqualTo(BigDecimal value) {
      addCriterion("freeze_blance <=", value, "freezeBlance");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andFreezeBlanceIn(List<BigDecimal> values) {
      addCriterion("freeze_blance in", values, "freezeBlance");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andFreezeBlanceNotIn(List<BigDecimal> values) {
      addCriterion("freeze_blance not in", values, "freezeBlance");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andFreezeBlanceBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("freeze_blance between", value1, value2, "freezeBlance");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andFreezeBlanceNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("freeze_blance not between", value1, value2, "freezeBlance");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andModifyDateIsNull() {
      addCriterion("modify_date is null");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andModifyDateIsNotNull() {
      addCriterion("modify_date is not null");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andModifyDateEqualTo(Date value) {
      addCriterion("modify_date =", value, "modifyDate");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andModifyDateNotEqualTo(Date value) {
      addCriterion("modify_date <>", value, "modifyDate");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andModifyDateGreaterThan(Date value) {
      addCriterion("modify_date >", value, "modifyDate");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andModifyDateGreaterThanOrEqualTo(Date value) {
      addCriterion("modify_date >=", value, "modifyDate");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andModifyDateLessThan(Date value) {
      addCriterion("modify_date <", value, "modifyDate");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andModifyDateLessThanOrEqualTo(Date value) {
      addCriterion("modify_date <=", value, "modifyDate");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andModifyDateIn(List<Date> values) {
      addCriterion("modify_date in", values, "modifyDate");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andModifyDateNotIn(List<Date> values) {
      addCriterion("modify_date not in", values, "modifyDate");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andModifyDateBetween(Date value1, Date value2) {
      addCriterion("modify_date between", value1, value2, "modifyDate");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andModifyDateNotBetween(Date value1, Date value2) {
      addCriterion("modify_date not between", value1, value2, "modifyDate");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andFreezeDateIsNull() {
      addCriterion("freeze_date is null");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andFreezeDateIsNotNull() {
      addCriterion("freeze_date is not null");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andFreezeDateEqualTo(Date value) {
      addCriterion("freeze_date =", value, "freezeDate");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andFreezeDateNotEqualTo(Date value) {
      addCriterion("freeze_date <>", value, "freezeDate");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andFreezeDateGreaterThan(Date value) {
      addCriterion("freeze_date >", value, "freezeDate");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andFreezeDateGreaterThanOrEqualTo(Date value) {
      addCriterion("freeze_date >=", value, "freezeDate");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andFreezeDateLessThan(Date value) {
      addCriterion("freeze_date <", value, "freezeDate");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andFreezeDateLessThanOrEqualTo(Date value) {
      addCriterion("freeze_date <=", value, "freezeDate");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andFreezeDateIn(List<Date> values) {
      addCriterion("freeze_date in", values, "freezeDate");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andFreezeDateNotIn(List<Date> values) {
      addCriterion("freeze_date not in", values, "freezeDate");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andFreezeDateBetween(Date value1, Date value2) {
      addCriterion("freeze_date between", value1, value2, "freezeDate");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andFreezeDateNotBetween(Date value1, Date value2) {
      addCriterion("freeze_date not between", value1, value2, "freezeDate");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andUpdateDateIsNull() {
      addCriterion("update_date is null");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andUpdateDateIsNotNull() {
      addCriterion("update_date is not null");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andUpdateDateEqualTo(Date value) {
      addCriterion("update_date =", value, "updateDate");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andUpdateDateNotEqualTo(Date value) {
      addCriterion("update_date <>", value, "updateDate");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andUpdateDateGreaterThan(Date value) {
      addCriterion("update_date >", value, "updateDate");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andUpdateDateGreaterThanOrEqualTo(Date value) {
      addCriterion("update_date >=", value, "updateDate");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andUpdateDateLessThan(Date value) {
      addCriterion("update_date <", value, "updateDate");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andUpdateDateLessThanOrEqualTo(Date value) {
      addCriterion("update_date <=", value, "updateDate");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andUpdateDateIn(List<Date> values) {
      addCriterion("update_date in", values, "updateDate");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andUpdateDateNotIn(List<Date> values) {
      addCriterion("update_date not in", values, "updateDate");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andUpdateDateBetween(Date value1, Date value2) {
      addCriterion("update_date between", value1, value2, "updateDate");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andUpdateDateNotBetween(Date value1, Date value2) {
      addCriterion("update_date not between", value1, value2, "updateDate");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andMembertypeIsNull() {
      addCriterion("memberType is null");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andMembertypeIsNotNull() {
      addCriterion("memberType is not null");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andMembertypeEqualTo(Integer value) {
      addCriterion("memberType =", value, "membertype");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andMembertypeNotEqualTo(Integer value) {
      addCriterion("memberType <>", value, "membertype");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andMembertypeGreaterThan(Integer value) {
      addCriterion("memberType >", value, "membertype");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andMembertypeGreaterThanOrEqualTo(Integer value) {
      addCriterion("memberType >=", value, "membertype");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andMembertypeLessThan(Integer value) {
      addCriterion("memberType <", value, "membertype");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andMembertypeLessThanOrEqualTo(Integer value) {
      addCriterion("memberType <=", value, "membertype");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andMembertypeIn(List<Integer> values) {
      addCriterion("memberType in", values, "membertype");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andMembertypeNotIn(List<Integer> values) {
      addCriterion("memberType not in", values, "membertype");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andMembertypeBetween(Integer value1, Integer value2) {
      addCriterion("memberType between", value1, value2, "membertype");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andMembertypeNotBetween(Integer value1, Integer value2) {
      addCriterion("memberType not between", value1, value2, "membertype");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andRemarkIsNull() {
      addCriterion("remark is null");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andRemarkIsNotNull() {
      addCriterion("remark is not null");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andRemarkEqualTo(String value) {
      addCriterion("remark =", value, "remark");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andRemarkNotEqualTo(String value) {
      addCriterion("remark <>", value, "remark");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andRemarkGreaterThan(String value) {
      addCriterion("remark >", value, "remark");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andRemarkGreaterThanOrEqualTo(String value) {
      addCriterion("remark >=", value, "remark");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andRemarkLessThan(String value) {
      addCriterion("remark <", value, "remark");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andRemarkLessThanOrEqualTo(String value) {
      addCriterion("remark <=", value, "remark");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andRemarkLike(String value) {
      addCriterion("remark like", value, "remark");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andRemarkNotLike(String value) {
      addCriterion("remark not like", value, "remark");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andRemarkIn(List<String> values) {
      addCriterion("remark in", values, "remark");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andRemarkNotIn(List<String> values) {
      addCriterion("remark not in", values, "remark");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andRemarkBetween(String value1, String value2) {
      addCriterion("remark between", value1, value2, "remark");
      return ((PlatformAcctExample.Criteria)this);
    }

    public PlatformAcctExample.Criteria andRemarkNotBetween(String value1, String value2) {
      addCriterion("remark not between", value1, value2, "remark");
      return ((PlatformAcctExample.Criteria)this);
    }
  }
}