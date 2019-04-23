<%@page import="oc.plataformaweb.objects.EmpresaObj"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="Style/empresaupdate.css" rel="stylesheet" type="text/css"/>
        <title>Modificar Empresa</title>
    </head>
    <%
        EmpresaObj CEmpresa = 
                (EmpresaObj)request.getSession().getAttribute("empresa");
        
    %>
    <body>
        
        <span class="close-btn">
            <a href="EmpresaServlet?formid=2">
        <img src="https://cdn4.iconfinder.com/data/icons/miu/22/circle_close_delete_-128.png"></img>
        </a>
        </span>
        <div class="modificar">
          
        <img src="img/esevolado.png">   
        <br>
        <h1>Modificar Empresa</h1>
        <br><br>
        
        <form id="myform" name="myform" action="EmpresaServlet" method="post" enctype="multipart/form-data">
            
            <label>Id:</label><br>
            <input type="number" id="nonId" name="nonId" value="<%= CEmpresa.getId() %>" disabled/>
            <br><br>            
            
            <div class="modificarempresa">
            <label for="nombre" class="label">Nombre:<span class="req">*</span></label><br>
            <input type="text" id="nombre" name="nombre" required placeholder="Nombre" autocomplete="off" class="input"/>
            <br><br>
            </div>

            <div class="modificarempresa">
            <label for="direccion" class="label">Direccion:<span class="req">*</span></label><br>
            <input type="text" id="direccion" name="direccion" required placeholder="Direccion" autocomplete="off" class="input"/>
            <br><br>
            </div>
            
            <div class="modificarempresa">
            <label>Departamento:</label><br>
            <select name="departamento" class="input-select">
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
            </div>
            
            <div class="modificarempresa">
            <label for="ciudad" class="label">Ciudad:<span class="req">*</span></label><br>
            <input type="text" id="ciudad" name="ciudad" required placeholder="Ciudad" autocomplete="off" class="input"/>
            <br><br>
            </div>
            
            <div class="modificarempresa">
            <label for="telefono" class="label">Telefono:<span class="req">*</span></label><br>
            <input type="text" id="telefono" name="telefono" required placeholder="Telefono" autocomplete="off" class="input"/>
            <br><br>
            </div>
            
            <div class="modificarempresa">
            <label for="sitioweb" class="label">Sitio Web:<span class="req">*</span></label><br>
            <input type="text" id="sitioweb" name="sitioweb" required placeholder="Sitio Web" autocomplete="off" class="input"/>
            <br><br>
            </div>
            
            <div class="modificarempresa">
            <input type="submit" id="mysubmit" name="mysubmit" value="Modificar" class="button"/>
            <input type="hidden" id="formid" name="formid" value="5" />
            <input type="hidden" id="id" name="id" value="<%= CEmpresa.getId() %>" />
            
        </form>
        </div>
    </body>
</html>

