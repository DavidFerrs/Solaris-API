package com.api.solaris.repository;

import com.api.solaris.model.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface AdministradorRepository extends UsuarioRepository<Administrador, Long> {

}
