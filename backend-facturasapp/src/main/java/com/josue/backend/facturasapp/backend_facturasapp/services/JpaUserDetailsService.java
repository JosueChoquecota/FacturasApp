package com.josue.backend.facturasapp.backend_facturasapp.services;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.josue.backend.facturasapp.backend_facturasapp.models.entities.Usuarios;
import com.josue.backend.facturasapp.backend_facturasapp.repositories.UsuarioReporitory;


@Service
public class JpaUserDetailsService implements UserDetailsService {
    @Autowired
    private UsuarioReporitory usuarioReporitory;
    
    @Override
    public UserDetails loadUserByUsername(String correo) throws UsernameNotFoundException {
        Usuarios usuario = usuarioReporitory.findByCorreo(correo)
            .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado: " + correo));
        return new User(
            usuario.getCorreo(),
            usuario.getContraseña(), 
            Collections.singletonList(new SimpleGrantedAuthority("ROLE_ADMIN"))
        );
    }
}
