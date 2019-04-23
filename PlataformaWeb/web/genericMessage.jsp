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
        span class="close-btn">
        <a href="index.html">
        <img src="https://cdn4.iconfinder.com/data/icons/miu/22/circle_close_delete_-128.png"></img>
        </a>
        </span>
        <div class="registrar">
        <h1>Generic Message</h1>
        <br><br>
        <p><%= iRows %> ha sido modificado</p>
        <br><br>
        </div>
    </body>
</html>
