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
@Table(name="carrito")
public class Carrito implements Serializable 
{    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long consecutivo;
    @Column(name="id_articulo")
    private Long idArticulo;
    private String marca;
    private String nombre;
    private Double precio;
    private boolean estado;
    private String categoria;
    private String correo;
}   

