
package com.disneyApi.demo.controller;

import com.disneyApi.demo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Flor
 */
@Controller
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;
  }
