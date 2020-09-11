/* global swal */

$(document).ready(function(){
    $("tr #btnDelete").click(function () {
        var idp=$(this).parent().find("#idp").val();
        eliminar(idp);
                swal({
          title: "Você está certo?",
          text: "A lista de compra do curso será excluido do carrinho !!" + " \n Realize nova compra se for necessário",
          icon: "warning",
          buttons: true,
          dangerMode: true
        }) .then((willDelete) => {
          if (willDelete) {
              eliminar(idp);
              swal("Curso removido eliminado com sucesso ", {
              icon: "success"
            }).then((willDelete)=>{
                    if (willDelete) {
                        parent.location.href="Controlador?accion=Carrinho";
                    }
            });
          } else {
            swal("Operação cancelada pelo cliente !");
          }
        });
    });
    function eliminar(idp) {
        var url="Controlador?accion=Delete";
            $.ajax({
                type: 'POST',
                url: url,
                data: "idp="+idp,
                    success: function (data, textStatus, jqXHR) {
                        // msg de alerta Localhost
//                        alert("Localhost: Curso removido do carrinho!");
            }
       });
    }
    
    $("tr #Quantidade").click(function () {
        var idp=$(this).parent().find("#idpro").val();
        var quantidade=$(this).parent().find("#Quantidade").val();
        var url = "Controlador?accion=AtualizarQuantidade";
        $.ajax({
            type: 'POST',
            url: url,
            data: "idp=" + idp + "&Quantidade" + quantidade,
            success: function (data, textStatus, jqXHR) {
                location.href="Controlador?accion=Carrinho";
            }
        });             
    });
});

