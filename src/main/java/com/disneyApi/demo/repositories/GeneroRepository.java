package com.disneyApi.demo.repositories;

import com.disneyApi.demo.entities.Genero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Flor
 */
@Repository
public interface GeneroRepository extends JpaRepository<Genero, String>{
    @Query("SELECT c FROM Usuario c WHERE c.nombre = :nombre")
    public Genero buscarPorNombre(@Param("nombre") String nombre);
}
