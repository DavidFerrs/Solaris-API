package com.api.solaris.repository;


import com.api.solaris.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, UUID>{

	Optional<Cliente> findByCpfCnpj(long cpfCnpj);

	Optional<Cliente> findByNome(String nome);

	Optional<Object> findById(Long id);
}
