package com.qf.service.impl;

import com.qf.bean.Users;
import com.qf.dao.UsersMapper;
import com.qf.service.UsersService;
import com.qf.util.SendEmail;
import com.qf.util.SendSms;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UsersServiceImpl implements UsersService {
    @Resource
    private UsersMapper usersMapper;
    @Override
    public int deleteByPrimaryKey(Integer userid) {
        return 0;
    }

    @Override
    public int insert(Users record) {
        return 0;
    }

    @Override
    public int insertSelective(Users record) {
        return usersMapper.insertSelective(record);
    }

    @Override
    public Users selectByPrimaryKey(Integer userid) {
        return usersMapper.selectByPrimaryKey(userid);
    }

    @Override
    public int updateByPrimaryKeySelective(Users record) {
        return usersMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Users record) {
        return usersMapper.updateByPrimaryKey(record);
    }

    @Override
    public int registry(int type, String testbox) {
        return 0;
    }

    /**
     * 用户登录
     * @param username
     * @return
     */
    @Override
    public Users login(String username) {
        Users users = usersMapper.selectByUsername(username);
        return users;
    }

    /**
     * 邮箱获取验证码
     * @param email
     * @return
     */
    @Override
    public boolean getCodeByEmail(String email,String code) {
        boolean send = SendEmail.Send(email, code);
        return send;
    }

    /**
     * 短信获取验证码
     * @param phone
     * @param code
     * @return
     */
    @Override
    public boolean getCodeBySms(String phone, String code) {
        int send = SendSms.send(phone, code);
        if (send==0){
            return true;
        }
        return false;
    }
    /**
     * 修改密码
     * @param record
     * @return
     */
    @Override
    public int setPassword(Users record) {
        int i = usersMapper.setPassword(record);
        return 1;
    }

    @Override
    public int selectEmoney(Integer userid) {
        return 0;
    }

    @Override
    public int selectAddressid(Integer userid) {
        return 0;
    }


}
