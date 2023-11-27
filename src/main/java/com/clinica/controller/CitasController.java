/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clinica.controller;

import com.clinica.domain.Cita;
import com.clinica.domain.Usuario;
import com.clinica.service.CitaService;
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
            var citas = cS.getCitas();
            model.addAttribute("citas", citas);
            model.addAttribute("rol", httpSession.getAttribute("rol"));
            return "/cita/listado";
        }
    }
    
    @PostMapping("/listarfecha")
    public String mostrarListadoFecha(@RequestParam("fecha") String fecha, Model model) 
    {    
        var citas = cS.getCitasFecha(fecha);
        model.addAttribute("citas", citas);
        return "/cita/listado";    
    }
    
    @PostMapping("/agendar")
    public String agendarCita(@ModelAttribute Cita citaAgendar)
    {
        String usuario = (String) httpSession.getAttribute("correo");
        cS.agendarCita(citaAgendar,usuario);
        return "redirect:/cita/listar";     
    }  
    
    @GetMapping("/traercita/{idCita}")
    public String agendarCita(@PathVariable Long idCita, Model model)
    {
        var cita = cS.getCitaId(idCita);
        model.addAttribute("cita", cita);
        return "/cita/agenda";     
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