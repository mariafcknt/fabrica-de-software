package br.univille.projfso2024b.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.univille.projfso2024b.service.ClienteService;

import org.springframework.web.bind.annotation.GetMapping;



@Controller
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @GetMapping
    public ModelAndView index(){

        var listaClientes = service.getAll();
        //quem é o html q quero desenhar, como que vou referenciar la no hmtl esses dados, e o dado de verdade
        return new ModelAndView("cliente/index","listaClientes",listaClientes);
    }
}
