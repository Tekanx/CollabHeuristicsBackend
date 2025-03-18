package com.Tekanx.collabheuristics.services;
/**
 * @author Tekanx
 * @version 0.1
 * @since 18/03/2025
 */

import java.util.List;

import com.Tekanx.collabheuristics.models.Evaluacion;
import com.Tekanx.collabheuristics.models.Evaluador;
import com.Tekanx.collabheuristics.models.Problema;

public interface ServicioEvaluador {
    List<Evaluador> getAllEvaluadores();
    Evaluador getEvaluador(Integer id_evaluador);
    Evaluador addEvaluador(Evaluador evaluador);
    Evaluador updateEvaluador(Evaluador evaluador);
    String deleteEvaluador(Evaluador evaluador);

    List<Evaluacion> getEvaluacionesofEvaluador(Integer id_evaluador);
    List<Problema> getProblemasofEvaluacionCrossEvaluador(Integer id_evaluador, Integer id_evaluacion);
}
