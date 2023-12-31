package com.clinica.controller;

import com.clinica.domain.MetodoPago;
import com.clinica.service.MetodoPagoService;
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

@Controller
@Slf4j
@RequestMapping("/metodopago")
public class MetodosPagoController{
    
    @Autowired
    private MetodoPagoService metodoPagoService;
    
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
            model.addAttribute("rol", httpSession.getAttribute("rol"));
            var metodos = metodoPagoService.getMetodosPagos(usuario);
            model.addAttribute("metodos", metodos);
            model.addAttribute("metodoPago",  new MetodoPago());
            return "/metodopago/listado";
        }
    }
   
    
    @PostMapping("/agregar")
    public String agregarMedotoPago(@ModelAttribute MetodoPago metodoPago)
    {
        String usuario = (String) httpSession.getAttribute("correo");
        metodoPagoService.agregarMetodoPago(metodoPago, usuario);
        metodoPagoService.establecerMetodoPredeterminado(metodoPago.getNumeroTarjeta());
        return "redirect:/metodopago/listar";     
    }  
    
    @GetMapping("/eliminar/{numeroTarjeta}")
    public String eliminarArticulo(@PathVariable String numeroTarjeta) 
    {
        metodoPagoService.eliminarMetodoPago(numeroTarjeta);
        return "redirect:/metodopago/listar";
    }
    
    @GetMapping("/establecerPredeterminado/{numeroTarjeta}")
    public String establecerPredeterminado(@PathVariable String numeroTarjeta) 
    {
        metodoPagoService.establecerMetodoPredeterminado(numeroTarjeta);
        return "redirect:/metodopago/listar";
    }
}
