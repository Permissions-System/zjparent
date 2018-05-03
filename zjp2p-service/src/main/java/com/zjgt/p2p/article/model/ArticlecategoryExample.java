package com.zjgt.p2p.article.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ArticlecategoryExample
{
  protected String orderByClause;
  protected boolean distinct;
  protected List<Criteria> oredCriteria;

  public ArticlecategoryExample()
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

  public static class Criteria extends ArticlecategoryExample.GeneratedCriteria
  {
  }

  protected static abstract class GeneratedCriteria
  {
    protected List<ArticlecategoryExample.Criterion> criteria;

    protected GeneratedCriteria()
    {
      this.criteria = new ArrayList();
    }

    public boolean isValid() {
      return (this.criteria.size() > 0);
    }

    public List<ArticlecategoryExample.Criterion> getAllCriteria() {
      return this.criteria;
    }

    public List<ArticlecategoryExample.Criterion> getCriteria() {
      return this.criteria;
    }

    protected void addCriterion(String condition) {
      if (condition == null) {
        throw new RuntimeException("Value for condition cannot be null");
      }
      this.criteria.add(new ArticlecategoryExample.Criterion(condition));
    }

    protected void addCriterion(String condition, Object value, String property) {
      if (value == null) {
        throw new RuntimeException("Value for " + property + " cannot be null");
      }
      this.criteria.add(new ArticlecategoryExample.Criterion(condition, value));
    }

    protected void addCriterion(String condition, Object value1, Object value2, String property) {
      if ((value1 == null) || (value2 == null)) {
        throw new RuntimeException("Between values for " + property + " cannot be null");
      }
      this.criteria.add(new ArticlecategoryExample.Criterion(condition, value1, value2));
    }

    public ArticlecategoryExample.Criteria andIdIsNull() {
      addCriterion("id is null");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andIdIsNotNull() {
      addCriterion("id is not null");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andIdEqualTo(Long value) {
      addCriterion("id =", value, "id");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andIdNotEqualTo(Long value) {
      addCriterion("id <>", value, "id");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andIdGreaterThan(Long value) {
      addCriterion("id >", value, "id");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andIdGreaterThanOrEqualTo(Long value) {
      addCriterion("id >=", value, "id");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andIdLessThan(Long value) {
      addCriterion("id <", value, "id");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andIdLessThanOrEqualTo(Long value) {
      addCriterion("id <=", value, "id");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andIdIn(List<Long> values) {
      addCriterion("id in", values, "id");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andIdNotIn(List<Long> values) {
      addCriterion("id not in", values, "id");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andIdBetween(Long value1, Long value2) {
      addCriterion("id between", value1, value2, "id");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andIdNotBetween(Long value1, Long value2) {
      addCriterion("id not between", value1, value2, "id");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andCreateDateIsNull() {
      addCriterion("create_date is null");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andCreateDateIsNotNull() {
      addCriterion("create_date is not null");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andCreateDateEqualTo(Date value) {
      addCriterion("create_date =", value, "createDate");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andCreateDateNotEqualTo(Date value) {
      addCriterion("create_date <>", value, "createDate");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andCreateDateGreaterThan(Date value) {
      addCriterion("create_date >", value, "createDate");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
      addCriterion("create_date >=", value, "createDate");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andCreateDateLessThan(Date value) {
      addCriterion("create_date <", value, "createDate");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andCreateDateLessThanOrEqualTo(Date value) {
      addCriterion("create_date <=", value, "createDate");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andCreateDateIn(List<Date> values) {
      addCriterion("create_date in", values, "createDate");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andCreateDateNotIn(List<Date> values) {
      addCriterion("create_date not in", values, "createDate");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andCreateDateBetween(Date value1, Date value2) {
      addCriterion("create_date between", value1, value2, "createDate");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andCreateDateNotBetween(Date value1, Date value2) {
      addCriterion("create_date not between", value1, value2, "createDate");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andModifyDateIsNull() {
      addCriterion("modify_date is null");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andModifyDateIsNotNull() {
      addCriterion("modify_date is not null");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andModifyDateEqualTo(Date value) {
      addCriterion("modify_date =", value, "modifyDate");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andModifyDateNotEqualTo(Date value) {
      addCriterion("modify_date <>", value, "modifyDate");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andModifyDateGreaterThan(Date value) {
      addCriterion("modify_date >", value, "modifyDate");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andModifyDateGreaterThanOrEqualTo(Date value) {
      addCriterion("modify_date >=", value, "modifyDate");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andModifyDateLessThan(Date value) {
      addCriterion("modify_date <", value, "modifyDate");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andModifyDateLessThanOrEqualTo(Date value) {
      addCriterion("modify_date <=", value, "modifyDate");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andModifyDateIn(List<Date> values) {
      addCriterion("modify_date in", values, "modifyDate");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andModifyDateNotIn(List<Date> values) {
      addCriterion("modify_date not in", values, "modifyDate");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andModifyDateBetween(Date value1, Date value2) {
      addCriterion("modify_date between", value1, value2, "modifyDate");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andModifyDateNotBetween(Date value1, Date value2) {
      addCriterion("modify_date not between", value1, value2, "modifyDate");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andOrdersIsNull() {
      addCriterion("orders is null");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andOrdersIsNotNull() {
      addCriterion("orders is not null");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andOrdersEqualTo(Integer value) {
      addCriterion("orders =", value, "orders");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andOrdersNotEqualTo(Integer value) {
      addCriterion("orders <>", value, "orders");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andOrdersGreaterThan(Integer value) {
      addCriterion("orders >", value, "orders");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andOrdersGreaterThanOrEqualTo(Integer value) {
      addCriterion("orders >=", value, "orders");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andOrdersLessThan(Integer value) {
      addCriterion("orders <", value, "orders");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andOrdersLessThanOrEqualTo(Integer value) {
      addCriterion("orders <=", value, "orders");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andOrdersIn(List<Integer> values) {
      addCriterion("orders in", values, "orders");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andOrdersNotIn(List<Integer> values) {
      addCriterion("orders not in", values, "orders");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andOrdersBetween(Integer value1, Integer value2) {
      addCriterion("orders between", value1, value2, "orders");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andOrdersNotBetween(Integer value1, Integer value2) {
      addCriterion("orders not between", value1, value2, "orders");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andGradeIsNull() {
      addCriterion("grade is null");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andGradeIsNotNull() {
      addCriterion("grade is not null");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andGradeEqualTo(Integer value) {
      addCriterion("grade =", value, "grade");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andGradeNotEqualTo(Integer value) {
      addCriterion("grade <>", value, "grade");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andGradeGreaterThan(Integer value) {
      addCriterion("grade >", value, "grade");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andGradeGreaterThanOrEqualTo(Integer value) {
      addCriterion("grade >=", value, "grade");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andGradeLessThan(Integer value) {
      addCriterion("grade <", value, "grade");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andGradeLessThanOrEqualTo(Integer value) {
      addCriterion("grade <=", value, "grade");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andGradeIn(List<Integer> values) {
      addCriterion("grade in", values, "grade");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andGradeNotIn(List<Integer> values) {
      addCriterion("grade not in", values, "grade");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andGradeBetween(Integer value1, Integer value2) {
      addCriterion("grade between", value1, value2, "grade");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andGradeNotBetween(Integer value1, Integer value2) {
      addCriterion("grade not between", value1, value2, "grade");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andNameIsNull() {
      addCriterion("name is null");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andNameIsNotNull() {
      addCriterion("name is not null");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andNameEqualTo(String value) {
      addCriterion("name =", value, "name");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andNameNotEqualTo(String value) {
      addCriterion("name <>", value, "name");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andNameGreaterThan(String value) {
      addCriterion("name >", value, "name");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andNameGreaterThanOrEqualTo(String value) {
      addCriterion("name >=", value, "name");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andNameLessThan(String value) {
      addCriterion("name <", value, "name");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andNameLessThanOrEqualTo(String value) {
      addCriterion("name <=", value, "name");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andNameLike(String value) {
      addCriterion("name like", value, "name");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andNameNotLike(String value) {
      addCriterion("name not like", value, "name");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andNameIn(List<String> values) {
      addCriterion("name in", values, "name");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andNameNotIn(List<String> values) {
      addCriterion("name not in", values, "name");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andNameBetween(String value1, String value2) {
      addCriterion("name between", value1, value2, "name");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andNameNotBetween(String value1, String value2) {
      addCriterion("name not between", value1, value2, "name");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andSeoDescriptionIsNull() {
      addCriterion("seo_description is null");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andSeoDescriptionIsNotNull() {
      addCriterion("seo_description is not null");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andSeoDescriptionEqualTo(String value) {
      addCriterion("seo_description =", value, "seoDescription");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andSeoDescriptionNotEqualTo(String value) {
      addCriterion("seo_description <>", value, "seoDescription");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andSeoDescriptionGreaterThan(String value) {
      addCriterion("seo_description >", value, "seoDescription");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andSeoDescriptionGreaterThanOrEqualTo(String value) {
      addCriterion("seo_description >=", value, "seoDescription");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andSeoDescriptionLessThan(String value) {
      addCriterion("seo_description <", value, "seoDescription");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andSeoDescriptionLessThanOrEqualTo(String value) {
      addCriterion("seo_description <=", value, "seoDescription");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andSeoDescriptionLike(String value) {
      addCriterion("seo_description like", value, "seoDescription");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andSeoDescriptionNotLike(String value) {
      addCriterion("seo_description not like", value, "seoDescription");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andSeoDescriptionIn(List<String> values) {
      addCriterion("seo_description in", values, "seoDescription");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andSeoDescriptionNotIn(List<String> values) {
      addCriterion("seo_description not in", values, "seoDescription");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andSeoDescriptionBetween(String value1, String value2) {
      addCriterion("seo_description between", value1, value2, "seoDescription");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andSeoDescriptionNotBetween(String value1, String value2) {
      addCriterion("seo_description not between", value1, value2, "seoDescription");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andSeoKeywordsIsNull() {
      addCriterion("seo_keywords is null");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andSeoKeywordsIsNotNull() {
      addCriterion("seo_keywords is not null");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andSeoKeywordsEqualTo(String value) {
      addCriterion("seo_keywords =", value, "seoKeywords");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andSeoKeywordsNotEqualTo(String value) {
      addCriterion("seo_keywords <>", value, "seoKeywords");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andSeoKeywordsGreaterThan(String value) {
      addCriterion("seo_keywords >", value, "seoKeywords");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andSeoKeywordsGreaterThanOrEqualTo(String value) {
      addCriterion("seo_keywords >=", value, "seoKeywords");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andSeoKeywordsLessThan(String value) {
      addCriterion("seo_keywords <", value, "seoKeywords");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andSeoKeywordsLessThanOrEqualTo(String value) {
      addCriterion("seo_keywords <=", value, "seoKeywords");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andSeoKeywordsLike(String value) {
      addCriterion("seo_keywords like", value, "seoKeywords");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andSeoKeywordsNotLike(String value) {
      addCriterion("seo_keywords not like", value, "seoKeywords");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andSeoKeywordsIn(List<String> values) {
      addCriterion("seo_keywords in", values, "seoKeywords");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andSeoKeywordsNotIn(List<String> values) {
      addCriterion("seo_keywords not in", values, "seoKeywords");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andSeoKeywordsBetween(String value1, String value2) {
      addCriterion("seo_keywords between", value1, value2, "seoKeywords");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andSeoKeywordsNotBetween(String value1, String value2) {
      addCriterion("seo_keywords not between", value1, value2, "seoKeywords");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andSeoTitleIsNull() {
      addCriterion("seo_title is null");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andSeoTitleIsNotNull() {
      addCriterion("seo_title is not null");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andSeoTitleEqualTo(String value) {
      addCriterion("seo_title =", value, "seoTitle");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andSeoTitleNotEqualTo(String value) {
      addCriterion("seo_title <>", value, "seoTitle");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andSeoTitleGreaterThan(String value) {
      addCriterion("seo_title >", value, "seoTitle");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andSeoTitleGreaterThanOrEqualTo(String value) {
      addCriterion("seo_title >=", value, "seoTitle");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andSeoTitleLessThan(String value) {
      addCriterion("seo_title <", value, "seoTitle");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andSeoTitleLessThanOrEqualTo(String value) {
      addCriterion("seo_title <=", value, "seoTitle");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andSeoTitleLike(String value) {
      addCriterion("seo_title like", value, "seoTitle");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andSeoTitleNotLike(String value) {
      addCriterion("seo_title not like", value, "seoTitle");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andSeoTitleIn(List<String> values) {
      addCriterion("seo_title in", values, "seoTitle");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andSeoTitleNotIn(List<String> values) {
      addCriterion("seo_title not in", values, "seoTitle");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andSeoTitleBetween(String value1, String value2) {
      addCriterion("seo_title between", value1, value2, "seoTitle");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andSeoTitleNotBetween(String value1, String value2) {
      addCriterion("seo_title not between", value1, value2, "seoTitle");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andTreePathIsNull() {
      addCriterion("tree_path is null");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andTreePathIsNotNull() {
      addCriterion("tree_path is not null");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andTreePathEqualTo(String value) {
      addCriterion("tree_path =", value, "treePath");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andTreePathNotEqualTo(String value) {
      addCriterion("tree_path <>", value, "treePath");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andTreePathGreaterThan(String value) {
      addCriterion("tree_path >", value, "treePath");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andTreePathGreaterThanOrEqualTo(String value) {
      addCriterion("tree_path >=", value, "treePath");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andTreePathLessThan(String value) {
      addCriterion("tree_path <", value, "treePath");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andTreePathLessThanOrEqualTo(String value) {
      addCriterion("tree_path <=", value, "treePath");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andTreePathLike(String value) {
      addCriterion("tree_path like", value, "treePath");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andTreePathNotLike(String value) {
      addCriterion("tree_path not like", value, "treePath");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andTreePathIn(List<String> values) {
      addCriterion("tree_path in", values, "treePath");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andTreePathNotIn(List<String> values) {
      addCriterion("tree_path not in", values, "treePath");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andTreePathBetween(String value1, String value2) {
      addCriterion("tree_path between", value1, value2, "treePath");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andTreePathNotBetween(String value1, String value2) {
      addCriterion("tree_path not between", value1, value2, "treePath");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andParentIsNull() {
      addCriterion("parent is null");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andParentIsNotNull() {
      addCriterion("parent is not null");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andParentEqualTo(Long value) {
      addCriterion("parent =", value, "parent");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andParentNotEqualTo(Long value) {
      addCriterion("parent <>", value, "parent");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andParentGreaterThan(Long value) {
      addCriterion("parent >", value, "parent");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andParentGreaterThanOrEqualTo(Long value) {
      addCriterion("parent >=", value, "parent");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andParentLessThan(Long value) {
      addCriterion("parent <", value, "parent");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andParentLessThanOrEqualTo(Long value) {
      addCriterion("parent <=", value, "parent");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andParentIn(List<Long> values) {
      addCriterion("parent in", values, "parent");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andParentNotIn(List<Long> values) {
      addCriterion("parent not in", values, "parent");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andParentBetween(Long value1, Long value2) {
      addCriterion("parent between", value1, value2, "parent");
      return ((ArticlecategoryExample.Criteria)this);
    }

    public ArticlecategoryExample.Criteria andParentNotBetween(Long value1, Long value2) {
      addCriterion("parent not between", value1, value2, "parent");
      return ((ArticlecategoryExample.Criteria)this);
    }
  }
}