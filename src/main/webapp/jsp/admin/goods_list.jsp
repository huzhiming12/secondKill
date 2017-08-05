<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<form class="form-inline definewidth m20" action="index.html"
      method="get">
    商品名称：
    <input type="text" name="username" id="username"
           class="abc input-default" placeholder="" value="">
    &nbsp;&nbsp;
    <button type="submit" class="btn btn-primary">查询</button>
    &nbsp;&nbsp;
    <a type="button" class="btn btn-success" id="addnew"
       href="admin/addGoodsUI">添加商品</a>
</form>
<table class="table table-bordered table-hover definewidth m10">
    <thead>
    <tr>
        <th>编号</th>
        <th>商品名称</th>
        <th>商品描述</th>
        <th>商品价格</th>
        <th>图片</th>
    </tr>
    </thead>
    <c:forEach items="${result.data}" var="goods">
        <tr>
            <td><c:out value="${goods.goodsId}"></c:out></td>
            <td style="width: 150px;"><c:out value="${goods.goodsName}"></c:out></td>
            <td><c:out value="${goods.description}"></c:out></td>
            <td>￥<c:out value="${goods.goodsPrice}"></c:out></td>
            <td style="width: 200px;"><img alt="" src="${goods.imgURL }"></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>