package com.Tekanx.collabheuristics.services.heuristica;

/**
 * @author Tekanx
 * @version 0.2
 * @since 01/05/2025
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Tekanx.collabheuristics.models.Heuristica;
import com.Tekanx.collabheuristics.models.Principio_heuristico;
import com.Tekanx.collabheuristics.repository.RepositorioHeuristica;

@Service
public class ImplServicioHeuristica implements ServicioHeuristica {

    @Autowired
    private RepositorioHeuristica repositorioHeuristica;

    @Override
    public List<Heuristica> getAllHeuristicas() {
        return (List<Heuristica>) repositorioHeuristica.findAll();
    }

    @Override
    public Heuristica getHeuristica(Integer id_heuristica) {
        return repositorioHeuristica.findById(id_heuristica).get();
    }

    @Override
    public Heuristica addHeuristica(Heuristica heuristica) {
        return repositorioHeuristica.save(heuristica);
    }

    @Override
    public Heuristica updateHeuristica(Heuristica heuristica) {
        return repositorioHeuristica.save(heuristica);
    }

    @Override
    public String deleteHeuristica(Heuristica heuristica) {
        repositorioHeuristica.delete(heuristica);
        return "Heuristica con ID " + heuristica.getId_heuristica() + " eliminada";
    }

    @Override
    public List<Principio_heuristico> getPrincipiosHeuristicosOfHeuristica(Integer id_heuristica) {
        return repositorioHeuristica.findPrincipiosHeuristicosOfHeuristica(id_heuristica);
    }

    

}
