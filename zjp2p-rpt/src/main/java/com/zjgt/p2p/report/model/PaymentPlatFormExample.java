package com.zjgt.p2p.report.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PaymentPlatFormExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table paymentplatform
     *
     * @mbggenerated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table paymentplatform
     *
     * @mbggenerated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table paymentplatform
     *
     * @mbggenerated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table paymentplatform
     *
     * @mbggenerated
     */
    public PaymentPlatFormExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table paymentplatform
     *
     * @mbggenerated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table paymentplatform
     *
     * @mbggenerated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table paymentplatform
     *
     * @mbggenerated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table paymentplatform
     *
     * @mbggenerated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table paymentplatform
     *
     * @mbggenerated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table paymentplatform
     *
     * @mbggenerated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table paymentplatform
     *
     * @mbggenerated
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table paymentplatform
     *
     * @mbggenerated
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table paymentplatform
     *
     * @mbggenerated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table paymentplatform
     *
     * @mbggenerated
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table paymentplatform
     *
     * @mbggenerated
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andPlatformIsNull() {
            addCriterion("platForm is null");
            return (Criteria) this;
        }

        public Criteria andPlatformIsNotNull() {
            addCriterion("platForm is not null");
            return (Criteria) this;
        }

        public Criteria andPlatformEqualTo(String value) {
            addCriterion("platForm =", value, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformNotEqualTo(String value) {
            addCriterion("platForm <>", value, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformGreaterThan(String value) {
            addCriterion("platForm >", value, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformGreaterThanOrEqualTo(String value) {
            addCriterion("platForm >=", value, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformLessThan(String value) {
            addCriterion("platForm <", value, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformLessThanOrEqualTo(String value) {
            addCriterion("platForm <=", value, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformLike(String value) {
            addCriterion("platForm like", value, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformNotLike(String value) {
            addCriterion("platForm not like", value, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformIn(List<String> values) {
            addCriterion("platForm in", values, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformNotIn(List<String> values) {
            addCriterion("platForm not in", values, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformBetween(String value1, String value2) {
            addCriterion("platForm between", value1, value2, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformNotBetween(String value1, String value2) {
            addCriterion("platForm not between", value1, value2, "platform");
            return (Criteria) this;
        }

        public Criteria andInteresttypeIsNull() {
            addCriterion("interestType is null");
            return (Criteria) this;
        }

        public Criteria andInteresttypeIsNotNull() {
            addCriterion("interestType is not null");
            return (Criteria) this;
        }

        public Criteria andInteresttypeEqualTo(String value) {
            addCriterion("interestType =", value, "interesttype");
            return (Criteria) this;
        }

        public Criteria andInteresttypeNotEqualTo(String value) {
            addCriterion("interestType <>", value, "interesttype");
            return (Criteria) this;
        }

        public Criteria andInteresttypeGreaterThan(String value) {
            addCriterion("interestType >", value, "interesttype");
            return (Criteria) this;
        }

        public Criteria andInteresttypeGreaterThanOrEqualTo(String value) {
            addCriterion("interestType >=", value, "interesttype");
            return (Criteria) this;
        }

        public Criteria andInteresttypeLessThan(String value) {
            addCriterion("interestType <", value, "interesttype");
            return (Criteria) this;
        }

        public Criteria andInteresttypeLessThanOrEqualTo(String value) {
            addCriterion("interestType <=", value, "interesttype");
            return (Criteria) this;
        }

        public Criteria andInteresttypeLike(String value) {
            addCriterion("interestType like", value, "interesttype");
            return (Criteria) this;
        }

        public Criteria andInteresttypeNotLike(String value) {
            addCriterion("interestType not like", value, "interesttype");
            return (Criteria) this;
        }

        public Criteria andInteresttypeIn(List<String> values) {
            addCriterion("interestType in", values, "interesttype");
            return (Criteria) this;
        }

        public Criteria andInteresttypeNotIn(List<String> values) {
            addCriterion("interestType not in", values, "interesttype");
            return (Criteria) this;
        }

        public Criteria andInteresttypeBetween(String value1, String value2) {
            addCriterion("interestType between", value1, value2, "interesttype");
            return (Criteria) this;
        }

        public Criteria andInteresttypeNotBetween(String value1, String value2) {
            addCriterion("interestType not between", value1, value2, "interesttype");
            return (Criteria) this;
        }

        public Criteria andComputingmethodIsNull() {
            addCriterion("computingMethod is null");
            return (Criteria) this;
        }

        public Criteria andComputingmethodIsNotNull() {
            addCriterion("computingMethod is not null");
            return (Criteria) this;
        }

        public Criteria andComputingmethodEqualTo(String value) {
            addCriterion("computingMethod =", value, "computingmethod");
            return (Criteria) this;
        }

        public Criteria andComputingmethodNotEqualTo(String value) {
            addCriterion("computingMethod <>", value, "computingmethod");
            return (Criteria) this;
        }

        public Criteria andComputingmethodGreaterThan(String value) {
            addCriterion("computingMethod >", value, "computingmethod");
            return (Criteria) this;
        }

        public Criteria andComputingmethodGreaterThanOrEqualTo(String value) {
            addCriterion("computingMethod >=", value, "computingmethod");
            return (Criteria) this;
        }

        public Criteria andComputingmethodLessThan(String value) {
            addCriterion("computingMethod <", value, "computingmethod");
            return (Criteria) this;
        }

        public Criteria andComputingmethodLessThanOrEqualTo(String value) {
            addCriterion("computingMethod <=", value, "computingmethod");
            return (Criteria) this;
        }

        public Criteria andComputingmethodLike(String value) {
            addCriterion("computingMethod like", value, "computingmethod");
            return (Criteria) this;
        }

        public Criteria andComputingmethodNotLike(String value) {
            addCriterion("computingMethod not like", value, "computingmethod");
            return (Criteria) this;
        }

        public Criteria andComputingmethodIn(List<String> values) {
            addCriterion("computingMethod in", values, "computingmethod");
            return (Criteria) this;
        }

        public Criteria andComputingmethodNotIn(List<String> values) {
            addCriterion("computingMethod not in", values, "computingmethod");
            return (Criteria) this;
        }

        public Criteria andComputingmethodBetween(String value1, String value2) {
            addCriterion("computingMethod between", value1, value2, "computingmethod");
            return (Criteria) this;
        }

        public Criteria andComputingmethodNotBetween(String value1, String value2) {
            addCriterion("computingMethod not between", value1, value2, "computingmethod");
            return (Criteria) this;
        }

        public Criteria andPaymentinterestIsNull() {
            addCriterion("payMentInterest is null");
            return (Criteria) this;
        }

        public Criteria andPaymentinterestIsNotNull() {
            addCriterion("payMentInterest is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentinterestEqualTo(BigDecimal value) {
            addCriterion("payMentInterest =", value, "paymentinterest");
            return (Criteria) this;
        }

        public Criteria andPaymentinterestNotEqualTo(BigDecimal value) {
            addCriterion("payMentInterest <>", value, "paymentinterest");
            return (Criteria) this;
        }

        public Criteria andPaymentinterestGreaterThan(BigDecimal value) {
            addCriterion("payMentInterest >", value, "paymentinterest");
            return (Criteria) this;
        }

        public Criteria andPaymentinterestGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("payMentInterest >=", value, "paymentinterest");
            return (Criteria) this;
        }

        public Criteria andPaymentinterestLessThan(BigDecimal value) {
            addCriterion("payMentInterest <", value, "paymentinterest");
            return (Criteria) this;
        }

        public Criteria andPaymentinterestLessThanOrEqualTo(BigDecimal value) {
            addCriterion("payMentInterest <=", value, "paymentinterest");
            return (Criteria) this;
        }

        public Criteria andPaymentinterestIn(List<BigDecimal> values) {
            addCriterion("payMentInterest in", values, "paymentinterest");
            return (Criteria) this;
        }

        public Criteria andPaymentinterestNotIn(List<BigDecimal> values) {
            addCriterion("payMentInterest not in", values, "paymentinterest");
            return (Criteria) this;
        }

        public Criteria andPaymentinterestBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("payMentInterest between", value1, value2, "paymentinterest");
            return (Criteria) this;
        }

        public Criteria andPaymentinterestNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("payMentInterest not between", value1, value2, "paymentinterest");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andTemp1IsNull() {
            addCriterion("temp1 is null");
            return (Criteria) this;
        }

        public Criteria andTemp1IsNotNull() {
            addCriterion("temp1 is not null");
            return (Criteria) this;
        }

        public Criteria andTemp1EqualTo(String value) {
            addCriterion("temp1 =", value, "temp1");
            return (Criteria) this;
        }

        public Criteria andTemp1NotEqualTo(String value) {
            addCriterion("temp1 <>", value, "temp1");
            return (Criteria) this;
        }

        public Criteria andTemp1GreaterThan(String value) {
            addCriterion("temp1 >", value, "temp1");
            return (Criteria) this;
        }

        public Criteria andTemp1GreaterThanOrEqualTo(String value) {
            addCriterion("temp1 >=", value, "temp1");
            return (Criteria) this;
        }

        public Criteria andTemp1LessThan(String value) {
            addCriterion("temp1 <", value, "temp1");
            return (Criteria) this;
        }

        public Criteria andTemp1LessThanOrEqualTo(String value) {
            addCriterion("temp1 <=", value, "temp1");
            return (Criteria) this;
        }

        public Criteria andTemp1Like(String value) {
            addCriterion("temp1 like", value, "temp1");
            return (Criteria) this;
        }

        public Criteria andTemp1NotLike(String value) {
            addCriterion("temp1 not like", value, "temp1");
            return (Criteria) this;
        }

        public Criteria andTemp1In(List<String> values) {
            addCriterion("temp1 in", values, "temp1");
            return (Criteria) this;
        }

        public Criteria andTemp1NotIn(List<String> values) {
            addCriterion("temp1 not in", values, "temp1");
            return (Criteria) this;
        }

        public Criteria andTemp1Between(String value1, String value2) {
            addCriterion("temp1 between", value1, value2, "temp1");
            return (Criteria) this;
        }

        public Criteria andTemp1NotBetween(String value1, String value2) {
            addCriterion("temp1 not between", value1, value2, "temp1");
            return (Criteria) this;
        }

        public Criteria andTemp2IsNull() {
            addCriterion("temp2 is null");
            return (Criteria) this;
        }

        public Criteria andTemp2IsNotNull() {
            addCriterion("temp2 is not null");
            return (Criteria) this;
        }

        public Criteria andTemp2EqualTo(String value) {
            addCriterion("temp2 =", value, "temp2");
            return (Criteria) this;
        }

        public Criteria andTemp2NotEqualTo(String value) {
            addCriterion("temp2 <>", value, "temp2");
            return (Criteria) this;
        }

        public Criteria andTemp2GreaterThan(String value) {
            addCriterion("temp2 >", value, "temp2");
            return (Criteria) this;
        }

        public Criteria andTemp2GreaterThanOrEqualTo(String value) {
            addCriterion("temp2 >=", value, "temp2");
            return (Criteria) this;
        }

        public Criteria andTemp2LessThan(String value) {
            addCriterion("temp2 <", value, "temp2");
            return (Criteria) this;
        }

        public Criteria andTemp2LessThanOrEqualTo(String value) {
            addCriterion("temp2 <=", value, "temp2");
            return (Criteria) this;
        }

        public Criteria andTemp2Like(String value) {
            addCriterion("temp2 like", value, "temp2");
            return (Criteria) this;
        }

        public Criteria andTemp2NotLike(String value) {
            addCriterion("temp2 not like", value, "temp2");
            return (Criteria) this;
        }

        public Criteria andTemp2In(List<String> values) {
            addCriterion("temp2 in", values, "temp2");
            return (Criteria) this;
        }

        public Criteria andTemp2NotIn(List<String> values) {
            addCriterion("temp2 not in", values, "temp2");
            return (Criteria) this;
        }

        public Criteria andTemp2Between(String value1, String value2) {
            addCriterion("temp2 between", value1, value2, "temp2");
            return (Criteria) this;
        }

        public Criteria andTemp2NotBetween(String value1, String value2) {
            addCriterion("temp2 not between", value1, value2, "temp2");
            return (Criteria) this;
        }

        public Criteria andTemp3IsNull() {
            addCriterion("temp3 is null");
            return (Criteria) this;
        }

        public Criteria andTemp3IsNotNull() {
            addCriterion("temp3 is not null");
            return (Criteria) this;
        }

        public Criteria andTemp3EqualTo(String value) {
            addCriterion("temp3 =", value, "temp3");
            return (Criteria) this;
        }

        public Criteria andTemp3NotEqualTo(String value) {
            addCriterion("temp3 <>", value, "temp3");
            return (Criteria) this;
        }

        public Criteria andTemp3GreaterThan(String value) {
            addCriterion("temp3 >", value, "temp3");
            return (Criteria) this;
        }

        public Criteria andTemp3GreaterThanOrEqualTo(String value) {
            addCriterion("temp3 >=", value, "temp3");
            return (Criteria) this;
        }

        public Criteria andTemp3LessThan(String value) {
            addCriterion("temp3 <", value, "temp3");
            return (Criteria) this;
        }

        public Criteria andTemp3LessThanOrEqualTo(String value) {
            addCriterion("temp3 <=", value, "temp3");
            return (Criteria) this;
        }

        public Criteria andTemp3Like(String value) {
            addCriterion("temp3 like", value, "temp3");
            return (Criteria) this;
        }

        public Criteria andTemp3NotLike(String value) {
            addCriterion("temp3 not like", value, "temp3");
            return (Criteria) this;
        }

        public Criteria andTemp3In(List<String> values) {
            addCriterion("temp3 in", values, "temp3");
            return (Criteria) this;
        }

        public Criteria andTemp3NotIn(List<String> values) {
            addCriterion("temp3 not in", values, "temp3");
            return (Criteria) this;
        }

        public Criteria andTemp3Between(String value1, String value2) {
            addCriterion("temp3 between", value1, value2, "temp3");
            return (Criteria) this;
        }

        public Criteria andTemp3NotBetween(String value1, String value2) {
            addCriterion("temp3 not between", value1, value2, "temp3");
            return (Criteria) this;
        }

        public Criteria andTemp4IsNull() {
            addCriterion("temp4 is null");
            return (Criteria) this;
        }

        public Criteria andTemp4IsNotNull() {
            addCriterion("temp4 is not null");
            return (Criteria) this;
        }

        public Criteria andTemp4EqualTo(String value) {
            addCriterion("temp4 =", value, "temp4");
            return (Criteria) this;
        }

        public Criteria andTemp4NotEqualTo(String value) {
            addCriterion("temp4 <>", value, "temp4");
            return (Criteria) this;
        }

        public Criteria andTemp4GreaterThan(String value) {
            addCriterion("temp4 >", value, "temp4");
            return (Criteria) this;
        }

        public Criteria andTemp4GreaterThanOrEqualTo(String value) {
            addCriterion("temp4 >=", value, "temp4");
            return (Criteria) this;
        }

        public Criteria andTemp4LessThan(String value) {
            addCriterion("temp4 <", value, "temp4");
            return (Criteria) this;
        }

        public Criteria andTemp4LessThanOrEqualTo(String value) {
            addCriterion("temp4 <=", value, "temp4");
            return (Criteria) this;
        }

        public Criteria andTemp4Like(String value) {
            addCriterion("temp4 like", value, "temp4");
            return (Criteria) this;
        }

        public Criteria andTemp4NotLike(String value) {
            addCriterion("temp4 not like", value, "temp4");
            return (Criteria) this;
        }

        public Criteria andTemp4In(List<String> values) {
            addCriterion("temp4 in", values, "temp4");
            return (Criteria) this;
        }

        public Criteria andTemp4NotIn(List<String> values) {
            addCriterion("temp4 not in", values, "temp4");
            return (Criteria) this;
        }

        public Criteria andTemp4Between(String value1, String value2) {
            addCriterion("temp4 between", value1, value2, "temp4");
            return (Criteria) this;
        }

        public Criteria andTemp4NotBetween(String value1, String value2) {
            addCriterion("temp4 not between", value1, value2, "temp4");
            return (Criteria) this;
        }

        public Criteria andTemp5IsNull() {
            addCriterion("temp5 is null");
            return (Criteria) this;
        }

        public Criteria andTemp5IsNotNull() {
            addCriterion("temp5 is not null");
            return (Criteria) this;
        }

        public Criteria andTemp5EqualTo(String value) {
            addCriterion("temp5 =", value, "temp5");
            return (Criteria) this;
        }

        public Criteria andTemp5NotEqualTo(String value) {
            addCriterion("temp5 <>", value, "temp5");
            return (Criteria) this;
        }

        public Criteria andTemp5GreaterThan(String value) {
            addCriterion("temp5 >", value, "temp5");
            return (Criteria) this;
        }

        public Criteria andTemp5GreaterThanOrEqualTo(String value) {
            addCriterion("temp5 >=", value, "temp5");
            return (Criteria) this;
        }

        public Criteria andTemp5LessThan(String value) {
            addCriterion("temp5 <", value, "temp5");
            return (Criteria) this;
        }

        public Criteria andTemp5LessThanOrEqualTo(String value) {
            addCriterion("temp5 <=", value, "temp5");
            return (Criteria) this;
        }

        public Criteria andTemp5Like(String value) {
            addCriterion("temp5 like", value, "temp5");
            return (Criteria) this;
        }

        public Criteria andTemp5NotLike(String value) {
            addCriterion("temp5 not like", value, "temp5");
            return (Criteria) this;
        }

        public Criteria andTemp5In(List<String> values) {
            addCriterion("temp5 in", values, "temp5");
            return (Criteria) this;
        }

        public Criteria andTemp5NotIn(List<String> values) {
            addCriterion("temp5 not in", values, "temp5");
            return (Criteria) this;
        }

        public Criteria andTemp5Between(String value1, String value2) {
            addCriterion("temp5 between", value1, value2, "temp5");
            return (Criteria) this;
        }

        public Criteria andTemp5NotBetween(String value1, String value2) {
            addCriterion("temp5 not between", value1, value2, "temp5");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table paymentplatform
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table paymentplatform
     *
     * @mbggenerated
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
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
}