package com.qf.service.impl;

import com.qf.bean.Coupons;
import com.qf.dao.CouponsMapper;
import com.qf.service.CouponsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 别闹！学习呢！
 */
@Service
public class CouponsServiceImpl implements CouponsService {
    @Resource
    private CouponsMapper couponsMapper;
    @Override
    public int deleteByPrimaryKey(Integer couponsid) {
        return 0;
    }

    @Override
    public int insert(Coupons record) {
        return 0;
    }

    @Override
    public int insertSelective(Coupons record) {
        return 0;
    }

    @Override
    public Coupons selectByPrimaryKey(Integer couponsid) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Coupons record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Coupons record) {
        return 0;
    }

    @Override
    public List<Coupons> selectCoupons(Integer userid) {
        return couponsMapper.selectCoupons(userid);
    }
}
