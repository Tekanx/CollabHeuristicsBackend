package com.Tekanx.collabheuristics.models;

import jakarta.persistence.Column;
import jakarta.persistence.Id;

/**
 * @author Tekanx
 * @version 0.1
 * @since 18/03/2025
 */

public class Puntuacion_problema {
   @Id
   @Column(name = "id_puntuacion", unique = true, updatable = false)
   private Long id_puntuacion;
   @Column(name = "id_evaluador")
   private Long fk_evaluador;
   @Column(name = "id_problema")
   private Long fk_problema;
   @Column(name = "probabilidad")
   private Integer probabilidad;
   @Column(name = "severidad")
   private Integer severidad;
   @Column(name = "criticidad")
   private Integer criticidad; 
}
