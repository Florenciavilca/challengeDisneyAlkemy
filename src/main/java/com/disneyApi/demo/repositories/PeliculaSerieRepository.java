package com.disneyApi.demo.repositories;

import com.disneyApi.demo.entities.Pelicula_serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Flor
 */
@Repository
public interface PeliculaSerieRepository extends JpaRepository<Pelicula_serie, String>{
    @Query("SELECT a FROM Pelicula_serie a WHERE a.id= :id")
    public Pelicula_serie buscarPelicula(@Param ("id") String id);
}
