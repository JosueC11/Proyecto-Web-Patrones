/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clinica.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.sql.Date;
import java.sql.Time;
import lombok.Data;

/**
 *
 * @author Josuu
 */

@Data
@Entity
@Table(name="citas")
public class Cita 
{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_cita")
    private Long idCita;
    private Date fecha;
    private Time hora;
    @Column(name="nombre_doctor")
    private String nombreDoctor;
    private Boolean estado;
    @Column(name="cedula_cliente")
    private String cedulaCliente;
}
