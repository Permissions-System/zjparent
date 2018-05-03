package com.zjgt.p2p.model;

import java.util.ArrayList;
import java.util.List;

public class AgreementExample
{
  protected String orderByClause;
  protected boolean distinct;
  protected List<Criteria> oredCriteria;

  public AgreementExample()
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

  public static class Criteria extends AgreementExample.GeneratedCriteria
  {
  }

  protected static abstract class GeneratedCriteria
  {
    protected List<AgreementExample.Criterion> criteria;

    protected GeneratedCriteria()
    {
      this.criteria = new ArrayList();
    }

    public boolean isValid() {
      return (this.criteria.size() > 0);
    }

    public List<AgreementExample.Criterion> getAllCriteria() {
      return this.criteria;
    }

    public List<AgreementExample.Criterion> getCriteria() {
      return this.criteria;
    }

    protected void addCriterion(String condition) {
      if (condition == null) {
        throw new RuntimeException("Value for condition cannot be null");
      }
      this.criteria.add(new AgreementExample.Criterion(condition));
    }

    protected void addCriterion(String condition, Object value, String property) {
      if (value == null) {
        throw new RuntimeException("Value for " + property + " cannot be null");
      }
      this.criteria.add(new AgreementExample.Criterion(condition, value));
    }

    protected void addCriterion(String condition, Object value1, Object value2, String property) {
      if ((value1 == null) || (value2 == null)) {
        throw new RuntimeException("Between values for " + property + " cannot be null");
      }
      this.criteria.add(new AgreementExample.Criterion(condition, value1, value2));
    }

    public AgreementExample.Criteria andIdIsNull() {
      addCriterion("id is null");
      return ((AgreementExample.Criteria)this);
    }

    public AgreementExample.Criteria andIdIsNotNull() {
      addCriterion("id is not null");
      return ((AgreementExample.Criteria)this);
    }

    public AgreementExample.Criteria andIdEqualTo(Integer value) {
      addCriterion("id =", value, "id");
      return ((AgreementExample.Criteria)this);
    }

    public AgreementExample.Criteria andIdNotEqualTo(Integer value) {
      addCriterion("id <>", value, "id");
      return ((AgreementExample.Criteria)this);
    }

    public AgreementExample.Criteria andIdGreaterThan(Integer value) {
      addCriterion("id >", value, "id");
      return ((AgreementExample.Criteria)this);
    }

    public AgreementExample.Criteria andIdGreaterThanOrEqualTo(Integer value) {
      addCriterion("id >=", value, "id");
      return ((AgreementExample.Criteria)this);
    }

    public AgreementExample.Criteria andIdLessThan(Integer value) {
      addCriterion("id <", value, "id");
      return ((AgreementExample.Criteria)this);
    }

    public AgreementExample.Criteria andIdLessThanOrEqualTo(Integer value) {
      addCriterion("id <=", value, "id");
      return ((AgreementExample.Criteria)this);
    }

    public AgreementExample.Criteria andIdIn(List<Integer> values) {
      addCriterion("id in", values, "id");
      return ((AgreementExample.Criteria)this);
    }

    public AgreementExample.Criteria andIdNotIn(List<Integer> values) {
      addCriterion("id not in", values, "id");
      return ((AgreementExample.Criteria)this);
    }

    public AgreementExample.Criteria andIdBetween(Integer value1, Integer value2) {
      addCriterion("id between", value1, value2, "id");
      return ((AgreementExample.Criteria)this);
    }

    public AgreementExample.Criteria andIdNotBetween(Integer value1, Integer value2) {
      addCriterion("id not between", value1, value2, "id");
      return ((AgreementExample.Criteria)this);
    }

    public AgreementExample.Criteria andAgreementnoIsNull() {
      addCriterion("agreementno is null");
      return ((AgreementExample.Criteria)this);
    }

    public AgreementExample.Criteria andAgreementnoIsNotNull() {
      addCriterion("agreementno is not null");
      return ((AgreementExample.Criteria)this);
    }

    public AgreementExample.Criteria andAgreementnoEqualTo(String value) {
      addCriterion("agreementno =", value, "agreementno");
      return ((AgreementExample.Criteria)this);
    }

