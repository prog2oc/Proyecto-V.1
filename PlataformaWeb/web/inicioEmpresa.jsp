<%-- 
    Document   : inicioEmpresa
    Created on : 22/04/2019, 04:50:52 PM
    Author     : erick
--%>

<%@page import="oc.plataformaweb.objects.EmpresaObj"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css">
        <link href="Style/menus.css" rel="stylesheet" type="text/css"/>
        <link href="Style/publicidad.css" rel="stylesheet" type="text/css"/>
        <script src="Scripts/publicidad.js" type="text/javascript"></script>
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
