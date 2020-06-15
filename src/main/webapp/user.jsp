<%@ page import="org.springframework.context.ApplicationContext" %>
<%@ page import="org.springframework.context.annotation.AnnotationConfigApplicationContext" %>
<%@ page import="kr.ac.jejunu.post.UserDao" %>
<%@ page import="kr.ac.jejunu.post.User" %><%--
  Created by IntelliJ IDEA.
  User: kom27
  Date: 2020-06-15
  Time: 오전 11:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    ApplicationContext applicationContext = new AnnotationConfigApplicationContext("kr.ac.jejunu.post");
    UserDao userDao = applicationContext.getBean("userDao", UserDao.class);
    User user = userDao.get(1);

%>
<html>
<head>
    <title>User</title>
</head>
<body>
<h1>Name : <%=user.getName()%></h1>
<h1>Password : <%=user.getPassword()%></h1>
</body>
</html>
