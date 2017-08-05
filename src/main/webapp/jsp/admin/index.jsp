<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <base href="<%=basePath%>">
    <title>后台管理系统</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link href="jsp/admin/assets/css/dpl-min.css" rel="stylesheet" type="text/css"/>
    <link href="jsp/admin/assets/css/bui-min.css" rel="stylesheet" type="text/css"/>
    <link href="jsp/admin/assets/css/main-min.css" rel="stylesheet" type="text/css"/>
</head>
<body>

<div class="header">

    <div class="dl-title">
        <!--<img src="/chinapost/Public/assets/img/top.png">-->
    </div>

    <div class="dl-log">
        欢迎您，<span class="dl-log-user">root</span>
        <a href="/chinapost/index.php?m=Public&a=logout" title="退出系统" class="dl-log-quit">[退出]</a>
    </div>
</div>
<div class="content">
    <div class="dl-main-nav">
        <div class="dl-inform">
            <div class="dl-inform-title">
                <s class="dl-inform-icon dl-up"></s>
            </div>
        </div>
        <ul id="J_Nav" class="nav-list ks-clear">
            <li class="nav-item dl-selected">
                <div class="nav-item-inner nav-home">系统管理</div>
            </li>
            <li class="nav-item dl-selected">
                <div class="nav-item-inner nav-order">业务管理</div>
            </li>
        </ul>
    </div>
    <ul id="J_NavContent" class="dl-tab-conten">

    </ul>
</div>
<script type="text/javascript" src="jsp/admin/assets/js/jquery-1.8.1.min.js"></script>
<script type="text/javascript" src="jsp/admin/assets/js/bui-min.js"></script>
<script type="text/javascript" src="jsp/admin/assets/js/common/main-min.js"></script>
<script type="text/javascript" src="jsp/admin/assets/js/config-min.js"></script>
<script>
    BUI.use('common/main', function () {
        var config = [{
            id: '1',
            menu: [{
                text: '系统管理',
                items: [{
                    id: '1',
                    text: '用户管理',
                    href: 'admin/userManage'
                }, {
                    id: '2',
                    text: '商品管理',
                    href: 'admin/goodsManager'
                }, {
                    id: '3',
                    text: '限时秒杀',
                    href: 'admin/killManage'
                },]
            }]
        }, {
            id: '7',
            homePage: '9',
            menu: [{
                text: '业务管理',
                items: [{
                    id: '9',
                    text: '查询业务',
                    href: 'Node/index.html'
                }]
            }]
        }];
        new PageUtil.MainPage({
            modulesConfig: config
        });
    });
</script>
<div style="text-align: center;">
    <p>
        来源：
        <a href="http://www.mycodes.net/" target="_blank">源码之家</a>
    </p>
</div>
</body>
</html>