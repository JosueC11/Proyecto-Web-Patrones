/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clinica.controller;

import com.clinica.domain.Usuario;
import com.clinica.service.CitaService;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Josuu
 */

@Controller
@Slf4j
@RequestMapping("/cita")
public class CitasController 
{

    @Autowired
    private CitaService cS;

    @GetMapping("/listar")
    public String mostrarListado(Model model) {
        var citas = cS.getCitas();
        model.addAttribute("citas", citas);
        return "/cita/listado";
    }
    
    @PostMapping("/listarfecha")
    public String mostrarListadoFecha(@RequestParam("fecha") String fecha, Model model) 
    {
        var articulos = cS.getCitasFecha(fecha);
        model.addAttribute("citas", articulos);
        return "/cita/listado";
    }
    
    @GetMapping("/agendar/{idCita}")
    public String agendarCita(@PathVariable Long idCita, HttpSession httpSession)
    {
        Usuario usuario = (Usuario) httpSession.getAttribute("usuario");
        cS.agendarCita(idCita,usuario.getCorreo());
        return "redirect:/cita/listar";     
    }  
    
    @GetMapping("/eliminar/{idCita}")
    public String eliminarCita(@PathVariable Long idCita) 
    {
        cS.eliminarCita(idCita);
        return "redirect:/cita/listar";
    }
    
    @GetMapping("/listarCitasAgendadas")    
    public String mostrarCitasAgendadas() 
    {
        return"";
    }
}