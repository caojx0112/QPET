package com.qf.dao;

import com.qf.bean.Shoppes;
import com.qf.bean.Shoptypes;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShoppesMapper {
    Shoppes findById(int shopid);
    //删除
    int deleteByPrimaryKey(Integer shopid);

    int insert(Shoppes record);
    //后台页面添加商品
    int insertSelective(Shoppes record);

    //主键
    Shoppes selectByPrimaryKey(Integer shopid);

    //后台页面修改宠物商品
    int updateByPrimaryKeySelective(Shoppes record);

    int updateByPrimaryKey(Shoppes record);




    //全查
    List<Shoppes> findAll();
    //搜索填充
    List<String> fill(@Param("shopname") String shopname, @Param("type")Integer type);
    //热门搜索
    List<String> findHot();

    //搜索功能( 上架时间  排序方式  商品种类     价格筛选    销量筛选 )
    List<Shoppes> find(@Param("shopname")String shopname,@Param("type")Integer type,@Param("sort1")Integer sort1,@Param("sort2")Integer sort2,@Param("sort3")Integer sort3,@Param("sort4")Integer sort4,@Param("sort5")Integer sort5);

    //后台页面商品列表信息
    List<Shoptypes> pettype(@Param("typeid")Integer typeid);




}