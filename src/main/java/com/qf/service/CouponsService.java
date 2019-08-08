package com.qf.service;

import com.qf.bean.Coupons;

import java.util.List;

public interface CouponsService {
    int deleteByPrimaryKey(Integer couponsid);

    int insert(Coupons record);

    int insertSelective(Coupons record);

    Coupons selectByPrimaryKey(Integer couponsid);

    int updateByPrimaryKeySelective(Coupons record);

    int updateByPrimaryKey(Coupons record);

    List<Coupons> selectCoupons(Integer userid);

}