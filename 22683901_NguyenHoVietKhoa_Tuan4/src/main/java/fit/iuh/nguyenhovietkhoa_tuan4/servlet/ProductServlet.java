package fit.iuh.nguyenhovietkhoa_tuan4.servlet;

import fit.iuh.nguyenhovietkhoa_tuan4.beans.Product;
import fit.iuh.nguyenhovietkhoa_tuan4.dao.ProductDAO;
import jakarta.annotation.Resource;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;

@WebServlet({"/products", "/product"})
public class ProductServlet extends HttpServlet {
    private ProductDAO productDAO;

    @Resource(name = "jdbc/shopdb")
    private DataSource dataSource;

    @Override
    public void init() throws ServletException {
        productDAO = new ProductDAO(dataSource);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idstr = req.getParameter("id");
        if (idstr != null) {
            // Hiển thị chi tiết sản phẩm
            int id = Integer.parseInt(idstr);
            Product product = productDAO.getProductById(id);

            if (product == null) {
                resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Product not found");
                return;
            }

            req.setAttribute("product", product);
            RequestDispatcher rd = req.getRequestDispatcher("/product-detail.jsp");
            rd.forward(req, resp);
        } else {
            // Hiển thị danh sách sản phẩm
            List<Product> products = productDAO.getAllProducts();
            req.setAttribute("products", products);
            RequestDispatcher rd = req.getRequestDispatcher("/product-list.jsp");
            rd.forward(req, resp);
        }
    }
}
