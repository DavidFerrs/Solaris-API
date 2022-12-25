package com.api.solaris.repository;

import com.api.solaris.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.Optional;

@NoRepositoryBean
public interface UsuarioRepository<E extends Usuario, ID extends Serializable> extends JpaRepository<E, ID> {
    Optional<E> findByLogin(String login);
}
