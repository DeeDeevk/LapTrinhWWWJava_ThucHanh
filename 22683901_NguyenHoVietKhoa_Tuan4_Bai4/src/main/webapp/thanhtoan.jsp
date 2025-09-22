<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Checkout - IUH BOOKSTORE</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0; padding: 0;
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
            margin: 20px auto;
            width: 70%;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        td {
            padding: 10px;
        }
        input[type=text], input[type=number] {
            width: 95%;
            padding: 5px;
        }
        .actions {
            text-align: center;
            margin-top: 20px;
        }
        .actions input {
            padding: 8px 20px;
            margin: 0 10px;
            cursor: pointer;
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
    <h3>Checkout - Already registered?</h3>
    <form action="${pageContext.request.contextPath}/checkout" method="post">
        <table>
            <tr>
                <td>Fullname:</td>
                <td><input type="text" name="fullname" required /></td>
            </tr>
            <tr>
                <td>Shipping address:</td>
                <td><input type="text" name="address" required /></td>
            </tr>
            <tr>
                <td>Total price:</td>
                <td><input type="text" name="totalPrice" value="${cart.total}" readonly /></td>
            </tr>
            <tr>
                <td>Payment method:</td>
                <td>
                    <input type="radio" name="payment" value="paypal" required /> Paypal
                    <input type="radio" name="payment" value="atm" /> ATM Debit
                    <input type="radio" name="payment" value="visa" /> Visa/Master card
                </td>
            </tr>
        </table>

        <div class="actions">
            <input type="submit" value="Save" />
            <input type="button" value="Cancel" onclick="window.location.href='${pageContext.request.contextPath}/cart'" />
        </div>
    </form>
</div>
</body>
</html>
