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
import java.util.regex.Pattern;

@WebServlet("/tintuc-form")
public class TinTucFormServlet extends HttpServlet {
    @Resource(name = "jdbc/quanlydanhmuc")
    private DataSource dataSource;

    private static final Pattern LINK_PATTERN = Pattern.compile("^https?://.+", Pattern.CASE_INSENSITIVE);
    private static final Pattern NOIDUNG_PATTERN = Pattern.compile("^.{1,255}$", Pattern.DOTALL);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DanhMucDAO dmDao = new DanhMucDAO(dataSource);
        List<DanhMuc> ds = dmDao.findAll();
        req.setAttribute("danhMucs", ds);
        req.getRequestDispatcher("TinTucForm.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Lấy params
        String tieuDe = req.getParameter("tieuDe");
        String noiDung = req.getParameter("noiDung");
        String lienKet = req.getParameter("lienKet");
        String madmStr = req.getParameter("madm");

        StringBuilder errors = new StringBuilder();

        if (tieuDe == null || tieuDe.trim().isEmpty()) errors.append("Tiêu đề bắt buộc.<br/>");
        if (noiDung == null || !NOIDUNG_PATTERN.matcher(noiDung).matches()) errors.append("Nội dung bắt buộc và không quá 255 ký tự.<br/>");
        if (lienKet == null || !LINK_PATTERN.matcher(lienKet).matches()) errors.append("Liên kết phải bắt đầu bằng http:// hoặc https://.<br/>");
        if (madmStr == null || madmStr.trim().isEmpty()) errors.append("Chọn danh mục.<br/>");

        if (errors.length() > 0) {
            req.setAttribute("errorMsg", errors.toString());
            DanhMucDAO dmDao = new DanhMucDAO(dataSource);
            req.setAttribute("danhMucs", dmDao.findAll());
            req.getRequestDispatcher("TinTucForm.jsp").forward(req, resp);
            return;
        }

        int madm = Integer.parseInt(madmStr);
        TinTuc tt = new TinTuc(null, tieuDe, noiDung, lienKet, madm);
        TinTucDAO dao = new TinTucDAO(dataSource);
        dao.insert(tt);
        resp.sendRedirect(req.getContextPath() + "/tintuc?madm=" + madm);
    }
}