    public AgreementExample.Criteria andAgreementnoNotEqualTo(String value) {
      addCriterion("agreementno <>", value, "agreementno");
      return ((AgreementExample.Criteria)this);
    }

    public AgreementExample.Criteria andAgreementnoGreaterThan(String value) {
      addCriterion("agreementno >", value, "agreementno");
      return ((AgreementExample.Criteria)this);
    }

    public AgreementExample.Criteria andAgreementnoGreaterThanOrEqualTo(String value) {
      addCriterion("agreementno >=", value, "agreementno");
      return ((AgreementExample.Criteria)this);
    }

    public AgreementExample.Criteria andAgreementnoLessThan(String value) {
      addCriterion("agreementno <", value, "agreementno");
      return ((AgreementExample.Criteria)this);
    }

    public AgreementExample.Criteria andAgreementnoLessThanOrEqualTo(String value) {
      addCriterion("agreementno <=", value, "agreementno");
      return ((AgreementExample.Criteria)this);
    }

    public AgreementExample.Criteria andAgreementnoLike(String value) {
      addCriterion("agreementno like", value, "agreementno");
      return ((AgreementExample.Criteria)this);
    }

    public AgreementExample.Criteria andAgreementnoNotLike(String value) {
      addCriterion("agreementno not like", value, "agreementno");
      return ((AgreementExample.Criteria)this);
    }

    public AgreementExample.Criteria andAgreementnoIn(List<String> values) {
      addCriterion("agreementno in", values, "agreementno");
      return ((AgreementExample.Criteria)this);
    }

    public AgreementExample.Criteria andAgreementnoNotIn(List<String> values) {
      addCriterion("agreementno not in", values, "agreementno");
      return ((AgreementExample.Criteria)this);
    }

    public AgreementExample.Criteria andAgreementnoBetween(String value1, String value2) {
      addCriterion("agreementno between", value1, value2, "agreementno");
      return ((AgreementExample.Criteria)this);
    }

    public AgreementExample.Criteria andAgreementnoNotBetween(String value1, String value2) {
      addCriterion("agreementno not between", value1, value2, "agreementno");
      return ((AgreementExample.Criteria)this);
    }

    public AgreementExample.Criteria andAgreementnameIsNull() {
      addCriterion("agreementname is null");
      return ((AgreementExample.Criteria)this);
    }

    public AgreementExample.Criteria andAgreementnameIsNotNull() {
      addCriterion("agreementname is not null");
      return ((AgreementExample.Criteria)this);
    }

    public AgreementExample.Criteria andAgreementnameEqualTo(String value) {
      addCriterion("agreementname =", value, "agreementname");
      return ((AgreementExample.Criteria)this);
    }

    public AgreementExample.Criteria andAgreementnameNotEqualTo(String value) {
      addCriterion("agreementname <>", value, "agreementname");
      return ((AgreementExample.Criteria)this);
    }

    public AgreementExample.Criteria andAgreementnameGreaterThan(String value) {
      addCriterion("agreementname >", value, "agreementname");
      return ((AgreementExample.Criteria)this);
    }

    public AgreementExample.Criteria andAgreementnameGreaterThanOrEqualTo(String value) {
      addCriterion("agreementname >=", value, "agreementname");
      return ((AgreementExample.Criteria)this);
    }

    public AgreementExample.Criteria andAgreementnameLessThan(String value) {
      addCriterion("agreementname <", value, "agreementname");
      return ((AgreementExample.Criteria)this);
    }

    public AgreementExample.Criteria andAgreementnameLessThanOrEqualTo(String value) {
      addCriterion("agreementname <=", value, "agreementname");
      return ((AgreementExample.Criteria)this);
    }

    public AgreementExample.Criteria andAgreementnameLike(String value) {
      addCriterion("agreementname like", value, "agreementname");
      return ((AgreementExample.Criteria)this);
    }

    public AgreementExample.Criteria andAgreementnameNotLike(String value) {
      addCriterion("agreementname not like", value, "agreementname");
      return ((AgreementExample.Criteria)this);
    }

