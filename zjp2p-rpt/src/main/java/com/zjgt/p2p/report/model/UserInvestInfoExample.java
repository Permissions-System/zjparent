package com.zjgt.p2p.report.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserInvestInfoExample {
    /**
     * orderByClausenull .
     *   userinvestinfo
     *
     * @ET
     */
    protected String orderByClause;

    /**
     * distinctnull .
     *   userinvestinfo
     *
     * @ET
     */
    protected boolean distinct;

    /**
     * oredCriterianull .
     *   userinvestinfo
     *
     * @ET
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method:UserInvestInfoExample
     *   userinvestinfo
     *
     * @ET
     */
    public UserInvestInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method:setOrderByClause
     *   userinvestinfo
     *
     * @ET
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method:getOrderByClause
     *   userinvestinfo
     *
     * @ET
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method:setDistinct
     *   userinvestinfo
     *
     * @ET
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method:isDistinct
     *   userinvestinfo
     *
     * @ET
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method:getOredCriteria
     *   userinvestinfo
     *
     * @ET
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method:or
     *   userinvestinfo
     *
     * @ET
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method:or
     *   userinvestinfo
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
     *   userinvestinfo
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
     *   userinvestinfo
     *
     * @ET
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method:clear
     *   userinvestinfo
     *
     * @ET
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class:org.mybatis.generator.config.Context@c325b
     *  userinvestinfo
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

        public Criteria andMembernameIsNull() {
            addCriterion("memberName is null");
            return (Criteria) this;
        }

        public Criteria andMembernameIsNotNull() {
            addCriterion("memberName is not null");
            return (Criteria) this;
        }

        public Criteria andMembernameEqualTo(String value) {
            addCriterion("memberName =", value, "membername");
            return (Criteria) this;
        }

        public Criteria andMembernameNotEqualTo(String value) {
            addCriterion("memberName <>", value, "membername");
            return (Criteria) this;
        }

        public Criteria andMembernameGreaterThan(String value) {
            addCriterion("memberName >", value, "membername");
            return (Criteria) this;
        }

        public Criteria andMembernameGreaterThanOrEqualTo(String value) {
            addCriterion("memberName >=", value, "membername");
            return (Criteria) this;
        }

        public Criteria andMembernameLessThan(String value) {
            addCriterion("memberName <", value, "membername");
            return (Criteria) this;
        }

        public Criteria andMembernameLessThanOrEqualTo(String value) {
            addCriterion("memberName <=", value, "membername");
            return (Criteria) this;
        }

        public Criteria andMembernameLike(String value) {
            addCriterion("memberName like", value, "membername");
            return (Criteria) this;
        }

        public Criteria andMembernameNotLike(String value) {
            addCriterion("memberName not like", value, "membername");
            return (Criteria) this;
        }

        public Criteria andMembernameIn(List<String> values) {
            addCriterion("memberName in", values, "membername");
            return (Criteria) this;
        }

        public Criteria andMembernameNotIn(List<String> values) {
            addCriterion("memberName not in", values, "membername");
            return (Criteria) this;
        }

        public Criteria andMembernameBetween(String value1, String value2) {
            addCriterion("memberName between", value1, value2, "membername");
            return (Criteria) this;
        }

        public Criteria andMembernameNotBetween(String value1, String value2) {
            addCriterion("memberName not between", value1, value2, "membername");
            return (Criteria) this;
        }

        public Criteria andRealnameIsNull() {
            addCriterion("realName is null");
            return (Criteria) this;
        }

        public Criteria andRealnameIsNotNull() {
            addCriterion("realName is not null");
            return (Criteria) this;
        }

        public Criteria andRealnameEqualTo(String value) {
            addCriterion("realName =", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameNotEqualTo(String value) {
            addCriterion("realName <>", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameGreaterThan(String value) {
            addCriterion("realName >", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameGreaterThanOrEqualTo(String value) {
            addCriterion("realName >=", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameLessThan(String value) {
            addCriterion("realName <", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameLessThanOrEqualTo(String value) {
            addCriterion("realName <=", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameLike(String value) {
            addCriterion("realName like", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameNotLike(String value) {
            addCriterion("realName not like", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameIn(List<String> values) {
            addCriterion("realName in", values, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameNotIn(List<String> values) {
            addCriterion("realName not in", values, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameBetween(String value1, String value2) {
            addCriterion("realName between", value1, value2, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameNotBetween(String value1, String value2) {
            addCriterion("realName not between", value1, value2, "realname");
            return (Criteria) this;
        }

        public Criteria andMobileIsNull() {
            addCriterion("mobile is null");
            return (Criteria) this;
        }

        public Criteria andMobileIsNotNull() {
            addCriterion("mobile is not null");
            return (Criteria) this;
        }

        public Criteria andMobileEqualTo(String value) {
            addCriterion("mobile =", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotEqualTo(String value) {
            addCriterion("mobile <>", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThan(String value) {
            addCriterion("mobile >", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThanOrEqualTo(String value) {
            addCriterion("mobile >=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThan(String value) {
            addCriterion("mobile <", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThanOrEqualTo(String value) {
            addCriterion("mobile <=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLike(String value) {
            addCriterion("mobile like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotLike(String value) {
            addCriterion("mobile not like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileIn(List<String> values) {
            addCriterion("mobile in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotIn(List<String> values) {
            addCriterion("mobile not in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileBetween(String value1, String value2) {
            addCriterion("mobile between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotBetween(String value1, String value2) {
            addCriterion("mobile not between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andHasfuiouIsNull() {
            addCriterion("HasFuiou is null");
            return (Criteria) this;
        }

        public Criteria andHasfuiouIsNotNull() {
            addCriterion("HasFuiou is not null");
            return (Criteria) this;
        }

        public Criteria andHasfuiouEqualTo(Integer value) {
            addCriterion("HasFuiou =", value, "hasfuiou");
            return (Criteria) this;
        }

        public Criteria andHasfuiouNotEqualTo(Integer value) {
            addCriterion("HasFuiou <>", value, "hasfuiou");
            return (Criteria) this;
        }

        public Criteria andHasfuiouGreaterThan(Integer value) {
            addCriterion("HasFuiou >", value, "hasfuiou");
            return (Criteria) this;
        }

        public Criteria andHasfuiouGreaterThanOrEqualTo(Integer value) {
            addCriterion("HasFuiou >=", value, "hasfuiou");
            return (Criteria) this;
        }

        public Criteria andHasfuiouLessThan(Integer value) {
            addCriterion("HasFuiou <", value, "hasfuiou");
            return (Criteria) this;
        }

        public Criteria andHasfuiouLessThanOrEqualTo(Integer value) {
            addCriterion("HasFuiou <=", value, "hasfuiou");
            return (Criteria) this;
        }

        public Criteria andHasfuiouIn(List<Integer> values) {
            addCriterion("HasFuiou in", values, "hasfuiou");
            return (Criteria) this;
        }

        public Criteria andHasfuiouNotIn(List<Integer> values) {
            addCriterion("HasFuiou not in", values, "hasfuiou");
            return (Criteria) this;
        }

        public Criteria andHasfuiouBetween(Integer value1, Integer value2) {
            addCriterion("HasFuiou between", value1, value2, "hasfuiou");
            return (Criteria) this;
        }

        public Criteria andHasfuiouNotBetween(Integer value1, Integer value2) {
            addCriterion("HasFuiou not between", value1, value2, "hasfuiou");
            return (Criteria) this;
        }

        public Criteria andRegtimeIsNull() {
            addCriterion("regTime is null");
            return (Criteria) this;
        }

        public Criteria andRegtimeIsNotNull() {
            addCriterion("regTime is not null");
            return (Criteria) this;
        }

        public Criteria andRegtimeEqualTo(Date value) {
            addCriterion("regTime =", value, "regtime");
            return (Criteria) this;
        }

        public Criteria andRegtimeNotEqualTo(Date value) {
            addCriterion("regTime <>", value, "regtime");
            return (Criteria) this;
        }

        public Criteria andRegtimeGreaterThan(Date value) {
            addCriterion("regTime >", value, "regtime");
            return (Criteria) this;
        }

        public Criteria andRegtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("regTime >=", value, "regtime");
            return (Criteria) this;
        }

        public Criteria andRegtimeLessThan(Date value) {
            addCriterion("regTime <", value, "regtime");
            return (Criteria) this;
        }

        public Criteria andRegtimeLessThanOrEqualTo(Date value) {
            addCriterion("regTime <=", value, "regtime");
            return (Criteria) this;
        }

        public Criteria andRegtimeIn(List<Date> values) {
            addCriterion("regTime in", values, "regtime");
            return (Criteria) this;
        }

        public Criteria andRegtimeNotIn(List<Date> values) {
            addCriterion("regTime not in", values, "regtime");
            return (Criteria) this;
        }

        public Criteria andRegtimeBetween(Date value1, Date value2) {
            addCriterion("regTime between", value1, value2, "regtime");
            return (Criteria) this;
        }

        public Criteria andRegtimeNotBetween(Date value1, Date value2) {
            addCriterion("regTime not between", value1, value2, "regtime");
            return (Criteria) this;
        }

        public Criteria andNearlyinvestmoneyIsNull() {
            addCriterion("nearlyInvestMoney is null");
            return (Criteria) this;
        }

        public Criteria andNearlyinvestmoneyIsNotNull() {
            addCriterion("nearlyInvestMoney is not null");
            return (Criteria) this;
        }

        public Criteria andNearlyinvestmoneyEqualTo(BigDecimal value) {
            addCriterion("nearlyInvestMoney =", value, "nearlyinvestmoney");
            return (Criteria) this;
        }

        public Criteria andNearlyinvestmoneyNotEqualTo(BigDecimal value) {
            addCriterion("nearlyInvestMoney <>", value, "nearlyinvestmoney");
            return (Criteria) this;
        }

        public Criteria andNearlyinvestmoneyGreaterThan(BigDecimal value) {
            addCriterion("nearlyInvestMoney >", value, "nearlyinvestmoney");
            return (Criteria) this;
        }

        public Criteria andNearlyinvestmoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("nearlyInvestMoney >=", value, "nearlyinvestmoney");
            return (Criteria) this;
        }

        public Criteria andNearlyinvestmoneyLessThan(BigDecimal value) {
            addCriterion("nearlyInvestMoney <", value, "nearlyinvestmoney");
            return (Criteria) this;
        }

        public Criteria andNearlyinvestmoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("nearlyInvestMoney <=", value, "nearlyinvestmoney");
            return (Criteria) this;
        }

        public Criteria andNearlyinvestmoneyIn(List<BigDecimal> values) {
            addCriterion("nearlyInvestMoney in", values, "nearlyinvestmoney");
            return (Criteria) this;
        }

        public Criteria andNearlyinvestmoneyNotIn(List<BigDecimal> values) {
            addCriterion("nearlyInvestMoney not in", values, "nearlyinvestmoney");
            return (Criteria) this;
        }

        public Criteria andNearlyinvestmoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("nearlyInvestMoney between", value1, value2, "nearlyinvestmoney");
            return (Criteria) this;
        }

        public Criteria andNearlyinvestmoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("nearlyInvestMoney not between", value1, value2, "nearlyinvestmoney");
            return (Criteria) this;
        }

        public Criteria andNearlyinvesttimeIsNull() {
            addCriterion("nearlyInvestTime is null");
            return (Criteria) this;
        }

        public Criteria andNearlyinvesttimeIsNotNull() {
            addCriterion("nearlyInvestTime is not null");
            return (Criteria) this;
        }

        public Criteria andNearlyinvesttimeEqualTo(Date value) {
            addCriterion("nearlyInvestTime =", value, "nearlyinvesttime");
            return (Criteria) this;
        }

        public Criteria andNearlyinvesttimeNotEqualTo(Date value) {
            addCriterion("nearlyInvestTime <>", value, "nearlyinvesttime");
            return (Criteria) this;
        }

        public Criteria andNearlyinvesttimeGreaterThan(Date value) {
            addCriterion("nearlyInvestTime >", value, "nearlyinvesttime");
            return (Criteria) this;
        }

        public Criteria andNearlyinvesttimeGreaterThanOrEqualTo(Date value) {
            addCriterion("nearlyInvestTime >=", value, "nearlyinvesttime");
            return (Criteria) this;
        }

        public Criteria andNearlyinvesttimeLessThan(Date value) {
            addCriterion("nearlyInvestTime <", value, "nearlyinvesttime");
            return (Criteria) this;
        }

        public Criteria andNearlyinvesttimeLessThanOrEqualTo(Date value) {
            addCriterion("nearlyInvestTime <=", value, "nearlyinvesttime");
            return (Criteria) this;
        }

        public Criteria andNearlyinvesttimeIn(List<Date> values) {
            addCriterion("nearlyInvestTime in", values, "nearlyinvesttime");
            return (Criteria) this;
        }

        public Criteria andNearlyinvesttimeNotIn(List<Date> values) {
            addCriterion("nearlyInvestTime not in", values, "nearlyinvesttime");
            return (Criteria) this;
        }

        public Criteria andNearlyinvesttimeBetween(Date value1, Date value2) {
            addCriterion("nearlyInvestTime between", value1, value2, "nearlyinvesttime");
            return (Criteria) this;
        }

        public Criteria andNearlyinvesttimeNotBetween(Date value1, Date value2) {
            addCriterion("nearlyInvestTime not between", value1, value2, "nearlyinvesttime");
            return (Criteria) this;
        }

        public Criteria andFirstinvestmoneyIsNull() {
            addCriterion("firstInvestMoney is null");
            return (Criteria) this;
        }

        public Criteria andFirstinvestmoneyIsNotNull() {
            addCriterion("firstInvestMoney is not null");
            return (Criteria) this;
        }

        public Criteria andFirstinvestmoneyEqualTo(BigDecimal value) {
            addCriterion("firstInvestMoney =", value, "firstinvestmoney");
            return (Criteria) this;
        }

        public Criteria andFirstinvestmoneyNotEqualTo(BigDecimal value) {
            addCriterion("firstInvestMoney <>", value, "firstinvestmoney");
            return (Criteria) this;
        }

        public Criteria andFirstinvestmoneyGreaterThan(BigDecimal value) {
            addCriterion("firstInvestMoney >", value, "firstinvestmoney");
            return (Criteria) this;
        }

        public Criteria andFirstinvestmoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("firstInvestMoney >=", value, "firstinvestmoney");
            return (Criteria) this;
        }

        public Criteria andFirstinvestmoneyLessThan(BigDecimal value) {
            addCriterion("firstInvestMoney <", value, "firstinvestmoney");
            return (Criteria) this;
        }

        public Criteria andFirstinvestmoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("firstInvestMoney <=", value, "firstinvestmoney");
            return (Criteria) this;
        }

        public Criteria andFirstinvestmoneyIn(List<BigDecimal> values) {
            addCriterion("firstInvestMoney in", values, "firstinvestmoney");
            return (Criteria) this;
        }

        public Criteria andFirstinvestmoneyNotIn(List<BigDecimal> values) {
            addCriterion("firstInvestMoney not in", values, "firstinvestmoney");
            return (Criteria) this;
        }

        public Criteria andFirstinvestmoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("firstInvestMoney between", value1, value2, "firstinvestmoney");
            return (Criteria) this;
        }

        public Criteria andFirstinvestmoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("firstInvestMoney not between", value1, value2, "firstinvestmoney");
            return (Criteria) this;
        }

        public Criteria andFirstinvesttimeIsNull() {
            addCriterion("firstInvestTime is null");
            return (Criteria) this;
        }

        public Criteria andFirstinvesttimeIsNotNull() {
            addCriterion("firstInvestTime is not null");
            return (Criteria) this;
        }

        public Criteria andFirstinvesttimeEqualTo(Date value) {
            addCriterion("firstInvestTime =", value, "firstinvesttime");
            return (Criteria) this;
        }

        public Criteria andFirstinvesttimeNotEqualTo(Date value) {
            addCriterion("firstInvestTime <>", value, "firstinvesttime");
            return (Criteria) this;
        }

        public Criteria andFirstinvesttimeGreaterThan(Date value) {
            addCriterion("firstInvestTime >", value, "firstinvesttime");
            return (Criteria) this;
        }

        public Criteria andFirstinvesttimeGreaterThanOrEqualTo(Date value) {
            addCriterion("firstInvestTime >=", value, "firstinvesttime");
            return (Criteria) this;
        }

        public Criteria andFirstinvesttimeLessThan(Date value) {
            addCriterion("firstInvestTime <", value, "firstinvesttime");
            return (Criteria) this;
        }

        public Criteria andFirstinvesttimeLessThanOrEqualTo(Date value) {
            addCriterion("firstInvestTime <=", value, "firstinvesttime");
            return (Criteria) this;
        }

        public Criteria andFirstinvesttimeIn(List<Date> values) {
            addCriterion("firstInvestTime in", values, "firstinvesttime");
            return (Criteria) this;
        }

        public Criteria andFirstinvesttimeNotIn(List<Date> values) {
            addCriterion("firstInvestTime not in", values, "firstinvesttime");
            return (Criteria) this;
        }

        public Criteria andFirstinvesttimeBetween(Date value1, Date value2) {
            addCriterion("firstInvestTime between", value1, value2, "firstinvesttime");
            return (Criteria) this;
        }

        public Criteria andFirstinvesttimeNotBetween(Date value1, Date value2) {
            addCriterion("firstInvestTime not between", value1, value2, "firstinvesttime");
            return (Criteria) this;
        }

        public Criteria andRecommendpersonIsNull() {
            addCriterion("recommendPerson is null");
            return (Criteria) this;
        }

        public Criteria andRecommendpersonIsNotNull() {
            addCriterion("recommendPerson is not null");
            return (Criteria) this;
        }

        public Criteria andRecommendpersonEqualTo(String value) {
            addCriterion("recommendPerson =", value, "recommendperson");
            return (Criteria) this;
        }

        public Criteria andRecommendpersonNotEqualTo(String value) {
            addCriterion("recommendPerson <>", value, "recommendperson");
            return (Criteria) this;
        }

        public Criteria andRecommendpersonGreaterThan(String value) {
            addCriterion("recommendPerson >", value, "recommendperson");
            return (Criteria) this;
        }

        public Criteria andRecommendpersonGreaterThanOrEqualTo(String value) {
            addCriterion("recommendPerson >=", value, "recommendperson");
            return (Criteria) this;
        }

        public Criteria andRecommendpersonLessThan(String value) {
            addCriterion("recommendPerson <", value, "recommendperson");
            return (Criteria) this;
        }

        public Criteria andRecommendpersonLessThanOrEqualTo(String value) {
            addCriterion("recommendPerson <=", value, "recommendperson");
            return (Criteria) this;
        }

        public Criteria andRecommendpersonLike(String value) {
            addCriterion("recommendPerson like", value, "recommendperson");
            return (Criteria) this;
        }

        public Criteria andRecommendpersonNotLike(String value) {
            addCriterion("recommendPerson not like", value, "recommendperson");
            return (Criteria) this;
        }

        public Criteria andRecommendpersonIn(List<String> values) {
            addCriterion("recommendPerson in", values, "recommendperson");
            return (Criteria) this;
        }

        public Criteria andRecommendpersonNotIn(List<String> values) {
            addCriterion("recommendPerson not in", values, "recommendperson");
            return (Criteria) this;
        }

        public Criteria andRecommendpersonBetween(String value1, String value2) {
            addCriterion("recommendPerson between", value1, value2, "recommendperson");
            return (Criteria) this;
        }

        public Criteria andRecommendpersonNotBetween(String value1, String value2) {
            addCriterion("recommendPerson not between", value1, value2, "recommendperson");
            return (Criteria) this;
        }

        public Criteria andRecommendcodeIsNull() {
            addCriterion("recommendCode is null");
            return (Criteria) this;
        }

        public Criteria andRecommendcodeIsNotNull() {
            addCriterion("recommendCode is not null");
            return (Criteria) this;
        }

        public Criteria andRecommendcodeEqualTo(String value) {
            addCriterion("recommendCode =", value, "recommendcode");
            return (Criteria) this;
        }

        public Criteria andRecommendcodeNotEqualTo(String value) {
            addCriterion("recommendCode <>", value, "recommendcode");
            return (Criteria) this;
        }

        public Criteria andRecommendcodeGreaterThan(String value) {
            addCriterion("recommendCode >", value, "recommendcode");
            return (Criteria) this;
        }

        public Criteria andRecommendcodeGreaterThanOrEqualTo(String value) {
            addCriterion("recommendCode >=", value, "recommendcode");
            return (Criteria) this;
        }

        public Criteria andRecommendcodeLessThan(String value) {
            addCriterion("recommendCode <", value, "recommendcode");
            return (Criteria) this;
        }

        public Criteria andRecommendcodeLessThanOrEqualTo(String value) {
            addCriterion("recommendCode <=", value, "recommendcode");
            return (Criteria) this;
        }

        public Criteria andRecommendcodeLike(String value) {
            addCriterion("recommendCode like", value, "recommendcode");
            return (Criteria) this;
        }

        public Criteria andRecommendcodeNotLike(String value) {
            addCriterion("recommendCode not like", value, "recommendcode");
            return (Criteria) this;
        }

        public Criteria andRecommendcodeIn(List<String> values) {
            addCriterion("recommendCode in", values, "recommendcode");
            return (Criteria) this;
        }

        public Criteria andRecommendcodeNotIn(List<String> values) {
            addCriterion("recommendCode not in", values, "recommendcode");
            return (Criteria) this;
        }

        public Criteria andRecommendcodeBetween(String value1, String value2) {
            addCriterion("recommendCode between", value1, value2, "recommendcode");
            return (Criteria) this;
        }

        public Criteria andRecommendcodeNotBetween(String value1, String value2) {
            addCriterion("recommendCode not between", value1, value2, "recommendcode");
            return (Criteria) this;
        }

        public Criteria andPromotecodeIsNull() {
            addCriterion("promoteCode is null");
            return (Criteria) this;
        }

        public Criteria andPromotecodeIsNotNull() {
            addCriterion("promoteCode is not null");
            return (Criteria) this;
        }

        public Criteria andPromotecodeEqualTo(String value) {
            addCriterion("promoteCode =", value, "promotecode");
            return (Criteria) this;
        }

        public Criteria andPromotecodeNotEqualTo(String value) {
            addCriterion("promoteCode <>", value, "promotecode");
            return (Criteria) this;
        }

        public Criteria andPromotecodeGreaterThan(String value) {
            addCriterion("promoteCode >", value, "promotecode");
            return (Criteria) this;
        }

        public Criteria andPromotecodeGreaterThanOrEqualTo(String value) {
            addCriterion("promoteCode >=", value, "promotecode");
            return (Criteria) this;
        }

        public Criteria andPromotecodeLessThan(String value) {
            addCriterion("promoteCode <", value, "promotecode");
            return (Criteria) this;
        }

        public Criteria andPromotecodeLessThanOrEqualTo(String value) {
            addCriterion("promoteCode <=", value, "promotecode");
            return (Criteria) this;
        }

        public Criteria andPromotecodeLike(String value) {
            addCriterion("promoteCode like", value, "promotecode");
            return (Criteria) this;
        }

        public Criteria andPromotecodeNotLike(String value) {
            addCriterion("promoteCode not like", value, "promotecode");
            return (Criteria) this;
        }

        public Criteria andPromotecodeIn(List<String> values) {
            addCriterion("promoteCode in", values, "promotecode");
            return (Criteria) this;
        }

        public Criteria andPromotecodeNotIn(List<String> values) {
            addCriterion("promoteCode not in", values, "promotecode");
            return (Criteria) this;
        }

        public Criteria andPromotecodeBetween(String value1, String value2) {
            addCriterion("promoteCode between", value1, value2, "promotecode");
            return (Criteria) this;
        }

        public Criteria andPromotecodeNotBetween(String value1, String value2) {
            addCriterion("promoteCode not between", value1, value2, "promotecode");
            return (Criteria) this;
        }

        public Criteria andIdentityIsNull() {
            addCriterion("identity is null");
            return (Criteria) this;
        }

        public Criteria andIdentityIsNotNull() {
            addCriterion("identity is not null");
            return (Criteria) this;
        }

        public Criteria andIdentityEqualTo(String value) {
            addCriterion("identity =", value, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityNotEqualTo(String value) {
            addCriterion("identity <>", value, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityGreaterThan(String value) {
            addCriterion("identity >", value, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityGreaterThanOrEqualTo(String value) {
            addCriterion("identity >=", value, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityLessThan(String value) {
            addCriterion("identity <", value, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityLessThanOrEqualTo(String value) {
            addCriterion("identity <=", value, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityLike(String value) {
            addCriterion("identity like", value, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityNotLike(String value) {
            addCriterion("identity not like", value, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityIn(List<String> values) {
            addCriterion("identity in", values, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityNotIn(List<String> values) {
            addCriterion("identity not in", values, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityBetween(String value1, String value2) {
            addCriterion("identity between", value1, value2, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityNotBetween(String value1, String value2) {
            addCriterion("identity not between", value1, value2, "identity");
            return (Criteria) this;
        }

        public Criteria andAreaIsNull() {
            addCriterion("area is null");
            return (Criteria) this;
        }

        public Criteria andAreaIsNotNull() {
            addCriterion("area is not null");
            return (Criteria) this;
        }

        public Criteria andAreaEqualTo(String value) {
            addCriterion("area =", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotEqualTo(String value) {
            addCriterion("area <>", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaGreaterThan(String value) {
            addCriterion("area >", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaGreaterThanOrEqualTo(String value) {
            addCriterion("area >=", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLessThan(String value) {
            addCriterion("area <", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLessThanOrEqualTo(String value) {
            addCriterion("area <=", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLike(String value) {
            addCriterion("area like", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotLike(String value) {
            addCriterion("area not like", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaIn(List<String> values) {
            addCriterion("area in", values, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotIn(List<String> values) {
            addCriterion("area not in", values, "area");
            return (Criteria) this;
        }

        public Criteria andAreaBetween(String value1, String value2) {
            addCriterion("area between", value1, value2, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotBetween(String value1, String value2) {
            addCriterion("area not between", value1, value2, "area");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNull() {
            addCriterion("province is null");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNotNull() {
            addCriterion("province is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceEqualTo(String value) {
            addCriterion("province =", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotEqualTo(String value) {
            addCriterion("province <>", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThan(String value) {
            addCriterion("province >", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("province >=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThan(String value) {
            addCriterion("province <", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThanOrEqualTo(String value) {
            addCriterion("province <=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLike(String value) {
            addCriterion("province like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotLike(String value) {
            addCriterion("province not like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceIn(List<String> values) {
            addCriterion("province in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotIn(List<String> values) {
            addCriterion("province not in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceBetween(String value1, String value2) {
            addCriterion("province between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotBetween(String value1, String value2) {
            addCriterion("province not between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andCityIsNull() {
            addCriterion("city is null");
            return (Criteria) this;
        }

        public Criteria andCityIsNotNull() {
            addCriterion("city is not null");
            return (Criteria) this;
        }

        public Criteria andCityEqualTo(String value) {
            addCriterion("city =", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotEqualTo(String value) {
            addCriterion("city <>", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThan(String value) {
            addCriterion("city >", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThanOrEqualTo(String value) {
            addCriterion("city >=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThan(String value) {
            addCriterion("city <", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThanOrEqualTo(String value) {
            addCriterion("city <=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLike(String value) {
            addCriterion("city like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotLike(String value) {
            addCriterion("city not like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityIn(List<String> values) {
            addCriterion("city in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotIn(List<String> values) {
            addCriterion("city not in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityBetween(String value1, String value2) {
            addCriterion("city between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotBetween(String value1, String value2) {
            addCriterion("city not between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andRegionIsNull() {
            addCriterion("region is null");
            return (Criteria) this;
        }

        public Criteria andRegionIsNotNull() {
            addCriterion("region is not null");
            return (Criteria) this;
        }

        public Criteria andRegionEqualTo(String value) {
            addCriterion("region =", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionNotEqualTo(String value) {
            addCriterion("region <>", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionGreaterThan(String value) {
            addCriterion("region >", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionGreaterThanOrEqualTo(String value) {
            addCriterion("region >=", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionLessThan(String value) {
            addCriterion("region <", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionLessThanOrEqualTo(String value) {
            addCriterion("region <=", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionLike(String value) {
            addCriterion("region like", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionNotLike(String value) {
            addCriterion("region not like", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionIn(List<String> values) {
            addCriterion("region in", values, "region");
            return (Criteria) this;
        }

        public Criteria andRegionNotIn(List<String> values) {
            addCriterion("region not in", values, "region");
            return (Criteria) this;
        }

        public Criteria andRegionBetween(String value1, String value2) {
            addCriterion("region between", value1, value2, "region");
            return (Criteria) this;
        }

        public Criteria andRegionNotBetween(String value1, String value2) {
            addCriterion("region not between", value1, value2, "region");
            return (Criteria) this;
        }

        public Criteria andGenderIsNull() {
            addCriterion("gender is null");
            return (Criteria) this;
        }

        public Criteria andGenderIsNotNull() {
            addCriterion("gender is not null");
            return (Criteria) this;
        }

        public Criteria andGenderEqualTo(String value) {
            addCriterion("gender =", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotEqualTo(String value) {
            addCriterion("gender <>", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThan(String value) {
            addCriterion("gender >", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThanOrEqualTo(String value) {
            addCriterion("gender >=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThan(String value) {
            addCriterion("gender <", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThanOrEqualTo(String value) {
            addCriterion("gender <=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLike(String value) {
            addCriterion("gender like", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotLike(String value) {
            addCriterion("gender not like", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderIn(List<String> values) {
            addCriterion("gender in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotIn(List<String> values) {
            addCriterion("gender not in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderBetween(String value1, String value2) {
            addCriterion("gender between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotBetween(String value1, String value2) {
            addCriterion("gender not between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andAgeIsNull() {
            addCriterion("age is null");
            return (Criteria) this;
        }

        public Criteria andAgeIsNotNull() {
            addCriterion("age is not null");
            return (Criteria) this;
        }

        public Criteria andAgeEqualTo(Integer value) {
            addCriterion("age =", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotEqualTo(Integer value) {
            addCriterion("age <>", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeGreaterThan(Integer value) {
            addCriterion("age >", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeGreaterThanOrEqualTo(Integer value) {
            addCriterion("age >=", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeLessThan(Integer value) {
            addCriterion("age <", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeLessThanOrEqualTo(Integer value) {
            addCriterion("age <=", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeIn(List<Integer> values) {
            addCriterion("age in", values, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotIn(List<Integer> values) {
            addCriterion("age not in", values, "age");
            return (Criteria) this;
        }

        public Criteria andAgeBetween(Integer value1, Integer value2) {
            addCriterion("age between", value1, value2, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotBetween(Integer value1, Integer value2) {
            addCriterion("age not between", value1, value2, "age");
            return (Criteria) this;
        }

        public Criteria andAccountbalanceIsNull() {
            addCriterion("accountBalance is null");
            return (Criteria) this;
        }

        public Criteria andAccountbalanceIsNotNull() {
            addCriterion("accountBalance is not null");
            return (Criteria) this;
        }

        public Criteria andAccountbalanceEqualTo(BigDecimal value) {
            addCriterion("accountBalance =", value, "accountbalance");
            return (Criteria) this;
        }

        public Criteria andAccountbalanceNotEqualTo(BigDecimal value) {
            addCriterion("accountBalance <>", value, "accountbalance");
            return (Criteria) this;
        }

        public Criteria andAccountbalanceGreaterThan(BigDecimal value) {
            addCriterion("accountBalance >", value, "accountbalance");
            return (Criteria) this;
        }

        public Criteria andAccountbalanceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("accountBalance >=", value, "accountbalance");
            return (Criteria) this;
        }

        public Criteria andAccountbalanceLessThan(BigDecimal value) {
            addCriterion("accountBalance <", value, "accountbalance");
            return (Criteria) this;
        }

        public Criteria andAccountbalanceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("accountBalance <=", value, "accountbalance");
            return (Criteria) this;
        }

        public Criteria andAccountbalanceIn(List<BigDecimal> values) {
            addCriterion("accountBalance in", values, "accountbalance");
            return (Criteria) this;
        }

        public Criteria andAccountbalanceNotIn(List<BigDecimal> values) {
            addCriterion("accountBalance not in", values, "accountbalance");
            return (Criteria) this;
        }

        public Criteria andAccountbalanceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("accountBalance between", value1, value2, "accountbalance");
            return (Criteria) this;
        }

        public Criteria andAccountbalanceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("accountBalance not between", value1, value2, "accountbalance");
            return (Criteria) this;
        }

        public Criteria andAddrechargemoneyIsNull() {
            addCriterion("addRechargeMoney is null");
            return (Criteria) this;
        }

        public Criteria andAddrechargemoneyIsNotNull() {
            addCriterion("addRechargeMoney is not null");
            return (Criteria) this;
        }

        public Criteria andAddrechargemoneyEqualTo(BigDecimal value) {
            addCriterion("addRechargeMoney =", value, "addrechargemoney");
            return (Criteria) this;
        }

        public Criteria andAddrechargemoneyNotEqualTo(BigDecimal value) {
            addCriterion("addRechargeMoney <>", value, "addrechargemoney");
            return (Criteria) this;
        }

        public Criteria andAddrechargemoneyGreaterThan(BigDecimal value) {
            addCriterion("addRechargeMoney >", value, "addrechargemoney");
            return (Criteria) this;
        }

        public Criteria andAddrechargemoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("addRechargeMoney >=", value, "addrechargemoney");
            return (Criteria) this;
        }

        public Criteria andAddrechargemoneyLessThan(BigDecimal value) {
            addCriterion("addRechargeMoney <", value, "addrechargemoney");
            return (Criteria) this;
        }

        public Criteria andAddrechargemoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("addRechargeMoney <=", value, "addrechargemoney");
            return (Criteria) this;
        }

        public Criteria andAddrechargemoneyIn(List<BigDecimal> values) {
            addCriterion("addRechargeMoney in", values, "addrechargemoney");
            return (Criteria) this;
        }

        public Criteria andAddrechargemoneyNotIn(List<BigDecimal> values) {
            addCriterion("addRechargeMoney not in", values, "addrechargemoney");
            return (Criteria) this;
        }

        public Criteria andAddrechargemoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("addRechargeMoney between", value1, value2, "addrechargemoney");
            return (Criteria) this;
        }

        public Criteria andAddrechargemoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("addRechargeMoney not between", value1, value2, "addrechargemoney");
            return (Criteria) this;
        }

        public Criteria andAddwithdrawalmoneyIsNull() {
            addCriterion("addWithdrawalMoney is null");
            return (Criteria) this;
        }

        public Criteria andAddwithdrawalmoneyIsNotNull() {
            addCriterion("addWithdrawalMoney is not null");
            return (Criteria) this;
        }

        public Criteria andAddwithdrawalmoneyEqualTo(BigDecimal value) {
            addCriterion("addWithdrawalMoney =", value, "addwithdrawalmoney");
            return (Criteria) this;
        }

        public Criteria andAddwithdrawalmoneyNotEqualTo(BigDecimal value) {
            addCriterion("addWithdrawalMoney <>", value, "addwithdrawalmoney");
            return (Criteria) this;
        }

        public Criteria andAddwithdrawalmoneyGreaterThan(BigDecimal value) {
            addCriterion("addWithdrawalMoney >", value, "addwithdrawalmoney");
            return (Criteria) this;
        }

        public Criteria andAddwithdrawalmoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("addWithdrawalMoney >=", value, "addwithdrawalmoney");
            return (Criteria) this;
        }

        public Criteria andAddwithdrawalmoneyLessThan(BigDecimal value) {
            addCriterion("addWithdrawalMoney <", value, "addwithdrawalmoney");
            return (Criteria) this;
        }

        public Criteria andAddwithdrawalmoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("addWithdrawalMoney <=", value, "addwithdrawalmoney");
            return (Criteria) this;
        }

        public Criteria andAddwithdrawalmoneyIn(List<BigDecimal> values) {
            addCriterion("addWithdrawalMoney in", values, "addwithdrawalmoney");
            return (Criteria) this;
        }

        public Criteria andAddwithdrawalmoneyNotIn(List<BigDecimal> values) {
            addCriterion("addWithdrawalMoney not in", values, "addwithdrawalmoney");
            return (Criteria) this;
        }

        public Criteria andAddwithdrawalmoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("addWithdrawalMoney between", value1, value2, "addwithdrawalmoney");
            return (Criteria) this;
        }

        public Criteria andAddwithdrawalmoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("addWithdrawalMoney not between", value1, value2, "addwithdrawalmoney");
            return (Criteria) this;
        }

        public Criteria andAddinvestmoneyIsNull() {
            addCriterion("addInvestMoney is null");
            return (Criteria) this;
        }

        public Criteria andAddinvestmoneyIsNotNull() {
            addCriterion("addInvestMoney is not null");
            return (Criteria) this;
        }

        public Criteria andAddinvestmoneyEqualTo(BigDecimal value) {
            addCriterion("addInvestMoney =", value, "addinvestmoney");
            return (Criteria) this;
        }

        public Criteria andAddinvestmoneyNotEqualTo(BigDecimal value) {
            addCriterion("addInvestMoney <>", value, "addinvestmoney");
            return (Criteria) this;
        }

        public Criteria andAddinvestmoneyGreaterThan(BigDecimal value) {
            addCriterion("addInvestMoney >", value, "addinvestmoney");
            return (Criteria) this;
        }

        public Criteria andAddinvestmoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("addInvestMoney >=", value, "addinvestmoney");
            return (Criteria) this;
        }

        public Criteria andAddinvestmoneyLessThan(BigDecimal value) {
            addCriterion("addInvestMoney <", value, "addinvestmoney");
            return (Criteria) this;
        }

        public Criteria andAddinvestmoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("addInvestMoney <=", value, "addinvestmoney");
            return (Criteria) this;
        }

        public Criteria andAddinvestmoneyIn(List<BigDecimal> values) {
            addCriterion("addInvestMoney in", values, "addinvestmoney");
            return (Criteria) this;
        }

        public Criteria andAddinvestmoneyNotIn(List<BigDecimal> values) {
            addCriterion("addInvestMoney not in", values, "addinvestmoney");
            return (Criteria) this;
        }

        public Criteria andAddinvestmoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("addInvestMoney between", value1, value2, "addinvestmoney");
            return (Criteria) this;
        }

        public Criteria andAddinvestmoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("addInvestMoney not between", value1, value2, "addinvestmoney");
            return (Criteria) this;
        }

        public Criteria andAddinvestcntIsNull() {
            addCriterion("addInvestCnt is null");
            return (Criteria) this;
        }

        public Criteria andAddinvestcntIsNotNull() {
            addCriterion("addInvestCnt is not null");
            return (Criteria) this;
        }

        public Criteria andAddinvestcntEqualTo(Integer value) {
            addCriterion("addInvestCnt =", value, "addinvestcnt");
            return (Criteria) this;
        }

        public Criteria andAddinvestcntNotEqualTo(Integer value) {
            addCriterion("addInvestCnt <>", value, "addinvestcnt");
            return (Criteria) this;
        }

        public Criteria andAddinvestcntGreaterThan(Integer value) {
            addCriterion("addInvestCnt >", value, "addinvestcnt");
            return (Criteria) this;
        }

        public Criteria andAddinvestcntGreaterThanOrEqualTo(Integer value) {
            addCriterion("addInvestCnt >=", value, "addinvestcnt");
            return (Criteria) this;
        }

        public Criteria andAddinvestcntLessThan(Integer value) {
            addCriterion("addInvestCnt <", value, "addinvestcnt");
            return (Criteria) this;
        }

        public Criteria andAddinvestcntLessThanOrEqualTo(Integer value) {
            addCriterion("addInvestCnt <=", value, "addinvestcnt");
            return (Criteria) this;
        }

        public Criteria andAddinvestcntIn(List<Integer> values) {
            addCriterion("addInvestCnt in", values, "addinvestcnt");
            return (Criteria) this;
        }

        public Criteria andAddinvestcntNotIn(List<Integer> values) {
            addCriterion("addInvestCnt not in", values, "addinvestcnt");
            return (Criteria) this;
        }

        public Criteria andAddinvestcntBetween(Integer value1, Integer value2) {
            addCriterion("addInvestCnt between", value1, value2, "addinvestcnt");
            return (Criteria) this;
        }

        public Criteria andAddinvestcntNotBetween(Integer value1, Integer value2) {
            addCriterion("addInvestCnt not between", value1, value2, "addinvestcnt");
            return (Criteria) this;
        }

        public Criteria andZjbnumIsNull() {
            addCriterion("ZJBNum is null");
            return (Criteria) this;
        }

        public Criteria andZjbnumIsNotNull() {
            addCriterion("ZJBNum is not null");
            return (Criteria) this;
        }

        public Criteria andZjbnumEqualTo(Integer value) {
            addCriterion("ZJBNum =", value, "zjbnum");
            return (Criteria) this;
        }

        public Criteria andZjbnumNotEqualTo(Integer value) {
            addCriterion("ZJBNum <>", value, "zjbnum");
            return (Criteria) this;
        }

        public Criteria andZjbnumGreaterThan(Integer value) {
            addCriterion("ZJBNum >", value, "zjbnum");
            return (Criteria) this;
        }

        public Criteria andZjbnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("ZJBNum >=", value, "zjbnum");
            return (Criteria) this;
        }

        public Criteria andZjbnumLessThan(Integer value) {
            addCriterion("ZJBNum <", value, "zjbnum");
            return (Criteria) this;
        }

        public Criteria andZjbnumLessThanOrEqualTo(Integer value) {
            addCriterion("ZJBNum <=", value, "zjbnum");
            return (Criteria) this;
        }

        public Criteria andZjbnumIn(List<Integer> values) {
            addCriterion("ZJBNum in", values, "zjbnum");
            return (Criteria) this;
        }

        public Criteria andZjbnumNotIn(List<Integer> values) {
            addCriterion("ZJBNum not in", values, "zjbnum");
            return (Criteria) this;
        }

        public Criteria andZjbnumBetween(Integer value1, Integer value2) {
            addCriterion("ZJBNum between", value1, value2, "zjbnum");
            return (Criteria) this;
        }

        public Criteria andZjbnumNotBetween(Integer value1, Integer value2) {
            addCriterion("ZJBNum not between", value1, value2, "zjbnum");
            return (Criteria) this;
        }

        public Criteria andRecommendregcntIsNull() {
            addCriterion("recommendRegCnt is null");
            return (Criteria) this;
        }

        public Criteria andRecommendregcntIsNotNull() {
            addCriterion("recommendRegCnt is not null");
            return (Criteria) this;
        }

        public Criteria andRecommendregcntEqualTo(Integer value) {
            addCriterion("recommendRegCnt =", value, "recommendregcnt");
            return (Criteria) this;
        }

        public Criteria andRecommendregcntNotEqualTo(Integer value) {
            addCriterion("recommendRegCnt <>", value, "recommendregcnt");
            return (Criteria) this;
        }

        public Criteria andRecommendregcntGreaterThan(Integer value) {
            addCriterion("recommendRegCnt >", value, "recommendregcnt");
            return (Criteria) this;
        }

        public Criteria andRecommendregcntGreaterThanOrEqualTo(Integer value) {
            addCriterion("recommendRegCnt >=", value, "recommendregcnt");
            return (Criteria) this;
        }

        public Criteria andRecommendregcntLessThan(Integer value) {
            addCriterion("recommendRegCnt <", value, "recommendregcnt");
            return (Criteria) this;
        }

        public Criteria andRecommendregcntLessThanOrEqualTo(Integer value) {
            addCriterion("recommendRegCnt <=", value, "recommendregcnt");
            return (Criteria) this;
        }

        public Criteria andRecommendregcntIn(List<Integer> values) {
            addCriterion("recommendRegCnt in", values, "recommendregcnt");
            return (Criteria) this;
        }

        public Criteria andRecommendregcntNotIn(List<Integer> values) {
            addCriterion("recommendRegCnt not in", values, "recommendregcnt");
            return (Criteria) this;
        }

        public Criteria andRecommendregcntBetween(Integer value1, Integer value2) {
            addCriterion("recommendRegCnt between", value1, value2, "recommendregcnt");
            return (Criteria) this;
        }

        public Criteria andRecommendregcntNotBetween(Integer value1, Integer value2) {
            addCriterion("recommendRegCnt not between", value1, value2, "recommendregcnt");
            return (Criteria) this;
        }

        public Criteria andAddlogincntIsNull() {
            addCriterion("addLoginCnt is null");
            return (Criteria) this;
        }

        public Criteria andAddlogincntIsNotNull() {
            addCriterion("addLoginCnt is not null");
            return (Criteria) this;
        }

        public Criteria andAddlogincntEqualTo(Integer value) {
            addCriterion("addLoginCnt =", value, "addlogincnt");
            return (Criteria) this;
        }

        public Criteria andAddlogincntNotEqualTo(Integer value) {
            addCriterion("addLoginCnt <>", value, "addlogincnt");
            return (Criteria) this;
        }

        public Criteria andAddlogincntGreaterThan(Integer value) {
            addCriterion("addLoginCnt >", value, "addlogincnt");
            return (Criteria) this;
        }

        public Criteria andAddlogincntGreaterThanOrEqualTo(Integer value) {
            addCriterion("addLoginCnt >=", value, "addlogincnt");
            return (Criteria) this;
        }

        public Criteria andAddlogincntLessThan(Integer value) {
            addCriterion("addLoginCnt <", value, "addlogincnt");
            return (Criteria) this;
        }

        public Criteria andAddlogincntLessThanOrEqualTo(Integer value) {
            addCriterion("addLoginCnt <=", value, "addlogincnt");
            return (Criteria) this;
        }

        public Criteria andAddlogincntIn(List<Integer> values) {
            addCriterion("addLoginCnt in", values, "addlogincnt");
            return (Criteria) this;
        }

        public Criteria andAddlogincntNotIn(List<Integer> values) {
            addCriterion("addLoginCnt not in", values, "addlogincnt");
            return (Criteria) this;
        }

        public Criteria andAddlogincntBetween(Integer value1, Integer value2) {
            addCriterion("addLoginCnt between", value1, value2, "addlogincnt");
            return (Criteria) this;
        }

        public Criteria andAddlogincntNotBetween(Integer value1, Integer value2) {
            addCriterion("addLoginCnt not between", value1, value2, "addlogincnt");
            return (Criteria) this;
        }

        public Criteria andLastlogintimeIsNull() {
            addCriterion("lastLoginTime is null");
            return (Criteria) this;
        }

        public Criteria andLastlogintimeIsNotNull() {
            addCriterion("lastLoginTime is not null");
            return (Criteria) this;
        }

        public Criteria andLastlogintimeEqualTo(Date value) {
            addCriterion("lastLoginTime =", value, "lastlogintime");
            return (Criteria) this;
        }

        public Criteria andLastlogintimeNotEqualTo(Date value) {
            addCriterion("lastLoginTime <>", value, "lastlogintime");
            return (Criteria) this;
        }

        public Criteria andLastlogintimeGreaterThan(Date value) {
            addCriterion("lastLoginTime >", value, "lastlogintime");
            return (Criteria) this;
        }

        public Criteria andLastlogintimeGreaterThanOrEqualTo(Date value) {
            addCriterion("lastLoginTime >=", value, "lastlogintime");
            return (Criteria) this;
        }

        public Criteria andLastlogintimeLessThan(Date value) {
            addCriterion("lastLoginTime <", value, "lastlogintime");
            return (Criteria) this;
        }

        public Criteria andLastlogintimeLessThanOrEqualTo(Date value) {
            addCriterion("lastLoginTime <=", value, "lastlogintime");
            return (Criteria) this;
        }

        public Criteria andLastlogintimeIn(List<Date> values) {
            addCriterion("lastLoginTime in", values, "lastlogintime");
            return (Criteria) this;
        }

        public Criteria andLastlogintimeNotIn(List<Date> values) {
            addCriterion("lastLoginTime not in", values, "lastlogintime");
            return (Criteria) this;
        }

        public Criteria andLastlogintimeBetween(Date value1, Date value2) {
            addCriterion("lastLoginTime between", value1, value2, "lastlogintime");
            return (Criteria) this;
        }

        public Criteria andLastlogintimeNotBetween(Date value1, Date value2) {
            addCriterion("lastLoginTime not between", value1, value2, "lastlogintime");
            return (Criteria) this;
        }

        public Criteria andRecordIsNull() {
            addCriterion("record is null");
            return (Criteria) this;
        }

        public Criteria andRecordIsNotNull() {
            addCriterion("record is not null");
            return (Criteria) this;
        }

        public Criteria andRecordEqualTo(String value) {
            addCriterion("record =", value, "record");
            return (Criteria) this;
        }

        public Criteria andRecordNotEqualTo(String value) {
            addCriterion("record <>", value, "record");
            return (Criteria) this;
        }

        public Criteria andRecordGreaterThan(String value) {
            addCriterion("record >", value, "record");
            return (Criteria) this;
        }

        public Criteria andRecordGreaterThanOrEqualTo(String value) {
            addCriterion("record >=", value, "record");
            return (Criteria) this;
        }

        public Criteria andRecordLessThan(String value) {
            addCriterion("record <", value, "record");
            return (Criteria) this;
        }

        public Criteria andRecordLessThanOrEqualTo(String value) {
            addCriterion("record <=", value, "record");
            return (Criteria) this;
        }

        public Criteria andRecordLike(String value) {
            addCriterion("record like", value, "record");
            return (Criteria) this;
        }

        public Criteria andRecordNotLike(String value) {
            addCriterion("record not like", value, "record");
            return (Criteria) this;
        }

        public Criteria andRecordIn(List<String> values) {
            addCriterion("record in", values, "record");
            return (Criteria) this;
        }

        public Criteria andRecordNotIn(List<String> values) {
            addCriterion("record not in", values, "record");
            return (Criteria) this;
        }

        public Criteria andRecordBetween(String value1, String value2) {
            addCriterion("record between", value1, value2, "record");
            return (Criteria) this;
        }

        public Criteria andRecordNotBetween(String value1, String value2) {
            addCriterion("record not between", value1, value2, "record");
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
     * This class:org.mybatis.generator.config.Context@c325b
     *  userinvestinfo
     *
     * @ET do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class:org.mybatis.generator.config.Context@c325b
     *  userinvestinfo
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