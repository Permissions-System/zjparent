package com.zjgt.p2p.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CpssettlelogExample
{
  protected String orderByClause;
  protected boolean distinct;
  protected List<Criteria> oredCriteria;

  public CpssettlelogExample()
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

  public static class Criteria extends CpssettlelogExample.GeneratedCriteria
  {
  }

  protected static abstract class GeneratedCriteria
  {
    protected List<CpssettlelogExample.Criterion> criteria;

    protected GeneratedCriteria()
    {
      this.criteria = new ArrayList();
    }

    public boolean isValid() {
      return (this.criteria.size() > 0);
    }

    public List<CpssettlelogExample.Criterion> getAllCriteria() {
      return this.criteria;
    }

    public List<CpssettlelogExample.Criterion> getCriteria() {
      return this.criteria;
    }

    protected void addCriterion(String condition) {
      if (condition == null) {
        throw new RuntimeException("Value for condition cannot be null");
      }
      this.criteria.add(new CpssettlelogExample.Criterion(condition));
    }

    protected void addCriterion(String condition, Object value, String property) {
      if (value == null) {
        throw new RuntimeException("Value for " + property + " cannot be null");
      }
      this.criteria.add(new CpssettlelogExample.Criterion(condition, value));
    }

    protected void addCriterion(String condition, Object value1, Object value2, String property) {
      if ((value1 == null) || (value2 == null)) {
        throw new RuntimeException("Between values for " + property + " cannot be null");
      }
      this.criteria.add(new CpssettlelogExample.Criterion(condition, value1, value2));
    }

    public CpssettlelogExample.Criteria andIdIsNull() {
      addCriterion("id is null");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andIdIsNotNull() {
      addCriterion("id is not null");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andIdEqualTo(Long value) {
      addCriterion("id =", value, "id");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andIdNotEqualTo(Long value) {
      addCriterion("id <>", value, "id");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andIdGreaterThan(Long value) {
      addCriterion("id >", value, "id");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andIdGreaterThanOrEqualTo(Long value) {
      addCriterion("id >=", value, "id");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andIdLessThan(Long value) {
      addCriterion("id <", value, "id");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andIdLessThanOrEqualTo(Long value) {
      addCriterion("id <=", value, "id");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andIdIn(List<Long> values) {
      addCriterion("id in", values, "id");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andIdNotIn(List<Long> values) {
      addCriterion("id not in", values, "id");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andIdBetween(Long value1, Long value2) {
      addCriterion("id between", value1, value2, "id");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andIdNotBetween(Long value1, Long value2) {
      addCriterion("id not between", value1, value2, "id");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andTermnumIsNull() {
      addCriterion("termnum is null");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andTermnumIsNotNull() {
      addCriterion("termnum is not null");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andTermnumEqualTo(Integer value) {
      addCriterion("termnum =", value, "termnum");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andTermnumNotEqualTo(Integer value) {
      addCriterion("termnum <>", value, "termnum");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andTermnumGreaterThan(Integer value) {
      addCriterion("termnum >", value, "termnum");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andTermnumGreaterThanOrEqualTo(Integer value) {
      addCriterion("termnum >=", value, "termnum");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andTermnumLessThan(Integer value) {
      addCriterion("termnum <", value, "termnum");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andTermnumLessThanOrEqualTo(Integer value) {
      addCriterion("termnum <=", value, "termnum");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andTermnumIn(List<Integer> values) {
      addCriterion("termnum in", values, "termnum");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andTermnumNotIn(List<Integer> values) {
      addCriterion("termnum not in", values, "termnum");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andTermnumBetween(Integer value1, Integer value2) {
      addCriterion("termnum between", value1, value2, "termnum");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andTermnumNotBetween(Integer value1, Integer value2) {
      addCriterion("termnum not between", value1, value2, "termnum");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andChannelIsNull() {
      addCriterion("channel is null");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andChannelIsNotNull() {
      addCriterion("channel is not null");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andChannelEqualTo(String value) {
      addCriterion("channel =", value, "channel");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andChannelNotEqualTo(String value) {
      addCriterion("channel <>", value, "channel");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andChannelGreaterThan(String value) {
      addCriterion("channel >", value, "channel");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andChannelGreaterThanOrEqualTo(String value) {
      addCriterion("channel >=", value, "channel");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andChannelLessThan(String value) {
      addCriterion("channel <", value, "channel");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andChannelLessThanOrEqualTo(String value) {
      addCriterion("channel <=", value, "channel");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andChannelLike(String value) {
      addCriterion("channel like", value, "channel");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andChannelNotLike(String value) {
      addCriterion("channel not like", value, "channel");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andChannelIn(List<String> values) {
      addCriterion("channel in", values, "channel");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andChannelNotIn(List<String> values) {
      addCriterion("channel not in", values, "channel");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andChannelBetween(String value1, String value2) {
      addCriterion("channel between", value1, value2, "channel");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andChannelNotBetween(String value1, String value2) {
      addCriterion("channel not between", value1, value2, "channel");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andChannel2IsNull() {
      addCriterion("channel2 is null");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andChannel2IsNotNull() {
      addCriterion("channel2 is not null");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andChannel2EqualTo(String value) {
      addCriterion("channel2 =", value, "channel2");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andChannel2NotEqualTo(String value) {
      addCriterion("channel2 <>", value, "channel2");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andChannel2GreaterThan(String value) {
      addCriterion("channel2 >", value, "channel2");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andChannel2GreaterThanOrEqualTo(String value) {
      addCriterion("channel2 >=", value, "channel2");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andChannel2LessThan(String value) {
      addCriterion("channel2 <", value, "channel2");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andChannel2LessThanOrEqualTo(String value) {
      addCriterion("channel2 <=", value, "channel2");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andChannel2Like(String value) {
      addCriterion("channel2 like", value, "channel2");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andChannel2NotLike(String value) {
      addCriterion("channel2 not like", value, "channel2");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andChannel2In(List<String> values) {
      addCriterion("channel2 in", values, "channel2");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andChannel2NotIn(List<String> values) {
      addCriterion("channel2 not in", values, "channel2");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andChannel2Between(String value1, String value2) {
      addCriterion("channel2 between", value1, value2, "channel2");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andChannel2NotBetween(String value1, String value2) {
      addCriterion("channel2 not between", value1, value2, "channel2");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andMemberidIsNull() {
      addCriterion("memberid is null");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andMemberidIsNotNull() {
      addCriterion("memberid is not null");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andMemberidEqualTo(Long value) {
      addCriterion("memberid =", value, "memberid");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andMemberidNotEqualTo(Long value) {
      addCriterion("memberid <>", value, "memberid");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andMemberidGreaterThan(Long value) {
      addCriterion("memberid >", value, "memberid");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andMemberidGreaterThanOrEqualTo(Long value) {
      addCriterion("memberid >=", value, "memberid");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andMemberidLessThan(Long value) {
      addCriterion("memberid <", value, "memberid");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andMemberidLessThanOrEqualTo(Long value) {
      addCriterion("memberid <=", value, "memberid");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andMemberidIn(List<Long> values) {
      addCriterion("memberid in", values, "memberid");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andMemberidNotIn(List<Long> values) {
      addCriterion("memberid not in", values, "memberid");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andMemberidBetween(Long value1, Long value2) {
      addCriterion("memberid between", value1, value2, "memberid");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andMemberidNotBetween(Long value1, Long value2) {
      addCriterion("memberid not between", value1, value2, "memberid");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andBidcodeIsNull() {
      addCriterion("bidcode is null");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andBidcodeIsNotNull() {
      addCriterion("bidcode is not null");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andBidcodeEqualTo(String value) {
      addCriterion("bidcode =", value, "bidcode");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andBidcodeNotEqualTo(String value) {
      addCriterion("bidcode <>", value, "bidcode");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andBidcodeGreaterThan(String value) {
      addCriterion("bidcode >", value, "bidcode");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andBidcodeGreaterThanOrEqualTo(String value) {
      addCriterion("bidcode >=", value, "bidcode");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andBidcodeLessThan(String value) {
      addCriterion("bidcode <", value, "bidcode");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andBidcodeLessThanOrEqualTo(String value) {
      addCriterion("bidcode <=", value, "bidcode");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andBidcodeLike(String value) {
      addCriterion("bidcode like", value, "bidcode");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andBidcodeNotLike(String value) {
      addCriterion("bidcode not like", value, "bidcode");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andBidcodeIn(List<String> values) {
      addCriterion("bidcode in", values, "bidcode");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andBidcodeNotIn(List<String> values) {
      addCriterion("bidcode not in", values, "bidcode");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andBidcodeBetween(String value1, String value2) {
      addCriterion("bidcode between", value1, value2, "bidcode");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andBidcodeNotBetween(String value1, String value2) {
      addCriterion("bidcode not between", value1, value2, "bidcode");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andAmountIsNull() {
      addCriterion("amount is null");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andAmountIsNotNull() {
      addCriterion("amount is not null");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andAmountEqualTo(BigDecimal value) {
      addCriterion("amount =", value, "amount");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andAmountNotEqualTo(BigDecimal value) {
      addCriterion("amount <>", value, "amount");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andAmountGreaterThan(BigDecimal value) {
      addCriterion("amount >", value, "amount");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andAmountGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("amount >=", value, "amount");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andAmountLessThan(BigDecimal value) {
      addCriterion("amount <", value, "amount");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andAmountLessThanOrEqualTo(BigDecimal value) {
      addCriterion("amount <=", value, "amount");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andAmountIn(List<BigDecimal> values) {
      addCriterion("amount in", values, "amount");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andAmountNotIn(List<BigDecimal> values) {
      addCriterion("amount not in", values, "amount");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andAmountBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("amount between", value1, value2, "amount");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andAmountNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("amount not between", value1, value2, "amount");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andSettleamountIsNull() {
      addCriterion("settleamount is null");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andSettleamountIsNotNull() {
      addCriterion("settleamount is not null");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andSettleamountEqualTo(BigDecimal value) {
      addCriterion("settleamount =", value, "settleamount");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andSettleamountNotEqualTo(BigDecimal value) {
      addCriterion("settleamount <>", value, "settleamount");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andSettleamountGreaterThan(BigDecimal value) {
      addCriterion("settleamount >", value, "settleamount");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andSettleamountGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("settleamount >=", value, "settleamount");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andSettleamountLessThan(BigDecimal value) {
      addCriterion("settleamount <", value, "settleamount");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andSettleamountLessThanOrEqualTo(BigDecimal value) {
      addCriterion("settleamount <=", value, "settleamount");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andSettleamountIn(List<BigDecimal> values) {
      addCriterion("settleamount in", values, "settleamount");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andSettleamountNotIn(List<BigDecimal> values) {
      addCriterion("settleamount not in", values, "settleamount");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andSettleamountBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("settleamount between", value1, value2, "settleamount");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andSettleamountNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("settleamount not between", value1, value2, "settleamount");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andSettledateIsNull() {
      addCriterion("settledate is null");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andSettledateIsNotNull() {
      addCriterion("settledate is not null");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andSettledateEqualTo(Date value) {
      addCriterion("settledate =", value, "settledate");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andSettledateNotEqualTo(Date value) {
      addCriterion("settledate <>", value, "settledate");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andSettledateGreaterThan(Date value) {
      addCriterion("settledate >", value, "settledate");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andSettledateGreaterThanOrEqualTo(Date value) {
      addCriterion("settledate >=", value, "settledate");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andSettledateLessThan(Date value) {
      addCriterion("settledate <", value, "settledate");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andSettledateLessThanOrEqualTo(Date value) {
      addCriterion("settledate <=", value, "settledate");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andSettledateIn(List<Date> values) {
      addCriterion("settledate in", values, "settledate");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andSettledateNotIn(List<Date> values) {
      addCriterion("settledate not in", values, "settledate");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andSettledateBetween(Date value1, Date value2) {
      addCriterion("settledate between", value1, value2, "settledate");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andSettledateNotBetween(Date value1, Date value2) {
      addCriterion("settledate not between", value1, value2, "settledate");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andCommissionIsNull() {
      addCriterion("commission is null");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andCommissionIsNotNull() {
      addCriterion("commission is not null");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andCommissionEqualTo(BigDecimal value) {
      addCriterion("commission =", value, "commission");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andCommissionNotEqualTo(BigDecimal value) {
      addCriterion("commission <>", value, "commission");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andCommissionGreaterThan(BigDecimal value) {
      addCriterion("commission >", value, "commission");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andCommissionGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("commission >=", value, "commission");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andCommissionLessThan(BigDecimal value) {
      addCriterion("commission <", value, "commission");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andCommissionLessThanOrEqualTo(BigDecimal value) {
      addCriterion("commission <=", value, "commission");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andCommissionIn(List<BigDecimal> values) {
      addCriterion("commission in", values, "commission");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andCommissionNotIn(List<BigDecimal> values) {
      addCriterion("commission not in", values, "commission");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andCommissionBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("commission between", value1, value2, "commission");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andCommissionNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("commission not between", value1, value2, "commission");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andInvestordercodeIsNull() {
      addCriterion("investOrderCode is null");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andInvestordercodeIsNotNull() {
      addCriterion("investOrderCode is not null");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andInvestordercodeEqualTo(String value) {
      addCriterion("investOrderCode =", value, "investordercode");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andInvestordercodeNotEqualTo(String value) {
      addCriterion("investOrderCode <>", value, "investordercode");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andInvestordercodeGreaterThan(String value) {
      addCriterion("investOrderCode >", value, "investordercode");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andInvestordercodeGreaterThanOrEqualTo(String value) {
      addCriterion("investOrderCode >=", value, "investordercode");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andInvestordercodeLessThan(String value) {
      addCriterion("investOrderCode <", value, "investordercode");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andInvestordercodeLessThanOrEqualTo(String value) {
      addCriterion("investOrderCode <=", value, "investordercode");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andInvestordercodeLike(String value) {
      addCriterion("investOrderCode like", value, "investordercode");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andInvestordercodeNotLike(String value) {
      addCriterion("investOrderCode not like", value, "investordercode");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andInvestordercodeIn(List<String> values) {
      addCriterion("investOrderCode in", values, "investordercode");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andInvestordercodeNotIn(List<String> values) {
      addCriterion("investOrderCode not in", values, "investordercode");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andInvestordercodeBetween(String value1, String value2) {
      addCriterion("investOrderCode between", value1, value2, "investordercode");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andInvestordercodeNotBetween(String value1, String value2) {
      addCriterion("investOrderCode not between", value1, value2, "investordercode");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andSettlestatusIsNull() {
      addCriterion("settlestatus is null");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andSettlestatusIsNotNull() {
      addCriterion("settlestatus is not null");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andSettlestatusEqualTo(Integer value) {
      addCriterion("settlestatus =", value, "settlestatus");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andSettlestatusNotEqualTo(Integer value) {
      addCriterion("settlestatus <>", value, "settlestatus");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andSettlestatusGreaterThan(Integer value) {
      addCriterion("settlestatus >", value, "settlestatus");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andSettlestatusGreaterThanOrEqualTo(Integer value) {
      addCriterion("settlestatus >=", value, "settlestatus");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andSettlestatusLessThan(Integer value) {
      addCriterion("settlestatus <", value, "settlestatus");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andSettlestatusLessThanOrEqualTo(Integer value) {
      addCriterion("settlestatus <=", value, "settlestatus");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andSettlestatusIn(List<Integer> values) {
      addCriterion("settlestatus in", values, "settlestatus");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andSettlestatusNotIn(List<Integer> values) {
      addCriterion("settlestatus not in", values, "settlestatus");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andSettlestatusBetween(Integer value1, Integer value2) {
      addCriterion("settlestatus between", value1, value2, "settlestatus");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andSettlestatusNotBetween(Integer value1, Integer value2) {
      addCriterion("settlestatus not between", value1, value2, "settlestatus");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andRemarkIsNull() {
      addCriterion("remark is null");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andRemarkIsNotNull() {
      addCriterion("remark is not null");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andRemarkEqualTo(String value) {
      addCriterion("remark =", value, "remark");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andRemarkNotEqualTo(String value) {
      addCriterion("remark <>", value, "remark");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andRemarkGreaterThan(String value) {
      addCriterion("remark >", value, "remark");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andRemarkGreaterThanOrEqualTo(String value) {
      addCriterion("remark >=", value, "remark");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andRemarkLessThan(String value) {
      addCriterion("remark <", value, "remark");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andRemarkLessThanOrEqualTo(String value) {
      addCriterion("remark <=", value, "remark");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andRemarkLike(String value) {
      addCriterion("remark like", value, "remark");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andRemarkNotLike(String value) {
      addCriterion("remark not like", value, "remark");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andRemarkIn(List<String> values) {
      addCriterion("remark in", values, "remark");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andRemarkNotIn(List<String> values) {
      addCriterion("remark not in", values, "remark");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andRemarkBetween(String value1, String value2) {
      addCriterion("remark between", value1, value2, "remark");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andRemarkNotBetween(String value1, String value2) {
      addCriterion("remark not between", value1, value2, "remark");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andOpdateIsNull() {
      addCriterion("opdate is null");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andOpdateIsNotNull() {
      addCriterion("opdate is not null");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andOpdateEqualTo(Date value) {
      addCriterion("opdate =", value, "opdate");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andOpdateNotEqualTo(Date value) {
      addCriterion("opdate <>", value, "opdate");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andOpdateGreaterThan(Date value) {
      addCriterion("opdate >", value, "opdate");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andOpdateGreaterThanOrEqualTo(Date value) {
      addCriterion("opdate >=", value, "opdate");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andOpdateLessThan(Date value) {
      addCriterion("opdate <", value, "opdate");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andOpdateLessThanOrEqualTo(Date value) {
      addCriterion("opdate <=", value, "opdate");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andOpdateIn(List<Date> values) {
      addCriterion("opdate in", values, "opdate");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andOpdateNotIn(List<Date> values) {
      addCriterion("opdate not in", values, "opdate");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andOpdateBetween(Date value1, Date value2) {
      addCriterion("opdate between", value1, value2, "opdate");
      return ((CpssettlelogExample.Criteria)this);
    }

    public CpssettlelogExample.Criteria andOpdateNotBetween(Date value1, Date value2) {
      addCriterion("opdate not between", value1, value2, "opdate");
      return ((CpssettlelogExample.Criteria)this);
    }
  }
}