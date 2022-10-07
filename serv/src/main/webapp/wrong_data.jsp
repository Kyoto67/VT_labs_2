<%--
  Created by IntelliJ IDEA.
  User: kyoto
  Date: 07.10.2022
  Time: 14:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="true" %>
<html>
<head>
    <title>ERROR</title>
<%--    <link rel="stylesheet" href="css/style.css">--%>
</head>
<body>
<br>
<br>
<p align="left"> WRONG DATA!!! </p>
<br>
<p align="left"> <%= request.getAttribute("error_message") %></p>
<br>
<div class="form">
    <form method="get" action="index.jsp">
        <input type="submit" value='Go back' >
    </form>
</div>
</body>
</html>