<%--
  Created by IntelliJ IDEA.
  User: adam
  Date: 2020. 12. 03.
  Time: 20:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title>Horgászat hozzáadása</title>
</head>
<body>
<div class="container">
    <h2 class="mt-sm-3">Új horgászat felvétele:</h2>
    <div class="card">
        <div class="card-body">
            <form:form method="post" action="addHorgaszat" modelAttribute="horgaszat">
            <div class="form-group row">
                <form:label path="horgaszatHely" for="horgaszatHely" class="col-sm-3 col-form-label" >Horgászhely:</form:label>
                <div class="col-sm-9">
                    <form:input path="horgaszatHely" type="text" class="form-control" name="horgaszatHely" placeholder="Helyszín"/>
                </div>
            </div>
            <div class="form-group row">
                <form:label path="horgaszatDatum" for="horgaszatDatum" class="col-sm-3 col-form-label">Horgászat dátuma:</form:label>
                <div class="col-sm-9">
                    <form:input path="horgaszatDatum" type="date" class="form-control" name="horgaszatDatum"/>
                </div>
            </div>
            <div class="form-group row">
                <form:label path="horgaszDarab" for="horgaszatDarab" class="col-sm-3 col-form-label">Résztvevők száma:</form:label>
                <div class="col-sm-9">
                    <form:input path="horgaszDarab" type="number" min="1" value="1" class="form-control" name="horgaszatDarab"/>
                </div>
            </div>
            <div class="form-group row">
                <form:label path="halDarab" for="halDarab" class="col-sm-3 col-form-label">Fogott halak száma:</form:label>
                <div class="col-sm-9">
                    <form:input path="halDarab" type="number" min="0" class="form-control" name="halDarab"/>
                </div>
            </div>
            <div class="form-group row">
                <form:label path="sor.nev" for="sorNev" class="col-sm-3 col-form-label">Sör neve: </form:label>
                <div class="col-sm-9">
                    <form:input path="sor.nev" type="text" class="form-control" name="sorNev" placeholder="Név"/>
                </div>
            </div>
            <div class="form-group row">
                <form:label path="sor.darab" for="sorDarab" class="col-sm-3 col-form-label">Sörök száma:</form:label>
                <div class="col-sm-9">
                    <form:input path="sor.darab" type="number" min="0" class="form-control" name="sorNev"/>
                </div>
            </div>
            <button type="submit" class="btn btn-success">Mentés</button>
            <table id="my_table">
                </form:form>
        </div>
    </div>
</div>
</body>
</html>
