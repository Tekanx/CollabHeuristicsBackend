package com.Tekanx.collabheuristics.services.problema;

import java.util.List;

import com.Tekanx.collabheuristics.models.Problema;

/**
 * @author Tekanx
 * @version 0.2
 * @since 06/05/2025
 */

public interface ServicioProblema {
    List<Problema> getAllProblemas();
    Problema getProblema(Long id_problema);
    Problema addProblema(Problema problema);
    Problema updateProblema(Problema problema);
    String deleteProblema(Problema problema);

    List<Problema> getProblemasofEvaluacion(Long id_evaluacion);
    List<Problema> getProblemasofPrincipioHeuristicoCrossEvaluacion(Long id_evaluacion, Long id_heuristica, Long id_principio);
}
