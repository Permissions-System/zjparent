package com.zjgt.p2p.model;

import java.util.ArrayList;
import java.util.List;

public class MemberActPwdExample
{
  protected String orderByClause;
  protected boolean distinct;
  protected List<Criteria> oredCriteria;

  public MemberActPwdExample()
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

  public static class Criteria extends MemberActPwdExample.GeneratedCriteria
  {
  }

  protected static abstract class GeneratedCriteria
  {
    protected List<MemberActPwdExample.Criterion> criteria;

    protected GeneratedCriteria()
    {
      this.criteria = new ArrayList();
    }

    public boolean isValid() {
      return (this.criteria.size() > 0);
    }

    public List<MemberActPwdExample.Criterion> getAllCriteria() {
      return this.criteria;
    }

    public List<MemberActPwdExample.Criterion> getCriteria() {
      return this.criteria;
    }

    protected void addCriterion(String condition) {
      if (condition == null) {
        throw new RuntimeException("Value for condition cannot be null");
      }
      this.criteria.add(new MemberActPwdExample.Criterion(condition));
    }

    protected void addCriterion(String condition, Object value, String property) {
      if (value == null) {
        throw new RuntimeException("Value for " + property + " cannot be null");
      }
      this.criteria.add(new MemberActPwdExample.Criterion(condition, value));
    }

    protected void addCriterion(String condition, Object value1, Object value2, String property) {
      if ((value1 == null) || (value2 == null)) {
        throw new RuntimeException("Between values for " + property + " cannot be null");
      }
      this.criteria.add(new MemberActPwdExample.Criterion(condition, value1, value2));
    }

    public MemberActPwdExample.Criteria andIdIsNull() {
      addCriterion("ID is null");
      return ((MemberActPwdExample.Criteria)this);
    }

    public MemberActPwdExample.Criteria andIdIsNotNull() {
      addCriterion("ID is not null");
      return ((MemberActPwdExample.Criteria)this);
    }

    public MemberActPwdExample.Criteria andIdEqualTo(Integer value) {
      addCriterion("ID =", value, "id");
      return ((MemberActPwdExample.Criteria)this);
    }

    public MemberActPwdExample.Criteria andIdNotEqualTo(Integer value) {
      addCriterion("ID <>", value, "id");
      return ((MemberActPwdExample.Criteria)this);
    }

    public MemberActPwdExample.Criteria andIdGreaterThan(Integer value) {
      addCriterion("ID >", value, "id");
      return ((MemberActPwdExample.Criteria)this);
    }

    public MemberActPwdExample.Criteria andIdGreaterThanOrEqualTo(Integer value) {
      addCriterion("ID >=", value, "id");
      return ((MemberActPwdExample.Criteria)this);
    }

    public MemberActPwdExample.Criteria andIdLessThan(Integer value) {
      addCriterion("ID <", value, "id");
      return ((MemberActPwdExample.Criteria)this);
    }

    public MemberActPwdExample.Criteria andIdLessThanOrEqualTo(Integer value) {
      addCriterion("ID <=", value, "id");
      return ((MemberActPwdExample.Criteria)this);
    }

    public MemberActPwdExample.Criteria andIdIn(List<Integer> values) {
      addCriterion("ID in", values, "id");
      return ((MemberActPwdExample.Criteria)this);
    }

    public MemberActPwdExample.Criteria andIdNotIn(List<Integer> values) {
      addCriterion("ID not in", values, "id");
      return ((MemberActPwdExample.Criteria)this);
    }

    public MemberActPwdExample.Criteria andIdBetween(Integer value1, Integer value2) {
      addCriterion("ID between", value1, value2, "id");
      return ((MemberActPwdExample.Criteria)this);
    }

    public MemberActPwdExample.Criteria andIdNotBetween(Integer value1, Integer value2) {
      addCriterion("ID not between", value1, value2, "id");
      return ((MemberActPwdExample.Criteria)this);
    }

    public MemberActPwdExample.Criteria andMemberidIsNull() {
      addCriterion("memberId is null");
      return ((MemberActPwdExample.Criteria)this);
    }

    public MemberActPwdExample.Criteria andMemberidIsNotNull() {
      addCriterion("memberId is not null");
      return ((MemberActPwdExample.Criteria)this);
    }

    public MemberActPwdExample.Criteria andMemberidEqualTo(Integer value) {
      addCriterion("memberId =", value, "memberid");
      return ((MemberActPwdExample.Criteria)this);
    }

    public MemberActPwdExample.Criteria andMemberidNotEqualTo(Integer value) {
      addCriterion("memberId <>", value, "memberid");
      return ((MemberActPwdExample.Criteria)this);
    }

    public MemberActPwdExample.Criteria andMemberidGreaterThan(Integer value) {
      addCriterion("memberId >", value, "memberid");
      return ((MemberActPwdExample.Criteria)this);
    }

