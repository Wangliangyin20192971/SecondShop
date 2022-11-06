<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="en">
<head>
    <title>用户登录页面</title>
    <style>
        html,body{
            margin: 0;
            padding: 0;
            height: 100%;
        }
        body{
            background: url("../img/bg.jpeg");
        }
        h1{
            color: #000000;
            text-align: center;
        }
        .container{
            margin: 100px auto;
            width: 500px;
        }
        form{
            background: rgb(166, 202, 211);
            height: 300px;
            width: 100%;
            border-radius: 10px;
            position: relative;
        }
        label{
            color: #000;
            font-weight: bold;
            font-size: 20px;
            margin-left: 40px;
        }
        input{
            text-align: left;
            margin: 10px;
        }
        .input{
            width: 80%;
            height: 35px;
            margin-left: 40px;
        }
        a{
            display: block;
            width:100px;
            height:35px;
            line-height: 35px;
            text-align: center;
            text-decoration: none;
            font-weight: bold;
            color: #fff;
        }
        .submit{
            display: inline-block;
            margin-top: 0;
            background: #000;
            border: none;
            color: #FFF;
            height: 35px;
            width: 100px;
            text-align: center;
            font-weight: bold;
            border-radius: 5px;
        }
        .login{
            position: absolute;
            bottom: 50px;
            left: 100px;
        }
        .register{
            position: absolute;
            bottom: 50px;
            right: 100px;
        }
    </style>
</head>
<body>
<div>
    <div class="container">
        <h1>用户登录</h1>
        <%--登录提示信息--%>
        <span style="color: red">${msg}</span>
        <form action="${pageContext.request.contextPath}/login" method="post">
            <br>
            <label for="username">用户名</label><br>
            <input type="text" name="userName" id="username" class="input" placeholder="请输入用户名"><br>
            <label for="pwd">密码</label><br>
            <input type="password" name="userPassword" id="pwd" class="input" placeholder="请输入密码"><br>
            <button type="submit" class="submit login" id="Login">登录</button>
            <button type="submit" class="submit register">
                <a href="${pageContext.request.contextPath}/register">注册</a>
            </button>
        </form>
    </div>
</div>
</body>
</html>