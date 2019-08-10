package com.qf.service;

import com.qf.bean.Shopaddress;

import java.util.List;

public interface ShopaddressService {

    Shopaddress selectByPrimaryKey(int addressid);

    int deleteByPrimaryKey(Integer addressid);

    int insert(Shopaddress record);

    int insertSelective(Shopaddress record);


    int updateByPrimaryKeySelective(Shopaddress record);

    int updateByPrimaryKey(Shopaddress record);
    public List<Shopaddress> selectAdderssByuserid(int userid);

}