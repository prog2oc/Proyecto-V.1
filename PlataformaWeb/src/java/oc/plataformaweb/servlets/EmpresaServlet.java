
package oc.plataformaweb.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import oc.plataformaweb.logic.EmpresaLogic;
import oc.plataformaweb.objects.EmpresaObj;


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
                String strDireccion = request.getParameter("direccion");
                String strDepartamento = request.getParameter("departamento");
                String strCiudad = request.getParameter("ciudad");
                String strContrasena = request.getParameter("contrasena");
                String strSitioWeb = request.getParameter("sitioweb");
                String strLogo = request.getParameter("logo");
             
                EmpresaLogic ELogic = new EmpresaLogic();
                int iRows = ELogic.insertEmpresaRows(strNombre, strLogo, strDireccion, strDepartamento, strCiudad, strContrasena, strSitioWeb);
                System.out.println("insert empresa rows: " + iRows);                
        
                request.getSession().setAttribute("rows", new Integer(iRows));
                response.sendRedirect("ProductoServlet?formid=7");
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
                String strDireccion = request.getParameter("direccion");
                String strDepartamento = request.getParameter("departamento");
                String strCiudad = request.getParameter("ciudad");
                String strContrasena = request.getParameter("contrasena");
                String strSitioWeb = request.getParameter("sitioweb");    
                int iId = Integer.parseInt(strId);
                
                int iRows;
               
                EmpresaLogic ELogic = new EmpresaLogic();
                
                iRows = ELogic.updateEmpresaRows(iId,strNombre,strDireccion,strDepartamento,strCiudad,strContrasena,strSitioWeb);                
                System.out.println("update empresa rows: " + iRows);
                
                request.getSession().setAttribute("rows", new Integer(iRows) );
                response.sendRedirect("inicioEmpresa.jsp");
            }
            
            if(strFormId.equals("6")){
                String strId = request.getParameter("id");
                int iId = Integer.parseInt(strId);
                          
                request.getSession().setAttribute("id", new Integer(iId));
                response.sendRedirect("empresaUpdateLogo.jsp");
            }
            
            if(strFormId.equals("7")){
                String strId = request.getParameter("id");
                String strLogo = request.getParameter("logo");
                int iId = Integer.parseInt(strId);
                
                int iRows;
                
                EmpresaLogic ELogic = new EmpresaLogic();
                
                iRows = ELogic.updateEmpresaImagenRows(iId, strLogo);
          
                request.getSession().setAttribute("rows", new Integer(iRows) );
                response.sendRedirect("EmpresagenericMessage.jsp");
            }
            
             if(strFormId.equals("8"))
        {
           
            String strUsuario = request.getParameter("nombreusuario");
            String strContrasena = request.getParameter("contrasena");
            
            if( strUsuario.equals("admin") & strContrasena.equals("admin") ){
                response.sendRedirect("inicioAdministrador.jsp");    
            } else {
            
                EmpresaLogic ELogic = new EmpresaLogic();
                EmpresaObj EEmpresa = ELogic.getEmpresaInfo(strUsuario, strContrasena);

                if(EEmpresa == null){                
                    request.getSession().setAttribute("error", "El usuario o contraseña no son correctos.");
                    response.sendRedirect("errorInicioSesion.jsp");    
                }else {  
                
                    request.getSession().setAttribute("empresa", EEmpresa);
                    response.sendRedirect("inicioEmpresa.jsp");
                }
            }
            
        }
             
             if(strFormId.equals("9"))
            {
                EmpresaLogic ELogic = new EmpresaLogic();
                ArrayList<EmpresaObj> EArray = ELogic.getAllEmpresas();
              
                request.getSession().setAttribute("empresa", EArray);
                response.sendRedirect("detalleEmpresa.jsp");
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

