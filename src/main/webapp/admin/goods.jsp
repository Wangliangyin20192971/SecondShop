<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2022/4/14
  Time: 20:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品信息</title>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"
          integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
    <!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap-theme.min.css"
          integrity="sha384-6pzBo3FDv/PJ8r2KRkGHifhEocL+1X2rVCTTkUfGk7/0pbek5mMa1upzvWbrUbOZ" crossorigin="anonymous">
    <style>
        img {
            width: 100%;
        }
        .thumbnail img {
            width: auto;
        }
        .damu-threec h3{
            margin-left: 15px;
        }

        .damu-hr hr {
            border: 1px solid gray;
        }
        .nav li a {
            display: block;
            width: 100%;
            height: 100%;
        }
        .row{
            width: 100%;
        }
    </style>
</head>
<body>
<div class="row">
    <c:forEach items="${pageResult.rows}" var="goods">
        <div class="col-md-3 damu-thumbnail text-center">
            <img src="../img/${goods.goodsUrl}">
            <div class="caption">
                <h3>${goods.goodsName}</h3>
                <h4>${goods.goodsPrice}</h4>
                <p>${goods.goodsMessage}</p>

            </div>
        </div>
    </c:forEach>
</div>
</body>
<script src="http://code.jquery.com/jquery-2.1.4.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"
        integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd"
        crossorigin="anonymous"></script>
</html>
