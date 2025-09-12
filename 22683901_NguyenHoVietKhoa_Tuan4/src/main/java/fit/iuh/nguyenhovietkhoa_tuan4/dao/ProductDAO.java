package fit.iuh.nguyenhovietkhoa_tuan4.dao;

import fit.iuh.nguyenhovietkhoa_tuan4.beans.Product;
import fit.iuh.nguyenhovietkhoa_tuan4.util.DBUtil;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    private DBUtil dbUtil;

    public ProductDAO(DataSource dataSource) {
        this.dbUtil = new DBUtil(dataSource);
    }

    // READ ALL
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM products";
        try(Connection conn = dbUtil.getConnection()){
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                Integer id = rs.getInt("ID");
                String model = rs.getString("MODEL");
                Double price = rs.getDouble("PRICE");
                Integer quantity = rs.getInt("QUANTITY");
                String description = rs.getString("DESCRIPTION");
                Product p = new Product(model, id, price, quantity, description);
                products.add(p);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return products;
    }

    // READ BY ID
    public Product getProductById(int id) {
        String sql = "SELECT * FROM products WHERE ID = ?";
        try(Connection conn = dbUtil.getConnection()){
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            try (ResultSet rs = preparedStatement.executeQuery()){
                if(rs.next()){
                    Integer p_id = rs.getInt("ID");
                    String model = rs.getString("MODEL");
                    Double price = rs.getDouble("PRICE");
                    Integer quantity = rs.getInt("QUANTITY");
                    String description = rs.getString("DESCRIPTION");
                    Product p = new Product(model, p_id, price, quantity, description);
                    return p;
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return null;
    }
}
