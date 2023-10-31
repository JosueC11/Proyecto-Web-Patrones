/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.clinica.service;

import com.clinica.domain.Cita;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author Josuu
 */

public interface CitaService 
{
    public List<Cita> getCitas();
    
    public List<Cita> getCitasFecha(String fecha);
    
    public void agendarCita(Long Id);
    
    public List<Cita> getCitasAgendadas();
    
    public List<Cita> getCitasUsuario(String correo);

    public void eliminarCita(Long idCita);             
}
