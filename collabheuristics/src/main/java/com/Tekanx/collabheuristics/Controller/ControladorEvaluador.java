package com.Tekanx.collabheuristics.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.Tekanx.collabheuristics.models.Evaluador;
import com.Tekanx.collabheuristics.services.ServicioEvaluador;

public class ControladorEvaluador {

    @Autowired
    private ServicioEvaluador servicioEvaluador;

    /* !- GET Mappings -! */

    @GetMapping("/evaluadores")
    public ResponseEntity <List<Evaluador>> getAllEvaluadores(){
        return ResponseEntity.ok(servicioEvaluador.getAllEvaluadores());
    }

    @GetMapping("/evaluadores/{id_evaluador}")
    public ResponseEntity<Evaluador> getEvaluador(@PathVariable("id_evaluador") Integer id_evaluador){
        return ResponseEntity.ok(servicioEvaluador.getEvaluador(id_evaluador));
    }

    /* !- POST Mappings -! */

    @PostMapping("/evaluadores")
        public ResponseEntity<Evaluador> createEvaluador(@RequestBody Evaluador evaluador){
            return ResponseEntity.ok(servicioEvaluador.addEvaluador(evaluador));
        }
    


    /* !- UPDATE Mappings -! */

    @PatchMapping("evaluadores/{id_evaluador}")
    public ResponseEntity<Evaluador> updateEvaluador(@RequestBody Evaluador evaluador, @PathVariable("id_evaluador") Integer id_evaluador){
        Evaluador evalObj = servicioEvaluador.getEvaluador(id_evaluador);
        if(evalObj != null){
            evalObj.setNombre(evaluador.getNombre());
            evalObj.setApellido(evaluador.getApellido());
            evalObj.setCorreo(evaluador.getCorreo());
            evalObj.setNumero(evaluador.getNumero());
            evalObj.setGenero(evaluador.getGenero());
            evalObj.setContrasena(evaluador.getContrasena());
        }

        return ResponseEntity.ok(servicioEvaluador.updateEvaluador(evaluador));
    }


    /* !- DELETE Mappings -! */

    @DeleteMapping("evaluadores/{id_evaluador}")
    public ResponseEntity<String> deleteEvaluador(@PathVariable("id_evaluador") Integer id_evaluador){
        Evaluador evalObj = servicioEvaluador.getEvaluador(id_evaluador);
        String deleteMsg = null;
        if(evalObj != null){
            deleteMsg = servicioEvaluador.deleteEvaluador(evalObj);
        }

        return ResponseEntity.ok(deleteMsg);
    }
}
