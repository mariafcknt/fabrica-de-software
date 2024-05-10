package br.univille.projfso2024b;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import br.univille.projfso2024b.entity.Cliente;
import br.univille.projfso2024b.service.ClienteService;

import br.univille.projfso2024b.entity.Pet;
import br.univille.projfso2024b.service.PetService;

@Component
public class Startup {
    @Autowired
    private ClienteService clienteService;
    @Autowired
    private PetService petService;

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
    }
}
