<%-- 
    Document   : detalleEmpresa
    Created on : 22/04/2019, 07:34:07 PM
    Author     : erick
--%>

<%@page import="oc.plataformaweb.objects.EmpresaObj"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title><link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css">
        <link href="Style/menus.css" rel="stylesheet" type="text/css"/>
        <link href="Style/publicidad.css" rel="stylesheet" type="text/css"/>
        <script src="Scripts/publicidad.js" type="text/javascript"></script>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato">
        <link href="https://fonts.googleapis.com/css?family=Noto+Sans+JP|Yanone+Kaffeesatz" rel="stylesheet">
        <link href='https://fonts.googleapis.com/css?family=Amatic SC' rel='stylesheet'>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="https://fonts.googleapis.com/css?family=Permanent+Marker" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Open+Sans+Condensed:300" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Abel" rel="stylesheet">
    </head>
    
    <%
        EmpresaObj CEmpresa = 
                (EmpresaObj)request.getSession().getAttribute("empresa");
        
    %>
    
    <body>
        
        <div class="header">
            <h1 class="logo">e<span class="blue">S</span>e<span class="blue">V</span>olado</h1>
            <input type="checkbox" id="chk">
            <label for="chk" class="show-menu-btn">
                <i class="fas fa-ellipsis-h"></i>
            </label>

            <div class="menu">
                <a href="ProductoServlet?formid=7">Cerrar Sesión</a>
                <label for="chk" class="hide-menu-btn" >
                        <i class="fas fa-times"></i>
                </label>                
            </div>
        </div>

       
        <div class="navbar">
                <a href="ProductoServlet?formid=16&idempresa=<%= CEmpresa.getId() %>">Productos</a>
                <a href="CategoriaServlet?formid=2">Categorias</a>
                <a href="PublicidadServlet?formid=9&idempresa=<%= CEmpresa.getId() %>">Publicidades</a>   
                <a href="TipoPublicidadServlet?formid=2">Tipo Publicidad</a>
        </div>
    </body>
</html>
