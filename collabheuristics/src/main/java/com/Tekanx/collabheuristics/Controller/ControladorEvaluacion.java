package com.Tekanx.collabheuristics.Controller;

import com.Tekanx.collabheuristics.models.Evaluacion;
import com.Tekanx.collabheuristics.models.Evaluador;
import com.Tekanx.collabheuristics.repository.RepositorioEvaluacion;
import com.Tekanx.collabheuristics.repository.RepositorioEvaluador;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/evaluaciones")
public class ControladorEvaluacion {

    private static final Logger logger = LoggerFactory.getLogger(ControladorEvaluacion.class);
    private final RepositorioEvaluacion repositorioEvaluacion;
    private final RepositorioEvaluador repositorioEvaluador;

    public ControladorEvaluacion(RepositorioEvaluacion repositorioEvaluacion,
                                RepositorioEvaluador repositorioEvaluador) {
        this.repositorioEvaluacion = repositorioEvaluacion;
        this.repositorioEvaluador = repositorioEvaluador;
    }

    @GetMapping("/evaluador")
    public ResponseEntity<?> getEvaluacionesEvaluador() {
        try {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            String username = auth.getName();
            
            logger.debug("Buscando evaluaciones para el usuario: {}", username);
            
            Optional<Evaluador> evaluadorOpt = repositorioEvaluador.findByNombreUsuario(username);
            if (!evaluadorOpt.isPresent()) {
                logger.error("Evaluador no encontrado para el usuario: {}", username);
                return ResponseEntity.badRequest().body("Evaluador no encontrado");
            }
            
            List<Evaluacion> evaluaciones = repositorioEvaluacion.findByEvaluadorId(evaluadorOpt.get().getId_evaluador());
            logger.debug("Se encontraron {} evaluaciones", evaluaciones.size());
            
            return ResponseEntity.ok(evaluaciones);
        } catch (Exception e) {
            logger.error("Error al obtener evaluaciones: ", e);
            return ResponseEntity.internalServerError().body("Error al obtener las evaluaciones: " + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEvaluacion(@PathVariable Long id) {
        try {
            return repositorioEvaluacion.findById(id)
                    .map(ResponseEntity::ok)
                    .orElseGet(() -> {
                        logger.warn("Evaluación no encontrada con ID: {}", id);
                        return ResponseEntity.notFound().build();
                    });
        } catch (Exception e) {
            logger.error("Error al obtener la evaluación con ID {}: ", id, e);
            return ResponseEntity.internalServerError().body("Error al obtener la evaluación: " + e.getMessage());
        }
    }
    @GetMapping("/{id}/evaluadores")
    public ResponseEntity<?> getEvaluadoresByEvaluacion(@PathVariable Long id){
        try{
            return ResponseEntity.ok(repositorioEvaluacion.findEvaluadoresByEvaluacionId(id));
        } catch (Exception e){
            logger.error("Error al obtener los evaluadores de la evaluación con ID {}: ", id, e);
            return ResponseEntity.internalServerError().body("Error al obtener los evaluadores de la evaluación: " + e.getMessage());
        }
    }
} 