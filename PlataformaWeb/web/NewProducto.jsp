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
        <title>JSP Page</title>
    </head>
    
    <%
        ArrayList<CategoriaObj> CArray = 
                (ArrayList<CategoriaObj>)request.getSession().getAttribute("categoria");
        Iterator<CategoriaObj> iteArray = CArray.iterator();
    %>    
    
    <body>
        <h1>Nuevo Producto</h1>
        <br><br>
        
        <form id="myform" name="myform" action="ProductoServlet" method="get">
            <label>Nombre:</label><br>
            <input type="text" id="nombre" name="nombre" />
            <br><br>
            
            <label>Precio:</label><br>
            <input type="number" id="preciounidad" name="preciounidad" />
            <br><br>
            
            <label>Unidades:</label><br>
            <input type="number" id="unidades" name="unidades" />
            <br><br>
            
            <label>Categoria:</label><br>
            <select name="idcategoria" >                        
            
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
            <label>Empresa:</label><br>
            <input type="number" id="idempresa" name="idempresa" />
            <br><br>
            
            <input type="submit" id="mysubmit" name="mysubmit" value="Crear"/>
            <input type="hidden" id="formid" name="formid" value="1" />
        </form>
        
    </body>
</html>
