package com.qf.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.qf.bean.Shoppes;
import com.qf.dao.ShoppesMapper;
import com.qf.service.ShoppesService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 别闹！学习呢！
 */
@Service
public class ShoppesServiceImpl implements ShoppesService {

    @Resource
    private ShoppesMapper shoppesMapper;
    @Override
    public int deleteByPrimaryKey(Integer shopid) {
        return 0;
    }

    @Override
    public int insert(Shoppes record) {
        return 0;
    }

    @Override
    public int insertSelective(Shoppes record) {
        return 0;
    }

    @Override
    public Shoppes selectByPrimaryKey(Integer shopid) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Shoppes record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Shoppes record) {
        return 0;
    }


}
