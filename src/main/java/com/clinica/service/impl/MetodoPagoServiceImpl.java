/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clinica.service.impl;

import com.clinica.dao.MetodoPagoDao;
import com.clinica.domain.MetodoPago;
import com.clinica.service.MetodoPagoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Josuu
 */

@Service
public class MetodoPagoServiceImpl implements MetodoPagoService
{
    @Autowired
    private MetodoPagoDao metodoPagoDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<MetodoPago> getMetodosPagos(String correo)
    {
        var listadoMetodosPago = metodoPagoDao.findAllByCorreo(correo);
        return listadoMetodosPago;
    }
    
    @Override
    public void establecerMetodoPredeterminado(MetodoPago metodoPago)
    {
        metodoPagoDao.save(metodoPago);
    }
    
    @Override
    @Transactional
    public void agregarMetodoPago(MetodoPago metodoPago)
    {
        metodoPago.setCorreo("OscarCañellas@gmail.com");
        metodoPago.setPredeterminado(false);
        metodoPagoDao.save(metodoPago);
    }
    
    @Override
    @Transactional
    public void eliminarMetodoPago(String numeroTarjeta)
    {
        metodoPagoDao.deleteByNumeroTarjeta(numeroTarjeta);
    }    
}
