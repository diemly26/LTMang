package Controller;

import Model.bean.PhongBan;
import Model.bo.PhongBanBO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/PhongBanServlet")
public class PhongBanServlet extends HttpServlet {
    private PhongBanBO phongbanBO = new PhongBanBO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "list":
                listPhongban(request, response);
                break;
            case "update":
                showUpdateForm(request, response);
                break;
            default:
                response.sendRedirect("UserHome.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if("update".equals(request.getParameter("action")))  {
            updatePhongban(request, response);
        }
        else {
            response.sendRedirect("UserHome.jsp");
        }

    }

    private void listPhongban(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<PhongBan> listPB = phongbanBO.getAllPhongban();
        request.setAttribute("listPB", listPB);
        request.getRequestDispatcher("XemPB.jsp").forward(request, response);
    }

    private void showUpdateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idpb = request.getParameter("idpb");
        if(idpb == null || idpb.isEmpty()) {
            List<PhongBan> listPB = phongbanBO.getAllPhongban();
            request.setAttribute("listPB", listPB);
            request.getRequestDispatcher("CapNhatPB.jsp").forward(request, response);
            return;
        }
        PhongBan pb = phongbanBO.getPhongbanById(idpb);
        request.setAttribute("pb", pb);
        request.getRequestDispatcher("FormCapNhatPB.jsp").forward(request, response);
    }

    private void updatePhongban(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String idpb = request.getParameter("idpb");
        String tenpb = request.getParameter("tenpb");
        String mota = request.getParameter("mota");
        PhongBan pb = new PhongBan(idpb, tenpb, mota);
        phongbanBO.updatePhongban(pb);
        List<PhongBan> listPB = phongbanBO.getAllPhongban();
        request.setAttribute("listPB", listPB);
        request.getRequestDispatcher("CapNhatPB.jsp").forward(request, response);
    }
}