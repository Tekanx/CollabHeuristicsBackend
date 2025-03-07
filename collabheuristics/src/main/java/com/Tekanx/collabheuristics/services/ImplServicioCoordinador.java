package com.Tekanx.collabheuristics.services;

/**
 * @author Tekanx
 * @version 0.1
 * @since 07/03/2025
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Tekanx.collabheuristics.models.Coordinador;
import com.Tekanx.collabheuristics.repository.RepositorioCoordinador;

@Service
public class ImplServicioCoordinador implements ServicioCoordinador{
    @Autowired
    private RepositorioCoordinador repositorioCoordinador;

    @Override
    public List<Coordinador> getAllCoordinadores() {
        return (List<Coordinador>) repositorioCoordinador.findAll();
    }

    @Override
    public Coordinador getCoordinador(Long id_coordinador) {
        return repositorioCoordinador.findById(id_coordinador).get();
    }

    @Override
    public Coordinador addCoordinador(Coordinador coordinador) {
        return repositorioCoordinador.save(coordinador);
    }

    @Override
    public Coordinador updateCoordinador(Coordinador coordinador) {
        return repositorioCoordinador.save(coordinador);
    }

    @Override
    public String deleteCoordinador(Coordinador coordinador) {
        repositorioCoordinador.delete(coordinador);
        return "Coordinador con ID " + coordinador.getId_coordinador() + " eliminado";
    }

}
