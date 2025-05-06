<%--
  Created by IntelliJ IDEA.
  User: macbook
  Date: 6/5/25
  Time: 15:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin</title>

</head><head>
    <meta charset="UTF-8">
    <title>Admin</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f9;
            color: #333;
        }
        h2 {
            text-align: center;
            margin-top: 20px;
            color: #444;
        }
        ul {
            list-style-type: none;
            padding: 0;
            margin: 20px auto;
            max-width: 400px;
        }
        ul a {
            display: block;
            text-decoration: none;
            color: #771212;
            background-color: #95c3ef;
            padding: 10px 15px;
            margin: 5px 0;
            text-align: center;
            border-radius: 5px;
            transition: background-color 0.3s ease;
        }
        ul a:hover {
            background-color: #dbfffa;
        }
    </style>
</head>
<body>
<h2>Welcome, Admin!</h2>
<ul>
    <a href="PhongBanServlet?action=list">Xem phòng ban</a>
    <a href="PhongBanServlet?action=update">Cập nhật phòng ban</a>
    <a href="NhanVienServlet?action=list">Xem nhân viên</a>
    <a href="NhanVienServlet?action=add">Thêm nhân viên</a>
    <a href="NhanVienServlet?action=search">Tìm kiếm nhân viên</a>
    <a href="NhanVienServlet?action=delete">Xoá nhân viên</a>
    <a href="NhanVienServlet?action=deleteMulti">Xoá nhiều nhân viên</a>

    <a href="CheckLoginServlet?action=logout">Đăng xuất</a>

</ul>
</body>
</html>

