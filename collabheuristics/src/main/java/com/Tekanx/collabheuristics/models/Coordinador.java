package com.Tekanx.collabheuristics.models;
/**
 * @author Tekanx
 * @version 0.1
 * @since 07/03/2025
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
    private Long id_coordinador;
    @Column(name = "nombre_usuario")
    private String nombre_usuario;
    @Column(name = "nombre_real")
    private String nombre_real;
    @Column(name = "apellido_coordinador")
    private String apellido_coordinador;
    @Column(name = "contacto_numero")
    private String contacto_numero;
    @Column(name = "contacto_correo")
    private String contacto_correo;
    @Column(name = "genero")
    private Byte genero;
    @Column(name = "url_avatar")
    private String url_avatar;
    @Column(name = "contrasena")
    private String contrasena;
}
