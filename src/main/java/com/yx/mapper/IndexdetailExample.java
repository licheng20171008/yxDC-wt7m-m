package com.yx.mapper;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class IndexdetailExample {
    protected String orderByClause;

    protected String limitClause;
    
    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public IndexdetailExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public String getLimitClause() {
		return limitClause;
	}

	public void setLimitClause(String limitClause) {
		this.limitClause = limitClause;
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

    /**
     * 
     * 
     * @author licheng
     * 
     * @date 2021-02-08
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

        public Criteria andCategoryDetailIsNull() {
            addCriterion("category_detail is null");
            return (Criteria) this;
        }

        public Criteria andCategoryDetailIsNotNull() {
            addCriterion("category_detail is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryDetailEqualTo(String value) {
            addCriterion("category_detail =", value, "categoryDetail");
            return (Criteria) this;
        }

        public Criteria andCategoryDetailNotEqualTo(String value) {
            addCriterion("category_detail <>", value, "categoryDetail");
            return (Criteria) this;
        }

        public Criteria andCategoryDetailGreaterThan(String value) {
            addCriterion("category_detail >", value, "categoryDetail");
            return (Criteria) this;
        }

        public Criteria andCategoryDetailGreaterThanOrEqualTo(String value) {
            addCriterion("category_detail >=", value, "categoryDetail");
            return (Criteria) this;
        }

        public Criteria andCategoryDetailLessThan(String value) {
            addCriterion("category_detail <", value, "categoryDetail");
            return (Criteria) this;
        }

        public Criteria andCategoryDetailLessThanOrEqualTo(String value) {
            addCriterion("category_detail <=", value, "categoryDetail");
            return (Criteria) this;
        }

        public Criteria andCategoryDetailLike(String value) {
            addCriterion("category_detail like", value, "categoryDetail");
            return (Criteria) this;
        }

        public Criteria andCategoryDetailNotLike(String value) {
            addCriterion("category_detail not like", value, "categoryDetail");
            return (Criteria) this;
        }

        public Criteria andCategoryDetailIn(List<String> values) {
            addCriterion("category_detail in", values, "categoryDetail");
            return (Criteria) this;
        }

        public Criteria andCategoryDetailNotIn(List<String> values) {
            addCriterion("category_detail not in", values, "categoryDetail");
            return (Criteria) this;
        }

        public Criteria andCategoryDetailBetween(String value1, String value2) {
            addCriterion("category_detail between", value1, value2, "categoryDetail");
            return (Criteria) this;
        }

        public Criteria andCategoryDetailNotBetween(String value1, String value2) {
            addCriterion("category_detail not between", value1, value2, "categoryDetail");
            return (Criteria) this;
        }

        public Criteria andTypeDetailIsNull() {
            addCriterion("type_detail is null");
            return (Criteria) this;
        }

        public Criteria andTypeDetailIsNotNull() {
            addCriterion("type_detail is not null");
            return (Criteria) this;
        }

        public Criteria andTypeDetailEqualTo(String value) {
            addCriterion("type_detail =", value, "typeDetail");
            return (Criteria) this;
        }

        public Criteria andTypeDetailNotEqualTo(String value) {
            addCriterion("type_detail <>", value, "typeDetail");
            return (Criteria) this;
        }

        public Criteria andTypeDetailGreaterThan(String value) {
            addCriterion("type_detail >", value, "typeDetail");
            return (Criteria) this;
        }

        public Criteria andTypeDetailGreaterThanOrEqualTo(String value) {
            addCriterion("type_detail >=", value, "typeDetail");
            return (Criteria) this;
        }

        public Criteria andTypeDetailLessThan(String value) {
            addCriterion("type_detail <", value, "typeDetail");
            return (Criteria) this;
        }

        public Criteria andTypeDetailLessThanOrEqualTo(String value) {
            addCriterion("type_detail <=", value, "typeDetail");
            return (Criteria) this;
        }

        public Criteria andTypeDetailLike(String value) {
            addCriterion("type_detail like", value, "typeDetail");
            return (Criteria) this;
        }

        public Criteria andTypeDetailNotLike(String value) {
            addCriterion("type_detail not like", value, "typeDetail");
            return (Criteria) this;
        }

        public Criteria andTypeDetailIn(List<String> values) {
            addCriterion("type_detail in", values, "typeDetail");
            return (Criteria) this;
        }

        public Criteria andTypeDetailNotIn(List<String> values) {
            addCriterion("type_detail not in", values, "typeDetail");
            return (Criteria) this;
        }

        public Criteria andTypeDetailBetween(String value1, String value2) {
            addCriterion("type_detail between", value1, value2, "typeDetail");
            return (Criteria) this;
        }

        public Criteria andTypeDetailNotBetween(String value1, String value2) {
            addCriterion("type_detail not between", value1, value2, "typeDetail");
            return (Criteria) this;
        }

        public Criteria andIndexidIsNull() {
            addCriterion("indexID is null");
            return (Criteria) this;
        }

        public Criteria andIndexidIsNotNull() {
            addCriterion("indexID is not null");
            return (Criteria) this;
        }

        public Criteria andIndexidEqualTo(String value) {
            addCriterion("indexID =", value, "indexid");
            return (Criteria) this;
        }

        public Criteria andIndexidNotEqualTo(String value) {
            addCriterion("indexID <>", value, "indexid");
            return (Criteria) this;
        }

        public Criteria andIndexidGreaterThan(String value) {
            addCriterion("indexID >", value, "indexid");
            return (Criteria) this;
        }

        public Criteria andIndexidGreaterThanOrEqualTo(String value) {
            addCriterion("indexID >=", value, "indexid");
            return (Criteria) this;
        }

        public Criteria andIndexidLessThan(String value) {
            addCriterion("indexID <", value, "indexid");
            return (Criteria) this;
        }

        public Criteria andIndexidLessThanOrEqualTo(String value) {
            addCriterion("indexID <=", value, "indexid");
            return (Criteria) this;
        }

        public Criteria andIndexidLike(String value) {
            addCriterion("indexID like", value, "indexid");
            return (Criteria) this;
        }

        public Criteria andIndexidNotLike(String value) {
            addCriterion("indexID not like", value, "indexid");
            return (Criteria) this;
        }

        public Criteria andIndexidIn(List<String> values) {
            addCriterion("indexID in", values, "indexid");
            return (Criteria) this;
        }

        public Criteria andIndexidNotIn(List<String> values) {
            addCriterion("indexID not in", values, "indexid");
            return (Criteria) this;
        }

        public Criteria andIndexidBetween(String value1, String value2) {
            addCriterion("indexID between", value1, value2, "indexid");
            return (Criteria) this;
        }

        public Criteria andIndexidNotBetween(String value1, String value2) {
            addCriterion("indexID not between", value1, value2, "indexid");
            return (Criteria) this;
        }

        public Criteria andIndexnameIsNull() {
            addCriterion("indexName is null");
            return (Criteria) this;
        }

        public Criteria andIndexnameIsNotNull() {
            addCriterion("indexName is not null");
            return (Criteria) this;
        }

        public Criteria andIndexnameEqualTo(String value) {
            addCriterion("indexName =", value, "indexname");
            return (Criteria) this;
        }

        public Criteria andIndexnameNotEqualTo(String value) {
            addCriterion("indexName <>", value, "indexname");
            return (Criteria) this;
        }

        public Criteria andIndexnameGreaterThan(String value) {
            addCriterion("indexName >", value, "indexname");
            return (Criteria) this;
        }

        public Criteria andIndexnameGreaterThanOrEqualTo(String value) {
            addCriterion("indexName >=", value, "indexname");
            return (Criteria) this;
        }

        public Criteria andIndexnameLessThan(String value) {
            addCriterion("indexName <", value, "indexname");
            return (Criteria) this;
        }

        public Criteria andIndexnameLessThanOrEqualTo(String value) {
            addCriterion("indexName <=", value, "indexname");
            return (Criteria) this;
        }

        public Criteria andIndexnameLike(String value) {
            addCriterion("indexName like", value, "indexname");
            return (Criteria) this;
        }

        public Criteria andIndexnameNotLike(String value) {
            addCriterion("indexName not like", value, "indexname");
            return (Criteria) this;
        }

        public Criteria andIndexnameIn(List<String> values) {
            addCriterion("indexName in", values, "indexname");
            return (Criteria) this;
        }

        public Criteria andIndexnameNotIn(List<String> values) {
            addCriterion("indexName not in", values, "indexname");
            return (Criteria) this;
        }

        public Criteria andIndexnameBetween(String value1, String value2) {
            addCriterion("indexName between", value1, value2, "indexname");
            return (Criteria) this;
        }

        public Criteria andIndexnameNotBetween(String value1, String value2) {
            addCriterion("indexName not between", value1, value2, "indexname");
            return (Criteria) this;
        }

        public Criteria andIndexdetailIsNull() {
            addCriterion("indexDetail is null");
            return (Criteria) this;
        }

        public Criteria andIndexdetailIsNotNull() {
            addCriterion("indexDetail is not null");
            return (Criteria) this;
        }

        public Criteria andIndexdetailEqualTo(String value) {
            addCriterion("indexDetail =", value, "indexdetail");
            return (Criteria) this;
        }

        public Criteria andIndexdetailNotEqualTo(String value) {
            addCriterion("indexDetail <>", value, "indexdetail");
            return (Criteria) this;
        }

        public Criteria andIndexdetailGreaterThan(String value) {
            addCriterion("indexDetail >", value, "indexdetail");
            return (Criteria) this;
        }

        public Criteria andIndexdetailGreaterThanOrEqualTo(String value) {
            addCriterion("indexDetail >=", value, "indexdetail");
            return (Criteria) this;
        }

        public Criteria andIndexdetailLessThan(String value) {
            addCriterion("indexDetail <", value, "indexdetail");
            return (Criteria) this;
        }

        public Criteria andIndexdetailLessThanOrEqualTo(String value) {
            addCriterion("indexDetail <=", value, "indexdetail");
            return (Criteria) this;
        }

        public Criteria andIndexdetailLike(String value) {
            addCriterion("indexDetail like", value, "indexdetail");
            return (Criteria) this;
        }

        public Criteria andIndexdetailNotLike(String value) {
            addCriterion("indexDetail not like", value, "indexdetail");
            return (Criteria) this;
        }

        public Criteria andIndexdetailIn(List<String> values) {
            addCriterion("indexDetail in", values, "indexdetail");
            return (Criteria) this;
        }

        public Criteria andIndexdetailNotIn(List<String> values) {
            addCriterion("indexDetail not in", values, "indexdetail");
            return (Criteria) this;
        }

        public Criteria andIndexdetailBetween(String value1, String value2) {
            addCriterion("indexDetail between", value1, value2, "indexdetail");
            return (Criteria) this;
        }

        public Criteria andIndexdetailNotBetween(String value1, String value2) {
            addCriterion("indexDetail not between", value1, value2, "indexdetail");
            return (Criteria) this;
        }

        public Criteria andIndexformulaIsNull() {
            addCriterion("indexFormula is null");
            return (Criteria) this;
        }

        public Criteria andIndexformulaIsNotNull() {
            addCriterion("indexFormula is not null");
            return (Criteria) this;
        }

        public Criteria andIndexformulaEqualTo(String value) {
            addCriterion("indexFormula =", value, "indexformula");
            return (Criteria) this;
        }

        public Criteria andIndexformulaNotEqualTo(String value) {
            addCriterion("indexFormula <>", value, "indexformula");
            return (Criteria) this;
        }

        public Criteria andIndexformulaGreaterThan(String value) {
            addCriterion("indexFormula >", value, "indexformula");
            return (Criteria) this;
        }

        public Criteria andIndexformulaGreaterThanOrEqualTo(String value) {
            addCriterion("indexFormula >=", value, "indexformula");
            return (Criteria) this;
        }

        public Criteria andIndexformulaLessThan(String value) {
            addCriterion("indexFormula <", value, "indexformula");
            return (Criteria) this;
        }

        public Criteria andIndexformulaLessThanOrEqualTo(String value) {
            addCriterion("indexFormula <=", value, "indexformula");
            return (Criteria) this;
        }

        public Criteria andIndexformulaLike(String value) {
            addCriterion("indexFormula like", value, "indexformula");
            return (Criteria) this;
        }

        public Criteria andIndexformulaNotLike(String value) {
            addCriterion("indexFormula not like", value, "indexformula");
            return (Criteria) this;
        }

        public Criteria andIndexformulaIn(List<String> values) {
            addCriterion("indexFormula in", values, "indexformula");
            return (Criteria) this;
        }

        public Criteria andIndexformulaNotIn(List<String> values) {
            addCriterion("indexFormula not in", values, "indexformula");
            return (Criteria) this;
        }

        public Criteria andIndexformulaBetween(String value1, String value2) {
            addCriterion("indexFormula between", value1, value2, "indexformula");
            return (Criteria) this;
        }

        public Criteria andIndexformulaNotBetween(String value1, String value2) {
            addCriterion("indexFormula not between", value1, value2, "indexformula");
            return (Criteria) this;
        }

        public Criteria andComputingcycleIsNull() {
            addCriterion("computingCycle is null");
            return (Criteria) this;
        }

        public Criteria andComputingcycleIsNotNull() {
            addCriterion("computingCycle is not null");
            return (Criteria) this;
        }

        public Criteria andComputingcycleEqualTo(String value) {
            addCriterion("computingCycle =", value, "computingcycle");
            return (Criteria) this;
        }

        public Criteria andComputingcycleNotEqualTo(String value) {
            addCriterion("computingCycle <>", value, "computingcycle");
            return (Criteria) this;
        }

        public Criteria andComputingcycleGreaterThan(String value) {
            addCriterion("computingCycle >", value, "computingcycle");
            return (Criteria) this;
        }

        public Criteria andComputingcycleGreaterThanOrEqualTo(String value) {
            addCriterion("computingCycle >=", value, "computingcycle");
            return (Criteria) this;
        }

        public Criteria andComputingcycleLessThan(String value) {
            addCriterion("computingCycle <", value, "computingcycle");
            return (Criteria) this;
        }

        public Criteria andComputingcycleLessThanOrEqualTo(String value) {
            addCriterion("computingCycle <=", value, "computingcycle");
            return (Criteria) this;
        }

        public Criteria andComputingcycleLike(String value) {
            addCriterion("computingCycle like", value, "computingcycle");
            return (Criteria) this;
        }

        public Criteria andComputingcycleNotLike(String value) {
            addCriterion("computingCycle not like", value, "computingcycle");
            return (Criteria) this;
        }

        public Criteria andComputingcycleIn(List<String> values) {
            addCriterion("computingCycle in", values, "computingcycle");
            return (Criteria) this;
        }

        public Criteria andComputingcycleNotIn(List<String> values) {
            addCriterion("computingCycle not in", values, "computingcycle");
            return (Criteria) this;
        }

        public Criteria andComputingcycleBetween(String value1, String value2) {
            addCriterion("computingCycle between", value1, value2, "computingcycle");
            return (Criteria) this;
        }

        public Criteria andComputingcycleNotBetween(String value1, String value2) {
            addCriterion("computingCycle not between", value1, value2, "computingcycle");
            return (Criteria) this;
        }

        public Criteria andCycleunitIsNull() {
            addCriterion("cycleUnit is null");
            return (Criteria) this;
        }

        public Criteria andCycleunitIsNotNull() {
            addCriterion("cycleUnit is not null");
            return (Criteria) this;
        }

        public Criteria andCycleunitEqualTo(String value) {
            addCriterion("cycleUnit =", value, "cycleunit");
            return (Criteria) this;
        }

        public Criteria andCycleunitNotEqualTo(String value) {
            addCriterion("cycleUnit <>", value, "cycleunit");
            return (Criteria) this;
        }

        public Criteria andCycleunitGreaterThan(String value) {
            addCriterion("cycleUnit >", value, "cycleunit");
            return (Criteria) this;
        }

        public Criteria andCycleunitGreaterThanOrEqualTo(String value) {
            addCriterion("cycleUnit >=", value, "cycleunit");
            return (Criteria) this;
        }

        public Criteria andCycleunitLessThan(String value) {
            addCriterion("cycleUnit <", value, "cycleunit");
            return (Criteria) this;
        }

        public Criteria andCycleunitLessThanOrEqualTo(String value) {
            addCriterion("cycleUnit <=", value, "cycleunit");
            return (Criteria) this;
        }

        public Criteria andCycleunitLike(String value) {
            addCriterion("cycleUnit like", value, "cycleunit");
            return (Criteria) this;
        }

        public Criteria andCycleunitNotLike(String value) {
            addCriterion("cycleUnit not like", value, "cycleunit");
            return (Criteria) this;
        }

        public Criteria andCycleunitIn(List<String> values) {
            addCriterion("cycleUnit in", values, "cycleunit");
            return (Criteria) this;
        }

        public Criteria andCycleunitNotIn(List<String> values) {
            addCriterion("cycleUnit not in", values, "cycleunit");
            return (Criteria) this;
        }

        public Criteria andCycleunitBetween(String value1, String value2) {
            addCriterion("cycleUnit between", value1, value2, "cycleunit");
            return (Criteria) this;
        }

        public Criteria andCycleunitNotBetween(String value1, String value2) {
            addCriterion("cycleUnit not between", value1, value2, "cycleunit");
            return (Criteria) this;
        }

        public Criteria andDepartmentIsNull() {
            addCriterion("department is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentIsNotNull() {
            addCriterion("department is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentEqualTo(String value) {
            addCriterion("department =", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentNotEqualTo(String value) {
            addCriterion("department <>", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentGreaterThan(String value) {
            addCriterion("department >", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentGreaterThanOrEqualTo(String value) {
            addCriterion("department >=", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentLessThan(String value) {
            addCriterion("department <", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentLessThanOrEqualTo(String value) {
            addCriterion("department <=", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentLike(String value) {
            addCriterion("department like", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentNotLike(String value) {
            addCriterion("department not like", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentIn(List<String> values) {
            addCriterion("department in", values, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentNotIn(List<String> values) {
            addCriterion("department not in", values, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentBetween(String value1, String value2) {
            addCriterion("department between", value1, value2, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentNotBetween(String value1, String value2) {
            addCriterion("department not between", value1, value2, "department");
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

        public Criteria andAbatetimeIsNull() {
            addCriterion("abateTime is null");
            return (Criteria) this;
        }

        public Criteria andAbatetimeIsNotNull() {
            addCriterion("abateTime is not null");
            return (Criteria) this;
        }

        public Criteria andAbatetimeEqualTo(Date value) {
            addCriterionForJDBCDate("abateTime =", value, "abatetime");
            return (Criteria) this;
        }

        public Criteria andAbatetimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("abateTime <>", value, "abatetime");
            return (Criteria) this;
        }

        public Criteria andAbatetimeGreaterThan(Date value) {
            addCriterionForJDBCDate("abateTime >", value, "abatetime");
            return (Criteria) this;
        }

        public Criteria andAbatetimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("abateTime >=", value, "abatetime");
            return (Criteria) this;
        }

        public Criteria andAbatetimeLessThan(Date value) {
            addCriterionForJDBCDate("abateTime <", value, "abatetime");
            return (Criteria) this;
        }

        public Criteria andAbatetimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("abateTime <=", value, "abatetime");
            return (Criteria) this;
        }

        public Criteria andAbatetimeIn(List<Date> values) {
            addCriterionForJDBCDate("abateTime in", values, "abatetime");
            return (Criteria) this;
        }

        public Criteria andAbatetimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("abateTime not in", values, "abatetime");
            return (Criteria) this;
        }

        public Criteria andAbatetimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("abateTime between", value1, value2, "abatetime");
            return (Criteria) this;
        }

        public Criteria andAbatetimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("abateTime not between", value1, value2, "abatetime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * 
     * 
     * @author licheng
     * 
     * @date 2021-02-08
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