<%-- 
    Document   : errorInicioSesion
    Created on : 21/04/2019, 04:16:58 PM
    Author     : erick
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>eSeVolado</title>
    </head>
    <body>
        <h1>¡Ups!</h1>
        <br><br>
        <h2>${error}</h2>
        <br><br>
        <a href="javascript:window.history.go(-2); ">Inicio</a>
    </body>
</html>
