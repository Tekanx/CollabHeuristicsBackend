package com.Tekanx.collabheuristics.models;
/**
 * @author Tekanx
 * @version 0.1
 * @since 06/03/2025
 */

public class Problema {
    private Long id_problema;
    private Long fk_evaluacion;
    private Long fk_evaluador;
    private String nombre_problema;
    private String descripcion_problema;
    private String[] heuristica_incumplida;
    private String[] ejemplo_ocurrencia;
    private String[] comentarios;
    private String url_imagen;
}
