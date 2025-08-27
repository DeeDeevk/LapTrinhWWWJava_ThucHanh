package com.example.nguyenhovietkhoa_tuan2;

import jakarta.activation.DataHandler;
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;
import jakarta.mail.util.ByteArrayDataSource;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@WebServlet("/sendMail")
@MultipartConfig
public class SendMailServlet extends HttpServlet {

    private final String USERNAME = "khoa01022020@gmail.com";
    private final String PASSWORD = "faxw cuki yquy gqxn";

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("sendMail.jsp");
        rd.forward(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String to = req.getParameter("to");
        String subject = req.getParameter("subject");
        String content = req.getParameter("content");
        Part filePart = req.getPart("file");
        try {
//      1.  Cấu hình SMTP
            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
//      2.  Tạo Session có xác thực
            Session session = Session.getInstance(props, new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(USERNAME, PASSWORD);
                }
            });

//      3.  Tạo message
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(USERNAME));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(subject, "UTF-8");
//      4.  Nội dung chính (text)
            MimeBodyPart textPart = new MimeBodyPart();
            textPart.setContent(content, "text/html; charset=utf-8");
//      5.  File đính kèm
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(textPart);
            if (filePart != null && filePart.getSize() > 0) {
                MimeBodyPart attachPart = new MimeBodyPart();
                String fileName = filePart.getSubmittedFileName();
                InputStream fileContent = filePart.getInputStream();
                attachPart.setFileName(fileName);
                attachPart.setDataHandler(new DataHandler(new ByteArrayDataSource(fileContent, getServletContext().getMimeType(fileName))));
                multipart.addBodyPart(attachPart);
            }
//      6. Multipart vào message
            message.setContent(multipart);
//      7. Gửi mail
            Transport.send(message);
            resp.setContentType("text/html; charset=UTF-8");
            resp.getWriter().println("<h3>Gửi mail thành công!</h3>");
        } catch (Exception e) {
            throw new ServletException("Lỗi gửi mail!!!" + e.getMessage(), e);
        }


    }
}
