<%@ page import="Model.User" %><%--
  Created by IntelliJ IDEA.
  User: Amine Akrichi
  Date: 29/05/2023
  Time: 10:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Modification Utilisateur</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <link rel="stylesheet" href="style.css" />
</head>
<body>
<%
    User u = (User) request.getAttribute("user");
    request.setAttribute("username",u.getUsername());
%>
<form action="modifyUser.user" method="post">
    <fieldset class="w-50 m-5 p-3" >
        <h1>Modifier un utilisateur :</h1>
        <div class="mb-3">
            <label for="username" class="form-label">Username</label>
            <input type="text" class="form-control" value="<%= u.getUsername()%>" id="username"  name="username" >
        </div>
        <div class="mb-3">
            <label for="password" class="form-label">Mot de Passe</label>
            <input type="text" class="form-control" value="<%= u.getPassword()%>" name="password" id="password">
        </div>

        <button type="submit" class="btn btn-primary">Modifier Utilisateur</button>
    </fieldset>
</form>
</body>
</html>
