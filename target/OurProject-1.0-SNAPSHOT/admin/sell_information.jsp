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
    <title>出售商品信息</title>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"
          integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
    <!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap-theme.min.css"
          integrity="sha384-6pzBo3FDv/PJ8r2KRkGHifhEocL+1X2rVCTTkUfGk7/0pbek5mMa1upzvWbrUbOZ" crossorigin="anonymous">
    <style>
        .add {
            display: block;
            font-size: 16px;
            width: 80px;
            height: 30px;
            margin-left: 20px;
        }
        img{
            width: 50px;
            height: 50px;
        }
    </style>
    <script>
        /*function getFile() {
            $("#getF").click();
        }*/
        function showImg(file) {
            var reader = new FileReader();
            reader.onload = function (evt) {
                document.getElementById('myImgxx').src = evt.target.result;
            }
            reader.readAsDataURL(file.files[0]);
        }

    </script>
</head>
<body>

<div class="box-header with-border">
    <h3 class="box-title">出售商品信息</h3>
</div>
<div class="box-body">
    <!-- 数据表格 -->
    <table id="dataList" class="table table-bordered table-striped table-hover dataTable text-center">
        <thead>
        <tr>
            <th class="sorting">商品id</th>
            <th class="sorting">商品名称</th>
            <th class="sorting">商品图片</th>
            <th class="sorting">商品信息</th>
            <th class="sorting">商品价格</th>
            <th class="sorting">商品类型</th>
            <th class="sorting">创建时间</th>
            <th class="text-center">操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${pageResult.rows}" var="sell">
            <tr>
                <c:if test="${sell.userId == USER.userId}">

                        <td>${sell.goodsId}</td>
                        <td>${sell.goodsName}</td>
                        <td>
                            <c:if test="${sell.goodsUrl != null}">
                                <img src="${pageContext.request.contextPath}/img/${sell.goodsUrl}" alt="图片">
                            </c:if>
                            <%--<c:if test="${sell.goodsUrl == null}">
                                <button type="button" class="btn bg-olive btn-xs" onclick="addImg(${sell.goodsId})">上传</button>
                            </c:if>--%>
                                <%--<form method="post" action="/uploadImg" enctype="multipart/form-data">
                                        <input style="display: none" type="file" name="file" id ="getF" onchange="showImg(this)">
                                        <input type="button" id= "submit" value="提交" onclick="getFile()">
                                    </form>--%>
                            <c:if test="${sell.goodsUrl == null}">
                                <img id="myImgxx">
                                <form method="post" action="/uploadImg" enctype="multipart/form-data">
                                    <input type="hidden" name="goodsId" id="goodsId" value="${sell.goodsId}">
                                    <input type="file" name="file" onchange="showImg(this)">
                                    <input type= "submit" value="提交">
                                </form>
                            </c:if>
                        </td>
                        <td>${sell.goodsMessage}</td>
                        <td>${sell.goodsPrice}</td>
                        <td>
                            <c:if test="${sell.goodsType == 1}">精美图书</c:if>
                            <c:if test="${sell.goodsType == 2}">电子数码</c:if>
                            <c:if test="${sell.goodsType == 3}">校园代步</c:if>
                            <c:if test="${sell.goodsType == 4}">日用商品</c:if>
                            <c:if test="${sell.goodsType == 5}">精包服饰</c:if>
                        </td>
                        <td>${sell.goodsCreateTime}</td>
                        <td class="text-center">
                            <c:if test="${sell.goodsState == 0}">
                                <button type="button" class="btn bg-olive btn-xs" data-toggle="modal" onclick="deleteSell(${sell.goodsId})">删除</button>
                            </c:if>
                            <c:if test="${sell.goodsState == 1}">
                                <button type="button" class="btn bg-olive btn-xs" onclick="confirmShipment(${sell.goodsId})">确认发货</button>
                            </c:if>
                            <c:if test="${sell.goodsState == 2}">
                                <button type="button" class="btn bg-olive btn-xs" disabled="true">已发货</button>
                            </c:if>
                        </td>
                </c:if>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <button type="button" class="btn bg-olive btn-xs add" data-toggle="modal"
            data-target="#addSellModal" onclick="resetStyle()"> 添加商品
    </button>
    <!-- 数据表格 /-->
</div>
<!-- 添加和编辑图书的模态窗口 -->
<div class="modal fade" id="addSellModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
     aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h3 id="myModalLabel">商品信息</h3>
            </div>
            <div class="modal-body">
<%--                id="addSell"method="post" action="/uploadImg" enctype="multipart/form-data"--%>
                <form id="addSell">
                    <span><input type="hidden" id="ebid" name="id"></span>
                    <table id="addOrEditTab" class="table table-bordered table-striped" width="800px">
                        <%--图书的id,不展示在页面--%>
                        <tr>
                            <td>商品名称</td>
                            <td><input class="form-control" placeholder="商品名称" name="goodsName" id="goodsName"></td>
                            <td>商品信息</td>
                            <td><input class="form-control" placeholder="商品信息" name="goodsMessage" id="goodsMessage">
                            </td>
                        </tr>
                        <tr>
                            <td>商品价格</td>
                            <td><input class="form-control" placeholder="商品价格" name="goodsPrice" id="goodsPrice"></td>
                            <td>商品类型</td>
                            <td>
                                <select class="form-control" placeholder="商品类型" name="goodsType" id="goodsType">
                                    <option value=" ">-请选择-</option>
                                    <option value="1" >精美图书</option>
                                    <option value="2" >电子数码</option>
                                    <option value="3" >校园代步</option>
                                    <option value="4" >日用商品</option>
                                    <option value="5" >精品服饰</option>
                                </select>
                            </td>
                        </tr>
                        <%--<tr>
                            <td>商品路径</td>
                            <td>
                                <input class="form-control" type="file" name="goodsUrl" id= "goodsUrl" onchange="showImg(this)">
                                <input type="submit" value="提交">
                            </td>
                            <td>商品图片</td>
                            <td>
                                <img id="myImgxx">
                            </td>
                        </tr>--%>
                    </table>
                </form>
            </div>
            <div class="modal-footer">
                <button class="btn btn-success" data-dismiss="modal" aria-hidden="true" id="aoe" disabled
                        onclick="addSell()">保存
                </button>
                <button class="btn btn-default" data-dismiss="modal" aria-hidden="true">关闭</button>
            </div>
        </div>
    </div>
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