package com.clinica.service;

import com.clinica.domain.UsuarioRegistro;

/**
 *
 * @author Dennis
 */

public interface UsuarioService {
    
    public UsuarioRegistro getUsuarioRegistro(String cedulaCliente);
    
    public void registrarUsuario(UsuarioRegistro usuario);
    
}
