package Controller;

import Model.bean.NhanVien;
import Model.bean.PhongBan;
import Model.bo.NhanVienBO;
import Model.bo.PhongBanBO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/NhanVienServlet")
public class NhanVienServlet extends HttpServlet {
    private NhanVienBO nhanvienBO = new NhanVienBO();
    private PhongBanBO phongbanBO = new PhongBanBO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "list":
                listNhanvien(request, response);
                break;
            case "search":
                searchNhanvien(request, response);
                break;
            case "delete":
                showDeleteForm(request, response);
                break;
            case "deleteMulti":
                showDeleteMultiForm(request, response);
                break;
            case "add":
                showAddForm(request, response);
                break;
            case "viewByDepartment":
                viewNhanvienByDepartment(request, response);
                break;
            case "checkidnv":  // thêm vào đây
                checkNhanVien(request, response);
                break;
            default:
                response.sendRedirect("UserHome.jsp");
        }
    }

    private void checkNhanVien(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String idnv = request.getParameter("idnv");
        NhanVien nv = nhanvienBO.getNhanvienByIdnv(idnv);
        response.setContentType("text/plain");
        response.getWriter().write(nv != null ? "exists" : "available");
    }

    private void showAddForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<PhongBan> listPB = phongbanBO.getAllPhongban();
        request.setAttribute("listPB", listPB);
        request.getRequestDispatcher("ThemNV.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("add".equals(action)) {
            addNhanvien(request, response);
        }
        else if("delete".equals(action)){
            deleteNhanvien(request, response);
        }
        else if("deleteMulti".equals(action)) {
            deleteMultipleNhanvien(request, response);
        }

        else {
            response.sendRedirect("UserHome.jsp");
        }
    }



    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<NhanVien> listNV = nhanvienBO.getAllNhanvien();
        request.setAttribute("listNV", listNV);
        request.getRequestDispatcher("XoaNV.jsp").forward(request, response);
    }

    private void showDeleteMultiForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<NhanVien> listNV = nhanvienBO.getAllNhanvien();
        request.setAttribute("listNV", listNV);
        request.getRequestDispatcher("XoaNhieuNV.jsp").forward(request, response);
    }


    private void viewNhanvienByDepartment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idpb = request.getParameter("idpb");
        if (idpb != null && !idpb.isEmpty()) {
            List<NhanVien> listNV = nhanvienBO.getNhanvienByDepartment(idpb);
            request.setAttribute("listNV", listNV);
            request.setAttribute("title", "Dữ liệu nhân viên phòng ban");
            request.getRequestDispatcher("XemNV.jsp").forward(request, response);
        } else {
            response.sendRedirect("PhongbanServlet?action=list");
        }
    }

    private void listNhanvien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<NhanVien> listNV = nhanvienBO.getAllNhanvien();
        request.setAttribute("listNV", listNV);
        request.getRequestDispatcher("XemNV.jsp").forward(request, response);
    }

    private void searchNhanvien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String keyword = request.getParameter("keyword");
        if (keyword == null || keyword.isEmpty()) {
            request.getRequestDispatcher("TimKiemNV.jsp").forward(request, response);
        } else {
            String field = request.getParameter("field");
            List<NhanVien> searchResults = nhanvienBO.searchNhanvienByField(field, keyword);
            request.setAttribute("listNV", searchResults);
            request.setAttribute("title", "Danh sách nhân viên tìm kiếm");
            request.getRequestDispatcher("XemNV.jsp").forward(request, response);
        }
    }

    private void deleteNhanvien(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String idnv = request.getParameter("idnv");
        boolean isDeleted = nhanvienBO.deleteNhanvien(idnv);
        showDeleteForm(request, response);
    }

    private void deleteMultipleNhanvien(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String[] ids = request.getParameterValues("idnv");
        boolean isDeleted = true;
        if (ids != null) {
            for (String id : ids) {
                if (!nhanvienBO.deleteNhanvien(id)) {
                    isDeleted = false;
                    break;
                }
            }
        }
        showDeleteMultiForm(request, response);
    }




    private void addNhanvien(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String idnv = request.getParameter("idnv");
        String hoten = request.getParameter("hoten");
        String idpb = request.getParameter("idpb");
        String diachi = request.getParameter("diachi");
        NhanVien nv = new NhanVien(idnv, hoten, idpb, diachi);
        nhanvienBO.addNhanvien(nv);
        response.sendRedirect("NhanvienServlet?action=list");
    }
}