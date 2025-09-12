<%--
  Created by IntelliJ IDEA.
  User: DeeDeevk
  Date: 9/12/2025
  Time: 1:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Product List</title>
</head>
<body>
<p>
    <a href="cart">View Cart</a>
</p>
<c:forEach items="${products}" var="p">
    <div class="product-class">
        <b> ${p.model}</b>
        <br/>
<%--        <img src="images/${p.imgURL}" class="hinh"> <br/>--%>
        Price: ${p.price}<br/>
        <form action="${pageContext.request.contextPath}/cart" method="post">
            <input type="text" size="2" value="1" name="quantity"> <br/>
            <input type="hidden" name="id" value="${p.id}">
            <input type="hidden" name="price" value="${p.price}">
            <input type="hidden" name="model" value="${p.model}">
            <input type="hidden" name="action" value="add"><br/>
            <input type="submit" name="addToCart" value="Add To Cart"><br/>
        </form>
        <a href="${pageContext.request.contextPath}/product?id=${p.id}">Product Detail</a><br/>
    </div>
</c:forEach>
</body>
</html>
