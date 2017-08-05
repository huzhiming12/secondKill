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



    <script type="text/javascript" charset="utf-8">
        jQuery(document).ready(function ($) {

            $('div#countdown-timer1').countdown("2016/5/20", function (event) {
                var $this = $(this);
                switch (event.type) {
                    case "seconds":
                    case "minutes":
                    case "hours":
                    case "days":
                    case "weeks":
                    case "daysLeft":
                        $this.find('span#' + event.type).html(event.value);
                        break;
                    case "finished":
                        $this.hide();
                        break;
                }
            });

            $('div#countdown-timer2').countdown("2016/6/29", function (event) {
                var $this = $(this);
                switch (event.type) {
                    case "seconds":
                    case "minutes":
                    case "hours":
                    case "days":
                    case "weeks":
                    case "daysLeft":
                        $this.find('span#' + event.type).html(event.value);
                        break;
                    case "finished":
                        $this.hide();
                        break;
                }

            });

        });
    </script>
</head>
<c:set var="nowDate" value="<%=new Date()%>"/>
<body background="#f7f7f7">
<div class="body_1yms">

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
                    <div style="height: 280px;">
                        <div class="floor1_right_title">
                            <c:out value="${kill.goodsName}"></c:out>
                        </div>
                        <div class="floor1_right_news">
                            <c:out value="${kill.description}"></c:out>
                        </div>

                        <div class="floor1_time">
                            <c:choose>
                                <c:when test="${kill.beginTime>nowDate}">
                                    <div class="time_tb">
                                        <img src="resource/img/time.png">
                                    </div>
                                    <div class="time_text">离开始抢购还有：</div>
                                    <div class="timer-simple-seconds"
                                         datetime=" <fmt:formatDate value="${kill.beginTime}" pattern="yyyy/MM/dd HH:mm:ss" /> ">
                                        <span class="day">0</span>天 * <span class="hour">00</span>时 *
                                        <span class="minute">00</span>分 * <span class="second">00</span>秒
                                    </div>
                                </c:when>
                                <c:when test="${kill.beginTime<nowDate && kill.endTime > nowDate}">
                                    <div class="time_tb">
                                        <img src="resource/img/time.png">
                                    </div>
                                    <div class="time_text">离结束还剩：</div>
                                    <div class="timer-simple-seconds"
                                         datetime="<fmt:formatDate value="${kill.endTime}" pattern="yyyy/MM/dd HH:mm:ss" /> ">
                                        <span class="day">0</span>天 * <span class="hour">00</span>时 *
                                        <span class="minute">00</span>分 * <span class="second">00</span>秒
                                    </div>
                                    <div class="has">
                                        <img src="resource/img/has.png">
                                    </div>
                                    <div class="red" style="font-weight: bold;">
                                        <c:out value="${kill.selled}"/>
                                    </div>
                                    <div class="te">已抢</div>
                                </c:when>
                            </c:choose>
                        </div>
                    </div>
                    <div class="floor1_three">
                        <div class="floor1_price">
                            <div class="red floor1_three_fh">￥</div>
                            <div class="red floor1_three_size">
                                <c:out value="${kill.killPrice}"/>
                            </div>
                            <div class="yh">
                                ￥
                                <c:out value="${kill.goodsPrice}"/>
                            </div>
                        </div>
                        <c:choose>
                            <c:when test="${kill.beginTime > nowDate }">
                                <div class="subnow btn_over">未开始</div>
                            </c:when>
                            <c:when test="${kill.endTime < nowDate }">
                                <div class="subnow btn_over">已结束</div>
                            </c:when>
                            <c:otherwise>
                                <a href="">
                                    <span class="subnow btn_now">抢购</span>
                                </a>
                            </c:otherwise>
                        </c:choose>

                    </div>
                </div>
            </div>
        </div>
        <div style="clear: both; height: 20px"></div>
    </div>


</div>
<script type="text/javascript" src="resource/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="resource/js/bootstrap.min.js"></script>
<script type="text/javascript" src="resource/js/timer.js"></script>
</body>
</html>
