/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clinica.controller;

import com.clinica.service.MetodoPagoService;
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
@RequestMapping("/metodopago")
public class MetodosPagoController 
{

    @Autowired
    private MetodoPagoService mps;

    @GetMapping("/listado")
    public String inicio(Model model) {
        var metodos = mps.getMetodosPagos("123456789");
        model.addAttribute("metodos", metodos);
        return "/metodopago/listado";
    }
   
}
