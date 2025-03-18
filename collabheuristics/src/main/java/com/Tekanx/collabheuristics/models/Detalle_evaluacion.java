package com.Tekanx.collabheuristics.models;
/**
 * @author Tekanx
 * @version 0.1
 * @since 18/03/2025
 */

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
@Table(name = "detalle_evaluacion")
@JsonInclude(NON_DEFAULT)
public class Detalle_evaluacion {
   @Id
   @Column(name = "id_detalle", unique = true, updatable = false)
   private Long id_detalle;
   @Column(name = "id_evaluador")
   private Long fk_evaluador;
   @Column(name = "id_evaluacion")
   private Long fk_evaluacion;
   @Column(name = "paso_actual")
   private Integer paso_actual;
}
