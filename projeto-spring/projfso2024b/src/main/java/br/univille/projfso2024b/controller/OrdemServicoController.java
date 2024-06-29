package br.univille.projfso2024b.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.projfso2024b.entity.OrdemServico;
import br.univille.projfso2024b.service.OrdemServicoService;
import br.univille.projfso2024b.service.PetService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;




@Controller
@RequestMapping("/ordens")
public class OrdemServicoController {

    @Autowired
    private OrdemServicoService service;
    @Autowired
    private PetService servicePet;

    @GetMapping
    public ModelAndView index(){

        var listaOrdens = service.getAll();
        
        HashMap<String,Object> dados = new HashMap<>();
                //key ,valor
        dados.put("listaOrdens",listaOrdens);
        

        //quem é o html q quero desenhar, como que vou referenciar la no hmtl esses dados, e o dado de verdade
        return new ModelAndView("ordemservico/index",dados); //o que isso faz é pegar o html e jogar os dados la dentro, dados da onde? do service
    }

    @GetMapping("/novo") //rota nova para o /novo
    public ModelAndView novo(){
        var ordemServico = new OrdemServico();// Cliente() ->        cliente
        var listaPets = servicePet.getAll();
        HashMap<String,Object> dados = new HashMap<>();
        dados.put("ordem", ordemServico);
        dados.put("listaPets",listaPets);
        return new ModelAndView("ordemservico/form", dados); //aqui manda o cliente de cima para o form
    }

    
    @PostMapping()
    public ModelAndView salvar(OrdemServico ordemServico){
        service.save(ordemServico); //aqui eu salvo
        return new ModelAndView("redirect:/ordens"); //aqui eu mando pra tela clientes
    }

    //esta dando erro para salvar, o que pode ser?  //o erro é que o form não ta mandando o cliente, ele ta mandando um objeto com o cliente dentro

    @GetMapping("/alterar/{id}") //aqui temos uma url dinamica, vai estar composta pela url base + /alterar + /id
    public ModelAndView alterar(@PathVariable("id") long id){
        // o ("id") nao é obrigatorio
        var ordemServico = service.getById(id); //aqui eu pego o cliente pelo id

        var listaPets = servicePet.getAll();
        HashMap<String,Object> dados = new HashMap<>();
        dados.put("ordemServico", ordemServico);
        dados.put("listaPets",listaPets);
        return new ModelAndView("ordemservico/form", dados); //aqui manda o cliente de cima para o form
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") long id){
        //obrigado ter um return, se n dá erro, igual ao node
        service.delete(id);
        return new ModelAndView("redirect:/ordens");
    }

}

