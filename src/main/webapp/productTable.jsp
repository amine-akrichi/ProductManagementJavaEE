<%@ page import="Model.Product" %>
<%@ page import="DAO.ProductManagment" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Model.User" %><%--
  Created by IntelliJ IDEA.
  User: Amine Akrichi
  Date: 08/05/2023
  Time: 11:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    <title>Table Produits</title>
    <link rel="stylesheet" href="style.css" />
</head>
<body>
<% User loggedUser =(User)request.getSession().getAttribute("loggedUser");%>

<nav>
    <div>
        <a href="">
        <img src="logo.png" alt="" /> <img src="logo-text.png" alt="" />
        </a>
        <%if (loggedUser.isAdmin()) { %>
        <span id="admin-span" style="font-size: 18px; color: lightgrey">| Espace Admin</span>

        <% } %>

    </div>
    <form class="d-flex mr-5" action="search.do" method="POST">
        <%if (loggedUser.isAdmin()) { %>
        <a class="btn btn-outline-light" style="margin-right: 20px" href="list.user">  Gestion des Utilisateurs</a>
        <% } %>
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
        List<Product> productList;
        List<Product> searchPL = (List<Product>) request.getAttribute("searchPL");
        System.out.println(searchPL);
        if (searchPL != null){
            productList= searchPL;
        }else {
            productList = (List<Product>) request.getAttribute("productList");
        }
    %>
    <a href="addProductForm.jsp" class="btn">Ajouter un Produit</a>
    <table class="table" style="width: 90%; text-align: center">
        <tr>
            <th>Reference</th>
            <th>Libèlle</th>
            <th>Fourniseur</th>
            <th>Prix</th>
            <th>Action</th>
        </tr>

        <% for (Product p : productList) { %>
        <tr>
            <td><%= p.getRef() %></td>
            <td><%= p.getName() %></td>
            <td><%= p.getProvider() %></td>
            <td><%= p.getPrice() %></td>
            <td>
                <a class="btn btn-success" href="modify.do?ref=<%= p.getRef()%>"
                >Modifier</a
                >
                <a class="btn btn-danger" href="delete.do?ref=<%= p.getRef()%>"
                >Supprimer</a
                >
            </td>
        </tr>
        <% } %>
    </table>
</div>
</body>
</html>
