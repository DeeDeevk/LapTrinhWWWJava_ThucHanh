package com.example.nguyenhoviekhoa_tuan3;

import com.example.nguyenhoviekhoa_tuan3.model.Qualification;
import com.example.nguyenhoviekhoa_tuan3.model.Student;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;

@WebServlet("/student")
public class StudentServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("student.jsp");
        rd.forward(req,resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Student st = new Student();
        String firstName = req.getParameter("firstName");
        st.setFirstName(firstName);
        String lastName = req.getParameter("lastName");
        st.setLastName(lastName);
        LocalDate dob = LocalDate.parse(req.getParameter("dob"));
        st.setDob(dob);
        String email = req.getParameter("email");
        st.setEmail(email);
        String phone = req.getParameter("mobile");
        st.setPhone(phone);
        String gender = req.getParameter("gender");
        st.setGender(gender);
        String address = req.getParameter("address");
        st.setAddress(address);
        String city = req.getParameter("city");
        st.setCity(city);
        String pinCode = req.getParameter("pinCode");
        st.setPinCode(pinCode);
        String state = req.getParameter("state");
        st.setState(state);
        String country = req.getParameter("country");
        st.setCountry(country);
        String[] hobbies = req.getParameterValues("hobbies");
        st.setHobbies(hobbies);
        String course = req.getParameter("course");
        st.setCourse(course);

        req.setAttribute("student", st);
        RequestDispatcher rd = req.getRequestDispatcher("student-result.jsp");
        rd.forward(req,resp);
    }
}
