<%@page import="bal.travelsyswebapp.objects.CountryObj"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Country</title>
    </head>
    <%
        CountryObj CCountry = 
                (CountryObj)request.getSession().getAttribute("country");
    %>
    <body>
        <h1>Update Country</h1>
        <br><br>
        
        <form id="myform" name="myform" action="CountryServlet" method="get">
            <label>Id:</label><br>
            <input type="number" id="idnon" name="idnon" value="<%= CCountry.getId() %>" disabled/>
            <br><br>
            
            <label>Name:</label><br>
            <input type="text" id="name" name="name" value="<%= CCountry.getName() %>" />
            <br><br>
            
            <label>Code:</label><br>
            <input type="text" id="code" name="code" value="<%= CCountry.getCode() %>" />
            <br><br>
            
            <input type="submit" id="mysubmit" name="mysubmit" value="Create"/>
            <input type="hidden" id="formid" name="formid" value="5" />
            <input type="hidden" id="id" name="id" value="<%= CCountry.getId() %>" />
        </form>
    </body>
</html>
