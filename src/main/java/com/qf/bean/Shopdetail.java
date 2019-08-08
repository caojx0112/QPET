package com.qf.bean;

public class Shopdetail {
    private Integer shopdeatilid;

    private String detailimages;

    private Integer shopid;

    public Integer getShopdeatilid() {
        return shopdeatilid;
    }

    public void setShopdeatilid(Integer shopdeatilid) {
        this.shopdeatilid = shopdeatilid;
    }

    public String getDetailimages() {
        return detailimages;
    }

    public void setDetailimages(String detailimages) {
        this.detailimages = detailimages == null ? null : detailimages.trim();
    }

    public Integer getShopid() {
        return shopid;
    }

    public void setShopid(Integer shopid) {
        this.shopid = shopid;
    }
}