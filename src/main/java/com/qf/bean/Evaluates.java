package com.qf.bean;

import java.util.Date;
import java.util.List;

public class Evaluates {
    private Integer evaluateid;

    private Integer shopid;

    private Integer userid;

    private String evaluateimage;

    private String content;

    private Date createtime;

    private Integer starlevel;

    private Users users;

    private Shoppes shoppes;

    private Shopdetail shopdetails;

    private List<Evaluates> evaluates;

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Integer getStarlevel() {
        return starlevel;
    }

    public void setStarlevel(Integer starlevel) {
        this.starlevel = starlevel;
    }

    public Integer getEvaluateid() {
        return evaluateid;
    }

    public void setEvaluateid(Integer evaluateid) {
        this.evaluateid = evaluateid;
    }

    public Integer getShopid() {
        return shopid;
    }

    public void setShopid(Integer shopid) {
        this.shopid = shopid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getEvaluateimage() {
        return evaluateimage;
    }

    public void setEvaluateimage(String evaluateimage) {
        this.evaluateimage = evaluateimage == null ? null : evaluateimage.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Shoppes getShoppes() {
        return shoppes;
    }

    public void setShoppes(Shoppes shoppes) {
        this.shoppes = shoppes;
    }

    public Shopdetail getShopdetails() {
        return shopdetails;
    }

    public void setShopdetails(Shopdetail shopdetails) {
        this.shopdetails = shopdetails;
    }

    public List<Evaluates> getEvaluates() {
        return evaluates;
    }

    public void setEvaluates(List<Evaluates> evaluates) {
        this.evaluates = evaluates;
    }
}