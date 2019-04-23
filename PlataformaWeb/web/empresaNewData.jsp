

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
        <link href="Style/registrarseempresa.css" rel="stylesheet" type="text/css"/>
        <link href='https://fonts.googleapis.com/css?family=Amatic SC' rel='stylesheet'>
            <title>Información de Empresa</title>
            <script src="Scripts/generalScript.js" type="text/javascript"></script>jquery-3.3.1.js" type="text/javascript"></script>
            <script src="Scripts/jquery.validate.js" type="text/javascript"></script>
            <script src="Scripts/additional-methods.js" type="text/javascript"></script>
            <script src="Scripts/generalScript.js" type="text/javascript"></script>
        
    </head>
    <body>
        
    <h1>Añadir Información Empresa</h1>
        
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
                       
        %>                
                    
            <label>Nombre:</label><br>            
            <input type="text" id="nombre" name="nombre" />
            <br><br>
            
            <label>Direccion:</label><br>
            <input type="text" id="direccion" name="direccion" />
            <br><br>
            
            <label>Departamento:</label><br>
            <select name="departamento">
                <option value="Ahuachapan">Ahuachapan</option>
                <option value="Cabanas">Cabanas</option>
                <option value="Chalatenango">Chalatenango</option>
                <option value="Cuscatlan">Cuscatlan</option>
                <option value="La Libertad">La Libertad</option>
                <option value="Morazan">Morazan</option>
                <option value="La Paz">La Paz</option>
                <option value="Santa Ana">Santa Ana</option>
                <option value="San Miguel">San Miguel</option>
                <option value="Sonsonate">Sonsonate</option>
                <option value="San Salvador">San Salvador</option>
                <option value="San Vicente">San Vicente</option>
                <option value="La Union">La Union</option>
                <option value="Usulután">Usulután</option>
            </select>
            <br><br>
            
            <label>Ciudad:</label><br>
            <input type="text" id="ciudad" name="ciudad" />
            <br><br>
            
            <label>Telefono:</label><br>
            <input type="text" id="telefono" name="telefono" />
            <br><br>
            
            <label>Sitio web:</label><br>
            <input type="text" id="sitioweb" name="sitioweb" />
            <br><br>
            
            <input type="submit" id="mysubmit" name="mysubmit" value="Create"/>
            <input type="hidden" id="formid" name="formid" value="1" />
        </form>
        
    </body>
</html>
