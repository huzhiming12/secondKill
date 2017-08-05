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

<body>
<c:set var="nowDate" value="<%=new Date()%>"/>
<div style="background: #f7f7f7;" class="back_1yms">

    <nav class="navbar navbar-inverse">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                        data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index">主页</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                </ul>

                <ul class="nav navbar-nav navbar-right">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                           aria-expanded="false">
                            <c:out value="${session.username}"/>
                            <span class="caret"></span>
                        </a>
                        <ul class="dropdown-menu">
                            <li><a href="orderList">订单</a></li>
                            <li role="separator" class="divider"></li>
                            <li><a href="logout">注销</a></li>
                        </ul>
                    </li>
                </ul>
                <form class="navbar-form navbar-right">
                    <div class="input-group">
                        <input type="text" class="form-control input-sm">
                        <span class="input-group-btn">
                            <button class="btn btn-primary btn-sm" type="button">
                                搜索
                            </button>
                        </span>
                    </div>
                </form>
            </div><!-- /.navbar-collapse -->
        </div><!-- /.container-fluid -->
    </nav>

    <br>
    <div id="myCarousel" class="carousel slide body_1yms">
        <!-- 轮播（Carousel）指标 -->
        <ol class="carousel-indicators">
            <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
            <li data-target="#myCarousel" data-slide-to="1"></li>
            <li data-target="#myCarousel" data-slide-to="2"></li>
        </ol>
        <!-- 轮播（Carousel）项目 -->
        <div class="carousel-inner">
            <div class="item active">
                <img src="resource/img/page1.jpg" style="clear: both; display: block; margin: auto;" alt="First slide">
            </div>
            <div class="item">
                <img src="resource/img/page2.jpg" style="clear: both; display: block; margin: auto;" alt="First slide">
            </div>
            <div class="item">
                <img src="resource/img/page3.jpg" style="clear: both; display: block; margin: auto;" alt="First slide">
            </div>
        </div>
        <!-- 轮播（Carousel）导航 -->
        <a class="carousel-control left" href="#myCarousel" data-slide="prev">&lsaquo;</a>
        <a class="carousel-control right" href="#myCarousel" data-slide="next">&rsaquo;</a>
    </div>


    <div class="body_1yms">

        <div class="ms_floor2">
            <div class="ms_floor2_title">
                <img src="resource/img/wenb2.png">
            </div>
            <ul class="floo2_ul">
                <!--第一行-->
                <c:forEach items="${killList}" var="kill" varStatus="num">
                    <li>
                        <div style="text-align: center;">
                            <a href="detail?killId=<c:out value='${kill.killId}'/>">
                                <img src="<c:out value='${kill.imgURL}'/> ">
                            </a>
                        </div>
                        <div class="floor2_bottom_text">
                            <div style="height: 170px">
                                <div class="floor2_right_title">
                                    <c:out value="${kill.goodsName}"/>
                                </div>
                                <div class="floor2_right_news">
                                    <c:out value="${kill.description}"/>
                                </div>
                                <div style="clear: both; height: 20px;"></div>
                                <div class="floor2_three">
                                    <div class="floor1_price">
                                        <div class="red floor1_three_fh">￥</div>
                                        <div class="red floor1_three_size">
                                            <c:out value="${kill.killPrice}"/>
                                        </div>
                                        <div class="yh">￥
                                            <c:out value="${kill.goodsPrice}"/>
                                        </div>
                                    </div>
                                    <div class="floor2_right">
                                        <div class="top">限量</div>
                                        <div class="bottom">
                                            <c:out value="${kill.limitNum}"/>
                                            件
                                        </div>
                                    </div>
                                </div>
                                <div style="clear: both;"></div>
                            </div>
                            <c:choose>
                                <c:when test="${kill.beginTime>nowDate}">
                                    <div class="floor1_time">
                                        <div class="time_text">离开始抢购还有：</div>
                                        <div class="timer-simple-seconds"
                                             datetime="<fmt:formatDate value="${kill.beginTime}" pattern="yyyy/MM/dd HH:mm:ss" /> ">
                                            <span class="day">0</span>天 * <span class="hour">00</span>时 * <span
                                                class="minute">00</span>分 * <span class="second">00</span>秒
                                        </div>
                                    </div>
                                </c:when>
                                <c:when test="${kill.beginTime<nowDate && kill.endTime>nowDate && kill.selled<kill.limitNum}">
                                    <div style="float: left; height: 40px; line-height: 40px; margin-top: 10px;">
                                        <span>已售<c:out value="${kill.selled}"/>件</span>
                                        <span class="time_text">剩余时间：</span>
                                        <span class="timer-simple-seconds"
                                              datetime="<fmt:formatDate value="${kill.endTime}" pattern="yyyy/MM/dd HH:mm:ss" /> ">
                                            <span class="day">0</span>天 * <span class="hour">00</span>时 * <span
                                                class="minute">00</span>分 * <span class="second">00</span>秒
                                        </span>
                                    </div>

                                    <a href="detail?killId=<c:out value='${kill.killId}'/>">
                                        <span class="subnow btn_now">抢购</span>
                                    </a>
                                </c:when>

                                <c:when test="${kill.selled>=kill.limitNum || kill.endTime<nowDate}">
                                    <div style="float: left; height: 40px; line-height: 40px; margin-top: 10px;">
                                        已售
                                        <c:out value="${kill.selled}"/>
                                        件
                                    </div>
                                    <a>
                                        <span class="subnow btn_over">已结束</span>
                                    </a>
                                </c:when>
                            </c:choose>


                        </div>
                    </li>
                    <c:if test="${num.index%2==0}">
                        <div class="center"></div>
                    </c:if>
                </c:forEach>
                <div style="clear: both"></div>
            </ul>

        </div>

    </div>
</div>
<div style="clear: both"></div>

<script type="text/javascript" src="resource/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="resource/js/bootstrap.min.js"></script>
<script type="text/javascript" src="resource/js/timer.js"></script>
</body>
</html>