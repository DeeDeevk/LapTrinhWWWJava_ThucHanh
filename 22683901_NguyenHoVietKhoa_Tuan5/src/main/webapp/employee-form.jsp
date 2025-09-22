<%--
  Created by IntelliJ IDEA.
  User: Student
  Date: 9/22/2025
  Time: 11:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page import="fit.iuh.nguyenhovietkhoa_tuan5.model.Department" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Employee Information</title></head>
<body>
<div class="container">
    <img src="${pageContext.request.contextPath}/images/HRbanner.jpg" height="200px"
         width="100%">

    <form action="${pageContext.request.contextPath}/employees" method="get">
        <input type="hidden" name="id"/>
        Name: <input type="text" name="name"/><br/>
        Salary: <input type="text" name="salary"/><br/>
        Department:
        <select name="departmentId">
            <c:forEach var="dep" items="${departments}">
                <option value="${dep.id}">${dep.name}</option>
            </c:forEach>
        </select>

        <br/>
        <input type="submit" value="Save"/>
    </form>
</div>
</body>
</html>
