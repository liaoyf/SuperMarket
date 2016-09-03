package com.sm.mybatis.mb;

import java.util.ArrayList;
import java.util.List;

public class LPRoleExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table t_lpower_role
	 * @mbggenerated  Mon Jun 22 20:33:59 CST 2015
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table t_lpower_role
	 * @mbggenerated  Mon Jun 22 20:33:59 CST 2015
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table t_lpower_role
	 * @mbggenerated  Mon Jun 22 20:33:59 CST 2015
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_lpower_role
	 * @mbggenerated  Mon Jun 22 20:33:59 CST 2015
	 */
	public LPRoleExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_lpower_role
	 * @mbggenerated  Mon Jun 22 20:33:59 CST 2015
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_lpower_role
	 * @mbggenerated  Mon Jun 22 20:33:59 CST 2015
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_lpower_role
	 * @mbggenerated  Mon Jun 22 20:33:59 CST 2015
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_lpower_role
	 * @mbggenerated  Mon Jun 22 20:33:59 CST 2015
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_lpower_role
	 * @mbggenerated  Mon Jun 22 20:33:59 CST 2015
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_lpower_role
	 * @mbggenerated  Mon Jun 22 20:33:59 CST 2015
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_lpower_role
	 * @mbggenerated  Mon Jun 22 20:33:59 CST 2015
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_lpower_role
	 * @mbggenerated  Mon Jun 22 20:33:59 CST 2015
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_lpower_role
	 * @mbggenerated  Mon Jun 22 20:33:59 CST 2015
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_lpower_role
	 * @mbggenerated  Mon Jun 22 20:33:59 CST 2015
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table t_lpower_role
	 * @mbggenerated  Mon Jun 22 20:33:59 CST 2015
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

		protected void addCriterion(String condition, Object value,
				String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property
						+ " cannot be null");
			}
			criteria.add(new Criterion(condition, value));
		}

		protected void addCriterion(String condition, Object value1,
				Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property
						+ " cannot be null");
			}
			criteria.add(new Criterion(condition, value1, value2));
		}

		public Criteria andLpIdIsNull() {
			addCriterion("LP_ID is null");
			return (Criteria) this;
		}

		public Criteria andLpIdIsNotNull() {
			addCriterion("LP_ID is not null");
			return (Criteria) this;
		}

		public Criteria andLpIdEqualTo(Integer value) {
			addCriterion("LP_ID =", value, "lpId");
			return (Criteria) this;
		}

		public Criteria andLpIdNotEqualTo(Integer value) {
			addCriterion("LP_ID <>", value, "lpId");
			return (Criteria) this;
		}

		public Criteria andLpIdGreaterThan(Integer value) {
			addCriterion("LP_ID >", value, "lpId");
			return (Criteria) this;
		}

		public Criteria andLpIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("LP_ID >=", value, "lpId");
			return (Criteria) this;
		}

		public Criteria andLpIdLessThan(Integer value) {
			addCriterion("LP_ID <", value, "lpId");
			return (Criteria) this;
		}

		public Criteria andLpIdLessThanOrEqualTo(Integer value) {
			addCriterion("LP_ID <=", value, "lpId");
			return (Criteria) this;
		}

		public Criteria andLpIdIn(List<Integer> values) {
			addCriterion("LP_ID in", values, "lpId");
			return (Criteria) this;
		}

		public Criteria andLpIdNotIn(List<Integer> values) {
			addCriterion("LP_ID not in", values, "lpId");
			return (Criteria) this;
		}

		public Criteria andLpIdBetween(Integer value1, Integer value2) {
			addCriterion("LP_ID between", value1, value2, "lpId");
			return (Criteria) this;
		}

		public Criteria andLpIdNotBetween(Integer value1, Integer value2) {
			addCriterion("LP_ID not between", value1, value2, "lpId");
			return (Criteria) this;
		}

		public Criteria andRoleIdIsNull() {
			addCriterion("Role_ID is null");
			return (Criteria) this;
		}

		public Criteria andRoleIdIsNotNull() {
			addCriterion("Role_ID is not null");
			return (Criteria) this;
		}

		public Criteria andRoleIdEqualTo(Integer value) {
			addCriterion("Role_ID =", value, "roleId");
			return (Criteria) this;
		}

		public Criteria andRoleIdNotEqualTo(Integer value) {
			addCriterion("Role_ID <>", value, "roleId");
			return (Criteria) this;
		}

		public Criteria andRoleIdGreaterThan(Integer value) {
			addCriterion("Role_ID >", value, "roleId");
			return (Criteria) this;
		}

		public Criteria andRoleIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("Role_ID >=", value, "roleId");
			return (Criteria) this;
		}

		public Criteria andRoleIdLessThan(Integer value) {
			addCriterion("Role_ID <", value, "roleId");
			return (Criteria) this;
		}

		public Criteria andRoleIdLessThanOrEqualTo(Integer value) {
			addCriterion("Role_ID <=", value, "roleId");
			return (Criteria) this;
		}

		public Criteria andRoleIdIn(List<Integer> values) {
			addCriterion("Role_ID in", values, "roleId");
			return (Criteria) this;
		}

		public Criteria andRoleIdNotIn(List<Integer> values) {
			addCriterion("Role_ID not in", values, "roleId");
			return (Criteria) this;
		}

		public Criteria andRoleIdBetween(Integer value1, Integer value2) {
			addCriterion("Role_ID between", value1, value2, "roleId");
			return (Criteria) this;
		}

		public Criteria andRoleIdNotBetween(Integer value1, Integer value2) {
			addCriterion("Role_ID not between", value1, value2, "roleId");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table t_lpower_role
	 * @mbggenerated  Mon Jun 22 20:33:59 CST 2015
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

		protected Criterion(String condition, Object value, Object secondValue,
				String typeHandler) {
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

	/**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table t_lpower_role
     *
     * @mbggenerated do_not_delete_during_merge Thu Jun 18 10:07:41 CST 2015
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}