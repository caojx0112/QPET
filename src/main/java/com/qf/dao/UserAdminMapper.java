package com.qf.dao;

import com.qf.bean.UserAdmin;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


public interface UserAdminMapper {

    @Update("update user_admin set password=#{password} where id=#{id}")
    int update1(@Param(value = "password") String password, @Param(value = "id") int id);

    @Select("select username,password from user_admin where username=#{username}")
    UserAdmin login1(@Param(value = "username") String username);

    int deleteByPrimaryKey(Integer id);

    int insert(UserAdmin record);

    int insertSelective(UserAdmin record);

    UserAdmin selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserAdmin record);

    int updateByPrimaryKey(UserAdmin record);
}