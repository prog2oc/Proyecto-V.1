/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oc.plataformaweb.servlets;
/**
 * @author Gabriela Centeno
 */
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
import oc.plataformaweb.logic.UsuarioLogic;
import oc.plataformaweb.objects.CategoriaObj;
import oc.plataformaweb.objects.ProductoObj;
import oc.plataformaweb.objects.UsuarioObj;

/**
 *
 * @author GabrielaB
 */
@WebServlet(name = "UsuarioServlet", urlPatterns = {"/UsuarioServlet"})
public class UsuarioServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) 
        {
                String strFormId = request.getParameter("formid");
            
            if(strFormId.equals("1"))
            {
                String strNombre = request.getParameter("nombre");
                String strApellido = request.getParameter("apellido");
                String strNombreUsuario = request.getParameter("usuario");
                String strFotoPerfil = "";
                String strGenero = request.getParameter("genero"); 
                String strFechaNacimiento = request.getParameter("fechanacimiento");
                String strCorreo = request.getParameter("correo"); 
                String strContrasena = request.getParameter("contrasena"); 
                String strDepartamento = request.getParameter("departamento");
                String strDireccion = request.getParameter("direccion");
                
                               
             
                UsuarioLogic ULogic = new UsuarioLogic();
                int iRows = ULogic.insertUsuarioRows(strNombre, strApellido, strNombreUsuario, strFotoPerfil, strGenero, strFechaNacimiento, strCorreo, strContrasena, strDepartamento, strDireccion);
                System.out.println("insert usuario rows: " + iRows);
              
                request.getSession().setAttribute("rows", new Integer(iRows));
                response.sendRedirect("UsuariogenericMessage.jsp");
            }
            
            if(strFormId.equals("2"))
            {
                UsuarioLogic ULogic = new UsuarioLogic();
                ArrayList<UsuarioObj> UArray = ULogic.getAllUsuarios();
              
                request.getSession().setAttribute("usuario", UArray);
                response.sendRedirect("usuarioForm.jsp");
            }
            
            if(strFormId.equals("3"))
            {
                String strId = request.getParameter("id");
                int iId = Integer.parseInt(strId);
                
                UsuarioLogic ULogic = new UsuarioLogic();
                int iRows = ULogic.deleteUsuarioRows(iId);
                
                request.getSession().setAttribute("rows", iRows);
                response.sendRedirect("UsuariogenericMessage.jsp");
            }
            
            if(strFormId.equals("4"))
            {
                String strId = request.getParameter("id");
                int iId = Integer.parseInt(strId);
                
                UsuarioLogic ULogic = new UsuarioLogic();
                UsuarioObj UUsuario = ULogic.getUsuarioById(iId);
          
                request.getSession().setAttribute("usuario", UUsuario);
                response.sendRedirect("usuarioUpdateForm.jsp");
            }   
            
            if(strFormId.equals("5"))
            {
                String strId=request.getParameter("id");
                String strNombre = request.getParameter("nombre");
                String strApellido = request.getParameter("apellido");
                String strNombreUsuario = request.getParameter("usuario");
                String strGenero = request.getParameter("genero"); 
                String strFechaNacimiento = request.getParameter("fechanacimiento");
                String strCorreo = request.getParameter("correo"); 
                String strContrasena = request.getParameter("contrasena"); 
                String strDepartamento = request.getParameter("departamento");
                String strDireccion = request.getParameter("direccion");    
                int iId = Integer.parseInt(strId);
               
                UsuarioLogic ULogic = new UsuarioLogic();
                int iRows = ULogic.updateUsuarioRows(iId, strNombre, strApellido, strNombreUsuario, strGenero, strFechaNacimiento, strCorreo, strContrasena, strDepartamento, strDireccion);
                System.out.println("update usuario rows: " + iRows);
                
                //send to frontend
                request.getSession().setAttribute("rows", new Integer(iRows) );
                response.sendRedirect("UsuariogenericMessage.jsp");
            }
            
            if(strFormId.equals("6"))
        {
           
            String strUsuario = request.getParameter("nombreusuario");
            String strContrasena = request.getParameter("contrasena");
            
            if( strUsuario.equals("admin") & strContrasena.equals("admin") ){
                response.sendRedirect("inicioAdministrador.jsp");    
            } else {
            
                UsuarioLogic ULogic = new UsuarioLogic();
                UsuarioObj UUsuario = ULogic.getUsuarioInfo(strUsuario, strContrasena);   

                if(UUsuario == null){                
                    request.getSession().setAttribute("error", "El usuario o contraseña no son correctos.");
                    response.sendRedirect("errorInicioSesion.jsp");    
                }else {  

                    //Productos y Categorias

                    CategoriaLogic CLogic = new CategoriaLogic();
                    ArrayList<CategoriaObj> CArray = CLogic.getAllCategorias();

                    ProductoLogic PLogic = new ProductoLogic();
                    ArrayList<ProductoObj> PArray = PLogic.getAllProductos();

                    request.getSession().setAttribute("categorias", CArray);
                    request.getSession().setAttribute("producto", PArray);                
                    request.getSession().setAttribute("usuario", UUsuario);
                    response.sendRedirect("InicioUsuario.jsp");
                }
            }
            
        }
            
            if(strFormId.equals("7")){
                String strId = request.getParameter("id");
                String strLogo = request.getParameter("foto");
                int iId = Integer.parseInt(strId);
                
                int iRows;
                
                UsuarioLogic ULogic = new UsuarioLogic();
                
                iRows = ULogic.updateUsuarioFotoRows(iId, strLogo);
                
                request.getSession().setAttribute("id", new Integer(iId));
                request.getSession().setAttribute("rows", new Integer(iRows) );
                response.sendRedirect("UsuarioInfoMessage.jsp");
            }
            
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}