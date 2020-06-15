<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User</title>
    <link rel="stylesheet" href="/css/user.css" />
</head>
<body>
<h1>Blue Font</h1>
<h3 id="title">Title : ${post.title}</h3>
<h3>Content : ${post.content}</h3>
<h3>Author : ${user.name}</h3>
<h3>Created : ${post.created_at}</h3>
<script src="/js/user.js/"></script>
</body>
</html>
