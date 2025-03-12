package com.Tekanx.collabheuristics.repository;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Tekanx
 * @version 0.1
 * @since 07/03/2025
 */

import org.springframework.stereotype.Repository;

import com.Tekanx.collabheuristics.models.Coordinador;

@Repository
public interface RepositorioCoordinador extends JpaRepository<Coordinador, Long> {
    
}
