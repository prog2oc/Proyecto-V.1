<%@page import="java.util.Iterator"%>
<%@page import="oc.plataformaweb.objects.CategoriaObj"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Categorias</title>
    </head>
    <%
        ArrayList<CategoriaObj> CArray = 
                (ArrayList<CategoriaObj>)request.getSession().getAttribute("categoria");
        Iterator<CategoriaObj> iteArray = CArray.iterator();
    %>    
    <body>
        <h1>Categorias</h1>
        <br>
        <a href="NewCategoria.html">Nuevo Categoria</a>
        <br><br>
        <table>
        <tr>
            <th>Id</th>
            <th>Nombre</th>
            <th>Descripcion</th>
        </tr>
        <%
            if(iteArray!=null)
            {
                CategoriaObj CTemp;
                while(iteArray.hasNext())
                {
                    CTemp = iteArray.next();
        %>
                <tr>
                    <td><%= CTemp.getId() %></td>
                    <td><%= CTemp.getNombre() %></td>
                    <td><%= CTemp.getDescripcion() %></td>
                    <td>
                        <a href="CategoriaServlet?formid=4&id=<%= CTemp.getId() %>">
                            Update
                        </a>
                    </td>
                    <td>
                        <a href="CategoriaServlet?formid=3&id=<%= CTemp.getId() %>">
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
