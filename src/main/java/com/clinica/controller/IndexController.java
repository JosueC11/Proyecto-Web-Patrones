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
 * @author Josuu
 */

@Controller
@Slf4j
@RequestMapping("/")
public class IndexController 
{
        @Autowired
    private HttpSession httpSession;
    
    @GetMapping()
    public String mostrarListado(Model model) 
    {
        model.addAttribute("rol", httpSession.getAttribute("rol"));
        return "index";       
    }   
}
