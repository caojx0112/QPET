package com.qf.bean;

import java.util.Date;
import java.util.List;

public class Shoptypes {
    private Integer typeid;

    private String typename;

    private Integer type;

    private Date createtime;

    private Date updatetime;

    private List<Shoppes> shoppesList;

    public List<Shoppes> getShoppesList() {
        return shoppesList;
    }

    public void setShoppesList(List<Shoppes> shoppesList) {
        this.shoppesList = shoppesList;
    }

    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename == null ? null : typename.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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
}