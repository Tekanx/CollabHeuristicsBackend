package com.Tekanx.collabheuristics.repository;

/**
 * @author Tekanx
 * @version 0.1
 * @since 08/05/2025
 */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Tekanx.collabheuristics.models.Puntuacion_problema;

public interface RepositorioPuntuacion extends JpaRepository<Puntuacion_problema, Long>{
    @Query(nativeQuery = true, value = "SELECT * FROM puntuacion_problema WHERE id_problema = ?1")
    Puntuacion_problema findByFkProblema(Long idProblema);

    @Query(nativeQuery = true, value = "SELECT AVG(probabilidad), AVG(severidad), AVG(criticidad) FROM puntuacion_problema WHERE id_problema = ?1")
    Float promediosPuntuaciones(Long id_problema);

    @Query(nativeQuery = true, value = "SELECT AVG(probabilidad) FROM puntuacion_problema WHERE id_problema = ?1")
    Float promedioProbabilidad(Long idProblema);

    @Query(nativeQuery = true, value = "SELECT AVG(severidad) FROM puntuacion_problema WHERE id_problema = ?1")
    Float promedioSeveridad(Long idProblema);
        
    @Query(nativeQuery = true, value = "SELECT AVG(criticidad) FROM puntuacion_problema WHERE id_problema = ?1")
    Float promedioCriticidad(Long idProblema);

}
