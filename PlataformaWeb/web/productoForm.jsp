<%-- 
    Document   : productoForm
    Created on : 16/04/2019, 10:44:52 PM
    Author     : erick
--%>

<%@page import="oc.plataformaweb.objects.EmpresaObj"%>
<%@page import="oc.plataformaweb.logic.EmpresaLogic"%>
<%@page import="oc.plataformaweb.objects.CategoriaObj"%>
<%@page import="oc.plataformaweb.logic.CategoriaLogic"%>
<%@page import="java.util.Iterator"%>
<%@page import="oc.plataformaweb.objects.ProductoObj"%>
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
        ArrayList<ProductoObj> PArray = 
                (ArrayList<ProductoObj>)request.getSession().getAttribute("producto");
        Iterator<ProductoObj> iteArray = PArray.iterator();
        
    %>    
    <body>
       <div class="header">
            <img src="img/esevolado.png" width="150" height="100" top="5" >
           
            <div class="menu">
                <a href="ProductoServlet?formid=7">Cerrar Sesión</a>               
            </div>
        </div>

       
        <div class="navbar">
                <a href="UsuarioServlet?formid=2">Usuarios</a>
                <a href="ProductoServlet?formid=2">Productos</a>
                <a href="CategoriaServlet?formid=2">Categorias</a>
                <a href="PublicidadServlet?formid=2">Publicidades</a>   
                <a href="TipoPublicidadServlet?formid=2">Tipo Publicidad</a>
        </div>


        <br><br>
        <table>
            <thead>
        <tr>
            <th>Id</th>
            <th>Nombre</th>
            <th>Imagen Producto</th>
            <th>Precio</th>
            <th>Unidades</th>
            <th>Categoria</th>
            <th>Empresa</th>
            
        </tr>
        </thead>
        <%
            if(iteArray!=null)
            {
                ProductoObj CTemp;
                while(iteArray.hasNext())
                {
                    CTemp = iteArray.next();
                                       
                    CategoriaLogic CatLog = new CategoriaLogic();
                    CategoriaObj Categoria = CatLog.getCategoriaById(CTemp.getIdCategoria());
                    
                    EmpresaLogic EmpLog = new EmpresaLogic();
                    EmpresaObj Empresa = EmpLog.getEmpresaById(CTemp.getIdEmpresa());
        %>
                <tr>
                    <td><%= CTemp.getId() %></td>
                    <td><%= CTemp.getNombreProducto() %></td>
                    <td><img src="img/Productos/<%= CTemp.getImagen() %> " width="200px" height="200px"> </td>
                    <td><%= CTemp.getPrecioUnidad() %></td>
                    <td><%= CTemp.getUnidades() %></td>
                    <td><%= Categoria.getNombre() %></td>
                    <td><%= Empresa.getNombre() %></td>
                    <td>
                        <a href="ProductoServlet?formid=3&id=<%= CTemp.getId() %>">
                            Delete
                        </a>
                    </td>
                </tr>
        <%
                }
            }
        %>
        
        </table>
    </body>
</html>
