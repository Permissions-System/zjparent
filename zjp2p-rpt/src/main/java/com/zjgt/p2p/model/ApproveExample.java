package com.zjgt.p2p.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ApproveExample {
    /**
     * orderByClausenull .
     *   approve
     *
     * @ET
     */
    protected String orderByClause;

    /**
     * distinctnull .
     *   approve
     *
     * @ET
     */
    protected boolean distinct;

    /**
     * oredCriterianull .
     *   approve
     *
     * @ET
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method:approveExample
     *   approve
     *
     * @ET
     */
    public ApproveExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method:setOrderByClause
     *   approve
     *
     * @ET
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method:getOrderByClause
     *   approve
     *
     * @ET
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method:setDistinct
     *   approve
     *
     * @ET
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method:isDistinct
     *   approve
     *
     * @ET
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method:getOredCriteria
     *   approve
     *
     * @ET
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method:or
     *   approve
     *
     * @ET
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method:or
     *   approve
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
     *   approve
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
     *   approve
     *
     * @ET
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method:clear
     *   approve
     *
     * @ET
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class:org.mybatis.generator.config.Context@3f669e7f
     *  approve
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
            addCriterion("Id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("Id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("Id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("Id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("Id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("Id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("Id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("Id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("Id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("Id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("Id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("Id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andModulecodeIsNull() {
            addCriterion("modulecode is null");
            return (Criteria) this;
        }

        public Criteria andModulecodeIsNotNull() {
            addCriterion("modulecode is not null");
            return (Criteria) this;
        }

        public Criteria andModulecodeEqualTo(String value) {
            addCriterion("modulecode =", value, "modulecode");
            return (Criteria) this;
        }

        public Criteria andModulecodeNotEqualTo(String value) {
            addCriterion("modulecode <>", value, "modulecode");
            return (Criteria) this;
        }

        public Criteria andModulecodeGreaterThan(String value) {
            addCriterion("modulecode >", value, "modulecode");
            return (Criteria) this;
        }

        public Criteria andModulecodeGreaterThanOrEqualTo(String value) {
            addCriterion("modulecode >=", value, "modulecode");
            return (Criteria) this;
        }

        public Criteria andModulecodeLessThan(String value) {
            addCriterion("modulecode <", value, "modulecode");
            return (Criteria) this;
        }

        public Criteria andModulecodeLessThanOrEqualTo(String value) {
            addCriterion("modulecode <=", value, "modulecode");
            return (Criteria) this;
        }

        public Criteria andModulecodeLike(String value) {
            addCriterion("modulecode like", value, "modulecode");
            return (Criteria) this;
        }

        public Criteria andModulecodeNotLike(String value) {
            addCriterion("modulecode not like", value, "modulecode");
            return (Criteria) this;
        }

        public Criteria andModulecodeIn(List<String> values) {
            addCriterion("modulecode in", values, "modulecode");
            return (Criteria) this;
        }

        public Criteria andModulecodeNotIn(List<String> values) {
            addCriterion("modulecode not in", values, "modulecode");
            return (Criteria) this;
        }

        public Criteria andModulecodeBetween(String value1, String value2) {
            addCriterion("modulecode between", value1, value2, "modulecode");
            return (Criteria) this;
        }

        public Criteria andModulecodeNotBetween(String value1, String value2) {
            addCriterion("modulecode not between", value1, value2, "modulecode");
            return (Criteria) this;
        }

        public Criteria andServicenoIsNull() {
            addCriterion("serviceno is null");
            return (Criteria) this;
        }

        public Criteria andServicenoIsNotNull() {
            addCriterion("serviceno is not null");
            return (Criteria) this;
        }

        public Criteria andServicenoEqualTo(String value) {
            addCriterion("serviceno =", value, "serviceno");
            return (Criteria) this;
        }

        public Criteria andServicenoNotEqualTo(String value) {
            addCriterion("serviceno <>", value, "serviceno");
            return (Criteria) this;
        }

        public Criteria andServicenoGreaterThan(String value) {
            addCriterion("serviceno >", value, "serviceno");
            return (Criteria) this;
        }

        public Criteria andServicenoGreaterThanOrEqualTo(String value) {
            addCriterion("serviceno >=", value, "serviceno");
            return (Criteria) this;
        }

        public Criteria andServicenoLessThan(String value) {
            addCriterion("serviceno <", value, "serviceno");
            return (Criteria) this;
        }

        public Criteria andServicenoLessThanOrEqualTo(String value) {
            addCriterion("serviceno <=", value, "serviceno");
            return (Criteria) this;
        }

        public Criteria andServicenoLike(String value) {
            addCriterion("serviceno like", value, "serviceno");
            return (Criteria) this;
        }

        public Criteria andServicenoNotLike(String value) {
            addCriterion("serviceno not like", value, "serviceno");
            return (Criteria) this;
        }

        public Criteria andServicenoIn(List<String> values) {
            addCriterion("serviceno in", values, "serviceno");
            return (Criteria) this;
        }

        public Criteria andServicenoNotIn(List<String> values) {
            addCriterion("serviceno not in", values, "serviceno");
            return (Criteria) this;
        }

        public Criteria andServicenoBetween(String value1, String value2) {
            addCriterion("serviceno between", value1, value2, "serviceno");
            return (Criteria) this;
        }

        public Criteria andServicenoNotBetween(String value1, String value2) {
            addCriterion("serviceno not between", value1, value2, "serviceno");
            return (Criteria) this;
        }

        public Criteria andTransnameIsNull() {
            addCriterion("transname is null");
            return (Criteria) this;
        }

        public Criteria andTransnameIsNotNull() {
            addCriterion("transname is not null");
            return (Criteria) this;
        }

        public Criteria andTransnameEqualTo(String value) {
            addCriterion("transname =", value, "transname");
            return (Criteria) this;
        }

        public Criteria andTransnameNotEqualTo(String value) {
            addCriterion("transname <>", value, "transname");
            return (Criteria) this;
        }

        public Criteria andTransnameGreaterThan(String value) {
            addCriterion("transname >", value, "transname");
            return (Criteria) this;
        }

        public Criteria andTransnameGreaterThanOrEqualTo(String value) {
            addCriterion("transname >=", value, "transname");
            return (Criteria) this;
        }

        public Criteria andTransnameLessThan(String value) {
            addCriterion("transname <", value, "transname");
            return (Criteria) this;
        }

        public Criteria andTransnameLessThanOrEqualTo(String value) {
            addCriterion("transname <=", value, "transname");
            return (Criteria) this;
        }

        public Criteria andTransnameLike(String value) {
            addCriterion("transname like", value, "transname");
            return (Criteria) this;
        }

        public Criteria andTransnameNotLike(String value) {
            addCriterion("transname not like", value, "transname");
            return (Criteria) this;
        }

        public Criteria andTransnameIn(List<String> values) {
            addCriterion("transname in", values, "transname");
            return (Criteria) this;
        }

        public Criteria andTransnameNotIn(List<String> values) {
            addCriterion("transname not in", values, "transname");
            return (Criteria) this;
        }

        public Criteria andTransnameBetween(String value1, String value2) {
            addCriterion("transname between", value1, value2, "transname");
            return (Criteria) this;
        }

        public Criteria andTransnameNotBetween(String value1, String value2) {
            addCriterion("transname not between", value1, value2, "transname");
            return (Criteria) this;
        }

        public Criteria andFlowstepIsNull() {
            addCriterion("flowstep is null");
            return (Criteria) this;
        }

        public Criteria andFlowstepIsNotNull() {
            addCriterion("flowstep is not null");
            return (Criteria) this;
        }

        public Criteria andFlowstepEqualTo(Integer value) {
            addCriterion("flowstep =", value, "flowstep");
            return (Criteria) this;
        }

        public Criteria andFlowstepNotEqualTo(Integer value) {
            addCriterion("flowstep <>", value, "flowstep");
            return (Criteria) this;
        }

        public Criteria andFlowstepGreaterThan(Integer value) {
            addCriterion("flowstep >", value, "flowstep");
            return (Criteria) this;
        }

        public Criteria andFlowstepGreaterThanOrEqualTo(Integer value) {
            addCriterion("flowstep >=", value, "flowstep");
            return (Criteria) this;
        }

        public Criteria andFlowstepLessThan(Integer value) {
            addCriterion("flowstep <", value, "flowstep");
            return (Criteria) this;
        }

        public Criteria andFlowstepLessThanOrEqualTo(Integer value) {
            addCriterion("flowstep <=", value, "flowstep");
            return (Criteria) this;
        }

        public Criteria andFlowstepIn(List<Integer> values) {
            addCriterion("flowstep in", values, "flowstep");
            return (Criteria) this;
        }

        public Criteria andFlowstepNotIn(List<Integer> values) {
            addCriterion("flowstep not in", values, "flowstep");
            return (Criteria) this;
        }

        public Criteria andFlowstepBetween(Integer value1, Integer value2) {
            addCriterion("flowstep between", value1, value2, "flowstep");
            return (Criteria) this;
        }

        public Criteria andFlowstepNotBetween(Integer value1, Integer value2) {
            addCriterion("flowstep not between", value1, value2, "flowstep");
            return (Criteria) this;
        }

        public Criteria andSubjectIsNull() {
            addCriterion("subject is null");
            return (Criteria) this;
        }

        public Criteria andSubjectIsNotNull() {
            addCriterion("subject is not null");
            return (Criteria) this;
        }

        public Criteria andSubjectEqualTo(String value) {
            addCriterion("subject =", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectNotEqualTo(String value) {
            addCriterion("subject <>", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectGreaterThan(String value) {
            addCriterion("subject >", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectGreaterThanOrEqualTo(String value) {
            addCriterion("subject >=", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectLessThan(String value) {
            addCriterion("subject <", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectLessThanOrEqualTo(String value) {
            addCriterion("subject <=", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectLike(String value) {
            addCriterion("subject like", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectNotLike(String value) {
            addCriterion("subject not like", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectIn(List<String> values) {
            addCriterion("subject in", values, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectNotIn(List<String> values) {
            addCriterion("subject not in", values, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectBetween(String value1, String value2) {
            addCriterion("subject between", value1, value2, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectNotBetween(String value1, String value2) {
            addCriterion("subject not between", value1, value2, "subject");
            return (Criteria) this;
        }

        public Criteria andAppreasonIsNull() {
            addCriterion("appreason is null");
            return (Criteria) this;
        }

        public Criteria andAppreasonIsNotNull() {
            addCriterion("appreason is not null");
            return (Criteria) this;
        }

        public Criteria andAppreasonEqualTo(String value) {
            addCriterion("appreason =", value, "appreason");
            return (Criteria) this;
        }

        public Criteria andAppreasonNotEqualTo(String value) {
            addCriterion("appreason <>", value, "appreason");
            return (Criteria) this;
        }

        public Criteria andAppreasonGreaterThan(String value) {
            addCriterion("appreason >", value, "appreason");
            return (Criteria) this;
        }

        public Criteria andAppreasonGreaterThanOrEqualTo(String value) {
            addCriterion("appreason >=", value, "appreason");
            return (Criteria) this;
        }

        public Criteria andAppreasonLessThan(String value) {
            addCriterion("appreason <", value, "appreason");
            return (Criteria) this;
        }

        public Criteria andAppreasonLessThanOrEqualTo(String value) {
            addCriterion("appreason <=", value, "appreason");
            return (Criteria) this;
        }

        public Criteria andAppreasonLike(String value) {
            addCriterion("appreason like", value, "appreason");
            return (Criteria) this;
        }

        public Criteria andAppreasonNotLike(String value) {
            addCriterion("appreason not like", value, "appreason");
            return (Criteria) this;
        }

        public Criteria andAppreasonIn(List<String> values) {
            addCriterion("appreason in", values, "appreason");
            return (Criteria) this;
        }

        public Criteria andAppreasonNotIn(List<String> values) {
            addCriterion("appreason not in", values, "appreason");
            return (Criteria) this;
        }

        public Criteria andAppreasonBetween(String value1, String value2) {
            addCriterion("appreason between", value1, value2, "appreason");
            return (Criteria) this;
        }

        public Criteria andAppreasonNotBetween(String value1, String value2) {
            addCriterion("appreason not between", value1, value2, "appreason");
            return (Criteria) this;
        }

        public Criteria andAppstatusIsNull() {
            addCriterion("appstatus is null");
            return (Criteria) this;
        }

        public Criteria andAppstatusIsNotNull() {
            addCriterion("appstatus is not null");
            return (Criteria) this;
        }

        public Criteria andAppstatusEqualTo(Boolean value) {
            addCriterion("appstatus =", value, "appstatus");
            return (Criteria) this;
        }

        public Criteria andAppstatusNotEqualTo(Boolean value) {
            addCriterion("appstatus <>", value, "appstatus");
            return (Criteria) this;
        }

        public Criteria andAppstatusGreaterThan(Boolean value) {
            addCriterion("appstatus >", value, "appstatus");
            return (Criteria) this;
        }

        public Criteria andAppstatusGreaterThanOrEqualTo(Boolean value) {
            addCriterion("appstatus >=", value, "appstatus");
            return (Criteria) this;
        }

        public Criteria andAppstatusLessThan(Boolean value) {
            addCriterion("appstatus <", value, "appstatus");
            return (Criteria) this;
        }

        public Criteria andAppstatusLessThanOrEqualTo(Boolean value) {
            addCriterion("appstatus <=", value, "appstatus");
            return (Criteria) this;
        }

        public Criteria andAppstatusIn(List<Boolean> values) {
            addCriterion("appstatus in", values, "appstatus");
            return (Criteria) this;
        }

        public Criteria andAppstatusNotIn(List<Boolean> values) {
            addCriterion("appstatus not in", values, "appstatus");
            return (Criteria) this;
        }

        public Criteria andAppstatusBetween(Boolean value1, Boolean value2) {
            addCriterion("appstatus between", value1, value2, "appstatus");
            return (Criteria) this;
        }

        public Criteria andAppstatusNotBetween(Boolean value1, Boolean value2) {
            addCriterion("appstatus not between", value1, value2, "appstatus");
            return (Criteria) this;
        }

        public Criteria andStaffNoIsNull() {
            addCriterion("staff_no is null");
            return (Criteria) this;
        }

        public Criteria andStaffNoIsNotNull() {
            addCriterion("staff_no is not null");
            return (Criteria) this;
        }

        public Criteria andStaffNoEqualTo(String value) {
            addCriterion("staff_no =", value, "staffNo");
            return (Criteria) this;
        }

        public Criteria andStaffNoNotEqualTo(String value) {
            addCriterion("staff_no <>", value, "staffNo");
            return (Criteria) this;
        }

        public Criteria andStaffNoGreaterThan(String value) {
            addCriterion("staff_no >", value, "staffNo");
            return (Criteria) this;
        }

        public Criteria andStaffNoGreaterThanOrEqualTo(String value) {
            addCriterion("staff_no >=", value, "staffNo");
            return (Criteria) this;
        }

        public Criteria andStaffNoLessThan(String value) {
            addCriterion("staff_no <", value, "staffNo");
            return (Criteria) this;
        }

        public Criteria andStaffNoLessThanOrEqualTo(String value) {
            addCriterion("staff_no <=", value, "staffNo");
            return (Criteria) this;
        }

        public Criteria andStaffNoLike(String value) {
            addCriterion("staff_no like", value, "staffNo");
            return (Criteria) this;
        }

        public Criteria andStaffNoNotLike(String value) {
            addCriterion("staff_no not like", value, "staffNo");
            return (Criteria) this;
        }

        public Criteria andStaffNoIn(List<String> values) {
            addCriterion("staff_no in", values, "staffNo");
            return (Criteria) this;
        }

        public Criteria andStaffNoNotIn(List<String> values) {
            addCriterion("staff_no not in", values, "staffNo");
            return (Criteria) this;
        }

        public Criteria andStaffNoBetween(String value1, String value2) {
            addCriterion("staff_no between", value1, value2, "staffNo");
            return (Criteria) this;
        }

        public Criteria andStaffNoNotBetween(String value1, String value2) {
            addCriterion("staff_no not between", value1, value2, "staffNo");
            return (Criteria) this;
        }

        public Criteria andStaffNameIsNull() {
            addCriterion("staff_name is null");
            return (Criteria) this;
        }

        public Criteria andStaffNameIsNotNull() {
            addCriterion("staff_name is not null");
            return (Criteria) this;
        }

        public Criteria andStaffNameEqualTo(String value) {
            addCriterion("staff_name =", value, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameNotEqualTo(String value) {
            addCriterion("staff_name <>", value, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameGreaterThan(String value) {
            addCriterion("staff_name >", value, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameGreaterThanOrEqualTo(String value) {
            addCriterion("staff_name >=", value, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameLessThan(String value) {
            addCriterion("staff_name <", value, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameLessThanOrEqualTo(String value) {
            addCriterion("staff_name <=", value, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameLike(String value) {
            addCriterion("staff_name like", value, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameNotLike(String value) {
            addCriterion("staff_name not like", value, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameIn(List<String> values) {
            addCriterion("staff_name in", values, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameNotIn(List<String> values) {
            addCriterion("staff_name not in", values, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameBetween(String value1, String value2) {
            addCriterion("staff_name between", value1, value2, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameNotBetween(String value1, String value2) {
            addCriterion("staff_name not between", value1, value2, "staffName");
            return (Criteria) this;
        }

        public Criteria andOpdateIsNull() {
            addCriterion("opdate is null");
            return (Criteria) this;
        }

        public Criteria andOpdateIsNotNull() {
            addCriterion("opdate is not null");
            return (Criteria) this;
        }

        public Criteria andOpdateEqualTo(Date value) {
            addCriterion("opdate =", value, "opdate");
            return (Criteria) this;
        }

        public Criteria andOpdateNotEqualTo(Date value) {
            addCriterion("opdate <>", value, "opdate");
            return (Criteria) this;
        }

        public Criteria andOpdateGreaterThan(Date value) {
            addCriterion("opdate >", value, "opdate");
            return (Criteria) this;
        }

        public Criteria andOpdateGreaterThanOrEqualTo(Date value) {
            addCriterion("opdate >=", value, "opdate");
            return (Criteria) this;
        }

        public Criteria andOpdateLessThan(Date value) {
            addCriterion("opdate <", value, "opdate");
            return (Criteria) this;
        }

        public Criteria andOpdateLessThanOrEqualTo(Date value) {
            addCriterion("opdate <=", value, "opdate");
            return (Criteria) this;
        }

        public Criteria andOpdateIn(List<Date> values) {
            addCriterion("opdate in", values, "opdate");
            return (Criteria) this;
        }

        public Criteria andOpdateNotIn(List<Date> values) {
            addCriterion("opdate not in", values, "opdate");
            return (Criteria) this;
        }

        public Criteria andOpdateBetween(Date value1, Date value2) {
            addCriterion("opdate between", value1, value2, "opdate");
            return (Criteria) this;
        }

        public Criteria andOpdateNotBetween(Date value1, Date value2) {
            addCriterion("opdate not between", value1, value2, "opdate");
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
     * This class:org.mybatis.generator.config.Context@3f669e7f
     *  approve
     *
     * @ET do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class:org.mybatis.generator.config.Context@3f669e7f
     *  approve
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