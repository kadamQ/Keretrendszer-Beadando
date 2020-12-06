<%--
  Created by IntelliJ IDEA.
  User: adam
  Date: 2020. 12. 06.
  Time: 18:23
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title>Horgászatok két időpont között</title>
</head>
<div class="container">
    <h2 class="mt-sm-3 ml-sm-3">Horgászatok kilistázása két időpont között</h2>
    <div class="card">
        <div class="card-body">
            <form:form method="post" action="${pageContext.request.contextPath}/horgaszatok/listByDate"
                       modelAttribute="datum">
            <div class="mt-sm-3">
                <div class="form-group row">
                    <form:label path="start" for="start"
                                class="col-sm-2 col-form-label">Kezdő dátum:</form:label>
                    <div class="col-sm-10">
                        <form:input path="start" type="date" name="start" class="form-control"/>
                    </div>
                </div>
            </div>
            <div class="form-group row">
                <form:label path="end" for="end"
                            class="col-sm-2 col-form-label">Záró dátum:</form:label>
                <div class="col-sm-10">
                    <form:input path="end" type="date" name="end" class="form-control"/>
                </div>
            </div>
        </div>
        <button type="submit" class="btn btn-success btn-lg btn-block font-weight-bold">Kilistáz!</button>
        <a class="btn btn-outline-success btn-lg btn-block" type="button"
           href="${pageContext.servletContext.contextPath}">Vissza</a>
        </form:form>
    </div>
</div>
<body>

</body>
</html>
