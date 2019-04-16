<%-- 
    Document   : tripForm
    Created on : Apr 6, 2019, 7:27:20 PM
    Author     : balbi
--%>

<%@page import="java.util.Iterator"%>
<%@page import="bal.travelsyswebapp.objects.TripViewObj"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Trip Form</title>
        <link href="styles/tableStyles.css" rel="stylesheet" type="text/css"/>
    </head>
    <%
        ArrayList<TripViewObj> CArray = 
                (ArrayList<TripViewObj>)request.getSession().getAttribute("tripsview");
        Iterator<TripViewObj> iteArray = CArray.iterator();
    %>    
    <body>
        <h1>Trip Form</h1>
        <br>
        <a href="TripServlet?formid=6">New Trip</a>
        <br><br>
        <table>
        <tr>
            <th>Id</th>
            <th>Client</th>
            <th>Country From</th>
            <th>Country Dest</th>
            <th>Meal</th>
            <th>Cost</th>
        </tr>
        <%
            if(iteArray!=null)
            {
                TripViewObj CTemp;
                while(iteArray.hasNext())
                {
                    CTemp = iteArray.next();
        %>
                <tr>
                    <td><%= CTemp.getId() %></td>
                    <td><%= CTemp.getClient() %></td>
                    <td><%= CTemp.getCountryFrom() %></td>
                    <td><%= CTemp.getCountryDest() %></td>
                    <td><%= CTemp.getMeal() %></td>
                    <td><%= CTemp.getCost() %></td>
                    <td>
                        <a href="TripServlet?formid=4&id=<%= CTemp.getId() %>">
                            update
                        </a>
                    </td>
                    <td>
                        <a href="TripServlet?formid=3&id=<%= CTemp.getId() %>">
                            delete
                        </a>
                    </td>
                </tr>
        <%
                }
            }
        %>
        
        </table>
    </body>
</html>
