package com.qf.dao;

import com.qf.bean.Shopdetail;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface ShopdetailMapper {

    @Select("select detailimages from shopdetail where shopid=#{id}")
    Shopdetail findItemimag1(@Param(value = "id") int id);

    int deleteByPrimaryKey(Integer shopdeatilid);

    int insert(Shopdetail record);

    int insertSelective(Shopdetail record);

    Shopdetail selectByPrimaryKey(Integer shopdeatilid);

    int updateByPrimaryKeySelective(Shopdetail record);

    int updateByPrimaryKey(Shopdetail record);
}