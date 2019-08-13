package com.qf.service;

import com.qf.bean.Shoppes;
import com.qf.bean.Shoptypes;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ShoppesService {
    Shoppes findById(int shopid);

    int deleteByPrimaryKey(Integer shopid);

    int insert(Shoppes record);

    int insertSelective(Shoppes record);

    Shoppes selectByPrimaryKey(Integer shopid);

    int updateByPrimaryKeySelective(Shoppes record);

    int updateByPrimaryKey(Shoppes record);




    //全查
    Map findAll();
    //搜索填充
    List<String> fill(String k,Integer type);
    //热门搜索
    List<String> findHot(@Param("type")Integer type);
    //搜索功能( 上架时间  排序方式  商品种类     价格筛选    销量筛选 )
    List<Shoppes> find(String shopname, Integer type, Integer sort1, Integer sort2, Integer sort3, Integer sort4, Integer sort5);

    //后台页面商品列表信息
    List<Shoptypes> pettype(Integer typeid);




}