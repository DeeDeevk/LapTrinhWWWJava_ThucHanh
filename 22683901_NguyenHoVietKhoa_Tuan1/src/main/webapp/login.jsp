<%--
  Created by IntelliJ IDEA.
  User: DeeDeevk
  Date: 8/18/2025
  Time: 9:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Đăng nhập</title>
    <style>
        button:hover{
            opacity: 0.75;
        }
    </style>
</head>
<body>
<form action="login" method="post" style="background-color: grey; width: 30%; margin: auto; border-radius: 10px">
    <h1 style="color: white; font-family: Arial; justify-content: center; align-items: center; display: flex">Đăng nhập</h1>
    <div style="margin-left: 20px;">
        <h3 style="color: white; font-family: Arial">Tên đăng nhập: </h3>
        <input style="width: 90%; border-radius: 5px" type="text" name="username" placeholder="Username">
        <h3 style="color: white; font-family: Arial">Mật khẩu: </h3>
        <input style="width: 90%; border-radius: 5px" type="text" name="password" placeholder="Password">
        <br>
        <button type="submit" style="margin-top: 10px; border-radius: 5px; padding: 10px 20px 10px 20px; margin-bottom: 10px">Đăng nhập</button>
    </div>

</form>
</body>
</html>
