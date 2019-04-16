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
import oc.plataformaweb.objects.CategoriaObj;

@WebServlet(name = "Categoria", urlPatterns = {"/Categoria"})
public class CategoriaServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String strFormId = request.getParameter("formid");
            
            if(strFormId.equals("1"))
            {
                //get parameters
                String strNombre = request.getParameter("nombre");
                String strDescripcion = request.getParameter("descripcion");
                
                //access logic
                CategoriaLogic CLogic = new CategoriaLogic();
                int iRows = CLogic.insertCategoriaRows(strNombre, strDescripcion);
                System.out.println("insert categoria rows: " + iRows);
                
                //send to frontend
                request.getSession().setAttribute("rows", new Integer(iRows));
                response.sendRedirect("genericMessageCategoria.jsp");
            }
            
            if(strFormId.equals("2"))
            {
                //access logic
                CategoriaLogic CLogic = new CategoriaLogic();
                ArrayList<CategoriaObj> CArray = CLogic.getAllCategorias();
                
                //send to frontend
                request.getSession().setAttribute("categoria", CArray);
                response.sendRedirect("categoriaForm.jsp");
            }
            
            if(strFormId.equals("3"))
            {
                //get parameters
                String strId = request.getParameter("id");
                int iId = Integer.parseInt(strId);
                
                //access logic
                CategoriaLogic CLogic = new CategoriaLogic();
                int iRows = CLogic.deleteCategoriaRows(iId);
                
                //send to frontend
                request.getSession().setAttribute("rows", iRows);
                response.sendRedirect("genericMessageCategoria.jsp");
            }
            
            if(strFormId.equals("4"))
            {
                //get parameters
                String strId = request.getParameter("id");
                int iId = Integer.parseInt(strId);
                
                //access logic
                CategoriaLogic CLogic = new CategoriaLogic();
                CategoriaObj CCategoria = CLogic.getCategoriaById(iId);
                
                //send to frontend
                request.getSession().setAttribute("categoria", CCategoria);
                response.sendRedirect("categoriaUpdateForm.jsp");
            }   
            
            if(strFormId.equals("5"))
            {
                //get parameters
                String strId = request.getParameter("id");
                String strNombre = request.getParameter("name");
                String strDescripcion = request.getParameter("age");
                int iId = Integer.parseInt(strId);
                
                
                //access logic
                CategoriaLogic CLogic = new CategoriaLogic();
                int iRows = CLogic.updateCategoriaRows(iId, strNombre, strDescripcion);
                System.out.println("update categoria rows: " + iRows);
                
                //send to frontend
                request.getSession().setAttribute("rows", new Integer(iRows));
                response.sendRedirect("genericMessageCategoria.jsp");
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
