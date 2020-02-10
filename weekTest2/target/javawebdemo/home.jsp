<%@ page import="com.itdr.pojo.Users" %>
<%@ page import="com.itdr.pojo.Name" %><%--
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
        width: 100%;
        height: 100%;
    }

    #center{
        width: 400px;
        height: 300px;
        text-align: center;
        margin: 20px auto;
        background-color: lightgrey;
    }
    input{
        width: 80px;
        height: 30px;
        margin-top: 20px;
    }
</style>
</head>
<body>

<div class="wk">
    <div class="first">
        <jsp:include page="top.jsp"></jsp:include>
    </div>
    <div id="center">
        <form action="/backed/user/start" method="post">
            生肖：<input type="text" name="sx"><br>
            月份：<input type="text" name="month"><br>
            星座：<input type="text" name="xz"><br>
            <input type="submit" value="提交">
        </form>

    </div>
</div>
</body>
<script src="../../js/jquery-3.3.1.js"></script>
<script>

</script>
</html>
