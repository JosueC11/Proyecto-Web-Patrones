package com.clinica.controller;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Dennis
 */
@Controller
@Slf4j
@RequestMapping("/sobreNosotros")
public class SobreNosotrosController {
  
    @Autowired
    private HttpSession httpSession;
    @GetMapping("/info")
    public String mostrarListado(Model model) 
    {
        model.addAttribute("rol", httpSession.getAttribute("rol"));
        return "/sobrenosotros/listado";  
    }
}
