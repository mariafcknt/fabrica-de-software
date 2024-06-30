(function(){

    $("#tabclientes").on("click",".js-delete", function() {
        let botaoClicado = $(this);
        $("#btnsim").attr("data-id", botaoClicado.attr("data-id"));
        $("#modalcliente").modal("show");
    })

    $("#btnsim").on("click", function(){
        let botaoSim = $(this)
        let id = botaoSim.attr("data-id")
        $.ajax({
            url: "/clientes/delete/" + id,
            method: "GET",
            success: function(){
                window.location.href = "/clientes"
            }
        })
    })

    //ordens
    $("#tabordens").on("click",".js-delete", function() {
        let botaoClicado = $(this);
        $("#btnsim").attr("data-id", botaoClicado.attr("data-id"));
        $("#modalordem").modal("show");
    })

    $("#btnsim").on("click", function(){
        let botaoSim = $(this)
        let id = botaoSim.attr("data-id")
        $.ajax({
            url: "/ordens/delete/" + id,
            method: "GET",
            success: function(){
                window.location.href = "/ordens"
            }
        })
    })

    //pets
    $("#tabpets").on("click",".js-delete", function() {
        let botaoClicado = $(this);
        $("#btnsim").attr("data-id", botaoClicado.attr("data-id"));
        $("#modalpet").modal("show");
    })

    $("#btnsim").on("click", function(){
        let botaoSim = $(this)
        let id = botaoSim.attr("data-id")
        $.ajax({
            url: "/pets/delete/" + id,
            method: "GET",
            success: function(){
                window.location.href = "/pets"
            }
        })
    })


})();