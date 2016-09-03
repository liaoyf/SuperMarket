package com.sm.mybatis.mb;

import com.sm.mybatis.mb.LPRoleExample;
import com.sm.mybatis.mb.LPRoleKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LPRoleMapper {
	
	
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_lpower_role
	 * @mbggenerated  Mon Jun 22 20:33:59 CST 2015
	 */
	int countByExample(LPRoleExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_lpower_role
	 * @mbggenerated  Mon Jun 22 20:33:59 CST 2015
	 */
	int deleteByExample(LPRoleExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_lpower_role
	 * @mbggenerated  Mon Jun 22 20:33:59 CST 2015
	 */
	int deleteByPrimaryKey(LPRoleKey key);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_lpower_role
	 * @mbggenerated  Mon Jun 22 20:33:59 CST 2015
	 */
	int insert(LPRoleKey record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_lpower_role
	 * @mbggenerated  Mon Jun 22 20:33:59 CST 2015
	 */
	int insertSelective(LPRoleKey record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_lpower_role
	 * @mbggenerated  Mon Jun 22 20:33:59 CST 2015
	 */
	List<LPRoleKey> selectByExample(LPRoleExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_lpower_role
	 * @mbggenerated  Mon Jun 22 20:33:59 CST 2015
	 */
	int updateByExampleSelective(@Param("record") LPRoleKey record,
			@Param("example") LPRoleExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_lpower_role
	 * @mbggenerated  Mon Jun 22 20:33:59 CST 2015
	 */
	int updateByExample(@Param("record") LPRoleKey record,
			@Param("example") LPRoleExample example);

	List<LPRoleKey>selectPByRole(Integer roleId);
}