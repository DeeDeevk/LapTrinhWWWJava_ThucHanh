<%--
  Created by IntelliJ IDEA.
  User: DeeDeevk
  Date: 8/22/2025
  Time: 8:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Upload File</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/uploadFile" method="post" style="width: 30%; margin: auto; border-radius: 10px; border: solid" enctype="multipart/form-data">
    <h1 style="font-family: Arial; justify-content: center; align-items: center; display: flex">Upload multi-files</h1>
    <div style="margin-left: 20px;">
        <h3 style="font-family: Arial">File #1: </h3>
        <input style="width: 90%; border-radius: 5px" type="file" name="file1">
        <h3 style="font-family: Arial">File #2: </h3>
        <input style="width: 90%; border-radius: 5px" type="file" name="file2">
        <h3 style="font-family: Arial">File #3: </h3>
        <input style="width: 90%; border-radius: 5px" type="file" name="file3">
        <h3 style="font-family: Arial">File #4: </h3>
        <input style="width: 90%; border-radius: 5px" type="file" name="file4">
        <h3 style="font-family: Arial">File #5: </h3>
        <input style="width: 90%; border-radius: 5px" type="file" name="file5">
        <br>
        <button type="submit" style="margin-top: 10px; border-radius: 5px; padding: 10px 20px 10px 20px; margin-bottom: 10px">Upload</button>
        <button type="submit" style="margin-top: 10px; border-radius: 5px; padding: 10px 20px 10px 20px; margin-bottom: 10px">Reset</button>
    </div>

</form>
</body>
</html>
