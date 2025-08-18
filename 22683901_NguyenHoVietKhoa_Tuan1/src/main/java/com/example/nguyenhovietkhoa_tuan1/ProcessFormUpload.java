package com.example.nguyenhovietkhoa_tuan1;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/processFormUpload")
@MultipartConfig()
public class ProcessFormUpload extends HttpServlet {

    private String firstName;
    private String lastName;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
        rd.forward(request, response);

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");


        PrintWriter out = response.getWriter();
        firstName = request.getParameter("first");
        lastName = request.getParameter("last");
        out.println("<html><body>");
        out.println("<h1>" + "Hello " + firstName + " " + lastName + "</h1>");
        out.println("</body></html>");
    }
}
