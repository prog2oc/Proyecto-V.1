<%-- 
    Document   : NewProducto
    Created on : 16/04/2019, 11:08:27 PM
    Author     : erick
--%>

<%@page import="java.util.Iterator"%>
<%@page import="oc.plataformaweb.objects.CategoriaObj"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="Style/nuevoproducto.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    
    <%
        ArrayList<CategoriaObj> CArray = 
                (ArrayList<CategoriaObj>)request.getSession().getAttribute("categorias");
        Iterator<CategoriaObj> iteArray = CArray.iterator();
    %>    
    
    <body>
        <<span class="close-btn">
        <a href="index.html">
        <img src="https://cdn4.iconfinder.com/data/icons/miu/22/circle_close_delete_-128.png"></img>
        </a>
        </span>
        
    <div class="producto" >
        
        <img src="img/esevolado.png">   
        <br>
        <h1>¡Agregue el producto!</h1>
          
           
           <br>
        <form id="myform" name="myform" action="ProductoServlet" method="get">
            <div class="nuevoproducto">
            <label>Nombre:<span class="req">*</span></label><br>
            <input type="text" id="nombre" name="nombre" required autocomplete="off" class="input"/>
            <br><br>
            </div>
            <div class="nuevoproducto">
            <label>Precio:<span class="req">*</span></label><br>
            <input type="number" step="0.01" id="preciounidad" name="preciounidad" />
            <br><br>
            </div>
            
            <div class="nuevoproducto">
            <label>Unidades:<span class="req">*</span></label><br>
            <input type="number" id="unidades" name="unidades" required autocomplete="off" class="input"/>
            <br><br>
            </div>
            <div class="nuevoproducto">
            <label>Categoria:<span class="req">*</span></label><br>
            <select id="idcategoria" name="idcategoria"required autocomplete="off" class="input-select" >                        
            
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
            </div>
            <div class="nuevoproducto">
            <label>Empresa:<span class="req">*</span></label><br>
            <input type="number" id="idempresa" name="idempresa"required autocomplete="off" class="input" />
            <br><br>
            </div>
            <div class="nuevoproducto">
            <input type="submit" id="mysubmit" name="mysubmit" value="Crear"  class="button"/>
            </div>
            <input type="hidden" id="formid" name="formid" value="1" />
        </form>
    </div>
    </body>
</html>
