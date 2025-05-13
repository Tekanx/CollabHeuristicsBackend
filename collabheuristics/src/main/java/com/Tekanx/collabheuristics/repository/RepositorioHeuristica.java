package com.Tekanx.collabheuristics.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author Tekanx
 * @version 0.2
 * @since 01/05/2025
 */

import org.springframework.stereotype.Repository;

import com.Tekanx.collabheuristics.models.Heuristica;
import com.Tekanx.collabheuristics.models.Principio_heuristico;

@Repository
public interface RepositorioHeuristica extends JpaRepository<Heuristica, Integer> {

    @Query(nativeQuery = true, value = "SELECT * FROM principio_heuristico WHERE id_heuristica = ?1")
    List<Principio_heuristico> findPrincipiosHeuristicosOfHeuristica(Integer id_heuristica);


}
