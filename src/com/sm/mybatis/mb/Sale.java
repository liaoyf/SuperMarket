package com.sm.mybatis.mb;

import java.util.Date;

public class Sale {
	
private Staff staff;
	
	private Vip vip;
	
    public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public Vip getVip() {
		return vip;
	}

	public void setVip(Vip vip) {
		this.vip = vip;
	}

	/**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sale.Sale_ID
     *
     * @mbggenerated Tue Jun 30 10:38:24 CST 2015
     */
    private Integer saleId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sale.Sale_Num
     *
     * @mbggenerated Tue Jun 30 10:38:24 CST 2015
     */
    private Float saleNum;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sale.Sale_Time
     *
     * @mbggenerated Tue Jun 30 10:38:24 CST 2015
     */
    private Date saleTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sale.Vip_Id
     *
     * @mbggenerated Tue Jun 30 10:38:24 CST 2015
     */
    private Integer vipId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sale.Staff_ID
     *
     * @mbggenerated Tue Jun 30 10:38:24 CST 2015
     */
    private Integer staffId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sale.Sale_ID
     *
     * @return the value of t_sale.Sale_ID
     *
     * @mbggenerated Tue Jun 30 10:38:24 CST 2015
     */
    public Integer getSaleId() {
        return saleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sale.Sale_ID
     *
     * @param saleId the value for t_sale.Sale_ID
     *
     * @mbggenerated Tue Jun 30 10:38:24 CST 2015
     */
    public void setSaleId(Integer saleId) {
        this.saleId = saleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sale.Sale_Num
     *
     * @return the value of t_sale.Sale_Num
     *
     * @mbggenerated Tue Jun 30 10:38:24 CST 2015
     */
    public Float getSaleNum() {
        return saleNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sale.Sale_Num
     *
     * @param saleNum the value for t_sale.Sale_Num
     *
     * @mbggenerated Tue Jun 30 10:38:24 CST 2015
     */
    public void setSaleNum(Float saleNum) {
        this.saleNum = saleNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sale.Sale_Time
     *
     * @return the value of t_sale.Sale_Time
     *
     * @mbggenerated Tue Jun 30 10:38:24 CST 2015
     */
    public Date getSaleTime() {
        return saleTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sale.Sale_Time
     *
     * @param saleTime the value for t_sale.Sale_Time
     *
     * @mbggenerated Tue Jun 30 10:38:24 CST 2015
     */
    public void setSaleTime(Date saleTime) {
        this.saleTime = saleTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sale.Vip_Id
     *
     * @return the value of t_sale.Vip_Id
     *
     * @mbggenerated Tue Jun 30 10:38:24 CST 2015
     */
    public Integer getVipId() {
        return vipId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sale.Vip_Id
     *
     * @param vipId the value for t_sale.Vip_Id
     *
     * @mbggenerated Tue Jun 30 10:38:24 CST 2015
     */
    public void setVipId(Integer vipId) {
        this.vipId = vipId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sale.Staff_ID
     *
     * @return the value of t_sale.Staff_ID
     *
     * @mbggenerated Tue Jun 30 10:38:24 CST 2015
     */
    public Integer getStaffId() {
        return staffId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sale.Staff_ID
     *
     * @param staffId the value for t_sale.Staff_ID
     *
     * @mbggenerated Tue Jun 30 10:38:24 CST 2015
     */
    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }
}