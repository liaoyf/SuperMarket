package com.sm.mybatis.mb;

import java.util.Date;

public class GoodsStock {
	
	private Stock stock;
	private Goods goods;
	
    public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	/**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_goods_stock.Goods_Stock_ID
     *
     * @mbggenerated Tue Jun 30 10:38:24 CST 2015
     */
    private Integer goodsStockId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_goods_stock.Goods_ID
     *
     * @mbggenerated Tue Jun 30 10:38:24 CST 2015
     */
    private Integer goodsId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_goods_stock.Stock_ID
     *
     * @mbggenerated Tue Jun 30 10:38:24 CST 2015
     */
    private Integer stockId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_goods_stock.Goods_Num
     *
     * @mbggenerated Tue Jun 30 10:38:24 CST 2015
     */
    private Integer goodsNum;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_goods_stock.Change_Time
     *
     * @mbggenerated Tue Jun 30 10:38:24 CST 2015
     */
    private Date changeTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_goods_stock.Goods_Stock_ID
     *
     * @return the value of t_goods_stock.Goods_Stock_ID
     *
     * @mbggenerated Tue Jun 30 10:38:24 CST 2015
     */
    public Integer getGoodsStockId() {
        return goodsStockId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_goods_stock.Goods_Stock_ID
     *
     * @param goodsStockId the value for t_goods_stock.Goods_Stock_ID
     *
     * @mbggenerated Tue Jun 30 10:38:24 CST 2015
     */
    public void setGoodsStockId(Integer goodsStockId) {
        this.goodsStockId = goodsStockId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_goods_stock.Goods_ID
     *
     * @return the value of t_goods_stock.Goods_ID
     *
     * @mbggenerated Tue Jun 30 10:38:24 CST 2015
     */
    public Integer getGoodsId() {
        return goodsId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_goods_stock.Goods_ID
     *
     * @param goodsId the value for t_goods_stock.Goods_ID
     *
     * @mbggenerated Tue Jun 30 10:38:24 CST 2015
     */
    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_goods_stock.Stock_ID
     *
     * @return the value of t_goods_stock.Stock_ID
     *
     * @mbggenerated Tue Jun 30 10:38:24 CST 2015
     */
    public Integer getStockId() {
        return stockId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_goods_stock.Stock_ID
     *
     * @param stockId the value for t_goods_stock.Stock_ID
     *
     * @mbggenerated Tue Jun 30 10:38:24 CST 2015
     */
    public void setStockId(Integer stockId) {
        this.stockId = stockId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_goods_stock.Goods_Num
     *
     * @return the value of t_goods_stock.Goods_Num
     *
     * @mbggenerated Tue Jun 30 10:38:24 CST 2015
     */
    public Integer getGoodsNum() {
        return goodsNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_goods_stock.Goods_Num
     *
     * @param goodsNum the value for t_goods_stock.Goods_Num
     *
     * @mbggenerated Tue Jun 30 10:38:24 CST 2015
     */
    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_goods_stock.Change_Time
     *
     * @return the value of t_goods_stock.Change_Time
     *
     * @mbggenerated Tue Jun 30 10:38:24 CST 2015
     */
    public Date getChangeTime() {
        return changeTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_goods_stock.Change_Time
     *
     * @param changeTime the value for t_goods_stock.Change_Time
     *
     * @mbggenerated Tue Jun 30 10:38:24 CST 2015
     */
    public void setChangeTime(Date changeTime) {
        this.changeTime = changeTime;
    }
}