    public AgreementExample.Criteria andAgreementnameIn(List<String> values) {
      addCriterion("agreementname in", values, "agreementname");
      return ((AgreementExample.Criteria)this);
    }

    public AgreementExample.Criteria andAgreementnameNotIn(List<String> values) {
      addCriterion("agreementname not in", values, "agreementname");
      return ((AgreementExample.Criteria)this);
    }

    public AgreementExample.Criteria andAgreementnameBetween(String value1, String value2) {
      addCriterion("agreementname between", value1, value2, "agreementname");
      return ((AgreementExample.Criteria)this);
    }

    public AgreementExample.Criteria andAgreementnameNotBetween(String value1, String value2) {
      addCriterion("agreementname not between", value1, value2, "agreementname");
      return ((AgreementExample.Criteria)this);
    }

    public AgreementExample.Criteria andSubjectIsNull() {
      addCriterion("subject is null");
      return ((AgreementExample.Criteria)this);
    }

    public AgreementExample.Criteria andSubjectIsNotNull() {
      addCriterion("subject is not null");
      return ((AgreementExample.Criteria)this);
    }

    public AgreementExample.Criteria andSubjectEqualTo(String value) {
      addCriterion("subject =", value, "subject");
      return ((AgreementExample.Criteria)this);
    }

    public AgreementExample.Criteria andSubjectNotEqualTo(String value) {
      addCriterion("subject <>", value, "subject");
      return ((AgreementExample.Criteria)this);
    }

    public AgreementExample.Criteria andSubjectGreaterThan(String value) {
      addCriterion("subject >", value, "subject");
      return ((AgreementExample.Criteria)this);
    }

    public AgreementExample.Criteria andSubjectGreaterThanOrEqualTo(String value) {
      addCriterion("subject >=", value, "subject");
      return ((AgreementExample.Criteria)this);
    }

    public AgreementExample.Criteria andSubjectLessThan(String value) {
      addCriterion("subject <", value, "subject");
      return ((AgreementExample.Criteria)this);
    }

    public AgreementExample.Criteria andSubjectLessThanOrEqualTo(String value) {
      addCriterion("subject <=", value, "subject");
      return ((AgreementExample.Criteria)this);
    }

    public AgreementExample.Criteria andSubjectLike(String value) {
      addCriterion("subject like", value, "subject");
      return ((AgreementExample.Criteria)this);
    }

    public AgreementExample.Criteria andSubjectNotLike(String value) {
      addCriterion("subject not like", value, "subject");
      return ((AgreementExample.Criteria)this);
    }

    public AgreementExample.Criteria andSubjectIn(List<String> values) {
      addCriterion("subject in", values, "subject");
      return ((AgreementExample.Criteria)this);
    }

    public AgreementExample.Criteria andSubjectNotIn(List<String> values) {
      addCriterion("subject not in", values, "subject");
      return ((AgreementExample.Criteria)this);
    }

    public AgreementExample.Criteria andSubjectBetween(String value1, String value2) {
      addCriterion("subject between", value1, value2, "subject");
      return ((AgreementExample.Criteria)this);
    }

    public AgreementExample.Criteria andSubjectNotBetween(String value1, String value2) {
      addCriterion("subject not between", value1, value2, "subject");
      return ((AgreementExample.Criteria)this);
    }

    public AgreementExample.Criteria andFileurlIsNull() {
      addCriterion("fileurl is null");
      return ((AgreementExample.Criteria)this);
    }

    public AgreementExample.Criteria andFileurlIsNotNull() {
      addCriterion("fileurl is not null");
      return ((AgreementExample.Criteria)this);
    }

    public AgreementExample.Criteria andFileurlEqualTo(String value) {
      addCriterion("fileurl =", value, "fileurl");
      return ((AgreementExample.Criteria)this);
    }

    public AgreementExample.Criteria andFileurlNotEqualTo(String value) {
      addCriterion("fileurl <>", value, "fileurl");
      return ((AgreementExample.Criteria)this);
    }

    public AgreementExample.Criteria andFileurlGreaterThan(String value) {
      addCriterion("fileurl >", value, "fileurl");
      return ((AgreementExample.Criteria)this);
    }

