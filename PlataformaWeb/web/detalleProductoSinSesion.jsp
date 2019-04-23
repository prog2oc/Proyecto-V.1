<%-- 
    Document   : detalleProducto
    Created on : 22/04/2019, 03:31:00 AM
    Author     : erick
--%>

<%@page import="oc.plataformaweb.logic.CategoriaLogic"%>
<%@page import="oc.plataformaweb.objects.ProductoObj"%>
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
         ProductoObj CProducto = 
                (ProductoObj)request.getSession().getAttribute("producto");
        
        ArrayList<CategoriaObj> CArray = 
                (ArrayList<CategoriaObj>)request.getSession().getAttribute("categorias");
        Iterator<CategoriaObj> iteCArray = CArray.iterator();

        
    %> 
    <body>
        <div class="header">
            <h1 class="logo">e<span class="blue">S</span>e<span class="blue">V</span>olado</h1>
            <input type="checkbox" id="chk">
            <label for="chk" class="show-menu-btn">
                <i class="fas fa-ellipsis-h"></i>
            </label>

            <div class="menu">
                <a href="inicioSesion.html">Iniciar Sesión</a>
                <a href="usuarioNew.html">Registrarse</a>
                <label for="chk" class="hide-menu-btn" >
                        <i class="fas fa-times"></i>
                </label>                
            </div>

        </div>
        

        <div class="navbar">
                <a href="ProductoServlet?formid=7">Inicio</a>
                <%
                    if(iteCArray!=null)
                    {
                        CategoriaObj CTemp;
                        while(iteCArray.hasNext())
                        {
                            CTemp = iteCArray.next();
                %>                
                            <a href="ProductoServlet?formid=11&idcategoria=<%= CTemp.getId() %>" ><%= CTemp.getNombre() %></a>                                     
                <%
                        }
                    }
                %>     
        </div>
        
        <div class="detalle">
            
            <table style="text-align: center">                
                    <tr>
                    <td rowspan="5"><img src="img/Productos/<%= CProducto.getImagen() %> " width="300px" height="300px"> </td>
                    <td>Código</td>
                    <td><input type="text" name="idproducto" id="idproducto" value="<%= CProducto.getId() %>" readonly></td>
                    </tr><tr>
                    <td>Nombre</td>
                    <td><input type="text" name="nombre" id="nombre" value="<%= CProducto.getNombreProducto() %>" readonly></td>    
                    </tr><tr>
                    <td>Precio:</td>
                    <td><input type="number" name="precio" id="precio" value="<%= CProducto.getPrecioUnidad() %>" readonly></td>    
                    </tr><tr>
                    
                    <input type="hidden" id="formid" name="formid" value="" />
                    <td><a href="inicioSesion.html"><button>Iniciar Sesion</button></a></td>
                    
                    </tr>               
            </table>
        </div>                
                
    </body>
</html>
