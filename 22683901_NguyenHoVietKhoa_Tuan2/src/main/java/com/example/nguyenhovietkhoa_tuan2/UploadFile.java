package com.example.nguyenhovietkhoa_tuan2;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;


@WebServlet("/uploadFile")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 10,
        maxRequestSize = 1024 * 1024 * 50
)
public class UploadFile extends HttpServlet {

    public UploadFile() {
    }

    ;
    private static final String UPLOAD_DIR = "uploads";

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/uploadFile.jsp");
        rd.forward(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uploadPath =  "D:\\Khoadihoc\\Uni\\HK7\\LTWWWJava\\ThucHanh\\22683901_NguyenHoVietKhoa_Tuan2\\src\\main\\uploads";


        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
        for (Part part : req.getParts()) {
            String fileName = getFileName(part);
            if (fileName != null && !fileName.isEmpty()) {
                part.write(uploadPath + File.separator + fileName);
            }
        }

        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().println("<h3> File Uploaded Successfully to " + uploadPath + "</h3>");
    }

    public String getFileName(Part part){
        String contentDisp = part.getHeader("content-disposition");
        String[] tokens = contentDisp.split(";");
        for(String token : tokens){
            if(token.trim().startsWith("filename")){
                return token.substring(token.indexOf("=") + 2, token.length() -1);
            }
        }
        return null;
    }
}
