package com.zjgt.p2p.model;

import java.util.ArrayList;
import java.util.List;

public class TransdefExample
{
  protected String orderByClause;
  protected boolean distinct;
  protected List<Criteria> oredCriteria;

  public TransdefExample()
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

  public static class Criteria extends TransdefExample.GeneratedCriteria
  {
  }

  protected static abstract class GeneratedCriteria
  {
    protected List<TransdefExample.Criterion> criteria;

    protected GeneratedCriteria()
    {
      this.criteria = new ArrayList();
    }

    public boolean isValid() {
      return (this.criteria.size() > 0);
    }

    public List<TransdefExample.Criterion> getAllCriteria() {
      return this.criteria;
    }

    public List<TransdefExample.Criterion> getCriteria() {
      return this.criteria;
    }

    protected void addCriterion(String condition) {
      if (condition == null) {
        throw new RuntimeException("Value for condition cannot be null");
      }
      this.criteria.add(new TransdefExample.Criterion(condition));
    }

    protected void addCriterion(String condition, Object value, String property) {
      if (value == null) {
        throw new RuntimeException("Value for " + property + " cannot be null");
      }
      this.criteria.add(new TransdefExample.Criterion(condition, value));
    }

    protected void addCriterion(String condition, Object value1, Object value2, String property) {
      if ((value1 == null) || (value2 == null)) {
        throw new RuntimeException("Between values for " + property + " cannot be null");
      }
      this.criteria.add(new TransdefExample.Criterion(condition, value1, value2));
    }

    public TransdefExample.Criteria andTrancodeIsNull() {
      addCriterion("TranCode is null");
      return ((TransdefExample.Criteria)this);
    }

    public TransdefExample.Criteria andTrancodeIsNotNull() {
      addCriterion("TranCode is not null");
      return ((TransdefExample.Criteria)this);
    }

    public TransdefExample.Criteria andTrancodeEqualTo(String value) {
      addCriterion("TranCode =", value, "trancode");
      return ((TransdefExample.Criteria)this);
    }

    public TransdefExample.Criteria andTrancodeNotEqualTo(String value) {
      addCriterion("TranCode <>", value, "trancode");
      return ((TransdefExample.Criteria)this);
    }

    public TransdefExample.Criteria andTrancodeGreaterThan(String value) {
      addCriterion("TranCode >", value, "trancode");
      return ((TransdefExample.Criteria)this);
    }

    public TransdefExample.Criteria andTrancodeGreaterThanOrEqualTo(String value) {
      addCriterion("TranCode >=", value, "trancode");
      return ((TransdefExample.Criteria)this);
    }

    public TransdefExample.Criteria andTrancodeLessThan(String value) {
      addCriterion("TranCode <", value, "trancode");
      return ((TransdefExample.Criteria)this);
    }

    public TransdefExample.Criteria andTrancodeLessThanOrEqualTo(String value) {
      addCriterion("TranCode <=", value, "trancode");
      return ((TransdefExample.Criteria)this);
    }

    public TransdefExample.Criteria andTrancodeLike(String value) {
      addCriterion("TranCode like", value, "trancode");
      return ((TransdefExample.Criteria)this);
    }

    public TransdefExample.Criteria andTrancodeNotLike(String value) {
      addCriterion("TranCode not like", value, "trancode");
      return ((TransdefExample.Criteria)this);
    }

    public TransdefExample.Criteria andTrancodeIn(List<String> values) {
      addCriterion("TranCode in", values, "trancode");
      return ((TransdefExample.Criteria)this);
    }

    public TransdefExample.Criteria andTrancodeNotIn(List<String> values) {
      addCriterion("TranCode not in", values, "trancode");
      return ((TransdefExample.Criteria)this);
    }

    public TransdefExample.Criteria andTrancodeBetween(String value1, String value2) {
      addCriterion("TranCode between", value1, value2, "trancode");
      return ((TransdefExample.Criteria)this);
    }

