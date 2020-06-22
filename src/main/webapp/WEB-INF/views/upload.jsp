<%--
  Created by IntelliJ IDEA.
  User: kom27
  Date: 2020-06-20
  Time: 오전 10:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Upload</title>
</head>
<body>
<h1>Upload</h1>
<form action="/upload" method="post" enctype="multipart/form-data">
    <input type="file" name="image">
    <input  type="submit">
</form>
<img src="${url}" />
</body>
</html>
