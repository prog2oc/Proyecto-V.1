<%@page import="oc.plataformaweb.logic.CategoriaLogic"%>
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
        <link href="Style/catalogo.css" rel="stylesheet" type="text/css"/>
        <script src="Scripts/catalogo.js" type="text/javascript"></script>
    </head>
    <%
        ArrayList<ProductoObj> PArray = 
                (ArrayList<ProductoObj>)request.getSession().getAttribute("producto");
        Iterator<ProductoObj> itePArray = PArray.iterator();
        
        ArrayList<CategoriaObj> CArray = 
                (ArrayList<CategoriaObj>)request.getSession().getAttribute("categorias");
        Iterator<CategoriaObj> iteCArray = CArray.iterator();
        
    %> 
    <body onload="filterSelection('all')">
        
 <div class="header">
            <img src="img/esevolado.png" width="150" height="100" top="5" > 
            
            <div class="menu">
                <a href="inicioSesion.html">Iniciar sesión</a>
                <a href="usuarioNew.html">Registrarse</a>
                <a href="empresaNew.html">Registrarse empresa</a>
                <a href="inicioSesionEmpresa.html">Inicar sesión empresa</a>
                              
            </div>
        </div>

       
        <div class="navbar">
                <a href="ProductoServlet?formid=7"><i class="fa fa-fw fa-home"></i>INICIO</a>
                
                
                <div class="subnav">
                    <a><button class="contenedorbutton">CATEGORIAS<i class="fa fa-caret-down"></i></button></a>
                    <br><br><br><br>
                        <div class="subnav-contenedor">
                        
                        <div id="myBtnContainer">
                        <a >Moda</a>
                        <a href="#link2">Muebles</a>
                        <a href="#link3">Juguetes</a>
                        <a href="#link3">Electrodomésticos</a>
                        <a class="btn" onclick="filterSelection('Herramientas')">Belleza</a>
                        <a class="btn active" onclick="filterSelection('all')">Todas</a>
                        </div>
                        
                    </div>
                </div>
                
        </div>

                <br>
                <div class="row">
                <%
                    if(itePArray!=null)
                    {
                     
                        ProductoObj PTemp;
                        while(itePArray.hasNext())
                        {
                            PTemp = itePArray.next(); 
                            CategoriaLogic CLog = new CategoriaLogic();
                            CategoriaObj Categoria = CLog.getCategoriaById(PTemp.getIdCategoria());

                %>
                
                
                    <div class="column <%= Categoria.getNombre() %>">
                        <div class="card">
                          <img src="img/Productos/<%= PTemp.getImagen() %>" style="width:100px">
                          <h2><%= PTemp.getNombreProducto() %></h2>
                          <h3 class="price">$<%= PTemp.getPrecioUnidad() %>0</h3>
                          <button onclick=" location.href='ProductoServlet?formid=14&idproducto=<%= PTemp.getId() %>' "> Ver Detalle</button>
                        </div>
                    </div>
               
                <%
                   
                            
                        }
                    }
                %>
                
              </div>  
              <br>
              <br>
        
        <div class="navbar">
            
            <br><br><br>
            <p> Todos los derechos reservados eSeVolado©</p>
        </div>
              

  
        
    </body>

      
        
       
        
    </body>
</html>
