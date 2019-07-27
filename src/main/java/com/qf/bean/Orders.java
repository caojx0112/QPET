package com.qf.bean;

import java.util.Date;

public class Orders {
    private Integer orderid;

    private Integer addressid;

    private Integer userid;

    private Integer couponsid;

    private Integer emoney;

    private Double orderamount;

    private Integer orderstatus;

    private Integer paystatus;

    private String orderdesc;

    private Date createtime;

    private Date expirationtime;

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public Integer getAddressid() {
        return addressid;
    }

    public void setAddressid(Integer addressid) {
        this.addressid = addressid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getCouponsid() {
        return couponsid;
    }

    public void setCouponsid(Integer couponsid) {
        this.couponsid = couponsid;
    }

    public Integer getEmoney() {
        return emoney;
    }

    public void setEmoney(Integer emoney) {
        this.emoney = emoney;
    }

    public Double getOrderamount() {
        return orderamount;
    }

    public void setOrderamount(Double orderamount) {
        this.orderamount = orderamount;
    }

    public Integer getOrderstatus() {
        return orderstatus;
    }

    public void setOrderstatus(Integer orderstatus) {
        this.orderstatus = orderstatus;
    }

    public Integer getPaystatus() {
        return paystatus;
    }

    public void setPaystatus(Integer paystatus) {
        this.paystatus = paystatus;
    }

    public String getOrderdesc() {
        return orderdesc;
    }

    public void setOrderdesc(String orderdesc) {
        this.orderdesc = orderdesc == null ? null : orderdesc.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getExpirationtime() {
        return expirationtime;
    }

    public void setExpirationtime(Date expirationtime) {
        this.expirationtime = expirationtime;
    }
}