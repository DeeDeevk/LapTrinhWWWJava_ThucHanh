<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Danh sách sách</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>.book-card img{height:200px;object-fit:cover}</style>
</head>
<body>
<div class="container">
    <h2 class="mb-3">Danh sách sách</h2>
    <div class="row">
        <c:forEach items="${books}" var="b">
            <div class="col-md-3 mb-4">
                <div class="card book-card">
                    <img src="${pageContext.request.contextPath}/${b.image}" class="card-img-top" alt="${b.title}">
                    <div class="card-body">
                        <h5 class="card-title">${b.title}</h5>
                        <p class="card-text">Tác giả: ${b.author}</p>
                        <p class="card-text">Price: ${b.price} VND</p>
                        <a href="books?action=detail&id=${b.id}" class="btn btn-sm btn-outline-primary">Chi tiết</a>
                        <form method="post" action="cart" style="display:inline">
                            <input type="hidden" name="op" value="add"/>
                            <input type="hidden" name="id" value="${b.id}" />
                            <button class="btn btn-sm btn-success">Add to cart</button>
                        </form>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>
