<%-- 
    Document   : cambiarLogo
    Created on : 20/04/2019, 06:33:21 PM
    Author     : erick
--%>

<%@page import="oc.plataformaweb.objects.EmpresaObj"%>
<%@page import="java.util.ArrayList"%>
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
        <link href="Style/registrar.css" rel="stylesheet" type="text/css"/>
        <link href='https://fonts.googleapis.com/css?family=Amatic SC' rel='stylesheet'>
        <title>eSeVolado</title>
    </head>
    <body>
        <%
             

               EmpresaObj CEmpresa = 
                       (EmpresaObj)request.getSession().getAttribute("empresa");
        
        %> 
        <span class="close-btn">
            <a href="ProductoServlet?formid=16&idempresa=<%= CEmpresa.getId() %>">
            <img src="https://cdn4.iconfinder.com/data/icons/miu/22/circle_close_delete_-128.png">
            </a>
        </span>
        <div class="registrar">
                <h1>Cambiar Imagen Producto</h1>

                <form id="myform" name="myform" action="ProductoServlet" method="get" enctype="multipart/form-data" >  
                <%


                    String archivourl = getServletContext().getRealPath("/") +"img\\Productos";

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
                    <input type="hidden" id="formid" name="formid" value="10" />
                    <input type="submit" id="mysubmit" name="mysubmit" value="Aceptar"/>

                </form>
        </div>            
    </body>
</html>
