package com.Tekanx.collabheuristics.models;
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

/**
 * @author Tekanx
 * @version 0.1
 * @since 18/03/2025
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
   @Column(name = "fecha_cambio")
   private Date fecha_cambio;
   @Column(name = "detalle_cambio")
   private Date detalle_cambio; 
}
