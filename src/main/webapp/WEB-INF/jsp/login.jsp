<%--
  Created by IntelliJ IDEA.
  User: HONGYI LU
  Date: 2020/2/20
  Time: 10:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AccountServiceTest</title>
</head>
<body>
<form action="/user/getloginfo" method="post">
    Username:<br>
    <input type="text" name="username"><br>
    Password:<br>
    <input type="text" name="password"><br>

    <input type="radio" name="groupid" value="1">Login as Administrator<br>
    <input type="radio" name="groupid" value="2" checked>Login as User<br>


    <input type="submit" value="submit" /><br />
</form>

</body>
</html>

