<%@ page import="java.util.ArrayList" %>
<%@ page import="entityData.Libro" %>


<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ListaLibrosWeb</title>
</head>
<body>
<h2>Libros</h2>
    <header>
        <h2>Lista de Libros</h2>
    </header>

    <article>
        <table>
            <tr>
                <th>IdLibro</th>
                <th>Nombre</th>
                <th>Categoria</th>
                <th>Tomo</th>
                <th>Registro</th>
                <th>Action</th>
            </tr>
                <%
                    ArrayList<Libro> lista= new ArrayList<>();
                try {

                    lista=(ArrayList<Libro>)session.getAttribute("listLibros");
                    for (Libro objLibro:lista){
                %>
            <tr>
                <td><%=objLibro.getID()%></td>
                <td><%=objLibro.getNombre()%></td>
                <td><%=objLibro.getCategoria()%></td>
                <td><%=objLibro.getTomo()%></td>
                <td><%=objLibro.getRegistro()%></td>
                <td>
                    <a href="../sUpdateLibro?idlibro=<%=objLibro.getID()%>&action=detalle">Detalle</a>

                    <a href="../sGestionarLibros?idlibro=<%=objLibro.getID()%>&action=eliminar">Eliminar</a>
                </td>
            </tr>
                <%
                        }
                    }catch (Exception e){
                        out.print(e+"  no esta entrando al gestion");

                    }
                %>
        </table>
    </article>
<div>
    <a class="btn" href="../sAddLibro">add</a>
    <a class="btn" href="Login.jsp">Log out</a>
    <br>
</div>
</body>
</html>
