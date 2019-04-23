
package oc.plataformaweb.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import oc.plataformaweb.logic.CategoriaLogic;
import oc.plataformaweb.logic.ProductoLogic;
import oc.plataformaweb.logic.UsuarioLogic;
import oc.plataformaweb.objects.ArticuloObj;
import oc.plataformaweb.objects.CategoriaObj;
import oc.plataformaweb.objects.ProductoObj;
import oc.plataformaweb.objects.UsuarioObj;

@WebServlet(name = "ProductoServlet", urlPatterns = {"/ProductoServlet"})
public class ProductoServlet extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            String strFormId = request.getParameter("formid");
            
            if(strFormId.equals("1"))
            {
                String strNombreProducto = request.getParameter("nombre");
                String strImagen = request.getParameter("imagen");
                String strPrecioUnidad = request.getParameter("preciounidad");
                String strUnidades = request.getParameter("unidades");
                String strIdCategoria = request.getParameter("idcategoria");
                String strIdEmpresa = request.getParameter("idempresa");
                double dPrecioUnidad = Double.parseDouble(strPrecioUnidad);
                int iUnidades = Integer.parseInt(strUnidades);
                int iIdCategoria = Integer.parseInt(strIdCategoria);
                int iIdEmpresa = Integer.parseInt(strIdEmpresa);
               
                //access logic
                ProductoLogic CLogic = new ProductoLogic();
                int iRows = CLogic.insertProductoRows(strNombreProducto, strImagen, dPrecioUnidad, iUnidades, iIdCategoria, iIdEmpresa);
                System.out.println("insert producto rows: " + iRows);
                
                //send to frontend
                request.getSession().setAttribute("rows", new Integer(iRows));
                response.sendRedirect("ProductoServlet?formid=16&idempresa="+iIdEmpresa+"");
            }
            
            if(strFormId.equals("2"))
            {
                ProductoLogic PLogic = new ProductoLogic();
                ArrayList<ProductoObj> PArray = PLogic.getAllProductos();
                                
                request.getSession().setAttribute("producto", PArray);
                response.sendRedirect("productoForm.jsp");
            }
            
            if(strFormId.equals("3"))
            {
                //get parameters
                String strId = request.getParameter("id");
                int iId = Integer.parseInt(strId);
                
                //access logic
                ProductoLogic CLogic = new ProductoLogic();
                int iRows = CLogic.deleteProductoRows(iId);
                
                //send to frontend
                request.getSession().setAttribute("rows", iRows);
                response.sendRedirect("genericMessageProducto.jsp");
            }
            
            if(strFormId.equals("4"))
            {
                //get parameters
                String strId = request.getParameter("id");
                int iId = Integer.parseInt(strId);
                
                //access logic
                ProductoLogic PLogic = new ProductoLogic();
                ProductoObj CProducto = PLogic.getProductoById(iId);
                
                CategoriaLogic CLogic = new CategoriaLogic();
                ArrayList<CategoriaObj> CArray = CLogic.getAllCategorias();
                
                //send to frontend
                request.getSession().setAttribute("categorias", CArray);
                //send to frontend
                request.getSession().setAttribute("producto", CProducto);
                response.sendRedirect("productoUpdateForm.jsp");
            }   
            
            if(strFormId.equals("5"))
            {
                //get parameters
                String strId = request.getParameter("id");
                String strNombreProducto = request.getParameter("nombre");
                String strPrecioUnidad = request.getParameter("preciounidad");
                String strUnidades = request.getParameter("unidades");
                String strIdCategoria = request.getParameter("idcategoria");
                String strIdEmpresa = request.getParameter("idempresa");
                double dPrecioUnidad = Double.parseDouble(strPrecioUnidad);
                int iUnidades = Integer.parseInt(strUnidades);
                int iIdCategoria = Integer.parseInt(strIdCategoria);
                int iIdEmpresa = Integer.parseInt(strIdEmpresa);
                int iId = Integer.parseInt(strId);
                
                //access logic
                ProductoLogic CLogic = new ProductoLogic();
                int iRows = CLogic.updateProductoRows(iId, strNombreProducto, dPrecioUnidad, iUnidades, iIdCategoria, iIdEmpresa);
                System.out.println("update client rows: " + iRows);
                
                //send to frontend
                request.getSession().setAttribute("rows", new Integer(iRows));
                response.sendRedirect("genericMessageProducto.jsp");
            }
            
            if(strFormId.equals("6"))
            {
                String strIdEmpresa = request.getParameter("id");
                int iIdEmpresa = Integer.parseInt(strIdEmpresa);
                
                CategoriaLogic CLogic = new CategoriaLogic();
                ArrayList<CategoriaObj> CArray = CLogic.getAllCategorias();
                               
                request.getSession().setAttribute("id", new Integer(iIdEmpresa));
                request.getSession().setAttribute("categorias", CArray);
                response.sendRedirect("productoNewImagen.jsp");
            }
            
            
            if(strFormId.equals("7"))
            {
                
                CategoriaLogic CLogic = new CategoriaLogic();
                ArrayList<CategoriaObj> CArray = CLogic.getAllCategorias();
                               
                                                
                ProductoLogic PLogic = new ProductoLogic();
                ArrayList<ProductoObj> PArray = PLogic.getAllProductos();
                
                HttpSession sesion  = request.getSession(true);
                ArrayList<ArticuloObj> AArray = sesion.getAttribute("carrito") == null ? new ArrayList<>() : (ArrayList) sesion.getAttribute("carrito");
                AArray.clear();
                sesion.setAttribute("carrito", AArray);
                
                                
                request.getSession().setAttribute("categorias", CArray);
                request.getSession().setAttribute("producto", PArray);
                response.sendRedirect("InicioSinSesion.jsp");
            }
            
            if(strFormId.equals("8"))
            {
                
                CategoriaLogic CLogic = new CategoriaLogic();
                ArrayList<CategoriaObj> CArray = CLogic.getAllCategorias();                                            
                
                ProductoLogic PLogic = new ProductoLogic();
                ArrayList<ProductoObj> PArray = PLogic.getAllProductos();
                                
                request.getSession().setAttribute("categorias", CArray);
                request.getSession().setAttribute("producto", PArray);
                response.sendRedirect("InicioUsuario.jsp");
            }
            
            if(strFormId.equals("9")){
                String strId = request.getParameter("id");
                int iId = Integer.parseInt(strId);
                          
                request.getSession().setAttribute("id", new Integer(iId));
                response.sendRedirect("productoUpdateImagen.jsp");
            }
            
            if(strFormId.equals("10")){
                String strId = request.getParameter("id");
                String strImagen = request.getParameter("imagen");
                int iId = Integer.parseInt(strId);
                
                int iRows;
                
                ProductoLogic PLogic = new ProductoLogic();
                
                iRows = PLogic.updateImagenProductoRows(iId, strImagen);                
                request.getSession().setAttribute("rows", new Integer(iRows) );
                response.sendRedirect("productoInfoMessage.jsp");
            }
            
            if(strFormId.equals("11"))
            {
                String strIdCategoria = request.getParameter("idcategoria");  
                int iIdCategoria = Integer.parseInt(strIdCategoria);
                
                CategoriaLogic CLogic = new CategoriaLogic();
                ArrayList<CategoriaObj> CArray = CLogic.getAllCategorias();
                               
                                                
                ProductoLogic PLogic = new ProductoLogic();
                ArrayList<ProductoObj> PArray = PLogic.getAllProductosByCategoria(iIdCategoria);
                                
                request.getSession().setAttribute("categorias", CArray);
                request.getSession().setAttribute("producto", PArray);
                response.sendRedirect("InicioSinSesion.jsp");
            }
            
            if(strFormId.equals("12"))
            {
                String strIdCategoria = request.getParameter("idcategoria");  
                int iIdCategoria = Integer.parseInt(strIdCategoria);
                
                CategoriaLogic CLogic = new CategoriaLogic();
                ArrayList<CategoriaObj> CArray = CLogic.getAllCategorias();
                               
                                                
                ProductoLogic PLogic = new ProductoLogic();
                ArrayList<ProductoObj> PArray = PLogic.getAllProductosByCategoria(iIdCategoria);
                                
                request.getSession().setAttribute("categorias", CArray);
                request.getSession().setAttribute("producto", PArray);
                response.sendRedirect("InicioUsuario.jsp");
            }  
            
            if(strFormId.equals("13"))
            {
                String strIdEmpresa = request.getParameter("idempresa");  
                int iIdEmpresa = Integer.parseInt(strIdEmpresa);
                
                CategoriaLogic CLogic = new CategoriaLogic();
                ArrayList<CategoriaObj> CArray = CLogic.getAllCategorias();
                               
                                                
                ProductoLogic PLogic = new ProductoLogic();
                ArrayList<ProductoObj> PArray = PLogic.getAllProductosByEmpresa(iIdEmpresa);
                                
                request.getSession().setAttribute("categorias", CArray);
                request.getSession().setAttribute("producto", PArray);
                response.sendRedirect("InicioSinSesion.jsp");
            }  
            if(strFormId.equals("13"))
            {
                String strIdEmpresa = request.getParameter("idempresa");  
                int iIdEmpresa = Integer.parseInt(strIdEmpresa);
                
                CategoriaLogic CLogic = new CategoriaLogic();
                ArrayList<CategoriaObj> CArray = CLogic.getAllCategorias();
                               
                                                
                ProductoLogic PLogic = new ProductoLogic();
                ArrayList<ProductoObj> PArray = PLogic.getAllProductosByEmpresa(iIdEmpresa);
                                
                request.getSession().setAttribute("categorias", CArray);
                request.getSession().setAttribute("producto", PArray);
                response.sendRedirect("InicioUsuario.jsp");
            }  
            
            if(strFormId.equals("14"))
            {
                //get parameters
                String strId = request.getParameter("idproducto");
                int iId = Integer.parseInt(strId);
                
                //access logic
                ProductoLogic PLogic = new ProductoLogic();
                ProductoObj CProducto = PLogic.getProductoById(iId);
                
                CategoriaLogic CLogic = new CategoriaLogic();
                ArrayList<CategoriaObj> CArray = CLogic.getAllCategorias();
                
                //send to frontend
                request.getSession().setAttribute("categorias", CArray);
                //send to frontend
                request.getSession().setAttribute("producto", CProducto);
                response.sendRedirect("detalleProductoSinSesion.jsp");
            }   
            
            if(strFormId.equals("15"))
            {
                String strId = request.getParameter("id");
                int iId = Integer.parseInt(strId);
                String strIdProducto = request.getParameter("idproducto");
                int iIdProducto = Integer.parseInt(strIdProducto);
                
                ProductoLogic PLogic = new ProductoLogic();
                ProductoObj CProducto = PLogic.getProductoById(iIdProducto);
                
                UsuarioLogic ULogic = new UsuarioLogic();
                UsuarioObj UUsuario = ULogic.getUsuarioById(iId);          
                                
                CategoriaLogic CLogic = new CategoriaLogic();
                ArrayList<CategoriaObj> CArray = CLogic.getAllCategorias();
                
                request.getSession().setAttribute("usuario", UUsuario);
                request.getSession().setAttribute("categorias", CArray);
                request.getSession().setAttribute("producto", CProducto);
                response.sendRedirect("detalleProducto.jsp");
            }   
            
            if(strFormId.equals("16"))
            {
                String strIdEmpresa = request.getParameter("idempresa");
                int iIdEmpresa = Integer.parseInt(strIdEmpresa);
                ProductoLogic PLogic = new ProductoLogic();
                ArrayList<ProductoObj> PArray = PLogic.getAllProductosByEmpresa(iIdEmpresa);
                                
                request.getSession().setAttribute("producto", PArray);
                response.sendRedirect("productoFormEmpresa.jsp");
            }
            
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
