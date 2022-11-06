<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2022/3/31
  Time: 19:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>个人中心</title>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"
          integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
    <!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap-theme.min.css"
          integrity="sha384-6pzBo3FDv/PJ8r2KRkGHifhEocL+1X2rVCTTkUfGk7/0pbek5mMa1upzvWbrUbOZ" crossorigin="anonymous">
    <style>
        body {
            margin: 0;
            padding: 0;
            background: url("../img/bg.jpeg");
        }

        .menu {
            margin-top: 50px;
        }

        .left {
            float: left;
            width: 20%;
            height: 660px;
            text-align: center;
            background: rgb(166, 202, 211)
        }

        .left ul {
            padding: 20px 0;
        }

        .left ul li {
            list-style: none;
            margin-bottom: 40px;
            font-size: 20px;
        }

        .left ul li a {
            text-decoration: none;
            color: #fff;
            list-style: none;
        }

        .right {
            float: right;
            width: 80%;
        }

        iframe {
            width: 100%;
            height: 660px;
        }

        .navbar-yin {
            background: rgb(166, 202, 211) !important;
        }
    </style>
</head>
<body>
<!-- 导航 -->
<nav class="navbar navbar-default navbar-fixed-top navbar-yin">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">校园二手交易市场</a>
        </div>
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li><a href="#" data-target="#myModal" data-toggle="modal">关于</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li class="active"><a>个人中心</a></li>
                <li><a href="${pageContext.request.contextPath}/toMain">返回首页</a></li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
<!-- 模态框 -->
<div class="modal fade" tabindex="-1" role="dialog" id="myModal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">关于</h4>
            </div>
            <div class="modal-body">
                <p>欢迎来到校园二手交易网站！</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div>
<div class="container menu">
    <!-- 左导航 -->
    <div class="left">
        <ul class="sidebar-menu">
            <li>
                <a href="${pageContext.request.contextPath}/toMessage">
                    <i class="fa fa-dashboard"></i> <span>我的信息</span>
                </a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/showSellGoods" target="iframe">
                    <i class="fa fa-circle-o"></i>出售商品信息
                </a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/showBuyGoods" target="iframe">
                    <i class="fa fa-circle-o"></i>购买商品信息
                </a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/showCollection" target="iframe">
                    <i class="fa fa-circle-o"></i>我的收藏信息
                </a>
            </li>
        </ul>
    </div>
    <!-- 右内容 -->
    <div class="right">
        <iframe width="100%" id="iframe" name="iframe" frameborder="0"
                src="${pageContext.request.contextPath}/selectNewUsers"></iframe>
    </div>
</div>
</body>
<script src="http://code.jquery.com/jquery-2.1.4.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"
        integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd"
        crossorigin="anonymous"></script>
</html>