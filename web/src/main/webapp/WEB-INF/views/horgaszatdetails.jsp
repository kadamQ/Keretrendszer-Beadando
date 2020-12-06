<%--
  Created by IntelliJ IDEA.
  User: adam
  Date: 2020. 12. 03.
  Time: 16:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
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

<table>
    <a href="${pageContext.servletContext.contextPath}/fogasok/add/${id}">Fogás hozzáadása</a>
        <ul>
            <c:forEach items="${horgaszat.fogasok}" var="fogas">
                <li>
                    <p>${fogas.hal} ${fogas.tomeg} ${fogas.horgaszbot} ${fogas.csali}</p>
                    <a href="${pageContext.servletContext.contextPath}/fogasok/delete/${fogas.id}&${horgaszat.id}">Fogas törlése</a>
                </li>
            </c:forEach>
        </ul>
</table>
</body>
</html>
