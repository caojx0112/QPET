package com.qf.dao;

import com.qf.bean.Shoptypes;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShoptypesMapper {
    int deleteByPrimaryKey(Integer typeid);

    int insert(Shoptypes record);

    int insertSelective(Shoptypes record);

    Shoptypes selectByPrimaryKey(Integer typeid);

    int updateByPrimaryKeySelective(Shoptypes record);

    int updateByPrimaryKey(Shoptypes record);


    //后台页面商品分类
    List<Shoptypes> pet();

}