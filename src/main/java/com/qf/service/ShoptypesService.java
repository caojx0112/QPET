package com.qf.service;

import com.qf.bean.Shoptypes;

import java.util.List;


public interface ShoptypesService {
    int deleteByPrimaryKey(Integer typeid);

    int insert(Shoptypes record);

    int insertSelective(Shoptypes record);

    Shoptypes selectByPrimaryKey(Integer typeid);

    int updateByPrimaryKeySelective(Shoptypes record);

    int updateByPrimaryKey(Shoptypes record);

    //后台页面商品分类
    List<Shoptypes> pet();
    //
    List<Shoptypes> findbytype(Integer type);
}