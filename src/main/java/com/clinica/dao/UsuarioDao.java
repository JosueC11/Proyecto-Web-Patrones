package com.clinica.dao;

import com.clinica.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Dennis
 */

@Repository
public interface UsuarioDao extends JpaRepository<Usuario, String> {
    
    public Usuario findByCorreo(String cedulaCliente);  
    
}