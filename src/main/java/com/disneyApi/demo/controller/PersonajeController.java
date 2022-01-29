package com.disneyApi.demo.controller;

import com.disneyApi.demo.entities.Personaje;
import com.disneyApi.demo.service.PersonajeService;
import java.util.List;
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
@RequestMapping("/personajes")
public class PersonajeController {
    @Autowired
    private PersonajeService personajeService;
    
    @GetMapping("/create")
    public String crearPersonaje(ModelMap modelo) {
        Personaje personaje = new Personaje();
        modelo.addAttribute("personaje", personaje);

        return "personajes.html";
    } 
    @PostMapping("/guardar")
    public String create(@ModelAttribute Personaje personaje) throws Exception {
        personajeService.crearPersonaje(personaje);

        return "personajes";
    }
    
    @PostMapping("/update")
    public String update(@ModelAttribute Personaje personaje)throws Exception{
        personajeService.editarPersonaje(personaje);

        return "personaje";
    }
    
    @PostMapping("/delete")
    public String delete(@ModelAttribute Personaje personaje) throws Exception {
        personajeService.editarPersonaje(personaje);

        return "index";
    }
    
    @GetMapping("/characters")
    public String listadoPersonaje(ModelMap modelo){
        
        List<Personaje> listadoPersonajes = personajeService.detallePersonajes();
        modelo.addAttribute("listaPersonajes", listadoPersonajes);
        
        return "listadoPersonaje.html";
    }
    
    @GetMapping("/detalle")
    public String detallePersonaje(ModelMap modelo){
        
        List<Personaje> listadoPersonaje = personajeService.detallePersonajes();
        modelo.addAttribute("listadoPersonaje", listadoPersonaje);
        
        return "detallePersonaje.html";
    }
    
 }
