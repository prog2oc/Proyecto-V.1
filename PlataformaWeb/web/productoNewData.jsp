

<%@page import="oc.plataformaweb.objects.CategoriaObj"%>
<%@page import="java.util.Iterator"%>
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
        
    <form id="myform" name="myform" action="ProductoServlet" method="get" enctype="multipart/form-data" >   
        
    <%
        
        
            String archivourl = "D:\\Documents\\Erick\\ESEN\\Tercer Año\\Ciclo I\\Programación II\\Proyecto\\Proyecto\\Proyecto-V.1\\PlataformaWeb\\web\\img\\Productos";
            
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

             ArrayList<CategoriaObj> CArray = 
                (ArrayList<CategoriaObj>)request.getSession().getAttribute("categorias");
                Iterator<CategoriaObj> iteArray = CArray.iterator();
                
            Integer iIdEmpresa = (Integer)request.getSession().getAttribute("id");
                                  
        %>                
                    
            <<label>Nombre:</label><br>
            <input type="text" id="nombre" name="nombre" />
            <br><br>
            
            <label>Precio:</label><br>
            <input type="number" step="0.01" id="preciounidad" name="preciounidad" />
            <br><br>
            
            <label>Unidades:</label><br>
            <input type="number" id="unidades" name="unidades" />
            <br><br>
            
            <label>Categoria:</label><br>
            <select id="idcategoria" name="idcategoria" >                        
            
            <%
            if(iteArray!=null)
            {
                CategoriaObj CTemp;
                while(iteArray.hasNext())
                {
                    CTemp = iteArray.next();
            %>
                    
            <option value="<%= CTemp.getId() %>"><%= CTemp.getNombre() %></option>    
            <%
                    }
                }
            %>
            </select>
            <br><br>
            
            <input type="hidden" id="idempresa" name="idempresa" value="<%= iIdEmpresa %>" />
            <br><br>
            <input type="hidden" id="formid" name="formid" value="1" />
            <input type="submit" id="mysubmit" name="mysubmit" value="Create"/>            
        </form>
        
    </body>
</html>
