/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
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
