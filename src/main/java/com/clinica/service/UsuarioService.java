package com.clinica.service;

import com.clinica.domain.Usuario;

/**
 *
 * @author Dennis
 */

public interface UsuarioService {
    
    public Usuario getUsuarioRegistro(String cedulaCliente);
    
    public void registrarUsuario(Usuario usuario);
    
    public void loguearUsuario(Usuario usuario);
    
}