package br.univille.projfso2024b.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.projfso2024b.entity.Pet;
import br.univille.projfso2024b.service.ClienteService;
import br.univille.projfso2024b.service.PetService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;




@Controller
@RequestMapping("/pets")
public class PetController {

    @Autowired
    private PetService service;
    @Autowired
    private ClienteService serviceCliente;

    @GetMapping
    public ModelAndView index(){

        var listaPets = service.getAll();
        
        HashMap<String,Object> dados = new HashMap<>();
                //key ,valor
        dados.put("listaPets",listaPets);
        

        //quem é o html q quero desenhar, como que vou referenciar la no hmtl esses dados, e o dado de verdade
        return new ModelAndView("pet/index",dados); //o que isso faz é pegar o html e jogar os dados la dentro, dados da onde? do service
    }

    @GetMapping("/novo") //rota nova para o /novo
    public ModelAndView novo(){
        var pet = new Pet();// Cliente() ->        cliente
        var listaClientes = serviceCliente.getAll();
        HashMap<String,Object> dados = new HashMap<>();
        dados.put("pet", pet);
        dados.put("listaClientes",listaClientes);
        return new ModelAndView("pet/form", dados); //aqui manda o cliente de cima para o form
    }

    
    @PostMapping()
    public ModelAndView salvar(Pet pet){
        service.save(pet); //aqui eu salvo
        return new ModelAndView("redirect:/pets"); //aqui eu mando pra tela clientes
    }

    //esta dando erro para salvar, o que pode ser?  //o erro é que o form não ta mandando o cliente, ele ta mandando um objeto com o cliente dentro

    @GetMapping("/alterar/{id}") //aqui temos uma url dinamica, vai estar composta pela url base + /alterar + /id
    public ModelAndView alterar(@PathVariable("id") long id){
        // o ("id") nao é obrigatorio
        var pet = service.getById(id); //aqui eu pego o cliente pelo id

        var listaClientes = serviceCliente.getAll();
        HashMap<String,Object> dados = new HashMap<>();
        dados.put("pet", pet);
        dados.put("listaClientes",listaClientes);

        return new ModelAndView("pet/form", dados); //aqui eu mando o cliente para o form
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") long id){
        //obrigado ter um return, se n dá erro, igual ao node
        service.delete(id);
        return new ModelAndView("redirect:/pets");
    }

}
