package com.Tekanx.collabheuristics.security;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.Tekanx.collabheuristics.models.Coordinador;
import com.Tekanx.collabheuristics.models.Evaluador;
import com.Tekanx.collabheuristics.repository.RepositorioCoordinador;
import com.Tekanx.collabheuristics.repository.RepositorioEvaluador;

import java.util.Collections;
import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final RepositorioCoordinador repositorioCoordinador;
    private final RepositorioEvaluador repositorioEvaluador;

    public CustomUserDetailsService(RepositorioCoordinador repositorioCoordinador, 
                                  RepositorioEvaluador repositorioEvaluador) {
        this.repositorioCoordinador = repositorioCoordinador;
        this.repositorioEvaluador = repositorioEvaluador;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Buscar primero en coordinadores
        Optional<Coordinador> coordinador = repositorioCoordinador.findByNombreUsuario(username);
        if (coordinador.isPresent()) {
            return new User(
                coordinador.get().getNombre_usuario(),
                coordinador.get().getContrasena(),
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_COORDINADOR"))
            );
        }

        // Si no es coordinador, buscar en evaluadores
        Optional<Evaluador> evaluador = repositorioEvaluador.findByNombreUsuario(username);
        if (evaluador.isPresent()) {
            return new User(
                evaluador.get().getNombre_usuario(),
                evaluador.get().getContrasena(),
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_EVALUADOR"))
            );
        }

        throw new UsernameNotFoundException("Usuario no encontrado: " + username);
    }
} 