package com.qf.dao;

import com.qf.bean.UsersCoupons;

import java.util.Map;

public interface UsersCouponsMapper {
    UsersCoupons selectcouponsnum(Map map);

    int deleteByPrimaryKey(Integer ucouponsid);

    int insert(UsersCoupons record);

    int insertSelective(UsersCoupons record);

    UsersCoupons selectByPrimaryKey(Integer ucouponsid);

    int updateByPrimaryKeySelective(UsersCoupons record);

    int updateByPrimaryKey(UsersCoupons record);
}