<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Danh sách tin tức</title>
  <style>
    /* CSS layout cơ bản */
    body{font-family: Arial; margin: 20px;}
    .sidebar{float:left;width:200px;}
    .content{margin-left:220px;}
    ul{list-style:none;padding:0;}
  </style>
</head>
<body>
<h1>Quản lý Tin tức</h1>
<div class="sidebar">
  <h3>Danh mục</h3>
  <ul>
    <c:forEach items="${danhMucs}" var="dm">
      <li><a href="${pageContext.request.contextPath}/tintuc?madm=${dm.madm}">${dm.tenDanhMuc}</a></li>
    </c:forEach>
  </ul>
  <p><a href="${pageContext.request.contextPath}/tintuc-form">Thêm tin mới</a></p>
  <p><a href="${pageContext.request.contextPath}/quanly">Quản lý (xóa)</a></p>
</div>

<div class="content">
  <h2>Tin tức thuộc danh mục
    <c:forEach items="${danhMucs}" var="dm">
      <c:if test="${dm.madm == currentMadm}">${dm.tenDanhMuc}</c:if>
    </c:forEach>
  </h2>

  <c:if test="${empty tins}">
    <p>Không có tin nào.</p>
  </c:if>

  <c:forEach items="${tins}" var="t">
    <div style="border-bottom:1px solid #ccc; padding:10px 0;">
      <h3>${t.tieuDe}</h3>
      <p>${t.noiDung}</p>
      <p><a target="_blank" href="${t.lienKet}">${t.lienKet}</a></p>
    </div>
  </c:forEach>
</div>
</body>
</html>
