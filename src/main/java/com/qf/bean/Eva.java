package com.qf.bean;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Eva {
private int userid;
private String nickname;
private String[] evaluateimage;
private String content;
private Date createtime;
private int starlevel;

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String[] getEvaluateimage() {
        return evaluateimage;
    }

    public void setEvaluateimage(String[] evaluateimage) {
        this.evaluateimage = evaluateimage;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public int getStarlevel() {
        return starlevel;
    }

    public void setStarlevel(int starlevel) {
        this.starlevel = starlevel;
    }
}