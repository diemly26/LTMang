<%--
  Created by IntelliJ IDEA.
  User: macbook
  Date: 6/5/25
  Time: 15:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="Model.bean.PhongBan" %>
<%
    PhongBan pb = (PhongBan) request.getAttribute("pb");
%>
<html>
<head>
    <title>Cập nhật phòng ban</title>
</head>
<body>
<div class="form-container">
    <h2>Cập nhật phòng ban</h2>
    <form action="PhongBanServlet?action=update" method="post">
        <input type="hidden" name="action" value="updateSubmit" />

        <label for="idpb">IDPB</label>
        <input type="text" id="idpb" name="idpb" value="<%= pb.getIdpb() %>" readonly />

        <label for="tenpb">Tên phòng ban</label>
        <input type="text" id="tenpb" name="tenpb" value="<%= pb.getTenpb() %>" required />

        <label for="mota">Mô tả</label>
        <textarea id="mota" name="mota" rows="4" required><%= pb.getMota() %></textarea>

        <div class="button-group">
            <input type="submit" value="Cập nhật" />
            <a class="cancel-button" href="PhongBanServlet?action=list">Hủy</a>
        </div>
    </form>
</div>
<a href="CheckLoginServlet?action=control">Home</a>

</body>
</html>