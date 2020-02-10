<%@ page import="com.itdr.pojo.Users" %>
<%@ page import="javax.naming.Name" %><%--
  Created by IntelliJ IDEA.
  User: 17591
  Date: 2020/1/15
  Time: 8:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>首页</title>
    <style>
        *{
            margin: 0;
            padding: 0;
        }
        .wk{
            display: flex;
        }
        #left{
            width: 300px;
            height: 400px;
            border: 1px solid black;
        }
        #center{
            width: 100%;
            height: 100%;
            text-align: center;
            margin-top: 30px;
        }
        #computer{
            width: 307px;
            height: 300px;
            border: 1px solid black;
            margin: auto;
        }
        button{
            width: 100px;
            height: 30px;
        }
        #right{
            width: 300px;
            height: 400px;
            border: 1px solid black;
        }
    </style>
</head>
<%
    Users u= (Users) request.getSession().getAttribute("us");
    String s=u.getUsername();
%>
<body>
<jsp:include page="top.jsp"></jsp:include>
<% boolean us; %>
<div class="wk">

    <div id="left">
        <h4>排行榜</h4>
    </div>
    <div id="center">
        <div id="computer"></div>
        <button id="btu1" onclick="chuquan(this)">石头</button>
        <button id="btu2" onclick="chuquan(this)">剪刀</button>
        <button id="btu3" onclick="chuquan(this)">布</button>
        <div>
            <%=s%>
        </div>
    </div>
    <div id="right">
        <div>分数：</div>
    </div>
</div>
</body>
<script src="../../js/jquery-3.3.1.js"></script>
<script>
    function chuquan(btu) {
        var a=Math.random()*3+1;
        var b;
        if(a==1){
            $("#computer").text("石头");
        }else if(a==2){
            $("#computer").text("剪刀");
        }else if(a==3){
            $("#computer").text("布");
        }

    }
</script>
</html>