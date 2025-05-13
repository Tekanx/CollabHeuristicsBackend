package com.Tekanx.collabheuristics.services.heuristica;

/**
 * @author Tekanx
 * @version 0.2
 * @since 01/05/2025
 */
import java.util.List;
import com.Tekanx.collabheuristics.models.Heuristica;
import com.Tekanx.collabheuristics.models.Principio_heuristico;

public interface ServicioHeuristica {

    List<Heuristica> getAllHeuristicas();
    Heuristica getHeuristica(Integer id_heuristica);
    Heuristica addHeuristica(Heuristica heuristica);
    Heuristica updateHeuristica(Heuristica heuristica);
    String deleteHeuristica(Heuristica heuristica);

    List<Principio_heuristico> getPrincipiosHeuristicosOfHeuristica(Integer id_heuristica);
    

}
