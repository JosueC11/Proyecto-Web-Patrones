package com.clinica.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Dennis
 */

@Controller
@RequestMapping("/usuario")
public class UsuarioRegistroController {
    
    @GetMapping("/registro")
    public String inicioRegistro() {
        return "/usuario/registro";
    }
}
