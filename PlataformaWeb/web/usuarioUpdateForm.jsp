<%-- 
    Document   : usuarioUpdate
    Created on : Apr 16, 2019, 11:35:04 PM
    Author     : GabrielaB
--%>

<%@page import="oc.plataformaweb.objects.UsuarioObj"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Usuario</title>
    </head>
    <%
        UsuarioObj UUsuario = (UsuarioObj)request.getSession().getAttribute("usuario");
        
    %>
    <body>
        <h1>Update Usuario</h1>
        <br><br>
        <form id="myform" name="myform" action="UsuarioServlet" method="get">
            
            <label>Id:</label><br>
            <input type="number" id="nonId" name="nonId" value="<%= UUsuario.getId() %>" disabled/>
            <br><br>
            
            <label>Nombre:</label><br>
            <input type="text" id="nombre" name="nombre" value="<%= UUsuario.getNombre() %>"  />
            <br><br>
            
            <label>Apellido:</label><br>
            <input type="text" id="apellido" name="apellido" value="<%= UUsuario.getApellido() %>"  />
            <br><br>
            
            <label>Usuario:</label><br>
            <input type="text" id="usuario" name="usuario" value="<%= UUsuario.getNombreUsuario() %>"  />
            <br><br>
            
            
            <label>Género:</label><br>
            <select name="genero" value="<%= UUsuario.getGenero() %>"  >
                <option value="F">Femenino</option>
                <option value="M">Masculino</option>
                <option value="O">Otros</option>
            </select>
            <br><br>
            
            <label>Fecha de nacimiento:</label><br>
            <input type="date" id="fechanacimiento" name="fechanacimiento" value="<%= UUsuario.getFechaNacimiento() %>"  />
            <br><br>
            
            <label>Correo:</label><br>
            <input type="text" id="correo" name="correo" value="<%= UUsuario.getCorreo() %>"  />
            <br><br>
            
            <label>Contraseña:</label><br>
            <input type="text" id="contrasena" name="contrasena" value="<%= UUsuario.getContrasena() %>"   />
            <br><br>
            
             <label>Departamento:</label><br>
            <select id="departamento" name="departamento">
                <option value="<%= UUsuario.getDepartamento() %>" selected disabled hidden><%= UUsuario.getDepartamento() %></option>
                <option value="AH">Ahuachapan</option>
                <option value="CA">Cabañas</option>
                <option value="CH">Chalatenango</option>
                <option value="CU">Cuscatlán</option>
                <option value="LI">La Libertad</option>
                <option value="MO">Morazán</option>
                <option value="PA">La Paz</option>
                <option value="SA">Santa Ana</option>
                <option value="SM">San Miguel</option>
                <option value="SO">Sonsonate</option>
                <option value="SS">San Salvador</option>
                <option value="SV">San Vicente</option>
                <option value="UN">La Unión</option>
                <option value="US">Usulután</option>
            </select>
            <br><br>
             <label>Dirección:</label><br>
            <input type="text" id="direccion" name="direccion" value="<%= UUsuario.getDireccion() %>"   />
            <br><br>
            
            
            <input type="submit" id="mysubmit" name="mysubmit" value="Update"/>
            <input type="hidden" id="formid" name="formid" value="5" />
            <input type="hidden" id="id" name="id" value="<%=UUsuario.getId() %>" />
            
        </form>
    </body>
</html>
