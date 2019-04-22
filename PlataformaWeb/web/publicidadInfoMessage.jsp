<%-- 
    Document   : publicidadInfoMessage
    Created on : 21/04/2019, 06:20:11 PM
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
        <a href="PublicidadServlet?formid=2">Home</a>
    </body>
</html>
