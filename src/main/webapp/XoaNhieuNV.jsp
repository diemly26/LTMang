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
<form action="NhanVienServlet?action=deleteMulti" method="post">
    <table>
        <tr>
            <th>IDNV</th>
            <th>Họ tên</th>
            <th>Địa chỉ</th>
            <th><input type="checkbox" id="select-all" /> Chọn tất cả</th>

        </tr>
        <%
            List<NhanVien> list = (List<NhanVien>) request.getAttribute("listNV");
            for (NhanVien nv : list) {
        %>
        <tr>
            <td><%= nv.getIdnv() %></td>
            <td><%= nv.getHoten() %></td>
            <td><%= nv.getDiachi() %></td>
            <td><input type="checkbox" name="idnv" value="<%= nv.getIdnv() %>" class="select-item" /></td>

        </tr>
        <% } %>
    </table>
    <div class="button-container">
        <button type="submit" class="delete-btn">Xoá đã chọn</button>
    </div>
    <a href="CheckLoginServlet?action=control" class="home-link">Home</a>

</form>

<script>
    document.getElementById("select-all").addEventListener("change", function() {
        const checkboxes = document.querySelectorAll(".select-item");
        checkboxes.forEach(checkbox => {
            checkbox.checked = this.checked;
        });
    });
</script>
</body>
</html>
