package com.Tekanx.collabheuristics.services.evaluacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Tekanx.collabheuristics.models.Evaluacion;
import com.Tekanx.collabheuristics.models.Evaluador;
import com.Tekanx.collabheuristics.repository.RepositorioEvaluacion;

/**
 * @author Tekanx
 * @version 0.2
 * @since 11/05/2025
 */
@Service
public class ImplServicioEvaluacion implements ServicioEvaluacion{

    @Autowired
    private RepositorioEvaluacion repositorioEvaluacion;

    @Override
    public List<Evaluacion> getEvaluaciones() {
        return repositorioEvaluacion.findAll();
    }
    
    @Override
    public List<Evaluador> getEvaluadoresByEvaluacionId(Long evaluacionId) {
        return repositorioEvaluacion.findEvaluadoresByEvaluacionId(evaluacionId);
    }

    @Override
    public Evaluacion getEvaluacion(Long id) {
        return repositorioEvaluacion.findById(id).orElse(null);
    }

    @Override
    public Evaluacion addEvaluacion(Evaluacion evaluacion) {
        return repositorioEvaluacion.save(evaluacion);
    }

    @Override
    public Evaluacion updateEvaluacion(Evaluacion evaluacion) {
        return repositorioEvaluacion.save(evaluacion);
    }

    @Override
    public String deleteEvaluacion(Evaluacion evaluacion) {
        repositorioEvaluacion.delete(evaluacion);
        return "Evaluacion con ID " + evaluacion.getId_evaluacion() + " ha sido eliminada";
    }

    @Override
    public List<Evaluacion> getEvaluacionesByEvaluadorId(Long evaluadorId) {
        return repositorioEvaluacion.findByEvaluadorId(evaluadorId);
    }

}
