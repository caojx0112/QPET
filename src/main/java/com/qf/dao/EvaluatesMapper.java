package com.qf.dao;

import com.qf.bean.Evaluates;

public interface EvaluatesMapper {
    int deleteByPrimaryKey(Integer evaluateid);

    int insert(Evaluates record);

    int insertSelective(Evaluates record);

    Evaluates selectByPrimaryKey(Integer evaluateid);

    int updateByPrimaryKeySelective(Evaluates record);

    int updateByPrimaryKey(Evaluates record);
}