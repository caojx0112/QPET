package com.qf.dao;

import com.qf.bean.Orders;

import java.util.List;

public interface OrdersMapper {
    List<Orders> findbyuserid(int userid);

    int  updatepaystatus(Orders orders);

    int deleteByPrimaryKey(String orderid);

    int insert(Orders record);

    int insertSelective(Orders record);

    Orders selectByPrimaryKey(String orderid);

    int updateByPrimaryKeySelective(Orders record);

    int updateByPrimaryKey(Orders record);

    Orders findorderdetail(String orderid);
}