package com.Tekanx.collabheuristics.Controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Tekanx.collabheuristics.api.JwtTokenUtil;
import com.Tekanx.collabheuristics.models.Coordinador;
import com.Tekanx.collabheuristics.models.Evaluador;
import com.Tekanx.collabheuristics.models.LoginResponse;
import com.Tekanx.collabheuristics.repository.RepositorioCoordinador;
import com.Tekanx.collabheuristics.repository.RepositorioEvaluador;

@RestController
@RequestMapping("/api/auth")
public class ControladorAuth {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;
    private final RepositorioCoordinador repositorioCoordinador;
    private final RepositorioEvaluador repositorioEvaluador;

    public ControladorAuth(AuthenticationManager authenticationManager, 
                         JwtTokenUtil jwtTokenUtil,
                         RepositorioCoordinador repositorioCoordinador,
                         RepositorioEvaluador repositorioEvaluador) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
        this.repositorioCoordinador = repositorioCoordinador;
        this.repositorioEvaluador = repositorioEvaluador;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> loginRequest) {
        try {
            String nombreUsuario = loginRequest.get("nombre_usuario");
            String contrasena = loginRequest.get("contrasena");
            // Intentar autenticar como coordinador
            Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(nombreUsuario, contrasena)   
            );

            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            String token = jwtTokenUtil.generateToken(userDetails);

            // Determinar el tipo de usuario
            String role = userDetails.getAuthorities().stream()
                .findFirst()
                .map(auth -> auth.getAuthority().replace("ROLE_", ""))
                .orElse("");

            return ResponseEntity.ok(new LoginResponse(token, role));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Credenciales inválidas");
        }
    }
} 