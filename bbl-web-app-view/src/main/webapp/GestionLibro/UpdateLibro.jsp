<%@ page import="entityData.Libro" %><%--
  Created by IntelliJ IDEA.
  User: Luis Enrique
  Date: 28/10/2021
  Time: 09:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UpdateLibro</title>
</head>
<body>
<%
    HttpSession session1 =request.getSession();
    Libro objLibro=new Libro();
    if (session1.getAttribute("objLibro")!=null){
        objLibro=(Libro) session1.getAttribute("objLibro");
        session1.removeAttribute("objLibro");
    }else{
        response.sendRedirect("ListLibros.jsp");
    }
%>
<div class="container">
    <form action="../sUpdateLibro" method="post">
        <div class="row">
            <div class="input-field">
                <label for="ID">Id Libro</label>
                <input  name="ID" type="text" value="<%=objLibro.getID()%>" hidden>
                <input id="" name="ID" type="text" value="<%=objLibro.getID()%>" id="ID" disabled>
            </div>
            <div class="input-field">
                <label for="Libro_name">Libro name</label>
                <input id="Libro_name" name="name" type="text" class="validate" value="<%=objLibro.getNombre()%>">
            </div>
            <div class="input-field">
                <label for="Libro_categoria">Libro categoria</label>
                <input id="Libro_categoria" name="categoria" type="text" class="validate" value="<%=objLibro.getCategoria()%>">
            </div>
            <div class="input-field">
                <label for="Libro_tomo">Libro tomo</label>
                <input id="Libro_tomo" name="tomo" type="text" class="validate" value="<%=objLibro.getTomo()%>">
            </div>
        </div>
        <button type="submit">Update</button>
    </form>
    <div class="card-action">
        <a href="ListLibros.jsp">Cancel</a>
    </div>
</div>

</body>
</html>
