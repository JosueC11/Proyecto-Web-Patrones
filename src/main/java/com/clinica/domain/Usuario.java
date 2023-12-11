package com.clinica.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author Dennis
 */
@Data
@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable
{
    @Id
    private String correo;
    private String nombre;
    private String apellido;
    private String telefono;
    private String direccion;
    @Column(name = "contraseña")
    private String contrasena;
    @Column(name = "direccion_foto")
    private String direccionFoto;
    @Column(name = "id_rol")
    private int idRol;
    
}
