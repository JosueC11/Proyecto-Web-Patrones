package com.clinica.controller;

import com.clinica.domain.Usuario;
import com.clinica.service.UsuarioService;
import jakarta.servlet.http.HttpSession;
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
public class UsuarioSesionController {

    @Autowired
    private UsuarioService us;

    @Autowired
    private HttpSession httpSession;

    @GetMapping("/registro")
    public String inicioRegistro(Model model) {
        Usuario usuario = new Usuario();
        model.addAttribute("usuario", usuario);
        model.addAttribute("rol", httpSession.getAttribute("rol"));
        return "/usuario/registrarse";
    }

    @PostMapping("/registrar")
    public String registrarUsuario(@ModelAttribute Usuario usuario,Model model) {
        
        Usuario usuarioRegistrado = us.getUsuarioRegistro(usuario.getCorreo());

        if (usuarioRegistrado == null) 
        {
            us.registrarUsuario(usuario);
            model.addAttribute("rol", httpSession.getAttribute("rol"));         
            return "redirect:/usuario/login";
        }
        else
        {
            model.addAttribute("error", "Usuario ya registrado!!, Intente con otro correo");
            return "/usuario/registrarse";
        }
    }

    @GetMapping("/login")
    public String inicioLogin(Model model) {
        Usuario usuario = new Usuario();
        model.addAttribute("usuario", usuario);
        model.addAttribute("rol", httpSession.getAttribute("rol"));
        return "/usuario/login";
    }

    @PostMapping("/loguear")
    public String loguearUsuario(@ModelAttribute Usuario usuario, Model model) {

        Usuario usuarioRegistrado = us.getUsuarioRegistro(usuario.getCorreo());

        if (usuarioRegistrado != null) {
            if (usuarioRegistrado.getContrasena().equals(usuario.getContrasena())) {
                model.addAttribute("bienvenida", "¡Bienvenido, " + usuarioRegistrado.getNombre() + "!");
                httpSession.setAttribute("correo", usuario.getCorreo());
                httpSession.setAttribute("rol", usuarioRegistrado.getIdRol());
                return "redirect:/";
            }
        }
        model.addAttribute("error", "Correo o contraseña incorrectos");
        return "/usuario/login";
    }

    @GetMapping("/perfil")
    public String perfilUsuario(Model model) {
        String usuario = (String) httpSession.getAttribute("correo");

        if (usuario == null) {
            return "redirect:/usuario/login";
        } else 
        {
            var mostrar = us.getUsuarioRegistro(usuario);
            model.addAttribute("usuario", mostrar);
            model.addAttribute("usuarioNuevo", new Usuario());
            model.addAttribute("rol", httpSession.getAttribute("rol"));
            return "/usuario/listado";
        }
    }
    
    @PostMapping("/editar")
    public String editarUsuario(@ModelAttribute Usuario usuario) 
    {
        int usuarioRol = (int) httpSession.getAttribute("rol");
        usuario.setIdRol(usuarioRol);
        us.editarUsuario(usuario);
        return "redirect:/usuario/perfil";
    }
       
    @PostMapping("/informacion")
    public String informacionUsuario() {
        return "index";
    }
}