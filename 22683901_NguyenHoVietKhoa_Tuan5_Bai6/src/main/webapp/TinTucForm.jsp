<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Thêm tin tức</title>
  <script>
    function validateForm() {
      const tieuDe = document.getElementById('tieuDe').value.trim();
      const noiDung = document.getElementById('noiDung').value;
      const lienKet = document.getElementById('lienKet').value.trim();
      const madm = document.getElementById('madm').value;

      let errors = [];
      if (!tieuDe) errors.push('Tiêu đề bắt buộc.');
      if (!noiDung || noiDung.length > 255) errors.push('Nội dung bắt buộc và không quá 255 ký tự.');
      const re = /^https?:\/\/.+/i;
      if (!re.test(lienKet)) errors.push('Liên kết phải bắt đầu bằng http:// hoặc https://');
      if (!madm) errors.push('Chọn danh mục.');

      if (errors.length > 0) {
        alert(errors.join("\\n"));
        return false;
      }
      return true;
    }
  </script>
</head>
<body>
<h1>Thêm tin tức</h1>

<c:if test="${not empty errorMsg}">
  <div style="color:red">${errorMsg}</div>
</c:if>

<form action="${pageContext.request.contextPath}/tintuc-form" method="post" onsubmit="return validateForm();">
  <div><label>Tiêu đề:</label><br/>
    <input id="tieuDe" name="tieuDe" type="text" value="${param.tieuDe}" required></div>
  <div><label>Nội dung (max 255):</label><br/>
    <textarea id="noiDung" name="noiDung" rows="4" cols="50" maxlength="255">${param.noiDung}</textarea></div>
  <div><label>Liên kết:</label><br/>
    <input id="lienKet" name="lienKet" type="text" value="${param.lienKet}" required></div>
  <div><label>Danh mục:</label><br/>
    <select id="madm" name="madm">
      <option value="">--Chọn--</option>
      <c:forEach items="${danhMucs}" var="dm">
        <option value="${dm.madm}">${dm.tenDanhMuc}</option>
      </c:forEach>
    </select>
  </div>
  <div style="margin-top:10px;">
    <button type="submit">Thêm</button>
    <a href="${pageContext.request.contextPath}/tintuc">Hủy</a>
  </div>
</form>
</body>
</html>
