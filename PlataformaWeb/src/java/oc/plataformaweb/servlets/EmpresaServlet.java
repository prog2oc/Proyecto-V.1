
package oc.plataformaweb.servlets;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import oc.plataformaweb.logic.EmpresaLogic;
import oc.plataformaweb.objects.EmpresaObj;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@MultipartConfig
@WebServlet(name = "EmpresaServlet", urlPatterns = {"/EmpresaServlet"})
public class EmpresaServlet extends HttpServlet 
{

    protected void processRequest(HttpServletRequest request, 
            HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) 
        {
            String strFormId = request.getParameter("formid");
            
            if(strFormId.equals("1"))
            {             
                
                String strNombre = request.getParameter("nombre");
                Part pLogo = request.getPart("logo");
                String strDireccion = request.getParameter("direccion");
                String strDepartamento = request.getParameter("departamento");
                String strCiudad = request.getParameter("ciudad");
                String strTelefono = request.getParameter("telefono");
                String strSitioWeb = request.getParameter("sitioweb");
                String strLogo = pLogo.getSubmittedFileName();
             
                EmpresaLogic ELogic = new EmpresaLogic();
                int iRows = ELogic.insertEmpresaRows(strNombre, strLogo, strDireccion, strDepartamento, strCiudad, strTelefono, strSitioWeb);
                System.out.println("insert empresa rows: " + iRows);
                
                request.getSession().setAttribute("logo", pLogo);
                request.getSession().setAttribute("rows", new Integer(iRows));
                response.sendRedirect("EmpresagenericMessage.jsp");
            }
            
            if(strFormId.equals("2"))
            {
                EmpresaLogic ELogic = new EmpresaLogic();
                ArrayList<EmpresaObj> EArray = ELogic.getAllEmpresas();
              
                request.getSession().setAttribute("empresa", EArray);
                response.sendRedirect("empresaForm.jsp");
            }
            
            if(strFormId.equals("3"))
            {
                String strId = request.getParameter("id");
                int iId = Integer.parseInt(strId);
                
                EmpresaLogic ELogic = new EmpresaLogic();
                int iRows = ELogic.deleteEmpresaRows(iId);
                
                request.getSession().setAttribute("rows", iRows);
                response.sendRedirect("EmpresagenericMessage.jsp");
            }
            
            if(strFormId.equals("4"))
            {
                String strId = request.getParameter("id");
                int iId = Integer.parseInt(strId);
                
                EmpresaLogic ELogic = new EmpresaLogic();
                EmpresaObj CEmpresa = ELogic.getEmpresaById(iId);
          
                request.getSession().setAttribute("empresa", CEmpresa);
                response.sendRedirect("empresaUpdateForm.jsp");
            }   
            
            if(strFormId.equals("5"))
            {
                String strId = request.getParameter("id");
                String strNombre = request.getParameter("nombre");                
                Part pLogo = request.getPart("logo");
                String strDireccion = request.getParameter("direccion");
                String strDepartamento = request.getParameter("departamento");
                String strCiudad = request.getParameter("ciudad");
                String strTelefono = request.getParameter("telefono");
                String strSitioWeb = request.getParameter("sitioweb");    
                int iId = Integer.parseInt(strId);
                String strLogo = pLogo.getSubmittedFileName();
                
                int iRows;
               
                EmpresaLogic ELogic = new EmpresaLogic();
                if (strLogo != null)
                {
                    iRows = ELogic.updateEmpresaRows(iId,strNombre, strLogo, strDireccion,strDepartamento,strCiudad,strTelefono,strSitioWeb);
                    request.getSession().setAttribute("rows", new Integer(iRows) );
                    response.sendRedirect("EmpresagenericMessageLogo.jsp");
                } else {
                    iRows = ELogic.updateEmpresaSinImagenRows(iId,strNombre,strDireccion,strDepartamento,strCiudad,strTelefono,strSitioWeb);
                    request.getSession().setAttribute("rows", new Integer(iRows) );
                    response.sendRedirect("EmpresagenericMessage.jsp");
                }
                System.out.println("update empresa rows: " + iRows);
                
                //send to frontend
                request.getSession().setAttribute("rows", new Integer(iRows) );
                response.sendRedirect("EmpresagenericMessageLogo.jsp");
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

