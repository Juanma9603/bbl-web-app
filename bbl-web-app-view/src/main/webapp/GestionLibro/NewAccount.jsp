<%@ page import="entityData.Libro" %>
<%@ page import="entityData.Login" %><%--
  Created by IntelliJ IDEA.
  User: Luis Enrique
  Date: 13/10/2021
  Time: 15:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="includes/newAccount.jsp"/>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Nuevo Usuario</title>
</head>
<body>


<h2>Create Account</h2>
<article>

    <div class="wrapper fadeInDown">
        <div id="formContent">
            <!-- Tabs Titles -->

            <!-- Icon -->
            <div class="fadeIn first">
                <img src="http://danielzawadzki.com/codepen/01/icon.svg" id="icon" alt="User Icon" />
            </div>

            <!-- Login Form -->

            <form action="../sCreateAccount" method="post">
                <input type="text" id="login" class="fadeIn second" name="user" placeholder="login" >
                <br>
                <input type="text" id="password" class="fadeIn third" name="password" placeholder="password" >
                <br>
                <input type="text" id="firstname" class="fadeIn third" name="firstname" placeholder="firstname" >
                <br>
                <input type="text" id="lastname" class="fadeIn third" name="lastname" placeholder="lastname" >
                <br>
                <input type="text" id="birthday" class="fadeIn third" name="birthday" placeholder="birthday" >
                <br>
                <input type="text" id="email" class="fadeIn third" name="email" placeholder="email" >

                <button type="submit">Create</button>
            </form>

        </div>
    </div>

</article>

</body>
</html>
