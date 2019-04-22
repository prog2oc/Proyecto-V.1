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
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css">
        <link href="Style/menus.css" rel="stylesheet" type="text/css"/>
        <link href="Style/publicidad.css" rel="stylesheet" type="text/css"/>
        <script src="Scripts/publicidad.js" type="text/javascript"></script>
    </head>
    <%
        ArrayList<ProductoObj> PArray = 
                (ArrayList<ProductoObj>)request.getSession().getAttribute("producto");
        Iterator<ProductoObj> itePArray = PArray.iterator();
        
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
        
        <br>
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
                        <p><%= CTemp.getNombreProducto() %></p>                 
                        <p>$ <%= CTemp.getPrecioUnidad() %>0</p>
                        <a href="ProductoServlet?formid=14&idproducto=<%= CTemp.getId() %>">Ver Detalle</a>
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
        
    </body>
</html>
