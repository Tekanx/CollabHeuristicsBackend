package com.Tekanx.collabheuristics.models;

import jakarta.persistence.Column;
import jakarta.persistence.Id;

/**
 * @author Tekanx
 * @version 0.1
 * @since 07/05/2025
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
@Table(name = "puntuacion_problema")
@JsonInclude(NON_DEFAULT)
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
