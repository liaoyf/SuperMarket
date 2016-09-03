package com.sm.mybatis.mb;

import com.sm.mybatis.mb.Stock;
import com.sm.mybatis.mb.StockExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface StockMapper {
	List<Stock> selectAllByStock(Map <String, Object> map);
	
	
	//段浩
		List<Stock> selectOnceByMap(Map <String, Object> map);
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_stock
     *
     * @mbggenerated Mon Jun 22 21:22:08 GMT+08:00 2015
     */
    int countByExample(StockExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_stock
     *
     * @mbggenerated Mon Jun 22 21:22:08 GMT+08:00 2015
     */
    int deleteByExample(StockExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_stock
     *
     * @mbggenerated Mon Jun 22 21:22:08 GMT+08:00 2015
     */
    int deleteByPrimaryKey(Integer stockId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_stock
     *
     * @mbggenerated Mon Jun 22 21:22:08 GMT+08:00 2015
     */
    int insert(Stock record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_stock
     *
     * @mbggenerated Mon Jun 22 21:22:08 GMT+08:00 2015
     */
    int insertSelective(Stock record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_stock
     *
     * @mbggenerated Mon Jun 22 21:22:08 GMT+08:00 2015
     */
    List<Stock> selectByExample(StockExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_stock
     *
     * @mbggenerated Mon Jun 22 21:22:08 GMT+08:00 2015
     */
    Stock selectByPrimaryKey(Integer stockId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_stock
     *
     * @mbggenerated Mon Jun 22 21:22:08 GMT+08:00 2015
     */
    int updateByExampleSelective(@Param("record") Stock record, @Param("example") StockExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_stock
     *
     * @mbggenerated Mon Jun 22 21:22:08 GMT+08:00 2015
     */
    int updateByExample(@Param("record") Stock record, @Param("example") StockExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_stock
     *
     * @mbggenerated Mon Jun 22 21:22:08 GMT+08:00 2015
     */
    int updateByPrimaryKeySelective(Stock record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_stock
     *
     * @mbggenerated Mon Jun 22 21:22:08 GMT+08:00 2015
     */
    int updateByPrimaryKey(Stock record);
}