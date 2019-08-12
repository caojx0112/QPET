<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<body>
<h2>Hello World!</h2>
</body>
<form action="api/comment" method="get">
    id<input type="text" name="id">
    有图:<input type="text" name="type">
    无图:<input type="text" name="type">
    <input type="submit" value="Comment">
</form>
</html>
