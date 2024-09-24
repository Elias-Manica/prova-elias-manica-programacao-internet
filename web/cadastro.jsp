<%-- 
    Document   : cadastro
    Created on : 23 de set. de 2024, 20:33:15
    Author     : Elias Manica
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página de Cadastro</title>
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
                margin-top: 20px; /* Espaço acima do formulário */
            }
            label {
                font-size: 14px;
                margin-bottom: 6px;
                display: block;
                color: #555;
            }
            input[type="text"],
            input[type="email"],
             input[type="password"],
            input[type="date"] {
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
    <body>
        <div class="wrapper">
            <h1>Cadastro</h1>
            <div class="form-container">
                <form action="acao?a=salvarUsuario" method="post">
                    <label for="nome">Nome Completo:</label>
                    <input type="text" id="nome" name="nome" required>

                    <label for="email">E-mail:</label>
                    <input type="email" id="email" name="email" required>
                    
                    <label for="password">Senha:</label>
                    <input type="password" id="senha" name="senha" required>

                    <label for="dataNascimento">Data de Nascimento:</label>
                    <input type="date" id="dataNascimento" name="dataNascimento" required>

                    <input type="text" id="id" name="id" readonly="" style="display: none"><br>
                    <input type="submit" value="Cadastrar">
                </form>
            </div>
        </div>
    </body>
</html>
