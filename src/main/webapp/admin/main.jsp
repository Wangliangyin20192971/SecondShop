<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2022/4/8
  Time: 13:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1,user-scalable=no">
    <title>main</title>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"
          integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
    <!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap-theme.min.css"
          integrity="sha384-6pzBo3FDv/PJ8r2KRkGHifhEocL+1X2rVCTTkUfGk7/0pbek5mMa1upzvWbrUbOZ" crossorigin="anonymous">
    <style>
        body{
            background: url(../img/bg.jpeg);
        }
        img {
            width: 100%;
        }

        .damu-carousel {
            margin: 80px auto;
        }

        .damu-carousel,
        .damu-carousel .item {
            height: 500px;
            overflow: hidden;
        }

        .carousel-caption {
            bottom: 10%;
        }

        @media only screen and (max-width:768px) {
            .carousel-caption {
                bottom: 5%;
            }

            .damu-carousel,
            .damu-carousel .item {
                height: 200px;
            }
        }

        .thumbnail img {
            width: auto;
        }

        .damu-threec {
            margin-top: 50px;
            margin-left: -15px;
        }

        .damu-threec .row{
            margin-left: 7px;
        }

        .damu-threec h3{
            margin-left: 15px;
        }

        .damu-hr {
            margin: 50px auto;
        }

        .damu-hr hr {
            border: 1px solid gray;
        }

        .nav li a {
            display: block;
            width: 100%;
            height: 100%;
        }
        .navbar-yin{
            background:  rgb(166, 202, 211) !important;
        }
        .container{
            background-color: #fff;
        }
        a{
            color: #000;
        }
    </style>
</head>
<body>
<!-- 导航 -->
<nav class="navbar navbar-default navbar-fixed-top navbar-yin">
    <div class="container navbar-yin">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">校园二手交易市场</a>
        </div>
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                       aria-haspopup="true" aria-expanded="false">商品分类 <span class="caret"></span></a>
                    <ul class="dropdown-menu" id="damu-nav">
                        <li><a href="#book">精美图书</a></li>
                        <li><a href="#elec">电子数码</a></li>
                        <li><a href="#ride">校园代步</a></li>
                        <li><a href="#dail">日用商品</a></li>
                        <li><a href="#bags">精包服饰</a></li>
                    </ul>
                </li>
                <li><a href="#" data-target="#myModal" data-toggle="modal">关于</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="${pageContext.request.contextPath}/toMessage">个人中心</a></li>
                <li><a href="#">欢迎你，<span>${USER_SESSION.userName}</span></a></li>
                <li><a href="${pageContext.request.contextPath}/logout">退出</a></li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
