package com.disneyApi.demo.repositories;

import com.disneyApi.demo.entities.Personaje;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Flor
 */
@Repository
public interface PersonajeRepository extends JpaRepository<Personaje, String> {

    @Query("SELECT a FROM Personaje a WHERE a.id= :id")
    public Personaje buscarPersonaje(@Param("id") String id);

    @Query("SELECT a.nombre FROM Personaje a WHERE a.nombre like :peso")
    public List<Personaje> buscarPersonajePorPeso(@Param("peso") String peso);

    @Query("SELECT a.nombre FROM Personaje a WHERE a.edad like :edad")
    public List<Personaje> buscarPersonajePorEdad(@Param("edad") String edad);

    @Query( "SELECT a.nombre, b.pelicula_serie_id FROM Personaje a INNER JOIN Pelicula_serie_personaje b ON a.id= b.personaje_id WHERE b.pelicula_serie_id LIKE :idMovie" )
    public List<Personaje> buscarPersonajePorPelicula(@Param("idMovie") String id);

}