    public TransdefExample.Criteria andTrancodeNotBetween(String value1, String value2) {
      addCriterion("TranCode not between", value1, value2, "trancode");
      return ((TransdefExample.Criteria)this);
    }

    public TransdefExample.Criteria andTrantypeIsNull() {
      addCriterion("TranType is null");
      return ((TransdefExample.Criteria)this);
    }

    public TransdefExample.Criteria andTrantypeIsNotNull() {
      addCriterion("TranType is not null");
      return ((TransdefExample.Criteria)this);
    }

    public TransdefExample.Criteria andTrantypeEqualTo(String value) {
      addCriterion("TranType =", value, "trantype");
      return ((TransdefExample.Criteria)this);
    }

    public TransdefExample.Criteria andTrantypeNotEqualTo(String value) {
      addCriterion("TranType <>", value, "trantype");
      return ((TransdefExample.Criteria)this);
    }

    public TransdefExample.Criteria andTrantypeGreaterThan(String value) {
      addCriterion("TranType >", value, "trantype");
      return ((TransdefExample.Criteria)this);
    }

    public TransdefExample.Criteria andTrantypeGreaterThanOrEqualTo(String value) {
      addCriterion("TranType >=", value, "trantype");
      return ((TransdefExample.Criteria)this);
    }

    public TransdefExample.Criteria andTrantypeLessThan(String value) {
      addCriterion("TranType <", value, "trantype");
      return ((TransdefExample.Criteria)this);
    }

    public TransdefExample.Criteria andTrantypeLessThanOrEqualTo(String value) {
      addCriterion("TranType <=", value, "trantype");
      return ((TransdefExample.Criteria)this);
    }

    public TransdefExample.Criteria andTrantypeLike(String value) {
      addCriterion("TranType like", value, "trantype");
      return ((TransdefExample.Criteria)this);
    }

    public TransdefExample.Criteria andTrantypeNotLike(String value) {
      addCriterion("TranType not like", value, "trantype");
      return ((TransdefExample.Criteria)this);
    }

    public TransdefExample.Criteria andTrantypeIn(List<String> values) {
      addCriterion("TranType in", values, "trantype");
      return ((TransdefExample.Criteria)this);
    }

    public TransdefExample.Criteria andTrantypeNotIn(List<String> values) {
      addCriterion("TranType not in", values, "trantype");
      return ((TransdefExample.Criteria)this);
    }

    public TransdefExample.Criteria andTrantypeBetween(String value1, String value2) {
      addCriterion("TranType between", value1, value2, "trantype");
      return ((TransdefExample.Criteria)this);
    }

    public TransdefExample.Criteria andTrantypeNotBetween(String value1, String value2) {
      addCriterion("TranType not between", value1, value2, "trantype");
      return ((TransdefExample.Criteria)this);
    }

    public TransdefExample.Criteria andTrannameIsNull() {
      addCriterion("TranName is null");
      return ((TransdefExample.Criteria)this);
    }

    public TransdefExample.Criteria andTrannameIsNotNull() {
      addCriterion("TranName is not null");
      return ((TransdefExample.Criteria)this);
    }

    public TransdefExample.Criteria andTrannameEqualTo(String value) {
      addCriterion("TranName =", value, "tranname");
      return ((TransdefExample.Criteria)this);
    }

    public TransdefExample.Criteria andTrannameNotEqualTo(String value) {
      addCriterion("TranName <>", value, "tranname");
      return ((TransdefExample.Criteria)this);
    }

    public TransdefExample.Criteria andTrannameGreaterThan(String value) {
      addCriterion("TranName >", value, "tranname");
      return ((TransdefExample.Criteria)this);
    }

    public TransdefExample.Criteria andTrannameGreaterThanOrEqualTo(String value) {
      addCriterion("TranName >=", value, "tranname");
      return ((TransdefExample.Criteria)this);
    }

    public TransdefExample.Criteria andTrannameLessThan(String value) {
      addCriterion("TranName <", value, "tranname");
      return ((TransdefExample.Criteria)this);
    }

