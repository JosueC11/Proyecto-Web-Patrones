package com.clinica.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Josuu
 */
@Controller
@RequestMapping("")
public class IndexController 
{
    @GetMapping("")
    public String mostrarIndex()
    {      
        return "/layout/plantilla";       
    }   
}
