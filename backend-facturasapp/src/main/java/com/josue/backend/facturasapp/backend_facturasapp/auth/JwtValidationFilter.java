package com.josue.backend.facturasapp.backend_facturasapp.auth;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import static com.josue.backend.facturasapp.backend_facturasapp.auth.TokenConfig.HEADER_AUTHORIZATION;
import static com.josue.backend.facturasapp.backend_facturasapp.auth.TokenConfig.PREFIX_TOKEN;
import static com.josue.backend.facturasapp.backend_facturasapp.auth.TokenConfig.SECRET_KEY;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtValidationFilter extends BasicAuthenticationFilter {

    public JwtValidationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws java.io.IOException, ServletException {
        String header = request.getHeader(HEADER_AUTHORIZATION);

        if (header == null || !header.startsWith(PREFIX_TOKEN)) {
            chain.doFilter(request, response);
            return;
        }
        String token = header.replace(PREFIX_TOKEN, "");

        try {
            Claims claims = Jwts.parser()
            .setSigningKey(SECRET_KEY)
            .parseClaimsJws(token)
            .getBody();

            Date expiration = claims.getExpiration();


            if (expiration.before(new Date())) {
                throw new RuntimeException("Token expirado");
            }

            String username = claims.getSubject();

            List<GrantedAuthority> authorities = List.of(new SimpleGrantedAuthority("ROLE_ADMIN"));
            UsernamePasswordAuthenticationToken auth = 
            new UsernamePasswordAuthenticationToken(username,null, authorities);
            
            SecurityContextHolder.getContext().setAuthentication(auth);
            chain.doFilter(request, response);

            } catch (Exception e) {
                response.setStatus(HttpServletResponse.SC_FORBIDDEN);
                response.setContentType("application/json");
                response.getWriter().write(new ObjectMapper().writeValueAsString(Map.of("error", "Token JWT no válido")));
            }

    }
}
