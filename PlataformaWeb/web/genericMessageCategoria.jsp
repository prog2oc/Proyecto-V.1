<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <%  
        Integer iRowsObj = (Integer)request.getSession().getAttribute("rows");   
        int iRows = iRowsObj.intValue();
    %>
    
    <body>
        <h1>Generic Message</h1>
        <br><br>
        <p><%= iRows %> rows where affected</p>
        <br><br>
        <a href="CategoriaServlet?formid=2">Home</a>
    </body>
</html>
