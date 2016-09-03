package com.sm.mybatis.mb;

import com.sm.mybatis.mb.Vip;
import com.sm.mybatis.mb.VipExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface VipMapper {

	List<Vip> selectAllByVip(Map <String, Object> map);
	//自定义
	List<Vip> selectOnceByMap(Map <String, Object> map);
	
	int selectCountByVip(Map <String, Object> map);
	
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_vip
	 * @mbggenerated  Mon Jun 22 20:33:59 CST 2015
	 */
	int countByExample(VipExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_vip
	 * @mbggenerated  Mon Jun 22 20:33:59 CST 2015
	 */
	int deleteByExample(VipExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_vip
	 * @mbggenerated  Mon Jun 22 20:33:59 CST 2015
	 */
	int deleteByPrimaryKey(Integer vipId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_vip
	 * @mbggenerated  Mon Jun 22 20:33:59 CST 2015
	 */
	int insert(Vip record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_vip
	 * @mbggenerated  Mon Jun 22 20:33:59 CST 2015
	 */
	int insertSelective(Vip record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_vip
	 * @mbggenerated  Mon Jun 22 20:33:59 CST 2015
	 */
	List<Vip> selectByExample(VipExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_vip
	 * @mbggenerated  Mon Jun 22 20:33:59 CST 2015
	 */
	Vip selectByPrimaryKey(Integer vipId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_vip
	 * @mbggenerated  Mon Jun 22 20:33:59 CST 2015
	 */
	int updateByExampleSelective(@Param("record") Vip record,
			@Param("example") VipExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_vip
	 * @mbggenerated  Mon Jun 22 20:33:59 CST 2015
	 */
	int updateByExample(@Param("record") Vip record,
			@Param("example") VipExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_vip
	 * @mbggenerated  Mon Jun 22 20:33:59 CST 2015
	 */
	int updateByPrimaryKeySelective(Vip record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_vip
	 * @mbggenerated  Mon Jun 22 20:33:59 CST 2015
	 */
	int updateByPrimaryKey(Vip record);
}