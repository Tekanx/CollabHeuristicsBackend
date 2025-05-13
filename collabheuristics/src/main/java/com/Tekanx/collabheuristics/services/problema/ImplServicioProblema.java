package com.Tekanx.collabheuristics.services.problema;

/**
 * @author Tekanx
 * @version 0.2
 * @since 07/05/2025
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Tekanx.collabheuristics.models.Problema;
import com.Tekanx.collabheuristics.repository.RepositorioProblema;

@Service
public class ImplServicioProblema implements ServicioProblema{

    @Autowired
    private RepositorioProblema repositorioProblema;

    @Override
    public List<Problema> getAllProblemas() {
        return repositorioProblema.findAll();
}

    @Override
    public Problema getProblema(Long id_problema) {
        return repositorioProblema.findById(id_problema).get();
    }

    @Override
    public Problema addProblema(Problema problema) {
        return repositorioProblema.save(problema);
    }

    @Override
    public Problema updateProblema(Problema problema) {
        return repositorioProblema.save(problema);
    }

    @Override
    public String deleteProblema(Problema problema) {
        repositorioProblema.delete(problema);
        return "Problema con ID " + problema.getId_problema() + " ha sido eliminado";
    }

    @Override
    public List<Problema> getProblemasofEvaluacion(Long id_evaluacion) {
        return repositorioProblema.findProblemasByEvaluadorId(id_evaluacion);
    }

    @Override
    public List<Problema> getProblemasofPrincipioHeuristicoCrossEvaluacion(Long id_evaluacion, Long id_heuristica, Long id_principio) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getProblemasofPrincipioHeuristicoCrossEvaluacion'");
    }

}