    public MemberActPwdExample.Criteria andMemberidGreaterThanOrEqualTo(Integer value) {
      addCriterion("memberId >=", value, "memberid");
      return ((MemberActPwdExample.Criteria)this);
    }

    public MemberActPwdExample.Criteria andMemberidLessThan(Integer value) {
      addCriterion("memberId <", value, "memberid");
      return ((MemberActPwdExample.Criteria)this);
    }

    public MemberActPwdExample.Criteria andMemberidLessThanOrEqualTo(Integer value) {
      addCriterion("memberId <=", value, "memberid");
      return ((MemberActPwdExample.Criteria)this);
    }

    public MemberActPwdExample.Criteria andMemberidIn(List<Integer> values) {
      addCriterion("memberId in", values, "memberid");
      return ((MemberActPwdExample.Criteria)this);
    }

    public MemberActPwdExample.Criteria andMemberidNotIn(List<Integer> values) {
      addCriterion("memberId not in", values, "memberid");
      return ((MemberActPwdExample.Criteria)this);
    }

    public MemberActPwdExample.Criteria andMemberidBetween(Integer value1, Integer value2) {
      addCriterion("memberId between", value1, value2, "memberid");
      return ((MemberActPwdExample.Criteria)this);
    }

    public MemberActPwdExample.Criteria andMemberidNotBetween(Integer value1, Integer value2) {
      addCriterion("memberId not between", value1, value2, "memberid");
      return ((MemberActPwdExample.Criteria)this);
    }

    public MemberActPwdExample.Criteria andPwduuidIsNull() {
      addCriterion("pwduuid is null");
      return ((MemberActPwdExample.Criteria)this);
    }

    public MemberActPwdExample.Criteria andPwduuidIsNotNull() {
      addCriterion("pwduuid is not null");
      return ((MemberActPwdExample.Criteria)this);
    }

    public MemberActPwdExample.Criteria andPwduuidEqualTo(String value) {
      addCriterion("pwduuid =", value, "pwduuid");
      return ((MemberActPwdExample.Criteria)this);
    }

    public MemberActPwdExample.Criteria andPwduuidNotEqualTo(String value) {
      addCriterion("pwduuid <>", value, "pwduuid");
      return ((MemberActPwdExample.Criteria)this);
    }

    public MemberActPwdExample.Criteria andPwduuidGreaterThan(String value) {
      addCriterion("pwduuid >", value, "pwduuid");
      return ((MemberActPwdExample.Criteria)this);
    }

    public MemberActPwdExample.Criteria andPwduuidGreaterThanOrEqualTo(String value) {
      addCriterion("pwduuid >=", value, "pwduuid");
      return ((MemberActPwdExample.Criteria)this);
    }

    public MemberActPwdExample.Criteria andPwduuidLessThan(String value) {
      addCriterion("pwduuid <", value, "pwduuid");
      return ((MemberActPwdExample.Criteria)this);
    }

    public MemberActPwdExample.Criteria andPwduuidLessThanOrEqualTo(String value) {
      addCriterion("pwduuid <=", value, "pwduuid");
      return ((MemberActPwdExample.Criteria)this);
    }

    public MemberActPwdExample.Criteria andPwduuidLike(String value) {
      addCriterion("pwduuid like", value, "pwduuid");
      return ((MemberActPwdExample.Criteria)this);
    }

    public MemberActPwdExample.Criteria andPwduuidNotLike(String value) {
      addCriterion("pwduuid not like", value, "pwduuid");
      return ((MemberActPwdExample.Criteria)this);
    }

    public MemberActPwdExample.Criteria andPwduuidIn(List<String> values) {
      addCriterion("pwduuid in", values, "pwduuid");
      return ((MemberActPwdExample.Criteria)this);
    }

    public MemberActPwdExample.Criteria andPwduuidNotIn(List<String> values) {
      addCriterion("pwduuid not in", values, "pwduuid");
      return ((MemberActPwdExample.Criteria)this);
    }

    public MemberActPwdExample.Criteria andPwduuidBetween(String value1, String value2) {
      addCriterion("pwduuid between", value1, value2, "pwduuid");
      return ((MemberActPwdExample.Criteria)this);
    }

    public MemberActPwdExample.Criteria andPwduuidNotBetween(String value1, String value2) {
      addCriterion("pwduuid not between", value1, value2, "pwduuid");
      return ((MemberActPwdExample.Criteria)this);
    }

    public MemberActPwdExample.Criteria andUuidisvalidIsNull() {
      addCriterion("uuidisvalid is null");
      return ((MemberActPwdExample.Criteria)this);
    }

    public MemberActPwdExample.Criteria andUuidisvalidIsNotNull() {
      addCriterion("uuidisvalid is not null");
      return ((MemberActPwdExample.Criteria)this);
    }

    public MemberActPwdExample.Criteria andUuidisvalidEqualTo(Boolean value) {
      addCriterion("uuidisvalid =", value, "uuidisvalid");
      return ((MemberActPwdExample.Criteria)this);
    }

