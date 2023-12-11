package com.clinica.controller;

import com.clinica.service.CitaService;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Josuu
 */

@Controller
@Slf4j
@RequestMapping("/historial")
public class HistorialController
{
    @Autowired
    private CitaService citaService;

    @GetMapping("/listar")
    public String mostrarHistorial(HttpSession httpSession, Model model) 
    {
        String usuario = (String) httpSession.getAttribute("correo");
        
        if(usuario == null)
        {
            return "redirect:/usuario/login";
        }
        else
        {
            model.addAttribute("rol", httpSession.getAttribute("rol"));
            model.addAttribute("imagen", httpSession.getAttribute("imagen"));
            var historial = citaService.getHistorial(usuario);
            model.addAttribute("historial", historial);
            return "/historial/listado";           
        }
    }   
}
