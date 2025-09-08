<%--
  Created by IntelliJ IDEA.
  User: st
  Date: 9/8/2025
  Time: 10:58 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>st Result</title>
    <style>
        body { font-family: Arial, sans-serif; background: #f2f2f2; }
        .container { width: 60%; margin: auto; background: #fff; padding: 20px; border: 1px solid #ccc; }
        h2 { text-align: center; }
        table { width: 100%; border-collapse: collapse; margin-top: 15px; }
        td { padding: 8px; border-bottom: 1px solid #ddd; }
        .label { font-weight: bold; width: 30%; }
        th, td { border: 1px solid #ddd; text-align: center; }
    </style>
</head>
<body>
<div class="container">
    <h2>Student Registration Details</h2>
    <table>
        <tr><td class="label">First Name:</td><td>${student.firstName}</td></tr>
        <tr><td class="label">Last Name:</td><td>${student.lastName}</td></tr>
        <tr><td class="label">Date of Birth:</td><td>${student.dob}</td></tr>
        <tr><td class="label">Email:</td><td>${student.email}</td></tr>
        <tr><td class="label">Mobile:</td><td>${student.phone}</td></tr>
        <tr><td class="label">Gender:</td><td>${student.gender}</td></tr>
        <tr><td class="label">Address:</td><td>${student.address}</td></tr>
        <tr><td class="label">City:</td><td>${student.city}</td></tr>
        <tr><td class="label">Pin Code:</td><td>${student.pinCode}</td></tr>
        <tr><td class="label">State:</td><td>${student.state}</td></tr>
        <tr><td class="label">Country:</td><td>${student.country}</td></tr>
        <tr>
            <td class="label">Hobbies:</td>
            <td>
                <c:forEach var="hobby" items="${student.hobbies}">
                    ${hobby}&nbsp;
                </c:forEach>
            </td>
        </tr>
        <tr><td class="label">Course Applied:</td><td>${student.course}</td></tr>
    </table>

    <h3>Qualification</h3>
    <table>
        <tr>
            <th>Examination</th>
            <th>Board</th>
            <th>Percentage</th>
            <th>Year of Passing</th>
        </tr>
    </table>
</div>
</body>
</html>

