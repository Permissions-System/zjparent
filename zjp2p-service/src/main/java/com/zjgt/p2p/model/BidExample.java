package com.zjgt.p2p.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springfk.pancloud.daoframework.page.PageExample;

public class BidExample extends PageExample
{
  protected String orderByClause;
  protected boolean distinct;
  protected Integer startPos;
  protected Integer pageSize;
  protected List<Criteria> oredCriteria;

  public BidExample()
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

  public Integer getStartPos() {
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

  public static class Criteria extends BidExample.GeneratedCriteria
  {
  }

  protected static abstract class GeneratedCriteria
  {
    protected List<BidExample.Criterion> criteria;

    protected GeneratedCriteria()
    {
      this.criteria = new ArrayList();
    }

    public boolean isValid() {
      return (this.criteria.size() > 0);
    }

    public List<BidExample.Criterion> getAllCriteria() {
      return this.criteria;
    }

    public List<BidExample.Criterion> getCriteria() {
      return this.criteria;
    }

    protected void addCriterion(String condition) {
      if (condition == null) {
        throw new RuntimeException("Value for condition cannot be null");
      }
      this.criteria.add(new BidExample.Criterion(condition));
    }

    protected void addCriterion(String condition, Object value, String property) {
      if (value == null) {
        throw new RuntimeException("Value for " + property + " cannot be null");
      }
      this.criteria.add(new BidExample.Criterion(condition, value));
    }

    protected void addCriterion(String condition, Object value1, Object value2, String property) {
      if ((value1 == null) || (value2 == null)) {
        throw new RuntimeException("Between values for " + property + " cannot be null");
      }
      this.criteria.add(new BidExample.Criterion(condition, value1, value2));
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

    public BidExample.Criteria andIdIsNull() {
      addCriterion("id is null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andIdIsNotNull() {
      addCriterion("id is not null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andIdEqualTo(Integer value) {
      addCriterion("id =", value, "id");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andIdNotEqualTo(Integer value) {
      addCriterion("id <>", value, "id");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andIdGreaterThan(Integer value) {
      addCriterion("id >", value, "id");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andIdGreaterThanOrEqualTo(Integer value) {
      addCriterion("id >=", value, "id");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andIdLessThan(Integer value) {
      addCriterion("id <", value, "id");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andIdLessThanOrEqualTo(Integer value) {
      addCriterion("id <=", value, "id");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andIdIn(List<Integer> values) {
      addCriterion("id in", values, "id");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andIdNotIn(List<Integer> values) {
      addCriterion("id not in", values, "id");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andIdBetween(Integer value1, Integer value2) {
      addCriterion("id between", value1, value2, "id");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andIdNotBetween(Integer value1, Integer value2) {
      addCriterion("id not between", value1, value2, "id");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidcodeIsNull() {
      addCriterion("BidCode is null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidcodeIsNotNull() {
      addCriterion("BidCode is not null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidcodeEqualTo(String value) {
      addCriterion("BidCode =", value, "bidcode");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidcodeNotEqualTo(String value) {
      addCriterion("BidCode <>", value, "bidcode");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidcodeGreaterThan(String value) {
      addCriterion("BidCode >", value, "bidcode");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidcodeGreaterThanOrEqualTo(String value) {
      addCriterion("BidCode >=", value, "bidcode");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidcodeLessThan(String value) {
      addCriterion("BidCode <", value, "bidcode");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidcodeLessThanOrEqualTo(String value) {
      addCriterion("BidCode <=", value, "bidcode");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidcodeLike(String value) {
      addCriterion("BidCode like", value, "bidcode");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidcodeNotLike(String value) {
      addCriterion("BidCode not like", value, "bidcode");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidcodeIn(List<String> values) {
      addCriterion("BidCode in", values, "bidcode");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidcodeNotIn(List<String> values) {
      addCriterion("BidCode not in", values, "bidcode");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidcodeBetween(String value1, String value2) {
      addCriterion("BidCode between", value1, value2, "bidcode");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidcodeNotBetween(String value1, String value2) {
      addCriterion("BidCode not between", value1, value2, "bidcode");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidnoIsNull() {
      addCriterion("bidno is null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidnoIsNotNull() {
      addCriterion("bidno is not null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidnoEqualTo(String value) {
      addCriterion("bidno =", value, "bidno");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidnoNotEqualTo(String value) {
      addCriterion("bidno <>", value, "bidno");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidnoGreaterThan(String value) {
      addCriterion("bidno >", value, "bidno");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidnoGreaterThanOrEqualTo(String value) {
      addCriterion("bidno >=", value, "bidno");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidnoLessThan(String value) {
      addCriterion("bidno <", value, "bidno");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidnoLessThanOrEqualTo(String value) {
      addCriterion("bidno <=", value, "bidno");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidnoLike(String value) {
      addCriterion("bidno like", value, "bidno");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidnoNotLike(String value) {
      addCriterion("bidno not like", value, "bidno");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidnoIn(List<String> values) {
      addCriterion("bidno in", values, "bidno");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidnoNotIn(List<String> values) {
      addCriterion("bidno not in", values, "bidno");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidnoBetween(String value1, String value2) {
      addCriterion("bidno between", value1, value2, "bidno");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidnoNotBetween(String value1, String value2) {
      addCriterion("bidno not between", value1, value2, "bidno");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidclassnoIsNull() {
      addCriterion("bidclassno is null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidclassnoIsNotNull() {
      addCriterion("bidclassno is not null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidclassnoEqualTo(String value) {
      addCriterion("bidclassno =", value, "bidclassno");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidclassnoNotEqualTo(String value) {
      addCriterion("bidclassno <>", value, "bidclassno");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidclassnoGreaterThan(String value) {
      addCriterion("bidclassno >", value, "bidclassno");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidclassnoGreaterThanOrEqualTo(String value) {
      addCriterion("bidclassno >=", value, "bidclassno");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidclassnoLessThan(String value) {
      addCriterion("bidclassno <", value, "bidclassno");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidclassnoLessThanOrEqualTo(String value) {
      addCriterion("bidclassno <=", value, "bidclassno");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidclassnoLike(String value) {
      addCriterion("bidclassno like", value, "bidclassno");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidclassnoNotLike(String value) {
      addCriterion("bidclassno not like", value, "bidclassno");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidclassnoIn(List<String> values) {
      addCriterion("bidclassno in", values, "bidclassno");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidclassnoNotIn(List<String> values) {
      addCriterion("bidclassno not in", values, "bidclassno");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidclassnoBetween(String value1, String value2) {
      addCriterion("bidclassno between", value1, value2, "bidclassno");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidclassnoNotBetween(String value1, String value2) {
      addCriterion("bidclassno not between", value1, value2, "bidclassno");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidtypeidIsNull() {
      addCriterion("bidtypeid is null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidtypeidIsNotNull() {
      addCriterion("bidtypeid is not null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidtypeidEqualTo(Integer value) {
      addCriterion("bidtypeid =", value, "bidtypeid");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidtypeidNotEqualTo(Integer value) {
      addCriterion("bidtypeid <>", value, "bidtypeid");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidtypeidGreaterThan(Integer value) {
      addCriterion("bidtypeid >", value, "bidtypeid");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidtypeidGreaterThanOrEqualTo(Integer value) {
      addCriterion("bidtypeid >=", value, "bidtypeid");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidtypeidLessThan(Integer value) {
      addCriterion("bidtypeid <", value, "bidtypeid");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidtypeidLessThanOrEqualTo(Integer value) {
      addCriterion("bidtypeid <=", value, "bidtypeid");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidtypeidIn(List<Integer> values) {
      addCriterion("bidtypeid in", values, "bidtypeid");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidtypeidNotIn(List<Integer> values) {
      addCriterion("bidtypeid not in", values, "bidtypeid");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidtypeidBetween(Integer value1, Integer value2) {
      addCriterion("bidtypeid between", value1, value2, "bidtypeid");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidtypeidNotBetween(Integer value1, Integer value2) {
      addCriterion("bidtypeid not between", value1, value2, "bidtypeid");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidtypeIsNull() {
      addCriterion("bidtype is null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidtypeIsNotNull() {
      addCriterion("bidtype is not null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidtypeEqualTo(String value) {
      addCriterion("bidtype =", value, "bidtype");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidtypeNotEqualTo(String value) {
      addCriterion("bidtype <>", value, "bidtype");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidtypeGreaterThan(String value) {
      addCriterion("bidtype >", value, "bidtype");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidtypeGreaterThanOrEqualTo(String value) {
      addCriterion("bidtype >=", value, "bidtype");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidtypeLessThan(String value) {
      addCriterion("bidtype <", value, "bidtype");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidtypeLessThanOrEqualTo(String value) {
      addCriterion("bidtype <=", value, "bidtype");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidtypeLike(String value) {
      addCriterion("bidtype like", value, "bidtype");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidtypeNotLike(String value) {
      addCriterion("bidtype not like", value, "bidtype");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidtypeIn(List<String> values) {
      addCriterion("bidtype in", values, "bidtype");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidtypeNotIn(List<String> values) {
      addCriterion("bidtype not in", values, "bidtype");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidtypeBetween(String value1, String value2) {
      addCriterion("bidtype between", value1, value2, "bidtype");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidtypeNotBetween(String value1, String value2) {
      addCriterion("bidtype not between", value1, value2, "bidtype");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidclassnameIsNull() {
      addCriterion("bidclassname is null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidclassnameIsNotNull() {
      addCriterion("bidclassname is not null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidclassnameEqualTo(String value) {
      addCriterion("bidclassname =", value, "bidclassname");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidclassnameNotEqualTo(String value) {
      addCriterion("bidclassname <>", value, "bidclassname");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidclassnameGreaterThan(String value) {
      addCriterion("bidclassname >", value, "bidclassname");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidclassnameGreaterThanOrEqualTo(String value) {
      addCriterion("bidclassname >=", value, "bidclassname");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidclassnameLessThan(String value) {
      addCriterion("bidclassname <", value, "bidclassname");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidclassnameLessThanOrEqualTo(String value) {
      addCriterion("bidclassname <=", value, "bidclassname");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidclassnameLike(String value) {
      addCriterion("bidclassname like", value, "bidclassname");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidclassnameNotLike(String value) {
      addCriterion("bidclassname not like", value, "bidclassname");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidclassnameIn(List<String> values) {
      addCriterion("bidclassname in", values, "bidclassname");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidclassnameNotIn(List<String> values) {
      addCriterion("bidclassname not in", values, "bidclassname");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidclassnameBetween(String value1, String value2) {
      addCriterion("bidclassname between", value1, value2, "bidclassname");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidclassnameNotBetween(String value1, String value2) {
      addCriterion("bidclassname not between", value1, value2, "bidclassname");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidclasssubjectIsNull() {
      addCriterion("bidclasssubject is null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidclasssubjectIsNotNull() {
      addCriterion("bidclasssubject is not null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidclasssubjectEqualTo(String value) {
      addCriterion("bidclasssubject =", value, "bidclasssubject");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidclasssubjectNotEqualTo(String value) {
      addCriterion("bidclasssubject <>", value, "bidclasssubject");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidclasssubjectGreaterThan(String value) {
      addCriterion("bidclasssubject >", value, "bidclasssubject");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidclasssubjectGreaterThanOrEqualTo(String value) {
      addCriterion("bidclasssubject >=", value, "bidclasssubject");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidclasssubjectLessThan(String value) {
      addCriterion("bidclasssubject <", value, "bidclasssubject");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidclasssubjectLessThanOrEqualTo(String value) {
      addCriterion("bidclasssubject <=", value, "bidclasssubject");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidclasssubjectLike(String value) {
      addCriterion("bidclasssubject like", value, "bidclasssubject");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidclasssubjectNotLike(String value) {
      addCriterion("bidclasssubject not like", value, "bidclasssubject");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidclasssubjectIn(List<String> values) {
      addCriterion("bidclasssubject in", values, "bidclasssubject");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidclasssubjectNotIn(List<String> values) {
      addCriterion("bidclasssubject not in", values, "bidclasssubject");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidclasssubjectBetween(String value1, String value2) {
      addCriterion("bidclasssubject between", value1, value2, "bidclasssubject");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidclasssubjectNotBetween(String value1, String value2) {
      addCriterion("bidclasssubject not between", value1, value2, "bidclasssubject");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidimgIsNull() {
      addCriterion("bidimg is null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidimgIsNotNull() {
      addCriterion("bidimg is not null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidimgEqualTo(String value) {
      addCriterion("bidimg =", value, "bidimg");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidimgNotEqualTo(String value) {
      addCriterion("bidimg <>", value, "bidimg");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidimgGreaterThan(String value) {
      addCriterion("bidimg >", value, "bidimg");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidimgGreaterThanOrEqualTo(String value) {
      addCriterion("bidimg >=", value, "bidimg");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidimgLessThan(String value) {
      addCriterion("bidimg <", value, "bidimg");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidimgLessThanOrEqualTo(String value) {
      addCriterion("bidimg <=", value, "bidimg");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidimgLike(String value) {
      addCriterion("bidimg like", value, "bidimg");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidimgNotLike(String value) {
      addCriterion("bidimg not like", value, "bidimg");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidimgIn(List<String> values) {
      addCriterion("bidimg in", values, "bidimg");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidimgNotIn(List<String> values) {
      addCriterion("bidimg not in", values, "bidimg");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidimgBetween(String value1, String value2) {
      addCriterion("bidimg between", value1, value2, "bidimg");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidimgNotBetween(String value1, String value2) {
      addCriterion("bidimg not between", value1, value2, "bidimg");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andAmountIsNull() {
      addCriterion("amount is null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andAmountIsNotNull() {
      addCriterion("amount is not null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andAmountEqualTo(BigDecimal value) {
      addCriterion("amount =", value, "amount");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andAmountNotEqualTo(BigDecimal value) {
      addCriterion("amount <>", value, "amount");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andAmountGreaterThan(BigDecimal value) {
      addCriterion("amount >", value, "amount");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andAmountGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("amount >=", value, "amount");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andAmountLessThan(BigDecimal value) {
      addCriterion("amount <", value, "amount");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andAmountLessThanOrEqualTo(BigDecimal value) {
      addCriterion("amount <=", value, "amount");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andAmountIn(List<BigDecimal> values) {
      addCriterion("amount in", values, "amount");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andAmountNotIn(List<BigDecimal> values) {
      addCriterion("amount not in", values, "amount");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andAmountBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("amount between", value1, value2, "amount");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andAmountNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("amount not between", value1, value2, "amount");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRemainpriamountIsNull() {
      addCriterion("RemainPriAmount is null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRemainpriamountIsNotNull() {
      addCriterion("RemainPriAmount is not null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRemainpriamountEqualTo(BigDecimal value) {
      addCriterion("RemainPriAmount =", value, "remainpriamount");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRemainpriamountNotEqualTo(BigDecimal value) {
      addCriterion("RemainPriAmount <>", value, "remainpriamount");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRemainpriamountGreaterThan(BigDecimal value) {
      addCriterion("RemainPriAmount >", value, "remainpriamount");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRemainpriamountGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("RemainPriAmount >=", value, "remainpriamount");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRemainpriamountLessThan(BigDecimal value) {
      addCriterion("RemainPriAmount <", value, "remainpriamount");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRemainpriamountLessThanOrEqualTo(BigDecimal value) {
      addCriterion("RemainPriAmount <=", value, "remainpriamount");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRemainpriamountIn(List<BigDecimal> values) {
      addCriterion("RemainPriAmount in", values, "remainpriamount");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRemainpriamountNotIn(List<BigDecimal> values) {
      addCriterion("RemainPriAmount not in", values, "remainpriamount");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRemainpriamountBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("RemainPriAmount between", value1, value2, "remainpriamount");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRemainpriamountNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("RemainPriAmount not between", value1, value2, "remainpriamount");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andInvestperiodtypeidIsNull() {
      addCriterion("investperiodtypeid is null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andInvestperiodtypeidIsNotNull() {
      addCriterion("investperiodtypeid is not null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andInvestperiodtypeidEqualTo(Integer value) {
      addCriterion("investperiodtypeid =", value, "investperiodtypeid");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andInvestperiodtypeidNotEqualTo(Integer value) {
      addCriterion("investperiodtypeid <>", value, "investperiodtypeid");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andInvestperiodtypeidGreaterThan(Integer value) {
      addCriterion("investperiodtypeid >", value, "investperiodtypeid");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andInvestperiodtypeidGreaterThanOrEqualTo(Integer value) {
      addCriterion("investperiodtypeid >=", value, "investperiodtypeid");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andInvestperiodtypeidLessThan(Integer value) {
      addCriterion("investperiodtypeid <", value, "investperiodtypeid");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andInvestperiodtypeidLessThanOrEqualTo(Integer value) {
      addCriterion("investperiodtypeid <=", value, "investperiodtypeid");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andInvestperiodtypeidIn(List<Integer> values) {
      addCriterion("investperiodtypeid in", values, "investperiodtypeid");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andInvestperiodtypeidNotIn(List<Integer> values) {
      addCriterion("investperiodtypeid not in", values, "investperiodtypeid");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andInvestperiodtypeidBetween(Integer value1, Integer value2) {
      addCriterion("investperiodtypeid between", value1, value2, "investperiodtypeid");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andInvestperiodtypeidNotBetween(Integer value1, Integer value2) {
      addCriterion("investperiodtypeid not between", value1, value2, "investperiodtypeid");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andInvestperiodIsNull() {
      addCriterion("investperiod is null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andInvestperiodIsNotNull() {
      addCriterion("investperiod is not null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andInvestperiodEqualTo(Integer value) {
      addCriterion("investperiod =", value, "investperiod");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andInvestperiodNotEqualTo(Integer value) {
      addCriterion("investperiod <>", value, "investperiod");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andInvestperiodGreaterThan(Integer value) {
      addCriterion("investperiod >", value, "investperiod");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andInvestperiodGreaterThanOrEqualTo(Integer value) {
      addCriterion("investperiod >=", value, "investperiod");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andInvestperiodLessThan(Integer value) {
      addCriterion("investperiod <", value, "investperiod");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andInvestperiodLessThanOrEqualTo(Integer value) {
      addCriterion("investperiod <=", value, "investperiod");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andInvestperiodIn(List<Integer> values) {
      addCriterion("investperiod in", values, "investperiod");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andInvestperiodNotIn(List<Integer> values) {
      addCriterion("investperiod not in", values, "investperiod");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andInvestperiodBetween(Integer value1, Integer value2) {
      addCriterion("investperiod between", value1, value2, "investperiod");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andInvestperiodNotBetween(Integer value1, Integer value2) {
      addCriterion("investperiod not between", value1, value2, "investperiod");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRaiseperiodIsNull() {
      addCriterion("raiseperiod is null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRaiseperiodIsNotNull() {
      addCriterion("raiseperiod is not null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRaiseperiodEqualTo(String value) {
      addCriterion("raiseperiod =", value, "raiseperiod");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRaiseperiodNotEqualTo(String value) {
      addCriterion("raiseperiod <>", value, "raiseperiod");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRaiseperiodGreaterThan(String value) {
      addCriterion("raiseperiod >", value, "raiseperiod");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRaiseperiodGreaterThanOrEqualTo(String value) {
      addCriterion("raiseperiod >=", value, "raiseperiod");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRaiseperiodLessThan(String value) {
      addCriterion("raiseperiod <", value, "raiseperiod");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRaiseperiodLessThanOrEqualTo(String value) {
      addCriterion("raiseperiod <=", value, "raiseperiod");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRaiseperiodLike(String value) {
      addCriterion("raiseperiod like", value, "raiseperiod");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRaiseperiodNotLike(String value) {
      addCriterion("raiseperiod not like", value, "raiseperiod");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRaiseperiodIn(List<String> values) {
      addCriterion("raiseperiod in", values, "raiseperiod");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRaiseperiodNotIn(List<String> values) {
      addCriterion("raiseperiod not in", values, "raiseperiod");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRaiseperiodBetween(String value1, String value2) {
      addCriterion("raiseperiod between", value1, value2, "raiseperiod");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRaiseperiodNotBetween(String value1, String value2) {
      addCriterion("raiseperiod not between", value1, value2, "raiseperiod");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRaisebegindateIsNull() {
      addCriterion("raisebegindate is null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRaisebegindateIsNotNull() {
      addCriterion("raisebegindate is not null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRaisebegindateEqualTo(java.util.Date value) {
      addCriterionForJDBCDate("raisebegindate =", value, "raisebegindate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRaisebegindateNotEqualTo(java.util.Date value) {
      addCriterionForJDBCDate("raisebegindate <>", value, "raisebegindate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRaisebegindateGreaterThan(java.util.Date value) {
      addCriterionForJDBCDate("raisebegindate >", value, "raisebegindate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRaisebegindateGreaterThanOrEqualTo(java.util.Date value) {
      addCriterionForJDBCDate("raisebegindate >=", value, "raisebegindate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRaisebegindateLessThan(java.util.Date value) {
      addCriterionForJDBCDate("raisebegindate <", value, "raisebegindate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRaisebegindateLessThanOrEqualTo(java.util.Date value) {
      addCriterionForJDBCDate("raisebegindate <=", value, "raisebegindate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRaisebegindateIn(List<java.util.Date> values) {
      addCriterionForJDBCDate("raisebegindate in", values, "raisebegindate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRaisebegindateNotIn(List<java.util.Date> values) {
      addCriterionForJDBCDate("raisebegindate not in", values, "raisebegindate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRaisebegindateBetween(java.util.Date value1, java.util.Date value2) {
      addCriterionForJDBCDate("raisebegindate between", value1, value2, "raisebegindate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRaisebegindateNotBetween(java.util.Date value1, java.util.Date value2) {
      addCriterionForJDBCDate("raisebegindate not between", value1, value2, "raisebegindate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRaiseenddateIsNull() {
      addCriterion("raiseenddate is null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRaiseenddateIsNotNull() {
      addCriterion("raiseenddate is not null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRaiseenddateEqualTo(java.util.Date value) {
      addCriterionForJDBCDate("raiseenddate =", value, "raiseenddate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRaiseenddateNotEqualTo(java.util.Date value) {
      addCriterionForJDBCDate("raiseenddate <>", value, "raiseenddate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRaiseenddateGreaterThan(java.util.Date value) {
      addCriterionForJDBCDate("raiseenddate >", value, "raiseenddate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRaiseenddateGreaterThanOrEqualTo(java.util.Date value) {
      addCriterionForJDBCDate("raiseenddate >=", value, "raiseenddate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRaiseenddateLessThan(java.util.Date value) {
      addCriterionForJDBCDate("raiseenddate <", value, "raiseenddate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRaiseenddateLessThanOrEqualTo(java.util.Date value) {
      addCriterionForJDBCDate("raiseenddate <=", value, "raiseenddate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRaiseenddateIn(List<java.util.Date> values) {
      addCriterionForJDBCDate("raiseenddate in", values, "raiseenddate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRaiseenddateNotIn(List<java.util.Date> values) {
      addCriterionForJDBCDate("raiseenddate not in", values, "raiseenddate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRaiseenddateBetween(java.util.Date value1, java.util.Date value2) {
      addCriterionForJDBCDate("raiseenddate between", value1, value2, "raiseenddate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRaiseenddateNotBetween(java.util.Date value1, java.util.Date value2) {
      addCriterionForJDBCDate("raiseenddate not between", value1, value2, "raiseenddate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andExptinterestdateIsNull() {
      addCriterion("exptinterestdate is null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andExptinterestdateIsNotNull() {
      addCriterion("exptinterestdate is not null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andExptinterestdateEqualTo(java.util.Date value) {
      addCriterionForJDBCDate("exptinterestdate =", value, "exptinterestdate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andExptinterestdateNotEqualTo(java.util.Date value) {
      addCriterionForJDBCDate("exptinterestdate <>", value, "exptinterestdate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andExptinterestdateGreaterThan(java.util.Date value) {
      addCriterionForJDBCDate("exptinterestdate >", value, "exptinterestdate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andExptinterestdateGreaterThanOrEqualTo(java.util.Date value) {
      addCriterionForJDBCDate("exptinterestdate >=", value, "exptinterestdate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andExptinterestdateLessThan(java.util.Date value) {
      addCriterionForJDBCDate("exptinterestdate <", value, "exptinterestdate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andExptinterestdateLessThanOrEqualTo(java.util.Date value) {
      addCriterionForJDBCDate("exptinterestdate <=", value, "exptinterestdate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andExptinterestdateIn(List<java.util.Date> values) {
      addCriterionForJDBCDate("exptinterestdate in", values, "exptinterestdate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andExptinterestdateNotIn(List<java.util.Date> values) {
      addCriterionForJDBCDate("exptinterestdate not in", values, "exptinterestdate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andExptinterestdateBetween(java.util.Date value1, java.util.Date value2) {
      addCriterionForJDBCDate("exptinterestdate between", value1, value2, "exptinterestdate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andExptinterestdateNotBetween(java.util.Date value1, java.util.Date value2) {
      addCriterionForJDBCDate("exptinterestdate not between", value1, value2, "exptinterestdate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andExptexpiredateIsNull() {
      addCriterion("exptexpiredate is null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andExptexpiredateIsNotNull() {
      addCriterion("exptexpiredate is not null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andExptexpiredateEqualTo(java.util.Date value) {
      addCriterionForJDBCDate("exptexpiredate =", value, "exptexpiredate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andExptexpiredateNotEqualTo(java.util.Date value) {
      addCriterionForJDBCDate("exptexpiredate <>", value, "exptexpiredate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andExptexpiredateGreaterThan(java.util.Date value) {
      addCriterionForJDBCDate("exptexpiredate >", value, "exptexpiredate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andExptexpiredateGreaterThanOrEqualTo(java.util.Date value) {
      addCriterionForJDBCDate("exptexpiredate >=", value, "exptexpiredate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andExptexpiredateLessThan(java.util.Date value) {
      addCriterionForJDBCDate("exptexpiredate <", value, "exptexpiredate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andExptexpiredateLessThanOrEqualTo(java.util.Date value) {
      addCriterionForJDBCDate("exptexpiredate <=", value, "exptexpiredate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andExptexpiredateIn(List<java.util.Date> values) {
      addCriterionForJDBCDate("exptexpiredate in", values, "exptexpiredate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andExptexpiredateNotIn(List<java.util.Date> values) {
      addCriterionForJDBCDate("exptexpiredate not in", values, "exptexpiredate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andExptexpiredateBetween(java.util.Date value1, java.util.Date value2) {
      addCriterionForJDBCDate("exptexpiredate between", value1, value2, "exptexpiredate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andExptexpiredateNotBetween(java.util.Date value1, java.util.Date value2) {
      addCriterionForJDBCDate("exptexpiredate not between", value1, value2, "exptexpiredate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andAnnualizedrateIsNull() {
      addCriterion("annualizedrate is null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andAnnualizedrateIsNotNull() {
      addCriterion("annualizedrate is not null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andAnnualizedrateEqualTo(BigDecimal value) {
      addCriterion("annualizedrate =", value, "annualizedrate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andAnnualizedrateNotEqualTo(BigDecimal value) {
      addCriterion("annualizedrate <>", value, "annualizedrate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andAnnualizedrateGreaterThan(BigDecimal value) {
      addCriterion("annualizedrate >", value, "annualizedrate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andAnnualizedrateGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("annualizedrate >=", value, "annualizedrate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andAnnualizedrateLessThan(BigDecimal value) {
      addCriterion("annualizedrate <", value, "annualizedrate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andAnnualizedrateLessThanOrEqualTo(BigDecimal value) {
      addCriterion("annualizedrate <=", value, "annualizedrate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andAnnualizedrateIn(List<BigDecimal> values) {
      addCriterion("annualizedrate in", values, "annualizedrate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andAnnualizedrateNotIn(List<BigDecimal> values) {
      addCriterion("annualizedrate not in", values, "annualizedrate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andAnnualizedrateBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("annualizedrate between", value1, value2, "annualizedrate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andAnnualizedrateNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("annualizedrate not between", value1, value2, "annualizedrate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andIntestcalctypeidIsNull() {
      addCriterion("intestcalctypeid is null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andIntestcalctypeidIsNotNull() {
      addCriterion("intestcalctypeid is not null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andIntestcalctypeidEqualTo(Integer value) {
      addCriterion("intestcalctypeid =", value, "intestcalctypeid");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andIntestcalctypeidNotEqualTo(Integer value) {
      addCriterion("intestcalctypeid <>", value, "intestcalctypeid");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andIntestcalctypeidGreaterThan(Integer value) {
      addCriterion("intestcalctypeid >", value, "intestcalctypeid");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andIntestcalctypeidGreaterThanOrEqualTo(Integer value) {
      addCriterion("intestcalctypeid >=", value, "intestcalctypeid");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andIntestcalctypeidLessThan(Integer value) {
      addCriterion("intestcalctypeid <", value, "intestcalctypeid");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andIntestcalctypeidLessThanOrEqualTo(Integer value) {
      addCriterion("intestcalctypeid <=", value, "intestcalctypeid");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andIntestcalctypeidIn(List<Integer> values) {
      addCriterion("intestcalctypeid in", values, "intestcalctypeid");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andIntestcalctypeidNotIn(List<Integer> values) {
      addCriterion("intestcalctypeid not in", values, "intestcalctypeid");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andIntestcalctypeidBetween(Integer value1, Integer value2) {
      addCriterion("intestcalctypeid between", value1, value2, "intestcalctypeid");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andIntestcalctypeidNotBetween(Integer value1, Integer value2) {
      addCriterion("intestcalctypeid not between", value1, value2, "intestcalctypeid");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andIntestcalctypeIsNull() {
      addCriterion("intestcalctype is null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andIntestcalctypeIsNotNull() {
      addCriterion("intestcalctype is not null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andIntestcalctypeEqualTo(String value) {
      addCriterion("intestcalctype =", value, "intestcalctype");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andIntestcalctypeNotEqualTo(String value) {
      addCriterion("intestcalctype <>", value, "intestcalctype");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andIntestcalctypeGreaterThan(String value) {
      addCriterion("intestcalctype >", value, "intestcalctype");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andIntestcalctypeGreaterThanOrEqualTo(String value) {
      addCriterion("intestcalctype >=", value, "intestcalctype");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andIntestcalctypeLessThan(String value) {
      addCriterion("intestcalctype <", value, "intestcalctype");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andIntestcalctypeLessThanOrEqualTo(String value) {
      addCriterion("intestcalctype <=", value, "intestcalctype");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andIntestcalctypeLike(String value) {
      addCriterion("intestcalctype like", value, "intestcalctype");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andIntestcalctypeNotLike(String value) {
      addCriterion("intestcalctype not like", value, "intestcalctype");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andIntestcalctypeIn(List<String> values) {
      addCriterion("intestcalctype in", values, "intestcalctype");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andIntestcalctypeNotIn(List<String> values) {
      addCriterion("intestcalctype not in", values, "intestcalctype");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andIntestcalctypeBetween(String value1, String value2) {
      addCriterion("intestcalctype between", value1, value2, "intestcalctype");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andIntestcalctypeNotBetween(String value1, String value2) {
      addCriterion("intestcalctype not between", value1, value2, "intestcalctype");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andExptlastacctdateIsNull() {
      addCriterion("exptlastacctdate is null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andExptlastacctdateIsNotNull() {
      addCriterion("exptlastacctdate is not null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andExptlastacctdateEqualTo(java.util.Date value) {
      addCriterionForJDBCDate("exptlastacctdate =", value, "exptlastacctdate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andExptlastacctdateNotEqualTo(java.util.Date value) {
      addCriterionForJDBCDate("exptlastacctdate <>", value, "exptlastacctdate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andExptlastacctdateGreaterThan(java.util.Date value) {
      addCriterionForJDBCDate("exptlastacctdate >", value, "exptlastacctdate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andExptlastacctdateGreaterThanOrEqualTo(java.util.Date value) {
      addCriterionForJDBCDate("exptlastacctdate >=", value, "exptlastacctdate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andExptlastacctdateLessThan(java.util.Date value) {
      addCriterionForJDBCDate("exptlastacctdate <", value, "exptlastacctdate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andExptlastacctdateLessThanOrEqualTo(java.util.Date value) {
      addCriterionForJDBCDate("exptlastacctdate <=", value, "exptlastacctdate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andExptlastacctdateIn(List<java.util.Date> values) {
      addCriterionForJDBCDate("exptlastacctdate in", values, "exptlastacctdate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andExptlastacctdateNotIn(List<java.util.Date> values) {
      addCriterionForJDBCDate("exptlastacctdate not in", values, "exptlastacctdate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andExptlastacctdateBetween(java.util.Date value1, java.util.Date value2) {
      addCriterionForJDBCDate("exptlastacctdate between", value1, value2, "exptlastacctdate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andExptlastacctdateNotBetween(java.util.Date value1, java.util.Date value2) {
      addCriterionForJDBCDate("exptlastacctdate not between", value1, value2, "exptlastacctdate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andMininvestamountIsNull() {
      addCriterion("mininvestamount is null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andMininvestamountIsNotNull() {
      addCriterion("mininvestamount is not null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andMininvestamountEqualTo(BigDecimal value) {
      addCriterion("mininvestamount =", value, "mininvestamount");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andMininvestamountNotEqualTo(BigDecimal value) {
      addCriterion("mininvestamount <>", value, "mininvestamount");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andMininvestamountGreaterThan(BigDecimal value) {
      addCriterion("mininvestamount >", value, "mininvestamount");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andMininvestamountGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("mininvestamount >=", value, "mininvestamount");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andMininvestamountLessThan(BigDecimal value) {
      addCriterion("mininvestamount <", value, "mininvestamount");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andMininvestamountLessThanOrEqualTo(BigDecimal value) {
      addCriterion("mininvestamount <=", value, "mininvestamount");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andMininvestamountIn(List<BigDecimal> values) {
      addCriterion("mininvestamount in", values, "mininvestamount");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andMininvestamountNotIn(List<BigDecimal> values) {
      addCriterion("mininvestamount not in", values, "mininvestamount");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andMininvestamountBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("mininvestamount between", value1, value2, "mininvestamount");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andMininvestamountNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("mininvestamount not between", value1, value2, "mininvestamount");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andMaxinvestamountIsNull() {
      addCriterion("maxinvestamount is null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andMaxinvestamountIsNotNull() {
      addCriterion("maxinvestamount is not null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andMaxinvestamountEqualTo(BigDecimal value) {
      addCriterion("maxinvestamount =", value, "maxinvestamount");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andMaxinvestamountNotEqualTo(BigDecimal value) {
      addCriterion("maxinvestamount <>", value, "maxinvestamount");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andMaxinvestamountGreaterThan(BigDecimal value) {
      addCriterion("maxinvestamount >", value, "maxinvestamount");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andMaxinvestamountGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("maxinvestamount >=", value, "maxinvestamount");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andMaxinvestamountLessThan(BigDecimal value) {
      addCriterion("maxinvestamount <", value, "maxinvestamount");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andMaxinvestamountLessThanOrEqualTo(BigDecimal value) {
      addCriterion("maxinvestamount <=", value, "maxinvestamount");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andMaxinvestamountIn(List<BigDecimal> values) {
      addCriterion("maxinvestamount in", values, "maxinvestamount");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andMaxinvestamountNotIn(List<BigDecimal> values) {
      addCriterion("maxinvestamount not in", values, "maxinvestamount");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andMaxinvestamountBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("maxinvestamount between", value1, value2, "maxinvestamount");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andMaxinvestamountNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("maxinvestamount not between", value1, value2, "maxinvestamount");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andIfredeemIsNull() {
      addCriterion("ifredeem is null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andIfredeemIsNotNull() {
      addCriterion("ifredeem is not null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andIfredeemEqualTo(Integer value) {
      addCriterion("ifredeem =", value, "ifredeem");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andIfredeemNotEqualTo(Integer value) {
      addCriterion("ifredeem <>", value, "ifredeem");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andIfredeemGreaterThan(Integer value) {
      addCriterion("ifredeem >", value, "ifredeem");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andIfredeemGreaterThanOrEqualTo(Integer value) {
      addCriterion("ifredeem >=", value, "ifredeem");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andIfredeemLessThan(Integer value) {
      addCriterion("ifredeem <", value, "ifredeem");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andIfredeemLessThanOrEqualTo(Integer value) {
      addCriterion("ifredeem <=", value, "ifredeem");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andIfredeemIn(List<Integer> values) {
      addCriterion("ifredeem in", values, "ifredeem");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andIfredeemNotIn(List<Integer> values) {
      addCriterion("ifredeem not in", values, "ifredeem");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andIfredeemBetween(Integer value1, Integer value2) {
      addCriterion("ifredeem between", value1, value2, "ifredeem");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andIfredeemNotBetween(Integer value1, Integer value2) {
      addCriterion("ifredeem not between", value1, value2, "ifredeem");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRedeemfeetypeIsNull() {
      addCriterion("redeemfeetype is null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRedeemfeetypeIsNotNull() {
      addCriterion("redeemfeetype is not null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRedeemfeetypeEqualTo(Integer value) {
      addCriterion("redeemfeetype =", value, "redeemfeetype");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRedeemfeetypeNotEqualTo(Integer value) {
      addCriterion("redeemfeetype <>", value, "redeemfeetype");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRedeemfeetypeGreaterThan(Integer value) {
      addCriterion("redeemfeetype >", value, "redeemfeetype");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRedeemfeetypeGreaterThanOrEqualTo(Integer value) {
      addCriterion("redeemfeetype >=", value, "redeemfeetype");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRedeemfeetypeLessThan(Integer value) {
      addCriterion("redeemfeetype <", value, "redeemfeetype");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRedeemfeetypeLessThanOrEqualTo(Integer value) {
      addCriterion("redeemfeetype <=", value, "redeemfeetype");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRedeemfeetypeIn(List<Integer> values) {
      addCriterion("redeemfeetype in", values, "redeemfeetype");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRedeemfeetypeNotIn(List<Integer> values) {
      addCriterion("redeemfeetype not in", values, "redeemfeetype");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRedeemfeetypeBetween(Integer value1, Integer value2) {
      addCriterion("redeemfeetype between", value1, value2, "redeemfeetype");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRedeemfeetypeNotBetween(Integer value1, Integer value2) {
      addCriterion("redeemfeetype not between", value1, value2, "redeemfeetype");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRedeemfeeIsNull() {
      addCriterion("redeemfee is null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRedeemfeeIsNotNull() {
      addCriterion("redeemfee is not null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRedeemfeeEqualTo(BigDecimal value) {
      addCriterion("redeemfee =", value, "redeemfee");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRedeemfeeNotEqualTo(BigDecimal value) {
      addCriterion("redeemfee <>", value, "redeemfee");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRedeemfeeGreaterThan(BigDecimal value) {
      addCriterion("redeemfee >", value, "redeemfee");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRedeemfeeGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("redeemfee >=", value, "redeemfee");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRedeemfeeLessThan(BigDecimal value) {
      addCriterion("redeemfee <", value, "redeemfee");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRedeemfeeLessThanOrEqualTo(BigDecimal value) {
      addCriterion("redeemfee <=", value, "redeemfee");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRedeemfeeIn(List<BigDecimal> values) {
      addCriterion("redeemfee in", values, "redeemfee");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRedeemfeeNotIn(List<BigDecimal> values) {
      addCriterion("redeemfee not in", values, "redeemfee");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRedeemfeeBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("redeemfee between", value1, value2, "redeemfee");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRedeemfeeNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("redeemfee not between", value1, value2, "redeemfee");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andIftransferIsNull() {
      addCriterion("iftransfer is null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andIftransferIsNotNull() {
      addCriterion("iftransfer is not null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andIftransferEqualTo(Integer value) {
      addCriterion("iftransfer =", value, "iftransfer");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andIftransferNotEqualTo(Integer value) {
      addCriterion("iftransfer <>", value, "iftransfer");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andIftransferGreaterThan(Integer value) {
      addCriterion("iftransfer >", value, "iftransfer");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andIftransferGreaterThanOrEqualTo(Integer value) {
      addCriterion("iftransfer >=", value, "iftransfer");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andIftransferLessThan(Integer value) {
      addCriterion("iftransfer <", value, "iftransfer");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andIftransferLessThanOrEqualTo(Integer value) {
      addCriterion("iftransfer <=", value, "iftransfer");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andIftransferIn(List<Integer> values) {
      addCriterion("iftransfer in", values, "iftransfer");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andIftransferNotIn(List<Integer> values) {
      addCriterion("iftransfer not in", values, "iftransfer");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andIftransferBetween(Integer value1, Integer value2) {
      addCriterion("iftransfer between", value1, value2, "iftransfer");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andIftransferNotBetween(Integer value1, Integer value2) {
      addCriterion("iftransfer not between", value1, value2, "iftransfer");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andTransfertypeIsNull() {
      addCriterion("transfertype is null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andTransfertypeIsNotNull() {
      addCriterion("transfertype is not null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andTransfertypeEqualTo(Integer value) {
      addCriterion("transfertype =", value, "transfertype");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andTransfertypeNotEqualTo(Integer value) {
      addCriterion("transfertype <>", value, "transfertype");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andTransfertypeGreaterThan(Integer value) {
      addCriterion("transfertype >", value, "transfertype");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andTransfertypeGreaterThanOrEqualTo(Integer value) {
      addCriterion("transfertype >=", value, "transfertype");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andTransfertypeLessThan(Integer value) {
      addCriterion("transfertype <", value, "transfertype");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andTransfertypeLessThanOrEqualTo(Integer value) {
      addCriterion("transfertype <=", value, "transfertype");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andTransfertypeIn(List<Integer> values) {
      addCriterion("transfertype in", values, "transfertype");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andTransfertypeNotIn(List<Integer> values) {
      addCriterion("transfertype not in", values, "transfertype");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andTransfertypeBetween(Integer value1, Integer value2) {
      addCriterion("transfertype between", value1, value2, "transfertype");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andTransfertypeNotBetween(Integer value1, Integer value2) {
      addCriterion("transfertype not between", value1, value2, "transfertype");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andTransfeeIsNull() {
      addCriterion("transfee is null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andTransfeeIsNotNull() {
      addCriterion("transfee is not null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andTransfeeEqualTo(BigDecimal value) {
      addCriterion("transfee =", value, "transfee");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andTransfeeNotEqualTo(BigDecimal value) {
      addCriterion("transfee <>", value, "transfee");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andTransfeeGreaterThan(BigDecimal value) {
      addCriterion("transfee >", value, "transfee");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andTransfeeGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("transfee >=", value, "transfee");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andTransfeeLessThan(BigDecimal value) {
      addCriterion("transfee <", value, "transfee");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andTransfeeLessThanOrEqualTo(BigDecimal value) {
      addCriterion("transfee <=", value, "transfee");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andTransfeeIn(List<BigDecimal> values) {
      addCriterion("transfee in", values, "transfee");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andTransfeeNotIn(List<BigDecimal> values) {
      addCriterion("transfee not in", values, "transfee");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andTransfeeBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("transfee between", value1, value2, "transfee");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andTransfeeNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("transfee not between", value1, value2, "transfee");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andPledgetypeIsNull() {
      addCriterion("pledgetype is null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andPledgetypeIsNotNull() {
      addCriterion("pledgetype is not null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andPledgetypeEqualTo(String value) {
      addCriterion("pledgetype =", value, "pledgetype");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andPledgetypeNotEqualTo(String value) {
      addCriterion("pledgetype <>", value, "pledgetype");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andPledgetypeGreaterThan(String value) {
      addCriterion("pledgetype >", value, "pledgetype");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andPledgetypeGreaterThanOrEqualTo(String value) {
      addCriterion("pledgetype >=", value, "pledgetype");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andPledgetypeLessThan(String value) {
      addCriterion("pledgetype <", value, "pledgetype");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andPledgetypeLessThanOrEqualTo(String value) {
      addCriterion("pledgetype <=", value, "pledgetype");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andPledgetypeLike(String value) {
      addCriterion("pledgetype like", value, "pledgetype");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andPledgetypeNotLike(String value) {
      addCriterion("pledgetype not like", value, "pledgetype");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andPledgetypeIn(List<String> values) {
      addCriterion("pledgetype in", values, "pledgetype");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andPledgetypeNotIn(List<String> values) {
      addCriterion("pledgetype not in", values, "pledgetype");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andPledgetypeBetween(String value1, String value2) {
      addCriterion("pledgetype between", value1, value2, "pledgetype");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andPledgetypeNotBetween(String value1, String value2) {
      addCriterion("pledgetype not between", value1, value2, "pledgetype");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBorrowercodeIsNull() {
      addCriterion("borrowerCode is null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBorrowercodeIsNotNull() {
      addCriterion("borrowerCode is not null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBorrowercodeEqualTo(String value) {
      addCriterion("borrowerCode =", value, "borrowercode");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBorrowercodeNotEqualTo(String value) {
      addCriterion("borrowerCode <>", value, "borrowercode");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBorrowercodeGreaterThan(String value) {
      addCriterion("borrowerCode >", value, "borrowercode");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBorrowercodeGreaterThanOrEqualTo(String value) {
      addCriterion("borrowerCode >=", value, "borrowercode");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBorrowercodeLessThan(String value) {
      addCriterion("borrowerCode <", value, "borrowercode");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBorrowercodeLessThanOrEqualTo(String value) {
      addCriterion("borrowerCode <=", value, "borrowercode");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBorrowercodeLike(String value) {
      addCriterion("borrowerCode like", value, "borrowercode");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBorrowercodeNotLike(String value) {
      addCriterion("borrowerCode not like", value, "borrowercode");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBorrowercodeIn(List<String> values) {
      addCriterion("borrowerCode in", values, "borrowercode");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBorrowercodeNotIn(List<String> values) {
      addCriterion("borrowerCode not in", values, "borrowercode");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBorrowercodeBetween(String value1, String value2) {
      addCriterion("borrowerCode between", value1, value2, "borrowercode");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBorrowercodeNotBetween(String value1, String value2) {
      addCriterion("borrowerCode not between", value1, value2, "borrowercode");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBorrowernameIsNull() {
      addCriterion("borrowername is null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBorrowernameIsNotNull() {
      addCriterion("borrowername is not null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBorrowernameEqualTo(String value) {
      addCriterion("borrowername =", value, "borrowername");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBorrowernameNotEqualTo(String value) {
      addCriterion("borrowername <>", value, "borrowername");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBorrowernameGreaterThan(String value) {
      addCriterion("borrowername >", value, "borrowername");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBorrowernameGreaterThanOrEqualTo(String value) {
      addCriterion("borrowername >=", value, "borrowername");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBorrowernameLessThan(String value) {
      addCriterion("borrowername <", value, "borrowername");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBorrowernameLessThanOrEqualTo(String value) {
      addCriterion("borrowername <=", value, "borrowername");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBorrowernameLike(String value) {
      addCriterion("borrowername like", value, "borrowername");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBorrowernameNotLike(String value) {
      addCriterion("borrowername not like", value, "borrowername");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBorrowernameIn(List<String> values) {
      addCriterion("borrowername in", values, "borrowername");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBorrowernameNotIn(List<String> values) {
      addCriterion("borrowername not in", values, "borrowername");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBorrowernameBetween(String value1, String value2) {
      addCriterion("borrowername between", value1, value2, "borrowername");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBorrowernameNotBetween(String value1, String value2) {
      addCriterion("borrowername not between", value1, value2, "borrowername");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBorrowerdescIsNull() {
      addCriterion("borrowerdesc is null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBorrowerdescIsNotNull() {
      addCriterion("borrowerdesc is not null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBorrowerdescEqualTo(String value) {
      addCriterion("borrowerdesc =", value, "borrowerdesc");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBorrowerdescNotEqualTo(String value) {
      addCriterion("borrowerdesc <>", value, "borrowerdesc");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBorrowerdescGreaterThan(String value) {
      addCriterion("borrowerdesc >", value, "borrowerdesc");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBorrowerdescGreaterThanOrEqualTo(String value) {
      addCriterion("borrowerdesc >=", value, "borrowerdesc");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBorrowerdescLessThan(String value) {
      addCriterion("borrowerdesc <", value, "borrowerdesc");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBorrowerdescLessThanOrEqualTo(String value) {
      addCriterion("borrowerdesc <=", value, "borrowerdesc");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBorrowerdescLike(String value) {
      addCriterion("borrowerdesc like", value, "borrowerdesc");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBorrowerdescNotLike(String value) {
      addCriterion("borrowerdesc not like", value, "borrowerdesc");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBorrowerdescIn(List<String> values) {
      addCriterion("borrowerdesc in", values, "borrowerdesc");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBorrowerdescNotIn(List<String> values) {
      addCriterion("borrowerdesc not in", values, "borrowerdesc");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBorrowerdescBetween(String value1, String value2) {
      addCriterion("borrowerdesc between", value1, value2, "borrowerdesc");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBorrowerdescNotBetween(String value1, String value2) {
      addCriterion("borrowerdesc not between", value1, value2, "borrowerdesc");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBorrowerinterestIsNull() {
      addCriterion("borrowerinterest is null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBorrowerinterestIsNotNull() {
      addCriterion("borrowerinterest is not null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBorrowerinterestEqualTo(BigDecimal value) {
      addCriterion("borrowerinterest =", value, "borrowerinterest");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBorrowerinterestNotEqualTo(BigDecimal value) {
      addCriterion("borrowerinterest <>", value, "borrowerinterest");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBorrowerinterestGreaterThan(BigDecimal value) {
      addCriterion("borrowerinterest >", value, "borrowerinterest");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBorrowerinterestGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("borrowerinterest >=", value, "borrowerinterest");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBorrowerinterestLessThan(BigDecimal value) {
      addCriterion("borrowerinterest <", value, "borrowerinterest");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBorrowerinterestLessThanOrEqualTo(BigDecimal value) {
      addCriterion("borrowerinterest <=", value, "borrowerinterest");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBorrowerinterestIn(List<BigDecimal> values) {
      addCriterion("borrowerinterest in", values, "borrowerinterest");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBorrowerinterestNotIn(List<BigDecimal> values) {
      addCriterion("borrowerinterest not in", values, "borrowerinterest");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBorrowerinterestBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("borrowerinterest between", value1, value2, "borrowerinterest");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBorrowerinterestNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("borrowerinterest not between", value1, value2, "borrowerinterest");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andInstcodeIsNull() {
      addCriterion("instCode is null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andInstcodeIsNotNull() {
      addCriterion("instCode is not null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andInstcodeEqualTo(String value) {
      addCriterion("instCode =", value, "instcode");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andInstcodeNotEqualTo(String value) {
      addCriterion("instCode <>", value, "instcode");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andInstcodeGreaterThan(String value) {
      addCriterion("instCode >", value, "instcode");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andInstcodeGreaterThanOrEqualTo(String value) {
      addCriterion("instCode >=", value, "instcode");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andInstcodeLessThan(String value) {
      addCriterion("instCode <", value, "instcode");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andInstcodeLessThanOrEqualTo(String value) {
      addCriterion("instCode <=", value, "instcode");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andInstcodeLike(String value) {
      addCriterion("instCode like", value, "instcode");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andInstcodeNotLike(String value) {
      addCriterion("instCode not like", value, "instcode");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andInstcodeIn(List<String> values) {
      addCriterion("instCode in", values, "instcode");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andInstcodeNotIn(List<String> values) {
      addCriterion("instCode not in", values, "instcode");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andInstcodeBetween(String value1, String value2) {
      addCriterion("instCode between", value1, value2, "instcode");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andInstcodeNotBetween(String value1, String value2) {
      addCriterion("instCode not between", value1, value2, "instcode");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andAssureinstnameIsNull() {
      addCriterion("assureinstname is null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andAssureinstnameIsNotNull() {
      addCriterion("assureinstname is not null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andAssureinstnameEqualTo(String value) {
      addCriterion("assureinstname =", value, "assureinstname");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andAssureinstnameNotEqualTo(String value) {
      addCriterion("assureinstname <>", value, "assureinstname");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andAssureinstnameGreaterThan(String value) {
      addCriterion("assureinstname >", value, "assureinstname");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andAssureinstnameGreaterThanOrEqualTo(String value) {
      addCriterion("assureinstname >=", value, "assureinstname");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andAssureinstnameLessThan(String value) {
      addCriterion("assureinstname <", value, "assureinstname");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andAssureinstnameLessThanOrEqualTo(String value) {
      addCriterion("assureinstname <=", value, "assureinstname");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andAssureinstnameLike(String value) {
      addCriterion("assureinstname like", value, "assureinstname");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andAssureinstnameNotLike(String value) {
      addCriterion("assureinstname not like", value, "assureinstname");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andAssureinstnameIn(List<String> values) {
      addCriterion("assureinstname in", values, "assureinstname");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andAssureinstnameNotIn(List<String> values) {
      addCriterion("assureinstname not in", values, "assureinstname");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andAssureinstnameBetween(String value1, String value2) {
      addCriterion("assureinstname between", value1, value2, "assureinstname");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andAssureinstnameNotBetween(String value1, String value2) {
      addCriterion("assureinstname not between", value1, value2, "assureinstname");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andEnsuretypeIsNull() {
      addCriterion("ensuretype is null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andEnsuretypeIsNotNull() {
      addCriterion("ensuretype is not null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andEnsuretypeEqualTo(String value) {
      addCriterion("ensuretype =", value, "ensuretype");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andEnsuretypeNotEqualTo(String value) {
      addCriterion("ensuretype <>", value, "ensuretype");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andEnsuretypeGreaterThan(String value) {
      addCriterion("ensuretype >", value, "ensuretype");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andEnsuretypeGreaterThanOrEqualTo(String value) {
      addCriterion("ensuretype >=", value, "ensuretype");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andEnsuretypeLessThan(String value) {
      addCriterion("ensuretype <", value, "ensuretype");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andEnsuretypeLessThanOrEqualTo(String value) {
      addCriterion("ensuretype <=", value, "ensuretype");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andEnsuretypeLike(String value) {
      addCriterion("ensuretype like", value, "ensuretype");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andEnsuretypeNotLike(String value) {
      addCriterion("ensuretype not like", value, "ensuretype");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andEnsuretypeIn(List<String> values) {
      addCriterion("ensuretype in", values, "ensuretype");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andEnsuretypeNotIn(List<String> values) {
      addCriterion("ensuretype not in", values, "ensuretype");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andEnsuretypeBetween(String value1, String value2) {
      addCriterion("ensuretype between", value1, value2, "ensuretype");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andEnsuretypeNotBetween(String value1, String value2) {
      addCriterion("ensuretype not between", value1, value2, "ensuretype");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andAgreement1IsNull() {
      addCriterion("agreement1 is null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andAgreement1IsNotNull() {
      addCriterion("agreement1 is not null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andAgreement1EqualTo(Integer value) {
      addCriterion("agreement1 =", value, "agreement1");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andAgreement1NotEqualTo(Integer value) {
      addCriterion("agreement1 <>", value, "agreement1");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andAgreement1GreaterThan(Integer value) {
      addCriterion("agreement1 >", value, "agreement1");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andAgreement1GreaterThanOrEqualTo(Integer value) {
      addCriterion("agreement1 >=", value, "agreement1");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andAgreement1LessThan(Integer value) {
      addCriterion("agreement1 <", value, "agreement1");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andAgreement1LessThanOrEqualTo(Integer value) {
      addCriterion("agreement1 <=", value, "agreement1");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andAgreement1In(List<Integer> values) {
      addCriterion("agreement1 in", values, "agreement1");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andAgreement1NotIn(List<Integer> values) {
      addCriterion("agreement1 not in", values, "agreement1");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andAgreement1Between(Integer value1, Integer value2) {
      addCriterion("agreement1 between", value1, value2, "agreement1");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andAgreement1NotBetween(Integer value1, Integer value2) {
      addCriterion("agreement1 not between", value1, value2, "agreement1");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andAgreement2IsNull() {
      addCriterion("agreement2 is null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andAgreement2IsNotNull() {
      addCriterion("agreement2 is not null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andAgreement2EqualTo(Integer value) {
      addCriterion("agreement2 =", value, "agreement2");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andAgreement2NotEqualTo(Integer value) {
      addCriterion("agreement2 <>", value, "agreement2");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andAgreement2GreaterThan(Integer value) {
      addCriterion("agreement2 >", value, "agreement2");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andAgreement2GreaterThanOrEqualTo(Integer value) {
      addCriterion("agreement2 >=", value, "agreement2");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andAgreement2LessThan(Integer value) {
      addCriterion("agreement2 <", value, "agreement2");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andAgreement2LessThanOrEqualTo(Integer value) {
      addCriterion("agreement2 <=", value, "agreement2");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andAgreement2In(List<Integer> values) {
      addCriterion("agreement2 in", values, "agreement2");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andAgreement2NotIn(List<Integer> values) {
      addCriterion("agreement2 not in", values, "agreement2");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andAgreement2Between(Integer value1, Integer value2) {
      addCriterion("agreement2 between", value1, value2, "agreement2");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andAgreement2NotBetween(Integer value1, Integer value2) {
      addCriterion("agreement2 not between", value1, value2, "agreement2");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andAgreement3IsNull() {
      addCriterion("agreement3 is null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andAgreement3IsNotNull() {
      addCriterion("agreement3 is not null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andAgreement3EqualTo(Integer value) {
      addCriterion("agreement3 =", value, "agreement3");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andAgreement3NotEqualTo(Integer value) {
      addCriterion("agreement3 <>", value, "agreement3");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andAgreement3GreaterThan(Integer value) {
      addCriterion("agreement3 >", value, "agreement3");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andAgreement3GreaterThanOrEqualTo(Integer value) {
      addCriterion("agreement3 >=", value, "agreement3");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andAgreement3LessThan(Integer value) {
      addCriterion("agreement3 <", value, "agreement3");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andAgreement3LessThanOrEqualTo(Integer value) {
      addCriterion("agreement3 <=", value, "agreement3");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andAgreement3In(List<Integer> values) {
      addCriterion("agreement3 in", values, "agreement3");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andAgreement3NotIn(List<Integer> values) {
      addCriterion("agreement3 not in", values, "agreement3");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andAgreement3Between(Integer value1, Integer value2) {
      addCriterion("agreement3 between", value1, value2, "agreement3");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andAgreement3NotBetween(Integer value1, Integer value2) {
      addCriterion("agreement3 not between", value1, value2, "agreement3");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRaisemoneyIsNull() {
      addCriterion("raisemoney is null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRaisemoneyIsNotNull() {
      addCriterion("raisemoney is not null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRaisemoneyEqualTo(BigDecimal value) {
      addCriterion("raisemoney =", value, "raisemoney");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRaisemoneyNotEqualTo(BigDecimal value) {
      addCriterion("raisemoney <>", value, "raisemoney");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRaisemoneyGreaterThan(BigDecimal value) {
      addCriterion("raisemoney >", value, "raisemoney");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRaisemoneyGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("raisemoney >=", value, "raisemoney");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRaisemoneyLessThan(BigDecimal value) {
      addCriterion("raisemoney <", value, "raisemoney");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRaisemoneyLessThanOrEqualTo(BigDecimal value) {
      addCriterion("raisemoney <=", value, "raisemoney");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRaisemoneyIn(List<BigDecimal> values) {
      addCriterion("raisemoney in", values, "raisemoney");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRaisemoneyNotIn(List<BigDecimal> values) {
      addCriterion("raisemoney not in", values, "raisemoney");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRaisemoneyBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("raisemoney between", value1, value2, "raisemoney");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRaisemoneyNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("raisemoney not between", value1, value2, "raisemoney");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRaisestateIsNull() {
      addCriterion("raisestate is null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRaisestateIsNotNull() {
      addCriterion("raisestate is not null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRaisestateEqualTo(Integer value) {
      addCriterion("raisestate =", value, "raisestate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRaisestateNotEqualTo(Integer value) {
      addCriterion("raisestate <>", value, "raisestate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRaisestateGreaterThan(Integer value) {
      addCriterion("raisestate >", value, "raisestate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRaisestateGreaterThanOrEqualTo(Integer value) {
      addCriterion("raisestate >=", value, "raisestate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRaisestateLessThan(Integer value) {
      addCriterion("raisestate <", value, "raisestate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRaisestateLessThanOrEqualTo(Integer value) {
      addCriterion("raisestate <=", value, "raisestate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRaisestateIn(List<Integer> values) {
      addCriterion("raisestate in", values, "raisestate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRaisestateNotIn(List<Integer> values) {
      addCriterion("raisestate not in", values, "raisestate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRaisestateBetween(Integer value1, Integer value2) {
      addCriterion("raisestate between", value1, value2, "raisestate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRaisestateNotBetween(Integer value1, Integer value2) {
      addCriterion("raisestate not between", value1, value2, "raisestate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRepaymentwayIsNull() {
      addCriterion("repaymentway is null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRepaymentwayIsNotNull() {
      addCriterion("repaymentway is not null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRepaymentwayEqualTo(String value) {
      addCriterion("repaymentway =", value, "repaymentway");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRepaymentwayNotEqualTo(String value) {
      addCriterion("repaymentway <>", value, "repaymentway");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRepaymentwayGreaterThan(String value) {
      addCriterion("repaymentway >", value, "repaymentway");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRepaymentwayGreaterThanOrEqualTo(String value) {
      addCriterion("repaymentway >=", value, "repaymentway");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRepaymentwayLessThan(String value) {
      addCriterion("repaymentway <", value, "repaymentway");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRepaymentwayLessThanOrEqualTo(String value) {
      addCriterion("repaymentway <=", value, "repaymentway");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRepaymentwayLike(String value) {
      addCriterion("repaymentway like", value, "repaymentway");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRepaymentwayNotLike(String value) {
      addCriterion("repaymentway not like", value, "repaymentway");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRepaymentwayIn(List<String> values) {
      addCriterion("repaymentway in", values, "repaymentway");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRepaymentwayNotIn(List<String> values) {
      addCriterion("repaymentway not in", values, "repaymentway");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRepaymentwayBetween(String value1, String value2) {
      addCriterion("repaymentway between", value1, value2, "repaymentway");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRepaymentwayNotBetween(String value1, String value2) {
      addCriterion("repaymentway not between", value1, value2, "repaymentway");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBindinnernoIsNull() {
      addCriterion("bindinnerno is null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBindinnernoIsNotNull() {
      addCriterion("bindinnerno is not null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBindinnernoEqualTo(String value) {
      addCriterion("bindinnerno =", value, "bindinnerno");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBindinnernoNotEqualTo(String value) {
      addCriterion("bindinnerno <>", value, "bindinnerno");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBindinnernoGreaterThan(String value) {
      addCriterion("bindinnerno >", value, "bindinnerno");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBindinnernoGreaterThanOrEqualTo(String value) {
      addCriterion("bindinnerno >=", value, "bindinnerno");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBindinnernoLessThan(String value) {
      addCriterion("bindinnerno <", value, "bindinnerno");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBindinnernoLessThanOrEqualTo(String value) {
      addCriterion("bindinnerno <=", value, "bindinnerno");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBindinnernoLike(String value) {
      addCriterion("bindinnerno like", value, "bindinnerno");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBindinnernoNotLike(String value) {
      addCriterion("bindinnerno not like", value, "bindinnerno");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBindinnernoIn(List<String> values) {
      addCriterion("bindinnerno in", values, "bindinnerno");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBindinnernoNotIn(List<String> values) {
      addCriterion("bindinnerno not in", values, "bindinnerno");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBindinnernoBetween(String value1, String value2) {
      addCriterion("bindinnerno between", value1, value2, "bindinnerno");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBindinnernoNotBetween(String value1, String value2) {
      addCriterion("bindinnerno not between", value1, value2, "bindinnerno");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidclassintroIsNull() {
      addCriterion("bidclassintro is null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidclassintroIsNotNull() {
      addCriterion("bidclassintro is not null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidclassintroEqualTo(String value) {
      addCriterion("bidclassintro =", value, "bidclassintro");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidclassintroNotEqualTo(String value) {
      addCriterion("bidclassintro <>", value, "bidclassintro");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidclassintroGreaterThan(String value) {
      addCriterion("bidclassintro >", value, "bidclassintro");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidclassintroGreaterThanOrEqualTo(String value) {
      addCriterion("bidclassintro >=", value, "bidclassintro");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidclassintroLessThan(String value) {
      addCriterion("bidclassintro <", value, "bidclassintro");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidclassintroLessThanOrEqualTo(String value) {
      addCriterion("bidclassintro <=", value, "bidclassintro");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidclassintroLike(String value) {
      addCriterion("bidclassintro like", value, "bidclassintro");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidclassintroNotLike(String value) {
      addCriterion("bidclassintro not like", value, "bidclassintro");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidclassintroIn(List<String> values) {
      addCriterion("bidclassintro in", values, "bidclassintro");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidclassintroNotIn(List<String> values) {
      addCriterion("bidclassintro not in", values, "bidclassintro");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidclassintroBetween(String value1, String value2) {
      addCriterion("bidclassintro between", value1, value2, "bidclassintro");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidclassintroNotBetween(String value1, String value2) {
      addCriterion("bidclassintro not between", value1, value2, "bidclassintro");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andInvestscopeIsNull() {
      addCriterion("investscope is null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andInvestscopeIsNotNull() {
      addCriterion("investscope is not null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andInvestscopeEqualTo(String value) {
      addCriterion("investscope =", value, "investscope");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andInvestscopeNotEqualTo(String value) {
      addCriterion("investscope <>", value, "investscope");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andInvestscopeGreaterThan(String value) {
      addCriterion("investscope >", value, "investscope");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andInvestscopeGreaterThanOrEqualTo(String value) {
      addCriterion("investscope >=", value, "investscope");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andInvestscopeLessThan(String value) {
      addCriterion("investscope <", value, "investscope");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andInvestscopeLessThanOrEqualTo(String value) {
      addCriterion("investscope <=", value, "investscope");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andInvestscopeLike(String value) {
      addCriterion("investscope like", value, "investscope");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andInvestscopeNotLike(String value) {
      addCriterion("investscope not like", value, "investscope");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andInvestscopeIn(List<String> values) {
      addCriterion("investscope in", values, "investscope");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andInvestscopeNotIn(List<String> values) {
      addCriterion("investscope not in", values, "investscope");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andInvestscopeBetween(String value1, String value2) {
      addCriterion("investscope between", value1, value2, "investscope");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andInvestscopeNotBetween(String value1, String value2) {
      addCriterion("investscope not between", value1, value2, "investscope");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andIncomedescIsNull() {
      addCriterion("incomedesc is null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andIncomedescIsNotNull() {
      addCriterion("incomedesc is not null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andIncomedescEqualTo(String value) {
      addCriterion("incomedesc =", value, "incomedesc");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andIncomedescNotEqualTo(String value) {
      addCriterion("incomedesc <>", value, "incomedesc");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andIncomedescGreaterThan(String value) {
      addCriterion("incomedesc >", value, "incomedesc");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andIncomedescGreaterThanOrEqualTo(String value) {
      addCriterion("incomedesc >=", value, "incomedesc");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andIncomedescLessThan(String value) {
      addCriterion("incomedesc <", value, "incomedesc");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andIncomedescLessThanOrEqualTo(String value) {
      addCriterion("incomedesc <=", value, "incomedesc");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andIncomedescLike(String value) {
      addCriterion("incomedesc like", value, "incomedesc");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andIncomedescNotLike(String value) {
      addCriterion("incomedesc not like", value, "incomedesc");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andIncomedescIn(List<String> values) {
      addCriterion("incomedesc in", values, "incomedesc");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andIncomedescNotIn(List<String> values) {
      addCriterion("incomedesc not in", values, "incomedesc");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andIncomedescBetween(String value1, String value2) {
      addCriterion("incomedesc between", value1, value2, "incomedesc");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andIncomedescNotBetween(String value1, String value2) {
      addCriterion("incomedesc not between", value1, value2, "incomedesc");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andIncomewayIsNull() {
      addCriterion("incomeway is null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andIncomewayIsNotNull() {
      addCriterion("incomeway is not null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andIncomewayEqualTo(Integer value) {
      addCriterion("incomeway =", value, "incomeway");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andIncomewayNotEqualTo(Integer value) {
      addCriterion("incomeway <>", value, "incomeway");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andIncomewayGreaterThan(Integer value) {
      addCriterion("incomeway >", value, "incomeway");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andIncomewayGreaterThanOrEqualTo(Integer value) {
      addCriterion("incomeway >=", value, "incomeway");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andIncomewayLessThan(Integer value) {
      addCriterion("incomeway <", value, "incomeway");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andIncomewayLessThanOrEqualTo(Integer value) {
      addCriterion("incomeway <=", value, "incomeway");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andIncomewayIn(List<Integer> values) {
      addCriterion("incomeway in", values, "incomeway");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andIncomewayNotIn(List<Integer> values) {
      addCriterion("incomeway not in", values, "incomeway");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andIncomewayBetween(Integer value1, Integer value2) {
      addCriterion("incomeway between", value1, value2, "incomeway");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andIncomewayNotBetween(Integer value1, Integer value2) {
      addCriterion("incomeway not between", value1, value2, "incomeway");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRaisecondIsNull() {
      addCriterion("raisecond is null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRaisecondIsNotNull() {
      addCriterion("raisecond is not null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRaisecondEqualTo(String value) {
      addCriterion("raisecond =", value, "raisecond");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRaisecondNotEqualTo(String value) {
      addCriterion("raisecond <>", value, "raisecond");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRaisecondGreaterThan(String value) {
      addCriterion("raisecond >", value, "raisecond");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRaisecondGreaterThanOrEqualTo(String value) {
      addCriterion("raisecond >=", value, "raisecond");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRaisecondLessThan(String value) {
      addCriterion("raisecond <", value, "raisecond");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRaisecondLessThanOrEqualTo(String value) {
      addCriterion("raisecond <=", value, "raisecond");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRaisecondLike(String value) {
      addCriterion("raisecond like", value, "raisecond");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRaisecondNotLike(String value) {
      addCriterion("raisecond not like", value, "raisecond");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRaisecondIn(List<String> values) {
      addCriterion("raisecond in", values, "raisecond");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRaisecondNotIn(List<String> values) {
      addCriterion("raisecond not in", values, "raisecond");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRaisecondBetween(String value1, String value2) {
      addCriterion("raisecond between", value1, value2, "raisecond");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRaisecondNotBetween(String value1, String value2) {
      addCriterion("raisecond not between", value1, value2, "raisecond");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRedeemwayIsNull() {
      addCriterion("redeemway is null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRedeemwayIsNotNull() {
      addCriterion("redeemway is not null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRedeemwayEqualTo(String value) {
      addCriterion("redeemway =", value, "redeemway");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRedeemwayNotEqualTo(String value) {
      addCriterion("redeemway <>", value, "redeemway");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRedeemwayGreaterThan(String value) {
      addCriterion("redeemway >", value, "redeemway");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRedeemwayGreaterThanOrEqualTo(String value) {
      addCriterion("redeemway >=", value, "redeemway");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRedeemwayLessThan(String value) {
      addCriterion("redeemway <", value, "redeemway");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRedeemwayLessThanOrEqualTo(String value) {
      addCriterion("redeemway <=", value, "redeemway");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRedeemwayLike(String value) {
      addCriterion("redeemway like", value, "redeemway");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRedeemwayNotLike(String value) {
      addCriterion("redeemway not like", value, "redeemway");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRedeemwayIn(List<String> values) {
      addCriterion("redeemway in", values, "redeemway");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRedeemwayNotIn(List<String> values) {
      addCriterion("redeemway not in", values, "redeemway");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRedeemwayBetween(String value1, String value2) {
      addCriterion("redeemway between", value1, value2, "redeemway");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRedeemwayNotBetween(String value1, String value2) {
      addCriterion("redeemway not between", value1, value2, "redeemway");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRaiserateIsNull() {
      addCriterion("raiserate is null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRaiserateIsNotNull() {
      addCriterion("raiserate is not null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRaiserateEqualTo(BigDecimal value) {
      addCriterion("raiserate =", value, "raiserate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRaiserateNotEqualTo(BigDecimal value) {
      addCriterion("raiserate <>", value, "raiserate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRaiserateGreaterThan(BigDecimal value) {
      addCriterion("raiserate >", value, "raiserate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRaiserateGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("raiserate >=", value, "raiserate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRaiserateLessThan(BigDecimal value) {
      addCriterion("raiserate <", value, "raiserate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRaiserateLessThanOrEqualTo(BigDecimal value) {
      addCriterion("raiserate <=", value, "raiserate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRaiserateIn(List<BigDecimal> values) {
      addCriterion("raiserate in", values, "raiserate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRaiserateNotIn(List<BigDecimal> values) {
      addCriterion("raiserate not in", values, "raiserate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRaiserateBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("raiserate between", value1, value2, "raiserate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRaiserateNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("raiserate not between", value1, value2, "raiserate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRedemrateIsNull() {
      addCriterion("redemrate is null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRedemrateIsNotNull() {
      addCriterion("redemrate is not null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRedemrateEqualTo(BigDecimal value) {
      addCriterion("redemrate =", value, "redemrate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRedemrateNotEqualTo(BigDecimal value) {
      addCriterion("redemrate <>", value, "redemrate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRedemrateGreaterThan(BigDecimal value) {
      addCriterion("redemrate >", value, "redemrate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRedemrateGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("redemrate >=", value, "redemrate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRedemrateLessThan(BigDecimal value) {
      addCriterion("redemrate <", value, "redemrate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRedemrateLessThanOrEqualTo(BigDecimal value) {
      addCriterion("redemrate <=", value, "redemrate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRedemrateIn(List<BigDecimal> values) {
      addCriterion("redemrate in", values, "redemrate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRedemrateNotIn(List<BigDecimal> values) {
      addCriterion("redemrate not in", values, "redemrate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRedemrateBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("redemrate between", value1, value2, "redemrate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRedemrateNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("redemrate not between", value1, value2, "redemrate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andTransrateIsNull() {
      addCriterion("transrate is null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andTransrateIsNotNull() {
      addCriterion("transrate is not null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andTransrateEqualTo(BigDecimal value) {
      addCriterion("transrate =", value, "transrate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andTransrateNotEqualTo(BigDecimal value) {
      addCriterion("transrate <>", value, "transrate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andTransrateGreaterThan(BigDecimal value) {
      addCriterion("transrate >", value, "transrate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andTransrateGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("transrate >=", value, "transrate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andTransrateLessThan(BigDecimal value) {
      addCriterion("transrate <", value, "transrate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andTransrateLessThanOrEqualTo(BigDecimal value) {
      addCriterion("transrate <=", value, "transrate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andTransrateIn(List<BigDecimal> values) {
      addCriterion("transrate in", values, "transrate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andTransrateNotIn(List<BigDecimal> values) {
      addCriterion("transrate not in", values, "transrate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andTransrateBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("transrate between", value1, value2, "transrate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andTransrateNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("transrate not between", value1, value2, "transrate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andPrepayrateIsNull() {
      addCriterion("prepayrate is null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andPrepayrateIsNotNull() {
      addCriterion("prepayrate is not null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andPrepayrateEqualTo(BigDecimal value) {
      addCriterion("prepayrate =", value, "prepayrate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andPrepayrateNotEqualTo(BigDecimal value) {
      addCriterion("prepayrate <>", value, "prepayrate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andPrepayrateGreaterThan(BigDecimal value) {
      addCriterion("prepayrate >", value, "prepayrate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andPrepayrateGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("prepayrate >=", value, "prepayrate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andPrepayrateLessThan(BigDecimal value) {
      addCriterion("prepayrate <", value, "prepayrate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andPrepayrateLessThanOrEqualTo(BigDecimal value) {
      addCriterion("prepayrate <=", value, "prepayrate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andPrepayrateIn(List<BigDecimal> values) {
      addCriterion("prepayrate in", values, "prepayrate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andPrepayrateNotIn(List<BigDecimal> values) {
      addCriterion("prepayrate not in", values, "prepayrate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andPrepayrateBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("prepayrate between", value1, value2, "prepayrate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andPrepayrateNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("prepayrate not between", value1, value2, "prepayrate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andReceiptdescIsNull() {
      addCriterion("receiptdesc is null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andReceiptdescIsNotNull() {
      addCriterion("receiptdesc is not null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andReceiptdescEqualTo(String value) {
      addCriterion("receiptdesc =", value, "receiptdesc");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andReceiptdescNotEqualTo(String value) {
      addCriterion("receiptdesc <>", value, "receiptdesc");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andReceiptdescGreaterThan(String value) {
      addCriterion("receiptdesc >", value, "receiptdesc");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andReceiptdescGreaterThanOrEqualTo(String value) {
      addCriterion("receiptdesc >=", value, "receiptdesc");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andReceiptdescLessThan(String value) {
      addCriterion("receiptdesc <", value, "receiptdesc");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andReceiptdescLessThanOrEqualTo(String value) {
      addCriterion("receiptdesc <=", value, "receiptdesc");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andReceiptdescLike(String value) {
      addCriterion("receiptdesc like", value, "receiptdesc");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andReceiptdescNotLike(String value) {
      addCriterion("receiptdesc not like", value, "receiptdesc");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andReceiptdescIn(List<String> values) {
      addCriterion("receiptdesc in", values, "receiptdesc");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andReceiptdescNotIn(List<String> values) {
      addCriterion("receiptdesc not in", values, "receiptdesc");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andReceiptdescBetween(String value1, String value2) {
      addCriterion("receiptdesc between", value1, value2, "receiptdesc");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andReceiptdescNotBetween(String value1, String value2) {
      addCriterion("receiptdesc not between", value1, value2, "receiptdesc");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidnumIsNull() {
      addCriterion("bidnum is null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidnumIsNotNull() {
      addCriterion("bidnum is not null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidnumEqualTo(Integer value) {
      addCriterion("bidnum =", value, "bidnum");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidnumNotEqualTo(Integer value) {
      addCriterion("bidnum <>", value, "bidnum");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidnumGreaterThan(Integer value) {
      addCriterion("bidnum >", value, "bidnum");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidnumGreaterThanOrEqualTo(Integer value) {
      addCriterion("bidnum >=", value, "bidnum");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidnumLessThan(Integer value) {
      addCriterion("bidnum <", value, "bidnum");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidnumLessThanOrEqualTo(Integer value) {
      addCriterion("bidnum <=", value, "bidnum");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidnumIn(List<Integer> values) {
      addCriterion("bidnum in", values, "bidnum");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidnumNotIn(List<Integer> values) {
      addCriterion("bidnum not in", values, "bidnum");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidnumBetween(Integer value1, Integer value2) {
      addCriterion("bidnum between", value1, value2, "bidnum");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidnumNotBetween(Integer value1, Integer value2) {
      addCriterion("bidnum not between", value1, value2, "bidnum");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andPubdateIsNull() {
      addCriterion("pubdate is null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andPubdateIsNotNull() {
      addCriterion("pubdate is not null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andPubdateEqualTo(java.util.Date value) {
      addCriterion("pubdate =", value, "pubdate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andPubdateNotEqualTo(java.util.Date value) {
      addCriterion("pubdate <>", value, "pubdate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andPubdateGreaterThan(java.util.Date value) {
      addCriterion("pubdate >", value, "pubdate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andPubdateGreaterThanOrEqualTo(java.util.Date value) {
      addCriterion("pubdate >=", value, "pubdate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andPubdateLessThan(java.util.Date value) {
      addCriterion("pubdate <", value, "pubdate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andPubdateLessThanOrEqualTo(java.util.Date value) {
      addCriterion("pubdate <=", value, "pubdate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andPubdateIn(List<java.util.Date> values) {
      addCriterion("pubdate in", values, "pubdate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andPubdateNotIn(List<java.util.Date> values) {
      addCriterion("pubdate not in", values, "pubdate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andPubdateBetween(java.util.Date value1, java.util.Date value2) {
      addCriterion("pubdate between", value1, value2, "pubdate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andPubdateNotBetween(java.util.Date value1, java.util.Date value2) {
      addCriterion("pubdate not between", value1, value2, "pubdate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andMemberidIsNull() {
      addCriterion("memberid is null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andMemberidIsNotNull() {
      addCriterion("memberid is not null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andMemberidEqualTo(Integer value) {
      addCriterion("memberid =", value, "memberid");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andMemberidNotEqualTo(Integer value) {
      addCriterion("memberid <>", value, "memberid");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andMemberidGreaterThan(Integer value) {
      addCriterion("memberid >", value, "memberid");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andMemberidGreaterThanOrEqualTo(Integer value) {
      addCriterion("memberid >=", value, "memberid");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andMemberidLessThan(Integer value) {
      addCriterion("memberid <", value, "memberid");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andMemberidLessThanOrEqualTo(Integer value) {
      addCriterion("memberid <=", value, "memberid");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andMemberidIn(List<Integer> values) {
      addCriterion("memberid in", values, "memberid");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andMemberidNotIn(List<Integer> values) {
      addCriterion("memberid not in", values, "memberid");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andMemberidBetween(Integer value1, Integer value2) {
      addCriterion("memberid between", value1, value2, "memberid");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andMemberidNotBetween(Integer value1, Integer value2) {
      addCriterion("memberid not between", value1, value2, "memberid");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andStaffNoIsNull() {
      addCriterion("staff_no is null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andStaffNoIsNotNull() {
      addCriterion("staff_no is not null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andStaffNoEqualTo(String value) {
      addCriterion("staff_no =", value, "staffNo");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andStaffNoNotEqualTo(String value) {
      addCriterion("staff_no <>", value, "staffNo");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andStaffNoGreaterThan(String value) {
      addCriterion("staff_no >", value, "staffNo");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andStaffNoGreaterThanOrEqualTo(String value) {
      addCriterion("staff_no >=", value, "staffNo");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andStaffNoLessThan(String value) {
      addCriterion("staff_no <", value, "staffNo");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andStaffNoLessThanOrEqualTo(String value) {
      addCriterion("staff_no <=", value, "staffNo");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andStaffNoLike(String value) {
      addCriterion("staff_no like", value, "staffNo");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andStaffNoNotLike(String value) {
      addCriterion("staff_no not like", value, "staffNo");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andStaffNoIn(List<String> values) {
      addCriterion("staff_no in", values, "staffNo");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andStaffNoNotIn(List<String> values) {
      addCriterion("staff_no not in", values, "staffNo");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andStaffNoBetween(String value1, String value2) {
      addCriterion("staff_no between", value1, value2, "staffNo");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andStaffNoNotBetween(String value1, String value2) {
      addCriterion("staff_no not between", value1, value2, "staffNo");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andMembernameIsNull() {
      addCriterion("membername is null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andMembernameIsNotNull() {
      addCriterion("membername is not null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andMembernameEqualTo(String value) {
      addCriterion("membername =", value, "membername");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andMembernameNotEqualTo(String value) {
      addCriterion("membername <>", value, "membername");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andMembernameGreaterThan(String value) {
      addCriterion("membername >", value, "membername");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andMembernameGreaterThanOrEqualTo(String value) {
      addCriterion("membername >=", value, "membername");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andMembernameLessThan(String value) {
      addCriterion("membername <", value, "membername");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andMembernameLessThanOrEqualTo(String value) {
      addCriterion("membername <=", value, "membername");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andMembernameLike(String value) {
      addCriterion("membername like", value, "membername");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andMembernameNotLike(String value) {
      addCriterion("membername not like", value, "membername");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andMembernameIn(List<String> values) {
      addCriterion("membername in", values, "membername");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andMembernameNotIn(List<String> values) {
      addCriterion("membername not in", values, "membername");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andMembernameBetween(String value1, String value2) {
      addCriterion("membername between", value1, value2, "membername");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andMembernameNotBetween(String value1, String value2) {
      addCriterion("membername not between", value1, value2, "membername");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRiskmgrfeeIsNull() {
      addCriterion("riskmgrfee is null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRiskmgrfeeIsNotNull() {
      addCriterion("riskmgrfee is not null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRiskmgrfeeEqualTo(BigDecimal value) {
      addCriterion("riskmgrfee =", value, "riskmgrfee");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRiskmgrfeeNotEqualTo(BigDecimal value) {
      addCriterion("riskmgrfee <>", value, "riskmgrfee");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRiskmgrfeeGreaterThan(BigDecimal value) {
      addCriterion("riskmgrfee >", value, "riskmgrfee");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRiskmgrfeeGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("riskmgrfee >=", value, "riskmgrfee");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRiskmgrfeeLessThan(BigDecimal value) {
      addCriterion("riskmgrfee <", value, "riskmgrfee");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRiskmgrfeeLessThanOrEqualTo(BigDecimal value) {
      addCriterion("riskmgrfee <=", value, "riskmgrfee");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRiskmgrfeeIn(List<BigDecimal> values) {
      addCriterion("riskmgrfee in", values, "riskmgrfee");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRiskmgrfeeNotIn(List<BigDecimal> values) {
      addCriterion("riskmgrfee not in", values, "riskmgrfee");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRiskmgrfeeBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("riskmgrfee between", value1, value2, "riskmgrfee");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRiskmgrfeeNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("riskmgrfee not between", value1, value2, "riskmgrfee");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andTransnameIsNull() {
      addCriterion("transname is null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andTransnameIsNotNull() {
      addCriterion("transname is not null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andTransnameEqualTo(String value) {
      addCriterion("transname =", value, "transname");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andTransnameNotEqualTo(String value) {
      addCriterion("transname <>", value, "transname");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andTransnameGreaterThan(String value) {
      addCriterion("transname >", value, "transname");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andTransnameGreaterThanOrEqualTo(String value) {
      addCriterion("transname >=", value, "transname");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andTransnameLessThan(String value) {
      addCriterion("transname <", value, "transname");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andTransnameLessThanOrEqualTo(String value) {
      addCriterion("transname <=", value, "transname");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andTransnameLike(String value) {
      addCriterion("transname like", value, "transname");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andTransnameNotLike(String value) {
      addCriterion("transname not like", value, "transname");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andTransnameIn(List<String> values) {
      addCriterion("transname in", values, "transname");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andTransnameNotIn(List<String> values) {
      addCriterion("transname not in", values, "transname");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andTransnameBetween(String value1, String value2) {
      addCriterion("transname between", value1, value2, "transname");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andTransnameNotBetween(String value1, String value2) {
      addCriterion("transname not between", value1, value2, "transname");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andProjectcodeIsNull() {
      addCriterion("projectCode is null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andProjectcodeIsNotNull() {
      addCriterion("projectCode is not null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andProjectcodeEqualTo(String value) {
      addCriterion("projectCode =", value, "projectcode");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andProjectcodeNotEqualTo(String value) {
      addCriterion("projectCode <>", value, "projectcode");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andProjectcodeGreaterThan(String value) {
      addCriterion("projectCode >", value, "projectcode");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andProjectcodeGreaterThanOrEqualTo(String value) {
      addCriterion("projectCode >=", value, "projectcode");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andProjectcodeLessThan(String value) {
      addCriterion("projectCode <", value, "projectcode");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andProjectcodeLessThanOrEqualTo(String value) {
      addCriterion("projectCode <=", value, "projectcode");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andProjectcodeLike(String value) {
      addCriterion("projectCode like", value, "projectcode");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andProjectcodeNotLike(String value) {
      addCriterion("projectCode not like", value, "projectcode");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andProjectcodeIn(List<String> values) {
      addCriterion("projectCode in", values, "projectcode");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andProjectcodeNotIn(List<String> values) {
      addCriterion("projectCode not in", values, "projectcode");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andProjectcodeBetween(String value1, String value2) {
      addCriterion("projectCode between", value1, value2, "projectcode");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andProjectcodeNotBetween(String value1, String value2) {
      addCriterion("projectCode not between", value1, value2, "projectcode");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andProjectfeatureIsNull() {
      addCriterion("projectfeature is null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andProjectfeatureIsNotNull() {
      addCriterion("projectfeature is not null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andProjectfeatureEqualTo(String value) {
      addCriterion("projectfeature =", value, "projectfeature");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andProjectfeatureNotEqualTo(String value) {
      addCriterion("projectfeature <>", value, "projectfeature");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andProjectfeatureGreaterThan(String value) {
      addCriterion("projectfeature >", value, "projectfeature");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andProjectfeatureGreaterThanOrEqualTo(String value) {
      addCriterion("projectfeature >=", value, "projectfeature");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andProjectfeatureLessThan(String value) {
      addCriterion("projectfeature <", value, "projectfeature");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andProjectfeatureLessThanOrEqualTo(String value) {
      addCriterion("projectfeature <=", value, "projectfeature");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andProjectfeatureLike(String value) {
      addCriterion("projectfeature like", value, "projectfeature");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andProjectfeatureNotLike(String value) {
      addCriterion("projectfeature not like", value, "projectfeature");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andProjectfeatureIn(List<String> values) {
      addCriterion("projectfeature in", values, "projectfeature");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andProjectfeatureNotIn(List<String> values) {
      addCriterion("projectfeature not in", values, "projectfeature");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andProjectfeatureBetween(String value1, String value2) {
      addCriterion("projectfeature between", value1, value2, "projectfeature");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andProjectfeatureNotBetween(String value1, String value2) {
      addCriterion("projectfeature not between", value1, value2, "projectfeature");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andYearservicefeeIsNull() {
      addCriterion("yearservicefee is null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andYearservicefeeIsNotNull() {
      addCriterion("yearservicefee is not null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andYearservicefeeEqualTo(BigDecimal value) {
      addCriterion("yearservicefee =", value, "yearservicefee");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andYearservicefeeNotEqualTo(BigDecimal value) {
      addCriterion("yearservicefee <>", value, "yearservicefee");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andYearservicefeeGreaterThan(BigDecimal value) {
      addCriterion("yearservicefee >", value, "yearservicefee");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andYearservicefeeGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("yearservicefee >=", value, "yearservicefee");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andYearservicefeeLessThan(BigDecimal value) {
      addCriterion("yearservicefee <", value, "yearservicefee");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andYearservicefeeLessThanOrEqualTo(BigDecimal value) {
      addCriterion("yearservicefee <=", value, "yearservicefee");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andYearservicefeeIn(List<BigDecimal> values) {
      addCriterion("yearservicefee in", values, "yearservicefee");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andYearservicefeeNotIn(List<BigDecimal> values) {
      addCriterion("yearservicefee not in", values, "yearservicefee");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andYearservicefeeBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("yearservicefee between", value1, value2, "yearservicefee");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andYearservicefeeNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("yearservicefee not between", value1, value2, "yearservicefee");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andPubfeeIsNull() {
      addCriterion("pubfee is null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andPubfeeIsNotNull() {
      addCriterion("pubfee is not null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andPubfeeEqualTo(BigDecimal value) {
      addCriterion("pubfee =", value, "pubfee");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andPubfeeNotEqualTo(BigDecimal value) {
      addCriterion("pubfee <>", value, "pubfee");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andPubfeeGreaterThan(BigDecimal value) {
      addCriterion("pubfee >", value, "pubfee");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andPubfeeGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("pubfee >=", value, "pubfee");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andPubfeeLessThan(BigDecimal value) {
      addCriterion("pubfee <", value, "pubfee");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andPubfeeLessThanOrEqualTo(BigDecimal value) {
      addCriterion("pubfee <=", value, "pubfee");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andPubfeeIn(List<BigDecimal> values) {
      addCriterion("pubfee in", values, "pubfee");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andPubfeeNotIn(List<BigDecimal> values) {
      addCriterion("pubfee not in", values, "pubfee");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andPubfeeBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("pubfee between", value1, value2, "pubfee");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andPubfeeNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("pubfee not between", value1, value2, "pubfee");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andInfofeeIsNull() {
      addCriterion("infofee is null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andInfofeeIsNotNull() {
      addCriterion("infofee is not null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andInfofeeEqualTo(BigDecimal value) {
      addCriterion("infofee =", value, "infofee");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andInfofeeNotEqualTo(BigDecimal value) {
      addCriterion("infofee <>", value, "infofee");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andInfofeeGreaterThan(BigDecimal value) {
      addCriterion("infofee >", value, "infofee");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andInfofeeGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("infofee >=", value, "infofee");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andInfofeeLessThan(BigDecimal value) {
      addCriterion("infofee <", value, "infofee");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andInfofeeLessThanOrEqualTo(BigDecimal value) {
      addCriterion("infofee <=", value, "infofee");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andInfofeeIn(List<BigDecimal> values) {
      addCriterion("infofee in", values, "infofee");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andInfofeeNotIn(List<BigDecimal> values) {
      addCriterion("infofee not in", values, "infofee");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andInfofeeBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("infofee between", value1, value2, "infofee");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andInfofeeNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("infofee not between", value1, value2, "infofee");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andOverduefeeIsNull() {
      addCriterion("overduefee is null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andOverduefeeIsNotNull() {
      addCriterion("overduefee is not null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andOverduefeeEqualTo(BigDecimal value) {
      addCriterion("overduefee =", value, "overduefee");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andOverduefeeNotEqualTo(BigDecimal value) {
      addCriterion("overduefee <>", value, "overduefee");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andOverduefeeGreaterThan(BigDecimal value) {
      addCriterion("overduefee >", value, "overduefee");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andOverduefeeGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("overduefee >=", value, "overduefee");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andOverduefeeLessThan(BigDecimal value) {
      addCriterion("overduefee <", value, "overduefee");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andOverduefeeLessThanOrEqualTo(BigDecimal value) {
      addCriterion("overduefee <=", value, "overduefee");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andOverduefeeIn(List<BigDecimal> values) {
      addCriterion("overduefee in", values, "overduefee");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andOverduefeeNotIn(List<BigDecimal> values) {
      addCriterion("overduefee not in", values, "overduefee");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andOverduefeeBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("overduefee between", value1, value2, "overduefee");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andOverduefeeNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("overduefee not between", value1, value2, "overduefee");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andUnpaidfeeIsNull() {
      addCriterion("unpaidfee is null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andUnpaidfeeIsNotNull() {
      addCriterion("unpaidfee is not null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andUnpaidfeeEqualTo(BigDecimal value) {
      addCriterion("unpaidfee =", value, "unpaidfee");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andUnpaidfeeNotEqualTo(BigDecimal value) {
      addCriterion("unpaidfee <>", value, "unpaidfee");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andUnpaidfeeGreaterThan(BigDecimal value) {
      addCriterion("unpaidfee >", value, "unpaidfee");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andUnpaidfeeGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("unpaidfee >=", value, "unpaidfee");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andUnpaidfeeLessThan(BigDecimal value) {
      addCriterion("unpaidfee <", value, "unpaidfee");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andUnpaidfeeLessThanOrEqualTo(BigDecimal value) {
      addCriterion("unpaidfee <=", value, "unpaidfee");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andUnpaidfeeIn(List<BigDecimal> values) {
      addCriterion("unpaidfee in", values, "unpaidfee");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andUnpaidfeeNotIn(List<BigDecimal> values) {
      addCriterion("unpaidfee not in", values, "unpaidfee");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andUnpaidfeeBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("unpaidfee between", value1, value2, "unpaidfee");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andUnpaidfeeNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("unpaidfee not between", value1, value2, "unpaidfee");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andInvestordercodeIsNull() {
      addCriterion("InvestOrderCode is null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andInvestordercodeIsNotNull() {
      addCriterion("InvestOrderCode is not null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andInvestordercodeEqualTo(String value) {
      addCriterion("InvestOrderCode =", value, "investordercode");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andInvestordercodeNotEqualTo(String value) {
      addCriterion("InvestOrderCode <>", value, "investordercode");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andInvestordercodeGreaterThan(String value) {
      addCriterion("InvestOrderCode >", value, "investordercode");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andInvestordercodeGreaterThanOrEqualTo(String value) {
      addCriterion("InvestOrderCode >=", value, "investordercode");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andInvestordercodeLessThan(String value) {
      addCriterion("InvestOrderCode <", value, "investordercode");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andInvestordercodeLessThanOrEqualTo(String value) {
      addCriterion("InvestOrderCode <=", value, "investordercode");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andInvestordercodeLike(String value) {
      addCriterion("InvestOrderCode like", value, "investordercode");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andInvestordercodeNotLike(String value) {
      addCriterion("InvestOrderCode not like", value, "investordercode");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andInvestordercodeIn(List<String> values) {
      addCriterion("InvestOrderCode in", values, "investordercode");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andInvestordercodeNotIn(List<String> values) {
      addCriterion("InvestOrderCode not in", values, "investordercode");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andInvestordercodeBetween(String value1, String value2) {
      addCriterion("InvestOrderCode between", value1, value2, "investordercode");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andInvestordercodeNotBetween(String value1, String value2) {
      addCriterion("InvestOrderCode not between", value1, value2, "investordercode");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andIfextrarateIsNull() {
      addCriterion("ifextrarate is null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andIfextrarateIsNotNull() {
      addCriterion("ifextrarate is not null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andIfextrarateEqualTo(Integer value) {
      addCriterion("ifextrarate =", value, "ifextrarate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andIfextrarateNotEqualTo(Integer value) {
      addCriterion("ifextrarate <>", value, "ifextrarate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andIfextrarateGreaterThan(Integer value) {
      addCriterion("ifextrarate >", value, "ifextrarate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andIfextrarateGreaterThanOrEqualTo(Integer value) {
      addCriterion("ifextrarate >=", value, "ifextrarate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andIfextrarateLessThan(Integer value) {
      addCriterion("ifextrarate <", value, "ifextrarate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andIfextrarateLessThanOrEqualTo(Integer value) {
      addCriterion("ifextrarate <=", value, "ifextrarate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andIfextrarateIn(List<Integer> values) {
      addCriterion("ifextrarate in", values, "ifextrarate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andIfextrarateNotIn(List<Integer> values) {
      addCriterion("ifextrarate not in", values, "ifextrarate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andIfextrarateBetween(Integer value1, Integer value2) {
      addCriterion("ifextrarate between", value1, value2, "ifextrarate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andIfextrarateNotBetween(Integer value1, Integer value2) {
      addCriterion("ifextrarate not between", value1, value2, "ifextrarate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andIfvirtualIsNull() {
      addCriterion("ifvirtual is null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andIfvirtualIsNotNull() {
      addCriterion("ifvirtual is not null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andIfvirtualEqualTo(Integer value) {
      addCriterion("ifvirtual =", value, "ifvirtual");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andIfvirtualNotEqualTo(Integer value) {
      addCriterion("ifvirtual <>", value, "ifvirtual");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andIfvirtualGreaterThan(Integer value) {
      addCriterion("ifvirtual >", value, "ifvirtual");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andIfvirtualGreaterThanOrEqualTo(Integer value) {
      addCriterion("ifvirtual >=", value, "ifvirtual");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andIfvirtualLessThan(Integer value) {
      addCriterion("ifvirtual <", value, "ifvirtual");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andIfvirtualLessThanOrEqualTo(Integer value) {
      addCriterion("ifvirtual <=", value, "ifvirtual");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andIfvirtualIn(List<Integer> values) {
      addCriterion("ifvirtual in", values, "ifvirtual");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andIfvirtualNotIn(List<Integer> values) {
      addCriterion("ifvirtual not in", values, "ifvirtual");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andIfvirtualBetween(Integer value1, Integer value2) {
      addCriterion("ifvirtual between", value1, value2, "ifvirtual");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andIfvirtualNotBetween(Integer value1, Integer value2) {
      addCriterion("ifvirtual not between", value1, value2, "ifvirtual");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andExtrarateIsNull() {
      addCriterion("extrarate is null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andExtrarateIsNotNull() {
      addCriterion("extrarate is not null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andExtrarateEqualTo(BigDecimal value) {
      addCriterion("extrarate =", value, "extrarate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andExtrarateNotEqualTo(BigDecimal value) {
      addCriterion("extrarate <>", value, "extrarate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andExtrarateGreaterThan(BigDecimal value) {
      addCriterion("extrarate >", value, "extrarate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andExtrarateGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("extrarate >=", value, "extrarate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andExtrarateLessThan(BigDecimal value) {
      addCriterion("extrarate <", value, "extrarate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andExtrarateLessThanOrEqualTo(BigDecimal value) {
      addCriterion("extrarate <=", value, "extrarate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andExtrarateIn(List<BigDecimal> values) {
      addCriterion("extrarate in", values, "extrarate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andExtrarateNotIn(List<BigDecimal> values) {
      addCriterion("extrarate not in", values, "extrarate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andExtrarateBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("extrarate between", value1, value2, "extrarate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andExtrarateNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("extrarate not between", value1, value2, "extrarate");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andApprostatusIsNull() {
      addCriterion("ApproStatus is null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andApprostatusIsNotNull() {
      addCriterion("ApproStatus is not null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andApprostatusEqualTo(Integer value) {
      addCriterion("ApproStatus =", value, "approstatus");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andApprostatusNotEqualTo(Integer value) {
      addCriterion("ApproStatus <>", value, "approstatus");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andApprostatusGreaterThan(Integer value) {
      addCriterion("ApproStatus >", value, "approstatus");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andApprostatusGreaterThanOrEqualTo(Integer value) {
      addCriterion("ApproStatus >=", value, "approstatus");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andApprostatusLessThan(Integer value) {
      addCriterion("ApproStatus <", value, "approstatus");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andApprostatusLessThanOrEqualTo(Integer value) {
      addCriterion("ApproStatus <=", value, "approstatus");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andApprostatusIn(List<Integer> values) {
      addCriterion("ApproStatus in", values, "approstatus");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andApprostatusNotIn(List<Integer> values) {
      addCriterion("ApproStatus not in", values, "approstatus");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andApprostatusBetween(Integer value1, Integer value2) {
      addCriterion("ApproStatus between", value1, value2, "approstatus");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andApprostatusNotBetween(Integer value1, Integer value2) {
      addCriterion("ApproStatus not between", value1, value2, "approstatus");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidstatusIsNull() {
      addCriterion("bidstatus is null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidstatusIsNotNull() {
      addCriterion("bidstatus is not null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidstatusEqualTo(Integer value) {
      addCriterion("bidstatus =", value, "bidstatus");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidstatusNotEqualTo(Integer value) {
      addCriterion("bidstatus <>", value, "bidstatus");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidstatusGreaterThan(Integer value) {
      addCriterion("bidstatus >", value, "bidstatus");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidstatusGreaterThanOrEqualTo(Integer value) {
      addCriterion("bidstatus >=", value, "bidstatus");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidstatusLessThan(Integer value) {
      addCriterion("bidstatus <", value, "bidstatus");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidstatusLessThanOrEqualTo(Integer value) {
      addCriterion("bidstatus <=", value, "bidstatus");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidstatusIn(List<Integer> values) {
      addCriterion("bidstatus in", values, "bidstatus");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidstatusNotIn(List<Integer> values) {
      addCriterion("bidstatus not in", values, "bidstatus");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidstatusBetween(Integer value1, Integer value2) {
      addCriterion("bidstatus between", value1, value2, "bidstatus");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBidstatusNotBetween(Integer value1, Integer value2) {
      addCriterion("bidstatus not between", value1, value2, "bidstatus");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBorrowstatusIsNull() {
      addCriterion("borrowstatus is null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBorrowstatusIsNotNull() {
      addCriterion("borrowstatus is not null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBorrowstatusEqualTo(Integer value) {
      addCriterion("borrowstatus =", value, "borrowstatus");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBorrowstatusNotEqualTo(Integer value) {
      addCriterion("borrowstatus <>", value, "borrowstatus");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBorrowstatusGreaterThan(Integer value) {
      addCriterion("borrowstatus >", value, "borrowstatus");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBorrowstatusGreaterThanOrEqualTo(Integer value) {
      addCriterion("borrowstatus >=", value, "borrowstatus");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBorrowstatusLessThan(Integer value) {
      addCriterion("borrowstatus <", value, "borrowstatus");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBorrowstatusLessThanOrEqualTo(Integer value) {
      addCriterion("borrowstatus <=", value, "borrowstatus");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBorrowstatusIn(List<Integer> values) {
      addCriterion("borrowstatus in", values, "borrowstatus");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBorrowstatusNotIn(List<Integer> values) {
      addCriterion("borrowstatus not in", values, "borrowstatus");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBorrowstatusBetween(Integer value1, Integer value2) {
      addCriterion("borrowstatus between", value1, value2, "borrowstatus");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andBorrowstatusNotBetween(Integer value1, Integer value2) {
      addCriterion("borrowstatus not between", value1, value2, "borrowstatus");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andLockupperiodIsNull() {
      addCriterion("lockupperiod is null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andLockupperiodIsNotNull() {
      addCriterion("lockupperiod is not null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andLockupperiodEqualTo(Integer value) {
      addCriterion("lockupperiod =", value, "lockupperiod");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andLockupperiodNotEqualTo(Integer value) {
      addCriterion("lockupperiod <>", value, "lockupperiod");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andLockupperiodGreaterThan(Integer value) {
      addCriterion("lockupperiod >", value, "lockupperiod");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andLockupperiodGreaterThanOrEqualTo(Integer value) {
      addCriterion("lockupperiod >=", value, "lockupperiod");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andLockupperiodLessThan(Integer value) {
      addCriterion("lockupperiod <", value, "lockupperiod");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andLockupperiodLessThanOrEqualTo(Integer value) {
      addCriterion("lockupperiod <=", value, "lockupperiod");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andLockupperiodIn(List<Integer> values) {
      addCriterion("lockupperiod in", values, "lockupperiod");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andLockupperiodNotIn(List<Integer> values) {
      addCriterion("lockupperiod not in", values, "lockupperiod");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andLockupperiodBetween(Integer value1, Integer value2) {
      addCriterion("lockupperiod between", value1, value2, "lockupperiod");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andLockupperiodNotBetween(Integer value1, Integer value2) {
      addCriterion("lockupperiod not between", value1, value2, "lockupperiod");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRemarkIsNull() {
      addCriterion("remark is null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRemarkIsNotNull() {
      addCriterion("remark is not null");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRemarkEqualTo(String value) {
      addCriterion("remark =", value, "remark");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRemarkNotEqualTo(String value) {
      addCriterion("remark <>", value, "remark");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRemarkGreaterThan(String value) {
      addCriterion("remark >", value, "remark");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRemarkGreaterThanOrEqualTo(String value) {
      addCriterion("remark >=", value, "remark");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRemarkLessThan(String value) {
      addCriterion("remark <", value, "remark");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRemarkLessThanOrEqualTo(String value) {
      addCriterion("remark <=", value, "remark");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRemarkLike(String value) {
      addCriterion("remark like", value, "remark");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRemarkNotLike(String value) {
      addCriterion("remark not like", value, "remark");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRemarkIn(List<String> values) {
      addCriterion("remark in", values, "remark");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRemarkNotIn(List<String> values) {
      addCriterion("remark not in", values, "remark");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRemarkBetween(String value1, String value2) {
      addCriterion("remark between", value1, value2, "remark");
      return ((BidExample.Criteria)this);
    }

    public BidExample.Criteria andRemarkNotBetween(String value1, String value2) {
      addCriterion("remark not between", value1, value2, "remark");
      return ((BidExample.Criteria)this);
    }
  }
}