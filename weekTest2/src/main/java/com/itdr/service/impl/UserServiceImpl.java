package com.itdr.service.impl;

import com.itdr.dao.UserDao;
import com.itdr.pojo.Name;
import com.itdr.pojo.Users;
import com.itdr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao ud;
    //注册
    @Override
    public int logon(String username, String password) {
        //参数非空判断
        if(username==null){
            return 0;
        }
        if(password==null){
            return 0;
        }
        Users users = ud.selectByUserNameAndPassword(username, password);
        //返回值null，说明用户不存在
        if(users == null){
            //添加
            int i=ud.addUser(username,password);
            if(i>0){
                return i;
            }else {
                return 0;
            }

        }else {
            return 0;
        }
    }


    //登录
    @Override
    public Users login(String username, String password) {
        //参数非空判断
        if(username==null){
            return null;
        }
        if(password==null){
            return null;
        }

        Users users = ud.selectByUserNameAndPassword(username, password);
        //返回值null，说明用户不存在，登录失败
        if(users == null){
            return null;
        }else {
            //成功返回成功数据
            return users;
        }

    }
    //游戏
    @Override
    public Name getName(String sx, String month, String xz) {
        //参数非空判断
        if(sx==null){
            return null;
        }
        if(month==null){
            return null;
        }
        if(xz==null){
            return null;
        }
        String s1=ud.getXing(sx);
        String s2=ud.getTwo(month);
        String s3=ud.getThree(xz);
        Name name=new Name();
        name.setXing(s1);
        name.setTwo(s2);
        name.setThree(s3);
        if(s1==null||s2==null||s3==null){
            return null;
        }
        return name;
    }
}
