<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Thanh toán</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <h3>Checkout</h3>

    <c:if test="${not empty msg}">
        <div class="alert alert-success">${msg}</div>
    </c:if>

    <form method="post" action="checkout">
        <div class="mb-3">
            <label class="form-label">Fullname</label>
            <input class="form-control" name="fullname" required>
        </div>
        <div class="mb-3">
            <label class="form-label">Shipping address</label>
            <input class="form-control" name="address" required>
        </div>
        <div class="mb-3">
            <label class="form-label">Payment method</label>
            <select name="payment" class="form-select">
                <option>Paypal</option>
                <option>ATM Debit</option>
                <option>Cash on delivery</option>
            </select>
        </div>
        <button class="btn btn-primary" type="submit">Submit order</button>
        <a href="cart" class="btn btn-secondary">Back to cart</a>
    </form>
</div>
</body>
</html>
