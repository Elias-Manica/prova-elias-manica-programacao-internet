<%-- 
    Document   : home
    Created on : 23 de set. de 2024, 20:25:14
    Author     : Elias Manica
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f4f4f4;
                color: #333;
                margin: 0;
                padding: 0;

                height: 100vh;
            }
            h1 {
                color: #2c3e50;
            }
            p {
                font-size: 18px;
                margin-top: 10px;
            }
            .container {
                background-color: #fff;
                padding: 20px;
                border-radius: 8px;
                box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
                max-width: 600px;
                text-align: center;
            }
        </style>
    </head>
    <%@include file="menu.jsp" %>
    <body>
        <div class="container">
            <h1>Bem-vindo!</h1>
            <p>Olá, meu nome é Elias Manica e esta é a minha prova para a cadeira de Programação para Internet da Univates.</p>
            <p>Data de conclusão: 30/09/2024.</p>
        </div>
    </body>
</html>
