package com.zjgt.p2p.article.model;

import java.util.ArrayList;
import java.util.List;

public class ArticletagExample
{
  protected String orderByClause;
  protected boolean distinct;
  protected List<Criteria> oredCriteria;

  public ArticletagExample()
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

  public static class Criteria extends ArticletagExample.GeneratedCriteria
  {
  }

  protected static abstract class GeneratedCriteria
  {
    protected List<ArticletagExample.Criterion> criteria;

    protected GeneratedCriteria()
    {
      this.criteria = new ArrayList();
    }

    public boolean isValid() {
      return (this.criteria.size() > 0);
    }

    public List<ArticletagExample.Criterion> getAllCriteria() {
      return this.criteria;
    }

    public List<ArticletagExample.Criterion> getCriteria() {
      return this.criteria;
    }

    protected void addCriterion(String condition) {
      if (condition == null) {
        throw new RuntimeException("Value for condition cannot be null");
      }
      this.criteria.add(new ArticletagExample.Criterion(condition));
    }

    protected void addCriterion(String condition, Object value, String property) {
      if (value == null) {
        throw new RuntimeException("Value for " + property + " cannot be null");
      }
      this.criteria.add(new ArticletagExample.Criterion(condition, value));
    }

    protected void addCriterion(String condition, Object value1, Object value2, String property) {
      if ((value1 == null) || (value2 == null)) {
        throw new RuntimeException("Between values for " + property + " cannot be null");
      }
      this.criteria.add(new ArticletagExample.Criterion(condition, value1, value2));
    }

    public ArticletagExample.Criteria andArticlesIsNull() {
      addCriterion("articles is null");
      return ((ArticletagExample.Criteria)this);
    }

    public ArticletagExample.Criteria andArticlesIsNotNull() {
      addCriterion("articles is not null");
      return ((ArticletagExample.Criteria)this);
    }

    public ArticletagExample.Criteria andArticlesEqualTo(Long value) {
      addCriterion("articles =", value, "articles");
      return ((ArticletagExample.Criteria)this);
    }

    public ArticletagExample.Criteria andArticlesNotEqualTo(Long value) {
      addCriterion("articles <>", value, "articles");
      return ((ArticletagExample.Criteria)this);
    }

    public ArticletagExample.Criteria andArticlesGreaterThan(Long value) {
      addCriterion("articles >", value, "articles");
      return ((ArticletagExample.Criteria)this);
    }

    public ArticletagExample.Criteria andArticlesGreaterThanOrEqualTo(Long value) {
      addCriterion("articles >=", value, "articles");
      return ((ArticletagExample.Criteria)this);
    }

    public ArticletagExample.Criteria andArticlesLessThan(Long value) {
      addCriterion("articles <", value, "articles");
      return ((ArticletagExample.Criteria)this);
    }

    public ArticletagExample.Criteria andArticlesLessThanOrEqualTo(Long value) {
      addCriterion("articles <=", value, "articles");
      return ((ArticletagExample.Criteria)this);
    }

    public ArticletagExample.Criteria andArticlesIn(List<Long> values) {
      addCriterion("articles in", values, "articles");
      return ((ArticletagExample.Criteria)this);
    }

    public ArticletagExample.Criteria andArticlesNotIn(List<Long> values) {
      addCriterion("articles not in", values, "articles");
      return ((ArticletagExample.Criteria)this);
    }

    public ArticletagExample.Criteria andArticlesBetween(Long value1, Long value2) {
      addCriterion("articles between", value1, value2, "articles");
      return ((ArticletagExample.Criteria)this);
    }

    public ArticletagExample.Criteria andArticlesNotBetween(Long value1, Long value2) {
      addCriterion("articles not between", value1, value2, "articles");
      return ((ArticletagExample.Criteria)this);
    }

    public ArticletagExample.Criteria andTagsIsNull() {
      addCriterion("tags is null");
      return ((ArticletagExample.Criteria)this);
    }

    public ArticletagExample.Criteria andTagsIsNotNull() {
      addCriterion("tags is not null");
      return ((ArticletagExample.Criteria)this);
    }

    public ArticletagExample.Criteria andTagsEqualTo(Long value) {
      addCriterion("tags =", value, "tags");
      return ((ArticletagExample.Criteria)this);
    }

    public ArticletagExample.Criteria andTagsNotEqualTo(Long value) {
      addCriterion("tags <>", value, "tags");
      return ((ArticletagExample.Criteria)this);
    }

    public ArticletagExample.Criteria andTagsGreaterThan(Long value) {
      addCriterion("tags >", value, "tags");
      return ((ArticletagExample.Criteria)this);
    }

    public ArticletagExample.Criteria andTagsGreaterThanOrEqualTo(Long value) {
      addCriterion("tags >=", value, "tags");
      return ((ArticletagExample.Criteria)this);
    }

    public ArticletagExample.Criteria andTagsLessThan(Long value) {
      addCriterion("tags <", value, "tags");
      return ((ArticletagExample.Criteria)this);
    }

    public ArticletagExample.Criteria andTagsLessThanOrEqualTo(Long value) {
      addCriterion("tags <=", value, "tags");
      return ((ArticletagExample.Criteria)this);
    }

    public ArticletagExample.Criteria andTagsIn(List<Long> values) {
      addCriterion("tags in", values, "tags");
      return ((ArticletagExample.Criteria)this);
    }

    public ArticletagExample.Criteria andTagsNotIn(List<Long> values) {
      addCriterion("tags not in", values, "tags");
      return ((ArticletagExample.Criteria)this);
    }

    public ArticletagExample.Criteria andTagsBetween(Long value1, Long value2) {
      addCriterion("tags between", value1, value2, "tags");
      return ((ArticletagExample.Criteria)this);
    }

    public ArticletagExample.Criteria andTagsNotBetween(Long value1, Long value2) {
      addCriterion("tags not between", value1, value2, "tags");
      return ((ArticletagExample.Criteria)this);
    }
  }
}