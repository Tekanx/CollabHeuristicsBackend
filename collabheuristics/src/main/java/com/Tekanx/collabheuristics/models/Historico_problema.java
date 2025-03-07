package com.Tekanx.collabheuristics.models;
import java.sql.Date;

/**
 * @author Tekanx
 * @version 0.1
 * @since 06/03/2025
 */

public class Historico_problema {
   private Long id_historico;
   private Long fk_evaluador;
   private Long fk_coordinador;
   private Date fecha_cambio;
   private Date detalle_cambio; 
}
