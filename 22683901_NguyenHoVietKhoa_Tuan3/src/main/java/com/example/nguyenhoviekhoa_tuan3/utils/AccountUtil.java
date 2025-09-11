package com.example.nguyenhoviekhoa_tuan3.utils;

import com.example.nguyenhoviekhoa_tuan3.model.Account;
import org.eclipse.tags.shaded.org.apache.xpath.objects.XBoolean;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AccountUtil {
    private DataSource dataSource;
    public AccountUtil(DataSource dataSource) {
        this.dataSource = dataSource;
    }

//    Lấy danh sách account
    public List<Account> getAccounts() {
        List<Account> accounts = new ArrayList<>();

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try{
            conn = dataSource.getConnection();
            String sql = "select * from account";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                int id = rs.getInt("ID");
                String firstName = rs.getString("FIRSTNAME");
                String lastName = rs.getString("LASTNAME");
                String email = rs.getString("EMAIL");
                String password = rs.getString("PASSWORD");
                Date dateOfBirth = rs.getDate("DOB");
                Account acc = new Account(firstName, lastName, email, id,  password, dateOfBirth);
                accounts.add(acc);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return accounts;
    }

    //    Thêm account
    public void addAccount(Account acc) throws Exception {
        String sql = "INSERT INTO account (FIRSTNAME, LASTNAME, EMAIL, PASSWORD, DOB) " +
                "VALUES (?, ?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = dataSource.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, acc.getFirstName());
            ps.setString(2, acc.getLastName());
            ps.setString(3, acc.getEmail());
            ps.setString(4, acc.getPassword());
            ps.setDate(5, (java.sql.Date) acc.getDateOfBirth());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}