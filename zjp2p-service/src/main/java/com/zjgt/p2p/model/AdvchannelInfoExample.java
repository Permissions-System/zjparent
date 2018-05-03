package com.zjgt.p2p.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdvchannelInfoExample
{
  protected String orderByClause;
  protected boolean distinct;
  protected List<Criteria> oredCriteria;

  public AdvchannelInfoExample()
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

  public static class Criteria extends AdvchannelInfoExample.GeneratedCriteria
  {
  }

  protected static abstract class GeneratedCriteria
  {
    protected List<AdvchannelInfoExample.Criterion> criteria;

    protected GeneratedCriteria()
    {
      this.criteria = new ArrayList();
    }

    public boolean isValid() {
      return (this.criteria.size() > 0);
    }

    public List<AdvchannelInfoExample.Criterion> getAllCriteria() {
      return this.criteria;
    }

    public List<AdvchannelInfoExample.Criterion> getCriteria() {
      return this.criteria;
    }

    protected void addCriterion(String condition) {
      if (condition == null) {
        throw new RuntimeException("Value for condition cannot be null");
      }
      this.criteria.add(new AdvchannelInfoExample.Criterion(condition));
    }

    protected void addCriterion(String condition, Object value, String property) {
      if (value == null) {
        throw new RuntimeException("Value for " + property + " cannot be null");
      }
      this.criteria.add(new AdvchannelInfoExample.Criterion(condition, value));
    }

    protected void addCriterion(String condition, Object value1, Object value2, String property) {
      if ((value1 == null) || (value2 == null)) {
        throw new RuntimeException("Between values for " + property + " cannot be null");
      }
      this.criteria.add(new AdvchannelInfoExample.Criterion(condition, value1, value2));
    }

    public AdvchannelInfoExample.Criteria andIdIsNull() {
      addCriterion("id is null");
      return ((AdvchannelInfoExample.Criteria)this);
    }

    public AdvchannelInfoExample.Criteria andIdIsNotNull() {
      addCriterion("id is not null");
      return ((AdvchannelInfoExample.Criteria)this);
    }

    public AdvchannelInfoExample.Criteria andIdEqualTo(Integer value) {
      addCriterion("id =", value, "id");
      return ((AdvchannelInfoExample.Criteria)this);
    }

    public AdvchannelInfoExample.Criteria andIdNotEqualTo(Integer value) {
      addCriterion("id <>", value, "id");
      return ((AdvchannelInfoExample.Criteria)this);
    }

    public AdvchannelInfoExample.Criteria andIdGreaterThan(Integer value) {
      addCriterion("id >", value, "id");
      return ((AdvchannelInfoExample.Criteria)this);
    }

    public AdvchannelInfoExample.Criteria andIdGreaterThanOrEqualTo(Integer value) {
      addCriterion("id >=", value, "id");
      return ((AdvchannelInfoExample.Criteria)this);
    }

    public AdvchannelInfoExample.Criteria andIdLessThan(Integer value) {
      addCriterion("id <", value, "id");
      return ((AdvchannelInfoExample.Criteria)this);
    }

    public AdvchannelInfoExample.Criteria andIdLessThanOrEqualTo(Integer value) {
      addCriterion("id <=", value, "id");
      return ((AdvchannelInfoExample.Criteria)this);
    }

    public AdvchannelInfoExample.Criteria andIdIn(List<Integer> values) {
      addCriterion("id in", values, "id");
      return ((AdvchannelInfoExample.Criteria)this);
    }

    public AdvchannelInfoExample.Criteria andIdNotIn(List<Integer> values) {
      addCriterion("id not in", values, "id");
      return ((AdvchannelInfoExample.Criteria)this);
    }

    public AdvchannelInfoExample.Criteria andIdBetween(Integer value1, Integer value2) {
      addCriterion("id between", value1, value2, "id");
      return ((AdvchannelInfoExample.Criteria)this);
    }

    public AdvchannelInfoExample.Criteria andIdNotBetween(Integer value1, Integer value2) {
      addCriterion("id not between", value1, value2, "id");
      return ((AdvchannelInfoExample.Criteria)this);
    }

    public AdvchannelInfoExample.Criteria andMemberidIsNull() {
      addCriterion("memberid is null");
      return ((AdvchannelInfoExample.Criteria)this);
    }

    public AdvchannelInfoExample.Criteria andMemberidIsNotNull() {
      addCriterion("memberid is not null");
      return ((AdvchannelInfoExample.Criteria)this);
    }

    public AdvchannelInfoExample.Criteria andMemberidEqualTo(Long value) {
      addCriterion("memberid =", value, "memberid");
      return ((AdvchannelInfoExample.Criteria)this);
    }

    public AdvchannelInfoExample.Criteria andMemberidNotEqualTo(Long value) {
      addCriterion("memberid <>", value, "memberid");
      return ((AdvchannelInfoExample.Criteria)this);
    }

    public AdvchannelInfoExample.Criteria andMemberidGreaterThan(Long value) {
      addCriterion("memberid >", value, "memberid");
      return ((AdvchannelInfoExample.Criteria)this);
    }

    public AdvchannelInfoExample.Criteria andMemberidGreaterThanOrEqualTo(Long value) {
      addCriterion("memberid >=", value, "memberid");
      return ((AdvchannelInfoExample.Criteria)this);
    }

    public AdvchannelInfoExample.Criteria andMemberidLessThan(Long value) {
      addCriterion("memberid <", value, "memberid");
      return ((AdvchannelInfoExample.Criteria)this);
    }

    public AdvchannelInfoExample.Criteria andMemberidLessThanOrEqualTo(Long value) {
      addCriterion("memberid <=", value, "memberid");
      return ((AdvchannelInfoExample.Criteria)this);
    }

    public AdvchannelInfoExample.Criteria andMemberidIn(List<Long> values) {
      addCriterion("memberid in", values, "memberid");
      return ((AdvchannelInfoExample.Criteria)this);
    }

    public AdvchannelInfoExample.Criteria andMemberidNotIn(List<Long> values) {
      addCriterion("memberid not in", values, "memberid");
      return ((AdvchannelInfoExample.Criteria)this);
    }

    public AdvchannelInfoExample.Criteria andMemberidBetween(Long value1, Long value2) {
      addCriterion("memberid between", value1, value2, "memberid");
      return ((AdvchannelInfoExample.Criteria)this);
    }

    public AdvchannelInfoExample.Criteria andMemberidNotBetween(Long value1, Long value2) {
      addCriterion("memberid not between", value1, value2, "memberid");
      return ((AdvchannelInfoExample.Criteria)this);
    }

    public AdvchannelInfoExample.Criteria andChannelnameIsNull() {
      addCriterion("channelname is null");
      return ((AdvchannelInfoExample.Criteria)this);
    }

    public AdvchannelInfoExample.Criteria andChannelnameIsNotNull() {
      addCriterion("channelname is not null");
      return ((AdvchannelInfoExample.Criteria)this);
    }

    public AdvchannelInfoExample.Criteria andChannelnameEqualTo(String value) {
      addCriterion("channelname =", value, "channelname");
      return ((AdvchannelInfoExample.Criteria)this);
    }

    public AdvchannelInfoExample.Criteria andChannelnameNotEqualTo(String value) {
      addCriterion("channelname <>", value, "channelname");
      return ((AdvchannelInfoExample.Criteria)this);
    }

    public AdvchannelInfoExample.Criteria andChannelnameGreaterThan(String value) {
      addCriterion("channelname >", value, "channelname");
      return ((AdvchannelInfoExample.Criteria)this);
    }

    public AdvchannelInfoExample.Criteria andChannelnameGreaterThanOrEqualTo(String value) {
      addCriterion("channelname >=", value, "channelname");
      return ((AdvchannelInfoExample.Criteria)this);
    }

    public AdvchannelInfoExample.Criteria andChannelnameLessThan(String value) {
      addCriterion("channelname <", value, "channelname");
      return ((AdvchannelInfoExample.Criteria)this);
    }

    public AdvchannelInfoExample.Criteria andChannelnameLessThanOrEqualTo(String value) {
      addCriterion("channelname <=", value, "channelname");
      return ((AdvchannelInfoExample.Criteria)this);
    }

    public AdvchannelInfoExample.Criteria andChannelnameLike(String value) {
      addCriterion("channelname like", value, "channelname");
      return ((AdvchannelInfoExample.Criteria)this);
    }

    public AdvchannelInfoExample.Criteria andChannelnameNotLike(String value) {
      addCriterion("channelname not like", value, "channelname");
      return ((AdvchannelInfoExample.Criteria)this);
    }

    public AdvchannelInfoExample.Criteria andChannelnameIn(List<String> values) {
      addCriterion("channelname in", values, "channelname");
      return ((AdvchannelInfoExample.Criteria)this);
    }

    public AdvchannelInfoExample.Criteria andChannelnameNotIn(List<String> values) {
      addCriterion("channelname not in", values, "channelname");
      return ((AdvchannelInfoExample.Criteria)this);
    }

    public AdvchannelInfoExample.Criteria andChannelnameBetween(String value1, String value2) {
      addCriterion("channelname between", value1, value2, "channelname");
      return ((AdvchannelInfoExample.Criteria)this);
    }

    public AdvchannelInfoExample.Criteria andChannelnameNotBetween(String value1, String value2) {
      addCriterion("channelname not between", value1, value2, "channelname");
      return ((AdvchannelInfoExample.Criteria)this);
    }

    public AdvchannelInfoExample.Criteria andChannelcodeIsNull() {
      addCriterion("channelcode is null");
      return ((AdvchannelInfoExample.Criteria)this);
    }

    public AdvchannelInfoExample.Criteria andChannelcodeIsNotNull() {
      addCriterion("channelcode is not null");
      return ((AdvchannelInfoExample.Criteria)this);
    }

    public AdvchannelInfoExample.Criteria andChannelcodeEqualTo(String value) {
      addCriterion("channelcode =", value, "channelcode");
      return ((AdvchannelInfoExample.Criteria)this);
    }

    public AdvchannelInfoExample.Criteria andChannelcodeNotEqualTo(String value) {
      addCriterion("channelcode <>", value, "channelcode");
      return ((AdvchannelInfoExample.Criteria)this);
    }

    public AdvchannelInfoExample.Criteria andChannelcodeGreaterThan(String value) {
      addCriterion("channelcode >", value, "channelcode");
      return ((AdvchannelInfoExample.Criteria)this);
    }

    public AdvchannelInfoExample.Criteria andChannelcodeGreaterThanOrEqualTo(String value) {
      addCriterion("channelcode >=", value, "channelcode");
      return ((AdvchannelInfoExample.Criteria)this);
    }

    public AdvchannelInfoExample.Criteria andChannelcodeLessThan(String value) {
      addCriterion("channelcode <", value, "channelcode");
      return ((AdvchannelInfoExample.Criteria)this);
    }

    public AdvchannelInfoExample.Criteria andChannelcodeLessThanOrEqualTo(String value) {
      addCriterion("channelcode <=", value, "channelcode");
      return ((AdvchannelInfoExample.Criteria)this);
    }

    public AdvchannelInfoExample.Criteria andChannelcodeLike(String value) {
      addCriterion("channelcode like", value, "channelcode");
      return ((AdvchannelInfoExample.Criteria)this);
    }

    public AdvchannelInfoExample.Criteria andChannelcodeNotLike(String value) {
      addCriterion("channelcode not like", value, "channelcode");
      return ((AdvchannelInfoExample.Criteria)this);
    }

    public AdvchannelInfoExample.Criteria andChannelcodeIn(List<String> values) {
      addCriterion("channelcode in", values, "channelcode");
      return ((AdvchannelInfoExample.Criteria)this);
    }

    public AdvchannelInfoExample.Criteria andChannelcodeNotIn(List<String> values) {
      addCriterion("channelcode not in", values, "channelcode");
      return ((AdvchannelInfoExample.Criteria)this);
    }

    public AdvchannelInfoExample.Criteria andChannelcodeBetween(String value1, String value2) {
      addCriterion("channelcode between", value1, value2, "channelcode");
      return ((AdvchannelInfoExample.Criteria)this);
    }

    public AdvchannelInfoExample.Criteria andChannelcodeNotBetween(String value1, String value2) {
      addCriterion("channelcode not between", value1, value2, "channelcode");
      return ((AdvchannelInfoExample.Criteria)this);
    }

    public AdvchannelInfoExample.Criteria andFeetypeIsNull() {
      addCriterion("feetype is null");
      return ((AdvchannelInfoExample.Criteria)this);
    }

    public AdvchannelInfoExample.Criteria andFeetypeIsNotNull() {
      addCriterion("feetype is not null");
      return ((AdvchannelInfoExample.Criteria)this);
    }

    public AdvchannelInfoExample.Criteria andFeetypeEqualTo(Integer value) {
      addCriterion("feetype =", value, "feetype");
      return ((AdvchannelInfoExample.Criteria)this);
    }

    public AdvchannelInfoExample.Criteria andFeetypeNotEqualTo(Integer value) {
      addCriterion("feetype <>", value, "feetype");
      return ((AdvchannelInfoExample.Criteria)this);
    }

    public AdvchannelInfoExample.Criteria andFeetypeGreaterThan(Integer value) {
      addCriterion("feetype >", value, "feetype");
      return ((AdvchannelInfoExample.Criteria)this);
    }

    public AdvchannelInfoExample.Criteria andFeetypeGreaterThanOrEqualTo(Integer value) {
      addCriterion("feetype >=", value, "feetype");
      return ((AdvchannelInfoExample.Criteria)this);
    }

    public AdvchannelInfoExample.Criteria andFeetypeLessThan(Integer value) {
      addCriterion("feetype <", value, "feetype");
      return ((AdvchannelInfoExample.Criteria)this);
    }

    public AdvchannelInfoExample.Criteria andFeetypeLessThanOrEqualTo(Integer value) {
      addCriterion("feetype <=", value, "feetype");
      return ((AdvchannelInfoExample.Criteria)this);
    }

    public AdvchannelInfoExample.Criteria andFeetypeIn(List<Integer> values) {
      addCriterion("feetype in", values, "feetype");
      return ((AdvchannelInfoExample.Criteria)this);
    }

    public AdvchannelInfoExample.Criteria andFeetypeNotIn(List<Integer> values) {
      addCriterion("feetype not in", values, "feetype");
      return ((AdvchannelInfoExample.Criteria)this);
    }

    public AdvchannelInfoExample.Criteria andFeetypeBetween(Integer value1, Integer value2) {
      addCriterion("feetype between", value1, value2, "feetype");
      return ((AdvchannelInfoExample.Criteria)this);
    }

    public AdvchannelInfoExample.Criteria andFeetypeNotBetween(Integer value1, Integer value2) {
      addCriterion("feetype not between", value1, value2, "feetype");
      return ((AdvchannelInfoExample.Criteria)this);
    }

    public AdvchannelInfoExample.Criteria andProfittypeIsNull() {
      addCriterion("profittype is null");
      return ((AdvchannelInfoExample.Criteria)this);
    }

    public AdvchannelInfoExample.Criteria andProfittypeIsNotNull() {
      addCriterion("profittype is not null");
      return ((AdvchannelInfoExample.Criteria)this);
    }

    public AdvchannelInfoExample.Criteria andProfittypeEqualTo(Integer value) {
      addCriterion("profittype =", value, "profittype");
      return ((AdvchannelInfoExample.Criteria)this);
    }

    public AdvchannelInfoExample.Criteria andProfittypeNotEqualTo(Integer value) {
      addCriterion("profittype <>", value, "profittype");
      return ((AdvchannelInfoExample.Criteria)this);
    }

    public AdvchannelInfoExample.Criteria andProfittypeGreaterThan(Integer value) {
      addCriterion("profittype >", value, "profittype");
      return ((AdvchannelInfoExample.Criteria)this);
    }

    public AdvchannelInfoExample.Criteria andProfittypeGreaterThanOrEqualTo(Integer value) {
      addCriterion("profittype >=", value, "profittype");
      return ((AdvchannelInfoExample.Criteria)this);
    }

    public AdvchannelInfoExample.Criteria andProfittypeLessThan(Integer value) {
      addCriterion("profittype <", value, "profittype");
      return ((AdvchannelInfoExample.Criteria)this);
    }

    public AdvchannelInfoExample.Criteria andProfittypeLessThanOrEqualTo(Integer value) {
      addCriterion("profittype <=", value, "profittype");
      return ((AdvchannelInfoExample.Criteria)this);
    }

    public AdvchannelInfoExample.Criteria andProfittypeIn(List<Integer> values) {
      addCriterion("profittype in", values, "profittype");
      return ((AdvchannelInfoExample.Criteria)this);
    }

    public AdvchannelInfoExample.Criteria andProfittypeNotIn(List<Integer> values) {
      addCriterion("profittype not in", values, "profittype");
      return ((AdvchannelInfoExample.Criteria)this);
    }

    public AdvchannelInfoExample.Criteria andProfittypeBetween(Integer value1, Integer value2) {
      addCriterion("profittype between", value1, value2, "profittype");
      return ((AdvchannelInfoExample.Criteria)this);
    }

    public AdvchannelInfoExample.Criteria andProfittypeNotBetween(Integer value1, Integer value2) {
      addCriterion("profittype not between", value1, value2, "profittype");
      return ((AdvchannelInfoExample.Criteria)this);
    }

    public AdvchannelInfoExample.Criteria andCooperiodIsNull() {
      addCriterion("cooperiod is null");
      return ((AdvchannelInfoExample.Criteria)this);
    }

    public AdvchannelInfoExample.Criteria andCooperiodIsNotNull() {
      addCriterion("cooperiod is not null");
      return ((AdvchannelInfoExample.Criteria)this);
    }

    public AdvchannelInfoExample.Criteria andCooperiodEqualTo(Date value) {
      addCriterion("cooperiod =", value, "cooperiod");
      return ((AdvchannelInfoExample.Criteria)this);
    }

    public AdvchannelInfoExample.Criteria andCooperiodNotEqualTo(Date value) {
      addCriterion("cooperiod <>", value, "cooperiod");
      return ((AdvchannelInfoExample.Criteria)this);
    }

    public AdvchannelInfoExample.Criteria andCooperiodGreaterThan(Date value) {
      addCriterion("cooperiod >", value, "cooperiod");
      return ((AdvchannelInfoExample.Criteria)this);
    }

    public AdvchannelInfoExample.Criteria andCooperiodGreaterThanOrEqualTo(Date value) {
      addCriterion("cooperiod >=", value, "cooperiod");
      return ((AdvchannelInfoExample.Criteria)this);
    }

    public AdvchannelInfoExample.Criteria andCooperiodLessThan(Date value) {
      addCriterion("cooperiod <", value, "cooperiod");
      return ((AdvchannelInfoExample.Criteria)this);
    }

    public AdvchannelInfoExample.Criteria andCooperiodLessThanOrEqualTo(Date value) {
      addCriterion("cooperiod <=", value, "cooperiod");
      return ((AdvchannelInfoExample.Criteria)this);
    }

    public AdvchannelInfoExample.Criteria andCooperiodIn(List<Date> values) {
      addCriterion("cooperiod in", values, "cooperiod");
      return ((AdvchannelInfoExample.Criteria)this);
    }

    public AdvchannelInfoExample.Criteria andCooperiodNotIn(List<Date> values) {
      addCriterion("cooperiod not in", values, "cooperiod");
      return ((AdvchannelInfoExample.Criteria)this);
    }

    public AdvchannelInfoExample.Criteria andCooperiodBetween(Date value1, Date value2) {
      addCriterion("cooperiod between", value1, value2, "cooperiod");
      return ((AdvchannelInfoExample.Criteria)this);
    }

    public AdvchannelInfoExample.Criteria andCooperiodNotBetween(Date value1, Date value2) {
      addCriterion("cooperiod not between", value1, value2, "cooperiod");
      return ((AdvchannelInfoExample.Criteria)this);
    }

    public AdvchannelInfoExample.Criteria andRemarkIsNull() {
      addCriterion("remark is null");
      return ((AdvchannelInfoExample.Criteria)this);
    }

    public AdvchannelInfoExample.Criteria andRemarkIsNotNull() {
      addCriterion("remark is not null");
      return ((AdvchannelInfoExample.Criteria)this);
    }

    public AdvchannelInfoExample.Criteria andRemarkEqualTo(String value) {
      addCriterion("remark =", value, "remark");
      return ((AdvchannelInfoExample.Criteria)this);
    }

    public AdvchannelInfoExample.Criteria andRemarkNotEqualTo(String value) {
      addCriterion("remark <>", value, "remark");
      return ((AdvchannelInfoExample.Criteria)this);
    }

    public AdvchannelInfoExample.Criteria andRemarkGreaterThan(String value) {
      addCriterion("remark >", value, "remark");
      return ((AdvchannelInfoExample.Criteria)this);
    }

    public AdvchannelInfoExample.Criteria andRemarkGreaterThanOrEqualTo(String value) {
      addCriterion("remark >=", value, "remark");
      return ((AdvchannelInfoExample.Criteria)this);
    }

    public AdvchannelInfoExample.Criteria andRemarkLessThan(String value) {
      addCriterion("remark <", value, "remark");
      return ((AdvchannelInfoExample.Criteria)this);
    }

    public AdvchannelInfoExample.Criteria andRemarkLessThanOrEqualTo(String value) {
      addCriterion("remark <=", value, "remark");
      return ((AdvchannelInfoExample.Criteria)this);
    }

    public AdvchannelInfoExample.Criteria andRemarkLike(String value) {
      addCriterion("remark like", value, "remark");
      return ((AdvchannelInfoExample.Criteria)this);
    }

    public AdvchannelInfoExample.Criteria andRemarkNotLike(String value) {
      addCriterion("remark not like", value, "remark");
      return ((AdvchannelInfoExample.Criteria)this);
    }

    public AdvchannelInfoExample.Criteria andRemarkIn(List<String> values) {
      addCriterion("remark in", values, "remark");
      return ((AdvchannelInfoExample.Criteria)this);
    }

    public AdvchannelInfoExample.Criteria andRemarkNotIn(List<String> values) {
      addCriterion("remark not in", values, "remark");
      return ((AdvchannelInfoExample.Criteria)this);
    }

    public AdvchannelInfoExample.Criteria andRemarkBetween(String value1, String value2) {
      addCriterion("remark between", value1, value2, "remark");
      return ((AdvchannelInfoExample.Criteria)this);
    }

    public AdvchannelInfoExample.Criteria andRemarkNotBetween(String value1, String value2) {
      addCriterion("remark not between", value1, value2, "remark");
      return ((AdvchannelInfoExample.Criteria)this);
    }
  }
}