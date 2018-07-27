<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>hello world</h1>
<form action="/hello/upload" method="post" enctype="multipart/form-data">
    <input type="file" name="file">
    <input type="submit">
</form>
<hr>
<form action="/hello/user" method="post" enctype="application/x-www-form-urlencoded">
    <input type="text" name="username"><br>
    <input type="password" name="password"><br>
    <input type="submit">
</form>
</body>
</html>
