package com.zjgt.p2p.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProjectExample
{
  protected String orderByClause;
  protected Integer startPos;
  protected Integer pageSize;
  protected boolean distinct;
  protected List<Criteria> oredCriteria;

  public ProjectExample()
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

  public Integer getStartPos() {
    return this.startPos;
  }

  public void setStartPos(Integer startPos)
  {
    this.startPos = startPos;
  }

  public Integer getPageSize()
  {
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

  public static class Criteria extends ProjectExample.GeneratedCriteria
  {
  }

  protected static abstract class GeneratedCriteria
  {
    protected List<ProjectExample.Criterion> criteria;

    protected GeneratedCriteria()
    {
      this.criteria = new ArrayList();
    }

    public boolean isValid() {
      return (this.criteria.size() > 0);
    }

    public List<ProjectExample.Criterion> getAllCriteria() {
      return this.criteria;
    }

    public List<ProjectExample.Criterion> getCriteria() {
      return this.criteria;
    }

    protected void addCriterion(String condition) {
      if (condition == null) {
        throw new RuntimeException("Value for condition cannot be null");
      }
      this.criteria.add(new ProjectExample.Criterion(condition));
    }

    protected void addCriterion(String condition, Object value, String property) {
      if (value == null) {
        throw new RuntimeException("Value for " + property + " cannot be null");
      }
      this.criteria.add(new ProjectExample.Criterion(condition, value));
    }

    protected void addCriterion(String condition, Object value1, Object value2, String property) {
      if ((value1 == null) || (value2 == null)) {
        throw new RuntimeException("Between values for " + property + " cannot be null");
      }
      this.criteria.add(new ProjectExample.Criterion(condition, value1, value2));
    }

    public ProjectExample.Criteria andIdIsNull() {
      addCriterion("id is null");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andIdIsNotNull() {
      addCriterion("id is not null");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andIdEqualTo(Long value) {
      addCriterion("id =", value, "id");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andIdNotEqualTo(Long value) {
      addCriterion("id <>", value, "id");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andIdGreaterThan(Long value) {
      addCriterion("id >", value, "id");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andIdGreaterThanOrEqualTo(Long value) {
      addCriterion("id >=", value, "id");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andIdLessThan(Long value) {
      addCriterion("id <", value, "id");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andIdLessThanOrEqualTo(Long value) {
      addCriterion("id <=", value, "id");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andIdIn(List<Long> values) {
      addCriterion("id in", values, "id");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andIdNotIn(List<Long> values) {
      addCriterion("id not in", values, "id");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andIdBetween(Long value1, Long value2) {
      addCriterion("id between", value1, value2, "id");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andIdNotBetween(Long value1, Long value2) {
      addCriterion("id not between", value1, value2, "id");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andProjectcodeIsNull() {
      addCriterion("ProjectCode is null");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andProjectcodeIsNotNull() {
      addCriterion("ProjectCode is not null");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andProjectcodeEqualTo(String value) {
      addCriterion("ProjectCode =", value, "projectcode");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andProjectcodeNotEqualTo(String value) {
      addCriterion("ProjectCode <>", value, "projectcode");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andProjectcodeGreaterThan(String value) {
      addCriterion("ProjectCode >", value, "projectcode");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andProjectcodeGreaterThanOrEqualTo(String value) {
      addCriterion("ProjectCode >=", value, "projectcode");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andProjectcodeLessThan(String value) {
      addCriterion("ProjectCode <", value, "projectcode");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andProjectcodeLessThanOrEqualTo(String value) {
      addCriterion("ProjectCode <=", value, "projectcode");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andProjectcodeLike(String value) {
      addCriterion("ProjectCode like", value, "projectcode");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andProjectcodeNotLike(String value) {
      addCriterion("ProjectCode not like", value, "projectcode");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andProjectcodeIn(List<String> values) {
      addCriterion("ProjectCode in", values, "projectcode");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andProjectcodeNotIn(List<String> values) {
      addCriterion("ProjectCode not in", values, "projectcode");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andProjectcodeBetween(String value1, String value2) {
      addCriterion("ProjectCode between", value1, value2, "projectcode");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andProjectcodeNotBetween(String value1, String value2) {
      addCriterion("ProjectCode not between", value1, value2, "projectcode");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andProjectnameIsNull() {
      addCriterion("ProjectName is null");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andProjectnameIsNotNull() {
      addCriterion("ProjectName is not null");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andProjectnameEqualTo(String value) {
      addCriterion("ProjectName =", value, "projectname");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andProjectnameNotEqualTo(String value) {
      addCriterion("ProjectName <>", value, "projectname");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andProjectnameGreaterThan(String value) {
      addCriterion("ProjectName >", value, "projectname");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andProjectnameGreaterThanOrEqualTo(String value) {
      addCriterion("ProjectName >=", value, "projectname");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andProjectnameLessThan(String value) {
      addCriterion("ProjectName <", value, "projectname");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andProjectnameLessThanOrEqualTo(String value) {
      addCriterion("ProjectName <=", value, "projectname");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andProjectnameLike(String value) {
      addCriterion("ProjectName like", value, "projectname");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andProjectnameNotLike(String value) {
      addCriterion("ProjectName not like", value, "projectname");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andProjectnameIn(List<String> values) {
      addCriterion("ProjectName in", values, "projectname");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andProjectnameNotIn(List<String> values) {
      addCriterion("ProjectName not in", values, "projectname");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andProjectnameBetween(String value1, String value2) {
      addCriterion("ProjectName between", value1, value2, "projectname");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andProjectnameNotBetween(String value1, String value2) {
      addCriterion("ProjectName not between", value1, value2, "projectname");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andAccountIsNull() {
      addCriterion("Account is null");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andAccountIsNotNull() {
      addCriterion("Account is not null");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andAccountEqualTo(Short value) {
      addCriterion("Account =", value, "account");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andAccountNotEqualTo(Short value) {
      addCriterion("Account <>", value, "account");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andAccountGreaterThan(Short value) {
      addCriterion("Account >", value, "account");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andAccountGreaterThanOrEqualTo(Short value) {
      addCriterion("Account >=", value, "account");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andAccountLessThan(Short value) {
      addCriterion("Account <", value, "account");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andAccountLessThanOrEqualTo(Short value) {
      addCriterion("Account <=", value, "account");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andAccountIn(List<Short> values) {
      addCriterion("Account in", values, "account");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andAccountNotIn(List<Short> values) {
      addCriterion("Account not in", values, "account");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andAccountBetween(Short value1, Short value2) {
      addCriterion("Account between", value1, value2, "account");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andAccountNotBetween(Short value1, Short value2) {
      addCriterion("Account not between", value1, value2, "account");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andInstcodeIsNull() {
      addCriterion("instCode is null");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andInstcodeIsNotNull() {
      addCriterion("instCode is not null");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andInstcodeEqualTo(String value) {
      addCriterion("instCode =", value, "instcode");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andInstcodeNotEqualTo(String value) {
      addCriterion("instCode <>", value, "instcode");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andInstcodeGreaterThan(String value) {
      addCriterion("instCode >", value, "instcode");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andInstcodeGreaterThanOrEqualTo(String value) {
      addCriterion("instCode >=", value, "instcode");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andInstcodeLessThan(String value) {
      addCriterion("instCode <", value, "instcode");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andInstcodeLessThanOrEqualTo(String value) {
      addCriterion("instCode <=", value, "instcode");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andInstcodeIn(List<String> values) {
      addCriterion("instCode in", values, "instcode");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andInstcodeNotIn(List<String> values) {
      addCriterion("instCode not in", values, "instcode");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andInstcodeBetween(String value1, String value2) {
      addCriterion("instCode between", value1, value2, "instcode");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andInstcodeNotBetween(String value1, String value2) {
      addCriterion("instCode not between", value1, value2, "instcode");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andInstnameIsNull() {
      addCriterion("instName is null");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andInstnameIsNotNull() {
      addCriterion("instName is not null");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andInstnameEqualTo(String value) {
      addCriterion("instName =", value, "instname");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andInstnameNotEqualTo(String value) {
      addCriterion("instName <>", value, "instname");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andInstnameGreaterThan(String value) {
      addCriterion("instName >", value, "instname");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andInstnameGreaterThanOrEqualTo(String value) {
      addCriterion("instName >=", value, "instname");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andInstnameLessThan(String value) {
      addCriterion("instName <", value, "instname");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andInstnameLessThanOrEqualTo(String value) {
      addCriterion("instName <=", value, "instname");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andInstnameLike(String value) {
      addCriterion("instName like", value, "instname");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andInstnameNotLike(String value) {
      addCriterion("instName not like", value, "instname");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andInstnameIn(List<String> values) {
      addCriterion("instName in", values, "instname");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andInstnameNotIn(List<String> values) {
      addCriterion("instName not in", values, "instname");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andInstnameBetween(String value1, String value2) {
      addCriterion("instName between", value1, value2, "instname");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andInstnameNotBetween(String value1, String value2) {
      addCriterion("instName not between", value1, value2, "instname");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andSubjectIsNull() {
      addCriterion("Subject is null");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andSubjectIsNotNull() {
      addCriterion("Subject is not null");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andSubjectEqualTo(String value) {
      addCriterion("Subject =", value, "subject");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andSubjectNotEqualTo(String value) {
      addCriterion("Subject <>", value, "subject");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andSubjectGreaterThan(String value) {
      addCriterion("Subject >", value, "subject");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andSubjectGreaterThanOrEqualTo(String value) {
      addCriterion("Subject >=", value, "subject");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andSubjectLessThan(String value) {
      addCriterion("Subject <", value, "subject");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andSubjectLessThanOrEqualTo(String value) {
      addCriterion("Subject <=", value, "subject");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andSubjectLike(String value) {
      addCriterion("Subject like", value, "subject");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andSubjectNotLike(String value) {
      addCriterion("Subject not like", value, "subject");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andSubjectIn(List<String> values) {
      addCriterion("Subject in", values, "subject");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andSubjectNotIn(List<String> values) {
      addCriterion("Subject not in", values, "subject");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andSubjectBetween(String value1, String value2) {
      addCriterion("Subject between", value1, value2, "subject");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andSubjectNotBetween(String value1, String value2) {
      addCriterion("Subject not between", value1, value2, "subject");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andBidnumIsNull() {
      addCriterion("bidnum is null");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andBidnumIsNotNull() {
      addCriterion("bidnum is not null");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andBidnumEqualTo(Integer value) {
      addCriterion("bidnum =", value, "bidnum");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andBidnumNotEqualTo(Integer value) {
      addCriterion("bidnum <>", value, "bidnum");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andBidnumGreaterThan(Integer value) {
      addCriterion("bidnum >", value, "bidnum");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andBidnumGreaterThanOrEqualTo(Integer value) {
      addCriterion("bidnum >=", value, "bidnum");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andBidnumLessThan(Integer value) {
      addCriterion("bidnum <", value, "bidnum");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andBidnumLessThanOrEqualTo(Integer value) {
      addCriterion("bidnum <=", value, "bidnum");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andBidnumIn(List<Integer> values) {
      addCriterion("bidnum in", values, "bidnum");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andBidnumNotIn(List<Integer> values) {
      addCriterion("bidnum not in", values, "bidnum");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andBidnumBetween(Integer value1, Integer value2) {
      addCriterion("bidnum between", value1, value2, "bidnum");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andBidnumNotBetween(Integer value1, Integer value2) {
      addCriterion("bidnum not between", value1, value2, "bidnum");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andBidamountIsNull() {
      addCriterion("bidamount is null");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andBidamountIsNotNull() {
      addCriterion("bidamount is not null");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andBidamountEqualTo(BigDecimal value) {
      addCriterion("bidamount =", value, "bidamount");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andBidamountNotEqualTo(BigDecimal value) {
      addCriterion("bidamount <>", value, "bidamount");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andBidamountGreaterThan(BigDecimal value) {
      addCriterion("bidamount >", value, "bidamount");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andBidamountGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("bidamount >=", value, "bidamount");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andBidamountLessThan(BigDecimal value) {
      addCriterion("bidamount <", value, "bidamount");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andBidamountLessThanOrEqualTo(BigDecimal value) {
      addCriterion("bidamount <=", value, "bidamount");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andBidamountIn(List<BigDecimal> values) {
      addCriterion("bidamount in", values, "bidamount");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andBidamountNotIn(List<BigDecimal> values) {
      addCriterion("bidamount not in", values, "bidamount");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andBidamountBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("bidamount between", value1, value2, "bidamount");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andBidamountNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("bidamount not between", value1, value2, "bidamount");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andOpdateIsNull() {
      addCriterion("opDate is null");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andOpdateIsNotNull() {
      addCriterion("opDate is not null");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andOpdateEqualTo(Date value) {
      addCriterion("opDate =", value, "opdate");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andOpdateNotEqualTo(Date value) {
      addCriterion("opDate <>", value, "opdate");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andOpdateGreaterThan(Date value) {
      addCriterion("opDate >", value, "opdate");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andOpdateGreaterThanOrEqualTo(Date value) {
      addCriterion("opDate >=", value, "opdate");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andOpdateLessThan(Date value) {
      addCriterion("opDate <", value, "opdate");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andOpdateLessThanOrEqualTo(Date value) {
      addCriterion("opDate <=", value, "opdate");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andOpdateIn(List<Date> values) {
      addCriterion("opDate in", values, "opdate");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andOpdateNotIn(List<Date> values) {
      addCriterion("opDate not in", values, "opdate");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andOpdateBetween(Date value1, Date value2) {
      addCriterion("opDate between", value1, value2, "opdate");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andOpdateNotBetween(Date value1, Date value2) {
      addCriterion("opDate not between", value1, value2, "opdate");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andMemberidIsNull() {
      addCriterion("memberid is null");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andMemberidIsNotNull() {
      addCriterion("memberid is not null");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andMemberidEqualTo(Integer value) {
      addCriterion("memberid =", value, "memberid");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andMemberidNotEqualTo(Integer value) {
      addCriterion("memberid <>", value, "memberid");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andMemberidGreaterThan(Integer value) {
      addCriterion("memberid >", value, "memberid");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andMemberidGreaterThanOrEqualTo(Integer value) {
      addCriterion("memberid >=", value, "memberid");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andMemberidLessThan(Integer value) {
      addCriterion("memberid <", value, "memberid");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andMemberidLessThanOrEqualTo(Integer value) {
      addCriterion("memberid <=", value, "memberid");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andMemberidIn(List<Integer> values) {
      addCriterion("memberid in", values, "memberid");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andMemberidNotIn(List<Integer> values) {
      addCriterion("memberid not in", values, "memberid");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andMemberidBetween(Integer value1, Integer value2) {
      addCriterion("memberid between", value1, value2, "memberid");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andMemberidNotBetween(Integer value1, Integer value2) {
      addCriterion("memberid not between", value1, value2, "memberid");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andLoanrateIsNull() {
      addCriterion("loanrate is null");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andLoanrateIsNotNull() {
      addCriterion("loanrate is not null");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andLoanrateEqualTo(BigDecimal value) {
      addCriterion("loanrate =", value, "loanrate");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andLoanrateNotEqualTo(BigDecimal value) {
      addCriterion("loanrate <>", value, "loanrate");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andLoanrateGreaterThan(BigDecimal value) {
      addCriterion("loanrate >", value, "loanrate");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andLoanrateGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("loanrate >=", value, "loanrate");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andLoanrateLessThan(BigDecimal value) {
      addCriterion("loanrate <", value, "loanrate");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andLoanrateLessThanOrEqualTo(BigDecimal value) {
      addCriterion("loanrate <=", value, "loanrate");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andLoanrateIn(List<BigDecimal> values) {
      addCriterion("loanrate in", values, "loanrate");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andLoanrateNotIn(List<BigDecimal> values) {
      addCriterion("loanrate not in", values, "loanrate");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andLoanrateBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("loanrate between", value1, value2, "loanrate");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andLoanrateNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("loanrate not between", value1, value2, "loanrate");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andMgrrateIsNull() {
      addCriterion("mgrrate is null");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andMgrrateIsNotNull() {
      addCriterion("mgrrate is not null");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andMgrrateEqualTo(BigDecimal value) {
      addCriterion("mgrrate =", value, "mgrrate");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andMgrrateNotEqualTo(BigDecimal value) {
      addCriterion("mgrrate <>", value, "mgrrate");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andMgrrateGreaterThan(BigDecimal value) {
      addCriterion("mgrrate >", value, "mgrrate");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andMgrrateGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("mgrrate >=", value, "mgrrate");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andMgrrateLessThan(BigDecimal value) {
      addCriterion("mgrrate <", value, "mgrrate");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andMgrrateLessThanOrEqualTo(BigDecimal value) {
      addCriterion("mgrrate <=", value, "mgrrate");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andMgrrateIn(List<BigDecimal> values) {
      addCriterion("mgrrate in", values, "mgrrate");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andMgrrateNotIn(List<BigDecimal> values) {
      addCriterion("mgrrate not in", values, "mgrrate");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andMgrrateBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("mgrrate between", value1, value2, "mgrrate");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andMgrrateNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("mgrrate not between", value1, value2, "mgrrate");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andPubrateIsNull() {
      addCriterion("pubrate is null");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andPubrateIsNotNull() {
      addCriterion("pubrate is not null");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andPubrateEqualTo(BigDecimal value) {
      addCriterion("pubrate =", value, "pubrate");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andPubrateNotEqualTo(BigDecimal value) {
      addCriterion("pubrate <>", value, "pubrate");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andPubrateGreaterThan(BigDecimal value) {
      addCriterion("pubrate >", value, "pubrate");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andPubrateGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("pubrate >=", value, "pubrate");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andPubrateLessThan(BigDecimal value) {
      addCriterion("pubrate <", value, "pubrate");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andPubrateLessThanOrEqualTo(BigDecimal value) {
      addCriterion("pubrate <=", value, "pubrate");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andPubrateIn(List<BigDecimal> values) {
      addCriterion("pubrate in", values, "pubrate");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andPubrateNotIn(List<BigDecimal> values) {
      addCriterion("pubrate not in", values, "pubrate");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andPubrateBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("pubrate between", value1, value2, "pubrate");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andPubrateNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("pubrate not between", value1, value2, "pubrate");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andExprateIsNull() {
      addCriterion("exprate is null");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andExprateIsNotNull() {
      addCriterion("exprate is not null");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andExprateEqualTo(BigDecimal value) {
      addCriterion("exprate =", value, "exprate");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andExprateNotEqualTo(BigDecimal value) {
      addCriterion("exprate <>", value, "exprate");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andExprateGreaterThan(BigDecimal value) {
      addCriterion("exprate >", value, "exprate");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andExprateGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("exprate >=", value, "exprate");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andExprateLessThan(BigDecimal value) {
      addCriterion("exprate <", value, "exprate");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andExprateLessThanOrEqualTo(BigDecimal value) {
      addCriterion("exprate <=", value, "exprate");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andExprateIn(List<BigDecimal> values) {
      addCriterion("exprate in", values, "exprate");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andExprateNotIn(List<BigDecimal> values) {
      addCriterion("exprate not in", values, "exprate");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andExprateBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("exprate between", value1, value2, "exprate");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andExprateNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("exprate not between", value1, value2, "exprate");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andDebtrateIsNull() {
      addCriterion("debtrate is null");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andDebtrateIsNotNull() {
      addCriterion("debtrate is not null");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andDebtrateEqualTo(BigDecimal value) {
      addCriterion("debtrate =", value, "debtrate");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andDebtrateNotEqualTo(BigDecimal value) {
      addCriterion("debtrate <>", value, "debtrate");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andDebtrateGreaterThan(BigDecimal value) {
      addCriterion("debtrate >", value, "debtrate");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andDebtrateGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("debtrate >=", value, "debtrate");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andDebtrateLessThan(BigDecimal value) {
      addCriterion("debtrate <", value, "debtrate");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andDebtrateLessThanOrEqualTo(BigDecimal value) {
      addCriterion("debtrate <=", value, "debtrate");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andDebtrateIn(List<BigDecimal> values) {
      addCriterion("debtrate in", values, "debtrate");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andDebtrateNotIn(List<BigDecimal> values) {
      addCriterion("debtrate not in", values, "debtrate");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andDebtrateBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("debtrate between", value1, value2, "debtrate");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andDebtrateNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("debtrate not between", value1, value2, "debtrate");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andInforateIsNull() {
      addCriterion("inforate is null");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andInforateIsNotNull() {
      addCriterion("inforate is not null");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andInforateEqualTo(BigDecimal value) {
      addCriterion("inforate =", value, "inforate");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andInforateNotEqualTo(BigDecimal value) {
      addCriterion("inforate <>", value, "inforate");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andInforateGreaterThan(BigDecimal value) {
      addCriterion("inforate >", value, "inforate");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andInforateGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("inforate >=", value, "inforate");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andInforateLessThan(BigDecimal value) {
      addCriterion("inforate <", value, "inforate");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andInforateLessThanOrEqualTo(BigDecimal value) {
      addCriterion("inforate <=", value, "inforate");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andInforateIn(List<BigDecimal> values) {
      addCriterion("inforate in", values, "inforate");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andInforateNotIn(List<BigDecimal> values) {
      addCriterion("inforate not in", values, "inforate");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andInforateBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("inforate between", value1, value2, "inforate");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andInforateNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("inforate not between", value1, value2, "inforate");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andPaywayIsNull() {
      addCriterion("payway is null");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andPaywayIsNotNull() {
      addCriterion("payway is not null");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andPaywayEqualTo(Integer value) {
      addCriterion("payway =", value, "payway");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andPaywayNotEqualTo(Integer value) {
      addCriterion("payway <>", value, "payway");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andPaywayGreaterThan(Integer value) {
      addCriterion("payway >", value, "payway");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andPaywayGreaterThanOrEqualTo(Integer value) {
      addCriterion("payway >=", value, "payway");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andPaywayLessThan(Integer value) {
      addCriterion("payway <", value, "payway");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andPaywayLessThanOrEqualTo(Integer value) {
      addCriterion("payway <=", value, "payway");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andPaywayIn(List<Integer> values) {
      addCriterion("payway in", values, "payway");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andPaywayNotIn(List<Integer> values) {
      addCriterion("payway not in", values, "payway");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andPaywayBetween(Integer value1, Integer value2) {
      addCriterion("payway between", value1, value2, "payway");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andPaywayNotBetween(Integer value1, Integer value2) {
      addCriterion("payway not between", value1, value2, "payway");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andRemarkIsNull() {
      addCriterion("remark is null");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andRemarkIsNotNull() {
      addCriterion("remark is not null");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andRemarkEqualTo(String value) {
      addCriterion("remark =", value, "remark");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andRemarkNotEqualTo(String value) {
      addCriterion("remark <>", value, "remark");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andRemarkGreaterThan(String value) {
      addCriterion("remark >", value, "remark");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andRemarkGreaterThanOrEqualTo(String value) {
      addCriterion("remark >=", value, "remark");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andRemarkLessThan(String value) {
      addCriterion("remark <", value, "remark");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andRemarkLessThanOrEqualTo(String value) {
      addCriterion("remark <=", value, "remark");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andRemarkLike(String value) {
      addCriterion("remark like", value, "remark");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andRemarkNotLike(String value) {
      addCriterion("remark not like", value, "remark");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andRemarkIn(List<String> values) {
      addCriterion("remark in", values, "remark");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andRemarkNotIn(List<String> values) {
      addCriterion("remark not in", values, "remark");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andRemarkBetween(String value1, String value2) {
      addCriterion("remark between", value1, value2, "remark");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andRemarkNotBetween(String value1, String value2) {
      addCriterion("remark not between", value1, value2, "remark");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andStatusIsNull() {
      addCriterion("status is null");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andStatusIsNotNull() {
      addCriterion("status is not null");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andStatusEqualTo(Integer value) {
      addCriterion("status =", value, "status");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andStatusNotEqualTo(Integer value) {
      addCriterion("status <>", value, "status");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andStatusGreaterThan(Integer value) {
      addCriterion("status >", value, "status");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andStatusGreaterThanOrEqualTo(Integer value) {
      addCriterion("status >=", value, "status");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andStatusLessThan(Integer value) {
      addCriterion("status <", value, "status");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andStatusLessThanOrEqualTo(Integer value) {
      addCriterion("status <=", value, "status");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andStatusIn(List<Integer> values) {
      addCriterion("status in", values, "status");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andStatusNotIn(List<Integer> values) {
      addCriterion("status not in", values, "status");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andStatusBetween(Integer value1, Integer value2) {
      addCriterion("status between", value1, value2, "status");
      return ((ProjectExample.Criteria)this);
    }

    public ProjectExample.Criteria andStatusNotBetween(Integer value1, Integer value2) {
      addCriterion("status not between", value1, value2, "status");
      return ((ProjectExample.Criteria)this);
    }
  }
}