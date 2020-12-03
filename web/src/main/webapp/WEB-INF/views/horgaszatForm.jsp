<%--
  Created by IntelliJ IDEA.
  User: adam
  Date: 2020. 12. 03.
  Time: 20:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Horgászat hozzáadása</title>
</head>
<body>
<form:form method="post" action="addHorgaszat" modelAttribute="horgaszat">
    <form:label path="horgaszatHely">Horgászhely</form:label>
    <form:input path="horgaszatHely"/>
    <form:label path="horgaszatDatum">Dátum</form:label>
    <form:input type="date" path="horgaszatDatum"/>
    <form:label path="horgaszDarab">Résztvevők száma</form:label>
    <form:input path="horgaszDarab"/>
    <form:label path="halDarab">Fogott halak száma</form:label>
    <form:input path="halDarab"/>
    <input type="submit" value="Küldés"/>

    <table id="my_table">


</form:form>
</body>
</html>
