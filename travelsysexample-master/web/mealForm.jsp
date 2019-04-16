<%@page import="java.util.Iterator"%>
<%@page import="bal.travelsyswebapp.objects.MealObj"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Meal Form</title>
        <link href="styles/tableStyles.css" rel="stylesheet" type="text/css"/>        
    </head>
    <%
        ArrayList<MealObj> CArray = 
                (ArrayList<MealObj>)request.getSession().getAttribute("meals");
        Iterator<MealObj> iteArray = CArray.iterator();
    %>    
    <body>
        <h1>Meal</h1>
        <br>
        <a href="mealNew.html">New Meal</a>
        <br><br>
        <table>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Description</th>
        </tr>
        <%
            if(iteArray!=null)
            {
                MealObj CTemp;
                while(iteArray.hasNext())
                {
                    CTemp = iteArray.next();
        %>
                <tr>
                    <td><%= CTemp.getId() %></td>
                    <td><%= CTemp.getName() %></td>
                    <td><%= CTemp.getDescription() %></td>
                    <td>
                        <a href="MealServlet?formid=4&id=<%= CTemp.getId() %>">
                            update
                        </a>
                    </td>
                    <td>
                        <a href="MealServlet?formid=3&id=<%= CTemp.getId() %>">
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
