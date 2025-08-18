<%--
  Created by IntelliJ IDEA.
  User: DeeDeevk
  Date: 8/18/2025
  Time: 9:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Trang chủ</title>
</head>
<body>
  <h2>Xin chào, ${sessionScope.user} đây là trang chủ</h2>
  <a href="${pageContext.request.contextPath}/secure/secure.jsp">Trang bảo mật</a>
  <br>
  <a href="${pageContext.request.contextPath}/logout">Đăng xuất</a>
</body>
</html>
