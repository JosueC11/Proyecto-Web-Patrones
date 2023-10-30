package com.clinica.service;


import com.clinica.domain.UsuarioRegistro;

/**
 *
 * @author Dennis
 */
public interface UsuarioRegistroService {
    
    public UsuarioRegistro getUsuarioRegistro(String cedulaCliente);
    
    public void registrarUsuario(UsuarioRegistro usuario);
}
