<%--
  Created by IntelliJ IDEA.
  User: macbook
  Date: 6/5/25
  Time: 15:12
  To change this template use File | Settings | File Templates.
--%>

<%@ page import="java.util.List, Model.bean.NhanVien" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><%= request.getAttribute("title") != null ? request.getAttribute("title") : "Danh sách nhân viên" %></title>
</head>
<body>
<h3><%= request.getAttribute("title") != null ? request.getAttribute("title") : "Danh sách nhân viên" %></h3>
<table>
    <tr>
        <th>IDNV</th>
        <th>Họ tên</th>
        <th>Địa chỉ</th>
        <th>Action</th>
    </tr>
    <%
        List<NhanVien> list = (List<NhanVien>) request.getAttribute("listNV");
        for (NhanVien nv : list) {
    %>
    <tr>
        <td><%= nv.getIdnv() %></td>
        <td><%= nv.getHoten() %></td>
        <td><%= nv.getDiachi() %></td>
        <td>
            <form action="NhanVienServlet?action=delete" method="post" style="display:inline;">
                <input type="hidden" name="idnv" value="<%= nv.getIdnv() %>" />
                <button type="submit" class="delete-btn">Xoá</button>
            </form>
        </td>
    </tr>
    <% } %>
</table>
<a href="CheckLoginServlet?action=control" class="home-link">Home</a>

</body>
</html>


