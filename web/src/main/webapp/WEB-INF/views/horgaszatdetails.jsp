<%--
  Created by IntelliJ IDEA.
  User: adam
  Date: 2020. 12. 03.
  Time: 16:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>${horgaszat.id}</title>
</head>
<body>
<table>
    <tr><td>Horgászat időpontja:</td><td>${horgaszat.horgaszatDatum}</td></tr>
    <tr><td>Horgászhely:</td><td>${horgaszat.horgaszatHely}</td></tr>
    <tr><td>Résztvevők száma:</td><td>${horgaszat.horgaszDarab}</td></tr>
    <tr><td>Fogott halak száma:</td><td>${horgaszat.halDarab}</td></tr>
    <tr><td>Fogások:</td><td>${horgaszat.fogasok}</td></tr>
    <tr><td>Sör neve:</td><td>${horgaszat.sor.nev}</td></tr>
    <tr><td>Sörök szama:</td><td>${horgaszat.sor.darab}</td></tr>
</table>
<form action="${pageContext.servletContext.contextPath}">
    <input type="submit" value="Home">
</form>

</body>
</html>
