<%-- 
    Document   : usuarioForm
    Created on : Apr 16, 2019, 11:41:00 PM
    Author     : GabrielaB
--%>

<%@page import="java.util.Iterator"%>
<%@page import="oc.plataformaweb.objects.UsuarioObj"%>
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
        ArrayList<UsuarioObj> UArray = 
                (ArrayList<UsuarioObj>)request.getSession().getAttribute("usuario");
        Iterator<UsuarioObj> iteArray = UArray.iterator();
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
            <th>Nombre</th>
            <th>Apellido</th>
            <th>Foto Perfil</th>
            <th>NombreUsuario</th>
            <th>Genero</th>
            <th>FechaNacimiento</th>
            <th>Correo</th>
            <th>Contrasena</th>
            <th>Departamento</th>
            <th>Direccion</th>
        </tr>
        </thead>
        <%
            if(iteArray!=null)
            {
                UsuarioObj UTemp;
                while(iteArray.hasNext())
                {
                    UTemp = iteArray.next();
        %>
                <tr>
                    <td><%= UTemp.getId() %></td>
                    <td><%= UTemp.getNombre() %></td>
                    <td><%= UTemp.getApellido() %></td>
                    <td><img src="img/Usuario/<%= UTemp.getFotoPerfil() %>" ></td>
                    <td><%= UTemp.getNombreUsuario() %></td>
                    <td><%= UTemp.getGenero() %></td>
                    <td><%= UTemp.getFechaNacimiento() %></td>
                    <td><%= UTemp.getCorreo() %></td>
                    <td><%= UTemp.getContrasena() %></td>
                    <td><%= UTemp.getDepartamento() %></td>
                    <td><%= UTemp.getDireccion() %></td>                    
                    <td>
                        <a href="UsuarioServlet?formid=3&id=<%= UTemp.getId() %>">
                            delete
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
