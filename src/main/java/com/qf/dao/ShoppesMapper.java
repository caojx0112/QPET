package com.qf.dao;

import com.qf.bean.Shoppes;

public interface ShoppesMapper {
    Shoppes findById(int shopid);

    int deleteByPrimaryKey(Integer shopid);

    int insert(Shoppes record);

    int insertSelective(Shoppes record);

    Shoppes selectByPrimaryKey(Integer shopid);

    int updateByPrimaryKeySelective(Shoppes record);

    int updateByPrimaryKey(Shoppes record);
}