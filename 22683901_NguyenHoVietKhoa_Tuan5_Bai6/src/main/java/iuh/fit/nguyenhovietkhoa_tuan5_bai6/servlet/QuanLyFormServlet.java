package iuh.fit.nguyenhovietkhoa_tuan5_bai6.servlet;

import iuh.fit.nguyenhovietkhoa_tuan5_bai6.dao.DanhMucDAO;
import iuh.fit.nguyenhovietkhoa_tuan5_bai6.dao.TinTucDAO;
import iuh.fit.nguyenhovietkhoa_tuan5_bai6.model.DanhMuc;
import iuh.fit.nguyenhovietkhoa_tuan5_bai6.model.TinTuc;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;

@WebServlet("/quanly")
public class QuanLyFormServlet extends HttpServlet {
    @Resource(name = "jdbc/quanlydanhmuc")
    private DataSource dataSource;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DanhMucDAO dmDao = new DanhMucDAO(dataSource);
        TinTucDAO ttDao = new TinTucDAO(dataSource);

        List<DanhMuc> dms = dmDao.findAll();
        req.setAttribute("danhMucs", dms);

        String madmStr = req.getParameter("madm");
        int madm = (madmStr != null && !madmStr.isEmpty()) ? Integer.parseInt(madmStr) : (dms.isEmpty() ? 0 : dms.get(0).getMadm());
        if (madm != 0) {
            List<TinTuc> tins = ttDao.findByDanhMuc(madm);
            req.setAttribute("tins", tins);
            req.setAttribute("currentMadm", madm);
        }
        req.getRequestDispatcher("QuanLyForm.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if ("delete".equalsIgnoreCase(action)) {
            String mattStr = req.getParameter("matt");
            if (mattStr != null && !mattStr.isEmpty()) {
                int matt = Integer.parseInt(mattStr);
                TinTucDAO dao = new TinTucDAO(dataSource);
                dao.delete(matt);
            }
        }
        resp.sendRedirect(req.getContextPath() + "/quanly");
    }
}
