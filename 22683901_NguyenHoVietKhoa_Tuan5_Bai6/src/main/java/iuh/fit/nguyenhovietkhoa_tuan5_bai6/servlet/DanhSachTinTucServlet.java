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

@WebServlet("/tintuc")
public class DanhSachTinTucServlet extends HttpServlet {
    @Resource(name = "jdbc/quanlydanhmuc")
    private DataSource dataSource;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DanhMucDAO dmDao = new DanhMucDAO(dataSource);
        TinTucDAO ttDao = new TinTucDAO(dataSource);

        List<DanhMuc> danhMucs = dmDao.findAll();
        req.setAttribute("danhMucs", danhMucs);

        String madmParam = req.getParameter("madm");
        int madm = (madmParam != null && !madmParam.isEmpty()) ? Integer.parseInt(madmParam) : (danhMucs.isEmpty() ? 0 : danhMucs.get(0).getMadm());
        if (madm != 0) {
            List<TinTuc> tins = ttDao.findByDanhMuc(madm);
            req.setAttribute("tins", tins);
            req.setAttribute("currentMadm", madm);
        }
        req.getRequestDispatcher("DanhSachTinTuc.jsp").forward(req, resp);
    }
}
