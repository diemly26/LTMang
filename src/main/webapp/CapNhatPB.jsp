<%--
  Created by IntelliJ IDEA.
  User: macbook
  Date: 6/5/25
  Time: 15:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.List, Model.bean.PhongBan" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><%= request.getAttribute("title") != null ? request.getAttribute("title") : "Danh sách phòng ban" %></title>

</head>
<body>
<h3><%= request.getAttribute("title") != null ? request.getAttribute("title") : "Danh sách phòng ban" %></h3>
<table>
    <tr>
        <th>IDPB</th>
        <th>Tên phòng ban</th>
        <th>Mô tả</th>
        <th>Cập nhật</th>
    </tr>
    <%
        List<PhongBan> list = (List<PhongBan>) request.getAttribute("listPB");
        if (list != null) {
            for (PhongBan pb : list) {
    %>
    <tr>
        <td><%= pb.getIdpb() %></td>
        <td><%= pb.getTenpb() %></td>
        <td><%= pb.getMota() %></td>
        <td><a class="update-link" href="PhongBanServlet?action=update&idpb=<%= pb.getIdpb() %>">Edit</a></td>
    </tr>
    <%
        }
    } else {
    %>
    <tr>
        <td colspan="5" style="text-align:center; color:#053bf1;">Không có dữ liệu phòng ban.</td>
    </tr>
    <% } %>
</table>
<a href="CheckLoginServlet?action=control" class="home-link">Home</a>

</body>
</html>