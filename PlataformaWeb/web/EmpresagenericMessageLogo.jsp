

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
        <title>JSP Page</title>
    </head>
    <body>
    <%
        
            String archivourl = "D:\\Documents\\Erick\\ESEN\\Tercer Año\\Ciclo I\\Programación II\\Proyecto\\Proyecto\\Proyecto-V.1\\PlataformaWeb\\web\\img\\Logos";
            
            DiskFileItemFactory factory = new DiskFileItemFactory();
            
            factory.setSizeThreshold(1024);
            
            factory.setRepository(new File(archivourl));
            
            ServletFileUpload upload = new ServletFileUpload(factory);
            
            
            try{
                
                List<FileItem> partes = upload.parseRequest(request);
                
                for(FileItem items: partes){
                    File file = new File(archivourl,items.getName());
                    String strlogo = items.getName();
                    items.write(file);
                }
                
                out.print("<h2>¿Confirmar datos?</h2>"+"\n\n"+"<a href='index.jsp'>Aceptar</a>");
                
            }catch(Exception e){
                out.print("Exception: "+e.getMessage()+"");
            }
            
            
        %>
        
        <form id="myform" name="myform" action="EmpresaServlet" method="post" enctype="multipart/form-data" >
            <input type="hidden" id="logo" name="logo" value="<%= strlogo %>"/>
            
            <label>Nombre:</label><br>            
            <input type="text" id="nombre" name="nombre" />
            <br><br>
            
            <label>Direccion:</label><br>
            <input type="text" id="direccion" name="direccion" />
            <br><br>
            
            <label>Departamento:</label><br>
            <select name="departamento">
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
