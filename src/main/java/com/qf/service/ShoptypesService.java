package com.qf.service;

import com.qf.bean.Shoptypes;


public interface ShoptypesService {
    int deleteByPrimaryKey(Integer typeid);

    int insert(Shoptypes record);

    int insertSelective(Shoptypes record);

    Shoptypes selectByPrimaryKey(Integer typeid);

    int updateByPrimaryKeySelective(Shoptypes record);

    int updateByPrimaryKey(Shoptypes record);
}