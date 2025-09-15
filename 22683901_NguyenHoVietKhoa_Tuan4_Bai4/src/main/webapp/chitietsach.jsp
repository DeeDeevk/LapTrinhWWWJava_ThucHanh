<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Chi tiết sách</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <h3>Product details: ${book.title} - Tác giả: ${book.author}</h3>
    <div class="row">
        <div class="col-md-4">
            <img src="${pageContext.request.contextPath}/${book.imgurl}" class="img-fluid" alt="${book.title}">
        </div>
        <div class="col-md-8">
            <p>Price (VND): ${book.price}</p>
            <p>Quantity: ${book.quantity}</p>
            <form method="post" action="cart">
                <input type="hidden" name="op" value="add"/>
                <input type="hidden" name="id" value="${book.id}"/>
                <button class="btn btn-success">Add to cart</button>
                <a href="books" class="btn btn-secondary">Back to list</a>
            </form>
        </div>
    </div>
</div>
</body>
</html>
