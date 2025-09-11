<%--
  Created by IntelliJ IDEA.
  User: DeeDeevk
  Date: 9/11/2025
  Time: 2:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <meta charset="UTF-8">
  <title>Account List</title>
</head>
<body>
<h1>Account Registration Successful!</h1>
<h2>List of Registered Accounts:</h2>
<table border="1">
  <thead>
  <tr>
    <th>ID</th>
    <th>First Name</th>
    <th>Last Name</th>
    <th>Email</th>
    <th>Date of Birth</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach var="account" items="${accounts}">
    <tr>
      <td>${account.id}</td>
      <td>${account.firstName}</td>
      <td>${account.lastName}</td>
      <td>${account.email}</td>
      <td>${account.dateOfBirth}</td>
    </tr>
  </c:forEach>
  </tbody>
</table>
</body>
</html>
