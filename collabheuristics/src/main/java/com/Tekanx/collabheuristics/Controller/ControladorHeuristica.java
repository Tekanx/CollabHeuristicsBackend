package com.Tekanx.collabheuristics.Controller;

/**
 * @author Tekanx
 * @version 0.2
 * @since 08/05/2025
 */ 

 import java.sql.Timestamp;
 import java.util.List;
 
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.http.HttpStatus;
 import org.springframework.http.ResponseEntity;
 import org.springframework.web.bind.annotation.GetMapping;
 import org.springframework.web.bind.annotation.PathVariable;
 import org.springframework.web.bind.annotation.RequestMapping;
 import org.springframework.web.bind.annotation.RestController;
 import org.slf4j.Logger;
 import org.slf4j.LoggerFactory;

import com.Tekanx.collabheuristics.models.Heuristica;
import com.Tekanx.collabheuristics.models.Principio_heuristico;
import com.Tekanx.collabheuristics.services.heuristica.ServicioHeuristica;


@RestController
@RequestMapping("/api/heuristicas")
public class ControladorHeuristica {
    private static final Logger logger = LoggerFactory.getLogger(ControladorProblema.class);

    @Autowired
    private ServicioHeuristica servicioHeuristica;
    
    public ControladorHeuristica(ServicioHeuristica servicioHeuristica){
        this.servicioHeuristica = servicioHeuristica;
    }

    @GetMapping({"", "/"})
    public ResponseEntity<?> getAllHeuristicas(){
        try{
            List<Heuristica> heuristicas = servicioHeuristica.getAllHeuristicas();
            return ResponseEntity.ok(heuristicas);
        } catch (Exception e){
            logger.error("Error al obtener todas las heurísticas: ", e);
            return ResponseEntity.internalServerError().body("Error al obtener todas las heurísticas: " + e.getMessage());
        }
    }

    @GetMapping("/{id_heuristica}")
    public ResponseEntity<?> getHeuristica(@PathVariable Integer id_heuristica){
        try{
            Heuristica heuristica = servicioHeuristica.getHeuristica(id_heuristica);
            return ResponseEntity.ok(heuristica);
        } catch (Exception e){
            logger.error("Error al obtener la heurística con ID: {}", id_heuristica, e);
            return ResponseEntity.internalServerError().body("Error al obtener la heurística: " + e.getMessage());
        }
    }

    @GetMapping("/{id_heuristica}/principios")
    public ResponseEntity<?> getPrincipiosHeuristicosOfHeuristica(@PathVariable Integer id_heuristica){
        try{
            List<Principio_heuristico> principios = servicioHeuristica.getPrincipiosHeuristicosOfHeuristica(id_heuristica);
            return ResponseEntity.ok(principios);
        } catch (Exception e){
            logger.error("Error al obtener los principios de la heurística con ID: {}", id_heuristica, e);
            return ResponseEntity.internalServerError().body("Error al obtener los principios de la heurística: " + e.getMessage());
        }
    }
    
    
}
