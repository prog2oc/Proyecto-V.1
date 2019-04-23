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
        <link href="Style/registrar.css" rel="stylesheet" type="text/css"/>
        <link href='https://fonts.googleapis.com/css?family=Amatic SC' rel='stylesheet'>
        <title>eSeVolado</title>
    </head>
    <body>
        <span class="close-btn">
                <a href="ProductoServlet?formid=8">
            <img src="https://cdn4.iconfinder.com/data/icons/miu/22/circle_close_delete_-128.png">
            </a>
        </span>
        
        <div class="registrar">
          
                <img src="img/esevolado.png">   
                <br>
                <h1>Cambiar Foto Perfil</h1>

                <form id="myform" name="myform" action="UsuarioServlet" method="post" enctype="multipart/form-data" >  
                <%


                    String archivourl = getServletContext().getRealPath("/") +"img\\Usuarios";

                    DiskFileItemFactory factory = new DiskFileItemFactory();

                    factory.setSizeThreshold(1024);

                    factory.setRepository(new File(archivourl));

                    ServletFileUpload upload = new ServletFileUpload(factory); 

                    String strFoto;

                    try{

                        List<FileItem> partes = upload.parseRequest(request);

                        for(FileItem items: partes){
                            File file = new File(archivourl,items.getName());
                            items.write(file);
                            strFoto = items.getName();
                            %>
                            <input type="hidden" id="foto" name="foto" value="<%= strFoto %>" />
                            <%                   
                        }

                    }catch(Exception e){

                    }          

                    Integer iId = (Integer)request.getSession().getAttribute("id");

                %> 
                    <input type="hidden" id="id" name="id" value="<%= iId %>" />
                    
                    <div class="nuevomiembro">
                        <input type="submit" id="mysubmit" name="mysubmit" value="Aceptar" class="button"/>
                    </div>
                    
                    <input type="hidden" id="formid" name="formid" value="7" />
                </form>
        </div>
                
    </body>
</html>
