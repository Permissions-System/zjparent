package com.zjgt.p2p.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CpsrecExample
{
  protected String orderByClause;
  protected boolean distinct;
  protected List<Criteria> oredCriteria;

  public CpsrecExample()
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

  public static class Criteria extends CpsrecExample.GeneratedCriteria
  {
  }

  protected static abstract class GeneratedCriteria
  {
    protected List<CpsrecExample.Criterion> criteria;

    protected GeneratedCriteria()
    {
      this.criteria = new ArrayList();
    }

    public boolean isValid() {
      return (this.criteria.size() > 0);
    }

    public List<CpsrecExample.Criterion> getAllCriteria() {
      return this.criteria;
    }

    public List<CpsrecExample.Criterion> getCriteria() {
      return this.criteria;
    }

    protected void addCriterion(String condition) {
      if (condition == null) {
        throw new RuntimeException("Value for condition cannot be null");
      }
      this.criteria.add(new CpsrecExample.Criterion(condition));
    }

    protected void addCriterion(String condition, Object value, String property) {
      if (value == null) {
        throw new RuntimeException("Value for " + property + " cannot be null");
      }
      this.criteria.add(new CpsrecExample.Criterion(condition, value));
    }

    protected void addCriterion(String condition, Object value1, Object value2, String property) {
      if ((value1 == null) || (value2 == null)) {
        throw new RuntimeException("Between values for " + property + " cannot be null");
      }
      this.criteria.add(new CpsrecExample.Criterion(condition, value1, value2));
    }

    public CpsrecExample.Criteria andIdIsNull() {
      addCriterion("id is null");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andIdIsNotNull() {
      addCriterion("id is not null");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andIdEqualTo(Long value) {
      addCriterion("id =", value, "id");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andIdNotEqualTo(Long value) {
      addCriterion("id <>", value, "id");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andIdGreaterThan(Long value) {
      addCriterion("id >", value, "id");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andIdGreaterThanOrEqualTo(Long value) {
      addCriterion("id >=", value, "id");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andIdLessThan(Long value) {
      addCriterion("id <", value, "id");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andIdLessThanOrEqualTo(Long value) {
      addCriterion("id <=", value, "id");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andIdIn(List<Long> values) {
      addCriterion("id in", values, "id");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andIdNotIn(List<Long> values) {
      addCriterion("id not in", values, "id");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andIdBetween(Long value1, Long value2) {
      addCriterion("id between", value1, value2, "id");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andIdNotBetween(Long value1, Long value2) {
      addCriterion("id not between", value1, value2, "id");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andPagenameIsNull() {
      addCriterion("pagename is null");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andPagenameIsNotNull() {
      addCriterion("pagename is not null");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andPagenameEqualTo(String value) {
      addCriterion("pagename =", value, "pagename");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andPagenameNotEqualTo(String value) {
      addCriterion("pagename <>", value, "pagename");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andPagenameGreaterThan(String value) {
      addCriterion("pagename >", value, "pagename");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andPagenameGreaterThanOrEqualTo(String value) {
      addCriterion("pagename >=", value, "pagename");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andPagenameLessThan(String value) {
      addCriterion("pagename <", value, "pagename");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andPagenameLessThanOrEqualTo(String value) {
      addCriterion("pagename <=", value, "pagename");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andPagenameLike(String value) {
      addCriterion("pagename like", value, "pagename");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andPagenameNotLike(String value) {
      addCriterion("pagename not like", value, "pagename");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andPagenameIn(List<String> values) {
      addCriterion("pagename in", values, "pagename");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andPagenameNotIn(List<String> values) {
      addCriterion("pagename not in", values, "pagename");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andPagenameBetween(String value1, String value2) {
      addCriterion("pagename between", value1, value2, "pagename");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andPagenameNotBetween(String value1, String value2) {
      addCriterion("pagename not between", value1, value2, "pagename");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andUrlIsNull() {
      addCriterion("url is null");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andUrlIsNotNull() {
      addCriterion("url is not null");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andUrlEqualTo(String value) {
      addCriterion("url =", value, "url");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andUrlNotEqualTo(String value) {
      addCriterion("url <>", value, "url");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andUrlGreaterThan(String value) {
      addCriterion("url >", value, "url");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andUrlGreaterThanOrEqualTo(String value) {
      addCriterion("url >=", value, "url");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andUrlLessThan(String value) {
      addCriterion("url <", value, "url");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andUrlLessThanOrEqualTo(String value) {
      addCriterion("url <=", value, "url");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andUrlLike(String value) {
      addCriterion("url like", value, "url");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andUrlNotLike(String value) {
      addCriterion("url not like", value, "url");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andUrlIn(List<String> values) {
      addCriterion("url in", values, "url");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andUrlNotIn(List<String> values) {
      addCriterion("url not in", values, "url");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andUrlBetween(String value1, String value2) {
      addCriterion("url between", value1, value2, "url");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andUrlNotBetween(String value1, String value2) {
      addCriterion("url not between", value1, value2, "url");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andChannelIsNull() {
      addCriterion("channel is null");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andChannelIsNotNull() {
      addCriterion("channel is not null");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andChannelEqualTo(String value) {
      addCriterion("channel =", value, "channel");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andChannelNotEqualTo(String value) {
      addCriterion("channel <>", value, "channel");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andChannelGreaterThan(String value) {
      addCriterion("channel >", value, "channel");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andChannelGreaterThanOrEqualTo(String value) {
      addCriterion("channel >=", value, "channel");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andChannelLessThan(String value) {
      addCriterion("channel <", value, "channel");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andChannelLessThanOrEqualTo(String value) {
      addCriterion("channel <=", value, "channel");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andChannelLike(String value) {
      addCriterion("channel like", value, "channel");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andChannelNotLike(String value) {
      addCriterion("channel not like", value, "channel");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andChannelIn(List<String> values) {
      addCriterion("channel in", values, "channel");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andChannelNotIn(List<String> values) {
      addCriterion("channel not in", values, "channel");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andChannelBetween(String value1, String value2) {
      addCriterion("channel between", value1, value2, "channel");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andChannelNotBetween(String value1, String value2) {
      addCriterion("channel not between", value1, value2, "channel");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andChannel2IsNull() {
      addCriterion("channel2 is null");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andChannel2IsNotNull() {
      addCriterion("channel2 is not null");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andChannel2EqualTo(String value) {
      addCriterion("channel2 =", value, "channel2");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andChannel2NotEqualTo(String value) {
      addCriterion("channel2 <>", value, "channel2");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andChannel2GreaterThan(String value) {
      addCriterion("channel2 >", value, "channel2");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andChannel2GreaterThanOrEqualTo(String value) {
      addCriterion("channel2 >=", value, "channel2");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andChannel2LessThan(String value) {
      addCriterion("channel2 <", value, "channel2");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andChannel2LessThanOrEqualTo(String value) {
      addCriterion("channel2 <=", value, "channel2");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andChannel2Like(String value) {
      addCriterion("channel2 like", value, "channel2");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andChannel2NotLike(String value) {
      addCriterion("channel2 not like", value, "channel2");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andChannel2In(List<String> values) {
      addCriterion("channel2 in", values, "channel2");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andChannel2NotIn(List<String> values) {
      addCriterion("channel2 not in", values, "channel2");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andChannel2Between(String value1, String value2) {
      addCriterion("channel2 between", value1, value2, "channel2");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andChannel2NotBetween(String value1, String value2) {
      addCriterion("channel2 not between", value1, value2, "channel2");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andSessionidIsNull() {
      addCriterion("sessionid is null");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andSessionidIsNotNull() {
      addCriterion("sessionid is not null");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andSessionidEqualTo(String value) {
      addCriterion("sessionid =", value, "sessionid");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andSessionidNotEqualTo(String value) {
      addCriterion("sessionid <>", value, "sessionid");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andSessionidGreaterThan(String value) {
      addCriterion("sessionid >", value, "sessionid");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andSessionidGreaterThanOrEqualTo(String value) {
      addCriterion("sessionid >=", value, "sessionid");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andSessionidLessThan(String value) {
      addCriterion("sessionid <", value, "sessionid");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andSessionidLessThanOrEqualTo(String value) {
      addCriterion("sessionid <=", value, "sessionid");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andSessionidLike(String value) {
      addCriterion("sessionid like", value, "sessionid");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andSessionidNotLike(String value) {
      addCriterion("sessionid not like", value, "sessionid");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andSessionidIn(List<String> values) {
      addCriterion("sessionid in", values, "sessionid");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andSessionidNotIn(List<String> values) {
      addCriterion("sessionid not in", values, "sessionid");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andSessionidBetween(String value1, String value2) {
      addCriterion("sessionid between", value1, value2, "sessionid");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andSessionidNotBetween(String value1, String value2) {
      addCriterion("sessionid not between", value1, value2, "sessionid");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andMemberidIsNull() {
      addCriterion("memberid is null");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andMemberidIsNotNull() {
      addCriterion("memberid is not null");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andMemberidEqualTo(Long value) {
      addCriterion("memberid =", value, "memberid");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andMemberidNotEqualTo(Long value) {
      addCriterion("memberid <>", value, "memberid");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andMemberidGreaterThan(Long value) {
      addCriterion("memberid >", value, "memberid");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andMemberidGreaterThanOrEqualTo(Long value) {
      addCriterion("memberid >=", value, "memberid");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andMemberidLessThan(Long value) {
      addCriterion("memberid <", value, "memberid");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andMemberidLessThanOrEqualTo(Long value) {
      addCriterion("memberid <=", value, "memberid");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andMemberidIn(List<Long> values) {
      addCriterion("memberid in", values, "memberid");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andMemberidNotIn(List<Long> values) {
      addCriterion("memberid not in", values, "memberid");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andMemberidBetween(Long value1, Long value2) {
      addCriterion("memberid between", value1, value2, "memberid");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andMemberidNotBetween(Long value1, Long value2) {
      addCriterion("memberid not between", value1, value2, "memberid");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andUserdistrictIsNull() {
      addCriterion("userdistrict is null");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andUserdistrictIsNotNull() {
      addCriterion("userdistrict is not null");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andUserdistrictEqualTo(String value) {
      addCriterion("userdistrict =", value, "userdistrict");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andUserdistrictNotEqualTo(String value) {
      addCriterion("userdistrict <>", value, "userdistrict");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andUserdistrictGreaterThan(String value) {
      addCriterion("userdistrict >", value, "userdistrict");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andUserdistrictGreaterThanOrEqualTo(String value) {
      addCriterion("userdistrict >=", value, "userdistrict");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andUserdistrictLessThan(String value) {
      addCriterion("userdistrict <", value, "userdistrict");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andUserdistrictLessThanOrEqualTo(String value) {
      addCriterion("userdistrict <=", value, "userdistrict");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andUserdistrictLike(String value) {
      addCriterion("userdistrict like", value, "userdistrict");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andUserdistrictNotLike(String value) {
      addCriterion("userdistrict not like", value, "userdistrict");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andUserdistrictIn(List<String> values) {
      addCriterion("userdistrict in", values, "userdistrict");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andUserdistrictNotIn(List<String> values) {
      addCriterion("userdistrict not in", values, "userdistrict");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andUserdistrictBetween(String value1, String value2) {
      addCriterion("userdistrict between", value1, value2, "userdistrict");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andUserdistrictNotBetween(String value1, String value2) {
      addCriterion("userdistrict not between", value1, value2, "userdistrict");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andOperationIsNull() {
      addCriterion("operation is null");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andOperationIsNotNull() {
      addCriterion("operation is not null");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andOperationEqualTo(String value) {
      addCriterion("operation =", value, "operation");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andOperationNotEqualTo(String value) {
      addCriterion("operation <>", value, "operation");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andOperationGreaterThan(String value) {
      addCriterion("operation >", value, "operation");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andOperationGreaterThanOrEqualTo(String value) {
      addCriterion("operation >=", value, "operation");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andOperationLessThan(String value) {
      addCriterion("operation <", value, "operation");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andOperationLessThanOrEqualTo(String value) {
      addCriterion("operation <=", value, "operation");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andOperationLike(String value) {
      addCriterion("operation like", value, "operation");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andOperationNotLike(String value) {
      addCriterion("operation not like", value, "operation");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andOperationIn(List<String> values) {
      addCriterion("operation in", values, "operation");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andOperationNotIn(List<String> values) {
      addCriterion("operation not in", values, "operation");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andOperationBetween(String value1, String value2) {
      addCriterion("operation between", value1, value2, "operation");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andOperationNotBetween(String value1, String value2) {
      addCriterion("operation not between", value1, value2, "operation");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andOpdateIsNull() {
      addCriterion("opdate is null");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andOpdateIsNotNull() {
      addCriterion("opdate is not null");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andOpdateEqualTo(Date value) {
      addCriterion("opdate =", value, "opdate");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andOpdateNotEqualTo(Date value) {
      addCriterion("opdate <>", value, "opdate");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andOpdateGreaterThan(Date value) {
      addCriterion("opdate >", value, "opdate");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andOpdateGreaterThanOrEqualTo(Date value) {
      addCriterion("opdate >=", value, "opdate");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andOpdateLessThan(Date value) {
      addCriterion("opdate <", value, "opdate");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andOpdateLessThanOrEqualTo(Date value) {
      addCriterion("opdate <=", value, "opdate");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andOpdateIn(List<Date> values) {
      addCriterion("opdate in", values, "opdate");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andOpdateNotIn(List<Date> values) {
      addCriterion("opdate not in", values, "opdate");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andOpdateBetween(Date value1, Date value2) {
      addCriterion("opdate between", value1, value2, "opdate");
      return ((CpsrecExample.Criteria)this);
    }

    public CpsrecExample.Criteria andOpdateNotBetween(Date value1, Date value2) {
      addCriterion("opdate not between", value1, value2, "opdate");
      return ((CpsrecExample.Criteria)this);
    }
  }
}