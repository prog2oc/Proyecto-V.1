package bal.travelsyswebapp.servlets;

import bal.travelsyswebapp.logic.MealLogic;
import bal.travelsyswebapp.objects.MealObj;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "MealServlet", urlPatterns = {"/MealServlet"})
public class MealServlet extends HttpServlet 
{

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) 
        {
            /* your code */
            String strFormId = request.getParameter("formid");
            
            if(strFormId.equals("1"))
            {
                //get parameters
                String strName = request.getParameter("name");
                String strDescription = request.getParameter("description");
                
                //access logic
                MealLogic CLogic = new MealLogic();
                int iRows = CLogic.insertMealRows(strName, strDescription);
                System.out.println("inser meal rows: " + iRows);
                
                //send to frontend
                request.getSession().setAttribute("rows", new Integer(iRows) );
                response.sendRedirect("genericMessage.jsp");                
            }
            
            if(strFormId.equals("2"))
            {
                //access logic
                MealLogic CLogic = new MealLogic();
                ArrayList<MealObj> CArray = CLogic.getAllMeals();
                
                //send to frontend
                request.getSession().setAttribute("meals", CArray);
                response.sendRedirect("mealForm.jsp");                
            }
            
            if(strFormId.equals("3"))
            {
                //get parameters
                String strId = request.getParameter("id");
                int iId = Integer.parseInt(strId);
                
                //access logic
                MealLogic CLogic = new MealLogic();
                int iRows = CLogic.deleteMealRows(iId);
                
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
                MealLogic CLogic = new MealLogic();
                MealObj CMeal = CLogic.getMealById(iId);
                
                //send to frontend
                request.getSession().setAttribute("meal", CMeal);
                response.sendRedirect("mealUpdateForm.jsp");                
            }
            
            if(strFormId.equals("5"))
            {
                //get parameters
                String strId = request.getParameter("id");
                String strName = request.getParameter("name");
                String strDescription = request.getParameter("description");
                int iId = Integer.parseInt(strId);
                
                //access logic
                MealLogic CLogic = new MealLogic();
                int iRows = CLogic.updateMealRows(iId,strName, strDescription);
                System.out.println("update meal rows: " + iRows);
                
                //send to frontend
                request.getSession().setAttribute("rows", new Integer(iRows) );
                response.sendRedirect("genericMessage.jsp");
            }            
            if(strFormId.equals("6"))
            {
                
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
