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
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <title>Horgaszatok</title>
</head>
<body>
<c:if test="${!empty horgaszatok}">
    <table frame="border" rules="all" class="table table-bordered table-hover">
        <thead class="thead-dark h2 text-sm-center">
        <tr>
            <th class="align-middle" rowspan="2">Dátum</th>
            <th class="align-middle" rowspan="2">Horgászhely</th>
            <th class="align-middle" rowspan="2">Résztvevők száma</th>
            <th class="align-middle" rowspan="2">Fogott halak száma</th>
            <th class="align-middle" colspan="2">Sör</th>
            <th class="align-middle" rowspan="2">
                <a class="btn btn-outline-light btn-lg btn-block fa fa-home" type="button"
                   href="${pageContext.servletContext.contextPath}"></a>
            </th>
        </tr>
        <tr>
            <th>Név</th>
            <th>Darab</th>
        </tr>
        <thead>
        <c:forEach items="${horgaszatok}" var="horgaszat">
        <tbody>
        <tr class="text-sm-center h4">
            <td class="align-middle">
                <a href="${pageContext.servletContext.contextPath}/horgaszat/${horgaszat.id}">${horgaszat.horgaszatDatum}</a>
            </td>
            <td class="align-middle">${horgaszat.horgaszatHely}</td>
            <td class="align-middle">${horgaszat.horgaszDarab}</td>
            <td class="align-middle">${horgaszat.halDarab}</td>
            <td class="align-middle">${horgaszat.sor.nev}</td>
            <td class="align-middle">${horgaszat.sor.darab}</td>
            <td class="align-middle"><a class="btn btn-outline-danger btn-lg btn-block" type="button"
                                        href="${pageContext.servletContext.contextPath}/horgaszatok/delete/${horgaszat.id}"
            >Törlés</a>
            </td>
        </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>
<c:if test="${empty horgaszatok}">
    <c:out value="Nincs horgaszat"/></c:if>
</body>
</html>
