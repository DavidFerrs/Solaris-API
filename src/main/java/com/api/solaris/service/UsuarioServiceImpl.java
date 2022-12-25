package com.api.solaris.service;

import com.api.solaris.data.DetalheUsuarioData;
import com.api.solaris.model.Administrador;
import com.api.solaris.model.Cliente;
import com.api.solaris.repository.AdministradorRepository;
import com.api.solaris.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UserDetailsService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private AdministradorRepository administradorRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Administrador> adm = this.administradorRepository.findByLogin(username);

        if (adm.isPresent())
            return new DetalheUsuarioData<>(adm);

        Optional<Cliente> cliente = this.clienteRepository.findByLogin(username);

        if (cliente.isPresent())
            return new DetalheUsuarioData<>(cliente);
        throw new UsernameNotFoundException("Usuario não encontrado");
    }
}
