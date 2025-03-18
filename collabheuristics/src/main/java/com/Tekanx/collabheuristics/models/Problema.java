package com.Tekanx.collabheuristics.models;

import jakarta.persistence.Column;
import jakarta.persistence.Id;

/**
 * @author Tekanx
 * @version 0.1
 * @since 18/03/2025
 */

public class Problema {
    @Id
    @Column(name = "id_problema", unique = true, updatable = false)
    private Long id_problema;
    @Column(name = "id_evaluacion")
    private Long fk_evaluacion;
    @Column(name = "id_evaluador")
    private Long fk_evaluador;
    @Column(name = "nombre_problema")
    private String nombre_problema;
    @Column(name = "descripcion")
    private String descripcion_problema;
    @Column(name = "heuristica_incumplida")
    private String heuristica_incumplida;
    @Column(name = "ejemplo_ocurrencia")
    private String ejemplo_ocurrencia;
    @Column(name = "comentarios")
    private String comentarios;
    @Column(name = "url_imagen")
    private String url_imagen;
}
