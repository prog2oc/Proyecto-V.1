<%@page import="oc.plataformaweb.logic.ProductoLogic"%>
<%@page import="oc.plataformaweb.objects.ArticuloObj"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="oc.plataformaweb.objects.ProductoObj"%>
<%@page import="oc.plataformaweb.objects.UsuarioObj"%>
<%@page import="oc.plataformaweb.objects.CategoriaObj"%>
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
        
        HttpSession sesion  = request.getSession(true);
        ArrayList<ArticuloObj> AArray = sesion.getAttribute("carrito") == null ? null : (ArrayList) sesion.getAttribute("carrito");
        Iterator<ArticuloObj> iteAArray = AArray.iterator();
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
        
        <div class="carrito">
            <table>
                
                <thead>
                    <td>Item</td>
                    <td>Descripcion</td>
                    <td>Precio</td>
                    <td>Cantidad</td>
                    <td>Total</td>
                    
                </thead>
                
                <tbody>
                    
                
                <form id="myform" name="myform" action="AnadirCarrito" method="get">
                    
                
                <%
                    ProductoLogic PLog = new ProductoLogic();
                    int CuentaProducto=0;
                    
                    if(iteAArray!=null)
                    {
                        ArticuloObj ATemp;                      
                        
                        while(iteAArray.hasNext())
                        {
                            CuentaProducto++;
                            
                            ATemp = iteAArray.next();
                            ProductoObj Producto = PLog.getProductoById(ATemp.getIdProducto());
                %>     
                    <tr>
                    <td><img src="img/Productos/<%= Producto.getImagen() %> " width="100px" height="100px"> </td>

                    <td>
                        <h3><%= Producto.getNombreProducto() %></h3>
                        <h3>ID: <%= Producto.getId() %></h3>
                    <input type="hidden" name="idproducto<%=CuentaProducto%>" id="idproducto<%=CuentaProducto%>" value="<%= Producto.getId() %>" readonly>
                    </td>    

                    <td>
                        <h3>$<%= Producto.getPrecioUnidad() %>0</h3>
                    </td>    

                    <td>
                    <input type="number" name="cantidad" id="cantidad" value="<%= ATemp.getCantidad() %>">
                    </td> 
                    
                     <td>
                         <input type="hidden" name="total" id="total" value="<%= Math.round(Producto.getPrecioUnidad()* ATemp.getCantidad() *100.0 )/100.0 %>">
                         <h3>$<%= Math.round(Producto.getPrecioUnidad()* ATemp.getCantidad() *100.0 )/100.0 %>0</h3>
                    </td>
                    
                <%
                        }
                    }
                %>  
                    
                    <input type="hidden" id="id" name="id" value="<%= UUsuario.getId() %>" />
                    <input type="hidden" id="formid" name="formid" value="2" />
                    </tr>
                    <tr></tr>
                    <tr>
                    <td><input type="submit" id="mysubmit" name="mysubmit" value="Agregar"/></td>
                    </tr>   
                </form>   
                
                </tbody>
            </table>            
        </div>
                    <br><br>
        <a href="javascript:window.history.go(-2); " >Regresar a Catálogo</a>
        
    </body>
</html>
