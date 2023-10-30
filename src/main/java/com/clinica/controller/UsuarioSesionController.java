package com.clinica.controller;

import com.clinica.domain.UsuarioRegistro;
import com.clinica.service.UsuarioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Dennis
 */

@Controller
@Slf4j
@RequestMapping("/usuario")
public class UsuarioSesionController 
{
    @Autowired
    private UsuarioService us;
    
    @GetMapping("/registro")
    public String inicioRegistro(Model model) {
        UsuarioRegistro usuario = new UsuarioRegistro();
        model.addAttribute("usuario", usuario);
        return "/usuario/registrarse";
    }

    @PostMapping("/registrar")
    public String registrarUsuario(@ModelAttribute UsuarioRegistro usuario) {
        us.registrarUsuario(usuario);
        return "index";
    }   
}
