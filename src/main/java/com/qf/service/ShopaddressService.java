package com.qf.service;

import com.qf.bean.Shopaddress;

import java.util.List;

public interface ShopaddressService {

    public List<Shopaddress> selectByPrimaryKey(int userid);

    int deleteByPrimaryKey(Integer addressid);

    int insert(Shopaddress record);

    int insertSelective(Shopaddress record);


    int updateByPrimaryKeySelective(Shopaddress record);

    int updateByPrimaryKey(Shopaddress record);
}