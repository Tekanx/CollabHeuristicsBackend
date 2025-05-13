package com.Tekanx.collabheuristics.models;
/**
 * @author Tekanx
 * @version 0.2
 * @since 13/05/2025
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
@Table(name = "heuristica")
@JsonInclude(NON_DEFAULT)

public class Heuristica {
    @Id
    @Column(name = "id_heuristica", unique = true, updatable = false)
    private Integer id_heuristica;
    @Column(name = "nombre_heuristica")
    private String nombre_heuristica;
    @Column(name = "descripcion_heuristica")
    private String descripcion_heuristica;
    @Column(name = "autor")
    private String autor;

}
