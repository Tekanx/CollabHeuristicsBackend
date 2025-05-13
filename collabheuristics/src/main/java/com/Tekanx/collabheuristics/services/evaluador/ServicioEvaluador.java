package com.Tekanx.collabheuristics.services.evaluador;
/**
 * @author Tekanx
 * @version 0.2
 * @since 1/05/2025
 */

import java.util.List;

import com.Tekanx.collabheuristics.models.Evaluacion;
import com.Tekanx.collabheuristics.models.Evaluador;
import com.Tekanx.collabheuristics.models.Problema;

public interface ServicioEvaluador {
    List<Evaluador> getAllEvaluadores();
    Evaluador getEvaluador(Long id_evaluador);
    Evaluador addEvaluador(Evaluador evaluador);
    Evaluador updateEvaluador(Evaluador evaluador);
    String deleteEvaluador(Evaluador evaluador);

    List<Evaluacion> getEvaluacionesofEvaluador(Long id_evaluador);
    List<Problema> getProblemasofEvaluacionCrossEvaluador(Long id_evaluador, Long id_evaluacion);
    List<Problema> getProblemasofAllEvaluadoresofEvaluacion(Long id_evaluacion);
    //Progreso de la evaluación
    Integer getProgresoEvaluadorofEvaluacion(Long id_evaluador, Long id_evaluacion);
    List<Integer> getProgresoEvaluadoresofEvaluacion(Long id_evaluacion);

}
