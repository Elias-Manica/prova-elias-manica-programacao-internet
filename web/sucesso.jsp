<%-- 
    Document   : sucesso
    Created on : 24 de set. de 2024, 20:29:02
    Author     : Elias
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificação Realizada com Sucesso</title>
        <!-- Inclua o CSS do Bootstrap -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    </head>
    <body>
        <%@include file="menu.jsp" %>
        <div class="container mt-5">
            <div class="alert alert-success" role="alert">
                <h4 class="alert-heading">Sucesso!</h4>
                <p>Seu cadastro/atualização foi concluído com sucesso.</p>
                <hr>
                <p class="mb-0"><a href="cadastro-estados.jsp" class="btn btn-primary">Vizualizar estados cadastrados</a></p>
            </div>
        </div>
        <!-- Inclua o JavaScript do Bootstrap -->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>
