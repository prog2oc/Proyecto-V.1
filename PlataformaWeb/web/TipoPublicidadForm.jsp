<%@page import="java.util.Iterator"%>
<%@page import="oc.plataformaweb.objects.TipoPublicidadObj"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tipo Publicidad Form</title>
    </head>
     <%
        ArrayList<TipoPublicidadObj> PArray = 
                (ArrayList<TipoPublicidadObj>)request.getSession().getAttribute("tipopublicidad");
        Iterator<TipoPublicidadObj> iteArray = PArray.iterator();
    %>    
    <body>
        <h1>Tipo  de Publicidad</h1>
        <br>
        <a href="TipoPublicidadNuevo.html">Nuevo tipo de publicidad</a>
        <br><br>
        <table>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Description</th>
        </tr>
        <%
            if(iteArray!=null)
            {
                TipoPublicidadObj PTemp;
                while(iteArray.hasNext())
                {
                    PTemp = iteArray.next();
        %>
        <tr>
                    <td><%= PTemp.getid()%></td>
                    <td><%= PTemp.getName() %></td>
                    <td><%= PTemp.getDescripcion()%></td>
                    <td>
                        <a href="TipoPublicidadServlet?formid=4&id=<%= PTemp.getid()%>">
                            update
                        </a>
                    </td>
                    <td>
                        <a href="TipoPublicidadServlet?formid=3&id=<%= PTemp.getid() %>">
                            delete
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
