package com.qf.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.qf.bean.Shoppes;
import com.qf.bean.ShoppingTrolley;
import com.qf.dao.ShoppingTrolleyMapper;
import com.qf.service.ShoppingTrolleyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 别闹！学习呢！
 */
@Service
public class ShoppingTrolleyServiceImpl implements ShoppingTrolleyService {

    @Resource
    private ShoppingTrolleyMapper shoppingTrolleyMapper;
    @Override
    public int deleteByPrimaryKey(Integer shopcard) {
        return shoppingTrolleyMapper.deleteByPrimaryKey(shopcard);
    }

    @Override
    public int insert(ShoppingTrolley record) {
        return 0;
    }

    @Override
    public int insertSelective(ShoppingTrolley record) {
        return shoppingTrolleyMapper.insertSelective(record);
    }

    @Override
    public List<ShoppingTrolley> selectByPrimaryKey(Integer userid) {
        return shoppingTrolleyMapper.selectByPrimaryKey(userid);
    }

    @Override
    public int updateByPrimaryKeySelective(ShoppingTrolley shoppingTrolley) {
        return shoppingTrolleyMapper.updateByPrimaryKeySelective(shoppingTrolley);
    }

    @Override
    public int updateByPrimaryKey(ShoppingTrolley record) {
        return 0;
    }

    @Override
    public ShoppingTrolley selectShoppingTrolley(Integer userid, Integer shopid) {
        Map map=new HashMap();
        map.put("userid",userid);
        map.put("shopid",shopid);
        return shoppingTrolleyMapper.selectShoppingTrolley(map);
    }

    @Override
    public List<ShoppingTrolley> selectShoppes(String shoppes) {
        List<ShoppingTrolley> shoppesList = JSONObject.parseArray(shoppes, ShoppingTrolley.class);
        List<ShoppingTrolley> shoppesList1=new ArrayList();
        for (ShoppingTrolley shoppes1 : shoppesList) {
            ShoppingTrolley shoppes2 = shoppingTrolleyMapper.selectShoppes(shoppes1.getShopcard());
            shoppesList1.add(shoppes2);
        }
        return shoppesList1;
    }
}
