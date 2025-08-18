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
</head>
<body>
<form action="login" method="post">
    <h1>Đăng nhập</h1>
    <div>
        <h3>Tên đăng nhập: </h3>
        <input type="text" name="username" placeholder="Username">
        <h3>Mật khẩu: </h3>
        <input type="text" name="password" placeholder="Password">
        <br>
        <button type="submit" style="margin-top: 10px">Đăng nhập</button>
    </div>
</form>
</body>
</html>
