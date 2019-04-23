<%@page import="oc.plataformaweb.objects.UsuarioObj"%>
<%@page import="oc.plataformaweb.objects.CategoriaObj"%>
<%@page import="java.util.Iterator"%>
<%@page import="oc.plataformaweb.objects.ProductoObj"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>eSeVolado</title>
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
        UsuarioObj UUsuario = (UsuarioObj)request.getSession().getAttribute("usuario");
        
        ArrayList<ProductoObj> PArray = 
                (ArrayList<ProductoObj>)request.getSession().getAttribute("producto");
        Iterator<ProductoObj> itePArray = PArray.iterator();
        
        ArrayList<CategoriaObj> CArray = 
                (ArrayList<CategoriaObj>)request.getSession().getAttribute("categorias");
        Iterator<CategoriaObj> iteCArray = CArray.iterator();
        
    %> 
    <body onload="showSlides(0)">
        <div class="header">
            <h1 class="logo">e<span class="blue">S</span>e<span class="blue">V</span>olado</h1>
            <input type="checkbox" id="chk">
            <label for="chk" class="show-menu-btn">
                <i class="fas fa-ellipsis-h"></i>
            </label>

            <div class="menu">
                <a href="UsuarioServlet?formid=8"><%= UUsuario.getNombre() %> <%= UUsuario.getApellido() %> </a>
                <a href="Carrito.jsp">Carrito</a>
                <a href="ProductoServlet?formid=7">Cerrar Sesión</a>
                <label for="chk" class="hide-menu-btn" >
                        <i class="fas fa-times"></i>
                </label>                
            </div>

        </div>
        

        <div class="navbar">
                <a href="ProductoServlet?formid=8">Inicio</a>
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
        
        
              <br><br>

        <div class="catalogo">

            <table>
                <%
                    if(itePArray!=null)
                    {
                        int SaltoLinea = 0;
                        ProductoObj CTemp;
                        while(itePArray.hasNext())
                        {
                            CTemp = itePArray.next(); 
                            SaltoLinea++;

                %>
                            <td>
                                <img src="img/Productos/<%= CTemp.getImagen() %> " width="200px" height="200px"> 
                                <h3><%= CTemp.getNombreProducto() %></h3>                 
                                <h3>$<%= CTemp.getPrecioUnidad() %>0</h3>
                                <a href="ProductoServlet?formid=15&idproducto=<%= CTemp.getId() %>&id=<%= UUsuario.getId() %>">Ver Detalle</a>
                            </td>                   
                <%
                            if(SaltoLinea==4){
                              %>
                              <tr>
                              <%
                                  SaltoLinea=0;
                            }
                        }
                    }
                %>

            </table>                          

        </div>
                
                <div  class="slideshow-container">
                <div class="mySlides fade">                  
                  <img src="img/Publicidad/officedepot1.png" style="width:100%">
                </div>
              
                <div class="mySlides fade">                  
                  <img src="img/Publicidad/officedepot2.png" style="width:100%">
                </div>
              
                <div class="mySlides fade">                  
                  <img src="img/Publicidad/siman1.jpg" style="width:100%">
                </div>
            </div>
        
    </body>
</html>
