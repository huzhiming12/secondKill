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
    <title></title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="jsp/admin/Css/bootstrap.css"/>
    <link rel="stylesheet" type="text/css" href="jsp/admin/Css/bootstrap-responsive.css"/>
    <link rel="stylesheet" type="text/css" href="jsp/admin/Css/style.css"/>
    <script type="text/javascript" src="jsp/admin/Js/jquery.js"></script>
    <script type="text/javascript" src="jsp/admin/Js/jquery.sorted.js"></script>
    <script type="text/javascript" src="jsp/admin/Js/bootstrap.js"></script>
    <script type="text/javascript" src="jsp/admin/Js/ckform.js"></script>
    <script type="text/javascript" src="jsp/admin/Js/common.js"></script>


    <style type="text/css">
        body {
            padding-bottom: 40px;
        }

        .sidebar-nav {
            padding: 9px 0;
        }

        @media ( max-width: 980px) {
            /* Enable use of floated navbar text */
            .navbar-text.pull-right {
                float: none;
                padding-left: 5px;
                padding-right: 5px;
            }
        }
    </style>
</head>
<body>
<form class="form-inline definewidth m20" action="index.html" method="get">
    商品名称：
    <input type="text" name="username" id="username" class="abc input-default" placeholder="" value="">
    &nbsp;&nbsp;
    <button type="submit" class="btn btn-primary">查询</button>
    &nbsp;&nbsp;
    <a type="button" class="btn btn-success" id="addnew" href="admin/addKillUI">添加秒杀</a>
</form>
<table class="table table-bordered table-hover definewidth m10">
    <thead>
    <tr>
        <th>编号</th>
        <th>秒杀商品</th>
        <th>秒杀价格</th>
        <th>图片</th>
        <th>开始时间</th>
        <th>结束时间</th>
        <th>总份数</th>
        <th>销量</th>
        <th>操作</th>
    </tr>
    </thead>

    <c:forEach items="${result.data}" var="kill">
        <tr>
            <td>
                <c:out value="${kill.killId}"></c:out>
            </td>
            <td>
                <c:out value="${kill.goodsName}"></c:out>
            </td>
            <td>
                ￥
                <c:out value="${kill.killPrice}"></c:out>
            </td>
            <td style="width: 200px">
                <img alt="" src="<c:out value="${kill.imgURL}"></c:out>"/>
            </td>
            <td>
                <fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${kill.beginTime}"/>
            </td>
            <td>
                <fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${kill.endTime}"/>
            </td>
            <td>
                <c:out value="${kill.limitNum}"></c:out>
            </td>
            <td>
                <c:out value="${kill.selled}"></c:out>
            </td>
            <td>
                <c:choose>
                    <c:when test="${kill.state==0}">
                        <a onclick="killList.update(${kill.killId}) ">下架</a>
                    </c:when>
                    <c:otherwise>
                        <a href="admin/delKill?killId=<c:out value="${kill.killId}"/> ">上架</a>
                    </c:otherwise>
                </c:choose>
            </td>
        </tr>
    </c:forEach>
</table>
<script type="text/javascript">
    var killList = {
        update: function (id) {
            $.ajax({
                url: "admin/delKill",
                data: {killId: id},
                success: function (data) {
                    alert(data["msg"]);
                    window.location.reload();
                },
            });
        }
    }
</script>
</body>
</html>