package com.zjgt.p2p.article.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TagExample
{
  protected String orderByClause;
  protected boolean distinct;
  protected List<Criteria> oredCriteria;

  public TagExample()
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

  public static class Criteria extends TagExample.GeneratedCriteria
  {
  }

  protected static abstract class GeneratedCriteria
  {
    protected List<TagExample.Criterion> criteria;

    protected GeneratedCriteria()
    {
      this.criteria = new ArrayList();
    }

    public boolean isValid() {
      return (this.criteria.size() > 0);
    }

    public List<TagExample.Criterion> getAllCriteria() {
      return this.criteria;
    }

    public List<TagExample.Criterion> getCriteria() {
      return this.criteria;
    }

    protected void addCriterion(String condition) {
      if (condition == null) {
        throw new RuntimeException("Value for condition cannot be null");
      }
      this.criteria.add(new TagExample.Criterion(condition));
    }

    protected void addCriterion(String condition, Object value, String property) {
      if (value == null) {
        throw new RuntimeException("Value for " + property + " cannot be null");
      }
      this.criteria.add(new TagExample.Criterion(condition, value));
    }

    protected void addCriterion(String condition, Object value1, Object value2, String property) {
      if ((value1 == null) || (value2 == null)) {
        throw new RuntimeException("Between values for " + property + " cannot be null");
      }
      this.criteria.add(new TagExample.Criterion(condition, value1, value2));
    }

    public TagExample.Criteria andIdIsNull() {
      addCriterion("id is null");
      return ((TagExample.Criteria)this);
    }

    public TagExample.Criteria andIdIsNotNull() {
      addCriterion("id is not null");
      return ((TagExample.Criteria)this);
    }

    public TagExample.Criteria andIdEqualTo(Long value) {
      addCriterion("id =", value, "id");
      return ((TagExample.Criteria)this);
    }

    public TagExample.Criteria andIdNotEqualTo(Long value) {
      addCriterion("id <>", value, "id");
      return ((TagExample.Criteria)this);
    }

    public TagExample.Criteria andIdGreaterThan(Long value) {
      addCriterion("id >", value, "id");
      return ((TagExample.Criteria)this);
    }

    public TagExample.Criteria andIdGreaterThanOrEqualTo(Long value) {
      addCriterion("id >=", value, "id");
      return ((TagExample.Criteria)this);
    }

    public TagExample.Criteria andIdLessThan(Long value) {
      addCriterion("id <", value, "id");
      return ((TagExample.Criteria)this);
    }

    public TagExample.Criteria andIdLessThanOrEqualTo(Long value) {
      addCriterion("id <=", value, "id");
      return ((TagExample.Criteria)this);
    }

    public TagExample.Criteria andIdIn(List<Long> values) {
      addCriterion("id in", values, "id");
      return ((TagExample.Criteria)this);
    }

    public TagExample.Criteria andIdNotIn(List<Long> values) {
      addCriterion("id not in", values, "id");
      return ((TagExample.Criteria)this);
    }

    public TagExample.Criteria andIdBetween(Long value1, Long value2) {
      addCriterion("id between", value1, value2, "id");
      return ((TagExample.Criteria)this);
    }

    public TagExample.Criteria andIdNotBetween(Long value1, Long value2) {
      addCriterion("id not between", value1, value2, "id");
      return ((TagExample.Criteria)this);
    }

    public TagExample.Criteria andCreateDateIsNull() {
      addCriterion("create_date is null");
      return ((TagExample.Criteria)this);
    }

    public TagExample.Criteria andCreateDateIsNotNull() {
      addCriterion("create_date is not null");
      return ((TagExample.Criteria)this);
    }

    public TagExample.Criteria andCreateDateEqualTo(Date value) {
      addCriterion("create_date =", value, "createDate");
      return ((TagExample.Criteria)this);
    }

    public TagExample.Criteria andCreateDateNotEqualTo(Date value) {
      addCriterion("create_date <>", value, "createDate");
      return ((TagExample.Criteria)this);
    }

    public TagExample.Criteria andCreateDateGreaterThan(Date value) {
      addCriterion("create_date >", value, "createDate");
      return ((TagExample.Criteria)this);
    }

    public TagExample.Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
      addCriterion("create_date >=", value, "createDate");
      return ((TagExample.Criteria)this);
    }

    public TagExample.Criteria andCreateDateLessThan(Date value) {
      addCriterion("create_date <", value, "createDate");
      return ((TagExample.Criteria)this);
    }

    public TagExample.Criteria andCreateDateLessThanOrEqualTo(Date value) {
      addCriterion("create_date <=", value, "createDate");
      return ((TagExample.Criteria)this);
    }

    public TagExample.Criteria andCreateDateIn(List<Date> values) {
      addCriterion("create_date in", values, "createDate");
      return ((TagExample.Criteria)this);
    }

    public TagExample.Criteria andCreateDateNotIn(List<Date> values) {
      addCriterion("create_date not in", values, "createDate");
      return ((TagExample.Criteria)this);
    }

    public TagExample.Criteria andCreateDateBetween(Date value1, Date value2) {
      addCriterion("create_date between", value1, value2, "createDate");
      return ((TagExample.Criteria)this);
    }

    public TagExample.Criteria andCreateDateNotBetween(Date value1, Date value2) {
      addCriterion("create_date not between", value1, value2, "createDate");
      return ((TagExample.Criteria)this);
    }

    public TagExample.Criteria andModifyDateIsNull() {
      addCriterion("modify_date is null");
      return ((TagExample.Criteria)this);
    }

    public TagExample.Criteria andModifyDateIsNotNull() {
      addCriterion("modify_date is not null");
      return ((TagExample.Criteria)this);
    }

    public TagExample.Criteria andModifyDateEqualTo(Date value) {
      addCriterion("modify_date =", value, "modifyDate");
      return ((TagExample.Criteria)this);
    }

    public TagExample.Criteria andModifyDateNotEqualTo(Date value) {
      addCriterion("modify_date <>", value, "modifyDate");
      return ((TagExample.Criteria)this);
    }

    public TagExample.Criteria andModifyDateGreaterThan(Date value) {
      addCriterion("modify_date >", value, "modifyDate");
      return ((TagExample.Criteria)this);
    }

    public TagExample.Criteria andModifyDateGreaterThanOrEqualTo(Date value) {
      addCriterion("modify_date >=", value, "modifyDate");
      return ((TagExample.Criteria)this);
    }

    public TagExample.Criteria andModifyDateLessThan(Date value) {
      addCriterion("modify_date <", value, "modifyDate");
      return ((TagExample.Criteria)this);
    }

    public TagExample.Criteria andModifyDateLessThanOrEqualTo(Date value) {
      addCriterion("modify_date <=", value, "modifyDate");
      return ((TagExample.Criteria)this);
    }

    public TagExample.Criteria andModifyDateIn(List<Date> values) {
      addCriterion("modify_date in", values, "modifyDate");
      return ((TagExample.Criteria)this);
    }

    public TagExample.Criteria andModifyDateNotIn(List<Date> values) {
      addCriterion("modify_date not in", values, "modifyDate");
      return ((TagExample.Criteria)this);
    }

    public TagExample.Criteria andModifyDateBetween(Date value1, Date value2) {
      addCriterion("modify_date between", value1, value2, "modifyDate");
      return ((TagExample.Criteria)this);
    }

    public TagExample.Criteria andModifyDateNotBetween(Date value1, Date value2) {
      addCriterion("modify_date not between", value1, value2, "modifyDate");
      return ((TagExample.Criteria)this);
    }

    public TagExample.Criteria andOrdersIsNull() {
      addCriterion("orders is null");
      return ((TagExample.Criteria)this);
    }

    public TagExample.Criteria andOrdersIsNotNull() {
      addCriterion("orders is not null");
      return ((TagExample.Criteria)this);
    }

    public TagExample.Criteria andOrdersEqualTo(Integer value) {
      addCriterion("orders =", value, "orders");
      return ((TagExample.Criteria)this);
    }

    public TagExample.Criteria andOrdersNotEqualTo(Integer value) {
      addCriterion("orders <>", value, "orders");
      return ((TagExample.Criteria)this);
    }

    public TagExample.Criteria andOrdersGreaterThan(Integer value) {
      addCriterion("orders >", value, "orders");
      return ((TagExample.Criteria)this);
    }

    public TagExample.Criteria andOrdersGreaterThanOrEqualTo(Integer value) {
      addCriterion("orders >=", value, "orders");
      return ((TagExample.Criteria)this);
    }

    public TagExample.Criteria andOrdersLessThan(Integer value) {
      addCriterion("orders <", value, "orders");
      return ((TagExample.Criteria)this);
    }

    public TagExample.Criteria andOrdersLessThanOrEqualTo(Integer value) {
      addCriterion("orders <=", value, "orders");
      return ((TagExample.Criteria)this);
    }

    public TagExample.Criteria andOrdersIn(List<Integer> values) {
      addCriterion("orders in", values, "orders");
      return ((TagExample.Criteria)this);
    }

    public TagExample.Criteria andOrdersNotIn(List<Integer> values) {
      addCriterion("orders not in", values, "orders");
      return ((TagExample.Criteria)this);
    }

    public TagExample.Criteria andOrdersBetween(Integer value1, Integer value2) {
      addCriterion("orders between", value1, value2, "orders");
      return ((TagExample.Criteria)this);
    }

    public TagExample.Criteria andOrdersNotBetween(Integer value1, Integer value2) {
      addCriterion("orders not between", value1, value2, "orders");
      return ((TagExample.Criteria)this);
    }

    public TagExample.Criteria andIconIsNull() {
      addCriterion("icon is null");
      return ((TagExample.Criteria)this);
    }

    public TagExample.Criteria andIconIsNotNull() {
      addCriterion("icon is not null");
      return ((TagExample.Criteria)this);
    }

    public TagExample.Criteria andIconEqualTo(String value) {
      addCriterion("icon =", value, "icon");
      return ((TagExample.Criteria)this);
    }

    public TagExample.Criteria andIconNotEqualTo(String value) {
      addCriterion("icon <>", value, "icon");
      return ((TagExample.Criteria)this);
    }

    public TagExample.Criteria andIconGreaterThan(String value) {
      addCriterion("icon >", value, "icon");
      return ((TagExample.Criteria)this);
    }

    public TagExample.Criteria andIconGreaterThanOrEqualTo(String value) {
      addCriterion("icon >=", value, "icon");
      return ((TagExample.Criteria)this);
    }

    public TagExample.Criteria andIconLessThan(String value) {
      addCriterion("icon <", value, "icon");
      return ((TagExample.Criteria)this);
    }

    public TagExample.Criteria andIconLessThanOrEqualTo(String value) {
      addCriterion("icon <=", value, "icon");
      return ((TagExample.Criteria)this);
    }

    public TagExample.Criteria andIconLike(String value) {
      addCriterion("icon like", value, "icon");
      return ((TagExample.Criteria)this);
    }

    public TagExample.Criteria andIconNotLike(String value) {
      addCriterion("icon not like", value, "icon");
      return ((TagExample.Criteria)this);
    }

    public TagExample.Criteria andIconIn(List<String> values) {
      addCriterion("icon in", values, "icon");
      return ((TagExample.Criteria)this);
    }

    public TagExample.Criteria andIconNotIn(List<String> values) {
      addCriterion("icon not in", values, "icon");
      return ((TagExample.Criteria)this);
    }

    public TagExample.Criteria andIconBetween(String value1, String value2) {
      addCriterion("icon between", value1, value2, "icon");
      return ((TagExample.Criteria)this);
    }

    public TagExample.Criteria andIconNotBetween(String value1, String value2) {
      addCriterion("icon not between", value1, value2, "icon");
      return ((TagExample.Criteria)this);
    }

    public TagExample.Criteria andMemoIsNull() {
      addCriterion("memo is null");
      return ((TagExample.Criteria)this);
    }

    public TagExample.Criteria andMemoIsNotNull() {
      addCriterion("memo is not null");
      return ((TagExample.Criteria)this);
    }

    public TagExample.Criteria andMemoEqualTo(String value) {
      addCriterion("memo =", value, "memo");
      return ((TagExample.Criteria)this);
    }

    public TagExample.Criteria andMemoNotEqualTo(String value) {
      addCriterion("memo <>", value, "memo");
      return ((TagExample.Criteria)this);
    }

    public TagExample.Criteria andMemoGreaterThan(String value) {
      addCriterion("memo >", value, "memo");
      return ((TagExample.Criteria)this);
    }

    public TagExample.Criteria andMemoGreaterThanOrEqualTo(String value) {
      addCriterion("memo >=", value, "memo");
      return ((TagExample.Criteria)this);
    }

    public TagExample.Criteria andMemoLessThan(String value) {
      addCriterion("memo <", value, "memo");
      return ((TagExample.Criteria)this);
    }

    public TagExample.Criteria andMemoLessThanOrEqualTo(String value) {
      addCriterion("memo <=", value, "memo");
      return ((TagExample.Criteria)this);
    }

    public TagExample.Criteria andMemoLike(String value) {
      addCriterion("memo like", value, "memo");
      return ((TagExample.Criteria)this);
    }

    public TagExample.Criteria andMemoNotLike(String value) {
      addCriterion("memo not like", value, "memo");
      return ((TagExample.Criteria)this);
    }

    public TagExample.Criteria andMemoIn(List<String> values) {
      addCriterion("memo in", values, "memo");
      return ((TagExample.Criteria)this);
    }

    public TagExample.Criteria andMemoNotIn(List<String> values) {
      addCriterion("memo not in", values, "memo");
      return ((TagExample.Criteria)this);
    }

    public TagExample.Criteria andMemoBetween(String value1, String value2) {
      addCriterion("memo between", value1, value2, "memo");
      return ((TagExample.Criteria)this);
    }

    public TagExample.Criteria andMemoNotBetween(String value1, String value2) {
      addCriterion("memo not between", value1, value2, "memo");
      return ((TagExample.Criteria)this);
    }

    public TagExample.Criteria andNameIsNull() {
      addCriterion("name is null");
      return ((TagExample.Criteria)this);
    }

    public TagExample.Criteria andNameIsNotNull() {
      addCriterion("name is not null");
      return ((TagExample.Criteria)this);
    }

    public TagExample.Criteria andNameEqualTo(String value) {
      addCriterion("name =", value, "name");
      return ((TagExample.Criteria)this);
    }

    public TagExample.Criteria andNameNotEqualTo(String value) {
      addCriterion("name <>", value, "name");
      return ((TagExample.Criteria)this);
    }

    public TagExample.Criteria andNameGreaterThan(String value) {
      addCriterion("name >", value, "name");
      return ((TagExample.Criteria)this);
    }

    public TagExample.Criteria andNameGreaterThanOrEqualTo(String value) {
      addCriterion("name >=", value, "name");
      return ((TagExample.Criteria)this);
    }

    public TagExample.Criteria andNameLessThan(String value) {
      addCriterion("name <", value, "name");
      return ((TagExample.Criteria)this);
    }

    public TagExample.Criteria andNameLessThanOrEqualTo(String value) {
      addCriterion("name <=", value, "name");
      return ((TagExample.Criteria)this);
    }

    public TagExample.Criteria andNameLike(String value) {
      addCriterion("name like", value, "name");
      return ((TagExample.Criteria)this);
    }

    public TagExample.Criteria andNameNotLike(String value) {
      addCriterion("name not like", value, "name");
      return ((TagExample.Criteria)this);
    }

    public TagExample.Criteria andNameIn(List<String> values) {
      addCriterion("name in", values, "name");
      return ((TagExample.Criteria)this);
    }

    public TagExample.Criteria andNameNotIn(List<String> values) {
      addCriterion("name not in", values, "name");
      return ((TagExample.Criteria)this);
    }

    public TagExample.Criteria andNameBetween(String value1, String value2) {
      addCriterion("name between", value1, value2, "name");
      return ((TagExample.Criteria)this);
    }

    public TagExample.Criteria andNameNotBetween(String value1, String value2) {
      addCriterion("name not between", value1, value2, "name");
      return ((TagExample.Criteria)this);
    }

    public TagExample.Criteria andTypeIsNull() {
      addCriterion("type is null");
      return ((TagExample.Criteria)this);
    }

    public TagExample.Criteria andTypeIsNotNull() {
      addCriterion("type is not null");
      return ((TagExample.Criteria)this);
    }

    public TagExample.Criteria andTypeEqualTo(Integer value) {
      addCriterion("type =", value, "type");
      return ((TagExample.Criteria)this);
    }

    public TagExample.Criteria andTypeNotEqualTo(Integer value) {
      addCriterion("type <>", value, "type");
      return ((TagExample.Criteria)this);
    }

    public TagExample.Criteria andTypeGreaterThan(Integer value) {
      addCriterion("type >", value, "type");
      return ((TagExample.Criteria)this);
    }

    public TagExample.Criteria andTypeGreaterThanOrEqualTo(Integer value) {
      addCriterion("type >=", value, "type");
      return ((TagExample.Criteria)this);
    }

    public TagExample.Criteria andTypeLessThan(Integer value) {
      addCriterion("type <", value, "type");
      return ((TagExample.Criteria)this);
    }

    public TagExample.Criteria andTypeLessThanOrEqualTo(Integer value) {
      addCriterion("type <=", value, "type");
      return ((TagExample.Criteria)this);
    }

    public TagExample.Criteria andTypeIn(List<Integer> values) {
      addCriterion("type in", values, "type");
      return ((TagExample.Criteria)this);
    }

    public TagExample.Criteria andTypeNotIn(List<Integer> values) {
      addCriterion("type not in", values, "type");
      return ((TagExample.Criteria)this);
    }

    public TagExample.Criteria andTypeBetween(Integer value1, Integer value2) {
      addCriterion("type between", value1, value2, "type");
      return ((TagExample.Criteria)this);
    }

    public TagExample.Criteria andTypeNotBetween(Integer value1, Integer value2) {
      addCriterion("type not between", value1, value2, "type");
      return ((TagExample.Criteria)this);
    }
  }
}