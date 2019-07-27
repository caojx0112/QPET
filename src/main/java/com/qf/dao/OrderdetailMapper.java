package com.qf.dao;

import com.qf.bean.Orderdetail;

public interface OrderdetailMapper {
    int deleteByPrimaryKey(Integer deatilid);

    int insert(Orderdetail record);

    int insertSelective(Orderdetail record);

    Orderdetail selectByPrimaryKey(Integer deatilid);

    int updateByPrimaryKeySelective(Orderdetail record);

    int updateByPrimaryKey(Orderdetail record);
}