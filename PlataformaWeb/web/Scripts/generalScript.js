$(document).ready(function(){
    console.log("js funciona");
    
    $("#myform").validate({
        
        rules:{
            
                nombre: {
                    required:true,
                    minlength:3,
                    lettersonly:true
                },
                
                usuario: {
                    required:true,
                    minlength:4                   
                },
                
                apellido: {
                    required:true,
                    minlength:4,
                    lettersonly:true
                },
                
                fechanacimiento: {
                    date:true,
                    required:true,
                    min:'1940-01-01',
                    max:'2001-03-03'
                },
                
                repetircontrasena:{
                    required:true,
                    equalTo:"#contrasena"
                },
                
                correo:{
                    required:true,
                    email:true
                },
                
                contrasena:{
                    required:true,
                    minlength:7
                },
                
                direccion:{
                    required:true,
                    minlength:7
                },
                
                sitioweb:{
                    required:true,
                    url:true
                },
                
                ciudad: "required",
                
                telefono:{
                    digits:true,
                    required:true,
                    minlength:8,
                    maxlength:8
                },
                
                unidades:{
                    digits:true,
                    required:true
                },
                
                precio:{
                    digits:true,
                    required:true
                },
                
                descripcion: "required"
            },
        
        messages:{
            
                nombre: {
                    required: " Digite su nombre. ",
                    minlength: " Su nombre debe de tener más de tres letras. ",
                    lettersonly: " Solo debe de ingresar letras. "
                },
                
                usuario: {
                    required: " Digite un usuario. ",
                    minlength: " El usuario debe de tener más de cuatro caracteres. "                   
                },
                
                 apellido: {
                    required: " Digite su apellido. ",
                    minlength: " Su apellido debe de tener más de tres letras. ",
                    lettersonly: " Solo debe de ingresar letras. "
                },
                
                fechanacimiento: {
                    required: " Debe de ingresar su fecha de nacimiento. ",
                    min: " Ingrese su verdadera fecha de nacimiento. ",
                    max: " Debe de tener más de 18 años para crear un usuario. "
                },
                
                repetircontrasena:{
                    required: " Debe de ingresar nuevamente la contraseña. ",
                    equalTo: " Las contraseñas no coinciden. "
                },
                
                correo:{
                    required: " Debe de ingresar un correo electrónico. ",
                    email: " Debe de ingresar un correo electrónico válido. "
                },
                
                contrasena:{
                    required: " Debe de ingesar una contraseña. ",
                    minlength: " Su contraseña debe de tener siete o más caracteres. "
                },
                
                direccion:{
                    required: " Debe de ingresar su dirección. ",
                    minlength: " La dirección debe de contener más de siete caracteres. "
                },
                
                sitioweb:{
                    required: " Debe de ingresar su sitio web. ",
                    url: " Debe de ingresar un sitio web válido. "
                },
                
                ciudad: " Debe de ingresar su ciudad. ",
                
                telefono:{
                    digits: " Solo debe de ingresar dígitos. ",
                    required: " Debe de ingresar su número telefónico. ",
                    minlength: " No debe de ingresar menos de 8 dígitos. ",
                    maxlength: " No debe de ingresar más de 8 dígitos. "
                },
                
                unidades:{
                    digits: " Solo debe de ingresar dígitos. ",
                    required: " Debe de ingresar la cantidad que desea adquirir. "
                },
                
                preciounidad:{
                    digits: " Solo debe de ingresar dígitos. ",
                    required: " Debe de ingresar el costo del producto. "
                },
                
                descripcion: " Ingrese una descripción para la categoría. "
                
                
                
                
                
        }
            
}); 
}); 
