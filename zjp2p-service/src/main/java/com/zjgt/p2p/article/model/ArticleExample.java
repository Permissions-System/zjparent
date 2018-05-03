package com.zjgt.p2p.article.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ArticleExample
{
  protected String orderByClause;
  protected boolean distinct;
  protected Integer startPos;
  protected Integer pageSize;
  protected List<Criteria> oredCriteria;

  public ArticleExample()
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

  public Integer getStartPos() {
    return this.startPos;
  }

  public void setStartPos(Integer startPos) {
    this.startPos = startPos;
  }

  public Integer getPageSize() {
    return this.pageSize;
  }

  public void setPageSize(Integer pageSize) {
    this.pageSize = pageSize;
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

  public static class Criteria extends ArticleExample.GeneratedCriteria
  {
  }

  protected static abstract class GeneratedCriteria
  {
    protected List<ArticleExample.Criterion> criteria;

    protected GeneratedCriteria()
    {
      this.criteria = new ArrayList();
    }

    public boolean isValid() {
      return (this.criteria.size() > 0);
    }

    public List<ArticleExample.Criterion> getAllCriteria() {
      return this.criteria;
    }

    public List<ArticleExample.Criterion> getCriteria() {
      return this.criteria;
    }

    protected void addCriterion(String condition) {
      if (condition == null) {
        throw new RuntimeException("Value for condition cannot be null");
      }
      this.criteria.add(new ArticleExample.Criterion(condition));
    }

    protected void addCriterion(String condition, Object value, String property) {
      if (value == null) {
        throw new RuntimeException("Value for " + property + " cannot be null");
      }
      this.criteria.add(new ArticleExample.Criterion(condition, value));
    }

    protected void addCriterion(String condition, Object value1, Object value2, String property) {
      if ((value1 == null) || (value2 == null)) {
        throw new RuntimeException("Between values for " + property + " cannot be null");
      }
      this.criteria.add(new ArticleExample.Criterion(condition, value1, value2));
    }

    public ArticleExample.Criteria andIdIsNull() {
      addCriterion("id is null");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andIdIsNotNull() {
      addCriterion("id is not null");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andIdEqualTo(Long value) {
      addCriterion("id =", value, "id");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andIdNotEqualTo(Long value) {
      addCriterion("id <>", value, "id");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andIdGreaterThan(Long value) {
      addCriterion("id >", value, "id");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andIdGreaterThanOrEqualTo(Long value) {
      addCriterion("id >=", value, "id");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andIdLessThan(Long value) {
      addCriterion("id <", value, "id");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andIdLessThanOrEqualTo(Long value) {
      addCriterion("id <=", value, "id");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andIdIn(List<Long> values) {
      addCriterion("id in", values, "id");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andIdNotIn(List<Long> values) {
      addCriterion("id not in", values, "id");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andIdBetween(Long value1, Long value2) {
      addCriterion("id between", value1, value2, "id");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andIdNotBetween(Long value1, Long value2) {
      addCriterion("id not between", value1, value2, "id");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andCreateDateIsNull() {
      addCriterion("create_date is null");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andCreateDateIsNotNull() {
      addCriterion("create_date is not null");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andCreateDateEqualTo(Date value) {
      addCriterion("create_date =", value, "createDate");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andCreateDateNotEqualTo(Date value) {
      addCriterion("create_date <>", value, "createDate");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andCreateDateGreaterThan(Date value) {
      addCriterion("create_date >", value, "createDate");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
      addCriterion("create_date >=", value, "createDate");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andCreateDateLessThan(Date value) {
      addCriterion("create_date <", value, "createDate");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andCreateDateLessThanOrEqualTo(Date value) {
      addCriterion("create_date <=", value, "createDate");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andCreateDateIn(List<Date> values) {
      addCriterion("create_date in", values, "createDate");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andCreateDateNotIn(List<Date> values) {
      addCriterion("create_date not in", values, "createDate");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andCreateDateBetween(Date value1, Date value2) {
      addCriterion("create_date between", value1, value2, "createDate");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andCreateDateNotBetween(Date value1, Date value2) {
      addCriterion("create_date not between", value1, value2, "createDate");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andModifyDateIsNull() {
      addCriterion("modify_date is null");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andModifyDateIsNotNull() {
      addCriterion("modify_date is not null");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andModifyDateEqualTo(Date value) {
      addCriterion("modify_date =", value, "modifyDate");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andModifyDateNotEqualTo(Date value) {
      addCriterion("modify_date <>", value, "modifyDate");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andModifyDateGreaterThan(Date value) {
      addCriterion("modify_date >", value, "modifyDate");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andModifyDateGreaterThanOrEqualTo(Date value) {
      addCriterion("modify_date >=", value, "modifyDate");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andModifyDateLessThan(Date value) {
      addCriterion("modify_date <", value, "modifyDate");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andModifyDateLessThanOrEqualTo(Date value) {
      addCriterion("modify_date <=", value, "modifyDate");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andModifyDateIn(List<Date> values) {
      addCriterion("modify_date in", values, "modifyDate");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andModifyDateNotIn(List<Date> values) {
      addCriterion("modify_date not in", values, "modifyDate");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andModifyDateBetween(Date value1, Date value2) {
      addCriterion("modify_date between", value1, value2, "modifyDate");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andModifyDateNotBetween(Date value1, Date value2) {
      addCriterion("modify_date not between", value1, value2, "modifyDate");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andAuthorIsNull() {
      addCriterion("author is null");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andAuthorIsNotNull() {
      addCriterion("author is not null");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andAuthorEqualTo(String value) {
      addCriterion("author =", value, "author");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andAuthorNotEqualTo(String value) {
      addCriterion("author <>", value, "author");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andAuthorGreaterThan(String value) {
      addCriterion("author >", value, "author");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andAuthorGreaterThanOrEqualTo(String value) {
      addCriterion("author >=", value, "author");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andAuthorLessThan(String value) {
      addCriterion("author <", value, "author");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andAuthorLessThanOrEqualTo(String value) {
      addCriterion("author <=", value, "author");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andAuthorLike(String value) {
      addCriterion("author like", value, "author");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andAuthorNotLike(String value) {
      addCriterion("author not like", value, "author");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andAuthorIn(List<String> values) {
      addCriterion("author in", values, "author");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andAuthorNotIn(List<String> values) {
      addCriterion("author not in", values, "author");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andAuthorBetween(String value1, String value2) {
      addCriterion("author between", value1, value2, "author");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andAuthorNotBetween(String value1, String value2) {
      addCriterion("author not between", value1, value2, "author");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andHitsIsNull() {
      addCriterion("hits is null");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andHitsIsNotNull() {
      addCriterion("hits is not null");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andHitsEqualTo(Long value) {
      addCriterion("hits =", value, "hits");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andHitsNotEqualTo(Long value) {
      addCriterion("hits <>", value, "hits");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andHitsGreaterThan(Long value) {
      addCriterion("hits >", value, "hits");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andHitsGreaterThanOrEqualTo(Long value) {
      addCriterion("hits >=", value, "hits");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andHitsLessThan(Long value) {
      addCriterion("hits <", value, "hits");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andHitsLessThanOrEqualTo(Long value) {
      addCriterion("hits <=", value, "hits");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andHitsIn(List<Long> values) {
      addCriterion("hits in", values, "hits");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andHitsNotIn(List<Long> values) {
      addCriterion("hits not in", values, "hits");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andHitsBetween(Long value1, Long value2) {
      addCriterion("hits between", value1, value2, "hits");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andHitsNotBetween(Long value1, Long value2) {
      addCriterion("hits not between", value1, value2, "hits");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andIsPublicationIsNull() {
      addCriterion("is_publication is null");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andIsPublicationIsNotNull() {
      addCriterion("is_publication is not null");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andIsPublicationEqualTo(Boolean value) {
      addCriterion("is_publication =", value, "isPublication");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andIsPublicationNotEqualTo(Boolean value) {
      addCriterion("is_publication <>", value, "isPublication");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andIsPublicationGreaterThan(Boolean value) {
      addCriterion("is_publication >", value, "isPublication");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andIsPublicationGreaterThanOrEqualTo(Boolean value) {
      addCriterion("is_publication >=", value, "isPublication");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andIsPublicationLessThan(Boolean value) {
      addCriterion("is_publication <", value, "isPublication");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andIsPublicationLessThanOrEqualTo(Boolean value) {
      addCriterion("is_publication <=", value, "isPublication");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andIsPublicationIn(List<Boolean> values) {
      addCriterion("is_publication in", values, "isPublication");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andIsPublicationNotIn(List<Boolean> values) {
      addCriterion("is_publication not in", values, "isPublication");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andIsPublicationBetween(Boolean value1, Boolean value2) {
      addCriterion("is_publication between", value1, value2, "isPublication");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andIsPublicationNotBetween(Boolean value1, Boolean value2) {
      addCriterion("is_publication not between", value1, value2, "isPublication");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andIsTopIsNull() {
      addCriterion("is_top is null");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andIsTopIsNotNull() {
      addCriterion("is_top is not null");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andIsTopEqualTo(Boolean value) {
      addCriterion("is_top =", value, "isTop");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andIsTopNotEqualTo(Boolean value) {
      addCriterion("is_top <>", value, "isTop");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andIsTopGreaterThan(Boolean value) {
      addCriterion("is_top >", value, "isTop");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andIsTopGreaterThanOrEqualTo(Boolean value) {
      addCriterion("is_top >=", value, "isTop");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andIsTopLessThan(Boolean value) {
      addCriterion("is_top <", value, "isTop");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andIsTopLessThanOrEqualTo(Boolean value) {
      addCriterion("is_top <=", value, "isTop");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andIsTopIn(List<Boolean> values) {
      addCriterion("is_top in", values, "isTop");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andIsTopNotIn(List<Boolean> values) {
      addCriterion("is_top not in", values, "isTop");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andIsTopBetween(Boolean value1, Boolean value2) {
      addCriterion("is_top between", value1, value2, "isTop");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andIsTopNotBetween(Boolean value1, Boolean value2) {
      addCriterion("is_top not between", value1, value2, "isTop");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andSeoDescriptionIsNull() {
      addCriterion("seo_description is null");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andSeoDescriptionIsNotNull() {
      addCriterion("seo_description is not null");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andSeoDescriptionEqualTo(String value) {
      addCriterion("seo_description =", value, "seoDescription");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andSeoDescriptionNotEqualTo(String value) {
      addCriterion("seo_description <>", value, "seoDescription");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andSeoDescriptionGreaterThan(String value) {
      addCriterion("seo_description >", value, "seoDescription");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andSeoDescriptionGreaterThanOrEqualTo(String value) {
      addCriterion("seo_description >=", value, "seoDescription");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andSeoDescriptionLessThan(String value) {
      addCriterion("seo_description <", value, "seoDescription");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andSeoDescriptionLessThanOrEqualTo(String value) {
      addCriterion("seo_description <=", value, "seoDescription");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andSeoDescriptionLike(String value) {
      addCriterion("seo_description like", value, "seoDescription");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andSeoDescriptionNotLike(String value) {
      addCriterion("seo_description not like", value, "seoDescription");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andSeoDescriptionIn(List<String> values) {
      addCriterion("seo_description in", values, "seoDescription");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andSeoDescriptionNotIn(List<String> values) {
      addCriterion("seo_description not in", values, "seoDescription");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andSeoDescriptionBetween(String value1, String value2) {
      addCriterion("seo_description between", value1, value2, "seoDescription");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andSeoDescriptionNotBetween(String value1, String value2) {
      addCriterion("seo_description not between", value1, value2, "seoDescription");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andSeoKeywordsIsNull() {
      addCriterion("seo_keywords is null");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andSeoKeywordsIsNotNull() {
      addCriterion("seo_keywords is not null");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andSeoKeywordsEqualTo(String value) {
      addCriterion("seo_keywords =", value, "seoKeywords");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andSeoKeywordsNotEqualTo(String value) {
      addCriterion("seo_keywords <>", value, "seoKeywords");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andSeoKeywordsGreaterThan(String value) {
      addCriterion("seo_keywords >", value, "seoKeywords");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andSeoKeywordsGreaterThanOrEqualTo(String value) {
      addCriterion("seo_keywords >=", value, "seoKeywords");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andSeoKeywordsLessThan(String value) {
      addCriterion("seo_keywords <", value, "seoKeywords");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andSeoKeywordsLessThanOrEqualTo(String value) {
      addCriterion("seo_keywords <=", value, "seoKeywords");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andSeoKeywordsLike(String value) {
      addCriterion("seo_keywords like", value, "seoKeywords");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andSeoKeywordsNotLike(String value) {
      addCriterion("seo_keywords not like", value, "seoKeywords");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andSeoKeywordsIn(List<String> values) {
      addCriterion("seo_keywords in", values, "seoKeywords");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andSeoKeywordsNotIn(List<String> values) {
      addCriterion("seo_keywords not in", values, "seoKeywords");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andSeoKeywordsBetween(String value1, String value2) {
      addCriterion("seo_keywords between", value1, value2, "seoKeywords");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andSeoKeywordsNotBetween(String value1, String value2) {
      addCriterion("seo_keywords not between", value1, value2, "seoKeywords");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andSeoTitleIsNull() {
      addCriterion("seo_title is null");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andSeoTitleIsNotNull() {
      addCriterion("seo_title is not null");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andSeoTitleEqualTo(String value) {
      addCriterion("seo_title =", value, "seoTitle");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andSeoTitleNotEqualTo(String value) {
      addCriterion("seo_title <>", value, "seoTitle");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andSeoTitleGreaterThan(String value) {
      addCriterion("seo_title >", value, "seoTitle");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andSeoTitleGreaterThanOrEqualTo(String value) {
      addCriterion("seo_title >=", value, "seoTitle");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andSeoTitleLessThan(String value) {
      addCriterion("seo_title <", value, "seoTitle");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andSeoTitleLessThanOrEqualTo(String value) {
      addCriterion("seo_title <=", value, "seoTitle");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andSeoTitleLike(String value) {
      addCriterion("seo_title like", value, "seoTitle");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andSeoTitleNotLike(String value) {
      addCriterion("seo_title not like", value, "seoTitle");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andSeoTitleIn(List<String> values) {
      addCriterion("seo_title in", values, "seoTitle");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andSeoTitleNotIn(List<String> values) {
      addCriterion("seo_title not in", values, "seoTitle");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andSeoTitleBetween(String value1, String value2) {
      addCriterion("seo_title between", value1, value2, "seoTitle");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andSeoTitleNotBetween(String value1, String value2) {
      addCriterion("seo_title not between", value1, value2, "seoTitle");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andTitleIsNull() {
      addCriterion("title is null");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andTitleIsNotNull() {
      addCriterion("title is not null");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andTitleEqualTo(String value) {
      addCriterion("title =", value, "title");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andTitleNotEqualTo(String value) {
      addCriterion("title <>", value, "title");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andTitleGreaterThan(String value) {
      addCriterion("title >", value, "title");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andTitleGreaterThanOrEqualTo(String value) {
      addCriterion("title >=", value, "title");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andTitleLessThan(String value) {
      addCriterion("title <", value, "title");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andTitleLessThanOrEqualTo(String value) {
      addCriterion("title <=", value, "title");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andTitleLike(String value) {
      addCriterion("title like", value, "title");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andTitleNotLike(String value) {
      addCriterion("title not like", value, "title");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andTitleIn(List<String> values) {
      addCriterion("title in", values, "title");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andTitleNotIn(List<String> values) {
      addCriterion("title not in", values, "title");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andTitleBetween(String value1, String value2) {
      addCriterion("title between", value1, value2, "title");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andTitleNotBetween(String value1, String value2) {
      addCriterion("title not between", value1, value2, "title");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andCategoryidIsNull() {
      addCriterion("categoryid is null");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andCategoryidIsNotNull() {
      addCriterion("categoryid is not null");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andCategoryidEqualTo(Long value) {
      addCriterion("categoryid =", value, "categoryid");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andCategoryidNotEqualTo(Long value) {
      addCriterion("categoryid <>", value, "categoryid");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andCategoryidGreaterThan(Long value) {
      addCriterion("categoryid >", value, "categoryid");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andCategoryidGreaterThanOrEqualTo(Long value) {
      addCriterion("categoryid >=", value, "categoryid");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andCategoryidLessThan(Long value) {
      addCriterion("categoryid <", value, "categoryid");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andCategoryidLessThanOrEqualTo(Long value) {
      addCriterion("categoryid <=", value, "categoryid");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andCategoryidIn(List<Long> values) {
      addCriterion("categoryid in", values, "categoryid");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andCategoryidNotIn(List<Long> values) {
      addCriterion("categoryid not in", values, "categoryid");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andCategoryidBetween(Long value1, Long value2) {
      addCriterion("categoryid between", value1, value2, "categoryid");
      return ((ArticleExample.Criteria)this);
    }

    public ArticleExample.Criteria andCategoryidNotBetween(Long value1, Long value2) {
      addCriterion("categoryid not between", value1, value2, "categoryid");
      return ((ArticleExample.Criteria)this);
    }
  }
}