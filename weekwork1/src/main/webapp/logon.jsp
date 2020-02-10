<%--
  Created by IntelliJ IDEA.
  User: 17591
  Date: 2020/2/6
  Time: 14:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
    <style>
        .wk{
            width: 100%;
            height: 100%;
            display: flex;
            align-content: center;
            justify-content: center;
            background: url(images/1.jpg) no-repeat;
            background-size: 100% 100%;
        }
        .current{
            width: 500px;
            height: 350px;
            margin: auto;
            display: flex;
            align-content: center;
            justify-content: center;
            background-color: white;
            opacity: 0.6;
        }
        #fr{
            height: 300px;
            width: 500px;
            /*display: flex;*/
            /*align-content: center;*/
            /*justify-content: center;*/
            margin: auto auto;

        }
        #fr form{
            width: 500px;
            margin-left: 100px;
        }
        #fr input{
            height: 25px;
            margin-bottom: 20px;

        }
        h1{
            text-align: center;
            margin-bottom: 40px;
        }
        #but{
            display: block;
            width: 80px;
            margin-left: 100px;
        }
    </style>
</head>
<body>
<div class="wk">
    <div class="current">
        <div id="fr">
            <h1 id="">欢迎</h1>
            <form action="/backed/user/logon" method="post" >
                用户名:&nbsp;<input type="text" placeholder="账号" name="username" id="user" onfocus="show('user','用户名必填！')" onblur="check('user','用户名不能为空！')"><span id="userspan"></span><br>
                密&nbsp;&nbsp;&nbsp;码:&nbsp;<input type="password" placeholder="密码" name="password" id="ps" onfocus="show('ps','密码必填！')" onblur="check('ps','密码不能为空！')"><span id="psspan"></span><br>
                <input type="submit" value="注册" id="but">
            </form>
        </div>
    </div>
</div>
<script src="js/jquery-3.3.1.js"></script>
<script>
    function show(id,infor) {
        document.getElementById(id+"span").innerHTML="<font color='gray'>"+infor+"</font>";
    }
    function check(id,infor) {
        var x=document.getElementById(id);
        if(x.value==""){
            document.getElementById(id+"span").innerHTML="<font color='red'>"+infor+"</font>";
        }else {
            document.getElementById(id+"span").innerHTML="";
        }
    }
</script>
</body>
</html>
