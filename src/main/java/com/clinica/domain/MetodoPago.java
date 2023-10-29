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
import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author Josuu
 */
@Data
@Entity
@Table(name="metodos_pago")
public class MetodoPago implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="numero_tarjeta")
    private String numeroTarjeta;
    private String nombre;
    @Column(name="dueño")
    private String duenno;
    @Column(name="mes_vencimiento")
    private String mesVencimiento;
    @Column(name="año_vencimiento")
    private String annoVencimiento;
    private String cvc;
    @Column(name="cedula_cliente")
    private String cedulaCliente;  
}
