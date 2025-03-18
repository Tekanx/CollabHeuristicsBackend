package com.Tekanx.collabheuristics.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Tekanx.collabheuristics.models.Evaluacion;
import com.Tekanx.collabheuristics.models.Evaluador;
import com.Tekanx.collabheuristics.models.Problema;
import com.Tekanx.collabheuristics.repository.RepositorioEvaluador;

/**
 * @author Tekanx
 * @version 0.1
 * @since 18/03/2025
 */
@Service
public class ImplServicioEvaluador implements ServicioEvaluador{

    @Autowired
    private RepositorioEvaluador repositorioEvaluador;

    @Override
    public List<Evaluador> getAllEvaluadores() {
        return (List<Evaluador>) repositorioEvaluador.findAll();
    }

    @Override
    public Evaluador getEvaluador(Integer id_evaluador) {
        return repositorioEvaluador.findById(id_evaluador).get();
    }

    @Override
    public Evaluador addEvaluador(Evaluador evaluador) {
        return repositorioEvaluador.save(evaluador);
    }

    @Override
    public Evaluador updateEvaluador(Evaluador evaluador) {
        return repositorioEvaluador.save(evaluador);
    }

    @Override
    public String deleteEvaluador(Evaluador evaluador) {
        repositorioEvaluador.delete(evaluador);
        return "Evaluador con ID " + evaluador.getId_coordinador() + ": " + evaluador.getNombre() + " " + evaluador.getApellido() + " ha sido eliminado";
    }

    @Override
    public List<Evaluacion> getEvaluacionesofEvaluador(Integer id_evaluador) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getEvaluacionesofEvaluador'");
    }

    @Override
    public List<Problema> getProblemasofEvaluacionCrossEvaluador(Integer id_evaluador, Integer id_evaluacion) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getProblemasofEvaluacionCrossEvaluador'");
    }
}
