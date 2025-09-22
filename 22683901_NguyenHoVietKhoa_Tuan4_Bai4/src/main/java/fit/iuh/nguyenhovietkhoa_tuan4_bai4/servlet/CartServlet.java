package fit.iuh.nguyenhovietkhoa_tuan4_bai4.servlet;

import fit.iuh.nguyenhovietkhoa_tuan4_bai4.HelloServlet;
import fit.iuh.nguyenhovietkhoa_tuan4_bai4.beans.Book;
import fit.iuh.nguyenhovietkhoa_tuan4_bai4.beans.CartBean;
import fit.iuh.nguyenhovietkhoa_tuan4_bai4.dao.BookDAO;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import javax.sql.DataSource;
import java.io.IOException;

@WebServlet("/cart")
public class CartServlet extends HelloServlet {
    private BookDAO bookDAO;

    @Resource(name = "jdbc/bookstoredb")
    private DataSource dataSource;

    @Override
    public void init() throws ServletException {
        bookDAO = new BookDAO(dataSource);
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            req.getRequestDispatcher("giohang.jsp").forward(req, resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        CartBean cart = (CartBean) session.getAttribute("cart");
        if(cart == null){
            cart = new CartBean();
            session.setAttribute("cart", cart);
        }
        String action = req.getParameter("action");
        try{
            if("add".equals(action)){
                int id = Integer.parseInt(req.getParameter("id"));
                Book book = bookDAO.getBookById(id);
                cart.addBook(book);
            }
            else if("update".equals(action)){
                int id = Integer.parseInt(req.getParameter("bookId"));
                int quantity = Integer.parseInt(req.getParameter("quantity"));
                cart.updateQuantity(id, quantity);
            } else if ("remove".equals(action)) {
                int id = Integer.parseInt(req.getParameter("bookId"));
                cart.removeBook(id);
            } else if ("clear".equals(action)) {
                cart.clear();
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
        resp.sendRedirect("cart");
    }
}
