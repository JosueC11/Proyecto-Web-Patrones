/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clinica.service.impl;

import com.clinica.dao.ArticuloDao;
import com.clinica.domain.Articulo;
import com.clinica.service.ArticuloService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Josuu
 */

@Service
public class ArticuloServiceImpl implements ArticuloService
{
    @Autowired
    private ArticuloDao articuloDao;
    @Override
    public List<Articulo> getArticulos()
    {
        var listadoArticulos = articuloDao.findAll();
        return listadoArticulos;
    }
    
    @Override
    public List<Articulo> getArticulosCategoria(String categoria)
    {
        var listadoArticulos = articuloDao.findAllByCategoria(categoria);
        return listadoArticulos;
    }
    
    @Override
    public void agregarArticulo(Articulo articulo)
    {
        articuloDao.save(articulo);
    }
    
    @Override
    public void eliminarArticulo(Long IdArticulo)
    {
        articuloDao.deleteById(IdArticulo);
    }
}
