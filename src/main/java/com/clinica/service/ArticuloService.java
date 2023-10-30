/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.clinica.service;

import com.clinica.domain.Articulo;
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
}