<%@ page import="DAO.UserManagment" %>
<%@ page import="Model.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Amine Akrichi
  Date: 18/05/2023
  Time: 09:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
  <title>Table Utilisateurs</title>
  <link rel="stylesheet" href="style.css" />
</head>
<body>
<nav>
  <div>
    <% User loggedUser =(User)request.getSession().getAttribute("loggedUser"); %>

    <a href="">
      <img src="logo.png" alt="" /> <img src="logo-text.png" alt="" />
    </a>
    <%if (loggedUser.isAdmin()) { %>
    <span id="admin-span" style="font-size: 18px; color: lightgrey">| Espace Admin</span>
    <% } %>


  </div>
  <form class="d-flex mr-5" action="search.user" method="POST">

    <a class="btn btn-outline-light" style="margin-right: 20px" href="list.do">  Gestion des Produits</a>

    <input
            class="form-control me-2"
            type="search"
            placeholder="Recherche..."
            name="search"
            id="search"
            aria-label="Recherche"
    />
    <button id="search-btn" class="btn" type="submit">Recherche</button>
    <a id="log-out-btn" href="login.html" class="btn btn-outline-danger">Logout</a>
  </form>
</nav>


<div class="table-wrapper">
  <%
    UserManagment userManagment = new UserManagment();
    List<User> searchUser =(List<User>) request.getAttribute("searchUser");
    List<User> userList = new ArrayList<>();
    if (searchUser!=null){
      userList = searchUser;
    }
    else {
      userList = (List<User>) request.getAttribute("usersList");;
    }

  %>
  <a href="addUserForm.jsp" class="btn">Ajouter un Utilisateur</a>
  <table class="table" style="width: 90%; text-align: center">
    <tr>
      <th>Username</th>
      <th>Mot de Passe</th>
      <th>Admin</th>
      <th>Action</th>
    </tr>

    <% for (User u : userList) { %>
    <tr>
      <td><%= u.getUsername() %></td>
      <td><%= u.getPassword() %></td>
      <td><%= u.isAdmin()?"Oui":"Non" %></td>
      <td>
        <a class="btn btn-success" href="modify.user?username=<%= u.getUsername()%>"
        >Modifier</a
        >
        <a class="btn btn-danger" href="delete.user?username=<%= u.getUsername()%>"
        >Supprimer</a
        >
      </td>
    </tr>
    <% } %>
  </table>
</div>
</body>
</html>
