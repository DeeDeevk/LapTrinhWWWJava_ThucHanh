<%--
  Created by IntelliJ IDEA.
  User: DeeDeevk
  Date: 8/27/2025
  Time: 3:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Send Mail</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/sendMail" method="post" style="width: 30%; margin: auto; border-radius: 10px; border: solid" enctype="multipart/form-data">
    <h1 style="font-family: Arial; justify-content: center; align-items: center; display: flex">Send mail</h1>
    <div style="margin-left: 20px;">
        <h3 style="font-family: Arial">Người nhận: </h3>
        <input style="width: 90%; border-radius: 5px" type="email" name="to" placeholder="Tên người nhận">
        <h3 style="font-family: Arial">Tiêu đề: </h3>
        <input style="width: 90%; border-radius: 5px" type="text" name="subject" placeholder="Tiêu đề">
        <h3 style="font-family: Arial">Nội dung: </h3>
        <textarea style="width: 90%; border-radius: 5px" name="content" cols="30" rows="10" placeholder="Nội dung"></textarea>
        <h3 style="font-family: Arial">File đính kèm: </h3>
        <input style="width: 90%; border-radius: 5px" type="file" name="file">
        <br>
        <button type="submit" style="margin-top: 10px; border-radius: 5px; padding: 10px 20px 10px 20px; margin-bottom: 10px">Gửi mail</button>
    </div>
</form>
</body>
</html>
