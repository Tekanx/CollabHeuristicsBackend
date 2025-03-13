package com.Tekanx.collabheuristics.services;
/**
 * @author Tekanx
 * @version 0.1
 * @since 13/03/2025
 */

import java.util.List;
import com.Tekanx.collabheuristics.models.Coordinador;
import com.Tekanx.collabheuristics.models.Evaluacion;
import com.Tekanx.collabheuristics.models.Evaluador;

public interface ServicioCoordinador {
    List<Coordinador> getAllCoordinadores();
    Coordinador getCoordinador(Integer id_coordinador);
    Coordinador addCoordinador(Coordinador coordinador);
    Coordinador updateCoordinador(Coordinador coordinador);
    String deleteCoordinador(Coordinador coordinador);

    List<Evaluacion> getEvaluacionesOfCoordinador(Integer id_coordinador);
    List<Evaluador> getEvaluadoresOfCoordinador(Integer id_coordinador);
    
}
