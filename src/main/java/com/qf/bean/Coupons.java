package com.qf.bean;

import java.util.Date;
import java.util.List;

public class Coupons {
    private Integer couponsid;

    private String couponsname;

    private Double couponsmoney;

    private Double couponsrental;

    private Integer couponsstatus;

    private String couponsimage;

    private Date begintime;

    private Date endtime;


    private List<UsersCoupons> usersCouponsList;

    public List<UsersCoupons> getUsersCouponsList() {
        return usersCouponsList;
    }

    public void setUsersCouponsList(List<UsersCoupons> usersCouponsList) {
        this.usersCouponsList = usersCouponsList;
    }

    public Integer getCouponsid() {
        return couponsid;
    }

    public void setCouponsid(Integer couponsid) {
        this.couponsid = couponsid;
    }

    public String getCouponsname() {
        return couponsname;
    }

    public void setCouponsname(String couponsname) {
        this.couponsname = couponsname == null ? null : couponsname.trim();
    }

    public Double getCouponsmoney() {
        return couponsmoney;
    }

    public void setCouponsmoney(Double couponsmoney) {
        this.couponsmoney = couponsmoney;
    }

    public Double getCouponsrental() {
        return couponsrental;
    }

    public void setCouponsrental(Double couponsrental) {
        this.couponsrental = couponsrental;
    }

    public Integer getCouponsstatus() {
        return couponsstatus;
    }

    public void setCouponsstatus(Integer couponsstatus) {
        this.couponsstatus = couponsstatus;
    }

    public String getCouponsimage() {
        return couponsimage;
    }

    public void setCouponsimage(String couponsimage) {
        this.couponsimage = couponsimage == null ? null : couponsimage.trim();
    }

    public Date getBegintime() {
        return begintime;
    }

    public void setBegintime(Date begintime) {
        this.begintime = begintime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }
}