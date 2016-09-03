package com.sm.mybatis.mb;

import java.util.ArrayList;
import java.util.List;

public class CreditsDiscountExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table t_credits_discount
	 * @mbggenerated  Mon Jun 22 20:33:59 CST 2015
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table t_credits_discount
	 * @mbggenerated  Mon Jun 22 20:33:59 CST 2015
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table t_credits_discount
	 * @mbggenerated  Mon Jun 22 20:33:59 CST 2015
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_credits_discount
	 * @mbggenerated  Mon Jun 22 20:33:59 CST 2015
	 */
	public CreditsDiscountExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_credits_discount
	 * @mbggenerated  Mon Jun 22 20:33:59 CST 2015
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_credits_discount
	 * @mbggenerated  Mon Jun 22 20:33:59 CST 2015
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_credits_discount
	 * @mbggenerated  Mon Jun 22 20:33:59 CST 2015
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_credits_discount
	 * @mbggenerated  Mon Jun 22 20:33:59 CST 2015
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_credits_discount
	 * @mbggenerated  Mon Jun 22 20:33:59 CST 2015
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_credits_discount
	 * @mbggenerated  Mon Jun 22 20:33:59 CST 2015
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_credits_discount
	 * @mbggenerated  Mon Jun 22 20:33:59 CST 2015
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_credits_discount
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
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_credits_discount
	 * @mbggenerated  Mon Jun 22 20:33:59 CST 2015
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_credits_discount
	 * @mbggenerated  Mon Jun 22 20:33:59 CST 2015
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table t_credits_discount
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

		public Criteria andVipLevelIsNull() {
			addCriterion("Vip_Level is null");
			return (Criteria) this;
		}

		public Criteria andVipLevelIsNotNull() {
			addCriterion("Vip_Level is not null");
			return (Criteria) this;
		}

		public Criteria andVipLevelEqualTo(String value) {
			addCriterion("Vip_Level =", value, "vipLevel");
			return (Criteria) this;
		}

		public Criteria andVipLevelNotEqualTo(String value) {
			addCriterion("Vip_Level <>", value, "vipLevel");
			return (Criteria) this;
		}

		public Criteria andVipLevelGreaterThan(String value) {
			addCriterion("Vip_Level >", value, "vipLevel");
			return (Criteria) this;
		}

		public Criteria andVipLevelGreaterThanOrEqualTo(String value) {
			addCriterion("Vip_Level >=", value, "vipLevel");
			return (Criteria) this;
		}

		public Criteria andVipLevelLessThan(String value) {
			addCriterion("Vip_Level <", value, "vipLevel");
			return (Criteria) this;
		}

		public Criteria andVipLevelLessThanOrEqualTo(String value) {
			addCriterion("Vip_Level <=", value, "vipLevel");
			return (Criteria) this;
		}

		public Criteria andVipLevelLike(String value) {
			addCriterion("Vip_Level like", value, "vipLevel");
			return (Criteria) this;
		}

		public Criteria andVipLevelNotLike(String value) {
			addCriterion("Vip_Level not like", value, "vipLevel");
			return (Criteria) this;
		}

		public Criteria andVipLevelIn(List<String> values) {
			addCriterion("Vip_Level in", values, "vipLevel");
			return (Criteria) this;
		}

		public Criteria andVipLevelNotIn(List<String> values) {
			addCriterion("Vip_Level not in", values, "vipLevel");
			return (Criteria) this;
		}

		public Criteria andVipLevelBetween(String value1, String value2) {
			addCriterion("Vip_Level between", value1, value2, "vipLevel");
			return (Criteria) this;
		}

		public Criteria andVipLevelNotBetween(String value1, String value2) {
			addCriterion("Vip_Level not between", value1, value2, "vipLevel");
			return (Criteria) this;
		}

		public Criteria andCreditsStartIntegralIsNull() {
			addCriterion("Credits_Start_Integral is null");
			return (Criteria) this;
		}

		public Criteria andCreditsStartIntegralIsNotNull() {
			addCriterion("Credits_Start_Integral is not null");
			return (Criteria) this;
		}

		public Criteria andCreditsStartIntegralEqualTo(Integer value) {
			addCriterion("Credits_Start_Integral =", value,
					"creditsStartIntegral");
			return (Criteria) this;
		}

		public Criteria andCreditsStartIntegralNotEqualTo(Integer value) {
			addCriterion("Credits_Start_Integral <>", value,
					"creditsStartIntegral");
			return (Criteria) this;
		}

		public Criteria andCreditsStartIntegralGreaterThan(Integer value) {
			addCriterion("Credits_Start_Integral >", value,
					"creditsStartIntegral");
			return (Criteria) this;
		}

		public Criteria andCreditsStartIntegralGreaterThanOrEqualTo(
				Integer value) {
			addCriterion("Credits_Start_Integral >=", value,
					"creditsStartIntegral");
			return (Criteria) this;
		}

		public Criteria andCreditsStartIntegralLessThan(Integer value) {
			addCriterion("Credits_Start_Integral <", value,
					"creditsStartIntegral");
			return (Criteria) this;
		}

		public Criteria andCreditsStartIntegralLessThanOrEqualTo(Integer value) {
			addCriterion("Credits_Start_Integral <=", value,
					"creditsStartIntegral");
			return (Criteria) this;
		}

		public Criteria andCreditsStartIntegralIn(List<Integer> values) {
			addCriterion("Credits_Start_Integral in", values,
					"creditsStartIntegral");
			return (Criteria) this;
		}

		public Criteria andCreditsStartIntegralNotIn(List<Integer> values) {
			addCriterion("Credits_Start_Integral not in", values,
					"creditsStartIntegral");
			return (Criteria) this;
		}

		public Criteria andCreditsStartIntegralBetween(Integer value1,
				Integer value2) {
			addCriterion("Credits_Start_Integral between", value1, value2,
					"creditsStartIntegral");
			return (Criteria) this;
		}

		public Criteria andCreditsStartIntegralNotBetween(Integer value1,
				Integer value2) {
			addCriterion("Credits_Start_Integral not between", value1, value2,
					"creditsStartIntegral");
			return (Criteria) this;
		}

		public Criteria andCreditsEndIntegralIsNull() {
			addCriterion("Credits_End_Integral is null");
			return (Criteria) this;
		}

		public Criteria andCreditsEndIntegralIsNotNull() {
			addCriterion("Credits_End_Integral is not null");
			return (Criteria) this;
		}

		public Criteria andCreditsEndIntegralEqualTo(Integer value) {
			addCriterion("Credits_End_Integral =", value, "creditsEndIntegral");
			return (Criteria) this;
		}

		public Criteria andCreditsEndIntegralNotEqualTo(Integer value) {
			addCriterion("Credits_End_Integral <>", value, "creditsEndIntegral");
			return (Criteria) this;
		}

		public Criteria andCreditsEndIntegralGreaterThan(Integer value) {
			addCriterion("Credits_End_Integral >", value, "creditsEndIntegral");
			return (Criteria) this;
		}

		public Criteria andCreditsEndIntegralGreaterThanOrEqualTo(Integer value) {
			addCriterion("Credits_End_Integral >=", value, "creditsEndIntegral");
			return (Criteria) this;
		}

		public Criteria andCreditsEndIntegralLessThan(Integer value) {
			addCriterion("Credits_End_Integral <", value, "creditsEndIntegral");
			return (Criteria) this;
		}

		public Criteria andCreditsEndIntegralLessThanOrEqualTo(Integer value) {
			addCriterion("Credits_End_Integral <=", value, "creditsEndIntegral");
			return (Criteria) this;
		}

		public Criteria andCreditsEndIntegralIn(List<Integer> values) {
			addCriterion("Credits_End_Integral in", values,
					"creditsEndIntegral");
			return (Criteria) this;
		}

		public Criteria andCreditsEndIntegralNotIn(List<Integer> values) {
			addCriterion("Credits_End_Integral not in", values,
					"creditsEndIntegral");
			return (Criteria) this;
		}

		public Criteria andCreditsEndIntegralBetween(Integer value1,
				Integer value2) {
			addCriterion("Credits_End_Integral between", value1, value2,
					"creditsEndIntegral");
			return (Criteria) this;
		}

		public Criteria andCreditsEndIntegralNotBetween(Integer value1,
				Integer value2) {
			addCriterion("Credits_End_Integral not between", value1, value2,
					"creditsEndIntegral");
			return (Criteria) this;
		}

		public Criteria andDiscountIsNull() {
			addCriterion("Discount is null");
			return (Criteria) this;
		}

		public Criteria andDiscountIsNotNull() {
			addCriterion("Discount is not null");
			return (Criteria) this;
		}

		public Criteria andDiscountEqualTo(String value) {
			addCriterion("Discount =", value, "discount");
			return (Criteria) this;
		}

		public Criteria andDiscountNotEqualTo(String value) {
			addCriterion("Discount <>", value, "discount");
			return (Criteria) this;
		}

		public Criteria andDiscountGreaterThan(String value) {
			addCriterion("Discount >", value, "discount");
			return (Criteria) this;
		}

		public Criteria andDiscountGreaterThanOrEqualTo(String value) {
			addCriterion("Discount >=", value, "discount");
			return (Criteria) this;
		}

		public Criteria andDiscountLessThan(String value) {
			addCriterion("Discount <", value, "discount");
			return (Criteria) this;
		}

		public Criteria andDiscountLessThanOrEqualTo(String value) {
			addCriterion("Discount <=", value, "discount");
			return (Criteria) this;
		}

		public Criteria andDiscountLike(String value) {
			addCriterion("Discount like", value, "discount");
			return (Criteria) this;
		}

		public Criteria andDiscountNotLike(String value) {
			addCriterion("Discount not like", value, "discount");
			return (Criteria) this;
		}

		public Criteria andDiscountIn(List<String> values) {
			addCriterion("Discount in", values, "discount");
			return (Criteria) this;
		}

		public Criteria andDiscountNotIn(List<String> values) {
			addCriterion("Discount not in", values, "discount");
			return (Criteria) this;
		}

		public Criteria andDiscountBetween(String value1, String value2) {
			addCriterion("Discount between", value1, value2, "discount");
			return (Criteria) this;
		}

		public Criteria andDiscountNotBetween(String value1, String value2) {
			addCriterion("Discount not between", value1, value2, "discount");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table t_credits_discount
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
     * This class corresponds to the database table t_credits_discount
     *
     * @mbggenerated do_not_delete_during_merge Mon Jun 22 20:32:47 CST 2015
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}