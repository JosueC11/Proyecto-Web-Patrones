package com.clinica.dao;

import com.clinica.domain.Articulo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Josuu
 */

@Repository
public interface ArticuloDao extends JpaRepository <Articulo, Long> 
{ 
    public List<Articulo> findAllByCategoria(String categoria);  
}
