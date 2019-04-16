<%@page import="java.util.Iterator"%>
<%@page import="bal.travelsyswebapp.objects.ClientObj"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" 
              content="text/html; charset=UTF-8">
        <title>Client</title>
        <link href="styles/tableStyles.css" rel="stylesheet" type="text/css"/>
    </head>
    <%
        ArrayList<ClientObj> CArray = 
                (ArrayList<ClientObj>)request.getSession().getAttribute("clients");
        Iterator<ClientObj> iteArray = CArray.iterator();
    %>
    <body>
        <h1>Client</h1>
        <br>
        <a href="clientNew.html">New Client</a>
        <br><br>
        <table>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Age</th>
        </tr>
        <%
            if(iteArray!=null)
            {
                ClientObj CTemp;
                while(iteArray.hasNext())
                {
                    CTemp = iteArray.next();
        %>
                <tr>
                    <td><%= CTemp.getId() %></td>
                    <td><%= CTemp.getName() %></td>
                    <td><%= CTemp.getAge() %></td>
                    <td>
                        <a href="ClientServlet?formid=4&id=<%= CTemp.getId() %>">
                            update
                        </a>
                    </td>
                    <td>
                        <a href="ClientServlet?formid=3&id=<%= CTemp.getId() %>">
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
