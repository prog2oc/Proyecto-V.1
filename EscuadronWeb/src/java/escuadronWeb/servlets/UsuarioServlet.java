package escuadronWeb.servlets;

import escuadronWeb.objects.UsuarioObj;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "UsuarioServlet", urlPatterns = {"/UsuarioServlet"})
public class UsuarioServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) 
        {
            String srtNombre = request.getParameter("nombre");
            String srtApellido = request.getParameter("apellido");
            String strEdad = request.getParameter("edad");
            String srtNombreUsuario = request.getParameter("nombreUsuario");
            String srtCorreo = request.getParameter("correo");
            String srtContra = request.getParameter("contra");
           
            int iEdad = Integer.parseInt(strEdad);
            
            UsuarioObj usuario = new UsuarioObj(srtNombre, srtApellido, iEdad, srtNombreUsuario, srtCorreo, srtContra);
            
                    
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UsuarioServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UsuarioServlet at " + request.getContextPath() + "</h1>");
            out.println("<h1>Bienvenido!</h1>");
            out.println("<h1>Nombre: "+usuario.getNombre()+"</h1>");
            out.println("<h1>Apellido: "+usuario.getApellido()+"</h1>");
            out.println("<h1>Edad: "+usuario.getEdad()+"</h1>");
            out.println("<h1>Nombre de Usuario: "+usuario.getNombreUsuario()+"</h1>");
            out.println("<h1>Correo: "+usuario.getCorreo()+"</h1>");
          
            out.println("</body>");
            out.println("</html>");
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
