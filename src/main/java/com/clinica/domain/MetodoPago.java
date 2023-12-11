package com.clinica.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 *
 * @author Josuu
 */
@Data
@Entity
@Table(name="metodos_pago")
public class MetodoPago
{
    @Id
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
    private String correo;  
    private boolean predeterminado;
}
