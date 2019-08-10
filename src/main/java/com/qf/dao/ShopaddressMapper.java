package com.qf.dao;

import com.qf.bean.Shopaddress;

public interface ShopaddressMapper {
    int deleteByPrimaryKey(Integer addressid);

    int insert(Shopaddress record);

    int insertSelective(Shopaddress record);

    Shopaddress selectByPrimaryKey(Integer addressid);

    int updateByPrimaryKeySelective(Shopaddress record);

    int updateByPrimaryKey(Shopaddress record);
}