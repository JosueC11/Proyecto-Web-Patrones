/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.clinica.service;

import com.clinica.domain.Cita;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Josuu
 */

public interface CitaService 
{
    public List<Cita> getCitas();
    
    public Cita getCitaId(Long id);
    
    public List<Cita> getCitasFecha(String fecha);
    
    public void agendarCita(Cita cita,String correo,String imagen);
    
    public List<Cita> getCitasAgendadas();
    
    public List<Cita> getCitasUsuario(String correo);

    public void eliminarCita(Long idCita);      
    
    public void citaTerminar(Long idCita);
    
    public List<Cita> getHistorial(String correo);
}
