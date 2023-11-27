/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clinica.service.impl;

import com.clinica.dao.ArticuloDao;
import com.clinica.dao.CarritoDao;
import com.clinica.domain.Articulo;
import com.clinica.domain.Carrito;
import com.clinica.service.ArticuloService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Josuu
 */

@Service
public class ArticuloServiceImpl implements ArticuloService
{
    @Autowired
    private ArticuloDao articuloDao;
    
    @Autowired
    private CarritoDao carritoDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Articulo> getArticulos()
    {
        var listadoArticulos = articuloDao.findAll();
        return listadoArticulos;
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Articulo> getArticulosCategoria(String categoria)
    {
        var listadoArticulos = articuloDao.findAllByCategoria(categoria);
        return listadoArticulos;
    }
    
    @Override
    @Transactional
    public void agregarArticulo(Articulo articulo)
    {
        articuloDao.save(articulo);
    }
    
    @Override
    @Transactional
    public void eliminarArticulo(Long IdArticulo)
    {
        articuloDao.deleteById(IdArticulo);
    }
    
    @Override
    @Transactional
    public void agregarCarrito(Long idArticulo, String correo)
    {
        Optional<Articulo> articuloOptional = articuloDao.findById(idArticulo);

        if (articuloOptional.isPresent()) {
            Articulo articulo = articuloOptional.get();
            
            Carrito carrito = new Carrito();
            carrito.setCategoria(articulo.getCategoria());
            carrito.setIdArticulo(articulo.getIdArticulo());
            carrito.setNombre(articulo.getNombre());
            carrito.setMarca(articulo.getMarca());
            carrito.setPrecio(articulo.getPrecio());
            carrito.setEstado(true);
            carrito.setCorreo(correo);          
            carritoDao.save(carrito);
        }
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Carrito> getCarrito(String correo)
    {
        var listado = carritoDao.findAllByCorreo(correo);
        return listado;
    }
    
    @Override
    @Transactional
    public void eliminarArticuloCarrito(Long consecutivo)
    {
        carritoDao.deleteByConsecutivo(consecutivo);
    }
    
    @Override
    @Transactional
    public void pagarCarrito(String correo)
    {
        carritoDao.deleteAllByCorreo(correo);
    }
}
