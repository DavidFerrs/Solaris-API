package com.api.solaris.service;

import com.api.solaris.data.DetalheUsuarioData;
import com.api.solaris.dto.Usuario;
import com.api.solaris.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DetalheUsuarioServiceImpl implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    public DetalheUsuarioServiceImpl(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> usuario = this.usuarioRepository.findByLogin(username);

        if (username.isEmpty()){
            throw new UsernameNotFoundException("Usuario não encontrado");
        }
        return new DetalheUsuarioData(usuario);
    }
}
