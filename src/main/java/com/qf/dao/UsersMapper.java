package com.qf.dao;

import com.qf.bean.Users;

public interface UsersMapper {
    int deleteByPrimaryKey(Integer userid);

    int insert(Users record);

    int insertSelective(Users record);

    Users selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);

    Users selectByUsername(String username);

    int setPassword(Users record);

    int selectEmoney(Integer userid);
    int selectAddressid(Integer userid);
}