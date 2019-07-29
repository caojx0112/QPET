package com.qf.bean;

public class Orderdetail {
    private Integer deatilid;

    private String oederid;

    private Integer shopid;

    private Integer shopnum;

    private Shoppes shoppes;

    private Orders orders;

    public Shoppes getShoppes() {
        return shoppes;
    }

    public void setShoppes(Shoppes shoppes) {
        this.shoppes = shoppes;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public Integer getDeatilid() {
        return deatilid;
    }

    public void setDeatilid(Integer deatilid) {
        this.deatilid = deatilid;
    }

    public String getOederid() {
        return oederid;
    }

    public void setOederid(String oederid) {
        this.oederid = oederid == null ? null : oederid.trim();
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
}