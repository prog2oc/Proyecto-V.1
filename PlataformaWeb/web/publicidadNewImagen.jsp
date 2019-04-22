<%-- 
    Document   : empresaNew
    Created on : 20/04/2019, 04:31:19 PM
    Author     : erick
--%>

<%@page import="oc.plataformaweb.objects.TipoPublicidadObj"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>eSeVolado</title>
    </head>
    
     <%
        ArrayList<TipoPublicidadObj> PArray = 
                (ArrayList<TipoPublicidadObj>)request.getSession().getAttribute("tipopublicidad");
        request.getSession().setAttribute("tipopublicidad", PArray);
        
        Integer iId = (Integer)request.getSession().getAttribute("id");
        request.getSession().setAttribute("idempresa", iId);
        
    %>    
    
    <body>
        <h1>Subir Imagen Publicidad</h1>
        <br><br>
        
        <form id="myform" name="myform" action="publicidadNewData.jsp" method="post" enctype="multipart/form-data" >
                       
            <label>Logo:</label><br>            
            <input type="file" id="imagen" name="imagen" />
            <br><br>
            
            <input type="submit" id="mysubmit" name="mysubmit" value="Create"/>
        </form>
    </body>
</html>
