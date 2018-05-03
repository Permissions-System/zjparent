package com.zjgt.p2p.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class VouchOrgExample
{
  protected String orderByClause;
  protected boolean distinct;
  protected Integer startPos;
  protected Integer pageSize;
  protected List<Criteria> oredCriteria;

  public VouchOrgExample()
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

  public static class Criteria extends VouchOrgExample.GeneratedCriteria
  {
  }

  protected static abstract class GeneratedCriteria
  {
    protected List<VouchOrgExample.Criterion> criteria;

    protected GeneratedCriteria()
    {
      this.criteria = new ArrayList();
    }

    public boolean isValid() {
      return (this.criteria.size() > 0);
    }

    public List<VouchOrgExample.Criterion> getAllCriteria() {
      return this.criteria;
    }

    public List<VouchOrgExample.Criterion> getCriteria() {
      return this.criteria;
    }

    protected void addCriterion(String condition) {
      if (condition == null) {
        throw new RuntimeException("Value for condition cannot be null");
      }
      this.criteria.add(new VouchOrgExample.Criterion(condition));
    }

    protected void addCriterion(String condition, Object value, String property) {
      if (value == null) {
        throw new RuntimeException("Value for " + property + " cannot be null");
      }
      this.criteria.add(new VouchOrgExample.Criterion(condition, value));
    }

    protected void addCriterion(String condition, Object value1, Object value2, String property) {
      if ((value1 == null) || (value2 == null)) {
        throw new RuntimeException("Between values for " + property + " cannot be null");
      }
      this.criteria.add(new VouchOrgExample.Criterion(condition, value1, value2));
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

    public VouchOrgExample.Criteria andIdIsNull() {
      addCriterion("ID is null");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andIdIsNotNull() {
      addCriterion("ID is not null");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andIdEqualTo(Integer value) {
      addCriterion("ID =", value, "id");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andIdNotEqualTo(Integer value) {
      addCriterion("ID <>", value, "id");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andIdGreaterThan(Integer value) {
      addCriterion("ID >", value, "id");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andIdGreaterThanOrEqualTo(Integer value) {
      addCriterion("ID >=", value, "id");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andIdLessThan(Integer value) {
      addCriterion("ID <", value, "id");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andIdLessThanOrEqualTo(Integer value) {
      addCriterion("ID <=", value, "id");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andIdIn(List<Integer> values) {
      addCriterion("ID in", values, "id");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andIdNotIn(List<Integer> values) {
      addCriterion("ID not in", values, "id");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andIdBetween(Integer value1, Integer value2) {
      addCriterion("ID between", value1, value2, "id");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andIdNotBetween(Integer value1, Integer value2) {
      addCriterion("ID not between", value1, value2, "id");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andInstcodeIsNull() {
      addCriterion("instCode is null");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andInstcodeIsNotNull() {
      addCriterion("instCode is not null");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andInstcodeEqualTo(String value) {
      addCriterion("instCode =", value, "instcode");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andInstcodeNotEqualTo(String value) {
      addCriterion("instCode <>", value, "instcode");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andInstcodeGreaterThan(String value) {
      addCriterion("instCode >", value, "instcode");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andInstcodeGreaterThanOrEqualTo(String value) {
      addCriterion("instCode >=", value, "instcode");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andInstcodeLessThan(String value) {
      addCriterion("instCode <", value, "instcode");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andInstcodeLessThanOrEqualTo(String value) {
      addCriterion("instCode <=", value, "instcode");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andInstcodeLike(String value) {
      addCriterion("instCode like", value, "instcode");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andInstcodeNotLike(String value) {
      addCriterion("instCode not like", value, "instcode");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andInstcodeIn(List<String> values) {
      addCriterion("instCode in", values, "instcode");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andInstcodeNotIn(List<String> values) {
      addCriterion("instCode not in", values, "instcode");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andInstcodeBetween(String value1, String value2) {
      addCriterion("instCode between", value1, value2, "instcode");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andInstcodeNotBetween(String value1, String value2) {
      addCriterion("instCode not between", value1, value2, "instcode");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andInstfullnameIsNull() {
      addCriterion("instFullName is null");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andInstfullnameIsNotNull() {
      addCriterion("instFullName is not null");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andInstfullnameEqualTo(String value) {
      addCriterion("instFullName =", value, "instfullname");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andInstfullnameNotEqualTo(String value) {
      addCriterion("instFullName <>", value, "instfullname");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andInstfullnameGreaterThan(String value) {
      addCriterion("instFullName >", value, "instfullname");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andInstfullnameGreaterThanOrEqualTo(String value) {
      addCriterion("instFullName >=", value, "instfullname");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andInstfullnameLessThan(String value) {
      addCriterion("instFullName <", value, "instfullname");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andInstfullnameLessThanOrEqualTo(String value) {
      addCriterion("instFullName <=", value, "instfullname");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andInstfullnameLike(String value) {
      addCriterion("instFullName like", value, "instfullname");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andInstfullnameNotLike(String value) {
      addCriterion("instFullName not like", value, "instfullname");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andInstfullnameIn(List<String> values) {
      addCriterion("instFullName in", values, "instfullname");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andInstfullnameNotIn(List<String> values) {
      addCriterion("instFullName not in", values, "instfullname");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andInstfullnameBetween(String value1, String value2) {
      addCriterion("instFullName between", value1, value2, "instfullname");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andInstfullnameNotBetween(String value1, String value2) {
      addCriterion("instFullName not between", value1, value2, "instfullname");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andInstnameIsNull() {
      addCriterion("instName is null");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andInstnameIsNotNull() {
      addCriterion("instName is not null");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andInstnameEqualTo(String value) {
      addCriterion("instName =", value, "instname");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andInstnameNotEqualTo(String value) {
      addCriterion("instName <>", value, "instname");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andInstnameGreaterThan(String value) {
      addCriterion("instName >", value, "instname");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andInstnameGreaterThanOrEqualTo(String value) {
      addCriterion("instName >=", value, "instname");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andInstnameLessThan(String value) {
      addCriterion("instName <", value, "instname");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andInstnameLessThanOrEqualTo(String value) {
      addCriterion("instName <=", value, "instname");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andInstnameLike(String value) {
      addCriterion("instName like", value, "instname");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andInstnameNotLike(String value) {
      addCriterion("instName not like", value, "instname");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andInstnameIn(List<String> values) {
      addCriterion("instName in", values, "instname");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andInstnameNotIn(List<String> values) {
      addCriterion("instName not in", values, "instname");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andInstnameBetween(String value1, String value2) {
      addCriterion("instName between", value1, value2, "instname");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andInstnameNotBetween(String value1, String value2) {
      addCriterion("instName not between", value1, value2, "instname");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andInstdescIsNull() {
      addCriterion("instDesc is null");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andInstdescIsNotNull() {
      addCriterion("instDesc is not null");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andInstdescEqualTo(String value) {
      addCriterion("instDesc =", value, "instdesc");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andInstdescNotEqualTo(String value) {
      addCriterion("instDesc <>", value, "instdesc");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andInstdescGreaterThan(String value) {
      addCriterion("instDesc >", value, "instdesc");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andInstdescGreaterThanOrEqualTo(String value) {
      addCriterion("instDesc >=", value, "instdesc");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andInstdescLessThan(String value) {
      addCriterion("instDesc <", value, "instdesc");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andInstdescLessThanOrEqualTo(String value) {
      addCriterion("instDesc <=", value, "instdesc");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andInstdescLike(String value) {
      addCriterion("instDesc like", value, "instdesc");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andInstdescNotLike(String value) {
      addCriterion("instDesc not like", value, "instdesc");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andInstdescIn(List<String> values) {
      addCriterion("instDesc in", values, "instdesc");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andInstdescNotIn(List<String> values) {
      addCriterion("instDesc not in", values, "instdesc");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andInstdescBetween(String value1, String value2) {
      addCriterion("instDesc between", value1, value2, "instdesc");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andInstdescNotBetween(String value1, String value2) {
      addCriterion("instDesc not between", value1, value2, "instdesc");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andInstlogoIsNull() {
      addCriterion("instLogo is null");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andInstlogoIsNotNull() {
      addCriterion("instLogo is not null");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andInstlogoEqualTo(String value) {
      addCriterion("instLogo =", value, "instlogo");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andInstlogoNotEqualTo(String value) {
      addCriterion("instLogo <>", value, "instlogo");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andInstlogoGreaterThan(String value) {
      addCriterion("instLogo >", value, "instlogo");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andInstlogoGreaterThanOrEqualTo(String value) {
      addCriterion("instLogo >=", value, "instlogo");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andInstlogoLessThan(String value) {
      addCriterion("instLogo <", value, "instlogo");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andInstlogoLessThanOrEqualTo(String value) {
      addCriterion("instLogo <=", value, "instlogo");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andInstlogoLike(String value) {
      addCriterion("instLogo like", value, "instlogo");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andInstlogoNotLike(String value) {
      addCriterion("instLogo not like", value, "instlogo");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andInstlogoIn(List<String> values) {
      addCriterion("instLogo in", values, "instlogo");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andInstlogoNotIn(List<String> values) {
      addCriterion("instLogo not in", values, "instlogo");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andInstlogoBetween(String value1, String value2) {
      addCriterion("instLogo between", value1, value2, "instlogo");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andInstlogoNotBetween(String value1, String value2) {
      addCriterion("instLogo not between", value1, value2, "instlogo");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andUporgIsNull() {
      addCriterion("UpOrg is null");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andUporgIsNotNull() {
      addCriterion("UpOrg is not null");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andUporgEqualTo(String value) {
      addCriterion("UpOrg =", value, "uporg");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andUporgNotEqualTo(String value) {
      addCriterion("UpOrg <>", value, "uporg");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andUporgGreaterThan(String value) {
      addCriterion("UpOrg >", value, "uporg");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andUporgGreaterThanOrEqualTo(String value) {
      addCriterion("UpOrg >=", value, "uporg");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andUporgLessThan(String value) {
      addCriterion("UpOrg <", value, "uporg");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andUporgLessThanOrEqualTo(String value) {
      addCriterion("UpOrg <=", value, "uporg");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andUporgLike(String value) {
      addCriterion("UpOrg like", value, "uporg");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andUporgNotLike(String value) {
      addCriterion("UpOrg not like", value, "uporg");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andUporgIn(List<String> values) {
      addCriterion("UpOrg in", values, "uporg");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andUporgNotIn(List<String> values) {
      addCriterion("UpOrg not in", values, "uporg");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andUporgBetween(String value1, String value2) {
      addCriterion("UpOrg between", value1, value2, "uporg");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andUporgNotBetween(String value1, String value2) {
      addCriterion("UpOrg not between", value1, value2, "uporg");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andInstlevelIsNull() {
      addCriterion("instLevel is null");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andInstlevelIsNotNull() {
      addCriterion("instLevel is not null");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andInstlevelEqualTo(Integer value) {
      addCriterion("instLevel =", value, "instlevel");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andInstlevelNotEqualTo(Integer value) {
      addCriterion("instLevel <>", value, "instlevel");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andInstlevelGreaterThan(Integer value) {
      addCriterion("instLevel >", value, "instlevel");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andInstlevelGreaterThanOrEqualTo(Integer value) {
      addCriterion("instLevel >=", value, "instlevel");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andInstlevelLessThan(Integer value) {
      addCriterion("instLevel <", value, "instlevel");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andInstlevelLessThanOrEqualTo(Integer value) {
      addCriterion("instLevel <=", value, "instlevel");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andInstlevelIn(List<Integer> values) {
      addCriterion("instLevel in", values, "instlevel");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andInstlevelNotIn(List<Integer> values) {
      addCriterion("instLevel not in", values, "instlevel");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andInstlevelBetween(Integer value1, Integer value2) {
      addCriterion("instLevel between", value1, value2, "instlevel");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andInstlevelNotBetween(Integer value1, Integer value2) {
      addCriterion("instLevel not between", value1, value2, "instlevel");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andAddressIsNull() {
      addCriterion("Address is null");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andAddressIsNotNull() {
      addCriterion("Address is not null");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andAddressEqualTo(String value) {
      addCriterion("Address =", value, "address");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andAddressNotEqualTo(String value) {
      addCriterion("Address <>", value, "address");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andAddressGreaterThan(String value) {
      addCriterion("Address >", value, "address");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andAddressGreaterThanOrEqualTo(String value) {
      addCriterion("Address >=", value, "address");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andAddressLessThan(String value) {
      addCriterion("Address <", value, "address");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andAddressLessThanOrEqualTo(String value) {
      addCriterion("Address <=", value, "address");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andAddressLike(String value) {
      addCriterion("Address like", value, "address");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andAddressNotLike(String value) {
      addCriterion("Address not like", value, "address");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andAddressIn(List<String> values) {
      addCriterion("Address in", values, "address");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andAddressNotIn(List<String> values) {
      addCriterion("Address not in", values, "address");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andAddressBetween(String value1, String value2) {
      addCriterion("Address between", value1, value2, "address");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andAddressNotBetween(String value1, String value2) {
      addCriterion("Address not between", value1, value2, "address");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andContactpersonIsNull() {
      addCriterion("ContactPerson is null");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andContactpersonIsNotNull() {
      addCriterion("ContactPerson is not null");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andContactpersonEqualTo(String value) {
      addCriterion("ContactPerson =", value, "contactperson");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andContactpersonNotEqualTo(String value) {
      addCriterion("ContactPerson <>", value, "contactperson");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andContactpersonGreaterThan(String value) {
      addCriterion("ContactPerson >", value, "contactperson");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andContactpersonGreaterThanOrEqualTo(String value) {
      addCriterion("ContactPerson >=", value, "contactperson");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andContactpersonLessThan(String value) {
      addCriterion("ContactPerson <", value, "contactperson");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andContactpersonLessThanOrEqualTo(String value) {
      addCriterion("ContactPerson <=", value, "contactperson");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andContactpersonLike(String value) {
      addCriterion("ContactPerson like", value, "contactperson");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andContactpersonNotLike(String value) {
      addCriterion("ContactPerson not like", value, "contactperson");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andContactpersonIn(List<String> values) {
      addCriterion("ContactPerson in", values, "contactperson");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andContactpersonNotIn(List<String> values) {
      addCriterion("ContactPerson not in", values, "contactperson");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andContactpersonBetween(String value1, String value2) {
      addCriterion("ContactPerson between", value1, value2, "contactperson");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andContactpersonNotBetween(String value1, String value2) {
      addCriterion("ContactPerson not between", value1, value2, "contactperson");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andMobileIsNull() {
      addCriterion("Mobile is null");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andMobileIsNotNull() {
      addCriterion("Mobile is not null");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andMobileEqualTo(String value) {
      addCriterion("Mobile =", value, "mobile");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andMobileNotEqualTo(String value) {
      addCriterion("Mobile <>", value, "mobile");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andMobileGreaterThan(String value) {
      addCriterion("Mobile >", value, "mobile");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andMobileGreaterThanOrEqualTo(String value) {
      addCriterion("Mobile >=", value, "mobile");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andMobileLessThan(String value) {
      addCriterion("Mobile <", value, "mobile");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andMobileLessThanOrEqualTo(String value) {
      addCriterion("Mobile <=", value, "mobile");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andMobileLike(String value) {
      addCriterion("Mobile like", value, "mobile");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andMobileNotLike(String value) {
      addCriterion("Mobile not like", value, "mobile");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andMobileIn(List<String> values) {
      addCriterion("Mobile in", values, "mobile");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andMobileNotIn(List<String> values) {
      addCriterion("Mobile not in", values, "mobile");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andMobileBetween(String value1, String value2) {
      addCriterion("Mobile between", value1, value2, "mobile");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andMobileNotBetween(String value1, String value2) {
      addCriterion("Mobile not between", value1, value2, "mobile");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andPhoneIsNull() {
      addCriterion("Phone is null");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andPhoneIsNotNull() {
      addCriterion("Phone is not null");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andPhoneEqualTo(String value) {
      addCriterion("Phone =", value, "phone");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andPhoneNotEqualTo(String value) {
      addCriterion("Phone <>", value, "phone");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andPhoneGreaterThan(String value) {
      addCriterion("Phone >", value, "phone");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andPhoneGreaterThanOrEqualTo(String value) {
      addCriterion("Phone >=", value, "phone");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andPhoneLessThan(String value) {
      addCriterion("Phone <", value, "phone");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andPhoneLessThanOrEqualTo(String value) {
      addCriterion("Phone <=", value, "phone");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andPhoneLike(String value) {
      addCriterion("Phone like", value, "phone");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andPhoneNotLike(String value) {
      addCriterion("Phone not like", value, "phone");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andPhoneIn(List<String> values) {
      addCriterion("Phone in", values, "phone");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andPhoneNotIn(List<String> values) {
      addCriterion("Phone not in", values, "phone");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andPhoneBetween(String value1, String value2) {
      addCriterion("Phone between", value1, value2, "phone");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andPhoneNotBetween(String value1, String value2) {
      addCriterion("Phone not between", value1, value2, "phone");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andFaxIsNull() {
      addCriterion("Fax is null");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andFaxIsNotNull() {
      addCriterion("Fax is not null");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andFaxEqualTo(String value) {
      addCriterion("Fax =", value, "fax");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andFaxNotEqualTo(String value) {
      addCriterion("Fax <>", value, "fax");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andFaxGreaterThan(String value) {
      addCriterion("Fax >", value, "fax");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andFaxGreaterThanOrEqualTo(String value) {
      addCriterion("Fax >=", value, "fax");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andFaxLessThan(String value) {
      addCriterion("Fax <", value, "fax");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andFaxLessThanOrEqualTo(String value) {
      addCriterion("Fax <=", value, "fax");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andFaxLike(String value) {
      addCriterion("Fax like", value, "fax");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andFaxNotLike(String value) {
      addCriterion("Fax not like", value, "fax");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andFaxIn(List<String> values) {
      addCriterion("Fax in", values, "fax");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andFaxNotIn(List<String> values) {
      addCriterion("Fax not in", values, "fax");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andFaxBetween(String value1, String value2) {
      addCriterion("Fax between", value1, value2, "fax");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andFaxNotBetween(String value1, String value2) {
      addCriterion("Fax not between", value1, value2, "fax");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andEmailIsNull() {
      addCriterion("EMail is null");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andEmailIsNotNull() {
      addCriterion("EMail is not null");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andEmailEqualTo(String value) {
      addCriterion("EMail =", value, "email");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andEmailNotEqualTo(String value) {
      addCriterion("EMail <>", value, "email");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andEmailGreaterThan(String value) {
      addCriterion("EMail >", value, "email");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andEmailGreaterThanOrEqualTo(String value) {
      addCriterion("EMail >=", value, "email");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andEmailLessThan(String value) {
      addCriterion("EMail <", value, "email");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andEmailLessThanOrEqualTo(String value) {
      addCriterion("EMail <=", value, "email");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andEmailLike(String value) {
      addCriterion("EMail like", value, "email");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andEmailNotLike(String value) {
      addCriterion("EMail not like", value, "email");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andEmailIn(List<String> values) {
      addCriterion("EMail in", values, "email");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andEmailNotIn(List<String> values) {
      addCriterion("EMail not in", values, "email");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andEmailBetween(String value1, String value2) {
      addCriterion("EMail between", value1, value2, "email");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andEmailNotBetween(String value1, String value2) {
      addCriterion("EMail not between", value1, value2, "email");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andAgreement1IsNull() {
      addCriterion("agreement1 is null");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andAgreement1IsNotNull() {
      addCriterion("agreement1 is not null");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andAgreement1EqualTo(String value) {
      addCriterion("agreement1 =", value, "agreement1");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andAgreement1NotEqualTo(String value) {
      addCriterion("agreement1 <>", value, "agreement1");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andAgreement1GreaterThan(String value) {
      addCriterion("agreement1 >", value, "agreement1");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andAgreement1GreaterThanOrEqualTo(String value) {
      addCriterion("agreement1 >=", value, "agreement1");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andAgreement1LessThan(String value) {
      addCriterion("agreement1 <", value, "agreement1");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andAgreement1LessThanOrEqualTo(String value) {
      addCriterion("agreement1 <=", value, "agreement1");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andAgreement1Like(String value) {
      addCriterion("agreement1 like", value, "agreement1");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andAgreement1NotLike(String value) {
      addCriterion("agreement1 not like", value, "agreement1");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andAgreement1In(List<String> values) {
      addCriterion("agreement1 in", values, "agreement1");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andAgreement1NotIn(List<String> values) {
      addCriterion("agreement1 not in", values, "agreement1");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andAgreement1Between(String value1, String value2) {
      addCriterion("agreement1 between", value1, value2, "agreement1");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andAgreement1NotBetween(String value1, String value2) {
      addCriterion("agreement1 not between", value1, value2, "agreement1");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andAgreementimgIsNull() {
      addCriterion("agreementImg is null");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andAgreementimgIsNotNull() {
      addCriterion("agreementImg is not null");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andAgreementimgEqualTo(String value) {
      addCriterion("agreementImg =", value, "agreementimg");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andAgreementimgNotEqualTo(String value) {
      addCriterion("agreementImg <>", value, "agreementimg");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andAgreementimgGreaterThan(String value) {
      addCriterion("agreementImg >", value, "agreementimg");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andAgreementimgGreaterThanOrEqualTo(String value) {
      addCriterion("agreementImg >=", value, "agreementimg");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andAgreementimgLessThan(String value) {
      addCriterion("agreementImg <", value, "agreementimg");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andAgreementimgLessThanOrEqualTo(String value) {
      addCriterion("agreementImg <=", value, "agreementimg");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andAgreementimgLike(String value) {
      addCriterion("agreementImg like", value, "agreementimg");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andAgreementimgNotLike(String value) {
      addCriterion("agreementImg not like", value, "agreementimg");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andAgreementimgIn(List<String> values) {
      addCriterion("agreementImg in", values, "agreementimg");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andAgreementimgNotIn(List<String> values) {
      addCriterion("agreementImg not in", values, "agreementimg");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andAgreementimgBetween(String value1, String value2) {
      addCriterion("agreementImg between", value1, value2, "agreementimg");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andAgreementimgNotBetween(String value1, String value2) {
      addCriterion("agreementImg not between", value1, value2, "agreementimg");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andValiddateIsNull() {
      addCriterion("ValidDate is null");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andValiddateIsNotNull() {
      addCriterion("ValidDate is not null");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andValiddateEqualTo(java.util.Date value) {
      addCriterionForJDBCDate("ValidDate =", value, "validdate");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andValiddateNotEqualTo(java.util.Date value) {
      addCriterionForJDBCDate("ValidDate <>", value, "validdate");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andValiddateGreaterThan(java.util.Date value) {
      addCriterionForJDBCDate("ValidDate >", value, "validdate");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andValiddateGreaterThanOrEqualTo(java.util.Date value) {
      addCriterionForJDBCDate("ValidDate >=", value, "validdate");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andValiddateLessThan(java.util.Date value) {
      addCriterionForJDBCDate("ValidDate <", value, "validdate");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andValiddateLessThanOrEqualTo(java.util.Date value) {
      addCriterionForJDBCDate("ValidDate <=", value, "validdate");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andValiddateIn(List<java.util.Date> values) {
      addCriterionForJDBCDate("ValidDate in", values, "validdate");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andValiddateNotIn(List<java.util.Date> values) {
      addCriterionForJDBCDate("ValidDate not in", values, "validdate");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andValiddateBetween(java.util.Date value1, java.util.Date value2) {
      addCriterionForJDBCDate("ValidDate between", value1, value2, "validdate");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andValiddateNotBetween(java.util.Date value1, java.util.Date value2) {
      addCriterionForJDBCDate("ValidDate not between", value1, value2, "validdate");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andOrgstateIsNull() {
      addCriterion("OrgState is null");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andOrgstateIsNotNull() {
      addCriterion("OrgState is not null");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andOrgstateEqualTo(Integer value) {
      addCriterion("OrgState =", value, "orgstate");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andOrgstateNotEqualTo(Integer value) {
      addCriterion("OrgState <>", value, "orgstate");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andOrgstateGreaterThan(Integer value) {
      addCriterion("OrgState >", value, "orgstate");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andOrgstateGreaterThanOrEqualTo(Integer value) {
      addCriterion("OrgState >=", value, "orgstate");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andOrgstateLessThan(Integer value) {
      addCriterion("OrgState <", value, "orgstate");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andOrgstateLessThanOrEqualTo(Integer value) {
      addCriterion("OrgState <=", value, "orgstate");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andOrgstateIn(List<Integer> values) {
      addCriterion("OrgState in", values, "orgstate");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andOrgstateNotIn(List<Integer> values) {
      addCriterion("OrgState not in", values, "orgstate");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andOrgstateBetween(Integer value1, Integer value2) {
      addCriterion("OrgState between", value1, value2, "orgstate");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andOrgstateNotBetween(Integer value1, Integer value2) {
      addCriterion("OrgState not between", value1, value2, "orgstate");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andAdminuseridIsNull() {
      addCriterion("AdminUserID is null");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andAdminuseridIsNotNull() {
      addCriterion("AdminUserID is not null");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andAdminuseridEqualTo(Integer value) {
      addCriterion("AdminUserID =", value, "adminuserid");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andAdminuseridNotEqualTo(Integer value) {
      addCriterion("AdminUserID <>", value, "adminuserid");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andAdminuseridGreaterThan(Integer value) {
      addCriterion("AdminUserID >", value, "adminuserid");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andAdminuseridGreaterThanOrEqualTo(Integer value) {
      addCriterion("AdminUserID >=", value, "adminuserid");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andAdminuseridLessThan(Integer value) {
      addCriterion("AdminUserID <", value, "adminuserid");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andAdminuseridLessThanOrEqualTo(Integer value) {
      addCriterion("AdminUserID <=", value, "adminuserid");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andAdminuseridIn(List<Integer> values) {
      addCriterion("AdminUserID in", values, "adminuserid");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andAdminuseridNotIn(List<Integer> values) {
      addCriterion("AdminUserID not in", values, "adminuserid");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andAdminuseridBetween(Integer value1, Integer value2) {
      addCriterion("AdminUserID between", value1, value2, "adminuserid");
      return ((VouchOrgExample.Criteria)this);
    }

    public VouchOrgExample.Criteria andAdminuseridNotBetween(Integer value1, Integer value2) {
      addCriterion("AdminUserID not between", value1, value2, "adminuserid");
      return ((VouchOrgExample.Criteria)this);
    }
  }
}