<%--
  Created by IntelliJ IDEA.
  User: Luis Enrique
  Date: 8/11/2021
  Time: 17:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="includes/autentication.jsp"/>
<html>
<head>
    <title>Autenticacion</title>
</head>
<body>
    <header>
        <h2>Autenticacion</h2>
    </header>
<section>
    <form action="../sAutenticacion" method="post">
        <label for="user">Username: </label>
        <input name="user" id="user" type="text"/>

        <label for="password">Password</label>
        <input name="password" id="password" type="text"/>

        <button type="submit">Login</button>
    </form>
    <div id="formFooter">
        <a href="../sCreateAccount">Crear Cuenta</a>
    </div>
</section>

</body>
</html>
