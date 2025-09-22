<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Book Detail</title>
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
            padding: 10px;
        }

        .book-detail img {
            height: 250px;
            margin-bottom: 10px;
        }

        .book-detail h3 {
            margin: 5px 0;
        }

        .book-detail p {
            margin: 3px 0;
        }

        .book-detail a {
            color: blue;
            text-decoration: underline;
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
    <a href="${pageContext.request.contextPath}/cart" style="float:right;">View Cart</a>
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
        <c:if test="${not empty book}">
            <div class="book-detail">
                <h3>Product details: ${book.title} - Tác giả ${book.author}</h3>
                <img src="${pageContext.request.contextPath}/images/${book.imgUrl}" alt="${book.title}">
                <p>Price (VND): ${book.price}</p>
                <p>Quantity: ${book.quantity}</p>
                <br/>
                <a href="${pageContext.request.contextPath}/book">Back to Product List</a>
            </div>
        </c:if>
    </div>
</div>
</body>
</html>
