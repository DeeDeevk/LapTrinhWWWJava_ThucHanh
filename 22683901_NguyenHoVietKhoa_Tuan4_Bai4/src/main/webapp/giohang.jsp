<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Your Shopping Cart</title>
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

        table {
            border-collapse: collapse;
            width: 100%;
        }

        table, th, td {
            border: 1px solid #ddd;
        }

        th {
            background: #666;
            color: white;
            padding: 8px;
            text-align: center;
        }

        td {
            padding: 8px;
            text-align: center;
        }

        .btn {
            padding: 5px 10px;
            margin: 3px;
            border: 1px solid #333;
            background: #f0f0f0;
            cursor: pointer;
        }

        .total {
            text-align: right;
            font-weight: bold;
            margin-top: 10px;
        }

        .actions {
            margin-top: 15px;
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
        <h3>YOUR SHOPPING CART</h3>

        <c:if test="${empty cart.items}">
            <p>Cart is empty!</p>
        </c:if>

        <c:if test="${not empty cart.items}">
            <table>
                <tr>
                    <th>Product ID</th>
                    <th>Product name</th>
                    <th>Price</th>
                    <th>Qty</th>
                    <th>Total</th>
                    <th>Remove</th>
                </tr>
                <c:forEach var="item" items="${cart.items}">
                    <tr>
                        <td>${item.book.id}</td>
                        <td>${item.book.title}</td>
                        <td>${item.book.price}</td>
                        <td>${item.quantity}</td>
                        <td>${item.book.price * item.quantity}</td>
                        <td>
                            <form action="${pageContext.request.contextPath}/cart" method="post">
                                <input type="hidden" name="action" value="remove"/>
                                <input type="hidden" name="bookId" value="${item.book.id}"/>
                                <input type="submit" value="Remove" class="btn"/>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </table>

            <div class="total">
                Total price (VND): ${cart.getTotal()}
            </div>

            <div class="actions">
<%--                <button class="btn">Checkout</button>--%>
                <form action="${pageContext.request.contextPath}/thanhtoan.jsp">
                    <button type="submit" class="btn">Checkout</button>
                </form>
                <a href="${pageContext.request.contextPath}/book" class="btn">Continue shopping</a>
            </div>
        </c:if>
    </div>
</div>
</body>
</html>
