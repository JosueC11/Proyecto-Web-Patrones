package com.clinica.service;

import com.clinica.domain.MetodoPago;
import java.util.List;

/**
 *
 * @author Josuu
 */

public interface MetodoPagoService 
{
    public List<MetodoPago> getMetodosPagos(String correo);
    
    public void establecerMetodoPredeterminado(String numeroTarjeta);
    
    public void agregarMetodoPago(MetodoPago metodoPago, String usuario);
    
    public void eliminarMetodoPago(String numeroTarjeta); 
}
