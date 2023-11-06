/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clinica.service.impl;

import com.clinica.dao.CitaDao;
import com.clinica.domain.Cita;
import com.clinica.domain.Usuario;
import com.clinica.service.CitaService;
import jakarta.servlet.http.HttpSession;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
    public List<Cita> getCitas()
    {      
        Date fechaHoraActual = new Date(System.currentTimeMillis());

        Date fechaSQL = new Date(fechaHoraActual.getTime());
        
        var listadoCitas = citaDao.findAllByFecha(fechaSQL);

        List<Cita> citasFiltradas = new ArrayList<>();

        for (Cita cita : listadoCitas) {
            if (cita.getEstado() && cita.getCorreo().isBlank()) {
                citasFiltradas.add(cita);
            }
        }
        return citasFiltradas;  
    }
    
    @Override
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
                if (cita.getEstado() && cita.getCorreo().isBlank()) {
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
    public void agendarCita(Long idCita, String correo)
    {
        Optional<Cita> cita = citaDao.findById(idCita);

        // Verifica si el Optional contiene un valor
        if (cita.isPresent()) {
            // Obtén el valor del Optional
            Cita citaValor = cita.get();
            // Realiza operaciones con el valor
            citaValor.setEstado(Boolean.FALSE);
            citaValor.setCorreo(correo);

            // Guarda el valor actualizado en la base de datos
            citaDao.save(citaValor);
        }
    }
    
    @Override
    public List<Cita> getCitasAgendadas()
    { 
            var listadoCitas = citaDao.findAll();

            return listadoCitas;
    }
    
    @Override
    public List<Cita> getCitasUsuario(String correo)
    { 
            var listadoCitas = citaDao.findAllByCorreo(correo);

            return listadoCitas;
    }
    
    @Override
    public void eliminarCita(Long idCita)
    {
        citaDao.deleteById(idCita);       
    }    
}
