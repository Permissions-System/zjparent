package com.zjgt.p2p.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BorrowerExample
{
  protected String orderByClause;
  protected boolean distinct;
  protected Integer startPos;
  protected Integer pageSize;
  protected List<Criteria> oredCriteria;

  public BorrowerExample()
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

  public Integer getStartPos()
  {
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

  public static class Criteria extends BorrowerExample.GeneratedCriteria
  {
  }

  protected static abstract class GeneratedCriteria
  {
    protected List<BorrowerExample.Criterion> criteria;

    protected GeneratedCriteria()
    {
      this.criteria = new ArrayList();
    }

    public boolean isValid() {
      return (this.criteria.size() > 0);
    }

    public List<BorrowerExample.Criterion> getAllCriteria() {
      return this.criteria;
    }

    public List<BorrowerExample.Criterion> getCriteria() {
      return this.criteria;
    }

    protected void addCriterion(String condition) {
      if (condition == null) {
        throw new RuntimeException("Value for condition cannot be null");
      }
      this.criteria.add(new BorrowerExample.Criterion(condition));
    }

    protected void addCriterion(String condition, Object value, String property) {
      if (value == null) {
        throw new RuntimeException("Value for " + property + " cannot be null");
      }
      this.criteria.add(new BorrowerExample.Criterion(condition, value));
    }

    protected void addCriterion(String condition, Object value1, Object value2, String property) {
      if ((value1 == null) || (value2 == null)) {
        throw new RuntimeException("Between values for " + property + " cannot be null");
      }
      this.criteria.add(new BorrowerExample.Criterion(condition, value1, value2));
    }

    protected void addCriterionForJDBCDate(String condition, java.util.Date value, String property) {
      if (value == null) {
        throw new RuntimeException("Value for " + property + " cannot be null");
      }
      addCriterion(condition, new java.sql.Date(value.getTime()), property);
    }

    protected void addCriterionForJDBCDate(String condition, List<java.util.Date> values, String property) {
      if ((values == null) || (values.size() == 0)) {
        throw new RuntimeException("Value list for " + property + " cannot be null or empty");
      }
      List dateList = new ArrayList();
      Iterator iter = values.iterator();
      while (iter.hasNext()) {
        dateList.add(new java.sql.Date(((java.util.Date)iter.next()).getTime()));
      }
      addCriterion(condition, dateList, property);
    }

    protected void addCriterionForJDBCDate(String condition, java.util.Date value1, java.util.Date value2, String property) {
      if ((value1 == null) || (value2 == null)) {
        throw new RuntimeException("Between values for " + property + " cannot be null");
      }
      addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
    }

    public BorrowerExample.Criteria andIdIsNull() {
      addCriterion("ID is null");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andIdIsNotNull() {
      addCriterion("ID is not null");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andIdEqualTo(Integer value) {
      addCriterion("ID =", value, "id");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andIdNotEqualTo(Integer value) {
      addCriterion("ID <>", value, "id");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andIdGreaterThan(Integer value) {
      addCriterion("ID >", value, "id");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andIdGreaterThanOrEqualTo(Integer value) {
      addCriterion("ID >=", value, "id");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andIdLessThan(Integer value) {
      addCriterion("ID <", value, "id");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andIdLessThanOrEqualTo(Integer value) {
      addCriterion("ID <=", value, "id");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andIdIn(List<Integer> values) {
      addCriterion("ID in", values, "id");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andIdNotIn(List<Integer> values) {
      addCriterion("ID not in", values, "id");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andIdBetween(Integer value1, Integer value2) {
      addCriterion("ID between", value1, value2, "id");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andIdNotBetween(Integer value1, Integer value2) {
      addCriterion("ID not between", value1, value2, "id");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andBorrowercodeIsNull() {
      addCriterion("borrowerCode is null");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andBorrowercodeIsNotNull() {
      addCriterion("borrowerCode is not null");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andBorrowercodeEqualTo(String value) {
      addCriterion("borrowerCode =", value, "borrowercode");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andBorrowercodeNotEqualTo(String value) {
      addCriterion("borrowerCode <>", value, "borrowercode");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andBorrowercodeGreaterThan(String value) {
      addCriterion("borrowerCode >", value, "borrowercode");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andBorrowercodeGreaterThanOrEqualTo(String value) {
      addCriterion("borrowerCode >=", value, "borrowercode");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andBorrowercodeLessThan(String value) {
      addCriterion("borrowerCode <", value, "borrowercode");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andBorrowercodeLessThanOrEqualTo(String value) {
      addCriterion("borrowerCode <=", value, "borrowercode");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andBorrowercodeLike(String value) {
      addCriterion("borrowerCode like", value, "borrowercode");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andBorrowercodeNotLike(String value) {
      addCriterion("borrowerCode not like", value, "borrowercode");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andBorrowercodeIn(List<String> values) {
      addCriterion("borrowerCode in", values, "borrowercode");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andBorrowercodeNotIn(List<String> values) {
      addCriterion("borrowerCode not in", values, "borrowercode");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andBorrowercodeBetween(String value1, String value2) {
      addCriterion("borrowerCode between", value1, value2, "borrowercode");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andBorrowercodeNotBetween(String value1, String value2) {
      addCriterion("borrowerCode not between", value1, value2, "borrowercode");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andFullnameIsNull() {
      addCriterion("FullName is null");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andFullnameIsNotNull() {
      addCriterion("FullName is not null");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andFullnameEqualTo(String value) {
      addCriterion("FullName =", value, "fullname");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andFullnameNotEqualTo(String value) {
      addCriterion("FullName <>", value, "fullname");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andFullnameGreaterThan(String value) {
      addCriterion("FullName >", value, "fullname");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andFullnameGreaterThanOrEqualTo(String value) {
      addCriterion("FullName >=", value, "fullname");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andFullnameLessThan(String value) {
      addCriterion("FullName <", value, "fullname");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andFullnameLessThanOrEqualTo(String value) {
      addCriterion("FullName <=", value, "fullname");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andFullnameLike(String value) {
      addCriterion("FullName like", value, "fullname");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andFullnameNotLike(String value) {
      addCriterion("FullName not like", value, "fullname");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andFullnameIn(List<String> values) {
      addCriterion("FullName in", values, "fullname");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andFullnameNotIn(List<String> values) {
      addCriterion("FullName not in", values, "fullname");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andFullnameBetween(String value1, String value2) {
      addCriterion("FullName between", value1, value2, "fullname");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andFullnameNotBetween(String value1, String value2) {
      addCriterion("FullName not between", value1, value2, "fullname");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andBorrowernameIsNull() {
      addCriterion("borrowername is null");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andBorrowernameIsNotNull() {
      addCriterion("borrowername is not null");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andBorrowernameEqualTo(String value) {
      addCriterion("borrowername =", value, "borrowername");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andBorrowernameNotEqualTo(String value) {
      addCriterion("borrowername <>", value, "borrowername");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andBorrowernameGreaterThan(String value) {
      addCriterion("borrowername >", value, "borrowername");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andBorrowernameGreaterThanOrEqualTo(String value) {
      addCriterion("borrowername >=", value, "borrowername");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andBorrowernameLessThan(String value) {
      addCriterion("borrowername <", value, "borrowername");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andBorrowernameLessThanOrEqualTo(String value) {
      addCriterion("borrowername <=", value, "borrowername");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andBorrowernameLike(String value) {
      addCriterion("borrowername like", value, "borrowername");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andBorrowernameNotLike(String value) {
      addCriterion("borrowername not like", value, "borrowername");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andBorrowernameIn(List<String> values) {
      addCriterion("borrowername in", values, "borrowername");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andBorrowernameNotIn(List<String> values) {
      addCriterion("borrowername not in", values, "borrowername");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andBorrowernameBetween(String value1, String value2) {
      addCriterion("borrowername between", value1, value2, "borrowername");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andBorrowernameNotBetween(String value1, String value2) {
      addCriterion("borrowername not between", value1, value2, "borrowername");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andCorpdescIsNull() {
      addCriterion("corpDesc is null");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andCorpdescIsNotNull() {
      addCriterion("corpDesc is not null");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andCorpdescEqualTo(String value) {
      addCriterion("corpDesc =", value, "corpdesc");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andCorpdescNotEqualTo(String value) {
      addCriterion("corpDesc <>", value, "corpdesc");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andCorpdescGreaterThan(String value) {
      addCriterion("corpDesc >", value, "corpdesc");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andCorpdescGreaterThanOrEqualTo(String value) {
      addCriterion("corpDesc >=", value, "corpdesc");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andCorpdescLessThan(String value) {
      addCriterion("corpDesc <", value, "corpdesc");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andCorpdescLessThanOrEqualTo(String value) {
      addCriterion("corpDesc <=", value, "corpdesc");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andCorpdescLike(String value) {
      addCriterion("corpDesc like", value, "corpdesc");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andCorpdescNotLike(String value) {
      addCriterion("corpDesc not like", value, "corpdesc");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andCorpdescIn(List<String> values) {
      addCriterion("corpDesc in", values, "corpdesc");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andCorpdescNotIn(List<String> values) {
      addCriterion("corpDesc not in", values, "corpdesc");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andCorpdescBetween(String value1, String value2) {
      addCriterion("corpDesc between", value1, value2, "corpdesc");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andCorpdescNotBetween(String value1, String value2) {
      addCriterion("corpDesc not between", value1, value2, "corpdesc");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andCorplogoIsNull() {
      addCriterion("corpLogo is null");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andCorplogoIsNotNull() {
      addCriterion("corpLogo is not null");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andCorplogoEqualTo(String value) {
      addCriterion("corpLogo =", value, "corplogo");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andCorplogoNotEqualTo(String value) {
      addCriterion("corpLogo <>", value, "corplogo");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andCorplogoGreaterThan(String value) {
      addCriterion("corpLogo >", value, "corplogo");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andCorplogoGreaterThanOrEqualTo(String value) {
      addCriterion("corpLogo >=", value, "corplogo");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andCorplogoLessThan(String value) {
      addCriterion("corpLogo <", value, "corplogo");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andCorplogoLessThanOrEqualTo(String value) {
      addCriterion("corpLogo <=", value, "corplogo");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andCorplogoLike(String value) {
      addCriterion("corpLogo like", value, "corplogo");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andCorplogoNotLike(String value) {
      addCriterion("corpLogo not like", value, "corplogo");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andCorplogoIn(List<String> values) {
      addCriterion("corpLogo in", values, "corplogo");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andCorplogoNotIn(List<String> values) {
      addCriterion("corpLogo not in", values, "corplogo");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andCorplogoBetween(String value1, String value2) {
      addCriterion("corpLogo between", value1, value2, "corplogo");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andCorplogoNotBetween(String value1, String value2) {
      addCriterion("corpLogo not between", value1, value2, "corplogo");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andUporgIsNull() {
      addCriterion("UpOrg is null");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andUporgIsNotNull() {
      addCriterion("UpOrg is not null");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andUporgEqualTo(String value) {
      addCriterion("UpOrg =", value, "uporg");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andUporgNotEqualTo(String value) {
      addCriterion("UpOrg <>", value, "uporg");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andUporgGreaterThan(String value) {
      addCriterion("UpOrg >", value, "uporg");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andUporgGreaterThanOrEqualTo(String value) {
      addCriterion("UpOrg >=", value, "uporg");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andUporgLessThan(String value) {
      addCriterion("UpOrg <", value, "uporg");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andUporgLessThanOrEqualTo(String value) {
      addCriterion("UpOrg <=", value, "uporg");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andUporgLike(String value) {
      addCriterion("UpOrg like", value, "uporg");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andUporgNotLike(String value) {
      addCriterion("UpOrg not like", value, "uporg");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andUporgIn(List<String> values) {
      addCriterion("UpOrg in", values, "uporg");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andUporgNotIn(List<String> values) {
      addCriterion("UpOrg not in", values, "uporg");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andUporgBetween(String value1, String value2) {
      addCriterion("UpOrg between", value1, value2, "uporg");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andUporgNotBetween(String value1, String value2) {
      addCriterion("UpOrg not between", value1, value2, "uporg");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andLevelIsNull() {
      addCriterion("Level is null");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andLevelIsNotNull() {
      addCriterion("Level is not null");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andLevelEqualTo(Integer value) {
      addCriterion("Level =", value, "level");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andLevelNotEqualTo(Integer value) {
      addCriterion("Level <>", value, "level");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andLevelGreaterThan(Integer value) {
      addCriterion("Level >", value, "level");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andLevelGreaterThanOrEqualTo(Integer value) {
      addCriterion("Level >=", value, "level");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andLevelLessThan(Integer value) {
      addCriterion("Level <", value, "level");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andLevelLessThanOrEqualTo(Integer value) {
      addCriterion("Level <=", value, "level");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andLevelIn(List<Integer> values) {
      addCriterion("Level in", values, "level");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andLevelNotIn(List<Integer> values) {
      addCriterion("Level not in", values, "level");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andLevelBetween(Integer value1, Integer value2) {
      addCriterion("Level between", value1, value2, "level");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andLevelNotBetween(Integer value1, Integer value2) {
      addCriterion("Level not between", value1, value2, "level");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andAddressIsNull() {
      addCriterion("Address is null");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andAddressIsNotNull() {
      addCriterion("Address is not null");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andAddressEqualTo(String value) {
      addCriterion("Address =", value, "address");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andAddressNotEqualTo(String value) {
      addCriterion("Address <>", value, "address");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andAddressGreaterThan(String value) {
      addCriterion("Address >", value, "address");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andAddressGreaterThanOrEqualTo(String value) {
      addCriterion("Address >=", value, "address");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andAddressLessThan(String value) {
      addCriterion("Address <", value, "address");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andAddressLessThanOrEqualTo(String value) {
      addCriterion("Address <=", value, "address");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andAddressLike(String value) {
      addCriterion("Address like", value, "address");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andAddressNotLike(String value) {
      addCriterion("Address not like", value, "address");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andAddressIn(List<String> values) {
      addCriterion("Address in", values, "address");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andAddressNotIn(List<String> values) {
      addCriterion("Address not in", values, "address");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andAddressBetween(String value1, String value2) {
      addCriterion("Address between", value1, value2, "address");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andAddressNotBetween(String value1, String value2) {
      addCriterion("Address not between", value1, value2, "address");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andContactpersonIsNull() {
      addCriterion("ContactPerson is null");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andContactpersonIsNotNull() {
      addCriterion("ContactPerson is not null");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andContactpersonEqualTo(String value) {
      addCriterion("ContactPerson =", value, "contactperson");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andContactpersonNotEqualTo(String value) {
      addCriterion("ContactPerson <>", value, "contactperson");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andContactpersonGreaterThan(String value) {
      addCriterion("ContactPerson >", value, "contactperson");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andContactpersonGreaterThanOrEqualTo(String value) {
      addCriterion("ContactPerson >=", value, "contactperson");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andContactpersonLessThan(String value) {
      addCriterion("ContactPerson <", value, "contactperson");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andContactpersonLessThanOrEqualTo(String value) {
      addCriterion("ContactPerson <=", value, "contactperson");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andContactpersonLike(String value) {
      addCriterion("ContactPerson like", value, "contactperson");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andContactpersonNotLike(String value) {
      addCriterion("ContactPerson not like", value, "contactperson");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andContactpersonIn(List<String> values) {
      addCriterion("ContactPerson in", values, "contactperson");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andContactpersonNotIn(List<String> values) {
      addCriterion("ContactPerson not in", values, "contactperson");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andContactpersonBetween(String value1, String value2) {
      addCriterion("ContactPerson between", value1, value2, "contactperson");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andContactpersonNotBetween(String value1, String value2) {
      addCriterion("ContactPerson not between", value1, value2, "contactperson");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andMobileIsNull() {
      addCriterion("Mobile is null");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andMobileIsNotNull() {
      addCriterion("Mobile is not null");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andMobileEqualTo(String value) {
      addCriterion("Mobile =", value, "mobile");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andMobileNotEqualTo(String value) {
      addCriterion("Mobile <>", value, "mobile");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andMobileGreaterThan(String value) {
      addCriterion("Mobile >", value, "mobile");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andMobileGreaterThanOrEqualTo(String value) {
      addCriterion("Mobile >=", value, "mobile");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andMobileLessThan(String value) {
      addCriterion("Mobile <", value, "mobile");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andMobileLessThanOrEqualTo(String value) {
      addCriterion("Mobile <=", value, "mobile");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andMobileLike(String value) {
      addCriterion("Mobile like", value, "mobile");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andMobileNotLike(String value) {
      addCriterion("Mobile not like", value, "mobile");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andMobileIn(List<String> values) {
      addCriterion("Mobile in", values, "mobile");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andMobileNotIn(List<String> values) {
      addCriterion("Mobile not in", values, "mobile");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andMobileBetween(String value1, String value2) {
      addCriterion("Mobile between", value1, value2, "mobile");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andMobileNotBetween(String value1, String value2) {
      addCriterion("Mobile not between", value1, value2, "mobile");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andPhoneIsNull() {
      addCriterion("Phone is null");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andPhoneIsNotNull() {
      addCriterion("Phone is not null");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andPhoneEqualTo(String value) {
      addCriterion("Phone =", value, "phone");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andPhoneNotEqualTo(String value) {
      addCriterion("Phone <>", value, "phone");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andPhoneGreaterThan(String value) {
      addCriterion("Phone >", value, "phone");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andPhoneGreaterThanOrEqualTo(String value) {
      addCriterion("Phone >=", value, "phone");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andPhoneLessThan(String value) {
      addCriterion("Phone <", value, "phone");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andPhoneLessThanOrEqualTo(String value) {
      addCriterion("Phone <=", value, "phone");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andPhoneLike(String value) {
      addCriterion("Phone like", value, "phone");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andPhoneNotLike(String value) {
      addCriterion("Phone not like", value, "phone");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andPhoneIn(List<String> values) {
      addCriterion("Phone in", values, "phone");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andPhoneNotIn(List<String> values) {
      addCriterion("Phone not in", values, "phone");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andPhoneBetween(String value1, String value2) {
      addCriterion("Phone between", value1, value2, "phone");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andPhoneNotBetween(String value1, String value2) {
      addCriterion("Phone not between", value1, value2, "phone");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andFaxIsNull() {
      addCriterion("Fax is null");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andFaxIsNotNull() {
      addCriterion("Fax is not null");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andFaxEqualTo(String value) {
      addCriterion("Fax =", value, "fax");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andFaxNotEqualTo(String value) {
      addCriterion("Fax <>", value, "fax");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andFaxGreaterThan(String value) {
      addCriterion("Fax >", value, "fax");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andFaxGreaterThanOrEqualTo(String value) {
      addCriterion("Fax >=", value, "fax");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andFaxLessThan(String value) {
      addCriterion("Fax <", value, "fax");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andFaxLessThanOrEqualTo(String value) {
      addCriterion("Fax <=", value, "fax");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andFaxLike(String value) {
      addCriterion("Fax like", value, "fax");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andFaxNotLike(String value) {
      addCriterion("Fax not like", value, "fax");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andFaxIn(List<String> values) {
      addCriterion("Fax in", values, "fax");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andFaxNotIn(List<String> values) {
      addCriterion("Fax not in", values, "fax");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andFaxBetween(String value1, String value2) {
      addCriterion("Fax between", value1, value2, "fax");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andFaxNotBetween(String value1, String value2) {
      addCriterion("Fax not between", value1, value2, "fax");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andEmailIsNull() {
      addCriterion("EMail is null");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andEmailIsNotNull() {
      addCriterion("EMail is not null");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andEmailEqualTo(String value) {
      addCriterion("EMail =", value, "email");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andEmailNotEqualTo(String value) {
      addCriterion("EMail <>", value, "email");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andEmailGreaterThan(String value) {
      addCriterion("EMail >", value, "email");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andEmailGreaterThanOrEqualTo(String value) {
      addCriterion("EMail >=", value, "email");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andEmailLessThan(String value) {
      addCriterion("EMail <", value, "email");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andEmailLessThanOrEqualTo(String value) {
      addCriterion("EMail <=", value, "email");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andEmailLike(String value) {
      addCriterion("EMail like", value, "email");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andEmailNotLike(String value) {
      addCriterion("EMail not like", value, "email");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andEmailIn(List<String> values) {
      addCriterion("EMail in", values, "email");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andEmailNotIn(List<String> values) {
      addCriterion("EMail not in", values, "email");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andEmailBetween(String value1, String value2) {
      addCriterion("EMail between", value1, value2, "email");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andEmailNotBetween(String value1, String value2) {
      addCriterion("EMail not between", value1, value2, "email");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andAgreement1IsNull() {
      addCriterion("agreement1 is null");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andAgreement1IsNotNull() {
      addCriterion("agreement1 is not null");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andAgreement1EqualTo(String value) {
      addCriterion("agreement1 =", value, "agreement1");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andAgreement1NotEqualTo(String value) {
      addCriterion("agreement1 <>", value, "agreement1");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andAgreement1GreaterThan(String value) {
      addCriterion("agreement1 >", value, "agreement1");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andAgreement1GreaterThanOrEqualTo(String value) {
      addCriterion("agreement1 >=", value, "agreement1");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andAgreement1LessThan(String value) {
      addCriterion("agreement1 <", value, "agreement1");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andAgreement1LessThanOrEqualTo(String value) {
      addCriterion("agreement1 <=", value, "agreement1");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andAgreement1Like(String value) {
      addCriterion("agreement1 like", value, "agreement1");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andAgreement1NotLike(String value) {
      addCriterion("agreement1 not like", value, "agreement1");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andAgreement1In(List<String> values) {
      addCriterion("agreement1 in", values, "agreement1");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andAgreement1NotIn(List<String> values) {
      addCriterion("agreement1 not in", values, "agreement1");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andAgreement1Between(String value1, String value2) {
      addCriterion("agreement1 between", value1, value2, "agreement1");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andAgreement1NotBetween(String value1, String value2) {
      addCriterion("agreement1 not between", value1, value2, "agreement1");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andAgreementimgIsNull() {
      addCriterion("agreementImg is null");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andAgreementimgIsNotNull() {
      addCriterion("agreementImg is not null");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andAgreementimgEqualTo(String value) {
      addCriterion("agreementImg =", value, "agreementimg");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andAgreementimgNotEqualTo(String value) {
      addCriterion("agreementImg <>", value, "agreementimg");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andAgreementimgGreaterThan(String value) {
      addCriterion("agreementImg >", value, "agreementimg");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andAgreementimgGreaterThanOrEqualTo(String value) {
      addCriterion("agreementImg >=", value, "agreementimg");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andAgreementimgLessThan(String value) {
      addCriterion("agreementImg <", value, "agreementimg");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andAgreementimgLessThanOrEqualTo(String value) {
      addCriterion("agreementImg <=", value, "agreementimg");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andAgreementimgLike(String value) {
      addCriterion("agreementImg like", value, "agreementimg");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andAgreementimgNotLike(String value) {
      addCriterion("agreementImg not like", value, "agreementimg");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andAgreementimgIn(List<String> values) {
      addCriterion("agreementImg in", values, "agreementimg");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andAgreementimgNotIn(List<String> values) {
      addCriterion("agreementImg not in", values, "agreementimg");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andAgreementimgBetween(String value1, String value2) {
      addCriterion("agreementImg between", value1, value2, "agreementimg");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andAgreementimgNotBetween(String value1, String value2) {
      addCriterion("agreementImg not between", value1, value2, "agreementimg");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andValiddateIsNull() {
      addCriterion("ValidDate is null");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andValiddateIsNotNull() {
      addCriterion("ValidDate is not null");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andValiddateEqualTo(java.util.Date value) {
      addCriterionForJDBCDate("ValidDate =", value, "validdate");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andValiddateNotEqualTo(java.util.Date value) {
      addCriterionForJDBCDate("ValidDate <>", value, "validdate");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andValiddateGreaterThan(java.util.Date value) {
      addCriterionForJDBCDate("ValidDate >", value, "validdate");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andValiddateGreaterThanOrEqualTo(java.util.Date value) {
      addCriterionForJDBCDate("ValidDate >=", value, "validdate");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andValiddateLessThan(java.util.Date value) {
      addCriterionForJDBCDate("ValidDate <", value, "validdate");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andValiddateLessThanOrEqualTo(java.util.Date value) {
      addCriterionForJDBCDate("ValidDate <=", value, "validdate");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andValiddateIn(List<java.util.Date> values) {
      addCriterionForJDBCDate("ValidDate in", values, "validdate");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andValiddateNotIn(List<java.util.Date> values) {
      addCriterionForJDBCDate("ValidDate not in", values, "validdate");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andValiddateBetween(java.util.Date value1, java.util.Date value2) {
      addCriterionForJDBCDate("ValidDate between", value1, value2, "validdate");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andValiddateNotBetween(java.util.Date value1, java.util.Date value2) {
      addCriterionForJDBCDate("ValidDate not between", value1, value2, "validdate");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andOrgstateIsNull() {
      addCriterion("OrgState is null");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andOrgstateIsNotNull() {
      addCriterion("OrgState is not null");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andOrgstateEqualTo(Integer value) {
      addCriterion("OrgState =", value, "orgstate");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andOrgstateNotEqualTo(Integer value) {
      addCriterion("OrgState <>", value, "orgstate");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andOrgstateGreaterThan(Integer value) {
      addCriterion("OrgState >", value, "orgstate");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andOrgstateGreaterThanOrEqualTo(Integer value) {
      addCriterion("OrgState >=", value, "orgstate");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andOrgstateLessThan(Integer value) {
      addCriterion("OrgState <", value, "orgstate");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andOrgstateLessThanOrEqualTo(Integer value) {
      addCriterion("OrgState <=", value, "orgstate");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andOrgstateIn(List<Integer> values) {
      addCriterion("OrgState in", values, "orgstate");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andOrgstateNotIn(List<Integer> values) {
      addCriterion("OrgState not in", values, "orgstate");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andOrgstateBetween(Integer value1, Integer value2) {
      addCriterion("OrgState between", value1, value2, "orgstate");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andOrgstateNotBetween(Integer value1, Integer value2) {
      addCriterion("OrgState not between", value1, value2, "orgstate");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andIdentnoIsNull() {
      addCriterion("identno is null");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andIdentnoIsNotNull() {
      addCriterion("identno is not null");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andIdentnoEqualTo(String value) {
      addCriterion("identno =", value, "identno");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andIdentnoNotEqualTo(String value) {
      addCriterion("identno <>", value, "identno");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andIdentnoGreaterThan(String value) {
      addCriterion("identno >", value, "identno");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andIdentnoGreaterThanOrEqualTo(String value) {
      addCriterion("identno >=", value, "identno");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andIdentnoLessThan(String value) {
      addCriterion("identno <", value, "identno");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andIdentnoLessThanOrEqualTo(String value) {
      addCriterion("identno <=", value, "identno");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andIdentnoLike(String value) {
      addCriterion("identno like", value, "identno");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andIdentnoNotLike(String value) {
      addCriterion("identno not like", value, "identno");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andIdentnoIn(List<String> values) {
      addCriterion("identno in", values, "identno");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andIdentnoNotIn(List<String> values) {
      addCriterion("identno not in", values, "identno");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andIdentnoBetween(String value1, String value2) {
      addCriterion("identno between", value1, value2, "identno");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andIdentnoNotBetween(String value1, String value2) {
      addCriterion("identno not between", value1, value2, "identno");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andBorrowtypeIsNull() {
      addCriterion("borrowtype is null");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andBorrowtypeIsNotNull() {
      addCriterion("borrowtype is not null");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andBorrowtypeEqualTo(Integer value) {
      addCriterion("borrowtype =", value, "borrowtype");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andBorrowtypeNotEqualTo(Integer value) {
      addCriterion("borrowtype <>", value, "borrowtype");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andBorrowtypeGreaterThan(Integer value) {
      addCriterion("borrowtype >", value, "borrowtype");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andBorrowtypeGreaterThanOrEqualTo(Integer value) {
      addCriterion("borrowtype >=", value, "borrowtype");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andBorrowtypeLessThan(Integer value) {
      addCriterion("borrowtype <", value, "borrowtype");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andBorrowtypeLessThanOrEqualTo(Integer value) {
      addCriterion("borrowtype <=", value, "borrowtype");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andBorrowtypeIn(List<Integer> values) {
      addCriterion("borrowtype in", values, "borrowtype");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andBorrowtypeNotIn(List<Integer> values) {
      addCriterion("borrowtype not in", values, "borrowtype");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andBorrowtypeBetween(Integer value1, Integer value2) {
      addCriterion("borrowtype between", value1, value2, "borrowtype");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andBorrowtypeNotBetween(Integer value1, Integer value2) {
      addCriterion("borrowtype not between", value1, value2, "borrowtype");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andAdminuseridIsNull() {
      addCriterion("AdminUserID is null");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andAdminuseridIsNotNull() {
      addCriterion("AdminUserID is not null");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andAdminuseridEqualTo(String value) {
      addCriterion("AdminUserID =", value, "adminuserid");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andAdminuseridNotEqualTo(String value) {
      addCriterion("AdminUserID <>", value, "adminuserid");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andAdminuseridGreaterThan(String value) {
      addCriterion("AdminUserID >", value, "adminuserid");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andAdminuseridGreaterThanOrEqualTo(String value) {
      addCriterion("AdminUserID >=", value, "adminuserid");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andAdminuseridLessThan(String value) {
      addCriterion("AdminUserID <", value, "adminuserid");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andAdminuseridLessThanOrEqualTo(String value) {
      addCriterion("AdminUserID <=", value, "adminuserid");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andAdminuseridLike(String value) {
      addCriterion("AdminUserID like", value, "adminuserid");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andAdminuseridNotLike(String value) {
      addCriterion("AdminUserID not like", value, "adminuserid");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andAdminuseridIn(List<String> values) {
      addCriterion("AdminUserID in", values, "adminuserid");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andAdminuseridNotIn(List<String> values) {
      addCriterion("AdminUserID not in", values, "adminuserid");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andAdminuseridBetween(String value1, String value2) {
      addCriterion("AdminUserID between", value1, value2, "adminuserid");
      return ((BorrowerExample.Criteria)this);
    }

    public BorrowerExample.Criteria andAdminuseridNotBetween(String value1, String value2) {
      addCriterion("AdminUserID not between", value1, value2, "adminuserid");
      return ((BorrowerExample.Criteria)this);
    }
  }
}