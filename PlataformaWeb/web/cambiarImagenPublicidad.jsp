<%-- 
    Document   : cambiarLogo
    Created on : 20/04/2019, 06:33:21 PM
    Author     : erick
--%>

<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@page import="java.io.File"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>eSeVolado</title>
    </head>
    <body>
        <h1>Cambiar Imagen Publicidad</h1>
        
        <form id="myform" name="myform" action="PublicidadServlet" method="get" enctype="multipart/form-data" >  
        <%
        
        
            String archivourl = "D:\\Documents\\Erick\\ESEN\\Tercer Año\\Ciclo I\\Programación II\\Proyecto\\Proyecto\\Proyecto-V.1\\PlataformaWeb\\web\\img\\Publicidad";
            
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

            Integer iId = (Integer)request.getSession().getAttribute("id");
                       
        %> 
            <input type="hidden" id="id" name="id" value="<%= iId %>" />
            <input type="hidden" id="formid" name="formid" value="7" />
            <input type="submit" id="mysubmit" name="mysubmit" value="Aceptar"/>
            
        </form>
    </body>
</html>
