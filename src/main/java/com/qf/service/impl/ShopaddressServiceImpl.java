package com.qf.service.impl;

import com.qf.bean.Shopaddress;
import com.qf.dao.ShopaddressMapper;
import com.qf.service.ShopaddressService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 别闹！学习呢！
 */
@Service
public class ShopaddressServiceImpl implements ShopaddressService {

   @Resource
   private ShopaddressMapper shopaddressMapper;


    @Override
    public Shopaddress selectByPrimaryKey(int addressid) {
        return shopaddressMapper.selectByPrimaryKey(addressid);
    }

    @Override
    public int deleteByPrimaryKey(Integer addressid) {
        return shopaddressMapper.deleteByPrimaryKey(addressid);
    }

    @Override
    public int insert(Shopaddress record) {
        return 0;
    }

    @Override
    public int insertSelective(Shopaddress record) {

        return shopaddressMapper.insertSelective(record);
    }


    @Override
    public int updateByPrimaryKeySelective(Shopaddress record) {
        return shopaddressMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Shopaddress record) {
        return 0;
    }
}
