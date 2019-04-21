<%@page import="oc.plataformaweb.objects.TipoPublicidadObj"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Actualizar Tipo de publicidad</title>
    </head>
     <%
        TipoPublicidadObj PTipoPublicidad = 
                (TipoPublicidadObj)request.getSession().getAttribute("tipopublicidad");
        
    %>    
    <body>
        <h1>Actualizar Tipo de publicidad</h1>
        <br><br>
        
        <form id="myform" name="myform" action="TipoPublicidadServlet" method="get">
            <label>Id:</label><br>
            <input type="number" id="nonId" name="nonId" value="<%= PTipoPublicidad.getid() %>" disabled/>
            <br><br>
            
            
            <label>Name:</label><br>
            <input type="text" id="name" name="name" value="<%= PTipoPublicidad.getName() %>" />
            <br><br>
            
            <label>Description:</label><br>
            <input type="text" id="description" name="description" value="<%= PTipoPublicidad.getDescripcion()%>" />
            <br><br>
            
            <input type="submit" id="mysubmit" name="mysubmit" value="Update"/>
            <input type="hidden" id="formid" name="formid" value="5" />
            <input type="hidden" id="id" name="id" value="<%= PTipoPublicidad.getid() %>" />
        </form>
    </body>
</html>
