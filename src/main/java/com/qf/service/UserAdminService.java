package com.qf.service;

import com.qf.bean.UserAdmin;

public interface UserAdminService {

    UserAdmin login(UserAdmin userAdmin);

    int deleteByPrimaryKey(Integer id);

    int insert(UserAdmin record);

    int insertSelective(UserAdmin record);

    UserAdmin selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserAdmin record);

    int updateByPrimaryKey(UserAdmin record);
}