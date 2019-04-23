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
        <link href='https://fonts.googleapis.com/css?family=Amatic SC' rel='stylesheet'>
        <link href="Style/usuarioupdate.css" rel="stylesheet" type="text/css"/>
        <title>Update Usuario</title>
    </head>
    <%
        UsuarioObj UUsuario = (UsuarioObj)request.getSession().getAttribute("usuario");
        
    %>
    <body>
        <span class="close-btn">
        <a href="ProductoServlet?formid=7">
        <img src="https://cdn4.iconfinder.com/data/icons/miu/22/circle_close_delete_-128.png"></img>
        </a>
        </span>
        
     <div class="modificar" >
         
                <img src="img/esevolado.png">   
                <br>
                <h1>¡Modificar usuario!</h1> 
        <h1>Modificar usuario</h1>
        <br><br>
        <form id="myform" name="myform" action="UsuarioServlet" method="get">
            
            <div class="modificarusuario">
            <label class="label">Id:</label><br>
            <input type="number" id="nonId" name="nonId" value="<%= UUsuario.getId() %>" disabled/>
            <br><br>
            </div>
            
            <div class="modificarusuario">
            <label class="label">Nombre:<span class="req">*</span></label><br>
            <input type="text" id="nombre" name="nombre" required autocomplete="off" class="input" placeholder="Nombre" value="<%= UUsuario.getNombre() %>"  />
            <br><br>
            </div>
            <div class="modificarusuario">
            <label class="label">Apellido:<span class="req">*</span></label><br>
            <input type="text" id="apellido" name="apellido" value="<%= UUsuario.getApellido() %>" required autocomplete="off" class="input" placeholder="Apellido" />
            <br><br>
            </div>
            <div class="modificarusuario">
            <label class="label">Usuario:<span class="req">*</span></label><br>
            <input type="text" id="usuario" name="usuario" value="<%= UUsuario.getNombreUsuario() %>" required autocomplete="off" class="input" placeholder="Usuario" />
            <br><br>
            </div>
            <div class="modificarusuario">
            <label class="label">Género:<span class="req">*</span></label><br>
            <select name="genero" value="<%= UUsuario.getGenero() %>" clase="input-select" >
                <option value="F">Femenino</option>
                <option value="M">Masculino</option>
                <option value="O">Otros</option>
            </select>
            <br><br>
            </div>
            <div class="modificarususario">
            <label class="label">Fecha de nacimiento:<span class="req">*</span></label><br>
            <input type="date" id="fechanacimiento" name="fechanacimiento" value="<%= UUsuario.getFechaNacimiento() %>" required autocomplete="off" class="input" placeholder="Fecha de Nacimiento" />
            <br><br>
            </div>
            <div class="modificarusuario">
            <label class="label">Correo:<span class="req">*</span></label><br>
            <input type="text" id="correo" name="correo" value="<%= UUsuario.getCorreo() %>" required autocomplete="off" class="input" placeholder="Correo"  />
            <br><br>
            </div>
            <div class="modificarusuario">
            <label class="label">Contraseña:<span class="req">*</span></label><br>
            <input type="text" id="contrasena" name="contrasena" value="<%= UUsuario.getContrasena() %>" required autocomplete="off" class="input" placeholder="Contraseña"  />
            <br><br>
            </div>
            <div class="modificarusuario">
             <label class="label">Departamento:<span class="req">*</span></label><br>
            <select id="departamento" name="departamento" class="input-select">
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
            </div>
            <div class="modificarrusuario">
             <label class="label">Dirección:<span class="req">*</span></label><br>
            <input type="text" id="direccion" name="direccion" value="<%= UUsuario.getDireccion() %>"  required autocomplete="off" class="input" placeholder="Dirección" />
            <br><br>
            </div>
            <div class="modificarusuario">
            <input type="submit" id="mysubmit" name="mysubmit" value="Update" class="button"/>
            </div>
            <input type="hidden" id="formid" name="formid" value="5" />
            <input type="hidden" id="id" name="id" value="<%=UUsuario.getId() %>" />
            
        </form>
     </div>
    </body>
</html>
