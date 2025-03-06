package com.Tekanx.collabheuristics.models;
/**
 * @author Tekanx
 * @version 0.1
 * @since 06/03/2025
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
import org.hibernate.annotations.UuidGenerator;

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
    @UuidGenerator
    @Column(name = "id_coordinador", unique = true, updatable = false)
    private String id_coordinador;
    private String nombre_usuario;
    private String nombre_real;
    private String apellido_coordinador;
    private Integer contacto_numero;
    private String contacto_correo;
    private Byte genero;
    private String url_avatar;
    private String contrasena;
}
