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
    <div class="ms_floor1">
        <div class="1yms_floor1_title">
            <img src="resource/img/wenb1.png">
        </div>

        <div style="clear: both; height: 20px"></div>

        <div class="ms_border">
            <div class="col-md-6 floor1_left" style="text-align: center;">
                <img src='<c:out value="${kill.imgURL}"></c:out>'>
            </div>
            <div class="col-md-6 floor1_right">
                <div class="floor1_right_text">
                    <div style="height: 260px;">
                        <div class="floor1_right_title">
                            <c:out value="${kill.goodsName}"></c:out>
                        </div>
                        <div class="floor1_right_news">
                            <c:out value="${kill.description}"></c:out>
                        </div>

                        <div class="floor1_time">

                            <div class="time_tb">
                                <img src="resource/img/time.png">
                            </div>
                            <div id="countdown_timer" class="time_text"></div>
                            <div class="has">
                                <img src="resource/img/has.png">
                            </div>
                            <div class="red" style="font-weight: bold;">
                                <c:out value="${kill.selled}"/>
                            </div>
                            <div class="te">已抢</div>
                        </div>
                    </div>
                    <div class="col-md-offset-9">
                        <span id="info" class="label label-warning" style="display: none"></span>
                    </div>
                    <div class="floor1_three">
                        <div class="floor1_price">
                            <div class="red floor1_three_fh">￥</div>
                            <div class="red floor1_three_size">
                                <c:out value="${kill.killPrice}"/>
                            </div>
                            <div class="yh">
                                ￥<c:out value="${kill.goodsPrice}"/>
                            </div>
                        </div>
                        <span id="btn_shop" class="subnow btn_now">抢购</span>
                    </div>
                </div>
            </div>
        </div>
        <div style="clear: both; height: 20px"></div>
    </div>


</div>
<script type="text/javascript" src="resource/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="resource/js/bootstrap.min.js"></script>
<script type="text/javascript" src="resource/js/jquery.countdown.min.js"></script>
<script type="text/javascript" src="resource/js/seckill.js"></script>
<script type="text/javascript">
    secKill.detail.init(${kill.killId}, ${nowDate.time}, ${kill.beginTime.time}, ${kill.endTime.time});
</script>
</body>
</html>
