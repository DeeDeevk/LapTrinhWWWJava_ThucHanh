<%--
  Created by IntelliJ IDEA.
  User: DeeDeevk
  Date: 9/11/2025
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Registration Form</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f9f9f9;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .form-container {
            border: 1px solid #28a745;
            padding: 20px 30px;
            border-radius: 6px;
            background: #fff;
            width: 350px;
            box-shadow: 0 2px 8px rgba(0,0,0,0.1);
        }

        h2 {
            text-align: center;
            margin-bottom: 20px;
        }

        .input-group {
            margin-bottom: 15px;
        }

        input[type="text"],
        input[type="email"],
        input[type="password"],
        select {
            width: 100%;
            padding: 8px;
            margin-top: 5px;
            border: 1px solid #ddd;
            border-radius: 4px;
        }

        .gender-group {
            margin-top: 10px;
        }

        .gender-group label {
            margin-right: 15px;
        }

        .btn {
            width: 100%;
            background: #1877f2;
            color: #fff;
            padding: 10px;
            border: none;
            border-radius: 6px;
            font-size: 16px;
            cursor: pointer;
        }

        .btn:hover {
            background: #145dbf;
        }
    </style>
</head>
<body>
<div class="form-container">
    <h2>User Registration Form</h2>
    <form action="account" method="post">
        <div class="input-group">
            <input type="text" name="firstName" placeholder="First Name" required>
        </div>
        <div class="input-group">
            <input type="text" name="lastName" placeholder="Last Name" required>
        </div>
        <div class="input-group">
            <input type="email" name="email" placeholder="Your Email" required>
        </div>
        <div class="input-group">
            <input type="password" name="password" placeholder="Password" required>
        </div>

        <div class="input-group">
            <label>Birthday</label><br>
            <select name="month" required>
                <option value="">Month</option>
                <% for(int i=1; i<=12; i++){ %>
                <option><%= i %></option>
                <% } %>
            </select>
            <select name="day" required>
                <option value="">Day</option>
                <% for(int i=1; i<=31; i++){ %>
                <option><%= i %></option>
                <% } %>
            </select>
            <select name="year" required>
                <option value="">Year</option>
                <% for(int y=2025; y>=1900; y--){ %>
                <option><%= y %></option>
                <% } %>
            </select>
        </div>

        <div class="gender-group">
            <label>Gender</label><br>
            <input type="radio" name="gender" value="Female" required> Female
            <input type="radio" name="gender" value="Male"> Male
        </div>

        <div class="input-group">
            <button type="submit" class="btn">Sign Up</button>
        </div>
    </form>
</div>
</body>
</html>
