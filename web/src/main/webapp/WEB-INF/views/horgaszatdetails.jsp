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
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <title>${horgaszat.horgaszatDatum}</title>
</head>
<body>
<table frame="border" rules="all" class="table table-bordered table-hover">
    <thead class="thead-dark h2 text-sm-center">
    <tr>
        <th class="align-middle" rowspan="2">Dátum</th>
        <th class="align-middle" rowspan="2">Horgászhely</th>
        <th class="align-middle" rowspan="2">Résztvevők száma</th>
        <th class="align-middle" rowspan="2">Fogott halak száma</th>
        <th class="align-middle" colspan="2">Sör</th>
        <th class="align-middle" rowspan="2">
            <a class="btn btn-outline-light btn-lg btn-block" type="button"
               href="${pageContext.servletContext.contextPath}/horgaszatok">Vissza</a>
        </th>
    </tr>
    <tr>
        <th>Név</th>
        <th>Darab</th>
    </tr>
    </thead>
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
        <td class="align-middle"><a class="btn btn-outline-success btn-lg btn-block" type="button"
                                    href="${pageContext.servletContext.contextPath}/fogasok/add/${id}"
        >Fogás hozzáadása</a>
        </td>
    </tr>
    </tbody>
</table>
<table frame="border" rules="all" class="table">
    <thead class="thead-dark h2 text-sm-center">
    <tr>
        <th class="align-middle">Fogások</th>
    </tr>
    </thead>
</table>
<table frame="border" rules="all" class="table table-bordered table-hover">
    <thead class="thead-dark h2 text-sm-center">
    <tr>
        <th class="align-middle" rowspan="2">Hal neve</th>
        <th class="align-middle" rowspan="2">Hal tömege</th>
        <th class="align-middle" rowspan="2">Horgaszbot fajtája</th>
        <th class="align-middle" rowspan="2">Csali fajtája</th>
        <th class="align-middle" rowspan="2">Törlés</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${horgaszat.fogasok}" var="fogas">
        <tr class="text-sm-center h4">
            <td class="align-middle">${fogas.hal.nev}</td>
            <td class="align-middle">${fogas.tomeg}</td>
            <td class="align-middle">${fogas.horgaszbot}</td>
            <td class="align-middle">${fogas.csali}</td>
            <td class="align-middle"><a class="btn btn-outline-danger btn-lg btn-block fa fa-trash" type="button"
                                        href="${pageContext.servletContext.contextPath}/fogasok/delete/${fogas.id}&${horgaszat.id}"></a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
