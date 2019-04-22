<%-- 
    Document   : productoForm
    Created on : 16/04/2019, 10:44:52 PM
    Author     : erick
--%>

<%@page import="oc.plataformaweb.objects.EmpresaObj"%>
<%@page import="oc.plataformaweb.logic.EmpresaLogic"%>
<%@page import="oc.plataformaweb.objects.CategoriaObj"%>
<%@page import="oc.plataformaweb.logic.CategoriaLogic"%>
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
        <a href="ProductoServlet?formid=6&id=1">Nuevo Producto</a>
        <br><br>
        <table>
        <tr>
            <th>Id</th>
            <th>Nombre</th>
            <th>Imagen Producto</th>
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
                                       
                    CategoriaLogic CatLog = new CategoriaLogic();
                    CategoriaObj Categoria = CatLog.getCategoriaById(CTemp.getIdCategoria());
                    
                    EmpresaLogic EmpLog = new EmpresaLogic();
                    EmpresaObj Empresa = EmpLog.getEmpresaById(CTemp.getIdEmpresa());
        %>
                <tr>
                    <td><%= CTemp.getId() %></td>
                    <td><%= CTemp.getNombreProducto() %></td>
                    <td><img src="img/Productos/<%= CTemp.getImagen() %> " width="200px" height="200px"> </td>
                    <td><%= CTemp.getPrecioUnidad() %></td>
                    <td><%= CTemp.getUnidades() %></td>
                    <td><%= Categoria.getNombre() %></td>
                    <td><%= Empresa.getNombre() %></td>
                    <td>
                        <a href="ProductoServlet?formid=4&id=<%= CTemp.getId() %>">
                            Modificar Información
                        </a>
                    </td>
                    <td>
                        <a href="ProductoServlet?formid=9&id=<%= CTemp.getId() %>">
                            Modificar Imagen
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