    public TransdefExample.Criteria andTrannameLessThanOrEqualTo(String value) {
      addCriterion("TranName <=", value, "tranname");
      return ((TransdefExample.Criteria)this);
    }

    public TransdefExample.Criteria andTrannameLike(String value) {
      addCriterion("TranName like", value, "tranname");
      return ((TransdefExample.Criteria)this);
    }

    public TransdefExample.Criteria andTrannameNotLike(String value) {
      addCriterion("TranName not like", value, "tranname");
      return ((TransdefExample.Criteria)this);
    }

    public TransdefExample.Criteria andTrannameIn(List<String> values) {
      addCriterion("TranName in", values, "tranname");
      return ((TransdefExample.Criteria)this);
    }

    public TransdefExample.Criteria andTrannameNotIn(List<String> values) {
      addCriterion("TranName not in", values, "tranname");
      return ((TransdefExample.Criteria)this);
    }

    public TransdefExample.Criteria andTrannameBetween(String value1, String value2) {
      addCriterion("TranName between", value1, value2, "tranname");
      return ((TransdefExample.Criteria)this);
    }

    public TransdefExample.Criteria andTrannameNotBetween(String value1, String value2) {
      addCriterion("TranName not between", value1, value2, "tranname");
      return ((TransdefExample.Criteria)this);
    }

    public TransdefExample.Criteria andTranstatusIsNull() {
      addCriterion("TranStatus is null");
      return ((TransdefExample.Criteria)this);
    }

    public TransdefExample.Criteria andTranstatusIsNotNull() {
      addCriterion("TranStatus is not null");
      return ((TransdefExample.Criteria)this);
    }

    public TransdefExample.Criteria andTranstatusEqualTo(String value) {
      addCriterion("TranStatus =", value, "transtatus");
      return ((TransdefExample.Criteria)this);
    }

    public TransdefExample.Criteria andTranstatusNotEqualTo(String value) {
      addCriterion("TranStatus <>", value, "transtatus");
      return ((TransdefExample.Criteria)this);
    }

    public TransdefExample.Criteria andTranstatusGreaterThan(String value) {
      addCriterion("TranStatus >", value, "transtatus");
      return ((TransdefExample.Criteria)this);
    }

    public TransdefExample.Criteria andTranstatusGreaterThanOrEqualTo(String value) {
      addCriterion("TranStatus >=", value, "transtatus");
      return ((TransdefExample.Criteria)this);
    }

    public TransdefExample.Criteria andTranstatusLessThan(String value) {
      addCriterion("TranStatus <", value, "transtatus");
      return ((TransdefExample.Criteria)this);
    }

    public TransdefExample.Criteria andTranstatusLessThanOrEqualTo(String value) {
      addCriterion("TranStatus <=", value, "transtatus");
      return ((TransdefExample.Criteria)this);
    }

    public TransdefExample.Criteria andTranstatusLike(String value) {
      addCriterion("TranStatus like", value, "transtatus");
      return ((TransdefExample.Criteria)this);
    }

    public TransdefExample.Criteria andTranstatusNotLike(String value) {
      addCriterion("TranStatus not like", value, "transtatus");
      return ((TransdefExample.Criteria)this);
    }

    public TransdefExample.Criteria andTranstatusIn(List<String> values) {
      addCriterion("TranStatus in", values, "transtatus");
      return ((TransdefExample.Criteria)this);
    }

    public TransdefExample.Criteria andTranstatusNotIn(List<String> values) {
      addCriterion("TranStatus not in", values, "transtatus");
      return ((TransdefExample.Criteria)this);
    }

    public TransdefExample.Criteria andTranstatusBetween(String value1, String value2) {
      addCriterion("TranStatus between", value1, value2, "transtatus");
      return ((TransdefExample.Criteria)this);
    }

    public TransdefExample.Criteria andTranstatusNotBetween(String value1, String value2) {
      addCriterion("TranStatus not between", value1, value2, "transtatus");
      return ((TransdefExample.Criteria)this);
    }

