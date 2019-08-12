package com.qf.service.impl;


import com.qf.bean.UserAdmin;
import com.qf.dao.UserAdminMapper;
import com.qf.service.UserAdminService;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

@Service
public class UserAdminSerrviceImpl implements UserAdminService {

    @Resource
    private UserAdminMapper userAdminMapper;

    @Override
    public UserAdmin login(String username,String password) {
        Md5Hash md5Hash=new Md5Hash(password,"",1);
        UserAdmin login = userAdminMapper.login1(username);
        if (login!=null&&md5Hash.toString().equals(login.getPassword())){
            return login;
        }
        return null;
    }


    @Override
    public int update(String password,int id) {
        Md5Hash md5Hash=new Md5Hash(password,"",1);

        return userAdminMapper.update1(md5Hash.toString(),id);

    }


    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(UserAdmin record) {
        return 0;
    }

    @Override
    public int insertSelective(UserAdmin record) {
        return 0;
    }

    @Override
    public UserAdmin selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    @Transactional
    public int updateByPrimaryKeySelective(UserAdmin record) {
        String password = record.getPassword();
        Md5Hash md5Hash=new Md5Hash(password,"",1);
        record.setPassword(md5Hash.toString());
        return userAdminMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(UserAdmin record) {
        return 0;
    }
}
