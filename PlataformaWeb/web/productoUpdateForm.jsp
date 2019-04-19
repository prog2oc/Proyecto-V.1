<%@page import="oc.plataformaweb.logic.CategoriaLogic"%>
<%@page import="java.util.Iterator"%>
<%@page import="oc.plataformaweb.objects.CategoriaObj"%>
<%@page import="java.util.ArrayList"%>
<%@page import="oc.plataformaweb.objects.ProductoObj"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Producto</title>
    </head>
    <%
        ProductoObj CProducto = 
                (ProductoObj)request.getSession().getAttribute("producto");
        
        ArrayList<CategoriaObj> CArray = 
                (ArrayList<CategoriaObj>)request.getSession().getAttribute("categoria");
        Iterator<CategoriaObj> iteArray = CArray.iterator();
        
        CategoriaLogic CatLog = new CategoriaLogic();
        CategoriaObj Categoria = CatLog.getCategoriaById(CProducto.getIdCategoria());
    %>
    <body>
        <h1>Actualizar Categoria</h1>
        <br><br>
        
        <form id="myform" name="myform" action="ProductoServlet" method="get">
            <label>Id:</label><br>
            <input type="number" id="nonId" name="nonId" value="<%= CProducto.getId() %>" disabled/>
            <br><br>
            
            <label>Nombre:</label><br>
            <input type="text" id="nombre" name="nombre" value="<%= CProducto.getNombreProducto() %>"/>
            <br><br>
            
            <label>Precio:</label><br>
            <input type="number" step="0.01" id="preciounidad" name="preciounidad" value="<%= CProducto.getPrecioUnidad() %>" />
            <br><br>
            
            <label>Unidades:</label><br>
            <input type="number" id="unidades" name="unidades" value="<%= CProducto.getUnidades() %>"/>
            <br><br>
            
            <label>Categoria:</label><br>
            <select id="idcategoria" name="idcategoria">                        
            <option value="<%= Categoria.getId() %>" selected disabled hidden><%=Categoria.getNombre() %></option>
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
            <input type="number" id="idempresa" name="idempresa" value="<%= CProducto.getIdEmpresa() %>" />
            <br><br>
            
            <input type="submit" id="mysubmit" name="mysubmit" value="Update"/>
            <input type="hidden" id="formid" name="formid" value="5" />
            <input type="hidden" id="id" name="id" value="<%= CProducto.getId() %>" />
        </form>
    </body>
</html>
