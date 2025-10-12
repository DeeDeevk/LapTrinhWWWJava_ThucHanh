<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>Quản lý tin tức</title></head>
<body>
<h1>Quản lý (Xóa tin tức)</h1>
<form action="${pageContext.request.contextPath}/quanly" method="get">
  <label>Chọn danh mục:</label>
  <select name="madm" onchange="this.form.submit()">
    <c:forEach items="${danhMucs}" var="dm">
      <option value="${dm.madm}" ${dm.madm == currentMadm ? 'selected' : ''}>${dm.tenDanhMuc}</option>
    </c:forEach>
  </select>
</form>

<c:if test="${not empty tins}">
  <table border="1" cellpadding="5">
    <tr><th>MATT</th><th>Tiêu đề</th><th>Hành động</th></tr>
    <c:forEach items="${tins}" var="t">
      <tr>
        <td>${t.matt}</td>
        <td>${t.tieuDe}</td>
        <td>
          <form action="${pageContext.request.contextPath}/quanly" method="post" style="display:inline;">
            <input type="hidden" name="action" value="delete"/>
            <input type="hidden" name="matt" value="${t.matt}"/>
            <button type="submit" onclick="return confirm('Xóa tin này?');">Xóa</button>
          </form>
        </td>
      </tr>
    </c:forEach>
  </table>
</c:if>
<p><a href="${pageContext.request.contextPath}/tintuc">Về danh sách</a></p>
</body>
</html>
