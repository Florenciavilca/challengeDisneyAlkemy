/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disneyApi.demo.repositories;

import com.disneyApi.demo.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Flor
 */

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String> {
    @Query("SELECT c FROM Usuario c WHERE c.mail = :mail")
    public Usuario buscarPorMail(@Param("mail") String mail);
}
