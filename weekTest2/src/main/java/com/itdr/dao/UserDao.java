package com.itdr.dao;

import com.itdr.pojo.Name;
import com.itdr.pojo.Users;
import com.itdr.utils.C3P0Util;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Repository
public class UserDao {
    @Autowired
    private JdbcTemplate jdt;
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
        String sql="INSERT INTO users values (null,?,?,0,now(),now())";
        int update = jdt.update(sql, username, password);
        return update;
    }

    public String getXing(String sx) {
        QueryRunner qr = new QueryRunner(C3P0Util.getCom());
        String sql="select * from xing where sx=?";
        Name query = null;
        try {
            query = qr.query(sql, new BeanHandler<>(Name.class),sx);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String s=query.getXing();
        return s;

    }

    public String getTwo(String month) {
        QueryRunner qr = new QueryRunner(C3P0Util.getCom());
        String sql="select * from two where month=?";
        Name query = null;
        try {
            query = qr.query(sql, new BeanHandler<>(Name.class), month);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(query);
        String s=query.getTwo();
        return s;
    }

    public String getThree(String xz) {
        QueryRunner qr = new QueryRunner(C3P0Util.getCom());
        String sql="select * from three where xz=?";
        Name query = null;
        try {
            query = qr.query(sql, new BeanHandler<>(Name.class), xz);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String s=query.getThree();
        return s;
    }
}
