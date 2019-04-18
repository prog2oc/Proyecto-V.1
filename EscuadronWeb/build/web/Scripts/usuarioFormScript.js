$(document).ready(function(){
    console.log("js funciona");
    
    $("#myForm").validate({
        
        rules:{
            
                nombre: {
                    required:true,
                    minlength:4,
                    pattern:"[A-Za-z]"
                },
                
                apellido: {
                    required:true,
                    minlength:4,
                    pattern:"[A-Za-z]"
                },
                
                fechaNacimiento: {
                    required:true,
                    min:'1899-01-01',
                    max:'2001-04-16'
                },
                
                edad: {
                    required:true,
                    min:18,
                    max:100
                },
                nombreUsuario:{
                        required:true,
                        minlength:5,
                        pattern:"[A-Za-z0-9]"
                    },
                correo:{
                    required:true
                },
                contra:{
                    minlength:4,
                    required:true
                    //patterm="^.*(?=.{8,})((?=.*[!@#$%^&*()\-_=+{};:,<.>]){1})(?=.*\d)((?=.*[a-z]){1})((?=.*[A-Z]){1}).*$"
                }                
        }
    });
});

