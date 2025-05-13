package com.Tekanx.collabheuristics.models;
/**
 * @author Tekanx
 * @version 0.2
 * @since 1/05/2025
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
@Table(name = "coordinador")
@JsonInclude(NON_DEFAULT)
public class Coordinador {
    @Id
    @Column(name = "id_coordinador", unique = true, updatable = false)
    private Integer id_coordinador;
    @Column(name = "nombre_usuario", unique = true)
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
