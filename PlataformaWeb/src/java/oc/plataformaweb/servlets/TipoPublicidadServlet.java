package oc.plataformaweb.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import oc.plataformaweb.logic.TipoPublicidadLogic;
import oc.plataformaweb.objects.TipoPublicidadObj;

@WebServlet(name = "TipoPublicidadServlet", urlPatterns = {"/TipoPublicidadServlet"})
public class TipoPublicidadServlet extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
             String strFormId = request.getParameter("formid");
            
            if(strFormId.equals("1"))
            {
                //get parameters
                String strName = request.getParameter("name");
                String strDescription = request.getParameter("description");
                
                //access logic
                TipoPublicidadLogic CLogic = new TipoPublicidadLogic();
                int iRows = CLogic.insertTipoPublicidadRows(strName, strDescription);
                System.out.println("inser tipo publicidad rows: " + iRows);
                
                //send to frontend
                request.getSession().setAttribute("rows", new Integer(iRows) );
                response.sendRedirect("genericMessage.jsp");                
            }
             if(strFormId.equals("2"))
            {
                //access logic
                TipoPublicidadLogic CLogic = new TipoPublicidadLogic();
                ArrayList<TipoPublicidadObj> PArray = CLogic.getAllTipoPublicidad();
                
                //send to frontend
                request.getSession().setAttribute("tipopublicidad", PArray);
                response.sendRedirect("TipoPublicidadForm.jsp");                
            }
              if(strFormId.equals("3"))
            {
                //get parameters
                String strId = request.getParameter("id");
                int iId = Integer.parseInt(strId);
                
                //access logic
                TipoPublicidadLogic PLogic = new TipoPublicidadLogic();
                int iRows = PLogic.deleteTipoPublicidadRows(iId);
                
                //send to frontend
                request.getSession().setAttribute("rows", iRows);
                response.sendRedirect("genericMessage.jsp"); 
            }
              if(strFormId.equals("4"))
            {
                //get parameters
                String strId = request.getParameter("id");
                int iId = Integer.parseInt(strId);
                
                //access logic
                TipoPublicidadLogic CLogic = new TipoPublicidadLogic();
                TipoPublicidadObj PTipoPublicidad = CLogic.getTipoPublicidadById(iId);
                
                //send to frontend
                request.getSession().setAttribute("tipopublicidad", PTipoPublicidad);
                response.sendRedirect("TipoPublicidadUpdateForm.jsp");                
            }
              if(strFormId.equals("5"))
            {
                //get parameters
                String strId = request.getParameter("id");
                String strName = request.getParameter("name");
                String strDescription = request.getParameter("description");
                int iId = Integer.parseInt(strId);
                
                //access logic
                TipoPublicidadLogic PLogic = new TipoPublicidadLogic();
                int iRows = PLogic.updateTipoPublicidadRows(iId,strName, strDescription);
                System.out.println("update Tipo de publicidad rows: " + iRows);
                
                //send to frontend
                request.getSession().setAttribute("rows", new Integer(iRows) );
                response.sendRedirect("genericMessage.jsp");
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
