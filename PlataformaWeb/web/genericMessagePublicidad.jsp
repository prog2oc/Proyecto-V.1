<%@page import="oc.plataformaweb.objects.EmpresaObj"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="Style/GenericMessage.css" rel="stylesheet" type="text/css"/>
        <link href="https://fonts.googleapis.com/css?family=Lobster" rel="stylesheet">>
        <title>Modificar publicidad</title>
    </head>
    <%  
        Integer iRowsObj = (Integer)request.getSession().getAttribute("rows");   
        int iRows = iRowsObj.intValue();
        
        EmpresaObj CEmpresa = 
                (EmpresaObj)request.getSession().getAttribute("empresa");
    %>
    
    <body>
        <span class="close-btn">
        <a href="PublicidadServlet?formid=9&<%= CEmpresa.getId() %>">
        <img src="https://cdn4.iconfinder.com/data/icons/miu/22/circle_close_delete_-128.png">
        </a>
        </span>
        <div class="registrar">
         <br><br>
         <img src="img/esevolado.png">  
        <h1><%= iRows %> publicidad ha sido modificada</h1>
        <br><br>
        </div>
    </body>
</html>