<div class="container">
    <!-- 轮播图 -->
    <div id="carousel-example-generic" class="carousel slide damu-carousel" data-ride="carousel"
         data-interval="1000">
        <!-- Indicators -->
        <ol class="carousel-indicators">
            <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
            <li data-target="#carousel-example-generic" data-slide-to="1"></li>
            <li data-target="#carousel-example-generic" data-slide-to="2"></li>
            <li data-target="#carousel-example-generic" data-slide-to="3"></li>
            <li data-target="#carousel-example-generic" data-slide-to="4"></li>
        </ol>

        <!-- Wrapper for slides -->
        <div class="carousel-inner" role="listbox">
            <div class="item">
                <img src="../img/0.jpg" alt="...">
            </div>
            <div class="item active">
                <img src="../img/1.jpg" alt="...">
            </div>
            <div class="item">
                <img src="../img/2.jpg" alt="...">
            </div>
            <div class="item">
                <img src="../img/3.jpg" alt="...">
            </div>
            <div class="item">
                <img src="../img/4.jpg" alt="...">
            </div>
        </div>

        <!-- Controls -->
        <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
            <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
            <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
        </a>
    </div>
    <!-- 分割线 -->
    <div class="damu-hr">
        <hr>
    </div>
    <!-- 栅栏 -->
    <div class="damu-threec">
        <h3>精品特卖</h3>
        <div class="row">
            <c:forEach items="${SpecGoods}" var="goods">
                <a href="${pageContext.request.contextPath}/detail?id=${goods.goodsId}">
                    <div class="col-md-3 damu-thumbnail text-center">
                        <img src="../img/${goods.goodsUrl}" alt="图片">
                        <div class="caption">
                            <h3>${goods.goodsName}</h3>
                            <h4>${goods.goodsPrice}</h4>
                            <p>${goods.goodsMessage}</p>
                        </div>
                    </div>
                </a>
            </c:forEach>
        </div>
    </div>
    <!-- 分割线 -->
    <div class="damu-hr">
        <hr>
    </div>
    <!-- 标签页 -->
    <div id="damu-tab">
        <h2>商品分类</h2>
        <ul class="nav nav-tabs" role="tablist" id="damu-list">
            <li role="presentation" class="active"><a href="#book" aria-controls="Chrome" role="tab" data-toggle="tab">精美图书</a></li>
            <li role="presentation"><a href="#elec" aria-controls="Firefox" role="tab" data-toggle="tab">电子数码</a></li>
            <li role="presentation"><a href="#ride" aria-controls="Safari" role="tab" data-toggle="tab">校园代步</a></li>
            <li role="presentation"><a href="#dail" aria-controls="Opera" role="tab" data-toggle="tab">日用商品</a></li>
            <li role="presentation"><a href="#bags" aria-controls="IE" role="tab" data-toggle="tab">精包服饰</a></li>
        </ul>
        <div class="tab-content">
            <div role="tabpanel" class="tab-pane active" id="book">
                <!-- 栅栏 -->
                <div class="container damu-threec">
                    <div class="container-fluid">
                        <div class="row">
                            <c:forEach items="${BookGoods}" var="goods">
                                <a href="${pageContext.request.contextPath}/detail?id=${goods.goodsId}">
                                    <div class="col-md-3 damu-thumbnail text-center">
                                        <img src="../img/${goods.goodsUrl}" alt="图片">
                                        <div class="caption">
                                            <h3>${goods.goodsName}</h3>
                                            <h4>${goods.goodsPrice}</h4>
                                            <p>${goods.goodsMessage}</p>
                                        </div>
                                    </div>
                                </a>
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </div>
            <div role="tabpanel" class="tab-pane" id="elec">
                <!-- 栅栏 -->
                <div class="container damu-threec">
                    <div class="container-fluid">
                        <div class="row">
                            <c:forEach items="${ElecGoods}" var="goods">
                                <a href="${pageContext.request.contextPath}/detail?id=${goods.goodsId}">
                                    <div class="col-md-3 damu-thumbnail text-center">
                                        <img src="../img/${goods.goodsUrl}" alt="图片">
                                        <div class="caption">
                                            <h3>${goods.goodsName}</h3>
                                            <h4>${goods.goodsPrice}</h4>
                                            <p>${goods.goodsMessage}</p>
                                        </div>
                                    </div>
                                </a>
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </div>
            <div role="tabpanel" class="tab-pane" id="ride">
                <!-- 栅栏 -->
                <div class="container damu-threec">
                    <div class="container-fluid">
                        <div class="row">
                            <c:forEach items="${RideGoods}" var="goods">
                                <a href="${pageContext.request.contextPath}/detail?id=${goods.goodsId}">
                                    <div class="col-md-3 damu-thumbnail text-center">
                                        <img src="../img/${goods.goodsUrl}" alt="图片">
                                        <div class="caption">
                                            <h3>${goods.goodsName}</h3>
                                            <h4>${goods.goodsPrice}</h4>
                                            <p>${goods.goodsMessage}</p>
                                        </div>
                                    </div>
                                </a>
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </div>
            <div role="tabpanel" class="tab-pane" id="dail">
                <!-- 栅栏 -->
                <div class="container damu-threec">
                    <div class="container-fluid">
                        <div class="row">
                            <c:forEach items="${DailGoods}" var="goods">
                                <a href="${pageContext.request.contextPath}/detail?id=${goods.goodsId}">
                                    <div class="col-md-3 damu-thumbnail text-center">
                                        <img src="../img/${goods.goodsUrl}" alt="图片">
                                        <div class="caption">
                                            <h3>${goods.goodsName}</h3>
                                            <h4>${goods.goodsPrice}</h4>
                                            <p>${goods.goodsMessage}</p>
                                        </div>
                                    </div>
                                </a>
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </div>
            <div role="tabpanel" class="tab-pane" id="bags">
                <!-- 栅栏 -->
                <div class="container damu-threec">
                    <div class="container-fluid">
                        <div class="row">
                            <c:forEach items="${BagsGoods}" var="goods">
                                <a href="${pageContext.request.contextPath}/detail?id=${goods.goodsId}">
                                    <div class="col-md-3 damu-thumbnail text-center">
                                        <img src="../img/${goods.goodsUrl}" alt="图片">
                                        <div class="caption">
                                            <h3>${goods.goodsName}</h3>
                                            <h4>${goods.goodsPrice}</h4>
                                            <p>${goods.goodsMessage}</p>
                                        </div>
                                    </div>
                                </a>
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
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
</body>
<script src="http://code.jquery.com/jquery-2.1.4.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"
        integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd"
        crossorigin="anonymous"></script>
<script>
    $("#damu-nav > li > a").click(function (e) {
        var href = $(this).attr("href");
        $("#damu-list > li > a[href=" + (href) + "]").tab('show');
        $(document).scrollTop($("#damu-tab").offset().top);
        e.preventDefault();
    })
</script>
</html>