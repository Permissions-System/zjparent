package com.zjgt.p2p.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class AgentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AgentExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

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

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andMemberidIsNull() {
            addCriterion("memberid is null");
            return (Criteria) this;
        }

        public Criteria andMemberidIsNotNull() {
            addCriterion("memberid is not null");
            return (Criteria) this;
        }

        public Criteria andMemberidEqualTo(Long value) {
            addCriterion("memberid =", value, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidNotEqualTo(Long value) {
            addCriterion("memberid <>", value, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidGreaterThan(Long value) {
            addCriterion("memberid >", value, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidGreaterThanOrEqualTo(Long value) {
            addCriterion("memberid >=", value, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidLessThan(Long value) {
            addCriterion("memberid <", value, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidLessThanOrEqualTo(Long value) {
            addCriterion("memberid <=", value, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidIn(List<Long> values) {
            addCriterion("memberid in", values, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidNotIn(List<Long> values) {
            addCriterion("memberid not in", values, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidBetween(Long value1, Long value2) {
            addCriterion("memberid between", value1, value2, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidNotBetween(Long value1, Long value2) {
            addCriterion("memberid not between", value1, value2, "memberid");
            return (Criteria) this;
        }

        public Criteria andLevelIsNull() {
            addCriterion("level is null");
            return (Criteria) this;
        }

        public Criteria andLevelIsNotNull() {
            addCriterion("level is not null");
            return (Criteria) this;
        }

        public Criteria andLevelEqualTo(Integer value) {
            addCriterion("level =", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotEqualTo(Integer value) {
            addCriterion("level <>", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThan(Integer value) {
            addCriterion("level >", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("level >=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThan(Integer value) {
            addCriterion("level <", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThanOrEqualTo(Integer value) {
            addCriterion("level <=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelIn(List<Integer> values) {
            addCriterion("level in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotIn(List<Integer> values) {
            addCriterion("level not in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelBetween(Integer value1, Integer value2) {
            addCriterion("level between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("level not between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andIscompanyIsNull() {
            addCriterion("iscompany is null");
            return (Criteria) this;
        }

        public Criteria andIscompanyIsNotNull() {
            addCriterion("iscompany is not null");
            return (Criteria) this;
        }

        public Criteria andIscompanyEqualTo(Integer value) {
            addCriterion("iscompany =", value, "iscompany");
            return (Criteria) this;
        }

        public Criteria andIscompanyNotEqualTo(Integer value) {
            addCriterion("iscompany <>", value, "iscompany");
            return (Criteria) this;
        }

        public Criteria andIscompanyGreaterThan(Integer value) {
            addCriterion("iscompany >", value, "iscompany");
            return (Criteria) this;
        }

        public Criteria andIscompanyGreaterThanOrEqualTo(Integer value) {
            addCriterion("iscompany >=", value, "iscompany");
            return (Criteria) this;
        }

        public Criteria andIscompanyLessThan(Integer value) {
            addCriterion("iscompany <", value, "iscompany");
            return (Criteria) this;
        }

        public Criteria andIscompanyLessThanOrEqualTo(Integer value) {
            addCriterion("iscompany <=", value, "iscompany");
            return (Criteria) this;
        }

        public Criteria andIscompanyIn(List<Integer> values) {
            addCriterion("iscompany in", values, "iscompany");
            return (Criteria) this;
        }

        public Criteria andIscompanyNotIn(List<Integer> values) {
            addCriterion("iscompany not in", values, "iscompany");
            return (Criteria) this;
        }

        public Criteria andIscompanyBetween(Integer value1, Integer value2) {
            addCriterion("iscompany between", value1, value2, "iscompany");
            return (Criteria) this;
        }

        public Criteria andIscompanyNotBetween(Integer value1, Integer value2) {
            addCriterion("iscompany not between", value1, value2, "iscompany");
            return (Criteria) this;
        }

        public Criteria andIsMerchantIsNull() {
            addCriterion("isMerchant is null");
            return (Criteria) this;
        }

        public Criteria andIsMerchantIsNotNull() {
            addCriterion("isMerchant is not null");
            return (Criteria) this;
        }

        public Criteria andIsMerchantEqualTo(Integer value) {
            addCriterion("isMerchant =", value, "isMerchant");
            return (Criteria) this;
        }

        public Criteria andIsMerchantNotEqualTo(Integer value) {
            addCriterion("isMerchant <>", value, "isisMerchantmerchant");
            return (Criteria) this;
        }

        public Criteria andIsMerchantGreaterThan(Integer value) {
            addCriterion("isMerchant >", value, "isMerchant");
            return (Criteria) this;
        }

        public Criteria andIsMerchantGreaterThanOrEqualTo(Integer value) {
            addCriterion("isMerchant >=", value, "isMerchant");
            return (Criteria) this;
        }

        public Criteria andIsMerchantLessThan(Integer value) {
            addCriterion("isMerchant <", value, "isMerchant");
            return (Criteria) this;
        }

        public Criteria andIsMerchantLessThanOrEqualTo(Integer value) {
            addCriterion("isMerchant <=", value, "isMerchant");
            return (Criteria) this;
        }

        public Criteria andIsMerchantIn(List<Integer> values) {
            addCriterion("isMerchant in", values, "isMerchant");
            return (Criteria) this;
        }

        public Criteria andIsMerchantNotIn(List<Integer> values) {
            addCriterion("isMerchant not in", values, "isMerchant");
            return (Criteria) this;
        }

        public Criteria andIsMerchantBetween(Integer value1, Integer value2) {
            addCriterion("isMerchant between", value1, value2, "isMerchant");
            return (Criteria) this;
        }

        public Criteria andIsMerchantNotBetween(Integer value1, Integer value2) {
            addCriterion("isMerchant not between", value1, value2, "isMerchant");
            return (Criteria) this;
        }

        public Criteria andCommissionrateIsNull() {
            addCriterion("commissionrate is null");
            return (Criteria) this;
        }

        public Criteria andCommissionrateIsNotNull() {
            addCriterion("commissionrate is not null");
            return (Criteria) this;
        }

        public Criteria andCommissionrateEqualTo(BigDecimal value) {
            addCriterion("commissionrate =", value, "commissionrate");
            return (Criteria) this;
        }

        public Criteria andCommissionrateNotEqualTo(BigDecimal value) {
            addCriterion("commissionrate <>", value, "commissionrate");
            return (Criteria) this;
        }

        public Criteria andCommissionrateGreaterThan(BigDecimal value) {
            addCriterion("commissionrate >", value, "commissionrate");
            return (Criteria) this;
        }

        public Criteria andCommissionrateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("commissionrate >=", value, "commissionrate");
            return (Criteria) this;
        }

        public Criteria andCommissionrateLessThan(BigDecimal value) {
            addCriterion("commissionrate <", value, "commissionrate");
            return (Criteria) this;
        }

        public Criteria andCommissionrateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("commissionrate <=", value, "commissionrate");
            return (Criteria) this;
        }

        public Criteria andCommissionrateIn(List<BigDecimal> values) {
            addCriterion("commissionrate in", values, "commissionrate");
            return (Criteria) this;
        }

        public Criteria andCommissionrateNotIn(List<BigDecimal> values) {
            addCriterion("commissionrate not in", values, "commissionrate");
            return (Criteria) this;
        }

        public Criteria andCommissionrateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("commissionrate between", value1, value2, "commissionrate");
            return (Criteria) this;
        }

        public Criteria andCommissionrateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("commissionrate not between", value1, value2, "commissionrate");
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
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

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