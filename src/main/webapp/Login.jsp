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
  session.setAttribute("temp", temp);
%>
<form action="CheckLoginServlet" method="post">
  <h1>Login</h1>
  <div class="form-group">
    <label for="username">Username:</label>
    <input type="text" id="username" name="username"/>
  </div>
  <div class="form-group">
    <label for="password">Password:</label>
    <input type="password" id="password" name="password"/>
  </div>
  <input type="submit" value="Login"/>
  <input type="reset" value="Reset"/>
</form>
<a href="CheckLoginServlet?action=control" class="home-link">Home</a>
</body>
</html>