    public AgreementExample.Criteria andFileurlGreaterThanOrEqualTo(String value) {
      addCriterion("fileurl >=", value, "fileurl");
      return ((AgreementExample.Criteria)this);
    }

    public AgreementExample.Criteria andFileurlLessThan(String value) {
      addCriterion("fileurl <", value, "fileurl");
      return ((AgreementExample.Criteria)this);
    }

    public AgreementExample.Criteria andFileurlLessThanOrEqualTo(String value) {
      addCriterion("fileurl <=", value, "fileurl");
      return ((AgreementExample.Criteria)this);
    }

    public AgreementExample.Criteria andFileurlLike(String value) {
      addCriterion("fileurl like", value, "fileurl");
      return ((AgreementExample.Criteria)this);
    }

    public AgreementExample.Criteria andFileurlNotLike(String value) {
      addCriterion("fileurl not like", value, "fileurl");
      return ((AgreementExample.Criteria)this);
    }

    public AgreementExample.Criteria andFileurlIn(List<String> values) {
      addCriterion("fileurl in", values, "fileurl");
      return ((AgreementExample.Criteria)this);
    }

    public AgreementExample.Criteria andFileurlNotIn(List<String> values) {
      addCriterion("fileurl not in", values, "fileurl");
      return ((AgreementExample.Criteria)this);
    }

    public AgreementExample.Criteria andFileurlBetween(String value1, String value2) {
      addCriterion("fileurl between", value1, value2, "fileurl");
      return ((AgreementExample.Criteria)this);
    }

    public AgreementExample.Criteria andFileurlNotBetween(String value1, String value2) {
      addCriterion("fileurl not between", value1, value2, "fileurl");
      return ((AgreementExample.Criteria)this);
    }

    public AgreementExample.Criteria andRemarkIsNull() {
      addCriterion("remark is null");
      return ((AgreementExample.Criteria)this);
    }

    public AgreementExample.Criteria andRemarkIsNotNull() {
      addCriterion("remark is not null");
      return ((AgreementExample.Criteria)this);
    }

    public AgreementExample.Criteria andRemarkEqualTo(String value) {
      addCriterion("remark =", value, "remark");
      return ((AgreementExample.Criteria)this);
    }

    public AgreementExample.Criteria andRemarkNotEqualTo(String value) {
      addCriterion("remark <>", value, "remark");
      return ((AgreementExample.Criteria)this);
    }

    public AgreementExample.Criteria andRemarkGreaterThan(String value) {
      addCriterion("remark >", value, "remark");
      return ((AgreementExample.Criteria)this);
    }

    public AgreementExample.Criteria andRemarkGreaterThanOrEqualTo(String value) {
      addCriterion("remark >=", value, "remark");
      return ((AgreementExample.Criteria)this);
    }

    public AgreementExample.Criteria andRemarkLessThan(String value) {
      addCriterion("remark <", value, "remark");
      return ((AgreementExample.Criteria)this);
    }

    public AgreementExample.Criteria andRemarkLessThanOrEqualTo(String value) {
      addCriterion("remark <=", value, "remark");
      return ((AgreementExample.Criteria)this);
    }

    public AgreementExample.Criteria andRemarkLike(String value) {
      addCriterion("remark like", value, "remark");
      return ((AgreementExample.Criteria)this);
    }

    public AgreementExample.Criteria andRemarkNotLike(String value) {
      addCriterion("remark not like", value, "remark");
      return ((AgreementExample.Criteria)this);
    }

    public AgreementExample.Criteria andRemarkIn(List<String> values) {
      addCriterion("remark in", values, "remark");
      return ((AgreementExample.Criteria)this);
    }

    public AgreementExample.Criteria andRemarkNotIn(List<String> values) {
      addCriterion("remark not in", values, "remark");
      return ((AgreementExample.Criteria)this);
    }

    public AgreementExample.Criteria andRemarkBetween(String value1, String value2) {
      addCriterion("remark between", value1, value2, "remark");
      return ((AgreementExample.Criteria)this);
    }

    public AgreementExample.Criteria andRemarkNotBetween(String value1, String value2) {
      addCriterion("remark not between", value1, value2, "remark");
      return ((AgreementExample.Criteria)this);
    }
  }
}