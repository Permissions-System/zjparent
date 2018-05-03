package com.zjgt.p2p.report.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TranslogExample {
    /**
     * orderByClausenull .
     *   translog
     *
     * @ET
     */
    protected String orderByClause;

    /**
     * distinctnull .
     *   translog
     *
     * @ET
     */
    protected boolean distinct;

    /**
     * oredCriterianull .
     *   translog
     *
     * @ET
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method:TranslogExample
     *   translog
     *
     * @ET
     */
    public TranslogExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method:setOrderByClause
     *   translog
     *
     * @ET
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method:getOrderByClause
     *   translog
     *
     * @ET
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method:setDistinct
     *   translog
     *
     * @ET
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method:isDistinct
     *   translog
     *
     * @ET
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method:getOredCriteria
     *   translog
     *
     * @ET
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method:or
     *   translog
     *
     * @ET
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method:or
     *   translog
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
     *   translog
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
     *   translog
     *
     * @ET
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method:clear
     *   translog
     *
     * @ET
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class:org.mybatis.generator.config.Context@19057e1c
     *  translog
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        protected void addCriterionForJDBCTime(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Time(value.getTime()), property);
        }

        protected void addCriterionForJDBCTime(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Time> timeList = new ArrayList<java.sql.Time>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                timeList.add(new java.sql.Time(iter.next().getTime()));
            }
            addCriterion(condition, timeList, property);
        }

        protected void addCriterionForJDBCTime(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Time(value1.getTime()), new java.sql.Time(value2.getTime()), property);
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

        public Criteria andUsernameIsNull() {
            addCriterion("username is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("username is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("username =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("username <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("username >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("username >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("username <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("username <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("username like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("username not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("username in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("username not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("username between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("username not between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andServTypeIsNull() {
            addCriterion("serv_type is null");
            return (Criteria) this;
        }

        public Criteria andServTypeIsNotNull() {
            addCriterion("serv_type is not null");
            return (Criteria) this;
        }

        public Criteria andServTypeEqualTo(String value) {
            addCriterion("serv_type =", value, "servType");
            return (Criteria) this;
        }

        public Criteria andServTypeNotEqualTo(String value) {
            addCriterion("serv_type <>", value, "servType");
            return (Criteria) this;
        }

        public Criteria andServTypeGreaterThan(String value) {
            addCriterion("serv_type >", value, "servType");
            return (Criteria) this;
        }

        public Criteria andServTypeGreaterThanOrEqualTo(String value) {
            addCriterion("serv_type >=", value, "servType");
            return (Criteria) this;
        }

        public Criteria andServTypeLessThan(String value) {
            addCriterion("serv_type <", value, "servType");
            return (Criteria) this;
        }

        public Criteria andServTypeLessThanOrEqualTo(String value) {
            addCriterion("serv_type <=", value, "servType");
            return (Criteria) this;
        }

        public Criteria andServTypeLike(String value) {
            addCriterion("serv_type like", value, "servType");
            return (Criteria) this;
        }

        public Criteria andServTypeNotLike(String value) {
            addCriterion("serv_type not like", value, "servType");
            return (Criteria) this;
        }

        public Criteria andServTypeIn(List<String> values) {
            addCriterion("serv_type in", values, "servType");
            return (Criteria) this;
        }

        public Criteria andServTypeNotIn(List<String> values) {
            addCriterion("serv_type not in", values, "servType");
            return (Criteria) this;
        }

        public Criteria andServTypeBetween(String value1, String value2) {
            addCriterion("serv_type between", value1, value2, "servType");
            return (Criteria) this;
        }

        public Criteria andServTypeNotBetween(String value1, String value2) {
            addCriterion("serv_type not between", value1, value2, "servType");
            return (Criteria) this;
        }

        public Criteria andServDespIsNull() {
            addCriterion("serv_desp is null");
            return (Criteria) this;
        }

        public Criteria andServDespIsNotNull() {
            addCriterion("serv_desp is not null");
            return (Criteria) this;
        }

        public Criteria andServDespEqualTo(String value) {
            addCriterion("serv_desp =", value, "servDesp");
            return (Criteria) this;
        }

        public Criteria andServDespNotEqualTo(String value) {
            addCriterion("serv_desp <>", value, "servDesp");
            return (Criteria) this;
        }

        public Criteria andServDespGreaterThan(String value) {
            addCriterion("serv_desp >", value, "servDesp");
            return (Criteria) this;
        }

        public Criteria andServDespGreaterThanOrEqualTo(String value) {
            addCriterion("serv_desp >=", value, "servDesp");
            return (Criteria) this;
        }

        public Criteria andServDespLessThan(String value) {
            addCriterion("serv_desp <", value, "servDesp");
            return (Criteria) this;
        }

        public Criteria andServDespLessThanOrEqualTo(String value) {
            addCriterion("serv_desp <=", value, "servDesp");
            return (Criteria) this;
        }

        public Criteria andServDespLike(String value) {
            addCriterion("serv_desp like", value, "servDesp");
            return (Criteria) this;
        }

        public Criteria andServDespNotLike(String value) {
            addCriterion("serv_desp not like", value, "servDesp");
            return (Criteria) this;
        }

        public Criteria andServDespIn(List<String> values) {
            addCriterion("serv_desp in", values, "servDesp");
            return (Criteria) this;
        }

        public Criteria andServDespNotIn(List<String> values) {
            addCriterion("serv_desp not in", values, "servDesp");
            return (Criteria) this;
        }

        public Criteria andServDespBetween(String value1, String value2) {
            addCriterion("serv_desp between", value1, value2, "servDesp");
            return (Criteria) this;
        }

        public Criteria andServDespNotBetween(String value1, String value2) {
            addCriterion("serv_desp not between", value1, value2, "servDesp");
            return (Criteria) this;
        }

        public Criteria andExtTpIsNull() {
            addCriterion("ext_tp is null");
            return (Criteria) this;
        }

        public Criteria andExtTpIsNotNull() {
            addCriterion("ext_tp is not null");
            return (Criteria) this;
        }

        public Criteria andExtTpEqualTo(String value) {
            addCriterion("ext_tp =", value, "extTp");
            return (Criteria) this;
        }

        public Criteria andExtTpNotEqualTo(String value) {
            addCriterion("ext_tp <>", value, "extTp");
            return (Criteria) this;
        }

        public Criteria andExtTpGreaterThan(String value) {
            addCriterion("ext_tp >", value, "extTp");
            return (Criteria) this;
        }

        public Criteria andExtTpGreaterThanOrEqualTo(String value) {
            addCriterion("ext_tp >=", value, "extTp");
            return (Criteria) this;
        }

        public Criteria andExtTpLessThan(String value) {
            addCriterion("ext_tp <", value, "extTp");
            return (Criteria) this;
        }

        public Criteria andExtTpLessThanOrEqualTo(String value) {
            addCriterion("ext_tp <=", value, "extTp");
            return (Criteria) this;
        }

        public Criteria andExtTpLike(String value) {
            addCriterion("ext_tp like", value, "extTp");
            return (Criteria) this;
        }

        public Criteria andExtTpNotLike(String value) {
            addCriterion("ext_tp not like", value, "extTp");
            return (Criteria) this;
        }

        public Criteria andExtTpIn(List<String> values) {
            addCriterion("ext_tp in", values, "extTp");
            return (Criteria) this;
        }

        public Criteria andExtTpNotIn(List<String> values) {
            addCriterion("ext_tp not in", values, "extTp");
            return (Criteria) this;
        }

        public Criteria andExtTpBetween(String value1, String value2) {
            addCriterion("ext_tp between", value1, value2, "extTp");
            return (Criteria) this;
        }

        public Criteria andExtTpNotBetween(String value1, String value2) {
            addCriterion("ext_tp not between", value1, value2, "extTp");
            return (Criteria) this;
        }

        public Criteria andTxnDateIsNull() {
            addCriterion("txn_date is null");
            return (Criteria) this;
        }

        public Criteria andTxnDateIsNotNull() {
            addCriterion("txn_date is not null");
            return (Criteria) this;
        }

        public Criteria andTxnDateEqualTo(Date value) {
            addCriterionForJDBCDate("txn_date =", value, "txnDate");
            return (Criteria) this;
        }

        public Criteria andTxnDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("txn_date <>", value, "txnDate");
            return (Criteria) this;
        }

        public Criteria andTxnDateGreaterThan(Date value) {
            addCriterionForJDBCDate("txn_date >", value, "txnDate");
            return (Criteria) this;
        }

        public Criteria andTxnDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("txn_date >=", value, "txnDate");
            return (Criteria) this;
        }

        public Criteria andTxnDateLessThan(Date value) {
            addCriterionForJDBCDate("txn_date <", value, "txnDate");
            return (Criteria) this;
        }

        public Criteria andTxnDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("txn_date <=", value, "txnDate");
            return (Criteria) this;
        }

        public Criteria andTxnDateIn(List<Date> values) {
            addCriterionForJDBCDate("txn_date in", values, "txnDate");
            return (Criteria) this;
        }

        public Criteria andTxnDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("txn_date not in", values, "txnDate");
            return (Criteria) this;
        }

        public Criteria andTxnDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("txn_date between", value1, value2, "txnDate");
            return (Criteria) this;
        }

        public Criteria andTxnDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("txn_date not between", value1, value2, "txnDate");
            return (Criteria) this;
        }

        public Criteria andTxnTimeIsNull() {
            addCriterion("txn_time is null");
            return (Criteria) this;
        }

        public Criteria andTxnTimeIsNotNull() {
            addCriterion("txn_time is not null");
            return (Criteria) this;
        }

        public Criteria andTxnTimeEqualTo(Date value) {
            addCriterionForJDBCTime("txn_time =", value, "txnTime");
            return (Criteria) this;
        }

        public Criteria andTxnTimeNotEqualTo(Date value) {
            addCriterionForJDBCTime("txn_time <>", value, "txnTime");
            return (Criteria) this;
        }

        public Criteria andTxnTimeGreaterThan(Date value) {
            addCriterionForJDBCTime("txn_time >", value, "txnTime");
            return (Criteria) this;
        }

        public Criteria andTxnTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("txn_time >=", value, "txnTime");
            return (Criteria) this;
        }

        public Criteria andTxnTimeLessThan(Date value) {
            addCriterionForJDBCTime("txn_time <", value, "txnTime");
            return (Criteria) this;
        }

        public Criteria andTxnTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("txn_time <=", value, "txnTime");
            return (Criteria) this;
        }

        public Criteria andTxnTimeIn(List<Date> values) {
            addCriterionForJDBCTime("txn_time in", values, "txnTime");
            return (Criteria) this;
        }

        public Criteria andTxnTimeNotIn(List<Date> values) {
            addCriterionForJDBCTime("txn_time not in", values, "txnTime");
            return (Criteria) this;
        }

        public Criteria andTxnTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("txn_time between", value1, value2, "txnTime");
            return (Criteria) this;
        }

        public Criteria andTxnTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("txn_time not between", value1, value2, "txnTime");
            return (Criteria) this;
        }

        public Criteria andMchntSsnIsNull() {
            addCriterion("mchnt_ssn is null");
            return (Criteria) this;
        }

        public Criteria andMchntSsnIsNotNull() {
            addCriterion("mchnt_ssn is not null");
            return (Criteria) this;
        }

        public Criteria andMchntSsnEqualTo(String value) {
            addCriterion("mchnt_ssn =", value, "mchntSsn");
            return (Criteria) this;
        }

        public Criteria andMchntSsnNotEqualTo(String value) {
            addCriterion("mchnt_ssn <>", value, "mchntSsn");
            return (Criteria) this;
        }

        public Criteria andMchntSsnGreaterThan(String value) {
            addCriterion("mchnt_ssn >", value, "mchntSsn");
            return (Criteria) this;
        }

        public Criteria andMchntSsnGreaterThanOrEqualTo(String value) {
            addCriterion("mchnt_ssn >=", value, "mchntSsn");
            return (Criteria) this;
        }

        public Criteria andMchntSsnLessThan(String value) {
            addCriterion("mchnt_ssn <", value, "mchntSsn");
            return (Criteria) this;
        }

        public Criteria andMchntSsnLessThanOrEqualTo(String value) {
            addCriterion("mchnt_ssn <=", value, "mchntSsn");
            return (Criteria) this;
        }

        public Criteria andMchntSsnLike(String value) {
            addCriterion("mchnt_ssn like", value, "mchntSsn");
            return (Criteria) this;
        }

        public Criteria andMchntSsnNotLike(String value) {
            addCriterion("mchnt_ssn not like", value, "mchntSsn");
            return (Criteria) this;
        }

        public Criteria andMchntSsnIn(List<String> values) {
            addCriterion("mchnt_ssn in", values, "mchntSsn");
            return (Criteria) this;
        }

        public Criteria andMchntSsnNotIn(List<String> values) {
            addCriterion("mchnt_ssn not in", values, "mchntSsn");
            return (Criteria) this;
        }

        public Criteria andMchntSsnBetween(String value1, String value2) {
            addCriterion("mchnt_ssn between", value1, value2, "mchntSsn");
            return (Criteria) this;
        }

        public Criteria andMchntSsnNotBetween(String value1, String value2) {
            addCriterion("mchnt_ssn not between", value1, value2, "mchntSsn");
            return (Criteria) this;
        }

        public Criteria andTxnAmtIsNull() {
            addCriterion("txn_amt is null");
            return (Criteria) this;
        }

        public Criteria andTxnAmtIsNotNull() {
            addCriterion("txn_amt is not null");
            return (Criteria) this;
        }

        public Criteria andTxnAmtEqualTo(BigDecimal value) {
            addCriterion("txn_amt =", value, "txnAmt");
            return (Criteria) this;
        }

        public Criteria andTxnAmtNotEqualTo(BigDecimal value) {
            addCriterion("txn_amt <>", value, "txnAmt");
            return (Criteria) this;
        }

        public Criteria andTxnAmtGreaterThan(BigDecimal value) {
            addCriterion("txn_amt >", value, "txnAmt");
            return (Criteria) this;
        }

        public Criteria andTxnAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("txn_amt >=", value, "txnAmt");
            return (Criteria) this;
        }

        public Criteria andTxnAmtLessThan(BigDecimal value) {
            addCriterion("txn_amt <", value, "txnAmt");
            return (Criteria) this;
        }

        public Criteria andTxnAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("txn_amt <=", value, "txnAmt");
            return (Criteria) this;
        }

        public Criteria andTxnAmtIn(List<BigDecimal> values) {
            addCriterion("txn_amt in", values, "txnAmt");
            return (Criteria) this;
        }

        public Criteria andTxnAmtNotIn(List<BigDecimal> values) {
            addCriterion("txn_amt not in", values, "txnAmt");
            return (Criteria) this;
        }

        public Criteria andTxnAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("txn_amt between", value1, value2, "txnAmt");
            return (Criteria) this;
        }

        public Criteria andTxnAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("txn_amt not between", value1, value2, "txnAmt");
            return (Criteria) this;
        }

        public Criteria andTxnAmtSucIsNull() {
            addCriterion("txn_amt_suc is null");
            return (Criteria) this;
        }

        public Criteria andTxnAmtSucIsNotNull() {
            addCriterion("txn_amt_suc is not null");
            return (Criteria) this;
        }

        public Criteria andTxnAmtSucEqualTo(BigDecimal value) {
            addCriterion("txn_amt_suc =", value, "txnAmtSuc");
            return (Criteria) this;
        }

        public Criteria andTxnAmtSucNotEqualTo(BigDecimal value) {
            addCriterion("txn_amt_suc <>", value, "txnAmtSuc");
            return (Criteria) this;
        }

        public Criteria andTxnAmtSucGreaterThan(BigDecimal value) {
            addCriterion("txn_amt_suc >", value, "txnAmtSuc");
            return (Criteria) this;
        }

        public Criteria andTxnAmtSucGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("txn_amt_suc >=", value, "txnAmtSuc");
            return (Criteria) this;
        }

        public Criteria andTxnAmtSucLessThan(BigDecimal value) {
            addCriterion("txn_amt_suc <", value, "txnAmtSuc");
            return (Criteria) this;
        }

        public Criteria andTxnAmtSucLessThanOrEqualTo(BigDecimal value) {
            addCriterion("txn_amt_suc <=", value, "txnAmtSuc");
            return (Criteria) this;
        }

        public Criteria andTxnAmtSucIn(List<BigDecimal> values) {
            addCriterion("txn_amt_suc in", values, "txnAmtSuc");
            return (Criteria) this;
        }

        public Criteria andTxnAmtSucNotIn(List<BigDecimal> values) {
            addCriterion("txn_amt_suc not in", values, "txnAmtSuc");
            return (Criteria) this;
        }

        public Criteria andTxnAmtSucBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("txn_amt_suc between", value1, value2, "txnAmtSuc");
            return (Criteria) this;
        }

        public Criteria andTxnAmtSucNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("txn_amt_suc not between", value1, value2, "txnAmtSuc");
            return (Criteria) this;
        }

        public Criteria andContractNoIsNull() {
            addCriterion("contract_no is null");
            return (Criteria) this;
        }

        public Criteria andContractNoIsNotNull() {
            addCriterion("contract_no is not null");
            return (Criteria) this;
        }

        public Criteria andContractNoEqualTo(String value) {
            addCriterion("contract_no =", value, "contractNo");
            return (Criteria) this;
        }

        public Criteria andContractNoNotEqualTo(String value) {
            addCriterion("contract_no <>", value, "contractNo");
            return (Criteria) this;
        }

        public Criteria andContractNoGreaterThan(String value) {
            addCriterion("contract_no >", value, "contractNo");
            return (Criteria) this;
        }

        public Criteria andContractNoGreaterThanOrEqualTo(String value) {
            addCriterion("contract_no >=", value, "contractNo");
            return (Criteria) this;
        }

        public Criteria andContractNoLessThan(String value) {
            addCriterion("contract_no <", value, "contractNo");
            return (Criteria) this;
        }

        public Criteria andContractNoLessThanOrEqualTo(String value) {
            addCriterion("contract_no <=", value, "contractNo");
            return (Criteria) this;
        }

        public Criteria andContractNoLike(String value) {
            addCriterion("contract_no like", value, "contractNo");
            return (Criteria) this;
        }

        public Criteria andContractNoNotLike(String value) {
            addCriterion("contract_no not like", value, "contractNo");
            return (Criteria) this;
        }

        public Criteria andContractNoIn(List<String> values) {
            addCriterion("contract_no in", values, "contractNo");
            return (Criteria) this;
        }

        public Criteria andContractNoNotIn(List<String> values) {
            addCriterion("contract_no not in", values, "contractNo");
            return (Criteria) this;
        }

        public Criteria andContractNoBetween(String value1, String value2) {
            addCriterion("contract_no between", value1, value2, "contractNo");
            return (Criteria) this;
        }

        public Criteria andContractNoNotBetween(String value1, String value2) {
            addCriterion("contract_no not between", value1, value2, "contractNo");
            return (Criteria) this;
        }

        public Criteria andOutFuiouAcctNoIsNull() {
            addCriterion("out_fuiou_acct_no is null");
            return (Criteria) this;
        }

        public Criteria andOutFuiouAcctNoIsNotNull() {
            addCriterion("out_fuiou_acct_no is not null");
            return (Criteria) this;
        }

        public Criteria andOutFuiouAcctNoEqualTo(String value) {
            addCriterion("out_fuiou_acct_no =", value, "outFuiouAcctNo");
            return (Criteria) this;
        }

        public Criteria andOutFuiouAcctNoNotEqualTo(String value) {
            addCriterion("out_fuiou_acct_no <>", value, "outFuiouAcctNo");
            return (Criteria) this;
        }

        public Criteria andOutFuiouAcctNoGreaterThan(String value) {
            addCriterion("out_fuiou_acct_no >", value, "outFuiouAcctNo");
            return (Criteria) this;
        }

        public Criteria andOutFuiouAcctNoGreaterThanOrEqualTo(String value) {
            addCriterion("out_fuiou_acct_no >=", value, "outFuiouAcctNo");
            return (Criteria) this;
        }

        public Criteria andOutFuiouAcctNoLessThan(String value) {
            addCriterion("out_fuiou_acct_no <", value, "outFuiouAcctNo");
            return (Criteria) this;
        }

        public Criteria andOutFuiouAcctNoLessThanOrEqualTo(String value) {
            addCriterion("out_fuiou_acct_no <=", value, "outFuiouAcctNo");
            return (Criteria) this;
        }

        public Criteria andOutFuiouAcctNoLike(String value) {
            addCriterion("out_fuiou_acct_no like", value, "outFuiouAcctNo");
            return (Criteria) this;
        }

        public Criteria andOutFuiouAcctNoNotLike(String value) {
            addCriterion("out_fuiou_acct_no not like", value, "outFuiouAcctNo");
            return (Criteria) this;
        }

        public Criteria andOutFuiouAcctNoIn(List<String> values) {
            addCriterion("out_fuiou_acct_no in", values, "outFuiouAcctNo");
            return (Criteria) this;
        }

        public Criteria andOutFuiouAcctNoNotIn(List<String> values) {
            addCriterion("out_fuiou_acct_no not in", values, "outFuiouAcctNo");
            return (Criteria) this;
        }

        public Criteria andOutFuiouAcctNoBetween(String value1, String value2) {
            addCriterion("out_fuiou_acct_no between", value1, value2, "outFuiouAcctNo");
            return (Criteria) this;
        }

        public Criteria andOutFuiouAcctNoNotBetween(String value1, String value2) {
            addCriterion("out_fuiou_acct_no not between", value1, value2, "outFuiouAcctNo");
            return (Criteria) this;
        }

        public Criteria andOutCustNoIsNull() {
            addCriterion("out_cust_no is null");
            return (Criteria) this;
        }

        public Criteria andOutCustNoIsNotNull() {
            addCriterion("out_cust_no is not null");
            return (Criteria) this;
        }

        public Criteria andOutCustNoEqualTo(String value) {
            addCriterion("out_cust_no =", value, "outCustNo");
            return (Criteria) this;
        }

        public Criteria andOutCustNoNotEqualTo(String value) {
            addCriterion("out_cust_no <>", value, "outCustNo");
            return (Criteria) this;
        }

        public Criteria andOutCustNoGreaterThan(String value) {
            addCriterion("out_cust_no >", value, "outCustNo");
            return (Criteria) this;
        }

        public Criteria andOutCustNoGreaterThanOrEqualTo(String value) {
            addCriterion("out_cust_no >=", value, "outCustNo");
            return (Criteria) this;
        }

        public Criteria andOutCustNoLessThan(String value) {
            addCriterion("out_cust_no <", value, "outCustNo");
            return (Criteria) this;
        }

        public Criteria andOutCustNoLessThanOrEqualTo(String value) {
            addCriterion("out_cust_no <=", value, "outCustNo");
            return (Criteria) this;
        }

        public Criteria andOutCustNoLike(String value) {
            addCriterion("out_cust_no like", value, "outCustNo");
            return (Criteria) this;
        }

        public Criteria andOutCustNoNotLike(String value) {
            addCriterion("out_cust_no not like", value, "outCustNo");
            return (Criteria) this;
        }

        public Criteria andOutCustNoIn(List<String> values) {
            addCriterion("out_cust_no in", values, "outCustNo");
            return (Criteria) this;
        }

        public Criteria andOutCustNoNotIn(List<String> values) {
            addCriterion("out_cust_no not in", values, "outCustNo");
            return (Criteria) this;
        }

        public Criteria andOutCustNoBetween(String value1, String value2) {
            addCriterion("out_cust_no between", value1, value2, "outCustNo");
            return (Criteria) this;
        }

        public Criteria andOutCustNoNotBetween(String value1, String value2) {
            addCriterion("out_cust_no not between", value1, value2, "outCustNo");
            return (Criteria) this;
        }

        public Criteria andOutArtifNmIsNull() {
            addCriterion("out_artif_nm is null");
            return (Criteria) this;
        }

        public Criteria andOutArtifNmIsNotNull() {
            addCriterion("out_artif_nm is not null");
            return (Criteria) this;
        }

        public Criteria andOutArtifNmEqualTo(String value) {
            addCriterion("out_artif_nm =", value, "outArtifNm");
            return (Criteria) this;
        }

        public Criteria andOutArtifNmNotEqualTo(String value) {
            addCriterion("out_artif_nm <>", value, "outArtifNm");
            return (Criteria) this;
        }

        public Criteria andOutArtifNmGreaterThan(String value) {
            addCriterion("out_artif_nm >", value, "outArtifNm");
            return (Criteria) this;
        }

        public Criteria andOutArtifNmGreaterThanOrEqualTo(String value) {
            addCriterion("out_artif_nm >=", value, "outArtifNm");
            return (Criteria) this;
        }

        public Criteria andOutArtifNmLessThan(String value) {
            addCriterion("out_artif_nm <", value, "outArtifNm");
            return (Criteria) this;
        }

        public Criteria andOutArtifNmLessThanOrEqualTo(String value) {
            addCriterion("out_artif_nm <=", value, "outArtifNm");
            return (Criteria) this;
        }

        public Criteria andOutArtifNmLike(String value) {
            addCriterion("out_artif_nm like", value, "outArtifNm");
            return (Criteria) this;
        }

        public Criteria andOutArtifNmNotLike(String value) {
            addCriterion("out_artif_nm not like", value, "outArtifNm");
            return (Criteria) this;
        }

        public Criteria andOutArtifNmIn(List<String> values) {
            addCriterion("out_artif_nm in", values, "outArtifNm");
            return (Criteria) this;
        }

        public Criteria andOutArtifNmNotIn(List<String> values) {
            addCriterion("out_artif_nm not in", values, "outArtifNm");
            return (Criteria) this;
        }

        public Criteria andOutArtifNmBetween(String value1, String value2) {
            addCriterion("out_artif_nm between", value1, value2, "outArtifNm");
            return (Criteria) this;
        }

        public Criteria andOutArtifNmNotBetween(String value1, String value2) {
            addCriterion("out_artif_nm not between", value1, value2, "outArtifNm");
            return (Criteria) this;
        }

        public Criteria andInFuiouAcctNoIsNull() {
            addCriterion("in_fuiou_acct_no is null");
            return (Criteria) this;
        }

        public Criteria andInFuiouAcctNoIsNotNull() {
            addCriterion("in_fuiou_acct_no is not null");
            return (Criteria) this;
        }

        public Criteria andInFuiouAcctNoEqualTo(String value) {
            addCriterion("in_fuiou_acct_no =", value, "inFuiouAcctNo");
            return (Criteria) this;
        }

        public Criteria andInFuiouAcctNoNotEqualTo(String value) {
            addCriterion("in_fuiou_acct_no <>", value, "inFuiouAcctNo");
            return (Criteria) this;
        }

        public Criteria andInFuiouAcctNoGreaterThan(String value) {
            addCriterion("in_fuiou_acct_no >", value, "inFuiouAcctNo");
            return (Criteria) this;
        }

        public Criteria andInFuiouAcctNoGreaterThanOrEqualTo(String value) {
            addCriterion("in_fuiou_acct_no >=", value, "inFuiouAcctNo");
            return (Criteria) this;
        }

        public Criteria andInFuiouAcctNoLessThan(String value) {
            addCriterion("in_fuiou_acct_no <", value, "inFuiouAcctNo");
            return (Criteria) this;
        }

        public Criteria andInFuiouAcctNoLessThanOrEqualTo(String value) {
            addCriterion("in_fuiou_acct_no <=", value, "inFuiouAcctNo");
            return (Criteria) this;
        }

        public Criteria andInFuiouAcctNoLike(String value) {
            addCriterion("in_fuiou_acct_no like", value, "inFuiouAcctNo");
            return (Criteria) this;
        }

        public Criteria andInFuiouAcctNoNotLike(String value) {
            addCriterion("in_fuiou_acct_no not like", value, "inFuiouAcctNo");
            return (Criteria) this;
        }

        public Criteria andInFuiouAcctNoIn(List<String> values) {
            addCriterion("in_fuiou_acct_no in", values, "inFuiouAcctNo");
            return (Criteria) this;
        }

        public Criteria andInFuiouAcctNoNotIn(List<String> values) {
            addCriterion("in_fuiou_acct_no not in", values, "inFuiouAcctNo");
            return (Criteria) this;
        }

        public Criteria andInFuiouAcctNoBetween(String value1, String value2) {
            addCriterion("in_fuiou_acct_no between", value1, value2, "inFuiouAcctNo");
            return (Criteria) this;
        }

        public Criteria andInFuiouAcctNoNotBetween(String value1, String value2) {
            addCriterion("in_fuiou_acct_no not between", value1, value2, "inFuiouAcctNo");
            return (Criteria) this;
        }

        public Criteria andInCustNoIsNull() {
            addCriterion("in_cust_no is null");
            return (Criteria) this;
        }

        public Criteria andInCustNoIsNotNull() {
            addCriterion("in_cust_no is not null");
            return (Criteria) this;
        }

        public Criteria andInCustNoEqualTo(String value) {
            addCriterion("in_cust_no =", value, "inCustNo");
            return (Criteria) this;
        }

        public Criteria andInCustNoNotEqualTo(String value) {
            addCriterion("in_cust_no <>", value, "inCustNo");
            return (Criteria) this;
        }

        public Criteria andInCustNoGreaterThan(String value) {
            addCriterion("in_cust_no >", value, "inCustNo");
            return (Criteria) this;
        }

        public Criteria andInCustNoGreaterThanOrEqualTo(String value) {
            addCriterion("in_cust_no >=", value, "inCustNo");
            return (Criteria) this;
        }

        public Criteria andInCustNoLessThan(String value) {
            addCriterion("in_cust_no <", value, "inCustNo");
            return (Criteria) this;
        }

        public Criteria andInCustNoLessThanOrEqualTo(String value) {
            addCriterion("in_cust_no <=", value, "inCustNo");
            return (Criteria) this;
        }

        public Criteria andInCustNoLike(String value) {
            addCriterion("in_cust_no like", value, "inCustNo");
            return (Criteria) this;
        }

        public Criteria andInCustNoNotLike(String value) {
            addCriterion("in_cust_no not like", value, "inCustNo");
            return (Criteria) this;
        }

        public Criteria andInCustNoIn(List<String> values) {
            addCriterion("in_cust_no in", values, "inCustNo");
            return (Criteria) this;
        }

        public Criteria andInCustNoNotIn(List<String> values) {
            addCriterion("in_cust_no not in", values, "inCustNo");
            return (Criteria) this;
        }

        public Criteria andInCustNoBetween(String value1, String value2) {
            addCriterion("in_cust_no between", value1, value2, "inCustNo");
            return (Criteria) this;
        }

        public Criteria andInCustNoNotBetween(String value1, String value2) {
            addCriterion("in_cust_no not between", value1, value2, "inCustNo");
            return (Criteria) this;
        }

        public Criteria andInArtifNmIsNull() {
            addCriterion("in_artif_nm is null");
            return (Criteria) this;
        }

        public Criteria andInArtifNmIsNotNull() {
            addCriterion("in_artif_nm is not null");
            return (Criteria) this;
        }

        public Criteria andInArtifNmEqualTo(String value) {
            addCriterion("in_artif_nm =", value, "inArtifNm");
            return (Criteria) this;
        }

        public Criteria andInArtifNmNotEqualTo(String value) {
            addCriterion("in_artif_nm <>", value, "inArtifNm");
            return (Criteria) this;
        }

        public Criteria andInArtifNmGreaterThan(String value) {
            addCriterion("in_artif_nm >", value, "inArtifNm");
            return (Criteria) this;
        }

        public Criteria andInArtifNmGreaterThanOrEqualTo(String value) {
            addCriterion("in_artif_nm >=", value, "inArtifNm");
            return (Criteria) this;
        }

        public Criteria andInArtifNmLessThan(String value) {
            addCriterion("in_artif_nm <", value, "inArtifNm");
            return (Criteria) this;
        }

        public Criteria andInArtifNmLessThanOrEqualTo(String value) {
            addCriterion("in_artif_nm <=", value, "inArtifNm");
            return (Criteria) this;
        }

        public Criteria andInArtifNmLike(String value) {
            addCriterion("in_artif_nm like", value, "inArtifNm");
            return (Criteria) this;
        }

        public Criteria andInArtifNmNotLike(String value) {
            addCriterion("in_artif_nm not like", value, "inArtifNm");
            return (Criteria) this;
        }

        public Criteria andInArtifNmIn(List<String> values) {
            addCriterion("in_artif_nm in", values, "inArtifNm");
            return (Criteria) this;
        }

        public Criteria andInArtifNmNotIn(List<String> values) {
            addCriterion("in_artif_nm not in", values, "inArtifNm");
            return (Criteria) this;
        }

        public Criteria andInArtifNmBetween(String value1, String value2) {
            addCriterion("in_artif_nm between", value1, value2, "inArtifNm");
            return (Criteria) this;
        }

        public Criteria andInArtifNmNotBetween(String value1, String value2) {
            addCriterion("in_artif_nm not between", value1, value2, "inArtifNm");
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

        public Criteria andTxnRspCdIsNull() {
            addCriterion("txn_rsp_cd is null");
            return (Criteria) this;
        }

        public Criteria andTxnRspCdIsNotNull() {
            addCriterion("txn_rsp_cd is not null");
            return (Criteria) this;
        }

        public Criteria andTxnRspCdEqualTo(String value) {
            addCriterion("txn_rsp_cd =", value, "txnRspCd");
            return (Criteria) this;
        }

        public Criteria andTxnRspCdNotEqualTo(String value) {
            addCriterion("txn_rsp_cd <>", value, "txnRspCd");
            return (Criteria) this;
        }

        public Criteria andTxnRspCdGreaterThan(String value) {
            addCriterion("txn_rsp_cd >", value, "txnRspCd");
            return (Criteria) this;
        }

        public Criteria andTxnRspCdGreaterThanOrEqualTo(String value) {
            addCriterion("txn_rsp_cd >=", value, "txnRspCd");
            return (Criteria) this;
        }

        public Criteria andTxnRspCdLessThan(String value) {
            addCriterion("txn_rsp_cd <", value, "txnRspCd");
            return (Criteria) this;
        }

        public Criteria andTxnRspCdLessThanOrEqualTo(String value) {
            addCriterion("txn_rsp_cd <=", value, "txnRspCd");
            return (Criteria) this;
        }

        public Criteria andTxnRspCdLike(String value) {
            addCriterion("txn_rsp_cd like", value, "txnRspCd");
            return (Criteria) this;
        }

        public Criteria andTxnRspCdNotLike(String value) {
            addCriterion("txn_rsp_cd not like", value, "txnRspCd");
            return (Criteria) this;
        }

        public Criteria andTxnRspCdIn(List<String> values) {
            addCriterion("txn_rsp_cd in", values, "txnRspCd");
            return (Criteria) this;
        }

        public Criteria andTxnRspCdNotIn(List<String> values) {
            addCriterion("txn_rsp_cd not in", values, "txnRspCd");
            return (Criteria) this;
        }

        public Criteria andTxnRspCdBetween(String value1, String value2) {
            addCriterion("txn_rsp_cd between", value1, value2, "txnRspCd");
            return (Criteria) this;
        }

        public Criteria andTxnRspCdNotBetween(String value1, String value2) {
            addCriterion("txn_rsp_cd not between", value1, value2, "txnRspCd");
            return (Criteria) this;
        }

        public Criteria andRspCdDescIsNull() {
            addCriterion("rsp_cd_desc is null");
            return (Criteria) this;
        }

        public Criteria andRspCdDescIsNotNull() {
            addCriterion("rsp_cd_desc is not null");
            return (Criteria) this;
        }

        public Criteria andRspCdDescEqualTo(String value) {
            addCriterion("rsp_cd_desc =", value, "rspCdDesc");
            return (Criteria) this;
        }

        public Criteria andRspCdDescNotEqualTo(String value) {
            addCriterion("rsp_cd_desc <>", value, "rspCdDesc");
            return (Criteria) this;
        }

        public Criteria andRspCdDescGreaterThan(String value) {
            addCriterion("rsp_cd_desc >", value, "rspCdDesc");
            return (Criteria) this;
        }

        public Criteria andRspCdDescGreaterThanOrEqualTo(String value) {
            addCriterion("rsp_cd_desc >=", value, "rspCdDesc");
            return (Criteria) this;
        }

        public Criteria andRspCdDescLessThan(String value) {
            addCriterion("rsp_cd_desc <", value, "rspCdDesc");
            return (Criteria) this;
        }

        public Criteria andRspCdDescLessThanOrEqualTo(String value) {
            addCriterion("rsp_cd_desc <=", value, "rspCdDesc");
            return (Criteria) this;
        }

        public Criteria andRspCdDescLike(String value) {
            addCriterion("rsp_cd_desc like", value, "rspCdDesc");
            return (Criteria) this;
        }

        public Criteria andRspCdDescNotLike(String value) {
            addCriterion("rsp_cd_desc not like", value, "rspCdDesc");
            return (Criteria) this;
        }

        public Criteria andRspCdDescIn(List<String> values) {
            addCriterion("rsp_cd_desc in", values, "rspCdDesc");
            return (Criteria) this;
        }

        public Criteria andRspCdDescNotIn(List<String> values) {
            addCriterion("rsp_cd_desc not in", values, "rspCdDesc");
            return (Criteria) this;
        }

        public Criteria andRspCdDescBetween(String value1, String value2) {
            addCriterion("rsp_cd_desc between", value1, value2, "rspCdDesc");
            return (Criteria) this;
        }

        public Criteria andRspCdDescNotBetween(String value1, String value2) {
            addCriterion("rsp_cd_desc not between", value1, value2, "rspCdDesc");
            return (Criteria) this;
        }

        public Criteria andSourCodeIsNull() {
            addCriterion("sour_code is null");
            return (Criteria) this;
        }

        public Criteria andSourCodeIsNotNull() {
            addCriterion("sour_code is not null");
            return (Criteria) this;
        }

        public Criteria andSourCodeEqualTo(String value) {
            addCriterion("sour_code =", value, "sourCode");
            return (Criteria) this;
        }

        public Criteria andSourCodeNotEqualTo(String value) {
            addCriterion("sour_code <>", value, "sourCode");
            return (Criteria) this;
        }

        public Criteria andSourCodeGreaterThan(String value) {
            addCriterion("sour_code >", value, "sourCode");
            return (Criteria) this;
        }

        public Criteria andSourCodeGreaterThanOrEqualTo(String value) {
            addCriterion("sour_code >=", value, "sourCode");
            return (Criteria) this;
        }

        public Criteria andSourCodeLessThan(String value) {
            addCriterion("sour_code <", value, "sourCode");
            return (Criteria) this;
        }

        public Criteria andSourCodeLessThanOrEqualTo(String value) {
            addCriterion("sour_code <=", value, "sourCode");
            return (Criteria) this;
        }

        public Criteria andSourCodeLike(String value) {
            addCriterion("sour_code like", value, "sourCode");
            return (Criteria) this;
        }

        public Criteria andSourCodeNotLike(String value) {
            addCriterion("sour_code not like", value, "sourCode");
            return (Criteria) this;
        }

        public Criteria andSourCodeIn(List<String> values) {
            addCriterion("sour_code in", values, "sourCode");
            return (Criteria) this;
        }

        public Criteria andSourCodeNotIn(List<String> values) {
            addCriterion("sour_code not in", values, "sourCode");
            return (Criteria) this;
        }

        public Criteria andSourCodeBetween(String value1, String value2) {
            addCriterion("sour_code between", value1, value2, "sourCode");
            return (Criteria) this;
        }

        public Criteria andSourCodeNotBetween(String value1, String value2) {
            addCriterion("sour_code not between", value1, value2, "sourCode");
            return (Criteria) this;
        }

        public Criteria andBusiTpIsNull() {
            addCriterion("busi_tp is null");
            return (Criteria) this;
        }

        public Criteria andBusiTpIsNotNull() {
            addCriterion("busi_tp is not null");
            return (Criteria) this;
        }

        public Criteria andBusiTpEqualTo(String value) {
            addCriterion("busi_tp =", value, "busiTp");
            return (Criteria) this;
        }

        public Criteria andBusiTpNotEqualTo(String value) {
            addCriterion("busi_tp <>", value, "busiTp");
            return (Criteria) this;
        }

        public Criteria andBusiTpGreaterThan(String value) {
            addCriterion("busi_tp >", value, "busiTp");
            return (Criteria) this;
        }

        public Criteria andBusiTpGreaterThanOrEqualTo(String value) {
            addCriterion("busi_tp >=", value, "busiTp");
            return (Criteria) this;
        }

        public Criteria andBusiTpLessThan(String value) {
            addCriterion("busi_tp <", value, "busiTp");
            return (Criteria) this;
        }

        public Criteria andBusiTpLessThanOrEqualTo(String value) {
            addCriterion("busi_tp <=", value, "busiTp");
            return (Criteria) this;
        }

        public Criteria andBusiTpLike(String value) {
            addCriterion("busi_tp like", value, "busiTp");
            return (Criteria) this;
        }

        public Criteria andBusiTpNotLike(String value) {
            addCriterion("busi_tp not like", value, "busiTp");
            return (Criteria) this;
        }

        public Criteria andBusiTpIn(List<String> values) {
            addCriterion("busi_tp in", values, "busiTp");
            return (Criteria) this;
        }

        public Criteria andBusiTpNotIn(List<String> values) {
            addCriterion("busi_tp not in", values, "busiTp");
            return (Criteria) this;
        }

        public Criteria andBusiTpBetween(String value1, String value2) {
            addCriterion("busi_tp between", value1, value2, "busiTp");
            return (Criteria) this;
        }

        public Criteria andBusiTpNotBetween(String value1, String value2) {
            addCriterion("busi_tp not between", value1, value2, "busiTp");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andCheckflagIsNull() {
            addCriterion("checkflag is null");
            return (Criteria) this;
        }

        public Criteria andCheckflagIsNotNull() {
            addCriterion("checkflag is not null");
            return (Criteria) this;
        }

        public Criteria andCheckflagEqualTo(String value) {
            addCriterion("checkflag =", value, "checkflag");
            return (Criteria) this;
        }

        public Criteria andCheckflagNotEqualTo(String value) {
            addCriterion("checkflag <>", value, "checkflag");
            return (Criteria) this;
        }

        public Criteria andCheckflagGreaterThan(String value) {
            addCriterion("checkflag >", value, "checkflag");
            return (Criteria) this;
        }

        public Criteria andCheckflagGreaterThanOrEqualTo(String value) {
            addCriterion("checkflag >=", value, "checkflag");
            return (Criteria) this;
        }

        public Criteria andCheckflagLessThan(String value) {
            addCriterion("checkflag <", value, "checkflag");
            return (Criteria) this;
        }

        public Criteria andCheckflagLessThanOrEqualTo(String value) {
            addCriterion("checkflag <=", value, "checkflag");
            return (Criteria) this;
        }

        public Criteria andCheckflagLike(String value) {
            addCriterion("checkflag like", value, "checkflag");
            return (Criteria) this;
        }

        public Criteria andCheckflagNotLike(String value) {
            addCriterion("checkflag not like", value, "checkflag");
            return (Criteria) this;
        }

        public Criteria andCheckflagIn(List<String> values) {
            addCriterion("checkflag in", values, "checkflag");
            return (Criteria) this;
        }

        public Criteria andCheckflagNotIn(List<String> values) {
            addCriterion("checkflag not in", values, "checkflag");
            return (Criteria) this;
        }

        public Criteria andCheckflagBetween(String value1, String value2) {
            addCriterion("checkflag between", value1, value2, "checkflag");
            return (Criteria) this;
        }

        public Criteria andCheckflagNotBetween(String value1, String value2) {
            addCriterion("checkflag not between", value1, value2, "checkflag");
            return (Criteria) this;
        }

        public Criteria andCheckdespIsNull() {
            addCriterion("checkdesp is null");
            return (Criteria) this;
        }

        public Criteria andCheckdespIsNotNull() {
            addCriterion("checkdesp is not null");
            return (Criteria) this;
        }

        public Criteria andCheckdespEqualTo(String value) {
            addCriterion("checkdesp =", value, "checkdesp");
            return (Criteria) this;
        }

        public Criteria andCheckdespNotEqualTo(String value) {
            addCriterion("checkdesp <>", value, "checkdesp");
            return (Criteria) this;
        }

        public Criteria andCheckdespGreaterThan(String value) {
            addCriterion("checkdesp >", value, "checkdesp");
            return (Criteria) this;
        }

        public Criteria andCheckdespGreaterThanOrEqualTo(String value) {
            addCriterion("checkdesp >=", value, "checkdesp");
            return (Criteria) this;
        }

        public Criteria andCheckdespLessThan(String value) {
            addCriterion("checkdesp <", value, "checkdesp");
            return (Criteria) this;
        }

        public Criteria andCheckdespLessThanOrEqualTo(String value) {
            addCriterion("checkdesp <=", value, "checkdesp");
            return (Criteria) this;
        }

        public Criteria andCheckdespLike(String value) {
            addCriterion("checkdesp like", value, "checkdesp");
            return (Criteria) this;
        }

        public Criteria andCheckdespNotLike(String value) {
            addCriterion("checkdesp not like", value, "checkdesp");
            return (Criteria) this;
        }

        public Criteria andCheckdespIn(List<String> values) {
            addCriterion("checkdesp in", values, "checkdesp");
            return (Criteria) this;
        }

        public Criteria andCheckdespNotIn(List<String> values) {
            addCriterion("checkdesp not in", values, "checkdesp");
            return (Criteria) this;
        }

        public Criteria andCheckdespBetween(String value1, String value2) {
            addCriterion("checkdesp between", value1, value2, "checkdesp");
            return (Criteria) this;
        }

        public Criteria andCheckdespNotBetween(String value1, String value2) {
            addCriterion("checkdesp not between", value1, value2, "checkdesp");
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

        public Criteria andCreatedateEqualTo(String value) {
            addCriterion("createDate =", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotEqualTo(String value) {
            addCriterion("createDate <>", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateGreaterThan(String value) {
            addCriterion("createDate >", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateGreaterThanOrEqualTo(String value) {
            addCriterion("createDate >=", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateLessThan(String value) {
            addCriterion("createDate <", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateLessThanOrEqualTo(String value) {
            addCriterion("createDate <=", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateLike(String value) {
            addCriterion("createDate like", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotLike(String value) {
            addCriterion("createDate not like", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateIn(List<String> values) {
            addCriterion("createDate in", values, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotIn(List<String> values) {
            addCriterion("createDate not in", values, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateBetween(String value1, String value2) {
            addCriterion("createDate between", value1, value2, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotBetween(String value1, String value2) {
            addCriterion("createDate not between", value1, value2, "createdate");
            return (Criteria) this;
        }

        public Criteria andFundflowIsNull() {
            addCriterion("fundFlow is null");
            return (Criteria) this;
        }

        public Criteria andFundflowIsNotNull() {
            addCriterion("fundFlow is not null");
            return (Criteria) this;
        }

        public Criteria andFundflowEqualTo(String value) {
            addCriterion("fundFlow =", value, "fundflow");
            return (Criteria) this;
        }

        public Criteria andFundflowNotEqualTo(String value) {
            addCriterion("fundFlow <>", value, "fundflow");
            return (Criteria) this;
        }

        public Criteria andFundflowGreaterThan(String value) {
            addCriterion("fundFlow >", value, "fundflow");
            return (Criteria) this;
        }

        public Criteria andFundflowGreaterThanOrEqualTo(String value) {
            addCriterion("fundFlow >=", value, "fundflow");
            return (Criteria) this;
        }

        public Criteria andFundflowLessThan(String value) {
            addCriterion("fundFlow <", value, "fundflow");
            return (Criteria) this;
        }

        public Criteria andFundflowLessThanOrEqualTo(String value) {
            addCriterion("fundFlow <=", value, "fundflow");
            return (Criteria) this;
        }

        public Criteria andFundflowLike(String value) {
            addCriterion("fundFlow like", value, "fundflow");
            return (Criteria) this;
        }

        public Criteria andFundflowNotLike(String value) {
            addCriterion("fundFlow not like", value, "fundflow");
            return (Criteria) this;
        }

        public Criteria andFundflowIn(List<String> values) {
            addCriterion("fundFlow in", values, "fundflow");
            return (Criteria) this;
        }

        public Criteria andFundflowNotIn(List<String> values) {
            addCriterion("fundFlow not in", values, "fundflow");
            return (Criteria) this;
        }

        public Criteria andFundflowBetween(String value1, String value2) {
            addCriterion("fundFlow between", value1, value2, "fundflow");
            return (Criteria) this;
        }

        public Criteria andFundflowNotBetween(String value1, String value2) {
            addCriterion("fundFlow not between", value1, value2, "fundflow");
            return (Criteria) this;
        }

        public Criteria andInvestidIsNull() {
            addCriterion("investId is null");
            return (Criteria) this;
        }

        public Criteria andInvestidIsNotNull() {
            addCriterion("investId is not null");
            return (Criteria) this;
        }

        public Criteria andInvestidEqualTo(String value) {
            addCriterion("investId =", value, "investid");
            return (Criteria) this;
        }

        public Criteria andInvestidNotEqualTo(String value) {
            addCriterion("investId <>", value, "investid");
            return (Criteria) this;
        }

        public Criteria andInvestidGreaterThan(String value) {
            addCriterion("investId >", value, "investid");
            return (Criteria) this;
        }

        public Criteria andInvestidGreaterThanOrEqualTo(String value) {
            addCriterion("investId >=", value, "investid");
            return (Criteria) this;
        }

        public Criteria andInvestidLessThan(String value) {
            addCriterion("investId <", value, "investid");
            return (Criteria) this;
        }

        public Criteria andInvestidLessThanOrEqualTo(String value) {
            addCriterion("investId <=", value, "investid");
            return (Criteria) this;
        }

        public Criteria andInvestidLike(String value) {
            addCriterion("investId like", value, "investid");
            return (Criteria) this;
        }

        public Criteria andInvestidNotLike(String value) {
            addCriterion("investId not like", value, "investid");
            return (Criteria) this;
        }

        public Criteria andInvestidIn(List<String> values) {
            addCriterion("investId in", values, "investid");
            return (Criteria) this;
        }

        public Criteria andInvestidNotIn(List<String> values) {
            addCriterion("investId not in", values, "investid");
            return (Criteria) this;
        }

        public Criteria andInvestidBetween(String value1, String value2) {
            addCriterion("investId between", value1, value2, "investid");
            return (Criteria) this;
        }

        public Criteria andInvestidNotBetween(String value1, String value2) {
            addCriterion("investId not between", value1, value2, "investid");
            return (Criteria) this;
        }

        public Criteria andDescribesIsNull() {
            addCriterion("describes is null");
            return (Criteria) this;
        }

        public Criteria andDescribesIsNotNull() {
            addCriterion("describes is not null");
            return (Criteria) this;
        }

        public Criteria andDescribesEqualTo(String value) {
            addCriterion("describes =", value, "describes");
            return (Criteria) this;
        }

        public Criteria andDescribesNotEqualTo(String value) {
            addCriterion("describes <>", value, "describes");
            return (Criteria) this;
        }

        public Criteria andDescribesGreaterThan(String value) {
            addCriterion("describes >", value, "describes");
            return (Criteria) this;
        }

        public Criteria andDescribesGreaterThanOrEqualTo(String value) {
            addCriterion("describes >=", value, "describes");
            return (Criteria) this;
        }

        public Criteria andDescribesLessThan(String value) {
            addCriterion("describes <", value, "describes");
            return (Criteria) this;
        }

        public Criteria andDescribesLessThanOrEqualTo(String value) {
            addCriterion("describes <=", value, "describes");
            return (Criteria) this;
        }

        public Criteria andDescribesLike(String value) {
            addCriterion("describes like", value, "describes");
            return (Criteria) this;
        }

        public Criteria andDescribesNotLike(String value) {
            addCriterion("describes not like", value, "describes");
            return (Criteria) this;
        }

        public Criteria andDescribesIn(List<String> values) {
            addCriterion("describes in", values, "describes");
            return (Criteria) this;
        }

        public Criteria andDescribesNotIn(List<String> values) {
            addCriterion("describes not in", values, "describes");
            return (Criteria) this;
        }

        public Criteria andDescribesBetween(String value1, String value2) {
            addCriterion("describes between", value1, value2, "describes");
            return (Criteria) this;
        }

        public Criteria andDescribesNotBetween(String value1, String value2) {
            addCriterion("describes not between", value1, value2, "describes");
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
     * This class:org.mybatis.generator.config.Context@19057e1c
     *  translog
     *
     * @ET do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class:org.mybatis.generator.config.Context@19057e1c
     *  translog
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