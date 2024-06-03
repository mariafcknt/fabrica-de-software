package br.univille.projfso2024b.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.projfso2024b.entity.Pet;
import br.univille.projfso2024b.service.ClienteService;
import br.univille.projfso2024b.service.PetService;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/pets")
public class PetController {

    @Autowired
    private PetService service;

    @Autowired
    private ClienteService serviceCliente;
    
    @GetMapping
    public ModelAndView index() {
      // var pets = service.getAll();
        var listaPets= service.getAll();
        HashMap<String, Object> dados = new HashMap<>();

        dados.put("listaPets", listaPets);
       // dados.put("pets", pets);
        //html, referência/apelido do dado no html, dado
        return new ModelAndView("pet/index", dados);
    }

    @GetMapping("/novo")
    public ModelAndView novo(){
        var pet = new Pet();
        var listaClientes = serviceCliente.getAll();
        HashMap<String, Object> dados = new HashMap<>();
        dados.put("pet", pet);
        dados.put("listaClientes", listaClientes);
        return new ModelAndView("pet/form", dados);
    }

    @PostMapping()
    public ModelAndView save(Pet pet){
        service.save(pet);
        return new ModelAndView("redirect:/pets");
    }

    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") long id){
        var pet = service.getById(id);
        var listaClientes = serviceCliente.getAll();
        HashMap<String,Object> dados = new HashMap<>();
        dados.put("pet", pet);
        dados.put("listaClientes",listaClientes);
        return new ModelAndView("pet/form", dados);
    }


    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") long id){
        service.delete(id);
        return new ModelAndView("redirect:/pets");
    }
}
