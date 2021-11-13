<%@ page import="entityData.Libro" %><%--
  Created by IntelliJ IDEA.
  User: Luis Enrique
  Date: 27/10/2021
  Time: 16:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AddLibro</title>
</head>
<body>
    <%
        HttpSession session1=request.getSession();
        Libro objLibro=new Libro();
    %>
    <div class="container">
        <form action="../sAddLibro" method="post">
            <div class="row">
                <div class="input-field">
                    <input id="Libro_name" name="name" type="text" class="validate">
                    <label for="Libro_name">Libro name</label>
                </div>
                <div class="input-field">
                    <input id="Libro_categoria" name="categoria" type="text" class="validate">
                    <label for="Libro_categoria">Libro categoria</label>
                </div>
                <div class="input-field">
                    <input id="Libro_tomo" name="tomo" type="text" class="validate">
                    <label for="Libro_tomo">Libro tomo</label>
                </div>
            </div>
            <button type="submit">registrar</button>
        </form>
        <div class="card-action">
            <a href="ListLibros.jsp">Cancel</a>
        </div>
    </div>

</body>
</html>
