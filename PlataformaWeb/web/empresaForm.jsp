<%@page import="java.util.Iterator"%>
<%@page import="oc.plataformaweb.objects.EmpresaObj"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" 
              content="text/html; charset=UTF-8">
        <title>Empresa</title>
        <link href="styles/tableStyles.css" rel="stylesheet" type="text/css"/>
        <script src="Scripts/additional-methods.js" type="text/javascript"></script>
        <script src="Scripts/empresaScript.js" type="text/javascript"></script>
        <script src="Scripts/jquery-3.3.1.js" type="text/javascript"></script>
        <script src="Scripts/jquery.validate.js" type="text/javascript"></script>
    </head>
    <%
        ArrayList<EmpresaObj> CArray = 
                (ArrayList<EmpresaObj>)request.getSession().getAttribute("empresa");
        Iterator<EmpresaObj> iteArray = CArray.iterator();
    %>
    <body>
        <h1>Empresa</h1>
        <br>
        <a href="empresaNew.html">Nueva Empresa</a>
        <br><br>
        <table>
        <tr>
            <th>Id</th>
            <th>Nombre</th>
            <th>Direccion</th>
            <th>Direccion</th>
            <th>Departamento</th>
            <th>Ciudad</th>
            <th>Telefono</th>
            <th>Sitio Web</th>
        </tr>
        <%
            if(iteArray!=null)
            {
                EmpresaObj ETemp;
                while(iteArray.hasNext())
                {
                    ETemp = iteArray.next();
        %>
                <tr>
                    <td><%= ETemp.getId() %></td>
                    <td><%= ETemp.getNombre() %></td>
                    <td><%= ETemp.getDireccion() %></td>
                    <td><%= ETemp.getDepartamento() %></td>
                    <td><%= ETemp.getCiudad() %></td>
                    <td><%= ETemp.getTelefono() %></td>
                    <td><%= ETemp.getSitioWeb() %></td>
                    
                    <td>
                        <a href="EmpresaServlet?formid=4&id=<%= ETemp.getId() %>">
                            update
                        </a>
                    </td>
                    <td>
                        <a href="EmpresaServlet?formid=3&id=<%= ETemp.getId() %>">
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

