<%@page import="oc.plataformaweb.objects.CategoriaObj"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="Style/categoriaupdate.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <%
        CategoriaObj CCategoria = 
                (CategoriaObj)request.getSession().getAttribute("categoria");
        
    %>
    <body>
        <span class="close-btn">
            <a href="CategoriaServlet?formid=2">
        <img src="https://cdn4.iconfinder.com/data/icons/miu/22/circle_close_delete_-128.png"></img>
        </a>
        </span>
        <div class="modificar">
          
        <img src="img/esevolado.png">   
        <br>
        <h1>Modificar Categoria</h1>
        <br><br>
        
        <form id="myform" name="myform" action="CategoriaServlet" method="get">
            
            <label>Id:</label><br>
            <input type="number" id="nonId" name="nonId" value="<%= CCategoria.getId() %>" disabled/>
            <br><br>
            
            
            <div class="modificarcategoria">
            <label for="nombre" class="label">Nombre:<span class="req">*</span></label><br>
            <input type="text" id="nombre" name="nombre" required placeholder="Nombre" autocomplete="off" class="input"/>
            <br><br>
            </div>
            
            <div class="modificarcategoria">
            <label for="descripcion" class="label">Descripcion:<span class="req">*</span></label><br>
            <input type="text" id="descripcion" name="descripcion" required placeholder="Descripcion" autocomplete="off" class="input"/>
            <br><br>
            </div>
            
            <div class="modificarcategoria">
            <input type="submit" id="mysubmit" name="mysubmit" value="Modificar" class="button"/>
            <input type="hidden" id="formid" name="formid" value="5" />
            <input type="hidden" id="id" name="id" value="<%= CCategoria.getId() %>" />
            </div>
        </form>
        </div>
    </body>
</html>
