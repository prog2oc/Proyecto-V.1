
$(document).ready(function(){
    $("#myform").validate({
        rules:{
            nombre:{
                required:true
            },
            direccion:{
                required:true
            },
            departamento:{
                required:true
            },
            ciudad:{
                required:true
            },
            telefono:{
                required:true,
                length:8
            },
            sitioweb:{
                required:true
            }
        }
    });
});


