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
import lombok.Data;

/**
 *
 * @author Josuu
 */
@Data
@Entity
@Table(name="carrito")
public class Carrito {

    @Id
    @Column(name="id_articulo")
    private Long idArticulo;
    private String marca;
    private String nombre;
    private Double precio;
    private boolean estado;
    private String categoria;
    private String correo;
}   
