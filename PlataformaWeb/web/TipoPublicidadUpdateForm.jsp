<%@page import="oc.plataformaweb.objects.TipoPublicidadObj"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="Style/registrar.css" rel="stylesheet" type="text/css"/>
        <title>Actualizar Tipo de publicidad</title>
    </head>
     <%
        TipoPublicidadObj PTipoPublicidad = 
                (TipoPublicidadObj)request.getSession().getAttribute("tipopublicidad");
        
    %>    
    <body>
        <span class="close-btn">
        <a href="ProductoServlet?formid=7">
        <img src="https://cdn4.iconfinder.com/data/icons/miu/22/circle_close_delete_-128.png"></img>
        </a>
        </span>
        <div class="registrar">
          
                <img src="img/esevolado.png">   
                <h1>Actualizar tipo de publicidad</h1>
                <br><br>

                <form id="myform" name="myform" action="TipoPublicidadServlet" method="get">
                    
                    
                    
                    <div class="nuevomiembro">
                        <label class="label">Name:<span class="req">*</span></label><br>
                        <input type="text" id="name" name="name" placeholder="Nombre" autocomplete="off" class="input" value="<%= PTipoPublicidad.getName() %>" />
                        <br><br>
                    </div>
                        
                    <div class="nuevomiembro">
                        <label class="label">Description:<span class="req">*</span></label><br>
                        <input type="text" id="description" name="description"placeholder="Descripción" autocomplete="off" class="input" value="<%= PTipoPublicidad.getDescripcion()%>" />
                        <br><br>
                    </div>
                        
                        
                    <div class="nuevomiembro">
                    <input type="submit" id="mysubmit" name="mysubmit" value="Modificar" class="button"/>
                    </div> 
                        
                    <input type="hidden" id="formid" name="formid" value="5" />
                    <input type="hidden" id="id" name="id" value="<%= PTipoPublicidad.getid() %>" />
                </form>
        </div>    
    </body>
</html>
