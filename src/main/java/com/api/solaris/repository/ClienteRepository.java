package com.api.solaris.repository;

import com.api.solaris.model.Cliente;

import java.util.Optional;

public interface ClienteRepository extends UsuarioRepository<Cliente, Long>{

	Optional<Cliente> findByCpf(long CPF);

	Optional<Cliente> findByNome(String nome);

	Optional<Cliente> findByLogin(String login);
}
