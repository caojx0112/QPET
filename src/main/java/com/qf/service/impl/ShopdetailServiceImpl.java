package com.qf.service.impl;

import com.qf.bean.Shopdetail;
import com.qf.dao.ShopdetailMapper;
import com.qf.service.ShopdetailService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ShopdetailServiceImpl implements ShopdetailService {

    @Resource
    private ShopdetailMapper shopdetailMapper;
    @Override
    public Shopdetail findItemimag(int id) {
        return shopdetailMapper.findItemimag(id);
    }

    @Override
    public int deleteByPrimaryKey(Integer shopdeatilid) {
        return 0;
    }

    @Override
    public int insert(Shopdetail record) {
        return 0;
    }

    @Override
    public int insertSelective(Shopdetail record) {
        return 0;
    }

    @Override
    public Shopdetail selectByPrimaryKey(Integer shopdeatilid) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Shopdetail record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Shopdetail record) {
        return 0;
    }
}
