/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clinica.service.impl;

import com.clinica.dao.CitaDao;
import com.clinica.domain.Cita;
import com.clinica.service.CitaService;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional(readOnly = true)
    public List<Cita> getCitas()
    {      
        Date fechaHoraActual = new Date(System.currentTimeMillis());

        Date fechaSQL = new Date(fechaHoraActual.getTime());
        
        var listadoCitas = citaDao.findAllByFecha(fechaSQL);

        List<Cita> citasFiltradas = new ArrayList<>();

        for (Cita cita : listadoCitas) {
            if (cita.getEstado()) {
                citasFiltradas.add(cita);
            }
        }
        return citasFiltradas;  
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Cita> getCitasFecha(String fecha)
    {      
        try {
            // Define el formato de fecha para el análisis
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");

            // Parsea la fecha String al formato deseado
            java.util.Date utilDate = formato.parse(fecha);

            // Convierte la fecha java.util.Date en java.sql.Date
            Date fechaSQL = new Date(utilDate.getTime());
            
            List<Cita> listadoCitas = citaDao.findAllByFecha(fechaSQL);

            List<Cita> citasFiltradas = new ArrayList<>();

            for (Cita cita : listadoCitas) {
                if (cita.getEstado()) {
                    citasFiltradas.add(cita);
                }
            }
            return citasFiltradas;
        } catch (ParseException e) {
            // Maneja la excepción en caso de un formato de fecha no válido
            e.printStackTrace();
            return null;
        }
    }
    
    @Override
    @Transactional
    public void agendarCita(Cita cita, String correo)
    {
        cita.setEstado(Boolean.FALSE);
        cita.setTerminado(Boolean.FALSE);
        cita.setCorreo(correo);
            
        // Guarda el valor actualizado en la base de datos
        citaDao.save(cita);

    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Cita> getCitasAgendadas()
    { 
            var listadoCitas = citaDao.findAllByEstado(false);

            return listadoCitas;
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Cita> getCitasUsuario(String correo)
    { 
            var listadoCitas = citaDao.findAllByCorreo(correo);

            return listadoCitas;
    }
    
    @Override
    @Transactional
    public void eliminarCita(Long idCita)
    {
        citaDao.deleteById(idCita);       
    }   
    
    @Override
    @Transactional(readOnly = true)
    public Cita getCitaId(Long idCita)
    {
        var cita = citaDao.findById(idCita).orElse(null);
        return cita;
    } 
}
