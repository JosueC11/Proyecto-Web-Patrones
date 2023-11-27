/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
@RequestMapping("/historialClinico")
public class HistorialClinicoController 
{
    @Autowired
    private HttpSession httpSession;
    
    @GetMapping("/listar")
    public String mostrarListado(Model model) 
    {
        model.addAttribute("rol", httpSession.getAttribute("rol"));
        return "/historialClinico/listado";       
    }
}
