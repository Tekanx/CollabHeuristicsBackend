package com.Tekanx.collabheuristics.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Tekanx.collabheuristics.models.Evaluador;

/**
 * @author Tekanx
 * @version 0.2
 * @since 06/05/2025
 */

@Repository
public interface RepositorioEvaluador extends JpaRepository<Evaluador, Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM evaluador WHERE nombre_usuario = ?1")
    Optional<Evaluador> findByNombreUsuario(String nombreUsuario);

    @Query(nativeQuery = true, value = "SELECT * FROM evaluador WHERE id_evaluador = ?1")
    Optional<Evaluador> findEvaluadorById(Long id_evaluador);

    @Query(nativeQuery = true, value = "SELECT Eva.evaluacion_identificador, Pr.numero_problema, Pr.nombre_problema, Pr.descripcion, Ph.nombre_principio, Pr.ejemplo_ocurrencia, Pr.url_imagen FROM public.Evaluador as Ev JOIN public.Problema as Pr ON Pr.id_evaluador = Ev.id_evaluador JOIN public.Principio_heuristico as Ph ON Pr.id_heuristicaincumplida = Ph.id_principioheuristico JOIN public.Evaluacion as Eva ON Eva.id_evaluacion = Pr.id_evaluacion WHERE Ev.id_evaluador = ?1;")
    Optional<Object> findAllEvaluacionesByEvaluador(Long id_evaluador);

    @Query(nativeQuery = true, value = "SELECT paso_actual FROM evaluacion as Ev JOIN detalle_evaluacion as De ON De.id_evaluacion = Ev.id_evaluacion JOIN evaluador as Eva ON Eva.id_evaluador = De.id_evaluador WHERE Ev.id_evaluacion = ?1 AND Eva.id_evaluador = ?2;")
    Integer pasoActualofEvaluador(Long id_evaluacion, Long id_evaluador);
}