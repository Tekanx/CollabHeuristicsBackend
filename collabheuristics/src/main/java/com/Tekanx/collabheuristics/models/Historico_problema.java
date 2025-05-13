package com.Tekanx.collabheuristics.models;

import java.sql.Date;
import java.sql.Timestamp;

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
@Table(name = "historico_problema")
@JsonInclude(NON_DEFAULT)

public class Historico_problema {
   @Id
   @Column(name = "id_historico", unique = true, updatable = false)
   private Long id_historico;
   @Column(name = "id_evaluador")
   private Long fk_evaluador;
   @Column(name = "id_coordinador")
   private Long fk_coordinador;
   @Column(name = "id_problema")
   private Long fk_problema;
   @Column(name = "fecha_cambio")
   private Timestamp fecha_cambio;
   @Column(name = "detalle")
   private String detalle_cambio; 
}
