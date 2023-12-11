package com.clinica.dao;

import com.clinica.domain.Carrito;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Josuu
 */

public interface CarritoDao extends JpaRepository<Carrito,Long>
{
    public List<Carrito> findAllByCorreo(String correo); 
    public void deleteByConsecutivo(Long consecutivo); 
    public void deleteAllByCorreo(String correo); 
}
