<%@page import="oc.plataformaweb.objects.EmpresaObj"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Empresa</title>
    </head>
    <%
        EmpresaObj CEmpresa = 
                (EmpresaObj)request.getSession().getAttribute("empresa");
        
    %>
    <body>
        <h1>Update Client</h1>
        <br><br>
        
        <form id="myform" name="myform" action="EmpresaServlet" method="post" enctype="multipart/form-data">
            
            <label>Id:</label><br>
            <input type="number" id="nonId" name="nonId" value="<%= CEmpresa.getId() %>" disabled/>
            <br><br>            
            
            <label>Nombre:</label><br>
            <input type="text" id="nombre" name="nombre" value="<%= CEmpresa.getNombre() %>" />
            <br><br>

            
            <label>Direccion:</label><br>
            <input type="text" id="direccion" name="direccion" value="<%= CEmpresa.getDireccion() %>" />
            <br><br>
            
            <label>Departamento:</label><br>
            <select name="departamento">
                <option value="<%= CEmpresa.getDepartamento() %>" selected hidden><%= CEmpresa.getDepartamento() %></option>
                <option value="Ahuachapan">Ahuachapan</option>
                <option value="Cabanas">Cabanas</option>
                <option value="Chalatenango">Chalatenango</option>
                <option value="Cuscatlan">Cuscatlan</option>
                <option value="La Libertad">La Libertad</option>
                <option value="Morazan">Morazan</option>
                <option value="La Paz">La Paz</option>
                <option value="Santa Ana">Santa Ana</option>
                <option value="San Miguel">San Miguel</option>
                <option value="Sonsonate">Sonsonate</option>
                <option value="San Salvador">San Salvador</option>
                <option value="San Vicente">San Vicente</option>
                <option value="La Union">La Union</option>
                <option value="Usulután">Usulután</option>
            </select>
            <br><br>
            
            <label>Ciudad:</label><br>
            <input type="text" id="ciudad" name="ciudad" value="<%= CEmpresa.getCiudad() %>" />
            <br><br>
            
            <label>Telefono:</label><br>
            <input type="text" id="telefono" name="telefono" value="<%= CEmpresa.getTelefono() %>" />
            <br><br>
            
            <label>Sitio Web:</label><br>
            <input type="text" id="sitioweb" name="sitioweb" value="<%= CEmpresa.getSitioWeb() %>" />
            <br><br>
            
            <input type="submit" id="mysubmit" name="mysubmit" value="Update"/>
            <input type="hidden" id="formid" name="formid" value="5" />
            <input type="hidden" id="id" name="id" value="<%= CEmpresa.getId() %>" />
        </form>
    </body>
</html>

