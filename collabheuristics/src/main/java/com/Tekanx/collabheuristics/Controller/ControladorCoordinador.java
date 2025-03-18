package com.Tekanx.collabheuristics.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

/**
 * @author Tekanx
 * @version 0.1
 * @since 13/03/2025
 */


import org.springframework.web.bind.annotation.RestController;

import com.Tekanx.collabheuristics.models.Coordinador;
import com.Tekanx.collabheuristics.models.Evaluacion;
import com.Tekanx.collabheuristics.services.ServicioCoordinador;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin(maxAge = 3360)
@RestController
public class ControladorCoordinador {
    @Autowired
    private ServicioCoordinador servicioCoordinador;

    /* !- GET Mappings -! */

    /**
     * 
     * @return
     */
    @GetMapping("/coordinadores")
    public ResponseEntity <List<Coordinador>> getAllCoordinadores() {
        return ResponseEntity.ok(servicioCoordinador.getAllCoordinadores());
    }

    /**
     * 
     * @param id_coordinador
     * @return
     */
    @GetMapping("/coordinadores/{id_coordinador}/evaluaciones")
    public ResponseEntity<List<Evaluacion>> getAllEvaluacionesofCoordinador(@PathVariable("id_coordinador") Integer id_coordinador){
        return ResponseEntity.ok(servicioCoordinador.getEvaluacionesOfCoordinador(id_coordinador));
    }

    /**
     * 
     * @param id_coordinador
     * @return
     */
    @GetMapping("/coordinadores/{id_coordinador}")
    public ResponseEntity<Coordinador> getCoordinador(@PathVariable("id_coordinador") Integer id_coordinador) {
        return ResponseEntity.ok(servicioCoordinador.getCoordinador(id_coordinador));
    }


    /* !- POST Mappings -! */

    /**
     * 
     * @param coordinador
     * @return
     */
    @PostMapping("/coordinadores")
    public ResponseEntity<Coordinador> createCoordinador(@RequestBody Coordinador coordinador) {
        return ResponseEntity.ok(servicioCoordinador.addCoordinador(coordinador));
    }

    /* !- UPDATE Mappings -! */

    /**
     * 
     * @param coordinador
     * @param id_coordinador
     * @return
     */
    @PatchMapping("/coordinadores/{id_coordinador}")
    public ResponseEntity<Coordinador> updateCoordinador(@RequestBody Coordinador coordinador, @PathVariable("id_coordinador") Integer id_coordinador){
        Coordinador coordObj = servicioCoordinador.getCoordinador(id_coordinador);
        if (coordObj != null) {
            coordObj.setNombre_real(coordinador.getNombre_real());
            coordObj.setApellido_real(coordinador.getApellido_real());
            coordObj.setCorreo(coordinador.getCorreo());
            coordObj.setNumero(coordinador.getNumero());
            coordObj.setGenero(coordinador.getGenero());
            coordObj.setContrasena(coordinador.getContrasena());
        }
        return ResponseEntity.ok(servicioCoordinador.updateCoordinador(coordinador));
    }


    /* !- DELETE Mappings -! */

    /**
     * 
     * @param id_coordinador
     * @return
     */
    @DeleteMapping("/coordinadores/{id_coordinador}")
    public ResponseEntity<String> deleteCoordinador(@PathVariable("id_coordinador") Integer id_coordinador){
        Coordinador coordObj = servicioCoordinador.getCoordinador(id_coordinador);
        String deleteMsg = null;
        if (coordObj != null) {
            deleteMsg = servicioCoordinador.deleteCoordinador(coordObj);
        }
        
        return ResponseEntity.ok(deleteMsg);
    }
}
