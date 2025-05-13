package com.Tekanx.collabheuristics.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Tekanx
 * @version 0.2
 * @since 07/05/2025
 */
import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_DEFAULT;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "problema")
@JsonInclude(NON_DEFAULT)

public class Problema {
    @Id
    @Column(name = "id_problema", unique = true, updatable = false)
    private Long id_problema;
    @Column(name = "numero_problema")
    private Integer numero_problema;
    @Column(name = "nombre_problema")
    private String nombre_problema;
    @Column(name = "descripcion")
    private String descripcion_problema;
    @Column(name = "ejemplo_ocurrencia")
    private String ejemplo_ocurrencia;
    @Column(name = "comentarios")
    private String comentarios;
    @Column(name = "url_imagen")
    private String url_imagen;
    @Column(name = "id_evaluacion")
    private Long fk_evaluacion;
    @Column(name = "id_evaluador")
    private Long fk_evaluador;
    @Column(name = "id_heuristicaincumplida")
    private Integer fk_heuristica_incumplida;
}
