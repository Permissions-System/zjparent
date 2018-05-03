package com.zjgt.p2p.report.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class CpsStatExample {
    /**
     * orderByClausenull .
     *   cpsstat
     *
     * @ET
     */
    protected String orderByClause;

    /**
     * distinctnull .
     *   cpsstat
     *
     * @ET
     */
    protected boolean distinct;
    

    /**
   	 * limit起始
   	 */
   	protected Integer startPos;

   	/**
   	 * limit限制条数
   	 */
   	protected Integer pageSize;

    /**
     * oredCriterianull .
     *   cpsstat
     *
     * @ET
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method:CpsStatExample
     *   cpsstat
     *
     * @ET
     */
    public CpsStatExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method:setOrderByClause
     *   cpsstat
     *
     * @ET
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method:getOrderByClause
     *   cpsstat
     *
     * @ET
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method:setDistinct
     *   cpsstat
     *
     * @ET
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method:isDistinct
     *   cpsstat
     *
     * @ET
     */
    public boolean isDistinct() {
        return distinct;
    }
    

    public Integer getStartPos() {
  		return startPos;
  	}

  	public void setStartPos(Integer startPos) {
  		this.startPos = startPos;
  	}

  	public Integer getPageSize() {
  		return pageSize;
  	}

  	public void setPageSize(Integer pageSize) {
  		this.pageSize = pageSize;
  	}


    /**
     * This method:getOredCriteria
     *   cpsstat
     *
     * @ET
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method:or
     *   cpsstat
     *
     * @ET
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method:or
     *   cpsstat
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
     *   cpsstat
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
     *   cpsstat
     *
     * @ET
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method:clear
     *   cpsstat
     *
     * @ET
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class:org.mybatis.generator.config.Context@22d282a3
     *  cpsstat
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

        public Criteria andCurdateIsNull() {
            addCriterion("curDate is null");
            return (Criteria) this;
        }

        public Criteria andCurdateIsNotNull() {
            addCriterion("curDate is not null");
            return (Criteria) this;
        }

        public Criteria andCurdateEqualTo(Date value) {
            addCriterionForJDBCDate("curDate =", value, "curdate");
            return (Criteria) this;
        }

        public Criteria andCurdateNotEqualTo(Date value) {
            addCriterionForJDBCDate("curDate <>", value, "curdate");
            return (Criteria) this;
        }

        public Criteria andCurdateGreaterThan(Date value) {
            addCriterionForJDBCDate("curDate >", value, "curdate");
            return (Criteria) this;
        }

        public Criteria andCurdateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("curDate >=", value, "curdate");
            return (Criteria) this;
        }

        public Criteria andCurdateLessThan(Date value) {
            addCriterionForJDBCDate("curDate <", value, "curdate");
            return (Criteria) this;
        }

        public Criteria andCurdateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("curDate <=", value, "curdate");
            return (Criteria) this;
        }

        public Criteria andCurdateIn(List<Date> values) {
            addCriterionForJDBCDate("curDate in", values, "curdate");
            return (Criteria) this;
        }

        public Criteria andCurdateNotIn(List<Date> values) {
            addCriterionForJDBCDate("curDate not in", values, "curdate");
            return (Criteria) this;
        }

        public Criteria andCurdateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("curDate between", value1, value2, "curdate");
            return (Criteria) this;
        }

        public Criteria andCurdateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("curDate not between", value1, value2, "curdate");
            return (Criteria) this;
        }

        public Criteria andCpscodeIsNull() {
            addCriterion("cpscode is null");
            return (Criteria) this;
        }

        public Criteria andCpscodeIsNotNull() {
            addCriterion("cpscode is not null");
            return (Criteria) this;
        }

        public Criteria andCpscodeEqualTo(String value) {
            addCriterion("cpscode =", value, "cpscode");
            return (Criteria) this;
        }

        public Criteria andCpscodeNotEqualTo(String value) {
            addCriterion("cpscode <>", value, "cpscode");
            return (Criteria) this;
        }

        public Criteria andCpscodeGreaterThan(String value) {
            addCriterion("cpscode >", value, "cpscode");
            return (Criteria) this;
        }

        public Criteria andCpscodeGreaterThanOrEqualTo(String value) {
            addCriterion("cpscode >=", value, "cpscode");
            return (Criteria) this;
        }

        public Criteria andCpscodeLessThan(String value) {
            addCriterion("cpscode <", value, "cpscode");
            return (Criteria) this;
        }

        public Criteria andCpscodeLessThanOrEqualTo(String value) {
            addCriterion("cpscode <=", value, "cpscode");
            return (Criteria) this;
        }

        public Criteria andCpscodeLike(String value) {
            addCriterion("cpscode like", value, "cpscode");
            return (Criteria) this;
        }

        public Criteria andCpscodeNotLike(String value) {
            addCriterion("cpscode not like", value, "cpscode");
            return (Criteria) this;
        }

        public Criteria andCpscodeIn(List<String> values) {
            addCriterion("cpscode in", values, "cpscode");
            return (Criteria) this;
        }

        public Criteria andCpscodeNotIn(List<String> values) {
            addCriterion("cpscode not in", values, "cpscode");
            return (Criteria) this;
        }

        public Criteria andCpscodeBetween(String value1, String value2) {
            addCriterion("cpscode between", value1, value2, "cpscode");
            return (Criteria) this;
        }

        public Criteria andCpscodeNotBetween(String value1, String value2) {
            addCriterion("cpscode not between", value1, value2, "cpscode");
            return (Criteria) this;
        }

        public Criteria andCpsnameIsNull() {
            addCriterion("cpsname is null");
            return (Criteria) this;
        }

        public Criteria andCpsnameIsNotNull() {
            addCriterion("cpsname is not null");
            return (Criteria) this;
        }

        public Criteria andCpsnameEqualTo(String value) {
            addCriterion("cpsname =", value, "cpsname");
            return (Criteria) this;
        }

        public Criteria andCpsnameNotEqualTo(String value) {
            addCriterion("cpsname <>", value, "cpsname");
            return (Criteria) this;
        }

        public Criteria andCpsnameGreaterThan(String value) {
            addCriterion("cpsname >", value, "cpsname");
            return (Criteria) this;
        }

        public Criteria andCpsnameGreaterThanOrEqualTo(String value) {
            addCriterion("cpsname >=", value, "cpsname");
            return (Criteria) this;
        }

        public Criteria andCpsnameLessThan(String value) {
            addCriterion("cpsname <", value, "cpsname");
            return (Criteria) this;
        }

        public Criteria andCpsnameLessThanOrEqualTo(String value) {
            addCriterion("cpsname <=", value, "cpsname");
            return (Criteria) this;
        }

        public Criteria andCpsnameLike(String value) {
            addCriterion("cpsname like", value, "cpsname");
            return (Criteria) this;
        }

        public Criteria andCpsnameNotLike(String value) {
            addCriterion("cpsname not like", value, "cpsname");
            return (Criteria) this;
        }

        public Criteria andCpsnameIn(List<String> values) {
            addCriterion("cpsname in", values, "cpsname");
            return (Criteria) this;
        }

        public Criteria andCpsnameNotIn(List<String> values) {
            addCriterion("cpsname not in", values, "cpsname");
            return (Criteria) this;
        }

        public Criteria andCpsnameBetween(String value1, String value2) {
            addCriterion("cpsname between", value1, value2, "cpsname");
            return (Criteria) this;
        }

        public Criteria andCpsnameNotBetween(String value1, String value2) {
            addCriterion("cpsname not between", value1, value2, "cpsname");
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

        public Criteria andOpenaccntIsNull() {
            addCriterion("openaccnt is null");
            return (Criteria) this;
        }

        public Criteria andOpenaccntIsNotNull() {
            addCriterion("openaccnt is not null");
            return (Criteria) this;
        }

        public Criteria andOpenaccntEqualTo(Integer value) {
            addCriterion("openaccnt =", value, "openaccnt");
            return (Criteria) this;
        }

        public Criteria andOpenaccntNotEqualTo(Integer value) {
            addCriterion("openaccnt <>", value, "openaccnt");
            return (Criteria) this;
        }

        public Criteria andOpenaccntGreaterThan(Integer value) {
            addCriterion("openaccnt >", value, "openaccnt");
            return (Criteria) this;
        }

        public Criteria andOpenaccntGreaterThanOrEqualTo(Integer value) {
            addCriterion("openaccnt >=", value, "openaccnt");
            return (Criteria) this;
        }

        public Criteria andOpenaccntLessThan(Integer value) {
            addCriterion("openaccnt <", value, "openaccnt");
            return (Criteria) this;
        }

        public Criteria andOpenaccntLessThanOrEqualTo(Integer value) {
            addCriterion("openaccnt <=", value, "openaccnt");
            return (Criteria) this;
        }

        public Criteria andOpenaccntIn(List<Integer> values) {
            addCriterion("openaccnt in", values, "openaccnt");
            return (Criteria) this;
        }

        public Criteria andOpenaccntNotIn(List<Integer> values) {
            addCriterion("openaccnt not in", values, "openaccnt");
            return (Criteria) this;
        }

        public Criteria andOpenaccntBetween(Integer value1, Integer value2) {
            addCriterion("openaccnt between", value1, value2, "openaccnt");
            return (Criteria) this;
        }

        public Criteria andOpenaccntNotBetween(Integer value1, Integer value2) {
            addCriterion("openaccnt not between", value1, value2, "openaccnt");
            return (Criteria) this;
        }

        public Criteria andInvestamountIsNull() {
            addCriterion("investamount is null");
            return (Criteria) this;
        }

        public Criteria andInvestamountIsNotNull() {
            addCriterion("investamount is not null");
            return (Criteria) this;
        }

        public Criteria andInvestamountEqualTo(Double value) {
            addCriterion("investamount =", value, "investamount");
            return (Criteria) this;
        }

        public Criteria andInvestamountNotEqualTo(Double value) {
            addCriterion("investamount <>", value, "investamount");
            return (Criteria) this;
        }

        public Criteria andInvestamountGreaterThan(Double value) {
            addCriterion("investamount >", value, "investamount");
            return (Criteria) this;
        }

        public Criteria andInvestamountGreaterThanOrEqualTo(Double value) {
            addCriterion("investamount >=", value, "investamount");
            return (Criteria) this;
        }

        public Criteria andInvestamountLessThan(Double value) {
            addCriterion("investamount <", value, "investamount");
            return (Criteria) this;
        }

        public Criteria andInvestamountLessThanOrEqualTo(Double value) {
            addCriterion("investamount <=", value, "investamount");
            return (Criteria) this;
        }

        public Criteria andInvestamountIn(List<Double> values) {
            addCriterion("investamount in", values, "investamount");
            return (Criteria) this;
        }

        public Criteria andInvestamountNotIn(List<Double> values) {
            addCriterion("investamount not in", values, "investamount");
            return (Criteria) this;
        }

        public Criteria andInvestamountBetween(Double value1, Double value2) {
            addCriterion("investamount between", value1, value2, "investamount");
            return (Criteria) this;
        }

        public Criteria andInvestamountNotBetween(Double value1, Double value2) {
            addCriterion("investamount not between", value1, value2, "investamount");
            return (Criteria) this;
        }

        public Criteria andInvestcntIsNull() {
            addCriterion("investcnt is null");
            return (Criteria) this;
        }

        public Criteria andInvestcntIsNotNull() {
            addCriterion("investcnt is not null");
            return (Criteria) this;
        }

        public Criteria andInvestcntEqualTo(Integer value) {
            addCriterion("investcnt =", value, "investcnt");
            return (Criteria) this;
        }

        public Criteria andInvestcntNotEqualTo(Integer value) {
            addCriterion("investcnt <>", value, "investcnt");
            return (Criteria) this;
        }

        public Criteria andInvestcntGreaterThan(Integer value) {
            addCriterion("investcnt >", value, "investcnt");
            return (Criteria) this;
        }

        public Criteria andInvestcntGreaterThanOrEqualTo(Integer value) {
            addCriterion("investcnt >=", value, "investcnt");
            return (Criteria) this;
        }

        public Criteria andInvestcntLessThan(Integer value) {
            addCriterion("investcnt <", value, "investcnt");
            return (Criteria) this;
        }

        public Criteria andInvestcntLessThanOrEqualTo(Integer value) {
            addCriterion("investcnt <=", value, "investcnt");
            return (Criteria) this;
        }

        public Criteria andInvestcntIn(List<Integer> values) {
            addCriterion("investcnt in", values, "investcnt");
            return (Criteria) this;
        }

        public Criteria andInvestcntNotIn(List<Integer> values) {
            addCriterion("investcnt not in", values, "investcnt");
            return (Criteria) this;
        }

        public Criteria andInvestcntBetween(Integer value1, Integer value2) {
            addCriterion("investcnt between", value1, value2, "investcnt");
            return (Criteria) this;
        }

        public Criteria andInvestcntNotBetween(Integer value1, Integer value2) {
            addCriterion("investcnt not between", value1, value2, "investcnt");
            return (Criteria) this;
        }

        public Criteria andAvginvestamountIsNull() {
            addCriterion("avginvestamount is null");
            return (Criteria) this;
        }

        public Criteria andAvginvestamountIsNotNull() {
            addCriterion("avginvestamount is not null");
            return (Criteria) this;
        }

        public Criteria andAvginvestamountEqualTo(Double value) {
            addCriterion("avginvestamount =", value, "avginvestamount");
            return (Criteria) this;
        }

        public Criteria andAvginvestamountNotEqualTo(Double value) {
            addCriterion("avginvestamount <>", value, "avginvestamount");
            return (Criteria) this;
        }

        public Criteria andAvginvestamountGreaterThan(Double value) {
            addCriterion("avginvestamount >", value, "avginvestamount");
            return (Criteria) this;
        }

        public Criteria andAvginvestamountGreaterThanOrEqualTo(Double value) {
            addCriterion("avginvestamount >=", value, "avginvestamount");
            return (Criteria) this;
        }

        public Criteria andAvginvestamountLessThan(Double value) {
            addCriterion("avginvestamount <", value, "avginvestamount");
            return (Criteria) this;
        }

        public Criteria andAvginvestamountLessThanOrEqualTo(Double value) {
            addCriterion("avginvestamount <=", value, "avginvestamount");
            return (Criteria) this;
        }

        public Criteria andAvginvestamountIn(List<Double> values) {
            addCriterion("avginvestamount in", values, "avginvestamount");
            return (Criteria) this;
        }

        public Criteria andAvginvestamountNotIn(List<Double> values) {
            addCriterion("avginvestamount not in", values, "avginvestamount");
            return (Criteria) this;
        }

        public Criteria andAvginvestamountBetween(Double value1, Double value2) {
            addCriterion("avginvestamount between", value1, value2, "avginvestamount");
            return (Criteria) this;
        }

        public Criteria andAvginvestamountNotBetween(Double value1, Double value2) {
            addCriterion("avginvestamount not between", value1, value2, "avginvestamount");
            return (Criteria) this;
        }

        public Criteria andInvestrateIsNull() {
            addCriterion("investrate is null");
            return (Criteria) this;
        }

        public Criteria andInvestrateIsNotNull() {
            addCriterion("investrate is not null");
            return (Criteria) this;
        }

        public Criteria andInvestrateEqualTo(BigDecimal value) {
            addCriterion("investrate =", value, "investrate");
            return (Criteria) this;
        }

        public Criteria andInvestrateNotEqualTo(BigDecimal value) {
            addCriterion("investrate <>", value, "investrate");
            return (Criteria) this;
        }

        public Criteria andInvestrateGreaterThan(BigDecimal value) {
            addCriterion("investrate >", value, "investrate");
            return (Criteria) this;
        }

        public Criteria andInvestrateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("investrate >=", value, "investrate");
            return (Criteria) this;
        }

        public Criteria andInvestrateLessThan(BigDecimal value) {
            addCriterion("investrate <", value, "investrate");
            return (Criteria) this;
        }

        public Criteria andInvestrateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("investrate <=", value, "investrate");
            return (Criteria) this;
        }

        public Criteria andInvestrateIn(List<BigDecimal> values) {
            addCriterion("investrate in", values, "investrate");
            return (Criteria) this;
        }

        public Criteria andInvestrateNotIn(List<BigDecimal> values) {
            addCriterion("investrate not in", values, "investrate");
            return (Criteria) this;
        }

        public Criteria andInvestrateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("investrate between", value1, value2, "investrate");
            return (Criteria) this;
        }

        public Criteria andInvestrateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("investrate not between", value1, value2, "investrate");
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
     * This class:org.mybatis.generator.config.Context@22d282a3
     *  cpsstat
     *
     * @ET do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class:org.mybatis.generator.config.Context@22d282a3
     *  cpsstat
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