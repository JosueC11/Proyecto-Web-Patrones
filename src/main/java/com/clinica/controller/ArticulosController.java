/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clinica.controller;

import com.clinica.domain.Articulo;
import com.clinica.domain.Usuario;
import com.clinica.service.ArticuloService;
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

/**
 *
 * @author Josuu
 */

@Controller
@Slf4j
@RequestMapping("/articulo")
public class ArticulosController 
{

    @Autowired
    private ArticuloService aS;
    
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
            var articulos = aS.getArticulos();
            model.addAttribute("articulos", articulos);
            model.addAttribute("articulo",  new Articulo());
            return "/articulo/listado";
        }
    }
    
    @GetMapping("/listarcategoria/{categoria}")
    public String mostrarListado(@PathVariable String categoria, Model model) 
    {
        String usuario = (String) httpSession.getAttribute("correo");
        
        if(usuario == null)
        {
            return "redirect:/usuario/login";
        }
        else
        {
            var articulos = aS.getArticulosCategoria(categoria);
            model.addAttribute("articulos", articulos);
            return "/articulo/listado";
        }
    }
    
    @PostMapping("/agregar")
    public String agregarArticulo(@ModelAttribute Articulo articulo)
    {
        aS.agregarArticulo(articulo);
        return "redirect:/articulo/listar";     
    }  
    
    @GetMapping("/eliminar/{idArticulo}")
    public String eliminarArticulo(@PathVariable Long idArticulo) 
    {
        aS.eliminarArticulo(idArticulo);
        return "redirect:/articulo/listar";
    }
    
    
    //Proximante se va a implementar el carrito de compras 
    
    @GetMapping("/agregarcarrito/{idArticulo}")
    public String agregarCarrito(@PathVariable Long idArticulo) 
    {
        aS.agregarCarrito(idArticulo);
        return "redirect:/articulo/listar";
    }
    
    @GetMapping("/abrircarrito")
    public String abrirCarrito() 
    {
        return "/articulo/carritocompras";
    }
}

