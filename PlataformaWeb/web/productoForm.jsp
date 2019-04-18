<%-- 
    Document   : productoForm
    Created on : 16/04/2019, 10:44:52 PM
    Author     : erick
--%>

<%@page import="java.util.Iterator"%>
<%@page import="oc.plataformaweb.objects.ProductoObj"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Producto</title>
    </head>
    <%
        ArrayList<ProductoObj> CArray = 
                (ArrayList<ProductoObj>)request.getSession().getAttribute("producto");
        Iterator<ProductoObj> iteArray = CArray.iterator();
    %>    
    <body>
        <h1>Categorias</h1>
        <br>
        <a href="ProductoServlet?formid=6">Nuevo Producto</a>
        <br><br>
        <table>
        <tr>
            <th>Id</th>
            <th>Nombre</th>
            <th>Precio</th>
            <th>Unidades</th>
            <th>Categoria</th>
            <th>Empresa</th>
            
        </tr>
        <%
            if(iteArray!=null)
            {
                ProductoObj CTemp;
                while(iteArray.hasNext())
                {
                    CTemp = iteArray.next();
        %>
                <tr>
                    <td><%= CTemp.getId() %></td>
                    <td><%= CTemp.getNombreProducto() %></td>
                    <td><%= CTemp.getPrecioUnidad() %></td>
                    <td><%= CTemp.getUnidades() %></td>
                    <td><%= CTemp.getIdCategoria() %></td>
                    <td><%= CTemp.getIdEmpresa() %></td>
                    <td>
                        <a href="ProductoServlet?formid=4&id=<%= CTemp.getId() %>">
                            Update
                        </a>
                    </td>
                    <td>
                        <a href="ProductoServlet?formid=3&id=<%= CTemp.getId() %>">
                            Delete
                        </a>
                    </td>
                </tr>
        <%
                }
            }
        %>
        
        </table>
    </body>
</html>
