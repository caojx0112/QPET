package com.qf.bean;

import java.util.Date;
import java.util.List;

public class Shoppes {
    private List evaluateimage;

    private List evaluates;

    private List specification;

    private Integer shopid;

    private String shopname;

    private Integer type;

    private Integer typeid;

    private Integer shopnum;

    private Integer shopsales;

    private Double oldprice;

    private Double newprice;

    private String shopimage;

    private String content;

    private Integer shopstatus;

    private Integer emoney;

    private String petbodily;

    private String woollength;

    private String pettype;

    private String petcolor;

    private Integer petblood;

    private Integer petclean;

    private Integer petvideo;

    private String recipe;

    private Integer suitableage;

    private Date createtime;

    private Date putawaytime;

    private String shopweight;  //商品规格

    private String feedback;

    private Integer evaluatescount;

    public String getShopweight() {
        return shopweight;
    }

    public void setShopweight(String shopweight) {
        this.shopweight = shopweight;
    }

    public Integer getShopid() {
        return shopid;
    }

    public void setShopid(Integer shopid) {
        this.shopid = shopid;
    }

    public String getShopname() {
        return shopname;
    }

    public void setShopname(String shopname) {
        this.shopname = shopname == null ? null : shopname.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    public Integer getShopnum() {
        return shopnum;
    }

    public void setShopnum(Integer shopnum) {
        this.shopnum = shopnum;
    }

    public Integer getShopsales() {
        return shopsales;
    }

    public void setShopsales(Integer shopsales) {
        this.shopsales = shopsales;
    }

    public Double getOldprice() {
        return oldprice;
    }

    public void setOldprice(Double oldprice) {
        this.oldprice = oldprice;
    }

    public Double getNewprice() {
        return newprice;
    }

    public void setNewprice(Double newprice) {
        this.newprice = newprice;
    }

    public String getShopimage() {
        return shopimage;
    }

    public void setShopimage(String shopimage) {
        this.shopimage = shopimage == null ? null : shopimage.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getShopstatus() {
        return shopstatus;
    }

    public void setShopstatus(Integer shopstatus) {
        this.shopstatus = shopstatus;
    }

    public Integer getEmoney() {
        return emoney;
    }

    public void setEmoney(Integer emoney) {
        this.emoney = emoney;
    }

    public String getPetbodily() {
        return petbodily;
    }

    public void setPetbodily(String petbodily) {
        this.petbodily = petbodily == null ? null : petbodily.trim();
    }

    public String getWoollength() {
        return woollength;
    }

    public void setWoollength(String woollength) {
        this.woollength = woollength == null ? null : woollength.trim();
    }

    public String getPettype() {
        return pettype;
    }

    public void setPettype(String pettype) {
        this.pettype = pettype == null ? null : pettype.trim();
    }

    public String getPetcolor() {
        return petcolor;
    }

    public void setPetcolor(String petcolor) {
        this.petcolor = petcolor == null ? null : petcolor.trim();
    }

    public Integer getPetblood() {
        return petblood;
    }

    public void setPetblood(Integer petblood) {
        this.petblood = petblood;
    }

    public Integer getPetclean() {
        return petclean;
    }

    public void setPetclean(Integer petclean) {
        this.petclean = petclean;
    }

    public Integer getPetvideo() {
        return petvideo;
    }

    public void setPetvideo(Integer petvideo) {
        this.petvideo = petvideo;
    }

    public String getRecipe() {
        return recipe;
    }

    public void setRecipe(String recipe) {
        this.recipe = recipe == null ? null : recipe.trim();
    }

    public Integer getSuitableage() {
        return suitableage;
    }

    public void setSuitableage(Integer suitableage) {
        this.suitableage = suitableage;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getPutawaytime() {
        return putawaytime;
    }

    public void setPutawaytime(Date putawaytime) {
        this.putawaytime = putawaytime;
    }

    public List getEvaluateimage() {
        return evaluateimage;
    }

    public void setEvaluateimage(List evaluateimage) {
        this.evaluateimage = evaluateimage;
    }

    public List getEvaluates() {
        return evaluates;
    }

    public void setEvaluates(List evaluates) {
        this.evaluates = evaluates;
    }

    public List getSpecification() {
        return specification;
    }

    public void setSpecification(List specification) {
        this.specification = specification;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public Integer getEvaluatescount() {
        return evaluatescount;
    }

    public void setEvaluatescount(Integer evaluatescount) {
        this.evaluatescount = evaluatescount;
    }
}