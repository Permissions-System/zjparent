package com.zjgt.p2p.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springfk.pancloud.daoframework.page.PageExample;

public class MessageExample extends PageExample
{
  protected String orderByClause;
  protected boolean distinct;
  protected List<Criteria> oredCriteria;

  public MessageExample()
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

  public static class Criteria extends MessageExample.GeneratedCriteria
  {
  }

  protected static abstract class GeneratedCriteria
  {
    protected List<MessageExample.Criterion> criteria;

    protected GeneratedCriteria()
    {
      this.criteria = new ArrayList();
    }

    public boolean isValid() {
      return (this.criteria.size() > 0);
    }

    public List<MessageExample.Criterion> getAllCriteria() {
      return this.criteria;
    }

    public List<MessageExample.Criterion> getCriteria() {
      return this.criteria;
    }

    protected void addCriterion(String condition) {
      if (condition == null) {
        throw new RuntimeException("Value for condition cannot be null");
      }
      this.criteria.add(new MessageExample.Criterion(condition));
    }

    protected void addCriterion(String condition, Object value, String property) {
      if (value == null) {
        throw new RuntimeException("Value for " + property + " cannot be null");
      }
      this.criteria.add(new MessageExample.Criterion(condition, value));
    }

    protected void addCriterion(String condition, Object value1, Object value2, String property) {
      if ((value1 == null) || (value2 == null)) {
        throw new RuntimeException("Between values for " + property + " cannot be null");
      }
      this.criteria.add(new MessageExample.Criterion(condition, value1, value2));
    }

    public MessageExample.Criteria andIdIsNull() {
      addCriterion("id is null");
      return ((MessageExample.Criteria)this);
    }

    public MessageExample.Criteria andIdIsNotNull() {
      addCriterion("id is not null");
      return ((MessageExample.Criteria)this);
    }

    public MessageExample.Criteria andIdEqualTo(Long value) {
      addCriterion("id =", value, "id");
      return ((MessageExample.Criteria)this);
    }

    public MessageExample.Criteria andIdNotEqualTo(Long value) {
      addCriterion("id <>", value, "id");
      return ((MessageExample.Criteria)this);
    }

    public MessageExample.Criteria andIdGreaterThan(Long value) {
      addCriterion("id >", value, "id");
      return ((MessageExample.Criteria)this);
    }

    public MessageExample.Criteria andIdGreaterThanOrEqualTo(Long value) {
      addCriterion("id >=", value, "id");
      return ((MessageExample.Criteria)this);
    }

    public MessageExample.Criteria andIdLessThan(Long value) {
      addCriterion("id <", value, "id");
      return ((MessageExample.Criteria)this);
    }

    public MessageExample.Criteria andIdLessThanOrEqualTo(Long value) {
      addCriterion("id <=", value, "id");
      return ((MessageExample.Criteria)this);
    }

    public MessageExample.Criteria andIdIn(List<Long> values) {
      addCriterion("id in", values, "id");
      return ((MessageExample.Criteria)this);
    }

    public MessageExample.Criteria andIdNotIn(List<Long> values) {
      addCriterion("id not in", values, "id");
      return ((MessageExample.Criteria)this);
    }

    public MessageExample.Criteria andIdBetween(Long value1, Long value2) {
      addCriterion("id between", value1, value2, "id");
      return ((MessageExample.Criteria)this);
    }

    public MessageExample.Criteria andIdNotBetween(Long value1, Long value2) {
      addCriterion("id not between", value1, value2, "id");
      return ((MessageExample.Criteria)this);
    }

    public MessageExample.Criteria andStatusIsNull() {
      addCriterion("status is null");
      return ((MessageExample.Criteria)this);
    }

    public MessageExample.Criteria andStatusIsNotNull() {
      addCriterion("status is not null");
      return ((MessageExample.Criteria)this);
    }

    public MessageExample.Criteria andStatusEqualTo(Integer value) {
      addCriterion("status =", value, "status");
      return ((MessageExample.Criteria)this);
    }

    public MessageExample.Criteria andStatusNotEqualTo(Integer value) {
      addCriterion("status <>", value, "status");
      return ((MessageExample.Criteria)this);
    }

    public MessageExample.Criteria andStatusGreaterThan(Integer value) {
      addCriterion("status >", value, "status");
      return ((MessageExample.Criteria)this);
    }

    public MessageExample.Criteria andStatusGreaterThanOrEqualTo(Integer value) {
      addCriterion("status >=", value, "status");
      return ((MessageExample.Criteria)this);
    }

    public MessageExample.Criteria andStatusLessThan(Integer value) {
      addCriterion("status <", value, "status");
      return ((MessageExample.Criteria)this);
    }

    public MessageExample.Criteria andStatusLessThanOrEqualTo(Integer value) {
      addCriterion("status <=", value, "status");
      return ((MessageExample.Criteria)this);
    }

