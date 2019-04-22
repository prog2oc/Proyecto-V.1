package oc.plataformaweb.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import oc.plataformaweb.logic.PublicidadLogic;
import oc.plataformaweb.logic.TipoPublicidadLogic;
import oc.plataformaweb.objects.PublicidadObj;
import oc.plataformaweb.objects.TipoPublicidadObj;

@WebServlet(name = "PublicidadServlet", urlPatterns = {"/PublicidadServlet"})
public class PublicidadServlet extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) 
        {
            
            String strFormId = request.getParameter("formid");
            
            if(strFormId.equals("1"))
            {
                String strImagen = request.getParameter("imagen");
                String strIdTipoPublicidad = request.getParameter("tipopublicidad");
                String strIdEmpresa = request.getParameter("empresa");             
                
                int iIdTipoPublicidad = Integer.parseInt(strIdTipoPublicidad);
                int iIdEmpresa = Integer.parseInt(strIdEmpresa);
                System.out.println("insert producto rows: " + strImagen + iIdTipoPublicidad + iIdEmpresa);
                
                PublicidadLogic PLogic = new PublicidadLogic();
                int iRows = PLogic.insertPublicidadRows(strImagen, iIdTipoPublicidad, iIdEmpresa);
                System.out.println("insert producto rows: " + iRows);
                
                request.getSession().setAttribute("rows", new Integer(iRows));
                response.sendRedirect("genericMessagePublicidad.jsp");
            }
            
            if(strFormId.equals("2"))
            {
                PublicidadLogic PLogic = new PublicidadLogic();
                ArrayList<PublicidadObj> PArray = PLogic.getAllPublicidad();
                
                TipoPublicidadLogic TPLogic = new TipoPublicidadLogic();
                ArrayList<TipoPublicidadObj> TPArray = TPLogic.getAllTipoPublicidad();
                               
                request.getSession().setAttribute("tipopublicidad", TPArray);
                                
                request.getSession().setAttribute("publicidad", PArray);
                response.sendRedirect("publicidadForm.jsp");
            }
            
            if(strFormId.equals("3"))
            {
                
                String strId = request.getParameter("id");
                int iId = Integer.parseInt(strId);
                
                
                PublicidadLogic PLogic = new PublicidadLogic();
                int iRows = PLogic.deletePublicidadRows(iId);
                
                
                request.getSession().setAttribute("rows", iRows);
                response.sendRedirect("genericMessagePublicidad.jsp");
            }
            
            if(strFormId.equals("4"))
            {                
                String strId = request.getParameter("id");
                int iId = Integer.parseInt(strId);              
                                
                PublicidadLogic PLogic = new PublicidadLogic();
                PublicidadObj CPublicidad = PLogic.getPublicidadById(iId);
                
                TipoPublicidadLogic TPLogic = new TipoPublicidadLogic();
                ArrayList<TipoPublicidadObj> TPArray = TPLogic.getAllTipoPublicidad();
                
                
                request.getSession().setAttribute("tipopublicidad", TPArray);                
                request.getSession().setAttribute("publicidad", CPublicidad);               
                response.sendRedirect("publicidadUpdateForm.jsp");
            }   
            
            if(strFormId.equals("5"))
            {               
                String strId = request.getParameter("id");
                String strIdTipoPublicidad = request.getParameter("tipopublicidad");                
                int iIdTipoPublicidad = Integer.parseInt(strIdTipoPublicidad);
                int iId = Integer.parseInt(strId);
                                
                PublicidadLogic PLogic = new PublicidadLogic();
                int iRows = PLogic.updatePublicidadRows(iId, iIdTipoPublicidad);
                System.out.println("update client rows: " + iRows);
                                
                request.getSession().setAttribute("rows", new Integer(iRows));
                response.sendRedirect("genericMessagePublicidad.jsp");
            }
            
            if(strFormId.equals("6"))
            {
                String strId = request.getParameter("id");
                int iId = Integer.parseInt(strId);
                
                TipoPublicidadLogic PLogic = new TipoPublicidadLogic();
                ArrayList<TipoPublicidadObj> PArray = PLogic.getAllTipoPublicidad();
                               
                request.getSession().setAttribute("id", new Integer(iId));
                request.getSession().setAttribute("tipopublicidad", PArray);
                response.sendRedirect("publicidadNewImagen.jsp");
            }
            
            if(strFormId.equals("7")){
                String strId = request.getParameter("id");
                String strLogo = request.getParameter("imagen");
                int iId = Integer.parseInt(strId);
                
                int iRows;
                
                PublicidadLogic ULogic = new PublicidadLogic();
                
                iRows = ULogic.updatePublicidadImagenRows(iId, strLogo);
                                
                request.getSession().setAttribute("rows", new Integer(iRows) );
                response.sendRedirect("publicidadInfoMessage.jsp");
            }
            
            if(strFormId.equals("8")){
                String strId = request.getParameter("id");
                int iId = Integer.parseInt(strId);
                          
                request.getSession().setAttribute("id", new Integer(iId));
                response.sendRedirect("publicidadUpdateImagen.jsp");
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
