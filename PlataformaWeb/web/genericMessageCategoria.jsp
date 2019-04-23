<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="Style/registrar.css" rel="stylesheet" type="text/css"/>
        <link href='https://fonts.googleapis.com/css?family=Amatic SC' rel='stylesheet'>
        <title>JSP Page</title>
    </head>
    <%  
        Integer iRowsObj = (Integer)request.getSession().getAttribute("rows");   
        int iRows = iRowsObj.intValue();
    %>
    
    <body>
        <span class="close-btn">
        <a href="CategoriaServlet?formid=2">
        <img src="https://cdn4.iconfinder.com/data/icons/miu/22/circle_close_delete_-128.png"></img>
        </a>
        </span>
        <div class="registrar">
            
        <img src="img/esevolado.png">   
        <br>
        <h1>Generic Message</h1>
        <br><br>
        <p><%= iRows %> categoria/as han sido modificadas</p>
        <br><br>
        
        </div>
    </body>
</html>
