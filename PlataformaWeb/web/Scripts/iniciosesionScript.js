$(document).ready(function(){
    
    
    $("#myform").validate({
        
        rules:{
                nombreusuario: "required",
                contrasena: "required"
            },
        
        messages:{
                nombreusuario: " Ingrese su usuario. ",
                contrasena: " Ingrese su contraseña. " 
        }
            
}); 
}); 



