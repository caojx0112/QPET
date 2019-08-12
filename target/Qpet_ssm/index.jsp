<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<body>
<h2>Hello World!</h2>
</body>
<form action="/admin/login" method="post">
    username:<input type="text" name="username">
    password:<input type="password" name="password">

    <input type="submit" value="login">
</form>

<a href="find.jsp">find</a>
<a href="findComment.jsp">Comment</a>

<a href="itemdetail.jsp">itemdetail</a>

<a href="finditemimage.jsp">finditemimage</a>
<a href="update.jsp">update</a>
</html>
