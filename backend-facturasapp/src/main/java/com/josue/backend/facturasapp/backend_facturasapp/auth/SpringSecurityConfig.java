package com.josue.backend.facturasapp.backend_facturasapp.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, AuthenticationManager authManager) throws Exception{
        JwtAuthenticationFilter jwtAuthenticationFilter = new JwtAuthenticationFilter(authManager);
        jwtAuthenticationFilter.setFilterProcessesUrl("/login");
        return http
        .csrf(csrf -> csrf.disable())
        .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .authorizeHttpRequests( auth -> auth
        .requestMatchers(HttpMethod.POST,"/login").permitAll()
        .requestMatchers(HttpMethod.POST, "/api/auth/register").permitAll() // <-- AGREGA ESTA LÍNEA
        .requestMatchers(HttpMethod.GET, "/usuarios").permitAll()
        .anyRequest().authenticated()
        )
        .addFilter(jwtAuthenticationFilter)
        .addFilter(new JwtValidationFilter(authManager))
        .build();
    }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

}
