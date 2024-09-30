<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entidade.Estado"%>
<%@page import="dao.EstadoDAO"%>
<!DOCTYPE html>
<html lang="pt-BR">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Estados</title>
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
        <style>
            body {
                background-color: #f4f4f4;
            }
            .container {
                margin-top: 20px;
            }
            h1 {
                color: #2c3e50;
                text-align: center;
                margin-bottom: 20px;
            }
        </style>
    </head>
    <%@include file="menu.jsp" %>
    <body>
        <div class="container">
            <h1>Lista de Estados</h1>

            <% ArrayList<Estado> estados = new EstadoDAO().consultar(); %>

            <table class="table table-bordered table-striped">
                <thead class="thead-dark">
                    <tr>
                        <th>ID</th>
                        <th>Nome</th>
                        <th>Sigla</th>
                        <th>Região</th>
                        <th>País</th>
                        <th>Ações</th>
                    </tr>
                </thead>
                <tbody>
                    <% if (estados != null && !estados.isEmpty()) { 
                        for (Estado e : estados) { %>
                        <tr>
                            <td><%= e.getId() %></td>
                            <td><%= e.getNome() %></td>
                            <td><%= e.getSigla() %></td>
                            <td><%= e.getRegiao() %></td>
                            <td><%= e.getPaisId() %></td>
                            <td>
                                <a href="acao?a=editarEstado&id=<%= e.getId() %>" class="btn btn-warning btn-sm">Editar</a>
                                <a href="acao?a=excluirEstado&id=<%= e.getId() %>" class="btn btn-danger btn-sm" onclick="return confirm('Tem certeza que deseja excluir?')">Excluir</a>
                            </td>
                        </tr>
                    <% } } else { %>
                        <tr>
                            <td colspan="6" class="text-center">Nenhum estado encontrado</td>
                        </tr>
                    <% } %>
                </tbody>
            </table>
        </div>

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </body>
</html>
