/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.clinica.dao;

import com.clinica.domain.Cita;
import java.sql.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Josuu
 */

@Repository
public interface CitaDao extends JpaRepository<Cita,Long> 
{  
    public List<Cita> findAllByFecha(Date fecha);
    public List<Cita> findAllByCorreo(String correo); 
    public List<Cita> findAllByEstado(boolean estado);
}
