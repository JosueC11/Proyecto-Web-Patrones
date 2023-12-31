package com.clinica.controller;

import com.clinica.domain.Articulo;
import com.clinica.service.ArticuloService;
import com.clinica.service.FirebaseStorageService;
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
import org.springframework.web.multipart.MultipartFile;

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
    private ArticuloService articuloService;
    
    @Autowired
    private HttpSession httpSession;
    
    @Autowired
    private FirebaseStorageService firebaseStorageService;

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
            var articulos = articuloService.getArticulos();
            model.addAttribute("articulos", articulos);
            model.addAttribute("rol", httpSession.getAttribute("rol"));
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
            var articulos = articuloService.getArticulosCategoria(categoria);
            model.addAttribute("articulos", articulos);
            model.addAttribute("rol", httpSession.getAttribute("rol"));
            model.addAttribute("articulo",  new Articulo());
            return "/articulo/listado";
        }
    }
    
    @PostMapping("/agregar")
    public String agregarArticulo(@ModelAttribute Articulo articulo,@RequestParam("imagenFile") MultipartFile imagenFile)
    {
        if (!imagenFile.isEmpty()) 
        {
            articuloService.agregarArticulo(articulo);
            articulo.setImagen(
                    firebaseStorageService.cargaImagen(
                            imagenFile,
                            "Articulo",
                            articulo.getIdArticulo()));
        }      
        articuloService.agregarArticulo(articulo);
        return "redirect:/articulo/listar";     
    }  
    
    @GetMapping("/eliminar/{idArticulo}")
    public String eliminarArticulo(@PathVariable Long idArticulo) 
    {
        articuloService.eliminarArticulo(idArticulo);
        return "redirect:/articulo/listar";
    }
    
    
    //Proximante se va a implementar el pago con factura
    
    @GetMapping("/agregarcarrito/{idArticulo}")
    public String agregarCarrito(@PathVariable Long idArticulo) 
    {
        String usuario = (String) httpSession.getAttribute("correo");
        
        articuloService.agregarCarrito(idArticulo,usuario);
        return "redirect:/articulo/listar";
    }
    
    @GetMapping("/abrircarrito")
    public String abrirCarrito(Model model) 
    {
        String usuario = (String) httpSession.getAttribute("correo");
        var articulosCarrito = articuloService.getCarrito(usuario);
        model.addAttribute("articulosCarrito", articulosCarrito);
        return "/articulo/carritocompras";
    }
    
    @GetMapping("/eliminarArticuloCarrito/{idArticulo}")
    public String eliminarArticuloCarrito(@PathVariable Long idArticulo) 
    {
        articuloService.eliminarArticuloCarrito(idArticulo);
        return "redirect:/articulo/abrircarrito";
    }
    
    @GetMapping("/pagarCarrito")
    public String pagarCarrito() 
    {
        String usuario = (String) httpSession.getAttribute("correo");
        articuloService.pagarCarrito(usuario);
        return "redirect:/articulo/abrircarrito";
    }
}

