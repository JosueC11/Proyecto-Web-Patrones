package com.clinica.controller;

import com.clinica.domain.Usuario;
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
        Usuario usuario = new Usuario();
        model.addAttribute("usuario", usuario);
        return "/usuario/registrarse";
    }
    
    @PostMapping("/registrar")
    public String registrarUsuario(@ModelAttribute Usuario usuario) {
        us.registrarUsuario(usuario);
        return "index";
    }   
    
    @GetMapping("login")
    public String inicioLogin(Model model)
    {
        Usuario usuario = new Usuario();
        model.addAttribute("usuario", usuario);
        return "/usuario/login";
    }

    @PostMapping("/loguear")
    public String loguearUsuario(@ModelAttribute Usuario usuario, Model model) {
        Usuario usuarioRegistrado = us.getUsuarioRegistro(usuario.getCorreo());
        if (usuarioRegistrado != null) {
            if (usuarioRegistrado.getContrasena().equals(usuario.getContrasena())) { 
                model.addAttribute("bienvenida", "¡Bienvenido, " + usuarioRegistrado.getNombre() + "!");
                return "index";
            }
        }
        model.addAttribute("error", "Correo o contraseña incorrectos");
        return "/usuario/login";
    }
    
    @GetMapping("/perfil")
    public String perfilUsuario(Model model) {
        Usuario usuario = new Usuario();
        model.addAttribute("usuario", usuario);
        return "/usuario/perfilUsuario";
    }
    
    @PostMapping("/informacion")
    public String informacionUsuario() {
        return "index";
    }
}
