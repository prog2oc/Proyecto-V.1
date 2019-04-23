<%-- 
    Document   : detalleProducto
    Created on : 22/04/2019, 03:31:00 AM
    Author     : erick
--%>

<%@page import="oc.plataformaweb.objects.UsuarioObj"%>
<%@page import="java.util.Iterator"%>
<%@page import="oc.plataformaweb.objects.CategoriaObj"%>
<%@page import="java.util.ArrayList"%>
<%@page import="oc.plataformaweb.objects.ProductoObj"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>eSeVolado</title>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css">
        <link href="Style/menus.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato">
        <link href="https://fonts.googleapis.com/css?family=Noto+Sans+JP|Yanone+Kaffeesatz" rel="stylesheet">
        <link href='https://fonts.googleapis.com/css?family=Amatic SC' rel='stylesheet'>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="https://fonts.googleapis.com/css?family=Permanent+Marker" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Open+Sans+Condensed:300" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Abel" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
           <link href="Style/catalogo.css" rel="stylesheet" type="text/css"/>
           <script src="Scripts/catalogo.js" type="text/javascript"></script>
    </head>
 
    <%
        UsuarioObj UUsuario = (UsuarioObj)request.getSession().getAttribute("usuario");
        
        ProductoObj CProducto = 
                (ProductoObj)request.getSession().getAttribute("producto");
        
        ArrayList<CategoriaObj> CArray = 
                (ArrayList<CategoriaObj>)request.getSession().getAttribute("categorias");
        Iterator<CategoriaObj> iteCArray = CArray.iterator();

        
    %> 
    <body onload="filterSelection('all')">
        
        <div class="header">
            <img src="img/esevolado.png" width="150" height="100"> 
            
            <div class="menu">
                <a href="inicioSesion.html"><%= UUsuario.getNombre() %> <%= UUsuario.getApellido() %> </a>
                <a href="AnadirCarrito?formid=3">Carrito</a>
                <a href="ProductoServlet?formid=7">Cerrar Sesión</a>
                              
            </div>
        </div>

       
        <div class="navbar">
                <a href="ProductoServlet?formid=8"><i class="fa fa-fw fa-home"></i>INICIO</a>
                
                <div class="subnav">
                    <a><button class="contenedorbutton">CATEGORIAS<i class="fa fa-caret-down"></i></button></a>
                    <br><br><br><br>
                    <div class="subnav-contenedor">                        
                        
                        <a href="ProductoServlet?formid=8">Moda</a>
                        <a href="ProductoServlet?formid=8">Muebles</a>
                        <a href="ProductoServlet?formid=8">Juguetes</a>
                        <a href="ProductoServlet?formid=8">Tecnología</a>
                        <a href="ProductoServlet?formid=8">Belleza</a>
                        <a href="ProductoServlet?formid=8">Todas</a>
                        
                    </div>
                </div>
                
                
        </div>
                

                <div id="#center" class="card">                                    

            
                <form id="myform" name="myform" action="AnadirCarrito" method="get">

                    <img src="img/Productos/<%= CProducto.getImagen() %> " width="100px">
                    <input type="hidden" name="idproducto" id="idproducto" value="<%= CProducto.getId() %>"></td>
                    <br>
                    <h2> <%= CProducto.getNombreProducto() %></h2>
                    <input type="hidden" name="nombre" id="nombre" value="<%= CProducto.getNombreProducto() %>">   
                    <br>
                    
                    <h2> <%= CProducto.getDescripcion() %> </h2>
                    <br>
                    <div class="detalle">
                        <h3 class="price">Precio: $<%= CProducto.getPrecioUnidad() %>0</h3>
                        <input type="hidden" name="precio" id="precio" value="<%= CProducto.getPrecioUnidad() %>">
                    <br>
                    </div>
                    <div class="detalle">
                        <h3>Cantidad:<input type="number" name="cantidad" id="cantidad" value="1"></h3>   
                        <br>
                    <div class="detalle">
                    <input type="hidden" id="id" name="id" value="<%= UUsuario.getId() %>" />
                    <input type="hidden" id="formid" name="formid" value="1" />
                    <div class="detalle">
                        <input type="submit" id="mysubmit" name="mysubmit" value="Agregar"/></input>
                    </div>
                </form>

        </div> 

                
    </body>
</html>
