package com.qf.service;

import com.qf.bean.Evaluates;

public interface EvaluatesService {
    int deleteByPrimaryKey(Integer evaluateid);

    int insert(Evaluates record);

    int insertSelective(Evaluates record);

    Evaluates selectByPrimaryKey(Integer evaluateid);

    int updateByPrimaryKeySelective(Evaluates record);

    int updateByPrimaryKey(Evaluates record);
    //查看评价数量
    int evaluatecount(Integer userid);
}