package com.zjgt.p2p.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CpsInvestinfoExample
{
  protected String orderByClause;
  protected boolean distinct;
  protected List<Criteria> oredCriteria;

  public CpsInvestinfoExample()
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

  public static class Criteria extends CpsInvestinfoExample.GeneratedCriteria
  {
  }

  protected static abstract class GeneratedCriteria
  {
    protected List<CpsInvestinfoExample.Criterion> criteria;

    protected GeneratedCriteria()
    {
      this.criteria = new ArrayList();
    }

    public boolean isValid() {
      return (this.criteria.size() > 0);
    }

    public List<CpsInvestinfoExample.Criterion> getAllCriteria() {
      return this.criteria;
    }

    public List<CpsInvestinfoExample.Criterion> getCriteria() {
      return this.criteria;
    }

    protected void addCriterion(String condition) {
      if (condition == null) {
        throw new RuntimeException("Value for condition cannot be null");
      }
      this.criteria.add(new CpsInvestinfoExample.Criterion(condition));
    }

    protected void addCriterion(String condition, Object value, String property) {
      if (value == null) {
        throw new RuntimeException("Value for " + property + " cannot be null");
      }
      this.criteria.add(new CpsInvestinfoExample.Criterion(condition, value));
    }

    protected void addCriterion(String condition, Object value1, Object value2, String property) {
      if ((value1 == null) || (value2 == null)) {
        throw new RuntimeException("Between values for " + property + " cannot be null");
      }
      this.criteria.add(new CpsInvestinfoExample.Criterion(condition, value1, value2));
    }

    public CpsInvestinfoExample.Criteria andIdIsNull() {
      addCriterion("id is null");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andIdIsNotNull() {
      addCriterion("id is not null");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andIdEqualTo(Long value) {
      addCriterion("id =", value, "id");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andIdNotEqualTo(Long value) {
      addCriterion("id <>", value, "id");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andIdGreaterThan(Long value) {
      addCriterion("id >", value, "id");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andIdGreaterThanOrEqualTo(Long value) {
      addCriterion("id >=", value, "id");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andIdLessThan(Long value) {
      addCriterion("id <", value, "id");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andIdLessThanOrEqualTo(Long value) {
      addCriterion("id <=", value, "id");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andIdIn(List<Long> values) {
      addCriterion("id in", values, "id");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andIdNotIn(List<Long> values) {
      addCriterion("id not in", values, "id");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andIdBetween(Long value1, Long value2) {
      addCriterion("id between", value1, value2, "id");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andIdNotBetween(Long value1, Long value2) {
      addCriterion("id not between", value1, value2, "id");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andChannelIsNull() {
      addCriterion("channel is null");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andChannelIsNotNull() {
      addCriterion("channel is not null");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andChannelEqualTo(String value) {
      addCriterion("channel =", value, "channel");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andChannelNotEqualTo(String value) {
      addCriterion("channel <>", value, "channel");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andChannelGreaterThan(String value) {
      addCriterion("channel >", value, "channel");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andChannelGreaterThanOrEqualTo(String value) {
      addCriterion("channel >=", value, "channel");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andChannelLessThan(String value) {
      addCriterion("channel <", value, "channel");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andChannelLessThanOrEqualTo(String value) {
      addCriterion("channel <=", value, "channel");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andChannelLike(String value) {
      addCriterion("channel like", value, "channel");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andChannelNotLike(String value) {
      addCriterion("channel not like", value, "channel");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andChannelIn(List<String> values) {
      addCriterion("channel in", values, "channel");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andChannelNotIn(List<String> values) {
      addCriterion("channel not in", values, "channel");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andChannelBetween(String value1, String value2) {
      addCriterion("channel between", value1, value2, "channel");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andChannelNotBetween(String value1, String value2) {
      addCriterion("channel not between", value1, value2, "channel");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andChannel2IsNull() {
      addCriterion("channel2 is null");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andChannel2IsNotNull() {
      addCriterion("channel2 is not null");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andChannel2EqualTo(String value) {
      addCriterion("channel2 =", value, "channel2");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andChannel2NotEqualTo(String value) {
      addCriterion("channel2 <>", value, "channel2");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andChannel2GreaterThan(String value) {
      addCriterion("channel2 >", value, "channel2");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andChannel2GreaterThanOrEqualTo(String value) {
      addCriterion("channel2 >=", value, "channel2");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andChannel2LessThan(String value) {
      addCriterion("channel2 <", value, "channel2");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andChannel2LessThanOrEqualTo(String value) {
      addCriterion("channel2 <=", value, "channel2");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andChannel2Like(String value) {
      addCriterion("channel2 like", value, "channel2");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andChannel2NotLike(String value) {
      addCriterion("channel2 not like", value, "channel2");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andChannel2In(List<String> values) {
      addCriterion("channel2 in", values, "channel2");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andChannel2NotIn(List<String> values) {
      addCriterion("channel2 not in", values, "channel2");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andChannel2Between(String value1, String value2) {
      addCriterion("channel2 between", value1, value2, "channel2");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andChannel2NotBetween(String value1, String value2) {
      addCriterion("channel2 not between", value1, value2, "channel2");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andSessionidIsNull() {
      addCriterion("sessionid is null");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andSessionidIsNotNull() {
      addCriterion("sessionid is not null");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andSessionidEqualTo(String value) {
      addCriterion("sessionid =", value, "sessionid");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andSessionidNotEqualTo(String value) {
      addCriterion("sessionid <>", value, "sessionid");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andSessionidGreaterThan(String value) {
      addCriterion("sessionid >", value, "sessionid");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andSessionidGreaterThanOrEqualTo(String value) {
      addCriterion("sessionid >=", value, "sessionid");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andSessionidLessThan(String value) {
      addCriterion("sessionid <", value, "sessionid");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andSessionidLessThanOrEqualTo(String value) {
      addCriterion("sessionid <=", value, "sessionid");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andSessionidLike(String value) {
      addCriterion("sessionid like", value, "sessionid");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andSessionidNotLike(String value) {
      addCriterion("sessionid not like", value, "sessionid");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andSessionidIn(List<String> values) {
      addCriterion("sessionid in", values, "sessionid");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andSessionidNotIn(List<String> values) {
      addCriterion("sessionid not in", values, "sessionid");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andSessionidBetween(String value1, String value2) {
      addCriterion("sessionid between", value1, value2, "sessionid");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andSessionidNotBetween(String value1, String value2) {
      addCriterion("sessionid not between", value1, value2, "sessionid");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andMemberidIsNull() {
      addCriterion("memberid is null");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andMemberidIsNotNull() {
      addCriterion("memberid is not null");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andMemberidEqualTo(Long value) {
      addCriterion("memberid =", value, "memberid");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andMemberidNotEqualTo(Long value) {
      addCriterion("memberid <>", value, "memberid");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andMemberidGreaterThan(Long value) {
      addCriterion("memberid >", value, "memberid");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andMemberidGreaterThanOrEqualTo(Long value) {
      addCriterion("memberid >=", value, "memberid");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andMemberidLessThan(Long value) {
      addCriterion("memberid <", value, "memberid");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andMemberidLessThanOrEqualTo(Long value) {
      addCriterion("memberid <=", value, "memberid");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andMemberidIn(List<Long> values) {
      addCriterion("memberid in", values, "memberid");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andMemberidNotIn(List<Long> values) {
      addCriterion("memberid not in", values, "memberid");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andMemberidBetween(Long value1, Long value2) {
      addCriterion("memberid between", value1, value2, "memberid");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andMemberidNotBetween(Long value1, Long value2) {
      addCriterion("memberid not between", value1, value2, "memberid");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andBidcodeIsNull() {
      addCriterion("bidcode is null");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andBidcodeIsNotNull() {
      addCriterion("bidcode is not null");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andBidcodeEqualTo(String value) {
      addCriterion("bidcode =", value, "bidcode");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andBidcodeNotEqualTo(String value) {
      addCriterion("bidcode <>", value, "bidcode");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andBidcodeGreaterThan(String value) {
      addCriterion("bidcode >", value, "bidcode");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andBidcodeGreaterThanOrEqualTo(String value) {
      addCriterion("bidcode >=", value, "bidcode");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andBidcodeLessThan(String value) {
      addCriterion("bidcode <", value, "bidcode");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andBidcodeLessThanOrEqualTo(String value) {
      addCriterion("bidcode <=", value, "bidcode");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andBidcodeLike(String value) {
      addCriterion("bidcode like", value, "bidcode");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andBidcodeNotLike(String value) {
      addCriterion("bidcode not like", value, "bidcode");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andBidcodeIn(List<String> values) {
      addCriterion("bidcode in", values, "bidcode");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andBidcodeNotIn(List<String> values) {
      addCriterion("bidcode not in", values, "bidcode");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andBidcodeBetween(String value1, String value2) {
      addCriterion("bidcode between", value1, value2, "bidcode");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andBidcodeNotBetween(String value1, String value2) {
      addCriterion("bidcode not between", value1, value2, "bidcode");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andAmountIsNull() {
      addCriterion("amount is null");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andAmountIsNotNull() {
      addCriterion("amount is not null");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andAmountEqualTo(BigDecimal value) {
      addCriterion("amount =", value, "amount");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andAmountNotEqualTo(BigDecimal value) {
      addCriterion("amount <>", value, "amount");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andAmountGreaterThan(BigDecimal value) {
      addCriterion("amount >", value, "amount");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andAmountGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("amount >=", value, "amount");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andAmountLessThan(BigDecimal value) {
      addCriterion("amount <", value, "amount");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andAmountLessThanOrEqualTo(BigDecimal value) {
      addCriterion("amount <=", value, "amount");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andAmountIn(List<BigDecimal> values) {
      addCriterion("amount in", values, "amount");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andAmountNotIn(List<BigDecimal> values) {
      addCriterion("amount not in", values, "amount");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andAmountBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("amount between", value1, value2, "amount");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andAmountNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("amount not between", value1, value2, "amount");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andSettleamountIsNull() {
      addCriterion("settleamount is null");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andSettleamountIsNotNull() {
      addCriterion("settleamount is not null");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andSettleamountEqualTo(BigDecimal value) {
      addCriterion("settleamount =", value, "settleamount");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andSettleamountNotEqualTo(BigDecimal value) {
      addCriterion("settleamount <>", value, "settleamount");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andSettleamountGreaterThan(BigDecimal value) {
      addCriterion("settleamount >", value, "settleamount");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andSettleamountGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("settleamount >=", value, "settleamount");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andSettleamountLessThan(BigDecimal value) {
      addCriterion("settleamount <", value, "settleamount");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andSettleamountLessThanOrEqualTo(BigDecimal value) {
      addCriterion("settleamount <=", value, "settleamount");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andSettleamountIn(List<BigDecimal> values) {
      addCriterion("settleamount in", values, "settleamount");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andSettleamountNotIn(List<BigDecimal> values) {
      addCriterion("settleamount not in", values, "settleamount");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andSettleamountBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("settleamount between", value1, value2, "settleamount");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andSettleamountNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("settleamount not between", value1, value2, "settleamount");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andCommissionIsNull() {
      addCriterion("commission is null");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andCommissionIsNotNull() {
      addCriterion("commission is not null");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andCommissionEqualTo(Long value) {
      addCriterion("commission =", value, "commission");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andCommissionNotEqualTo(Long value) {
      addCriterion("commission <>", value, "commission");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andCommissionGreaterThan(Long value) {
      addCriterion("commission >", value, "commission");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andCommissionGreaterThanOrEqualTo(Long value) {
      addCriterion("commission >=", value, "commission");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andCommissionLessThan(Long value) {
      addCriterion("commission <", value, "commission");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andCommissionLessThanOrEqualTo(Long value) {
      addCriterion("commission <=", value, "commission");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andCommissionIn(List<Long> values) {
      addCriterion("commission in", values, "commission");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andCommissionNotIn(List<Long> values) {
      addCriterion("commission not in", values, "commission");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andCommissionBetween(Long value1, Long value2) {
      addCriterion("commission between", value1, value2, "commission");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andCommissionNotBetween(Long value1, Long value2) {
      addCriterion("commission not between", value1, value2, "commission");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andOrdernoIsNull() {
      addCriterion("orderno is null");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andOrdernoIsNotNull() {
      addCriterion("orderno is not null");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andOrdernoEqualTo(String value) {
      addCriterion("orderno =", value, "orderno");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andOrdernoNotEqualTo(String value) {
      addCriterion("orderno <>", value, "orderno");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andOrdernoGreaterThan(String value) {
      addCriterion("orderno >", value, "orderno");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andOrdernoGreaterThanOrEqualTo(String value) {
      addCriterion("orderno >=", value, "orderno");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andOrdernoLessThan(String value) {
      addCriterion("orderno <", value, "orderno");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andOrdernoLessThanOrEqualTo(String value) {
      addCriterion("orderno <=", value, "orderno");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andOrdernoLike(String value) {
      addCriterion("orderno like", value, "orderno");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andOrdernoNotLike(String value) {
      addCriterion("orderno not like", value, "orderno");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andOrdernoIn(List<String> values) {
      addCriterion("orderno in", values, "orderno");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andOrdernoNotIn(List<String> values) {
      addCriterion("orderno not in", values, "orderno");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andOrdernoBetween(String value1, String value2) {
      addCriterion("orderno between", value1, value2, "orderno");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andOrdernoNotBetween(String value1, String value2) {
      addCriterion("orderno not between", value1, value2, "orderno");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andOrderdateIsNull() {
      addCriterion("orderdate is null");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andOrderdateIsNotNull() {
      addCriterion("orderdate is not null");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andOrderdateEqualTo(Date value) {
      addCriterion("orderdate =", value, "orderdate");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andOrderdateNotEqualTo(Date value) {
      addCriterion("orderdate <>", value, "orderdate");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andOrderdateGreaterThan(Date value) {
      addCriterion("orderdate >", value, "orderdate");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andOrderdateGreaterThanOrEqualTo(Date value) {
      addCriterion("orderdate >=", value, "orderdate");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andOrderdateLessThan(Date value) {
      addCriterion("orderdate <", value, "orderdate");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andOrderdateLessThanOrEqualTo(Date value) {
      addCriterion("orderdate <=", value, "orderdate");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andOrderdateIn(List<Date> values) {
      addCriterion("orderdate in", values, "orderdate");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andOrderdateNotIn(List<Date> values) {
      addCriterion("orderdate not in", values, "orderdate");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andOrderdateBetween(Date value1, Date value2) {
      addCriterion("orderdate between", value1, value2, "orderdate");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andOrderdateNotBetween(Date value1, Date value2) {
      addCriterion("orderdate not between", value1, value2, "orderdate");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andLastsettledateIsNull() {
      addCriterion("lastsettledate is null");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andLastsettledateIsNotNull() {
      addCriterion("lastsettledate is not null");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andLastsettledateEqualTo(Date value) {
      addCriterion("lastsettledate =", value, "lastsettledate");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andLastsettledateNotEqualTo(Date value) {
      addCriterion("lastsettledate <>", value, "lastsettledate");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andLastsettledateGreaterThan(Date value) {
      addCriterion("lastsettledate >", value, "lastsettledate");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andLastsettledateGreaterThanOrEqualTo(Date value) {
      addCriterion("lastsettledate >=", value, "lastsettledate");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andLastsettledateLessThan(Date value) {
      addCriterion("lastsettledate <", value, "lastsettledate");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andLastsettledateLessThanOrEqualTo(Date value) {
      addCriterion("lastsettledate <=", value, "lastsettledate");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andLastsettledateIn(List<Date> values) {
      addCriterion("lastsettledate in", values, "lastsettledate");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andLastsettledateNotIn(List<Date> values) {
      addCriterion("lastsettledate not in", values, "lastsettledate");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andLastsettledateBetween(Date value1, Date value2) {
      addCriterion("lastsettledate between", value1, value2, "lastsettledate");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andLastsettledateNotBetween(Date value1, Date value2) {
      addCriterion("lastsettledate not between", value1, value2, "lastsettledate");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andProfitstatusIsNull() {
      addCriterion("profitstatus is null");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andProfitstatusIsNotNull() {
      addCriterion("profitstatus is not null");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andProfitstatusEqualTo(Integer value) {
      addCriterion("profitstatus =", value, "profitstatus");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andProfitstatusNotEqualTo(Integer value) {
      addCriterion("profitstatus <>", value, "profitstatus");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andProfitstatusGreaterThan(Integer value) {
      addCriterion("profitstatus >", value, "profitstatus");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andProfitstatusGreaterThanOrEqualTo(Integer value) {
      addCriterion("profitstatus >=", value, "profitstatus");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andProfitstatusLessThan(Integer value) {
      addCriterion("profitstatus <", value, "profitstatus");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andProfitstatusLessThanOrEqualTo(Integer value) {
      addCriterion("profitstatus <=", value, "profitstatus");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andProfitstatusIn(List<Integer> values) {
      addCriterion("profitstatus in", values, "profitstatus");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andProfitstatusNotIn(List<Integer> values) {
      addCriterion("profitstatus not in", values, "profitstatus");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andProfitstatusBetween(Integer value1, Integer value2) {
      addCriterion("profitstatus between", value1, value2, "profitstatus");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andProfitstatusNotBetween(Integer value1, Integer value2) {
      addCriterion("profitstatus not between", value1, value2, "profitstatus");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andRemarkIsNull() {
      addCriterion("remark is null");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andRemarkIsNotNull() {
      addCriterion("remark is not null");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andRemarkEqualTo(String value) {
      addCriterion("remark =", value, "remark");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andRemarkNotEqualTo(String value) {
      addCriterion("remark <>", value, "remark");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andRemarkGreaterThan(String value) {
      addCriterion("remark >", value, "remark");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andRemarkGreaterThanOrEqualTo(String value) {
      addCriterion("remark >=", value, "remark");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andRemarkLessThan(String value) {
      addCriterion("remark <", value, "remark");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andRemarkLessThanOrEqualTo(String value) {
      addCriterion("remark <=", value, "remark");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andRemarkLike(String value) {
      addCriterion("remark like", value, "remark");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andRemarkNotLike(String value) {
      addCriterion("remark not like", value, "remark");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andRemarkIn(List<String> values) {
      addCriterion("remark in", values, "remark");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andRemarkNotIn(List<String> values) {
      addCriterion("remark not in", values, "remark");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andRemarkBetween(String value1, String value2) {
      addCriterion("remark between", value1, value2, "remark");
      return ((CpsInvestinfoExample.Criteria)this);
    }

    public CpsInvestinfoExample.Criteria andRemarkNotBetween(String value1, String value2) {
      addCriterion("remark not between", value1, value2, "remark");
      return ((CpsInvestinfoExample.Criteria)this);
    }
  }
}