package com.qf.bean;

import java.util.List;

/**
 * ** 程序猿
 * 一入代码深似海，
 * 小试牛刀异常来。
 * 奈何BUG直挠耳，
 * 仰天大笑出门来。
 */
//订单列表返回类
public class OrdersList {
    private String orderid;
    private Double orderamount;
    private Integer orderstatus;
    private Integer ordercount; //商品数量
    List<Shoppes> shoppes;

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
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

    public Integer getOrdercount() {
        return ordercount;
    }

    public void setOrdercount(Integer ordercount) {
        this.ordercount = ordercount;
    }

    public List<Shoppes> getShoppes() {
        return shoppes;
    }

    public void setShoppes(List<Shoppes> shoppes) {
        this.shoppes = shoppes;
    }
}
