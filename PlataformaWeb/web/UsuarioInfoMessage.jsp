<%-- 
    Document   : UsuarioInfoMessage
    Created on : 21/04/2019, 04:55:31 PM
    Author     : erick
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>eSeVolado</title>
    </head>
    <%
        Integer iRowsObj = (Integer)request.getSession().getAttribute("rows");
        int iRows = iRowsObj.intValue();
        Integer iIdObj = (Integer)request.getSession().getAttribute("id");
        int iId = iIdObj.intValue();
        
    %>
    <body>
        <h1>Cambio de Foto de Perfil</h1>
        <br><br>
        <p><%= iRows %> foto ha sido modificada</p>
        <br><br>
        <a href="UsuarioServlet?formid=2">Home</a>
    </body>
</html>
