package com.Tekanx.collabheuristics.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author Tekanx
 * @version 0.2
 * @since 30/04/2025
 */

import org.springframework.stereotype.Repository;

import com.Tekanx.collabheuristics.models.Coordinador;
import com.Tekanx.collabheuristics.models.Evaluacion;

@Repository
public interface RepositorioCoordinador extends JpaRepository<Coordinador, Integer> {

    @Query(nativeQuery = true, value = "SELECT id_evaluacion, nombre_evaluacion, descripcion, heuristica_aplicada, fecha_inicio, fecha_termino, evaluacion.id_coordinador FROM coordinador JOIN evaluacion ON evaluacion.id_coordinador = coordinador.id_coordinador WHERE coordinador.id_coordinador = ?1 ")
    List<Evaluacion> findAllEvaluacionesbyCoordinador(Integer id_coordinador);
    @Query(nativeQuery = true, value = "SELECT id_coordinador, nombre_usuario, nombre, apellido, numero, correo, genero, url_avatar, contrasena FROM coordinador WHERE nombre_usuario = ?1")
    Optional<Coordinador> findByNombreUsuario(String nombreUsuario);
}
