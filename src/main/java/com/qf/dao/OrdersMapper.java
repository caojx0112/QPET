package com.qf.dao;

import com.qf.bean.Orders;

import java.util.List;

public interface OrdersMapper {

    int  updatepaystatus(Orders orders);

    int deleteByPrimaryKey(String orderid);

    int insert(Orders record);

    int insertSelective(Orders record);

    Orders selectByPrimaryKey(String orderid);

    int updateByPrimaryKeySelective(Orders record);

    int updateByPrimaryKey(Orders record);
    //查看订单数量
    public int SelectOrdersCount(Integer userid);
    //查看待付款数量
    public int obligationcount(Integer userid);
    //查看待发货数量
    public int delivercount(Integer userid);
    //查看待收货数量
    public int receivingcount(Integer userid);

    List<Orders> findbyuserid(int userid);

    Orders findorderdetail(String orderid);
}