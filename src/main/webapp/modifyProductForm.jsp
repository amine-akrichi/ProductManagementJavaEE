<%@ page import="Model.Product" %><%--
  Created by IntelliJ IDEA.
  User: Amine Akrichi
  Date: 17/05/2023
  Time: 22:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Modification Produit</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <link rel="stylesheet" href="style.css" />
</head>
<body>
<%
    Product p = (Product) request.getAttribute("product");
    request.setAttribute("ref",p.getRef());
%>
<form action="modifyPost.do" method="post">
    <fieldset class="w-50 m-5 p-3" >
        <h1>Modifier un produit :</h1>
        <div class="mb-3">
            <label for="ref" class="form-label">Reférence</label>
            <input type="hidden" name="ref" value="<%= p.getRef() %>" />
            <input type="text" class="form-control" value="<%= p.getRef()%>" id="ref" disabled>
        </div>
        <div class="mb-3">
            <label for="name" class="form-label">Libellé</label>
            <input type="text" class="form-control" value="<%= p.getName()%>" name="name" id="name">
        </div>
        <div class="mb-3">
            <label for="provider" class="form-label">Fourniseur</label>
            <input type="text" class="form-control" value="<%= p.getProvider()%>" name="provider" id="provider">
        </div>
        <div class="mb-3">
            <label for="price" class="form-label">Prix</label>
            <input type="number" class="form-control" value="<%= p.getPrice()%>" name="price" id="price">
        </div>
        <button type="submit" class="btn btn-primary">Modifier Produit</button>
    </fieldset>
</form>
</body>
</html>
