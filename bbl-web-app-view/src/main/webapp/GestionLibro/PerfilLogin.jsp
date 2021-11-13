<%@ page import="entityData.Login" %>
<%@ page import="entityData.Persona" %>
<%@ page import="org.apache.log4j.Logger" %><%--
  Created by IntelliJ IDEA.
  User: Luis Enrique
  Date: 5/11/2021
  Time: 18:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Perfil</title>
</head>
<body>
<%

   HttpSession session1=request.getSession();
   Persona objPersona=new Persona();
    if (session1.getAttribute("objPersona")!=null) {
        objPersona = (Persona) session1.getAttribute("objPersona");
        session1.removeAttribute("objPersona");
    }else{
            response.sendRedirect("Login.jsp");

    }

/*
    HttpSession session1 =request.getSession();
    Login objLogin=new Login();
    if (session1.getAttribute("objLogin")!=null){
        objLogin=(Login) session1.getAttribute("objLogin");
        session1.removeAttribute("objLogin");

    }else{
        response.sendRedirect("index.jsp");
    }*/
%>

    <div class="container mt-4 mb-4 p-3 d-flex justify-content-center">
        <div class="card p-4">
            <div class=" image d-flex flex-column justify-content-center align-items-center"> <button class="btn btn-secondary"> <img src="https://i.imgur.com/wvxPV9S.png" height="100" width="100" /></button> <span class="name mt-3" ></span></span>
                <div class="d-flex flex-row justify-content-center align-items-center gap-2"> <span class="idd1">Oxc4c16a645_b21a</span> <span><i class="fa fa-copy"></i></span> </div>
                <div class="d-flex flex-row justify-content-center align-items-center mt-3"> <span class="number">1069 <span class="follow">Followers</span></span> </div>
                <div class=" d-flex mt-2"> <button class="btn1 btn-dark">Edit Profile</button> </div>
                <div class="text mt-3"> <span><%=objPersona.getFirstname()%><br><br> Artist/ Creative Director by Day #NFT minting@ with FND night. </span> </div>
                <div class="gap-3 mt-3 icons d-flex flex-row justify-content-center align-items-center"> <span><i class="fa fa-twitter"></i></span> <span><i class="fa fa-facebook-f"></i></span> <span><i class="fa fa-instagram"></i></span> <span><i class="fa fa-linkedin"></i></span> </div>
                <div class=" px-2 rounded mt-4 date "> <span class="join">Joined May,2021</span> </div>
                <a href="../sGestionarLibros?action=listar">Listar</a>
                <a href="Login.jsp">Log out</a>
            </div>
        </div>
    </div>

</body>
</html>
