package com.Tekanx.collabheuristics.services.puntuacion_problema;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Tekanx.collabheuristics.models.Evaluador;
import com.Tekanx.collabheuristics.models.Puntuacion_problema;
import com.Tekanx.collabheuristics.repository.RepositorioPuntuacion;

/**
 * @author Tekanx
 * @version 0.1
 * @since 08/05/2025
 */

@Service
public class ImplServicioPuntuacion implements ServicioPuntuacion {

    @Autowired
    private RepositorioPuntuacion repositorioPuntuacion;

    @Override
    public Puntuacion_problema getPuntuacion(Long id_puntuacion) {
        return repositorioPuntuacion.findById(id_puntuacion).orElse(null);
    }

    @Override
    public Puntuacion_problema addPuntuacion(Puntuacion_problema puntuacion) {
        return repositorioPuntuacion.save(puntuacion);
    }

    @Override
    public Puntuacion_problema updatePuntuacion(Puntuacion_problema puntuacion) {
        return repositorioPuntuacion.save(puntuacion);
    }

    @Override
    public String deletePuntuacion(Puntuacion_problema puntuacion) {
        repositorioPuntuacion.delete(puntuacion);
        return "Puntuacion con ID " + puntuacion.getId_puntuacion() + " eliminada";
    }

    @Override
    public Integer getPuntuacionSeveridadofEvaluador(Long id_evaluador) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPuntuacionProbabilidadofEvaluador'");
}

    @Override
    public List<Puntuacion_problema> getPuntuacionofEvaluadores(List<Long> ids_evaluadores) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPuntuacionProbabilidadofEvaluador'");
}

    @Override
    public Integer getPuntuacionProbabilidadofEvaluador(Long id_problema) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPuntuacionProbabilidadofEvaluador'");
    }

    @Override
    public Integer getPuntuacionCriticidadofEvaluador(Long id_problema) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPuntuacionCriticidadofEvaluador'");
    }


}
