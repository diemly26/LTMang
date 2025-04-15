<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String username = request.getParameter("username");
    String password = request.getParameter("password");

    String address = "192 NLB";

    if("Chi Pheo".equals(username) && (!"thi no".equals(password))){
        request.setAttribute("address", address);
        RequestDispatcher rd = request.getRequestDispatcher("Welcome.jsp");
        rd.forward(request, response);
    } else
    {
        response.sendRedirect("Login.jsp");
    }

%>
