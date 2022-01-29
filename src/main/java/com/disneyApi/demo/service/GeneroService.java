package com.disneyApi.demo.service;

import com.disneyApi.demo.entities.Genero;
import com.disneyApi.demo.repositories.GeneroRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Flor
 */
@Service
public class GeneroService {
    @Autowired
    private GeneroRepository generoRepository;

    public List<Genero> detalleGenero(){
       return generoRepository.findAll();
   }
    @Transactional
    public void crearGenero(Genero genero) {
        Genero nuevoGenero = genero;
        generoRepository.save(nuevoGenero);
        
    }
    @Transactional
    public void eliminarGenero(Genero genero) {
        Genero nuevoGenero = genero;
        generoRepository.deleteById(nuevoGenero.getId());
        
    }
    
    public Genero buscarGeneroNombre(String nombre){
        
        Genero genero = generoRepository.buscarPorNombre(nombre);
        return genero;
    }
    @Transactional
    public Genero editarGenero(Genero genero) throws Exception{
        Genero generoModificado = generoRepository.buscarPorNombre(genero.getNombre());
        if (generoModificado != null){
            generoModificado.setImagen(genero.getImagen());
            generoModificado.setNombre(genero.getNombre());
            generoModificado.setPeliculas(genero.getPeliculas());

            return generoRepository.save(generoModificado);
        } else {
           throw new Exception ("El genero seleccionado no se encuentra en la Base de Datos");
        }
    }
}
