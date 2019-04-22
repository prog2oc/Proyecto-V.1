<%-- 
    Document   : productoForm
    Created on : 16/04/2019, 10:44:52 PM
    Author     : erick
--%>

<%@page import="oc.plataformaweb.objects.TipoPublicidadObj"%>
<%@page import="oc.plataformaweb.logic.TipoPublicidadLogic"%>
<%@page import="oc.plataformaweb.objects.PublicidadObj"%>
<%@page import="oc.plataformaweb.objects.EmpresaObj"%>
<%@page import="oc.plataformaweb.logic.EmpresaLogic"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>eSeVolado</title>
    </head>
    <%
        ArrayList<PublicidadObj> CArray = 
                (ArrayList<PublicidadObj>)request.getSession().getAttribute("publicidad");
        Iterator<PublicidadObj> iteArray = CArray.iterator();
        
    %>    
    <body>
        <h1>Publicidad</h1>
        <br>
        <a href="PublicidadServlet?formid=6&id=1">Nuevo Producto</a>
        <br><br>
        <table>
        <tr>
            <th>Id</th>
            <th>Imagen</th>
            <th>Tipo Publicidad</th>
            <th>Empresa</th>
            
        </tr>
        <%
            if(iteArray!=null)
            {
                PublicidadObj CTemp;
                while(iteArray.hasNext())
                {
                    CTemp = iteArray.next();
                                       
                    TipoPublicidadLogic TPLog = new TipoPublicidadLogic();
                    TipoPublicidadObj TipoPublicidad = TPLog.getTipoPublicidadById(CTemp.getIdTipoPublicidad());
                    
                    EmpresaLogic EmpLog = new EmpresaLogic();
                    EmpresaObj Empresa = EmpLog.getEmpresaById(CTemp.getIdEmpresa());
        %>
                <tr>
                    <td><%= CTemp.getId() %></td>
                    <td><img src="img/Publicidad/<%= CTemp.getImagen() %>" width="250px" height="250px"></td>
                    <td><%= TipoPublicidad.getName() %></td>
                    <td><%= Empresa.getNombre() %></td>
                    <td>
                        <a href="PublicidadServlet?formid=4&id=<%= CTemp.getId() %>">
                            Modificar Tipo Publicidad
                        </a>
                    </td>
                    <td>
                        <a href="PublicidadServlet?formid=8&id=<%= CTemp.getId() %>">
                            Modificar Imagen
                        </a>
                    </td>
                    <td>
                        <a href="PublicidadServlet?formid=3&id=<%= CTemp.getId() %>">
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
