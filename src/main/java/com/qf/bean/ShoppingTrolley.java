package com.qf.bean;

import java.util.Date;

public class ShoppingTrolley {
    private Integer shopcard;

    private Integer userid;

    private Integer trolleyrstatus;

    private Date createtime;

    private Date updatetime;

    private Integer shopid;

    private Integer shopnum;

    private Double shopmoney;

    private Integer specification;

    private Shoppes shoppes;

    public Shoppes getShoppes() {
        return shoppes;
    }

    public void setShoppes(Shoppes shoppes) {
        this.shoppes = shoppes;
    }

    public Integer getSpecification() {
        return specification;
    }

    public void setSpecification(Integer specification) {
        this.specification = specification;
    }

    public Integer getShopcard() {
        return shopcard;
    }

    public void setShopcard(Integer shopcard) {
        this.shopcard = shopcard;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getTrolleyrstatus() {
        return trolleyrstatus;
    }

    public void setTrolleyrstatus(Integer trolleyrstatus) {
        this.trolleyrstatus = trolleyrstatus;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public Integer getShopid() {
        return shopid;
    }

    public void setShopid(Integer shopid) {
        this.shopid = shopid;
    }

    public Integer getShopnum() {
        return shopnum;
    }

    public void setShopnum(Integer shopnum) {
        this.shopnum = shopnum;
    }

    public Double getShopmoney() {
        return shopmoney;
    }

    public void setShopmoney(Double shopmoney) {
        this.shopmoney = shopmoney;
    }
}