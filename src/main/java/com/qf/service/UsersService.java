package com.qf.service;

import com.qf.bean.Users;

public interface UsersService {
    int deleteByPrimaryKey(Integer userid);

    int insert(Users record);

    int insertSelective(Users record);

    Users selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);

    int registry(int type, String testbox);

    Users login(String username);

    boolean getCodeByEmail(String email, String code);
    boolean getCodeBySms(String phone, String code);

    int setPassword(Users record);
    int selectEmoney(Integer userid);
    int selectAddressid(Integer userid);
}
