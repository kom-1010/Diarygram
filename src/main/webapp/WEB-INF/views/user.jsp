<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User</title>
</head>
<body>
<h1>--------- user --------------</h1>
<h3>Name : ${user.name}</h3>
<h3>Password : ${user.password}</h3>
<h1>--------- post --------------</h1>
<h3>Title : ${post.title}</h3>
<h3>Content : ${post.content}</h3>
<h3>Author : ${post.user_id}</h3>
<h3>Created : ${post.created_at}</h3>
</body>
</html>
