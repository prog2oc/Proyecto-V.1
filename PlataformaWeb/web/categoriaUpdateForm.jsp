<%@page import="oc.plataformaweb.objects.CategoriaObj"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <%
        CategoriaObj CCategoria = 
                (CategoriaObj)request.getSession().getAttribute("categoria");
        
    %>
    <body>
        <h1>Actualizar Categoria</h1>
        <br><br>
        
        <form id="myform" name="myform" action="CategoriaServlet" method="get">
            <label>Id:</label><br>
            <input type="number" id="nonId" name="nonId" value="<%= CCategoria.getId() %>" disabled/>
            <br><br>
            
            
            <label>Nombre:</label><br>
            <input type="text" id="nombre" name="nombre" value="<%= CCategoria.getNombre() %>" />
            <br><br>
            
            <label>Descripcion:</label><br>
            <input type="text" id="descripcion" name="descripcion" value="<%= CCategoria.getDescripcion() %>" />
            <br><br>
            
            <input type="submit" id="mysubmit" name="mysubmit" value="Update"/>
            <input type="hidden" id="formid" name="formid" value="5" />
            <input type="hidden" id="id" name="id" value="<%= CCategoria.getId() %>" />
        </form>
    </body>
</html>
