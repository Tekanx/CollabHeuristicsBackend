package com.Tekanx.collabheuristics.repository;

/**
 * @author Tekanx
 * @version 0.1
 * @since 07/03/2025
 */

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Tekanx.collabheuristics.models.Coordinador;

@Repository
public interface RepositorioCoordinador extends CrudRepository<Coordinador, Long> {

}
