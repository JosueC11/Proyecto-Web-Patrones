/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.clinica.dao;

import com.clinica.domain.MetodoPago;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Josuu
 */

@Repository
public interface MetodoPagoDao extends JpaRepository<MetodoPago,String> 
{  
    public List<MetodoPago> findAllByCorreo(String correo);  
    public void deleteByNumeroTarjeta(String numeroTarjeta);  
}
