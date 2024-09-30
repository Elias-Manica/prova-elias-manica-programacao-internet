<%-- 
    Document   : cadastroEstado
    Created on : 23 de set. de 2024, 20:33:15
    Author     : Elias Manica
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="entidade.Estado"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entidade.Pais"%>
<%@page import="dao.PaisDAO"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página de Cadastro de Estados</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f4f4f4;
                color: #333;
                margin: 0;
                padding: 0;
            }
            h1 {
                color: #2c3e50;
                text-align: center;
                margin-top: 20px;
            }
            .form-container {
                background-color: #fff;
                padding: 20px;
                border-radius: 8px;
                box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
                max-width: 400px;
                width: 100%;
                margin-top: 20px;
            }
            label {
                font-size: 14px;
                margin-bottom: 6px;
                display: block;
                color: #555;
            }
            input[type="text"],
            select {
                width: 100%;
                padding: 10px;
                margin-bottom: 15px;
                border: 1px solid #ccc;
                border-radius: 4px;
            }
            input[type="submit"] {
                background-color: #2c3e50;
                color: #fff;
                padding: 10px 15px;
                border: none;
                border-radius: 4px;
                cursor: pointer;
                width: 100%;
            }
            input[type="submit"]:hover {
                background-color: #34495e;
            }
            .wrapper {
                display: flex;
                flex-direction: column;
                justify-content: center;
                align-items: center;
                margin-top: 10px;
            }
        </style>
    </head>
    <%@include file="menu.jsp" %>
    <%
        Estado estado = (Estado) request.getAttribute("estado");

        if (estado == null) {
            estado = new Estado();
        }
    %>
    <%
        // Buscando a lista de países do banco de dados
        ArrayList<Pais> listaPaises = new PaisDAO().consultar();
    %>
    <body>
        <div class="wrapper">
            <h1>Cadastro de Estado</h1>
            <div class="form-container">
                <form action="acao?a=salvarEstado" method="post">
                    <label for="nome">Nome do Estado:</label>
                    <input type="text" id="nome" name="nome" required value="<%= estado.getNome() %>">

                    <label for="sigla">Sigla:</label>
                    <input type="text" id="sigla" name="sigla" required value="<%= estado.getSigla() %>">

                    <label for="regiao">Região:</label>
                    <select id="regiao" name="regiao">
                        <option value="Norte" <%= estado.getRegiao().equals("Norte") ? "selected" : "" %>>Norte</option>
                        <option value="Nordeste" <%= estado.getRegiao().equals("Nordeste") ? "selected" : "" %>>Nordeste</option>
                        <option value="Centro-Oeste" <%= estado.getRegiao().equals("Centro-Oeste") ? "selected" : "" %>>Centro-Oeste</option>
                        <option value="Sudeste" <%= estado.getRegiao().equals("Sudeste") ? "selected" : "" %>>Sudeste</option>
                        <option value="Sul" <%= estado.getRegiao().equals("Sul") ? "selected" : "" %>>Sul</option>
                    </select>

                    <label for="pais">País:</label>
                    <select id="pais" name="pais" required>
                        <% if (listaPaises != null && !listaPaises.isEmpty()) { 
                            for (Pais pais : listaPaises) { %>
                                <option value="<%= pais.getId() %>" <%= estado.getPaisId() == pais.getId() ? "selected" : "" %>>
                                    <%= pais.getNome() %>
                                </option>
                            <% } 
                        } else { %>
                            <option value="">Nenhum país disponível</option>
                        <% } %>
                    </select>
                    <input type="hidden" id="id" name="id" value="<%= estado.getId() %>" style="display: none">
                    <input type="submit" value="<%= estado.getId() == 0 ? "Cadastrar" : "Atualizar" %>">
                </form>
            </div>
        </div>
    </body>
</html>
