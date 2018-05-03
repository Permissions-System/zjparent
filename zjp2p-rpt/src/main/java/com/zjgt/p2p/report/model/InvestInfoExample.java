package com.zjgt.p2p.report.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InvestInfoExample {
    /**
     * orderByClausenull .
     *   investinfo
     *
     * @ET
     */
    protected String orderByClause;

    /**
     * distinctnull .
     *   investinfo
     *
     * @ET
     */
    protected boolean distinct;

    /**
     * oredCriterianull .
     *   investinfo
     *
     * @ET
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method:InvestInfoExample
     *   investinfo
     *
     * @ET
     */
    public InvestInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method:setOrderByClause
     *   investinfo
     *
     * @ET
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method:getOrderByClause
     *   investinfo
     *
     * @ET
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method:setDistinct
     *   investinfo
     *
     * @ET
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method:isDistinct
     *   investinfo
     *
     * @ET
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method:getOredCriteria
     *   investinfo
     *
     * @ET
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method:or
     *   investinfo
     *
     * @ET
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method:or
     *   investinfo
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
     *   investinfo
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
     *   investinfo
     *
     * @ET
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method:clear
     *   investinfo
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
     *  investinfo
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

        public Criteria andLendidIsNull() {
            addCriterion("lendId is null");
            return (Criteria) this;
        }

        public Criteria andLendidIsNotNull() {
            addCriterion("lendId is not null");
            return (Criteria) this;
        }

        public Criteria andLendidEqualTo(Integer value) {
            addCriterion("lendId =", value, "lendid");
            return (Criteria) this;
        }

        public Criteria andLendidNotEqualTo(Integer value) {
            addCriterion("lendId <>", value, "lendid");
            return (Criteria) this;
        }

        public Criteria andLendidGreaterThan(Integer value) {
            addCriterion("lendId >", value, "lendid");
            return (Criteria) this;
        }

        public Criteria andLendidGreaterThanOrEqualTo(Integer value) {
            addCriterion("lendId >=", value, "lendid");
            return (Criteria) this;
        }

        public Criteria andLendidLessThan(Integer value) {
            addCriterion("lendId <", value, "lendid");
            return (Criteria) this;
        }

        public Criteria andLendidLessThanOrEqualTo(Integer value) {
            addCriterion("lendId <=", value, "lendid");
            return (Criteria) this;
        }

        public Criteria andLendidIn(List<Integer> values) {
            addCriterion("lendId in", values, "lendid");
            return (Criteria) this;
        }

        public Criteria andLendidNotIn(List<Integer> values) {
            addCriterion("lendId not in", values, "lendid");
            return (Criteria) this;
        }

        public Criteria andLendidBetween(Integer value1, Integer value2) {
            addCriterion("lendId between", value1, value2, "lendid");
            return (Criteria) this;
        }

        public Criteria andLendidNotBetween(Integer value1, Integer value2) {
            addCriterion("lendId not between", value1, value2, "lendid");
            return (Criteria) this;
        }

        public Criteria andFuyouaccountIsNull() {
            addCriterion("fuyouAccount is null");
            return (Criteria) this;
        }

        public Criteria andFuyouaccountIsNotNull() {
            addCriterion("fuyouAccount is not null");
            return (Criteria) this;
        }

        public Criteria andFuyouaccountEqualTo(String value) {
            addCriterion("fuyouAccount =", value, "fuyouaccount");
            return (Criteria) this;
        }

        public Criteria andFuyouaccountNotEqualTo(String value) {
            addCriterion("fuyouAccount <>", value, "fuyouaccount");
            return (Criteria) this;
        }

        public Criteria andFuyouaccountGreaterThan(String value) {
            addCriterion("fuyouAccount >", value, "fuyouaccount");
            return (Criteria) this;
        }

        public Criteria andFuyouaccountGreaterThanOrEqualTo(String value) {
            addCriterion("fuyouAccount >=", value, "fuyouaccount");
            return (Criteria) this;
        }

        public Criteria andFuyouaccountLessThan(String value) {
            addCriterion("fuyouAccount <", value, "fuyouaccount");
            return (Criteria) this;
        }

        public Criteria andFuyouaccountLessThanOrEqualTo(String value) {
            addCriterion("fuyouAccount <=", value, "fuyouaccount");
            return (Criteria) this;
        }

        public Criteria andFuyouaccountLike(String value) {
            addCriterion("fuyouAccount like", value, "fuyouaccount");
            return (Criteria) this;
        }

        public Criteria andFuyouaccountNotLike(String value) {
            addCriterion("fuyouAccount not like", value, "fuyouaccount");
            return (Criteria) this;
        }

        public Criteria andFuyouaccountIn(List<String> values) {
            addCriterion("fuyouAccount in", values, "fuyouaccount");
            return (Criteria) this;
        }

        public Criteria andFuyouaccountNotIn(List<String> values) {
            addCriterion("fuyouAccount not in", values, "fuyouaccount");
            return (Criteria) this;
        }

        public Criteria andFuyouaccountBetween(String value1, String value2) {
            addCriterion("fuyouAccount between", value1, value2, "fuyouaccount");
            return (Criteria) this;
        }

        public Criteria andFuyouaccountNotBetween(String value1, String value2) {
            addCriterion("fuyouAccount not between", value1, value2, "fuyouaccount");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNull() {
            addCriterion("userName is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("userName is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("userName =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("userName <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("userName >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("userName >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("userName <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("userName <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("userName like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("userName not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("userName in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("userName not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("userName between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("userName not between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andPromocodeIsNull() {
            addCriterion("PromoCode is null");
            return (Criteria) this;
        }

        public Criteria andPromocodeIsNotNull() {
            addCriterion("PromoCode is not null");
            return (Criteria) this;
        }

        public Criteria andPromocodeEqualTo(String value) {
            addCriterion("PromoCode =", value, "promocode");
            return (Criteria) this;
        }

        public Criteria andPromocodeNotEqualTo(String value) {
            addCriterion("PromoCode <>", value, "promocode");
            return (Criteria) this;
        }

        public Criteria andPromocodeGreaterThan(String value) {
            addCriterion("PromoCode >", value, "promocode");
            return (Criteria) this;
        }

        public Criteria andPromocodeGreaterThanOrEqualTo(String value) {
            addCriterion("PromoCode >=", value, "promocode");
            return (Criteria) this;
        }

        public Criteria andPromocodeLessThan(String value) {
            addCriterion("PromoCode <", value, "promocode");
            return (Criteria) this;
        }

        public Criteria andPromocodeLessThanOrEqualTo(String value) {
            addCriterion("PromoCode <=", value, "promocode");
            return (Criteria) this;
        }

        public Criteria andPromocodeLike(String value) {
            addCriterion("PromoCode like", value, "promocode");
            return (Criteria) this;
        }

        public Criteria andPromocodeNotLike(String value) {
            addCriterion("PromoCode not like", value, "promocode");
            return (Criteria) this;
        }

        public Criteria andPromocodeIn(List<String> values) {
            addCriterion("PromoCode in", values, "promocode");
            return (Criteria) this;
        }

        public Criteria andPromocodeNotIn(List<String> values) {
            addCriterion("PromoCode not in", values, "promocode");
            return (Criteria) this;
        }

        public Criteria andPromocodeBetween(String value1, String value2) {
            addCriterion("PromoCode between", value1, value2, "promocode");
            return (Criteria) this;
        }

        public Criteria andPromocodeNotBetween(String value1, String value2) {
            addCriterion("PromoCode not between", value1, value2, "promocode");
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

        public Criteria andLendprojectIsNull() {
            addCriterion("lendproject is null");
            return (Criteria) this;
        }

        public Criteria andLendprojectIsNotNull() {
            addCriterion("lendproject is not null");
            return (Criteria) this;
        }

        public Criteria andLendprojectEqualTo(String value) {
            addCriterion("lendproject =", value, "lendproject");
            return (Criteria) this;
        }

        public Criteria andLendprojectNotEqualTo(String value) {
            addCriterion("lendproject <>", value, "lendproject");
            return (Criteria) this;
        }

        public Criteria andLendprojectGreaterThan(String value) {
            addCriterion("lendproject >", value, "lendproject");
            return (Criteria) this;
        }

        public Criteria andLendprojectGreaterThanOrEqualTo(String value) {
            addCriterion("lendproject >=", value, "lendproject");
            return (Criteria) this;
        }

        public Criteria andLendprojectLessThan(String value) {
            addCriterion("lendproject <", value, "lendproject");
            return (Criteria) this;
        }

        public Criteria andLendprojectLessThanOrEqualTo(String value) {
            addCriterion("lendproject <=", value, "lendproject");
            return (Criteria) this;
        }

        public Criteria andLendprojectLike(String value) {
            addCriterion("lendproject like", value, "lendproject");
            return (Criteria) this;
        }

        public Criteria andLendprojectNotLike(String value) {
            addCriterion("lendproject not like", value, "lendproject");
            return (Criteria) this;
        }

        public Criteria andLendprojectIn(List<String> values) {
            addCriterion("lendproject in", values, "lendproject");
            return (Criteria) this;
        }

        public Criteria andLendprojectNotIn(List<String> values) {
            addCriterion("lendproject not in", values, "lendproject");
            return (Criteria) this;
        }

        public Criteria andLendprojectBetween(String value1, String value2) {
            addCriterion("lendproject between", value1, value2, "lendproject");
            return (Criteria) this;
        }

        public Criteria andLendprojectNotBetween(String value1, String value2) {
            addCriterion("lendproject not between", value1, value2, "lendproject");
            return (Criteria) this;
        }

        public Criteria andLendmoneyIsNull() {
            addCriterion("lendMoney is null");
            return (Criteria) this;
        }

        public Criteria andLendmoneyIsNotNull() {
            addCriterion("lendMoney is not null");
            return (Criteria) this;
        }

        public Criteria andLendmoneyEqualTo(BigDecimal value) {
            addCriterion("lendMoney =", value, "lendmoney");
            return (Criteria) this;
        }

        public Criteria andLendmoneyNotEqualTo(BigDecimal value) {
            addCriterion("lendMoney <>", value, "lendmoney");
            return (Criteria) this;
        }

        public Criteria andLendmoneyGreaterThan(BigDecimal value) {
            addCriterion("lendMoney >", value, "lendmoney");
            return (Criteria) this;
        }

        public Criteria andLendmoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("lendMoney >=", value, "lendmoney");
            return (Criteria) this;
        }

        public Criteria andLendmoneyLessThan(BigDecimal value) {
            addCriterion("lendMoney <", value, "lendmoney");
            return (Criteria) this;
        }

        public Criteria andLendmoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("lendMoney <=", value, "lendmoney");
            return (Criteria) this;
        }

        public Criteria andLendmoneyIn(List<BigDecimal> values) {
            addCriterion("lendMoney in", values, "lendmoney");
            return (Criteria) this;
        }

        public Criteria andLendmoneyNotIn(List<BigDecimal> values) {
            addCriterion("lendMoney not in", values, "lendmoney");
            return (Criteria) this;
        }

        public Criteria andLendmoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("lendMoney between", value1, value2, "lendmoney");
            return (Criteria) this;
        }

        public Criteria andLendmoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("lendMoney not between", value1, value2, "lendmoney");
            return (Criteria) this;
        }

        public Criteria andRealmoneyIsNull() {
            addCriterion("realMoney is null");
            return (Criteria) this;
        }

        public Criteria andRealmoneyIsNotNull() {
            addCriterion("realMoney is not null");
            return (Criteria) this;
        }

        public Criteria andRealmoneyEqualTo(BigDecimal value) {
            addCriterion("realMoney =", value, "realmoney");
            return (Criteria) this;
        }

        public Criteria andRealmoneyNotEqualTo(BigDecimal value) {
            addCriterion("realMoney <>", value, "realmoney");
            return (Criteria) this;
        }

        public Criteria andRealmoneyGreaterThan(BigDecimal value) {
            addCriterion("realMoney >", value, "realmoney");
            return (Criteria) this;
        }

        public Criteria andRealmoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("realMoney >=", value, "realmoney");
            return (Criteria) this;
        }

        public Criteria andRealmoneyLessThan(BigDecimal value) {
            addCriterion("realMoney <", value, "realmoney");
            return (Criteria) this;
        }

        public Criteria andRealmoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("realMoney <=", value, "realmoney");
            return (Criteria) this;
        }

        public Criteria andRealmoneyIn(List<BigDecimal> values) {
            addCriterion("realMoney in", values, "realmoney");
            return (Criteria) this;
        }

        public Criteria andRealmoneyNotIn(List<BigDecimal> values) {
            addCriterion("realMoney not in", values, "realmoney");
            return (Criteria) this;
        }

        public Criteria andRealmoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("realMoney between", value1, value2, "realmoney");
            return (Criteria) this;
        }

        public Criteria andRealmoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("realMoney not between", value1, value2, "realmoney");
            return (Criteria) this;
        }

        public Criteria andDeductmoneyIsNull() {
            addCriterion("deductMoney is null");
            return (Criteria) this;
        }

        public Criteria andDeductmoneyIsNotNull() {
            addCriterion("deductMoney is not null");
            return (Criteria) this;
        }

        public Criteria andDeductmoneyEqualTo(BigDecimal value) {
            addCriterion("deductMoney =", value, "deductmoney");
            return (Criteria) this;
        }

        public Criteria andDeductmoneyNotEqualTo(BigDecimal value) {
            addCriterion("deductMoney <>", value, "deductmoney");
            return (Criteria) this;
        }

        public Criteria andDeductmoneyGreaterThan(BigDecimal value) {
            addCriterion("deductMoney >", value, "deductmoney");
            return (Criteria) this;
        }

        public Criteria andDeductmoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("deductMoney >=", value, "deductmoney");
            return (Criteria) this;
        }

        public Criteria andDeductmoneyLessThan(BigDecimal value) {
            addCriterion("deductMoney <", value, "deductmoney");
            return (Criteria) this;
        }

        public Criteria andDeductmoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("deductMoney <=", value, "deductmoney");
            return (Criteria) this;
        }

        public Criteria andDeductmoneyIn(List<BigDecimal> values) {
            addCriterion("deductMoney in", values, "deductmoney");
            return (Criteria) this;
        }

        public Criteria andDeductmoneyNotIn(List<BigDecimal> values) {
            addCriterion("deductMoney not in", values, "deductmoney");
            return (Criteria) this;
        }

        public Criteria andDeductmoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("deductMoney between", value1, value2, "deductmoney");
            return (Criteria) this;
        }

        public Criteria andDeductmoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("deductMoney not between", value1, value2, "deductmoney");
            return (Criteria) this;
        }

        public Criteria andExpectmoneyIsNull() {
            addCriterion("expectMoney is null");
            return (Criteria) this;
        }

        public Criteria andExpectmoneyIsNotNull() {
            addCriterion("expectMoney is not null");
            return (Criteria) this;
        }

        public Criteria andExpectmoneyEqualTo(BigDecimal value) {
            addCriterion("expectMoney =", value, "expectmoney");
            return (Criteria) this;
        }

        public Criteria andExpectmoneyNotEqualTo(BigDecimal value) {
            addCriterion("expectMoney <>", value, "expectmoney");
            return (Criteria) this;
        }

        public Criteria andExpectmoneyGreaterThan(BigDecimal value) {
            addCriterion("expectMoney >", value, "expectmoney");
            return (Criteria) this;
        }

        public Criteria andExpectmoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("expectMoney >=", value, "expectmoney");
            return (Criteria) this;
        }

        public Criteria andExpectmoneyLessThan(BigDecimal value) {
            addCriterion("expectMoney <", value, "expectmoney");
            return (Criteria) this;
        }

        public Criteria andExpectmoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("expectMoney <=", value, "expectmoney");
            return (Criteria) this;
        }

        public Criteria andExpectmoneyIn(List<BigDecimal> values) {
            addCriterion("expectMoney in", values, "expectmoney");
            return (Criteria) this;
        }

        public Criteria andExpectmoneyNotIn(List<BigDecimal> values) {
            addCriterion("expectMoney not in", values, "expectmoney");
            return (Criteria) this;
        }

        public Criteria andExpectmoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("expectMoney between", value1, value2, "expectmoney");
            return (Criteria) this;
        }

        public Criteria andExpectmoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("expectMoney not between", value1, value2, "expectmoney");
            return (Criteria) this;
        }

        public Criteria andRepaymoneyIsNull() {
            addCriterion("repayMoney is null");
            return (Criteria) this;
        }

        public Criteria andRepaymoneyIsNotNull() {
            addCriterion("repayMoney is not null");
            return (Criteria) this;
        }

        public Criteria andRepaymoneyEqualTo(BigDecimal value) {
            addCriterion("repayMoney =", value, "repaymoney");
            return (Criteria) this;
        }

        public Criteria andRepaymoneyNotEqualTo(BigDecimal value) {
            addCriterion("repayMoney <>", value, "repaymoney");
            return (Criteria) this;
        }

        public Criteria andRepaymoneyGreaterThan(BigDecimal value) {
            addCriterion("repayMoney >", value, "repaymoney");
            return (Criteria) this;
        }

        public Criteria andRepaymoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("repayMoney >=", value, "repaymoney");
            return (Criteria) this;
        }

        public Criteria andRepaymoneyLessThan(BigDecimal value) {
            addCriterion("repayMoney <", value, "repaymoney");
            return (Criteria) this;
        }

        public Criteria andRepaymoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("repayMoney <=", value, "repaymoney");
            return (Criteria) this;
        }

        public Criteria andRepaymoneyIn(List<BigDecimal> values) {
            addCriterion("repayMoney in", values, "repaymoney");
            return (Criteria) this;
        }

        public Criteria andRepaymoneyNotIn(List<BigDecimal> values) {
            addCriterion("repayMoney not in", values, "repaymoney");
            return (Criteria) this;
        }

        public Criteria andRepaymoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("repayMoney between", value1, value2, "repaymoney");
            return (Criteria) this;
        }

        public Criteria andRepaymoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("repayMoney not between", value1, value2, "repaymoney");
            return (Criteria) this;
        }

        public Criteria andYearrateIsNull() {
            addCriterion("yearRate is null");
            return (Criteria) this;
        }

        public Criteria andYearrateIsNotNull() {
            addCriterion("yearRate is not null");
            return (Criteria) this;
        }

        public Criteria andYearrateEqualTo(Double value) {
            addCriterion("yearRate =", value, "yearrate");
            return (Criteria) this;
        }

        public Criteria andYearrateNotEqualTo(Double value) {
            addCriterion("yearRate <>", value, "yearrate");
            return (Criteria) this;
        }

        public Criteria andYearrateGreaterThan(Double value) {
            addCriterion("yearRate >", value, "yearrate");
            return (Criteria) this;
        }

        public Criteria andYearrateGreaterThanOrEqualTo(Double value) {
            addCriterion("yearRate >=", value, "yearrate");
            return (Criteria) this;
        }

        public Criteria andYearrateLessThan(Double value) {
            addCriterion("yearRate <", value, "yearrate");
            return (Criteria) this;
        }

        public Criteria andYearrateLessThanOrEqualTo(Double value) {
            addCriterion("yearRate <=", value, "yearrate");
            return (Criteria) this;
        }

        public Criteria andYearrateIn(List<Double> values) {
            addCriterion("yearRate in", values, "yearrate");
            return (Criteria) this;
        }

        public Criteria andYearrateNotIn(List<Double> values) {
            addCriterion("yearRate not in", values, "yearrate");
            return (Criteria) this;
        }

        public Criteria andYearrateBetween(Double value1, Double value2) {
            addCriterion("yearRate between", value1, value2, "yearrate");
            return (Criteria) this;
        }

        public Criteria andYearrateNotBetween(Double value1, Double value2) {
            addCriterion("yearRate not between", value1, value2, "yearrate");
            return (Criteria) this;
        }

        public Criteria andTimelimitIsNull() {
            addCriterion("timeLimit is null");
            return (Criteria) this;
        }

        public Criteria andTimelimitIsNotNull() {
            addCriterion("timeLimit is not null");
            return (Criteria) this;
        }

        public Criteria andTimelimitEqualTo(Integer value) {
            addCriterion("timeLimit =", value, "timelimit");
            return (Criteria) this;
        }

        public Criteria andTimelimitNotEqualTo(Integer value) {
            addCriterion("timeLimit <>", value, "timelimit");
            return (Criteria) this;
        }

        public Criteria andTimelimitGreaterThan(Integer value) {
            addCriterion("timeLimit >", value, "timelimit");
            return (Criteria) this;
        }

        public Criteria andTimelimitGreaterThanOrEqualTo(Integer value) {
            addCriterion("timeLimit >=", value, "timelimit");
            return (Criteria) this;
        }

        public Criteria andTimelimitLessThan(Integer value) {
            addCriterion("timeLimit <", value, "timelimit");
            return (Criteria) this;
        }

        public Criteria andTimelimitLessThanOrEqualTo(Integer value) {
            addCriterion("timeLimit <=", value, "timelimit");
            return (Criteria) this;
        }

        public Criteria andTimelimitIn(List<Integer> values) {
            addCriterion("timeLimit in", values, "timelimit");
            return (Criteria) this;
        }

        public Criteria andTimelimitNotIn(List<Integer> values) {
            addCriterion("timeLimit not in", values, "timelimit");
            return (Criteria) this;
        }

        public Criteria andTimelimitBetween(Integer value1, Integer value2) {
            addCriterion("timeLimit between", value1, value2, "timelimit");
            return (Criteria) this;
        }

        public Criteria andTimelimitNotBetween(Integer value1, Integer value2) {
            addCriterion("timeLimit not between", value1, value2, "timelimit");
            return (Criteria) this;
        }

        public Criteria andLenddateIsNull() {
            addCriterion("lendDate is null");
            return (Criteria) this;
        }

        public Criteria andLenddateIsNotNull() {
            addCriterion("lendDate is not null");
            return (Criteria) this;
        }

        public Criteria andLenddateEqualTo(Date value) {
            addCriterion("lendDate =", value, "lenddate");
            return (Criteria) this;
        }

        public Criteria andLenddateNotEqualTo(Date value) {
            addCriterion("lendDate <>", value, "lenddate");
            return (Criteria) this;
        }

        public Criteria andLenddateGreaterThan(Date value) {
            addCriterion("lendDate >", value, "lenddate");
            return (Criteria) this;
        }

        public Criteria andLenddateGreaterThanOrEqualTo(Date value) {
            addCriterion("lendDate >=", value, "lenddate");
            return (Criteria) this;
        }

        public Criteria andLenddateLessThan(Date value) {
            addCriterion("lendDate <", value, "lenddate");
            return (Criteria) this;
        }

        public Criteria andLenddateLessThanOrEqualTo(Date value) {
            addCriterion("lendDate <=", value, "lenddate");
            return (Criteria) this;
        }

        public Criteria andLenddateIn(List<Date> values) {
            addCriterion("lendDate in", values, "lenddate");
            return (Criteria) this;
        }

        public Criteria andLenddateNotIn(List<Date> values) {
            addCriterion("lendDate not in", values, "lenddate");
            return (Criteria) this;
        }

        public Criteria andLenddateBetween(Date value1, Date value2) {
            addCriterion("lendDate between", value1, value2, "lenddate");
            return (Criteria) this;
        }

        public Criteria andLenddateNotBetween(Date value1, Date value2) {
            addCriterion("lendDate not between", value1, value2, "lenddate");
            return (Criteria) this;
        }

        public Criteria andRepaydateIsNull() {
            addCriterion("repayDate is null");
            return (Criteria) this;
        }

        public Criteria andRepaydateIsNotNull() {
            addCriterion("repayDate is not null");
            return (Criteria) this;
        }

        public Criteria andRepaydateEqualTo(Date value) {
            addCriterion("repayDate =", value, "repaydate");
            return (Criteria) this;
        }

        public Criteria andRepaydateNotEqualTo(Date value) {
            addCriterion("repayDate <>", value, "repaydate");
            return (Criteria) this;
        }

        public Criteria andRepaydateGreaterThan(Date value) {
            addCriterion("repayDate >", value, "repaydate");
            return (Criteria) this;
        }

        public Criteria andRepaydateGreaterThanOrEqualTo(Date value) {
            addCriterion("repayDate >=", value, "repaydate");
            return (Criteria) this;
        }

        public Criteria andRepaydateLessThan(Date value) {
            addCriterion("repayDate <", value, "repaydate");
            return (Criteria) this;
        }

        public Criteria andRepaydateLessThanOrEqualTo(Date value) {
            addCriterion("repayDate <=", value, "repaydate");
            return (Criteria) this;
        }

        public Criteria andRepaydateIn(List<Date> values) {
            addCriterion("repayDate in", values, "repaydate");
            return (Criteria) this;
        }

        public Criteria andRepaydateNotIn(List<Date> values) {
            addCriterion("repayDate not in", values, "repaydate");
            return (Criteria) this;
        }

        public Criteria andRepaydateBetween(Date value1, Date value2) {
            addCriterion("repayDate between", value1, value2, "repaydate");
            return (Criteria) this;
        }

        public Criteria andRepaydateNotBetween(Date value1, Date value2) {
            addCriterion("repayDate not between", value1, value2, "repaydate");
            return (Criteria) this;
        }

        public Criteria andExpiredateIsNull() {
            addCriterion("expireDate is null");
            return (Criteria) this;
        }

        public Criteria andExpiredateIsNotNull() {
            addCriterion("expireDate is not null");
            return (Criteria) this;
        }

        public Criteria andExpiredateEqualTo(Date value) {
            addCriterion("expireDate =", value, "expiredate");
            return (Criteria) this;
        }

        public Criteria andExpiredateNotEqualTo(Date value) {
            addCriterion("expireDate <>", value, "expiredate");
            return (Criteria) this;
        }

        public Criteria andExpiredateGreaterThan(Date value) {
            addCriterion("expireDate >", value, "expiredate");
            return (Criteria) this;
        }

        public Criteria andExpiredateGreaterThanOrEqualTo(Date value) {
            addCriterion("expireDate >=", value, "expiredate");
            return (Criteria) this;
        }

        public Criteria andExpiredateLessThan(Date value) {
            addCriterion("expireDate <", value, "expiredate");
            return (Criteria) this;
        }

        public Criteria andExpiredateLessThanOrEqualTo(Date value) {
            addCriterion("expireDate <=", value, "expiredate");
            return (Criteria) this;
        }

        public Criteria andExpiredateIn(List<Date> values) {
            addCriterion("expireDate in", values, "expiredate");
            return (Criteria) this;
        }

        public Criteria andExpiredateNotIn(List<Date> values) {
            addCriterion("expireDate not in", values, "expiredate");
            return (Criteria) this;
        }

        public Criteria andExpiredateBetween(Date value1, Date value2) {
            addCriterion("expireDate between", value1, value2, "expiredate");
            return (Criteria) this;
        }

        public Criteria andExpiredateNotBetween(Date value1, Date value2) {
            addCriterion("expireDate not between", value1, value2, "expiredate");
            return (Criteria) this;
        }

        public Criteria andRegdateIsNull() {
            addCriterion("regDate is null");
            return (Criteria) this;
        }

        public Criteria andRegdateIsNotNull() {
            addCriterion("regDate is not null");
            return (Criteria) this;
        }

        public Criteria andRegdateEqualTo(Date value) {
            addCriterion("regDate =", value, "regdate");
            return (Criteria) this;
        }

        public Criteria andRegdateNotEqualTo(Date value) {
            addCriterion("regDate <>", value, "regdate");
            return (Criteria) this;
        }

        public Criteria andRegdateGreaterThan(Date value) {
            addCriterion("regDate >", value, "regdate");
            return (Criteria) this;
        }

        public Criteria andRegdateGreaterThanOrEqualTo(Date value) {
            addCriterion("regDate >=", value, "regdate");
            return (Criteria) this;
        }

        public Criteria andRegdateLessThan(Date value) {
            addCriterion("regDate <", value, "regdate");
            return (Criteria) this;
        }

        public Criteria andRegdateLessThanOrEqualTo(Date value) {
            addCriterion("regDate <=", value, "regdate");
            return (Criteria) this;
        }

        public Criteria andRegdateIn(List<Date> values) {
            addCriterion("regDate in", values, "regdate");
            return (Criteria) this;
        }

        public Criteria andRegdateNotIn(List<Date> values) {
            addCriterion("regDate not in", values, "regdate");
            return (Criteria) this;
        }

        public Criteria andRegdateBetween(Date value1, Date value2) {
            addCriterion("regDate between", value1, value2, "regdate");
            return (Criteria) this;
        }

        public Criteria andRegdateNotBetween(Date value1, Date value2) {
            addCriterion("regDate not between", value1, value2, "regdate");
            return (Criteria) this;
        }

        public Criteria andPrevinvestdateIsNull() {
            addCriterion("prevInvestDate is null");
            return (Criteria) this;
        }

        public Criteria andPrevinvestdateIsNotNull() {
            addCriterion("prevInvestDate is not null");
            return (Criteria) this;
        }

        public Criteria andPrevinvestdateEqualTo(Date value) {
            addCriterion("prevInvestDate =", value, "previnvestdate");
            return (Criteria) this;
        }

        public Criteria andPrevinvestdateNotEqualTo(Date value) {
            addCriterion("prevInvestDate <>", value, "previnvestdate");
            return (Criteria) this;
        }

        public Criteria andPrevinvestdateGreaterThan(Date value) {
            addCriterion("prevInvestDate >", value, "previnvestdate");
            return (Criteria) this;
        }

        public Criteria andPrevinvestdateGreaterThanOrEqualTo(Date value) {
            addCriterion("prevInvestDate >=", value, "previnvestdate");
            return (Criteria) this;
        }

        public Criteria andPrevinvestdateLessThan(Date value) {
            addCriterion("prevInvestDate <", value, "previnvestdate");
            return (Criteria) this;
        }

        public Criteria andPrevinvestdateLessThanOrEqualTo(Date value) {
            addCriterion("prevInvestDate <=", value, "previnvestdate");
            return (Criteria) this;
        }

        public Criteria andPrevinvestdateIn(List<Date> values) {
            addCriterion("prevInvestDate in", values, "previnvestdate");
            return (Criteria) this;
        }

        public Criteria andPrevinvestdateNotIn(List<Date> values) {
            addCriterion("prevInvestDate not in", values, "previnvestdate");
            return (Criteria) this;
        }

        public Criteria andPrevinvestdateBetween(Date value1, Date value2) {
            addCriterion("prevInvestDate between", value1, value2, "previnvestdate");
            return (Criteria) this;
        }

        public Criteria andPrevinvestdateNotBetween(Date value1, Date value2) {
            addCriterion("prevInvestDate not between", value1, value2, "previnvestdate");
            return (Criteria) this;
        }

        public Criteria andSuminvestcntIsNull() {
            addCriterion("sumInvestCnt is null");
            return (Criteria) this;
        }

        public Criteria andSuminvestcntIsNotNull() {
            addCriterion("sumInvestCnt is not null");
            return (Criteria) this;
        }

        public Criteria andSuminvestcntEqualTo(Integer value) {
            addCriterion("sumInvestCnt =", value, "suminvestcnt");
            return (Criteria) this;
        }

        public Criteria andSuminvestcntNotEqualTo(Integer value) {
            addCriterion("sumInvestCnt <>", value, "suminvestcnt");
            return (Criteria) this;
        }

        public Criteria andSuminvestcntGreaterThan(Integer value) {
            addCriterion("sumInvestCnt >", value, "suminvestcnt");
            return (Criteria) this;
        }

        public Criteria andSuminvestcntGreaterThanOrEqualTo(Integer value) {
            addCriterion("sumInvestCnt >=", value, "suminvestcnt");
            return (Criteria) this;
        }

        public Criteria andSuminvestcntLessThan(Integer value) {
            addCriterion("sumInvestCnt <", value, "suminvestcnt");
            return (Criteria) this;
        }

        public Criteria andSuminvestcntLessThanOrEqualTo(Integer value) {
            addCriterion("sumInvestCnt <=", value, "suminvestcnt");
            return (Criteria) this;
        }

        public Criteria andSuminvestcntIn(List<Integer> values) {
            addCriterion("sumInvestCnt in", values, "suminvestcnt");
            return (Criteria) this;
        }

        public Criteria andSuminvestcntNotIn(List<Integer> values) {
            addCriterion("sumInvestCnt not in", values, "suminvestcnt");
            return (Criteria) this;
        }

        public Criteria andSuminvestcntBetween(Integer value1, Integer value2) {
            addCriterion("sumInvestCnt between", value1, value2, "suminvestcnt");
            return (Criteria) this;
        }

        public Criteria andSuminvestcntNotBetween(Integer value1, Integer value2) {
            addCriterion("sumInvestCnt not between", value1, value2, "suminvestcnt");
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

        public Criteria andSexIsNull() {
            addCriterion("sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(String value) {
            addCriterion("sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(String value) {
            addCriterion("sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(String value) {
            addCriterion("sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(String value) {
            addCriterion("sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(String value) {
            addCriterion("sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(String value) {
            addCriterion("sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLike(String value) {
            addCriterion("sex like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotLike(String value) {
            addCriterion("sex not like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<String> values) {
            addCriterion("sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<String> values) {
            addCriterion("sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(String value1, String value2) {
            addCriterion("sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(String value1, String value2) {
            addCriterion("sex not between", value1, value2, "sex");
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
     *  investinfo
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
     *  investinfo
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