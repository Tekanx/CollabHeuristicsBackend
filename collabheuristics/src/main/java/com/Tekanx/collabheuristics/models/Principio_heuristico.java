package com.Tekanx.collabheuristics.models;
/**
 * @author Tekanx
 * @version 0.2
 * @since 24/04/2025
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
@Table(name = "principio_heuristico")
@JsonInclude(NON_DEFAULT)

public class Principio_heuristico {
    @Id
    @Column(name = "id_principioheuristico", unique = true, updatable = false)
    private Integer id_principioheuristico;
    @Column(name = "numero_principio")
    private Integer numero_principio;
    @Column(name = "nombre_principio")
    private String nombre_principio;
    @Column(name = "descripcion_principio")
    private String descripcion_principio;
    @Column(name = "id_heuristica")
    private Integer id_heuristica;
}
