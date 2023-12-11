package com.clinica.controller;

import com.clinica.domain.Cita;
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
    private CitaService citasService;
    
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
            var citas = citasService.getCitas();
            model.addAttribute("citas", citas);
            model.addAttribute("rol", httpSession.getAttribute("rol"));
            return "/cita/listado";
        }
    }
    
    @PostMapping("/listarfecha")
    public String mostrarListadoFecha(@RequestParam("fecha") String fecha, Model model) 
    {    
        var citas = citasService.getCitasFecha(fecha);
        model.addAttribute("citas", citas);
        model.addAttribute("rol", httpSession.getAttribute("rol"));
        return "/cita/listado";    
    }
    
    @PostMapping("/agendar")
    public String agendarCita(@ModelAttribute Cita citaAgendar)
    {
        String usuario = (String) httpSession.getAttribute("correo");
        String imagen = (String) httpSession.getAttribute("imagen");
        citasService.agendarCita(citaAgendar,usuario,imagen);
        return "redirect:/cita/listar";     
    }  
    
    @GetMapping("/traercita/{idCita}")
    public String citaAgendar(@PathVariable Long idCita, Model model)
    {
        var cita = citasService.getCitaId(idCita);
        model.addAttribute("cita", cita);
        return "/cita/agenda";     
    }  

    
    @GetMapping("/eliminar/{idCita}")
    public String eliminarCita(@PathVariable Long idCita) 
    {
        citasService.eliminarCita(idCita);
        return "redirect:/cita/listar";
    }
    
    @GetMapping("/listarCitasAgendadas")    
    public String mostrarCitasAgendadas(Model model) 
    {
        var citas = citasService.getCitasAgendadas();
        model.addAttribute("citas", citas);
        model.addAttribute("modo", "agendadas");
        return "/cita/listado";
    }
    
    @GetMapping("/terminar/{idCita}")    
    public String terminarCitas(@PathVariable Long idCita) 
    {
        citasService.citaTerminar(idCita);      
        return "redirect:/cita/listarCitasAgendadas";
    }
}