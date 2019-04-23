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
    </head>
    <%
        ArrayList<ProductoObj> PArray = 
                (ArrayList<ProductoObj>)request.getSession().getAttribute("producto");
        Iterator<ProductoObj> itePArray = PArray.iterator();
        
        ArrayList<CategoriaObj> CArray = 
                (ArrayList<CategoriaObj>)request.getSession().getAttribute("categorias");
        Iterator<CategoriaObj> iteCArray = CArray.iterator();
        
    %> 
    <body onload="showSlides(0)">
        
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
                        
                        
                        <a href="#link1">Moda</a>
                        <a href="#link2">Muebles</a>
                        <a href="#link3">Juguetes</a>
                        <a href="#link3">Electrodomésticos</a>
                        <a href="#link3">Belleza</a>
                        <a href="#link1">Todas</a>
                        
                    </div>
                </div>
                
        </div>

                <br>
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
                        <div class="content">
                          <img src="/w3images/mountains.jpg" alt="Mountains" style="width:100%">
                          <h4>Mountains</h4>
                          <p>Lorem ipsum dolor..</p>
                        </div>
                    </div>
               
                <%
                   
                            
                        }
                    }
                %>
                
                
              <br>
              <br>
        
        <div class="navbar">
            
            <br><br><br>
            <p> Todos los derechos reservados eSeVolado©</p>
        </div>
              

  
        
    </body>

      
        
       
        
    </body>
</html>
