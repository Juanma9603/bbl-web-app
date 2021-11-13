<%@ page import="entityData.Persona" %><%--
  Created by IntelliJ IDEA.
  User: Luis Enrique
  Date: 11/11/2021
  Time: 16:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    HttpSession session1=request.getSession();
    if (session1.getAttribute("objPersona")!=null){
        Persona objPersona=(Persona) session1.getAttribute("objPersona");
        if (objPersona.getiD()==0){
            response.sendRedirect("NewAccount.jsp");
        }
    }
%>
