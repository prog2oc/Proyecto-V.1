<%-- 
    Document   : tripNew
    Created on : Apr 10, 2019, 8:35:46 PM
    Author     : balbi
--%>

<%@page import="bal.travelsyswebapp.objects.MealObj"%>
<%@page import="bal.travelsyswebapp.objects.CountryObj"%>
<%@page import="java.util.Iterator"%>
<%@page import="bal.travelsyswebapp.objects.ClientObj"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New Trip</title>
    </head>
    <%
        ArrayList<ClientObj> CClientArray = 
                (ArrayList<ClientObj>)request.getSession().getAttribute("clients");
        Iterator<ClientObj> iteClientArray = CClientArray.iterator();
        
        ArrayList<CountryObj> CCountryFromArray = 
                (ArrayList<CountryObj>)request.getSession().getAttribute("countryfrom");
        Iterator<CountryObj> iteCountryFromArray = CCountryFromArray.iterator();
        
        ArrayList<CountryObj> CCountryDestArray = CCountryFromArray;
        Iterator<CountryObj> iteCountryDestArray = CCountryDestArray.iterator();
        
        ArrayList<MealObj> CMealArray = 
                (ArrayList<MealObj>)request.getSession().getAttribute("meals");
        Iterator<MealObj> iteMealArray = CMealArray.iterator();
    %>    
    <body>
        <h1>New Trip</h1>
        <br><br>
        
        <form id="myform" name="myform" action="TripServlet" method="get">
            <label>Client:</label><br>
            <select id="client" name="client">
                <option id="client0" name="client0" value="0"></option>                
                <%
                    if(iteClientArray!=null)
                    {
                        ClientObj CClientTemp;
                        while(iteClientArray.hasNext())
                        {
                            CClientTemp = iteClientArray.next();
                %>
                            <option id="client<%= CClientTemp.getId() %>" 
                                    name="client<%= CClientTemp.getId() %>" 
                                    value="<%= CClientTemp.getId() %>">
                                <%= CClientTemp.getName() %>
                            </option>
                <%
                        }
                    }
                %>
            </select>
            <br><br>
            
            <label>Country From:</label><br>
            <select id="countryfrom" name="countryfrom">
                <option id="countryfrom0" name="countryfrom0" value="0"></option>                
                <%
                    if(iteCountryFromArray!=null)
                    {
                        CountryObj CCountryFromTemp;
                        while(iteCountryFromArray.hasNext())
                        {
                            CCountryFromTemp = iteCountryFromArray.next();
                %>
                            <option id="countryfrom<%= CCountryFromTemp.getId() %>" 
                                    name="countryfrom<%= CCountryFromTemp.getId() %>" 
                                    value="<%= CCountryFromTemp.getId() %>">
                                <%= CCountryFromTemp.getName() %>
                            </option>
                <%
                        }
                    }
                %>
            </select>
            <br><br>
            
            <label>Country Destination:</label><br>
            <select id="countrydest" name="countrydest">
                <option id="countrydest0" name="countrydest0" value="0"></option>
                <%
                    if(iteCountryDestArray!=null)
                    {
                        CountryObj CCountryDestTemp;
                        while(iteCountryDestArray.hasNext())
                        {
                            CCountryDestTemp = iteCountryDestArray.next();
                %>
                            <option id="countrydest<%= CCountryDestTemp.getId() %>" 
                                    name="countrydest<%= CCountryDestTemp.getId() %>" 
                                    value="<%= CCountryDestTemp.getId() %>">
                                <%= CCountryDestTemp.getName() %>
                            </option>
                <%
                        }
                    }
                %>
            </select>
            <br><br>
            
            <label>Meal:</label><br>
            <select id="meal" name="meal">
                <option id="meal0" name="meal0" value="0"></option>
                <%
                    if(iteMealArray!=null)
                    {
                        MealObj CMealTemp;
                        while(iteMealArray.hasNext())
                        {
                            CMealTemp = iteMealArray.next();
                %>
                            <option id="client<%= CMealTemp.getId() %>" 
                                    name="client<%= CMealTemp.getId() %>" 
                                    value="<%= CMealTemp.getId() %>">
                                <%= CMealTemp.getName() %>
                            </option>
                <%
                        }
                    }
                %>
            </select>
            <br><br>
            
            <label>Cost:</label><br>
            <input type="number" id="cost" name="cost" />
            <br><br>
            
            <input type="submit" id="mysubmit" name="mysubmit" value="Create"/>
            <input type="hidden" id="formid" name="formid" value="1" />
        </form>
    </body>
</html>
