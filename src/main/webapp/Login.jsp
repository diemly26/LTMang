<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Login</title>
</head>
<body>
<%
  String temp = "temp";
  session.setAttribute("temp", temp); // Sử dụng session mặc định
%>
<form action="CheckLoginServlet" method="post">
  Username: <input type="text" name="username"><br>
  Password: <input type="password" name="password"><br>
  <br>
  <input type="submit" value="Login">
  <input type="reset" value="Reset">
</form>
</body>
</html>
