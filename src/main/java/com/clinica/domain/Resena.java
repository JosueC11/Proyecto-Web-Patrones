/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clinica.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name="resenas")
public class Resena implements Serializable 
{
    @Id
    @Column(name="id_resena")
    private Long idResena;
    private String descripcion;
    private int puntos;
    private String correo;
}
