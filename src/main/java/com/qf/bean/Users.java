package com.qf.bean;

import java.util.Date;
import java.util.List;

public class Users {
    private Integer userid;

    private String username;

    private String nickname;

    private String password;

    private String userimages;

    private String usersex;

    private Date birthday;

    private Integer emoney;

    private Integer userstatus;

    private Integer addressid;

    private Date createtime;

    private Date updatetime;

    private List<Evaluates>evaluates;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getUserimages() {
        return userimages;
    }

    public void setUserimages(String userimages) {
        this.userimages = userimages == null ? null : userimages.trim();
    }

    public String getUsersex() {
        return usersex;
    }

    public void setUsersex(String usersex) {
        this.usersex = usersex == null ? null : usersex.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getEmoney() {
        return emoney;
    }

    public void setEmoney(Integer emoney) {
        this.emoney = emoney;
    }

    public Integer getUserstatus() {
        return userstatus;
    }

    public void setUserstatus(Integer userstatus) {
        this.userstatus = userstatus;
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

    public Integer getAddressid() {
        return addressid;
    }

    public void setAddressid(Integer addressid) {
        this.addressid = addressid;
    }

    public List<Evaluates> getEvaluates() {
        return evaluates;
    }

    public void setEvaluates(List<Evaluates> evaluates) {
        this.evaluates = evaluates;
    }
}