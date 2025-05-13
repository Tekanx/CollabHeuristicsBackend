package com.Tekanx.collabheuristics.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Tekanx.collabheuristics.api.JwtTokenUtil;
import com.Tekanx.collabheuristics.models.Coordinador;
import com.Tekanx.collabheuristics.models.LoginResponse;

//@RestController
//@RequestMapping("/api/auth")
public class AuthController {
    
    @Autowired
    private AuthenticationManager authenticationManager;
    
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Coordinador loginRequest) {
        try {
            Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                    loginRequest.getNombre_usuario(),
                    loginRequest.getContrasena()
                )
            );
            
            UserDetails userDetails = (UserDetails) auth.getPrincipal();
            String token = jwtTokenUtil.generateToken(userDetails);
            
            // Obtener el rol del usuario
            String role = userDetails.getAuthorities().stream()
                .findFirst()
                .map(authority -> authority.getAuthority().replace("ROLE_", ""))
                .orElse("");
            
            return ResponseEntity.ok(new LoginResponse(token, role));
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales inválidas");
        }
    }
}
