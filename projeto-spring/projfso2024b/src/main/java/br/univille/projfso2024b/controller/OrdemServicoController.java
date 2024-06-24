package br.univille.projfso2024b.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.univille.projfso2024b.entity.OrdemServico;
import br.univille.projfso2024b.service.OrdemServicoService;

import br.univille.projfso2024b.service.PetService;

@Controller
@RequestMapping("/ordens")
public class OrdemServicoController {
    @Autowired
    private OrdemServicoService service;

    @Autowired
    private PetService servicePet;

    @GetMapping()
    public ModelAndView index() {
        var listaOrdens = service.getAll();

        HashMap<String, Object> dados = new HashMap<>();

        dados.put("listaOrdens", listaOrdens);

        return new ModelAndView("ordens/form", dados);
    }

    @PostMapping()
    public ModelAndView save(OrdemServico ordem){
        service.save(ordem);
        return new ModelAndView("redirect:/ordens");
    }

    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") long id){
        var ordem = service.getById(id);
        var listaPets = servicePet.getAll();
        HashMap<String,Object> dados = new HashMap<>();
        dados.put("ordem", ordem);
        dados.put("listaPets",listaPets);
        return new ModelAndView("ordens/form", dados);
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") long id){
        service.delete(id);
        return new ModelAndView("redirect:/ordens");
    }

}
