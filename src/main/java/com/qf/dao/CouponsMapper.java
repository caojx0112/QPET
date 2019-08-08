package com.qf.dao;

import com.qf.bean.Coupons;

import java.util.List;

public interface CouponsMapper {
    int deleteByPrimaryKey(Integer couponsid);

    int insert(Coupons record);

    int insertSelective(Coupons record);

    Coupons selectByPrimaryKey(Integer couponsid);

    int updateByPrimaryKeySelective(Coupons record);

    int updateByPrimaryKey(Coupons record);
<<<<<<< HEAD

    List<Coupons> selectCoupons(Integer userid);
=======
>>>>>>> origin/master
}