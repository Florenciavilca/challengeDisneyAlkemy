
package com.disneyApi.demo.controller;

import com.disneyApi.demo.entities.Genero;
import com.disneyApi.demo.service.GeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Flor
 */
@Controller
@RequestMapping("/genero")
public class GeneroController {

    @Autowired
    private GeneroService generoService;

    @GetMapping("/create")
    public String crearGenero(ModelMap modelo) {
        Genero genero = new Genero();
        modelo.addAttribute("genero", genero);

        return "genero.html";
    }

    @PostMapping("/save")
    public String ingresar(@ModelAttribute Genero genero) throws Exception {
        generoService.crearGenero(genero);

        return "index";
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute Genero genero) throws Exception {
        generoService.eliminarGenero(genero);

        return "index";
    }
    @PostMapping("/update")
    public String update(@ModelAttribute Genero genero) throws Exception{
        
    generoService.editarGenero(genero);
    
    return "index";
    }
}
