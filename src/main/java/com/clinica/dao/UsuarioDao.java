package com.clinica.dao;

import com.clinica.domain.UsuarioRegistro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Dennis
 */

@Repository
public interface UsuarioDao extends JpaRepository<UsuarioRegistro, String> {
    
    public UsuarioRegistro findByCorreo(String cedulaCliente);  
    
}