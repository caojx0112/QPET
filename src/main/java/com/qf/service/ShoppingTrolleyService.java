package com.qf.service;

import com.qf.bean.Shoppes;
import com.qf.bean.ShoppingTrolley;

import java.util.List;

public interface ShoppingTrolleyService {
    int deleteByPrimaryKey(Integer shopcard);

    int insert(ShoppingTrolley record);

    int insertSelective(ShoppingTrolley record);

    List<ShoppingTrolley> selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(ShoppingTrolley shoppingTrolley);

    int updateByPrimaryKey(ShoppingTrolley record);
    ShoppingTrolley selectShoppingTrolley(Integer userid, Integer shopid);

    List<ShoppingTrolley> selectShoppes(String shoppes);
}