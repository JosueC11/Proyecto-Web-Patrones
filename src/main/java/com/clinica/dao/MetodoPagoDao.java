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
