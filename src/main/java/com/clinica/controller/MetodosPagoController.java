/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clinica.controller;

import com.clinica.domain.MetodoPago;
import com.clinica.service.MetodoPagoService;
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
    private MetodoPagoService mps;
        
    @GetMapping("/listar")
    public String mostrarListado(Model model) {
        var metodos = mps.getMetodosPagos("OscarCañellas@gmail.com");
        model.addAttribute("metodos", metodos);
        model.addAttribute("metodoPago",  new MetodoPago());
        return "/metodopago/listado";
    }
   
    
    @PostMapping("/agregar")
    public String agregarMedotoPago(@ModelAttribute MetodoPago metodoPago)
    {
        mps.agregarMetodoPago(metodoPago);
        return "redirect:/metodopago/listar";     
    }  
    
    @GetMapping("/eliminar/{numeroTarjeta}")
    public String eliminarArticulo(@PathVariable String numeroTarjeta) 
    {
        mps.eliminarMetodoPago(numeroTarjeta);
        return "redirect:/metodopago/listar";
    }
}
