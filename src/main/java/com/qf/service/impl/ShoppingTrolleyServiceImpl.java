package com.qf.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.qf.bean.Shoppes;
import com.qf.bean.ShoppingTrolley;
import com.qf.bean.Specification;
import com.qf.dao.ShoppesMapper;
import com.qf.dao.ShoppingTrolleyMapper;
import com.qf.dao.SpecificationMapper;
import com.qf.service.ShoppingTrolleyService;
import com.qf.util.StatusUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
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
    @Resource
    private ShoppesMapper shoppesMapper;
    @Resource
    private SpecificationMapper specificationMapper;

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
        Shoppes shoppes = shoppesMapper.selectByPrimaryKey(record.getShopid());
        Specification specification = specificationMapper.selectByPrimaryKey(record.getSpecification());
        Double total=0.0;
        //没有规格
        total=shoppes.getNewprice()*record.getShopnum();
        //有规格
        if (specification!= null){
            total=specification.getShopmoney()*record.getShopnum();
        }
        record.setShopmoney(total);
        record.setTrolleyrstatus(1);
        return shoppingTrolleyMapper.insertSelective(record);
    }

    @Override
    public ShoppingTrolley selectByPrimaryKey(Integer shopcard) {
        return null;
    }
    @Override
    public List<ShoppingTrolley> selectAll(Integer userid) {
        List<ShoppingTrolley> list = shoppingTrolleyMapper.selectAll(userid);
        for (ShoppingTrolley shoppingTrolley : list) {
            Specification specification = specificationMapper.selectByPrimaryKey(shoppingTrolley.getSpecification());
            if (specification!= null){
                Shoppes shoppes = shoppingTrolley.getShoppes();
                shoppes.setNewprice(specification.getShopmoney());
            }
        }
        return list;
    }

    @Override
    @Transactional
    public int updateByPrimaryKeySelective(ShoppingTrolley shoppingTrolley) {
        Map map=new HashMap();
        map.put("userid",shoppingTrolley.getUserid());
        map.put("shopid",shoppingTrolley.getShopid());
        double  money=0.0;
        Shoppes shoppes = shoppesMapper.selectByPrimaryKey(shoppingTrolley.getShopid());
        ShoppingTrolley shoppingTrolley1 = shoppingTrolleyMapper.selectShoppingTrolley(map);
        money=shoppes.getNewprice()*shoppingTrolley.getShopnum();
        Specification specification =
                specificationMapper.selectByPrimaryKey(shoppingTrolley1.getSpecification());
        if (specification!=null){
            money=specification.getShopmoney()*shoppingTrolley.getShopnum();
        }
        shoppingTrolley.setShopmoney(money);
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
            Specification specification = specificationMapper.selectByPrimaryKey(shoppes2.getSpecification());
            if (specification!= null){
                Shoppes shoppes3 = shoppes2.getShoppes();
                shoppes3.setNewprice(specification.getShopmoney());
            }


            shoppesList1.add(shoppes2);
        }
        return shoppesList1;
    }
}