    public TransdefExample.Criteria andTrandescIsNull() {
      addCriterion("TranDesc is null");
      return ((TransdefExample.Criteria)this);
    }

    public TransdefExample.Criteria andTrandescIsNotNull() {
      addCriterion("TranDesc is not null");
      return ((TransdefExample.Criteria)this);
    }

    public TransdefExample.Criteria andTrandescEqualTo(String value) {
      addCriterion("TranDesc =", value, "trandesc");
      return ((TransdefExample.Criteria)this);
    }

    public TransdefExample.Criteria andTrandescNotEqualTo(String value) {
      addCriterion("TranDesc <>", value, "trandesc");
      return ((TransdefExample.Criteria)this);
    }

    public TransdefExample.Criteria andTrandescGreaterThan(String value) {
      addCriterion("TranDesc >", value, "trandesc");
      return ((TransdefExample.Criteria)this);
    }

    public TransdefExample.Criteria andTrandescGreaterThanOrEqualTo(String value) {
      addCriterion("TranDesc >=", value, "trandesc");
      return ((TransdefExample.Criteria)this);
    }

    public TransdefExample.Criteria andTrandescLessThan(String value) {
      addCriterion("TranDesc <", value, "trandesc");
      return ((TransdefExample.Criteria)this);
    }

    public TransdefExample.Criteria andTrandescLessThanOrEqualTo(String value) {
      addCriterion("TranDesc <=", value, "trandesc");
      return ((TransdefExample.Criteria)this);
    }

    public TransdefExample.Criteria andTrandescLike(String value) {
      addCriterion("TranDesc like", value, "trandesc");
      return ((TransdefExample.Criteria)this);
    }

    public TransdefExample.Criteria andTrandescNotLike(String value) {
      addCriterion("TranDesc not like", value, "trandesc");
      return ((TransdefExample.Criteria)this);
    }

    public TransdefExample.Criteria andTrandescIn(List<String> values) {
      addCriterion("TranDesc in", values, "trandesc");
      return ((TransdefExample.Criteria)this);
    }

    public TransdefExample.Criteria andTrandescNotIn(List<String> values) {
      addCriterion("TranDesc not in", values, "trandesc");
      return ((TransdefExample.Criteria)this);
    }

    public TransdefExample.Criteria andTrandescBetween(String value1, String value2) {
      addCriterion("TranDesc between", value1, value2, "trandesc");
      return ((TransdefExample.Criteria)this);
    }

    public TransdefExample.Criteria andTrandescNotBetween(String value1, String value2) {
      addCriterion("TranDesc not between", value1, value2, "trandesc");
      return ((TransdefExample.Criteria)this);
    }

    public TransdefExample.Criteria andIsnotifyIsNull() {
      addCriterion("IsNotify is null");
      return ((TransdefExample.Criteria)this);
    }

    public TransdefExample.Criteria andIsnotifyIsNotNull() {
      addCriterion("IsNotify is not null");
      return ((TransdefExample.Criteria)this);
    }

    public TransdefExample.Criteria andIsnotifyEqualTo(Byte value) {
      addCriterion("IsNotify =", value, "isnotify");
      return ((TransdefExample.Criteria)this);
    }

    public TransdefExample.Criteria andIsnotifyNotEqualTo(Byte value) {
      addCriterion("IsNotify <>", value, "isnotify");
      return ((TransdefExample.Criteria)this);
    }

    public TransdefExample.Criteria andIsnotifyGreaterThan(Byte value) {
      addCriterion("IsNotify >", value, "isnotify");
      return ((TransdefExample.Criteria)this);
    }

    public TransdefExample.Criteria andIsnotifyGreaterThanOrEqualTo(Byte value) {
      addCriterion("IsNotify >=", value, "isnotify");
      return ((TransdefExample.Criteria)this);
    }

    public TransdefExample.Criteria andIsnotifyLessThan(Byte value) {
      addCriterion("IsNotify <", value, "isnotify");
      return ((TransdefExample.Criteria)this);
    }

