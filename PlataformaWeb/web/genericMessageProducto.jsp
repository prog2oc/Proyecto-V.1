<%@page import="oc.plataformaweb.objects.EmpresaObj"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="Style/GenericMessage.css" rel="stylesheet" type="text/css"/>
        <link href="https://fonts.googleapis.com/css?family=Lobster" rel="stylesheet">
        <title>Modificar producto</title>
    </head>
    <%  
        Integer iRowsObj = (Integer)request.getSession().getAttribute("rows");   
        int iRows = iRowsObj.intValue();
        
EmpresaObj CEmpresa = 
                (EmpresaObj)request.getSession().getAttribute("empresa");
    %>
    
    <body>
        <span class="close-btn">
        <a href="ProductoServlet?formid=6&idempresa=<%= CEmpresa.getId() %>">
        <img src="https://cdn4.iconfinder.com/data/icons/miu/22/circle_close_delete_-128.png"></img>
        </a>
        </span>
        
        <div class="registrar">
            
        <img src="img/esevolado.png">   
        <br>
        <br><br>
        <h1> ¡<%= iRows %> producto ha sido modificados!</h1>
        <br><br>
        
        </div>
    </body>
</html>
