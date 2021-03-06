package com.itdr.service.impl;

import com.itdr.common.ResponseCode;
import com.itdr.dao.UserDao;import com.itdr.pojo.Users;
import com.itdr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao ud ;
    //注册
    @Override
    public ResponseCode<Users> logon(String username, String password) {
        //参数非空判断
        if(username==null){
            return ResponseCode.toDefeated("用户名不能为空！");
        }
        if(password==null){
            return ResponseCode.toDefeated("密码不能为空！");
        }
        Users users = ud.selectByUserNameAndPassword(username, password);
        //返回值null，说明用户不存在
        if(users == null){
            //添加
            int i=ud.addUser(username,password);
            if(i>0){
                return ResponseCode.toSuccess(i);
            }else {
                return ResponseCode.toDefeated("注册失败！");
            }

        }else {
            return ResponseCode.toDefeated("用户已存在！");
        }
    }
    //登录
    @Override
    public ResponseCode<Users> login(String username, String password) {
        //参数非空判断
        if(username==null){
            return ResponseCode.toDefeated("用户名不能为空！");
        }
        if(password==null){
            return ResponseCode.toDefeated("密码不能为空！");
        }

        Users users = ud.selectByUserNameAndPassword(username, password);
        //返回值null，说明用户不存在，登录失败
        if(users == null){
            return ResponseCode.toDefeated("用户不存在！");
        }else {
            //成功返回成功数据
            return ResponseCode.toSuccess(users);
        }

    }
}
