package com.Tekanx.collabheuristics.services.puntuacion_problema;

import java.util.List;

import com.Tekanx.collabheuristics.models.Evaluador;
import com.Tekanx.collabheuristics.models.Puntuacion_problema;

/**
 * @author Tekanx
 * @version 0.1
 * @since 08/05/2025
 */
public interface ServicioPuntuacion {
    Puntuacion_problema getPuntuacion(Long id_puntuacion);
    Puntuacion_problema addPuntuacion(Puntuacion_problema puntuacion);
    Puntuacion_problema updatePuntuacion(Puntuacion_problema puntuacion);
    String deletePuntuacion(Puntuacion_problema puntuacion);

    Integer getPuntuacionSeveridadofEvaluador(Long id_problema);
    Integer getPuntuacionProbabilidadofEvaluador(Long id_problema);
    Integer getPuntuacionCriticidadofEvaluador(Long id_problema);


    List<Puntuacion_problema> getPuntuacionofEvaluadores(List<Long> ids_evaluadores);
}
