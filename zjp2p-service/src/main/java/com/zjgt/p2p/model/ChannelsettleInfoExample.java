package com.zjgt.p2p.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ChannelsettleInfoExample
{
  protected String orderByClause;
  protected boolean distinct;
  protected List<Criteria> oredCriteria;

  public ChannelsettleInfoExample()
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

  public static class Criteria extends ChannelsettleInfoExample.GeneratedCriteria
  {
  }

  protected static abstract class GeneratedCriteria
  {
    protected List<ChannelsettleInfoExample.Criterion> criteria;

    protected GeneratedCriteria()
    {
      this.criteria = new ArrayList();
    }

    public boolean isValid() {
      return (this.criteria.size() > 0);
    }

    public List<ChannelsettleInfoExample.Criterion> getAllCriteria() {
      return this.criteria;
    }

    public List<ChannelsettleInfoExample.Criterion> getCriteria() {
      return this.criteria;
    }

    protected void addCriterion(String condition) {
      if (condition == null) {
        throw new RuntimeException("Value for condition cannot be null");
      }
      this.criteria.add(new ChannelsettleInfoExample.Criterion(condition));
    }

    protected void addCriterion(String condition, Object value, String property) {
      if (value == null) {
        throw new RuntimeException("Value for " + property + " cannot be null");
      }
      this.criteria.add(new ChannelsettleInfoExample.Criterion(condition, value));
    }

    protected void addCriterion(String condition, Object value1, Object value2, String property) {
      if ((value1 == null) || (value2 == null)) {
        throw new RuntimeException("Between values for " + property + " cannot be null");
      }
      this.criteria.add(new ChannelsettleInfoExample.Criterion(condition, value1, value2));
    }

    public ChannelsettleInfoExample.Criteria andIdIsNull() {
      addCriterion("id is null");
      return ((ChannelsettleInfoExample.Criteria)this);
    }

    public ChannelsettleInfoExample.Criteria andIdIsNotNull() {
      addCriterion("id is not null");
      return ((ChannelsettleInfoExample.Criteria)this);
    }

    public ChannelsettleInfoExample.Criteria andIdEqualTo(Long value) {
      addCriterion("id =", value, "id");
      return ((ChannelsettleInfoExample.Criteria)this);
    }

    public ChannelsettleInfoExample.Criteria andIdNotEqualTo(Long value) {
      addCriterion("id <>", value, "id");
      return ((ChannelsettleInfoExample.Criteria)this);
    }

    public ChannelsettleInfoExample.Criteria andIdGreaterThan(Long value) {
      addCriterion("id >", value, "id");
      return ((ChannelsettleInfoExample.Criteria)this);
    }

    public ChannelsettleInfoExample.Criteria andIdGreaterThanOrEqualTo(Long value) {
      addCriterion("id >=", value, "id");
      return ((ChannelsettleInfoExample.Criteria)this);
    }

    public ChannelsettleInfoExample.Criteria andIdLessThan(Long value) {
      addCriterion("id <", value, "id");
      return ((ChannelsettleInfoExample.Criteria)this);
    }

    public ChannelsettleInfoExample.Criteria andIdLessThanOrEqualTo(Long value) {
      addCriterion("id <=", value, "id");
      return ((ChannelsettleInfoExample.Criteria)this);
    }

    public ChannelsettleInfoExample.Criteria andIdIn(List<Long> values) {
      addCriterion("id in", values, "id");
      return ((ChannelsettleInfoExample.Criteria)this);
    }

    public ChannelsettleInfoExample.Criteria andIdNotIn(List<Long> values) {
      addCriterion("id not in", values, "id");
      return ((ChannelsettleInfoExample.Criteria)this);
    }

    public ChannelsettleInfoExample.Criteria andIdBetween(Long value1, Long value2) {
      addCriterion("id between", value1, value2, "id");
      return ((ChannelsettleInfoExample.Criteria)this);
    }

    public ChannelsettleInfoExample.Criteria andIdNotBetween(Long value1, Long value2) {
      addCriterion("id not between", value1, value2, "id");
      return ((ChannelsettleInfoExample.Criteria)this);
    }

    public ChannelsettleInfoExample.Criteria andBidtypeidIsNull() {
      addCriterion("bidtypeid is null");
      return ((ChannelsettleInfoExample.Criteria)this);
    }

    public ChannelsettleInfoExample.Criteria andBidtypeidIsNotNull() {
      addCriterion("bidtypeid is not null");
      return ((ChannelsettleInfoExample.Criteria)this);
    }

    public ChannelsettleInfoExample.Criteria andBidtypeidEqualTo(Integer value) {
      addCriterion("bidtypeid =", value, "bidtypeid");
      return ((ChannelsettleInfoExample.Criteria)this);
    }

    public ChannelsettleInfoExample.Criteria andBidtypeidNotEqualTo(Integer value) {
      addCriterion("bidtypeid <>", value, "bidtypeid");
      return ((ChannelsettleInfoExample.Criteria)this);
    }

    public ChannelsettleInfoExample.Criteria andBidtypeidGreaterThan(Integer value) {
      addCriterion("bidtypeid >", value, "bidtypeid");
      return ((ChannelsettleInfoExample.Criteria)this);
    }

    public ChannelsettleInfoExample.Criteria andBidtypeidGreaterThanOrEqualTo(Integer value) {
      addCriterion("bidtypeid >=", value, "bidtypeid");
      return ((ChannelsettleInfoExample.Criteria)this);
    }

    public ChannelsettleInfoExample.Criteria andBidtypeidLessThan(Integer value) {
      addCriterion("bidtypeid <", value, "bidtypeid");
      return ((ChannelsettleInfoExample.Criteria)this);
    }

    public ChannelsettleInfoExample.Criteria andBidtypeidLessThanOrEqualTo(Integer value) {
      addCriterion("bidtypeid <=", value, "bidtypeid");
      return ((ChannelsettleInfoExample.Criteria)this);
    }

    public ChannelsettleInfoExample.Criteria andBidtypeidIn(List<Integer> values) {
      addCriterion("bidtypeid in", values, "bidtypeid");
      return ((ChannelsettleInfoExample.Criteria)this);
    }

    public ChannelsettleInfoExample.Criteria andBidtypeidNotIn(List<Integer> values) {
      addCriterion("bidtypeid not in", values, "bidtypeid");
      return ((ChannelsettleInfoExample.Criteria)this);
    }

    public ChannelsettleInfoExample.Criteria andBidtypeidBetween(Integer value1, Integer value2) {
      addCriterion("bidtypeid between", value1, value2, "bidtypeid");
      return ((ChannelsettleInfoExample.Criteria)this);
    }

    public ChannelsettleInfoExample.Criteria andBidtypeidNotBetween(Integer value1, Integer value2) {
      addCriterion("bidtypeid not between", value1, value2, "bidtypeid");
      return ((ChannelsettleInfoExample.Criteria)this);
    }

    public ChannelsettleInfoExample.Criteria andChannelidIsNull() {
      addCriterion("channelid is null");
      return ((ChannelsettleInfoExample.Criteria)this);
    }

    public ChannelsettleInfoExample.Criteria andChannelidIsNotNull() {
      addCriterion("channelid is not null");
      return ((ChannelsettleInfoExample.Criteria)this);
    }

    public ChannelsettleInfoExample.Criteria andChannelidEqualTo(Integer value) {
      addCriterion("channelid =", value, "channelid");
      return ((ChannelsettleInfoExample.Criteria)this);
    }

    public ChannelsettleInfoExample.Criteria andChannelidNotEqualTo(Integer value) {
      addCriterion("channelid <>", value, "channelid");
      return ((ChannelsettleInfoExample.Criteria)this);
    }

    public ChannelsettleInfoExample.Criteria andChannelidGreaterThan(Integer value) {
      addCriterion("channelid >", value, "channelid");
      return ((ChannelsettleInfoExample.Criteria)this);
    }

    public ChannelsettleInfoExample.Criteria andChannelidGreaterThanOrEqualTo(Integer value) {
      addCriterion("channelid >=", value, "channelid");
      return ((ChannelsettleInfoExample.Criteria)this);
    }

    public ChannelsettleInfoExample.Criteria andChannelidLessThan(Integer value) {
      addCriterion("channelid <", value, "channelid");
      return ((ChannelsettleInfoExample.Criteria)this);
    }

    public ChannelsettleInfoExample.Criteria andChannelidLessThanOrEqualTo(Integer value) {
      addCriterion("channelid <=", value, "channelid");
      return ((ChannelsettleInfoExample.Criteria)this);
    }

    public ChannelsettleInfoExample.Criteria andChannelidIn(List<Integer> values) {
      addCriterion("channelid in", values, "channelid");
      return ((ChannelsettleInfoExample.Criteria)this);
    }

    public ChannelsettleInfoExample.Criteria andChannelidNotIn(List<Integer> values) {
      addCriterion("channelid not in", values, "channelid");
      return ((ChannelsettleInfoExample.Criteria)this);
    }

    public ChannelsettleInfoExample.Criteria andChannelidBetween(Integer value1, Integer value2) {
      addCriterion("channelid between", value1, value2, "channelid");
      return ((ChannelsettleInfoExample.Criteria)this);
    }

    public ChannelsettleInfoExample.Criteria andChannelidNotBetween(Integer value1, Integer value2) {
      addCriterion("channelid not between", value1, value2, "channelid");
      return ((ChannelsettleInfoExample.Criteria)this);
    }

    public ChannelsettleInfoExample.Criteria andSettleperiodIsNull() {
      addCriterion("settleperiod is null");
      return ((ChannelsettleInfoExample.Criteria)this);
    }

    public ChannelsettleInfoExample.Criteria andSettleperiodIsNotNull() {
      addCriterion("settleperiod is not null");
      return ((ChannelsettleInfoExample.Criteria)this);
    }

    public ChannelsettleInfoExample.Criteria andSettleperiodEqualTo(Integer value) {
      addCriterion("settleperiod =", value, "settleperiod");
      return ((ChannelsettleInfoExample.Criteria)this);
    }

    public ChannelsettleInfoExample.Criteria andSettleperiodNotEqualTo(Integer value) {
      addCriterion("settleperiod <>", value, "settleperiod");
      return ((ChannelsettleInfoExample.Criteria)this);
    }

    public ChannelsettleInfoExample.Criteria andSettleperiodGreaterThan(Integer value) {
      addCriterion("settleperiod >", value, "settleperiod");
      return ((ChannelsettleInfoExample.Criteria)this);
    }

    public ChannelsettleInfoExample.Criteria andSettleperiodGreaterThanOrEqualTo(Integer value) {
      addCriterion("settleperiod >=", value, "settleperiod");
      return ((ChannelsettleInfoExample.Criteria)this);
    }

    public ChannelsettleInfoExample.Criteria andSettleperiodLessThan(Integer value) {
      addCriterion("settleperiod <", value, "settleperiod");
      return ((ChannelsettleInfoExample.Criteria)this);
    }

    public ChannelsettleInfoExample.Criteria andSettleperiodLessThanOrEqualTo(Integer value) {
      addCriterion("settleperiod <=", value, "settleperiod");
      return ((ChannelsettleInfoExample.Criteria)this);
    }

    public ChannelsettleInfoExample.Criteria andSettleperiodIn(List<Integer> values) {
      addCriterion("settleperiod in", values, "settleperiod");
      return ((ChannelsettleInfoExample.Criteria)this);
    }

    public ChannelsettleInfoExample.Criteria andSettleperiodNotIn(List<Integer> values) {
      addCriterion("settleperiod not in", values, "settleperiod");
      return ((ChannelsettleInfoExample.Criteria)this);
    }

    public ChannelsettleInfoExample.Criteria andSettleperiodBetween(Integer value1, Integer value2) {
      addCriterion("settleperiod between", value1, value2, "settleperiod");
      return ((ChannelsettleInfoExample.Criteria)this);
    }

    public ChannelsettleInfoExample.Criteria andSettleperiodNotBetween(Integer value1, Integer value2) {
      addCriterion("settleperiod not between", value1, value2, "settleperiod");
      return ((ChannelsettleInfoExample.Criteria)this);
    }

    public ChannelsettleInfoExample.Criteria andSettledateIsNull() {
      addCriterion("settledate is null");
      return ((ChannelsettleInfoExample.Criteria)this);
    }

    public ChannelsettleInfoExample.Criteria andSettledateIsNotNull() {
      addCriterion("settledate is not null");
      return ((ChannelsettleInfoExample.Criteria)this);
    }

    public ChannelsettleInfoExample.Criteria andSettledateEqualTo(Date value) {
      addCriterion("settledate =", value, "settledate");
      return ((ChannelsettleInfoExample.Criteria)this);
    }

    public ChannelsettleInfoExample.Criteria andSettledateNotEqualTo(Date value) {
      addCriterion("settledate <>", value, "settledate");
      return ((ChannelsettleInfoExample.Criteria)this);
    }

    public ChannelsettleInfoExample.Criteria andSettledateGreaterThan(Date value) {
      addCriterion("settledate >", value, "settledate");
      return ((ChannelsettleInfoExample.Criteria)this);
    }

    public ChannelsettleInfoExample.Criteria andSettledateGreaterThanOrEqualTo(Date value) {
      addCriterion("settledate >=", value, "settledate");
      return ((ChannelsettleInfoExample.Criteria)this);
    }

    public ChannelsettleInfoExample.Criteria andSettledateLessThan(Date value) {
      addCriterion("settledate <", value, "settledate");
      return ((ChannelsettleInfoExample.Criteria)this);
    }

    public ChannelsettleInfoExample.Criteria andSettledateLessThanOrEqualTo(Date value) {
      addCriterion("settledate <=", value, "settledate");
      return ((ChannelsettleInfoExample.Criteria)this);
    }

    public ChannelsettleInfoExample.Criteria andSettledateIn(List<Date> values) {
      addCriterion("settledate in", values, "settledate");
      return ((ChannelsettleInfoExample.Criteria)this);
    }

    public ChannelsettleInfoExample.Criteria andSettledateNotIn(List<Date> values) {
      addCriterion("settledate not in", values, "settledate");
      return ((ChannelsettleInfoExample.Criteria)this);
    }

    public ChannelsettleInfoExample.Criteria andSettledateBetween(Date value1, Date value2) {
      addCriterion("settledate between", value1, value2, "settledate");
      return ((ChannelsettleInfoExample.Criteria)this);
    }

    public ChannelsettleInfoExample.Criteria andSettledateNotBetween(Date value1, Date value2) {
      addCriterion("settledate not between", value1, value2, "settledate");
      return ((ChannelsettleInfoExample.Criteria)this);
    }

    public ChannelsettleInfoExample.Criteria andRemarkIsNull() {
      addCriterion("remark is null");
      return ((ChannelsettleInfoExample.Criteria)this);
    }

    public ChannelsettleInfoExample.Criteria andRemarkIsNotNull() {
      addCriterion("remark is not null");
      return ((ChannelsettleInfoExample.Criteria)this);
    }

    public ChannelsettleInfoExample.Criteria andRemarkEqualTo(String value) {
      addCriterion("remark =", value, "remark");
      return ((ChannelsettleInfoExample.Criteria)this);
    }

    public ChannelsettleInfoExample.Criteria andRemarkNotEqualTo(String value) {
      addCriterion("remark <>", value, "remark");
      return ((ChannelsettleInfoExample.Criteria)this);
    }

    public ChannelsettleInfoExample.Criteria andRemarkGreaterThan(String value) {
      addCriterion("remark >", value, "remark");
      return ((ChannelsettleInfoExample.Criteria)this);
    }

    public ChannelsettleInfoExample.Criteria andRemarkGreaterThanOrEqualTo(String value) {
      addCriterion("remark >=", value, "remark");
      return ((ChannelsettleInfoExample.Criteria)this);
    }

    public ChannelsettleInfoExample.Criteria andRemarkLessThan(String value) {
      addCriterion("remark <", value, "remark");
      return ((ChannelsettleInfoExample.Criteria)this);
    }

    public ChannelsettleInfoExample.Criteria andRemarkLessThanOrEqualTo(String value) {
      addCriterion("remark <=", value, "remark");
      return ((ChannelsettleInfoExample.Criteria)this);
    }

    public ChannelsettleInfoExample.Criteria andRemarkLike(String value) {
      addCriterion("remark like", value, "remark");
      return ((ChannelsettleInfoExample.Criteria)this);
    }

    public ChannelsettleInfoExample.Criteria andRemarkNotLike(String value) {
      addCriterion("remark not like", value, "remark");
      return ((ChannelsettleInfoExample.Criteria)this);
    }

    public ChannelsettleInfoExample.Criteria andRemarkIn(List<String> values) {
      addCriterion("remark in", values, "remark");
      return ((ChannelsettleInfoExample.Criteria)this);
    }

    public ChannelsettleInfoExample.Criteria andRemarkNotIn(List<String> values) {
      addCriterion("remark not in", values, "remark");
      return ((ChannelsettleInfoExample.Criteria)this);
    }

    public ChannelsettleInfoExample.Criteria andRemarkBetween(String value1, String value2) {
      addCriterion("remark between", value1, value2, "remark");
      return ((ChannelsettleInfoExample.Criteria)this);
    }

    public ChannelsettleInfoExample.Criteria andRemarkNotBetween(String value1, String value2) {
      addCriterion("remark not between", value1, value2, "remark");
      return ((ChannelsettleInfoExample.Criteria)this);
    }
  }
}