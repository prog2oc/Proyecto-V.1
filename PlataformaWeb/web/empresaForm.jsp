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
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css">
        <link href="Style/menus.css" rel="stylesheet" type="text/css"/>
        <link href="Style/publicidad.css" rel="stylesheet" type="text/css"/>
        <script src="Scripts/publicidad.js" type="text/javascript"></script>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato">
        <link href="https://fonts.googleapis.com/css?family=Noto+Sans+JP|Yanone+Kaffeesatz" rel="stylesheet">
        <link href='https://fonts.googleapis.com/css?family=Amatic SC' rel='stylesheet'>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="https://fonts.googleapis.com/css?family=Permanent+Marker" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Open+Sans+Condensed:300" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Abel" rel="stylesheet">
    </head>
    <%
        ArrayList<EmpresaObj> CArray = 
                (ArrayList<EmpresaObj>)request.getSession().getAttribute("empresa");
        Iterator<EmpresaObj> iteArray = CArray.iterator();
    %>
    <body>
        <h1>Empresa</h1>
        <br>
        <a href="empresaNewLogo.jsp">Nueva Empresa</a>
        <br><br>
        <table>
        <tr>
            <th>Id</th>
            <th>Nombre</th>
            <th>Logo</th>
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
                    <%
                        if(ETemp.getLogo()!= ""){
                    %>
                    <td> <img src="img/Logos/<%=ETemp.getLogo()%>" width="200px" height="200px"> </td>
                    <%
                        } else {
                    %>
                    <td> No hay imagen. </td>
                    <%
                        }
                    %>
                    <td><%= ETemp.getDireccion() %></td>
                    <td><%= ETemp.getDepartamento() %></td>
                    <td><%= ETemp.getCiudad() %></td>
                    <td><%= ETemp.getTelefono() %></td>
                    <td><%= ETemp.getSitioWeb() %></td>
                    
                    <td>
                        <a href="EmpresaServlet?formid=4&id=<%= ETemp.getId() %>">
                            Cambiar Información
                        </a>
                    </td>
                     <td>
                        <a href="EmpresaServlet?formid=6&id=<%= ETemp.getId() %>">
                            Cambiar Logo
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

