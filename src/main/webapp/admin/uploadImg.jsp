<%--
  Created by IntelliJ IDEA.
  User: 25774
  Date: 2022/5/4
  Time: 20:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <script>
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
    <img id="myImgxx">
    <form method="post" action="/uploadImg" enctype="multipart/form-data">
        <input type="file" name="file" onchange="showImg(this)">
        <input type="submit" value="提交">
    </form>
</body>
</html>
