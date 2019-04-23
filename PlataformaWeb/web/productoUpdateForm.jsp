<%@page import="oc.plataformaweb.logic.CategoriaLogic"%>
<%@page import="java.util.Iterator"%>
<%@page import="oc.plataformaweb.objects.CategoriaObj"%>
<%@page import="java.util.ArrayList"%>
<%@page import="oc.plataformaweb.objects.ProductoObj"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Producto</title>
    </head>
    <%
        ProductoObj CProducto = 
                (ProductoObj)request.getSession().getAttribute("producto");
        
        ArrayList<CategoriaObj> CArray = 
                (ArrayList<CategoriaObj>)request.getSession().getAttribute("categoria");
        Iterator<CategoriaObj> iteArray = CArray.iterator();
        
        CategoriaLogic CatLog = new CategoriaLogic();
        CategoriaObj Categoria = CatLog.getCategoriaById(CProducto.getIdCategoria());
    %>
    <body>
        <span class="close-btn">
        <a href="ProductoServlet?formid=7">
        <img src="https://cdn4.iconfinder.com/data/icons/miu/22/circle_close_delete_-128.png"></img>
        </a>
        </span>
        
     <div class="modificar" >
         
                <img src="img/esevolado.png">   
                <br>
                <h1>¡Modificar producto!</h1> 
        
        <br><br>
        <form id="myform" name="myform" action="ProductoServlet" method="get">
            <label class="label">Id:</label><br>
            <input type="number" id="nonId" name="nonId" value="<%= CProducto.getId() %>" disabled/>
            <br><br>
            <div class="modificarproducto">
            <label class="label">Nombre: <span class="req">*</span></label><br>
            <input type="text" id="nombre" name="nombre" required autocomplete="off" class="input" placeholder="Nombre" value="<%= CProducto.getNombreProducto() %>"/>
            <br><br>
            </div>
            <div class="modificarproducto">
            <label class="label">Precio:<span class="req">*</span></label><br>
            <input type="number" step="0.01" id="preciounidad" name="preciounidad"  required autocomplete="off" class="input" placeholder="Precio" value="<%= CProducto.getPrecioUnidad() %>" />
            <br><br>
            </div>
            <div class="modificarproducto">
            <label class="label">Unidades:<span class="req">*</span></label><br>
            <input type="number" id="unidades" name="unidades" required autocomplete="off" class="input" placeholder="" value="<%= CProducto.getUnidades() %>"/>
            <br><br>
            </div>
            <div class="modificarproducto">
            <label class="label">Categoria:<span class="req">*</span></label><br>
            <select id="idcategoria" name="idcategoria" class="input-select">                        
            <option value="<%= Categoria.getId() %>" selected disabled hidden><%=Categoria.getNombre() %></option>
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
            <div class="modificarproducto">
            <label class="label">Empresa:<span class="req">*</span></label><br>
            <input type="number" id="idempresa" name="idempresa" required autocomplete="off" class="input" placeholder="Empresa" value="<%= CProducto.getIdEmpresa() %>" />
            <br><br>
            </div>
            <div class="modificarproducto">
            <input type="submit" id="mysubmit" name="mysubmit" value="Update" class="button"/>
            </div>
            <input type="hidden" id="formid" name="formid" value="5" />
            <input type="hidden" id="id" name="id" value="<%= CProducto.getId() %>" />
        </form>
     </div>
    </body>
</html>
