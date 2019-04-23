

<%@page import="java.util.Iterator"%>
<%@page import="oc.plataformaweb.objects.TipoPublicidadObj"%>
<%@page import="java.util.ArrayList"%>
<%@page import="javax.servlet.annotation.MultipartConfig"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="java.io.File"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>

<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" 
              content="text/html; charset=UTF-8">
        <title>eSeVolado</title>
    </head>
    <body>
        
    <h1>Añadir Información Publicidad</h1>
        
    <form id="myform" name="myform" action="PublicidadServlet" method="get" enctype="multipart/form-data" >   
        
    <%
        
        
            String archivourl = getServletContext().getRealPath("/") +"img\\Publicidad";
            
            DiskFileItemFactory factory = new DiskFileItemFactory();
            
            factory.setSizeThreshold(1024);
            
            factory.setRepository(new File(archivourl));
            
            ServletFileUpload upload = new ServletFileUpload(factory); 
            
            String strImagen;
                        
            try{
                
                List<FileItem> partes = upload.parseRequest(request);
                
                for(FileItem items: partes){
                    File file = new File(archivourl,items.getName());
                    items.write(file);
                    strImagen = items.getName();
                    %>
                    <input type="hidden" id="imagen" name="imagen" value="<%= strImagen %>" />
                    <%                   
                }
                
            }catch(Exception e){
               
            }   

            ArrayList<TipoPublicidadObj> PArray = 
                (ArrayList<TipoPublicidadObj>)request.getSession().getAttribute("tipopublicidad");
                Iterator<TipoPublicidadObj> iteArray = PArray.iterator();
                
            Integer iIdEmpresa = (Integer)request.getSession().getAttribute("id");
                                  
        %>                
                    
            <label>Tipo Publicidad: </label><br>
            <select id="tipopublicidad" name="tipopublicidad" >                        
            
            <%
            if(iteArray!=null)
            {
                TipoPublicidadObj PTemp;
                while(iteArray.hasNext())
                {
                    PTemp = iteArray.next();
            %>
                    
            <option value="<%= PTemp.getid() %>"><%= PTemp.getName() %></option>    
            <%
                    }
                }
            %>
            </select>
            
            <input type="hidden" id="empresa" name="empresa" value="<%= iIdEmpresa %>" />
            <br><br>
            <input type="hidden" id="formid" name="formid" value="1" />
            <input type="submit" id="mysubmit" name="mysubmit" value="Create"/>            
        </form>
        
    </body>
</html>
