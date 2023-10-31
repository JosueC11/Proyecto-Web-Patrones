/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clinica.controller;

import com.clinica.service.CitaService;
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
@RequestMapping("/agenda")
public class AgendaController 
{
    @Autowired
    private CitaService cS;

    @GetMapping("/listar")
    public String mostrarListado(Model model) 
    {
        var citasAgendadas = cS.getCitasUsuario("OscarCañellas@gmail.com");
        model.addAttribute("agenda", citasAgendadas);
        return "/agenda/listado";
    }
    
}
