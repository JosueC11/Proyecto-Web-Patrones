/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clinica.service.impl;

import com.clinica.dao.CitaDao;
import com.clinica.domain.Cita;
import com.clinica.service.CitaService;
import java.time.LocalDate;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Josuu
 */

@Service
public class CitaServiceImpl implements CitaService
{
    @Autowired
    private CitaDao citaDao;

    @Override
    public List<Cita> getCitas(Date fecha)
    {
        var listadoCitas = citaDao.findAllByFecha(fecha);
        for(Cita cita: listadoCitas)
        {
            listadoCitas.removeIf(e -> !e.getEstado() || !e.getCedulaCliente().isBlank());
        }
        return listadoCitas;
    }
    
    @Override
    public void agendarCita(Cita cita,String cedulaCliente)
    {
        cita.setEstado(Boolean.FALSE);
        cita.setCedulaCliente(cedulaCliente);       
        citaDao.save(cita);       
    }
    
    @Override
    public List<Cita> getCitasAgendadas()
    {
        LocalDate fecha = LocalDate.now(); 
        String fechaCorta = new SimpleDateFormat("yyyy-MM-dd").format(fecha);
        var listadoCitas = citaDao.findAll();
        for(Cita cita: listadoCitas)
        {
            listadoCitas.removeIf(e -> e.getEstado() 
                    || e.getCedulaCliente().isBlank() 
                    || !e.getFecha().equals(fechaCorta));
        }
        return listadoCitas;      
    }
    
    @Override
    public void eliminarCita(Long idCita)
    {
        citaDao.deleteById(idCita);       
    }    
}
