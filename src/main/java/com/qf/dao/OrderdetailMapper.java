package com.qf.dao;

import com.qf.bean.Orderdetail;

import java.util.List;

public interface OrderdetailMapper {
    List<Orderdetail> findbyOrderid(String orderid);

    int deleteByPrimaryKey(Integer deatilid);

    int insert(Orderdetail record);

    int insertSelective(Orderdetail record);

    Orderdetail selectByPrimaryKey(Integer deatilid);

    int updateByPrimaryKeySelective(Orderdetail record);

    int updateByPrimaryKey(Orderdetail record);
}