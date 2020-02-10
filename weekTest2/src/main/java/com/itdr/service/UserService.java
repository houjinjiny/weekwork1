package com.itdr.service;

import com.itdr.pojo.Name;
import com.itdr.pojo.Users;
import org.springframework.stereotype.Service;


public interface UserService {
    Users login(String username, String password);

    int logon(String username, String password);


    Name getName(String sx, String month, String xz);
}
