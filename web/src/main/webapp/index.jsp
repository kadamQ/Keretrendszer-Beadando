<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title>Horgászat adatbázis</title>
</head>
<body>
<form action="${pageContext.servletContext.contextPath}/horgaszatok">
    <input type="submit" value="Horgászatok">
</form>
<form action="${pageContext.servletContext.contextPath}/addHorgaszat">
    <input type="submit" value="Horgászat hozzáadása">
</form>
</body>
</html>
