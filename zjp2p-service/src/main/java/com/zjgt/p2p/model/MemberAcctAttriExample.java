package com.zjgt.p2p.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MemberAcctAttriExample
{
  protected String orderByClause;
  protected boolean distinct;
  protected List<Criteria> oredCriteria;

  public MemberAcctAttriExample()
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

  public static class Criteria extends MemberAcctAttriExample.GeneratedCriteria
  {
  }

  protected static abstract class GeneratedCriteria
  {
    protected List<MemberAcctAttriExample.Criterion> criteria;

    protected GeneratedCriteria()
    {
      this.criteria = new ArrayList();
    }

    public boolean isValid() {
      return (this.criteria.size() > 0);
    }

    public List<MemberAcctAttriExample.Criterion> getAllCriteria() {
      return this.criteria;
    }

    public List<MemberAcctAttriExample.Criterion> getCriteria() {
      return this.criteria;
    }

    protected void addCriterion(String condition) {
      if (condition == null) {
        throw new RuntimeException("Value for condition cannot be null");
      }
      this.criteria.add(new MemberAcctAttriExample.Criterion(condition));
    }

    protected void addCriterion(String condition, Object value, String property) {
      if (value == null) {
        throw new RuntimeException("Value for " + property + " cannot be null");
      }
      this.criteria.add(new MemberAcctAttriExample.Criterion(condition, value));
    }

    protected void addCriterion(String condition, Object value1, Object value2, String property) {
      if ((value1 == null) || (value2 == null)) {
        throw new RuntimeException("Between values for " + property + " cannot be null");
      }
      this.criteria.add(new MemberAcctAttriExample.Criterion(condition, value1, value2));
    }

    public MemberAcctAttriExample.Criteria andCreateDateIsNull() {
      addCriterion("create_date is null");
      return ((MemberAcctAttriExample.Criteria)this);
    }

    public MemberAcctAttriExample.Criteria andCreateDateIsNotNull() {
      addCriterion("create_date is not null");
      return ((MemberAcctAttriExample.Criteria)this);
    }

    public MemberAcctAttriExample.Criteria andCreateDateEqualTo(Date value) {
      addCriterion("create_date =", value, "createDate");
      return ((MemberAcctAttriExample.Criteria)this);
    }

    public MemberAcctAttriExample.Criteria andCreateDateNotEqualTo(Date value) {
      addCriterion("create_date <>", value, "createDate");
      return ((MemberAcctAttriExample.Criteria)this);
    }

    public MemberAcctAttriExample.Criteria andCreateDateGreaterThan(Date value) {
      addCriterion("create_date >", value, "createDate");
      return ((MemberAcctAttriExample.Criteria)this);
    }

    public MemberAcctAttriExample.Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
      addCriterion("create_date >=", value, "createDate");
      return ((MemberAcctAttriExample.Criteria)this);
    }

    public MemberAcctAttriExample.Criteria andCreateDateLessThan(Date value) {
      addCriterion("create_date <", value, "createDate");
      return ((MemberAcctAttriExample.Criteria)this);
    }

    public MemberAcctAttriExample.Criteria andCreateDateLessThanOrEqualTo(Date value) {
      addCriterion("create_date <=", value, "createDate");
      return ((MemberAcctAttriExample.Criteria)this);
    }

    public MemberAcctAttriExample.Criteria andCreateDateIn(List<Date> values) {
      addCriterion("create_date in", values, "createDate");
      return ((MemberAcctAttriExample.Criteria)this);
    }

    public MemberAcctAttriExample.Criteria andCreateDateNotIn(List<Date> values) {
      addCriterion("create_date not in", values, "createDate");
      return ((MemberAcctAttriExample.Criteria)this);
    }

    public MemberAcctAttriExample.Criteria andCreateDateBetween(Date value1, Date value2) {
      addCriterion("create_date between", value1, value2, "createDate");
      return ((MemberAcctAttriExample.Criteria)this);
    }

    public MemberAcctAttriExample.Criteria andCreateDateNotBetween(Date value1, Date value2) {
      addCriterion("create_date not between", value1, value2, "createDate");
      return ((MemberAcctAttriExample.Criteria)this);
    }

    public MemberAcctAttriExample.Criteria andMemberidIsNull() {
      addCriterion("memberid is null");
      return ((MemberAcctAttriExample.Criteria)this);
    }

    public MemberAcctAttriExample.Criteria andMemberidIsNotNull() {
      addCriterion("memberid is not null");
      return ((MemberAcctAttriExample.Criteria)this);
    }

    public MemberAcctAttriExample.Criteria andMemberidEqualTo(Long value) {
      addCriterion("memberid =", value, "memberid");
      return ((MemberAcctAttriExample.Criteria)this);
    }

    public MemberAcctAttriExample.Criteria andMemberidNotEqualTo(Long value) {
      addCriterion("memberid <>", value, "memberid");
      return ((MemberAcctAttriExample.Criteria)this);
    }

    public MemberAcctAttriExample.Criteria andMemberidGreaterThan(Long value) {
      addCriterion("memberid >", value, "memberid");
      return ((MemberAcctAttriExample.Criteria)this);
    }

    public MemberAcctAttriExample.Criteria andMemberidGreaterThanOrEqualTo(Long value) {
      addCriterion("memberid >=", value, "memberid");
      return ((MemberAcctAttriExample.Criteria)this);
    }

    public MemberAcctAttriExample.Criteria andMemberidLessThan(Long value) {
      addCriterion("memberid <", value, "memberid");
      return ((MemberAcctAttriExample.Criteria)this);
    }

    public MemberAcctAttriExample.Criteria andMemberidLessThanOrEqualTo(Long value) {
      addCriterion("memberid <=", value, "memberid");
      return ((MemberAcctAttriExample.Criteria)this);
    }

    public MemberAcctAttriExample.Criteria andMemberidIn(List<Long> values) {
      addCriterion("memberid in", values, "memberid");
      return ((MemberAcctAttriExample.Criteria)this);
    }

    public MemberAcctAttriExample.Criteria andMemberidNotIn(List<Long> values) {
      addCriterion("memberid not in", values, "memberid");
      return ((MemberAcctAttriExample.Criteria)this);
    }

    public MemberAcctAttriExample.Criteria andMemberidBetween(Long value1, Long value2) {
      addCriterion("memberid between", value1, value2, "memberid");
      return ((MemberAcctAttriExample.Criteria)this);
    }

    public MemberAcctAttriExample.Criteria andMemberidNotBetween(Long value1, Long value2) {
      addCriterion("memberid not between", value1, value2, "memberid");
      return ((MemberAcctAttriExample.Criteria)this);
    }

    public MemberAcctAttriExample.Criteria andCapitalStatusIsNull() {
      addCriterion("capital_status is null");
      return ((MemberAcctAttriExample.Criteria)this);
    }

    public MemberAcctAttriExample.Criteria andCapitalStatusIsNotNull() {
      addCriterion("capital_status is not null");
      return ((MemberAcctAttriExample.Criteria)this);
    }

    public MemberAcctAttriExample.Criteria andCapitalStatusEqualTo(Integer value) {
      addCriterion("capital_status =", value, "capitalStatus");
      return ((MemberAcctAttriExample.Criteria)this);
    }

    public MemberAcctAttriExample.Criteria andCapitalStatusNotEqualTo(Integer value) {
      addCriterion("capital_status <>", value, "capitalStatus");
      return ((MemberAcctAttriExample.Criteria)this);
    }

    public MemberAcctAttriExample.Criteria andCapitalStatusGreaterThan(Integer value) {
      addCriterion("capital_status >", value, "capitalStatus");
      return ((MemberAcctAttriExample.Criteria)this);
    }

    public MemberAcctAttriExample.Criteria andCapitalStatusGreaterThanOrEqualTo(Integer value) {
      addCriterion("capital_status >=", value, "capitalStatus");
      return ((MemberAcctAttriExample.Criteria)this);
    }

    public MemberAcctAttriExample.Criteria andCapitalStatusLessThan(Integer value) {
      addCriterion("capital_status <", value, "capitalStatus");
      return ((MemberAcctAttriExample.Criteria)this);
    }

    public MemberAcctAttriExample.Criteria andCapitalStatusLessThanOrEqualTo(Integer value) {
      addCriterion("capital_status <=", value, "capitalStatus");
      return ((MemberAcctAttriExample.Criteria)this);
    }

    public MemberAcctAttriExample.Criteria andCapitalStatusIn(List<Integer> values) {
      addCriterion("capital_status in", values, "capitalStatus");
      return ((MemberAcctAttriExample.Criteria)this);
    }

    public MemberAcctAttriExample.Criteria andCapitalStatusNotIn(List<Integer> values) {
      addCriterion("capital_status not in", values, "capitalStatus");
      return ((MemberAcctAttriExample.Criteria)this);
    }

    public MemberAcctAttriExample.Criteria andCapitalStatusBetween(Integer value1, Integer value2) {
      addCriterion("capital_status between", value1, value2, "capitalStatus");
      return ((MemberAcctAttriExample.Criteria)this);
    }

    public MemberAcctAttriExample.Criteria andCapitalStatusNotBetween(Integer value1, Integer value2) {
      addCriterion("capital_status not between", value1, value2, "capitalStatus");
      return ((MemberAcctAttriExample.Criteria)this);
    }

    public MemberAcctAttriExample.Criteria andWithdrawStatusIsNull() {
      addCriterion("withdraw_status is null");
      return ((MemberAcctAttriExample.Criteria)this);
    }

    public MemberAcctAttriExample.Criteria andWithdrawStatusIsNotNull() {
      addCriterion("withdraw_status is not null");
      return ((MemberAcctAttriExample.Criteria)this);
    }

    public MemberAcctAttriExample.Criteria andWithdrawStatusEqualTo(Integer value) {
      addCriterion("withdraw_status =", value, "withdrawStatus");
      return ((MemberAcctAttriExample.Criteria)this);
    }

    public MemberAcctAttriExample.Criteria andWithdrawStatusNotEqualTo(Integer value) {
      addCriterion("withdraw_status <>", value, "withdrawStatus");
      return ((MemberAcctAttriExample.Criteria)this);
    }

    public MemberAcctAttriExample.Criteria andWithdrawStatusGreaterThan(Integer value) {
      addCriterion("withdraw_status >", value, "withdrawStatus");
      return ((MemberAcctAttriExample.Criteria)this);
    }

    public MemberAcctAttriExample.Criteria andWithdrawStatusGreaterThanOrEqualTo(Integer value) {
      addCriterion("withdraw_status >=", value, "withdrawStatus");
      return ((MemberAcctAttriExample.Criteria)this);
    }

    public MemberAcctAttriExample.Criteria andWithdrawStatusLessThan(Integer value) {
      addCriterion("withdraw_status <", value, "withdrawStatus");
      return ((MemberAcctAttriExample.Criteria)this);
    }

    public MemberAcctAttriExample.Criteria andWithdrawStatusLessThanOrEqualTo(Integer value) {
      addCriterion("withdraw_status <=", value, "withdrawStatus");
      return ((MemberAcctAttriExample.Criteria)this);
    }

    public MemberAcctAttriExample.Criteria andWithdrawStatusIn(List<Integer> values) {
      addCriterion("withdraw_status in", values, "withdrawStatus");
      return ((MemberAcctAttriExample.Criteria)this);
    }

    public MemberAcctAttriExample.Criteria andWithdrawStatusNotIn(List<Integer> values) {
      addCriterion("withdraw_status not in", values, "withdrawStatus");
      return ((MemberAcctAttriExample.Criteria)this);
    }

    public MemberAcctAttriExample.Criteria andWithdrawStatusBetween(Integer value1, Integer value2) {
      addCriterion("withdraw_status between", value1, value2, "withdrawStatus");
      return ((MemberAcctAttriExample.Criteria)this);
    }

    public MemberAcctAttriExample.Criteria andWithdrawStatusNotBetween(Integer value1, Integer value2) {
      addCriterion("withdraw_status not between", value1, value2, "withdrawStatus");
      return ((MemberAcctAttriExample.Criteria)this);
    }

    public MemberAcctAttriExample.Criteria andOperUserIsNull() {
      addCriterion("oper_user is null");
      return ((MemberAcctAttriExample.Criteria)this);
    }

    public MemberAcctAttriExample.Criteria andOperUserIsNotNull() {
      addCriterion("oper_user is not null");
      return ((MemberAcctAttriExample.Criteria)this);
    }

    public MemberAcctAttriExample.Criteria andOperUserEqualTo(String value) {
      addCriterion("oper_user =", value, "operUser");
      return ((MemberAcctAttriExample.Criteria)this);
    }

    public MemberAcctAttriExample.Criteria andOperUserNotEqualTo(String value) {
      addCriterion("oper_user <>", value, "operUser");
      return ((MemberAcctAttriExample.Criteria)this);
    }

    public MemberAcctAttriExample.Criteria andOperUserGreaterThan(String value) {
      addCriterion("oper_user >", value, "operUser");
      return ((MemberAcctAttriExample.Criteria)this);
    }

    public MemberAcctAttriExample.Criteria andOperUserGreaterThanOrEqualTo(String value) {
      addCriterion("oper_user >=", value, "operUser");
      return ((MemberAcctAttriExample.Criteria)this);
    }

    public MemberAcctAttriExample.Criteria andOperUserLessThan(String value) {
      addCriterion("oper_user <", value, "operUser");
      return ((MemberAcctAttriExample.Criteria)this);
    }

    public MemberAcctAttriExample.Criteria andOperUserLessThanOrEqualTo(String value) {
      addCriterion("oper_user <=", value, "operUser");
      return ((MemberAcctAttriExample.Criteria)this);
    }

    public MemberAcctAttriExample.Criteria andOperUserLike(String value) {
      addCriterion("oper_user like", value, "operUser");
      return ((MemberAcctAttriExample.Criteria)this);
    }

    public MemberAcctAttriExample.Criteria andOperUserNotLike(String value) {
      addCriterion("oper_user not like", value, "operUser");
      return ((MemberAcctAttriExample.Criteria)this);
    }

    public MemberAcctAttriExample.Criteria andOperUserIn(List<String> values) {
      addCriterion("oper_user in", values, "operUser");
      return ((MemberAcctAttriExample.Criteria)this);
    }

    public MemberAcctAttriExample.Criteria andOperUserNotIn(List<String> values) {
      addCriterion("oper_user not in", values, "operUser");
      return ((MemberAcctAttriExample.Criteria)this);
    }

    public MemberAcctAttriExample.Criteria andOperUserBetween(String value1, String value2) {
      addCriterion("oper_user between", value1, value2, "operUser");
      return ((MemberAcctAttriExample.Criteria)this);
    }

    public MemberAcctAttriExample.Criteria andOperUserNotBetween(String value1, String value2) {
      addCriterion("oper_user not between", value1, value2, "operUser");
      return ((MemberAcctAttriExample.Criteria)this);
    }

    public MemberAcctAttriExample.Criteria andOperDateIsNull() {
      addCriterion("oper_date is null");
      return ((MemberAcctAttriExample.Criteria)this);
    }

    public MemberAcctAttriExample.Criteria andOperDateIsNotNull() {
      addCriterion("oper_date is not null");
      return ((MemberAcctAttriExample.Criteria)this);
    }

    public MemberAcctAttriExample.Criteria andOperDateEqualTo(Date value) {
      addCriterion("oper_date =", value, "operDate");
      return ((MemberAcctAttriExample.Criteria)this);
    }

    public MemberAcctAttriExample.Criteria andOperDateNotEqualTo(Date value) {
      addCriterion("oper_date <>", value, "operDate");
      return ((MemberAcctAttriExample.Criteria)this);
    }

    public MemberAcctAttriExample.Criteria andOperDateGreaterThan(Date value) {
      addCriterion("oper_date >", value, "operDate");
      return ((MemberAcctAttriExample.Criteria)this);
    }

    public MemberAcctAttriExample.Criteria andOperDateGreaterThanOrEqualTo(Date value) {
      addCriterion("oper_date >=", value, "operDate");
      return ((MemberAcctAttriExample.Criteria)this);
    }

    public MemberAcctAttriExample.Criteria andOperDateLessThan(Date value) {
      addCriterion("oper_date <", value, "operDate");
      return ((MemberAcctAttriExample.Criteria)this);
    }

    public MemberAcctAttriExample.Criteria andOperDateLessThanOrEqualTo(Date value) {
      addCriterion("oper_date <=", value, "operDate");
      return ((MemberAcctAttriExample.Criteria)this);
    }

    public MemberAcctAttriExample.Criteria andOperDateIn(List<Date> values) {
      addCriterion("oper_date in", values, "operDate");
      return ((MemberAcctAttriExample.Criteria)this);
    }

    public MemberAcctAttriExample.Criteria andOperDateNotIn(List<Date> values) {
      addCriterion("oper_date not in", values, "operDate");
      return ((MemberAcctAttriExample.Criteria)this);
    }

    public MemberAcctAttriExample.Criteria andOperDateBetween(Date value1, Date value2) {
      addCriterion("oper_date between", value1, value2, "operDate");
      return ((MemberAcctAttriExample.Criteria)this);
    }

    public MemberAcctAttriExample.Criteria andOperDateNotBetween(Date value1, Date value2) {
      addCriterion("oper_date not between", value1, value2, "operDate");
      return ((MemberAcctAttriExample.Criteria)this);
    }

    public MemberAcctAttriExample.Criteria andMemoIsNull() {
      addCriterion("memo is null");
      return ((MemberAcctAttriExample.Criteria)this);
    }

    public MemberAcctAttriExample.Criteria andMemoIsNotNull() {
      addCriterion("memo is not null");
      return ((MemberAcctAttriExample.Criteria)this);
    }

    public MemberAcctAttriExample.Criteria andMemoEqualTo(String value) {
      addCriterion("memo =", value, "memo");
      return ((MemberAcctAttriExample.Criteria)this);
    }

    public MemberAcctAttriExample.Criteria andMemoNotEqualTo(String value) {
      addCriterion("memo <>", value, "memo");
      return ((MemberAcctAttriExample.Criteria)this);
    }

    public MemberAcctAttriExample.Criteria andMemoGreaterThan(String value) {
      addCriterion("memo >", value, "memo");
      return ((MemberAcctAttriExample.Criteria)this);
    }

    public MemberAcctAttriExample.Criteria andMemoGreaterThanOrEqualTo(String value) {
      addCriterion("memo >=", value, "memo");
      return ((MemberAcctAttriExample.Criteria)this);
    }

    public MemberAcctAttriExample.Criteria andMemoLessThan(String value) {
      addCriterion("memo <", value, "memo");
      return ((MemberAcctAttriExample.Criteria)this);
    }

    public MemberAcctAttriExample.Criteria andMemoLessThanOrEqualTo(String value) {
      addCriterion("memo <=", value, "memo");
      return ((MemberAcctAttriExample.Criteria)this);
    }

    public MemberAcctAttriExample.Criteria andMemoLike(String value) {
      addCriterion("memo like", value, "memo");
      return ((MemberAcctAttriExample.Criteria)this);
    }

    public MemberAcctAttriExample.Criteria andMemoNotLike(String value) {
      addCriterion("memo not like", value, "memo");
      return ((MemberAcctAttriExample.Criteria)this);
    }

    public MemberAcctAttriExample.Criteria andMemoIn(List<String> values) {
      addCriterion("memo in", values, "memo");
      return ((MemberAcctAttriExample.Criteria)this);
    }

    public MemberAcctAttriExample.Criteria andMemoNotIn(List<String> values) {
      addCriterion("memo not in", values, "memo");
      return ((MemberAcctAttriExample.Criteria)this);
    }

    public MemberAcctAttriExample.Criteria andMemoBetween(String value1, String value2) {
      addCriterion("memo between", value1, value2, "memo");
      return ((MemberAcctAttriExample.Criteria)this);
    }

    public MemberAcctAttriExample.Criteria andMemoNotBetween(String value1, String value2) {
      addCriterion("memo not between", value1, value2, "memo");
      return ((MemberAcctAttriExample.Criteria)this);
    }

    public MemberAcctAttriExample.Criteria andUpdateDateIsNull() {
      addCriterion("update_date is null");
      return ((MemberAcctAttriExample.Criteria)this);
    }

    public MemberAcctAttriExample.Criteria andUpdateDateIsNotNull() {
      addCriterion("update_date is not null");
      return ((MemberAcctAttriExample.Criteria)this);
    }

    public MemberAcctAttriExample.Criteria andUpdateDateEqualTo(Date value) {
      addCriterion("update_date =", value, "updateDate");
      return ((MemberAcctAttriExample.Criteria)this);
    }

    public MemberAcctAttriExample.Criteria andUpdateDateNotEqualTo(Date value) {
      addCriterion("update_date <>", value, "updateDate");
      return ((MemberAcctAttriExample.Criteria)this);
    }

    public MemberAcctAttriExample.Criteria andUpdateDateGreaterThan(Date value) {
      addCriterion("update_date >", value, "updateDate");
      return ((MemberAcctAttriExample.Criteria)this);
    }

    public MemberAcctAttriExample.Criteria andUpdateDateGreaterThanOrEqualTo(Date value) {
      addCriterion("update_date >=", value, "updateDate");
      return ((MemberAcctAttriExample.Criteria)this);
    }

    public MemberAcctAttriExample.Criteria andUpdateDateLessThan(Date value) {
      addCriterion("update_date <", value, "updateDate");
      return ((MemberAcctAttriExample.Criteria)this);
    }

    public MemberAcctAttriExample.Criteria andUpdateDateLessThanOrEqualTo(Date value) {
      addCriterion("update_date <=", value, "updateDate");
      return ((MemberAcctAttriExample.Criteria)this);
    }

    public MemberAcctAttriExample.Criteria andUpdateDateIn(List<Date> values) {
      addCriterion("update_date in", values, "updateDate");
      return ((MemberAcctAttriExample.Criteria)this);
    }

    public MemberAcctAttriExample.Criteria andUpdateDateNotIn(List<Date> values) {
      addCriterion("update_date not in", values, "updateDate");
      return ((MemberAcctAttriExample.Criteria)this);
    }

    public MemberAcctAttriExample.Criteria andUpdateDateBetween(Date value1, Date value2) {
      addCriterion("update_date between", value1, value2, "updateDate");
      return ((MemberAcctAttriExample.Criteria)this);
    }

    public MemberAcctAttriExample.Criteria andUpdateDateNotBetween(Date value1, Date value2) {
      addCriterion("update_date not between", value1, value2, "updateDate");
      return ((MemberAcctAttriExample.Criteria)this);
    }
  }
}