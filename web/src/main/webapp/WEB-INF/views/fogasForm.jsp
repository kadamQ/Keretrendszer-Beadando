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
    <title>Új fogás</title>
</head>
<body>
    <form:form method="post" action="${pageContext.request.contextPath}/fogasok/add/${horgaszatId}" modelAttribute="fogas">
                <form:label path="hal">Hal neve:</form:label>
                <form:input path="hal"/>
                <form:label path="tomeg">Mennyiség</form:label>
                <form:input path="tomeg"/>
                <form:select path="horgaszbot">
                    <form:options items="${horgaszbot}"/>
                </form:select>
                <form:select path="csali">
                    <form:options items="${csali}"/>
                </form:select>
        <input type="submit" value="Felvitel">
    </form:form>
</html>
