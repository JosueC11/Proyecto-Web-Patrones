package com.clinica.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Data;

@Entity
@Table(name = "usuarios_registro")
@Data
public class UsuarioRegistro implements Serializable 
{
    private String nombre;
    private String apellido;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String cedula;
    private String telefono;
    private String direccion;
    @Column(name = "correo_electronico")
    private String correoElectronico;
    @Column(name = "contraseña")
    private String contrasena;
    @Column(name = "direccion_foto")
    private String direccionFoto;
}
