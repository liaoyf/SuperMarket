package com.sm.mybatis.mb;

public class Stock {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_stock.Stock_ID
     *
     * @mbggenerated Mon Jun 22 21:22:08 GMT+08:00 2015
     */
    private Integer stockId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_stock.Stock_Name
     *
     * @mbggenerated Mon Jun 22 21:22:08 GMT+08:00 2015
     */
    private String stockName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_stock.Stock_Volume
     *
     * @mbggenerated Mon Jun 22 21:22:08 GMT+08:00 2015
     */
    private Integer stockVolume;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_stock.Stock_ID
     *
     * @return the value of t_stock.Stock_ID
     *
     * @mbggenerated Mon Jun 22 21:22:08 GMT+08:00 2015
     */
    public Integer getStockId() {
        return stockId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_stock.Stock_ID
     *
     * @param stockId the value for t_stock.Stock_ID
     *
     * @mbggenerated Mon Jun 22 21:22:08 GMT+08:00 2015
     */
    public void setStockId(Integer stockId) {
        this.stockId = stockId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_stock.Stock_Name
     *
     * @return the value of t_stock.Stock_Name
     *
     * @mbggenerated Mon Jun 22 21:22:08 GMT+08:00 2015
     */
    public String getStockName() {
        return stockName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_stock.Stock_Name
     *
     * @param stockName the value for t_stock.Stock_Name
     *
     * @mbggenerated Mon Jun 22 21:22:08 GMT+08:00 2015
     */
    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_stock.Stock_Volume
     *
     * @return the value of t_stock.Stock_Volume
     *
     * @mbggenerated Mon Jun 22 21:22:08 GMT+08:00 2015
     */
    public Integer getStockVolume() {
        return stockVolume;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_stock.Stock_Volume
     *
     * @param stockVolume the value for t_stock.Stock_Volume
     *
     * @mbggenerated Mon Jun 22 21:22:08 GMT+08:00 2015
     */
    public void setStockVolume(Integer stockVolume) {
        this.stockVolume = stockVolume;
    }
}