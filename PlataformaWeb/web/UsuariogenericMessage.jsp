<%-- 
    Document   : UsuariogenericMessage
    Created on : Apr 16, 2019, 10:04:49 PM
    Author     : GabrielaB
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="Style/GenericMessage.css" rel="stylesheet" type="text/css"/>
        <link href="https://fonts.googleapis.com/css?family=Lobster" rel="stylesheet">
        <title>eSeVolado</title>
    </head>
    <%
        Integer iRowsObj = (Integer)request.getSession().getAttribute("rows");
        int iRows = iRowsObj.intValue();
        
    %>
    <body>
        <span class="close-btn">
        <a href="UsuarioServlet?formid=2">
        <img src="https://cdn4.iconfinder.com/data/icons/miu/22/circle_close_delete_-128.png"></img>
        </a>
        </span>
        
        <div class="registrar">
            <img src="img/esevolado.png">   
            <br>
            <br><br>
            <h1>Sus datos han sido registrados</h1>
            <br><br>
            
        </div>
    </body>
</html>
