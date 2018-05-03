package com.zjgt.p2p.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ApproveExample
{
  protected String orderByClause;
  protected boolean distinct;
  protected List<Criteria> oredCriteria;

  public ApproveExample()
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

  public static class Criteria extends ApproveExample.GeneratedCriteria
  {
  }

  protected static abstract class GeneratedCriteria
  {
    protected List<ApproveExample.Criterion> criteria;

    protected GeneratedCriteria()
    {
      this.criteria = new ArrayList();
    }

    public boolean isValid() {
      return (this.criteria.size() > 0);
    }

    public List<ApproveExample.Criterion> getAllCriteria() {
      return this.criteria;
    }

    public List<ApproveExample.Criterion> getCriteria() {
      return this.criteria;
    }

    protected void addCriterion(String condition) {
      if (condition == null) {
        throw new RuntimeException("Value for condition cannot be null");
      }
      this.criteria.add(new ApproveExample.Criterion(condition));
    }

    protected void addCriterion(String condition, Object value, String property) {
      if (value == null) {
        throw new RuntimeException("Value for " + property + " cannot be null");
      }
      this.criteria.add(new ApproveExample.Criterion(condition, value));
    }

    protected void addCriterion(String condition, Object value1, Object value2, String property) {
      if ((value1 == null) || (value2 == null)) {
        throw new RuntimeException("Between values for " + property + " cannot be null");
      }
      this.criteria.add(new ApproveExample.Criterion(condition, value1, value2));
    }

    public ApproveExample.Criteria andIdIsNull() {
      addCriterion("Id is null");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andIdIsNotNull() {
      addCriterion("Id is not null");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andIdEqualTo(Long value) {
      addCriterion("Id =", value, "id");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andIdNotEqualTo(Long value) {
      addCriterion("Id <>", value, "id");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andIdGreaterThan(Long value) {
      addCriterion("Id >", value, "id");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andIdGreaterThanOrEqualTo(Long value) {
      addCriterion("Id >=", value, "id");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andIdLessThan(Long value) {
      addCriterion("Id <", value, "id");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andIdLessThanOrEqualTo(Long value) {
      addCriterion("Id <=", value, "id");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andIdIn(List<Long> values) {
      addCriterion("Id in", values, "id");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andIdNotIn(List<Long> values) {
      addCriterion("Id not in", values, "id");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andIdBetween(Long value1, Long value2) {
      addCriterion("Id between", value1, value2, "id");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andIdNotBetween(Long value1, Long value2) {
      addCriterion("Id not between", value1, value2, "id");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andModulecodeIsNull() {
      addCriterion("modulecode is null");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andModulecodeIsNotNull() {
      addCriterion("modulecode is not null");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andModulecodeEqualTo(String value) {
      addCriterion("modulecode =", value, "modulecode");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andModulecodeNotEqualTo(String value) {
      addCriterion("modulecode <>", value, "modulecode");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andModulecodeGreaterThan(String value) {
      addCriterion("modulecode >", value, "modulecode");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andModulecodeGreaterThanOrEqualTo(String value) {
      addCriterion("modulecode >=", value, "modulecode");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andModulecodeLessThan(String value) {
      addCriterion("modulecode <", value, "modulecode");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andModulecodeLessThanOrEqualTo(String value) {
      addCriterion("modulecode <=", value, "modulecode");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andModulecodeLike(String value) {
      addCriterion("modulecode like", value, "modulecode");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andModulecodeNotLike(String value) {
      addCriterion("modulecode not like", value, "modulecode");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andModulecodeIn(List<String> values) {
      addCriterion("modulecode in", values, "modulecode");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andModulecodeNotIn(List<String> values) {
      addCriterion("modulecode not in", values, "modulecode");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andModulecodeBetween(String value1, String value2) {
      addCriterion("modulecode between", value1, value2, "modulecode");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andModulecodeNotBetween(String value1, String value2) {
      addCriterion("modulecode not between", value1, value2, "modulecode");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andServicenoIsNull() {
      addCriterion("serviceno is null");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andServicenoIsNotNull() {
      addCriterion("serviceno is not null");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andServicenoEqualTo(String value) {
      addCriterion("serviceno =", value, "serviceno");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andServicenoNotEqualTo(String value) {
      addCriterion("serviceno <>", value, "serviceno");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andServicenoGreaterThan(String value) {
      addCriterion("serviceno >", value, "serviceno");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andServicenoGreaterThanOrEqualTo(String value) {
      addCriterion("serviceno >=", value, "serviceno");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andServicenoLessThan(String value) {
      addCriterion("serviceno <", value, "serviceno");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andServicenoLessThanOrEqualTo(String value) {
      addCriterion("serviceno <=", value, "serviceno");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andServicenoLike(String value) {
      addCriterion("serviceno like", value, "serviceno");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andServicenoNotLike(String value) {
      addCriterion("serviceno not like", value, "serviceno");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andServicenoIn(List<String> values) {
      addCriterion("serviceno in", values, "serviceno");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andServicenoNotIn(List<String> values) {
      addCriterion("serviceno not in", values, "serviceno");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andServicenoBetween(String value1, String value2) {
      addCriterion("serviceno between", value1, value2, "serviceno");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andServicenoNotBetween(String value1, String value2) {
      addCriterion("serviceno not between", value1, value2, "serviceno");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andTransnameIsNull() {
      addCriterion("transname is null");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andTransnameIsNotNull() {
      addCriterion("transname is not null");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andTransnameEqualTo(String value) {
      addCriterion("transname =", value, "transname");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andTransnameNotEqualTo(String value) {
      addCriterion("transname <>", value, "transname");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andTransnameGreaterThan(String value) {
      addCriterion("transname >", value, "transname");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andTransnameGreaterThanOrEqualTo(String value) {
      addCriterion("transname >=", value, "transname");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andTransnameLessThan(String value) {
      addCriterion("transname <", value, "transname");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andTransnameLessThanOrEqualTo(String value) {
      addCriterion("transname <=", value, "transname");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andTransnameLike(String value) {
      addCriterion("transname like", value, "transname");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andTransnameNotLike(String value) {
      addCriterion("transname not like", value, "transname");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andTransnameIn(List<String> values) {
      addCriterion("transname in", values, "transname");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andTransnameNotIn(List<String> values) {
      addCriterion("transname not in", values, "transname");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andTransnameBetween(String value1, String value2) {
      addCriterion("transname between", value1, value2, "transname");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andTransnameNotBetween(String value1, String value2) {
      addCriterion("transname not between", value1, value2, "transname");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andFlowstepIsNull() {
      addCriterion("flowstep is null");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andFlowstepIsNotNull() {
      addCriterion("flowstep is not null");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andFlowstepEqualTo(Integer value) {
      addCriterion("flowstep =", value, "flowstep");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andFlowstepNotEqualTo(Integer value) {
      addCriterion("flowstep <>", value, "flowstep");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andFlowstepGreaterThan(Integer value) {
      addCriterion("flowstep >", value, "flowstep");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andFlowstepGreaterThanOrEqualTo(Integer value) {
      addCriterion("flowstep >=", value, "flowstep");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andFlowstepLessThan(Integer value) {
      addCriterion("flowstep <", value, "flowstep");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andFlowstepLessThanOrEqualTo(Integer value) {
      addCriterion("flowstep <=", value, "flowstep");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andFlowstepIn(List<Integer> values) {
      addCriterion("flowstep in", values, "flowstep");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andFlowstepNotIn(List<Integer> values) {
      addCriterion("flowstep not in", values, "flowstep");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andFlowstepBetween(Integer value1, Integer value2) {
      addCriterion("flowstep between", value1, value2, "flowstep");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andFlowstepNotBetween(Integer value1, Integer value2) {
      addCriterion("flowstep not between", value1, value2, "flowstep");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andSubjectIsNull() {
      addCriterion("subject is null");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andSubjectIsNotNull() {
      addCriterion("subject is not null");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andSubjectEqualTo(String value) {
      addCriterion("subject =", value, "subject");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andSubjectNotEqualTo(String value) {
      addCriterion("subject <>", value, "subject");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andSubjectGreaterThan(String value) {
      addCriterion("subject >", value, "subject");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andSubjectGreaterThanOrEqualTo(String value) {
      addCriterion("subject >=", value, "subject");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andSubjectLessThan(String value) {
      addCriterion("subject <", value, "subject");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andSubjectLessThanOrEqualTo(String value) {
      addCriterion("subject <=", value, "subject");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andSubjectLike(String value) {
      addCriterion("subject like", value, "subject");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andSubjectNotLike(String value) {
      addCriterion("subject not like", value, "subject");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andSubjectIn(List<String> values) {
      addCriterion("subject in", values, "subject");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andSubjectNotIn(List<String> values) {
      addCriterion("subject not in", values, "subject");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andSubjectBetween(String value1, String value2) {
      addCriterion("subject between", value1, value2, "subject");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andSubjectNotBetween(String value1, String value2) {
      addCriterion("subject not between", value1, value2, "subject");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andAppreasonIsNull() {
      addCriterion("appreason is null");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andAppreasonIsNotNull() {
      addCriterion("appreason is not null");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andAppreasonEqualTo(String value) {
      addCriterion("appreason =", value, "appreason");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andAppreasonNotEqualTo(String value) {
      addCriterion("appreason <>", value, "appreason");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andAppreasonGreaterThan(String value) {
      addCriterion("appreason >", value, "appreason");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andAppreasonGreaterThanOrEqualTo(String value) {
      addCriterion("appreason >=", value, "appreason");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andAppreasonLessThan(String value) {
      addCriterion("appreason <", value, "appreason");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andAppreasonLessThanOrEqualTo(String value) {
      addCriterion("appreason <=", value, "appreason");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andAppreasonLike(String value) {
      addCriterion("appreason like", value, "appreason");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andAppreasonNotLike(String value) {
      addCriterion("appreason not like", value, "appreason");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andAppreasonIn(List<String> values) {
      addCriterion("appreason in", values, "appreason");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andAppreasonNotIn(List<String> values) {
      addCriterion("appreason not in", values, "appreason");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andAppreasonBetween(String value1, String value2) {
      addCriterion("appreason between", value1, value2, "appreason");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andAppreasonNotBetween(String value1, String value2) {
      addCriterion("appreason not between", value1, value2, "appreason");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andAppstatusIsNull() {
      addCriterion("appstatus is null");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andAppstatusIsNotNull() {
      addCriterion("appstatus is not null");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andAppstatusEqualTo(Boolean value) {
      addCriterion("appstatus =", value, "appstatus");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andAppstatusNotEqualTo(Boolean value) {
      addCriterion("appstatus <>", value, "appstatus");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andAppstatusGreaterThan(Boolean value) {
      addCriterion("appstatus >", value, "appstatus");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andAppstatusGreaterThanOrEqualTo(Boolean value) {
      addCriterion("appstatus >=", value, "appstatus");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andAppstatusLessThan(Boolean value) {
      addCriterion("appstatus <", value, "appstatus");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andAppstatusLessThanOrEqualTo(Boolean value) {
      addCriterion("appstatus <=", value, "appstatus");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andAppstatusIn(List<Boolean> values) {
      addCriterion("appstatus in", values, "appstatus");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andAppstatusNotIn(List<Boolean> values) {
      addCriterion("appstatus not in", values, "appstatus");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andAppstatusBetween(Boolean value1, Boolean value2) {
      addCriterion("appstatus between", value1, value2, "appstatus");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andAppstatusNotBetween(Boolean value1, Boolean value2) {
      addCriterion("appstatus not between", value1, value2, "appstatus");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andStaffNoIsNull() {
      addCriterion("staff_no is null");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andStaffNoIsNotNull() {
      addCriterion("staff_no is not null");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andStaffNoEqualTo(String value) {
      addCriterion("staff_no =", value, "staffNo");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andStaffNoNotEqualTo(String value) {
      addCriterion("staff_no <>", value, "staffNo");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andStaffNoGreaterThan(String value) {
      addCriterion("staff_no >", value, "staffNo");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andStaffNoGreaterThanOrEqualTo(String value) {
      addCriterion("staff_no >=", value, "staffNo");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andStaffNoLessThan(String value) {
      addCriterion("staff_no <", value, "staffNo");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andStaffNoLessThanOrEqualTo(String value) {
      addCriterion("staff_no <=", value, "staffNo");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andStaffNoLike(String value) {
      addCriterion("staff_no like", value, "staffNo");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andStaffNoNotLike(String value) {
      addCriterion("staff_no not like", value, "staffNo");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andStaffNoIn(List<String> values) {
      addCriterion("staff_no in", values, "staffNo");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andStaffNoNotIn(List<String> values) {
      addCriterion("staff_no not in", values, "staffNo");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andStaffNoBetween(String value1, String value2) {
      addCriterion("staff_no between", value1, value2, "staffNo");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andStaffNoNotBetween(String value1, String value2) {
      addCriterion("staff_no not between", value1, value2, "staffNo");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andStaffNameIsNull() {
      addCriterion("staff_name is null");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andStaffNameIsNotNull() {
      addCriterion("staff_name is not null");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andStaffNameEqualTo(String value) {
      addCriterion("staff_name =", value, "staffName");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andStaffNameNotEqualTo(String value) {
      addCriterion("staff_name <>", value, "staffName");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andStaffNameGreaterThan(String value) {
      addCriterion("staff_name >", value, "staffName");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andStaffNameGreaterThanOrEqualTo(String value) {
      addCriterion("staff_name >=", value, "staffName");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andStaffNameLessThan(String value) {
      addCriterion("staff_name <", value, "staffName");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andStaffNameLessThanOrEqualTo(String value) {
      addCriterion("staff_name <=", value, "staffName");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andStaffNameLike(String value) {
      addCriterion("staff_name like", value, "staffName");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andStaffNameNotLike(String value) {
      addCriterion("staff_name not like", value, "staffName");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andStaffNameIn(List<String> values) {
      addCriterion("staff_name in", values, "staffName");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andStaffNameNotIn(List<String> values) {
      addCriterion("staff_name not in", values, "staffName");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andStaffNameBetween(String value1, String value2) {
      addCriterion("staff_name between", value1, value2, "staffName");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andStaffNameNotBetween(String value1, String value2) {
      addCriterion("staff_name not between", value1, value2, "staffName");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andOpdateIsNull() {
      addCriterion("opdate is null");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andOpdateIsNotNull() {
      addCriterion("opdate is not null");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andOpdateEqualTo(Date value) {
      addCriterion("opdate =", value, "opdate");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andOpdateNotEqualTo(Date value) {
      addCriterion("opdate <>", value, "opdate");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andOpdateGreaterThan(Date value) {
      addCriterion("opdate >", value, "opdate");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andOpdateGreaterThanOrEqualTo(Date value) {
      addCriterion("opdate >=", value, "opdate");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andOpdateLessThan(Date value) {
      addCriterion("opdate <", value, "opdate");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andOpdateLessThanOrEqualTo(Date value) {
      addCriterion("opdate <=", value, "opdate");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andOpdateIn(List<Date> values) {
      addCriterion("opdate in", values, "opdate");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andOpdateNotIn(List<Date> values) {
      addCriterion("opdate not in", values, "opdate");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andOpdateBetween(Date value1, Date value2) {
      addCriterion("opdate between", value1, value2, "opdate");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andOpdateNotBetween(Date value1, Date value2) {
      addCriterion("opdate not between", value1, value2, "opdate");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andRemarkIsNull() {
      addCriterion("remark is null");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andRemarkIsNotNull() {
      addCriterion("remark is not null");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andRemarkEqualTo(String value) {
      addCriterion("remark =", value, "remark");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andRemarkNotEqualTo(String value) {
      addCriterion("remark <>", value, "remark");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andRemarkGreaterThan(String value) {
      addCriterion("remark >", value, "remark");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andRemarkGreaterThanOrEqualTo(String value) {
      addCriterion("remark >=", value, "remark");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andRemarkLessThan(String value) {
      addCriterion("remark <", value, "remark");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andRemarkLessThanOrEqualTo(String value) {
      addCriterion("remark <=", value, "remark");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andRemarkLike(String value) {
      addCriterion("remark like", value, "remark");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andRemarkNotLike(String value) {
      addCriterion("remark not like", value, "remark");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andRemarkIn(List<String> values) {
      addCriterion("remark in", values, "remark");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andRemarkNotIn(List<String> values) {
      addCriterion("remark not in", values, "remark");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andRemarkBetween(String value1, String value2) {
      addCriterion("remark between", value1, value2, "remark");
      return ((ApproveExample.Criteria)this);
    }

    public ApproveExample.Criteria andRemarkNotBetween(String value1, String value2) {
      addCriterion("remark not between", value1, value2, "remark");
      return ((ApproveExample.Criteria)this);
    }
  }
}