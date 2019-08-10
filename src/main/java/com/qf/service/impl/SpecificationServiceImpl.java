package com.qf.service.impl;

import com.qf.bean.Specification;
import com.qf.dao.SpecificationMapper;
import com.qf.service.SpecificationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class SpecificationServiceImpl implements SpecificationService {

    @Resource
    private SpecificationMapper specificationMapper;


    @Override
    public List findAll() {

        return specificationMapper.findAll();
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(Specification record) {
        return 0;
    }

    @Override
    public int insertSelective(Specification record) {
        return 0;
    }

    @Override
    public Specification selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Specification record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Specification record) {
        return 0;
    }
}
