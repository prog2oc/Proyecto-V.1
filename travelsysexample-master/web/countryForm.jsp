<%@page import="java.util.Iterator"%>
<%@page import="bal.travelsyswebapp.objects.CountryObj"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" 
              content="text/html; charset=UTF-8">
        <title>Country Form</title>
        <link href="styles/tableStyles.css" rel="stylesheet" type="text/css"/>        
    </head>
    <%
        ArrayList<CountryObj> CArray = 
                (ArrayList<CountryObj>)request.getSession().getAttribute("countries");
        Iterator<CountryObj> iteArray = CArray.iterator();
    %>
    <body>
        <h1>Country</h1>
        <br>
        <a href="countryNew.html">New Country</a>
        <br><br>
        <table>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Code</th>
        </tr>
        <%
            if(iteArray!=null)
            {
                CountryObj CTemp;
                while(iteArray.hasNext())
                {
                    CTemp = iteArray.next();
        %>
                <tr>
                    <td><%= CTemp.getId() %></td>
                    <td><%= CTemp.getName() %></td>
                    <td><%= CTemp.getCode() %></td>
                    <td>
                        <a href="CountryServlet?formid=4&id=<%= CTemp.getId() %>">
                            update
                        </a>
                    </td>
                    <td>
                        <a href="CountryServlet?formid=3&id=<%= CTemp.getId() %>">
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
