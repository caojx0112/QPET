package com.qf.service;

import com.qf.bean.Collect;

public interface CollectService {
    int delete(int userid,int shopid);

    Collect find(int userid,int shopid);

    int deleteByPrimaryKey(Integer collectid);

    int insert(Collect record);

    int insertSelective(Collect record);

    Collect selectByPrimaryKey(Integer collectid);

    int updateByPrimaryKeySelective(Collect record);

    int updateByPrimaryKey(Collect record);
    //查看收藏数量
    int collectcount(Integer userid);
}