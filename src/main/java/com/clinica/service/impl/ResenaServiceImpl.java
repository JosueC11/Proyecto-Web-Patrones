package com.clinica.service.impl;

import com.clinica.domain.Resena;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.clinica.dao.ResenaDao;
import com.clinica.service.ResenaService;

/**
 *
 * @author Josuu
 */
@Service
public class ResenaServiceImpl implements ResenaService
{
    @Autowired
    private ResenaDao resenaDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Resena> getResenas()
    {
        var listadoResenas = resenaDao.findAll();
        return listadoResenas;
    }
       
    @Override
    @Transactional(readOnly = true)
    public List<Resena> getResenasUser(String correo)
    {
        return resenaDao.findAllByCorreo(correo);
    }
    
    @Override
    @Transactional
    public void agregarResena(Resena resena, String usuario)
    {
        resena.setCorreo(usuario);
        resenaDao.save(resena);
    }
    
    @Override
    @Transactional
    public void eliminarResena(Long idResena)
    {
        resenaDao.deleteById(idResena);
    }    
}
