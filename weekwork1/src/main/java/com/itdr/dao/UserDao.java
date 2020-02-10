package com.itdr.dao;

import com.itdr.pojo.Users;
import com.itdr.utils.C3P0Util;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
@Repository
public class UserDao {
    public Users selectByUserNameAndPassword(String username,String password){
        QueryRunner qr = new QueryRunner(C3P0Util.getCom());

        String sql = "select id,username,password,type,create_time,update_time from users where username=? and password=?";
        Users u = null;
        try {
            u = qr.query(sql, new BeanHandler<Users>(Users.class),username,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return u;
    }

    public int addUser(String username, String password) {
        QueryRunner qr = new QueryRunner(C3P0Util.getCom());
        String sql="INSERT INTO users values (null,?,?,0,now(),now())";
        int update = 0;
        try {
            update = qr.update(sql, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return update;
    }
}
