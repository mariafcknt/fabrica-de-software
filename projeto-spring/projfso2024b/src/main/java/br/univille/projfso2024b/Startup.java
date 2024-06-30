package br.univille.projfso2024b;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import br.univille.projfso2024b.entity.Cliente;
import br.univille.projfso2024b.entity.OrdemServico;
import br.univille.projfso2024b.service.ClienteService;
import br.univille.projfso2024b.service.OrdemServicoService;
import br.univille.projfso2024b.entity.Pet;
import br.univille.projfso2024b.service.PetService;

@Component
public class Startup {
    @Autowired
    private ClienteService clienteService;
    @Autowired
    private PetService petService;
    @Autowired
    private OrdemServicoService ordemService;

    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) {
        var cliente1 = new Cliente();
        cliente1.setNome("Zezinho da Silva Sauro");
        cliente1.setEndereco("Rua lalalla 1000");
        cliente1.setDataNascimento(new Date());
        clienteService.save(cliente1);

        var pet1 = new Pet();
        pet1.setNome("Doguin");
        pet1.setRaca("Vira-lata");
        pet1.setEspecie("Cachorro");
        petService.save(pet1);

        var ordem1 = new OrdemServico();
        var data = new Date();
        ordem1.setPet(pet1);
        ordem1.setDataEntrada(data);
        ordem1.setDataSaida(data);
        ordem1.setServico("Banho e Tosa");
        ordem1.setValor(250.0f);
        ordem1.setFormaPagamento("Crédito");
        ordem1.setAnotacao("O cachorro está com pulgas");
        ordemService.save(ordem1);
    }
}
