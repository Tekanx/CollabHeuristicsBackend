package com.Tekanx.collabheuristics.services.evaluador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Tekanx.collabheuristics.models.Evaluacion;
import com.Tekanx.collabheuristics.models.Evaluador;
import com.Tekanx.collabheuristics.models.Problema;
import com.Tekanx.collabheuristics.repository.RepositorioEvaluador;

/**
 * @author Tekanx
 * @version 0.2
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

    public Evaluador getEvaluador(Long id_evaluador) {
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
        return "Evaluador con ID " + evaluador.getId_evaluador() + ": " + evaluador.getNombre() + " " + evaluador.getApellido() + " ha sido eliminado";
    }

    @Override
    public List<Evaluacion> getEvaluacionesofEvaluador(Long id_evaluador) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getEvaluacionesofEvaluador'");
    }

    @Override
    public List<Problema> getProblemasofEvaluacionCrossEvaluador(Long id_evaluador, Long id_evaluacion) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getProblemasofEvaluacionCrossEvaluador'");
    }

    @Override
    public List<Problema> getProblemasofAllEvaluadoresofEvaluacion(Long id_evaluacion) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getProblemasofAllEvaluadoresofEvaluacion'");
    }

    @Override
    public Integer getProgresoEvaluadorofEvaluacion(Long id_evaluador, Long id_evaluacion) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getProgresoEvaluadorofEvaluacion'");
    }

    @Override
    public List<Integer> getProgresoEvaluadoresofEvaluacion(Long id_evaluacion) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getProgresoEvaluadoresofEvaluacion'");
    }

}
