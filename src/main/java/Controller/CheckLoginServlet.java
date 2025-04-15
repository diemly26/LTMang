package Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.*;

import Model.bean.Admin;
import Model.bo.CheckLoginBO;

@WebServlet("/CheckLoginServlet")

public class CheckLoginServlet extends HttpServlet{
    private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        doPost(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        String destination = null;
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //HttpSession session = request.getSession();
        CheckLoginBO checkLoginBO = new CheckLoginBO();
        Admin admin;
        try {
            if(checkLoginBO.isValidUser(username, password)) {
                admin = checkLoginBO.getAdmin(username, password);

                //session.setAttribute("loggedin", true);
                //session.setAttribute("username", admin.getUsername());

                destination = "/Welcome.jsp";
                RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
                rd.forward(request, response); // đối tượng rd chuyển đến trang được chỉ định
            } else {

                destination = "/Login.jsp";
                //session.setAttribute("loggedin", false);
                //session.setAttribute("error_message", "Tai khoan hoac mat khau sai.");
                RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
                rd.forward(request, response);
            }
        } catch(ClassNotFoundException | SQLException | ServletException | IOException e){
            e.printStackTrace();
        }
    }
}
