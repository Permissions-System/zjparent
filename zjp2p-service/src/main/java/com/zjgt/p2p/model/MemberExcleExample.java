package com.zjgt.p2p.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MemberExcleExample
{
  protected String orderByClause;
  protected boolean distinct;
  protected List<Criteria> oredCriteria;

  public MemberExcleExample()
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

  public static class Criteria extends MemberExcleExample.GeneratedCriteria
  {
  }

  protected static abstract class GeneratedCriteria
  {
    protected List<MemberExcleExample.Criterion> criteria;

    protected GeneratedCriteria()
    {
      this.criteria = new ArrayList();
    }

    public boolean isValid() {
      return (this.criteria.size() > 0);
    }

    public List<MemberExcleExample.Criterion> getAllCriteria() {
      return this.criteria;
    }

    public List<MemberExcleExample.Criterion> getCriteria() {
      return this.criteria;
    }

    protected void addCriterion(String condition) {
      if (condition == null) {
        throw new RuntimeException("Value for condition cannot be null");
      }
      this.criteria.add(new MemberExcleExample.Criterion(condition));
    }

    protected void addCriterion(String condition, Object value, String property) {
      if (value == null) {
        throw new RuntimeException("Value for " + property + " cannot be null");
      }
      this.criteria.add(new MemberExcleExample.Criterion(condition, value));
    }

    protected void addCriterion(String condition, Object value1, Object value2, String property) {
      if ((value1 == null) || (value2 == null)) {
        throw new RuntimeException("Between values for " + property + " cannot be null");
      }
      this.criteria.add(new MemberExcleExample.Criterion(condition, value1, value2));
    }

    public MemberExcleExample.Criteria andIdIsNotNull() {
      addCriterion("m.id is not null");
      return ((MemberExcleExample.Criteria)this);
    }

    public MemberExcleExample.Criteria andEmailOrMobileLike(String value) {
      addCriterion("(m.email like '" + value + "' or m.mobile like '" + value + "' )");
      return ((MemberExcleExample.Criteria)this);
    }

    public MemberExcleExample.Criteria andUsernameLike(String value) {
      addCriterion("m.username like", value, "m.username");
      return ((MemberExcleExample.Criteria)this);
    }

    public MemberExcleExample.Criteria andRealnameLike(String value) {
      addCriterion("m.realname like", value, "m.realname");
      return ((MemberExcleExample.Criteria)this);
    }

    public MemberExcleExample.Criteria andCreateDateBetween(Date value1, Date value2) {
      addCriterion("m.create_date between", value1, value2, "m.createDate");
      return ((MemberExcleExample.Criteria)this);
    }

    public MemberExcleExample.Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
      addCriterion("m.create_date >=", value, "m.createDate");
      return ((MemberExcleExample.Criteria)this);
    }

    public MemberExcleExample.Criteria andCreateDateLessThanOrEqualTo(Date value) {
      addCriterion("m.create_date <=", value, "m.createDate");
      return ((MemberExcleExample.Criteria)this);
    }

    public MemberExcleExample.Criteria andUserstatusEqualTo(Short value) {
      addCriterion("m.userstatus =", value, "m.userstatus");
      return ((MemberExcleExample.Criteria)this);
    }

    public MemberExcleExample.Criteria andAgentidEqualTo(Long value) {
      addCriterion("m.agentid =", value, "m.agentid");
      return ((MemberExcleExample.Criteria)this);
    }

    public MemberExcleExample.Criteria andRegSourceEqualTo(Long value) {
      addCriterion("m.regSource =", value, "m.regSource");
      return ((MemberExcleExample.Criteria)this);
    }
  }
}