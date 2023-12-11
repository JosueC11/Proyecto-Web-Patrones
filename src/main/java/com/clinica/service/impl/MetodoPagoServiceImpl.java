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
    @Transactional
    public void establecerMetodoPredeterminado(String numeroTarjeta)
    {
        var listaMetodos = metodoPagoDao.findAll();
        for(MetodoPago MetedoPago: listaMetodos)
        {
            if(MetedoPago.getNumeroTarjeta().equals(numeroTarjeta))
            {
                MetedoPago.setPredeterminado(true);
                metodoPagoDao.save(MetedoPago);
            }
            else
            {
                MetedoPago.setPredeterminado(false);
                metodoPagoDao.save(MetedoPago);
            }           
        }
    }
    
    @Override
    @Transactional
    public void agregarMetodoPago(MetodoPago metodoPago, String usuario)
    {
        metodoPago.setCorreo(usuario);
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
