package com.example.nguyenhoviekhoa_tuan3;

import com.example.nguyenhoviekhoa_tuan3.model.Account;
import com.example.nguyenhoviekhoa_tuan3.utils.AccountUtil;
import jakarta.annotation.Resource;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.sql.DataSource;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@WebServlet("/account")
public class AccountServlet extends HttpServlet {

    private AccountUtil accountUtil;
    @Resource(name = "jdbc/storedb")
    private DataSource dataSource;

    @Override
    public void init() throws ServletException {
        try {
            accountUtil = new AccountUtil(dataSource);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstname = req.getParameter("firstName");
        String lastname = req.getParameter("lastName");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        int day = Integer.valueOf(req.getParameter("day"));
        int month = Integer.valueOf(req.getParameter("month"));
        int year = Integer.valueOf(req.getParameter("year"));

        LocalDate localDate = LocalDate.of(year, month, day);
        java.sql.Date dob = java.sql.Date.valueOf(localDate);

        Account acc = new Account(firstname, lastname, email, password, dob);
        try {
            accountUtil.addAccount(acc);
            List<Account> accounts = accountUtil.getAccounts();
            req.setAttribute("accounts", accounts);
            RequestDispatcher rd = req.getRequestDispatcher("account.jsp");
            rd.forward(req, resp);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("RegisterForm.jsp");
        rd.forward(req, resp);
    }
}
