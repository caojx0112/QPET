package com.qf.bean;

import java.util.Date;

public class Evaluates {
    private Integer evaluateid;

    private Integer shopid;

    private Integer userid;

    private String evaluateimage;

    private String content;

    private Date createtime;

    private Integer starlevel;

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
}