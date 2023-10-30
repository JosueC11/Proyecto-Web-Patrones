
package com.clinica.service.impl;

import com.clinica.dao.UsuarioRegistroDao;
import com.clinica.domain.UsuarioRegistro;
import com.clinica.service.UsuarioRegistroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Dennis
 */

@Service
public class UsuarioRegistroImpl implements UsuarioRegistroService {
    
    @Autowired
    private UsuarioRegistroDao usuarioRegistroDao;
    
    @Override
    public UsuarioRegistro getUsuarioRegistro(String cedulaCliente)
    {
        return usuarioRegistroDao.findByCedulaCliente(cedulaCliente);
    }
    
    @Override
    public void registrarUsuario(UsuarioRegistro usuario)
    {
        usuarioRegistroDao.save(usuario);
    }
}
