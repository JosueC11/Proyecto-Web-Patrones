package com.clinica.dao;

import com.clinica.domain.Resena;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Josuu
 */

@Repository
public interface ResenaDao extends JpaRepository<Resena, Long> 
{
    public List<Resena> findAllByCorreo(String correo);  
}
