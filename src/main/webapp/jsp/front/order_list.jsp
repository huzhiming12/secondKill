<%@page import="java.util.Date" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <base href="<%=basePath%>">
    <title>限时抢购</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="resource/css/bootstrap.min.css" type="text/css" rel="stylesheet">
    <link href="resource/css/1yms.css" type="text/css" rel="stylesheet">
</head>
<c:set var="nowDate" value="<%=new Date()%>"/>
<body background="#f7f7f7">
<div class="body_1yms">
    <br>
    <button class="btn btn-default btn-sm" onclick="history.go(-1)">返回</button>

    <c:forEach items="${orders}" var="order">
        <div class="panel panel-info">
            <!-- Default panel contents -->
            <div class="panel-heading">
                <span>订单号:<c:out value="${order.orderId}"/></span> &nbsp;&nbsp;
                <span>创建时间:<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${order.createTime}"/></span>
            </div>
            <div class="panel-body">
                <table class="table table-bordered">
                    <tr>
                        <td><img style="max-height: 100px" src="<c:out value="${order.imgURL}" />" alt=""></td>
                        <td><c:out value="${order.goodsName}"/></td>
                        <td>
                            <div style="text-decoration: line-through;margin-bottom: 10px"> 原价:
                                <c:out value="${order.goodsPrice}"/></div>
                            <div> 秒杀价:<c:out value="${order.killPrice}"/></div>
                        </td>
                    </tr>
                </table>
            </div>
        </div>
    </c:forEach>
</div>
<script type="text/javascript" src="resource/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="resource/js/bootstrap.min.js"></script>
<script type="text/javascript" src="resource/js/jquery.countdown.min.js"></script>
<script type="text/javascript" src="resource/js/seckill.js"></script>

</body>
</html>
