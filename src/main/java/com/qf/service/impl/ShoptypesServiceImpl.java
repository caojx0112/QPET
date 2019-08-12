package com.qf.service.impl;

import com.qf.bean.Shoptypes;
import com.qf.dao.ShoptypesMapper;
import com.qf.service.ShoptypesService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class ShoptypesServiceImpl implements ShoptypesService {

    @Resource
    private ShoptypesMapper shoptypesMapper;

    @Override
    public int deleteByPrimaryKey(Integer typeid) {
        return 0;
    }

    @Override
    public int insert(Shoptypes record) {
        return 0;
    }

    @Override
    public int insertSelective(Shoptypes record) {
        return shoptypesMapper.insertSelective(record);
    }

    @Override
    public Shoptypes selectByPrimaryKey(Integer typeid) {
        return shoptypesMapper.selectByPrimaryKey(typeid);
    }

    @Override
    public int updateByPrimaryKeySelective(Shoptypes record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Shoptypes record) {
        return 0;
    }




    @Override
    public List<Shoptypes> pet() {
        return shoptypesMapper.pet();
    }

    @Override
    public List<Shoptypes> findbytype(Integer type) {
        return shoptypesMapper.findbytype(type);
    }


}
