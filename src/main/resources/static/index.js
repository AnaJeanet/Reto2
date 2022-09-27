function leerClientes(){
        $.ajax({    
            url : 'https://dog.ceo/api/breeds/image/random',
            type : 'GET',
            dataType : 'json',
    
            success : function(respuesta) {
                   alert(respuesta);

            error : function(xhr, status) {
                alert('ha sucedido un problema');
            }
        });
    }
    