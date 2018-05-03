package com.zjgt.p2p.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MemberAcctExample
{
  protected String orderByClause;
  protected boolean distinct;
  protected List<Criteria> oredCriteria;

  public MemberAcctExample()
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

  public static class Criteria extends MemberAcctExample.GeneratedCriteria
  {
  }

  protected static abstract class GeneratedCriteria
  {
    protected List<MemberAcctExample.Criterion> criteria;

    protected GeneratedCriteria()
    {
      this.criteria = new ArrayList();
    }

    public boolean isValid() {
      return (this.criteria.size() > 0);
    }

    public List<MemberAcctExample.Criterion> getAllCriteria() {
      return this.criteria;
    }

    public List<MemberAcctExample.Criterion> getCriteria() {
      return this.criteria;
    }

    protected void addCriterion(String condition) {
      if (condition == null) {
        throw new RuntimeException("Value for condition cannot be null");
      }
      this.criteria.add(new MemberAcctExample.Criterion(condition));
    }

    protected void addCriterion(String condition, Object value, String property) {
      if (value == null) {
        throw new RuntimeException("Value for " + property + " cannot be null");
      }
      this.criteria.add(new MemberAcctExample.Criterion(condition, value));
    }

    protected void addCriterion(String condition, Object value1, Object value2, String property) {
      if ((value1 == null) || (value2 == null)) {
        throw new RuntimeException("Between values for " + property + " cannot be null");
      }
      this.criteria.add(new MemberAcctExample.Criterion(condition, value1, value2));
    }

    public MemberAcctExample.Criteria andMemberAcctidIsNull() {
      addCriterion("member_acctid is null");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andMemberAcctidIsNotNull() {
      addCriterion("member_acctid is not null");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andMemberAcctidEqualTo(Long value) {
      addCriterion("member_acctid =", value, "memberAcctid");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andMemberAcctidNotEqualTo(Long value) {
      addCriterion("member_acctid <>", value, "memberAcctid");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andMemberAcctidGreaterThan(Long value) {
      addCriterion("member_acctid >", value, "memberAcctid");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andMemberAcctidGreaterThanOrEqualTo(Long value) {
      addCriterion("member_acctid >=", value, "memberAcctid");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andMemberAcctidLessThan(Long value) {
      addCriterion("member_acctid <", value, "memberAcctid");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andMemberAcctidLessThanOrEqualTo(Long value) {
      addCriterion("member_acctid <=", value, "memberAcctid");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andMemberAcctidIn(List<Long> values) {
      addCriterion("member_acctid in", values, "memberAcctid");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andMemberAcctidNotIn(List<Long> values) {
      addCriterion("member_acctid not in", values, "memberAcctid");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andMemberAcctidBetween(Long value1, Long value2) {
      addCriterion("member_acctid between", value1, value2, "memberAcctid");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andMemberAcctidNotBetween(Long value1, Long value2) {
      addCriterion("member_acctid not between", value1, value2, "memberAcctid");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andMemberidIsNull() {
      addCriterion("memberid is null");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andMemberidIsNotNull() {
      addCriterion("memberid is not null");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andMemberidEqualTo(Long value) {
      addCriterion("memberid =", value, "memberid");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andMemberidNotEqualTo(Long value) {
      addCriterion("memberid <>", value, "memberid");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andMemberidGreaterThan(Long value) {
      addCriterion("memberid >", value, "memberid");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andMemberidGreaterThanOrEqualTo(Long value) {
      addCriterion("memberid >=", value, "memberid");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andMemberidLessThan(Long value) {
      addCriterion("memberid <", value, "memberid");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andMemberidLessThanOrEqualTo(Long value) {
      addCriterion("memberid <=", value, "memberid");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andMemberidIn(List<Long> values) {
      addCriterion("memberid in", values, "memberid");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andMemberidNotIn(List<Long> values) {
      addCriterion("memberid not in", values, "memberid");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andMemberidBetween(Long value1, Long value2) {
      addCriterion("memberid between", value1, value2, "memberid");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andMemberidNotBetween(Long value1, Long value2) {
      addCriterion("memberid not between", value1, value2, "memberid");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andCreateDateIsNull() {
      addCriterion("create_date is null");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andCreateDateIsNotNull() {
      addCriterion("create_date is not null");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andCreateDateEqualTo(Date value) {
      addCriterion("create_date =", value, "createDate");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andCreateDateNotEqualTo(Date value) {
      addCriterion("create_date <>", value, "createDate");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andCreateDateGreaterThan(Date value) {
      addCriterion("create_date >", value, "createDate");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
      addCriterion("create_date >=", value, "createDate");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andCreateDateLessThan(Date value) {
      addCriterion("create_date <", value, "createDate");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andCreateDateLessThanOrEqualTo(Date value) {
      addCriterion("create_date <=", value, "createDate");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andCreateDateIn(List<Date> values) {
      addCriterion("create_date in", values, "createDate");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andCreateDateNotIn(List<Date> values) {
      addCriterion("create_date not in", values, "createDate");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andCreateDateBetween(Date value1, Date value2) {
      addCriterion("create_date between", value1, value2, "createDate");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andCreateDateNotBetween(Date value1, Date value2) {
      addCriterion("create_date not between", value1, value2, "createDate");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andAcctTypeIsNull() {
      addCriterion("acct_type is null");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andAcctTypeIsNotNull() {
      addCriterion("acct_type is not null");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andAcctTypeEqualTo(Integer value) {
      addCriterion("acct_type =", value, "acctType");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andAcctTypeNotEqualTo(Integer value) {
      addCriterion("acct_type <>", value, "acctType");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andAcctTypeGreaterThan(Integer value) {
      addCriterion("acct_type >", value, "acctType");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andAcctTypeGreaterThanOrEqualTo(Integer value) {
      addCriterion("acct_type >=", value, "acctType");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andAcctTypeLessThan(Integer value) {
      addCriterion("acct_type <", value, "acctType");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andAcctTypeLessThanOrEqualTo(Integer value) {
      addCriterion("acct_type <=", value, "acctType");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andAcctTypeIn(List<Integer> values) {
      addCriterion("acct_type in", values, "acctType");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andAcctTypeNotIn(List<Integer> values) {
      addCriterion("acct_type not in", values, "acctType");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andAcctTypeBetween(Integer value1, Integer value2) {
      addCriterion("acct_type between", value1, value2, "acctType");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andAcctTypeNotBetween(Integer value1, Integer value2) {
      addCriterion("acct_type not between", value1, value2, "acctType");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andAcctNameIsNull() {
      addCriterion("acct_name is null");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andAcctNameIsNotNull() {
      addCriterion("acct_name is not null");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andAcctNameEqualTo(String value) {
      addCriterion("acct_name =", value, "acctName");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andAcctNameNotEqualTo(String value) {
      addCriterion("acct_name <>", value, "acctName");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andAcctNameGreaterThan(String value) {
      addCriterion("acct_name >", value, "acctName");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andAcctNameGreaterThanOrEqualTo(String value) {
      addCriterion("acct_name >=", value, "acctName");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andAcctNameLessThan(String value) {
      addCriterion("acct_name <", value, "acctName");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andAcctNameLessThanOrEqualTo(String value) {
      addCriterion("acct_name <=", value, "acctName");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andAcctNameLike(String value) {
      addCriterion("acct_name like", value, "acctName");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andAcctNameNotLike(String value) {
      addCriterion("acct_name not like", value, "acctName");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andAcctNameIn(List<String> values) {
      addCriterion("acct_name in", values, "acctName");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andAcctNameNotIn(List<String> values) {
      addCriterion("acct_name not in", values, "acctName");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andAcctNameBetween(String value1, String value2) {
      addCriterion("acct_name between", value1, value2, "acctName");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andAcctNameNotBetween(String value1, String value2) {
      addCriterion("acct_name not between", value1, value2, "acctName");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andAccountIsNull() {
      addCriterion("account is null");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andAccountIsNotNull() {
      addCriterion("account is not null");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andAccountEqualTo(BigDecimal value) {
      addCriterion("account =", value, "account");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andAccountNotEqualTo(BigDecimal value) {
      addCriterion("account <>", value, "account");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andAccountGreaterThan(BigDecimal value) {
      addCriterion("account >", value, "account");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andAccountGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("account >=", value, "account");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andAccountLessThan(BigDecimal value) {
      addCriterion("account <", value, "account");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andAccountLessThanOrEqualTo(BigDecimal value) {
      addCriterion("account <=", value, "account");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andAccountIn(List<BigDecimal> values) {
      addCriterion("account in", values, "account");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andAccountNotIn(List<BigDecimal> values) {
      addCriterion("account not in", values, "account");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andAccountBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("account between", value1, value2, "account");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andAccountNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("account not between", value1, value2, "account");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andBlanceIsNull() {
      addCriterion("blance is null");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andBlanceIsNotNull() {
      addCriterion("blance is not null");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andBlanceEqualTo(BigDecimal value) {
      addCriterion("blance =", value, "blance");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andBlanceNotEqualTo(BigDecimal value) {
      addCriterion("blance <>", value, "blance");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andBlanceGreaterThan(BigDecimal value) {
      addCriterion("blance >", value, "blance");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andBlanceGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("blance >=", value, "blance");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andBlanceLessThan(BigDecimal value) {
      addCriterion("blance <", value, "blance");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andBlanceLessThanOrEqualTo(BigDecimal value) {
      addCriterion("blance <=", value, "blance");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andBlanceIn(List<BigDecimal> values) {
      addCriterion("blance in", values, "blance");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andBlanceNotIn(List<BigDecimal> values) {
      addCriterion("blance not in", values, "blance");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andBlanceBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("blance between", value1, value2, "blance");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andBlanceNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("blance not between", value1, value2, "blance");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andFreezeBlanceIsNull() {
      addCriterion("freeze_blance is null");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andFreezeBlanceIsNotNull() {
      addCriterion("freeze_blance is not null");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andFreezeBlanceEqualTo(BigDecimal value) {
      addCriterion("freeze_blance =", value, "freezeBlance");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andFreezeBlanceNotEqualTo(BigDecimal value) {
      addCriterion("freeze_blance <>", value, "freezeBlance");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andFreezeBlanceGreaterThan(BigDecimal value) {
      addCriterion("freeze_blance >", value, "freezeBlance");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andFreezeBlanceGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("freeze_blance >=", value, "freezeBlance");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andFreezeBlanceLessThan(BigDecimal value) {
      addCriterion("freeze_blance <", value, "freezeBlance");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andFreezeBlanceLessThanOrEqualTo(BigDecimal value) {
      addCriterion("freeze_blance <=", value, "freezeBlance");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andFreezeBlanceIn(List<BigDecimal> values) {
      addCriterion("freeze_blance in", values, "freezeBlance");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andFreezeBlanceNotIn(List<BigDecimal> values) {
      addCriterion("freeze_blance not in", values, "freezeBlance");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andFreezeBlanceBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("freeze_blance between", value1, value2, "freezeBlance");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andFreezeBlanceNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("freeze_blance not between", value1, value2, "freezeBlance");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andMembertypeIsNull() {
      addCriterion("memberType is null");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andMembertypeIsNotNull() {
      addCriterion("memberType is not null");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andMembertypeEqualTo(Integer value) {
      addCriterion("memberType =", value, "membertype");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andMembertypeNotEqualTo(Integer value) {
      addCriterion("memberType <>", value, "membertype");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andMembertypeGreaterThan(Integer value) {
      addCriterion("memberType >", value, "membertype");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andMembertypeGreaterThanOrEqualTo(Integer value) {
      addCriterion("memberType >=", value, "membertype");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andMembertypeLessThan(Integer value) {
      addCriterion("memberType <", value, "membertype");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andMembertypeLessThanOrEqualTo(Integer value) {
      addCriterion("memberType <=", value, "membertype");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andMembertypeIn(List<Integer> values) {
      addCriterion("memberType in", values, "membertype");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andMembertypeNotIn(List<Integer> values) {
      addCriterion("memberType not in", values, "membertype");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andMembertypeBetween(Integer value1, Integer value2) {
      addCriterion("memberType between", value1, value2, "membertype");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andMembertypeNotBetween(Integer value1, Integer value2) {
      addCriterion("memberType not between", value1, value2, "membertype");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andModifyDateIsNull() {
      addCriterion("modify_date is null");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andModifyDateIsNotNull() {
      addCriterion("modify_date is not null");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andModifyDateEqualTo(Date value) {
      addCriterion("modify_date =", value, "modifyDate");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andModifyDateNotEqualTo(Date value) {
      addCriterion("modify_date <>", value, "modifyDate");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andModifyDateGreaterThan(Date value) {
      addCriterion("modify_date >", value, "modifyDate");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andModifyDateGreaterThanOrEqualTo(Date value) {
      addCriterion("modify_date >=", value, "modifyDate");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andModifyDateLessThan(Date value) {
      addCriterion("modify_date <", value, "modifyDate");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andModifyDateLessThanOrEqualTo(Date value) {
      addCriterion("modify_date <=", value, "modifyDate");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andModifyDateIn(List<Date> values) {
      addCriterion("modify_date in", values, "modifyDate");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andModifyDateNotIn(List<Date> values) {
      addCriterion("modify_date not in", values, "modifyDate");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andModifyDateBetween(Date value1, Date value2) {
      addCriterion("modify_date between", value1, value2, "modifyDate");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andModifyDateNotBetween(Date value1, Date value2) {
      addCriterion("modify_date not between", value1, value2, "modifyDate");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andFreezeDateIsNull() {
      addCriterion("freeze_date is null");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andFreezeDateIsNotNull() {
      addCriterion("freeze_date is not null");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andFreezeDateEqualTo(Date value) {
      addCriterion("freeze_date =", value, "freezeDate");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andFreezeDateNotEqualTo(Date value) {
      addCriterion("freeze_date <>", value, "freezeDate");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andFreezeDateGreaterThan(Date value) {
      addCriterion("freeze_date >", value, "freezeDate");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andFreezeDateGreaterThanOrEqualTo(Date value) {
      addCriterion("freeze_date >=", value, "freezeDate");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andFreezeDateLessThan(Date value) {
      addCriterion("freeze_date <", value, "freezeDate");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andFreezeDateLessThanOrEqualTo(Date value) {
      addCriterion("freeze_date <=", value, "freezeDate");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andFreezeDateIn(List<Date> values) {
      addCriterion("freeze_date in", values, "freezeDate");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andFreezeDateNotIn(List<Date> values) {
      addCriterion("freeze_date not in", values, "freezeDate");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andFreezeDateBetween(Date value1, Date value2) {
      addCriterion("freeze_date between", value1, value2, "freezeDate");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andFreezeDateNotBetween(Date value1, Date value2) {
      addCriterion("freeze_date not between", value1, value2, "freezeDate");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andUpdateDateIsNull() {
      addCriterion("update_date is null");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andUpdateDateIsNotNull() {
      addCriterion("update_date is not null");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andUpdateDateEqualTo(Date value) {
      addCriterion("update_date =", value, "updateDate");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andUpdateDateNotEqualTo(Date value) {
      addCriterion("update_date <>", value, "updateDate");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andUpdateDateGreaterThan(Date value) {
      addCriterion("update_date >", value, "updateDate");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andUpdateDateGreaterThanOrEqualTo(Date value) {
      addCriterion("update_date >=", value, "updateDate");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andUpdateDateLessThan(Date value) {
      addCriterion("update_date <", value, "updateDate");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andUpdateDateLessThanOrEqualTo(Date value) {
      addCriterion("update_date <=", value, "updateDate");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andUpdateDateIn(List<Date> values) {
      addCriterion("update_date in", values, "updateDate");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andUpdateDateNotIn(List<Date> values) {
      addCriterion("update_date not in", values, "updateDate");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andUpdateDateBetween(Date value1, Date value2) {
      addCriterion("update_date between", value1, value2, "updateDate");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andUpdateDateNotBetween(Date value1, Date value2) {
      addCriterion("update_date not between", value1, value2, "updateDate");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andRemarkIsNull() {
      addCriterion("remark is null");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andRemarkIsNotNull() {
      addCriterion("remark is not null");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andRemarkEqualTo(String value) {
      addCriterion("remark =", value, "remark");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andRemarkNotEqualTo(String value) {
      addCriterion("remark <>", value, "remark");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andRemarkGreaterThan(String value) {
      addCriterion("remark >", value, "remark");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andRemarkGreaterThanOrEqualTo(String value) {
      addCriterion("remark >=", value, "remark");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andRemarkLessThan(String value) {
      addCriterion("remark <", value, "remark");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andRemarkLessThanOrEqualTo(String value) {
      addCriterion("remark <=", value, "remark");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andRemarkLike(String value) {
      addCriterion("remark like", value, "remark");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andRemarkNotLike(String value) {
      addCriterion("remark not like", value, "remark");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andRemarkIn(List<String> values) {
      addCriterion("remark in", values, "remark");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andRemarkNotIn(List<String> values) {
      addCriterion("remark not in", values, "remark");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andRemarkBetween(String value1, String value2) {
      addCriterion("remark between", value1, value2, "remark");
      return ((MemberAcctExample.Criteria)this);
    }

    public MemberAcctExample.Criteria andRemarkNotBetween(String value1, String value2) {
      addCriterion("remark not between", value1, value2, "remark");
      return ((MemberAcctExample.Criteria)this);
    }
  }
}