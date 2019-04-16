package bal.travelsyswebapp.servlets;

import bal.travelsyswebapp.logic.ClientLogic;
import bal.travelsyswebapp.logic.CountryLogic;
import bal.travelsyswebapp.logic.MealLogic;
import bal.travelsyswebapp.logic.TripLogic;
import bal.travelsyswebapp.objects.ClientObj;
import bal.travelsyswebapp.objects.CountryObj;
import bal.travelsyswebapp.objects.MealObj;
import bal.travelsyswebapp.objects.TripObj;
import bal.travelsyswebapp.objects.TripViewObj;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "TripServlet", urlPatterns = {"/TripServlet"})
public class TripServlet extends HttpServlet 
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
                String strClient = request.getParameter("client");
                String strCountryFrom = request.getParameter("countryfrom");
                String strCountryDest = request.getParameter("countrydest");
                String strMeal = request.getParameter("meal");
                String strCost = request.getParameter("cost");
                
                int iIdClient = Integer.parseInt(strClient);
                int iIdCountryFrom = Integer.parseInt(strCountryFrom);
                int iIdCountryDest = Integer.parseInt(strCountryDest);
                int iIdMeal = Integer.parseInt(strMeal);
                double dCost = Double.parseDouble(strCost);
                
                //access logic
                TripLogic CLogic = new TripLogic();
                int iRows = CLogic.insertTripRows(iIdClient, iIdCountryFrom, iIdCountryDest, iIdMeal, dCost);
                System.out.println("insert trip rows: " + iRows);
                                
                //send to frontend
                request.getSession().setAttribute("rows", new Integer(iRows) );
                response.sendRedirect("genericMessage.jsp");                 
            }
            
            if(strFormId.equals("2"))
            {
                //access logic
                TripLogic CLogic = new TripLogic();
                ArrayList<TripViewObj> CArray = CLogic.getAllTrips();
                
                //send to frontend
                request.getSession().setAttribute("tripsview", CArray);
                response.sendRedirect("tripForm.jsp");
            }
            
            if(strFormId.equals("3"))
            {
            }            
            
            if(strFormId.equals("4"))
            {
            }            
            
            if(strFormId.equals("5"))
            {
            }            
            
            if(strFormId.equals("6"))
            {
                //load all dropdowns
                ClientLogic CClientLogic = new ClientLogic();
                ArrayList<ClientObj> CClientArray = CClientLogic.getAllClients();
                
                CountryLogic CCountryLogic = new CountryLogic();
                ArrayList<CountryObj> CCountryFromArray = 
                        CCountryLogic.getAllCountries();
                
                MealLogic CMealLogic = new MealLogic();
                ArrayList<MealObj> CMealArray = CMealLogic.getAllMeals();
                
                request.getSession().setAttribute("clients", CClientArray);
                request.getSession().setAttribute("countryfrom", CCountryFromArray);
                request.getSession().setAttribute("meals", CMealArray);
                response.sendRedirect("tripNew.jsp");
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
