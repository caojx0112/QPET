package com.qf.dao;

import com.qf.bean.Collect;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface CollectMapper {
    @Delete("delete from collect where userid=#{userid} and shopid=#{shopid}")
    int delete1(@Param(value = "userid") int userid, @Param(value = "shopid") int shopid);

    @Select("select userid,shopid  from collect where userid=#{userid} and shopid=#{shopid}")
    Collect find(@Param(value = "userid") int userid,@Param(value = "shopid") int shopid);

    int deleteByPrimaryKey(Integer collectid);

    int insert(Collect record);

    int insertSelective(Collect record);

    Collect selectByPrimaryKey(Integer collectid);

    int updateByPrimaryKeySelective(Collect record);

    int updateByPrimaryKey(Collect record);
    //查看收藏数量
    int collectcount(Integer userid);
}