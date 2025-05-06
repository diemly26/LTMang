<%--
  Created by IntelliJ IDEA.
  User: macbook
  Date: 6/5/25
  Time: 15:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tìm Kiếm Nhân Viên</title>
</head>
<body>
<h3>Tìm Kiếm Nhân Viên</h3>
<form action="NhanVienServlet" method="get">
    <input type="hidden" name="action" value="search" />

    <input type="radio" name="field" value="idnv" checked />
    <label>IDNV</label>
    <br/>
    <input type="radio" name="field" value="hoten" />
    <label>Họ tên</label>
    <br/>
    <input type="radio" name="field" value="diachi" />
    <label>Địa chỉ</label>
    <br><br>
    <label>Nhập từ khóa:</label>
    <input type="text" name="keyword" required />
    <br><br>
    <input type="submit" value="Tìm" />
    <input type="reset" value="Xóa" />
</form>

<a href="CheckLoginServlet?action=control" class="home-link">Home</a>

</body>
</html>

