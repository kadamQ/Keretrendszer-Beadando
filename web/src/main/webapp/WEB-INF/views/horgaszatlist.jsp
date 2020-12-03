<%--
  Created by IntelliJ IDEA.
  User: adam
  Date: 2020. 12. 03.
  Time: 2:02
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Horgaszatok</title>
</head>
<body>
<c:if test="${!empty horgaszatok}">
    <table frame="border" rules="all">
        <tr>
            <th rowspan="2">Azonosító</th>
            <th rowspan="2">Horgászhely</th>
            <th rowspan="2">Dátum</th>
            <th rowspan="2">Résztvevők száma</th>
            <th rowspan="2">Fogott halak száma</th>
            <th colspan="2">Sör</th>
        </tr>
        <tr>
            <th>Sör neve</th>
            <th>Sör száma</th>
        </tr>
<c:forEach items="${horgaszatok}" var="horgaszat">
    <tr>
        <td><a href="${pageContext.servletContext.contextPath}/horgaszat/${horgaszat.id}">${horgaszat.id}</a></td>
        <td>${horgaszat.horgaszatHely}</td>
        <td>${horgaszat.horgaszatDatum}</td>
        <td>${horgaszat.horgaszDarab}</td>
        <td>${horgaszat.halDarab}</td>
        <td>${horgaszat.sor.nev}</td>
        <td>${horgaszat.sor.darab}</td>
    </tr>
</c:forEach>
    </table>
</c:if>
<c:if test="${empty horgaszatok}">
<c:out value="Nincs horgaszat"/></c:if>

<form action="${pageContext.servletContext.contextPath}/addHorgaszat">
    <input type="submit" value="Horgászat hozzáadása">
</form>

</body>
</html>
