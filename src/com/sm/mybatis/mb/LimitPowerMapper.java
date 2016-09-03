package com.sm.mybatis.mb;

import com.sm.mybatis.mb.LimitPower;
import  com.sm.mybatis.mb.LimitPowerExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface LimitPowerMapper {
	
	
	
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_limit_power
	 * @mbggenerated  Mon Jun 22 20:33:59 CST 2015
	 */
	int countByExample(LimitPowerExample example);
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_limit_power
	 * @mbggenerated  Mon Jun 22 20:33:59 CST 2015
	 */
	int deleteByExample(LimitPowerExample example);
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_limit_power
	 * @mbggenerated  Mon Jun 22 20:33:59 CST 2015
	 */
	int deleteByPrimaryKey(Integer lPId);
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_limit_power
	 * @mbggenerated  Mon Jun 22 20:33:59 CST 2015
	 */
	int insert(LimitPower record);
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_limit_power
	 * @mbggenerated  Mon Jun 22 20:33:59 CST 2015
	 */
	int insertSelective(LimitPower record);
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_limit_power
	 * @mbggenerated  Mon Jun 22 20:33:59 CST 2015
	 */
	List<LimitPower> selectByExample(LimitPowerExample example);
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_limit_power
	 * @mbggenerated  Mon Jun 22 20:33:59 CST 2015
	 */
	LimitPower selectByPrimaryKey(Integer lPId);
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_limit_power
	 * @mbggenerated  Mon Jun 22 20:33:59 CST 2015
	 */
	int updateByExampleSelective(@Param("record") LimitPower record,
			@Param("example") LimitPowerExample example);
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_limit_power
	 * @mbggenerated  Mon Jun 22 20:33:59 CST 2015
	 */
	int updateByExample(@Param("record") LimitPower record,
			@Param("example") LimitPowerExample example);
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_limit_power
	 * @mbggenerated  Mon Jun 22 20:33:59 CST 2015
	 */
	int updateByPrimaryKeySelective(LimitPower record);
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_limit_power
	 * @mbggenerated  Mon Jun 22 20:33:59 CST 2015
	 */
	int updateByPrimaryKey(LimitPower record);
	List<LimitPower> selectAllByLimit(Map <String, Object> map);

}