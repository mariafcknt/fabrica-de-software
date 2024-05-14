package br.univille.projfso2024b.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.projfso2024b.entity.Pet;
import br.univille.projfso2024b.service.PetService;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/pets")
public class PetController {

    @Autowired
    private PetService service;
    
    @GetMapping
    public ModelAndView index() {
        var listaPets = service.getAll();
        //html, referência/apelido do dado no html, dado
        return new ModelAndView("pet/index", "listaPets", listaPets);
    }

    @GetMapping("/novo")
    public ModelAndView novo(){
        var pet = new Pet();
        return new ModelAndView("pet/form","pet", pet);
    }

    @PostMapping()
    public ModelAndView save(Pet pet){
        service.save(pet);
        return new ModelAndView("redirect:/pets");
    }

    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") long id){
        var pet = service.getById(id);
        return new ModelAndView("pet/form", "pet", pet);
    }


    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") long id){
        service.delete(id);
        return new ModelAndView("redirect:/pets");
    }
}
