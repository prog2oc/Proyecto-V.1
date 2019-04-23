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
        <link href="Style/GenericMessage.css" rel="stylesheet" type="text/css"/>
         <link href="https://fonts.googleapis.com/css?family=Lobster" rel="stylesheet">>
        
        <title>eSeVolado</title>
    </head>
    <body>
         <span class="close-btn">
        <a href="javascript:window.history.go(-2);">
        <img src="https://cdn4.iconfinder.com/data/icons/miu/22/circle_close_delete_-128.png"></img>
        </a>
        </span>
        
        <div class="registrar">
            <h1>Se ha producido un error</h1>
            <br><br>
            <h1>${error}</h1>
            <br><br>
     
        
        </div>
    </body>
</html>
