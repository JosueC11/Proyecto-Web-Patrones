package com.clinica.controller;

import com.clinica.domain.Resena;
import com.clinica.service.ResenaService;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Josuu
 */

@Controller
@Slf4j
@RequestMapping("/resena")
public class ResenasController 
{
    @Autowired
    private ResenaService resenaService;
    
    @Autowired
    private HttpSession httpSession;

    @GetMapping("/listar")
    public String mostrarListado(Model model) 
    {
        String usuario = (String) httpSession.getAttribute("correo");
        
        if(usuario == null)
        {
            return "redirect:/usuario/login";
        }
        else
        {
            var resenas = resenaService.getResenas();
            model.addAttribute("resenas", resenas);
            model.addAttribute("resena",  new Resena());
            model.addAttribute("rol", httpSession.getAttribute("rol"));
            return "/resena/listado";
        }
    }
    
    @GetMapping("/listarUser")
    public String mostrarListadoUser(Model model) 
    {    
        String usuario = (String) httpSession.getAttribute("correo");
        var resenas = resenaService.getResenasUser(usuario);
        model.addAttribute("resenas", resenas);
        model.addAttribute("resena",  new Resena());
        model.addAttribute("rol", httpSession.getAttribute("rol"));
        model.addAttribute("modo", "listuser");
        model.addAttribute("correo", httpSession.getAttribute("correo"));
        for(Resena r: resenas)
        {
            System.out.print(r.getCorreo());
        }
        return "/resena/listado";    
    }
    
    @PostMapping("/agregar")
    public String agendarResna(@ModelAttribute Resena resenaAgregar)
    {
        String usuario = (String) httpSession.getAttribute("correo");
        String imagen = (String) httpSession.getAttribute("imagen");
        resenaService.agregarResena(resenaAgregar,usuario,imagen);
        return "redirect:/resena/listar";     
    }  
    
    @GetMapping("/eliminar/{idResena}")
    public String eliminarCita(@PathVariable Long idResena) 
    {
        resenaService.eliminarResena(idResena);
        return "redirect:/resena/listar";
    }  
}
