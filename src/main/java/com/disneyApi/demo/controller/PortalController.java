
package com.disneyApi.demo.controller;

import com.disneyApi.demo.ErrorServicio.ErrorServicio;
import com.disneyApi.demo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Flor
 */
@Controller
public class PortalController {

    
    @Autowired
    private UsuarioService usuarioService;

    
    @GetMapping("/")
    public String index(ModelMap modelo) {
        return "index.html";
    }

    @PreAuthorize("hasAnyRole('USUARIO')")
    @GetMapping("/inicio")
    public String inicio() {
        return "disneyApi.html";
    }
    
    @GetMapping("/login")
    public String login(@RequestParam(required = false) String error, @RequestParam(required = false) String logout, ModelMap model) {
        if (error != null) {
            model.put("error", "Usuario o clave incorrectos");
        }
        if (logout != null) {
            model.put("logout", "Ha salido correctamente.");
        }
        return "login.html";
    }
    
    
    @GetMapping("/auth/register")
    public String registro() {
        return "registro.html";
    }
    
    @GetMapping("/auth/login")
    public String log() {
        return "login.html";
    }

    @PostMapping("/auth/register")
     public String registrar(ModelMap modelo, @RequestParam String nombre, @RequestParam String apellido, @RequestParam String mail, @RequestParam String clave1, @RequestParam String clave2) {

        try {
        
            usuarioService.registrar(nombre, apellido, mail, clave1, clave2);
            
        } catch (ErrorServicio ex) {
            modelo.put("error", ex.getMessage());
            modelo.put("nombre", nombre);
            modelo.put("apellido", apellido);
            modelo.put("mail", mail);
            modelo.put("clave1", clave1);
            modelo.put("clave2", clave2);
            return "index.html";
        }

        modelo.put("descripcion", "Tu usuario fue registrado de manera satisfactoria");
        return "index.html";
    }




}
