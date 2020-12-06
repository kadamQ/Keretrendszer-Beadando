<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title>Horgászat nyilvántartó</title>
    <h1 class="text-sm-center font-weight-bold mt-sm-3">Horgászat nyilvántartó rendszer</h1>
</head>
<body>
<div class="text-sm-center mt-sm-5">
    <div class="ml-sm-5 mr-sm-5">
        <form action="${pageContext.servletContext.contextPath}/horgaszatok">
            <button type="submit" class="btn btn-success btn-lg btn-block font-weight-bold">Korábbi Horgászatok</button>
        </form>
        <div class="mt-sm-3">
            <form action="${pageContext.servletContext.contextPath}/addHorgaszat">
                <button type="submit" class="btn btn-success btn-lg btn-block font-weight-bold">Új Horgászat Hozzáadása
                </button>
            </form>
        </div>
    </div>
    <h5 class="mt-sm-5">A türelmetlen horgász sosem fog igazán nagy halat, mert kirántja a horgot, amikor az úszó az
        első kis rángásra
        épphogy bukdácsolni kezd. Nincsenek ahhoz idegei, hogy megvárja, amíg az igazán nagy hal ráharap a horogra. A
        nagy hal azért lesz nagy, mert okosabb és óvatosabb, mint a többi, melyeket már süldőként kifogtak.</h5>
</div>
</body>
</html>
