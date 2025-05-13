package com.Tekanx.collabheuristics.repository;

/**
 * @author Tekanx
 * @version 0.2
 * @since 13/05/2025
 */
import com.Tekanx.collabheuristics.models.Evaluacion;
import com.Tekanx.collabheuristics.models.Evaluador;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioEvaluacion extends JpaRepository<Evaluacion, Long> {
    @Query(nativeQuery = true, value = "SELECT Ev.id_evaluacion, Ev.nombre_evaluacion, Ev.descripcion, Ev.fecha_inicio, Ev.fecha_termino, Ev.id_coordinador, Ev.id_heuristica, Ev.evaluacion_identificador FROM evaluacion as Ev JOIN detalle_evaluacion as De ON De.id_evaluacion = Ev.id_evaluacion JOIN evaluador as Eva ON Eva.id_evaluador = De.id_evaluador WHERE Eva.id_evaluador = ?1")
    List<Evaluacion> findByEvaluadorId(Long evaluadorId);

    @Query(nativeQuery = true, value = "SELECT Eva.id_evaluador, Eva.nombre_usuario, Eva.nombre, Eva.apellido, Eva.numero, Eva.correo, Eva.genero, Eva.url_avatar, Eva.contrasena FROM evaluacion as Ev JOIN detalle_evaluacion as De ON De.id_evaluacion = Ev.id_evaluacion JOIN evaluador as Eva ON Eva.id_evaluador = De.id_evaluador WHERE Ev.id_evaluacion = ?1")
    List<Evaluador> findEvaluadoresByEvaluacionId(Long evaluacionId);
    
} 