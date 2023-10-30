package com.clinica.service;

import com.clinica.domain.MetodoPago;
import java.util.List;

/**
 *
 * @author Josuu
 */

public interface MetodoPagoService 
{
    public List<MetodoPago> getMetodosPagos(String cedulaCliente);
    
    public void establecerMetodoPredeterminado(MetodoPago metodoPago);
    
    public void eliminarMetodoPago(MetodoPago metodoPago); 
}
