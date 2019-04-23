<%-- 
    Document   : productoForm
    Created on : 16/04/2019, 10:44:52 PM
    Author     : erick
--%>

<%@page import="oc.plataformaweb.objects.TipoPublicidadObj"%>
<%@page import="oc.plataformaweb.logic.TipoPublicidadLogic"%>
<%@page import="oc.plataformaweb.objects.PublicidadObj"%>
<%@page import="oc.plataformaweb.objects.EmpresaObj"%>
<%@page import="oc.plataformaweb.logic.EmpresaLogic"%>
<%@page import="java.util.Iterator"%>
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
        ArrayList<PublicidadObj> CArray = 
                (ArrayList<PublicidadObj>)request.getSession().getAttribute("publicidad");
        Iterator<PublicidadObj> iteArray = CArray.iterator();
        
    EmpresaObj CEmpresa = 
                (EmpresaObj)request.getSession().getAttribute("empresa");
        
    %>    
    <body>
        <div class="header">
            <h1 class="logo">e<span class="blue">S</span>e<span class="blue">V</span>olado</h1>
            <input type="checkbox" id="chk">
            <label for="chk" class="show-menu-btn">
                <i class="fas fa-ellipsis-h"></i>
            </label>

            <div class="menu">
                <a href="EmpresaServlet?formid=4&id=<%= CEmpresa.getId() %>"><%= CEmpresa.getNombre() %> </a>
                <a href="ProductoServlet?formid=7">Cerrar Sesión</a>
                <label for="chk" class="hide-menu-btn" >
                        <i class="fas fa-times"></i>
                </label>                
            </div>
        </div>

       
        <div class="navbar">
                 <a href="ProductoServlet?formid=16&idempresa=<%= CEmpresa.getId() %>">Productos</a>
                <a href="CategoriaServlet?formid=6">Categorias</a>
                <a href="PublicidadServlet?formid=9&idempresa=<%= CEmpresa.getId() %>">Publicidades</a>   
                <a href="TipoPublicidadServlet?formid=6">Tipo Publicidad</a>
        </div>
 
        <br>
        <a href="PublicidadServlet?formid=6&id=<%= CEmpresa.getId() %>">Nueva Publicidad</a>
        <br><br>
        <table>
        <tr>
            <th>Id</th>
            <th>Imagen</th>
            <th>Tipo Publicidad</th>
            <th>Empresa</th>
            
        </tr>
        <%
            if(iteArray!=null)
            {
                PublicidadObj CTemp;
                while(iteArray.hasNext())
                {
                    CTemp = iteArray.next();
                                       
                    TipoPublicidadLogic TPLog = new TipoPublicidadLogic();
                    TipoPublicidadObj TipoPublicidad = TPLog.getTipoPublicidadById(CTemp.getIdTipoPublicidad());
                    
                    EmpresaLogic EmpLog = new EmpresaLogic();
                    EmpresaObj Empresa = EmpLog.getEmpresaById(CTemp.getIdEmpresa());
        %>
                <tr>
                    <td><%= CTemp.getId() %></td>
                    <td><img src="img/Publicidad/<%= CTemp.getImagen() %>" width="250px" height="250px"></td>
                    <td><%= TipoPublicidad.getName() %></td>
                    <td><%= Empresa.getNombre() %></td>
                    <td>
                        <a href="PublicidadServlet?formid=4&id=<%= CTemp.getId() %>">
                            Modificar Tipo Publicidad
                        </a>
                    </td>
                    <td>
                        <a href="PublicidadServlet?formid=8&id=<%= CTemp.getId() %>">
                            Modificar Imagen
                        </a>
                    </td>
                    <td>
                        <a href="PublicidadServlet?formid=3&id=<%= CTemp.getId() %>">
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
