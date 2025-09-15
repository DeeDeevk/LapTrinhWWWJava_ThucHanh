<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.Map" %>
<%@ page import="fit.iuh.bookstore.tuan04_duongthekhanh_22660101.model.CartItem" %>
<!DOCTYPE html>
<html>
<head>
    <title>Giỏ hàng</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <h3>Your Shopping Cart</h3>

    <c:set var="cart" value="${sessionScope.cart}" />
    <c:if test="${empty cart}">
        <p>Giỏ hàng trống. <a href="books">Tiếp tục xem sách</a></p>
    </c:if>

    <c:if test="${not empty cart}">
        <table class="table table-bordered">
            <thead>
            <tr><th>Product ID</th><th>Product</th><th>Price</th><th>Qty</th><th>Total</th><th>Action</th></tr>
            </thead>
            <tbody>
            <c:set var="sum" value="0" />
            <c:forEach items="${cart.values()}" var="item">
                <tr>
                    <td>${item.book.id}</td>
                    <td>${item.book.title}</td>
                    <td>${item.book.price}</td>
                    <td>
                        <form method="post" action="cart" class="d-inline">
                            <input type="hidden" name="op" value="update" />
                            <input type="hidden" name="id" value="${item.book.id}" />
                            <input type="number" name="qty" value="${item.quantity}" min="0" style="width:70px" />
                            <button class="btn btn-sm btn-primary" type="submit">Update</button>
                        </form>
                    </td>
                    <td>${item.total}</td>
                    <td>
                        <form method="post" action="cart" style="display:inline">
                            <input type="hidden" name="op" value="remove"/>
                            <input type="hidden" name="id" value="${item.book.id}"/>
                            <button class="btn btn-sm btn-danger">Remove</button>
                        </form>
                    </td>
                </tr>
                <c:set var="sum" value="${sum + item.total}" />
            </c:forEach>
            </tbody>
            <tfoot>
            <tr><td colspan="4" class="text-end"><strong>Total price</strong></td><td colspan="2">${sum} VND</td></tr>
            </tfoot>
        </table>

        <a href="books" class="btn btn-secondary">Continue shopping</a>
        <form method="post" action="cart" style="display:inline">
            <input type="hidden" name="op" value="clear"/>
            <button class="btn btn-warning">Clear cart</button>
        </form>

        <a href="checkout" class="btn btn-success">Checkout</a>
    </c:if>
</div>
</body>
</html>
