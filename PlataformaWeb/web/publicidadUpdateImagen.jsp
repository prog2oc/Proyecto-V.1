<%@page import="oc.plataformaweb.objects.EmpresaObj"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>eSeVolado</title>
    </head>
    <%        
        Integer iId = (Integer)request.getSession().getAttribute("id");
        request.getSession().setAttribute("id", iId);
        
    %>
    <body>
        <h1>Cambiar Imagen Publicidad</h1>
        <br><br>
        
        <form id="myform" name="myform" action="cambiarImagenPublicidad.jsp" method="post" enctype="multipart/form-data">
            
            <label>Cambiar Logo:</label><br>
            <input type="file" id="imagen" name="imagen"/>
            <br><br>          
                       
            <input type="submit" id="mysubmit" name="mysubmit" value="Actualizar"/>
        </form>
    </body>
</html>

