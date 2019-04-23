/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import oc.plataformaweb.logic.DetalleOrdenLogic;
import oc.plataformaweb.logic.ProductoLogic;
import oc.plataformaweb.logic.UsuarioLogic;
import oc.plataformaweb.objects.ArticuloObj;
import oc.plataformaweb.objects.CategoriaObj;
import oc.plataformaweb.objects.ProductoObj;
import oc.plataformaweb.objects.UsuarioObj;

/**
 *
 * @author erick
 */
@WebServlet(name = "AnadirCarrito", urlPatterns = {"/AnadirCarrito"})
public class AnadirCarrito extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            String strFormId = request.getParameter("formid");
            
            if(strFormId.equals("1"))
            {
                String strId = request.getParameter("id");
                int iId = Integer.parseInt(strId);
                String strIdProducto = request.getParameter("idproducto");
                int iIdProducto = Integer.parseInt(strIdProducto);
                String strCantidad = request.getParameter("cantidad");
                int iCantidad = Integer.parseInt(strCantidad);
                
                UsuarioLogic ULogic = new UsuarioLogic();
                UsuarioObj UUsuario = ULogic.getUsuarioById(iId);
                
                ProductoLogic PLogic = new ProductoLogic();
                ArrayList<ProductoObj> PArray = PLogic.getAllProductos();
                                
                CategoriaLogic CLogic = new CategoriaLogic();
                ArrayList<CategoriaObj> CArray = CLogic.getAllCategorias();
                
                HttpSession sesion  = request.getSession(true);
                ArrayList<ArticuloObj> AArray = sesion.getAttribute("carrito") == null ? new ArrayList<>() : (ArrayList) sesion.getAttribute("carrito");
                
                boolean chequeo = false;
                
                if(AArray.size() > 0){
                    for(ArticuloObj a: AArray){
                        if(iIdProducto == a.getIdProducto()){
                            a.setCantidad(a.getCantidad() + iCantidad);
                            chequeo = true;
                            break;
                        }
                    }
                }
                
                if(!chequeo){
                    AArray.add(new ArticuloObj(iIdProducto, iCantidad) );
                }
                
                sesion.setAttribute("carrito", AArray);
                
                request.getSession().setAttribute("usuario", UUsuario);
                request.getSession().setAttribute("categorias", CArray);
                request.getSession().setAttribute("producto", PArray);
                response.sendRedirect("Carrito.jsp");
            }  
        
        
        if(strFormId.equals("2"))
            {
                String strId = request.getParameter("id");
                int iId = Integer.parseInt(strId);
                String strIdProducto1 = request.getParameter("idproducto1");
                int iIdProducto1 = Integer.parseInt(strIdProducto1);
                String strIdProducto2 = request.getParameter("idproducto2");
                int iIdProducto2 = Integer.parseInt(strIdProducto2);
                String strIdProducto3 = request.getParameter("idproducto3");
                int iIdProducto3 = Integer.parseInt(strIdProducto3);
                String strIdProducto4 = request.getParameter("idproducto4");
                int iIdProducto4 = Integer.parseInt(strIdProducto4);
                String strIdProducto5 = request.getParameter("idproducto5");
                int iIdProducto5 = Integer.parseInt(strIdProducto5);
                String strTotal = request.getParameter("total");
                int iTotal = Integer.parseInt(strTotal);
                
                DetalleOrdenLogic DLogic = new DetalleOrdenLogic();
                int iRows = DLogic.insertDetalleOrdenRows(iIdProducto1, iTotal, iId, iIdProducto2, iIdProducto3, iIdProducto4, iIdProducto5);
                System.out.println("inser categoria rows: " + iRows);
                
                HttpSession sesion  = request.getSession(true);
                ArrayList<ArticuloObj> AArray = sesion.getAttribute("carrito") == null ? new ArrayList<>() : (ArrayList) sesion.getAttribute("carrito");
                
                AArray.clear();                
                sesion.setAttribute("carrito",  AArray);
                
                response.sendRedirect("ProductoServlet?formid=8");
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
