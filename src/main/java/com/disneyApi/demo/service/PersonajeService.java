package com.disneyApi.demo.service;

import com.disneyApi.demo.entities.Personaje;
import com.disneyApi.demo.repositories.PersonajeRepository;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Flor
 */

@Service
public class PersonajeService {
    @Autowired
    private PersonajeRepository personajeRepository;
    
    @Transactional(readOnly = true)
    public List <Personaje> detallePersonajes(){
       return personajeRepository.findAll();
   }
    @Transactional
    public void crearPersonaje(Personaje personaje) {
        Personaje nuevoPersonaje = personaje;
     
      personajeRepository.save(nuevoPersonaje);
        
    }
    @Transactional
    public Personaje editarPersonaje(Personaje personaje) throws Exception{
        Personaje pNuevo = personajeRepository.buscarPersonaje(personaje.getId());
        if (pNuevo != null){
            pNuevo.setNombre(personaje.getNombre());
            pNuevo.setEdad(personaje.getEdad());
            pNuevo.setHistoria(personaje.getHistoria());
            pNuevo.setImagen(personaje.getImagen());
            pNuevo.setPeso(personaje.getPeso());
            return personajeRepository.save(pNuevo);
        } else {
           throw new Exception ("El personaje no se encuentra en la Base de Datos");
        }
    }
    

    
    @Transactional
    public void eliminarPersonaje(Personaje personaje) throws Exception{
        Personaje personajeEliminar = personajeRepository.buscarPersonaje(personaje.getId());
        if (personajeEliminar != null){
             personajeRepository.delete(personajeEliminar);
        } else {
           throw new Exception ("El personaje no se encuentra en la Base de Datos");
        }
    }
 
}
