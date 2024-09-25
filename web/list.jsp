<%-- 
    Document   : list
    Created on : 23 de set. de 2024, 20:48:13
    Author     : Elias Manica
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entidade.Pessoa"%>
<%@page import="dao.PessoaDAO"%>
<!DOCTYPE html>
<html lang="pt-BR">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Cadastros</title>
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
            <h1>Lista de Cadastros</h1>

            <% ArrayList<Pessoa> pessoas = new PessoaDAO().consultar(); %>

            <table class="table table-bordered table-striped">
                <thead class="thead-dark">
                    <tr>
                        <th>ID</th>
                        <th>Nome Completo</th>
                        <th>E-mail</th>
                        <th>Data de Nascimento</th>
                        <th>Ações</th>
                    </tr>
                </thead>
                <tbody>
                    <% if (pessoas != null && !pessoas.isEmpty()) { 
                        for (Pessoa p : pessoas) { %>
                        <tr>
                            <td><%= p.getId() %></td>
                            <td><%= p.getNome() %></td>
                            <td><%= p.getEmail() %></td>
                            <td><%= p.getDataNascimento() %></td>
                            <td>
                                <a href="acao?a=editarPessoa&id=<%= p.getId() %>" class="btn btn-warning btn-sm">Editar</a>
                                <a href="acao?a=excluirPessoa&id=<%= p.getId() %>" class="btn btn-danger btn-sm" onclick="return confirm('Tem certeza que deseja excluir?')">Excluir</a>
                            </td>
                        </tr>
                    <% } } else { %>
                        <tr>
                            <td colspan="5" class="text-center">Nenhum cadastro encontrado</td>
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
