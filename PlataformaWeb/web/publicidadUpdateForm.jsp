<%@page import="oc.plataformaweb.logic.TipoPublicidadLogic"%>
<%@page import="oc.plataformaweb.objects.TipoPublicidadObj"%>
<%@page import="oc.plataformaweb.objects.PublicidadObj"%>
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
        PublicidadObj CPublicidad = 
                (PublicidadObj)request.getSession().getAttribute("publicidad");
        
        ArrayList<TipoPublicidadObj> CArray = 
                (ArrayList<TipoPublicidadObj>)request.getSession().getAttribute("tipopublicidad");
        Iterator<TipoPublicidadObj> iteArray = CArray.iterator();
        
        TipoPublicidadLogic TPLog = new TipoPublicidadLogic();
        TipoPublicidadObj TipoPublicidad = TPLog.getTipoPublicidadById(CPublicidad.getIdTipoPublicidad());
    %>
    <body>
        <h1>Actualizar Publicidad</h1>
        <br><br>
        
        <form id="myform" name="myform" action="PublicidadServlet" method="get">  
            
            <label>Categoria:</label><br>
            <select id="tipopublicidad" name="tipopublicidad">                        
            <option value="<%= TipoPublicidad.getid() %>" selected disabled hidden><%=TipoPublicidad.getName() %></option>
            <%
            if(iteArray!=null)
            {
                TipoPublicidadObj TPTemp;
                while(iteArray.hasNext())
                {
                    TPTemp = iteArray.next();
            %>
                    
            <option value="<%= TPTemp.getid() %>"><%= TPTemp.getName() %></option>    
            <%
                    }
                }
            %>
            </select>
            <br><br>
            
            <input type="submit" id="mysubmit" name="mysubmit" value="Update"/>
            <input type="hidden" id="formid" name="formid" value="5" />
            <input type="hidden" id="id" name="id" value="<%= CPublicidad.getId() %>" />
        </form>
    </body>
</html>
