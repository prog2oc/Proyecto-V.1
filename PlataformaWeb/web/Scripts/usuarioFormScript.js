$(document).ready(function(){
    console.log("js funciona");
    
    $("#formNuevoUsuario").validate({
        
        rules:{
            
                nombre: {
                    required:true,
                    minlength:4
                },
                
                usuario: {
                    required:true,
                    minlength:4                   
                },
                
                apellido: {
                    required:true,
                    minlength:4                  
                },
                
                fechanacimiento: {
                    required:true,
                    min:'1899-01-01',
                    max:'2001-01-01'
                },
                correo:{
                    required:true
                },
                contrasena:{
                    required:true,
                    minlength:7,
                },
                direccion:{
                    required:true,
                    minlength:7
                }
        }
}); 

$("#formNuevaEmpresa").validate({
        
        rules:{
            
                nombre: {
                    required:true,
                    minlength:3
                },
                sitioweb:{
                    required:true
                },
                ciudad:{
                    required:true,
                    minlength:10
                },
                telefono:{
                    required:true,
                    minlength:8
                },
                direccion:{
                    required:true,
                    minlength:10
                }
        }
}); 
}); 