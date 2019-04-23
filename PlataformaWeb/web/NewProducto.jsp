<%-- 
    Document   : NewProducto
    Created on : 16/04/2019, 11:08:27 PM
    Author     : erick
--%>

<%@page import="java.util.Iterator"%>
<%@page import="oc.plataformaweb.objects.CategoriaObj"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="Style/nuevoproducto.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
        <script src="Scripts/jquery-3.3.1.js" type="text/javascript"></script>
        <script src="Scripts/jquery.validate.js" type="text/javascript"></script>
        <script src="Scripts/additional-methods.js" type="text/javascript"></script>
        <script src="Scripts/generalScript.js" type="text/javascript"></script>
        
    </head>
    
    <%
        ArrayList<CategoriaObj> CArray = 
                (ArrayList<CategoriaObj>)request.getSession().getAttribute("categorias");
        Iterator<CategoriaObj> iteArray = CArray.iterator();
    %>    
    
    <body>
           <br>
        <form id="myform" name="myform" action="ProductoServlet" method="get">
            
            <label>Nombre:</label><br>
            <input type="text" id="nombre" name="nombre" />
            <br><br>
            </div>
            <div class="nuevoproducto">
            <label>Precio:<span class="req">*</span></label><br>
            <input type="number" step="0.01" id="preciounidad" name="preciounidad" autocomplete="off"/>
            <br><br>
            </div>
            
            <div class="nuevoproducto">
            <label>Unidades:<span class="req">*</span></label><br>
            <input type="number" id="unidades" name="unidades" autocomplete="off" class="input"/>
            <br><br>
            </div>
            
            <div class="nuevoproducto">
            <label>Categoria:<span class="req">*</span></label><br>
            <select id="idcategoria" name="idcategoria" class="input-select" >                        
            
            <%
            if(iteArray!=null)
            {
                CategoriaObj CTemp;
                while(iteArray.hasNext())
                {
                    CTemp = iteArray.next();
            %>
                    
            <option value="<%= CTemp.getId() %>"><%= CTemp.getNombre() %></option>    
            <%
                    }
                }
            %>
            </select>
            <br><br>
            
            <div class="nuevoproducto">
            <label>Empresa:</label><br>
            <input type="number" id="idempresa" name="idempresa" autocomplete="off" class="input" />
            <br><br>
            
            
            <input type="submit" id="mysubmit" name="mysubmit" value="Crear"  class="button"/>
           
            <input type="hidden" id="formid" name="formid" value="1" />
        </form>
    </div>
    </body>
</html>
