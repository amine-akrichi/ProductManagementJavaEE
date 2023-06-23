<%--
  Created by IntelliJ IDEA.
  User: Amine Akrichi
  Date: 06/04/2023
  Time: 09:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <%
        boolean message = (boolean) request.getAttribute("Message");
    %>
</head>
<body>

    ${message ?
    '<h1 class="alert alert-primary w-25 m-5" style="text-align: center">Produit ajouté</h1>'
    :
    '<h1 class="alert alert-danger w-25 m-5" style="text-align: center">Echec d ajout</h1>'
     }

</body>
</html>
