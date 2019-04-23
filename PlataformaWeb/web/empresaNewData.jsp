

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
            <link href="Style/registrarseempresa.css" rel="stylesheet" type="text/css"/>
            <link href='https://fonts.googleapis.com/css?family=Amatic SC' rel='stylesheet'>
            <script src="Scripts/additional-methods.js" type="text/javascript"></script>
            <script src="Scripts/jquery-3.3.1.js" type="text/javascript"></script>
            <script src="Scripts/jquery.validate.js" type="text/javascript"></script>
            <script src="Scripts/generalScript.js" type="text/javascript"></script>
        
    </head>
    <body>
        
    <h1>Añadir Información Empresa</h1>
        
    <form id="myform" name="myform" action="EmpresaServlet" method="post" enctype="multipart/form-data" >   
        
    <%
        
        
            String archivourl = getServletContext().getRealPath("/") +"img\\Logos";
            
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
                    
            <div class="empresaregistrar">
            <label class="label">Nombre:<span class="req">*</span></label><br>
            <input type="text" id="nombre" name="nombre" autocomplete="off" class="input" placeholder="Nombre"/>
            <br><br>
            </div>

            <div class="empresaregistrar">
            <label class="label">Direccion:<span class="req">*</span></label><br>
            <input type="text" id="direccion" autocomplete="off" name="direccion" class="input" placeholder="Dirección"/>
            <br><br>
            </div>
            
            <div class="empresaregistrar" style="width:300px;">
            <label class="label">Departamento:<span class="req">*</"span></label><br>
            <select id="departamento" name="departamento" class="input-select">
                <option value="AH">Ahuachapan</option>
                <option value="CA">Cabañas</option>
                <option value="CH">Chalatenango</option>
                <option value="CU">Cuscatlán</option>
                <option value="LI">La Libertad</option>
                <option value="MO">Morazán</option>
                <option value="PA">La Paz</option>
                <option value="SA">Santa Ana</option>
                <option value="SM">San Miguel</option>
                <option value="SO">Sonsonate</option>
                <option value="SS">San Salvador</option>
                <option value="SV">San Vicente</option>
                <option value="UN">La Unión</option>
                <option value="US">Usulután</option>
            </select>
            <br><br><br>
            </div>
            
            <div class="empresaregistrar">
            <label class="label">Ciudad:<span class="req">*</span></label><br>
            <input type="text" id="ciudad" name="ciudad" autocomplete="off" placeholder="Cuidad" class="input" />
            <br><br>
            </div>
            
            <div class="empresaregistrar">
            <label class="label">Contraseña:</label><br>
            <input type="text" id="contrasena" name="contrasena" placeholder="Contraseña" class="input"/>
            <br><br>
            </div>
            
            <div class="empresaregistrar">
            <label class="label"> Sitio web:<span class="req">*</span></label><br>
            <input type="text" id="sitioweb" name="sitioweb" autocomplete="off"  placeholder="Web Site" class="input"/>
            <br><br>
            </div>
            
            <div class="empresaregistrar">
            <input type="submit" id="mysubmit" name="mysubmit" value="Registrarse" class="button"/>
            </div>
            <input type="hidden" id="formid" name="formid" value="1" />
        </form>
        
    </body>
</html>
