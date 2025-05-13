package com.Tekanx.collabheuristics.services.evaluacion;

import java.util.List;

import com.Tekanx.collabheuristics.models.Evaluacion;
import com.Tekanx.collabheuristics.models.Evaluador;

/**
 * @author Tekanx
 * @version 0.1
 * @since 11/05/2025
 */
public interface ServicioEvaluacion {
    List<Evaluacion> getEvaluaciones();
    List<Evaluador> getEvaluadoresByEvaluacionId(Long evaluacionId);
    Evaluacion getEvaluacion(Long id);
    Evaluacion addEvaluacion(Evaluacion evaluacion);
    Evaluacion updateEvaluacion(Evaluacion evaluacion);
    String deleteEvaluacion(Evaluacion evaluacion);

    List<Evaluacion> getEvaluacionesByEvaluadorId(Long evaluadorId);
}
