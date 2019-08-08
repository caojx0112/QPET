package com.qf.service;

import com.qf.bean.Shoppes;

import java.util.List;

public interface ShoppesService {
    int deleteByPrimaryKey(Integer shopid);

    int insert(Shoppes record);

    int insertSelective(Shoppes record);

    Shoppes selectByPrimaryKey(Integer shopid);

    int updateByPrimaryKeySelective(Shoppes record);

    int updateByPrimaryKey(Shoppes record);


}