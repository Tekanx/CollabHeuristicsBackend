package com.Tekanx.collabheuristics.models;
/**
 * @author Tekanx
 * @version 0.1
 * @since 06/03/2025
 */

public class Puntuacion_problema {
   private Long id_puntuacion;
   private Long fk_evaluador;
   private Long fk_problema;
   private Integer[] probabilidad;
   private Integer[] severidad;
   private Integer[] criticidad; 
}
