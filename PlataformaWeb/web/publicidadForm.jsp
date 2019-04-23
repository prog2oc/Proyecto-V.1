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
            <th>Imagen</th>
            <th>Tipo Publicidad</th>
            <th>Empresa</th>
            
        </tr>
        </thead>
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
