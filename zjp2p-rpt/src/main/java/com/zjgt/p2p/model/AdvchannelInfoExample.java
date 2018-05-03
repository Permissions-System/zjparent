package com.zjgt.p2p.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdvchannelInfoExample {
    /**
     * orderByClausenull .
     *   advchannelinfo
     *
     * @ET
     */
    protected String orderByClause;

    /**
     * distinctnull .
     *   advchannelinfo
     *
     * @ET
     */
    protected boolean distinct;

    /**
     * oredCriterianull .
     *   advchannelinfo
     *
     * @ET
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method:AdvchannelInfoExample
     *   advchannelinfo
     *
     * @ET
     */
    public AdvchannelInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method:setOrderByClause
     *   advchannelinfo
     *
     * @ET
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method:getOrderByClause
     *   advchannelinfo
     *
     * @ET
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method:setDistinct
     *   advchannelinfo
     *
     * @ET
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method:isDistinct
     *   advchannelinfo
     *
     * @ET
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method:getOredCriteria
     *   advchannelinfo
     *
     * @ET
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method:or
     *   advchannelinfo
     *
     * @ET
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method:or
     *   advchannelinfo
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
     *   advchannelinfo
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
     *   advchannelinfo
     *
     * @ET
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method:clear
     *   advchannelinfo
     *
     * @ET
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class:org.mybatis.generator.config.Context@8d171b2
     *  advchannelinfo
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

        public Criteria andChannelnameIsNull() {
            addCriterion("channelname is null");
            return (Criteria) this;
        }

        public Criteria andChannelnameIsNotNull() {
            addCriterion("channelname is not null");
            return (Criteria) this;
        }

        public Criteria andChannelnameEqualTo(String value) {
            addCriterion("channelname =", value, "channelname");
            return (Criteria) this;
        }

        public Criteria andChannelnameNotEqualTo(String value) {
            addCriterion("channelname <>", value, "channelname");
            return (Criteria) this;
        }

        public Criteria andChannelnameGreaterThan(String value) {
            addCriterion("channelname >", value, "channelname");
            return (Criteria) this;
        }

        public Criteria andChannelnameGreaterThanOrEqualTo(String value) {
            addCriterion("channelname >=", value, "channelname");
            return (Criteria) this;
        }

        public Criteria andChannelnameLessThan(String value) {
            addCriterion("channelname <", value, "channelname");
            return (Criteria) this;
        }

        public Criteria andChannelnameLessThanOrEqualTo(String value) {
            addCriterion("channelname <=", value, "channelname");
            return (Criteria) this;
        }

        public Criteria andChannelnameLike(String value) {
            addCriterion("channelname like", value, "channelname");
            return (Criteria) this;
        }

        public Criteria andChannelnameNotLike(String value) {
            addCriterion("channelname not like", value, "channelname");
            return (Criteria) this;
        }

        public Criteria andChannelnameIn(List<String> values) {
            addCriterion("channelname in", values, "channelname");
            return (Criteria) this;
        }

        public Criteria andChannelnameNotIn(List<String> values) {
            addCriterion("channelname not in", values, "channelname");
            return (Criteria) this;
        }

        public Criteria andChannelnameBetween(String value1, String value2) {
            addCriterion("channelname between", value1, value2, "channelname");
            return (Criteria) this;
        }

        public Criteria andChannelnameNotBetween(String value1, String value2) {
            addCriterion("channelname not between", value1, value2, "channelname");
            return (Criteria) this;
        }

        public Criteria andChannelcodeIsNull() {
            addCriterion("channelcode is null");
            return (Criteria) this;
        }

        public Criteria andChannelcodeIsNotNull() {
            addCriterion("channelcode is not null");
            return (Criteria) this;
        }

        public Criteria andChannelcodeEqualTo(String value) {
            addCriterion("channelcode =", value, "channelcode");
            return (Criteria) this;
        }

        public Criteria andChannelcodeNotEqualTo(String value) {
            addCriterion("channelcode <>", value, "channelcode");
            return (Criteria) this;
        }

        public Criteria andChannelcodeGreaterThan(String value) {
            addCriterion("channelcode >", value, "channelcode");
            return (Criteria) this;
        }

        public Criteria andChannelcodeGreaterThanOrEqualTo(String value) {
            addCriterion("channelcode >=", value, "channelcode");
            return (Criteria) this;
        }

        public Criteria andChannelcodeLessThan(String value) {
            addCriterion("channelcode <", value, "channelcode");
            return (Criteria) this;
        }

        public Criteria andChannelcodeLessThanOrEqualTo(String value) {
            addCriterion("channelcode <=", value, "channelcode");
            return (Criteria) this;
        }

        public Criteria andChannelcodeLike(String value) {
            addCriterion("channelcode like", value, "channelcode");
            return (Criteria) this;
        }

        public Criteria andChannelcodeNotLike(String value) {
            addCriterion("channelcode not like", value, "channelcode");
            return (Criteria) this;
        }

        public Criteria andChannelcodeIn(List<String> values) {
            addCriterion("channelcode in", values, "channelcode");
            return (Criteria) this;
        }

        public Criteria andChannelcodeNotIn(List<String> values) {
            addCriterion("channelcode not in", values, "channelcode");
            return (Criteria) this;
        }

        public Criteria andChannelcodeBetween(String value1, String value2) {
            addCriterion("channelcode between", value1, value2, "channelcode");
            return (Criteria) this;
        }

        public Criteria andChannelcodeNotBetween(String value1, String value2) {
            addCriterion("channelcode not between", value1, value2, "channelcode");
            return (Criteria) this;
        }

        public Criteria andFeetypeIsNull() {
            addCriterion("feetype is null");
            return (Criteria) this;
        }

        public Criteria andFeetypeIsNotNull() {
            addCriterion("feetype is not null");
            return (Criteria) this;
        }

        public Criteria andFeetypeEqualTo(Integer value) {
            addCriterion("feetype =", value, "feetype");
            return (Criteria) this;
        }

        public Criteria andFeetypeNotEqualTo(Integer value) {
            addCriterion("feetype <>", value, "feetype");
            return (Criteria) this;
        }

        public Criteria andFeetypeGreaterThan(Integer value) {
            addCriterion("feetype >", value, "feetype");
            return (Criteria) this;
        }

        public Criteria andFeetypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("feetype >=", value, "feetype");
            return (Criteria) this;
        }

        public Criteria andFeetypeLessThan(Integer value) {
            addCriterion("feetype <", value, "feetype");
            return (Criteria) this;
        }

        public Criteria andFeetypeLessThanOrEqualTo(Integer value) {
            addCriterion("feetype <=", value, "feetype");
            return (Criteria) this;
        }

        public Criteria andFeetypeIn(List<Integer> values) {
            addCriterion("feetype in", values, "feetype");
            return (Criteria) this;
        }

        public Criteria andFeetypeNotIn(List<Integer> values) {
            addCriterion("feetype not in", values, "feetype");
            return (Criteria) this;
        }

        public Criteria andFeetypeBetween(Integer value1, Integer value2) {
            addCriterion("feetype between", value1, value2, "feetype");
            return (Criteria) this;
        }

        public Criteria andFeetypeNotBetween(Integer value1, Integer value2) {
            addCriterion("feetype not between", value1, value2, "feetype");
            return (Criteria) this;
        }

        public Criteria andProfittypeIsNull() {
            addCriterion("profittype is null");
            return (Criteria) this;
        }

        public Criteria andProfittypeIsNotNull() {
            addCriterion("profittype is not null");
            return (Criteria) this;
        }

        public Criteria andProfittypeEqualTo(Integer value) {
            addCriterion("profittype =", value, "profittype");
            return (Criteria) this;
        }

        public Criteria andProfittypeNotEqualTo(Integer value) {
            addCriterion("profittype <>", value, "profittype");
            return (Criteria) this;
        }

        public Criteria andProfittypeGreaterThan(Integer value) {
            addCriterion("profittype >", value, "profittype");
            return (Criteria) this;
        }

        public Criteria andProfittypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("profittype >=", value, "profittype");
            return (Criteria) this;
        }

        public Criteria andProfittypeLessThan(Integer value) {
            addCriterion("profittype <", value, "profittype");
            return (Criteria) this;
        }

        public Criteria andProfittypeLessThanOrEqualTo(Integer value) {
            addCriterion("profittype <=", value, "profittype");
            return (Criteria) this;
        }

        public Criteria andProfittypeIn(List<Integer> values) {
            addCriterion("profittype in", values, "profittype");
            return (Criteria) this;
        }

        public Criteria andProfittypeNotIn(List<Integer> values) {
            addCriterion("profittype not in", values, "profittype");
            return (Criteria) this;
        }

        public Criteria andProfittypeBetween(Integer value1, Integer value2) {
            addCriterion("profittype between", value1, value2, "profittype");
            return (Criteria) this;
        }

        public Criteria andProfittypeNotBetween(Integer value1, Integer value2) {
            addCriterion("profittype not between", value1, value2, "profittype");
            return (Criteria) this;
        }

        public Criteria andCooperiodIsNull() {
            addCriterion("cooperiod is null");
            return (Criteria) this;
        }

        public Criteria andCooperiodIsNotNull() {
            addCriterion("cooperiod is not null");
            return (Criteria) this;
        }

        public Criteria andCooperiodEqualTo(Date value) {
            addCriterion("cooperiod =", value, "cooperiod");
            return (Criteria) this;
        }

        public Criteria andCooperiodNotEqualTo(Date value) {
            addCriterion("cooperiod <>", value, "cooperiod");
            return (Criteria) this;
        }

        public Criteria andCooperiodGreaterThan(Date value) {
            addCriterion("cooperiod >", value, "cooperiod");
            return (Criteria) this;
        }

        public Criteria andCooperiodGreaterThanOrEqualTo(Date value) {
            addCriterion("cooperiod >=", value, "cooperiod");
            return (Criteria) this;
        }

        public Criteria andCooperiodLessThan(Date value) {
            addCriterion("cooperiod <", value, "cooperiod");
            return (Criteria) this;
        }

        public Criteria andCooperiodLessThanOrEqualTo(Date value) {
            addCriterion("cooperiod <=", value, "cooperiod");
            return (Criteria) this;
        }

        public Criteria andCooperiodIn(List<Date> values) {
            addCriterion("cooperiod in", values, "cooperiod");
            return (Criteria) this;
        }

        public Criteria andCooperiodNotIn(List<Date> values) {
            addCriterion("cooperiod not in", values, "cooperiod");
            return (Criteria) this;
        }

        public Criteria andCooperiodBetween(Date value1, Date value2) {
            addCriterion("cooperiod between", value1, value2, "cooperiod");
            return (Criteria) this;
        }

        public Criteria andCooperiodNotBetween(Date value1, Date value2) {
            addCriterion("cooperiod not between", value1, value2, "cooperiod");
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

    /**
     * This class:org.mybatis.generator.config.Context@8d171b2
     *  advchannelinfo
     *
     * @ET do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class:org.mybatis.generator.config.Context@8d171b2
     *  advchannelinfo
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