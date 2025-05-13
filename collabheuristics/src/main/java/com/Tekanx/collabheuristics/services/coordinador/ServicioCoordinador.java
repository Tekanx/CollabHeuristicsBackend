package com.Tekanx.collabheuristics.services.coordinador;
/**
 * @author Tekanx
 * @version 0.2 
 * @since 13/05/2025
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
