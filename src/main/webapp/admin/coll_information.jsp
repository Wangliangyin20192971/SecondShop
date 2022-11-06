<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2022/4/13
  Time: 16:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>收藏商品信息</title>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"
          integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
    <!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap-theme.min.css"
          integrity="sha384-6pzBo3FDv/PJ8r2KRkGHifhEocL+1X2rVCTTkUfGk7/0pbek5mMa1upzvWbrUbOZ" crossorigin="anonymous">
    <style>
        img{
            /*display: block;
            text-align: center;*/
            width: 50px;
            height: 30px;
        }
    </style>
</head>
<body>

<div class="box-header with-border">
    <h3 class="box-title">收藏商品信息</h3>
</div>
<div class="box-body">
    <!-- 数据表格 -->
    <table id="dataList" class="table table-bordered table-striped table-hover dataTable text-center">
        <thead>
        <tr>
            <th class="sorting">收藏id</th>
            <th class="sorting">商品Id</th>
            <th class="sorting">商品名称</th>
            <th class="sorting">商品信息</th>
            <th class="sorting">商品图片</th>
            <th class="sorting">商品价格</th>
            <th class="sorting">商品类型</th>
            <th class="text-center">操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${pageResult.rows}" var="coll">
        <tr>
            <c:if test="${coll.userId == USER.userId}">
                <td>${coll.collId}</td>
                <td>${coll.goodsId}</td>
                <td>${coll.goodsName}</td>
                <td>${coll.goodsMessage}</td>
                <td>
                    <img src="${pageContext.request.contextPath}/img/${coll.goodsUrl}" alt="图片">
                </td>
                <td>${coll.goodsPrice}</td>
                <td>
                    <c:if test="${coll.goodsType == 1}">精美图书</c:if>
                    <c:if test="${coll.goodsType == 2}">电子数码</c:if>
                    <c:if test="${coll.goodsType == 3}">校园代步</c:if>
                    <c:if test="${coll.goodsType == 4}">日用商品</c:if>
                    <c:if test="${coll.goodsType == 5}">精包服饰</c:if>
                </td>
                <td class="text-center">
                    <button type="button" class="btn bg-olive btn-xs" data-toggle="modal"
                            onclick="deleteColl(${coll.collId})"> 删除
                    </button>
                </td>
            </c:if>
        </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
<script src="http://code.jquery.com/jquery-2.1.4.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"
        integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd"
        crossorigin="anonymous"></script>
<script src="../js/my.js"></script>
<script src="../js/pagination.js"></script>

</html>