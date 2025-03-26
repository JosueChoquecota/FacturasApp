package com.josue.backend.facturasapp.backend_facturasapp.auth;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import java.util.Map;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import static com.josue.backend.facturasapp.backend_facturasapp.auth.TokenConfig.HEADER_AUTHORIZATION;
import static com.josue.backend.facturasapp.backend_facturasapp.auth.TokenConfig.PREFIX_TOKEN;
import static com.josue.backend.facturasapp.backend_facturasapp.auth.TokenConfig.SECRET_KEY;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtAuthenticationFilter extends  UsernamePasswordAuthenticationFilter{

    private final AuthenticationManager authenticationManager;

    public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            Map<String, String> credentials = new ObjectMapper().readValue(request.getInputStream(), Map.class);
            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(credentials.get("correo"), credentials.get("password"))
            );
        } catch (IOException e) {
            throw new RuntimeException("Error al obtener las credenciales del request", e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        String username = authResult.getName();
        Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));
        String token = Jwts.builder()
        .setSubject(username)
        .setIssuedAt(new Date())
        .setExpiration(new Date(System.currentTimeMillis() + 3600000)) // 1 hora
        .signWith(key, SignatureAlgorithm.HS256)
        .compact();

        response.addHeader(HEADER_AUTHORIZATION, PREFIX_TOKEN + token);
        response.setContentType("application/json");
        response.getWriter().write("{\"token\": \"" + PREFIX_TOKEN + token + "\"}");
    }

}
