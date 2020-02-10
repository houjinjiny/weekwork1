package com.itdr.controller;

import com.itdr.common.ResponseCode;
import com.itdr.pojo.Users;
import com.itdr.service.UserService;
import com.itdr.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/backed/user/*")
@Controller
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
@Autowired
    private UserService userService ;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        String[] split = requestURI.split("/");

        switch (split[split.length - 1]){
            case "login":
                login(request,response);
                break;
            case "logon":
                logon(request,response);
                break;
        }
    }
    //注册
    private void logon(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        ResponseCode<Users> logon = userService.logon(username, password);
        if(logon.getData()!=null){
            request.getRequestDispatcher("/index.jsp").forward(request,response);
        }else {
            request.getRequestDispatcher("/WEB-INF/noaccess.jsp").forward(request,response);
        }

    }


    //登录
    private void login(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        ResponseCode<Users> login = userService.login(username, password);
        if(login.getData()!=null){
            //登陆成功，保存用户信息
            HttpSession session=request.getSession();
            Users data=login.getData();
            session.setAttribute("us",data);
//            request.setAttribute("user",login);
            request.getRequestDispatcher("/WEB-INF/home.jsp").forward(request,response);
        }else {
            request.getRequestDispatcher("/WEB-INF/noaccess.jsp").forward(request,response);
        }

    }
}