    public MessageExample.Criteria andStatusIn(List<Integer> values) {
      addCriterion("status in", values, "status");
      return ((MessageExample.Criteria)this);
    }

    public MessageExample.Criteria andStatusNotIn(List<Integer> values) {
      addCriterion("status not in", values, "status");
      return ((MessageExample.Criteria)this);
    }

    public MessageExample.Criteria andStatusBetween(Integer value1, Integer value2) {
      addCriterion("status between", value1, value2, "status");
      return ((MessageExample.Criteria)this);
    }

    public MessageExample.Criteria andStatusNotBetween(Integer value1, Integer value2) {
      addCriterion("status not between", value1, value2, "status");
      return ((MessageExample.Criteria)this);
    }

    public MessageExample.Criteria andTypeIsNull() {
      addCriterion("type is null");
      return ((MessageExample.Criteria)this);
    }

    public MessageExample.Criteria andTypeIsNotNull() {
      addCriterion("type is not null");
      return ((MessageExample.Criteria)this);
    }

    public MessageExample.Criteria andTypeEqualTo(Integer value) {
      addCriterion("type =", value, "type");
      return ((MessageExample.Criteria)this);
    }

    public MessageExample.Criteria andTypeNotEqualTo(Integer value) {
      addCriterion("type <>", value, "type");
      return ((MessageExample.Criteria)this);
    }

    public MessageExample.Criteria andTypeGreaterThan(Integer value) {
      addCriterion("type >", value, "type");
      return ((MessageExample.Criteria)this);
    }

    public MessageExample.Criteria andTypeGreaterThanOrEqualTo(Integer value) {
      addCriterion("type >=", value, "type");
      return ((MessageExample.Criteria)this);
    }

    public MessageExample.Criteria andTypeLessThan(Integer value) {
      addCriterion("type <", value, "type");
      return ((MessageExample.Criteria)this);
    }

    public MessageExample.Criteria andTypeLessThanOrEqualTo(Integer value) {
      addCriterion("type <=", value, "type");
      return ((MessageExample.Criteria)this);
    }

    public MessageExample.Criteria andTypeIn(List<Integer> values) {
      addCriterion("type in", values, "type");
      return ((MessageExample.Criteria)this);
    }

    public MessageExample.Criteria andTypeNotIn(List<Integer> values) {
      addCriterion("type not in", values, "type");
      return ((MessageExample.Criteria)this);
    }

    public MessageExample.Criteria andTypeBetween(Integer value1, Integer value2) {
      addCriterion("type between", value1, value2, "type");
      return ((MessageExample.Criteria)this);
    }

    public MessageExample.Criteria andTypeNotBetween(Integer value1, Integer value2) {
      addCriterion("type not between", value1, value2, "type");
      return ((MessageExample.Criteria)this);
    }

    public MessageExample.Criteria andTitleIsNull() {
      addCriterion("title is null");
      return ((MessageExample.Criteria)this);
    }

    public MessageExample.Criteria andTitleIsNotNull() {
      addCriterion("title is not null");
      return ((MessageExample.Criteria)this);
    }

    public MessageExample.Criteria andTitleEqualTo(String value) {
      addCriterion("title =", value, "title");
      return ((MessageExample.Criteria)this);
    }

    public MessageExample.Criteria andTitleNotEqualTo(String value) {
      addCriterion("title <>", value, "title");
      return ((MessageExample.Criteria)this);
    }

    public MessageExample.Criteria andTitleGreaterThan(String value) {
      addCriterion("title >", value, "title");
      return ((MessageExample.Criteria)this);
    }

    public MessageExample.Criteria andTitleGreaterThanOrEqualTo(String value) {
      addCriterion("title >=", value, "title");
      return ((MessageExample.Criteria)this);
    }

    public MessageExample.Criteria andTitleLessThan(String value) {
      addCriterion("title <", value, "title");
      return ((MessageExample.Criteria)this);
    }

    public MessageExample.Criteria andTitleLessThanOrEqualTo(String value) {
      addCriterion("title <=", value, "title");
      return ((MessageExample.Criteria)this);
    }

    public MessageExample.Criteria andTitleLike(String value) {
      addCriterion("title like", value, "title");
      return ((MessageExample.Criteria)this);
    }

    public MessageExample.Criteria andTitleNotLike(String value) {
      addCriterion("title not like", value, "title");
      return ((MessageExample.Criteria)this);
    }

    public MessageExample.Criteria andTitleIn(List<String> values) {
      addCriterion("title in", values, "title");
      return ((MessageExample.Criteria)this);
    }

    public MessageExample.Criteria andTitleNotIn(List<String> values) {
      addCriterion("title not in", values, "title");
      return ((MessageExample.Criteria)this);
    }

