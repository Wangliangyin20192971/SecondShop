<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="en">
<head>
    <title>用户注册页面</title>
    <html lang="en">
    <head>
        <style>
            body{
                background: url("../img/bg.jpeg");
            }
            .container{
                margin: 100px auto;
                width: 500px;
            }
            form{
                width: 500px;
                margin: 0 auto;
                background:  rgb(166, 202, 211);
                border-radius: 15px;
                position: relative;
            }
            .form-group{
                width: 500px;
                margin: 0 auto;
                background:  rgb(166, 202, 211);
                border-radius: 15px;
                position: relative;
            }
            h1{
                font-size: 28px;
                text-align: center;
                color: #000;
            }
            .p{
                color: red;
                margin-left: 33px;
                display: inline-block;
            }
            label{
                font-size: 18px;
                font-weight: bold;
            }
            .register{
                height: 35px;
                width: 300px;
            }
            .q{
                color:red;
                margin-left:50px;
                display:inline-block;
            }
            .checkbox{
                margin-left: 100px;
                display: inline-block;
                width: 15px;
                height: 15px;
            }
            .submit{
                border-radius: 7px;
                margin-left: 150px;
                height: 35px;
                width: 150px;
                background-color: #000;
                border: none;
                display: block;
                padding: 0;
                color: #FFF;
                font-weight: bold;
                cursor: pointer;
            }
            .Msg{
                font-size: 15px;
                color: #9f191f;
            }
            a{
                text-decoration: none;
                font-weight: bold;
            }
            .left,.right{
                position: absolute;
                bottom: 20px;
            }
            .left{
                left: 20px;
            }
            .right{
                right: 20px;
            }
            #women,#man{
                height: 15px;
                width: 50px;
            }
        </style>
        <script>
            function checkPassword(f1) {
                var pwd = document.getElementById("pwd");
                var pwdMsg = document.getElementById("pwdMsg");
                if(f1){
                    var reg = /^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,18}$/;
                    if(!reg.test(pwd.value)){
                        pwdMsg.innerHTML = "格式错误";
                        return false;
                    }
                    pwdMsg.innerHTML = "";
                    return true;
                }else{
                    return false;
                }
            }

            function checkNotNull(nid){
                var nodex = document.getElementById(nid);
                var msg=document.getElementById(nid+"Msg");
                var div=document.getElementById(nid+"Div");
                var reg = /^\s*$/;
                if(reg.test(nodex.value)){
                    div.className+=" has-error";
                    msg.innerHTML = "不能为空";
                    return false;
                }else{
                    div.className="form-group";
                    msg.innerHTML = "";
                    return true;
                }
            }
            function checkForm() {
                var flag1 = checkNotNull("username");
                var flag2 = checkNotNull("pwd");
                var flag3 = checkNotNull("userBuilding");
                var flag4 = checkNotNull("userRoom");
                var flag5 = checkPassword(flag2);
                return flag1&&flag2&&flag3&&flag4&&flag5;
            }
        </script>
    </head>
<body>
<div class="container">
    <h1>新用户注册</h1>
    <span style="color: red">${msg}</span>
    <form action="${pageContext.request.contextPath}/addUser" onsubmit="return checkForm()" method="post">
        <br>
        <div id="usernameDiv" class="form-group">
            <span class="p">*</span>
            <label for="username">用户名</label>
            <input type="text" name="userName" id="username" placeholder="请输入用户名" class="register">
            <label id="usernameMsg" class="Msg"></label><br><br>
        </div>


        <div id="pwdDiv" class="form-group">
            <span class="q">*</span>
            <label for="pwd">密码</label>
            <input type="text" name="userPassword" id="pwd" placeholder="请输入6~18位的密码（不能为全数字）" class="register">
            <label id="pwdMsg" class="Msg"></label><br><br>
        </div>

        <div class="form-group">
            <span class="q">*</span>
            <label for="man">性别</label>
            <input type="radio" name="userSex" id="man" value="男" checked="checked" class="register"/>男
            <input type="radio" name="userSex" id="women" value="女" class="register"/>女<br><br>
        </div>

        <div id="userBuildingDiv" class="form-group">
        <span class="p">*</span>
        <label for="building">宿舍楼</label>
        <input type="text" name="userBuilding" id="userBuilding" placeholder="如：七栋" id="building" class="register">
        <label id="userBuildingMsg" class="Msg"></label><br><br>
        </div>

        <div id="userRoomDiv" class="form-group">
        <span class="p">*</span>
        <label for="room">宿舍号</label>
        <input type="text" name="userRoom" id="userRoom" placeholder="如：521" id="room" class="register">
        <label id="userRoomMsg" class="Msg"></label><br><br>
        </div>

        <div class="form-group">
        <input type="checkbox" class="checkbox">
        <span style="font-size:15px">我已阅读并同意《用户注册协议》</span>
        <br><br>
        </div>

        <input type="submit" value="同意以上协议并注册" class="submit"><br>
    </form>
</div>
</body>
</html>