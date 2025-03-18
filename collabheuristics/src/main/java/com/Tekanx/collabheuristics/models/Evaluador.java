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
 * @version 0.1
 * @since 18/03/2025
 */

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_DEFAULT;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "evaluador")
@JsonInclude(NON_DEFAULT)
public class Evaluador {
    @Id
    @Column(name = "id_coordinador", unique = true, updatable = false)
    private Long id_coordinador;
    @Column(name = "nombre_usuario")
    private String nombre_usuario;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "numero")
    private Integer numero;
    @Column(name = "correo")
    private String correo;
    @Column(name = "genero")
    private Byte genero;
    @Column(name = "url_avatar")
    private String url_avatar;
    @Column(name = "contrasena")
    private String contrasena;
}
