package com.qf.dao;

import com.qf.bean.UserAdmin;


public interface UserAdminMapper {

    UserAdmin login(String username);

    int deleteByPrimaryKey(Integer id);

    int insert(UserAdmin record);

    int insertSelective(UserAdmin record);

    UserAdmin selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserAdmin record);

    int updateByPrimaryKey(UserAdmin record);
}