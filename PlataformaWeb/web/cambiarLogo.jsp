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
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Cambiar Logo</h1>
        
        <form id="myform" name="myform" action="EmpresaServlet" method="post" enctype="multipart/form-data" >  
        <%
        
        
            String archivourl = "D:\\Documents\\Erick\\ESEN\\Tercer Año\\Ciclo I\\Programación II\\Proyecto\\Proyecto\\Proyecto-V.1\\PlataformaWeb\\web\\img\\Logos";
            
            DiskFileItemFactory factory = new DiskFileItemFactory();
            
            factory.setSizeThreshold(1024);
            
            factory.setRepository(new File(archivourl));
            
            ServletFileUpload upload = new ServletFileUpload(factory); 
            
            String strLogo;
                        
            try{
                
                List<FileItem> partes = upload.parseRequest(request);
                
                for(FileItem items: partes){
                    File file = new File(archivourl,items.getName());
                    items.write(file);
                    strLogo = items.getName();
                    %>
                    <input type="hidden" id="logo" name="logo" value="<%= strLogo %>" />
                    <%                   
                }
                
            }catch(Exception e){
               
            }          

            Integer iId = (Integer)request.getSession().getAttribute("id");
                       
        %> 
            <input type="hidden" id="id" name="id" value="<%= iId %>" />
            <input type="submit" id="mysubmit" name="mysubmit" value="Update"/>
            <input type="hidden" id="formid" name="formid" value="7" />
        </form>
    </body>
</html>
