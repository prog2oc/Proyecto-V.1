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
        <title>Usuario</title>
    </head>
     <%
        ArrayList<UsuarioObj> UArray = 
                (ArrayList<UsuarioObj>)request.getSession().getAttribute("usuario");
        Iterator<UsuarioObj> iteArray = UArray.iterator();
    %>
    <body>
        <h1>Usuario</h1>
        <br>
        <a href="usuarioNew.html">Nuevo Usuario</a>
        <br><br>
        <table>
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
                        <a href="UsuarioServlet?formid=4&id=<%= UTemp.getId() %>">
                            update
                        </a>
                    </td>
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
