(function(){

    $("#tabclientes").on("click", ".js-delete", function(){
        //alert("ema ema ema");
        let botaoClicado = $(this); //Pegar a referencia de qua lbotao vermelho foi clicado
        $("#btnsim").attr("data-id", botaoClicado.attr("data-id")); //Pegar o id do botao clicado e passar para o botao sim
        $("#modalcliente").modal("show"); //aparecer a modal na cara do usuário
    })

    //aqui vamos chamar o botao sim para deletar o cliente
    $("#btnsim").on("click", function(){
        let botaoSim = $(this);
        let id = botaoSim.attr("data-id");
        $.ajax({
            url: "/clientes/delete/" + id,//para onde vamos chamar, qual endpoint
             method: "GET", //qual metodo vamos usar
            success: function(){
            window.location.href = "/clientes";
        }
        })
    })

})();