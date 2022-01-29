package com.disneyApi.demo.controller;

import com.disneyApi.demo.entities.Genero;
import com.disneyApi.demo.entities.Pelicula_serie;
import com.disneyApi.demo.entities.Personaje;
import com.disneyApi.demo.service.GeneroService;
import com.disneyApi.demo.service.PeliculaSerieService;
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
@RequestMapping("/peliculaSerie")
public class PeliculaSerieController {
 @Autowired
    private PeliculaSerieService peliculaSerieService;
     @Autowired
    private PersonajeService personajeService;
     @Autowired
     private GeneroService generoService;
    
    @GetMapping("/create")
    public String crearPeliculaSerie(ModelMap modelo) {
        Pelicula_serie peliculaSerie = new Pelicula_serie();
        modelo.addAttribute("peliculaSerie", peliculaSerie);
        List<Personaje> listaPersonajes = personajeService.detallePersonajes();
        modelo.addAttribute("personajes", listaPersonajes);
        List<Genero> listaGeneros = generoService.detalleGenero();
        modelo.addAttribute("generos", listaGeneros);
        return "movieSerie.html";
    } 
    @PostMapping("/save")
    public String create(@ModelAttribute Pelicula_serie peliculaSerie) throws Exception {
        peliculaSerieService.crearPeliculaSerie(peliculaSerie);

        return "index";
    }
 @GetMapping("/movies")
    public String listadoPeliculaSerie(ModelMap modelo){
        
        List<Pelicula_serie> listadoPeliculaSerie = peliculaSerieService.detallePeliculaSerie();
        modelo.addAttribute("listadoPeliculas", listadoPeliculaSerie);
        
        return "listadoPeliculas.html";
    }
    
    @GetMapping("/detalle")
    public String detallePeliculaSerie(ModelMap modelo){
        
        List<Pelicula_serie> listadoPeliculaSerie = peliculaSerieService.detallePeliculaSerie();
        modelo.addAttribute("listadoPeliculas", listadoPeliculaSerie);
        
        return "detallePeliculas.html";
    }
    @PostMapping("/update")
    public String update(@ModelAttribute Pelicula_serie peliculaSerie)throws Exception{
        peliculaSerieService.editarPeliculaSerie(peliculaSerie);

        return "index";
    }
    
    @PostMapping("/delete")
    public String delete(@ModelAttribute Pelicula_serie peliculaSerie)throws Exception{
        peliculaSerieService.editarPeliculaSerie(peliculaSerie);

        return "index";
    }
}
