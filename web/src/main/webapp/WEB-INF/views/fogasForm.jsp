<%--
  Created by IntelliJ IDEA.
  User: adam
  Date: 2020. 12. 04.
  Time: 23:23
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title>Új fogás hozzáadása</title>
</head>
<body>
<h2 class="mt-sm-3 ml-sm-3">Új fogás felvétele:</h2>
<div class="card">
    <div class="card-body">
        <form:form method="post" action="${pageContext.request.contextPath}/fogasok/add/${horgaszatId}"
                   modelAttribute="fogas">
            <div class="form-group row">
                <form:label path="hal" for="halNev"
                            class="col-sm-2 col-form-label">Hal neve:</form:label>
                <div class="col-sm-10">
                    <form:input path="hal" type="text" placeholder="Név" name="halNev" class="form-control"/>
                </div>
            </div>
            <div class="form-group row">
                <form:label path="tomeg" for="halTomeg"
                            class="col-sm-2 col-form-label">Hal tömege:</form:label>
                <div class="col-sm-10">
                    <form:input path="tomeg" type="number" step="0.1" min="0" name="halTomeg" class="form-control"/>
                </div>
            </div>
            <div class="form-group row">
                <form:label path="tomeg" for="halTomeg"
                            class="col-sm-2 col-form-label">Horgászbot fajtája:</form:label>
                <div class="col-sm-10">
                    <form:select path="horgaszbot" class="form-control">
                        <form:options items="${horgaszbot}"/>
                    </form:select>
                </div>
            </div>
            <div class="form-group row mb-sm-4">
                <form:label path="tomeg" for="halTomeg"
                            class="col-sm-2 col-form-label">Csali fajtája:</form:label>
                <div class="col-sm-10">
                    <form:select path="csali" class="form-control">
                        <form:options items="${csali}"/>
                    </form:select>
                </div>
            </div>
            <button type="submit" class="btn btn-success btn-lg btn-block">Mentés</button>
            <a class="btn btn-outline-success btn-lg btn-block" type="button"
               href="${pageContext.servletContext.contextPath}/horgaszat/${id}">Vissza</a>
        </form:form>
    </div>
</div>
</div>
</body>
</html>
