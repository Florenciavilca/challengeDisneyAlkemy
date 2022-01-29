package com.disneyApi.demo.service;

import com.disneyApi.demo.entities.Pelicula_serie;
import com.disneyApi.demo.repositories.PeliculaSerieRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Flor
 */

@Service
public class PeliculaSerieService {
    @Autowired
    private PeliculaSerieRepository peliculaSerieRepository;
    

    
    public List <Pelicula_serie> detallePeliculaSerie(){
       return peliculaSerieRepository.findAll();
   }
    

    @Transactional
    public void crearPeliculaSerie(Pelicula_serie peliculaSerie) {
        Pelicula_serie nuevaPeliculaSerie = peliculaSerie;
        peliculaSerieRepository.save(nuevaPeliculaSerie);
    }
    
    
    @Transactional
    public Pelicula_serie editarPeliculaSerie(Pelicula_serie peliculaSerie) throws Exception{
        Pelicula_serie peliculaModificada = peliculaSerieRepository.buscarPelicula(peliculaSerie.getId());
        if (peliculaModificada != null){
            peliculaModificada.setCalificacion(peliculaSerie.getCalificacion());
            peliculaModificada.setFechaCreacion(peliculaSerie.getFechaCreacion());
            peliculaModificada.setGenero(peliculaSerie.getGenero());
            peliculaModificada.setImagen(peliculaSerie.getImagen());
            peliculaModificada.setTitulo(peliculaSerie.getTitulo());
            peliculaModificada.setPersonaje(peliculaSerie.getPersonaje());
            return peliculaSerieRepository.save(peliculaModificada);
        } else {
           throw new Exception ("La pelicula/serie no se encuentra en la Base de Datos");
        }
    }

    

    

@Transactional
    public void eliminarPeliculaSerie(Pelicula_serie peliculaSerie) throws Exception{
        Pelicula_serie peliculaSerieEliminar = peliculaSerieRepository.buscarPelicula(peliculaSerie.getId());
        if (peliculaSerieEliminar != null){
             peliculaSerieRepository.delete(peliculaSerieEliminar);
        } else {
           throw new Exception ("El personaje no se encuentra en la Base de Datos");
        }
    }
}
