package oc.plataformaweb.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import oc.plataformaweb.logic.CategoriaLogic;
import oc.plataformaweb.logic.ProductoLogic;
import oc.plataformaweb.objects.CategoriaObj;
import oc.plataformaweb.objects.ProductoObj;

@WebServlet(name = "ProductoServlet", urlPatterns = {"/ProductoServlet"})
public class ProductoServlet extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String strFormId = request.getParameter("formid");
            
            if(strFormId.equals("1"))
            {
                //get parameters
                String strNombreProducto = request.getParameter("nombre");
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
                int iRows = CLogic.insertProductoRows(strNombreProducto, dPrecioUnidad, iUnidades, iIdCategoria, iIdEmpresa);
                System.out.println("insert producto rows: " + iRows);
                
                //send to frontend
                request.getSession().setAttribute("rows", new Integer(iRows));
                response.sendRedirect("genericMessageProducto.jsp");
            }
            
            if(strFormId.equals("2"))
            {
                //access logic
                ProductoLogic CLogic = new ProductoLogic();
                ArrayList<ProductoObj> PArray = CLogic.getAllProductos();
                
                //send to frontend
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
                request.getSession().setAttribute("categoria", CArray);
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
                CategoriaLogic CLogic = new CategoriaLogic();
                ArrayList<CategoriaObj> CArray = CLogic.getAllCategorias();
                
                //send to frontend
                request.getSession().setAttribute("categoria", CArray);
                response.sendRedirect("NewProducto.jsp");
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
