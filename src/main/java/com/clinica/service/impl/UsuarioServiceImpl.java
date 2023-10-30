package com.clinica.service.impl;

import com.clinica.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import com.clinica.dao.UsuarioDao;
import com.clinica.domain.Usuario;
import org.springframework.stereotype.Service;


/**
 *
 * @author Dennis
 */

@Service
public class UsuarioServiceImpl implements UsuarioService
{
    @Autowired
    private UsuarioDao usuarioDao;
    
    @Override
    public Usuario getUsuarioRegistro(String correo)
    {
        return usuarioDao.findByCorreo(correo);
    }
    
    @Override
    public void registrarUsuario(Usuario usuario)
    {
        usuarioDao.save(usuario);
    }  
    
    @Override
    public void loguearUsuario(Usuario usuario)
    {
        
    } 
}

