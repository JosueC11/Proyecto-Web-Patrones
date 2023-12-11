package com.clinica.service;

import com.clinica.domain.Resena;
import java.util.List;

/**
 *
 * @author Josuu
 */
public interface ResenaService 
{
    public List<Resena> getResenas();
    
    public List<Resena> getResenasUser(String correo);
      
    public void agregarResena(Resena resena, String usuario,String imagen);
    
    public void eliminarResena(Long idResena); 
}