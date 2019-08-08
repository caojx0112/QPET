package com.qf.dao;

import com.qf.bean.Shoppes;
import com.qf.bean.ShoppingTrolley;

import java.util.List;
import java.util.Map;

public interface ShoppingTrolleyMapper {
    int deleteByPrimaryKey(Integer shopcard);

    int insert(ShoppingTrolley record);

    int insertSelective(ShoppingTrolley record);

    List<ShoppingTrolley> selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(ShoppingTrolley shoppingTrolley);

    int updateByPrimaryKey(ShoppingTrolley record);
    ShoppingTrolley selectShoppingTrolley(Map map);

    ShoppingTrolley selectShoppes(Integer shopcard);
}