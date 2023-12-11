package com.clinica.service;

import com.clinica.domain.Articulo;
import com.clinica.domain.Carrito;
import java.util.List;

/**
 *
 * @author Josuu
 */

public interface ArticuloService 
{
    public List<Articulo> getArticulos();
    
    public List<Articulo> getArticulosCategoria(String categoria);
    
    public void agregarArticulo(Articulo articulo);
    
    public void eliminarArticulo(Long IdArticulo);   
    
    public void agregarCarrito(Long idArticulo, String correo);  
    
    public List<Carrito> getCarrito(String correo);
    
    public void eliminarArticuloCarrito(Long consecutivo);
    
    public void pagarCarrito(String correo);
}
