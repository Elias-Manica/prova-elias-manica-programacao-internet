<%-- 
    Document   : menu
    Created on : 8 de set. de 2024, 20:15:35
    Author     : Elias
--%>

<%@page import="entidade.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <%
            HttpSession sessao = request.getSession();
            Usuario usuario = (Usuario) sessao.getAttribute("user");
        
            if (usuario == null) {  
                response.sendRedirect("login.jsp");
            }
        %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu Simples</title>
        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous"><!-- comment --></head>
    
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container-fluid">
                <a class="navbar-brand" href="#">Elias Manica</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <li class="nav-item">
                            <a class="nav-link" href="home.jsp">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="cadastro.jsp">Cadastro Pessoal</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="cadastro-tabela.jsp">Listar cadastros</a>
                        </li>
                    </ul>
                    <form class="d-flex" action="acao?a=logout" method="post">                       
                        <button class="btn btn-outline-success" type="submit">Sair</button>
                    </form>
                </div>
            </div>
        </nav>

    </body>
</html>

