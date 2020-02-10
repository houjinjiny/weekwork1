package com.itdr.controller;

import com.itdr.pojo.Name;
import com.itdr.pojo.Users;
import com.itdr.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/backed/user/*")
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
//    @Autowired
//    private UserService userService;
    ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
    UserService userService=ac.getBean(UserService.class);

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
            case "start":
                start(request,response);
                break;
        }
    }


    //注册
    private void logon(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        int i = userService.logon(username, password);
        if(i!=0){
            request.getRequestDispatcher("/index.jsp").forward(request,response);
        }else {
            request.getRequestDispatcher("/WEB-INF/noaccess.jsp").forward(request,response);
        }

    }


    //登录
    private void login(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Users users = userService.login(username, password);
        if(users!=null){
            //登陆成功，保存用户信息
            HttpSession session=request.getSession();
            session.setAttribute("us",users);
//            request.setAttribute("user",login);
            request.getRequestDispatcher("/home.jsp").forward(request,response);
        }else {
            request.getRequestDispatcher("/noaccess.jsp").forward(request,response);
        }

    }
    //游戏
    private void start(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String sx=request.getParameter("sx");
        String month=request.getParameter("month");
        String xz=request.getParameter("xz");
        Name name=userService.getName(sx,month,xz);
        HttpSession session=request.getSession();
        session.setAttribute("name",name);
        request.getRequestDispatcher("/home2.jsp").forward(request,response);
    }
}