    public MemberActPwdExample.Criteria andUuidisvalidNotEqualTo(Boolean value) {
      addCriterion("uuidisvalid <>", value, "uuidisvalid");
      return ((MemberActPwdExample.Criteria)this);
    }

    public MemberActPwdExample.Criteria andUuidisvalidGreaterThan(Boolean value) {
      addCriterion("uuidisvalid >", value, "uuidisvalid");
      return ((MemberActPwdExample.Criteria)this);
    }

    public MemberActPwdExample.Criteria andUuidisvalidGreaterThanOrEqualTo(Boolean value) {
      addCriterion("uuidisvalid >=", value, "uuidisvalid");
      return ((MemberActPwdExample.Criteria)this);
    }

    public MemberActPwdExample.Criteria andUuidisvalidLessThan(Boolean value) {
      addCriterion("uuidisvalid <", value, "uuidisvalid");
      return ((MemberActPwdExample.Criteria)this);
    }

    public MemberActPwdExample.Criteria andUuidisvalidLessThanOrEqualTo(Boolean value) {
      addCriterion("uuidisvalid <=", value, "uuidisvalid");
      return ((MemberActPwdExample.Criteria)this);
    }

    public MemberActPwdExample.Criteria andUuidisvalidIn(List<Boolean> values) {
      addCriterion("uuidisvalid in", values, "uuidisvalid");
      return ((MemberActPwdExample.Criteria)this);
    }

    public MemberActPwdExample.Criteria andUuidisvalidNotIn(List<Boolean> values) {
      addCriterion("uuidisvalid not in", values, "uuidisvalid");
      return ((MemberActPwdExample.Criteria)this);
    }

    public MemberActPwdExample.Criteria andUuidisvalidBetween(Boolean value1, Boolean value2) {
      addCriterion("uuidisvalid between", value1, value2, "uuidisvalid");
      return ((MemberActPwdExample.Criteria)this);
    }

    public MemberActPwdExample.Criteria andUuidisvalidNotBetween(Boolean value1, Boolean value2) {
      addCriterion("uuidisvalid not between", value1, value2, "uuidisvalid");
      return ((MemberActPwdExample.Criteria)this);
    }

    public MemberActPwdExample.Criteria andRemarkIsNull() {
      addCriterion("remark is null");
      return ((MemberActPwdExample.Criteria)this);
    }

    public MemberActPwdExample.Criteria andRemarkIsNotNull() {
      addCriterion("remark is not null");
      return ((MemberActPwdExample.Criteria)this);
    }

    public MemberActPwdExample.Criteria andRemarkEqualTo(String value) {
      addCriterion("remark =", value, "remark");
      return ((MemberActPwdExample.Criteria)this);
    }

    public MemberActPwdExample.Criteria andRemarkNotEqualTo(String value) {
      addCriterion("remark <>", value, "remark");
      return ((MemberActPwdExample.Criteria)this);
    }

    public MemberActPwdExample.Criteria andRemarkGreaterThan(String value) {
      addCriterion("remark >", value, "remark");
      return ((MemberActPwdExample.Criteria)this);
    }

    public MemberActPwdExample.Criteria andRemarkGreaterThanOrEqualTo(String value) {
      addCriterion("remark >=", value, "remark");
      return ((MemberActPwdExample.Criteria)this);
    }

    public MemberActPwdExample.Criteria andRemarkLessThan(String value) {
      addCriterion("remark <", value, "remark");
      return ((MemberActPwdExample.Criteria)this);
    }

    public MemberActPwdExample.Criteria andRemarkLessThanOrEqualTo(String value) {
      addCriterion("remark <=", value, "remark");
      return ((MemberActPwdExample.Criteria)this);
    }

    public MemberActPwdExample.Criteria andRemarkLike(String value) {
      addCriterion("remark like", value, "remark");
      return ((MemberActPwdExample.Criteria)this);
    }

    public MemberActPwdExample.Criteria andRemarkNotLike(String value) {
      addCriterion("remark not like", value, "remark");
      return ((MemberActPwdExample.Criteria)this);
    }

    public MemberActPwdExample.Criteria andRemarkIn(List<String> values) {
      addCriterion("remark in", values, "remark");
      return ((MemberActPwdExample.Criteria)this);
    }

    public MemberActPwdExample.Criteria andRemarkNotIn(List<String> values) {
      addCriterion("remark not in", values, "remark");
      return ((MemberActPwdExample.Criteria)this);
    }

    public MemberActPwdExample.Criteria andRemarkBetween(String value1, String value2) {
      addCriterion("remark between", value1, value2, "remark");
      return ((MemberActPwdExample.Criteria)this);
    }

    public MemberActPwdExample.Criteria andRemarkNotBetween(String value1, String value2) {
      addCriterion("remark not between", value1, value2, "remark");
      return ((MemberActPwdExample.Criteria)this);
    }
  }
}