<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>

<!DOCTYPE html>
<html lang="en">

<head>
    <base href="<%=basePath%>">
    <meta charset="utf-8">
    <title>抢购网</title>
    <link rel="stylesheet" type="text/css" href="resource/css/login.css">
    <link type="text/css" href="resource/css/bootstrap.min.css">

</head>
<body>

<div class="alert" style="margin-left: 50px; margin-right: 50px; margin-top: 30px;display:
<c:if test="${result==null}">none</c:if> ">
    <button type="button" class="close" data-dismiss="alert">&times;</button>
    <strong>提示：</strong>
    <c:out value="${result.msg}"></c:out>
</div>

<div class="container">
    <section id="content">
        <form action="login" method="post">
            <h1>用户登录</h1>
            <div>
                <input type="text" name="username" placeholder="用户名" required="" id="username"/>
            </div>
            <div>
                <input type="password" name="password" placeholder="密码" required="" id="password"/>
            </div>
            <div>
                <input type="submit" value="登录"/>
                <%--<a href="#">Lost your password?</a>--%>
                <a href="registerUI">注册</a>
            </div>
        </form><!-- form -->
        <div class="button">
            <%--<a href="#">Download type file</a>--%>
        </div>
    </section>
</div>
<script type="javascript" href="resource/js/jquery-3.2.1.min.js"></script>
<script type="javascript" href="resource/js/bootstrap.min.js"></script>
</body>
</html>