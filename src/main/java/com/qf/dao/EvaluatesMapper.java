package com.qf.dao;

import com.qf.bean.Evaluates;

import java.util.List;

public interface EvaluatesMapper {
    int deleteByPrimaryKey(Integer evaluateid);

    int insert(Evaluates record);

    int insertSelective(Evaluates record);

    Evaluates selectByPrimaryKey(Integer evaluateid);

    int updateByPrimaryKeySelective(Evaluates record);

    int updateByPrimaryKey(Evaluates record);

    //查看评价数量
    int evaluatecount(Integer userid);

    int findStar(int shopid);

    int Count(int shopid);

    List findById(int shopid);
}