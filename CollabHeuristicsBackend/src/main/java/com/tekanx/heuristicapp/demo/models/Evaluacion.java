package com.tekanx.heuristicapp.demo.models;
/**
 * @author Tekanx
 * @version 0.1
 * @since 05/03/2025
 */

import java.sql.Date;


public class Evaluacion {
    private String id_evaluacion;
    private String nombre_evaluacion;
    private String descripcion;
    private String principio;
    private Date fecha_inicio;
    private Date fecha_termino;
    private String fk_coordinador;  
}