    public TransdefExample.Criteria andIsnotifyLessThanOrEqualTo(Byte value) {
      addCriterion("IsNotify <=", value, "isnotify");
      return ((TransdefExample.Criteria)this);
    }

    public TransdefExample.Criteria andIsnotifyIn(List<Byte> values) {
      addCriterion("IsNotify in", values, "isnotify");
      return ((TransdefExample.Criteria)this);
    }

    public TransdefExample.Criteria andIsnotifyNotIn(List<Byte> values) {
      addCriterion("IsNotify not in", values, "isnotify");
      return ((TransdefExample.Criteria)this);
    }

    public TransdefExample.Criteria andIsnotifyBetween(Byte value1, Byte value2) {
      addCriterion("IsNotify between", value1, value2, "isnotify");
      return ((TransdefExample.Criteria)this);
    }

    public TransdefExample.Criteria andIsnotifyNotBetween(Byte value1, Byte value2) {
      addCriterion("IsNotify not between", value1, value2, "isnotify");
      return ((TransdefExample.Criteria)this);
    }

    public TransdefExample.Criteria andNotifymethodIsNull() {
      addCriterion("NotifyMethod is null");
      return ((TransdefExample.Criteria)this);
    }

    public TransdefExample.Criteria andNotifymethodIsNotNull() {
      addCriterion("NotifyMethod is not null");
      return ((TransdefExample.Criteria)this);
    }

    public TransdefExample.Criteria andNotifymethodEqualTo(String value) {
      addCriterion("NotifyMethod =", value, "notifymethod");
      return ((TransdefExample.Criteria)this);
    }

    public TransdefExample.Criteria andNotifymethodNotEqualTo(String value) {
      addCriterion("NotifyMethod <>", value, "notifymethod");
      return ((TransdefExample.Criteria)this);
    }

    public TransdefExample.Criteria andNotifymethodGreaterThan(String value) {
      addCriterion("NotifyMethod >", value, "notifymethod");
      return ((TransdefExample.Criteria)this);
    }

    public TransdefExample.Criteria andNotifymethodGreaterThanOrEqualTo(String value) {
      addCriterion("NotifyMethod >=", value, "notifymethod");
      return ((TransdefExample.Criteria)this);
    }

    public TransdefExample.Criteria andNotifymethodLessThan(String value) {
      addCriterion("NotifyMethod <", value, "notifymethod");
      return ((TransdefExample.Criteria)this);
    }

    public TransdefExample.Criteria andNotifymethodLessThanOrEqualTo(String value) {
      addCriterion("NotifyMethod <=", value, "notifymethod");
      return ((TransdefExample.Criteria)this);
    }

    public TransdefExample.Criteria andNotifymethodLike(String value) {
      addCriterion("NotifyMethod like", value, "notifymethod");
      return ((TransdefExample.Criteria)this);
    }

    public TransdefExample.Criteria andNotifymethodNotLike(String value) {
      addCriterion("NotifyMethod not like", value, "notifymethod");
      return ((TransdefExample.Criteria)this);
    }

    public TransdefExample.Criteria andNotifymethodIn(List<String> values) {
      addCriterion("NotifyMethod in", values, "notifymethod");
      return ((TransdefExample.Criteria)this);
    }

    public TransdefExample.Criteria andNotifymethodNotIn(List<String> values) {
      addCriterion("NotifyMethod not in", values, "notifymethod");
      return ((TransdefExample.Criteria)this);
    }

    public TransdefExample.Criteria andNotifymethodBetween(String value1, String value2) {
      addCriterion("NotifyMethod between", value1, value2, "notifymethod");
      return ((TransdefExample.Criteria)this);
    }

    public TransdefExample.Criteria andNotifymethodNotBetween(String value1, String value2) {
      addCriterion("NotifyMethod not between", value1, value2, "notifymethod");
      return ((TransdefExample.Criteria)this);
    }
  }
}