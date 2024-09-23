<%-- 
    Document   : list
    Created on : 23 de set. de 2024, 20:48:13
    Author     : Elias Manica
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                    <%-- Exemplo de dados. Você deve substituir isso pela lógica que busca os dados cadastrados. --%>
                    <tr>
                        <td>1</td>
                        <td>Elias Manica</td>
                        <td>elias@example.com</td>
                        <td>1990-01-01</td>
                        <td>
                            <a href="editCadastro.jsp?id=1" class="btn btn-warning btn-sm">Editar</a>
                            <a href="deleteCadastro.jsp?id=1" class="btn btn-danger btn-sm">Excluir</a>
                        </td>
                    </tr>
                    <tr>
                        <td>2</td>
                        <td>Maria Silva</td>
                        <td>maria@example.com</td>
                        <td>1992-02-02</td>
                        <td>
                            <a href="editCadastro.jsp?id=2" class="btn btn-warning btn-sm">Editar</a>
                            <a href="deleteCadastro.jsp?id=2" class="btn btn-danger btn-sm">Excluir</a>
                        </td>
                    </tr>
                    <%-- Adicione mais linhas conforme necessário --%>
                </tbody>
            </table>
        </div>

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </body>
</html>
