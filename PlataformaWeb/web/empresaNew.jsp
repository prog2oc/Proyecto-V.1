<%-- 
    Document   : empresaNew
    Created on : 20/04/2019, 04:31:19 PM
    Author     : erick
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>New Empresa</h1>
        <br><br>
        
        <form id="myform" name="myform" action="EmpresagenericMessageLogo.jsp" method="post" enctype="multipart/form-data" >
                       
            <label>Logo:</label><br>            
            <input type="file" id="logo" name="logo" />
            <br><br>
            
            
            <input type="submit" id="mysubmit" name="mysubmit" value="Create"/>
        </form>
    </body>
</html>
