package com.qf.dao;

import com.qf.bean.Shopdetail;

public interface ShopdetailMapper {
    int deleteByPrimaryKey(Integer shopdeatilid);

    int insert(Shopdetail record);

    int insertSelective(Shopdetail record);

    Shopdetail selectByPrimaryKey(Integer shopdeatilid);

    int updateByPrimaryKeySelective(Shopdetail record);

    int updateByPrimaryKey(Shopdetail record);
}