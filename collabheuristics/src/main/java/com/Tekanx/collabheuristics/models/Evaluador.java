package com.Tekanx.collabheuristics.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Tekanx
 * @version 0.2
 * @since 1/05/2025
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
    @Column(name = "id_evaluador", unique = true, updatable = false)
    private Long id_evaluador;

    @NotBlank
    @Column(name = "nombre_usuario", unique = true, length = 50)
    private String nombre_usuario;

    @NotBlank
    @Column(name = "nombre", length = 100)
    private String nombre;

    @Column(name = "apellido", length = 100)
    private String apellido;

    @Column(name = "numero")
    private Integer numero;

    @Email
    @Column(name = "correo", length = 100)
    private String correo;

    @Column(name = "genero")
    private Byte genero;

    @Column(name = "url_avatar", length = 500)
    private String url_avatar;

    @Column(name = "contrasena", length = 100)
    private String contrasena;
}
