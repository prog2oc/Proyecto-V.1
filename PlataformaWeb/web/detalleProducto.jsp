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
        <link href="Style/publicidad.css" rel="stylesheet" type="text/css"/>
        <script src="Scripts/publicidad.js" type="text/javascript"></script>
    </head>
    <%
        UsuarioObj UUsuario = (UsuarioObj)request.getSession().getAttribute("usuario");
        
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
                <a href="inicioSesion.html"><%= UUsuario.getNombre() %> <%= UUsuario.getApellido() %> </a>
                <a href="carrito.jsp">Carrito</a>
                <a href="ProductoServlet?formid=7">Cerrar Sesión</a>
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
                            <a href="ProductoServlet?formid=12&idcategoria=<%= CTemp.getId() %>" ><%= CTemp.getNombre() %></a>                                     
                <%
                        }
                    }
                %>     
        </div>
        
        <div class="detalle">
            
            <table>
                <form id="myform" name="myform" action="ProductoServlet" method="get">
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
                    <td>Cantidad:</td>
                    <td><input type="number" name="cantidad" id="cantidad"></td>    
                    </tr><tr>
                    
                    <input type="hidden" id="formid" name="formid" value="" />
                    <td><input type="submit" id="mysubmit" name="mysubmit" value="Agregar"/></td>
                    </tr>
                </form>
            </table>
        </div>                
                
    </body>
</html>
