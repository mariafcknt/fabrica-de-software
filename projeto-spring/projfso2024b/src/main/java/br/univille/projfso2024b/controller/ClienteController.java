package br.univille.projfso2024b.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.univille.projfso2024b.entity.Cliente;
import br.univille.projfso2024b.service.ClienteService;
import ch.qos.logback.core.model.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@Controller
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @GetMapping
    public ModelAndView index(){

        var listaClientes = service.getAll();
        //quem é o html q quero desenhar, como que vou referenciar la no hmtl esses dados, e o dado de verdade
        return new ModelAndView("cliente/index","listaClientes",listaClientes); //o que isso faz é pegar o html e jogar os dados la dentro, dados da onde? do service
    }

    @GetMapping("/novo") //rota nova para o /novo
    public ModelAndView novo(){
        var cliente = new Cliente();// Cliente() ->        cliente
        return new ModelAndView("cliente/form", "cliente", cliente); //aqui man do o cliente de cima para o form
    }

    
    @PostMapping()
    public ModelAndView salvar(Cliente cliente){
        service.save(cliente); //aqui eu salvo
        return new ModelAndView("redirect:/clientes"); //aqui eu mando pra tela clientes
    }

    //esta dando erro para salvar, o que pode ser?  //o erro é que o form não ta mandando o cliente, ele ta mandando um objeto com o cliente dentro


}
