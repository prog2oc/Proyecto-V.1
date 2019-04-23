$(document).ready(function(){
    console.log("js funciona");
    
    $("#myform").validate({
        
        rules:{
            
                nombre: {
                    required:true,
                    minlength:4,
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
                    min:'1899-01-01',
                    max:'2001-01-01'
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
                ciudad:{
                    required:true,
                    minlength:10
                },
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
                costo:{
                    digits:true,
                    required:true
                }
            }
}); 
}); 
