package fit.iuh.nguyenhovietkhoa_tuan4_bai4.servlet;

import fit.iuh.nguyenhovietkhoa_tuan4_bai4.beans.Book;
import fit.iuh.nguyenhovietkhoa_tuan4_bai4.dao.BookDAO;
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

@WebServlet({"/books", "/book"})
public class BookListServlet extends HttpServlet {
    private BookDAO bookDAO;

    @Resource(name = "jdbc/bookstoredb")
    private DataSource dataSource;

    @Override
    public void init() throws ServletException {
        bookDAO = new BookDAO(dataSource);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idstr = req.getParameter("id");
        String title = req.getParameter("title");
        if (idstr != null) {
            // Hiển thị chi tiết sản phẩm
            int id = Integer.parseInt(idstr);
            Book book = bookDAO.getBookById(id);

            if (book == null) {
                resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Product not found");
                return;
            }

            req.setAttribute("book", book);
            RequestDispatcher rd = req.getRequestDispatcher("/chitietsach.jsp");
            rd.forward(req, resp);
        }
        else if(title != null){
            List<Book> books = bookDAO.getBookByTitle(title);

            if (books == null) {
                resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Product not found");
                return;
            }

            req.setAttribute("books", books);
            RequestDispatcher rd = req.getRequestDispatcher("/timkiemsach.jsp");
            rd.forward(req, resp);
        }
        else {
            // Hiển thị danh sách sản phẩm
            List<Book> books = bookDAO.getAllBook();
            req.setAttribute("books", books);
            RequestDispatcher rd = req.getRequestDispatcher("/danhsach.jsp");
            rd.forward(req, resp);
        }
    }
}
