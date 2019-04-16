<%-- 
    Document   : mealUpdateForm
    Created on : Apr 6, 2019, 12:09:37 AM
    Author     : balbi
--%>

<%@page import="bal.travelsyswebapp.objects.MealObj"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Meal</title>
    </head>
    <%
        MealObj CMeal = 
                (MealObj)request.getSession().getAttribute("meal");
        
    %>    
    <body>
        <h1>Update Meal</h1>
        <br><br>
        
        <form id="myform" name="myform" action="MealServlet" method="get">
            <label>Id:</label><br>
            <input type="number" id="nonId" name="nonId" value="<%= CMeal.getId() %>" disabled/>
            <br><br>
            
            
            <label>Name:</label><br>
            <input type="text" id="name" name="name" value="<%= CMeal.getName() %>" />
            <br><br>
            
            <label>Description:</label><br>
            <input type="text" id="description" name="description" value="<%= CMeal.getDescription() %>" />
            <br><br>
            
            <input type="submit" id="mysubmit" name="mysubmit" value="Update"/>
            <input type="hidden" id="formid" name="formid" value="5" />
            <input type="hidden" id="id" name="id" value="<%= CMeal.getId() %>" />
        </form>
    </body>
</html>
