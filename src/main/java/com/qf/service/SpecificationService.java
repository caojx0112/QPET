package com.qf.service;

import com.qf.bean.Specification;

import java.util.List;

public interface SpecificationService {
    List findAll();

    int deleteByPrimaryKey(Integer id);

    int insert(Specification record);

    int insertSelective(Specification record);

    Specification selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Specification record);

    int updateByPrimaryKey(Specification record);
}