<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form upload</title>
    <style>
        .form-container {
            padding: 10px;
            background-color: grey;
            width: 40%;
            border-radius: 10px;
        }

        .form-group {
            display: flex;
            flex-direction: column;
            gap: 5px;
            margin-bottom: 15px;
        }

        .form-group h3 {
            color: white;
            font-family: Arial;
            margin: 0 0 10px 20px;
        }

        .form-group input, .form-group textarea, .form-group button {
            margin-left: 20px;
            font-family: Arial;
            border-radius: 5px;
            box-sizing: border-box; /* Đảm bảo padding và border không làm tăng kích thước */
        }

        .name-group {
            display: flex;
            gap: 10px; /* Khoảng cách giữa hai input */
            width: 83%;
        }

        .name-group input {
            flex: 1; /* Hai input first và last chia đều không gian */
        }

        .full-width {
            width: 80%; /* Các input khác có chiều rộng bằng name-group */
        }

        .form-group textarea {
            width: 80%; /* Textarea cũng có chiều rộng bằng name-group */
        }

        .form-group button {
            border: white;
            font-family: Arial;
            width: 30%;
            padding: 3px 10px;
        }

        .form-group button:hover {
            opacity: 0.75;
        }
    </style>
</head>
<body>
<form action="processFormUpload" method="post" enctype="multipart/form-data" class="form-container">
    <h1 style="color: white; font-family: Arial; margin-left: 20px">Register</h1>
    <div class="form-group">
        <h3>Name</h3>
        <div class="name-group">
            <input type="text" name="first" placeholder="First Name">
            <input type="text" name="last" placeholder="Last Name">
        </div>
    </div>
    <div class="form-group">
        <h3>Username</h3>
        <input type="text" name="username" class="full-width" placeholder="Username">
    </div>
    <div class="form-group">
        <h3>E-mail</h3>
        <input type="text" name="email" class="full-width" placeholder="E-mail">
    </div>
    <div class="form-group">
        <h3>Password</h3>
        <input type="password" name="password" class="full-width" placeholder="Password">
    </div>
    <div class="form-group">
        <h3>Facebook</h3>
        <input type="text" name="facebook" class="full-width" placeholder="Facebook">
    </div>
    <div class="form-group">
        <h3>Short Bio</h3>
        <textarea name="shortbio" class="full-width" placeholder="Text something..."></textarea>
    </div>
    <div class="form-group">
        <button type="submit">Submit</button>
    </div>
</form>
</body>
</html>