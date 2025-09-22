<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>IUH BOOKSTORE</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
        }

        .header {
            background: #666;
            color: white;
            padding: 15px;
            font-size: 22px;
            font-weight: bold;
        }

        .menu {
            background: #999;
            padding: 10px;
        }

        .menu a {
            color: white;
            margin-right: 20px;
            text-decoration: none;
            font-weight: bold;
        }

        .container {
            display: flex;
            margin: 10px;
        }

        .sidebar {
            width: 20%;
            padding: 10px;
        }

        .content {
            width: 80%;
            display: grid;
            grid-template-columns: repeat(3, 1fr);
            gap: 15px;
        }

        .product {
            border: 1px solid #ddd;
            padding: 10px;
            text-align: center;
        }

        .product img {
            height: 180px;
        }

        .product b {
            display: block;
            margin-bottom: 5px;
        }

        .product a {
            display: inline-block;
            margin: 3px 0;
            color: blue;
            text-decoration: underline;
        }

        .product input[type=submit] {
            margin-top: 5px;
            padding: 5px 10px;
        }

        .search-box input {
            width: 90%;
            padding: 5px;
        }
    </style>
</head>
<body>
<div class="header">IUH BOOKSTORE</div>
<div class="menu">
    <a href="#">HOME</a>
    <a href="#">EXAMPLES</a>
    <a href="#">SERVICES</a>
    <a href="#">PRODUCTS</a>
    <a href="#">CONTACT</a>
    <a href="cart" style="float:right;">View Cart</a>
</div>

<div class="container">
    <!-- Sidebar -->
    <div class="sidebar">
        <h3>ABOUT US</h3>
        <p>About us information will be here... <a href="#">Read More »</a></p>
        <h3>SEARCH SITE</h3>
        <div class="search-box">
            <form action="${pageContext.request.contextPath}/books" method="get">
                <input type="text" name="title" placeholder="Search..."/>
                <input type="submit" value="Search"/>
            </form>
        </div>
    </div>

    <!-- Content -->
    <div class="content">
        <c:forEach items="${books}" var="b">
            <div class="product">
                <b>${b.title}</b>
                <img src="images/${b.imgUrl}" alt="${b.title}">
                <p>Price: ${b.price}</p>
                <p>Quantity: ${b.quantity}</p>
                <a href="${pageContext.request.contextPath}/book?id=${b.id}">Product details</a><br/>
                <form action="${pageContext.request.contextPath}/cart" method="post">
                    <input type="hidden" name="id" value="${b.id}">
                    <input type="hidden" name="price" value="${b.price}">
                    <input type="hidden" name="model" value="${b.quantity}">
                    <input type="hidden" name="action" value="add">
                    <input type="submit" value="Add to cart">
                </form>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>
