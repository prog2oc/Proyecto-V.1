<%@page import="oc.plataformaweb.objects.EmpresaObj"%>
<%@page import="java.util.Iterator"%>
<%@page import="oc.plataformaweb.objects.CategoriaObj"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>eSeVolado</title>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css">
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
        <link href="Style/tablas.css" rel="stylesheet" type="text/css"/>
    </head>
    <%
        ArrayList<CategoriaObj> CArray = 
                (ArrayList<CategoriaObj>)request.getSession().getAttribute("categoria");
        Iterator<CategoriaObj> iteArray = CArray.iterator();
        
    EmpresaObj CEmpresa = 
                (EmpresaObj)request.getSession().getAttribute("empresa");
    %>    
    <body>
        <div class="header">
            <img src="img/esevolado.png" width="150" height="100" top="5" >
           
            <div class="menu">
                <a href="EmpresaServlet?formid=4&id=<%= CEmpresa.getId() %>"><%= CEmpresa.getNombre() %> </a>
                <a href="ProductoServlet?formid=7">Cerrar Sesión</a>              
            </div>
        </div>
      
        <div class="navbar">
                <a href="ProductoServlet?formid=16&idempresa=<%= CEmpresa.getId() %>">Productos</a>
                <a href="CategoriaServlet?formid=2">Categorias</a>
                <a href="PublicidadServlet?formid=9&idempresa=<%= CEmpresa.getId() %>">Publicidades</a>   
                <a href="TipoPublicidadServlet?formid=2">Tipo Publicidad</a>
        </div>

        <br><br>

        <table>
        <thead>
        <tr>
            <th>Id</th>
            <th>Nombre</th>
            <th>Descripcion</th>
        </tr>
        </thead>
        <%
            if(iteArray!=null)
            {
                CategoriaObj CTemp;
                while(iteArray.hasNext())
                {
                    CTemp = iteArray.next();
        %>
                <tr>
                    <td><%= CTemp.getId() %></td>
                    <td><%= CTemp.getNombre() %></td>
                    <td><%= CTemp.getDescripcion() %></td>
                </tr>
        <%
                }
            }
        %>
        
        </table>
    </body>
</html>
