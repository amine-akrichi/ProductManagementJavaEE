<%--
  Created by IntelliJ IDEA.
  User: Med Amine Akrichi
  Date: 22/03/2023
  Time: 18:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ajout Produit</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <link rel="stylesheet" href="style.css" />
</head>
<body>
<form action="add.do" method="post">
    <fieldset class="w-50 m-5 p-3" >
        <h1>Ajouter un produit :</h1>
        <div class="mb-3">
            <label for="ref" class="form-label">Reférence</label>
            <input type="text" class="form-control" name="ref" id="ref">
        </div>
        <div class="mb-3">
            <label for="name" class="form-label">Libellé</label>
            <input type="text" class="form-control" name="name" id="name">
        </div>
        <div class="mb-3">
            <label for="provider" class="form-label">Fourniseur</label>
            <input type="text" class="form-control" name="provider" id="provider">
        </div>
        <div class="mb-3">
            <label for="price" class="form-label">Prix</label>
            <input type="number" class="form-control" name="price" id="price">
        </div>
        <button type="submit" class="btn btn-primary">Ajouter Produit</button>
    </fieldset>
</form>
</body>
</html>
