package com.qf.service.impl;

import com.qf.bean.Evaluates;
import com.qf.dao.EvaluatesMapper;
import com.qf.service.EvaluatesService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 别闹！学习呢！
 */
@Service
public class EvaluatesServiceImpl implements EvaluatesService {

    @Resource
    private EvaluatesMapper evaluatesMapper;
    @Override
    public int deleteByPrimaryKey(Integer evaluateid) {
        return 0;
    }

    @Override
    public int insert(Evaluates record) {
        return 0;
    }

    @Override
    public int insertSelective(Evaluates record) {
        return 0;
    }

    @Override
    public Evaluates selectByPrimaryKey(Integer evaluateid) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Evaluates record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Evaluates record) {
        return 0;
    }

    @Override
    public int evaluatecount(Integer userid) {
        return evaluatesMapper.evaluatecount(userid);
    }
}
