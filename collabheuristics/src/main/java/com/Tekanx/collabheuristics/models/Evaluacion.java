package com.Tekanx.collabheuristics.models;/**
 * @author Tekanx
 * @version 0.2
 * @since 30/04/2025
 */

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_DEFAULT;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "evaluacion")
@JsonInclude(NON_DEFAULT)
public class Evaluacion {
    @Id
    @Column(name = "id_evaluacion", unique = true, updatable = false)
    private Long id_evaluacion;
    @Column(name = "nombre_evaluacion")
    private String nombre_evaluacion;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "fecha_inicio")
    private Date fecha_inicio;
    @Column(name = "fecha_termino")
    private Date fecha_termino;
    @Column(name = "id_coordinador")
    private Long id_coordinador;  
    @Column(name = "id_heuristica")
    private Integer id_heuristica; 
    @Column(name = "evaluacion_identificador")
    private String evaluacion_identificador;
}
