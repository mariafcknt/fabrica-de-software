package br.univille.projfso2024b;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import br.univille.projfso2024b.entity.Cliente;
import br.univille.projfso2024b.service.ClienteService;
//vira um bin, um objeto 'relacionado' ao bin
@Component
public class Startup {

    @Autowired
    private ClienteService service;
    
    /*
    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event){
        var cliente1 = new Cliente();
        cliente1.setNome("Zezinho das galaxia");
        cliente1.setEndereco("Rua laaaaaa");
        cliente1.setDataNascimento(new Date());
        service.save(cliente1);
    }*/
}
