package com.Tekanx.collabheuristics.services;
/**
 * @author Tekanx
 * @version 0.1
 * @since 07/03/2025
 */

import java.util.List;
import com.Tekanx.collabheuristics.models.Coordinador;

public interface ServicioCoordinador {
    List<Coordinador> getAllCoordinadores();
    Coordinador getCoordinador(Long id_coordinador);
    Coordinador addCoordinador(Coordinador coordinador);
    Coordinador updateCoordinador(Coordinador coordinador);
    String deleteCoordinador(Coordinador coordinador);

}
