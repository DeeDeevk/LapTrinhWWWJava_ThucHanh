<%--
  Created by IntelliJ IDEA.
  User: Student
  Date: 9/8/2025
  Time: 10:33 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student Registration Form</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f2f2f2;
        }
        .container {
            width: 70%;
            margin: auto;
            background: #fff;
            padding: 20px;
            border: 1px solid #ccc;
        }
        h2 {
            text-align: center;
            margin-bottom: 20px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
        }
        td {
            padding: 8px;
        }
        input[type="text"], input[type="email"], input[type="date"], textarea {
            width: 95%;
            padding: 6px;
            border: 1px solid #ccc;
            border-radius: 3px;
        }
        input[type="radio"], input[type="checkbox"] {
            margin-right: 5px;
        }
        .btn {
            text-align: center;
            margin-top: 15px;
        }
        input[type="submit"], input[type="reset"] {
            padding: 8px 16px;
            margin: 5px;
            border: none;
            border-radius: 3px;
            cursor: pointer;
        }
        input[type="submit"] {
            background-color: #007BFF;
            color: white;
        }
        input[type="reset"] {
            background-color: #6c757d;
            color: white;
        }
        .qualification-table, .qualification-table th, .qualification-table td {
            border: 1px solid #ccc;
        }
        .qualification-table th, .qualification-table td {
            padding: 6px;
            text-align: center;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>Student Registration Form</h2>
    <form action="student" method="post">
        <table>
            <tr>
                <td>First Name</td>
                <td><input type="text" name="firstName"></td>
                <td>Last Name</td>
                <td><input type="text" name="lastName"></td>
            </tr>
            <tr>
                <td>Date of Birth</td>
                <td><input type="date" name="dob"></td>
                <td>Email</td>
                <td><input type="email" name="email"></td>
            </tr>
            <tr>
                <td>Mobile</td>
                <td><input type="text" name="mobile"></td>
                <td>Gender</td>
                <td>
                    <input type="radio" name="gender" value="Male"> Male
                    <input type="radio" name="gender" value="Female"> Female
                </td>
            </tr>
            <tr>
                <td>Address</td>
                <td colspan="3"><textarea name="address" rows="3"></textarea></td>
            </tr>
            <tr>
                <td>City</td>
                <td><input type="text" name="city"></td>
                <td>Pin Code</td>
                <td><input type="text" name="pinCode"></td>
            </tr>
            <tr>
                <td>State</td>
                <td><input type="text" name="state"></td>
                <td>Country</td>
                <td><input type="text" name="country" value="India"></td>
            </tr>
            <tr>
                <td>Hobbies</td>
                <td colspan="3">
                    <input type="checkbox" name="hobbies" value="Drawing"> Drawing
                    <input type="checkbox" name="hobbies" value="Singing"> Singing
                    <input type="checkbox" name="hobbies" value="Dancing"> Dancing
                    <input type="checkbox" name="hobbies" value="Sketching"> Sketching
                    <input type="checkbox" name="hobbies" value="Others"> Others
                </td>
            </tr>
        </table>

        <h3>Qualification</h3>
        <table class="qualification-table" width="100%">
            <tr>
                <th>Sl.No</th>
                <th>Examination</th>
                <th>Board</th>
                <th>Percentage</th>
                <th>Year of Passing</th>
            </tr>
            <tr>
                <td>1</td>
                <td>Class X</td>
                <td><input type="text" name="board1"></td>
                <td><input type="text" name="percentage1"></td>
                <td><input type="text" name="year1"></td>
            </tr>
            <tr>
                <td>2</td>
                <td>Class XII</td>
                <td><input type="text" name="board2"></td>
                <td><input type="text" name="percentage2"></td>
                <td><input type="text" name="year2"></td>
            </tr>
        </table>

        <h3>Course applies for</h3>
        <input type="radio" name="course" value="BCA"> BCA
        <input type="radio" name="course" value="B.Com"> B.Com
        <input type="radio" name="course" value="B.Sc"> B.Sc
        <input type="radio" name="course" value="B.A"> B.A

        <div class="btn">
            <input type="submit" value="Submit">
            <input type="reset" value="Reset">
        </div>
    </form>
</div>
</body>
</html>