<%--
  Created by IntelliJ IDEA.
  User: macbook
  Date: 6/5/25
  Time: 15:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List, Model.bean.PhongBan" %>
<%
    List<PhongBan> listPB = (List<PhongBan>) request.getAttribute("listPB");
%>
<html>
<head>
    <title>Thêm nhân viên</title>
</head>
<body>
<h3>Thêm nhân viên mới</h3>
<form method="post" action="NhanvienServlet">
    <input type="hidden" name="action" value="add" />

    <label for="idnv">ID nhân viên</label>
    <input type="text" id="idnv" name="idnv" required />
    <small id="idnv-message"></small>

    <label for="hoten">Họ tên</label>
    <input type="text" id="hoten" name="hoten" required />

    <label for="idpb">Phòng ban</label>
    <select id="idpb" name="idpb" required>
        <option value="">-- Chọn phòng ban --</option>
        <%
            if (listPB != null) {
                for (PhongBan pb : listPB) {
        %>
        <option value="<%= pb.getIdpb() %>"><%= pb.getTenpb() %></option>
        <%
                }
            }
        %>
    </select>

    <label for="diachi">Địa chỉ</label>
    <input type="text" id="diachi" name="diachi" required />

    <button type="submit">Thêm nhân viên</button>
</form>

<!-- Link to Home page styled as a button -->
<a href="CheckLoginServlet?action=control" class="home-link">Home</a>

</body>
</html>
<script>
    document.getElementById("idnv").addEventListener("blur", function () {
        var idnv = this.value.trim();
        var messageElem = document.getElementById("idnv-message");

        if (idnv === "") {
            messageElem.textContent = "";
            return;
        }

        fetch("NhanVienServlet?action=checkidnv&idnv=" + encodeURIComponent(idnv))
            .then(response => response.text())
            .then(result => {
                if (result === "exists") {
                    messageElem.textContent = "ID nhân viên đã tồn tại, vui lòng nhập ID khác.";
                    messageElem.style.color = "red";
                } else {
                    messageElem.textContent = "ID hợp lệ.";
                    messageElem.style.color = "green";
                }
            })
            .catch(error => {
                console.error("Lỗi khi kiểm tra ID:", error);
                messageElem.textContent = "Không thể kiểm tra ID lúc này.";
                messageElem.style.color = "orange";
            });
    });
</script>
