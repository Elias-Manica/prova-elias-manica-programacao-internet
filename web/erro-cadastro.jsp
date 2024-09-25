<%-- 
    Document   : erro-cadastro
    Created on : 24 de set. de 2024, 20:29:35
    Author     : Elias
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Erro no Cadastro</title>
        <!-- Inclua o CSS do Bootstrap -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    </head>
    <body>
        <%@include file="menu.jsp" %>
        <div class="container mt-5">
            <div class="alert alert-danger" role="alert">
                <h4 class="alert-heading">Erro!</h4>
                <p><%= request.getAttribute("erroMensagem") != null ? request.getAttribute("erroMensagem") : "Infelizmente, não foi possível concluir a operação." %></p>
                <hr>
                <p class="mb-0"><a href="cadastro.jsp" class="btn btn-primary">Voltar ao formulário de cadastro</a></p>
            </div>
        </div>
        <!-- Inclua o JavaScript do Bootstrap -->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>
