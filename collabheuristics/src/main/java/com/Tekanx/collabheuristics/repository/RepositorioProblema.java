package com.Tekanx.collabheuristics.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Tekanx.collabheuristics.models.Problema;

/**
 * @author Tekanx
 * @version 0.2
 * @since 07/05/2025
 */

@Repository
public interface RepositorioProblema extends JpaRepository<Problema, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM problema WHERE id_evaluador = ?1")
    List<Problema> findProblemasByEvaluadorId(Long idEvaluador);

    @Query(nativeQuery = true, value = "SELECT * FROM problema WHERE id_evaluacion = ?1")
    List<Problema> findProblemasByFkEvaluacion(Long idEvaluacion); 

    @Query(nativeQuery = true, value = "SELECT Ph.numero_principio, Ph.nombre_principio, COUNT(*) as Cantidad FROM principio_heuristico as Ph JOIN problema as Pr ON Pr.id_heuristicaincumplida = Ph.id_principioheuristico WHERE Pr.id_evaluacion = ?1  GROUP BY Ph.id_principioheuristico")
    List<Object[]> countProblemasPorPrincipio(Long id_evaluacion);
}
