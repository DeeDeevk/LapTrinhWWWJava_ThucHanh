package fit.iuh.nguyenhovietkhoa_tuan4_bai4.dao;

import fit.iuh.nguyenhovietkhoa_tuan4_bai4.beans.Book;
import fit.iuh.nguyenhovietkhoa_tuan4_bai4.util.DBUtil;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
    private DBUtil dbUtil;

    public BookDAO(DataSource dataSource){
        this.dbUtil = new DBUtil(dataSource);
    }

    public List<Book> getAllBook(){
        List<Book> books = new ArrayList<>();
        String sql = "SELECT * FROM books";
        try(Connection conn = dbUtil.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()){
                books.add(new Book(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getDouble("price"),
                        rs.getInt("quantity"),
                        rs.getString("imgurl")
                ));
            }
        } catch (Exception e){
            throw new RuntimeException(e);
        }
        return books;
    }

    public Book getBookById(int id) {
        String sql = "SELECT * FROM books WHERE id = ?";
        try(Connection conn = dbUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()){
                if(rs.next()){
                    return new Book(
                            rs.getInt("id"),
                            rs.getString("title"),
                            rs.getString("author"),
                            rs.getDouble("price"),
                            rs.getInt("quantity"),
                            rs.getString("imgurl")
                    );
                }
            }
        } catch (Exception e){
            throw new RuntimeException(e);
        }
        return null;
    }

    public List<Book> getBookByTitle(String title) {
        List<Book> books = new ArrayList<>();
        String sql = "SELECT * FROM books WHERE title LIKE ?";
        try(Connection conn = dbUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, "%" + title + "%");
            try (ResultSet rs = ps.executeQuery()){
                if(rs.next()){
                    Book b = new Book(
                            rs.getInt("id"),
                            rs.getString("title"),
                            rs.getString("author"),
                            rs.getDouble("price"),
                            rs.getInt("quantity"),
                            rs.getString("imgurl")
                    );
                    books.add(b);
                }
            }
        } catch (Exception e){
            throw new RuntimeException(e);
        }
        return books;
    }
}

