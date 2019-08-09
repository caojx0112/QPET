package com.qf.service.impl;

import com.qf.bean.Collect;
import com.qf.dao.CollectMapper;
import com.qf.service.CollectService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 别闹！学习呢！
 */
@Service
public class CollectServiceImpl implements CollectService {
    @Resource
    private CollectMapper collectMapper;
    @Override
    public int deleteByPrimaryKey(Integer collectid) {
        return 0;
    }

    @Override
    public int insert(Collect record) {
        return collectMapper.insert(record);
    }

    @Override
    public int insertSelective(Collect record) {
        return 0;
    }

    @Override
    public Collect selectByPrimaryKey(Integer collectid) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Collect record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Collect record) {
        return 0;
    }

    @Override
    public int collectcount(Integer userid) {
        return collectMapper.collectcount(userid);
    }
}
