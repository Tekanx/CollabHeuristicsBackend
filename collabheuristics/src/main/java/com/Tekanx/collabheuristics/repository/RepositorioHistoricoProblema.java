package com.Tekanx.collabheuristics.repository;

/**
 * @author Tekanx
 * @version 0.2
 * @since 13/05/2025
 */

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Tekanx.collabheuristics.models.Historico_problema;

@Repository
public interface RepositorioHistoricoProblema extends JpaRepository<Historico_problema, Long> {
    // Custom queries can be added here if needed
    @Query(nativeQuery = true, value = "SELECT * FROM Historico_problema WHERE id_problema = ?1")
    List<Historico_problema> findByFkProblema(@Param("id_problema") Long id_problema);
} 