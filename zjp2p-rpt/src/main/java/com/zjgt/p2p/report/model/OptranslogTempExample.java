package com.zjgt.p2p.report.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class OptranslogTempExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table optranslogtemp
     *
     * @mbggenerated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table optranslogtemp
     *
     * @mbggenerated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table optranslogtemp
     *
     * @mbggenerated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table optranslogtemp
     *
     * @mbggenerated
     */
    public OptranslogTempExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table optranslogtemp
     *
     * @mbggenerated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table optranslogtemp
     *
     * @mbggenerated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table optranslogtemp
     *
     * @mbggenerated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table optranslogtemp
     *
     * @mbggenerated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table optranslogtemp
     *
     * @mbggenerated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table optranslogtemp
     *
     * @mbggenerated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table optranslogtemp
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
     * This method corresponds to the database table optranslogtemp
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
     * This method corresponds to the database table optranslogtemp
     *
     * @mbggenerated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table optranslogtemp
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
     * This class corresponds to the database table optranslogtemp
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
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table optranslogtemp
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
     * This class corresponds to the database table optranslogtemp
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