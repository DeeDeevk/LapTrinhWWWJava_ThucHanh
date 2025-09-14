<%--
  Created by IntelliJ IDEA.
  User: DeeDeevk
  Date: 9/14/2025
  Time: 6:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>IUH Book Store</title>
    <style>
        body{
            margin: 0;
            padding: 0;
        }
        .container{
            width: 100%;
            margin: auto;
            height: 100vh;
        }
        header {
            width: 100%;
            height: 100px;
            background-color: sandybrown;
            display: flex;
            align-items: center;
            justify-content: space-between;
        }
        #nameStore{
            color: white;
            background-color: grey;
            font-size: 20px;
            padding: 10px;
        }
        .commonContainer{
            margin: 10px;
        }
        .bHead{
            color: white;
            background-color: grey;
            padding: 10px;
            margin-left: 10px;
        }
    </style>
</head>
<body>
  <div class="container">
      <header>
          <div class="commonContainer">
              <p id="nameStore">IUH BOOKSTORE</p>
          </div>
          <div class="commonContainer">
              <button class="bHead">HOME</button>
              <button class="bHead">EXAMPLES</button>
              <button class="bHead">SERVICES</button>
              <button class="bHead">PRODUCTS</button>
              <button class="bHead">CONTACT</button>
          </div>
      </header>
      <div>

      </div>
  </div>
</body>
</html>
