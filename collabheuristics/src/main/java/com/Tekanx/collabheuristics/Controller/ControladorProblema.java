package com.Tekanx.collabheuristics.Controller;

/**
 * @author Tekanx
 * @version 0.2
 * @since 07/05/2025
 */ 

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.Tekanx.collabheuristics.models.Historico_problema;
import com.Tekanx.collabheuristics.models.Problema;
import com.Tekanx.collabheuristics.repository.RepositorioHistoricoProblema;
import com.Tekanx.collabheuristics.repository.RepositorioProblema;

@RestController
@RequestMapping("/api/problemas")
public class ControladorProblema {

    private static final Logger logger = LoggerFactory.getLogger(ControladorProblema.class);
    @Autowired
    private final RepositorioProblema repositorioProblema;
    @Autowired
    private final RepositorioHistoricoProblema repositorioHistoricoProblema;

    public ControladorProblema(RepositorioProblema repositorioProblema, RepositorioHistoricoProblema repositorioHistoricoProblema){
        this.repositorioProblema = repositorioProblema;
        this.repositorioHistoricoProblema = repositorioHistoricoProblema;
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllProblemas(){
        try{
            List<Problema> problemas = repositorioProblema.findAll();
            return ResponseEntity.ok(problemas);
        } catch (Exception e){
            logger.error("Error al obtener todos los problemas: ", e);
            return ResponseEntity.internalServerError().body("Error al obtener todos los problemas: " + e.getMessage());
        }
    }

    @GetMapping("/{id_problema}")
    public ResponseEntity<?> getProblema(@PathVariable Long id_problema){
        try{
            Problema problema = repositorioProblema.findById(id_problema).orElse(null);
            return ResponseEntity.ok(problema);
        } catch (Exception e){
            logger.error("Error al obtener el problema con ID: {}", id_problema, e);
            return ResponseEntity.internalServerError().body("Error al obtener el problema: " + e.getMessage());
        }
    }

    @GetMapping("/evaluador/{id_evaluador}")
    public ResponseEntity<?> getProblemasofEvaluador(@PathVariable Long id_evaluador){
        try{
            List<Problema> problemas = repositorioProblema.findProblemasByEvaluadorId(id_evaluador);
            return ResponseEntity.ok(problemas);
        } catch (Exception e){
            logger.error("Error al obtener los problemas del evaluador con ID: {}", id_evaluador, e);
            return ResponseEntity.internalServerError().body("Error al obtener los problemas del evaluador: " + e.getMessage());
        }
    }
    
    // Obtener problemas de una evaluación específica
    @GetMapping("/evaluacion/{idEvaluacion}")
    public ResponseEntity<?> getProblemasByEvaluacion(@PathVariable Long idEvaluacion) {
        try {
            List<Problema> problemas = repositorioProblema.findProblemasByFkEvaluacion(idEvaluacion);
            return ResponseEntity.ok(problemas);
        } catch (Exception e) {
            logger.error("Error al obtener problemas de la evaluación {}: ", idEvaluacion, e);
            return ResponseEntity.internalServerError().body("Error al obtener problemas: " + e.getMessage());
        }
    }

    @PostMapping("/{idEvaluacion}/problema")
    public ResponseEntity<?> createProblema(@PathVariable Long idEvaluacion, @RequestBody Problema problema){
        try{
            problema.setFk_evaluacion(idEvaluacion);
            Problema problemaGuardado = repositorioProblema.save(problema);
            // Guardar en histórico
            Historico_problema historico = new Historico_problema();
            historico.setFk_evaluador(problema.getFk_evaluador());
            historico.setFk_problema(problemaGuardado.getId_problema());
            historico.setFecha_cambio(new Timestamp(System.currentTimeMillis()));
            historico.setDetalle_cambio("Creación de problema: " + problemaGuardado.getNombre_problema() + " - " + problemaGuardado.getDescripcion_problema() + " - N° de heurística incumplida: " + problemaGuardado.getFk_heuristica_incumplida() + " - Ejemplo de ocurrencia: " + problemaGuardado.getEjemplo_ocurrencia());
            repositorioHistoricoProblema.save(historico);
            return ResponseEntity.status(HttpStatus.CREATED).body(problemaGuardado);
        } catch (Exception e){
            logger.error("Error al crear el problema: ", e);
            return ResponseEntity.internalServerError().body("Error al crear el problema: " + e.getMessage());
        }
    }

    @PostMapping("/consolidar")
    public ResponseEntity<?> consolidarProblemas(@RequestBody List<Problema> problemasAConsolidar) {
        try{
            if(problemasAConsolidar.isEmpty()){
                return ResponseEntity.badRequest().body("No hay problemas para consolidar");
            }
            Problema problemaBase = problemasAConsolidar.get(0);
            problemasAConsolidar.remove(0);
            // Guardar en histórico
            for(Problema problema : problemasAConsolidar){
                Historico_problema historico = new Historico_problema();
                historico.setFk_evaluador(problema.getFk_evaluador());
                historico.setFk_problema(problema.getId_problema());
                historico.setFecha_cambio(new Timestamp(System.currentTimeMillis()));
                historico.setDetalle_cambio("Consolidación de problema con: " + problema.getNombre_problema() + " - " + problema.getDescripcion_problema() + " - " + problema.getFk_heuristica_incumplida() + " - " + problema.getEjemplo_ocurrencia());
                repositorioHistoricoProblema.save(historico);
            }
            // Guardar el problema consolidado
            repositorioProblema.save(problemaBase);
            // Eliminar los problemas originales
            for(Problema problema : problemasAConsolidar){
                repositorioProblema.deleteById(problema.getId_problema());
            }
            return ResponseEntity.ok(problemaBase);
        } catch (Exception e){
            logger.error("Error al consolidar problemas: ", e);
            return ResponseEntity.internalServerError().body("Error al consolidar problemas: " + e.getMessage());
        }
    }

    @PutMapping("/{id_problema}")
    public ResponseEntity<?> updateProblema(@PathVariable Long id_problema, @RequestBody Problema problema){
        try{
            Problema problemaExistente = repositorioProblema.findById(id_problema).orElse(null);
            if(problemaExistente == null){
                new RuntimeException("Problema no encontrado");
                return ResponseEntity.notFound().build();
            }
            // Guardar en histórico antes de actualizar
            Historico_problema historico = new Historico_problema();
            historico.setFk_evaluador(problemaExistente.getFk_evaluador());
            historico.setFk_problema(id_problema);
            historico.setFecha_cambio(new Timestamp(System.currentTimeMillis()));
            historico.setDetalle_cambio("Actualización de problema: " + problemaExistente.getNombre_problema() + " - " + problemaExistente.getDescripcion_problema() + " - N° de heurística incumplida: " + problemaExistente.getFk_heuristica_incumplida() + " - Ejemplo de ocurrencia: " + problemaExistente.getEjemplo_ocurrencia());
            repositorioHistoricoProblema.save(historico);

            problemaExistente.setNumero_problema(problema.getNumero_problema());
            problemaExistente.setNombre_problema(problema.getNombre_problema());
            problemaExistente.setDescripcion_problema(problema.getDescripcion_problema());
            problemaExistente.setFk_heuristica_incumplida(problema.getFk_heuristica_incumplida());
            problemaExistente.setEjemplo_ocurrencia(problema.getEjemplo_ocurrencia());
            problemaExistente.setUrl_imagen(problema.getUrl_imagen());
            Problema problemaActualizado = repositorioProblema.save(problemaExistente);
            return ResponseEntity.ok(problemaActualizado);
        } catch (Exception e){
            logger.error("Error al actualizar el problema con ID: {}", id_problema, e);
            return ResponseEntity.internalServerError().body("Error al actualizar el problema: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id_problema}")
    public ResponseEntity<?> deleteProblema(@PathVariable Long id_problema){
        try{
            repositorioProblema.deleteById(id_problema);
        } catch (Exception e){
            logger.error("Error al eliminar el problema con ID: {}", id_problema, e);
            return ResponseEntity.internalServerError().body("Error al eliminar el problema: " + e.getMessage());
        }
        return ResponseEntity.ok("Problema eliminado con ID: " + id_problema);
    }

    @GetMapping("{id_evaluacion}/principios/problemas")
    public ResponseEntity<?> getCantidadPrincipiosPorProblema(@PathVariable Long id_evaluacion){
        try{
            List<Object[]> principios = repositorioProblema.countProblemasPorPrincipio(id_evaluacion);
            return ResponseEntity.ok(principios);
        } catch (Exception e){
            logger.error("Error al obtener la cantidad de principios: ", e);
            return ResponseEntity.internalServerError().body("Error al obtener la cantidad de principios: " + e.getMessage());
        }
    }
}
    

