/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clinica.dao;

import com.clinica.domain.Articulo;
import com.clinica.domain.Carrito;
import java.util.List;
import java.util.Optional;
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
