package com.qf.dao;

import com.qf.bean.Specification;

import java.util.List;

public interface SpecificationMapper {

    List findAll(int shopid);

    int deleteByPrimaryKey(Integer id);

    int insert(Specification record);

    int insertSelective(Specification record);

    Specification selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Specification record);

    int updateByPrimaryKey(Specification record);
}