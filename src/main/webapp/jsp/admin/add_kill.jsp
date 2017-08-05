<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
            .navbar-text.pull-right {
                float: none;
                padding-left: 5px;
                padding-right: 5px;
            }
        }
    </style>

</head>
<body>


<div class="alert" style="margin-left: 50px; margin-right: 50px; margin-top: 30px;display:
<c:if test="${addResult==null}">none</c:if> ">
    <button type="button" class="close" data-dismiss="alert">&times;</button>
    <strong>提示：</strong>
    <c:out value="${addResult.msg}"></c:out>
</div>
<form action="admin/addKill" method="post" class="definewidth m20" style="padding-top: 10px;">
    <table class="table table-bordered table-hover definewidth m10">
        <tr>
            <td width="10%" class="tableleft">选择商品</td>
            <td>
                <select name="goods.goodsId">
                    <c:forEach items="${result.data}" var="goods">
                        <option value='<c:out value="${goods.goodsId}"/>'>
                            <c:out value="${goods.goodsName}"/>
                        </option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td class="tableleft">秒杀开始时间</td>
            <td>
                <input type="text" name="beginTime"/>
            </td>
        </tr>
        <tr>
            <td class="tableleft">秒杀结束时间</td>
            <td>
                <input type="text" name="endTime"/>
            </td>
        </tr>
        <tr id="type1">
            <td class="tableleft">总份数</td>
            <td>
                <input type="text" name="limitNum" value="0"/>
            </td>
        </tr>
        <tr>
            <td class="tableleft">秒杀价格</td>
            <td>
                <input type="text" name="killPrice"/>
            </td>
        </tr>

        <tr>
            <td class="tableleft"></td>
            <td>
                <button type="submit" class="btn btn-primary" type="button">添加</button>
                &nbsp;&nbsp;
                <button type="button" class="btn btn-success">返回列表</button>
            </td>
        </tr>
    </table>
</form>
</body>
</html>