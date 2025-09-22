<%--
  Created by IntelliJ IDEA.
  User: DeeDeevk
  Date: 9/15/2025
  Time: 5:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title>Kết quả tìm kiếm</title></head>
<body>
<h2>Kết quả tìm kiếm</h2>

<div class="content">
  <c:forEach items="${books}" var="b">
    <div class="product">
      <b>${b.title}</b>
      <img src="images/${b.imgUrl}" alt="${b.title}">
      <p>Price: ${b.price}</p>
      <p>Quantity: ${b.quantity}</p>
      <a href="${pageContext.request.contextPath}/book?id=${b.id}">Chi tiết</a>
    </div>
  </c:forEach>
</div>

<p><a href="${pageContext.request.contextPath}/books">Quay lại danh sách</a></p>
</body>
</html>