    public MessageExample.Criteria andTitleBetween(String value1, String value2) {
      addCriterion("title between", value1, value2, "title");
      return ((MessageExample.Criteria)this);
    }

    public MessageExample.Criteria andTitleNotBetween(String value1, String value2) {
      addCriterion("title not between", value1, value2, "title");
      return ((MessageExample.Criteria)this);
    }

    public MessageExample.Criteria andMemberidIsNull() {
      addCriterion("memberid is null");
      return ((MessageExample.Criteria)this);
    }

    public MessageExample.Criteria andMemberidIsNotNull() {
      addCriterion("memberid is not null");
      return ((MessageExample.Criteria)this);
    }

    public MessageExample.Criteria andMemberidEqualTo(Long value) {
      addCriterion("memberid =", value, "memberid");
      return ((MessageExample.Criteria)this);
    }

    public MessageExample.Criteria andMemberidNotEqualTo(Long value) {
      addCriterion("memberid <>", value, "memberid");
      return ((MessageExample.Criteria)this);
    }

    public MessageExample.Criteria andMemberidGreaterThan(Long value) {
      addCriterion("memberid >", value, "memberid");
      return ((MessageExample.Criteria)this);
    }

    public MessageExample.Criteria andMemberidGreaterThanOrEqualTo(Long value) {
      addCriterion("memberid >=", value, "memberid");
      return ((MessageExample.Criteria)this);
    }

    public MessageExample.Criteria andMemberidLessThan(Long value) {
      addCriterion("memberid <", value, "memberid");
      return ((MessageExample.Criteria)this);
    }

    public MessageExample.Criteria andMemberidLessThanOrEqualTo(Long value) {
      addCriterion("memberid <=", value, "memberid");
      return ((MessageExample.Criteria)this);
    }

    public MessageExample.Criteria andMemberidIn(List<Long> values) {
      addCriterion("memberid in", values, "memberid");
      return ((MessageExample.Criteria)this);
    }

    public MessageExample.Criteria andMemberidNotIn(List<Long> values) {
      addCriterion("memberid not in", values, "memberid");
      return ((MessageExample.Criteria)this);
    }

    public MessageExample.Criteria andMemberidBetween(Long value1, Long value2) {
      addCriterion("memberid between", value1, value2, "memberid");
      return ((MessageExample.Criteria)this);
    }

    public MessageExample.Criteria andMemberidNotBetween(Long value1, Long value2) {
      addCriterion("memberid not between", value1, value2, "memberid");
      return ((MessageExample.Criteria)this);
    }

    public MessageExample.Criteria andCreatedateIsNull() {
      addCriterion("createdate is null");
      return ((MessageExample.Criteria)this);
    }

    public MessageExample.Criteria andCreatedateIsNotNull() {
      addCriterion("createdate is not null");
      return ((MessageExample.Criteria)this);
    }

    public MessageExample.Criteria andCreatedateEqualTo(Date value) {
      addCriterion("createdate =", value, "createdate");
      return ((MessageExample.Criteria)this);
    }

    public MessageExample.Criteria andCreatedateNotEqualTo(Date value) {
      addCriterion("createdate <>", value, "createdate");
      return ((MessageExample.Criteria)this);
    }

    public MessageExample.Criteria andCreatedateGreaterThan(Date value) {
      addCriterion("createdate >", value, "createdate");
      return ((MessageExample.Criteria)this);
    }

    public MessageExample.Criteria andCreatedateGreaterThanOrEqualTo(Date value) {
      addCriterion("createdate >=", value, "createdate");
      return ((MessageExample.Criteria)this);
    }

    public MessageExample.Criteria andCreatedateLessThan(Date value) {
      addCriterion("createdate <", value, "createdate");
      return ((MessageExample.Criteria)this);
    }

    public MessageExample.Criteria andCreatedateLessThanOrEqualTo(Date value) {
      addCriterion("createdate <=", value, "createdate");
      return ((MessageExample.Criteria)this);
    }

    public MessageExample.Criteria andCreatedateIn(List<Date> values) {
      addCriterion("createdate in", values, "createdate");
      return ((MessageExample.Criteria)this);
    }

    public MessageExample.Criteria andCreatedateNotIn(List<Date> values) {
      addCriterion("createdate not in", values, "createdate");
      return ((MessageExample.Criteria)this);
    }

    public MessageExample.Criteria andCreatedateBetween(Date value1, Date value2) {
      addCriterion("createdate between", value1, value2, "createdate");
      return ((MessageExample.Criteria)this);
    }

    public MessageExample.Criteria andCreatedateNotBetween(Date value1, Date value2) {
      addCriterion("createdate not between", value1, value2, "createdate");
      return ((MessageExample.Criteria)this);
    }
  }
}