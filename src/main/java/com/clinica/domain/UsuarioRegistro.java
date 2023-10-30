package com.clinica.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name = "clientes")
public class UsuarioRegistro implements Serializable 
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
}
