<%@page import="bal.travelsyswebapp.objects.ClientObj"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Client</title>
    </head>
    <%
        ClientObj CClient = 
                (ClientObj)request.getSession().getAttribute("client");
        
    %>
    <body>
        <h1>Update Client</h1>
        <br><br>
        
        <form id="myform" name="myform" action="ClientServlet" method="get">
            <label>Id:</label><br>
            <input type="number" id="nonId" name="nonId" value="<%= CClient.getId() %>" disabled/>
            <br><br>
            
            
            <label>Name:</label><br>
            <input type="text" id="name" name="name" value="<%= CClient.getName() %>" />
            <br><br>
            
            <label>Age:</label><br>
            <input type="number" id="age" name="age" value="<%= CClient.getAge() %>" />
            <br><br>
            
            <input type="submit" id="mysubmit" name="mysubmit" value="Update"/>
            <input type="hidden" id="formid" name="formid" value="5" />
            <input type="hidden" id="id" name="id" value="<%= CClient.getId() %>" />
        </form>
    </body>
</html>
