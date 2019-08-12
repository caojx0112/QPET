package com.qf.bean;
//商品规格
public class Specification {
    private Integer id;

    private Integer shopid;

    private String shopwegiht;

    private Integer shopnum;

    private Integer spestatus;

    private Double shopmoney;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getShopid() {
        return shopid;
    }

    public void setShopid(Integer shopid) {
        this.shopid = shopid;
    }

    public String getShopwegiht() {
        return shopwegiht;
    }

    public void setShopwegiht(String shopwegiht) {
        this.shopwegiht = shopwegiht == null ? null : shopwegiht.trim();
    }

    public Integer getShopnum() {
        return shopnum;
    }

    public void setShopnum(Integer shopnum) {
        this.shopnum = shopnum;
    }

    public Integer getSpestatus() {
        return spestatus;
    }

    public void setSpestatus(Integer spestatus) {
        this.spestatus = spestatus;
    }

    public Double getShopmoney() {
        return shopmoney;
    }

    public void setShopmoney(Double shopmoney) {
        this.shopmoney = shopmoney;
    }



    private Shoppes shoppes;

    public Shoppes getShoppes() {
        return shoppes;
    }

    public void setShoppes(Shoppes shoppes) {
        this.shoppes = shoppes;
    }
}