package com.clinica.service;

import com.clinica.domain.Usuario;

/**
 *
 * @author Dennis
 */

public interface UsuarioService 
{   
    public Usuario getUsuarioRegistro(String correo);
    
    public void registrarUsuario(Usuario usuario);
    
    public void editarUsuario(Usuario usuario);
}