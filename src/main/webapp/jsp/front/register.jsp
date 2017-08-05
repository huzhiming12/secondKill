<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <base href="<%=basePath%>">

    <title>用户注册</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link href="resource/css/register.css" rel="stylesheet" type="text/css" media="all"/>
</head>
<body>
<!-- main -->
<div class="main main-agileits">
    <h1>用户注册</h1>
    <div class="main-agilerow">
        <div class="signup-wthreetop">
            <h2>欢迎注册抢购网</h2>
            <p>Lorem ipsum dolor sit amet</p>
        </div>
        <div class="contact-wthree">
            <form action="register" id="registerForm" method="post">
                <h3>Step 1 :</h3>
                <div class="form-w3step1">
                    <input type="text" name="username" id="username" placeholder="用户名" required="">
                    <input type="text" name="mobilePhone" id="phone" class="agileits-btm" placeholder="手机号" required="">
                </div>
                <h3>Step 2 :</h3>
                <div class="form-w3step1">
                    <input type="password" name="password" id="pwd" placeholder="密码" required="">
                    <input type="password" id="compwd" class="agileits-btm" placeholder="密码确认" required="">
                </div>
                <h3>Step 3 :</h3>
                <div class="form-w3step1 w3ls-formrow">
                    <input type="text" name="realName" placeholder="真实姓名" required="">
                    <input type="email" name="email" placeholder="邮箱" required="">
                    <input type="text" id="address" class="agileits-btm" name="address" placeholder="地址" required="">
                </div>
                <input type="button" id="addbtn" value="注册">
            </form>
        </div>
    </div>
</div>
<div class="w3copyright-agile">
    <p>
        © 2017 Client Signup Form. All rights reserved | Design by
        <a href="http://w3layouts.com/" target="_blank">W3layouts</a>
    </p>
</div>
<script type="text/javascript" src="resource/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="resource/js/seckill.js"></script>
<script type="text/javascript">
    $("#addbtn").click(function () {
        secKill.register.register();
    });
</script>

</body>
</html>