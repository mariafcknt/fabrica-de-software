package br.univille.projfso2024b.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/pets")
public class PetController {

    @GetMapping
    public ModelAndView index() {
        var msg = "eu não acredito";
        return new ModelAndView("pet/index", "apelido", msg);
    }
}
