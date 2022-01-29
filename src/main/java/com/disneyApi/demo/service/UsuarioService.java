/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disneyApi.demo.service;

import com.disneyApi.demo.ErrorServicio.ErrorServicio;
import com.disneyApi.demo.entities.Usuario;
import com.disneyApi.demo.enums.Rol;
import com.disneyApi.demo.repositories.UsuarioRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author Flor
 */
@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional
    public void registrar(String nombre, String apellido, String mail, String clave1, String clave2) throws ErrorServicio{

        validar(nombre, apellido, mail, clave1, clave2);

        Usuario usuario = new Usuario();
        usuario.setNombre(nombre);
        usuario.setApellido(apellido);
        usuario.setMail(mail);
        usuario.setRol(Rol.USUARIO);

        String encriptada = new BCryptPasswordEncoder().encode(clave1);
        usuario.setClave1(encriptada);
        usuarioRepository.save(usuario);

    }


    public void validar(String nombre, String apellido, String mail, String clave1, String clave2) throws ErrorServicio {

        if (nombre == null || nombre.isEmpty()) {
            throw new ErrorServicio("El nombre del usuario no puede ser nulo");
        }

        if (apellido == null || apellido.isEmpty()) {
            throw new ErrorServicio("El apellido del usuario no puede ser nulo");
        }

        if (mail == null || mail.isEmpty()) {
            throw new ErrorServicio("El mail no puede ser nulo");
        }

        if (clave1 == null || clave1.isEmpty() || clave1.length() <= 5) {
            throw new ErrorServicio("La clave del usuario no puede ser nula y tiene que tener mas de cinco digitos");
        }
        if (!clave1.equals(clave2)) {
            throw new ErrorServicio("Las claves deben ser iguales");
        }

        
    }


    @Override
    public UserDetails loadUserByUsername(String mail) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.buscarPorMail(mail);
        
        if (usuario != null) {
            List<GrantedAuthority> permisos = new ArrayList<>();
            
                              
            GrantedAuthority p1 = new SimpleGrantedAuthority("ROLE_"+usuario.getRol());
            permisos.add(p1);
         
      
            ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
            HttpSession session = attr.getRequest().getSession(true);
            session.setAttribute("usuariosession", usuario);

            User user = new User(usuario.getMail(), usuario.getClave1(), permisos);
            return user;

        } else {
            return null;
        }

    }
    
    @Transactional(readOnly=true)
    public Usuario buscarPorId(String id) throws ErrorServicio {

        Optional<Usuario> respuesta = usuarioRepository.findById(id);
        if (respuesta.isPresent()) {

            Usuario usuario = respuesta.get();
            return usuario;
        } else {

            throw new ErrorServicio("No se encontró el usuario solicitado");
        }

    }
    @Transactional(readOnly=true)
    public List<Usuario> todosLosUsuarios(){
 
        return usuarioRepository.findAll();
        
    }
    
 
}
