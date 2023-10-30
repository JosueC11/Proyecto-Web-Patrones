package com.clinica.service.impl;

import com.clinica.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import com.clinica.dao.UsuarioDao;
import com.clinica.domain.UsuarioRegistro;
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
    public UsuarioRegistro getUsuarioRegistro(String correo)
    {
        return usuarioDao.findByCorreo(correo);
    }
    
    @Override
    public void registrarUsuario(UsuarioRegistro usuario)
    {
        usuarioDao.save(usuario);
    }   
}

