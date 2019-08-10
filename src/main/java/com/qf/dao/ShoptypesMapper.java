package com.qf.dao;

import com.qf.bean.Shoptypes;

public interface ShoptypesMapper {
    int deleteByPrimaryKey(Integer typeid);

    int insert(Shoptypes record);

    int insertSelective(Shoptypes record);

    Shoptypes selectByPrimaryKey(Integer typeid);

    int updateByPrimaryKeySelective(Shoptypes record);

    int updateByPrimaryKey(Shoptypes record);
}