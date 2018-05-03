package com.zjgt.p2p.report.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DailyStatExample {
    /**
     * orderByClausenull .
     *   dailystat
     *
     * @ET
     */
    protected String orderByClause;

    /**
     * distinctnull .
     *   dailystat
     *
     * @ET
     */
    protected boolean distinct;

    /**
     * oredCriterianull .
     *   dailystat
     *
     * @ET
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method:DailyStatExample
     *   dailystat
     *
     * @ET
     */
    public DailyStatExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method:setOrderByClause
     *   dailystat
     *
     * @ET
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method:getOrderByClause
     *   dailystat
     *
     * @ET
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method:setDistinct
     *   dailystat
     *
     * @ET
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method:isDistinct
     *   dailystat
     *
     * @ET
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method:getOredCriteria
     *   dailystat
     *
     * @ET
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method:or
     *   dailystat
     *
     * @ET
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method:or
     *   dailystat
     *
     * @ET
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method:createCriteria
     *   dailystat
     *
     * @ET
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method:createCriteriaInternal
     *   dailystat
     *
     * @ET
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method:clear
     *   dailystat
     *
     * @ET
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class:org.mybatis.generator.config.Context@6a15e1e1
     *  dailystat
     *
     * @ET
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

        public Criteria andCurrentdateIsNull() {
            addCriterion("currentDate is null");
            return (Criteria) this;
        }

        public Criteria andCurrentdateIsNotNull() {
            addCriterion("currentDate is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentdateEqualTo(Date value) {
            addCriterion("currentDate =", value, "currentdate");
            return (Criteria) this;
        }

        public Criteria andCurrentdateNotEqualTo(Date value) {
            addCriterion("currentDate <>", value, "currentdate");
            return (Criteria) this;
        }

        public Criteria andCurrentdateGreaterThan(Date value) {
            addCriterion("currentDate >", value, "currentdate");
            return (Criteria) this;
        }

        public Criteria andCurrentdateGreaterThanOrEqualTo(Date value) {
            addCriterion("currentDate >=", value, "currentdate");
            return (Criteria) this;
        }

        public Criteria andCurrentdateLessThan(Date value) {
            addCriterion("currentDate <", value, "currentdate");
            return (Criteria) this;
        }

        public Criteria andCurrentdateLessThanOrEqualTo(Date value) {
            addCriterion("currentDate <=", value, "currentdate");
            return (Criteria) this;
        }

        public Criteria andCurrentdateIn(List<Date> values) {
            addCriterion("currentDate in", values, "currentdate");
            return (Criteria) this;
        }

        public Criteria andCurrentdateNotIn(List<Date> values) {
            addCriterion("currentDate not in", values, "currentdate");
            return (Criteria) this;
        }

        public Criteria andCurrentdateBetween(Date value1, Date value2) {
            addCriterion("currentDate between", value1, value2, "currentdate");
            return (Criteria) this;
        }

        public Criteria andCurrentdateNotBetween(Date value1, Date value2) {
            addCriterion("currentDate not between", value1, value2, "currentdate");
            return (Criteria) this;
        }

        public Criteria andRegcntIsNull() {
            addCriterion("regcnt is null");
            return (Criteria) this;
        }

        public Criteria andRegcntIsNotNull() {
            addCriterion("regcnt is not null");
            return (Criteria) this;
        }

        public Criteria andRegcntEqualTo(Integer value) {
            addCriterion("regcnt =", value, "regcnt");
            return (Criteria) this;
        }

        public Criteria andRegcntNotEqualTo(Integer value) {
            addCriterion("regcnt <>", value, "regcnt");
            return (Criteria) this;
        }

        public Criteria andRegcntGreaterThan(Integer value) {
            addCriterion("regcnt >", value, "regcnt");
            return (Criteria) this;
        }

        public Criteria andRegcntGreaterThanOrEqualTo(Integer value) {
            addCriterion("regcnt >=", value, "regcnt");
            return (Criteria) this;
        }

        public Criteria andRegcntLessThan(Integer value) {
            addCriterion("regcnt <", value, "regcnt");
            return (Criteria) this;
        }

        public Criteria andRegcntLessThanOrEqualTo(Integer value) {
            addCriterion("regcnt <=", value, "regcnt");
            return (Criteria) this;
        }

        public Criteria andRegcntIn(List<Integer> values) {
            addCriterion("regcnt in", values, "regcnt");
            return (Criteria) this;
        }

        public Criteria andRegcntNotIn(List<Integer> values) {
            addCriterion("regcnt not in", values, "regcnt");
            return (Criteria) this;
        }

        public Criteria andRegcntBetween(Integer value1, Integer value2) {
            addCriterion("regcnt between", value1, value2, "regcnt");
            return (Criteria) this;
        }

        public Criteria andRegcntNotBetween(Integer value1, Integer value2) {
            addCriterion("regcnt not between", value1, value2, "regcnt");
            return (Criteria) this;
        }

        public Criteria andLogincntIsNull() {
            addCriterion("logincnt is null");
            return (Criteria) this;
        }

        public Criteria andLogincntIsNotNull() {
            addCriterion("logincnt is not null");
            return (Criteria) this;
        }

        public Criteria andLogincntEqualTo(Integer value) {
            addCriterion("logincnt =", value, "logincnt");
            return (Criteria) this;
        }

        public Criteria andLogincntNotEqualTo(Integer value) {
            addCriterion("logincnt <>", value, "logincnt");
            return (Criteria) this;
        }

        public Criteria andLogincntGreaterThan(Integer value) {
            addCriterion("logincnt >", value, "logincnt");
            return (Criteria) this;
        }

        public Criteria andLogincntGreaterThanOrEqualTo(Integer value) {
            addCriterion("logincnt >=", value, "logincnt");
            return (Criteria) this;
        }

        public Criteria andLogincntLessThan(Integer value) {
            addCriterion("logincnt <", value, "logincnt");
            return (Criteria) this;
        }

        public Criteria andLogincntLessThanOrEqualTo(Integer value) {
            addCriterion("logincnt <=", value, "logincnt");
            return (Criteria) this;
        }

        public Criteria andLogincntIn(List<Integer> values) {
            addCriterion("logincnt in", values, "logincnt");
            return (Criteria) this;
        }

        public Criteria andLogincntNotIn(List<Integer> values) {
            addCriterion("logincnt not in", values, "logincnt");
            return (Criteria) this;
        }

        public Criteria andLogincntBetween(Integer value1, Integer value2) {
            addCriterion("logincnt between", value1, value2, "logincnt");
            return (Criteria) this;
        }

        public Criteria andLogincntNotBetween(Integer value1, Integer value2) {
            addCriterion("logincnt not between", value1, value2, "logincnt");
            return (Criteria) this;
        }

        public Criteria andLogintimeIsNull() {
            addCriterion("logintime is null");
            return (Criteria) this;
        }

        public Criteria andLogintimeIsNotNull() {
            addCriterion("logintime is not null");
            return (Criteria) this;
        }

        public Criteria andLogintimeEqualTo(Integer value) {
            addCriterion("logintime =", value, "logintime");
            return (Criteria) this;
        }

        public Criteria andLogintimeNotEqualTo(Integer value) {
            addCriterion("logintime <>", value, "logintime");
            return (Criteria) this;
        }

        public Criteria andLogintimeGreaterThan(Integer value) {
            addCriterion("logintime >", value, "logintime");
            return (Criteria) this;
        }

        public Criteria andLogintimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("logintime >=", value, "logintime");
            return (Criteria) this;
        }

        public Criteria andLogintimeLessThan(Integer value) {
            addCriterion("logintime <", value, "logintime");
            return (Criteria) this;
        }

        public Criteria andLogintimeLessThanOrEqualTo(Integer value) {
            addCriterion("logintime <=", value, "logintime");
            return (Criteria) this;
        }

        public Criteria andLogintimeIn(List<Integer> values) {
            addCriterion("logintime in", values, "logintime");
            return (Criteria) this;
        }

        public Criteria andLogintimeNotIn(List<Integer> values) {
            addCriterion("logintime not in", values, "logintime");
            return (Criteria) this;
        }

        public Criteria andLogintimeBetween(Integer value1, Integer value2) {
            addCriterion("logintime between", value1, value2, "logintime");
            return (Criteria) this;
        }

        public Criteria andLogintimeNotBetween(Integer value1, Integer value2) {
            addCriterion("logintime not between", value1, value2, "logintime");
            return (Criteria) this;
        }

        public Criteria andCustomerslogincntIsNull() {
            addCriterion("customersLogincnt is null");
            return (Criteria) this;
        }

        public Criteria andCustomerslogincntIsNotNull() {
            addCriterion("customersLogincnt is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerslogincntEqualTo(Integer value) {
            addCriterion("customersLogincnt =", value, "customerslogincnt");
            return (Criteria) this;
        }

        public Criteria andCustomerslogincntNotEqualTo(Integer value) {
            addCriterion("customersLogincnt <>", value, "customerslogincnt");
            return (Criteria) this;
        }

        public Criteria andCustomerslogincntGreaterThan(Integer value) {
            addCriterion("customersLogincnt >", value, "customerslogincnt");
            return (Criteria) this;
        }

        public Criteria andCustomerslogincntGreaterThanOrEqualTo(Integer value) {
            addCriterion("customersLogincnt >=", value, "customerslogincnt");
            return (Criteria) this;
        }

        public Criteria andCustomerslogincntLessThan(Integer value) {
            addCriterion("customersLogincnt <", value, "customerslogincnt");
            return (Criteria) this;
        }

        public Criteria andCustomerslogincntLessThanOrEqualTo(Integer value) {
            addCriterion("customersLogincnt <=", value, "customerslogincnt");
            return (Criteria) this;
        }

        public Criteria andCustomerslogincntIn(List<Integer> values) {
            addCriterion("customersLogincnt in", values, "customerslogincnt");
            return (Criteria) this;
        }

        public Criteria andCustomerslogincntNotIn(List<Integer> values) {
            addCriterion("customersLogincnt not in", values, "customerslogincnt");
            return (Criteria) this;
        }

        public Criteria andCustomerslogincntBetween(Integer value1, Integer value2) {
            addCriterion("customersLogincnt between", value1, value2, "customerslogincnt");
            return (Criteria) this;
        }

        public Criteria andCustomerslogincntNotBetween(Integer value1, Integer value2) {
            addCriterion("customersLogincnt not between", value1, value2, "customerslogincnt");
            return (Criteria) this;
        }

        public Criteria andCustomerslogintimeIsNull() {
            addCriterion("customersLogintime is null");
            return (Criteria) this;
        }

        public Criteria andCustomerslogintimeIsNotNull() {
            addCriterion("customersLogintime is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerslogintimeEqualTo(Integer value) {
            addCriterion("customersLogintime =", value, "customerslogintime");
            return (Criteria) this;
        }

        public Criteria andCustomerslogintimeNotEqualTo(Integer value) {
            addCriterion("customersLogintime <>", value, "customerslogintime");
            return (Criteria) this;
        }

        public Criteria andCustomerslogintimeGreaterThan(Integer value) {
            addCriterion("customersLogintime >", value, "customerslogintime");
            return (Criteria) this;
        }

        public Criteria andCustomerslogintimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("customersLogintime >=", value, "customerslogintime");
            return (Criteria) this;
        }

        public Criteria andCustomerslogintimeLessThan(Integer value) {
            addCriterion("customersLogintime <", value, "customerslogintime");
            return (Criteria) this;
        }

        public Criteria andCustomerslogintimeLessThanOrEqualTo(Integer value) {
            addCriterion("customersLogintime <=", value, "customerslogintime");
            return (Criteria) this;
        }

        public Criteria andCustomerslogintimeIn(List<Integer> values) {
            addCriterion("customersLogintime in", values, "customerslogintime");
            return (Criteria) this;
        }

        public Criteria andCustomerslogintimeNotIn(List<Integer> values) {
            addCriterion("customersLogintime not in", values, "customerslogintime");
            return (Criteria) this;
        }

        public Criteria andCustomerslogintimeBetween(Integer value1, Integer value2) {
            addCriterion("customersLogintime between", value1, value2, "customerslogintime");
            return (Criteria) this;
        }

        public Criteria andCustomerslogintimeNotBetween(Integer value1, Integer value2) {
            addCriterion("customersLogintime not between", value1, value2, "customerslogintime");
            return (Criteria) this;
        }

        public Criteria andOpenactnumIsNull() {
            addCriterion("openActNum is null");
            return (Criteria) this;
        }

        public Criteria andOpenactnumIsNotNull() {
            addCriterion("openActNum is not null");
            return (Criteria) this;
        }

        public Criteria andOpenactnumEqualTo(Integer value) {
            addCriterion("openActNum =", value, "openactnum");
            return (Criteria) this;
        }

        public Criteria andOpenactnumNotEqualTo(Integer value) {
            addCriterion("openActNum <>", value, "openactnum");
            return (Criteria) this;
        }

        public Criteria andOpenactnumGreaterThan(Integer value) {
            addCriterion("openActNum >", value, "openactnum");
            return (Criteria) this;
        }

        public Criteria andOpenactnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("openActNum >=", value, "openactnum");
            return (Criteria) this;
        }

        public Criteria andOpenactnumLessThan(Integer value) {
            addCriterion("openActNum <", value, "openactnum");
            return (Criteria) this;
        }

        public Criteria andOpenactnumLessThanOrEqualTo(Integer value) {
            addCriterion("openActNum <=", value, "openactnum");
            return (Criteria) this;
        }

        public Criteria andOpenactnumIn(List<Integer> values) {
            addCriterion("openActNum in", values, "openactnum");
            return (Criteria) this;
        }

        public Criteria andOpenactnumNotIn(List<Integer> values) {
            addCriterion("openActNum not in", values, "openactnum");
            return (Criteria) this;
        }

        public Criteria andOpenactnumBetween(Integer value1, Integer value2) {
            addCriterion("openActNum between", value1, value2, "openactnum");
            return (Criteria) this;
        }

        public Criteria andOpenactnumNotBetween(Integer value1, Integer value2) {
            addCriterion("openActNum not between", value1, value2, "openactnum");
            return (Criteria) this;
        }

        public Criteria andPlatformrechargenumIsNull() {
            addCriterion("platformRechargeNum is null");
            return (Criteria) this;
        }

        public Criteria andPlatformrechargenumIsNotNull() {
            addCriterion("platformRechargeNum is not null");
            return (Criteria) this;
        }

        public Criteria andPlatformrechargenumEqualTo(Integer value) {
            addCriterion("platformRechargeNum =", value, "platformrechargenum");
            return (Criteria) this;
        }

        public Criteria andPlatformrechargenumNotEqualTo(Integer value) {
            addCriterion("platformRechargeNum <>", value, "platformrechargenum");
            return (Criteria) this;
        }

        public Criteria andPlatformrechargenumGreaterThan(Integer value) {
            addCriterion("platformRechargeNum >", value, "platformrechargenum");
            return (Criteria) this;
        }

        public Criteria andPlatformrechargenumGreaterThanOrEqualTo(Integer value) {
            addCriterion("platformRechargeNum >=", value, "platformrechargenum");
            return (Criteria) this;
        }

        public Criteria andPlatformrechargenumLessThan(Integer value) {
            addCriterion("platformRechargeNum <", value, "platformrechargenum");
            return (Criteria) this;
        }

        public Criteria andPlatformrechargenumLessThanOrEqualTo(Integer value) {
            addCriterion("platformRechargeNum <=", value, "platformrechargenum");
            return (Criteria) this;
        }

        public Criteria andPlatformrechargenumIn(List<Integer> values) {
            addCriterion("platformRechargeNum in", values, "platformrechargenum");
            return (Criteria) this;
        }

        public Criteria andPlatformrechargenumNotIn(List<Integer> values) {
            addCriterion("platformRechargeNum not in", values, "platformrechargenum");
            return (Criteria) this;
        }

        public Criteria andPlatformrechargenumBetween(Integer value1, Integer value2) {
            addCriterion("platformRechargeNum between", value1, value2, "platformrechargenum");
            return (Criteria) this;
        }

        public Criteria andPlatformrechargenumNotBetween(Integer value1, Integer value2) {
            addCriterion("platformRechargeNum not between", value1, value2, "platformrechargenum");
            return (Criteria) this;
        }

        public Criteria andPlatformrechargepernumIsNull() {
            addCriterion("platformRechargePerNum is null");
            return (Criteria) this;
        }

        public Criteria andPlatformrechargepernumIsNotNull() {
            addCriterion("platformRechargePerNum is not null");
            return (Criteria) this;
        }

        public Criteria andPlatformrechargepernumEqualTo(Integer value) {
            addCriterion("platformRechargePerNum =", value, "platformrechargepernum");
            return (Criteria) this;
        }

        public Criteria andPlatformrechargepernumNotEqualTo(Integer value) {
            addCriterion("platformRechargePerNum <>", value, "platformrechargepernum");
            return (Criteria) this;
        }

        public Criteria andPlatformrechargepernumGreaterThan(Integer value) {
            addCriterion("platformRechargePerNum >", value, "platformrechargepernum");
            return (Criteria) this;
        }

        public Criteria andPlatformrechargepernumGreaterThanOrEqualTo(Integer value) {
            addCriterion("platformRechargePerNum >=", value, "platformrechargepernum");
            return (Criteria) this;
        }

        public Criteria andPlatformrechargepernumLessThan(Integer value) {
            addCriterion("platformRechargePerNum <", value, "platformrechargepernum");
            return (Criteria) this;
        }

        public Criteria andPlatformrechargepernumLessThanOrEqualTo(Integer value) {
            addCriterion("platformRechargePerNum <=", value, "platformrechargepernum");
            return (Criteria) this;
        }

        public Criteria andPlatformrechargepernumIn(List<Integer> values) {
            addCriterion("platformRechargePerNum in", values, "platformrechargepernum");
            return (Criteria) this;
        }

        public Criteria andPlatformrechargepernumNotIn(List<Integer> values) {
            addCriterion("platformRechargePerNum not in", values, "platformrechargepernum");
            return (Criteria) this;
        }

        public Criteria andPlatformrechargepernumBetween(Integer value1, Integer value2) {
            addCriterion("platformRechargePerNum between", value1, value2, "platformrechargepernum");
            return (Criteria) this;
        }

        public Criteria andPlatformrechargepernumNotBetween(Integer value1, Integer value2) {
            addCriterion("platformRechargePerNum not between", value1, value2, "platformrechargepernum");
            return (Criteria) this;
        }

        public Criteria andPlatformrechargeamountIsNull() {
            addCriterion("platformRechargeAmount is null");
            return (Criteria) this;
        }

        public Criteria andPlatformrechargeamountIsNotNull() {
            addCriterion("platformRechargeAmount is not null");
            return (Criteria) this;
        }

        public Criteria andPlatformrechargeamountEqualTo(Double value) {
            addCriterion("platformRechargeAmount =", value, "platformrechargeamount");
            return (Criteria) this;
        }

        public Criteria andPlatformrechargeamountNotEqualTo(Double value) {
            addCriterion("platformRechargeAmount <>", value, "platformrechargeamount");
            return (Criteria) this;
        }

        public Criteria andPlatformrechargeamountGreaterThan(Double value) {
            addCriterion("platformRechargeAmount >", value, "platformrechargeamount");
            return (Criteria) this;
        }

        public Criteria andPlatformrechargeamountGreaterThanOrEqualTo(Double value) {
            addCriterion("platformRechargeAmount >=", value, "platformrechargeamount");
            return (Criteria) this;
        }

        public Criteria andPlatformrechargeamountLessThan(Double value) {
            addCriterion("platformRechargeAmount <", value, "platformrechargeamount");
            return (Criteria) this;
        }

        public Criteria andPlatformrechargeamountLessThanOrEqualTo(Double value) {
            addCriterion("platformRechargeAmount <=", value, "platformrechargeamount");
            return (Criteria) this;
        }

        public Criteria andPlatformrechargeamountIn(List<Double> values) {
            addCriterion("platformRechargeAmount in", values, "platformrechargeamount");
            return (Criteria) this;
        }

        public Criteria andPlatformrechargeamountNotIn(List<Double> values) {
            addCriterion("platformRechargeAmount not in", values, "platformrechargeamount");
            return (Criteria) this;
        }

        public Criteria andPlatformrechargeamountBetween(Double value1, Double value2) {
            addCriterion("platformRechargeAmount between", value1, value2, "platformrechargeamount");
            return (Criteria) this;
        }

        public Criteria andPlatformrechargeamountNotBetween(Double value1, Double value2) {
            addCriterion("platformRechargeAmount not between", value1, value2, "platformrechargeamount");
            return (Criteria) this;
        }

        public Criteria andFuyourechargenumIsNull() {
            addCriterion("fuyouRechargeNum is null");
            return (Criteria) this;
        }

        public Criteria andFuyourechargenumIsNotNull() {
            addCriterion("fuyouRechargeNum is not null");
            return (Criteria) this;
        }

        public Criteria andFuyourechargenumEqualTo(Integer value) {
            addCriterion("fuyouRechargeNum =", value, "fuyourechargenum");
            return (Criteria) this;
        }

        public Criteria andFuyourechargenumNotEqualTo(Integer value) {
            addCriterion("fuyouRechargeNum <>", value, "fuyourechargenum");
            return (Criteria) this;
        }

        public Criteria andFuyourechargenumGreaterThan(Integer value) {
            addCriterion("fuyouRechargeNum >", value, "fuyourechargenum");
            return (Criteria) this;
        }

        public Criteria andFuyourechargenumGreaterThanOrEqualTo(Integer value) {
            addCriterion("fuyouRechargeNum >=", value, "fuyourechargenum");
            return (Criteria) this;
        }

        public Criteria andFuyourechargenumLessThan(Integer value) {
            addCriterion("fuyouRechargeNum <", value, "fuyourechargenum");
            return (Criteria) this;
        }

        public Criteria andFuyourechargenumLessThanOrEqualTo(Integer value) {
            addCriterion("fuyouRechargeNum <=", value, "fuyourechargenum");
            return (Criteria) this;
        }

        public Criteria andFuyourechargenumIn(List<Integer> values) {
            addCriterion("fuyouRechargeNum in", values, "fuyourechargenum");
            return (Criteria) this;
        }

        public Criteria andFuyourechargenumNotIn(List<Integer> values) {
            addCriterion("fuyouRechargeNum not in", values, "fuyourechargenum");
            return (Criteria) this;
        }

        public Criteria andFuyourechargenumBetween(Integer value1, Integer value2) {
            addCriterion("fuyouRechargeNum between", value1, value2, "fuyourechargenum");
            return (Criteria) this;
        }

        public Criteria andFuyourechargenumNotBetween(Integer value1, Integer value2) {
            addCriterion("fuyouRechargeNum not between", value1, value2, "fuyourechargenum");
            return (Criteria) this;
        }

        public Criteria andFuyourechargepernumIsNull() {
            addCriterion("fuyouRechargePerNum is null");
            return (Criteria) this;
        }

        public Criteria andFuyourechargepernumIsNotNull() {
            addCriterion("fuyouRechargePerNum is not null");
            return (Criteria) this;
        }

        public Criteria andFuyourechargepernumEqualTo(Integer value) {
            addCriterion("fuyouRechargePerNum =", value, "fuyourechargepernum");
            return (Criteria) this;
        }

        public Criteria andFuyourechargepernumNotEqualTo(Integer value) {
            addCriterion("fuyouRechargePerNum <>", value, "fuyourechargepernum");
            return (Criteria) this;
        }

        public Criteria andFuyourechargepernumGreaterThan(Integer value) {
            addCriterion("fuyouRechargePerNum >", value, "fuyourechargepernum");
            return (Criteria) this;
        }

        public Criteria andFuyourechargepernumGreaterThanOrEqualTo(Integer value) {
            addCriterion("fuyouRechargePerNum >=", value, "fuyourechargepernum");
            return (Criteria) this;
        }

        public Criteria andFuyourechargepernumLessThan(Integer value) {
            addCriterion("fuyouRechargePerNum <", value, "fuyourechargepernum");
            return (Criteria) this;
        }

        public Criteria andFuyourechargepernumLessThanOrEqualTo(Integer value) {
            addCriterion("fuyouRechargePerNum <=", value, "fuyourechargepernum");
            return (Criteria) this;
        }

        public Criteria andFuyourechargepernumIn(List<Integer> values) {
            addCriterion("fuyouRechargePerNum in", values, "fuyourechargepernum");
            return (Criteria) this;
        }

        public Criteria andFuyourechargepernumNotIn(List<Integer> values) {
            addCriterion("fuyouRechargePerNum not in", values, "fuyourechargepernum");
            return (Criteria) this;
        }

        public Criteria andFuyourechargepernumBetween(Integer value1, Integer value2) {
            addCriterion("fuyouRechargePerNum between", value1, value2, "fuyourechargepernum");
            return (Criteria) this;
        }

        public Criteria andFuyourechargepernumNotBetween(Integer value1, Integer value2) {
            addCriterion("fuyouRechargePerNum not between", value1, value2, "fuyourechargepernum");
            return (Criteria) this;
        }

        public Criteria andFuyourechargeamountIsNull() {
            addCriterion("fuyouRechargeAmount is null");
            return (Criteria) this;
        }

        public Criteria andFuyourechargeamountIsNotNull() {
            addCriterion("fuyouRechargeAmount is not null");
            return (Criteria) this;
        }

        public Criteria andFuyourechargeamountEqualTo(Double value) {
            addCriterion("fuyouRechargeAmount =", value, "fuyourechargeamount");
            return (Criteria) this;
        }

        public Criteria andFuyourechargeamountNotEqualTo(Double value) {
            addCriterion("fuyouRechargeAmount <>", value, "fuyourechargeamount");
            return (Criteria) this;
        }

        public Criteria andFuyourechargeamountGreaterThan(Double value) {
            addCriterion("fuyouRechargeAmount >", value, "fuyourechargeamount");
            return (Criteria) this;
        }

        public Criteria andFuyourechargeamountGreaterThanOrEqualTo(Double value) {
            addCriterion("fuyouRechargeAmount >=", value, "fuyourechargeamount");
            return (Criteria) this;
        }

        public Criteria andFuyourechargeamountLessThan(Double value) {
            addCriterion("fuyouRechargeAmount <", value, "fuyourechargeamount");
            return (Criteria) this;
        }

        public Criteria andFuyourechargeamountLessThanOrEqualTo(Double value) {
            addCriterion("fuyouRechargeAmount <=", value, "fuyourechargeamount");
            return (Criteria) this;
        }

        public Criteria andFuyourechargeamountIn(List<Double> values) {
            addCriterion("fuyouRechargeAmount in", values, "fuyourechargeamount");
            return (Criteria) this;
        }

        public Criteria andFuyourechargeamountNotIn(List<Double> values) {
            addCriterion("fuyouRechargeAmount not in", values, "fuyourechargeamount");
            return (Criteria) this;
        }

        public Criteria andFuyourechargeamountBetween(Double value1, Double value2) {
            addCriterion("fuyouRechargeAmount between", value1, value2, "fuyourechargeamount");
            return (Criteria) this;
        }

        public Criteria andFuyourechargeamountNotBetween(Double value1, Double value2) {
            addCriterion("fuyouRechargeAmount not between", value1, value2, "fuyourechargeamount");
            return (Criteria) this;
        }

        public Criteria andInvestnumIsNull() {
            addCriterion("investNum is null");
            return (Criteria) this;
        }

        public Criteria andInvestnumIsNotNull() {
            addCriterion("investNum is not null");
            return (Criteria) this;
        }

        public Criteria andInvestnumEqualTo(Integer value) {
            addCriterion("investNum =", value, "investnum");
            return (Criteria) this;
        }

        public Criteria andInvestnumNotEqualTo(Integer value) {
            addCriterion("investNum <>", value, "investnum");
            return (Criteria) this;
        }

        public Criteria andInvestnumGreaterThan(Integer value) {
            addCriterion("investNum >", value, "investnum");
            return (Criteria) this;
        }

        public Criteria andInvestnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("investNum >=", value, "investnum");
            return (Criteria) this;
        }

        public Criteria andInvestnumLessThan(Integer value) {
            addCriterion("investNum <", value, "investnum");
            return (Criteria) this;
        }

        public Criteria andInvestnumLessThanOrEqualTo(Integer value) {
            addCriterion("investNum <=", value, "investnum");
            return (Criteria) this;
        }

        public Criteria andInvestnumIn(List<Integer> values) {
            addCriterion("investNum in", values, "investnum");
            return (Criteria) this;
        }

        public Criteria andInvestnumNotIn(List<Integer> values) {
            addCriterion("investNum not in", values, "investnum");
            return (Criteria) this;
        }

        public Criteria andInvestnumBetween(Integer value1, Integer value2) {
            addCriterion("investNum between", value1, value2, "investnum");
            return (Criteria) this;
        }

        public Criteria andInvestnumNotBetween(Integer value1, Integer value2) {
            addCriterion("investNum not between", value1, value2, "investnum");
            return (Criteria) this;
        }

        public Criteria andInvestpernumIsNull() {
            addCriterion("investPerNum is null");
            return (Criteria) this;
        }

        public Criteria andInvestpernumIsNotNull() {
            addCriterion("investPerNum is not null");
            return (Criteria) this;
        }

        public Criteria andInvestpernumEqualTo(Integer value) {
            addCriterion("investPerNum =", value, "investpernum");
            return (Criteria) this;
        }

        public Criteria andInvestpernumNotEqualTo(Integer value) {
            addCriterion("investPerNum <>", value, "investpernum");
            return (Criteria) this;
        }

        public Criteria andInvestpernumGreaterThan(Integer value) {
            addCriterion("investPerNum >", value, "investpernum");
            return (Criteria) this;
        }

        public Criteria andInvestpernumGreaterThanOrEqualTo(Integer value) {
            addCriterion("investPerNum >=", value, "investpernum");
            return (Criteria) this;
        }

        public Criteria andInvestpernumLessThan(Integer value) {
            addCriterion("investPerNum <", value, "investpernum");
            return (Criteria) this;
        }

        public Criteria andInvestpernumLessThanOrEqualTo(Integer value) {
            addCriterion("investPerNum <=", value, "investpernum");
            return (Criteria) this;
        }

        public Criteria andInvestpernumIn(List<Integer> values) {
            addCriterion("investPerNum in", values, "investpernum");
            return (Criteria) this;
        }

        public Criteria andInvestpernumNotIn(List<Integer> values) {
            addCriterion("investPerNum not in", values, "investpernum");
            return (Criteria) this;
        }

        public Criteria andInvestpernumBetween(Integer value1, Integer value2) {
            addCriterion("investPerNum between", value1, value2, "investpernum");
            return (Criteria) this;
        }

        public Criteria andInvestpernumNotBetween(Integer value1, Integer value2) {
            addCriterion("investPerNum not between", value1, value2, "investpernum");
            return (Criteria) this;
        }

        public Criteria andInvestamountIsNull() {
            addCriterion("investAmount is null");
            return (Criteria) this;
        }

        public Criteria andInvestamountIsNotNull() {
            addCriterion("investAmount is not null");
            return (Criteria) this;
        }

        public Criteria andInvestamountEqualTo(Double value) {
            addCriterion("investAmount =", value, "investamount");
            return (Criteria) this;
        }

        public Criteria andInvestamountNotEqualTo(Double value) {
            addCriterion("investAmount <>", value, "investamount");
            return (Criteria) this;
        }

        public Criteria andInvestamountGreaterThan(Double value) {
            addCriterion("investAmount >", value, "investamount");
            return (Criteria) this;
        }

        public Criteria andInvestamountGreaterThanOrEqualTo(Double value) {
            addCriterion("investAmount >=", value, "investamount");
            return (Criteria) this;
        }

        public Criteria andInvestamountLessThan(Double value) {
            addCriterion("investAmount <", value, "investamount");
            return (Criteria) this;
        }

        public Criteria andInvestamountLessThanOrEqualTo(Double value) {
            addCriterion("investAmount <=", value, "investamount");
            return (Criteria) this;
        }

        public Criteria andInvestamountIn(List<Double> values) {
            addCriterion("investAmount in", values, "investamount");
            return (Criteria) this;
        }

        public Criteria andInvestamountNotIn(List<Double> values) {
            addCriterion("investAmount not in", values, "investamount");
            return (Criteria) this;
        }

        public Criteria andInvestamountBetween(Double value1, Double value2) {
            addCriterion("investAmount between", value1, value2, "investamount");
            return (Criteria) this;
        }

        public Criteria andInvestamountNotBetween(Double value1, Double value2) {
            addCriterion("investAmount not between", value1, value2, "investamount");
            return (Criteria) this;
        }

        public Criteria andFirstinvestpernumIsNull() {
            addCriterion("firstInvestPerNum is null");
            return (Criteria) this;
        }

        public Criteria andFirstinvestpernumIsNotNull() {
            addCriterion("firstInvestPerNum is not null");
            return (Criteria) this;
        }

        public Criteria andFirstinvestpernumEqualTo(Integer value) {
            addCriterion("firstInvestPerNum =", value, "firstinvestpernum");
            return (Criteria) this;
        }

        public Criteria andFirstinvestpernumNotEqualTo(Integer value) {
            addCriterion("firstInvestPerNum <>", value, "firstinvestpernum");
            return (Criteria) this;
        }

        public Criteria andFirstinvestpernumGreaterThan(Integer value) {
            addCriterion("firstInvestPerNum >", value, "firstinvestpernum");
            return (Criteria) this;
        }

        public Criteria andFirstinvestpernumGreaterThanOrEqualTo(Integer value) {
            addCriterion("firstInvestPerNum >=", value, "firstinvestpernum");
            return (Criteria) this;
        }

        public Criteria andFirstinvestpernumLessThan(Integer value) {
            addCriterion("firstInvestPerNum <", value, "firstinvestpernum");
            return (Criteria) this;
        }

        public Criteria andFirstinvestpernumLessThanOrEqualTo(Integer value) {
            addCriterion("firstInvestPerNum <=", value, "firstinvestpernum");
            return (Criteria) this;
        }

        public Criteria andFirstinvestpernumIn(List<Integer> values) {
            addCriterion("firstInvestPerNum in", values, "firstinvestpernum");
            return (Criteria) this;
        }

        public Criteria andFirstinvestpernumNotIn(List<Integer> values) {
            addCriterion("firstInvestPerNum not in", values, "firstinvestpernum");
            return (Criteria) this;
        }

        public Criteria andFirstinvestpernumBetween(Integer value1, Integer value2) {
            addCriterion("firstInvestPerNum between", value1, value2, "firstinvestpernum");
            return (Criteria) this;
        }

        public Criteria andFirstinvestpernumNotBetween(Integer value1, Integer value2) {
            addCriterion("firstInvestPerNum not between", value1, value2, "firstinvestpernum");
            return (Criteria) this;
        }

        public Criteria andFirstinvestamountIsNull() {
            addCriterion("firstInvestAmount is null");
            return (Criteria) this;
        }

        public Criteria andFirstinvestamountIsNotNull() {
            addCriterion("firstInvestAmount is not null");
            return (Criteria) this;
        }

        public Criteria andFirstinvestamountEqualTo(Double value) {
            addCriterion("firstInvestAmount =", value, "firstinvestamount");
            return (Criteria) this;
        }

        public Criteria andFirstinvestamountNotEqualTo(Double value) {
            addCriterion("firstInvestAmount <>", value, "firstinvestamount");
            return (Criteria) this;
        }

        public Criteria andFirstinvestamountGreaterThan(Double value) {
            addCriterion("firstInvestAmount >", value, "firstinvestamount");
            return (Criteria) this;
        }

        public Criteria andFirstinvestamountGreaterThanOrEqualTo(Double value) {
            addCriterion("firstInvestAmount >=", value, "firstinvestamount");
            return (Criteria) this;
        }

        public Criteria andFirstinvestamountLessThan(Double value) {
            addCriterion("firstInvestAmount <", value, "firstinvestamount");
            return (Criteria) this;
        }

        public Criteria andFirstinvestamountLessThanOrEqualTo(Double value) {
            addCriterion("firstInvestAmount <=", value, "firstinvestamount");
            return (Criteria) this;
        }

        public Criteria andFirstinvestamountIn(List<Double> values) {
            addCriterion("firstInvestAmount in", values, "firstinvestamount");
            return (Criteria) this;
        }

        public Criteria andFirstinvestamountNotIn(List<Double> values) {
            addCriterion("firstInvestAmount not in", values, "firstinvestamount");
            return (Criteria) this;
        }

        public Criteria andFirstinvestamountBetween(Double value1, Double value2) {
            addCriterion("firstInvestAmount between", value1, value2, "firstinvestamount");
            return (Criteria) this;
        }

        public Criteria andFirstinvestamountNotBetween(Double value1, Double value2) {
            addCriterion("firstInvestAmount not between", value1, value2, "firstinvestamount");
            return (Criteria) this;
        }

        public Criteria andPlatformwithdrawnumIsNull() {
            addCriterion("platformWithdrawNum is null");
            return (Criteria) this;
        }

        public Criteria andPlatformwithdrawnumIsNotNull() {
            addCriterion("platformWithdrawNum is not null");
            return (Criteria) this;
        }

        public Criteria andPlatformwithdrawnumEqualTo(Integer value) {
            addCriterion("platformWithdrawNum =", value, "platformwithdrawnum");
            return (Criteria) this;
        }

        public Criteria andPlatformwithdrawnumNotEqualTo(Integer value) {
            addCriterion("platformWithdrawNum <>", value, "platformwithdrawnum");
            return (Criteria) this;
        }

        public Criteria andPlatformwithdrawnumGreaterThan(Integer value) {
            addCriterion("platformWithdrawNum >", value, "platformwithdrawnum");
            return (Criteria) this;
        }

        public Criteria andPlatformwithdrawnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("platformWithdrawNum >=", value, "platformwithdrawnum");
            return (Criteria) this;
        }

        public Criteria andPlatformwithdrawnumLessThan(Integer value) {
            addCriterion("platformWithdrawNum <", value, "platformwithdrawnum");
            return (Criteria) this;
        }

        public Criteria andPlatformwithdrawnumLessThanOrEqualTo(Integer value) {
            addCriterion("platformWithdrawNum <=", value, "platformwithdrawnum");
            return (Criteria) this;
        }

        public Criteria andPlatformwithdrawnumIn(List<Integer> values) {
            addCriterion("platformWithdrawNum in", values, "platformwithdrawnum");
            return (Criteria) this;
        }

        public Criteria andPlatformwithdrawnumNotIn(List<Integer> values) {
            addCriterion("platformWithdrawNum not in", values, "platformwithdrawnum");
            return (Criteria) this;
        }

        public Criteria andPlatformwithdrawnumBetween(Integer value1, Integer value2) {
            addCriterion("platformWithdrawNum between", value1, value2, "platformwithdrawnum");
            return (Criteria) this;
        }

        public Criteria andPlatformwithdrawnumNotBetween(Integer value1, Integer value2) {
            addCriterion("platformWithdrawNum not between", value1, value2, "platformwithdrawnum");
            return (Criteria) this;
        }

        public Criteria andPlatformwithdrawpernumberIsNull() {
            addCriterion("platformWithdrawPerNumber is null");
            return (Criteria) this;
        }

        public Criteria andPlatformwithdrawpernumberIsNotNull() {
            addCriterion("platformWithdrawPerNumber is not null");
            return (Criteria) this;
        }

        public Criteria andPlatformwithdrawpernumberEqualTo(Integer value) {
            addCriterion("platformWithdrawPerNumber =", value, "platformwithdrawpernumber");
            return (Criteria) this;
        }

        public Criteria andPlatformwithdrawpernumberNotEqualTo(Integer value) {
            addCriterion("platformWithdrawPerNumber <>", value, "platformwithdrawpernumber");
            return (Criteria) this;
        }

        public Criteria andPlatformwithdrawpernumberGreaterThan(Integer value) {
            addCriterion("platformWithdrawPerNumber >", value, "platformwithdrawpernumber");
            return (Criteria) this;
        }

        public Criteria andPlatformwithdrawpernumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("platformWithdrawPerNumber >=", value, "platformwithdrawpernumber");
            return (Criteria) this;
        }

        public Criteria andPlatformwithdrawpernumberLessThan(Integer value) {
            addCriterion("platformWithdrawPerNumber <", value, "platformwithdrawpernumber");
            return (Criteria) this;
        }

        public Criteria andPlatformwithdrawpernumberLessThanOrEqualTo(Integer value) {
            addCriterion("platformWithdrawPerNumber <=", value, "platformwithdrawpernumber");
            return (Criteria) this;
        }

        public Criteria andPlatformwithdrawpernumberIn(List<Integer> values) {
            addCriterion("platformWithdrawPerNumber in", values, "platformwithdrawpernumber");
            return (Criteria) this;
        }

        public Criteria andPlatformwithdrawpernumberNotIn(List<Integer> values) {
            addCriterion("platformWithdrawPerNumber not in", values, "platformwithdrawpernumber");
            return (Criteria) this;
        }

        public Criteria andPlatformwithdrawpernumberBetween(Integer value1, Integer value2) {
            addCriterion("platformWithdrawPerNumber between", value1, value2, "platformwithdrawpernumber");
            return (Criteria) this;
        }

        public Criteria andPlatformwithdrawpernumberNotBetween(Integer value1, Integer value2) {
            addCriterion("platformWithdrawPerNumber not between", value1, value2, "platformwithdrawpernumber");
            return (Criteria) this;
        }

        public Criteria andPlatformwithdrawamountIsNull() {
            addCriterion("platformWithdrawAmount is null");
            return (Criteria) this;
        }

        public Criteria andPlatformwithdrawamountIsNotNull() {
            addCriterion("platformWithdrawAmount is not null");
            return (Criteria) this;
        }

        public Criteria andPlatformwithdrawamountEqualTo(Double value) {
            addCriterion("platformWithdrawAmount =", value, "platformwithdrawamount");
            return (Criteria) this;
        }

        public Criteria andPlatformwithdrawamountNotEqualTo(Double value) {
            addCriterion("platformWithdrawAmount <>", value, "platformwithdrawamount");
            return (Criteria) this;
        }

        public Criteria andPlatformwithdrawamountGreaterThan(Double value) {
            addCriterion("platformWithdrawAmount >", value, "platformwithdrawamount");
            return (Criteria) this;
        }

        public Criteria andPlatformwithdrawamountGreaterThanOrEqualTo(Double value) {
            addCriterion("platformWithdrawAmount >=", value, "platformwithdrawamount");
            return (Criteria) this;
        }

        public Criteria andPlatformwithdrawamountLessThan(Double value) {
            addCriterion("platformWithdrawAmount <", value, "platformwithdrawamount");
            return (Criteria) this;
        }

        public Criteria andPlatformwithdrawamountLessThanOrEqualTo(Double value) {
            addCriterion("platformWithdrawAmount <=", value, "platformwithdrawamount");
            return (Criteria) this;
        }

        public Criteria andPlatformwithdrawamountIn(List<Double> values) {
            addCriterion("platformWithdrawAmount in", values, "platformwithdrawamount");
            return (Criteria) this;
        }

        public Criteria andPlatformwithdrawamountNotIn(List<Double> values) {
            addCriterion("platformWithdrawAmount not in", values, "platformwithdrawamount");
            return (Criteria) this;
        }

        public Criteria andPlatformwithdrawamountBetween(Double value1, Double value2) {
            addCriterion("platformWithdrawAmount between", value1, value2, "platformwithdrawamount");
            return (Criteria) this;
        }

        public Criteria andPlatformwithdrawamountNotBetween(Double value1, Double value2) {
            addCriterion("platformWithdrawAmount not between", value1, value2, "platformwithdrawamount");
            return (Criteria) this;
        }

        public Criteria andFuyouwithdrawnumIsNull() {
            addCriterion("fuyouWithdrawNum is null");
            return (Criteria) this;
        }

        public Criteria andFuyouwithdrawnumIsNotNull() {
            addCriterion("fuyouWithdrawNum is not null");
            return (Criteria) this;
        }

        public Criteria andFuyouwithdrawnumEqualTo(Integer value) {
            addCriterion("fuyouWithdrawNum =", value, "fuyouwithdrawnum");
            return (Criteria) this;
        }

        public Criteria andFuyouwithdrawnumNotEqualTo(Integer value) {
            addCriterion("fuyouWithdrawNum <>", value, "fuyouwithdrawnum");
            return (Criteria) this;
        }

        public Criteria andFuyouwithdrawnumGreaterThan(Integer value) {
            addCriterion("fuyouWithdrawNum >", value, "fuyouwithdrawnum");
            return (Criteria) this;
        }

        public Criteria andFuyouwithdrawnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("fuyouWithdrawNum >=", value, "fuyouwithdrawnum");
            return (Criteria) this;
        }

        public Criteria andFuyouwithdrawnumLessThan(Integer value) {
            addCriterion("fuyouWithdrawNum <", value, "fuyouwithdrawnum");
            return (Criteria) this;
        }

        public Criteria andFuyouwithdrawnumLessThanOrEqualTo(Integer value) {
            addCriterion("fuyouWithdrawNum <=", value, "fuyouwithdrawnum");
            return (Criteria) this;
        }

        public Criteria andFuyouwithdrawnumIn(List<Integer> values) {
            addCriterion("fuyouWithdrawNum in", values, "fuyouwithdrawnum");
            return (Criteria) this;
        }

        public Criteria andFuyouwithdrawnumNotIn(List<Integer> values) {
            addCriterion("fuyouWithdrawNum not in", values, "fuyouwithdrawnum");
            return (Criteria) this;
        }

        public Criteria andFuyouwithdrawnumBetween(Integer value1, Integer value2) {
            addCriterion("fuyouWithdrawNum between", value1, value2, "fuyouwithdrawnum");
            return (Criteria) this;
        }

        public Criteria andFuyouwithdrawnumNotBetween(Integer value1, Integer value2) {
            addCriterion("fuyouWithdrawNum not between", value1, value2, "fuyouwithdrawnum");
            return (Criteria) this;
        }

        public Criteria andFuyouwithdrawpernumberIsNull() {
            addCriterion("fuyouWithdrawPerNumber is null");
            return (Criteria) this;
        }

        public Criteria andFuyouwithdrawpernumberIsNotNull() {
            addCriterion("fuyouWithdrawPerNumber is not null");
            return (Criteria) this;
        }

        public Criteria andFuyouwithdrawpernumberEqualTo(Integer value) {
            addCriterion("fuyouWithdrawPerNumber =", value, "fuyouwithdrawpernumber");
            return (Criteria) this;
        }

        public Criteria andFuyouwithdrawpernumberNotEqualTo(Integer value) {
            addCriterion("fuyouWithdrawPerNumber <>", value, "fuyouwithdrawpernumber");
            return (Criteria) this;
        }

        public Criteria andFuyouwithdrawpernumberGreaterThan(Integer value) {
            addCriterion("fuyouWithdrawPerNumber >", value, "fuyouwithdrawpernumber");
            return (Criteria) this;
        }

        public Criteria andFuyouwithdrawpernumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("fuyouWithdrawPerNumber >=", value, "fuyouwithdrawpernumber");
            return (Criteria) this;
        }

        public Criteria andFuyouwithdrawpernumberLessThan(Integer value) {
            addCriterion("fuyouWithdrawPerNumber <", value, "fuyouwithdrawpernumber");
            return (Criteria) this;
        }

        public Criteria andFuyouwithdrawpernumberLessThanOrEqualTo(Integer value) {
            addCriterion("fuyouWithdrawPerNumber <=", value, "fuyouwithdrawpernumber");
            return (Criteria) this;
        }

        public Criteria andFuyouwithdrawpernumberIn(List<Integer> values) {
            addCriterion("fuyouWithdrawPerNumber in", values, "fuyouwithdrawpernumber");
            return (Criteria) this;
        }

        public Criteria andFuyouwithdrawpernumberNotIn(List<Integer> values) {
            addCriterion("fuyouWithdrawPerNumber not in", values, "fuyouwithdrawpernumber");
            return (Criteria) this;
        }

        public Criteria andFuyouwithdrawpernumberBetween(Integer value1, Integer value2) {
            addCriterion("fuyouWithdrawPerNumber between", value1, value2, "fuyouwithdrawpernumber");
            return (Criteria) this;
        }

        public Criteria andFuyouwithdrawpernumberNotBetween(Integer value1, Integer value2) {
            addCriterion("fuyouWithdrawPerNumber not between", value1, value2, "fuyouwithdrawpernumber");
            return (Criteria) this;
        }

        public Criteria andFuyouwithdrawamountIsNull() {
            addCriterion("fuyouWithdrawAmount is null");
            return (Criteria) this;
        }

        public Criteria andFuyouwithdrawamountIsNotNull() {
            addCriterion("fuyouWithdrawAmount is not null");
            return (Criteria) this;
        }

        public Criteria andFuyouwithdrawamountEqualTo(Double value) {
            addCriterion("fuyouWithdrawAmount =", value, "fuyouwithdrawamount");
            return (Criteria) this;
        }

        public Criteria andFuyouwithdrawamountNotEqualTo(Double value) {
            addCriterion("fuyouWithdrawAmount <>", value, "fuyouwithdrawamount");
            return (Criteria) this;
        }

        public Criteria andFuyouwithdrawamountGreaterThan(Double value) {
            addCriterion("fuyouWithdrawAmount >", value, "fuyouwithdrawamount");
            return (Criteria) this;
        }

        public Criteria andFuyouwithdrawamountGreaterThanOrEqualTo(Double value) {
            addCriterion("fuyouWithdrawAmount >=", value, "fuyouwithdrawamount");
            return (Criteria) this;
        }

        public Criteria andFuyouwithdrawamountLessThan(Double value) {
            addCriterion("fuyouWithdrawAmount <", value, "fuyouwithdrawamount");
            return (Criteria) this;
        }

        public Criteria andFuyouwithdrawamountLessThanOrEqualTo(Double value) {
            addCriterion("fuyouWithdrawAmount <=", value, "fuyouwithdrawamount");
            return (Criteria) this;
        }

        public Criteria andFuyouwithdrawamountIn(List<Double> values) {
            addCriterion("fuyouWithdrawAmount in", values, "fuyouwithdrawamount");
            return (Criteria) this;
        }

        public Criteria andFuyouwithdrawamountNotIn(List<Double> values) {
            addCriterion("fuyouWithdrawAmount not in", values, "fuyouwithdrawamount");
            return (Criteria) this;
        }

        public Criteria andFuyouwithdrawamountBetween(Double value1, Double value2) {
            addCriterion("fuyouWithdrawAmount between", value1, value2, "fuyouwithdrawamount");
            return (Criteria) this;
        }

        public Criteria andFuyouwithdrawamountNotBetween(Double value1, Double value2) {
            addCriterion("fuyouWithdrawAmount not between", value1, value2, "fuyouwithdrawamount");
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

        public Criteria andCreatedateIsNull() {
            addCriterion("createDate is null");
            return (Criteria) this;
        }

        public Criteria andCreatedateIsNotNull() {
            addCriterion("createDate is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedateEqualTo(Date value) {
            addCriterion("createDate =", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotEqualTo(Date value) {
            addCriterion("createDate <>", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateGreaterThan(Date value) {
            addCriterion("createDate >", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateGreaterThanOrEqualTo(Date value) {
            addCriterion("createDate >=", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateLessThan(Date value) {
            addCriterion("createDate <", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateLessThanOrEqualTo(Date value) {
            addCriterion("createDate <=", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateIn(List<Date> values) {
            addCriterion("createDate in", values, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotIn(List<Date> values) {
            addCriterion("createDate not in", values, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateBetween(Date value1, Date value2) {
            addCriterion("createDate between", value1, value2, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotBetween(Date value1, Date value2) {
            addCriterion("createDate not between", value1, value2, "createdate");
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
    }

    /**
     * This class:org.mybatis.generator.config.Context@6a15e1e1
     *  dailystat
     *
     * @ET do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class:org.mybatis.generator.config.Context@6a15e1e1
     *  dailystat
     *
     * @ET
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